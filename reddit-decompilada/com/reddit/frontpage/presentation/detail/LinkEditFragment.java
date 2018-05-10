package com.reddit.frontpage.presentation.detail;

import android.os.Bundle;
import androidx.os.BundleKt;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerLinkEditComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.presentation.detail.EditContract.LinkParameters;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import com.reddit.frontpage.presentation.detail.common.Link;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/LinkEditFragment;", "Lcom/reddit/frontpage/presentation/detail/EditFragment;", "()V", "editableText", "", "getEditableText", "()Ljava/lang/String;", "link", "Lcom/reddit/frontpage/domain/model/Link;", "getLink", "()Lcom/reddit/frontpage/domain/model/Link;", "title", "", "getTitle", "()I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEditFragment.kt */
public final class LinkEditFragment extends EditFragment {
    public static final Companion f40013d = new Companion();
    private HashMap f40014g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/LinkEditFragment$Companion;", "", "()V", "ARG_EDIT_LINK", "", "newInstance", "Lcom/reddit/frontpage/presentation/detail/LinkEditFragment;", "editableLink", "Lcom/reddit/frontpage/presentation/detail/common/Link;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkEditFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LinkEditFragment m22809a(Link link) {
            Intrinsics.m26847b(link, "editableLink");
            LinkEditFragment linkEditFragment = new LinkEditFragment();
            linkEditFragment.setArguments(BundleKt.a(new Pair[]{TuplesKt.m26780a("com.reddit.frontpage.edit_link", link)}));
            return linkEditFragment;
        }
    }

    public final void mo7338i() {
        if (this.f40014g != null) {
            this.f40014g.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo7338i();
    }

    public final String mo7337g() {
        return m40581j().getSelftext();
    }

    private final com.reddit.frontpage.domain.model.Link m40581j() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.m26842a();
        }
        return ((Link) arguments.getParcelable("com.reddit.frontpage.edit_link")).f33844a;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = DaggerLinkEditComponent.m29162a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        bundle.mo4672a(k).mo4674a((View) this).mo4673a(new LinkParameters(m40581j())).mo4675a().mo4676a(this);
    }
}
