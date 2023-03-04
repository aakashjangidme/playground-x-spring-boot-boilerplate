package me.ajangid.playgroundxspringbootboilerplate.services;

import exceptions.CustomDataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductRequest;
import me.ajangid.playgroundxspringbootboilerplate.dto.ProductResponse;
import me.ajangid.playgroundxspringbootboilerplate.models.Product;
import me.ajangid.playgroundxspringbootboilerplate.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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


    public ProductResponse getProductById(long id) {
        log.info("productId : {}", id);

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            log.info("product : {}", product.get());
            return ProductResponse.builder().id(product.get().getId()).name(product.get().getName()).description(product.get().getDescription()).price(product.get().getPrice()).category(product.get().getCategory()).image(product.get().getImage()).build();
        } else {
            throw new CustomDataNotFoundException("Product not found");
        }

    }

    @Override
    public void deleteProduct(long id) {
        log.info("productId : {}", id);

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            log.info("product : {}", product.get());
            productRepository.deleteById(id);
        } else {
            throw new CustomDataNotFoundException("Could not delete Product::Product not found");
        }
    }

    @Override
    public void updateProduct(ProductRequest productRequest, long id) {
        log.info("productId : {}", id);
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            log.info("product : {}", product.get());

            Product newProduct = Product.builder().id(id).name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).category(productRequest.getCategory()).image(productRequest.getImage()).build();

            productRepository.save(newProduct);

        } else {
            throw new CustomDataNotFoundException("Product not found");
        }
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription()).price(product.getPrice()).category(product.getCategory()).image(product.getImage()).build();
    }
}
