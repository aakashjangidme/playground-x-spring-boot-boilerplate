package me.ajangid.playgroundxspringbootboilerplate.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductRequest;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;
import me.ajangid.playgroundxspringbootboilerplate.models.Product;
import me.ajangid.playgroundxspringbootboilerplate.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).category(productRequest.getCategory()).image(productRequest.getImage()).build();
        productRepository.save(product);
        log.info("Saved product : {}", product.getId());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription()).price(product.getPrice()).category(product.getCategory()).image(product.getImage()).build();
    }
}
