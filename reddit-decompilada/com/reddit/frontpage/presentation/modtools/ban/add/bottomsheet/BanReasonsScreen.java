package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerBanReasonsComponent;
import com.reddit.frontpage.di.module.BanReasonsViewModule;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsContract.View;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import de.greenrobot.event.EventBus;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsContract$View;", "context", "Landroid/content/Context;", "banReasons", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "presenter", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsPresenter;)V", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "setScreen", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "onClick", "", "banReason", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReason;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BanReasonsScreen.kt */
public final class BanReasonsScreen extends RedditBottomSheetDialog implements View {
    @Inject
    public BanReasonsPresenter f39104d;
    public BaseScreen f39105e;
    private final List<String> f39106f;

    public BanReasonsScreen(Context context, List<String> list) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(list, "banReasons");
        super(context, false);
        this.f39106f = list;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DaggerBanReasonsComponent.m29030a().m22070a(FrontpageApplication.m28875k()).m22071a(new BanReasonsViewModule(this)).m22069a().mo4611a(this);
        setContentView((int) C1761R.layout.ban_reasons_sheet);
        bundle = new ReasonsAdapter(this.f39106f, new BanReasonsScreen$onCreate$adapter$1(this));
        android.view.View findViewById = findViewById(C1761R.id.reasons_recyclerview);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
        }
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter((Adapter) bundle);
        recyclerView.addItemDecoration(DividerItemDecoration.m30092a(getContext(), 1));
        bundle = this.f39104d;
        if (bundle == null) {
            Intrinsics.m26844a("presenter");
        }
        bundle.attach();
    }

    public final void mo7182a(BanReason banReason) {
        Intrinsics.m26847b(banReason, "banReason");
        EventBus.getDefault().postSticky(banReason);
        dismiss();
    }
}
