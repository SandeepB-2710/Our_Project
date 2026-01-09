package com.tata.payloads;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String postImage;
//    private String postVedio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
