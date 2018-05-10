package com.reddit.frontpage.presentation.accounts;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/ConfirmLogoutDialog;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "context", "Landroid/content/Context;", "account", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "onRemoveConfirmed", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/content/Context;Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;Lkotlin/jvm/functions/Function1;)V", "cancelView", "Landroid/view/View;", "logoutView", "Landroid/widget/TextView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ConfirmLogoutDialog.kt */
public final class ConfirmLogoutDialog extends RedditBottomSheetDialog {
    private TextView f39064d;
    private View f39065e;
    private final AccountPresentationModel f39066f;
    private final Function1<AccountPresentationModel, Unit> f39067g;

    public ConfirmLogoutDialog(Context context, AccountPresentationModel accountPresentationModel, Function1<? super AccountPresentationModel, Unit> function1) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(accountPresentationModel, "account");
        Intrinsics.m26847b(function1, "onRemoveConfirmed");
        super(context);
        this.f39066f = accountPresentationModel;
        this.f39067g = function1;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1761R.layout.account_picker_confirm_remove);
        bundle = this.f39066f;
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        context = context.getResources();
        Intrinsics.m26843a(context, "context.resources");
        m36781a((String) bundle.m22642a(context));
        bundle = findViewById(C1761R.id.confirm_remove_account_logout);
        if (bundle == null) {
            Intrinsics.m26842a();
        }
        this.f39064d = (TextView) bundle;
        TextView textView = this.f39064d;
        if (textView == null) {
            Intrinsics.m26844a("logoutView");
        }
        ColorStateList valueOf = ColorStateList.valueOf(ContextCompat.c(textView.getContext(), C1761R.color.rdt_red));
        Intrinsics.m26843a((Object) valueOf, "ColorStateList.valueOf(C…ontext, R.color.rdt_red))");
        TextViewsKt.m24096a(textView, valueOf);
        textView.setOnClickListener(new ConfirmLogoutDialog$inlined$sam$OnClickListener$i$7f478c20(new ConfirmLogoutDialog$onCreate$$inlined$apply$lambda$1(this)));
        bundle = findViewById(C1761R.id.confirm_remove_account_cancel);
        if (bundle == null) {
            Intrinsics.m26842a();
        }
        this.f39065e = bundle;
        bundle = this.f39065e;
        if (bundle == null) {
            Intrinsics.m26844a("cancelView");
        }
        bundle.setOnClickListener(new ConfirmLogoutDialog$inlined$sam$OnClickListener$i$7f478c20(new ConfirmLogoutDialog$onCreate$2(this)));
    }
}
