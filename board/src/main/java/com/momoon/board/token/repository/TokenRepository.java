package com.momoon.board.token.repository;

import com.momoon.board.token.domain.TokenInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Mapper
@Repository
public interface TokenRepository {
    int addRefreshToken(TokenInfo tokenInfo);

    int updateToken(TokenInfo tokenInfo);

    int deleteByMemberId(@Param("memberId") Long memberId);

    TokenInfo findByMemberIdAndTokenValue(@Param("memberId") String memberId, @Param("tokenValue") String tokenValue);

}
