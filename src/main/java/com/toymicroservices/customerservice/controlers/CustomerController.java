package com.toymicroservices.customerservice.controlers;

import com.toymicroservices.customerservice.models.Customer;
import com.toymicroservices.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    final CustomerRepository repository;

    @GetMapping
    public List<Customer> getList() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Customer post(@RequestBody Customer customer) {
        return repository.save(customer);
    }
}
