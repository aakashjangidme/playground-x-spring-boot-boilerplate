package me.ajangid.playgroundxspringbootboilerplate.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;
import me.ajangid.playgroundxspringbootboilerplate.models.Product;
import org.springframework.stereotype.Service;
import me.ajangid.playgroundxspringbootboilerplate.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor//Autowires the bean
@Slf4j
public class ProductService implements IProductService {


    private final ProductRepository productRepository;


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());

    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription()).price(product.getPrice()).category(product.getCategory()).image(product.getImage()).build();
    }
}
