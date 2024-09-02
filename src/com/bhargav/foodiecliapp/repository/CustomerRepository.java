package com.bhargav.foodiecliapp.repository;

import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.Factory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository
{

    private List<Customer> customerList;

    public CustomerRepository()
    {
        this.customerList = Factory.getCsvReader().readCustomersFromCsv();
    }

    public List<Customer> getAllCustomers()
    {
        return this.customerList;
    }

    public Customer saveCustomer(Customer customer)
    {
        this.customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id)
    {
         return this.customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Optional<Customer> findCustomerByEmail(String email)
    {
        return this.customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public Optional<Customer> findCustomerByEmailAndPassword(String email, String password)
    {
        return this.customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }

    public void delete(Customer customer)
    {
        this.customerList.remove(customer);
    }

    public Customer updateCustomer(Customer customerToBeUpdated)
    {
        Optional<Customer> updateCustomer = this.customerList.stream().filter(customer -> customer.getId().equals(customerToBeUpdated.getId())).findFirst().map(customer -> {
            customer.setName(customerToBeUpdated.getName());
            customer.setEmail(customerToBeUpdated.getEmail());
            customer.setPassword(customerToBeUpdated.getPassword());

            return customer;
        });
        return updateCustomer.orElse(null);
    }
}
