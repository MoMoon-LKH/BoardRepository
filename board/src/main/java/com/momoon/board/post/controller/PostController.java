package com.momoon.board.post.controller;

import com.momoon.board.category.domain.Category;
import com.momoon.board.category.domain.LoginAccess;
import com.momoon.board.category.service.CategoryService;
import com.momoon.board.common.AccessService;
import com.momoon.board.common.exception.NotAccessRightException;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.service.MemberService;
import com.momoon.board.post.domain.*;
import com.momoon.board.post.service.PostService;
import com.momoon.board.token.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Map<String, Object> map = new HashMap<>();
        int total = postService.countByCategoryId(categoryId);
        List<PostListResponse> list = postService.findListByCategoryId(listRequest);

        map.put("total", total);
        map.put("list", list);

        // 코멘트 수 관련 로직 추가 예정
        
        
        return ResponseEntity.ok(map);
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

        return ResponseEntity.status(HttpStatus.CREATED).body(postRequest);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(
            @PathVariable("id") Long id,
            @RequestBody PostRequest postRequest,
            HttpServletRequest request
    ) {

        Post post = postService.findById(id);

        if (post.getMemberId() != null) {
            String accessToken = request.getHeader("Authorization");
            if(accessToken != null) {
                accessToken = tokenProvider.removeBearer(accessToken);
                tokenProvider.validateToken(accessToken, false);
                String memberId = tokenProvider.getMemberIdByToken(accessToken, false);
                Member member = memberService.findByMemberId(memberId);

                if (!post.getMemberId().equals(member.getId())) {
                    throw new NotAccessRightException();
                }

            } else {
                throw new NotAccessRightException();
            }
        } else {
            if (postRequest.getPassword() == null || !passwordEncoder.matches(postRequest.getPassword(), post.getPassword())) {
                throw new NotAccessRightException();
            }
        }

        postRequest.setId(id);
        postService.updatePost(postRequest);

        return ResponseEntity.ok(postService.findDetailById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(
            @PathVariable("id") Long id,
            @RequestBody PostRequest postRequest,
            HttpServletRequest request
    ) {

        Post post = postService.findById(id);

        if (post.getMemberId() != null) {
            String accessToken = request.getHeader("Authorization");
            if(accessToken != null) {
                accessToken = tokenProvider.removeBearer(accessToken);
                tokenProvider.validateToken(accessToken, false);
                String memberId = tokenProvider.getMemberIdByToken(accessToken, false);
                Member member = memberService.findByMemberId(memberId);

                if (!post.getMemberId().equals(member.getId())) {
                    throw new NotAccessRightException();
                }

            } else {
                throw new NotAccessRightException();
            }
        } else {
            if (postRequest.getPassword() == null || !passwordEncoder.matches(postRequest.getPassword(), post.getPassword())) {
                throw new NotAccessRightException();
            }
        }

        postService.deletePost(id);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "정상적으로 삭제되었습니다");

        return ResponseEntity.ok(map);
    }

}
