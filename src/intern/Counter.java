/* This is a Java counter class. It increments and decrements a counter in intervals
 * of one unit; either hour, minute, or second.
 * Written by Calvin Li.
 * Written on Ubuntu Linux, Eclipse Luna, Java 8 SE.
 */

package intern;

public class Counter {

	/* Store the counter components in an array for easy access (H/M/S)
	 * count[0] = hour ; count[1] = minute ; count[2] = second */
	int[] count = new int[3];

	/* Default Constructor
	 * The default constructor sets the counter to 0:0:0 */
	Counter()
	{
		/* Set the fields to zero */
		count[0] = 0;
		count[1] = 0;
		count[2] = 0;
	}

	/* Parameterized Constructor sets the counter to the values specified in h,m,s*/
	Counter(int h, int m, int s)
	{
		/* If input is within bounds */
		if (h <= 23 && h >= 0 && m <= 59 && m >= 0 && s <= 59 && s >= 0)
		{
			count[0] = h;
			count[1] = m;
			count[2] = s;
		}
		/* Display an error message and set counter to 0:0:0 in event of undesirable input */
		else
		{
			//System.out.println("A negative or out of bound number was entered. Auto setting counter to 0:0:0 instead.\n");
			count[0] = 0;
			count[1] = 0;
			count[2] = 0;
		}
	}

	/* Get functions for each field in the counter. Set functions are not provided
	 * because the project instructions requested that the only allowable method
	 * to change the Counter time after initialization be incrementing/decrementing each field. */

	public int[] get()
	{
		return count;
	}

	/* Display standard time */
	public void displayStandard()
	{
		/* Check if it is the morning or the afternoon
		 * and print the appropriate 12-hour time with AM/PM marker */
		if (count[0] > 12)
		{
			System.out.format("%tl:%tM:%tS PM" , (count[0] - 12), count[1], count[2]);
		}
		else
		{
			System.out.format("%tl:%tM:%tS AM" , count[0], count[1], count[2]);
		}

		/* For use in other applications that require a string */
		String standardTimeAM = String.format("%tl:%tM:%tS AM", count[0], count[1], count[2]);
		String standardTimePM = String.format("%tl:%tM:%tS PM", (count[0] - 12), count[1], count[2]);

	}

	/* Print military time */
	public void displayMilitary()
	{
		/* Display military time */
		System.out.format("%tH:%tM:%tS" , count[0], count[1], count[2]);

		/* For use in other applications that require a string */
		String militaryTime = String.format("%tH:%tM:%tS");
	}

	/* Functions used to increment and decrement the counter */

	/* Function to increment hour field */
	public void incrementHour()
	{
		if (count[0] < 23 && count[0] >= 0 )
		{
			count[0] += 1;
		}
		else
		{
            count[0] = 0;
            count[1] = 0;
            count[2] = 0;
        }
	}

	/* Function to increment minute field */
	public void incrementMinute()
	{
		if (count[1] < 59 && count[1] >= 0)
		{
			count[1] += 1;
		}
		else
		{
			count[1] = 0;
			this.incrementHour();
		}
	}

	/* Function to increment second field */
	public void incrementSecond()
	{
		if (count[2] < 59 && count[2] >= 0)
		{
            count[2] += 1;
		}
		else
		{
			count[2] = 0;
			this.incrementMinute();
		}

	}

	/* Function to decrement hour field */
	public void decrementHour()
	{
		if (count[0] < 23 && count[0] >=1)
		{
			count[0] -= 1;
		}
		else
		{
            count[0] = 23;
            count[1] = 59;
            count[2] = 59;
		}
	}

	/* Function to decrement minute field */
	public void decrementMinute()
	{
		if (count[1] < 59 && count[1] >=1)
		{
			count[1] -= 1;
		}
		else
		{
            count[2] = 59;
            count[1] = 59;
			this.decrementHour();
		}
	}

	/* Function to decrement second field */
	public void decrementSecond()
	{
		if (count[2] < 59 && count[2] >= 1)
		{
            count[2] -= 1;
		}
		else
		{
            count[2] = 59;
			this.decrementMinute();
		}
	}
}
