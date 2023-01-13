package com.company.exception;

public class InvalidMenuSelect extends Exception{
	public InvalidMenuSelect() {
		super("잘못된 메뉴 입력입니다. 다시 입력 해 주세요.");
	}
}
