package com.reddit.frontpage.widgets;

import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HeaderMetadataView.kt */
final class HeaderMetadataView$bind$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ HeaderMetadataView f37399a;
    final /* synthetic */ Link f37400b;

    HeaderMetadataView$bind$$inlined$apply$lambda$1(HeaderMetadataView headerMetadataView, Link link) {
        this.f37399a = headerMetadataView;
        this.f37400b = link;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        HeaderMetadataView.m24145a(this.f37399a, this.f37400b);
        return Unit.f25273a;
    }
}
