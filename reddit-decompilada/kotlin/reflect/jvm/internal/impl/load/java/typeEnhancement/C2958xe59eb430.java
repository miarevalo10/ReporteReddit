package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2958xe59eb430 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38599a;
    final /* synthetic */ String f38600b;
    final /* synthetic */ String f38601c;
    final /* synthetic */ String f38602d;
    final /* synthetic */ String f38603e;
    final /* synthetic */ String f38604f;
    final /* synthetic */ String f38605g;
    final /* synthetic */ String f38606h;
    final /* synthetic */ String f38607i;
    final /* synthetic */ String f38608j;

    C2958xe59eb430(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38599a = signatureBuildingComponents;
        this.f38600b = str;
        this.f38601c = str2;
        this.f38602d = str3;
        this.f38603e = str4;
        this.f38604f = str5;
        this.f38605g = str6;
        this.f38606h = str7;
        this.f38607i = str8;
        this.f38608j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38605g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27265a(JvmPrimitiveType.BOOLEAN);
        return Unit.f25273a;
    }
}
