package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import android.net.Uri;
import android.text.TextUtils;
import android.text.style.URLSpan;
import bolts.Task;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.toolbox.RequestFuture;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.instabug.chat.model.Attachment;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.Session.SessionId;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketClientListener;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketConnection;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditTransformer;
import com.reddit.datalibrary.frontpage.requests.models.frontpage.TopicWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentEditResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.GenericResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.HtmlText;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkEditResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreCommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.NotificationWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.RedditVideo;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.SearchResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitImageResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitVideoResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import com.reddit.datalibrary.frontpage.requests.models.v2.BadgeCount;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.DeserializationPostProcessable;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease.Field;
import com.reddit.datalibrary.frontpage.requests.models.v2.Identifiable;
import com.reddit.datalibrary.frontpage.requests.models.v2.KarmaItem;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListingModel;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RedditLinkImageInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveCommentsUpdate.LiveComment;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveCommentsUpdater;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.EmbedsReady;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.SettingsUpdated;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.ThreadCompleted;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.UpdateAdded;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.UpdateDeleted;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.UpdateStricken;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdate.ViewerCountChanged;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdater;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.RedirectUpdate.Redirect;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.RedirectUpdater;
import com.reddit.datalibrary.frontpage.service.api.AwsFileUploadRequest;
import com.reddit.datalibrary.frontpage.service.api.FileUploadResponse;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import com.reddit.frontpage.util.JsonUtil;
import com.reddit.frontpage.util.Util;
import dagger.Lazy;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.PostProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Inject;
import net.hockeyapp.android.UpdateFragment;
import okhttp3.Response;
import timber.log.Timber;

public class RedditClient {
    public static final Type f10867b = new C15533().f8835b;
    public static final Type f10868c = new C15544().f8835b;
    public static final Type f10869d = new C15555().f8835b;
    private static final ConcurrentMap<SessionId, RedditClient> f10870g = new ConcurrentHashMap();
    private static final Type f10871h = new C15511().f8835b;
    private static final Type f10872i = new C15522().f8835b;
    private static final Type f10873j = new C15566().f8835b;
    private static final Type f10874k = new C15577().f8835b;
    private static final Type f10875l = new C15588().f8835b;
    private static final Type f10876m = new C15599().f8835b;
    private static final Type f10877n = new TypeToken<List<LinkFlair>>() {
    }.f8835b;
    private static Gson f10878o;
    private static final Object f10879p = new Object();
    public final Cannon f10880a;
    @Inject
    Lazy<WebSocketClient> f10881e;
    private final Cannon f10882f;

    static class C15511 extends TypeToken<SendBirdAccessTokenData> {
        C15511() {
        }
    }

    static class C15522 extends TypeToken<Listing<Link>> {
        C15522() {
        }
    }

    static class C15533 extends TypeToken<Listing<Subreddit>> {
        C15533() {
        }
    }

    static class C15544 extends TypeToken<Listing<Comment>> {
        C15544() {
        }
    }

    static class C15555 extends TypeToken<List<Multireddit>> {
        C15555() {
        }
    }

    static class C15566 extends TypeToken<Listing<LiveUpdate>> {
        C15566() {
        }
    }

    static class C15577 extends TypeToken<List<KarmaItem>> {
        C15577() {
        }
    }

    static class C15588 extends TypeToken<List<SubredditNameInfo>> {
        C15588() {
        }
    }

    static class C15599 extends TypeToken<RedditLinkImageInfo> {
        C15599() {
        }
    }

