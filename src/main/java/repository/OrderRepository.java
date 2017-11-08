package repository;

import model.Department;
import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

    List<Order> findAllByEmployeeId(int id);
    List<Order> findAllByDepartmentAndEmployeeId(Department department, Integer id);
    List<Order> findAllByEndTimeAfter(LocalDateTime localDateTime);
}
