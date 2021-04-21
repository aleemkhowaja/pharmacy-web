package com.pharm.exception;

public class IllegalOperationException extends RuntimeException {

	private CommonExceptionMessage commonExceptionMessage;

	public IllegalOperationException() {
		super();
	}

	public IllegalOperationException(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

	public IllegalOperationException(String message) {
		super(message);
	}

	public IllegalOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalOperationException(Throwable cause) {
		super(cause);
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

}
