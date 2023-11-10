package com.momoon.board.post.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostDetail {

    private Long id;

    private String title;

    private String content;

    private int viewCnt;

    private String nickname;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String personalId;

    public PostDetail() {
    }

    public PostDetail(builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
        this.viewCnt = builder.viewCnt;
        this.nickname = builder.nickname;
        this.createDate = builder.createDate;
        this.modifyDate = builder.modifyDate;
        this.personalId = builder.personalId;
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

    public String getNickname() {
        return nickname;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public String getPersonalId() {
        return personalId;
    }

    public static class builder {
        private Long id;

        private String title;

        private String content;

        private int viewCnt;

        private String nickname;

        private LocalDateTime createDate;

        private LocalDateTime modifyDate;

        private String personalId;


        public builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public builder nickname(String nickname) {
            this.nickname = nickname;
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

        public builder personalId(String personalId) {
            this.personalId = personalId;
            return this;
        }

        public PostDetail build(){
            return new PostDetail(this);
        }
    }
}
