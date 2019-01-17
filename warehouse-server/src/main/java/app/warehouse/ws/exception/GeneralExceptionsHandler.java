package app.warehouse.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.weddini.throttling.ThrottlingException;

import app.warehouse.ws.exception.domain.response.ExceptionResponse;


@ControllerAdvice
public class GeneralExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ThrottlingException.class)
    public final ResponseEntity<Object> handleAlreadyExistsException(Exception ex, WebRequest req) {
        ExceptionResponse exResponse = 
        		new ExceptionResponse(
        				"Too many requests", 
        				req.getDescription(false),
        				ex.getClass().getName());
        return new ResponseEntity<Object>(exResponse, HttpStatus.TOO_MANY_REQUESTS);
    }
}
