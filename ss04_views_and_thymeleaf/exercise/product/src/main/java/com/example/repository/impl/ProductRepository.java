package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone", 100.0, "Normal", "china"));
        productList.add(new Product(2, "nokia", 50.0, "Vip", "america"));
        productList.add(new Product(3, "samsung", 150.0, "Normal", "vn"));
    }

    String[] productDescribeList = new String[]{"Normal", "Vip"};

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product FindById(int id) {
        for (Product item: productList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String[] productDescribe() {
        return productDescribeList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        for (Product item: productList) {
            if (item.getId() == id) {
                item.setProductName(product.getProductName());
                item.setProductPrice(product.getProductPrice());
                item.setProductDescribe(product.getProductDescribe());
                item.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void delete(int id) {
        productList.removeIf(item -> item.getId() == id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Product item: productList) {
            if (item.getProductName().contains(name)) {
                products.add(item);
            }
        }
        return products;
    }
}
