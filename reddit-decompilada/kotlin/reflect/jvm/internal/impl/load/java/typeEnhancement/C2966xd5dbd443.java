package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2966xd5dbd443 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38679a;
    final /* synthetic */ String f38680b;
    final /* synthetic */ String f38681c;
    final /* synthetic */ String f38682d;
    final /* synthetic */ String f38683e;
    final /* synthetic */ String f38684f;
    final /* synthetic */ String f38685g;
    final /* synthetic */ String f38686h;
    final /* synthetic */ String f38687i;
    final /* synthetic */ String f38688j;

    C2966xd5dbd443(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38679a = signatureBuildingComponents;
        this.f38680b = str;
        this.f38681c = str2;
        this.f38682d = str3;
        this.f38683e = str4;
        this.f38684f = str5;
        this.f38685g = str6;
        this.f38686h = str7;
        this.f38687i = str8;
        this.f38688j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38681c, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27265a(JvmPrimitiveType.BOOLEAN);
        return Unit.f25273a;
    }
}
