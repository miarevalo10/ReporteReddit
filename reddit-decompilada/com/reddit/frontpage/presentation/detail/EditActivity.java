package com.reddit.frontpage.presentation.detail;

import android.os.Bundle;
import android.view.View;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.detail.common.Comment;
import com.reddit.frontpage.presentation.detail.common.Editable;
import com.reddit.frontpage.presentation.detail.common.Link;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditActivity;", "Lcom/reddit/frontpage/BaseActivity;", "()V", "getFragment", "Lcom/reddit/frontpage/presentation/detail/EditFragment;", "editable", "Lcom/reddit/frontpage/presentation/detail/common/Editable;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditActivity.kt */
public final class EditActivity extends BaseActivity {
    public static final Companion f40826d = new Companion();
    private HashMap f40827h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditActivity$Companion;", "", "()V", "EDITABLE", "", "FRAGTAG_EDITABLE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditActivity.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final View mo7727a(int i) {
        if (this.f40827h == null) {
            this.f40827h = new HashMap();
        }
        View view = (View) this.f40827h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40827h.put(Integer.valueOf(i), view);
        return view;
    }

    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object obj = (Editable) getIntent().getParcelableExtra("com.reddit.frontpage.editable");
        if (bundle == null) {
            bundle = getSupportFragmentManager().a();
            Intrinsics.m26843a(obj, "editable");
            if (obj instanceof Link) {
                com.reddit.frontpage.presentation.detail.LinkEditFragment.Companion companion = LinkEditFragment.f40013d;
                bundle.a(C1761R.id.container, com.reddit.frontpage.presentation.detail.LinkEditFragment.Companion.m22809a((Link) obj), "editable").e();
                bundle = Unit.f25273a;
            } else if ((obj instanceof Comment) != null) {
                throw ((Throwable) new NotImplementedError());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
