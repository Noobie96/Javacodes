package Exception;

import java.io.IOException;

class calci extends Calculator {
	int output;
	int a, b;
	static int num1, num2;
	static int result;

	@Override
	void add() {
		output = a + b;
		System.out.println("output:" + output);

	}

	@Override
	protected void sub() {
		output = a - b;
		System.out.println("output:" + output);

	}

	int divide(int a, int b) {
		try {
			result = a / b;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static void main(String args[]) throws IOException {

		calci cal = new calci();
		cal.divide(10, 0);
	}
}
