package com.cerner.pharmassist.pharmaService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest/order")
public class OrderResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/pending")
    public List<String> getAllOrders() {

        ResponseEntity<List<String>> orderResponse = restTemplate.exchange("http://localhost:8300/rest/db/pending", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });

        List<String> orders = orderResponse.getBody();
        return orders;

    }

}
