package edu.miu.cs.cs425.srmwebapi.dto.product;

import java.time.LocalDate;

public record ProductResponseDTO1(
        Long productId,
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied
) {
}
