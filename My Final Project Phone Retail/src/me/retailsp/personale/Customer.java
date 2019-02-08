package me.retailsp.personale;

public class Customer 
{
	/*Customer Variables*/
	String name;
	float payment_total;
	/*Constructor*/
	public Customer(String name, float payment_total)
	{
		this.name = name;
		this.payment_total = payment_total;
	}
	/*Getters and Setters for Customer Variables*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPayment_total() {
		return payment_total;
	}

	public void setPayment_total(float payment_total) {
		this.payment_total = payment_total;
	}
	
	
}
