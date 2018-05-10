package com.reddit.social.presentation.messaginglist.content;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.LDVideoPlayerOld;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/RedditImageMessage;", "Landroid/support/v7/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageContainer", "Landroid/widget/RelativeLayout;", "getImageContainer", "()Landroid/widget/RelativeLayout;", "imageContainer$delegate", "Lkotlin/Lazy;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "titleText", "Landroid/widget/TextView;", "getTitleText", "()Landroid/widget/TextView;", "titleText$delegate", "videoPlayer", "Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;", "getVideoPlayer", "()Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;", "videoPlayer$delegate", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditImage.kt */
public final class RedditImageMessage extends CardView {
    static final /* synthetic */ KProperty[] f29907e = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditImageMessage.class), "titleText", "getTitleText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditImageMessage.class), "imageContainer", "getImageContainer()Landroid/widget/RelativeLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditImageMessage.class), "progressBar", "getProgressBar()Landroid/widget/ProgressBar;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditImageMessage.class), "videoPlayer", "getVideoPlayer()Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditImageMessage.class), "imageView", "getImageView()Landroid/widget/ImageView;"))};
    private final Lazy f29908f;
    private final Lazy f29909g;
    private final Lazy f29910h;
    private final Lazy f29911i;
    private final Lazy f29912j;
    private HashMap f29913k;

    public final View m30882a(int i) {
        if (this.f29913k == null) {
            this.f29913k = new HashMap();
        }
        View view = (View) this.f29913k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f29913k.put(Integer.valueOf(i), view);
        return view;
    }

    public final RelativeLayout getImageContainer() {
        return (RelativeLayout) this.f29909g.mo5678b();
    }

    public final ImageView getImageView() {
        return (ImageView) this.f29912j.mo5678b();
    }

    public final ProgressBar getProgressBar() {
        return (ProgressBar) this.f29910h.mo5678b();
    }

    public final TextView getTitleText() {
        return (TextView) this.f29908f.mo5678b();
    }

    public final LDVideoPlayerOld getVideoPlayer() {
        return (LDVideoPlayerOld) this.f29911i.mo5678b();
    }

    private RedditImageMessage(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context, null, 0);
        this.f29908f = LazyKt.m26777a(new RedditImageMessage$titleText$2(this));
        this.f29909g = LazyKt.m26777a(new RedditImageMessage$imageContainer$2(this));
        this.f29910h = LazyKt.m26777a(new RedditImageMessage$progressBar$2(this));
        this.f29911i = LazyKt.m26777a(new RedditImageMessage$videoPlayer$2(this));
        this.f29912j = LazyKt.m26777a(new RedditImageMessage$imageView$2(this));
        View.inflate(context, C1761R.layout.merge_chat_image_message, this);
    }
}
