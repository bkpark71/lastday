package com.company.domain;

import java.util.Scanner;

public class Screen {
	final static private String resultFormat = "-------------------------------------------------------------";
	static private CalMemory memory = CalMemory.getInstance();
	private String result = "";

	public void show() {
		System.out.println("\n\n\n\n"+resultFormat + "\n" + memory + "\n" + resultFormat);
	}
}
