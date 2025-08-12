package edu.miu.cs.cs425.srmwebapi.dto.product;

import edu.miu.cs.cs425.srmwebapi.dto.supplier.SupplierRequestDTO1;

import java.time.LocalDate;

public record ProductRequestDTO1(
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied,
        SupplierRequestDTO1 supplierRequest
) {
}
