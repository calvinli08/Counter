/* This is a Java counter class. It increments and decrements a counter in intervals
 * of one unit; either hour, minute, or second.
 * Written by Calvin Li.
 * Written on Ubuntu Linux, Eclipse Luna, Java 8 SE.
 */

import java.util.ArrayList;
import java.lang.Throwable;
import javax.swing.*;

class Counter {

	//Counter components
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	//Default Constructor
	//The default constructor sets the counter to 0:0:0
	Counter()
	{
		count.set(0,0);
		count.set(1,0);
		count.set(2,0);
	};
	//Store the counter components in an array list for easy access (H/M/S)
	//ArrayList(0) = hour ; ArrayList(1) = minute ; ArrayList(2) = second
	ArrayList<Integer> count = new ArrayList<Integer>(3);
	//Parameterized Constructor
	Counter(int h, int m, int s)
	{
		//If input is within bounds
		if (h < 23 && h >= 0 && m < 59 && m >= 0 && s < 59 && s >= 0)
		{
			hour = h;
			minute = m;
			second = s;
			count.set(0,h);
			count.set(1,m);
			count.set(2,s);

		}
		//Display an error message and set counter to 0:0:0 in event of undesirable input
		else
		{
			String inputException = "A negative or out of bound number was entered. Auto setting counter to 0:0:0 instead.\n";
			count.set(0,0);
			count.set(1,0);
			count.set(2,0);
		}
	}
	//Function to reset counter to 0:0:0
	public void Reset()
	{
		count.set(0,0);
		count.set(1,0);
		count.set(2,0);
	}
	//Display Output by changing the integers to strings
	//Standard Time
	String standardTime = "" + count.get(0) + ":"+ count.get(1)+ ":" + count.get(2);
	//Military Time
	String militaryTime = "" + count.get(0) + ":"+ count.get(1)+ ":" + count.get(2);

	//Functions used to increment and decrement the counter
	//Create a throwable object to throw in case of errors in functions.
	Throwable counterException = new Throwable("The counter attempted to go out of bounds. Resetting counter to 0:0:0.\n");
	//Start the functions
	//Function to increment hour field
	public void incrementHour() throws Throwable
	{
		if (count.get(0) < 23 && count.get(0) >= 0 )
		{
			count.set(0,(count.get(0)+1));
		}
		else if (count.get(0) == 23)
		{
			this.Reset();
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
	//Function to increment minute field
	public void incrementMinute() throws Throwable
	{
		if (count.get(1) < 59 && count.get(1) >= 0)
		{
			count.set(1,(count.get(1)+1));
		}
		else if (count.get(1) == 59)
		{
			count.set(1,0);
			this.incrementHour();
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
	//Function to increment second field
	public void incrementSecond() throws Throwable
	{
		if (count.get(2) < 59 && count.get(2) >= 0)
		{
			count.set(2,(count.get(2)+1));
		}
		else if (count.get(2) == 59)
		{
			count.set(2,0);
			this.incrementMinute();
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
	//Function to decrement hour field
	public void decrementHour()	throws Throwable
	{
		if (count.get(0) < 23 && count.get(0) >=1)
		{
			count.set(0,(count.get(0)-1));
		}
		else if (count.get(0) == 0)
		{
			count.set(0,23);
			count.set(1,59);
			count.set(2,59);
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
	//Function to decrement minute field
	public void decrementMinute() throws Throwable
	{
		if (count.get(1) < 59 && count.get(1) >=1)
		{
			count.set(1,(count.get(1)-1));
		}
		else if (count.get(1) == 0)
		{
			count.set(1,59);
			this.decrementHour();
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
	//Function to decrement second field
	public void decrementSecond() throws Throwable
	{
		if (count.get(2) < 59 && count.get(2) >= 1)
		{
			count.set(2,(count.get(2)-1));
		}
		else if (count.get(2) == 0)
		{
			count.set(2, 59);
			this.decrementMinute();
		}
		else
		{
			this.Reset();
			throw counterException;
		}
	}
}
