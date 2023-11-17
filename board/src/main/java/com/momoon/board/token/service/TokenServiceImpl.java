package com.momoon.board.token.service;

import com.momoon.board.token.JwtTokenProvider;
import com.momoon.board.token.domain.TokenDto;
import com.momoon.board.token.domain.TokenInfo;
import com.momoon.board.token.repository.TokenInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenInfoMapper tokenInfoMapper;

    private final JwtTokenProvider provider;

    public TokenServiceImpl(TokenInfoMapper tokenInfoMapper, JwtTokenProvider provider) {
        this.tokenInfoMapper = tokenInfoMapper;
        this.provider = provider;
    }

    @Override
    public int saveTokenInfo(TokenInfo tokenInfo) {
        return tokenInfoMapper.saveTokenInfo(tokenInfo);
    }

    @Override
    @Transactional
    public TokenDto createLoginToken(String loginId, Long memberId) {
        String access = provider.createToken(loginId);
        String refresh = provider.createRefreshToken(loginId);

        TokenInfo tokenInfo = new TokenInfo.builder()
                        .memberId(memberId)
                        .tokenValue(refresh)
                        .build();

        tokenInfoMapper.saveTokenInfo(tokenInfo);

        return new TokenDto.builder()
                .access(access)
                .refresh(refresh)
                .build();
    }
}
