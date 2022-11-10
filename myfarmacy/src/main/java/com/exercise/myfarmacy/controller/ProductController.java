package com.exercise.myfarmacy.controller;

import com.exercise.myfarmacy.model.Product;
import com.exercise.myfarmacy.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void createProduct(Product product){
        productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping
    public void deleteProduct(Integer id){
        productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(Product product){
        productService.updateProduct(product);
    }
}
