/* A JUnit test stub to test the Counter class, as requested by the Maxeta Intern Project. */

package intern;

import static org.junit.Assert.assertArrayEquals;
import org.junit.*;
import intern.Counter;

/** JUnit test stub class for the Counter class.
 * <br>
 * Validates the functionality of the Counter class through JUnit tests.
 * There is a test for each method within the class, as well as for each
 * possible rollover situation. A rollover situation occurs when incrementing one
 * field beyond it's upper bound causes other fields to change. For example,
 * incrementing the seconds field 59, causing the minutes field to increment, and
 * resetting the seconds field to 0.
 * <br>
 * References:
 * <br>
 * 1) assertArrayEquals function:
 * <br>
 * http://junit.org/javadoc/latest/org/junit/Assert.html#assertArrayEquals%28int[],%20int[]%29
 * <br>
 * 2) HTML characters used in javadoc:
 * <br>
 * https://en.wikipedia.org/wiki/List_of_XML_and_HTML_character_entity_references
 * <br>
 * 3) javadoc author/version tags:
 * <br>
 * http://javaworkshop.sourceforge.net/chapter4.html
 *
 * @author Calvin Li
 * @version 1.0
 * */
public class CounterTest {

	/** Main method
    * <br>
    * Contains a line to start the JUnit test runner for the
    * CounterTest class from the terminal, removing the need to
    * add extra arguments to the "java" command.
    * To start the JUnit Tests, navigate to the
    * counter/src directory and enter &lt;java intern.CounterTest&gt;
    *
    * @param    args[]  contains any text entered in terminal prompt
    */
	public static void main(String args[])
	{
		org.junit.runner.JUnitCore.main("intern.CounterTest");
	}

	/** Default Constructor. 
	 * <br>
	 * Initializes an instance of CounterTest to run test methods. 
	 * The JUnit runner constructs a fresh instance of CounterTest
	 * for each test it runs, there is no need for the user to initialize
	 * anything.	
	 */
	public CounterTest() {};
	
	/** Tests whether the the default Counter constructor can initialize
     * an instance of counter to 0:0:0 without parameters passed to it.
	 * <br>
	 * Initializes an instance of the Counter class
	 * by calling the default constructor.
	 * <br>
	 * Passes if result is 0:0:0.
	 * */
	@Test
	public void testInitializeCounter_withoutParameters()
	{
		Counter testCounter = new Counter();
		int[] needed = {0, 0, 0};
		assertArrayEquals(testCounter.get(), needed);
	}

