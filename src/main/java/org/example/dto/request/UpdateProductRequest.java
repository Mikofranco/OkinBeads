package org.example.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.data.models.Category;

 @Setter @Getter
public class UpdateProductRequest {
    private long productId;
    private String name;
    private Double amount;
    private String description;
    private String imageUrl;
    private Category category;
}
