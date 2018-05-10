package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
final class C2962xe59eb434 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ SignatureBuildingComponents f38639a;
    final /* synthetic */ String f38640b;
    final /* synthetic */ String f38641c;
    final /* synthetic */ String f38642d;
    final /* synthetic */ String f38643e;
    final /* synthetic */ String f38644f;
    final /* synthetic */ String f38645g;
    final /* synthetic */ String f38646h;
    final /* synthetic */ String f38647i;
    final /* synthetic */ String f38648j;

    C2962xe59eb434(SignatureBuildingComponents signatureBuildingComponents, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f38639a = signatureBuildingComponents;
        this.f38640b = str;
        this.f38641c = str2;
        this.f38642d = str3;
        this.f38643e = str4;
        this.f38644f = str5;
        this.f38645g = str6;
        this.f38646h = str7;
        this.f38647i = str8;
        this.f38648j = str9;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        functionEnhancementBuilder.m27264a(this.f38645g, PredefinedEnhancementInfoKt.f25753b);
        functionEnhancementBuilder.m27266b(this.f38645g, PredefinedEnhancementInfoKt.f25753b);
        return Unit.f25273a;
    }
}
