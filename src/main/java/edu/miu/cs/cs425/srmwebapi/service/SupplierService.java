package edu.miu.cs.cs425.srmwebapi.service;

import edu.miu.cs.cs425.srmwebapi.dto.product.ProductResponseDTO1;
import edu.miu.cs.cs425.srmwebapi.dto.supplier.SupplierResponseDTO1;
import edu.miu.cs.cs425.srmwebapi.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierResponseDTO1> getAllSuppliers() {
        return supplierRepository.findAll(Sort.by("name"))
                .stream()
                .map(s -> new SupplierResponseDTO1(
                        s.getSupplierId(),
                        s.getName(),
                        s.getProducts().stream()
                                .map(p -> new ProductResponseDTO1(
                                        p.getProductId(),
                                        p.getName(),
                                        p.getUnitPrice(),
                                        p.getQuantityInStock(),
                                        p.getDateSupplied()
                                )).toList()
                )).toList();
    }

}
