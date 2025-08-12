package edu.miu.cs.cs425.srmwebapi.dto.supplier;

import edu.miu.cs.cs425.srmwebapi.dto.product.ProductResponseDTO1;

import java.util.List;

public record SupplierResponseDTO1(
        Integer supplierId,
        String name,
        List<ProductResponseDTO1> products
) {
}
