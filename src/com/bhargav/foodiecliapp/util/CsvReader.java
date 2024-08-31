package com.bhargav.foodiecliapp.util;

import com.bhargav.foodiecliapp.model.Customer;
import com.bhargav.foodiecliapp.model.Dish;
import com.bhargav.foodiecliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvReader {

    /*
    Read the data from CSV files and Create a List of Objects.
     */

    /*
    The Below Method is used to read the details of an customer from Customer.csv files
     */
    public List<Customer> readCustomersFromCsv()
    {

        String customersCsvFilePath ="E:\\Personal Projects\\foodie-cli-application-java\\data\\customers.csv";
        //Java IO Classes (FileReader, BufferedReader)

        List<Customer> customerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(customersCsvFilePath)))
        {

            String csvSplitBy = ",";
            br.readLine();

            while ( (line = br.readLine()) != null )
            {
                //C001, Bujji, bujji@gmail.com, bujji023
                String[] data = line.split(csvSplitBy);

                Customer customer = new Customer();
                customer.setId(data[0]);
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);
                customerList.add(customer);
            }
        } catch (IOException e)
        {
            System.out.println("File not found in the path");
            e.printStackTrace();
        }
    return customerList;
    }

    /*
    The below Method is used to read the Dishes from dishes.csv file
     */
    public List<Dish> readDishesFromCsv()
    {
        String dishCsvFilePath = "E:\\Personal Projects\\foodie-cli-application-java\\data\\dishes.csv";

        List<Dish> dishList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(dishCsvFilePath)))
        {

            String csvSplitBy = ",";
            br.readLine();

            while ( (line = br.readLine()) != null )
            {
                //D001,Butter Chicken,Rich and creamy chicken curry,12.99
                String[] data = line.split(csvSplitBy);

                Dish dish = new Dish();
                dish.setId(data[0]);
                dish.setName(data[1]);
                dish.setDescription(data[2]);
                dish.setPrice(Double.parseDouble(data[3]));
                dishList.add(dish);
            }
        } catch (IOException e)
        {
            System.out.println("File not found in the path");
            e.printStackTrace();
        }
        return dishList;
    }

    /*
    The Below Method is used to read the Restaurant data from restaurants.csv file
     */
    public List<Restaurant> readRestaurantsFromCsv()
    {
        String restaurantCsvFilePath = "E:\\Personal Projects\\foodie-cli-application-java\\data\\restaurants.csv";

        List<Restaurant> restaurantList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(restaurantCsvFilePath)))
        {

            String csvSplitBy = ",";
            br.readLine();

            while ( (line = br.readLine()) != null )
            {
                //R001,Spice Haven,123 Curry Lane,D001:D002:D003
                String[] data = line.split(csvSplitBy);

                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0]);
                restaurant.setName(data[1]);
                restaurant.setAddress(data[2]);
                restaurant.setMenu(Collections.singletonList(data[3]));
                restaurantList.add(restaurant);
            }
        } catch (IOException e)
        {
            System.out.println("File not found in the path");
            e.printStackTrace();
        }
        return restaurantList;
    }
}
