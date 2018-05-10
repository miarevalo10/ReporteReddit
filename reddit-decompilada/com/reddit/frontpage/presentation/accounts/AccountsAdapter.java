package com.reddit.frontpage.presentation.accounts;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.AnonymousAvatar;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.RealAvatar;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dBk\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter$AccountHolder;", "getAccounts", "Lkotlin/Function0;", "", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "isCurrentSessionAnonymous", "", "onAccountClicked", "Lkotlin/Function1;", "", "onAddAccountClicked", "onRemoveAccountClicked", "onAnonymousClicked", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "accounts", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AccountHolder", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountsAdapter.kt */
public final class AccountsAdapter extends Adapter<AccountHolder> {
    public static final Companion f28053a = new Companion();
    private final Function0<List<AccountPresentationModel>> f28054b;
    private final Function0<Boolean> f28055c;
    private final Function1<AccountPresentationModel, Unit> f28056f;
    private final Function0<Unit> f28057g;
    private final Function1<AccountPresentationModel, Unit> f28058h;
    private final Function0<Unit> f28059i;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter$Companion;", "", "()V", "VIEWTYPE_ACCOUNT", "", "VIEWTYPE_ADD_ACCOUNT", "VIEWTYPE_ANONYMOUS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter$AccountHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter;Landroid/view/View;)V", "account", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "getAccount", "()Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "removeAccountView", "getRemoveAccountView", "()Landroid/view/View;", "bindAccount", "", "bindAddAccount", "bindAnonymous", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountsAdapter.kt */
    public final class AccountHolder extends ViewHolder {
        final ImageView f28049a;
        final TextView f28050b;
        final View f28051p;
        final /* synthetic */ AccountsAdapter f28052q;

        public AccountHolder(AccountsAdapter accountsAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28052q = accountsAdapter;
            super(view);
            Object findViewById = view.findViewById(C1761R.id.account_icon);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.account_icon)");
            this.f28049a = (ImageView) findViewById;
            findViewById = view.findViewById(C1761R.id.account_name);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.account_name)");
            this.f28050b = (TextView) findViewById;
            findViewById = view.findViewById(C1761R.id.account_remove);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.account_remove)");
            this.f28051p = findViewById;
            view.setOnClickListener(new C1804xbc6d3ac1((Function1) new Function1<View, Unit>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    switch (this.f()) {
                        case null:
                            this.f28052q.f28056f.mo6492a(((AccountPresentationModel) this.f28052q.m29381b().get(this.d())));
                            break;
                        case 1:
                            this.f28052q.f28057g.invoke();
                            break;
                        case 2:
                            this.f28052q.f28059i.invoke();
                            break;
                        default:
                            break;
                    }
                    return Unit.f25273a;
                }
            }));
            accountsAdapter = this.f28051p;
            accountsAdapter.setOnClickListener(new C1804xbc6d3ac1((Function1) new AccountsAdapter$AccountHolder$$special$$inlined$apply$lambda$1(this)));
            accountsAdapter.addOnLayoutChangeListener((OnLayoutChangeListener) new AccountsAdapter$AccountHolder$2$2(accountsAdapter));
        }
    }

    public final /* synthetic */ ViewHolder m29378a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (ViewHolder) new AccountHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.account_picker_account_item, false));
    }

    public final /* synthetic */ void m29379a(ViewHolder viewHolder, int i) {
        AccountHolder accountHolder = (AccountHolder) viewHolder;
        Intrinsics.m26847b(accountHolder, "holder");
        Object obj;
        Context context;
        switch (m29380b(i)) {
            case 0:
                AccountPresentationModel accountPresentationModel = (AccountPresentationModel) m29381b().get(i);
                Intrinsics.m26847b(accountPresentationModel, "account");
                obj = accountHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                obj.setActivated(accountPresentationModel.f20322c);
                obj = accountPresentationModel.f20321b;
                if (obj instanceof RealAvatar) {
                    AvatarUtilKt.m23659a(accountHolder.f28049a, ((RealAvatar) accountPresentationModel.f20321b).f27959a, null, null);
                } else if (Intrinsics.m26845a(obj, AnonymousAvatar.f27958a)) {
                    obj = accountHolder.c;
                    Intrinsics.m26843a(obj, "itemView");
                    Intrinsics.m26843a(GlideApp.a(obj.getContext()).b(Integer.valueOf(C1761R.drawable.ic_icon_redditor)).into(accountHolder.f28049a), "GlideApp.with(itemView.c…          .into(iconView)");
                }
                TextView textView = accountHolder.f28050b;
                Object obj2 = accountHolder.c;
                Intrinsics.m26843a(obj2, "itemView");
                obj2 = obj2.getResources();
                Intrinsics.m26843a(obj2, "itemView.resources");
                textView.setText(accountPresentationModel.m22642a(obj2));
                return;
            case 1:
                i = accountHolder.f28049a;
                obj = accountHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                context = obj.getContext();
                Intrinsics.m26843a((Object) context, "itemView.context");
                i.setImageDrawable(ResourcesUtil.m22732e(context, (int) C1761R.drawable.ic_icon_add_plus));
                i = accountHolder.f28050b;
                obj = accountHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                i.setText(obj.getResources().getString(C1761R.string.action_add_account));
                ViewsKt.m24109d(accountHolder.f28051p);
                break;
            case 2:
                Object obj3 = accountHolder.c;
                Intrinsics.m26843a(obj3, "itemView");
                obj3.setActivated(((Boolean) accountHolder.f28052q.f28055c.invoke()).booleanValue());
                i = accountHolder.f28049a;
                obj = accountHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                context = obj.getContext();
                Intrinsics.m26843a((Object) context, "itemView.context");
                i.setImageDrawable(ResourcesUtil.m22732e(context, (int) C1761R.drawable.ic_icon_redditor));
                i = accountHolder.f28050b;
                obj = accountHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                i.setText(obj.getResources().getString(C1761R.string.label_anonymous));
                ViewsKt.m24109d(accountHolder.f28051p);
                return;
            default:
                break;
        }
    }

    public AccountsAdapter(Function0<? extends List<AccountPresentationModel>> function0, Function0<Boolean> function02, Function1<? super AccountPresentationModel, Unit> function1, Function0<Unit> function03, Function1<? super AccountPresentationModel, Unit> function12, Function0<Unit> function04) {
        Intrinsics.m26847b(function0, "getAccounts");
        Intrinsics.m26847b(function02, "isCurrentSessionAnonymous");
        Intrinsics.m26847b(function1, "onAccountClicked");
        Intrinsics.m26847b(function03, "onAddAccountClicked");
        Intrinsics.m26847b(function12, "onRemoveAccountClicked");
        Intrinsics.m26847b(function04, "onAnonymousClicked");
        this.f28054b = function0;
        this.f28055c = function02;
        this.f28056f = function1;
        this.f28057g = function03;
        this.f28058h = function12;
        this.f28059i = function04;
    }

    public final List<AccountPresentationModel> m29381b() {
        return (List) this.f28054b.invoke();
    }

    public final int m29377a() {
        return m29381b().size() + 2;
    }

    public final int m29380b(int i) {
        if (i <= CollectionsKt__CollectionsKt.m26787a(m29381b())) {
            return 0;
        }
        return i == CollectionsKt__CollectionsKt.m26787a(m29381b()) + 1 ? 2 : 1;
    }
}
