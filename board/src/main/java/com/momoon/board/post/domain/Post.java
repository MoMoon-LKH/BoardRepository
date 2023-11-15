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

    private Long categoryId;

    private String personalId;

    private String password;

    public Post() {

    }

    public Post(builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.viewCnt = builder.viewCnt;
        this.createDate = builder.createDate;
        this.modifyDate = builder.modifyDate;
        this.memberId = builder.memberId;
        this.categoryId = builder.categoryId;
        this.personalId = builder.personalId;
        this.password = builder.password;
    }

    public static class builder {

        private String title;
        private String content;
        private int viewCnt;
        private LocalDateTime createDate;
        private LocalDateTime modifyDate;
        private Long memberId;
        private Long categoryId;
        private String personalId;
        private String password;

        public builder title(String title) {
            this.title = title;
            return this;
        }

        public builder content(String content) {
            this.content = content;
            return this;
        }

        public builder viewCnt(int viewCnt) {
            this.viewCnt = viewCnt;
            return this;
        }

        public builder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public builder modifyDate(LocalDateTime modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public builder memberId(Long memberId) {
            this.memberId = memberId;
            return this;
        }

        public builder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public builder personalId(String personalId) {
            this.personalId = personalId;
            return this;
        }

        public builder password(String password) {
            this.password = password;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
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

    public Long getCategoryId() {
        return categoryId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getPassword() {
        return password;
    }
}
