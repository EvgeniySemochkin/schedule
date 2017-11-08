package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    void delete(int id);
    Employee get(int id);
    List<Employee> getAll();
}
