package junit.test.sample;

import java.util.Scanner;

/*
 * 
 */
public class Solution {

	/*
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>> a: ");
		int a = sc.nextInt();
		System.out.print(">>> b: ");		
		int b = sc.nextInt();
		System.out.print(">>> c: ");				
		int c = sc.nextInt();	
		System.out.println("<<< a: " + a + " b: " + b + " c: " + c);
		Triangle t = new Triangle(a, b, c);
		System.out.println("<<< t is: " + t.triangleType());
		sc.close();
	}

}