    private static class CommentListDeserializer implements JsonDeserializer<List<ReplyableWrapper>> {
        private CommentListDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            type = new ArrayList();
            jsonElement = jsonElement.m7501i().iterator();
            while (jsonElement.hasNext()) {
                Object obj;
                JsonElement jsonElement2 = (JsonElement) jsonElement.next();
                String c = jsonElement2.m7500h().m14933c("kind").mo2461c();
                Object obj2 = -1;
                int hashCode = c.hashCode();
                if (hashCode != 3645) {
                    if (hashCode != 3648) {
                        if (hashCode != 3357525) {
                            if (hashCode == 1084542847) {
                                if (c.equals(Kind.NOTIFICATION)) {
                                    obj2 = 3;
                                }
                            }
                        } else if (c.equals(Kind.MORE)) {
                            obj2 = 1;
                        }
                    } else if (c.equals(Kind.MESSAGE)) {
                        obj2 = 2;
                    }
                } else if (c.equals(Kind.COMMENT)) {
                    obj2 = null;
                }
                switch (obj2) {
                    case null:
                        if (!jsonElement2.m7500h().m14935e("data").m14932b("was_comment")) {
                            obj = (ReplyableWrapper) jsonDeserializationContext.mo2504a(jsonElement2, CommentWrapper.class);
                            break;
                        }
                        obj = (ReplyableWrapper) jsonDeserializationContext.mo2504a(jsonElement2, MessageWrapper.class);
                        break;
                    case 1:
                        obj = (ReplyableWrapper) jsonDeserializationContext.mo2504a(jsonElement2, MoreWrapper.class);
                        break;
                    case 2:
                        obj = (ReplyableWrapper) jsonDeserializationContext.mo2504a(jsonElement2, MessageWrapper.class);
                        break;
                    case 3:
                        obj = (ReplyableWrapper) jsonDeserializationContext.mo2504a(jsonElement2, NotificationWrapper.class);
                        break;
                    default:
                        continue;
                }
                type.add(obj);
            }
            return type;
        }
    }

    public static class CommentResponseDeserializer implements JsonDeserializer<CommentResponse> {
        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7501i();
            return new CommentResponse((Link) jsonDeserializationContext.mo2504a(jsonElement.m14920a(0).m7500h().m14933c("data").m7500h().m14933c("children").m7501i().m14920a(0).m7500h().m14933c("data"), Link.class), (CommentListing) jsonDeserializationContext.mo2504a(jsonElement.m14920a(1), CommentListing.class));
        }
    }

    private static class DbFlowExclusionStrategy implements ExclusionStrategy {
        private DbFlowExclusionStrategy() {
        }

        public final boolean mo3035a(FieldAttributes fieldAttributes) {
            return fieldAttributes.f8708a.getType().equals(ModelAdapter.class);
        }
    }

    private static class DeserializationPostProcessor implements PostProcessor<DeserializationPostProcessable> {
        public final /* bridge */ /* synthetic */ void m16329a(JsonElement jsonElement, Object obj, Gson gson) {
        }

        private DeserializationPostProcessor() {
        }

        public final /* synthetic */ void m16330a(Object obj) {
            ((DeserializationPostProcessable) obj).postDeserialization();
        }
    }

    public static class HtmlTextDeserializer implements JsonDeserializer<HtmlText> {
        private final Uri f16296a;

        public HtmlTextDeserializer(Uri uri) {
            this.f16296a = uri;
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if ((jsonElement instanceof JsonPrimitive) == null || (jsonElement.m7502j().f14993a instanceof String) == null) {
                return null;
            }
            jsonElement = HtmlText.m9386a(jsonElement.m7502j().mo2461c());
            int i = 0;
            type = new HtmlText(HtmlText.m9387a(jsonElement, 0, jsonElement.length()));
            jsonElement = this.f16296a;
            URLSpan[] uRLSpanArr = (URLSpan[]) type.getSpans(0, type.length(), URLSpan.class);
            int length = uRLSpanArr.length;
            while (i < length) {
                URLSpan uRLSpan = uRLSpanArr[i];
                String url = uRLSpan.getURL();
                Uri parse = Uri.parse(url);
                if (parse.isRelative()) {
                    url = parse.buildUpon().scheme(jsonElement.getScheme()).authority(jsonElement.getAuthority()).build().toString();
                }
                int spanStart = type.getSpanStart(uRLSpan);
                int spanEnd = type.getSpanEnd(uRLSpan);
                int spanFlags = type.getSpanFlags(uRLSpan);
                type.removeSpan(uRLSpan);
                type.setSpan(new URLSpan(url), spanStart, spanEnd, spanFlags);
                i++;
            }
            return type;
        }
    }

    private static class KarmaItemListDeserializer implements JsonDeserializer<List<KarmaItem>> {
        private KarmaItemListDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = ((JsonElement) Optional.m6897c(jsonElement.m7500h().m14933c("data")).mo2314a(new JsonArray())).m7501i();
            type = new ArrayList(jsonElement.m14919a());
            jsonElement = jsonElement.iterator();
            while (jsonElement.hasNext()) {
                type.add((KarmaItem) jsonDeserializationContext.mo2504a((JsonElement) jsonElement.next(), KarmaItem.class));
            }
            return type;
        }
    }

    private static class LinkDeserializer implements JsonDeserializer<Link> {
        private LinkDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return (Link) jsonDeserializationContext.mo2504a(jsonElement.m7500h(), ClientLink.class);
        }
    }

    private static class LinkPreviewDeserializer implements JsonDeserializer<LinkPreview> {
        private LinkPreviewDeserializer() {
        }

        private static String m16334a(JsonElement jsonElement, String str) {
            jsonElement = jsonElement.m7500h().m14933c(str);
            if (jsonElement == null) {
                return null;
            }
            return jsonElement.mo2461c();
        }

        private static int m16336b(JsonElement jsonElement, String str) {
            jsonElement = jsonElement.m7500h().m14933c(str);
            if (jsonElement == null) {
                return null;
            }
            return jsonElement.mo2464f();
        }

        private static List<ImageResolution> m16335a(JsonDeserializationContext jsonDeserializationContext, JsonElement jsonElement) {
            List<ImageResolution> arrayList = new ArrayList();
            jsonElement = jsonElement.m7500h().m14933c("resolutions");
            if (jsonElement != null) {
                jsonElement = jsonElement.m7501i().iterator();
                while (jsonElement.hasNext()) {
                    arrayList.add(jsonDeserializationContext.mo2504a((JsonElement) jsonElement.next(), ImageResolution.class));
                }
            }
            return arrayList;
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonDeserializationContext jsonDeserializationContext2 = jsonDeserializationContext;
            RedditVideo redditVideo = null;
            if (jsonElement == null) {
                return null;
            }
            ImageResolution imageResolution;
            ImageResolution imageResolution2;
            ImageResolution imageResolution3;
            boolean z = false;
            JsonElement a = jsonElement.m7500h().m14933c("images").m7501i().m14920a(0);
            JsonElement c = a.m7500h().m14933c("source");
            List a2 = m16335a(jsonDeserializationContext2, a);
            ImageResolution imageResolution4 = (ImageResolution) jsonDeserializationContext2.mo2504a(c, ImageResolution.class);
            a2.add(imageResolution4);
            a = jsonElement.m7500h().m14933c("images").m7501i().m14920a(0).m7500h().m14933c("variants");
            c = a.m7500h().m14933c("obfuscated");
            JsonElement c2 = a.m7500h().m14933c("gif");
            a = a.m7500h().m14933c("mp4");
            List arrayList = new ArrayList();
            if (c != null) {
                JsonElement c3 = c.m7500h().m14933c("source");
                arrayList.addAll(m16335a(jsonDeserializationContext2, c));
                ImageResolution imageResolution5 = (ImageResolution) jsonDeserializationContext2.mo2504a(c3, ImageResolution.class);
                arrayList.add(imageResolution5);
                imageResolution = imageResolution5;
            } else {
                imageResolution = null;
            }
            List arrayList2 = new ArrayList();
            if (c2 != null) {
                c = c2.m7500h().m14933c("source");
                arrayList2.addAll(m16335a(jsonDeserializationContext2, c2));
                imageResolution5 = (ImageResolution) jsonDeserializationContext2.mo2504a(c, ImageResolution.class);
                arrayList2.add(imageResolution5);
                imageResolution2 = imageResolution5;
            } else {
                imageResolution2 = null;
            }
            List arrayList3 = new ArrayList();
            if (a != null) {
                c = a.m7500h().m14933c("source");
                arrayList3.addAll(m16335a(jsonDeserializationContext2, a));
                ImageResolution imageResolution6 = (ImageResolution) jsonDeserializationContext2.mo2504a(c, ImageResolution.class);
                arrayList3.add(imageResolution6);
                imageResolution3 = imageResolution6;
            } else {
                imageResolution3 = null;
            }
            JsonElement c4 = jsonElement.m7500h().m14933c("reddit_video_preview");
            if (c4 != null) {
                redditVideo = new RedditVideo();
                redditVideo.setHeight(m16336b(c4, "height"));
                redditVideo.setWidth(m16336b(c4, "width"));
                redditVideo.setDashUrl(m16334a(c4, "dash_url"));
                redditVideo.setDuration(m16336b(c4, State.KEY_DURATION));
                redditVideo.setHlsUrl(m16334a(c4, "hls_url"));
                JsonElement c5 = c4.m7500h().m14933c("is_gif");
                if (c5 != null) {
                    z = c5.mo2465g();
                }
                redditVideo.setGif(z);
                redditVideo.setFallbackUrl(m16334a(c4, "fallback_url"));
                redditVideo.setScrubberMediaUrl(m16334a(c4, "scrubber_media_url"));
                redditVideo.setTranscodingStatus(m16334a(c4, "transcoding_status"));
            }
            return new LinkPreview(imageResolution4, a2, imageResolution, arrayList, imageResolution2, arrayList2, imageResolution3, arrayList3, redditVideo);
        }
    }

    private static abstract class ListingDeserializer<T extends Identifiable> implements JsonDeserializer<Listing<T>> {
        Map<String, Class<? extends T>> f16297a;

        ListingDeserializer(Map<String, Class<? extends T>> map) {
            this.f16297a = map;
        }

        ListingDeserializer(String str, Class<? extends T> cls) {
            this.f16297a = new HashMap();
            this.f16297a.put(str, cls);
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if ((jsonElement instanceof JsonObject) == null) {
                return new ListingModel(Collections.emptyList(), null, null, null);
            }
            jsonElement = jsonElement.m7500h().m14933c("data");
            type = jsonElement.m7500h().m14933c("children").m7501i();
            List arrayList = new ArrayList(type.m14919a());
            type = type.iterator();
            while (type.hasNext()) {
                JsonElement h = ((JsonElement) type.next()).m7500h();
                JsonElement c = h.m14933c("kind");
                Type type2 = c != null ? (Class) this.f16297a.get(c.mo2461c()) : null;
                if (type2 != null) {
                    arrayList.add((Identifiable) jsonDeserializationContext.mo2504a(h, type2));
                }
            }
            return new ListingModel(arrayList, JsonUtil.a(jsonElement, "before"), JsonUtil.a(jsonElement, "after"), JsonUtil.a(jsonElement, "dist"));
        }
    }

    private static class LiveCommentsWebSocketListener implements WebSocketClientListener {
        private final LiveCommentsUpdater f16298a;

        private LiveCommentsWebSocketListener(LiveCommentsUpdater liveCommentsUpdater) {
            this.f16298a = liveCommentsUpdater;
        }

        public final void mo3036a(String str) {
            final LiveComment liveComment = (LiveComment) RedditClient.f10878o.m7482a(str, LiveComment.class);
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ LiveCommentsWebSocketListener f10853b;

                public /* synthetic */ Object call() throws Exception {
                    this.f10853b.f16298a.a(liveComment);
                    return null;
                }
            }, Task.f2715b);
        }

        public final void mo3037a(final Throwable th, final Response response) {
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ LiveCommentsWebSocketListener f10856c;

                public /* synthetic */ Object call() throws Exception {
                    this.f10856c.f16298a.a(th, response.message());
                    return null;
                }
            }, Task.f2715b);
        }
    }

    private static class LiveThreadSettingsUpdatedDeserializer implements JsonDeserializer<SettingsUpdated> {
        private LiveThreadSettingsUpdatedDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            LiveThread liveThread = (LiveThread) jsonDeserializationContext.mo2504a(jsonElement, LiveThread.class);
            return liveThread != null ? new SettingsUpdated(liveThread) : null;
        }
    }

    private static class LiveThreadUpdateDeletedDeserializer implements JsonDeserializer<UpdateDeleted> {
        private LiveThreadUpdateDeletedDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.mo2461c();
            return jsonElement != null ? new UpdateDeleted(jsonElement) : null;
        }
    }

    private static class LiveThreadUpdateStrickenDeserializer implements JsonDeserializer<UpdateStricken> {
        private LiveThreadUpdateStrickenDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.mo2461c();
            return jsonElement != null ? new UpdateStricken(jsonElement) : null;
        }
    }

    private static class LiveThreadWebSocketListener implements WebSocketClientListener {
        private final LiveThreadUpdater f16299a;

        private LiveThreadWebSocketListener(LiveThreadUpdater liveThreadUpdater) {
            this.f16299a = liveThreadUpdater;
        }

        public final void mo3036a(String str) {
            final LiveThreadUpdate liveThreadUpdate = (LiveThreadUpdate) RedditClient.f10878o.m7482a(str, LiveThreadUpdate.class);
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ LiveThreadWebSocketListener f10858b;

                public /* synthetic */ Object call() throws Exception {
                    liveThreadUpdate.a(this.f10858b.f16299a);
                    return null;
                }
            }, Task.f2715b);
        }

        public final void mo3037a(final Throwable th, final Response response) {
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ LiveThreadWebSocketListener f10861c;

                public /* synthetic */ Object call() throws Exception {
                    response.message();
                    return null;
                }
            }, Task.f2715b);
        }
    }

    private static class ModQueueCommentsDeserializer implements JsonDeserializer<Listing<Listable>> {
        Map<String, Class<? extends Listable>> f16300a = new HashMap();

        ModQueueCommentsDeserializer() {
            this.f16300a.put(Kind.COMMENT, Comment.class);
            this.f16300a.put(Kind.LINK, ClientLink.class);
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7500h().m14933c("data");
            type = jsonElement.m7500h().m14933c("children").m7501i();
            List arrayList = new ArrayList();
            type = type.iterator();
            while (true) {
                Type type2 = null;
                if (!type.hasNext()) {
                    return new ListingModel(arrayList, JsonUtil.a(jsonElement, "before"), JsonUtil.a(jsonElement, "after"), null);
                }
                JsonElement h = ((JsonElement) type.next()).m7500h();
                JsonElement c = h.m14933c("kind");
                if (c != null) {
                    type2 = (Class) this.f16300a.get(c.mo2461c());
                }
                if (type2 != null) {
                    if (type2 == Comment.class) {
                        arrayList.add((Comment) jsonDeserializationContext.mo2504a(h.m14933c("data").m7500h(), Comment.class));
                    } else {
                        arrayList.add(jsonDeserializationContext.mo2504a(h, type2));
                    }
                }
            }
        }
    }

    private static class MultiredditListDeserializer implements JsonDeserializer<List<Multireddit>> {
        private MultiredditListDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7501i();
            type = new ArrayList(jsonElement.m14919a());
            jsonElement = jsonElement.iterator();
            while (jsonElement.hasNext()) {
                type.add((Multireddit) jsonDeserializationContext.mo2504a((JsonElement) jsonElement.next(), Multireddit.class));
            }
            return type;
        }
    }

    static class PolymorphicDeserializer<T> implements JsonDeserializer<T> {
        private final String f16301a;
        private final String f16302b;
        private final Map<String, Class<? extends T>> f16303c;

        PolymorphicDeserializer(String str, String str2, Map<String, Class<? extends T>> map) {
            this.f16301a = str;
            this.f16302b = str2;
            this.f16303c = map;
        }

        public final T mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7500h();
            Class cls = (Class) this.f16303c.get(jsonElement.m14933c(this.f16301a).mo2461c());
            if (cls != null) {
                jsonElement = jsonElement.m14933c(this.f16302b);
                if (jsonElement != null) {
                    return jsonDeserializationContext.mo2504a(jsonElement, cls);
                }
            }
            return null;
        }
    }

    private static class RedditLinkPreviewDeserializer implements JsonDeserializer<RedditLinkImageInfo> {
        private RedditLinkPreviewDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            type = null;
            if (jsonElement == null) {
                return null;
            }
            jsonElement = jsonElement.m7501i().m14920a(0).m7500h().m14933c("data").m7500h().m14933c("children").m7501i().m14920a(0).m7500h().m14933c("data").m7500h().m14933c("preview").m7500h();
            ImageResolution imageResolution = (ImageResolution) jsonDeserializationContext.mo2504a(jsonElement.m7500h().m14933c("images").m7501i().m14920a(0).m7500h().m14933c("source"), ImageResolution.class);
            jsonElement = jsonElement.m7500h().m14933c("images").m7501i().m14920a(0).m7500h().m14933c("variants");
            JsonElement c = jsonElement.m7500h().m14933c("obfuscated");
            JsonElement c2 = jsonElement.m7500h().m14933c("gif");
            jsonElement = jsonElement.m7500h().m14933c("mp4");
            ImageResolution imageResolution2 = c != null ? (ImageResolution) jsonDeserializationContext.mo2504a(c.m7500h().m14933c("source"), ImageResolution.class) : null;
            ImageResolution imageResolution3 = c2 != null ? (ImageResolution) jsonDeserializationContext.mo2504a(c2.m7500h().m14933c("source"), ImageResolution.class) : null;
            if (jsonElement != null) {
                type = (ImageResolution) jsonDeserializationContext.mo2504a(jsonElement.m7500h().m14933c("source"), ImageResolution.class);
            }
            return new RedditLinkImageInfo(imageResolution, imageResolution2, imageResolution3, type);
        }
    }

    private static class RedirectsWebSocketListener implements WebSocketClientListener {
        private final RedirectUpdater f16304a;

        private RedirectsWebSocketListener(RedirectUpdater redirectUpdater) {
            this.f16304a = redirectUpdater;
        }

        public final void mo3036a(String str) {
            final Redirect redirect = (Redirect) RedditClient.f10878o.m7482a(str, Redirect.class);
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ RedirectsWebSocketListener f10863b;

                public /* synthetic */ Object call() throws Exception {
                    this.f10863b.f16304a.onRedirect(redirect.payload.link);
                    return null;
                }
            }, Task.f2715b);
        }

        public final void mo3037a(final Throwable th, final Response response) {
            Task.m2408a(new Callable<Void>(this) {
                final /* synthetic */ RedirectsWebSocketListener f10866c;

                public /* synthetic */ Object call() throws Exception {
                    this.f10866c.f16304a.onFailure(th, response.message());
                    return null;
                }
            }, Task.f2715b);
        }
    }

    static class ReplyableListingTypeAdapterFactory implements TypeAdapterFactory {
        private final Set<Class<?>> f16307a = new HashSet(2);

        ReplyableListingTypeAdapterFactory(Class<?>... clsArr) {
            for (int i = 0; i < 2; i++) {
                this.f16307a.add(clsArr[i]);
            }
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            if (!this.f16307a.contains(typeToken.f8834a)) {
                return null;
            }
            gson = gson.m7474a((TypeAdapterFactory) this, (TypeToken) typeToken);
            return new TypeAdapter<T>(this) {
                final /* synthetic */ ReplyableListingTypeAdapterFactory f16306b;

                public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
                }

                public final T mo2458a(JsonReader jsonReader) throws IOException {
                    JsonElement a = Streams.m7553a(jsonReader);
                    return !(a instanceof JsonObject) ? null : gson.m7509a(a);
                }
            };
        }
    }

    public static class SearchResponseDeserializer implements JsonDeserializer<SearchResponse> {
        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if ((jsonElement instanceof JsonArray) != null) {
                type = jsonElement.m7501i().m14920a(0);
                jsonElement = jsonElement.m7501i().m14920a(1);
            } else {
                type = null;
                jsonElement = jsonElement.m7500h();
            }
            return new SearchResponse(type != null ? (SubredditListing) jsonDeserializationContext.mo2504a(type, SubredditListing.class) : new SubredditListing(), (LinkListing) jsonDeserializationContext.mo2504a(jsonElement, LinkListing.class));
        }
    }

    private static class SendBirdAccessTokenResponseDeserializer implements JsonDeserializer<SendBirdAccessTokenData> {
        private SendBirdAccessTokenResponseDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7500h();
            return new SendBirdAccessTokenData(jsonElement.m14933c("valid_until").mo2463e(), jsonElement.m14933c("sb_access_token").mo2461c());
        }
    }

    private static class SendBirdConfigDeserializer implements JsonDeserializer<SendBirdConfig> {
        private SendBirdConfigDeserializer() {
        }

        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return new SendBirdConfig(jsonElement.m7500h().m14933c("proxy_host").mo2461c(), jsonElement.m7500h().m14933c("max_message_length").mo2464f());
        }
    }

    public static class SubredditSearchListDeserializer implements JsonDeserializer<List<SubredditNameInfo>> {
        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.m7500h().m14933c("subreddits").m7501i();
            type = new ArrayList(jsonElement.m14919a());
            jsonElement = jsonElement.iterator();
            while (jsonElement.hasNext()) {
                type.add(jsonDeserializationContext.mo2504a((JsonElement) jsonElement.next(), SubredditNameInfo.class));
            }
            return type;
        }
    }

    public static class ThingWrapperListDeserializer implements JsonDeserializer<List<ThingWrapper>> {
        public final /* synthetic */ Object mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if ((jsonElement instanceof JsonArray) == null) {
                return Collections.emptyList();
            }
            type = new ArrayList();
            jsonElement = jsonElement.m7501i().iterator();
            while (jsonElement.hasNext()) {
                Object obj;
                JsonElement jsonElement2 = (JsonElement) jsonElement.next();
                String c = jsonElement2.m7500h().m14933c("kind").mo2461c();
                Object obj2 = -1;
                int hashCode = c.hashCode();
                if (hashCode != 3649) {
                    if (hashCode != 3357525) {
                        if (hashCode != 110546223) {
                            switch (hashCode) {
                                case 3645:
                                    if (c.equals(Kind.COMMENT)) {
                                        obj2 = null;
                                        break;
                                    }
                                    break;
                                case 3646:
                                    if (c.equals(Kind.ACCOUNT)) {
                                        obj2 = 4;
                                        break;
                                    }
                                    break;
                                case 3647:
                                    if (c.equals(Kind.LINK)) {
                                        obj2 = 1;
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } else if (c.equals(Kind.TOPIC)) {
                            obj2 = 2;
                        }
                    } else if (c.equals(Kind.MORE)) {
                        obj2 = 5;
                    }
                } else if (c.equals(Kind.SUBREDDIT)) {
                    obj2 = 3;
                }
                switch (obj2) {
                    case null:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, CommentWrapper.class);
                        break;
                    case 1:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, LinkWrapper.class);
                        break;
                    case 2:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, TopicWrapper.class);
                        break;
                    case 3:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, SubredditWrapper.class);
                        break;
                    case 4:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, AccountWrapper.class);
                        break;
                    case 5:
                        obj = (ThingWrapper) jsonDeserializationContext.mo2504a(jsonElement2, MoreWrapper.class);
                        break;
                    default:
                        continue;
                }
                type.add(obj);
            }
            return type;
        }
    }

    static class WrappedTypeAdapterFactory implements TypeAdapterFactory {
        private final String f16310a;
        private final Set<Class<?>> f16311b;

        WrappedTypeAdapterFactory(String str, Class<?>... clsArr) {
            this.f16310a = str;
            this.f16311b = new HashSet(clsArr.length);
            for (Object add : clsArr) {
                this.f16311b.add(add);
            }
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            if (!this.f16311b.contains(typeToken.f8834a)) {
                return null;
            }
            gson = gson.m7474a((TypeAdapterFactory) this, (TypeToken) typeToken);
            return new TypeAdapter<T>(this) {
                final /* synthetic */ WrappedTypeAdapterFactory f16309b;

                public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
                }

                public final T mo2458a(JsonReader jsonReader) throws IOException {
                    JsonElement a = Streams.m7553a(jsonReader);
                    JsonObject h = a.m7500h();
                    if (h.m14932b(this.f16309b.f16310a)) {
                        return gson.m7509a(h.m14933c(this.f16309b.f16310a));
                    }
                    return gson.m7509a(a);
                }
            };
        }
    }

    private static class LinkListingDeserializer extends ListingDeserializer<Listable> {
        LinkListingDeserializer() {
            Map hashMap = new HashMap();
            hashMap.put(Kind.LINK, ClientLink.class);
            hashMap.put("banner", Banner.class);
            if (FrontpageSettings.m9011a().m9059t().experiments.m9358a().active) {
                hashMap.put(Kind.LIVE_UPDATE_EVENT, LiveThread.class);
            }
            super(hashMap);
        }
    }

    private static class LiveThreadUpdateDeserializer extends PolymorphicDeserializer<LiveThreadUpdate> {
        LiveThreadUpdateDeserializer() {
            Map hashMap = new HashMap();
            hashMap.put("activity", ViewerCountChanged.class);
            hashMap.put("update", UpdateAdded.class);
            hashMap.put("strike", UpdateStricken.class);
            hashMap.put("delete", UpdateDeleted.class);
            hashMap.put("settings", SettingsUpdated.class);
            hashMap.put("complete", ThreadCompleted.class);
            hashMap.put("embeds_ready", EmbedsReady.class);
            super("type", "payload", hashMap);
        }
    }

    private static class LiveUpdateListingDeserializer extends ListingDeserializer<LiveUpdate> {
        LiveUpdateListingDeserializer() {
            super("LiveUpdate", LiveUpdate.class);
        }
    }

    private static class SubredditListingDeserializer extends ListingDeserializer<Subreddit> {
        SubredditListingDeserializer() {
            super(Kind.SUBREDDIT, Subreddit.class);
        }
    }

    private RedditClient(Session session) {
        FrontpageApplication.f().a(this);
        String i = FrontpageSettings.m9011a().m9044i();
        String j = FrontpageSettings.m9011a().m9046j();
        FrontpageApplication frontpageApplication = FrontpageApplication.a;
        Builder builder = new Builder(Uri.parse(i));
        builder.f10888a = Config.f10814b;
        Builder a = builder.m9313a(new RedditTransformer()).m9312a(new SessionDynamic(session));
        a.f10889b = new SessionRetryPolicyFactory(session);
        a.f10891d = new SessionRequestTagger(session);
        a.f10890c = m9223g();
        if (FrontpageSettings.m9011a().m9049k()) {
            a.m9312a(new StagingCookieDynamic());
        }
        this.f10880a = a.m9314a();
        FrontpageApplication frontpageApplication2 = FrontpageApplication.a;
        a = new Builder(Uri.parse(j));
        a.f10888a = Config.f10814b;
        a = a.m9313a(new RedditTransformer()).m9312a(new SessionDynamic(session)).m9312a(new SessionUserIdDynamic(session));
        a.f10889b = new SessionRetryPolicyFactory(session);
        a.f10891d = new SessionRequestTagger(session);
        a.f10890c = m9223g();
        this.f10882f = a.m9314a();
    }

    public final RedditRequestBuilder<RedditLinkImageInfo> m9242a(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, f10876m).m9322a(0).m9325a(str);
    }

    public final ListingRequestBuilder2<Listing<? extends Link>> m9249b(String str) {
        return (ListingRequestBuilder2) new ListingRequestBuilder2(this.f10882f, f10872i).m9323a(Priority.IMMEDIATE).m9325a("redditmobile/1/mainfeed").m9335c(str);
    }

    public final ListingRequestBuilder2<Listing<? extends Link>> m9236a(String str, String str2) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10872i);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9323a(Priority.HIGH).m9325a("r").m9325a(str).m9335c(str2);
    }

    public final ListingRequestBuilder2<Listing<? extends Listable>> m9256c(String str) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10868c);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9323a(Priority.HIGH).m9325a("r").m9325a(str).m9325a("about").m9325a("modqueue");
    }

    public final ListingRequestBuilder2<Listing<? extends Link>> m9250b(String str, String str2) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10872i);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9323a(Priority.HIGH).m9325a("me/m").m9325a(str).m9335c(str2);
    }

    public final ListingRequestBuilder2<Listing<Subreddit>> m9262d(String str) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10867b);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9325a("subreddits/mine/subscriber").m9327a("limit", "100").m9335c(str);
    }

    public final ListingRequestBuilder2<Listing<Subreddit>> m9267e(String str) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10867b);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9325a("subreddits/mine/moderator").m9327a("limit", "100").m9335c(str);
    }

    public final ListingRequestBuilder2<Listing<Subreddit>> m9269f(String str) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10867b);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9325a("subreddits/default").m9327a("limit", "100").m9335c(str);
    }

    public final RedditRequestBuilder<List<Multireddit>> m9272g(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, f10869d);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9325a("api/multi/mine").m9335c(str);
    }

    public final RedditRequestBuilder<Multireddit> m9258c(String str, String str2) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, Multireddit.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9325a("api/multi/user").m9325a(str).m9325a("m").m9325a(str2).m9327a("expand_srs", "true");
    }

    public final RequestBuilder<Listing<LiveUpdate>> m9273h(String str) {
        RequestBuilder listingRequestBuilder2 = new ListingRequestBuilder2(this.f10880a, f10873j);
        listingRequestBuilder2.f16333l = true;
        return (ListingRequestBuilder2) listingRequestBuilder2.m9325a(Kind.LIVE).m9325a(str);
    }

    public final RequestBuilder<LiveThread> m9275i(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, LiveThread.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9325a(Kind.LIVE).m9325a(str).m9325a("about");
    }

    public final RedditRequestBuilder<Void> m9241a(Boolean bool, Collection<String> collection) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9323a(Priority.HIGH).m9325a("api/favorite").m9328a("make_favorite", bool.booleanValue()).m9333b("sr_name", Joiner.m6882a(",").mo2323b().m6886a((Iterable) collection));
    }

    public final RedditRequestBuilder<CommentResponse> m9264d(String str, String str2) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, CommentResponse.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9323a(Priority.HIGH).m9325a("comments").m9325a(str).m9335c(str2);
    }

    public final RedditRequestBuilder<MoreCommentResponse> m9246a(String str, List<String> list, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, MoreCommentResponse.class).m9322a(1).m9323a(Priority.IMMEDIATE).m9325a("api/morechildren").m9333b("link_id", str).m9333b("children", TextUtils.join(",", list)).m9335c(str2);
    }

    public final ListingRequestBuilder<MessageListing> m9277j(String str) {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, MessageListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9325a("message").m9325a(str).m9327a("limit", "100");
    }

    public final ListingRequestBuilder<MessageListing> m9279k(String str) {
        return (ListingRequestBuilder) new ListingRequestBuilder(this.f10880a, MessageListing.class).m9325a("message").m9325a("messages").m9325a(str);
    }

    public final ListingRequestBuilder<MessageListing> m9238a(String str, String str2, String str3) {
        ListingRequestBuilder<MessageListing> listingRequestBuilder = (ListingRequestBuilder) new ListingRequestBuilder(this.f10882f, MessageListing.class).m9325a("redditmobile/1/inbox");
        if (!TextUtils.isEmpty(str)) {
            listingRequestBuilder.m9327a("type", str);
        }
        if (TextUtils.isEmpty(str2) == null || TextUtils.isEmpty(str3) == null) {
            str = new HashMap(2);
            if (!TextUtils.isEmpty(str2)) {
                str.put("trending", str2);
            }
            if (TextUtils.isEmpty(str3) == null) {
                str.put("inbox", str3);
            }
            listingRequestBuilder.m19782d(f10878o.m7487b(str));
        }
        return listingRequestBuilder;
    }

    public final ListingRequestBuilder<MessageListing> m9237a() {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, MessageListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9325a("message/inbox_notifications").m9327a("limit", "100");
    }

    public final RedditRequestBuilder m9281l(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10882f, Object.class).m9322a(1).m9323a(Priority.LOW).m9325a("redditmobile/1/inbox/mark_read").m9333b("type", "trending_notification").m9333b("id", str);
    }

    public final RedditRequestBuilder<BadgeCount> m9252b() {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10882f, BadgeCount.class).m9325a("redditmobile/1/inbox/badge_count");
    }

    public final RedditRequestBuilder m9243a(String str, int i) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, Object.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9322a(1).m9323a(Priority.LOW).m9325a("api/vote").m9333b("dir", Integer.toString(i)).m9333b("id", str);
    }

    private ListingRequestBuilder<ThingWrapperListing> m9214J(String str) {
        return (ListingRequestBuilder) new ListingRequestBuilder(this.f10880a, ThingWrapperListing.class).m9323a(Priority.IMMEDIATE).m9325a("user").m9325a(str).m9325a("saved");
    }

    public final ListingRequestBuilder<ThingWrapperListing> m9283m(String str) {
        return (ListingRequestBuilder) m9214J(str).m9327a("type", "links");
    }

    public final ListingRequestBuilder<ThingWrapperListing> m9284n(String str) {
        return (ListingRequestBuilder) m9214J(str).m9327a("type", "comments");
    }

    public final RedditRequestBuilder<Object> m9286p(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9323a(Priority.LOW).m9325a("api/save").m9333b("id", str);
    }

    public final RedditRequestBuilder<Object> m9287q(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9323a(Priority.LOW).m9325a("api/unsave").m9333b("id", str);
    }

    public final RedditRequestBuilder<Account> m9257c() {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Account.class).m9323a(Priority.IMMEDIATE).m9325a("api/v1/me");
    }

    public final RedditRequestBuilder<AccountPrefs> m9263d() {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, AccountPrefs.class).m9325a("api/v1/me/prefs");
    }

    public final RedditRequestBuilder<AccountPrefs> m9239a(AccountPrefs accountPrefs) {
        try {
            return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, AccountPrefs.class).m9322a(7).m9325a("api/v1/me/prefs").m9332b("application/json").m9329a(JsonUtil.a(accountPrefs).getBytes("utf-8"));
        } catch (AccountPrefs accountPrefs2) {
            Timber.c(accountPrefs2, "Unable to encode subreddit to Json", new Object[0]);
            return null;
        }
    }

    public final RedditRequestBuilder<AccountWrapper> m9288r(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, AccountWrapper.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9323a(Priority.HIGH).m9325a("user").m9325a(str).m9325a("about");
    }

    public final ListingRequestBuilder<CommentListing> m9268e(String str, String str2) {
        return (ListingRequestBuilder) new ListingRequestBuilder(this.f10880a, CommentListing.class).m9323a(Priority.HIGH).m9325a("user").m9325a(str).m9325a("comments.json").m9335c(str2);
    }

    public final RedditRequestBuilder<SearchResponse> m9289s(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, SearchResponse.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9323a(Priority.IMMEDIATE).m9325a("search").m9327a("q", str).m9327a("type", "sr,link,user");
    }

    public final ListingRequestBuilder<SubredditListing> m9270f(String str, String str2) {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, SubredditListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9323a(Priority.IMMEDIATE).m9325a("search").m9327a("q", str).m9327a("type", "sr,user").m9335c(str2);
    }

    public final RedditRequestBuilder<List<SubredditNameInfo>> m9290t(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, f10875l).m9322a(1).m9325a("api/search_subreddits").m9327a("query", str).m9328a("include_over_18", UserSettingsStorage.m9093a().m9094a(SessionManager.m9191b().f10840c).f10768a.over_18);
    }

    public final ListingRequestBuilder<LinkListing> m9291u(String str) {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, LinkListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9323a(Priority.IMMEDIATE).m9325a("search").m9327a("q", str).m9327a("types", "link");
    }

    public final ListingRequestBuilder<LinkListing> m9251b(String str, String str2, String str3) {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, LinkListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9323a(Priority.IMMEDIATE).m9325a("r").m9325a(str).m9325a("search").m9327a("restrict_sr", "on").m9327a("q", str2).m9335c(str3);
    }

    public final ListingRequestBuilder<LinkListing> m9271g(String str, String str2) {
        RequestBuilder listingRequestBuilder = new ListingRequestBuilder(this.f10880a, LinkListing.class);
        listingRequestBuilder.f16333l = true;
        return (ListingRequestBuilder) listingRequestBuilder.m9323a(Priority.IMMEDIATE).m9325a("me/m").m9325a(str).m9325a("search").m9327a("restrict_sr", "on").m9327a("q", str2);
    }

    private RedditRequestBuilder<SubmitResponse> m9218a(String str, String str2, boolean z, boolean z2, String str3, String str4) {
        RequestBuilder requestBuilder = (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, SubmitResponse.class).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/submit").m9333b("api_type", "json").m9333b("sr", str).m9333b("title", str2).m9333b("send_replies", Boolean.toString(z2)).m9333b("resubmit", Boolean.toString(z));
        m9220a(requestBuilder, str4, str3);
        return requestBuilder;
    }

    private static void m9221a(RequestBuilder requestBuilder, String str, String str2, String str3) {
        Object obj = (TextUtils.isEmpty(str) || TextUtils.equals(Util.f(C1761R.string.add_location), str)) ? null : 1;
        if (obj != null) {
            requestBuilder.m9333b("location_name", str).m9333b("location_lat", str2).m9333b("location_long", str3);
        }
    }

    private static void m9220a(RequestBuilder requestBuilder, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            requestBuilder.m9333b("flair_id", str);
            if (TextUtils.isEmpty(str2) == null) {
                requestBuilder.m9333b("flair_text", str2);
            }
        }
    }

    public final RedditRequestBuilder<SubmitImageResponse> m9253b(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7, String str8) {
        RequestBuilder requestBuilder = (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, SubmitImageResponse.class).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/submit").m9333b("api_type", "json").m9333b("sr", str).m9333b("title", str2).m9333b("kind", Attachment.TYPE_IMAGE).m9333b(UpdateFragment.FRAGMENT_URL, str3).m9333b("send_replies", Boolean.toString(z2)).m9333b("resubmit", Boolean.toString(z));
        m9221a(requestBuilder, str4, str5, str6);
        m9220a(requestBuilder, str8, str7);
        return requestBuilder;
    }

    public final RedditRequestBuilder<SubmitVideoResponse> m9244a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, SubmitVideoResponse.class).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/submit").m9333b("api_type", "json").m9333b("sr", str).m9333b("title", str2).m9333b("kind", str6).m9333b(UpdateFragment.FRAGMENT_URL, str4).m9333b("video_poster_url", str5).m9333b("video_filename", str3).m9333b("send_replies", String.valueOf(z2)).m9333b("resubmit", String.valueOf(z));
    }

    public final RedditRequestBuilder<FileUploadLease> m9274h(String str, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, FileUploadLease.class).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/image_upload_s3.json").m9333b("raw_json", "1").m9333b("filepath", str).m9333b("mimetype", str2);
    }

    public final RedditRequestBuilder<FileUploadLease> m9276i(String str, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, FileUploadLease.class).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/video_upload_s3.json").m9333b("filepath", str).m9333b("mimetype", str2);
    }

    public final RedditRequestBuilder<CommentReplyResponse> m9278j(String str, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, new TypeToken<CommentReplyResponse>(this) {
            final /* synthetic */ RedditClient f16293d;

            {
                this.f16293d = r1;
            }
        }.f8835b).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/comment").m9333b("api_type", "json").m9333b("thing_id", str).m9333b("text", str2);
    }

    public final RedditRequestBuilder<CommentEditResponse> m9280k(String str, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, new TypeToken<CommentEditResponse>(this) {
            final /* synthetic */ RedditClient f16294d;

            {
                this.f16294d = r1;
            }
        }.f8835b).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/editusertext").m9333b("api_type", "json").m9333b("thing_id", str).m9333b("text", str2);
    }

    public final RedditRequestBuilder<LinkEditResponse> m9282l(String str, String str2) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, new TypeToken<LinkEditResponse>(this) {
            final /* synthetic */ RedditClient f16295d;

            {
                this.f16295d = r1;
            }
        }.f8835b).m9323a(Priority.IMMEDIATE).m9322a(1).m9325a("api/editusertext").m9333b("api_type", "json").m9333b("thing_id", str).m9333b("text", str2);
    }

    public final RedditRequestBuilder<GenericResponse> m9259c(String str, String str2, String str3) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, GenericResponse.class).m9322a(1).m9325a("api/compose").m9333b("api_type", "json").m9333b("subject", str).m9333b("text", str2).m9333b("to", str3);
    }

    public final RedditRequestBuilder<Object> m9248a(ArrayList<String> arrayList) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/hide").m9333b("id", TextUtils.join(",", arrayList));
    }

    public final RedditRequestBuilder<Object> m9255b(ArrayList<String> arrayList) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/unhide").m9333b("id", TextUtils.join(",", arrayList));
    }

    public final RedditRequestBuilder<Object> m9265d(String str, String str2, String str3) {
        RedditRequestBuilder redditRequestBuilder = (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9325a("api/report").m9333b("thing_id", str).m9333b("reason", str2);
        if (TextUtils.isEmpty(str3) == null) {
            redditRequestBuilder.m9333b("other_reason", str3);
        }
        return redditRequestBuilder;
    }

    public final RedditRequestBuilder<Object> m9261c(ArrayList<String> arrayList) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9325a("api/read_message").m9333b("id", TextUtils.join(",", arrayList));
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9292v(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/marknsfw").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9293w(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/unmarknsfw").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9294x(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/spoiler").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9295y(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/unspoiler").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9296z(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/lock").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9224A(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/unlock").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9247a(String str, boolean z) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/set_subreddit_sticky").m9333b("api_type", "json").m9333b("id", str).m9328a("state", z);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9225B(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/approve").m9333b("id", str);
    }

    @Deprecated
    private RedditRequestBuilder<Object> m9215K(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9333b("api_type", "json").m9325a("api/distinguish").m9333b("id", str);
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9226C(String str) {
        return (RedditRequestBuilder) m9215K(str).m9333b("how", "yes");
    }

    public final RedditRequestBuilder<Object> m9227D(String str) {
        return (RedditRequestBuilder) m9226C(str).m9333b("sticky", "yes");
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9228E(String str) {
        return (RedditRequestBuilder) m9215K(str).m9333b("how", "no");
    }

    @Deprecated
    public final RedditRequestBuilder<Object> m9254b(String str, boolean z) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9323a(Priority.LOW).m9322a(1).m9325a("api/remove").m9333b("id", str).m9328a(ModQueueOptionsPresenter.ACTION_SPAM, z);
    }

    public final RedditRequestBuilder<Object> m9229F(String str) {
        return (RedditRequestBuilder) new RedditRequestBuilder(this.f10880a, Object.class).m9322a(1).m9325a("api/del").m9333b("id", str);
    }

    public final RedditRequestBuilder<Object> m9230G(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, Object.class);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9322a(1).m9325a("api/v1/gold/gild/").m9325a(str).m9333b("id", str);
    }

    public final RequestBuilder<Object> m9231H(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String id = TimeZone.getDefault().getID();
        return new RequestBuilder(this.f10882f, Object.class).m9322a(1).m9325a("redditmobile/1/push/register").m9333b("push_token", str).m9333b("device_id", Config.f10819g).m9333b("client_id", Config.f10815c).m9326a("utc_timestamp_ms", currentTimeMillis).m9333b("tz_name", id).m9333b("language", Locale.getDefault().toString().replace(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, Operation.MINUS)).m9328a("debug", false);
    }

    public final RequestBuilder<Object> m9266e() {
        return new RequestBuilder(this.f10882f, Object.class).m9322a(1).m9325a("redditmobile/1/logout").m9333b("push_token", FirebaseInstanceId.m7356a().m7365d()).m9333b("device_id", Config.f10819g).m9333b("client_id", Config.f10815c).m9328a("debug", false);
    }

    public final RequestBuilder<List<LinkFlair>> m9232I(String str) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(this.f10880a, f10877n);
        redditRequestBuilder.f16333l = true;
        return (RedditRequestBuilder) redditRequestBuilder.m9323a(Priority.HIGH).m9325a("r").m9325a(str).m9325a("api/link_flair");
    }

    public final RedditRequestBuilder<Object> m9240a(LinkFlair linkFlair, String str, String str2) {
        String id = linkFlair != null ? linkFlair.getId() : "";
        if (TextUtils.isEmpty(str) && linkFlair != null) {
            str = linkFlair.getText();
        } else if (str == null) {
            str = "";
        }
        linkFlair = new RedditRequestBuilder(this.f10880a, Object.class);
        linkFlair.f16333l = true;
        return (RedditRequestBuilder) linkFlair.m9322a(1).m9325a("api/selectflair").m9333b("flair_template_id", id).m9333b("text", str).m9333b("link", str2);
    }

    public static FileUploadResponse m9219a(String str, InputStream inputStream, String str2, List<Field> list) {
        FrontpageApplication frontpageApplication = FrontpageApplication.a;
        Builder builder = new Builder(Uri.parse(str));
        builder.f10888a = Config.f10814b;
        Cannon a = builder.m9312a(new AwsUploadDynamic()).m9314a();
        RequestFuture a2 = RequestFuture.m10986a();
        String i = Util.i(str2);
        if (i == null) {
            i = "image/*";
        }
        Request awsFileUploadRequest = new AwsFileUploadRequest(str, a2, a2);
        for (Field field : list) {
            if (field.value != null) {
                awsFileUploadRequest.addFormData(field.name, field.value);
            }
        }
        awsFileUploadRequest.addFormData("file", i, inputStream, str2);
        a.f10898c.mo3040a(awsFileUploadRequest);
        try {
            return (FileUploadResponse) a2.get();
        } catch (String str3) {
            Timber.c(str3, str3.getMessage(), new Object[null]);
            return new FileUploadResponse();
        }
    }

    public final WebSocketConnection m9234a(Uri uri, LiveThreadUpdater liveThreadUpdater) {
        return ((WebSocketClient) this.f10881e.get()).m9303a(uri, new LiveThreadWebSocketListener(liveThreadUpdater));
    }

    public final WebSocketConnection m9233a(Uri uri, LiveCommentsUpdater liveCommentsUpdater) {
        return ((WebSocketClient) this.f10881e.get()).m9303a(uri, new LiveCommentsWebSocketListener(liveCommentsUpdater));
    }

    public final WebSocketConnection m9235a(Uri uri, RedirectUpdater redirectUpdater) {
        return ((WebSocketClient) this.f10881e.get()).m9303a(uri, new RedirectsWebSocketListener(redirectUpdater));
    }

    private static Gson m9223g() {
        if (f10878o == null) {
            GsonBuilder a = new GsonFireBuilder().a(DeserializationPostProcessable.class, new DeserializationPostProcessor()).a().m7490a(CommentResponse.class, new CommentResponseDeserializer()).m7490a(f10871h, new SendBirdAccessTokenResponseDeserializer()).m7490a(SendBirdConfig.class, new SendBirdConfigDeserializer()).m7490a(SearchResponse.class, new SearchResponseDeserializer()).m7490a(HtmlText.class, new HtmlTextDeserializer(Uri.parse("https://www.reddit.com"))).m7490a(new TypeToken<List<ReplyableWrapper>>() {
            }.f8835b, new CommentListDeserializer()).m7490a(new TypeToken<List<ThingWrapper>>() {
            }.f8835b, new ThingWrapperListDeserializer()).m7490a(f10872i, new LinkListingDeserializer()).m7490a(f10867b, new SubredditListingDeserializer()).m7490a(f10868c, new ModQueueCommentsDeserializer()).m7490a(f10869d, new MultiredditListDeserializer()).m7490a(f10873j, new LiveUpdateListingDeserializer()).m7490a(f10874k, new KarmaItemListDeserializer()).m7490a(f10876m, new RedditLinkPreviewDeserializer()).m7490a(LinkPreview.class, new LinkPreviewDeserializer()).m7490a(Link.class, new LinkDeserializer()).m7490a(LiveThreadUpdate.class, new LiveThreadUpdateDeserializer()).m7490a(UpdateDeleted.class, new LiveThreadUpdateDeletedDeserializer()).m7490a(UpdateStricken.class, new LiveThreadUpdateStrickenDeserializer()).m7490a(SettingsUpdated.class, new LiveThreadSettingsUpdatedDeserializer()).m7489a(new WrappedTypeAdapterFactory("data", Multireddit.class, Subreddit.class, SubredditInfo.class, LiveThread.class, ClientLink.class, Banner.class, LiveUpdate.class)).m7489a(new WrappedTypeAdapterFactory("payload", LiveComment.class)).m7489a(new ReplyableListingTypeAdapterFactory(CommentListing.class, MessageListing.class)).m7490a(f10875l, new SubredditSearchListDeserializer());
            ExclusionStrategy[] exclusionStrategyArr = new ExclusionStrategy[]{new DbFlowExclusionStrategy()};
            for (int i = 0; i <= 0; i++) {
                Object obj = exclusionStrategyArr[0];
                Excluder excluder = a.f8722a;
                Excluder a2 = excluder.m14966a();
                a2.f15029f = new ArrayList(excluder.f15029f);
                a2.f15029f.add(obj);
                a2.f15030g = new ArrayList(excluder.f15030g);
                a2.f15030g.add(obj);
                a.f8722a = a2;
            }
            f10878o = a.m7488a();
        }
        return f10878o;
    }

    public static RedditClient m9217a(SessionManager sessionManager) {
        return m9216a(sessionManager.f10840c);
    }

    public static RedditClient m9216a(Session session) {
        SessionId sessionId = session.f16288a;
        RedditClient redditClient = (RedditClient) f10870g.get(sessionId);
        if (redditClient == null) {
            synchronized (f10879p) {
                redditClient = (RedditClient) f10870g.get(sessionId);
                if (redditClient == null) {
                    redditClient = new RedditClient(session);
                    f10870g.put(sessionId, redditClient);
                }
            }
        }
        return redditClient;
    }

    public final ListingRequestBuilder2<Listing<? extends Link>> m9285o(String str) {
        return (ListingRequestBuilder2) new ListingRequestBuilder2(this.f10880a, f10872i).m9323a(Priority.HIGH).m9325a("user").m9325a(str).m9325a("submitted");
    }

    public final RedditRequestBuilder<SubmitResponse> m9245a(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7, String str8) {
        RequestBuilder requestBuilder = (RedditRequestBuilder) m9218a(str, str2, z, z2, str7, str8).m9333b("kind", "link").m9333b(UpdateFragment.FRAGMENT_URL, str3);
        m9221a(requestBuilder, str4, str5, str6);
        return requestBuilder;
    }

    public final RedditRequestBuilder<SubmitResponse> m9260c(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7, String str8) {
        RedditRequestBuilder<SubmitResponse> redditRequestBuilder = (RedditRequestBuilder) m9218a(str, str2, z, z2, str7, str8).m9333b("kind", "self").m9333b("text", str3);
        redditRequestBuilder.m9333b("location_name", str4).m9333b("location_lat", str5).m9333b("location_long", str6);
        return redditRequestBuilder;
    }
}
