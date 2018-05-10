package com.reddit.frontpage.presentation.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.detail.ReplyContract.Presenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.widgets.submit.OnQuoteSelectedListener;
import com.reddit.frontpage.widgets.submit.ReplyablePreview;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H%J\b\u0010)\u001a\u00020(H%J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020,H$J\b\u0010-\u001a\u00020(H%J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020#H\u0016J\b\u00101\u001a\u00020#H\u0016J&\u00102\u001a\u0004\u0018\u00010,2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020#H\u0016J\b\u0010:\u001a\u00020#H\u0016J\b\u0010;\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0010\u0010?\u001a\u00020#2\u0006\u0010=\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020#H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 ¨\u0006B"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyFragment;", "Lcom/reddit/frontpage/ui/BaseFrontpageFragment;", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;", "()V", "kindWithId", "", "getKindWithId", "()Ljava/lang/String;", "presenter", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;)V", "progressDialog", "Landroid/support/v7/app/AlertDialog;", "replyText", "getReplyText", "replyTextView", "Landroid/widget/EditText;", "getReplyTextView", "()Landroid/widget/EditText;", "replyTextView$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "targetContainer", "Landroid/widget/FrameLayout;", "getTargetContainer", "()Landroid/widget/FrameLayout;", "targetContainer$delegate", "toolbar", "Landroid/support/v7/widget/Toolbar;", "getToolbar", "()Landroid/support/v7/widget/Toolbar;", "toolbar$delegate", "configurePostButton", "", "formatTextForBlockquote", "quote", "", "getDiscardWarning", "", "getHint", "getLayoutId", "getReplyablePreview", "Landroid/view/View;", "getTitle", "handleBack", "", "hideProgressDialog", "navigateAway", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "showDiscardWarningDialog", "showErrorMessage", "message", "showFallbackErrorMessage", "showGenericErrorMessage", "showProgressDialog", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyFragment.kt */
public abstract class ReplyFragment extends BaseFrontpageFragment implements View {
    static final /* synthetic */ KProperty[] f39093b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReplyFragment.class), "toolbar", "getToolbar()Landroid/support/v7/widget/Toolbar;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReplyFragment.class), "replyTextView", "getReplyTextView()Landroid/widget/EditText;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReplyFragment.class), "targetContainer", "getTargetContainer()Landroid/widget/FrameLayout;"))};
    public static final Companion f39094d = new Companion();
    private final InvalidatableLazy f39095a = LazyKt.m24084a((BaseFrontpageFragment) this, (Function0) new ReplyFragment$toolbar$2(this));
    @Inject
    public Presenter f39096c;
    private final InvalidatableLazy f39097g = LazyKt.m24084a((BaseFrontpageFragment) this, (Function0) new ReplyFragment$replyTextView$2(this));
    private final InvalidatableLazy f39098h = LazyKt.m24084a((BaseFrontpageFragment) this, (Function0) new ReplyFragment$targetContainer$2(this));
    private AlertDialog f39099i;
    private HashMap f39100j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyFragment$Companion;", "", "()V", "REDDIT_FORMAT_NEWLINE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyFragment.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final EditText m38934m() {
        return (EditText) this.f39097g.mo5678b();
    }

    protected abstract android.view.View mo7339a();

    public void mo7341b() {
        if (this.f39100j != null) {
            this.f39100j.clear();
        }
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_reply;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo7341b();
    }

    public final Presenter m38946j() {
        Presenter presenter = this.f39096c;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    public final String mo7166c() {
        return m38934m().getText().toString();
    }

    public android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup viewGroup2 = (Toolbar) ((Lazy) this.f39095a).mo5678b();
        viewGroup2.setTitle(null);
        ((TextView) viewGroup2.findViewById(C1761R.id.toolbar_title)).setText(C1761R.string.title_reply_link);
        viewGroup2.setNavigationIcon(C1761R.drawable.ic_icon_close);
        viewGroup2.setNavigationOnClickListener((OnClickListener) new ReplyFragment$onCreateView$$inlined$apply$lambda$1(this));
        viewGroup2.e();
        Object findItem = viewGroup2.getMenu().findItem(C1761R.id.action_submit);
        Intrinsics.m26843a(findItem, "postMenuItem");
        Object obj = (TextView) findItem.getActionView().findViewById(C1761R.id.menu_item_text);
        Intrinsics.m26843a(obj, "postView");
        obj.setText(getString(C1761R.string.action_post));
        findItem = findItem.getActionView();
        Intrinsics.m26843a(findItem, "postMenuItem.actionView");
        findItem.setOnClickListener((OnClickListener) new ReplyFragment$inlined$sam$OnClickListener$i$7f478c20((Function1) new ReplyFragment$configurePostButton$1(this)));
        layoutInflater = getActivity();
        if (layoutInflater != null) {
            layoutInflater = layoutInflater.getWindow();
            if (layoutInflater != null) {
                layoutInflater.setSoftInputMode(4);
            }
        }
        m38934m().requestFocus();
        layoutInflater = mo7339a();
        if ((layoutInflater instanceof ReplyablePreview) != null) {
            ((ReplyablePreview) layoutInflater).getQuoteActionModeCallback().f22027a = (OnQuoteSelectedListener) new ReplyFragment$onCreateView$2(this);
        }
        ((FrameLayout) ((Lazy) this.f39098h).mo5678b()).addView(layoutInflater);
        m38934m().setHint(C1761R.string.hint_link_reply);
        return this.e;
    }

    public void onStart() {
        super.onStart();
        Presenter presenter = this.f39096c;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.attach();
    }

    public void onStop() {
        super.onStop();
        Presenter presenter = this.f39096c;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.detach();
    }

    public final boolean mo7172k() {
        Presenter presenter = this.f39096c;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo6455a();
        return true;
    }

    public final void mo7167d() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a((Object) context, "context!!");
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
        redditAlertDialog.f21113a.a(C1761R.string.discard_comment).a(C1761R.string.action_discard, new ReplyFragment$showDiscardWarningDialog$$inlined$apply$lambda$1(this)).b(C1761R.string.action_edit, null);
        redditAlertDialog.m23323a();
    }

    public final void mo7164a(String str) {
        Intrinsics.m26847b(str, "message");
        m38934m().setError(str);
    }

    public final void mo7165b(String str) {
        Intrinsics.m26847b(str, "message");
        Snackbar.a(this.e, str, -1).a();
    }

    public final void mo7168e() {
        Snackbar.a(this.e, getString(C1761R.string.error_fallback_message), -1);
    }

    public final void mo7169f() {
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object activity = getActivity();
        if (activity == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(activity, "activity!!");
        AlertDialog a = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23286a((Context) activity, (int) C1761R.string.title_replying, false);
        a.setOnDismissListener(new ReplyFragment$showProgressDialog$$inlined$apply$lambda$1(this));
        a.setOnCancelListener(new ReplyFragment$showProgressDialog$$inlined$apply$lambda$2(this));
        this.f39099i = a;
        a = this.f39099i;
        if (a != null) {
            a.show();
        }
    }

    public final void mo7170g() {
        AlertDialog alertDialog = this.f39099i;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f39099i = null;
    }

    public final void mo7171i() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final /* synthetic */ String m38931a(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(Operation.GREATER_THAN);
        stringBuilder.append(StringsKt__StringsJVMKt.m41942a((String) charSequence.toString(), "\n\n", "\n\n>"));
        return stringBuilder.toString();
    }
}
