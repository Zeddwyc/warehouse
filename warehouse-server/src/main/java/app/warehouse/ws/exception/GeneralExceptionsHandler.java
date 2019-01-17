package app.warehouse.ws.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.weddini.throttling.ThrottlingException;

import app.warehouse.ws.domain.response.ExceptionResponse;
import app.warehouse.ws.domain.response.ValidationExceptionResponse;

@ControllerAdvice
public class GeneralExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ThrottlingException.class)
	public final ResponseEntity<Object> handleRateLimitException(Exception ex, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse("Too many requests", req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.TOO_MANY_REQUESTS);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AlreadyExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(Exception ex, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		BindingResult br = ex.getBindingResult();
		List<String> errors = br.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<Object>(new ValidationExceptionResponse("Validation failure", errors),
				HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), req.getDescription(false),
				ex.getClass().getName());
		return new ResponseEntity<Object>(exResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}
