package com.reddit.social.util;

import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.social.model.SendBirdDataV1;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.Member.InvitationState;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u001a\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u001a\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0001¢\u0006\u0002\u0010\u001d\u001a\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010 \u001a\u00020\r\u001a\u000e\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0001\u001a\u000e\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0003\u001a\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0003\u001a\u000e\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001\u001a\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0001H\u0002\u001a\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010*\u00020\b\u001a\f\u0010/\u001a\u0004\u0018\u00010\u0001*\u00020\u0016\u001a\f\u00100\u001a\u0004\u0018\u00010,*\u000201\u001a\f\u00102\u001a\u0004\u0018\u000103*\u00020\u0016\u001a\n\u00104\u001a\u00020\r*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"GROUP_CHANNEL_DEFAULT_NAME", "", "PARROT_ICON_IND", "", "SNOOMOJI_DRAWABLE", "Landroid/support/v4/util/ArrayMap;", "buildGroupChannelName", "groupChannel", "Lcom/sendbird/android/GroupChannel;", "currentUserName", "checkUserOptedIntoChat", "", "forceInit", "", "getGroupChannelName", "getMembersAndInviters", "", "channels", "", "getMessageText", "", "baseMessage", "Lcom/sendbird/android/BaseMessage;", "getSenderIds", "messages", "getSnoomojiDrawable", "Landroid/graphics/drawable/Drawable;", "snoomojiName", "getSnoomojiResId", "(Ljava/lang/String;)Ljava/lang/Integer;", "isAccepted", "currentUserId", "isGroupChatEnabled", "isSnoomojiGifId", "snoomojiId", "isSnoomojiGifPosition", "position", "isSnoomojiGifResId", "resId", "removeAccountTypeIfPresent", "userId", "snooToCharSequence", "snoomoji", "unmarshallData", "Lcom/reddit/datalibrary/social/model/SendBirdDataV1;", "data", "getMembersAndInviter", "getRequestId", "getSendBirdDataV1", "Lcom/sendbird/android/UserMessage;", "getSender", "Lcom/sendbird/android/User;", "isPrivate", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: ChatUtil.kt */
public final class ChatUtilKt {
    private static final int f22479a = 33;
    private static final String f22480b = "Group Channel";
    private static final ArrayMap<String, Integer> f22481c;

    public static final boolean m24763b(int i) {
        return i == C1761R.drawable._0003_partyparrot;
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        Object e = Util.m24023e((int) C1761R.array.snoomoji_ids);
        int[] a = Util.m23992a();
        Intrinsics.m26843a(e, "ids");
        int length = e.length;
        for (int i = 0; i < length; i++) {
            arrayMap.put(e[i], Integer.valueOf(a[i]));
        }
        f22481c = arrayMap;
    }

