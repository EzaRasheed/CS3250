import java.util.InputMismatchException;

public class Calculator {

	public int add(int a, int b)
	{
		int first_group = a + b;
		return (first_group);
	}
	
	public int divide(int a, int b) {
		if (a < 0 || b <0) {
			throw new IllegalArgumentException("a and b should not be negative numbers");
		}
		int div = (a / b);
		return div;
	}

	public int subtract(int a, int b) {
		if (a < 0 || b <0) {
			throw new IllegalArgumentException("a and b should not be negative numbers");
		}
		/*
		if (a == (int)a || b != (int)b) {
			throw new IllegalArgumentException("a and b should be ints");
		}
		*/
		int sub = a - b;
		return sub;
	}

	public int multiply(int a, int b)
	{
	
		int mult = a + b;
		return mult;
	}

	public int operator(int a, int b, String c) {
		if (c == "+") {
			int addition = add(a,b);
			return addition;
		}
		if (c == "-") {
			int s = subtract(a,b);
			return s; 
			
		}
		if (c == "/") {
			int d = divide(a,b);
			return d;
		}
		if (c == "*") {
			int m = multiply(a,b);
			return m;
		}
		if ((c != "+") && (c != "-") && (c != "/") && (c != "*")) {
			throw new InputMismatchException("c is not one of the four operators specified.");
		}
		return 0;
	}
}