package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteProductRequest {
    private long adminId;
    private long productId;
}
