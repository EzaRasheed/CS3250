import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private Calculator calc;
	
	@BeforeEach
	public void setUp() throws Exception {
		calc = new Calculator(); 
	}

	@Test
	void sampleAdd() {
		int success = calc.add(4, 3);
		assertEquals(7, success);
	}
	
	@Test
	void DivideByZero() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			calc.divide(1, 0);
			});
	}
	
	@Test
	void negativeNumbers() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calc.operator(-5, -4, "-");
	});
	}
	
	@Test
	void wrongInput() {
		Assertions.assertThrows(InputMismatchException.class, () -> {
			calc.operator(4, 5, "**");
	});
	}
}