package com.reddit.datalibrary.frontpage.redditauth.account;

public class TokenUtil {

    public static class TokenRotationError extends Exception {
        public TokenRotationError(String str) {
            super(str);
        }

        public TokenRotationError(Exception exception) {
            super(exception);
        }
    }
}
