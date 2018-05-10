package com.reddit.datalibrary.social.network;

import com.google.gson.JsonElement;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.Contact;
import com.reddit.datalibrary.social.model.CreateChannelRequestBody;
import com.reddit.datalibrary.social.model.InviteToChannelRequestBody;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0007J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0006J\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00062\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/social/network/BaseplateClient;", "Lcom/reddit/datalibrary/social/network/BaseClient;", "()V", "baseplateNetworkService", "Lcom/reddit/datalibrary/social/network/BaseplateService;", "contacts", "Lio/reactivex/Observable;", "", "Lcom/reddit/datalibrary/social/model/Contact;", "limit", "", "(Ljava/lang/Integer;)Lio/reactivex/Observable;", "createChannel", "Lcom/google/gson/JsonElement;", "body", "Lcom/reddit/datalibrary/social/model/CreateChannelRequestBody;", "fetchSendBirdAccessTokenData", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "fetchSendBirdConfig", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "inviteToChannel", "channelUrl", "", "Lcom/reddit/datalibrary/social/model/InviteToChannelRequestBody;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "muteChannel", "Lretrofit2/Response;", "Ljava/lang/Void;", "setChatEnabled", "unmuteChannel", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseplateClient.kt */
public final class BaseplateClient extends BaseClient {
    private final BaseplateService f27394a;

    public BaseplateClient() {
        Object f = Util.m24027f((int) C1761R.string.baseplate_uri);
        Intrinsics.m26843a(f, "baseplateUri");
        this.f27394a = (BaseplateService) BaseClient.m21773a(f, BaseplateService.class);
    }

    public final Observable<SendBirdAccessTokenData> m28846b() {
        return this.f27394a.sendbirdAccessToken(BaseClient.m21774a());
    }

    public final Observable<SendBirdConfig> m28848c() {
        return this.f27394a.sendbirdConfig(BaseClient.m21774a());
    }

    public final Observable<JsonElement> m28843a(CreateChannelRequestBody createChannelRequestBody) {
        Intrinsics.m26847b(createChannelRequestBody, "body");
        return this.f27394a.createChannel(BaseClient.m21774a(), createChannelRequestBody);
    }

    public final Observable<JsonElement> m28845a(String str, InviteToChannelRequestBody inviteToChannelRequestBody) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(inviteToChannelRequestBody, "body");
        return this.f27394a.inviteToChannel(str, BaseClient.m21774a(), inviteToChannelRequestBody);
    }

    public final Observable<List<Contact>> m28850d() {
        return this.f27394a.contacts(BaseClient.m21774a(), null);
    }

    public final Observable<ChatEnabled> m28851e() {
        return this.f27394a.isChatEnabled(BaseClient.m21774a());
    }

    public final Observable<Response<Void>> m28852f() {
        return this.f27394a.setChatEnabled(BaseClient.m21774a());
    }

    public final Observable<ChannelMuteStatus> m28844a(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return this.f27394a.isChannelMuted(str, BaseClient.m21774a());
    }

    public final Observable<Response<Void>> m28847b(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return this.f27394a.muteChannel(str, BaseClient.m21774a());
    }

    public final Observable<Response<Void>> m28849c(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return this.f27394a.unmuteChannel(str, BaseClient.m21774a());
    }
}
