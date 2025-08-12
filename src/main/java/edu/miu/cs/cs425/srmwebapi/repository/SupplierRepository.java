package edu.miu.cs.cs425.srmwebapi.repository;

import edu.miu.cs.cs425.srmwebapi.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query(value = """
        select s from Supplier s LEFT JOIN FETCH s.products order by s.name
    """)
    List<Supplier> getAllSuppliersAndProducts();
}
