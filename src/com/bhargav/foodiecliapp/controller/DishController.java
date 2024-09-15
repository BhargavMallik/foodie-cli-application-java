package com.bhargav.foodiecliapp.controller;

import com.bhargav.foodiecliapp.exceptions.DishExistingException;
import com.bhargav.foodiecliapp.exceptions.DishNotExistingException;
import com.bhargav.foodiecliapp.model.Dish;
import com.bhargav.foodiecliapp.service.DishServiceImpl;

import java.util.List;

public class DishController
{
    private final DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService)
    {
        this.dishService = dishService;
    }

    public List<Dish> getDisesList()
    {
        return this.dishService.getDishesList();
    }

    public Dish save(Dish dish) throws DishExistingException
    {
        return this.dishService.save(dish);
    }

    public Dish getDishById(String id) throws DishNotExistingException {
        return this.dishService.getDishById(id);
    }

    public Dish update(Dish dish) throws DishNotExistingException {
        return this.dishService.updateDish(dish);
    }

    public void deleteDish(String id) throws DishNotExistingException{
        this.dishService.deleteDish(id);
    }
}
