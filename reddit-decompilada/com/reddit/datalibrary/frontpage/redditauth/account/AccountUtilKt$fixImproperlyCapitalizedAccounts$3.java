package com.reddit.datalibrary.frontpage.redditauth.account;

import android.accounts.Account;
import android.support.v4.util.ArraySet;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "didCapitalizationFix", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Completable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountUtilKt.kt */
final class AccountUtilKt$fixImproperlyCapitalizedAccounts$3<T, R> implements Function<Boolean, CompletableSource> {
    public static final AccountUtilKt$fixImproperlyCapitalizedAccounts$3 f16286a = new AccountUtilKt$fixImproperlyCapitalizedAccounts$3();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "properNames", "", "", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: AccountUtilKt.kt */
    static final class C15494<T, R> implements Function<T, R> {
        public static final C15494 f16284a = new C15494();

        C15494() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            Intrinsics.b(list, "properNames");
            Iterable<String> iterable = list;
            AccountUtilKt accountUtilKt = AccountUtilKt.f10833a;
            for (String a : iterable) {
                AccountUtilKt.m9176a(a);
            }
            return Unit.a;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
    /* compiled from: AccountUtilKt.kt */
    static final class C15505<T> implements Consumer<Disposable> {
        public static final C15505 f16285a = new C15505();

        C15505() {
        }

        public final /* synthetic */ void accept(Object obj) {
            obj = AccountUtilKt$fixImproperlyCapitalizedAccounts$1.f19462a;
            obj = AccountUtilKt$fixImproperlyCapitalizedAccounts$1.m20722a();
            Intrinsics.a(obj, "sharedPrefs()");
            obj = obj.edit();
            Intrinsics.a(obj, "editor");
            obj.putBoolean("pref_did_cap_fix", true);
            obj.apply();
        }
    }

    AccountUtilKt$fixImproperlyCapitalizedAccounts$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.b(bool, "didCapitalizationFix");
        if (bool.booleanValue() != null) {
            return Completable.complete();
        }
        Timber.a("Fixing improperly capitalized accounts", new Object[0]);
        obj = FrontpageApplication.k().b();
        ArrayList b = AccountUtil.m9172b(FrontpageApplication.a);
        Intrinsics.a(b, "getAccounts(FrontpageApplication.instance)");
        Iterable<Account> iterable = b;
        ArraySet arraySet = new ArraySet();
        for (Account account : iterable) {
            Iterable<String> iterable2 = arraySet;
            boolean z = true;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                for (String a : iterable2) {
                    if (StringsKt.a(a, account.name, true)) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                arraySet.add(account.name);
            }
        }
        Iterable<String> iterable3 = arraySet;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable3));
        for (String str : iterable3) {
            Intrinsics.a(str, "it");
            Single a2 = obj.a(str);
            Function1 function1 = AccountUtilKt$fixImproperlyCapitalizedAccounts$3$2$1.f19773a;
            if (function1 != null) {
                function1 = new AccountUtilKtKt$sam$Function$24aea3ed(function1);
            }
            arrayList.add(a2.map((Function) function1));
        }
        return Single.zip((List) arrayList, (Function) AccountUtilKt$fixImproperlyCapitalizedAccounts$3$3$1.f16283a).map(C15494.f16284a).toCompletable().doOnSubscribe(C15505.f16285a);
    }
}
