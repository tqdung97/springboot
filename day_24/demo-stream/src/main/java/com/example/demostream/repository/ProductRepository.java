package com.example.demostream.repository;

import com.example.demostream.db.ProductDB;
import com.example.demostream.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class ProductRepository {
    private Integer generateId() {
        List<Product> products = ProductDB.products;
        return products.isEmpty() ? 1 : products.get(products.size() - 1).getId() + 1;
    }

    public List<Product> findAll() {
        return ProductDB.products;
    }

    public List<Product> findByBrand(String brand) {
        return ProductDB.products.stream()
                .filter(product -> product.getBrand().equals(brand))
                .toList();
    }

    public List<Product> findByPriceGreater(Integer price) {
        return ProductDB.products.stream()
                .filter(product -> product.getPrice() > price)
                .toList();
    }

    public List<Product> findByNameContainsIgnoreCase(String name) {
        return ProductDB.products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public Product save(Product p) {
        Optional<Product> optionalProduct = findById(p.getId());
        if(optionalProduct.isEmpty()) {
            p.setId(generateId());
            ProductDB.products.add(p);
            return p;
        } else {
            Product product = optionalProduct.get();
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setBrand(p.getBrand());
            product.setCount(p.getCount());
            return product;
        }
    }

    private Optional<Product> findById(Integer id) {
        return ProductDB.products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public void deleteByBrand(String brand) {
        ProductDB.products.removeIf(product -> product.getBrand().equals(brand));
    }

    public void delete(Integer id) {
        ProductDB.products.removeIf(p -> p.getId().equals(id));
    }

    public void deleteRandomByCount(Integer count) {
        Random rd = new Random();
        List<Product> products = ProductDB.products;
        if(products.size() < count) {
            throw new RuntimeException("Không đủ số lượng");
        }
        if( products.size() == count) {
            products.clear();
            return;
        }

        for (int i = 0; i < count; i++) {
            int rdIndex = rd.nextInt(products.size());
            Product product = products.get(rdIndex);
            delete(product.getId());
        }
    }
}
