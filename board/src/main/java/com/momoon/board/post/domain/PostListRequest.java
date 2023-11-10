package com.momoon.board.post.domain;

public class PostListRequest {

    private Long categoryId;

    private int offset;

    private int limit;

    private String searchSelect;

    private String searchWord;


    public PostListRequest() {
    }

    private PostListRequest(builder builder) {
        this.categoryId = builder.categoryId;
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.searchSelect = builder.searchSelect;
        this.searchWord = builder.searchWord;
    }


    public static class builder {
        private Long categoryId;
        private int offset;
        private int limit;
        private String searchSelect;
        private String searchWord;

        public builder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public builder searchSelect(String searchSelect) {
            this.searchSelect = searchSelect;
            return this;
        }

        public builder searchWord(String searchWord) {
            this.searchWord = searchWord;
            return this;
        }

        public PostListRequest build() {
            return new PostListRequest(this);
        }

    }
}
