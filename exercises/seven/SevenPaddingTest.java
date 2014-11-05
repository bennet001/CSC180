package exercises.seven;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SevenPaddingTest {
	SevenPadding test = new SevenPadding();
	@Test
	public void testPad() {
		assertEquals("1234                ", test.pad(1234, 20));
		assertEquals("Hello, the",test.pad("Hello, there!", 10));
		assertEquals("          ",test.pad(null, 10));
		assertEquals("",test.pad(null, 0));
		assertEquals("", test.pad(1234, 0));
	}

	@Test
	public void testUnpad() {
		int expected = 1234;
		int actual = test.unpad("1234         ", Integer.class);
		Assert.assertEquals(expected, actual);//(num,test.unpad("1234         ", Integer.class));
		// => Integer(1234);
		double doubleexpected = 34.45;
		double doubleactual = test.unpad("34.45    ", Double.class);
		Assert.assertEquals(doubleexpected, doubleactual, 3.14);// => Double(34.45)
		assertEquals("Howdy, Stranger!", test.unpad("Howdy, Stranger!                                   ", String.class));
		// => String("Howdy, Stranger!")
		long longexpected = 1234123412341234l;
		long longactual = test.unpad("1234123412341234    ", Long.class);
		assertEquals(longexpected,longactual);// => Long(1234123412341234)
		assertEquals("",test.unpad("", String.class));// => String("");//
	}

}
