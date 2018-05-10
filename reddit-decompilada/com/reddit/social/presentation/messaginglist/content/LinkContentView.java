package com.reddit.social.presentation.messaginglist.content;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.chat.model.Attachment;
import com.reddit.android.view.WrappedWidthTextView;
import com.reddit.frontpage.C1761R;
import com.reddit.social.util.textview.LinkTransformationMethod;
import com.reddit.social.widgets.ProportionalImageView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b$\u0010\fR\u001b\u0010&\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b'\u0010\f¨\u0006)"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/LinkContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "description$delegate", "Lkotlin/Lazy;", "favicon", "Landroid/widget/ImageView;", "getFavicon", "()Landroid/widget/ImageView;", "favicon$delegate", "image", "Lcom/reddit/social/widgets/ProportionalImageView;", "getImage", "()Lcom/reddit/social/widgets/ProportionalImageView;", "image$delegate", "linkEmbed", "Landroid/widget/LinearLayout;", "getLinkEmbed", "()Landroid/widget/LinearLayout;", "linkEmbed$delegate", "rawMessage", "Lcom/reddit/android/view/WrappedWidthTextView;", "getRawMessage", "()Lcom/reddit/android/view/WrappedWidthTextView;", "rawMessage$delegate", "siteName", "getSiteName", "siteName$delegate", "title", "getTitle", "title$delegate", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Link.kt */
public final class LinkContentView extends FrameLayout {
    static final /* synthetic */ KProperty[] f22413a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "rawMessage", "getRawMessage()Lcom/reddit/android/view/WrappedWidthTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "linkEmbed", "getLinkEmbed()Landroid/widget/LinearLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "favicon", "getFavicon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "siteName", "getSiteName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "title", "getTitle()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), "description", "getDescription()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkContentView.class), Attachment.TYPE_IMAGE, "getImage()Lcom/reddit/social/widgets/ProportionalImageView;"))};
    private final Lazy f22414b;
    private final Lazy f22415c;
    private final Lazy f22416d;
    private final Lazy f22417e;
    private final Lazy f22418f;
    private final Lazy f22419g;
    private final Lazy f22420h;
    private HashMap f22421i;

    public final View m24723a(int i) {
        if (this.f22421i == null) {
            this.f22421i = new HashMap();
        }
        View view = (View) this.f22421i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22421i.put(Integer.valueOf(i), view);
        return view;
    }

    public final TextView getDescription() {
        return (TextView) this.f22419g.mo5678b();
    }

    public final ImageView getFavicon() {
        return (ImageView) this.f22416d.mo5678b();
    }

    public final ProportionalImageView getImage() {
        return (ProportionalImageView) this.f22420h.mo5678b();
    }

    public final LinearLayout getLinkEmbed() {
        return (LinearLayout) this.f22415c.mo5678b();
    }

    public final WrappedWidthTextView getRawMessage() {
        return (WrappedWidthTextView) this.f22414b.mo5678b();
    }

    public final TextView getSiteName() {
        return (TextView) this.f22417e.mo5678b();
    }

    public final TextView getTitle() {
        return (TextView) this.f22418f.mo5678b();
    }

    private LinkContentView(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context, null, 0);
        this.f22414b = LazyKt.m26777a(new LinkContentView$rawMessage$2(this));
        this.f22415c = LazyKt.m26777a(new LinkContentView$linkEmbed$2(this));
        this.f22416d = LazyKt.m26777a(new LinkContentView$favicon$2(this));
        this.f22417e = LazyKt.m26777a(new LinkContentView$siteName$2(this));
        this.f22418f = LazyKt.m26777a(new LinkContentView$title$2(this));
        this.f22419g = LazyKt.m26777a(new LinkContentView$description$2(this));
        this.f22420h = LazyKt.m26777a(new LinkContentView$image$2(this));
        FrameLayout.inflate(context, C1761R.layout.merge_chat_link_content, this);
        getRawMessage().setTransformationMethod(new LinkTransformationMethod());
    }
}
