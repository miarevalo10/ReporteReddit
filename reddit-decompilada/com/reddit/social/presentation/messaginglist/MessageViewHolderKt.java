package com.reddit.social.presentation.messaginglist;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.presentationobjects.AdminMessageData;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.ImageFileMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.MessageData;
import com.reddit.social.presentation.presentationobjects.RedditImageContentMessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.VideoFileMessageData;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.anko.CustomViewPropertiesKt;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\b¨\u0006\u0013"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/MessageViewHolder;", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "showDate", "", "showDetails", "listener", "Lcom/reddit/social/presentation/messaginglist/MessageItemOnClickListener;", "linkEmbedLoaded", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "messageContainer", "Landroid/content/Context;", "messageContentViewHolder", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
public final class MessageViewHolderKt {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22397a;

        static {
            int[] iArr = new int[SentStatus.values().length];
            f22397a = iArr;
            iArr[SentStatus.f22462c.ordinal()] = 1;
        }
    }

    public static final void m24717a(MessageViewHolder messageViewHolder, HasMessageData hasMessageData, boolean z, boolean z2, MessageItemOnClickListener messageItemOnClickListener, PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        Intrinsics.m26847b(messageViewHolder, "$receiver");
        Intrinsics.m26847b(hasMessageData, "message");
        Intrinsics.m26847b(publishSubject, "linkEmbedLoaded");
        MessageData a = hasMessageData.mo5204a();
        ViewsKt.m24106b(messageViewHolder.f34588b, z);
        if (z) {
            CharSequence f;
            z = messageViewHolder.f34590q;
            DateUtil dateUtil = DateUtil.f20370a;
            if (DateUtil.m22710f(a.f22430c)) {
                f = Util.m24027f((int) C1761R.string.label_today);
            } else {
                dateUtil = DateUtil.f20370a;
                if (DateUtil.m22709e(a.f22430c)) {
                    f = Util.m24027f((int) C1761R.string.label_yesterday);
                } else {
                    dateUtil = DateUtil.f20370a;
                    f = DateUtil.m22711g(a.f22430c);
                }
            }
            z.setText(f);
        }
        ViewsKt.m24106b((View) messageViewHolder.f34591r, z2);
        ViewsKt.m24106b((View) messageViewHolder.f34594u, z2);
        ViewsKt.m24108c((View) messageViewHolder.f34592s, z2);
        Object context = messageViewHolder.f34587a.getContext();
        View view;
        if (z2) {
            messageViewHolder.f34594u.setText(a.f22432e);
            AvatarUtilKt.m23659a(messageViewHolder.f34592s, a.f22434g, Boolean.valueOf(AccountPrefsUtil.m23630a(a.f22432e, a.f22433f)), null);
            z2 = messageViewHolder.f34591r;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
            Object[] objArr = new Object[1];
            DateUtil dateUtil2 = DateUtil.f20370a;
            objArr[0] = DateUtil.m22712h(a.f22430c);
            Object a2 = Util.m23960a((int) C1761R.string.fmt_timestamp_text, objArr);
            Intrinsics.m26843a(a2, "Util.getString(R.string.…il.formatTime(timestamp))");
            a2 = String.format(a2, Arrays.copyOf(new Object[0], 0));
            Intrinsics.m26843a(a2, "java.lang.String.format(format, *args)");
            z2.setText((CharSequence) a2);
            view = (View) messageViewHolder.f34593t;
            Intrinsics.m26843a(context, "ctx");
            CustomViewPropertiesKt.m28402a(view, DimensionsKt.m28408a(context, C1761R.dimen.half_pad));
            CustomViewPropertiesKt.m28402a((View) messageViewHolder.f34589p, DimensionsKt.m28408a(context, C1761R.dimen.double_pad));
        } else {
            CustomViewPropertiesKt.m28402a((View) messageViewHolder.f34593t, 0);
            view = (View) messageViewHolder.f34589p;
            Intrinsics.m26843a(context, "ctx");
            CustomViewPropertiesKt.m28402a(view, DimensionsKt.m28407a(context));
        }
        z = a.f22436i;
        if (z) {
            if (WhenMappings.f22397a[z.ordinal()]) {
                messageViewHolder.f34596w.setVisibility(0);
                messageViewHolder.f34596w.setText(Util.m24027f((int) true));
                messageViewHolder.f34595v.m24711a(hasMessageData, (MessageContentClickListener) new MessageViewHolderKt$bind$2(messageItemOnClickListener), publishSubject);
                if (messageItemOnClickListener != null) {
                    if (!(hasMessageData instanceof AdminMessageData)) {
                        messageViewHolder.f34589p.setOnLongClickListener((OnLongClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$1(messageViewHolder, hasMessageData, messageItemOnClickListener));
                        ((View) messageViewHolder.f34589p).setOnClickListener((OnClickListener) new MessageViewHolderKt$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessageViewHolderKt$bind$$inlined$let$lambda$2(messageViewHolder, hasMessageData, messageItemOnClickListener)));
                    }
                    if (hasMessageData instanceof RedditImageContentMessageData) {
                        messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$3(messageViewHolder, hasMessageData, messageItemOnClickListener));
                    } else if (hasMessageData instanceof ImageFileMessageData) {
                        messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$4(messageViewHolder, hasMessageData, messageItemOnClickListener));
                    } else if (hasMessageData instanceof VideoFileMessageData) {
                        messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$5(messageViewHolder, hasMessageData, messageItemOnClickListener));
                    }
                }
                ((View) messageViewHolder.f34592s).setOnClickListener((OnClickListener) new MessageViewHolderKt$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessageViewHolderKt$bind$4(messageViewHolder, a)));
            }
        }
        messageViewHolder.f34596w.setVisibility(true);
        messageViewHolder.f34595v.m24711a(hasMessageData, (MessageContentClickListener) new MessageViewHolderKt$bind$2(messageItemOnClickListener), publishSubject);
        if (messageItemOnClickListener != null) {
            if (hasMessageData instanceof AdminMessageData) {
                messageViewHolder.f34589p.setOnLongClickListener((OnLongClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$1(messageViewHolder, hasMessageData, messageItemOnClickListener));
                ((View) messageViewHolder.f34589p).setOnClickListener((OnClickListener) new MessageViewHolderKt$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessageViewHolderKt$bind$$inlined$let$lambda$2(messageViewHolder, hasMessageData, messageItemOnClickListener)));
            }
            if (hasMessageData instanceof RedditImageContentMessageData) {
                messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$3(messageViewHolder, hasMessageData, messageItemOnClickListener));
            } else if (hasMessageData instanceof ImageFileMessageData) {
                messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$4(messageViewHolder, hasMessageData, messageItemOnClickListener));
            } else if (hasMessageData instanceof VideoFileMessageData) {
                messageViewHolder.c.setOnClickListener((OnClickListener) new MessageViewHolderKt$bind$$inlined$let$lambda$5(messageViewHolder, hasMessageData, messageItemOnClickListener));
            }
        }
        ((View) messageViewHolder.f34592s).setOnClickListener((OnClickListener) new MessageViewHolderKt$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessageViewHolderKt$bind$4(messageViewHolder, a)));
    }
}
