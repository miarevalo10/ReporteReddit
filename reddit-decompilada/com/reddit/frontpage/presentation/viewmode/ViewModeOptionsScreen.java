package com.reddit.frontpage.presentation.viewmode;

import android.content.Context;
import android.os.Bundle;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerViewModeOptionsComponent;
import com.reddit.frontpage.di.module.ViewModeOptionsViewModule;
import com.reddit.frontpage.presentation.common.ui.view.BottomSheetOptionItemView;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsContract.View;
import com.reddit.frontpage.ui.BaseScreen;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract$View;", "context", "Landroid/content/Context;", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "(Landroid/content/Context;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "getMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "setMode", "(Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "presenter", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsPresenter;)V", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "setScreen", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "clearSelections", "", "notifyModeSelection", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCardOption", "setCompactOption", "setGalleryOption", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ViewModeOptionsScreen.kt */
public final class ViewModeOptionsScreen extends RedditBottomSheetDialog implements View {
    @Inject
    public ViewModeOptionsPresenter f39120d;
    public BaseScreen f39121e;
    private ListingViewMode f39122f;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21000a;

        static {
            int[] iArr = new int[ListingViewMode.values().length];
            f21000a = iArr;
            iArr[ListingViewMode.f20612a.ordinal()] = 1;
            f21000a[ListingViewMode.f20613b.ordinal()] = 2;
            f21000a[ListingViewMode.f20614c.ordinal()] = 3;
        }
    }

    public final ListingViewMode mo7192a() {
        return this.f39122f;
    }

    public ViewModeOptionsScreen(Context context, ListingViewMode listingViewMode) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(listingViewMode, "mode");
        super(context);
        this.f39122f = listingViewMode;
    }

    public final ViewModeOptionsPresenter m38987f() {
        ViewModeOptionsPresenter viewModeOptionsPresenter = this.f39120d;
        if (viewModeOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return viewModeOptionsPresenter;
    }

    public final void m38982a(BaseScreen baseScreen) {
        Intrinsics.m26847b(baseScreen, "<set-?>");
        this.f39121e = baseScreen;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DaggerViewModeOptionsComponent.m29305a().m22179a(FrontpageApplication.m28875k()).m22180a(new ViewModeOptionsViewModule(this)).m22181a().mo4754a(this);
        setContentView((int) C1761R.layout.viewmode_options);
        m36781a((String) getContext().getString(C1761R.string.view_mode_options_title));
        Object obj;
        switch (WhenMappings.f21000a[this.f39122f.ordinal()]) {
            case 1:
                obj = (BottomSheetOptionItemView) findViewById(C1761R.id.card_option);
                Intrinsics.m26843a(obj, "card_option");
                obj.setSelected(true);
                break;
            case 2:
                obj = (BottomSheetOptionItemView) findViewById(C1761R.id.compact_option);
                Intrinsics.m26843a(obj, "compact_option");
                obj.setSelected(true);
                break;
            case 3:
                obj = (BottomSheetOptionItemView) findViewById(C1761R.id.gallery_option);
                Intrinsics.m26843a(obj, "gallery_option");
                obj.setSelected(true);
                break;
            default:
                break;
        }
        ((BottomSheetOptionItemView) findViewById(C1761R.id.card_option)).setOnClickListener(new ViewModeOptionsScreen$onCreate$1(this));
        ((BottomSheetOptionItemView) findViewById(C1761R.id.compact_option)).setOnClickListener(new ViewModeOptionsScreen$onCreate$2(this));
        ((BottomSheetOptionItemView) findViewById(C1761R.id.gallery_option)).setOnClickListener(new ViewModeOptionsScreen$onCreate$3(this));
    }

    public final void mo7176b() {
        Object obj = (BottomSheetOptionItemView) findViewById(C1761R.id.card_option);
        Intrinsics.m26843a(obj, "card_option");
        obj.setSelected(true);
    }

    public final void mo7194c() {
        Object obj = (BottomSheetOptionItemView) findViewById(C1761R.id.compact_option);
        Intrinsics.m26843a(obj, "compact_option");
        obj.setSelected(true);
    }

    public final void mo7195d() {
        Object obj = (BottomSheetOptionItemView) findViewById(C1761R.id.gallery_option);
        Intrinsics.m26843a(obj, "gallery_option");
        obj.setSelected(true);
    }

    public final void mo7196e() {
        Object obj = (BottomSheetOptionItemView) findViewById(C1761R.id.card_option);
        Intrinsics.m26843a(obj, "card_option");
        obj.setSelected(false);
        obj = (BottomSheetOptionItemView) findViewById(C1761R.id.compact_option);
        Intrinsics.m26843a(obj, "compact_option");
        obj.setSelected(false);
        obj = (BottomSheetOptionItemView) findViewById(C1761R.id.gallery_option);
        Intrinsics.m26843a(obj, "gallery_option");
        obj.setSelected(false);
    }

    public final void mo7193a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        BaseScreen baseScreen = this.f39121e;
        if (baseScreen == null) {
            Intrinsics.m26844a("screen");
        }
        EventBus.getDefault().postSticky(new ViewModeOptionSelection(baseScreen, listingViewMode));
        dismiss();
    }
}
