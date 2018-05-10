package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2952xe59eb416 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38539a;
    final /* synthetic */ String f38540b;
    final /* synthetic */ String f38541c;
    final /* synthetic */ String f38542d;
    final /* synthetic */ String f38543e;
    final /* synthetic */ String f38544f;
    final /* synthetic */ String f38545g;
    final /* synthetic */ String f38546h;
    final /* synthetic */ String f38547i;
    final /* synthetic */ String f38548j;

    C2952xe59eb416(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38539a = signatureBuildingComponents;
        this.f38540b = str;
        this.f38541c = str2;
        this.f38542d = str3;
        this.f38543e = str4;
        this.f38544f = str5;
        this.f38545g = str6;
        this.f38546h = str7;
        this.f38547i = str8;
        this.f38548j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38545g, PredefinedEnhancementInfoKt.f25754c);
        functionEnhancementBuilder.m27266b(this.f38548j, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25754c);
        return Unit.f25273a;
    }
}
