package exercises.five;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleDateFormatConverterTest {
	SimpleDateFormatConverter tester;
	SimpleDateFormatConverter sdfTest;
	Date today = new Date(1/21/2014);
	Calendar reference;
	@Before
	public void serUp(){
		tester = new SimpleDateFormatConverter();
		sdfTest = new SimpleDateFormatConverter(tester.getSdfparseing(), new SimpleDateFormat("yyyy.MMM.dd"));
	}

	@Test
	public void testParse() {
		tester.parse("12/30/2014");
		assertEquals(tester.getSdfparseing().getCalendar().MONTH, Calendar.MONTH);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFormat() {
		tester.parse("12/30/2014");
		tester.format(new Date("12/20/2014"));
		assertEquals(tester.getSdfformatting().format(today), 
				tester.getSdfformatting().format(Calendar.MONTH));
	}

	@Test
	public void testGetSdf() {
		Assert.assertNotEquals(sdfTest.getSdf(), null);
	}

	@Test
	public void testGetSdfparseing() {
		Assert.assertEquals(sdfTest.getSdf(), sdfTest.getSdfparseing());
	}

	@Test
	public void testGetSdfformatting() {
		Assert.assertNotEquals(sdfTest.getSdf(), sdfTest.getSdfformatting());
	}

}
