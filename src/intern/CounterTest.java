/* This is a JUnit test stub for the Counter class.
 *
 * assertEquals(x),...) function learned from:
 * http:stackoverflow.com/questions/1811103/java-junit-the-method-x-is-ambiguous-for-type-y
 *
 * */

package intern;

import static org.junit.Assert.assertArrayEquals;
import org.junit.*;
import intern.Counter;

public class CounterTest {

	/* Main method to facilitate running tests from the terminal */
	public static void main(String args[])
	{
		org.junit.runner.JUnitCore.main("intern.CounterTest");
	}

	/* Testing the default Counter constructor.
	 * Pass if Counter is initialized to 0:0:0. */
	@Test
	public void testInitializeCounter_withoutParameters()
	{
		Counter testCounter = new Counter();
		int[] needed = {0, 0, 0};
		assertArrayEquals(testCounter.get(), needed);
	}

	/* Testing the parameterized Counter constructor.
	 * Pass if Counter is initialized to 17:38:29. */
	@Test
	public void testInitializeCounter_withParameters()
	{
		Counter testCounter = new Counter(17,38,29);
		int[] needed = {17, 38, 29};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Testing the parameterized Counter constructor with out of bound input.
	 * Pass if Counter is passed 50:100:100 but initializes to
	 * 0:0:0 instead and prints error message. */
	@Test
	public void testInitializeCounter_outOfBoundParameters()
	{
		Counter testCounter = new Counter(50,100,100);
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}
	
	/* Testing if the get function.
	 * Pass if result is 1:1:1. */
	@Test
	public void testGet()
	{
		Counter testCounter = new Counter(1,1,1);
		int[] needed = {1,1,1};
		assertArrayEquals(testCounter.get(),needed);
	}
	
	/* Increment the seconds field without causing other fields to change.
	 * Pass if result is 0:0:1. */
	@Test
	public void testIncrementSecond_()
	{
		Counter testCounter = new Counter();
		testCounter.incrementSecond();
		int[] needed = {0,0,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increment the minutes field without causing other fields to change.
	 * Pass if result is 0:1:0. */
	@Test
	public void testIncrementMinute()
	{
		Counter testCounter = new Counter();
		testCounter.incrementMinute();
		int[] needed = {0,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increment the hours field without causing other fields to change.
	 * Pass if result is 1:0:0. */
	@Test
	public void testIncrementHour()
	{
		Counter testCounter = new Counter();
		testCounter.incrementHour();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the seconds field without causing other fields to change.
	 * Pass if result is 1:1:0. */
	@Test
	public void testDecrementSecond()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementSecond();
		int[] needed = {1,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the minutes field without causing other fields to change.
	 * Pass if result is 1:0:1. */
	@Test
	public void testDecrementMinute()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementMinute();
		int[] needed = {1,0,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the hours field without causing other fields to change.
	 * Pass if result is 0:1:1. */
	@Test
	public void testDecrementHour()
	{
		Counter testCounter = new Counter(1,1,1);
		testCounter.decrementHour();
		int[] needed = {0,1,1};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increase the seconds field until it causes the minutes field to increment.
	 * Pass if result is 0:1:0 */
	@Test
	public void testIncrementMinute_usingSeconds()
	{
		Counter testCounter = new Counter(0,0,59);
		testCounter.incrementSecond();
		int[] needed = {0,1,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increase the minutes field until it causes the hours field to increment.
	 * Pass if result is 1:0:0. */
	@Test
	public void testIncrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(0,59,0);
		testCounter.incrementMinute();
		int[] needed = {1,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increase the seconds field until it causes the hours field to increment.
	 * Pass if result is 1:0:0. */
	@Test
	public void testIncrementHours_usingSeconds()
	{
		Counter testCounter = new Counter(0,59,59);
		testCounter.incrementSecond();
		int[] needed = {1, 0, 0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the minutes field until it causes the hours field to decrement.
	 * Pass if result is 0:59:59. */
	@Test
	public void testDecrementHours_usingMinutes()
	{
		Counter testCounter = new Counter(1,0,0);
		testCounter.decrementMinute();
		int[] needed = {0,59,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the seconds field until it causes the hours field to decrement.
	 * Pass if result is 0:59:59. */
	@Test
	public void testDecrementHours_usingSeconds()
	{
		Counter testCounter = new Counter(1,0,0);
		testCounter.decrementSecond();
		int[] needed = {0,59,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Decrement the seconds field until it causes the minutes field to decrement.
	 * Pass if result is 0:0:59. */
	@Test
	public void testDecrementMinutes_usingSeconds()
	{
		Counter testCounter = new Counter(0,1,0);
		testCounter.decrementSecond();
		int[] needed = {0,0,59};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increase the hours field until it causes the counter to roll over.
	 * Pass if result is 0:0:0. */
	@Test
	public void testRollover_usingHours()
	{
		Counter testCounter = new Counter(23,0,0);
		testCounter.incrementHour();
		int[] needed = {0, 0, 0};
		assertArrayEquals(testCounter.get(), needed);
	}

	/* Increase the minutes field until it causes the counter to roll over.
	 * Pass if result is 0:0:0. */
	@Test
	public void testRollover_usingMinutes()
	{
		Counter testCounter = new Counter(23,59,0);
		testCounter.incrementMinute();
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

	/* Increase the seconds field until it causes the counter to roll over.
	 * Pass if result is 0:0:0. */
	@Test
	public void testRollover_usingSeconds()
	{
		Counter testCounter = new Counter(23,59,59);
		testCounter.incrementSecond();
		int[] needed = {0,0,0};
		assertArrayEquals(testCounter.get(),needed);
	}

}
