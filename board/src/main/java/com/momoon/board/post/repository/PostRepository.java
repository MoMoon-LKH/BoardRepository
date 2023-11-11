package com.momoon.board.post.repository;

import com.momoon.board.post.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface PostRepository {

    List<PostListResponse> findListByCategoryId(PostListRequest request);

    int updateViewCntById(@Param("id") Long id);

    Optional<PostDetail> findDetailById(@Param("id") Long id);

    Long savePost(PostRequest postRequest);

    Optional<Post> findById(@Param("id") Long id);

    int updatePost(PostRequest postRequest);

    int deletePost(@Param("id") Long id);

    int countByCategoryId(@Param("categoryId") Long categoryId);
}
