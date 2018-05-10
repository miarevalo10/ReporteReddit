package com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions;

import android.content.Context;
import android.os.Bundle;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerModUsersOptionsComponent;
import com.reddit.frontpage.di.module.ModUsersOptionsViewModule;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.widgets.ModUsersOptionItemView;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsContract$View;", "context", "Landroid/content/Context;", "layoutRes", "", "(Landroid/content/Context;I)V", "presenter", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsPresenter;)V", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "setScreen", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "onClick", "", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showError", "message", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModUsersOptionsScreen.kt */
public final class ModUsersOptionsScreen extends RedditBottomSheetDialog implements View {
    @Inject
    public ModUsersOptionsPresenter f39107d;
    public BaseScreen f39108e;
    private final int f39109f;

    public ModUsersOptionsScreen(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, false);
        this.f39109f = i;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DaggerModUsersOptionsComponent.m29185a().m22139a(FrontpageApplication.m28875k()).m22140a(new ModUsersOptionsViewModule(this)).m22141a().mo4688a(this);
        setContentView((int) this.f39109f);
        bundle = findViewById(C1761R.id.details_option);
        if (bundle == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModUsersOptionItemView");
        }
        ((ModUsersOptionItemView) bundle).setOnClickListener(new ModUsersOptionsScreen$onCreate$1(this));
        bundle = findViewById(C1761R.id.view_profile_option);
        if (bundle == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModUsersOptionItemView");
        }
        ((ModUsersOptionItemView) bundle).setOnClickListener(new ModUsersOptionsScreen$onCreate$2(this));
        bundle = findViewById(C1761R.id.remove_option);
        if (bundle == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModUsersOptionItemView");
        }
        ((ModUsersOptionItemView) bundle).setOnClickListener(new ModUsersOptionsScreen$onCreate$3(this));
        bundle = this.f39107d;
        if (bundle == null) {
            Intrinsics.m26844a("presenter");
        }
        bundle.attach();
    }

    public final ModUsersOptionsPresenter mo7176b() {
        ModUsersOptionsPresenter modUsersOptionsPresenter = this.f39107d;
        if (modUsersOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return modUsersOptionsPresenter;
    }

    public final void m38959a(BaseScreen baseScreen) {
        Intrinsics.m26847b(baseScreen, "<set-?>");
        this.f39108e = baseScreen;
    }

    public final void mo7183a(ModUsersOptionsAction modUsersOptionsAction) {
        Intrinsics.m26847b(modUsersOptionsAction, "event");
        EventBus.getDefault().postSticky(modUsersOptionsAction);
        dismiss();
    }
}
