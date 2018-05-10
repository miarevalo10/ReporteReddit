package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.api.v1.Dynamic;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;
import timber.log.Timber;

public class SessionDynamic implements Dynamic {
    private final Session f16312a;

    public SessionDynamic(Session session) {
        this.f16312a = session;
    }

    public final void mo3034a(Map<String, String> map) {
        Timber.b("token is %s", new Object[]{this.f16312a.f16289b});
        String str = HttpRequest.HEADER_AUTHORIZATION;
        StringBuilder stringBuilder = new StringBuilder("Bearer ");
        stringBuilder.append(this.f16312a.f16289b);
        map.put(str, stringBuilder.toString());
    }
}
