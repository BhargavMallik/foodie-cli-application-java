package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.RestaurantExistsException;
import com.bhargav.foodiecliapp.exceptions.RestaurantNotExistsException;
import com.bhargav.foodiecliapp.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService
{
    public List<Restaurant> getAllRestaurants();

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException;

    public Optional<Restaurant> findRestaurantById(String id) throws RestaurantNotExistsException;

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotExistsException;

    public void deleteRestaurant(String id) throws RestaurantNotExistsException;
}
