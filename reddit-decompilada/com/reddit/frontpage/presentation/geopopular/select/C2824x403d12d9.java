package com.reddit.frontpage.presentation.geopopular.select;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0015\u0010\u0004\u001a\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0015\u0010\b\u001a\u00110\u0003¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularMappingResult;", "p1", "Lkotlin/ParameterName;", "name", "first", "p2", "second", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class C2824x403d12d9 extends FunctionReference implements Function2<String, GeopopularMappingResult, Pair<? extends String, ? extends GeopopularMappingResult>> {
    public static final C2824x403d12d9 f36465a = new C2824x403d12d9();

    C2824x403d12d9() {
        super(2);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(Pair.class);
    }

    public final String mo5687b() {
        return "<init>";
    }

    public final String mo6932c() {
        return "<init>(Ljava/lang/Object;Ljava/lang/Object;)V";
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        String str = (String) obj;
        GeopopularMappingResult geopopularMappingResult = (GeopopularMappingResult) obj2;
        Intrinsics.m26847b(str, "p1");
        Intrinsics.m26847b(geopopularMappingResult, "p2");
        return new Pair(str, geopopularMappingResult);
    }
}
