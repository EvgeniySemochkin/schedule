package service;

import model.Employee;
import util.exceptions.NotFoundException;

public interface EmployeeService {

    Employee save(Employee employee);
    void delete(int id) throws NotFoundException;
    Employee get(int id) throws NotFoundException;
}
