package com.rentoki.springbootprac.product;

import com.rentoki.springbootprac.product.model.Product;
import com.rentoki.springbootprac.product.services.CreateProductService;
import com.rentoki.springbootprac.product.services.DeleteProductService;
import com.rentoki.springbootprac.product.services.GetProductsService;
import com.rentoki.springbootprac.product.services.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductController(CreateProductService createProductService, GetProductsService getProductsService, UpdateProductService updateProductService, DeleteProductService deleteProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct() {
        return createProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getProductsService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return updateProductService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return deleteProductService.execute(null);
    }
}
