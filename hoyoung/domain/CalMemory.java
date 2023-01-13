package com.company.domain;


public class CalMemory {
	private static CalMemory instance;
	private CalStatus status;
	private Double e1 = 0.0;
	private Double e2 = 0.0;
	private Operator operator = Operator.NAN;
	private Double result = 0.0;
	private CalMemory(){};

	public static CalMemory getInstance() {
		if (instance == null) {
			instance = new CalMemory();
		}
		return instance;
	}

	public CalStatus getStatus() {
		return status;
	}

	public void setStatus(CalStatus status) {
		this.status = status;
	}

	public Double getE1() {
		return e1;
	}

	public void setE1(Double e1) {
		this.e1 = e1;
	}

	public Double getE2() {
		return e2;
	}

	public void setE2(Double e2) {
		this.e2 = e2;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		if (e1 == 0.0) {
			return "...";
		}
		if (operator == Operator.NAN) {
			return e1.toString();
		}
		if (e2 == 0.0) {
			return e1.toString() + operator.getValue();
		}
		if (result == 0.0) {
			result = Calculation.calculate(e1, e2, operator.getValue());
			return e1.toString() + operator.getValue() + e2.toString() + "=" + result.toString();
		}
		return null;
		// return e1.toString() + operator.getValue() + e2.toString() + "=" + result.toString();
	}
}
