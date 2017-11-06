package repository;

import model.Employee;

public interface EmployeeRepository {

    Employee save(Employee employee);

    boolean delete(int id);

    Employee get(int id);
}

