package com.momoon.board.token.repository;

import com.momoon.board.token.domain.TokenInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenInfoMapper {

    int saveTokenInfo(TokenInfo tokenInfo);

}
