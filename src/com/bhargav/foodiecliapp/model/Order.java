package com.bhargav.foodiecliapp.model;

import java.util.List;
import java.util.Objects;

public class Order
{
    /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    Customer                    customer
    Restaurant                  restaurant
    List<Dish>                  dishes
    double                      price
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */

    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private List<String> dishes;
    private double price;

    public Order()
    {}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }

    public List<String> getDishes()
    {
        return dishes;
    }

    public void setDishes(List<String> dishes)
    {
        this.dishes = dishes;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(price, order.price) == 0 && Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, customer, restaurant, dishes, price);
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", dishes=" + dishes +
                ", price=" + price +
                '}';
    }
}
