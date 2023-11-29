package com.momoon.board.member.repository;

import com.momoon.board.member.domain.LoginDto;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.domain.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface MemberMapper {

    int registerMember(Member member);

    int countByLoginId(@Param("loginId") String loginId);

    int countByNickname(@Param("nickname") String nickname);

    Optional<MemberDto> findById(@Param("id") Long id);

    Optional<Member> findByLoginIdAndPassword(LoginDto loginDto);

}
