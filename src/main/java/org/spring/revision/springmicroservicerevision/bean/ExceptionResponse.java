package org.spring.revision.springmicroservicerevision.bean;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
@ApiModel(description="the exception handling model")
public class ExceptionResponse {

	@Pattern(regexp = "dd-mm-yyyy")
	private final LocalDate now;
	private final String message;
	private final String description;

	public ExceptionResponse(LocalDate now, String message, String description) {
		this.now = now;
		this.message = message;
		this.description = description;

	}

	public LocalDate getNow() {
		return now;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [now=" + now + ", message=" + message + ", description=" + description + "]";
	}

}
