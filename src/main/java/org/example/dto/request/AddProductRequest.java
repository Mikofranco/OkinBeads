package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.example.data.models.Category;

import java.math.BigDecimal;
@Getter
@Setter
public class AddProductRequest {
    private Long adminId;
    private String imageUrl;
    private BigDecimal amount;
    private String name;
    private String description;
    private Category category;

}
