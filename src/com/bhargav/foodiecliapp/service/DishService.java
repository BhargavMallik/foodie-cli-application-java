package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.DishExistingException;
import com.bhargav.foodiecliapp.exceptions.DishNotExistingException;
import com.bhargav.foodiecliapp.model.Dish;

import java.util.List;

public interface DishService
{
    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistingException;
    public void deleteDish(String id) throws DishNotExistingException;

    public Dish getDishById(String id) throws DishNotExistingException;
    public Dish updateDish(Dish dish) throws DishNotExistingException;
}
