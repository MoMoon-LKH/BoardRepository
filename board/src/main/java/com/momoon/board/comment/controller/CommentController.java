package com.momoon.board.comment.controller;

import com.momoon.board.category.domain.Category;
import com.momoon.board.category.domain.LoginAccess;
import com.momoon.board.category.service.CategoryService;
import com.momoon.board.comment.domain.CommentRequest;
import com.momoon.board.comment.domain.CommentResponse;
import com.momoon.board.comment.service.CommentService;
import com.momoon.board.common.AccessService;
import com.momoon.board.common.exception.NotAccessRightException;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.service.MemberService;
import com.momoon.board.token.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post/{categoryId}/{postId}")
public class CommentController {

    private final CommentService commentService;

    private final CategoryService categoryService;

    private final AccessService accessService;

    private final TokenProvider tokenProvider;

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    public CommentController(CommentService commentService, CategoryService categoryService, AccessService accessService, TokenProvider tokenProvider, MemberService memberService, PasswordEncoder passwordEncoder) {
        this.commentService = commentService;
        this.categoryService = categoryService;
        this.accessService = accessService;
        this.tokenProvider = tokenProvider;
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getList(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("postId") Long postId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            HttpServletRequest request
    ) {
        int limit = 20;
        int offset = (page - 1) * limit;

        LoginAccess loginAccess = categoryService.findById(categoryId).getLoginAccess();
        String accessToken = request.getHeader("Authorization");

        accessService.confirmCategoryAccess(loginAccess, accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("total", commentService.countByPostId(postId));
        map.put("list", commentService.findListByPostId(postId, offset, limit));

        return ResponseEntity.ok(map);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> createComment(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("postId") Long postId,
            @RequestBody CommentRequest commentRequest,
            HttpServletRequest request
            ) {

        LoginAccess loginAccess = categoryService.findById(categoryId).getLoginAccess();
        String accessToken = request.getHeader("Authorization");

        accessService.confirmCategoryAccess(loginAccess, accessToken);

        if (accessToken != null) {
            String memberId = tokenProvider.getMemberIdByToken(tokenProvider.removeBearer(accessToken), false);
            Member member = memberService.findByMemberId(memberId);
            commentRequest.setMemberId(member.getId());
        } else {
            if (commentRequest.getPersonalId() == null || commentRequest.getPassword() == null) {
                throw new NotAccessRightException();
            }

            commentRequest.setPassword(passwordEncoder.encode(commentRequest.getPassword()));
        }

        commentRequest.setPostId(postId);
        commentService.save(commentRequest);

        CommentResponse result = commentService.findById(commentRequest.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("postId") Long postId,
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("postId") Long postId,
            @PathVariable("id") Long id
    ) {

        return ResponseEntity.ok("");
    }
}
