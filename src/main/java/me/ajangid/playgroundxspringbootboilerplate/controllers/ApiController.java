package me.ajangid.playgroundxspringbootboilerplate.controllers;


import handlers.ResponseHandler;
import lombok.RequiredArgsConstructor;
import me.ajangid.playgroundxspringbootboilerplate.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseHandler.generateResponse("Health is up.", HttpStatus.OK, null);

    }

}
