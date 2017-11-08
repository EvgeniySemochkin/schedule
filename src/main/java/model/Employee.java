package model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(Employee employee) {
        super(employee.getId());
        this.name = employee.getName();
        this.department = employee.getDepartment();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "Id='" + super.getId() +
                "', name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
