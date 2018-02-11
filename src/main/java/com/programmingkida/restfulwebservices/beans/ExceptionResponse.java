package com.programmingkida.restfulwebservices.beans;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ExceptionResponse() {
	}

	public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
