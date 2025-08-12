package edu.miu.cs.cs425.srmwebapi.repository;

import edu.miu.cs.cs425.srmwebapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsBySupplier_SupplierId(Integer supplierId);
}
