package com.reddit.frontpage.presentation.modtools.ban.add;

import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BannedForCommentView.kt */
final class BannedForCommentView$authorView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ BannedForCommentView f36974a;

    BannedForCommentView$authorView$2(BannedForCommentView bannedForCommentView) {
        this.f36974a = bannedForCommentView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (TextView) this.f36974a.m29751a(C1761R.id.author);
    }
}
