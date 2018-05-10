package com.reddit.frontpage.presentation.postoption;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerPostOptionsComponent;
import com.reddit.frontpage.di.component.PostOptionsComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.common.ui.TexturedBackground;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.Parameters;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.View;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsScreen;", "Landroid/support/design/widget/BottomSheetDialog;", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$View;", "context", "Landroid/content/Context;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Landroid/content/Context;Lcom/reddit/frontpage/domain/model/Subreddit;)V", "presenter", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/postoption/PostOptionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/postoption/PostOptionsPresenter;)V", "enableAllOptions", "", "enable", "", "enableImageOption", "enableLinkOption", "enableTextOption", "enableVideoOption", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDestination", "destination", "", "keyColor", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionsScreen.kt */
public final class PostOptionsScreen extends BottomSheetDialog implements View {
    @Inject
    public PostOptionsPresenter f37042d;

    public PostOptionsScreen(final Context context, Subreddit subreddit) {
        Intrinsics.m26847b(context, "context");
        super(context);
        Builder a = DaggerPostOptionsComponent.m29249a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4719a(k).mo4721a((View) this).mo4720a(new Parameters(subreddit)).mo4722a(LazyKt.m26777a(new Function0<Context>() {
            public final /* bridge */ /* synthetic */ Object invoke() {
                return context;
            }
        })).mo4723a().mo4724a(this);
    }

    public final PostOptionsPresenter m37395b() {
        PostOptionsPresenter postOptionsPresenter = this.f37042d;
        if (postOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return postOptionsPresenter;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1761R.layout.bottomsheet_post);
        bundle = Unit.f25273a;
        getWindow().setLayout(-1, -1);
        bundle = this.f37042d;
        if (bundle == null) {
            Intrinsics.m26844a("presenter");
        }
        bundle.attach();
        Object obj = (ImageView) findViewById(C1761R.id.close_option);
        Intrinsics.m26843a(obj, "close_option");
        ((android.view.View) obj).setOnClickListener(new PostOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new PostOptionsScreen$onCreate$2(this)));
    }

    public final void mo6977a(String str, String str2) {
        Intrinsics.m26847b(str, "destination");
        Object obj = (TextView) findViewById(C1761R.id.post_destination_title);
        Intrinsics.m26843a(obj, "post_destination_title");
        obj.setText(getContext().getString(C1761R.string.post_destination_format, new Object[]{str}));
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        ImageView imageView = (ImageView) findViewById(C1761R.id.background);
        Intrinsics.m26843a((Object) imageView, "background");
        TexturedBackground.m22745a(context, str2, imageView);
    }

    public final void mo6976a() {
        mo6978a(true);
        mo6979b(true);
        mo6980c(true);
        mo6981d(true);
    }

    public final void mo6978a(boolean z) {
        Object obj = (PostOptionItemView) findViewById(C1761R.id.link_option);
        Intrinsics.m26843a(obj, "link_option");
        obj.setEnabled(z);
        if (z) {
            Object obj2 = (PostOptionItemView) findViewById(C1761R.id.link_option);
            Intrinsics.m26843a(obj2, "link_option");
            ((android.view.View) obj2).setOnClickListener(new PostOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new PostOptionsScreen$enableLinkOption$1(this)));
        }
    }

    public final void mo6979b(boolean z) {
        Object obj = (PostOptionItemView) findViewById(C1761R.id.image_option);
        Intrinsics.m26843a(obj, "image_option");
        obj.setEnabled(z);
        if (z) {
            Object obj2 = (PostOptionItemView) findViewById(C1761R.id.image_option);
            Intrinsics.m26843a(obj2, "image_option");
            ((android.view.View) obj2).setOnClickListener(new PostOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new PostOptionsScreen$enableImageOption$1(this)));
        }
    }

    public final void mo6980c(boolean z) {
        Object obj = (PostOptionItemView) findViewById(C1761R.id.video_option);
        Intrinsics.m26843a(obj, "video_option");
        obj.setEnabled(z);
        if (z) {
            Object obj2 = (PostOptionItemView) findViewById(C1761R.id.video_option);
            Intrinsics.m26843a(obj2, "video_option");
            ((android.view.View) obj2).setOnClickListener(new PostOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new PostOptionsScreen$enableVideoOption$1(this)));
        }
    }

    public final void mo6981d(boolean z) {
        Object obj = (PostOptionItemView) findViewById(C1761R.id.text_option);
        Intrinsics.m26843a(obj, "text_option");
        obj.setEnabled(z);
        if (z) {
            Object obj2 = (PostOptionItemView) findViewById(C1761R.id.text_option);
            Intrinsics.m26843a(obj2, "text_option");
            ((android.view.View) obj2).setOnClickListener(new PostOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new PostOptionsScreen$enableTextOption$1(this)));
        }
    }
}
