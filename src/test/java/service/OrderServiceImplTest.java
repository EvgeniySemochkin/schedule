package service;

import model.FurnitureType;
import model.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@ContextConfiguration("classpath:/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Order order = new Order("Test order", FurnitureType.ARMCHAIR, LocalDateTime.now());
        orderService.save(order);
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}