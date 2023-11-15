package com.momoon.board.member.repository;

import com.momoon.board.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {

    int registerMember(Member member);


}
