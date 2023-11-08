package com.momoon.board.post.controller;

import com.momoon.board.post.domain.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {


    @GetMapping("/list/{categoryId}")
    public ResponseEntity<?> getPostList(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "searchSelect", required = false) String searchSelect,
            @RequestParam(value = "searchWord", required = false) String searchWord,
            @RequestParam(value = "limit", defaultValue = "20") int limit
    ) {

        return ResponseEntity.ok("");
    }

    @GetMapping("/{categoryId}/{id}")
    public ResponseEntity<?> getPostDetail (
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("id") Long postId
    ) {

        return ResponseEntity.ok("");
    }

    @PostMapping("")
    public ResponseEntity<?> writePost() {
        return ResponseEntity.ok("");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok("");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok("");
    }

}
