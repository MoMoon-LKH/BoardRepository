package com.momoon.board.comment.repository;

import com.momoon.board.comment.domain.CommentRequest;
import com.momoon.board.comment.domain.CommentResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface CommentRepository {

    int saveComment(CommentRequest commentRequest);

    int updateComment(CommentRequest commentRequest);

    List<CommentResponse> findListByPostId(@Param("postId") Long postId, int offset, int limit);

    int countByPostId(@Param("postId") Long postId);

    Optional<CommentResponse> findById(@Param("id") Long id);
}
