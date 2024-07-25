package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.model.Customer;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistingException;
}
