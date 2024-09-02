package com.bhargav.foodiecliapp.util;

import com.bhargav.foodiecliapp.controller.CustomerController;
import com.bhargav.foodiecliapp.repository.CustomerRepository;
import com.bhargav.foodiecliapp.service.CustomerServiceImpl;

public class Factory
{
    public static CsvReader getCsvReader()
    {
        return Holder.CSV_READER;
    }
    public static CustomerRepository getCustomerRepository() {
        return Holder.CUSTOMER_REPOSITORY;
    }

    public static CustomerServiceImpl getCustomerService() {
        return Holder.CUSTOMER_SERVICE;
    }

    public static CustomerController getCustomerController() {
        return Holder.CUSTOMER_CONTROLLER;
    }

    private static class Holder
    {
        private static final CsvReader CSV_READER = new CsvReader();

        private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
        private static final CustomerServiceImpl CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);
        private static final CustomerController CUSTOMER_CONTROLLER = new CustomerController(CUSTOMER_SERVICE);
    }
}
