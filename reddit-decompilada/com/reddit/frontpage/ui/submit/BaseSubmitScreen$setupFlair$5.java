package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$setupFlair$5 implements OnClickListener {
    final /* synthetic */ BaseSubmitScreen f21601a;

    BaseSubmitScreen$setupFlair$5(BaseSubmitScreen baseSubmitScreen) {
        this.f21601a = baseSubmitScreen;
    }

    public final void onClick(View view) {
        if (this.f21601a.m39519O() != null) {
            Screen screen = (Screen) this.f21601a;
            String O = this.f21601a.m39519O();
            if (O == null) {
                Intrinsics.m26842a();
            }
            Screen a = Nav.m22550a(O, null, this.f21601a.flair, this.f21601a.flairTextEdit);
            if (a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.submit.LinkFlairSelectScreen");
            }
            ((LinkFlairSelectScreen) a).m29363b((Screen) this.f21601a);
            Routing.m22623a(screen, a);
        }
    }
}
