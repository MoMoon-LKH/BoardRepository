package com.momoon.board.token.service;

import com.momoon.board.token.domain.TokenInfo;
import com.momoon.board.token.repository.TokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenInfoService {

    private final TokenRepository tokenRepository;

    public TokenInfoService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }


    @Transactional
    public void insertLoginToken(TokenInfo tokenInfo) {
        tokenRepository.deleteByMemberId(tokenInfo.getMemberId());
        tokenRepository.addRefreshToken(tokenInfo);
    }
}
