package edu.miu.cs.cs425.srmwebapi.controller;

import edu.miu.cs.cs425.srmwebapi.dto.supplier.SupplierResponseDTO1;
import edu.miu.cs.cs425.srmwebapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/srm/api/v1/supplier"})
public class SupplierController {

    private SupplierService supplierService;

    public  SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<SupplierResponseDTO1>> listSuppliers(){
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }
}
