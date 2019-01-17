package app.warehouse.ws.domain.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ValidationExceptionResponse {

	private LocalDateTime timestamp;
	private String message;
	private List<String> details;

	public ValidationExceptionResponse(String message, List<String> details) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.details = details;
	}
}
