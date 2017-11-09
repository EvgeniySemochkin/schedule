package service;

import model.Department;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        if (order.getDepartment() == null){
            switch (order.getFurnitureType()){
                case SOFA:
                case BED:
                case ARMCHAIR:
                    order.setDepartment(Department.CUSHIONED_FURNITURE);
                    break;
                case WARDROBE:
                case BEDSIDE_TABLE:
                case SHELF:
                    order.setDepartment(Department.STORAGE);
                    break;
                case TABLE:
                case CHAIR:
                case ROCKING_CHAIR:
                    order.setDepartment(Department.OFFICE);
                    break;
            }
        }

        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order get(int id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void delete(int id) { orderRepository.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllByEmployee(int id) {
        return orderRepository.findAllByEmployeeId(id);
    }

    @Override
    public List<Order> getAllByDepartment(Department department) {
        return orderRepository.findAllByDepartmentAndEmployeeId(department, null);
    }

    @Override
    public List<Order> getAllUnfinished() {
        return orderRepository.findAllByEndTimeAfter(LocalDateTime.now());
    }

    @Override
    public String getTimeLeft(int id) {
        LocalDateTime endDateTime = orderRepository.findOne(id).getEndTime();
        LocalDateTime currentDateTime = LocalDateTime.now();
        long days = ChronoUnit.DAYS.between(currentDateTime, endDateTime);

        LocalTime currentTime = currentDateTime.toLocalTime();
        LocalTime endTime = endDateTime.toLocalTime();
        long hours = ChronoUnit.HOURS.between(currentTime, endTime);
        if (hours < 0) hours = 24 + hours;

        return "Time left " + days + " days and " + hours + " hours";
    }

}
