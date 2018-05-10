package com.reddit.social.presentation.messaginglist.content;

import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.widgets.video.LDVideoPlayerOld;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/RedditImageMessageContent;", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "cardView", "Landroid/support/v7/widget/CardView;", "titleText", "Landroid/widget/TextView;", "imageContainer", "Landroid/widget/RelativeLayout;", "progressBar", "Landroid/widget/ProgressBar;", "videoPlayer", "Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;", "imageView", "Landroid/widget/ImageView;", "(Landroid/support/v7/widget/CardView;Landroid/widget/TextView;Landroid/widget/RelativeLayout;Landroid/widget/ProgressBar;Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;Landroid/widget/ImageView;)V", "getCardView", "()Landroid/support/v7/widget/CardView;", "getImageContainer", "()Landroid/widget/RelativeLayout;", "getImageView", "()Landroid/widget/ImageView;", "getProgressBar", "()Landroid/widget/ProgressBar;", "remoteRedditApiDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "getRemoteRedditApiDataSource", "()Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "setRemoteRedditApiDataSource", "(Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;)V", "getTitleText", "()Landroid/widget/TextView;", "getVideoPlayer", "()Lcom/reddit/frontpage/widgets/video/LDVideoPlayerOld;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditImage.kt */
public final class RedditImageMessageContent extends MessageContentViewHolder {
    @Inject
    public RemoteRedditApiDataSource f29914b;
    final TextView f29915c;
    final RelativeLayout f29916d;
    final ProgressBar f29917e;
    final LDVideoPlayerOld f29918f;
    final ImageView f29919g;
    private final CardView f29920h;

    public RedditImageMessageContent(CardView cardView, TextView textView, RelativeLayout relativeLayout, ProgressBar progressBar, LDVideoPlayerOld lDVideoPlayerOld, ImageView imageView) {
        Intrinsics.m26847b(cardView, "cardView");
        Intrinsics.m26847b(textView, "titleText");
        Intrinsics.m26847b(relativeLayout, "imageContainer");
        Intrinsics.m26847b(progressBar, "progressBar");
        Intrinsics.m26847b(lDVideoPlayerOld, "videoPlayer");
        Intrinsics.m26847b(imageView, "imageView");
        super(cardView);
        this.f29920h = cardView;
        this.f29915c = textView;
        this.f29916d = relativeLayout;
        this.f29917e = progressBar;
        this.f29918f = lDVideoPlayerOld;
        this.f29919g = imageView;
        FrontpageApplication.m28877m().mo4609a(this);
    }
}
