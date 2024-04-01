package com.karthik.customer.controller;

import com.karthik.customer.db.entity.Customer;
import com.karthik.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        log.info("Hold on.. ");
        return customerService.getAllCustomers();
    }

    @GetMapping("/error")
    public List<Customer> error() {
        return customerService.throwException();
    }

}
