package sn.touba.xadimousalih.declarationtimbreservice.exception; 

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DeclarationNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(DeclarationNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletResponse res, AccessDeniedException e) throws IOException {
        LOG.error("ERROR", e);
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(HttpServletResponse res, IllegalArgumentException e) throws IOException {
        LOG.error("ERROR", e);
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res, Exception e) throws IOException {
        LOG.error("ERROR", e);
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

}
