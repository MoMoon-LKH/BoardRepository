package com.momoon.board.comment.domain;

import java.time.LocalDateTime;

public class CommentResponse {

    private Long id;

    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String nickname;

    private String personalId;


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPersonalId() {
        return personalId;
    }
}
