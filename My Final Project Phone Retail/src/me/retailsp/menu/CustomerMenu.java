package me.retailsp.menu;

import java.util.ArrayList;
import java.util.Scanner;

import me.retailsp.personale.Customer;

public class CustomerMenu extends Menu
{
	/*Since I do not know how many customers are there and
	 * I don't expect much adding and deleting so I choose 
	 * an array list*/
	ArrayList<Customer> customers;
	int currentSelected = 0; /*This has no much use but this was place here when testing the code*/
	/*Constructor*/
	public CustomerMenu(ArrayList<Customer> customers)
	{
		/*It's parent class requires a "title" as a parameter in its constructor*/
		super("Customers");
		this.customers = customers;
	}
	/*run function responsible on keeping the Employee Menu going*/
	public void run()
	{
		isRunning = true;
		while(isRunning)
		{
			display();
		}
	}
	/*Prints out all the method and gets selection*/
	public void display()
	{
		super.display();
		displayCustomers();
		showSelection();
		getSelection();
	}
	/*Prints out a list of Customers with their name and payment owed*/
	private void displayCustomers()
	{
		for(int i = 0; i < customers.size(); i++)
		{
			Customer customer = customers.get(i);
			if(customer == null)
				continue;
			System.out.println(i + ") Name: " + customer.getName() + " | Total: " + customer.getPayment_total());
		}
	}
	/*Just prints what options the user has*/
	private void showSelection()
	{
		System.out.println("---Selections---");
		System.out.println("0) Home 1) Add 2) Delete 3) Pay");
	}
	/*Does some input checking and passes it to input method*/
	private void getSelection()
	{
		do
		{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			currentSelected = scanner.nextInt();
			System.out.println("You selected " + currentSelected);
			if(!( (currentSelected >= 0) && (currentSelected <= 3 )))
				System.out.println("Invalid Selection");
		}while( !( (currentSelected >= 0) && (currentSelected <= 3 ) ) );
		input(currentSelected);
	}
	/*Starts method for adding deleting or payment for customers*/
	public void input(int i)
	{
		switch(i)
		{
		case 0:
			isRunning = false;
			break;
		case 1:
			addCustomer();
			break;
		case 2:
			deleteCustomer();
			break;
		case 3:
			paymentCustomer();
			break;
		}
	}
	
	/*In add customer method it will ask for input in order to create an customer object
	 * and add it to the customers array list */
	private void addCustomer()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>To add a new Customer we'll need some Info");
		System.out.print(">>Please Type in the Customer's Name: ");
		String name = scanner.nextLine();
		System.out.print(">>Great! Now we will need an amount of payment that they will owe: ");
		float payment = scanner.nextFloat();
		customers.add(new Customer(name,payment));
	}
	/* delete method method will prompt on how to delete an customer and ask the user
	 * for their "number" in the list that was displayed before hand in the show Customers method
	 * and if the customer still owes a payment it will not allow the user to delete that customer
	 * from the list*/
	private void deleteCustomer()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>To delete a Customer we'll need the number assoicated with them in the Customer page, for example.");
		System.out.println(">>0) Name: Customer Name | Total: 45.0 >> This Customer's number is 0");
		System.out.println(">>1) Name: ANother Customer Name | Total: 45.0 >> This Customer's number is 1");
		System.out.println(">>If you wish out to opt out the deletion page select -1 without deleting a customer.");
		System.out.println(">>Now enter the customer's number: ");
		boolean validInput = true;
		int id = -1;
		do
		{
				id = scanner.nextInt();
				if(id == -1)
				{
					return;
				}
				if(id < 0 || id >= customers.size() || customers.get(id) == null)
				{
					System.out.println(">>The ID is not valid! >> Try another ID");
					validInput = false;
				}
		}while(!validInput);
		if(customers.get(id).getPayment_total() <= 0)
			customers.remove(id);
		else
			System.out.println(">>Sorry but that customer has a pending payment.");
	}
	
	/*Will remove the amount owed from a customer object in order to be deleted*/
	private void paymentCustomer()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>For a customer to procced payment we'll need the number assoicated with them in the Customer page, for example.");
		System.out.println(">>0) Name: Customer Name | Total: 45.0 >> This Customer's number is 0");
		System.out.println(">>1) Name: ANother Customer Name | Total: 45.0 >> This Customer's number is 1");
		System.out.println(">>If you wish out to opt out the payment page select -1 without affecting payment of a customer.");
		System.out.println(">>Now enter the customer's number: ");
		boolean validInput = true;
		int id = -1;
		do
		{
				id = scanner.nextInt();
				if(id == -1)
				{
					return;
				}
				if(id < 0 || id >= customers.size() | customers.get(id) == null)
				{
					System.out.println(">>The ID is not valid! >> Try another ID");
					validInput = false;
				}
		}while(!validInput);
		customers.get(id).setPayment_total(0);
	}
}
