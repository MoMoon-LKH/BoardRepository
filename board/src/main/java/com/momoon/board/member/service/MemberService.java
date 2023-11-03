package com.momoon.board.member.service;

import com.momoon.board.member.domain.Member;
import com.momoon.board.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int registerMember(Member member) {
        return memberRepository.registerMember(member);
    }

    public boolean existMemberId(String memberId) {
        return memberRepository.countByMemberId(memberId) > 0;
    }

    public boolean existNickname(String nickname) {
        return memberRepository.countByNickname(nickname) > 0;
    }

}
