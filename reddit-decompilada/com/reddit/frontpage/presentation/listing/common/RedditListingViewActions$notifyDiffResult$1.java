package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.util.ListUpdateCallback;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"com/reddit/frontpage/presentation/listing/common/RedditListingViewActions$notifyDiffResult$1", "Landroid/support/v7/util/ListUpdateCallback;", "(Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;Lkotlin/jvm/functions/Function1;)V", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingViewActions.kt */
public final class RedditListingViewActions$notifyDiffResult$1 implements ListUpdateCallback {
    final /* synthetic */ CardLinkAdapter f28288a;
    final /* synthetic */ Function1 f28289b;

    RedditListingViewActions$notifyDiffResult$1(CardLinkAdapter cardLinkAdapter, Function1 function1) {
        this.f28288a = cardLinkAdapter;
        this.f28289b = function1;
    }

    public final void m29599a(int i, int i2, Object obj) {
        this.f28288a.a(((Number) this.f28289b.mo6492a(Integer.valueOf(i))).intValue(), i2, obj);
    }

    public final void m29601c(int i, int i2) {
        this.f28288a.b(((Number) this.f28289b.mo6492a(Integer.valueOf(i))).intValue(), ((Number) this.f28289b.mo6492a(Integer.valueOf(i2))).intValue());
    }

    public final void m29598a(int i, int i2) {
        this.f28288a.c(((Number) this.f28289b.mo6492a(Integer.valueOf(i))).intValue(), i2);
    }

    public final void m29600b(int i, int i2) {
        this.f28288a.d(((Number) this.f28289b.mo6492a(Integer.valueOf(i))).intValue(), i2);
    }
}