    public static final boolean m24756a(GroupChannel groupChannel, String str) {
        Intrinsics.m26847b(groupChannel, "groupChannel");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Object m = groupChannel.m30983m();
        Intrinsics.m26843a(m, "groupChannel.members");
        Collection arrayList = new ArrayList();
        for (Object next : (Iterable) m) {
            Object obj = (Member) next;
            Intrinsics.m26843a(obj, "it");
            if (StringsKt__StringsJVMKt.m41946a(obj.m25021d(), str, true)) {
                arrayList.add(next);
            }
        }
        groupChannel = ((List) arrayList).iterator();
        if (groupChannel.hasNext() == null) {
            return false;
        }
        m = (Member) groupChannel.next();
        Intrinsics.m26843a(m, "it");
        return Intrinsics.m26845a(m.m30994b(), InvitationState.JOINED);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.CharSequence m24751a(com.sendbird.android.BaseMessage r6) {
        /*
        r0 = r6 instanceof com.sendbird.android.FileMessage;
        if (r0 == 0) goto L_0x0012;
    L_0x0004:
        r6 = (com.sendbird.android.FileMessage) r6;
        r6 = r6.m30941j();
        r0 = "baseMessage.name";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r0);
        r6 = (java.lang.CharSequence) r6;
        return r6;
    L_0x0012:
        r0 = r6 instanceof com.sendbird.android.AdminMessage;
        if (r0 == 0) goto L_0x0024;
    L_0x0016:
        r6 = (com.sendbird.android.AdminMessage) r6;
        r6 = r6.m30928b();
        r0 = "baseMessage.message";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r0);
        r6 = (java.lang.CharSequence) r6;
        return r6;
    L_0x0024:
        r0 = r6 instanceof com.sendbird.android.UserMessage;
        if (r0 == 0) goto L_0x00bb;
    L_0x0028:
        r6 = (com.sendbird.android.UserMessage) r6;
        r0 = m24750a(r6);
        if (r0 == 0) goto L_0x00ae;
    L_0x0030:
        r1 = r0.getMessage();
        r2 = 0;
        if (r1 == 0) goto L_0x0042;
    L_0x0037:
        r1 = r1.getEmbedData();
        if (r1 == 0) goto L_0x0042;
    L_0x003d:
        r1 = r1.getUrl();
        goto L_0x0043;
    L_0x0042:
        r1 = r2;
    L_0x0043:
        r0 = r0.getMessage();
        if (r0 == 0) goto L_0x004e;
    L_0x0049:
        r0 = r0.getSnoomoji();
        goto L_0x004f;
    L_0x004e:
        r0 = r2;
    L_0x004f:
        r1 = (java.lang.CharSequence) r1;
        r3 = 1;
        r4 = 0;
        if (r1 == 0) goto L_0x005e;
    L_0x0055:
        r5 = r1.length();
        if (r5 != 0) goto L_0x005c;
    L_0x005b:
        goto L_0x005e;
    L_0x005c:
        r5 = r4;
        goto L_0x005f;
    L_0x005e:
        r5 = r3;
    L_0x005f:
        if (r5 != 0) goto L_0x0062;
    L_0x0061:
        goto L_0x00ac;
    L_0x0062:
        r1 = r0;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x0070;
    L_0x0067:
        r1 = r1.length();
        if (r1 != 0) goto L_0x006e;
    L_0x006d:
        goto L_0x0070;
    L_0x006e:
        r1 = r4;
        goto L_0x0071;
    L_0x0070:
        r1 = r3;
    L_0x0071:
        if (r1 != 0) goto L_0x00a5;
    L_0x0073:
        if (r0 == 0) goto L_0x0099;
    L_0x0075:
        r0 = m24749a(r0);
        if (r0 == 0) goto L_0x0099;
    L_0x007b:
        r1 = 2131165323; // 0x7f07008b float:1.794486E38 double:1.0529355717E-314;
        r1 = com.reddit.frontpage.util.Util.m24012d(r1);
        r0.setBounds(r4, r4, r1, r1);
        r1 = new android.text.style.ImageSpan;
        r1.<init>(r0, r4);
        r2 = new android.text.SpannableString;
        r0 = "x";
        r0 = (java.lang.CharSequence) r0;
        r2.<init>(r0);
        r0 = 17;
        r2.setSpan(r1, r4, r3, r0);
    L_0x0099:
        if (r2 == 0) goto L_0x009f;
    L_0x009b:
        r1 = r2;
        r1 = (java.lang.CharSequence) r1;
        goto L_0x00ac;
    L_0x009f:
        r0 = "";
        r1 = r0;
        r1 = (java.lang.CharSequence) r1;
        goto L_0x00ac;
    L_0x00a5:
        r0 = r6.m31081b();
        r1 = r0;
        r1 = (java.lang.CharSequence) r1;
    L_0x00ac:
        if (r1 != 0) goto L_0x00ba;
    L_0x00ae:
        r6 = r6.m31081b();
        r0 = "baseMessage.message";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r0);
        r1 = r6;
        r1 = (java.lang.CharSequence) r1;
    L_0x00ba:
        return r1;
    L_0x00bb:
        r6 = "";
        r6 = (java.lang.CharSequence) r6;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.util.ChatUtilKt.a(com.sendbird.android.BaseMessage):java.lang.CharSequence");
    }

    public static final String m24760b(GroupChannel groupChannel, String str) {
        Intrinsics.m26847b(groupChannel, "groupChannel");
        String b = m24759b(groupChannel);
        boolean z = false;
        if (b != null) {
            if (((CharSequence) b).length() > 0) {
                return b;
            }
        }
        GroupChannel<Object> m = groupChannel.m30983m();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : m) {
            Intrinsics.m26843a(obj, "user");
            if (!StringsKt__StringsJVMKt.m41946a(obj.m25022e(), str, true)) {
                if (((CharSequence) stringBuilder).length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj.m25022e());
            }
        }
        if (stringBuilder.length() == null) {
            z = true;
        }
        if (z && str != null) {
            stringBuilder.append(str);
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "stringBuilder.toString()");
        return stringBuilder2;
    }

    public static final SendBirdDataV1 m24750a(UserMessage userMessage) {
        Object obj;
        Intrinsics.m26847b(userMessage, "$receiver");
        CharSequence c = userMessage.m31082c();
        if (c != null) {
            if (c.length() != 0) {
                obj = null;
                if (obj == null) {
                    return null;
                }
                Object c2 = userMessage.m31082c();
                Intrinsics.m26843a(c2, "data");
                return m24767d(c2);
            }
        }
        obj = 1;
        if (obj == null) {
            return null;
        }
        Object c22 = userMessage.m31082c();
        Intrinsics.m26843a(c22, "data");
        return m24767d(c22);
    }

    private static final SendBirdDataV1 m24767d(String str) {
        try {
            return (SendBirdDataV1) new Gson().a(str, SendBirdDataV1.class);
        } catch (String str2) {
            Timber.c((Throwable) str2, "SendBirdDataV1 unmarshallData exception", new Object[0]);
            return null;
        }
    }

    public static final Set<String> m24753a(List<? extends BaseMessage> list) {
        Intrinsics.m26847b(list, "messages");
        Collection arrayList = new ArrayList();
        for (BaseMessage b : list) {
            User b2 = m24757b(b);
            Object d = b2 != null ? b2.m25021d() : null;
            if (d != null) {
                arrayList.add(d);
            }
        }
        return CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    public static final User m24757b(BaseMessage baseMessage) {
        Intrinsics.m26847b(baseMessage, "$receiver");
        if (baseMessage instanceof UserMessage) {
            return ((UserMessage) baseMessage).m31083d();
        }
        return baseMessage instanceof FileMessage ? ((FileMessage) baseMessage).m30939c() : null;
    }

    public static final String m24764c(BaseMessage baseMessage) {
        Intrinsics.m26847b(baseMessage, "$receiver");
        if (baseMessage instanceof UserMessage) {
            return ((UserMessage) baseMessage).m31084j();
        }
        return baseMessage instanceof FileMessage ? ((FileMessage) baseMessage).m30938b() : null;
    }

    public static final Set<String> m24761b(List<GroupChannel> list) {
        Intrinsics.m26847b(list, "channels");
        Iterable<GroupChannel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (GroupChannel a : iterable) {
            arrayList.add(m24752a(a));
        }
        return CollectionsKt___CollectionsKt.m41451p(CollectionsKt__IterablesKt.m32813c((List) arrayList));
    }

    public static final Set<String> m24752a(GroupChannel groupChannel) {
        Intrinsics.m26847b(groupChannel, "$receiver");
        Object m = groupChannel.m30983m();
        Intrinsics.m26843a(m, "members");
        Iterable<Object> iterable = (Iterable) m;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Object obj : iterable) {
            Intrinsics.m26843a(obj, "it");
            arrayList.add(obj.m25021d());
        }
        Set<String> p = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        groupChannel = groupChannel.m30981k();
        if (groupChannel != null) {
            groupChannel = groupChannel.m25021d();
            if (groupChannel != null) {
                return SetsKt___SetsKt.m32821b(p, groupChannel);
            }
        }
        return p;
    }

    public static final String m24759b(GroupChannel groupChannel) {
        Intrinsics.m26847b(groupChannel, "groupChannel");
        groupChannel = groupChannel.m24872f();
        return (TextUtils.isEmpty((CharSequence) groupChannel) || StringsKt__StringsJVMKt.m41946a((String) groupChannel, f22480b, true)) ? null : groupChannel;
    }

    public static final Drawable m24749a(String str) {
        Intrinsics.m26847b(str, "snoomojiName");
        str = m24758b(str);
        return str != null ? Util.m24032h(str.intValue()) : null;
    }

    public static final Integer m24758b(String str) {
        Intrinsics.m26847b(str, "snoomojiName");
        return (Integer) f22481c.get(str);
    }

    public static final boolean m24755a(int i) {
        return i == f22479a;
    }

    public static final boolean m24766c(String str) {
        Intrinsics.m26847b(str, "snoomojiId");
        return TextUtils.equals(Util.m24023e((int) C1761R.array.snoomoji_ids)[f22479a], str);
    }

    public static final void m24754a() {
        Observable observeOn = new BaseplateClient().m28851e().subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "BaseplateClient().isChat…n(SchedulerProvider.ui())");
        ObservablesKt.m24091a(observeOn, (Function1) new ChatUtilKt$checkUserOptedIntoChat$1());
    }

    public static final boolean m24762b() {
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Account d = b.d();
        if (d == null) {
            return false;
        }
        return d.features.chat_group_rollout;
    }

    public static final boolean m24765c(GroupChannel groupChannel) {
        Intrinsics.m26847b(groupChannel, "$receiver");
        return groupChannel.m30985o();
    }
}
