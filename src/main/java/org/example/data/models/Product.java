package org.example.data.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String imageUrl;
    private BigDecimal amount;
    private String name;
    public String description;
    @ManyToOne
    private   Admin uploader;
}
