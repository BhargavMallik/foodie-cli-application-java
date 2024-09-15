package com.bhargav.foodiecliapp.repository;

import com.bhargav.foodiecliapp.model.Dish;

import java.util.List;
import java.util.Optional;

public class DishRepository
{
    List<Dish> dishList;

    public DishRepository(List<Dish> dishList)
    {
        this.dishList = dishList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public Dish saveDish(Dish dish)
    {
        this.dishList.add(dish);
        return dish;
    }

    public Optional<Dish> findDishById(String id)
    {
        return this.dishList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }

    public Dish updateDish(Dish dishToBeUpdated)
    {
        Optional<Dish> optionalDish = this.dishList.stream().filter(dish -> dish.getId().equals(dishToBeUpdated.getId()))
                .findFirst()
                .map(dish -> {
                    dish.setName(dishToBeUpdated.getName());
                    dish.setPrice(dishToBeUpdated.getPrice());
                    dish.setDescription(dishToBeUpdated.getDescription());

                    return dish;
                        });

        return optionalDish.orElse(null);
    }

    public void deleteDish(Dish dish)
    {

        this.dishList.remove(dish);
    }
}
