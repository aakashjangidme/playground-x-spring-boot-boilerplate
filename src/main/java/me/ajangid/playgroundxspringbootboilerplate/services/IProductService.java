package me.ajangid.playgroundxspringbootboilerplate.services;

import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getAllProducts();
}
