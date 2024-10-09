package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter@Builder
@Getter
public class LikeResponse {
    private Long likeId;
    private final String SUCCESSFUL = "SUCCESSFUL";
}
