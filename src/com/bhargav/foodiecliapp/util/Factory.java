package com.bhargav.foodiecliapp.util;

import com.bhargav.foodiecliapp.controller.CustomerController;
import com.bhargav.foodiecliapp.repository.CustomerRepository;
import com.bhargav.foodiecliapp.service.CustomerServiceImpl;

public class Factory
{
    public CustomerRepository getCustomerRepository()
    {
        return new CustomerRepository();
    }

    public CustomerServiceImpl getCustomerService()
    {
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public CustomerController getCustomerController()
    {
        return new CustomerController(getCustomerService());
    }
}
