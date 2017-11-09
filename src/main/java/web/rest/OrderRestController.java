package web.rest;


import model.Department;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.OrderService;

import java.net.URI;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") int id) { return orderService.get(id);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        orderService.delete(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Order order) {
        orderService.save(order);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createWithLocation(@RequestBody Order order) {
        Order created = orderService.save(order);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/orders/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping
    public List<Order> getAll() { return orderService.getAll(); }

    @GetMapping("/unfinished")
    public List<Order> getAllUnfinished() { return orderService.getAllUnfinished(); }

    @GetMapping(value = "/by_department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllByDeparatment(@RequestBody Department department) { return orderService.getAllByDepartment(department); }

    @GetMapping("/by_employee/{id}")
    public List<Order> getAllByEmployee(@PathVariable("id") int id) { return orderService.getAllByEmployee(id); }

    @GetMapping("/get_time_left/{id}")
    public String getTimeLeft (@PathVariable("id") int id) { return orderService.getTimeLeft(id); }

}
