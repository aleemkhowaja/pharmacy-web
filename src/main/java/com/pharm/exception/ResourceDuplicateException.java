package com.pharm.exception;

/**
 * For HTTP 404 errros
 */
public class ResourceDuplicateException extends RuntimeException {

	private static final long serialVersionUID = -6656676401730511867L;
	private CommonExceptionMessage commonExceptionMessage;

	public ResourceDuplicateException() {
		super();
	}

	public ResourceDuplicateException(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

	public ResourceDuplicateException(String message) {
		super(message);
	}

	public ResourceDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceDuplicateException(Throwable cause) {
		super(cause);
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}

}
