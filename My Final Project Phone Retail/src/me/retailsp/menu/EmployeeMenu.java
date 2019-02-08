package me.retailsp.menu;

import java.util.ArrayList;
import java.util.Scanner;

import me.retailsp.personale.Employee;

public class EmployeeMenu extends Menu
{
	/*Since I do not know how many employees are there and
	 * I don't expect much adding and deleting so I choose 
	 * an array list*/
	private ArrayList<Employee> employees;
	int currentSelected = 0; /*This has no much use but this was place here when testing the code*/
	/*Constructor*/
	public EmployeeMenu(ArrayList<Employee> employees)
	{
		/*It's parent class requires a "title" as a parameter in its constructor*/
		super("Employees");
		this.employees = employees;
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
		showEmployees();
		showSelection();
		getSelection();
	}
	
	/*Prints out a list of Employees with their name and position*/
	private void showEmployees()
	{
		for(int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(employee == null)
				continue;
			System.out.println(i + ") Name: " + employee.getName() + " | Position: " + employee.getPosition());
		}
	}
	/*Just prints what options the user has*/
	private void showSelection()
	{
		System.out.println("---Selections---");
		System.out.println("0) Home 1) Add 2) Fire");
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
			if(!( (currentSelected >= 0) && (currentSelected <= 2 )))
				System.out.println("Invalid Selection");
		}while( !( (currentSelected >= 0) && (currentSelected <= 2 ) ) );
		input(currentSelected);
	}
	/*Input is switch statement that starts a new method that either add delete("fire") and employee*/
	public void input(int i)
	{
		switch(i)
		{
		case 0:
			isRunning = false;
			break;
		case 1:
			addEmployee();
			break;
		case 2:
			fireEmployee();
			break;
		}
	}
	/*In add employee method it will ask for input in order to create an employee object
	 * and add it to the employees array list */
	private void addEmployee()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>To add a new Employee we'll need some Info");
		System.out.print(">>Please Type in the Employee's Name: ");
		String name = scanner.nextLine();
		System.out.print(">>Great! Now what is their position: ");
		String position = scanner.nextLine();
		employees.add(new Employee(name,position));
	}
	/* Fire Employee method will prompt on how to delete an employee and ask the user
	 * for their "number" in the list that was displayed before hand in the showEmployees method*/
	private void fireEmployee()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>To delete a Employee we'll need the number assoicated with them in the Employee page, for example.");
		System.out.println(">>0) Employee: Employee Name | Position: Clerk >> This Employee's number is 0");
		System.out.println(">>1) Employee: Another Employee Name | Position: Manager >> This Employee's number is 1");
		System.out.println(">>If you wish out to opt out the deletion page select -1 without deleting a employee.");
		System.out.println(">>Now enter the employee's number: ");
		boolean validInput = true;
		int id = -1;
		/*Use a do while loop because we might not need to ask input for more than
		 * once if the user's input is not valid*/
		do
		{
				id = scanner.nextInt();
				if(id == -1)
				{
					return;
				}
				if(id < 0 || id >= employees.size() || employees.get(id) == null)
				{
					System.out.println(">>The ID is not valid! >> Try another ID");
					validInput = false;
				}
		}while(!validInput);
		//If everything goes well we delete
		employees.remove(id);
	}
}
