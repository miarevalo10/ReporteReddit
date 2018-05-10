package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2956xe59eb42e extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38579a;
    final /* synthetic */ String f38580b;
    final /* synthetic */ String f38581c;
    final /* synthetic */ String f38582d;
    final /* synthetic */ String f38583e;
    final /* synthetic */ String f38584f;
    final /* synthetic */ String f38585g;
    final /* synthetic */ String f38586h;
    final /* synthetic */ String f38587i;
    final /* synthetic */ String f38588j;

    C2956xe59eb42e(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38579a = signatureBuildingComponents;
        this.f38580b = str;
        this.f38581c = str2;
        this.f38582d = str3;
        this.f38583e = str4;
        this.f38584f = str5;
        this.f38585g = str6;
        this.f38586h = str7;
        this.f38587i = str8;
        this.f38588j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ((FunctionEnhancementBuilder) obj).m27264a(this.f38580b, PredefinedEnhancementInfoKt.f25753b, PredefinedEnhancementInfoKt.f25754c);
        return Unit.f25273a;
    }
}
