

package intern;

import static org.junit.Assert.assertArrayEquals;
import org.junit.*;
import intern.Counter;

/** JUnit test stub class for the Counter class.
 * <br>
 * Validates the functionality of the Counter class through JUnit Tests.
 * There is a test for each method within the class, as well as for each
 * possible rollover situation. Rollover situation being when, for example,
 * the seconds field hits 60, causing the minutes field to increment, and
 * resetting the seconds field to 0.
 * <br>
 * References:
 * <br>
 * assertArrayEquals(x),...) function:
 * <br>
 * http://junit.org/javadoc/latest/org/junit/Assert.html#assertArrayEquals%28int[],%20int[]%29
 * <br>
 * HTML characters used in javadoc:
 * <br>
 * https://en.wikipedia.org/wiki/List_of_XML_and_HTML_character_entity_references
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

	/** Tests the default Counter constructor.
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

	/** Tests the parameterized Counter constructor.
	 * <br>
	 * Call the parameterized constructor with h = 17,
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

	/** Tests the parameterized Counter constructor with out of bound input.
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

	/** Tests the <code>get</code> function.
	 * <br>
	 * Initiate an instance of the Counter class at 1:1:1,
	 * and call <code>get</code>.
	 * <br>
	 * Passes if result is 1:1:1. */
	@Test
	public void testGet()
	{
		Counter testCounter = new Counter(1,1,1);
		int[] needed = {1,1,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests <code>incrementSecond</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 0:0:0 and call
	 * <code>incrementSecond</code>.
	 * <br>
	 * Passes if result is 0:0:1. */
	@Test
	public void testIncrementSecond_()
	{
		Counter testCounter = new Counter();
		testCounter.incrementSecond();
		int[] needed = {0,0,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests <code>incrementMinute</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 0:1:0 and call
	 * <code>incrementMinute</code>.
	 * <br>
	 * Passes if result is 0:0:1. */
	@Test
	public void testIncrementMinute()
	{
		Counter testCounter = new Counter();
		testCounter.incrementMinute();
		int[] needed = {0,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests <code>incrementHour</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 1:0:0 and call
	 * <code>incrementMinute</code>.
	 * <br>
	 * Passes if result is 0:0:1. */
	@Test
	public void testIncrementHour()
	{
		Counter testCounter = new Counter();
		testCounter.incrementHour();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests <code>decrementSecond</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 1:1:1 and call
	 * <code>decrementSecond</code>.
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

	/** Tests <code>decrementMinute</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 1:1:1 and call
	 * <code>decrementMinute</code>.
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

	/** Tests <code>decrementHour</code> function without
	 * causing other fields to change.
	 * <br>
	 * Initialize the Counter to 1:1:1 and call
	 * <code>decrementHour</code>.
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

	/** Tests if the minutes field increments when seconds field hits 60.
	 * <br>
	 * Initialize an instance of counter to 0:0:59 and
	 * call <code>incrementSecond</code>.
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

	/** Tests if the hours field increments when minutes field hits 60.
	 * <br>
	 * Initializes an instance of counter to 0:59:0 and
	 * calls <code>incrementMinute</code>.
	 * <br>
	 * Passes if result is 0:1:0 */
	@Test
	public void testIncrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(0,59,0);
		testCounter.incrementMinute();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests if hours field can be incremented by incrementing seconds field.
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

	/** Tests if hours field can be decremented by decrementing minutes field.
	 * <br>
	 * Initializes an instance of counter to 1:0:0 and
	 * calls <code>decrementMinute</code>.
	 * <br>
	 * Passes if result is 0:59:59. */
	@Test
	public void testDecrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(1,0,0);
		testCounter.decrementMinute();
		int[] needed = {0,59,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/** Tests if hours field can be decremented by decrementing seconds field.
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

	/** Tests if minutes field can be decremented by decrementing seconds field.
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

	/** Tests if incrementing the hours field causes the counter to roll over.
	 * <br>
	 * Initialize an instance of counter to 23:0:0
	 * and call <code>incrementHour</code>.
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

	/** Tests if incrementing the minutes field causes the counter to roll over.
	 * <br>
	 * Initialize an instance of counter to 23:59:0
	 * and call <code>incrementMinute</code>.
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

	/** Tests if incrementing the seconds field causes the counter to roll over.
	 * <br>
	 * Initialize an instance of counter to 23:59:59
	 * and call <code>incrementSecond</code>.
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
