package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommentRequest {
    private long commenterId;
    private long productId;
    private String comment;
}
