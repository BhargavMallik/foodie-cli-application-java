package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.RestaurantExistsException;
import com.bhargav.foodiecliapp.exceptions.RestaurantNotExistsException;
import com.bhargav.foodiecliapp.model.Restaurant;
import com.bhargav.foodiecliapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService
{
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants()
    {
        return this.restaurantRepository.getAllRestaurants();
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException
    {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if (restaurantById.isPresent())
        {
            throw new RestaurantExistsException("This Restaurant Already Exists with this Id : " + restaurant.getId());
        }
        return this.restaurantRepository.saveRestaurant(restaurant);
    }

    @Override
    public Optional<Restaurant> findRestaurantById(String id) throws RestaurantNotExistsException
    {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);

        if (restaurantById.isEmpty())
        {
            throw new RestaurantNotExistsException("Restaurant by this Id is not exists : " + id);
        }
        return this.restaurantRepository.findRestaurantById(id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotExistsException
    {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findRestaurantById(restaurantToBeUpdated.getId());

        if(restaurantOptional.isEmpty())
        {
            throw new RestaurantNotExistsException("Restaurant Not Exists with this Id : " + restaurantToBeUpdated.getId());
        }
        return this.restaurantRepository.updateRestaurant(restaurantToBeUpdated);
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) throws RestaurantNotExistsException
    {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findRestaurantById(restaurant.getId());

        if(restaurantOptional.isEmpty())
        {
            throw new RestaurantNotExistsException("Restaurant Not Exists with this Id : " + restaurant.getId());
        }
        this.restaurantRepository.deleteRestaurant(restaurant);
    }
}
