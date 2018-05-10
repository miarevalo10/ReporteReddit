package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"collectToken", "", "T", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: TemplateParser.kt */
final class TemplateParser$parse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StringBuilder f37093a;
    final /* synthetic */ ObjectRef f37094b;

    TemplateParser$parse$1(StringBuilder stringBuilder, ObjectRef objectRef) {
        this.f37093a = stringBuilder;
        this.f37094b = objectRef;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        m37465a();
        return Unit.f25273a;
    }

    public final void m37465a() {
        if ((((CharSequence) this.f37093a).length() > 0 ? 1 : 0) != 0) {
            this.f37094b.f25291a = this.f37093a.toString();
            this.f37093a.delete(0, this.f37093a.length());
        }
    }
}
