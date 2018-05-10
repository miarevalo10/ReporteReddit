package com.reddit.social.analytics;

import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.datalibrary.social.model.User;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.contacts.view.ContactsActionType.ADD;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.MessageType;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004STUVB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J&\u0010$\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010(\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020 2\u0006\u0010*\u001a\u00020+J4\u0010.\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010 2\b\u00101\u001a\u0004\u0018\u00010 2\b\u00102\u001a\u0004\u0018\u00010 J4\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010 2\b\u00101\u001a\u0004\u0018\u00010 2\b\u00102\u001a\u0004\u0018\u00010 J\u000e\u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J&\u00105\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\u0006\u00106\u001a\u000207J8\u00108\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020 2\u0006\u00106\u001a\u0002072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\b\u00109\u001a\u0004\u0018\u00010 J\u0006\u0010:\u001a\u00020\u001eJ\u001c\u0010;\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0006\u0010<\u001a\u00020\u001eJ\u0006\u0010=\u001a\u00020\u001eJ\u0006\u0010>\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010A\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010/\u001a\u0004\u0018\u00010 2\u0006\u0010F\u001a\u00020GH\u0002J\u0006\u0010H\u001a\u00020\u001eJ\u0006\u0010I\u001a\u00020\u001eJ\u0006\u0010J\u001a\u00020\u001eJ\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J4\u0010L\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010F\u001a\u00020G2\b\u00100\u001a\u0004\u0018\u00010 2\b\u00101\u001a\u0004\u0018\u00010 2\b\u00102\u001a\u0004\u0018\u00010 J \u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 H\u0002J\u000e\u0010R\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006W"}, d2 = {"Lcom/reddit/social/analytics/ChatAnalytics;", "", "()V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "chatInboxListUseCase", "Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "getChatInboxListUseCase", "()Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "setChatInboxListUseCase", "(Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;)V", "lastInvalidUserAlert", "", "loadInviteUseCase", "Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "getLoadInviteUseCase", "()Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "setLoadInviteUseCase", "(Lcom/reddit/social/domain/usecases/LoadInviteUseCase;)V", "loadMessagesUseCase", "Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "getLoadMessagesUseCase", "()Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "setLoadMessagesUseCase", "(Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;)V", "addToChat", "", "channelUrl", "", "members", "", "Lcom/reddit/datalibrary/social/model/User;", "alertInvalidUser", "userAddedMethod", "chat", "chatLeaveGroup", "chatMemberBlock", "blockedUserId", "source", "Lcom/reddit/social/analytics/ChatAnalytics$Source;", "chatMemberReport", "reportedUserId", "chatMessage", "messageType", "postId", "postType", "postTitle", "chatMessageFailed", "chatSettings", "closeContacts", "contactsActionType", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "contactAdd", "contactAddedId", "contacts", "createChat", "createChatFromInbox", "createChatFromProfile", "inbox", "invitation", "invitationAccept", "invitationDecline", "invitationInbox", "numberPendingInvites", "", "invitationViewMember", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "optInClick", "optInView", "optOutClick", "redditPostsHistory", "reportMessage", "sendChatInboxEvent", "refreshChannels", "", "action", "noun", "snoomoji", "ChatType", "MessageType", "Source", "UserAddedMethod", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
public final class ChatAnalytics {
    @Inject
    public ChatDataRepositoryContract f22291a;
    @Inject
    public ChatInboxListUseCase f22292b;
    @Inject
    public LoadInviteUseCase f22293c;
    @Inject
    public LoadMessagesUseCase f22294d;
    public long f22295e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/reddit/social/analytics/ChatAnalytics$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MESSAGES_INBOX", "CHAT_VIEW", "CHAT_KEYBOARD", "CHAT_SETTINGS", "CONTACTS_LIST", "INVITATION_INBOX", "USER_PROFILE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatAnalytics.kt */
    public enum Source {
        ;
        
        public final String f22289h;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.f22289h = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22290a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f22290a = iArr;
            iArr[MessageType.f22454k.ordinal()] = 1;
            f22290a[MessageType.f22453j.ordinal()] = 2;
            f22290a[MessageType.f22450g.ordinal()] = 3;
            f22290a[MessageType.f22451h.ordinal()] = 4;
            f22290a[MessageType.f22444a.ordinal()] = 5;
        }
    }

    public ChatAnalytics() {
        FrontpageApplication.m28878n().mo5080a(this);
    }

    public final void m24471a(String str, String str2) {
        Object d = SessionUtil.m23898d();
        ChatInboxListUseCase chatInboxListUseCase = this.f22292b;
        if (chatInboxListUseCase == null) {
            Intrinsics.m26844a("chatInboxListUseCase");
        }
        Intrinsics.m26843a(d, "userId");
        ObservablesKt.m24091a(chatInboxListUseCase.m24490a(d, false, false), (Function1) new ChatAnalytics$sendChatInboxEvent$1(str, str2));
    }

    public final void m24473a(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "messageType");
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$chatMessage$1(str2, str, str3, str4, str5));
    }

    public final void m24475b(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "messageType");
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$chatMessageFailed$1(str2, str, str3, str4, str5));
    }

    public final void m24470a(String str, HasMessageData hasMessageData, String str2, String str3, String str4) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(hasMessageData, "message");
        ObjectRef objectRef = new ObjectRef();
        objectRef.f25291a = m24467b(hasMessageData);
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$reportMessage$1(objectRef, str, hasMessageData, str2, str3, str4));
    }

    public final void m24472a(String str, String str2, Source source) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "blockedUserId");
        Intrinsics.m26847b(source, "source");
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$chatMemberBlock$1(source, str2, str));
    }

    public final void m24474b(String str, String str2, Source source) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "reportedUserId");
        Intrinsics.m26847b(source, "source");
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$chatMemberReport$1(source, str2, str));
    }

    public static void m24462a() {
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("view")).m21895c("contacts")).m21891a();
    }

    public static void m24464a(String str, ContactsActionType contactsActionType, List<String> list, String str2) {
        String str3;
        Intrinsics.m26847b(str, "userAddedMethod");
        Intrinsics.m26847b(contactsActionType, "contactsActionType");
        Intrinsics.m26847b(list, "members");
        boolean z = contactsActionType instanceof ADD;
        if (z == null) {
            if (list.size() <= 2) {
                str3 = "direct";
                ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("contacts_add")).m28926h(str).m28925g(str3).m28932n(str2).m28920d(Long.valueOf((long) list.size())).m28924f((String) null).mo4572a(z).m21891a();
            }
        }
        str3 = "group";
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("contacts_add")).m28926h(str).m28925g(str3).m28932n(str2).m28920d(Long.valueOf((long) list.size())).m28924f((String) null).mo4572a(z).m21891a();
    }

    public static void m24465a(String str, List<User> list) {
        String str2;
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "members");
        String str3 = null;
        if (list.size() == 2) {
            str2 = "direct";
            Object d = SessionUtil.m23898d();
            for (Object next : list) {
                if ((Intrinsics.m26845a(((User) next).getUser_id(), d) ^ 1) != 0) {
                    break;
                }
            }
            Object next2 = null;
            User user = (User) next2;
            if (user != null) {
                str3 = user.getUser_id();
            }
        } else {
            str2 = "group";
        }
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("create_chat")).m28932n(str3).m28925g(str2).m28920d(Long.valueOf((long) list.size())).m28924f(str).mo4572a((boolean) null).m21891a();
    }

    public static void m24469b(String str, List<User> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "members");
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("add_to_chat")).m28925g("group").m28920d(Long.valueOf((long) list.size())).m28924f(str).mo4572a(true).m21891a();
    }

    public static void m24466a(List<String> list, ContactsActionType contactsActionType) {
        String str;
        Intrinsics.m26847b(list, "members");
        Intrinsics.m26847b(contactsActionType, "contactsActionType");
        boolean z = contactsActionType instanceof ADD;
        if (z == null) {
            if (list.size() <= 2) {
                str = "direct";
                ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("close_contacts")).m28925g(str).m28920d(Long.valueOf((long) list.size())).m28924f(null).mo4572a(z).m21891a();
            }
        }
        str = "group";
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("click")).m21895c("close_contacts")).m28925g(str).m28920d(Long.valueOf((long) list.size())).m28924f(null).mo4572a(z).m21891a();
    }

    private static String m24467b(HasMessageData hasMessageData) {
        switch (WhenMappings.f22290a[hasMessageData.mo5204a().f22435h.ordinal()]) {
            case 1:
                return "snoomoji";
            case 2:
                return "snoomoji";
            case 3:
                return Kind.POST;
            case 4:
                return Kind.POST;
            case 5:
                return hasMessageData.mo5204a().f22441n != null ? Kind.POST : "text";
            default:
                return "text";
        }
    }

    public static void m24463a(int i) {
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22286f.f22289h)).m21892b("view")).m21895c("inbox")).m28919c(Long.valueOf((long) i)).m21891a();
    }

    public static void m24468b() {
        String d = SessionUtil.m23898d();
        if (d != null) {
            ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22287g.f22289h)).m21892b("click")).m21895c("create_chat")).m28922e(d).m28925g("direct").m21891a();
        }
    }
}
