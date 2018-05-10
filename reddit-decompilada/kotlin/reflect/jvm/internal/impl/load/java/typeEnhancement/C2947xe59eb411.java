package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2947xe59eb411 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38489a;
    final /* synthetic */ String f38490b;
    final /* synthetic */ String f38491c;
    final /* synthetic */ String f38492d;
    final /* synthetic */ String f38493e;
    final /* synthetic */ String f38494f;
    final /* synthetic */ String f38495g;
    final /* synthetic */ String f38496h;
    final /* synthetic */ String f38497i;
    final /* synthetic */ String f38498j;

    C2947xe59eb411(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38489a = signatureBuildingComponents;
        this.f38490b = str;
        this.f38491c = str2;
        this.f38492d = str3;
        this.f38493e = str4;
        this.f38494f = str5;
        this.f38495g = str6;
        this.f38496h = str7;
        this.f38497i = str8;
        this.f38498j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38495g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38496h, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25752a, PredefinedEnhancementInfoKt.f25752a);
        functionEnhancementBuilder.m27266b(this.f38495g, PredefinedEnhancementInfoKt.f25752a);
        return Unit.f25273a;
    }
}
