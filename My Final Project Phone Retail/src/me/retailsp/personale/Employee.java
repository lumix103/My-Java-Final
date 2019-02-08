package me.retailsp.personale;

public class Employee 
{
	/*Employee Variable*/
	String name;
	String position;
	/*Getters and Setters*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	/*Constructor*/
	public Employee(String name, String position)
	{
		this.name = name;
		this.position = position;
	}
}
