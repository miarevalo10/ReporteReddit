package com.sendbird.android.shadow.okhttp3;

import java.io.IOException;

public interface Interceptor {

    public interface Chain {
        Request mo5329a();

        Response mo5330a(Request request) throws IOException;

        int mo5331b();

        int mo5332c();

        int mo5333d();
    }

    Response mo5325a(Chain chain) throws IOException;
}
