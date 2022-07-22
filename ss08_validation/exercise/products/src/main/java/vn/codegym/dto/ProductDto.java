package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ProductDto implements Validator {
    private Integer id;

    @NotBlank(message = "Khong duoc de trong")
    private String productName;

    private Double productPrice;
    private String productDescribe;
    private String producer;

    public ProductDto() {
    }

    public ProductDto(Integer id, String productName, Double productPrice, String productDescribe, String producer) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescribe = productDescribe;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        double price = productDto.getProductPrice();
        if (price < 0) {
            errors.rejectValue("productPrice", "price.regex", "Tien khong duoc be hon 0");
        }
    }
}
