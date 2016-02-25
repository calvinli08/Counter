package Intern;

import static org.junit.Assert.assertEquals;

public class CounterTest {
	
	/* Testing the default Counter constructor.
	 * Pass if Counter is initialized to 0:0:0. */
	@Test
	public void testInitializeCounter_withoutParemeters()	
	{
		Counter testCounter = new Counter();
		assertEquals(0, testCounter.count.get(0));
		assertEquals(0, testCounter.count.get(1));
		assertEquals(0, testCounter.count.get(2));
	}
	
	/* Testing the parameterized Counter constructor.
	 * Pass if Counter is initialized to 17:38:29 
	 * and 3:5:9. */
	@Test
	public void testInitializeCounter_withParameters()
	{
		Counter testCounterParameterA = new Counter(17,38,29);
		assertEquals(17, testCounterParameterA.count.get(0));
		assertEquals(38, testCounterParameterA.count.get(1));
		assertEquals(29, testCounterParameterA.count.get(2));
		Counter testCounterParameterB = new Counter(3,5,9);
		assertEquals(3, testCounterParameterB.count.get(0));
		assertEquals(5, testCounterParameterB.count.get(1));
		assertEquals(9, testCounterParameterB.count.get(2));			
	}
	
	/* Testing the parameterized Counter constructor with out of bound input.
	 * Pass if Counter is passed 50:100:100 but initializes to
	 * 0:0:0 instead and prints error message. */
	@Test
	public void testInitializeCounter_outOfBoundParameters()	
	{
		Counter testCounter = new Counter(50,100,100);
		assertEquals(0, testCounter.count.get(0));
		assertEquals(0, testCounter.count.get(1));
		assertEquals(0, testCounter.count.get(2));
	}
	
	/* Testing the Reset() method
	 * Pass if Counter value is 0:0:0 after method call*/
	@Test
	public void testReset()	
	{
		
	}
	
	
	/* Increment the seconds field twice without.
	 * Pass if seconds field increases by two */
	public void testIncrementSecond_()	
	{
		
	}
	

	public void testIncrementMinute()
	{
		
	}
	
	
	public void testIncrementHour()
	{
		
	}
	
	public void testDecrementSecond()	
	{
		
	}
	

	public void testDecrementMinute()
	{
		
	}
	
	
	public void testDecrementHour()
	{
		
	}


}
