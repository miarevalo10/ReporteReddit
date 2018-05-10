package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2948xe59eb412 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38499a;
    final /* synthetic */ String f38500b;
    final /* synthetic */ String f38501c;
    final /* synthetic */ String f38502d;
    final /* synthetic */ String f38503e;
    final /* synthetic */ String f38504f;
    final /* synthetic */ String f38505g;
    final /* synthetic */ String f38506h;
    final /* synthetic */ String f38507i;
    final /* synthetic */ String f38508j;

    C2948xe59eb412(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38499a = signatureBuildingComponents;
        this.f38500b = str;
        this.f38501c = str2;
        this.f38502d = str3;
        this.f38503e = str4;
        this.f38504f = str5;
        this.f38505g = str6;
        this.f38506h = str7;
        this.f38507i = str8;
        this.f38508j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38505g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38507i, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27266b(this.f38505g, PredefinedEnhancementInfoKt.f25753b);
        return Unit.f25273a;
    }
}
