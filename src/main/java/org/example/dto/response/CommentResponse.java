package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CommentResponse {
    private long commenterId;
    private String commenterName;
    private final String SUCCESS ="SUCCESSFUL";
}
