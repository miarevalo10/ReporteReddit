package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2950xe59eb414 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38519a;
    final /* synthetic */ String f38520b;
    final /* synthetic */ String f38521c;
    final /* synthetic */ String f38522d;
    final /* synthetic */ String f38523e;
    final /* synthetic */ String f38524f;
    final /* synthetic */ String f38525g;
    final /* synthetic */ String f38526h;
    final /* synthetic */ String f38527i;
    final /* synthetic */ String f38528j;

    C2950xe59eb414(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38519a = signatureBuildingComponents;
        this.f38520b = str;
        this.f38521c = str2;
        this.f38522d = str3;
        this.f38523e = str4;
        this.f38524f = str5;
        this.f38525g = str6;
        this.f38526h = str7;
        this.f38527i = str8;
        this.f38528j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38525g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27264a(this.f38525g, PredefinedEnhancementInfoKt.f25754c);
        functionEnhancementBuilder.m27264a(this.f38526h, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25754c, PredefinedEnhancementInfoKt.f25754c, PredefinedEnhancementInfoKt.f25752a);
        functionEnhancementBuilder.m27266b(this.f38525g, PredefinedEnhancementInfoKt.f25752a);
        return Unit.f25273a;
    }
}
