package me.ajangid.playgroundxspringbootboilerplate.models;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//@Document(value = "product")
@Entity
@Table(name = "products")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Product name is required.")
    private String name;

    @NotNull(message = "Product Description is required.")
    private String description;

    @NotNull(message = "Product Category is required.")
    private String category;

    @Pattern(regexp = ".*\\.jpg|.*\\.jpeg|.*\\.png", message = "Only images of type JPEG or PNG are supported.")
    private String image;

    @NotNull(message = "Product Price is required.")
    @Pattern(regexp = "^\\d{1,5}$", message = "Invalid price value")
    @Min(value = 1, message = "The price of product must be greater than 0.")
    private String price;

}
