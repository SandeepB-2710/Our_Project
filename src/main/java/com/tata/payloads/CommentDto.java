package com.tata.payloads;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

    private Integer commentId;
    
    @NotEmpty
    @Size(min=4, max=15, message="Comment size must be more than 4 and less than 15")
    private String content;
    private LocalDateTime createdAt;
}
