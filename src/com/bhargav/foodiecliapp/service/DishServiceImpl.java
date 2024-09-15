package com.bhargav.foodiecliapp.service;

import com.bhargav.foodiecliapp.exceptions.DishExistingException;
import com.bhargav.foodiecliapp.exceptions.DishNotExistingException;
import com.bhargav.foodiecliapp.model.Dish;
import com.bhargav.foodiecliapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService
{
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository)
    {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishesList()
    {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistingException
    {
        Optional<Dish> findDish = this.dishRepository.findDishById(dish.getId());
        if(findDish.isPresent())
            throw new DishExistingException("Dish Already Exists with this Id : " + dish.getId());
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public void deleteDish(String id) throws DishNotExistingException
    {
        Optional<Dish> findDish = this.dishRepository.findDishById(id);
        if(findDish.isEmpty())
            throw new DishNotExistingException("Dish Not Exists with this Id : " +id);
        this.dishRepository.deleteDish(getDishById(id));
    }

    @Override
    public Dish getDishById(String id) throws DishNotExistingException
    {
        Optional<Dish> findDish = this.dishRepository.findDishById(id);
        if(findDish.isEmpty())
            throw new DishNotExistingException("Dish Not Exists with this Id : " +id);
        return findDish.get();
    }

    @Override
    public Dish updateDish(Dish dish) throws DishNotExistingException
    {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
        if(dishById.isEmpty())
            throw new DishNotExistingException("Dish Not Exists with this Id : " +dish.getId());
        return this.dishRepository.updateDish(dish);
    }
}
