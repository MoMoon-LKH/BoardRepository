package com.momoon.board.post.service;

import com.momoon.board.post.domain.*;
import com.momoon.board.post.exception.NotFoundPostException;
import com.momoon.board.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostListResponse> findListByCategoryId(PostListRequest request) {
        return postRepository.findListByCategoryId(request);
    }

    public int updateViewCntById(Long id) {
        return postRepository.updateViewCntById(id);
    }

    public PostDetail findDetailById(Long id) {
        return postRepository.findDetailById(id).orElseThrow(NotFoundPostException::new);
    }

    public Long savePost(PostRequest postRequest) {
        return postRepository.savePost(postRequest);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(NotFoundPostException::new);
    }

    public void updatePost(PostRequest postRequest){
        postRepository.updatePost(postRequest);
    }

    public void deletePost(Long id) {
        postRepository.deletePost(id);
    }

    public int countByCategoryId(Long categoryId) {
        return postRepository.countByCategoryId(categoryId);
    }
}