package service;

import model.Employee;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EmployeeRepository;
import repository.OrderRepository;
import util.exceptions.NotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void delete(int id){

        List<Order> orderList = orderRepository.findAllByEmployeeId(id);
        for (Order order : orderList) {
            order.setEmployeeId(null);
            orderRepository.saveAndFlush(order);
        }
        employeeRepository.delete(id);
    }

    @Override
    public Employee get(int id){
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }




}
