package com.momoon.board.post.repository;

import com.momoon.board.post.domain.PostDetail;
import com.momoon.board.post.domain.PostListRequest;
import com.momoon.board.post.domain.PostListResponse;
import com.momoon.board.post.domain.PostRequest;
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
}
