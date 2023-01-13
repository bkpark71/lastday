package com.company.domain;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.company.Exceptions.InvalidOperationException;

public class InputHandle {
	final static private String promptE1 = "첫 번 째 수를 입력하세요. : ";
	final static private String promptE2 = "두 번 째 수를 입력하세요. : ";
	final static private String promptOP = "연산자를 입력하세요. : ";
	final static private Scanner sc = new Scanner(System.in);
	static private CalMemory memory = CalMemory.getInstance();

	public static void getE1FromUser() {
		System.out.print(promptE1);
		memory.setE1(sc.nextDouble());
	}

	public static void getE2FromUser() {
		System.out.print(promptE2);
		memory.setE2(sc.nextDouble());
	}

	public static void getOPFromUser() throws InvalidOperationException {
		System.out.print(promptOP);
		String str = sc.next();
		System.out.println(str);
		if (str.equals("+")  || str.equals("-") || str.equals("*") || str.equals("/")) memory.setOperator(Operator.getOp(str));
		else throw new InvalidOperationException();
	}
}
