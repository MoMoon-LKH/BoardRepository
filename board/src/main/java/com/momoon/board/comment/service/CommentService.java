package com.momoon.board.comment.service;

import com.momoon.board.comment.domain.CommentRequest;
import com.momoon.board.comment.domain.CommentResponse;
import com.momoon.board.comment.repository.CommentRepository;
import com.momoon.board.common.exception.NotFoundDomainException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public int save(CommentRequest commentRequest) {
        return commentRepository.saveComment(commentRequest);
    }

    public List<CommentResponse> findListByPostId(Long postId, int offset, int limit) {
        return commentRepository.findListByPostId(postId, offset, limit);
    }

    public int countByPostId(Long postId) {
        return commentRepository.countByPostId(postId);
    }

    public CommentResponse findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundDomainException("해당 댓글을 찾을 수 없습니다"));
    }
}
