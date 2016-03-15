/* A Java counter class requested by Maxeta's Intern Project. */

package intern;

/** Implements the Counter class specified in the Intern Project Requirements.
 * The counter increments and decrements itself in intervals of one unit;
 * either hour, minute, or second.
 * This class contains two methods for String based display
 * , displayStandard and displayMilitary.
 * Window based display capabilities are provided in the bundled CounterDisplay class.
 * <br>
 * Written on Ubuntu Linux, Eclipse Luna, Java 8 SE.
 * <br>
 * Compiled using javac.
 * <p>
 * References:
 * <br>
 * 1) Javadoc command reference page:
 * <br>
 * https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html#synopsis
 * <br>
 * 2) Javadoc formatting tutorial page:
 * <br>
 * http://www.oracle.com/technetwork/articles/java/index-137868.html
 * <br>
 * 3) Java 8 API:
 * <br>
 * https://docs.oracle.com/javase/8/docs/api/
 * <br>
 * 4) HTML paragraph tag for use in javadoc:
 * <br>
 * http://www.w3schools.com/html/html_paragraphs.asp
 * <br>
 * 5) HTML characters used in javadoc:
 * <br>
 * https://en.wikipedia.org/wiki/List_of_XML_and_HTML_character_entity_references
 * <br>
 * 6) JavaFX tutorial:
 * <br>
 * http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
 * <br>
 * 7) String.format arguments:
 * <br>
 * http://stackoverflow.com/questions/17881211/exception-in-thread-main-java-util-missingformatargumentexception-format-spec
 * <br>
 * 8) String.format flags
 * <br>
 * https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#dt
 *
 * @author Calvin Li
 * @version 1.0
 * */
public class Counter {

	/** The count array stores the counter components for easy access (H:M:S).
	 * count[0] = hour ; count[1] = minute ; count[2] = second
	 * */
	private int[] count = new int[3];

	/** Default Constructor
	 * <p>
	 * Sets the counter to 0:0:0
	 * */
	public Counter()
	{
		/* Set the fields to zero */
		count[0] = 0;
		count[1] = 0;
		count[2] = 0;
	}

	/** Parameterized Constructor
	 * <p>
	 * Initializes the counter at the time specified by h,m, and s.
	 * Constructor checks if the values of h, m, and s are
	 * within bounds; the bounds for each being:
     * <br>
	 * 23 &gt; h &ge; 0
     * <br>
	 * 59 &gt; m &ge; 0
     * <br>
	 * 59 &gt; s &ge; 0 .
	 *
	 * @param	h	value to initialize hours field to
	 * @param	m	value to initialize minutes field to
	 * @param	s	value to initialize seconds field to
	 * */
	public Counter(int h, int m, int s)
	{
		/** Checks if input is within bounds */
		if (h <= 23 && h >= 0 && m <= 59 && m >= 0 && s <= 59 && s >= 0)
		{
			count[0] = h;
			count[1] = m;
			count[2] = s;
		}
		/** Auto sets counter to 0:0:0 in event of undesirable input.*/
		else
		{
			count[0] = 0;
			count[1] = 0;
			count[2] = 0;
		}
	}

	/** Gets an array containing the counter's current time.
	 * <p>
	 * Set functions are not provided because the project instructions
	 * requested that the only allowable method to change the Counter
	 * time after initialization be incrementing/decrementing each field.
	 *
	 * @return integer array containing current time
	 * */
	public int[] get()
	{
        int[] time = count;
        return time;
	}

	/** Formats the counters current time in Standard 12-hour format
	 * and returns as String.
	 * <p>
	 * Since most display mediums can be expected to use strings,
	 * strings with format tags are provided in addition to 
	 * the JavaFX window.
	 *
	 * @return	String containing current counter time in Standard 12-hour format
	 * */
	public String displayStandard()
	{
		/* 12 hour Standard format Strings containing time.
		 * Checks if it is morning or afternoon and returns the appropriate
		 * 12-hour time with AM/PM marker.
		 * First converts the int values in count to long values. 
		 */
		long hour = Integer.toUnsignedLong(count[0]);
		long minute = Integer.toUnsignedLong(count[1]);
		long second = Integer.toUnsignedLong(count[2]);
			if (count[0] > 12)
			{
				System.out.format("%tl:%tM:%tS PM" , (hour - 12), minute, second);
				return String.format("%tl:%tM:%tS PM", (hour - 12), minute, second);
			}
			else
			{
				System.out.format("%tl:%tM:%tS AM" , hour, minute, second);
				return String.format("%tl:%tM:%tS AM", hour, minute, second);
			}
	}

	/** Formats the counter's current time in Military 24-hour format
	 * and returns as String.
	 * <p>
	 * Since most display mediums can be expected to use strings,
	 * strings with format tags are provided in addition to 
	 * the JavaFX window.
	 *
	 * @return	String containing current counter time in Military 24-hour format
     */
	public String displayMilitary()
	{
		/* 24 hour Military format Strings for use in other applications. 
		 * First converts the int values in count to long values. */
		long hour = Integer.toUnsignedLong(count[0]);
		long minute = Integer.toUnsignedLong(count[1]);
		long second = Integer.toUnsignedLong(count[2]);
		return String.format("%tH:%tM:%tS", hour, minute, second);
	}

	/* Methods used to increment and decrement the counter */

	/** Increases the value in the counter's hours field by one.
	 * <p>
	 * If the value of hours field before increment is equal to 23,
	 * rolls over the counter to 0:0:0.
	 *  */
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

	/** Increases the value in the counter's minutes field by one.
	 * <p>
	 * If value of minutes field before increment is equal to 59,
	 * calls <code>incrementHour</code>. For example, incrementing 0:59:0 yields
     * 1:0:0.
	 * */
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

	/** Increases the value in the counter's seconds field by one.
	 * <p>
	 * If value of seconds field before increment is equal to 59,
	 * calls <code>incrementMinute</code>. For example, incrementing 0:0:59
     * yields 0:1:0.
	 * */
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

	/** Decreases the value in the counter's hours field by one.
	 * <p>
	 * If value of hours field before decrement is equal to 0,
	 * sets hours to 23, and leaves minutes and seconds fields unchanged.
	 * */
	public void decrementHour()
	{
		if (count[0] < 23 && count[0] >=1)
		{
			count[0] -= 1;
		}
		else
		{
            count[0] = 23;
		}
	}

	/** Decreases the value in the counter's minutes field by one.
	 * <p>
	 * If value of minutes field before decrement is equal to 0,
	 * calls <code>decrementHour</code>, sets minutes to 59, 
	 * and leaves seconds unchanged.
     * For example, decrementing 2:0:25 yields 1:59:25.
	 * */
	public void decrementMinute()
	{
		if (count[1] < 59 && count[1] >=1)
		{
			count[1] -= 1;
		}
		else
		{
            count[1] = 59;
			this.decrementHour();
		}
	}

	/** Decreases the value in the counter's seconds field by one.
	 * <p>
	 * If value of seconds field before decrement is equal to 0,
	 * calls <code>decrementMinute</code>, and sets seconds to 59.
     * For example, decrementing 2:2:0 yields 2:1:59.
	 * */
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
