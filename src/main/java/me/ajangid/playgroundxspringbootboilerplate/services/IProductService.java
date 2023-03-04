package me.ajangid.playgroundxspringbootboilerplate.services;

import me.ajangid.playgroundxspringbootboilerplate.dto.ProductRequest;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getAllProducts();

    public void createProduct(ProductRequest productRequest);

    public ProductResponse getProductById(long id);

    public void deleteProduct(long id);

    public void updateProduct(ProductRequest productRequest, long id);
}
