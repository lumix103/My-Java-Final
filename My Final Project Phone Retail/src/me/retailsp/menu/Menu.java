package me.retailsp.menu;

public abstract class Menu implements Display
{
	/*isRunning is to be used along side the run method*/
	protected boolean isRunning = false;
	/*Getter*/
	public String getTitle() 
	{
		return title;
	}
	/*Menu Variables*/
	String title;
	/*Constructor*/
	public Menu(String title)
	{
		this.title = title;
	}
	/*Child Class should still override this method and call it's parents method*/
	public void display()
	{
		System.out.println("---The " + title + " Page---");
	}
	/*To be implemented by it's child class*/
	public abstract void run();
}
