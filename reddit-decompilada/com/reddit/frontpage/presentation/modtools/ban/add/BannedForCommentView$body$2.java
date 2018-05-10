package com.reddit.frontpage.presentation.modtools.ban.add;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BannedForCommentView.kt */
final class BannedForCommentView$body$2 extends Lambda implements Function0<BaseHtmlTextView> {
    final /* synthetic */ BannedForCommentView f36975a;

    BannedForCommentView$body$2(BannedForCommentView bannedForCommentView) {
        this.f36975a = bannedForCommentView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (BaseHtmlTextView) this.f36975a.m29751a(C1761R.id.comment_text);
    }
}
