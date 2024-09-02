package com.bhargav.foodiecliapp.repository;

import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository
{

    private List<Customer> customerList;

    public CustomerRepository()
    {
        CsvReader csvReader = new CsvReader();
        this.customerList = csvReader.readCustomersFromCsv();
    }

    public List<Customer> getAllCustomers()
    {
        return this.customerList;
    }

    public Customer save(Customer customer)
    {
        this.customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id)
    {
         return this.customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
}
