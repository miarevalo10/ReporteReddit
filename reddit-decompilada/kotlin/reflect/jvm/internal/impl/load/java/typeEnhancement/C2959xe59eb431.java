package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2959xe59eb431 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38609a;
    final /* synthetic */ String f38610b;
    final /* synthetic */ String f38611c;
    final /* synthetic */ String f38612d;
    final /* synthetic */ String f38613e;
    final /* synthetic */ String f38614f;
    final /* synthetic */ String f38615g;
    final /* synthetic */ String f38616h;
    final /* synthetic */ String f38617i;
    final /* synthetic */ String f38618j;

    C2959xe59eb431(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38609a = signatureBuildingComponents;
        this.f38610b = str;
        this.f38611c = str2;
        this.f38612d = str3;
        this.f38613e = str4;
        this.f38614f = str5;
        this.f38615g = str6;
        this.f38616h = str7;
        this.f38617i = str8;
        this.f38618j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38615g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38615g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27265a(JvmPrimitiveType.BOOLEAN);
        return Unit.f25273a;
    }
}
