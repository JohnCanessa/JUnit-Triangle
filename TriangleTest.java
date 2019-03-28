package junit.test.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.test.sample.Triangle.TriangleTypes;

import static org.junit.Assert.*;

/*
 * 
 */
public class TriangleTest {

	// **** constructor ****
	
	public TriangleTest() {
	}
	
	// **** ****
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("<<< setUpClass ...");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("<<< tearDownClass ...");
	}
	
	@Before
	public void setUp() {
		System.out.println("<<< setUp ...");
	}
	
	@After
	public void tearDown() {
		System.out.println("<<< tearDown ...");
	}
	
	// **** tests ****
	
	@Test
	public void testScalene() {
		System.out.println("<<< testScalene ...");
		Triangle t = new Triangle(30, 40, 50);
		String type 	= t.triangleType();
		System.out.println("<<<     type ==>" + type + "<==");
		String expected = TriangleTypes.Scalene.name();
		System.out.println("<<< expected ==>" + expected + "<==");
		assertEquals(type, expected);
	}
	
	@Test
	public void testEquilateral() {
		System.out.println("<<< testEquilateral ...");
		Triangle t = new Triangle(10, 10, 10);
		String type = t.triangleType();
		System.out.println("<<<     type ==>" + type + "<==");
		String expected = TriangleTypes.Equilateral.name();
		System.out.println("<<< expected ==>" + expected + "<==");
		assertEquals(type, expected);
	}
	
	@Test
	public void testIsosceles() {
		System.out.println("<<< testIsosceles ...");
		Triangle t = new Triangle(10, 5, 10);
		String type = t.triangleType();
		System.out.println("<<<     type ==>" + type + "<===");
		String expected = TriangleTypes.Scalene.name();
		System.out.println("<<< expected ==>" + expected + "<==");
		assertEquals(type, expected);
	}
}
