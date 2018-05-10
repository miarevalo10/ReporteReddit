package com.twitter.sdk.android.core.identity;

class WebViewException extends Exception {
    private final int f23937a;
    private final String f23938b;

    public WebViewException(int i, String str, String str2) {
        super(str);
        this.f23937a = i;
        this.f23938b = str2;
    }
}
