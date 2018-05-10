package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2953xe59eb417 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38549a;
    final /* synthetic */ String f38550b;
    final /* synthetic */ String f38551c;
    final /* synthetic */ String f38552d;
    final /* synthetic */ String f38553e;
    final /* synthetic */ String f38554f;
    final /* synthetic */ String f38555g;
    final /* synthetic */ String f38556h;
    final /* synthetic */ String f38557i;
    final /* synthetic */ String f38558j;

    C2953xe59eb417(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38549a = signatureBuildingComponents;
        this.f38550b = str;
        this.f38551c = str2;
        this.f38552d = str3;
        this.f38553e = str4;
        this.f38554f = str5;
        this.f38555g = str6;
        this.f38556h = str7;
        this.f38557i = str8;
        this.f38558j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38555g, PredefinedEnhancementInfoKt.f25752a);
        functionEnhancementBuilder.m27266b(this.f38558j, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25754c);
        return Unit.f25273a;
    }
}
