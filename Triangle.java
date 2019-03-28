package junit.test.sample;


/*
 * 
 */
public class Triangle {

	// **** ****
	
	enum TriangleTypes {
		Equilateral, Isosceles, Scalene
	}
	
	// **** attributes ****
	
	int 	a;
	int 	b;
	int 	c;
	
	// **** constructor ****

	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// **** methods ****
	
	public String triangleType() {
		
		String	type	= "";
		String	errMsg	= "";
		
		// **** check for invalid side sizes ****
		
		if (a <= 0) {
			errMsg = "a <= 0";
		}
		if (b <= 0) {
			errMsg = "b <= 0";
		}
		if (c <= 0) {
			errMsg = "c <= 0";
		}
		
		// **** check for a side too long ****
		
		if ((a + b <= c) || (b + c <= a) || (c + a <= b)) {
			errMsg = String.format("not a valid triangle a: " + a + " b: " + b + " c: " + c);
		}
		
		// **** classify the triangle (if needed) ****
		
		if (errMsg.length() != 0) {
			type = errMsg;
		} else {
			if ((a == b) && (b == c)) {
				type = TriangleTypes.Equilateral.name();
			} else if ((a == b) || (b == c) || (c == a)) {
				type = TriangleTypes.Isosceles.name();
			} else {
				type = TriangleTypes.Scalene.name();
			}	
		}

		// **** ****
		
		return type;
	}
	
}
