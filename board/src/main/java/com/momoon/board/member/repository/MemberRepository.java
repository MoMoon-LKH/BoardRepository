package com.momoon.board.member.repository;

import com.momoon.board.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRepository {

    int registerMember(Member member);

    int countByMemberId(@Param("memberId") String memberId);

    int countByNickname(@Param("nickname") String nickname);


}
