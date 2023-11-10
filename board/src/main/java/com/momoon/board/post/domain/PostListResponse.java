package com.momoon.board.post.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostListResponse {

    private Long id;

    private String title;

    private int viewCnt;

    private int commentCnt;

    private LocalDateTime createDate;

    public PostListResponse() {
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public int getCommentCnt() {
        return commentCnt;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void setCommentCnt(int commentCnt) {
        this.commentCnt = commentCnt;
    }

}
