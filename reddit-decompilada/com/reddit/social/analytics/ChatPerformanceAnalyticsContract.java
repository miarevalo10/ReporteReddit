package com.reddit.social.analytics;

import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.sendbird.android.GroupChannel.MemberState;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0018"}, d2 = {"Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "", "channelClicked", "", "channelId", "", "channelLoaded", "cachedDataAvailable", "", "chatBottomNavClicked", "chatInboxDataLoaded", "inboxItems", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "getGroupChannelsEnd", "memberState", "Lcom/sendbird/android/GroupChannel$MemberState;", "uuid", "Ljava/util/UUID;", "getGroupChannelsStart", "requestCompleted", "requestUrl", "Lokhttp3/HttpUrl;", "requestStarted", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatPerformanceAnalyticsContract.kt */
public interface ChatPerformanceAnalyticsContract {
    void mo5100a();

    void mo5101a(MemberState memberState, UUID uuid);

    void mo5102a(String str);

    void mo5103a(String str, boolean z);

    void mo5104a(boolean z, List<ChatInboxItem> list);

    void mo5105b(MemberState memberState, UUID uuid);
}
