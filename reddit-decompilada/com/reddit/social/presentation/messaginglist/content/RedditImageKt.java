package com.reddit.social.presentation.messaginglist.content;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bumptech.glide.request.RequestListener;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.ImageUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import com.reddit.social.presentation.presentationobjects.RedditImageContentMessageData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.anko.CustomLayoutPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u000b\u001a\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\r"}, d2 = {"REDDIT_URL_START", "", "getREDDIT_URL_START", "()Ljava/lang/String;", "bind", "", "Lcom/reddit/social/presentation/messaginglist/content/RedditImageMessageContent;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/RedditImageContentMessageData;", "fetchRedditData", "redditImageMessageContent", "Landroid/view/ViewGroup;", "showMediaContent", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: RedditImage.kt */
public final class RedditImageKt {
    private static final String f22424a = "https://www.reddit.com/";

    public static final RedditImageMessageContent m24727a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Object context = viewGroup.getContext();
        Intrinsics.m26843a(context, "context");
        RedditImageMessage redditImageMessage = new RedditImageMessage(context);
        redditImageMessage.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b()));
        redditImageMessage.setCardBackgroundColor(ColorStateList.valueOf(ViewsKt.m24101a((View) viewGroup, (int) C1761R.color.groupChatBubbleOther)));
        redditImageMessage.setUseCompatPadding(true);
        redditImageMessage.setRadius(12.0f);
        redditImageMessage.setCardElevation(null);
        return new RedditImageMessageContent(redditImageMessage, redditImageMessage.getTitleText(), redditImageMessage.getImageContainer(), redditImageMessage.getProgressBar(), redditImageMessage.getVideoPlayer(), redditImageMessage.getImageView());
    }

    public static final void m24728a(RedditImageMessageContent redditImageMessageContent, RedditImageContentMessageData redditImageContentMessageData) {
        Intrinsics.m26847b(redditImageMessageContent, "$receiver");
        Intrinsics.m26847b(redditImageContentMessageData, "messageData");
        redditImageMessageContent.f29915c.setText(redditImageContentMessageData.f29947a);
        if (redditImageContentMessageData.f29949c != null) {
            m24730c(redditImageMessageContent, redditImageContentMessageData);
            return;
        }
        redditImageMessageContent.f29916d.setVisibility(0);
        redditImageMessageContent.f29917e.setVisibility(0);
        if (redditImageMessageContent.f29914b == null) {
            Intrinsics.m26844a("remoteRedditApiDataSource");
        }
        RemoteRedditApiDataSource.a(new Regex(f22424a).m28148b(redditImageContentMessageData.f29948b, "")).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new RedditImageKt$fetchRedditData$1(redditImageMessageContent, redditImageContentMessageData), (Consumer) new RedditImageKt$fetchRedditData$2(redditImageMessageContent));
    }

    private static final void m24730c(RedditImageMessageContent redditImageMessageContent, RedditImageContentMessageData redditImageContentMessageData) {
        Context context = redditImageMessageContent.f29916d.getContext();
        if (redditImageContentMessageData != null && !TextUtils.isEmpty(redditImageContentMessageData.f29951e)) {
            redditImageMessageContent.f29918f.setVisibility(0);
            redditImageMessageContent.f29916d.setVisibility(8);
            ImageUtil.m23723a(context, redditImageContentMessageData.f29949c, redditImageContentMessageData.f29950d, redditImageContentMessageData.f29951e, (VideoPlayerOld) redditImageMessageContent.f29918f);
        } else if (redditImageContentMessageData != null && !TextUtils.isEmpty(redditImageContentMessageData.f29950d)) {
            redditImageMessageContent.f29918f.setVisibility(8);
            redditImageMessageContent.f29916d.setVisibility(0);
            ImageUtil.m23726b(context, redditImageContentMessageData.f29950d, redditImageMessageContent.f29919g, new RedditImageKt$showMediaContent$1(redditImageMessageContent));
        } else if (redditImageContentMessageData == null || TextUtils.isEmpty(redditImageContentMessageData.f29949c)) {
            redditImageMessageContent.f29918f.setVisibility(8);
            redditImageMessageContent.f29916d.setVisibility(8);
        } else {
            redditImageMessageContent.f29918f.setVisibility(8);
            redditImageMessageContent.f29916d.setVisibility(0);
            ImageUtil.m23721a(context, redditImageContentMessageData.f29949c, redditImageMessageContent.f29919g, (RequestListener) new RedditImageKt$showMediaContent$2(redditImageMessageContent));
        }
    }
}
