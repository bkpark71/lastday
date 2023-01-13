package com.company.exception;

public class HasNoName extends Exception{
	public HasNoName() {
		super("이름이 없습니다.");
	}
}
