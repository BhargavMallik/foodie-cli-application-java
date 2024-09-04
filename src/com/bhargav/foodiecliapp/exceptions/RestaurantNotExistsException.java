package com.bhargav.foodiecliapp.exceptions;

public class RestaurantNotExistsException extends Exception
{
    public RestaurantNotExistsException(String message)
    {
        super(message);
    }
}
