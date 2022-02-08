package edu.escuelaing.arep;

import edu.escuelaing.arep.services.Convert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    Convert convert = new Convert();;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * Test number zero celsiusFahrenheit
     */
    public void testConvertCelsisuFahWithZero() {
        double answer = convert.celsiusFahrenheit(0);
        assertEquals(answer, (double)32);
    }

    /**
     *Test number zero negative celsiusFahrenheit
     */
    public void testConvertCelsisuFahWithNegZero() {
        double answer = convert.celsiusFahrenheit(-0);
        assertEquals(answer, (double)32);
    }

    /**
     *Test number positive celsiusFahrenheit
     */
    public void testConvertCelsisuFahPositive() {
        double answer = convert.celsiusFahrenheit(20);
        assertEquals(answer, (double)68);
    }

    /**
     * Test number negative celsiusFahrenheit
     */
    public void testConvertCelsisuFahNegative() {
        double answer = convert.celsiusFahrenheit(-20);
        assertEquals(answer, (double)-4);
    }

    /**
     * Test number zero fahrenheitCelsius
     */
    public void testConvertfahrenheitCelWithZero() {
        double answer = convert.fahrenheitCelsius(0);
        assertEquals(answer, (double)-17.78);
    }

    /**
     * Test number zero negative fahrenheitCelsius
     */
    public void testConvertfahrenheitCelWithNegZero() {
        double answer = convert.fahrenheitCelsius(-0);
        assertEquals(answer, (double)-17.78);
    }

    /**
     * Test number positive fahrenheitCelsius
     */
    public void testConvertfahrenheitCelPositive() {
        double answer = convert.fahrenheitCelsius(20);
        assertEquals(answer, (double)-6.67);
    }

    /**
     * Test number negative fahrenheitCelsius
     */
    public void testConvertfahrenheitCelNegative() {
        double answer = convert.fahrenheitCelsius(-20);
        assertEquals(answer, (double)-28.89);
    }
}
