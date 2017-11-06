package model;


import java.time.LocalDateTime;

public class Order extends BaseEntity {

    private String name;
    private FurnitureType furnitureType;
    private LocalDateTime endTime;
    private Department department;


}
