package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.model.Customer;
import com.sun.source.tree.BreakTree;

public class CustomerServiceImpl  implements CustomerService{

    @Override
    public Customer save(Customer customer) throws CustomerExistingException {

        //if customer already exists (id, name, emai) throw CustomerExistsException

        //else save customer in repository

        return null;
    }
}
