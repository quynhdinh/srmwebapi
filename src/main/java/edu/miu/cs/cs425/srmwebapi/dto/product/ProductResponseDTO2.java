package edu.miu.cs.cs425.srmwebapi.dto.product;

import edu.miu.cs.cs425.srmwebapi.dto.supplier.SupplierResponseDTO2;

import java.time.LocalDate;

public record ProductResponseDTO2(
        Long productId,
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied,
        SupplierResponseDTO2 supplier
) {
}
