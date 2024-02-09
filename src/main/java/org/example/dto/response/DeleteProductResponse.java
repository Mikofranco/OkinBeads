package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeleteProductResponse {
    private long productId;
    private final String MESSAGE = "SUCCESSFUL";
}
