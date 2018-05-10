package com.reddit.frontpage.widgets.modtools.modview.rightcomment;

import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRightCommentPresenter.kt */
final class ModViewRightCommentPresenter$distinguish$1 implements Action {
    final /* synthetic */ ModViewRightCommentPresenter f29523a;
    final /* synthetic */ DistinguishType f29524b;
    final /* synthetic */ String f29525c;
    final /* synthetic */ boolean f29526d;

    ModViewRightCommentPresenter$distinguish$1(ModViewRightCommentPresenter modViewRightCommentPresenter, DistinguishType distinguishType, String str, boolean z) {
        this.f29523a = modViewRightCommentPresenter;
        this.f29524b = distinguishType;
        this.f29525c = str;
        this.f29526d = z;
    }

    public final void run() {
        if (Intrinsics.m26845a(this.f29524b, DistinguishType.c)) {
            this.f29523a.m35323a().cacheDistinguishAdminState(this.f29525c, Boolean.valueOf(true));
        } else {
            this.f29523a.m35323a().cacheDistinguishState(this.f29525c, Boolean.valueOf(true ^ Intrinsics.m26845a(this.f29524b, DistinguishType.b)));
        }
        this.f29523a.m35323a().cacheStickyState(this.f29525c, Boolean.valueOf(this.f29526d));
        this.f29523a.f34548b.mo6538a();
    }
}
