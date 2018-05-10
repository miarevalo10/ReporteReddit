package com.reddit.social.presentation.messaginglist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0019\u0010\u0011R\u001b\u0010\u001b\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001c\u0010\u0016R\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b$\u0010\fR\u001b\u0010&\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b'\u0010\u0016R\u001b\u0010)\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b*\u0010\u0016¨\u00060"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/MessageView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "contentContainer$delegate", "Lkotlin/Lazy;", "dateContainer", "getDateContainer", "()Landroid/widget/LinearLayout;", "dateContainer$delegate", "dateText", "Landroid/widget/TextView;", "getDateText", "()Landroid/widget/TextView;", "dateText$delegate", "messageContainer", "getMessageContainer", "messageContainer$delegate", "name", "getName", "name$delegate", "profileIcon", "Landroid/widget/ImageView;", "getProfileIcon", "()Landroid/widget/ImageView;", "profileIcon$delegate", "profileIconContainer", "getProfileIconContainer", "profileIconContainer$delegate", "sentStatusText", "getSentStatusText", "sentStatusText$delegate", "timeText", "getTimeText", "timeText$delegate", "setContent", "", "contentViewHolder", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
public final class MessageView extends LinearLayout {
    static final /* synthetic */ KProperty[] f22386a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "dateContainer", "getDateContainer()Landroid/widget/LinearLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "messageContainer", "getMessageContainer()Landroid/widget/LinearLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "dateText", "getDateText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "timeText", "getTimeText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "profileIcon", "getProfileIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "profileIconContainer", "getProfileIconContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "name", "getName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "contentContainer", "getContentContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessageView.class), "sentStatusText", "getSentStatusText()Landroid/widget/TextView;"))};
    private final Lazy f22387b;
    private final Lazy f22388c;
    private final Lazy f22389d;
    private final Lazy f22390e;
    private final Lazy f22391f;
    private final Lazy f22392g;
    private final Lazy f22393h;
    private final Lazy f22394i;
    private final Lazy f22395j;
    private HashMap f22396k;

    public final View m24716a(int i) {
        if (this.f22396k == null) {
            this.f22396k = new HashMap();
        }
        View view = (View) this.f22396k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22396k.put(Integer.valueOf(i), view);
        return view;
    }

    public final FrameLayout getContentContainer() {
        return (FrameLayout) this.f22394i.mo5678b();
    }

    public final LinearLayout getDateContainer() {
        return (LinearLayout) this.f22387b.mo5678b();
    }

    public final TextView getDateText() {
        return (TextView) this.f22389d.mo5678b();
    }

    public final LinearLayout getMessageContainer() {
        return (LinearLayout) this.f22388c.mo5678b();
    }

    public final TextView getName() {
        return (TextView) this.f22393h.mo5678b();
    }

    public final ImageView getProfileIcon() {
        return (ImageView) this.f22391f.mo5678b();
    }

    public final FrameLayout getProfileIconContainer() {
        return (FrameLayout) this.f22392g.mo5678b();
    }

    public final TextView getSentStatusText() {
        return (TextView) this.f22395j.mo5678b();
    }

    public final TextView getTimeText() {
        return (TextView) this.f22390e.mo5678b();
    }

    private MessageView(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context, null, 0);
        this.f22387b = LazyKt.m26777a(new MessageView$dateContainer$2(this));
        this.f22388c = LazyKt.m26777a(new MessageView$messageContainer$2(this));
        this.f22389d = LazyKt.m26777a(new MessageView$dateText$2(this));
        this.f22390e = LazyKt.m26777a(new MessageView$timeText$2(this));
        this.f22391f = LazyKt.m26777a(new MessageView$profileIcon$2(this));
        this.f22392g = LazyKt.m26777a(new MessageView$profileIconContainer$2(this));
        this.f22393h = LazyKt.m26777a(new MessageView$name$2(this));
        this.f22394i = LazyKt.m26777a(new MessageView$contentContainer$2(this));
        this.f22395j = LazyKt.m26777a(new MessageView$sentStatusText$2(this));
        LinearLayout.inflate(context, C1761R.layout.message_view, this);
        setOrientation(1);
        setClickable(true);
    }

    public final void setContent(MessageContentViewHolder messageContentViewHolder) {
        Intrinsics.m26847b(messageContentViewHolder, "contentViewHolder");
        messageContentViewHolder = messageContentViewHolder.f22385a;
        if (messageContentViewHolder != null) {
            ViewParent parent = messageContentViewHolder.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(messageContentViewHolder);
            }
            getContentContainer().removeAllViews();
            getContentContainer().addView(messageContentViewHolder);
        }
    }
}
