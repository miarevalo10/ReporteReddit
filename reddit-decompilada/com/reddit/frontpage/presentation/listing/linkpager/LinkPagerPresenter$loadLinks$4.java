package com.reddit.frontpage.presentation.listing.linkpager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerPresenter.kt */
final class LinkPagerPresenter$loadLinks$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Function1 f36693a;

    LinkPagerPresenter$loadLinks$4(Function1 function1) {
        this.f36693a = function1;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "it");
        this.f36693a.mo6492a(th);
        return Unit.f25273a;
    }
}
