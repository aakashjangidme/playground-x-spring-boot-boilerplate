package me.ajangid.playgroundxspringbootboilerplate.controllers;


import handlers.ResponseHandler;
import lombok.RequiredArgsConstructor;
import me.ajangid.playgroundxspringbootboilerplate.dto.ApiResponse;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;
import me.ajangid.playgroundxspringbootboilerplate.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
@RequiredArgsConstructor
@Validated
public class ApiController {

    private final ProductService productService;


    @GetMapping("health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseHandler.generateResponse("Health is up.", HttpStatus.OK, null);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();

        return ResponseHandler.generateResponse("Product(s) fetched successfully.", HttpStatus.OK, products);
    }

}
