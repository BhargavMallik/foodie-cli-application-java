package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.exceptions.CustomerNotExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.repository.CustomerRepository;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer) throws CustomerExistingException;

    public void deleteCustomer(String id) throws CustomerNotExistingException;

    public List<Customer> getCustomersList();

    public Customer getCustomerById(String id) throws CustomerNotExistingException;

    public Customer getCustomerByEmail(String email) throws CustomerNotExistingException;

    public Customer updateCustomer(Customer customer) throws CustomerNotExistingException;

    public Customer validateCustomerLogin(String email, String password) throws CustomerNotExistingException;

    public void setCurrentLoggedInCustomer(Customer customer);

    public Customer currentLoggedInCustomer();
}
