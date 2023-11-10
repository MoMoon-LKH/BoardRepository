package com.momoon.board.post.controller;

import com.momoon.board.category.domain.Category;
import com.momoon.board.category.domain.LoginAccess;
import com.momoon.board.category.service.CategoryService;
import com.momoon.board.common.AccessService;
import com.momoon.board.common.exception.NotAccessRightException;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.service.MemberService;
import com.momoon.board.post.domain.PostDetail;
import com.momoon.board.post.domain.PostListRequest;
import com.momoon.board.post.domain.PostListResponse;
import com.momoon.board.post.domain.PostRequest;
import com.momoon.board.post.service.PostService;
import com.momoon.board.token.TokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final MemberService memberService;
    private final CategoryService categoryService;
    private final AccessService accessService;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public PostController(PostService postService, MemberService memberService, CategoryService categoryService, AccessService accessService, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.postService = postService;
        this.memberService = memberService;
        this.categoryService = categoryService;
        this.accessService = accessService;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("/list/{categoryId}")
    public ResponseEntity<?> getPostList(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "searchSelect", required = false) String searchSelect,
            @RequestParam(value = "searchWord", required = false) String searchWord,
            @RequestParam(value = "limit", defaultValue = "20") int limit,
            HttpServletRequest request
    ) {

        Category category = categoryService.findById(categoryId);
        LoginAccess loginAccess = category.getLoginAccess();
        String accessToken = request.getHeader("Authorization");

        accessService.confirmCategoryAccess(loginAccess, accessToken);


        PostListRequest listRequest = new PostListRequest.builder()
                .categoryId(categoryId)
                .offset((page - 1) * limit)
                .limit(limit)
                .searchSelect(searchSelect)
                .searchWord(searchWord)
                .build();

        List<PostListResponse> list = postService.findListByCategoryId(listRequest);

        // 코멘트 수 관련 로직 추가 예정
        
        
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{categoryId}/{id}")
    public ResponseEntity<?> getPostDetail (
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("id") Long postId,
            HttpServletRequest request
    ) {

        Category category = categoryService.findById(categoryId);
        LoginAccess loginAccess = category.getLoginAccess();
        String accessToken = request.getHeader("Authorization");

        accessService.confirmCategoryAccess(loginAccess, accessToken);

        postService.updateViewCntById(postId);
        PostDetail post = postService.findDetailById(postId);

        return ResponseEntity.ok(post);
    }

    @PostMapping("")
    public ResponseEntity<?> writePost(
            @RequestBody PostRequest postRequest,
            HttpServletRequest request) {

        Category category = categoryService.findById(postRequest.getCategoryId());
        LoginAccess loginAccess = category.getLoginAccess();
        String accessToken = request.getHeader("Authorization");

        accessService.confirmCategoryAccess(loginAccess, accessToken);

        if (postRequest.getPersonalId() != null) {
            postRequest.setPassword(passwordEncoder.encode(postRequest.getPassword()));
        } else {
            Member member = memberService.findByMemberId(
                    tokenProvider.getMemberIdByToken(tokenProvider.removeBearer(accessToken), false)
            );
            if (!member.getId().equals(postRequest.getMemberId())) {
                throw new NotAccessRightException();
            }
        }

        postService.savePost(postRequest);

        return ResponseEntity.ok(postRequest);
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
