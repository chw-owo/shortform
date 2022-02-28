package com.example.shortform.domain;

import com.example.shortform.dto.ResponseDto.CommentDetailResponseDto;
import com.example.shortform.dto.ResponseDto.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public CommentResponseDto toPKResponse() {
        return CommentResponseDto.builder()
                .commentId(id)
                .build();
    }

    public CommentDetailResponseDto toResponse() {
        return CommentDetailResponseDto.builder()
                .commentId(id)
                .nickname(user.getNickname())
                .content(content)
                .profileImage(user.getProfileImage())
                .build();
    }
}
