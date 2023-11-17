package com.momoon.board.token.service;

import com.momoon.board.token.domain.TokenDto;
import com.momoon.board.token.domain.TokenInfo;

public interface TokenService {

    int saveTokenInfo(TokenInfo tokenInfo);

    TokenDto createLoginToken(String loginId, Long memberId);
}
