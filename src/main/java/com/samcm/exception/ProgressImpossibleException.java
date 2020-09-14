package com.samcm.exception;

/**
 * For HTTP 404 errros
 */
public class ProgressImpossibleException extends RuntimeException {

	private CommonExceptionMessage commonExceptionMessage;

	public ProgressImpossibleException() {
		super();
	}

	public ProgressImpossibleException(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

	public ProgressImpossibleException(String message) {
		super(message);
	}

	public ProgressImpossibleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProgressImpossibleException(Throwable cause) {
		super(cause);
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

}
