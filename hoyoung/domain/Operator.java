package com.company.domain;

public enum Operator {
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	NAN(null);

	private final String value;

	Operator(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Operator getOp(String input) {
		switch (input) {
			case "+" -> {
				return PLUS;
			}
			case "-" -> {
				return MINUS;
			}
			case "*" -> {
				return MULTIPLY;
			}
			case "/" -> {
				return DIVIDE;
			}
			default -> {
				return NAN;
			}
		}

	}
}
