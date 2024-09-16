package com.example.demo.exception;

public class CustomeException extends RuntimeException {
	 String msg;
	 int id;
	public CustomeException(String msg, int id) {
		super(String.format("%s %s "
				+ "",msg,id));
		this.msg = msg;
		this.id = id;
	}
	 
}
