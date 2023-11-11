package com.momoon.board.post.domain;

import java.time.LocalDateTime;

public class Post {

    private Long id;

    private String title;

    private String content;

    private int viewCnt;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Long memberId;

    private String personalId;

    private String password;

    public Post() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getPassword() {
        return password;
    }
}
