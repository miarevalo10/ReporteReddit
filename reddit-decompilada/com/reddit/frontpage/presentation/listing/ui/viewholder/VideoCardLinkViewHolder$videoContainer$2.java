package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolder.kt */
final class VideoCardLinkViewHolder$videoContainer$2 extends Lambda implements Function0<View> {
    final /* synthetic */ View f36926a;

    VideoCardLinkViewHolder$videoContainer$2(View view) {
        this.f36926a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f36926a.findViewById(C1761R.id.video_container);
        if (findViewById != null) {
            return findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }
}
