package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2949xe59eb413 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38509a;
    final /* synthetic */ String f38510b;
    final /* synthetic */ String f38511c;
    final /* synthetic */ String f38512d;
    final /* synthetic */ String f38513e;
    final /* synthetic */ String f38514f;
    final /* synthetic */ String f38515g;
    final /* synthetic */ String f38516h;
    final /* synthetic */ String f38517i;
    final /* synthetic */ String f38518j;

    C2949xe59eb413(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38509a = signatureBuildingComponents;
        this.f38510b = str;
        this.f38511c = str2;
        this.f38512d = str3;
        this.f38513e = str4;
        this.f38514f = str5;
        this.f38515g = str6;
        this.f38516h = str7;
        this.f38517i = str8;
        this.f38518j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38515g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38516h, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25754c, PredefinedEnhancementInfoKt.f25752a);
        functionEnhancementBuilder.m27266b(this.f38515g, PredefinedEnhancementInfoKt.f25752a);
        return Unit.f25273a;
    }
}
