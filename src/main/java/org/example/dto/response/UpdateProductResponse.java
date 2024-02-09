package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@Setter
@Getter
public class UpdateProductResponse {
    private Long productId;
    private String imageUrl;
    private BigDecimal amount;
    private String name;
    public String description;
}
