package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"consumeVariable", "", "T", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: TemplateParser.kt */
final class TemplateParser$parse$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TemplateParser f37098a;
    final /* synthetic */ BooleanRef f37099b;
    final /* synthetic */ ObjectRef f37100c;
    final /* synthetic */ TemplateResultBuilder f37101d;
    final /* synthetic */ TemplateParser$parse$2 f37102e;

    TemplateParser$parse$3(TemplateParser templateParser, BooleanRef booleanRef, ObjectRef objectRef, TemplateResultBuilder templateResultBuilder, TemplateParser$parse$2 templateParser$parse$2) {
        this.f37098a = templateParser;
        this.f37099b = booleanRef;
        this.f37100c = objectRef;
        this.f37101d = templateResultBuilder;
        this.f37102e = templateParser$parse$2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        m37467a();
        return Unit.f25273a;
    }

    public final void m37467a() {
        Object a;
        if (this.f37099b.f25288a) {
            String str = (String) this.f37100c.f25291a;
            if (str != null && Character.isLetter(StringsKt___StringsKt.m42684g(str))) {
                str = (String) this.f37100c.f25291a;
                if (str == null) {
                    Intrinsics.m26842a();
                }
                if (StringsKt__StringsKt.m42439a((CharSequence) str, ' ', 0, 6) == -1) {
                    TemplateResolver a2 = this.f37098a.f20977b;
                    String str2 = (String) this.f37100c.f25291a;
                    if (str2 == null) {
                        Intrinsics.m26842a();
                    }
                    a = a2.mo4929a(str2);
                    if (a != null) {
                        TemplateResultBuilder templateResultBuilder = this.f37101d;
                        if (((String) this.f37100c.f25291a) == null) {
                            Intrinsics.m26842a();
                        }
                        templateResultBuilder.mo4930a(a);
                        this.f37100c.f25291a = null;
                    } else {
                        TemplateResultBuilder templateResultBuilder2 = this.f37101d;
                        StringBuilder stringBuilder = new StringBuilder("Variable ");
                        stringBuilder.append((String) this.f37100c.f25291a);
                        stringBuilder.append(" not found");
                        templateResultBuilder2.f20978a = new Error(stringBuilder.toString());
                    }
                    if (a == null) {
                        this.f37102e.m37466a();
                        this.f37101d.mo4931a("}");
                    }
                    this.f37099b.f25288a = false;
                }
            }
        }
        a = null;
        if (a == null) {
            this.f37102e.m37466a();
            this.f37101d.mo4931a("}");
        }
        this.f37099b.f25288a = false;
    }
}