	/** Tests whether the the parameterized Counter constructor can initialize
     * a counter instance to the requested time.
	 * <br>
	 * Calls the parameterized constructor with h = 17,
	 * m = 38, s = 29.
	 * <br>
	 * Passes if result is 17:38:29. */
	@Test
	public void testInitializeCounter_withParameters()
	{
		Counter testCounter = new Counter(17,38,29);
		int[] needed = {17, 38, 29};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the the parameterized Counter constructor can detect and deny
     * a request to initialize a counter to out-of-bound values.
	 * <br>
	 * Passes if arguments given to parameterized
	 * constructor is 50:100:100, but counter initializes to
	 * 0:0:0 instead. */
	@Test
	public void testInitializeCounter_outOfBoundParameters()
	{
		Counter testCounter = new Counter(50,100,100);
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether  the <code>get</code> function can obtain the array containing
     * the counter's current time.
	 * <br>
	 * Initializes an instance of the Counter class at 1:1:1,
	 * and calls <code>get</code>.
	 * <br>
	 * Passes if result is 1:1:1. */
	@Test
	public void testGet()
	{
		Counter testCounter = new Counter(1,1,1);
		int[] needed = {1,1,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>incrementSecond</code> function can increase the value of
     * the seconds field by one.
	 * <br>
	 * Initializes the Counter to 0:0:0 and calls
	 * <code>incrementSecond</code>. Does not test if
     * incrementing the seconds field past 59 can cause other fields to increment.
	 * <br>
	 * Passes if result is 0:0:1. */
	@Test
	public void testIncrementSecond()
	{
		Counter testCounter = new Counter();
		testCounter.incrementSecond();
		int[] needed = {0,0,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>incrementMinute</code> function can increase the value of
     * the minutes field by one.
	 * <br>
	 * Initializes the Counter to 0:0:0 and calls
	 * <code>incrementMinute</code>. Does not test if
     * incrementing the minutes field past 59 can cause other fields to increment.
	 * <br>
	 * Passes if result is 0:1:0. */
	@Test
	public void testIncrementMinute()
	{
		Counter testCounter = new Counter();
		testCounter.incrementMinute();
		int[] needed = {0,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>incrementHour</code> function can increase the value of
     * the hours field by one.
	 * <br>
	 * Initializes the Counter to 0:0:0 and calls
	 * <code>incrementHour</code>. Does not test if
     * incrementing the hours field past 23 can cause counter to rollover.
	 * <br>
	 * Passes if result is 1:0:0. */
	@Test
	public void testIncrementHour()
	{
		Counter testCounter = new Counter();
		testCounter.incrementHour();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>decrementSecond</code> function can decrease the
     * value of the seconds field by one.
	 * <br>
	 * Initializes the Counter to 1:1:1 and calls
	 * <code>decrementSecond</code>. Does not test if decrementing
     * the seconds field past 0 can cause other fields to decrement.
	 * <br>
	 * Passes if result is 1:1:0. */
	@Test
	public void testDecrementSecond()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementSecond();
		int[] needed = {1,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>decrementMinute</code> function can decrease the
     * value of the minutes field by one.
	 * <br>
	 * Initializes the Counter to 1:1:1 and calls
	 * <code>decrementMinute</code>. Does not test if decrementing
     * the minutes field past 0 can cause other fields to decrement.
	 * <br>
	 * Passes if result is 1:0:1 */
	@Test
	public void testDecrementMinute()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementMinute();
		int[] needed = {1,0,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether the <code>decrementHour</code> function can decrease the
     * value of the hours field by one.
	 * <br>
	 * Initializes the Counter to 1:1:1 and calls
	 * <code>decrementHour</code>. Does not test if decrementing
     * the hours field past 0 can cause other fields to decrement.
	 * <br>
	 * Passes if result is 0:1:1. */
	@Test
	public void testDecrementHour()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementHour();
		int[] needed = {0,1,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether minutes field can be incremented by incrementing seconds field.
	 * <br>
	 * Initializes an instance of counter to 0:0:59 and
	 * calls <code>incrementSecond</code>.
	 * <br>
	 * Passes if result is 0:1:0 */
	@Test
	public void testIncrementMinute_usingSeconds()
	{
		Counter testCounter = new Counter(0,0,59);
		testCounter.incrementSecond();
		int[] needed = {0,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether hours field can be incremented by incrementing minutes field.
	 * <br>
	 * Initializes an instance of counter to 0:59:0 and
	 * calls <code>incrementMinute</code>.
	 * <br>
	 * Passes if result is 1:0:0 */
	@Test
	public void testIncrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(0,59,0);
		testCounter.incrementMinute();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether hours field can be incremented by incrementing seconds field.
	 * <br>
	 * Initializes an instance of counter to 0:59:59 and
	 * calls <code>incrementSecond</code>.
	 * <br>
	 * Passes if result is 1:0:0 */
	@Test
	public void testIncrementHours_usingSeconds()
	{
		Counter testCounter = new Counter(0,59,59);
		testCounter.incrementSecond();
		int[] needed = {1, 0, 0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether hours field can be decremented by decrementing minutes field.
	 * <br>
	 * Initializes an instance of counter to 1:0:0 and
	 * calls <code>decrementMinute</code>.
	 * <br>
	 * Passes if result is 0:59:0. */
	@Test
	public void testDecrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(1,0,0);
		testCounter.decrementMinute();
		int[] needed = {0,59,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether hours field can be decremented by decrementing seconds field.
	 * <br>
	 * Initializes an instance of counter to 1:0:0 and
	 * calls <code>decrementSecond</code>.
	 * <br>
	 * Passes if result is 0:59:59. */
	@Test
	public void testDecrementHours_usingSeconds()
	{
		Counter testCounter = new Counter(1,0,0);
		testCounter.decrementSecond();
		int[] needed = {0,59,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether minutes field can be decremented by decrementing seconds field.
	 * <br>
	 * Initializes an instance of counter to 0:1:0 and
	 * calls <code>decrementSecond</code>.
	 * <br>
	 * Passes if result is 0:0:59. */
	@Test
	public void testDecrementMinutes_usingSeconds()
	{
		Counter testCounter = new Counter(0,1,0);
		testCounter.decrementSecond();
		int[] needed = {0,0,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether incrementing the hours field can cause the counter to roll over.
	 * <br>
	 * Initializes an instance of counter to 23:0:0
	 * and calls <code>incrementHour</code>.
	 * <br>
	 * Passes if result is 0:0:0. */
	@Test
	public void testRollover_usingHours()
	{
		Counter testCounter = new Counter(23,0,0);
		testCounter.incrementHour();
		int[] needed = {0, 0, 0};
		assertArrayEquals(testCounter.get(), needed);
	}

	/** Tests whether incrementing the minutes field can cause the counter to roll over.
	 * <br>
	 * Initializes an instance of counter to 23:59:0
	 * and calls <code>incrementMinute</code>.
	 * <br>
	 * Passes if result is 0:0:0. */
	@Test
	public void testRollover_usingMinutes()
	{
		Counter testCounter = new Counter(23,59,0);
		testCounter.incrementMinute();
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests whether incrementing the seconds field can cause the counter to roll over.
	 * <br>
	 * Initializes an instance of counter to 23:59:59
	 * and calls <code>incrementSecond</code>.
	 * <br>
	 * Passes if result is 0:0:0. */
	@Test
	public void testRollover_usingSeconds()
	{
		Counter testCounter = new Counter(23,59,59);
		testCounter.incrementSecond();
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}
}
