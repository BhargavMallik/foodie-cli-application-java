package com.bhargav.foodiecliapp.exceptions;

import com.bhargav.foodiecliapp.model.Customer;

public class CustomerNotExistingException extends Exception
{
    public CustomerNotExistingException(String message)
    {
        super(message);
    }
}
