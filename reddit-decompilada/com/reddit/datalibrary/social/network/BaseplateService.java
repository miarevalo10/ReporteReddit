package com.reddit.datalibrary.social.network;

import com.google.gson.JsonElement;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.Contact;
import com.reddit.datalibrary.social.model.CreateChannelRequestBody;
import com.reddit.datalibrary.social.model.InviteToChannelRequestBody;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nH'¢\u0006\u0002\u0010\u000bJ.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J8\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u0012H'J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J4\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J4\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'¨\u0006 "}, d2 = {"Lcom/reddit/datalibrary/social/network/BaseplateService;", "", "contacts", "Lio/reactivex/Observable;", "", "Lcom/reddit/datalibrary/social/model/Contact;", "headers", "", "", "limit", "", "(Ljava/util/Map;Ljava/lang/Integer;)Lio/reactivex/Observable;", "createChannel", "Lcom/google/gson/JsonElement;", "body", "Lcom/reddit/datalibrary/social/model/CreateChannelRequestBody;", "inviteToChannel", "channelUrl", "Lcom/reddit/datalibrary/social/model/InviteToChannelRequestBody;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "muteChannel", "Lretrofit2/Response;", "Ljava/lang/Void;", "sendbirdAccessToken", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "sendbirdConfig", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "setChatEnabled", "unmuteChannel", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseplateService.kt */
public interface BaseplateService {
    @GET(a = "/api/v1/sendbird/contacts")
    Observable<List<Contact>> contacts(@HeaderMap Map<String, String> map, @Query(a = "limit") Integer num);

    @POST(a = "/api/v1/sendbird/group_channels")
    Observable<JsonElement> createChannel(@HeaderMap Map<String, String> map, @Body CreateChannelRequestBody createChannelRequestBody);

    @POST(a = "/api/v1/sendbird/group_channels/{url}/invite")
    Observable<JsonElement> inviteToChannel(@Path(a = "url") String str, @HeaderMap Map<String, String> map, @Body InviteToChannelRequestBody inviteToChannelRequestBody);

    @GET(a = "/api/v1/sendbird/group_channels/{channel_url}/mute")
    Observable<ChannelMuteStatus> isChannelMuted(@Path(a = "channel_url") String str, @HeaderMap Map<String, String> map);

    @GET(a = "/api/v1/sendbird/chat_enabled")
    Observable<ChatEnabled> isChatEnabled(@HeaderMap Map<String, String> map);

    @PUT(a = "/api/v1/sendbird/group_channels/{channel_url}/mute")
    Observable<Response<Void>> muteChannel(@Path(a = "channel_url") String str, @HeaderMap Map<String, String> map);

    @GET(a = "/api/v1/sendbird/me")
    Observable<SendBirdAccessTokenData> sendbirdAccessToken(@HeaderMap Map<String, String> map);

    @GET(a = "/api/v1/sendbird/config")
    Observable<SendBirdConfig> sendbirdConfig(@HeaderMap Map<String, String> map);

    @PUT(a = "/api/v1/sendbird/chat_enabled")
    Observable<Response<Void>> setChatEnabled(@HeaderMap Map<String, String> map);

    @DELETE(a = "/api/v1/sendbird/group_channels/{channel_url}/mute")
    Observable<Response<Void>> unmuteChannel(@Path(a = "channel_url") String str, @HeaderMap Map<String, String> map);
}
