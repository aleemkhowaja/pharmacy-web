package com.pharm.exception;

public class WrongValuesFound  extends RuntimeException{
	private CommonExceptionMessage commonExceptionMessage;

	public WrongValuesFound() {
		super();
	}

	public WrongValuesFound(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

	public WrongValuesFound(String message) {
		super(message);
	}

	public WrongValuesFound(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongValuesFound(Throwable cause) {
		super(cause);
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}
}
