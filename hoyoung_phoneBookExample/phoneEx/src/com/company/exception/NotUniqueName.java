package com.company.exception;

public class NotUniqueName extends Exception{
	public NotUniqueName() {
		super("중복 된 이름입니다.");
	}
}
