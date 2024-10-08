package com.bhargav.foodiecliapp.ui;

import com.bhargav.foodiecliapp.Factory;
import com.bhargav.foodiecliapp.controller.CustomerController;
import com.bhargav.foodiecliapp.exceptions.CustomerExistingException;
import com.bhargav.foodiecliapp.exceptions.CustomerNotExistingException;
import com.bhargav.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu extends Menu
{
    private final CustomerController customerController;


    public CustomerMenu()
    {
        this.customerController = Factory.getCustomerController();
    }

    @Override
    public void displayMenu()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login  (Existing Customer)");
                System.out.println("3. Search Customer");
                System.out.println("4. Display All Customers ");
                System.out.println("5. Update Customer");
                System.out.println("6. Delete Customer");
                System.out.println("7. Exit");

                System.out.println("Please enter your choice (1-7)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> customerRegisterForm();
                    case 2 -> customerLoginForm();
                    case 3 -> customerSearchForm();
                    case 4 -> displayAllCustomers();
                    case 5 -> customerUpdateForm();
                    case 6 -> deleteCustomerForm();
                    case 7 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e)
        {
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    public void customerRegisterForm()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Your id : ");
            String id = sc.nextLine();

            System.out.println("Enter Your Name : ");
            String name = sc.nextLine();

            System.out.println("Enter Your Email : ");
            String email = sc.nextLine();

            System.out.println("Set Your Password");
            String password = sc.nextLine();

            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);

            Customer savedCustomer = customerController.saveCustomer(customer);
            System.out.println("Customer Regestration Successful!!!");
            displayCustomerDetails(savedCustomer);
        } catch (CustomerExistingException e)
        {
            System.out.println(e.getMessage());
        } catch (Exception ex)
        {
            System.out.println("Internal Error occured - Please try again later");
            customerRegisterForm();
        }
    }

    public void displayCustomerDetails(Customer customer)
    {
        displayMenuHeader("Customer Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
    }

    public void customerLoginForm()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter You Email : ");
            String email = sc.nextLine();

            System.out.println("Enter Your Password : ");
            String password = sc.nextLine();

            Customer validateCustomer = customerController.validateCustomerLogin(email,password);
            System.out.println("Login Successful");
            System.out.println("Welcome "+ validateCustomer.getName());

            RestaurantsMenu rm = new RestaurantsMenu();
            rm.displayMenu();

        } catch (CustomerNotExistingException ex)
        {
            System.out.println(ex.getMessage());
            displayMenu();
        }
    }

    public void customerSearchForm()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Your id :");
            String id = sc.nextLine();

            Customer customer = customerController.getCustomerById(id);
            displayCustomerDetails(customer);

        } catch (CustomerNotExistingException ex)
        {
            System.out.println(ex.getMessage());
            displayMenu();
        }
    }
    public void displayAllCustomers()
    {
        List<Customer> customerList = customerController.getCustomersList();

        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Customers");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        System.out.println(dashesLine);
        customerList.forEach(customer -> System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length())));
    }

    public void customerUpdateForm()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the customer Details to be Updated");

            System.out.println("Enter Id : ");
            String id = sc.nextLine();

            System.out.println("Enter Name : ");
            String name = sc.nextLine();

            System.out.println("Enter Email : ");
            String email = sc.nextLine();

            System.out.println("Enter Password : ");
            String password = sc.nextLine();

            Customer customer = new Customer();

            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);

            Customer updatedCustomer = customerController.updateCustomer(customer);

            System.out.println("Customer Updated Successful");
            displayCustomerDetails(updatedCustomer);

        } catch (CustomerNotExistingException ex)
        {
            System.out.println(ex.getMessage());
            displayMenu();
        } catch (Exception e)
        {
            System.out.println("Some Internal Error Occured - Please try again.");
            customerUpdateForm();
        }
    }

    public void deleteCustomerForm()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Id : ");
            String id = sc.nextLine();

            customerController.deleteCustomer(id);
            System.out.println("Customer Deleted Successful");
        } catch (CustomerNotExistingException ex)
        {
            System.out.println(ex.getMessage());
            displayMenu();
        }
    }
}
