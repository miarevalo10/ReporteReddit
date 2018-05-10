package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"dropVariable", "", "T", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: TemplateParser.kt */
final class TemplateParser$parse$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BooleanRef f37095a;
    final /* synthetic */ TemplateResultBuilder f37096b;
    final /* synthetic */ ObjectRef f37097c;

    TemplateParser$parse$2(BooleanRef booleanRef, TemplateResultBuilder templateResultBuilder, ObjectRef objectRef) {
        this.f37095a = booleanRef;
        this.f37096b = templateResultBuilder;
        this.f37097c = objectRef;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        m37466a();
        return Unit.f25273a;
    }

    public final void m37466a() {
        if (this.f37095a.f25288a) {
            this.f37096b.mo4931a("{");
        }
        if (((String) this.f37097c.f25291a) != null) {
            TemplateResultBuilder templateResultBuilder = this.f37096b;
            String str = (String) this.f37097c.f25291a;
            if (str == null) {
                Intrinsics.m26842a();
            }
            templateResultBuilder.mo4931a(str);
            this.f37097c.f25291a = null;
        }
    }
}
