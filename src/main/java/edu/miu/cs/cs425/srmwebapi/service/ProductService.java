package edu.miu.cs.cs425.srmwebapi.service;

import edu.miu.cs.cs425.srmwebapi.dto.product.ProductRequestDTO1;
import edu.miu.cs.cs425.srmwebapi.dto.product.ProductResponseDTO2;
import edu.miu.cs.cs425.srmwebapi.dto.supplier.SupplierResponseDTO2;
import edu.miu.cs.cs425.srmwebapi.exception.SupplierNotFoundException;
import edu.miu.cs.cs425.srmwebapi.model.Product;
import edu.miu.cs.cs425.srmwebapi.model.Supplier;
import edu.miu.cs.cs425.srmwebapi.repository.ProductRepository;
import edu.miu.cs.cs425.srmwebapi.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository,
                          SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<ProductResponseDTO2> getProducts() {
        return productRepository.findAll(Sort.by("name"))
                .stream()
                .map(p -> new ProductResponseDTO2(
                        p.getProductId(),
                        p.getName(),
                        p.getUnitPrice(),
                        p.getQuantityInStock(),
                        p.getDateSupplied(),
                        new SupplierResponseDTO2(
                                p.getSupplier().getSupplierId(),
                                p.getSupplier().getName(),
                                p.getSupplier().getContactPhoneNo()
                        )
                )).toList();
    }

    public  List<ProductResponseDTO2> getProductsBySupplierId(Integer supplierId) throws SupplierNotFoundException {
        supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier with Id " + supplierId + " not found."));
        return productRepository.findProductsBySupplier_SupplierId(supplierId)
                .stream()
                .map(p -> new ProductResponseDTO2(
                        p.getProductId(),
                        p.getName(),
                        p.getUnitPrice(),
                        p.getQuantityInStock(),
                        p.getDateSupplied(),
                        new SupplierResponseDTO2(
                                p.getSupplier().getSupplierId(),
                                p.getSupplier().getName(),
                                p.getSupplier().getContactPhoneNo()
                        )
                )).toList();
    }

    public  ProductResponseDTO2 addNewProduct(ProductRequestDTO1 productRequest) {
        var product = new Product(null, productRequest.name(), productRequest.unitPrice(),
                productRequest.quantityInStock(), productRequest.dateSupplied(),
                new Supplier(null, productRequest.supplierRequest().name(),
                        productRequest.supplierRequest().contactPhoneNo()));
        var savedProduct = productRepository.save(product);
        return new ProductResponseDTO2(
                savedProduct.getProductId(),
                savedProduct.getName(),
                savedProduct.getUnitPrice(),
                savedProduct.getQuantityInStock(),
                savedProduct.getDateSupplied(),
                new SupplierResponseDTO2(
                        savedProduct.getSupplier().getSupplierId(),
                        savedProduct.getSupplier().getName(),
                        savedProduct.getSupplier().getContactPhoneNo()
                )
        );
    }
}
