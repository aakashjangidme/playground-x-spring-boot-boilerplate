package handlers;


import me.ajangid.playgroundxspringbootboilerplate.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * Handles the api response, just pass message, http status & response object (if any)
 */
public class ResponseHandler {
    public static ResponseEntity<ApiResponse> generateResponse(String message, HttpStatus status, Object responseObj) {

        ApiResponse res = ApiResponse.builder().data(responseObj).status(status.value()).message(message).timestamp(new Date()).build();
        return new ResponseEntity<>(res, status);
    }
}