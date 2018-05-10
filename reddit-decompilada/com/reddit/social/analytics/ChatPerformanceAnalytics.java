package com.reddit.social.analytics;

import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.TimingUtil;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.sendbird.android.GroupChannel.MemberState;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0010H\u0002¨\u0006\""}, d2 = {"Lcom/reddit/social/analytics/ChatPerformanceAnalytics;", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "()V", "channelClicked", "", "chatId", "", "channelLoaded", "cachedDataAvailable", "", "chatBottomNavClicked", "chatInboxDataLoaded", "chatInboxItems", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "createChatPerfAnalyticsEventBuilder", "Lcom/reddit/frontpage/commons/analytics/builders/ChatEventBuilder;", "action", "noun", "timeElapsed", "", "getGroupChannelsEnd", "memberState", "Lcom/sendbird/android/GroupChannel$MemberState;", "uuid", "Ljava/util/UUID;", "getGroupChannelsStart", "requestCompleted", "requestUrl", "Lokhttp3/HttpUrl;", "requestStarted", "sendPerfEvent", "builder", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatPerformanceAnalytics.kt */
public final class ChatPerformanceAnalytics implements ChatPerformanceAnalyticsContract {
    public static final Companion f29572a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/analytics/ChatPerformanceAnalytics$Companion;", "", "()V", "ACTION_LOAD", "", "CHAT_LOAD_CHANNEL_TAG", "CHAT_START_TAG", "NOUN_CHANNEL_CACHED", "NOUN_CHANNEL_NEW", "NOUN_INBOX_CACHED", "NOUN_INBOX_NEW", "NOUN_PROXY_REQUEST", "NOUN_PROXY_SENDBIRD", "REQUEST_NAME_ALL_CHANNELS", "REQUEST_NAME_INVITED_CHANNELS", "REQUEST_NAME_JOINED_CHANNELS", "SOURCE_CHAT_PERF", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatPerformanceAnalytics.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22296a;

        static {
            int[] iArr = new int[MemberState.values().length];
            f22296a = iArr;
            iArr[MemberState.INVITED.ordinal()] = 1;
            f22296a[MemberState.INVITED_BY_NON_FRIEND.ordinal()] = 2;
            f22296a[MemberState.INVITED_BY_FRIEND.ordinal()] = 3;
            f22296a[MemberState.JOINED.ordinal()] = 4;
            f22296a[MemberState.ALL.ordinal()] = 5;
        }
    }

    public final void mo5100a() {
        TimingUtil.m23938a("CHAT_INBOX_LOAD_TAG");
    }

    public final void mo5104a(boolean z, List<ChatInboxItem> list) {
        Intrinsics.m26847b(list, "chatInboxItems");
        long d = TimingUtil.m23941d("CHAT_INBOX_LOAD_TAG");
        if (d != -1) {
            Iterable<ChatInboxItem> iterable = list;
            int i = 0;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (ChatInboxItem chatInboxItem : iterable) {
                    if (chatInboxItem.f22315c) {
                        i++;
                    }
                }
            }
            list = list.size() - i;
            ChatEventBuilder a = m30605a(TrackLoadSettingsAtom.TYPE, z ? "inbox_cached" : "inbox_new", d);
            a.m28917b(Long.valueOf((long) i)).m28919c(Long.valueOf((long) list));
            m30606a(a);
        }
    }

    public final void mo5102a(String str) {
        Intrinsics.m26847b(str, "chatId");
        StringBuilder stringBuilder = new StringBuilder("CHAT_LOAD_CHANNEL_TAG_");
        stringBuilder.append(str);
        TimingUtil.m23938a(stringBuilder.toString());
    }

    public final void mo5103a(String str, boolean z) {
        Intrinsics.m26847b(str, "chatId");
        StringBuilder stringBuilder = new StringBuilder("CHAT_LOAD_CHANNEL_TAG_");
        stringBuilder.append(str);
        long d = TimingUtil.m23941d(stringBuilder.toString());
        if (d != -1) {
            ChatEventBuilder a = m30605a(TrackLoadSettingsAtom.TYPE, z ? "channel_cached" : "channel_new", d);
            a.m28924f(str);
            m30606a(a);
        }
    }

    public static void m30607a(HttpUrl httpUrl, UUID uuid) {
        Intrinsics.m26847b(httpUrl, "requestUrl");
        Intrinsics.m26847b(uuid, "uuid");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpUrl);
        stringBuilder.append('_');
        stringBuilder.append(uuid);
        TimingUtil.m23939b(stringBuilder.toString());
    }

    public final void mo5101a(MemberState memberState, UUID uuid) {
        Intrinsics.m26847b(memberState, "memberState");
        Intrinsics.m26847b(uuid, "uuid");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(memberState.name());
        stringBuilder.append('_');
        stringBuilder.append(uuid);
        TimingUtil.m23939b(stringBuilder.toString());
    }

    public final void mo5105b(MemberState memberState, UUID uuid) {
        Intrinsics.m26847b(memberState, "memberState");
        Intrinsics.m26847b(uuid, "uuid");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(memberState.name());
        stringBuilder.append('_');
        stringBuilder.append(uuid);
        long d = TimingUtil.m23941d(stringBuilder.toString());
        if (d != -1) {
            ChatEventBuilder a = m30605a(TrackLoadSettingsAtom.TYPE, "request_sendbird", d);
            switch (WhenMappings.f22296a[memberState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    memberState = "get_existing_invited_channels";
                    break;
                case 4:
                    memberState = "get_existing_joined_channels";
                    break;
                case 5:
                    memberState = "get_existing_all_channels";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            a.m28934p(memberState);
            m30606a(a);
        }
    }

    public static ChatEventBuilder m30605a(String str, String str2, long j) {
        Object p = AppAnalytics.m21879p();
        try {
            String str3 = "chat_performance";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append('_');
            stringBuilder.append(str);
            stringBuilder.append('_');
            stringBuilder.append(str2);
            String stringBuilder2 = stringBuilder.toString();
            ChatEventBuilder chatEventBuilder = (ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) p.m21888a(str3)).m21892b(str)).m21895c(str2);
            str2 = SessionUtil.m23898d();
            Intrinsics.m26843a((Object) str2, "SessionUtil.getTypedCurrentSessionAccountID()");
            str = chatEventBuilder.m28922e(str2);
            Intrinsics.m26847b(stringBuilder2, "type");
            str.timerBuilder.millis(Long.valueOf(j));
            str.timerBuilder.type(stringBuilder2);
            str.timerSet = true;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
        } catch (String str4) {
            Timber.c((Throwable) str4, "Failed to create chat perf analytics event", new Object[0]);
        }
        Intrinsics.m26843a(p, "builder");
        return p;
    }

    public static void m30606a(ChatEventBuilder chatEventBuilder) {
        try {
            Object a = FrontpageSettings.a();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
            a = a.t();
            Intrinsics.m26843a(a, "config");
            if (a.h()) {
                chatEventBuilder.m21891a();
            }
        } catch (ChatEventBuilder chatEventBuilder2) {
            Timber.c((Throwable) chatEventBuilder2, "Failed to send chat perf analytics event", new Object[0]);
        }
    }
}
