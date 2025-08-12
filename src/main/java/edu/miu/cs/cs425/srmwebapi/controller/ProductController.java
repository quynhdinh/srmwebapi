package edu.miu.cs.cs425.srmwebapi.controller;

import edu.miu.cs.cs425.srmwebapi.dto.product.ProductRequestDTO1;
import edu.miu.cs.cs425.srmwebapi.dto.product.ProductResponseDTO2;
import edu.miu.cs.cs425.srmwebapi.exception.SupplierNotFoundException;
import edu.miu.cs.cs425.srmwebapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/srm/api/v1/products"})
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<List<ProductResponseDTO2>> listProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(value = {"/get/supplier/{supplierId}"})
    public ResponseEntity<List<ProductResponseDTO2>> getProductsBySupplierId(
            @PathVariable Integer supplierId)  throws SupplierNotFoundException {
        return ResponseEntity.ok(productService.getProductsBySupplierId(supplierId));
    }

    @PostMapping(value = {""})
    public ResponseEntity<ProductResponseDTO2> addNewProduct(@RequestBody @Valid ProductRequestDTO1 newProduct) {
        var product = productService.addNewProduct(newProduct);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
