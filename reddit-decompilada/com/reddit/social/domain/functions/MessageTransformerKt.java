package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.model.SendBirdDataV1;
import com.reddit.datalibrary.social.model.SendBirdDataV1.EmbedData;
import com.reddit.datalibrary.social.model.SendBirdDataV1.Message;
import com.reddit.frontpage.util.Util;
import com.reddit.social.presentation.presentationobjects.AdminMessageData;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.ImageFileMessageData;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState.NotLoaded;
import com.reddit.social.presentation.presentationobjects.MessageData;
import com.reddit.social.presentation.presentationobjects.MessageType;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.SnoomojiGifMessageData;
import com.reddit.social.presentation.presentationobjects.SnoomojiImageMessageData;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessage.Thumbnail;
import com.sendbird.android.UserMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a5\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0007*\u00020\u000eH\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002\u001a-\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0015\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0019\u001a5\u0010\u001a\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001c\u001a5\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!\u001a5\u0010\"\u001a\u00020#*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$\u001a5\u0010%\u001a\u00020&*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010'\u001aC\u0010(\u001a\u00020)*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010,¨\u0006-"}, d2 = {"createRedditPostAsTextLink", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "Lcom/sendbird/android/UserMessage;", "currentUser", "", "profileUrl", "profileNsfw", "", "embedUrl", "createSnoomojiMessageData", "snoomoji", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "getSentStatus", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "isFailed", "toAdminMessageData", "Lcom/reddit/social/presentation/presentationobjects/AdminMessageData;", "Lcom/sendbird/android/AdminMessage;", "toHasMessageData", "isProfileNsfw", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "toImageFile", "Lcom/reddit/social/presentation/presentationobjects/ImageFileMessageData;", "Lcom/sendbird/android/FileMessage;", "(Lcom/sendbird/android/FileMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/social/presentation/presentationobjects/ImageFileMessageData;", "toLinkContent", "Lcom/reddit/social/presentation/presentationobjects/LinkContentMessageData;", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/reddit/social/presentation/presentationobjects/LinkContentMessageData;", "toRedditImage", "Lcom/reddit/social/presentation/presentationobjects/RedditImageContentMessageData;", "embedData", "Lcom/reddit/datalibrary/social/model/SendBirdDataV1$EmbedData;", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/reddit/datalibrary/social/model/SendBirdDataV1$EmbedData;)Lcom/reddit/social/presentation/presentationobjects/RedditImageContentMessageData;", "toSnooGif", "Lcom/reddit/social/presentation/presentationobjects/SnoomojiGifMessageData;", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/social/presentation/presentationobjects/SnoomojiGifMessageData;", "toSnooImage", "Lcom/reddit/social/presentation/presentationobjects/SnoomojiImageMessageData;", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/social/presentation/presentationobjects/SnoomojiImageMessageData;", "toTextMessage", "Lcom/reddit/social/presentation/presentationobjects/TextMessageData;", "messageText", "isHackIsPost", "(Lcom/sendbird/android/UserMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)Lcom/reddit/social/presentation/presentationobjects/TextMessageData;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: MessageTransformer.kt */
public final class MessageTransformerKt {
    private static /* synthetic */ TextMessageData m24487b(UserMessage userMessage, String str, String str2, Boolean bool) {
        Object b = userMessage.m31081b();
        Intrinsics.m26843a(b, "message");
        MessageType messageType = MessageType.f22444a;
        Object j = userMessage.m31084j();
        Intrinsics.m26843a(j, "requestId");
        long f = userMessage.m24878f();
        long g = userMessage.m24879g();
        Object d = userMessage.m31083d();
        Intrinsics.m26843a(d, "sender");
        Object d2 = d.m25021d();
        Intrinsics.m26843a(d2, "sender.userId");
        d = userMessage.m31083d();
        Intrinsics.m26843a(d, "sender");
        Object e = d.m25022e();
        Intrinsics.m26843a(e, "sender.nickname");
        Object a = Util.m23961a(userMessage.m24879g());
        Intrinsics.m26843a(a, "Util.getDisplayableAge(createdAt)");
        SentStatus a2 = m24486a((BaseMessage) userMessage);
        Object d3 = userMessage.m31083d();
        Intrinsics.m26843a(d3, "sender");
        d3 = d3.m25021d();
        Intrinsics.m26843a(d3, "sender.userId");
        boolean b2 = StringsKt__StringsJVMKt.m41948b(d3, str);
        String h = userMessage.m24880h();
        Intrinsics.m26843a((Object) h, "channelUrl");
        String k = userMessage.m31085k();
        Intrinsics.m26843a((Object) k, "customType");
        String c = userMessage.m31082c();
        Intrinsics.m26843a((Object) c, "data");
        return new TextMessageData(b, new MessageData(j, f, g, d2, e, bool, str2, a, messageType, false, a2, b2, h, k, c));
    }

    private static final SentStatus m24486a(BaseMessage baseMessage) {
        if ((baseMessage.m24878f() == 0 ? true : null) != null) {
            return SentStatus.f22462c;
        }
        return SentStatus.f22460a;
    }

    public static final /* synthetic */ HasMessageData m24484a(UserMessage userMessage, String str, String str2, Boolean bool) {
        String str3 = str;
        SendBirdDataV1 a = ChatUtilKt.m24750a(userMessage);
        if (a == null) {
            return m24487b(userMessage, str, str2, bool);
        }
        String url;
        Message message;
        CharSequence charSequence;
        Object obj;
        Object obj2;
        LinkEmbedState notLoaded;
        MessageType messageType;
        Object j;
        long f;
        long g;
        Object d;
        Object e;
        Object a2;
        SentStatus a3;
        boolean b;
        String k;
        String c;
        Message message2 = a.getMessage();
        String str4 = null;
        if (message2 != null) {
            EmbedData embedData = message2.getEmbedData();
            if (embedData != null) {
                url = embedData.getUrl();
                message = a.getMessage();
                if (message != null) {
                    str4 = message.getSnoomoji();
                }
                charSequence = url;
                obj = 1;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj2 = null;
                        if (obj2 != null) {
                            if (url == null) {
                                Intrinsics.m26842a();
                            }
                            notLoaded = new NotLoaded(url);
                            messageType = MessageType.f22451h;
                            j = userMessage.m31084j();
                            Intrinsics.m26843a(j, "requestId");
                            f = userMessage.m24878f();
                            g = userMessage.m24879g();
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            d = obj.m25021d();
                            Intrinsics.m26843a(d, "sender.userId");
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            e = obj.m25022e();
                            Intrinsics.m26843a(e, "sender.nickname");
                            a2 = Util.m23961a(userMessage.m24879g());
                            Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                            a3 = m24486a((BaseMessage) userMessage);
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            obj = obj.m25021d();
                            Intrinsics.m26843a(obj, "sender.userId");
                            b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                            str3 = userMessage.m24880h();
                            Intrinsics.m26843a((Object) str3, "channelUrl");
                            k = userMessage.m31085k();
                            Intrinsics.m26843a((Object) k, "customType");
                            c = userMessage.m31082c();
                            Intrinsics.m26843a((Object) c, "data");
                            return new LinkContentMessageData(notLoaded, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                        }
                        charSequence = str4;
                        if (charSequence != null) {
                            if (charSequence.length() != 0) {
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            return m24487b(userMessage, str, str2, bool);
                        }
                        if (str4 == null) {
                            Intrinsics.m26842a();
                        }
                        if (ChatUtilKt.m24766c(str4)) {
                            messageType = MessageType.f22453j;
                            j = userMessage.m31084j();
                            Intrinsics.m26843a(j, "requestId");
                            f = userMessage.m24878f();
                            g = userMessage.m24879g();
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            d = obj.m25021d();
                            Intrinsics.m26843a(d, "sender.userId");
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            e = obj.m25022e();
                            Intrinsics.m26843a(e, "sender.nickname");
                            a2 = Util.m23961a(userMessage.m24879g());
                            Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                            a3 = m24486a((BaseMessage) userMessage);
                            obj = userMessage.m31083d();
                            Intrinsics.m26843a(obj, "sender");
                            obj = obj.m25021d();
                            Intrinsics.m26843a(obj, "sender.userId");
                            b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                            str3 = userMessage.m24880h();
                            Intrinsics.m26843a((Object) str3, "channelUrl");
                            k = userMessage.m31085k();
                            Intrinsics.m26843a((Object) k, "customType");
                            c = userMessage.m31082c();
                            Intrinsics.m26843a((Object) c, "data");
                            return new SnoomojiImageMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                        }
                        messageType = MessageType.f22454k;
                        j = userMessage.m31084j();
                        Intrinsics.m26843a(j, "requestId");
                        f = userMessage.m24878f();
                        g = userMessage.m24879g();
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        d = obj.m25021d();
                        Intrinsics.m26843a(d, "sender.userId");
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        e = obj.m25022e();
                        Intrinsics.m26843a(e, "sender.nickname");
                        a2 = Util.m23961a(userMessage.m24879g());
                        Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                        a3 = m24486a((BaseMessage) userMessage);
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        obj = obj.m25021d();
                        Intrinsics.m26843a(obj, "sender.userId");
                        b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                        str3 = userMessage.m24880h();
                        Intrinsics.m26843a((Object) str3, "channelUrl");
                        k = userMessage.m31085k();
                        Intrinsics.m26843a((Object) k, "customType");
                        c = userMessage.m31082c();
                        Intrinsics.m26843a((Object) c, "data");
                        return new SnoomojiGifMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                    }
                }
                obj2 = 1;
                if (obj2 != null) {
                    charSequence = str4;
                    if (charSequence != null) {
                        if (charSequence.length() != 0) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        return m24487b(userMessage, str, str2, bool);
                    }
                    if (str4 == null) {
                        Intrinsics.m26842a();
                    }
                    if (ChatUtilKt.m24766c(str4)) {
                        messageType = MessageType.f22453j;
                        j = userMessage.m31084j();
                        Intrinsics.m26843a(j, "requestId");
                        f = userMessage.m24878f();
                        g = userMessage.m24879g();
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        d = obj.m25021d();
                        Intrinsics.m26843a(d, "sender.userId");
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        e = obj.m25022e();
                        Intrinsics.m26843a(e, "sender.nickname");
                        a2 = Util.m23961a(userMessage.m24879g());
                        Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                        a3 = m24486a((BaseMessage) userMessage);
                        obj = userMessage.m31083d();
                        Intrinsics.m26843a(obj, "sender");
                        obj = obj.m25021d();
                        Intrinsics.m26843a(obj, "sender.userId");
                        b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                        str3 = userMessage.m24880h();
                        Intrinsics.m26843a((Object) str3, "channelUrl");
                        k = userMessage.m31085k();
                        Intrinsics.m26843a((Object) k, "customType");
                        c = userMessage.m31082c();
                        Intrinsics.m26843a((Object) c, "data");
                        return new SnoomojiImageMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                    }
                    messageType = MessageType.f22454k;
                    j = userMessage.m31084j();
                    Intrinsics.m26843a(j, "requestId");
                    f = userMessage.m24878f();
                    g = userMessage.m24879g();
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    d = obj.m25021d();
                    Intrinsics.m26843a(d, "sender.userId");
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    e = obj.m25022e();
                    Intrinsics.m26843a(e, "sender.nickname");
                    a2 = Util.m23961a(userMessage.m24879g());
                    Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                    a3 = m24486a((BaseMessage) userMessage);
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    obj = obj.m25021d();
                    Intrinsics.m26843a(obj, "sender.userId");
                    b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                    str3 = userMessage.m24880h();
                    Intrinsics.m26843a((Object) str3, "channelUrl");
                    k = userMessage.m31085k();
                    Intrinsics.m26843a((Object) k, "customType");
                    c = userMessage.m31082c();
                    Intrinsics.m26843a((Object) c, "data");
                    return new SnoomojiGifMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                }
                if (url == null) {
                    Intrinsics.m26842a();
                }
                notLoaded = new NotLoaded(url);
                messageType = MessageType.f22451h;
                j = userMessage.m31084j();
                Intrinsics.m26843a(j, "requestId");
                f = userMessage.m24878f();
                g = userMessage.m24879g();
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                d = obj.m25021d();
                Intrinsics.m26843a(d, "sender.userId");
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                e = obj.m25022e();
                Intrinsics.m26843a(e, "sender.nickname");
                a2 = Util.m23961a(userMessage.m24879g());
                Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                a3 = m24486a((BaseMessage) userMessage);
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                obj = obj.m25021d();
                Intrinsics.m26843a(obj, "sender.userId");
                b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                str3 = userMessage.m24880h();
                Intrinsics.m26843a((Object) str3, "channelUrl");
                k = userMessage.m31085k();
                Intrinsics.m26843a((Object) k, "customType");
                c = userMessage.m31082c();
                Intrinsics.m26843a((Object) c, "data");
                return new LinkContentMessageData(notLoaded, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
            }
        }
        url = null;
        message = a.getMessage();
        if (message != null) {
            str4 = message.getSnoomoji();
        }
        charSequence = url;
        obj = 1;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj2 = null;
                if (obj2 != null) {
                    if (url == null) {
                        Intrinsics.m26842a();
                    }
                    notLoaded = new NotLoaded(url);
                    messageType = MessageType.f22451h;
                    j = userMessage.m31084j();
                    Intrinsics.m26843a(j, "requestId");
                    f = userMessage.m24878f();
                    g = userMessage.m24879g();
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    d = obj.m25021d();
                    Intrinsics.m26843a(d, "sender.userId");
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    e = obj.m25022e();
                    Intrinsics.m26843a(e, "sender.nickname");
                    a2 = Util.m23961a(userMessage.m24879g());
                    Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                    a3 = m24486a((BaseMessage) userMessage);
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    obj = obj.m25021d();
                    Intrinsics.m26843a(obj, "sender.userId");
                    b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                    str3 = userMessage.m24880h();
                    Intrinsics.m26843a((Object) str3, "channelUrl");
                    k = userMessage.m31085k();
                    Intrinsics.m26843a((Object) k, "customType");
                    c = userMessage.m31082c();
                    Intrinsics.m26843a((Object) c, "data");
                    return new LinkContentMessageData(notLoaded, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                }
                charSequence = str4;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    return m24487b(userMessage, str, str2, bool);
                }
                if (str4 == null) {
                    Intrinsics.m26842a();
                }
                if (ChatUtilKt.m24766c(str4)) {
                    messageType = MessageType.f22454k;
                    j = userMessage.m31084j();
                    Intrinsics.m26843a(j, "requestId");
                    f = userMessage.m24878f();
                    g = userMessage.m24879g();
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    d = obj.m25021d();
                    Intrinsics.m26843a(d, "sender.userId");
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    e = obj.m25022e();
                    Intrinsics.m26843a(e, "sender.nickname");
                    a2 = Util.m23961a(userMessage.m24879g());
                    Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                    a3 = m24486a((BaseMessage) userMessage);
                    obj = userMessage.m31083d();
                    Intrinsics.m26843a(obj, "sender");
                    obj = obj.m25021d();
                    Intrinsics.m26843a(obj, "sender.userId");
                    b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                    str3 = userMessage.m24880h();
                    Intrinsics.m26843a((Object) str3, "channelUrl");
                    k = userMessage.m31085k();
                    Intrinsics.m26843a((Object) k, "customType");
                    c = userMessage.m31082c();
                    Intrinsics.m26843a((Object) c, "data");
                    return new SnoomojiGifMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
                }
                messageType = MessageType.f22453j;
                j = userMessage.m31084j();
                Intrinsics.m26843a(j, "requestId");
                f = userMessage.m24878f();
                g = userMessage.m24879g();
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                d = obj.m25021d();
                Intrinsics.m26843a(d, "sender.userId");
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                e = obj.m25022e();
                Intrinsics.m26843a(e, "sender.nickname");
                a2 = Util.m23961a(userMessage.m24879g());
                Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                a3 = m24486a((BaseMessage) userMessage);
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                obj = obj.m25021d();
                Intrinsics.m26843a(obj, "sender.userId");
                b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                str3 = userMessage.m24880h();
                Intrinsics.m26843a((Object) str3, "channelUrl");
                k = userMessage.m31085k();
                Intrinsics.m26843a((Object) k, "customType");
                c = userMessage.m31082c();
                Intrinsics.m26843a((Object) c, "data");
                return new SnoomojiImageMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            charSequence = str4;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                return m24487b(userMessage, str, str2, bool);
            }
            if (str4 == null) {
                Intrinsics.m26842a();
            }
            if (ChatUtilKt.m24766c(str4)) {
                messageType = MessageType.f22453j;
                j = userMessage.m31084j();
                Intrinsics.m26843a(j, "requestId");
                f = userMessage.m24878f();
                g = userMessage.m24879g();
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                d = obj.m25021d();
                Intrinsics.m26843a(d, "sender.userId");
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                e = obj.m25022e();
                Intrinsics.m26843a(e, "sender.nickname");
                a2 = Util.m23961a(userMessage.m24879g());
                Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
                a3 = m24486a((BaseMessage) userMessage);
                obj = userMessage.m31083d();
                Intrinsics.m26843a(obj, "sender");
                obj = obj.m25021d();
                Intrinsics.m26843a(obj, "sender.userId");
                b = StringsKt__StringsJVMKt.m41948b(obj, str3);
                str3 = userMessage.m24880h();
                Intrinsics.m26843a((Object) str3, "channelUrl");
                k = userMessage.m31085k();
                Intrinsics.m26843a((Object) k, "customType");
                c = userMessage.m31082c();
                Intrinsics.m26843a((Object) c, "data");
                return new SnoomojiImageMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
            }
            messageType = MessageType.f22454k;
            j = userMessage.m31084j();
            Intrinsics.m26843a(j, "requestId");
            f = userMessage.m24878f();
            g = userMessage.m24879g();
            obj = userMessage.m31083d();
            Intrinsics.m26843a(obj, "sender");
            d = obj.m25021d();
            Intrinsics.m26843a(d, "sender.userId");
            obj = userMessage.m31083d();
            Intrinsics.m26843a(obj, "sender");
            e = obj.m25022e();
            Intrinsics.m26843a(e, "sender.nickname");
            a2 = Util.m23961a(userMessage.m24879g());
            Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
            a3 = m24486a((BaseMessage) userMessage);
            obj = userMessage.m31083d();
            Intrinsics.m26843a(obj, "sender");
            obj = obj.m25021d();
            Intrinsics.m26843a(obj, "sender.userId");
            b = StringsKt__StringsJVMKt.m41948b(obj, str3);
            str3 = userMessage.m24880h();
            Intrinsics.m26843a((Object) str3, "channelUrl");
            k = userMessage.m31085k();
            Intrinsics.m26843a((Object) k, "customType");
            c = userMessage.m31082c();
            Intrinsics.m26843a((Object) c, "data");
            return new SnoomojiGifMessageData(str4, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
        }
        if (url == null) {
            Intrinsics.m26842a();
        }
        notLoaded = new NotLoaded(url);
        messageType = MessageType.f22451h;
        j = userMessage.m31084j();
        Intrinsics.m26843a(j, "requestId");
        f = userMessage.m24878f();
        g = userMessage.m24879g();
        obj = userMessage.m31083d();
        Intrinsics.m26843a(obj, "sender");
        d = obj.m25021d();
        Intrinsics.m26843a(d, "sender.userId");
        obj = userMessage.m31083d();
        Intrinsics.m26843a(obj, "sender");
        e = obj.m25022e();
        Intrinsics.m26843a(e, "sender.nickname");
        a2 = Util.m23961a(userMessage.m24879g());
        Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
        a3 = m24486a((BaseMessage) userMessage);
        obj = userMessage.m31083d();
        Intrinsics.m26843a(obj, "sender");
        obj = obj.m25021d();
        Intrinsics.m26843a(obj, "sender.userId");
        b = StringsKt__StringsJVMKt.m41948b(obj, str3);
        str3 = userMessage.m24880h();
        Intrinsics.m26843a((Object) str3, "channelUrl");
        k = userMessage.m31085k();
        Intrinsics.m26843a((Object) k, "customType");
        c = userMessage.m31082c();
        Intrinsics.m26843a((Object) c, "data");
        return new LinkContentMessageData(notLoaded, new MessageData(j, f, g, d, e, bool, str2, a2, messageType, false, a3, b, str3, k, c));
    }

    public static final /* synthetic */ AdminMessageData m24483a(AdminMessage adminMessage) {
        String b = adminMessage.m30928b();
        Intrinsics.m26843a((Object) b, "message");
        MessageType messageType = MessageType.f22452i;
        String str = b;
        Object a = Util.m23961a(adminMessage.m24879g());
        Intrinsics.m26843a(a, "Util.getDisplayableAge(createdAt)");
        SentStatus sentStatus = SentStatus.f22460a;
        String h = adminMessage.m24880h();
        Intrinsics.m26843a((Object) h, "channelUrl");
        b = adminMessage.m30930d();
        Intrinsics.m26843a((Object) b, "customType");
        String c = adminMessage.m30929c();
        Intrinsics.m26843a((Object) c, "data");
        return new AdminMessageData(str, new MessageData("", adminMessage.m24878f(), adminMessage.m24879g(), "", "Admin", Boolean.valueOf(false), "", a, messageType, true, sentStatus, false, h, b, c));
    }

    public static final /* synthetic */ ImageFileMessageData m24485a(FileMessage fileMessage, String str, String str2, Boolean bool) {
        Object j = fileMessage.m30941j();
        Intrinsics.m26843a(j, "name");
        Object d = fileMessage.m30940d();
        Intrinsics.m26843a(d, UpdateFragment.FRAGMENT_URL);
        Object m = fileMessage.m30944m();
        Intrinsics.m26843a(m, "thumbnails");
        Thumbnail thumbnail = (Thumbnail) CollectionsKt___CollectionsKt.m41434e((List) m);
        String a = thumbnail != null ? thumbnail.m24910a() : null;
        MessageType messageType = MessageType.f22445b;
        Object b = fileMessage.m30938b();
        Intrinsics.m26843a(b, "requestId");
        long f = fileMessage.m24878f();
        long g = fileMessage.m24879g();
        Object c = fileMessage.m30939c();
        Intrinsics.m26843a(c, "sender");
        Object d2 = c.m25021d();
        Intrinsics.m26843a(d2, "sender.userId");
        c = fileMessage.m30939c();
        Intrinsics.m26843a(c, "sender");
        Object e = c.m25022e();
        Intrinsics.m26843a(e, "sender.nickname");
        Object a2 = Util.m23961a(fileMessage.m24879g());
        Intrinsics.m26843a(a2, "Util.getDisplayableAge(createdAt)");
        SentStatus a3 = m24486a((BaseMessage) fileMessage);
        Object c2 = fileMessage.m30939c();
        Intrinsics.m26843a(c2, "sender");
        c2 = c2.m25021d();
        Intrinsics.m26843a(c2, "sender.userId");
        boolean b2 = StringsKt__StringsJVMKt.m41948b(c2, str);
        String h = fileMessage.m24880h();
        Intrinsics.m26843a((Object) h, "channelUrl");
        String l = fileMessage.m30943l();
        String str3 = h;
        Intrinsics.m26843a((Object) l, "customType");
        h = fileMessage.m30942k();
        Intrinsics.m26843a((Object) h, "data");
        MessageData messageData = r4;
        MessageData messageData2 = new MessageData(b, f, g, d2, e, bool, str2, a2, messageType, false, a3, b2, str3, l, h);
        return new ImageFileMessageData(j, d, a, messageData);
    }
}
