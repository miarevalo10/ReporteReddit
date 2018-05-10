package com.reddit.datalibrary.frontpage.data.common.interceptor;

import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.util.TimingUtil;
import com.reddit.social.analytics.ChatPerformanceAnalytics;
import java.net.URL;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/TimingInterceptor;", "Lokhttp3/Interceptor;", "()V", "chatPerfAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalytics;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TimingInterceptor.kt */
public final class TimingInterceptor implements Interceptor {
    private ChatPerformanceAnalytics f15743a = new ChatPerformanceAnalytics();

    public final Response intercept(Chain chain) {
        Intrinsics.b(chain, "chain");
        HttpUrl url = chain.request().url();
        UUID randomUUID = UUID.randomUUID();
        Intrinsics.a(url, UpdateFragment.FRAGMENT_URL);
        Intrinsics.a(randomUUID, "uuid");
        ChatPerformanceAnalytics.a(url, randomUUID);
        chain = chain.proceed(chain.request());
        Intrinsics.b(url, "requestUrl");
        Intrinsics.b(randomUUID, "uuid");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        stringBuilder.append('_');
        stringBuilder.append(randomUUID);
        long d = TimingUtil.d(stringBuilder.toString());
        if (d != -1) {
            ChatEventBuilder a = ChatPerformanceAnalytics.a(TrackLoadSettingsAtom.TYPE, "request_proxy", d);
            URL url2 = url.url();
            Intrinsics.a(url2, "requestUrl.url()");
            String path = url2.getPath();
            Intrinsics.a(path, "requestUrl.url().path");
            a.p(path);
            ChatPerformanceAnalytics.a(a);
        }
        Intrinsics.a(chain, "response");
        return chain;
    }
}
