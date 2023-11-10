package com.momoon.board.common;

import com.momoon.board.category.domain.Category;
import com.momoon.board.category.domain.LoginAccess;
import com.momoon.board.common.exception.NotAccessRightException;
import com.momoon.board.token.TokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    private final TokenProvider tokenProvider;

    public AccessService(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public boolean confirmCategoryAccess(LoginAccess loginAccess, String accessToken) {

        if (loginAccess == LoginAccess.LOGIN) {
            if (accessToken == null || !tokenProvider.validateToken(accessToken.replace("Bearer ", ""), false)) {
                throw new NotAccessRightException();
            }
        } else if (loginAccess == LoginAccess.NOT) {
            if(accessToken != null) {
                throw new NotAccessRightException();
            }
        }

        return true;
    }
}
