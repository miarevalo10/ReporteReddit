package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
final class MemberScope$Companion$ALL_NAME_FILTER$1 extends Lambda implements Function1<Name, Boolean> {
    public static final MemberScope$Companion$ALL_NAME_FILTER$1 f38818a = new MemberScope$Companion$ALL_NAME_FILTER$1();

    MemberScope$Companion$ALL_NAME_FILTER$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Name) obj, "it");
        return Boolean.valueOf(true);
    }
}
