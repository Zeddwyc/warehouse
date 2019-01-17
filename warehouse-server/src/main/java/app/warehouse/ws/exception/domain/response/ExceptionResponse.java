package app.warehouse.ws.exception.domain.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {

	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String exception;

	public ExceptionResponse(String message, String path, String exception) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.path = path;
		this.exception = exception;
	}
}