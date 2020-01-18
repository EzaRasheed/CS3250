import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalTest {

	@Test
	public void testNegDaysInBetween() {
		// Cal neg_days = new Cal();
		int calc = Cal.cal(04, 17, 04, 10, 2009);
		assertEquals(calc,  7);
		assertTrue(calc > 0);
		// expected: <-7> but was: <7>
		// expected: <true> but was: <false>
	}

	@Test
	public void testDaysInRegYear() {
		int one_year = Cal.cal(01, 01, 12, 31, 2019);
		assertTrue(one_year == 364);
		// The time between the first day of the year to the last day of the year
		// IS 364 days (True)
	}
	
	@Test
	public void testDaysInLeapYear() {
		int days_in_leap = Cal.cal(01, 01, 12, 31, 2020);
		assertTrue(days_in_leap == 365);
	}
		// Compared to the test above this one, which is not a leap year(2019),
		// this test is calculating a leap year, so it has one extra day 
	
	@Test
	public void testLeapYear() {
		int leap_year = Cal.cal(02, 29, 03, 8, 2016);
		assertFalse(leap_year != 8);
		// The time between Feb. 29th and March 8th is 8 days, so when I make leap_year
		// not equal to 8, it's false, which makes assertFalse true, passing the test
	}
	
	@Test
	public void testNonLeapYear() {
		int not_leap = Cal.cal(02, 29, 03, 8, 2015);
		assertFalse(not_leap != 8);
		// This test tests the difference in the calculation of days between
		// two dates from the test above when Feb.29 is mentioned in a leap year
		// vs. a non-leap year 
		// When Feb.29 is tested in a leap year, it is counted in the calculation
		// like in the test above, whereas in this test, 2015 is not a leap year, so
		// it correctly does not count Feb. 29th
	}
	
	@Test
	public void testDatesInLY() {
		int calc_in_leap = Cal.cal(01, 10, 11, 26, 2012);
		assertEquals(calc_in_leap, 320);
	}
	// Expected <321> but was <320>
	// There are 321 days in between these 2 days in a leap year(2012), so this test will be false,
	// since the amount 320 is how many days are in-between these two days in a non-leap year
	
	@Test
	public void testIncorrectDate() {
		int incorrect = Cal.cal(02, 17, 02, 30, 2007);
		assertEquals(incorrect, 11);
	}
	// This test should have been true because Feb.17th to Feb.28th is 11 days.
	// It should not have counted the 29th of February nor the 30th, but it incorrectly did
	// Expected <13> but was: <11>
	
	@Test
	public void testIncorrectDateWithLY() {
		int incorrect_w_LY = Cal.cal(02, 17, 02, 31, 2008);
		assertEquals(incorrect_w_LY, 12);
	}
	// This test should have been true because Feb.17th to Feb.29th is 12 days.
	// It should not have counted the 30th not 31st, but it incorrectly did
	// Expected <14> but was: <12>
	
	@Test
	public void testExtraDate() {
		int thirty_first = Cal.cal(06, 31, 9, 31, 2017);
		assertEquals(thirty_first, 92);
		// June 31st and September 31st are not actual dates, so it accurately
		// does NOT calculate them as days, whereas the end date is usually calculated
		// in the number of days between two given days
	}
	
	@Test
	public void testSameDate() {
		int same_day = Cal.cal(07, 04, 07, 04, 2013);
		assertTrue(same_day == 0);
		// The days between July 4th and July 4th are 0 days, which is True
	}
}
