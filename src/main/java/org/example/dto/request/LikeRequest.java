package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LikeRequest {
    private  long productId;
    private long userId;
}
