/* This is a Java counter class. It increments and decrements a counter in intervals 
 * of one unit; either hour, minute, or second.
 * Written by Calvin Li. 
 * Written on Ubuntu Linux, Eclipse Luna, Java 8 SE.
 */

package Intern;

import java.util.ArrayList;
import java.io.*;

public class Counter {
	
	
	
	
	/* Store the counter components in an array list for easy access (H/M/S)
	 * ArrayList(0) = hour ; ArrayList(1) = minute ; ArrayList(2) = second */	
	ArrayList<Integer> count = new ArrayList<Integer>(3);
	
	/* Default Constructor
	 * The default constructor sets the counter to 0:0:0 */
	Counter()	
	{
		count.set(0,0);
		count.set(1,0);
		count.set(2,0);
	};

	/* Parameterized Constructor */
	Counter(int h, int m, int s) 
	{
		/* If input is within bounds */
		if (h < 23 && h >= 0 && m < 59 && m >= 0 && s < 59 && s >= 0)
		{
			count.set(0,h);
			count.set(1,m);
			count.set(2,s);			
		}
		/* Display an error message and set counter to 0:0:0 in event of undesirable input */
		else
		{	
			System.out.println("A negative or out of bound number was entered. Auto setting counter to 0:0:0 instead.\n");
			count.set(0,0);
			count.set(1,0);
			count.set(2,0);
		}	
	}
	
	/* Function to reset counter to 0:0:0 */
	public void Reset()	
	{
		count.set(0,0);
		count.set(1,0);
		count.set(2,0);
	}
	
	/* Display standard time */
	public void displayStandard()	
	{
		/* Check if it is the morning or the afternoon
		 * and print the appropriate 12-hour time with AM/PM marker */
		if (count.get(0) > 12)
		{
			System.out.format("%tl:%tM:%tS PM" , (count.get(0) - 12), count.get(1), count.get(2));
		}
		else 
		{
			System.out.format("%tl:%tM:%tS AM" , count.get(0), count.get(1), count.get(2));
		}
		
		/* For use in other applications that require a string */
		String standardTimeAM = String.format("%tl:%tM:%tS AM", count.get(0), count.get(1), count.get(2));
		String standardTimePM = String.format("%tl:%tM:%tS PM", (count.get(0) - 12), count.get(1), count.get(2));

	}
	
	/* Print military time */
	public void displayMilitary()	
	{
		/* Display military time */
		System.out.format("%tH:%tM:%tS" , count.get(0), count.get(1), count.get(2));
		
		/* For use in other applications that require a string */
		String militaryTime = String.format("%tH:%tM:%tS");
	}
	
	/* Functions used to increment and decrement the counter */
	
	/* Function to increment hour field */
	public void incrementHour() 	
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
		}
	}
	
	/* Function to increment minute field */
	public void incrementMinute() 	
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
		}
	}
	
	/* Function to increment second field */
	public void incrementSecond() 	
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
		}
	}
	
	/* Function to decrement hour field */
	public void decrementHour()	
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
		}
	}
	
	/* Function to decrement minute field */
	public void decrementMinute() 
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
		}
	}
	
	/* Function to decrement second field */
	public void decrementSecond() 	
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
		}
	}
}