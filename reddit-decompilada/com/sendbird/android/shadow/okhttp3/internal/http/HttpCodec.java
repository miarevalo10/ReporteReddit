package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.Response.Builder;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okio.Sink;
import java.io.IOException;

public interface HttpCodec {
    Builder mo5338a(boolean z) throws IOException;

    ResponseBody mo5339a(Response response) throws IOException;

    Sink mo5340a(Request request, long j);

    void mo5341a() throws IOException;

    void mo5342a(Request request) throws IOException;

    void mo5343b() throws IOException;

    void mo5344c();
}
