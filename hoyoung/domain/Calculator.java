package com.company.domain;

import java.security.spec.ECField;

import com.company.Exceptions.InvalidOperationException;

public class Calculator {
	private Screen screen;
	private CalMemory memory;
	private InputHandle inputHandle;
	private CalStatus status;

	public Calculator() {
		screen = new Screen();
		memory = CalMemory.getInstance();
		inputHandle = new InputHandle();
		status = CalStatus.START;
	}

	public void startCalculate() {

		while (status != CalStatus.DONE) {
			try {
				if (status == CalStatus.START)
					status = CalStatus.INPUTE1;

				if (status == CalStatus.INPUTE1) {
					screen.show();
					InputHandle.getE1FromUser();
					status = CalStatus.INPUTOP;
					continue;
				}

				if (status == CalStatus.INPUTOP) {
					screen.show();
					InputHandle.getOPFromUser();
					status = CalStatus.INPUTE2;
					continue;
				}
				if (status == CalStatus.INPUTE2) {
					screen.show();
					InputHandle.getE2FromUser();
					status = CalStatus.ENDING;
					continue;
				}
				if (status == CalStatus.ENDING) {
					screen.show();
					System.out.println("Calculation End");
					status = CalStatus.DONE;
				}
			}
			catch (InvalidOperationException e) {
				status = CalStatus.INPUTOP;
				System.out.println("Wrong Operation, Please Input Again");
				continue;
				}
			catch (Exception e) {
					System.out.println("error message : " + e);
				}

		}
	}
}
