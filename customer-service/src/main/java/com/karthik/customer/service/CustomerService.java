package com.karthik.customer.service;

import com.karthik.customer.db.entity.Customer;
import com.karthik.customer.db.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;
import static org.springframework.data.domain.Sort.by;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        log.info("Getting all customers from DB, sorted by age(desc) and name(asc) ");
        Sort sortByAgeAndName = by(desc("age")).and(by(asc("name")));
        return Optional.of(customerRepository.findAll(sortByAgeAndName)).orElse(List.of());
    }

    public List<Customer> throwException() {
        log.error("Oooooops...!! Simulated error....");
        throw new RuntimeException("I error voluntarily");
    }
}
