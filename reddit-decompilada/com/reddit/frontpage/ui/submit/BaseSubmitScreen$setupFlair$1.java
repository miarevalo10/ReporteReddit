package com.reddit.frontpage.ui.submit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$setupFlair$1 extends FunctionReference implements Function1<Object, String> {
    public static final BaseSubmitScreen$setupFlair$1 f37388a = new BaseSubmitScreen$setupFlair$1();

    BaseSubmitScreen$setupFlair$1() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(CharSequence.class);
    }

    public final String mo5687b() {
        return "toString";
    }

    public final String mo6932c() {
        return "toString()Ljava/lang/String;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        Intrinsics.m26847b(charSequence, "p1");
        return charSequence.toString();
    }
}
