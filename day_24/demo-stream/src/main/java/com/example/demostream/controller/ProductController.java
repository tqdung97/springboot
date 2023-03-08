package com.example.demostream.controller;

import com.example.demostream.model.Product;
import com.example.demostream.request.CreateProductRequest;
import com.example.demostream.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("products/total-money")
    public Integer getTotalMoney() {
        return productService.getTotalMoney();
    }

    @GetMapping("brand/{name}")
    public List<Product> getProductByBrand(@PathVariable String name) {
        return productService.findByBrand(name);
    }

    @GetMapping("price/{price}")
    public List<Product> getProductByPrice(@PathVariable Integer price) {
        return productService.findByPrice(price);
    }

    @GetMapping("name/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @PostMapping("products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody CreateProductRequest request) {
        return productService.addProduct(request);
    }

    @DeleteMapping("brand/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByBrand(@PathVariable String name) {
        productService.deleteByBrand(name);
    }

    @GetMapping("products/sortbyprice-asc")
    public List<Product> sortByPriceAsc() {
        return productService.sortByPrice();
    }

    @GetMapping("products/sortbycount-desc")
    public List<Product> sortByCountDesc() {
        return productService.sortByCount();
    }

    @DeleteMapping("products/delete-random/{count}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRandomProduct(@PathVariable Integer count) {
        productService.deleteRandomProduct(count);
    }
}
