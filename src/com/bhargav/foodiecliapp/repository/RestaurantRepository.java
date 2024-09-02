package com.bhargav.foodiecliapp.repository;

import java.util.List;
import com.bhargav.foodiecliapp.model.Restaurant;
import com.bhargav.foodiecliapp.Factory;

public class RestaurantRepository
{
    private List<Restaurant> restaurantList;

    public RestaurantRepository()
    {
        this. restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getAllRestaurants()
    {
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant)
    {
        this.restaurantList.add(restaurant);
        return restaurant;
    }


}
