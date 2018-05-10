package com.reddit.frontpage.commons.analytics.builders;

import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.components.Chat.Builder;
import com.reddit.data.events.models.components.User;
import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/ChatEventBuilder;", "Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "()V", "chatBuilder", "Lcom/reddit/data/events/models/components/Chat$Builder;", "idSet", "", "userBuilder", "Lcom/reddit/data/events/models/components/User$Builder;", "blockedUserId", "", "chatId", "id", "chatRecipient", "recipientId", "existingChannel", "imageUploadMethod", "invitationId", "invitationPreviewType", "invitationTimestamp", "", "(Ljava/lang/Long;)Lcom/reddit/frontpage/commons/analytics/builders/ChatEventBuilder;", "invitationType", "messageType", "numberBlockedUsers", "numBlockedUsers", "numberChannels", "numberMembers", "numberPendingInvites", "numberUnreads", "prepareAnalytics", "", "reportedUserId", "requestName", "senderUserId", "type", "userAddedMethod", "userId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatEventBuilder.kt */
public final class ChatEventBuilder extends BaseEventBuilder<ChatEventBuilder> {
    public final Builder f27446a = new Builder();
    private final User.Builder f27447b = new User.Builder();
    private boolean f27448c;

    public ChatEventBuilder() {
        Event.Builder builder = new Event.Builder();
        Intrinsics.m26847b(builder, "<set-?>");
        this.builder = builder;
    }

    public final ChatEventBuilder m28922e(String str) {
        Intrinsics.m26847b(str, "id");
        this.f27447b.id(str);
        this.f27447b.logged_in(Boolean.valueOf(SessionUtil.m23894a()));
        this.f27448c = true;
        return this;
    }

    public final ChatEventBuilder m28924f(String str) {
        this.f27446a.id(str);
        return this;
    }

    public final ChatEventBuilder m28925g(String str) {
        Intrinsics.m26847b(str, "type");
        this.f27446a.type(str);
        return this;
    }

    public final ChatEventBuilder mo4572a(boolean z) {
        this.f27446a.existing_channel(Boolean.valueOf(z));
        return this;
    }

    public final ChatEventBuilder m28926h(String str) {
        Intrinsics.m26847b(str, "userAddedMethod");
        this.f27446a.user_added_method(str);
        return this;
    }

    public final ChatEventBuilder m28927i(String str) {
        Intrinsics.m26847b(str, "invitationId");
        this.f27446a.invitation_id(str);
        return this;
    }

    public final ChatEventBuilder m28928j(String str) {
        Intrinsics.m26847b(str, "invitationType");
        this.f27446a.invitation_type(str);
        return this;
    }

    public final ChatEventBuilder m28915a(Long l) {
        this.f27446a.number_blocked_users(l);
        return this;
    }

    public final ChatEventBuilder m28929k(String str) {
        Intrinsics.m26847b(str, "blockedUserId");
        this.f27446a.blocked_user_id(str);
        return this;
    }

    public final ChatEventBuilder m28930l(String str) {
        Intrinsics.m26847b(str, "invitationPreviewType");
        this.f27446a.invitation_preview_type(str);
        return this;
    }

    public final ChatEventBuilder m28931m(String str) {
        this.f27446a.message_type(str);
        return this;
    }

    public final ChatEventBuilder m28917b(Long l) {
        this.f27446a.number_channels(l);
        return this;
    }

    public final ChatEventBuilder m28919c(Long l) {
        this.f27446a.number_pending_invites(l);
        return this;
    }

    public final ChatEventBuilder m28932n(String str) {
        SessionUtil.m23893a(str);
        this.f27446a.recipient_user_id(str);
        return this;
    }

    public final ChatEventBuilder m28920d(Long l) {
        this.f27446a.number_members(l);
        return this;
    }

    public final ChatEventBuilder m28921e(Long l) {
        this.f27446a.number_unreads(l);
        return this;
    }

    public final ChatEventBuilder m28933o(String str) {
        Intrinsics.m26847b(str, "senderUserId");
        this.f27446a.sender_user_id(str);
        return this;
    }

    public final ChatEventBuilder m28923f(Long l) {
        this.f27446a.invitation_timestamp(l);
        return this;
    }

    public final ChatEventBuilder m28934p(String str) {
        Intrinsics.m26847b(str, "requestName");
        this.f27446a.request_name(str);
        return this;
    }

    public final void mo4573b() {
        this.builder.chat(this.f27446a.build());
        if (this.f27448c) {
            this.builder.user(this.f27447b.build());
        }
    }
}
