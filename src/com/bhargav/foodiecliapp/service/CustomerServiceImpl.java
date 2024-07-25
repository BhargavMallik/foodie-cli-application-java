package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.repository.CustomerRepository;
import com.sun.source.tree.BreakTree;

import java.util.Optional;

public class CustomerServiceImpl  implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistingException {

        //if customer already exists (id, name, emai) throw CustomerExistsException
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistingException("Customer Already Exists with this id: "+customer.getId());

        //else save customer in repository

        return this.customerRepository.save(customer);
    }
}
