package org.example.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity@Setter@Getter
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
