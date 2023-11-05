package com.momoon.board.member.repository;

import com.momoon.board.member.domain.Member;
import com.momoon.board.member.dto.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface MemberRepository {

    int registerMember(Member member);

    int countByMemberId(@Param("memberId") String memberId);

    int countByNickname(@Param("nickname") String nickname);

    Member findByMemberId(@Param("memberId") String memberId);
}
