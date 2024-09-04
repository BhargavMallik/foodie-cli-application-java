package com.bhargav.foodiecliapp.controller;

import com.bhargav.foodiecliapp.exceptions.RestaurantExistsException;
import com.bhargav.foodiecliapp.exceptions.RestaurantNotExistsException;
import com.bhargav.foodiecliapp.model.Restaurant;
import com.bhargav.foodiecliapp.service.RestaurantServiceImpl;

import java.util.List;
import java.util.Optional;

public class RestaurantController
{
    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getAllRestaurants()
    {
        return this.restaurantService.getAllRestaurants();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException
    {
        return this.restaurantService.saveRestaurant(restaurant);
    }

    public Optional<Restaurant> findRestaurantById(String id) throws RestaurantNotExistsException
    {
        return this.restaurantService.findRestaurantById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotExistsException
    {
        return this.restaurantService.updateRestaurant(restaurantToBeUpdated);
    }

    public void deleteRestaurant(String id) throws RestaurantNotExistsException
    {
        this.restaurantService.deleteRestaurant(id);
    }

}
