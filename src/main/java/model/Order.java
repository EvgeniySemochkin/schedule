package model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "furnituretype", nullable = false)
    @Enumerated(EnumType.STRING)
    private FurnitureType furnitureType;

    @Column(name = "endtime", nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false)
    private Department department;

    @Column(name = "employee_id")
    private Integer employeeId;

    public Order() {
    }

    public Order(String name, FurnitureType furnitureType, LocalDateTime endTime) {
        this.name = name;
        this.furnitureType = furnitureType;
        this.endTime = endTime;
    }

    public Order(String name, FurnitureType furnitureType, LocalDateTime endTime, Department department) {
        this.name = name;
        this.furnitureType = furnitureType;
        this.endTime = endTime;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FurnitureType getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(FurnitureType furnitureType) {
        this.furnitureType = furnitureType;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Order{" + "Id='" + super.getId() +
                "', name='" + name + '\'' +
                ", furnitureType=" + furnitureType +
                ", endTime=" + endTime +
                ", department=" + department +
                ", employeeId=" + employeeId +
                '}';
    }
}
