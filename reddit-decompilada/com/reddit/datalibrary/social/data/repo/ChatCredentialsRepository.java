package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\r\u001a\u00020\u0005J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\fJ\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/social/data/repo/ChatCredentialsRepository;", "", "()V", "accessTokenMap", "", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "baseplateClient", "Lcom/reddit/datalibrary/social/network/BaseplateClient;", "sendBirdConfig", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "clearExistingAccessToken", "", "userId", "fetchSendBirdAccessTokenData", "Lio/reactivex/Observable;", "fetchSendbirdConfig", "getExistingAccessToken", "invalidateProxyHost", "saveAccessTokenData", "accessTokenData", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatCredentialsRepository.kt */
public final class ChatCredentialsRepository {
    public final BaseplateClient f19849a = new BaseplateClient();
    public SendBirdConfig f19850b;
    public Map<String, SendBirdAccessTokenData> f19851c;

    public final void m21698a(String str) {
        Intrinsics.m26847b(str, "userId");
        if (this.f19851c == null) {
            this.f19851c = new HashMap();
        }
        Map map = this.f19851c;
        if (map != null) {
            map.remove(str);
        }
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        ChatSharedPreferencesUtil.m24745a(obj.getApplicationContext(), this.f19851c);
    }

    public static final /* synthetic */ void m21697a(ChatCredentialsRepository chatCredentialsRepository, String str, SendBirdAccessTokenData sendBirdAccessTokenData) {
        if (sendBirdAccessTokenData != null) {
            if (chatCredentialsRepository.f19851c == null) {
                chatCredentialsRepository.f19851c = new HashMap();
            }
            Map map = chatCredentialsRepository.f19851c;
            if (map != null) {
                map.put(str, sendBirdAccessTokenData);
            }
            Object obj = FrontpageApplication.f27402a;
            Intrinsics.m26843a(obj, "FrontpageApplication.instance");
            ChatSharedPreferencesUtil.m24745a(obj.getApplicationContext(), chatCredentialsRepository.f19851c);
        }
    }
}
