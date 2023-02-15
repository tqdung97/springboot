package com.example.blogbackend.controller;

import com.example.blogbackend.request.UpsertCategoriesRequest;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Xem tất cả thể loại
    @GetMapping("")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    // Xem chi tiết thể loại
    @GetMapping("{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //Thêm thể loại

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody UpsertCategoriesRequest request){
        return new ResponseEntity<>(categoryService.createCategoy(request), HttpStatus.CREATED);
    }

    // Sửa thể loại
    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody UpsertCategoriesRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    // Xóa thể loại
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
