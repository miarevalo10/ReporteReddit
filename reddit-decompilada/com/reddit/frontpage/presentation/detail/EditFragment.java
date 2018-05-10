package com.reddit.frontpage.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.detail.EditContract.Presenter;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import com.reddit.frontpage.presentation.detail.common.Editable;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0014\u0010\"\u001a\u00020\u001d2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020\u001dH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00064"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditFragment;", "Lcom/reddit/frontpage/ui/BaseFrontpageFragment;", "Lcom/reddit/frontpage/presentation/detail/EditContract$View;", "()V", "editableText", "", "getEditableText", "()Ljava/lang/String;", "editableTextView", "Landroid/widget/EditText;", "getEditableTextView", "()Landroid/widget/EditText;", "editableTextView$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "editedText", "getEditedText", "presenter", "Lcom/reddit/frontpage/presentation/detail/EditContract$Presenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/detail/EditContract$Presenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/detail/EditContract$Presenter;)V", "progressDialog", "Landroid/support/v7/app/AlertDialog;", "title", "", "getTitle", "()I", "configurePostButton", "", "toolbar", "Landroid/support/v7/widget/Toolbar;", "getLayoutId", "hideProgressDialog", "navigateAway", "editable", "Lcom/reddit/frontpage/presentation/detail/common/Editable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "showErrorMessage", "message", "showFallbackErrorMessage", "showProgressDialog", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditFragment.kt */
public abstract class EditFragment extends BaseFrontpageFragment implements View {
    static final /* synthetic */ KProperty[] f39087a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(EditFragment.class), "editableTextView", "getEditableTextView()Landroid/widget/EditText;"))};
    public static final Companion f39088c = new Companion();
    @Inject
    public Presenter f39089b;
    private final InvalidatableLazy f39090d = LazyKt.m24084a((BaseFrontpageFragment) this, (Function0) new EditFragment$editableTextView$2(this));
    private AlertDialog f39091g;
    private HashMap f39092h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditFragment$Companion;", "", "()V", "EXTRA_EDITABLE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditFragment.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final EditText m38918j() {
        return (EditText) this.f39090d.mo5678b();
    }

    public abstract String mo7337g();

    public final int mo7160h() {
        return C1761R.layout.fragment_edit;
    }

    public void mo7338i() {
        if (this.f39092h != null) {
            this.f39092h.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo7338i();
    }

    public final Presenter m38926f() {
        Presenter presenter = this.f39089b;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    public final String mo7153a() {
        return m38918j().getText().toString();
    }

    public android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater = this.e;
        if (layoutInflater == null) {
            Intrinsics.m26842a();
        }
        Object obj = (Toolbar) ((Toolbar) layoutInflater.findViewById(C1761R.id.toolbar)).findViewById(C1761R.id.toolbar);
        obj.setTitle(null);
        ((TextView) ((android.view.View) obj).findViewById(C1761R.id.toolbar_title)).setText(C1761R.string.title_edit_link);
        obj.setNavigationIcon(C1761R.drawable.ic_icon_close);
        obj.setNavigationOnClickListener((OnClickListener) new EditFragment$onCreateView$$inlined$apply$lambda$1(this));
        obj.e();
        Intrinsics.m26843a(obj, "this");
        obj = obj.getMenu().findItem(C1761R.id.action_submit);
        Intrinsics.m26843a(obj, "postMenuItem");
        Object obj2 = (TextView) obj.getActionView().findViewById(C1761R.id.menu_item_text);
        Intrinsics.m26843a(obj2, "postView");
        obj2.setText(getString(C1761R.string.action_post));
        obj = obj.getActionView();
        Intrinsics.m26843a(obj, "postMenuItem.actionView");
        obj.setOnClickListener((OnClickListener) new EditFragment$inlined$sam$OnClickListener$i$7f478c20((Function1) new EditFragment$configurePostButton$1(this)));
        layoutInflater = m38918j();
        layoutInflater.setText(mo7337g());
        viewGroup = getActivity();
        if (viewGroup != null) {
            viewGroup = viewGroup.getWindow();
            if (viewGroup != null) {
                viewGroup.setSoftInputMode(4);
            }
        }
        layoutInflater.requestFocus();
        return this.e;
    }

    public void onStart() {
        super.onStart();
        Presenter presenter = this.f39089b;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.attach();
    }

    public void onStop() {
        super.onStop();
        Presenter presenter = this.f39089b;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.detach();
    }

    public final void mo7155a(String str) {
        Intrinsics.m26847b(str, "message");
        Snackbar.a(this.e, str, -1).a();
    }

    public final void mo7156b() {
        Snackbar.a(this.e, C1761R.string.error_network_error, -1).a();
    }

    public final void mo7157c() {
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object activity = getActivity();
        if (activity == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(activity, "activity!!");
        AlertDialog a = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23286a((Context) activity, (int) C1761R.string.title_updating, false);
        a.show();
        this.f39091g = a;
    }

    public final void mo7158d() {
        AlertDialog alertDialog = this.f39091g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f39091g = null;
    }

    public final void mo7159e() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
            activity.finish();
        }
    }

    public final void mo7154a(Editable<?> editable) {
        Intrinsics.m26847b(editable, "editable");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("com.reddit.frontpage.editable", editable);
            activity.setResult(-1, intent);
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
