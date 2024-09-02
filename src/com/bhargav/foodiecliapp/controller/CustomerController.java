package com.bhargav.foodiecliapp.controller;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.exceptions.CustomerNotExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController
{
    private CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl)
    {
        this.customerServiceImpl = customerServiceImpl;
    }

    public Customer saveCustomer(Customer customer) throws CustomerExistingException
    {
        return this.customerServiceImpl.saveCustomer(customer);
    }

    public void deleteCustomer(String id) throws CustomerNotExistingException
    {
        this.customerServiceImpl.deleteCustomer(id);
    }

    public List<Customer> getCustomersList()
    {
        return this.customerServiceImpl.getCustomersList();
    }

    public Customer getCustomerById(String id) throws CustomerNotExistingException
    {
        return this.customerServiceImpl.getCustomerById(id);
    }

    public Customer getCustomerByEmail(String email) throws CustomerNotExistingException
    {
        return this.customerServiceImpl.getCustomerByEmail(email);
    }

    public Customer getCurrentLoggedInCustomer()
    {
        return this.customerServiceImpl.currentLoggedInCustomer();
    }

    public Customer validateCustomerLogin(String email, String password) throws CustomerNotExistingException
    {
        Customer customer = this.customerServiceImpl.validateCustomerLogin(email,password);

        if(customer != null)
        {
            this.customerServiceImpl.setCurrentLoggedInCustomer(customer);
        }
        return customer;
    }

}
