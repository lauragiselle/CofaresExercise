package com.exercise.myfarmacy.service;

import com.exercise.myfarmacy.model.Product;
import com.exercise.myfarmacy.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Integer id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.delete(product.get());
        } else {
            log.warn("Product does not exist");
        }
    }

    public void updateProduct(Product product){
        Optional<Product> productToUpdate = productRepository.findById(product.getId());
        if (productToUpdate.isPresent()){
            Product entity = productToUpdate.get();
            entity.setName(product.getName());
            entity.setPrice(product.getPrice());
            productRepository.save(entity);
        } else {
            log.warn("Product does not exist");
        }
    }
}
