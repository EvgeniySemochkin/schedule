package service;


import model.Department;
import model.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);
    Order get(int id);
    void delete(int id);
    List<Order> getAll();
    List<Order> getAllByEmployee(int id);
    List<Order> getAllByDepartment(Department department);
    List<Order> getAllUnfinished();
    public String getTimeLeft(int id);


}
