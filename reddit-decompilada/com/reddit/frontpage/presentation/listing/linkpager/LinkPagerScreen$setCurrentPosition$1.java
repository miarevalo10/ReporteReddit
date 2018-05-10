package com.reddit.frontpage.presentation.listing.linkpager;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerScreen.kt */
final class LinkPagerScreen$setCurrentPosition$1 implements Runnable {
    final /* synthetic */ LinkPagerScreen f20609a;
    final /* synthetic */ int f20610b;

    LinkPagerScreen$setCurrentPosition$1(LinkPagerScreen linkPagerScreen, int i) {
        this.f20609a = linkPagerScreen;
        this.f20610b = i;
    }

    public final void run() {
        LinkPagerScreen.m40641b(this.f20609a, this.f20610b);
    }
}
