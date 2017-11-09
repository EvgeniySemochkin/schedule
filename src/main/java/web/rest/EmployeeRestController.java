package web.rest;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee get(@PathVariable("id") int id) { return employeeService.get(id);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> createWithLocation(@RequestBody Employee employee) {
        Employee created = employeeService.save(employee);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/orders/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping
    public List<Employee> getAll() { return employeeService.getAll(); }

}
