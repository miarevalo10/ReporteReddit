package com.reddit.social.presentation.messaginglist.content;

import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditImage.kt */
final class RedditImageMessage$titleText$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ RedditImageMessage f37586a;

    RedditImageMessage$titleText$2(RedditImageMessage redditImageMessage) {
        this.f37586a = redditImageMessage;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (TextView) this.f37586a.m30882a(C1761R.id.chat_image_message_title);
    }
}
