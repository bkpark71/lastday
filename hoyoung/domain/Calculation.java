package com.company.domain;


public class Calculation {
	public static Double calculate(Double e1, Double e2, String userInputOp) throws ArithmeticException{
		Operator inputOp = Operator.getOp(userInputOp);
		switch (inputOp) {
			case PLUS -> {
				return plus(e1, e2);
			}
			case MINUS -> {
				return minus(e1, e2);
			}
			case MULTIPLY -> {
				return multiply(e1, e2);
			}
			case DIVIDE -> {
				return divide(e1, e2);
			}
			default ->  {
				return 0.0;
			}
		}
	}

	private static Double plus(Double e1, Double e2) throws ArithmeticException{
		return e1 + e2;
	}

	private static Double minus(Double e1, Double e2) throws ArithmeticException{
		return e1 - e2;
	}

	private static Double multiply(Double e1, Double e2) throws ArithmeticException{
		return  e1 * e2;
	}

	private static Double divide(Double e1, Double e2) throws ArithmeticException {
		return e1 / e2;
	}
}
