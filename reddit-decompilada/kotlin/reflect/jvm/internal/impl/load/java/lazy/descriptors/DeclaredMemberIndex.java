package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeclaredMemberIndex.kt */
public interface DeclaredMemberIndex {

    /* compiled from: DeclaredMemberIndex.kt */
    public static final class Empty implements DeclaredMemberIndex {
        public static final Empty f32719a = null;

        public final JavaField mo5784b(Name name) {
            Intrinsics.m26847b(name, "name");
            return null;
        }

        static {
            Empty empty = new Empty();
        }

        private Empty() {
            f32719a = this;
        }

        public final /* synthetic */ Collection mo5781a(Name name) {
            Intrinsics.m26847b(name, "name");
            return CollectionsKt__CollectionsKt.m26790a();
        }

        public final Set<Name> mo5782a() {
            return SetsKt__SetsKt.m26799a();
        }

        public final Set<Name> mo5783b() {
            return SetsKt__SetsKt.m26799a();
        }
    }

    Collection<JavaMethod> mo5781a(Name name);

    Set<Name> mo5782a();

    Set<Name> mo5783b();

    JavaField mo5784b(Name name);
}
