package com.bhargav.foodiecliapp.repository;

import java.util.List;
import java.util.Optional;

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

    public Restaurant saveRestaurant(Restaurant restaurant)
    {
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurantById(String id)
    {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated)
    {
        Optional<Restaurant> restaurantOptional = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated.getId()))
                .findFirst()
                .map(restaurant ->{
                    restaurant.setName(restaurantToBeUpdated.getName());
                    restaurant.setMenu(restaurantToBeUpdated.getMenu());
                    restaurant.setAddress(restaurantToBeUpdated.getAddress());
                    return restaurant;
                        }
                );
        return restaurantOptional.orElse(null);
    }

    public void deleteRestaurant(Restaurant restaurant)
    {
        this.restaurantList.remove(restaurant);
    }
}
