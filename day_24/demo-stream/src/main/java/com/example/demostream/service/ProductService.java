package com.example.demostream.service;

import com.example.demostream.model.Product;
import com.example.demostream.repository.ProductRepository;
import com.example.demostream.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Lấy danh sách tất cả sản phẩm trong giỏ hàng
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    
    // 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
    // Tổng tiền mỗi sản phẩm = price * count
    public Integer getTotalMoney() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> product.getPrice() * product.getCount())
                .mapToInt(Integer::intValue)
                .sum();
    }
    
    // 3. Tìm các sản phẩm của thuơng hiệu "Apple"
    public List<Product> findByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
    
    // 4. Tìm các sản phẩm có giá > 20000000
    public List<Product> findByPrice(Integer price) {
        return productRepository.findByPriceGreater(price);
    }
    
    // 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)
    public List<Product> findByName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }
    
    // 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
    public Product addProduct(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .brand(request.getBrand())
                .count(request.getCount())
                .build();
        return productRepository.save(product);
    }
    
    // 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
    public void deleteByBrand(String brand) {
        productRepository.deleteByBrand(brand);
    }
    
    // 8. Sắp xếp giỏ hàng theo price tăng dần
    public List<Product> sortByPrice() {
        List<Product> products = productRepository.findAll();
        return products.stream().sorted(Comparator.comparing(Product::getPrice)).toList();
    }
    
    // 9. Sắp xếp giỏ hàng theo count giảm dần
    public List<Product> sortByCount() {
        List<Product> products = productRepository.findAll();
        return products.stream().sorted(Comparator.comparing(Product::getCount).reversed()).toList();
    }
    
    // 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
    public void deleteRandomProduct(Integer count) {
        productRepository.deleteRandomByCount(count);
    }
}
