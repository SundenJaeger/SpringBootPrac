package com.rentoki.springbootprac.product.services;

import com.rentoki.springbootprac.Command;
import com.rentoki.springbootprac.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Command<Void, List<Product>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
