package com.samcm.exception;

 
public class MaxRecordExceedException extends RuntimeException {

	private CommonExceptionMessage commonExceptionMessage;

	public MaxRecordExceedException() {
		super();
	}

	public MaxRecordExceedException(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

	public MaxRecordExceedException(String message) {
		super(message);
	}

	public MaxRecordExceedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaxRecordExceedException(Throwable cause) {
		super(cause);
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

}
