package me.retailsp.app;

import java.util.ArrayList;
import java.util.Scanner;

import me.retailsp.menu.CustomerMenu;
import me.retailsp.menu.EmployeeMenu;
import me.retailsp.menu.Menu;
import me.retailsp.personale.Customer;
import me.retailsp.personale.Employee;

public class RetailApp 
{
	/*Variables*/
	Menu menus[];
	private ArrayList<Employee> employees;
	private ArrayList<Customer> customers;
	private int currentSelected = 0;
	private boolean isRunning = false;
	private String companyName;
	/*Constructor*/
	public RetailApp(String companyName)
	{
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		this.companyName = companyName;
		initMenus();
	}
	
	private void initMenus()
	{
		/*Initializing Menu Array*/
		menus = new Menu[2];
		menus[0] = new CustomerMenu(customers);
		menus[1] = new EmployeeMenu(employees);
	}
	/*Run function is the source of the application*/
	public void run()
	{
		isRunning = true;
		System.out.println("---"+companyName+"---");
		while(isRunning)
		{
			display();
			menuRuns();
			currentSelected = 0;
		}
		System.out.println("Application is ending!!!");
	}
	
	public void display()
	{
		/*currentSelected is charge which menus is being displayed
		 *and there is an if statement to check if the menu is not null
		 *to avoid a null pointer exception.*/
		switch (currentSelected)
		{
			case 0:
				displayHomeScreen();
				break;
			case 1:
				if(menus[0] != null)
					menus[0].display();
				break;
			case 2:
				if(menus[1] != null)
					menus[1].display();
				break;
			case 3:
				isRunning = false;
				break;
		}
	}
	/*This prints the "home page"*/
	private void displayHomeScreen()
	{
		System.out.println("---The Home Page---");
		System.out.println("---Selections---");
		/*Loops through the menu array to display the title of all menus*/
		for(int i = 0; i < menus.length; i++)
		{
			Menu obj = menus[i];
			if(obj == null)
			{
				System.out.println("Failure in initalizing menus closing application!!!");
				currentSelected = 3;
			}
			System.out.println("\t"+(i+1) + ") " + obj.getTitle());
		}
		System.out.println("\t"+ (menus.length+1) + ") Exit" );
		System.out.println("Please Make A Selection: ");
	}
	
	public void menuRuns()
	{
		do
		{
			/*The @SuppressWarnings("resource") is here to ignore a warning for 
			 * not closing the scanner since I can't close it within the loop
			 * without stopping the input.
			 * */
			 @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			currentSelected = scanner.nextInt();
			System.out.println("You selected " + currentSelected);
			/*This if statement that checks if the int is a valid option*/
			if(!( (currentSelected >= 0) && (currentSelected <= 3 )))
				System.out.println("Invalid Selection");
		}while( !( (currentSelected >= 0) && (currentSelected <= 3 ) ) );
		if(currentSelected  == menus.length + 1)	//Exit selection is menus.length + 1 in the home page
		{
			isRunning = false;
			return;
		}
		if(currentSelected == 0)
		{
			return;
		}
		//Menus run method is while loop which is similar to retail app.
		menus[currentSelected-1].run();
	}
}
