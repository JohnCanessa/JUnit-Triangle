package junit.test.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.test.sample.Triangle.TriangleTypes;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
		String expected = TriangleTypes.Isosceles.name();
		System.out.println("<<< expected ==>" + expected + "<==");
		assertEquals(type, expected);
	}
	
	// **** tests to read n triangles from file ****
	@Test
	public void testTriangles() {
		
		// **** ****
		System.out.println("<<< testTriangles ...");

		// **** open file with test cases (one per line) ****
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("c:\\Temp\\triangles.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// **** read count of triangles ****
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("<<< line ==>" + line + "<==");
		
		// **** convert to integer ****
		int n = Integer.parseInt(line);
		System.out.println("<<< count: " + n);

		// **** loop once per triangle ****
		for (int i = 0; i < n; i++) {

			// **** read sides and triangle type ****
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("<<< line ==>" + line + "<==");
		
			// **** split the line ****
			String s[] = line.split(" ");
			
			// **** extract triangle sides ****
			int a = Integer.parseInt(s[0]);			
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			System.out.println("<<< a: " + a + " b: " + b + " c: " + c);
			
			// **** extract triangle type ****
			String expected = null;
			switch (s[3]) {
			case "I":
				expected = TriangleTypes.Isosceles.name();
				break;
			case "E":
				expected = TriangleTypes.Equilateral.name();
				break;
			case "S":
				expected = TriangleTypes.Scalene.name();
				break;
			}
			System.out.println("<<< expected ==>" + expected + "<===");
			
			// **** instantiate triangle****
			Triangle t = new Triangle(a, b, c);

			// **** compute the triangle type ****
			String type = t.triangleType();
			System.out.println("<<<     type ==>" + type + "<===");
			
			// **** ****
			assertEquals(type, expected);
		}

		// **** close file ****
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
