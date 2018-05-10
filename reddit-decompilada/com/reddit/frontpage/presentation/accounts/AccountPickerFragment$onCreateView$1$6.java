package com.reddit.frontpage.presentation.accounts;

import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerFragment.kt */
final class AccountPickerFragment$onCreateView$1$6 extends FunctionReference implements Function0<Unit> {
    public static final AccountPickerFragment$onCreateView$1$6 f36345a = new AccountPickerFragment$onCreateView$1$6();

    AccountPickerFragment$onCreateView$1$6() {
        super(0);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(SessionUtil.class);
    }

    public final String mo5687b() {
        return "logout";
    }

    public final String mo6932c() {
        return "logout()V";
    }

    public final /* synthetic */ Object invoke() {
        SessionUtil.m23896b();
        return Unit.f25273a;
    }
}
