package com.reddit.frontpage.presentation.accounts;

import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerFragment.kt */
final class AccountPickerFragment$onCreateView$1$2 extends FunctionReference implements Function0<Boolean> {
    public static final AccountPickerFragment$onCreateView$1$2 f36344a = new AccountPickerFragment$onCreateView$1$2();

    AccountPickerFragment$onCreateView$1$2() {
        super(0);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(SessionUtil.class);
    }

    public final String mo5687b() {
        return "isActiveAnonymous";
    }

    public final String mo6932c() {
        return "isActiveAnonymous()Z";
    }

    public final /* synthetic */ Object invoke() {
        return Boolean.valueOf(SessionUtil.m23894a());
    }
}
