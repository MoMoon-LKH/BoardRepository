package com.momoon.board.post.domain;

import java.time.LocalDate;

public class Post {

    private Long id;

    private String title;

    private String content;

    private int viewCnt;

    private LocalDate createDate;

    private LocalDate modifyDate;

    public Post() {
    }

    public Post(builder builder) {
        this.id = builder.id;
    }

    public static class builder {
        private Long id;

        private String title;

        private String content;

        private int viewCnt;

        private LocalDate createDate;

        private LocalDate modifyDate;


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

        public builder createDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }

        public builder modifyDate(LocalDate modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public Post build(){
            return new Post(this);
        }
    }
}
