package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.exceptions.CustomerNotExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl  implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerExistingException {

        //if customer already exists (id, name, emai) throw CustomerExistsException
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistingException("Customer Already Exists with this id: "+customer.getId());

        //else save customer in repository

        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotExistingException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
        {
            throw new CustomerNotExistingException("Customer Not Found");
        }
        this.customerRepository.delete(customerById.get());
    }

    @Override
    public List<Customer> getCustomersList()
    {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotExistingException
    {
         Optional<Customer> customerById = this.customerRepository.findCustomerById(id);

         if(customerById.isEmpty())
         {
             throw new CustomerNotExistingException("Customer Not Found in this Id : " + id);
         }
         return customerById.get();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotExistingException
    {
        Optional<Customer> customerByEmail = this.customerRepository.findCustomerByEmail(email);

        if(customerByEmail.isEmpty())
        {
            throw new CustomerNotExistingException("Customer Not Found by this Email" + email);
        }
        return customerByEmail.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotExistingException
    {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());

        if(customerById.isEmpty())
        {
            throw new CustomerNotExistingException("Customer Not Exists");
        }
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotExistingException
    {
        Optional<Customer> customerByEmailAndPassword = this.customerRepository.findCustomerByEmailAndPassword(email,password);

        if(customerByEmailAndPassword.isEmpty())
        {
            throw new CustomerNotExistingException("Invalid Email or Password");
        }
        return customerByEmailAndPassword.get();
    }


}
