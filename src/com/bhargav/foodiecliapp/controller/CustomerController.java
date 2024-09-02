package com.bhargav.foodiecliapp.controller;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.service.CustomerServiceImpl;

public class CustomerController
{
    private CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl)
    {
        this.customerServiceImpl = customerServiceImpl;
    }

    public Customer save(Customer customer) throws CustomerExistingException
    {
        return this.customerServiceImpl.save(customer);
    }
}
