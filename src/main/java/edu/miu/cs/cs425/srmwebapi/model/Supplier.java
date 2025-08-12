package edu.miu.cs.cs425.srmwebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    //@Column(nullable = false)
    @NotNull(message = "Supplier Name is required")
    private String name;
    private String contactPhoneNo;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    public Supplier(Integer supplierId, String name, String contactPhoneNo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhoneNo = contactPhoneNo;
    }
}
