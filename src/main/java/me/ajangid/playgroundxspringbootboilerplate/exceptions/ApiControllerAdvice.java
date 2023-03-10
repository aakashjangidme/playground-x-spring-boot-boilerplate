package me.ajangid.playgroundxspringbootboilerplate.exceptions;

import exceptions.CustomDataNotFoundException;
import exceptions.CustomParameterConstraintException;
import handlers.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import me.ajangid.playgroundxspringbootboilerplate.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler(CustomDataNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCustomDataNotFoundExceptions(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        log.error("handleCustomDataNotFoundExceptions :: ");

        return ResponseHandler.generateResponse(e.getMessage(), status, null);

    }

    @ExceptionHandler(CustomParameterConstraintException.class)
    public ResponseEntity<ApiResponse> handleCustomParameterConstraintExceptions(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 400

        return ResponseHandler.generateResponse(e.getMessage(), status, null);

    }


    @ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<ApiResponse> handleNullPointerExceptions(Exception e) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return ResponseHandler.generateResponse(e.getMessage(), status, null);
    }

    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ApiResponse> handleExceptions(Exception e) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return ResponseHandler.generateResponse(e.getMessage(), status, null);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return ResponseHandler.generateResponse("Something went wrong.", HttpStatus.BAD_REQUEST, result);

    }
}
