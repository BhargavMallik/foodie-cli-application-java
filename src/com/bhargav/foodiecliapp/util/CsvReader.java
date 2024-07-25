package com.bhargav.foodiecliapp.util;

import com.bhargav.foodiecliapp.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    /*
    Read the data from CSV files and Create a List of Objects.
     */

    public List<Customer> readCustomersFromCsv(){

        String customersCsvFilePath ="E:\\Personal Projects\\foodie-cli-application-java\\data\\customers.csv";
        //Java IO Classes (FileReader, BufferedReader)

        List<Customer> customerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(customersCsvFilePath))){

            String csvSplitBy = ",";
            br.readLine();

            while ( (line = br.readLine()) != null ){
                //C001, Bujji, bujji@gmail.com, bujji023
                String[] data = line.split(csvSplitBy);

                Customer customer = new Customer();
                customer.setId(data[0]);
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);
                customerList.add(customer);
            }
        } catch (IOException e){
            System.out.println("File not foind in the path");
            e.printStackTrace();
        }
    return customerList;
    }
}
