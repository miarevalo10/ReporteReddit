package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2945xe59eb40f extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38469a;
    final /* synthetic */ String f38470b;
    final /* synthetic */ String f38471c;
    final /* synthetic */ String f38472d;
    final /* synthetic */ String f38473e;
    final /* synthetic */ String f38474f;
    final /* synthetic */ String f38475g;
    final /* synthetic */ String f38476h;
    final /* synthetic */ String f38477i;
    final /* synthetic */ String f38478j;

    C2945xe59eb40f(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38469a = signatureBuildingComponents;
        this.f38470b = str;
        this.f38471c = str2;
        this.f38472d = str3;
        this.f38473e = str4;
        this.f38474f = str5;
        this.f38475g = str6;
        this.f38476h = str7;
        this.f38477i = str8;
        this.f38478j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38475g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38475g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38475g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27265a(JvmPrimitiveType.BOOLEAN);
        return Unit.f25273a;
    }
}
