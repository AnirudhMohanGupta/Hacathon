package com.cerner.pharmassist.dbservice.resource;

import com.cerner.pharmassist.dbservice.model.Order;
import com.cerner.pharmassist.dbservice.model.Orders;
import com.cerner.pharmassist.dbservice.repository.OrdersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private OrdersRepository ordersRepository;

    public DbServiceResource(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/{patientname}")
    public List<String> getOrders(@PathVariable("patientname") final String patientname) {

        return getOrdersByPatientName(patientname);
    }

    @GetMapping("/pending")
    public List<String> getAllOrders() {

        return getAllPatient();
    }

    private List<String> getAllPatient() {
        List<Order> o=  ordersRepository.findAllByStatus(0);
        List<String> s= new ArrayList<>();
        for (Order order:o
             ) {
            s.add(order.getPatientName()+" : "+order.getDrug());
        }
        return s;
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Orders orders) {
        orders.getDrugs()
                .stream()
                .map(order -> new Order(orders.getPatientName(), order, 0))
                .forEach(order -> ordersRepository.save(order));
        return getOrdersByPatientName(orders.getPatientName());
    }


    @PostMapping("/delete/{patientname}")
    public List<String> delete(@PathVariable("patientname") final String patientname) {

        List<Order> orders = ordersRepository.findByPatientName(patientname);
        ordersRepository.delete(orders);

        return getOrdersByPatientName(patientname);
    }


    private List<String> getOrdersByPatientName(@PathVariable("patientname") String patientname) {
        return ordersRepository.findByPatientName(patientname)
                .stream()
                .map(Order::getDrug)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/updateorder")
    public List<String> update(@RequestParam("patientname") String patientName, @RequestParam("drug") String drug) {
        System.out.println("fffffffffffffffff:" + patientName + "\n yuyuyu" + drug);
        Integer id = ordersRepository.findId(patientName, drug).iterator().next().getId();
        System.out.println(id);
        ordersRepository.updateStatus(id);
        return getOrdersByPatientName(patientName);
    }

}
