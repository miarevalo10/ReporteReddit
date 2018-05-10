package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
public final class Checks {
    final Name f26376a;
    final Regex f26377b;
    final Collection<Name> f26378c;
    final Function1<FunctionDescriptor, String> f26379d;
    final Check[] f26380e;

    /* compiled from: modifierChecks.kt */
    static final class C30062 extends Lambda implements Function1 {
        public static final C30062 f38950a = new C30062();

        C30062() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Intrinsics.m26847b((FunctionDescriptor) obj, "$receiver");
            return null;
        }
    }

    /* compiled from: modifierChecks.kt */
    static final class C30073 extends Lambda implements Function1 {
        public static final C30073 f38951a = new C30073();

        C30073() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Intrinsics.m26847b((FunctionDescriptor) obj, "$receiver");
            return null;
        }
    }

    /* compiled from: modifierChecks.kt */
    static final class C30084 extends Lambda implements Function1 {
        public static final C30084 f38952a = new C30084();

        C30084() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Intrinsics.m26847b((FunctionDescriptor) obj, "$receiver");
            return null;
        }
    }

    private Checks(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.f26376a = name;
        this.f26377b = regex;
        this.f26378c = collection;
        this.f26379d = function1;
        this.f26380e = checkArr;
    }

    public Checks(Name name, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(checkArr, "checks");
        Intrinsics.m26847b(function1, "additionalChecks");
        this(name, null, null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
    }

    private Checks(Regex regex, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics.m26847b(regex, "regex");
        Intrinsics.m26847b(checkArr, "checks");
        Intrinsics.m26847b(function1, "additionalChecks");
        this(null, regex, null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
    }

    public Checks(Collection<Name> collection, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics.m26847b(collection, "nameList");
        Intrinsics.m26847b(checkArr, "checks");
        Intrinsics.m26847b(function1, "additionalChecks");
        this(null, null, collection, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
    }
}
