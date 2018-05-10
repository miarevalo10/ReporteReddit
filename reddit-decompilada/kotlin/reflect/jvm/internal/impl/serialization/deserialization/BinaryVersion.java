package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BinaryVersion.kt */
public abstract class BinaryVersion {
    public static final Companion f26208f = new Companion();
    private static final int f26209g = -1;
    private final int f26210a;
    private final List<Integer> f26211b;
    private final int[] f26212c;
    protected final int f26213d;
    protected final int f26214e;

    /* compiled from: BinaryVersion.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public BinaryVersion(int... iArr) {
        Intrinsics.m26847b(iArr, "numbers");
        this.f26212c = iArr;
        iArr = ArraysKt___ArraysKt.m36093b(this.f26212c, 0);
        this.f26213d = iArr != null ? iArr.intValue() : f26209g;
        iArr = ArraysKt___ArraysKt.m36093b(this.f26212c, 1);
        this.f26214e = iArr != null ? iArr.intValue() : f26209g;
        iArr = ArraysKt___ArraysKt.m36093b(this.f26212c, 2);
        this.f26210a = iArr != null ? iArr.intValue() : f26209g;
        this.f26211b = this.f26212c.length > 3 ? CollectionsKt___CollectionsKt.m41449n(ArraysKt___ArraysKt.m36100c(this.f26212c).subList(3, this.f26212c.length)) : CollectionsKt__CollectionsKt.m26790a();
    }

    public boolean equals(Object obj) {
        if (Intrinsics.m26845a(getClass(), obj != null ? obj.getClass() : null)) {
            int i = this.f26213d;
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.BinaryVersion");
            }
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (i == binaryVersion.f26213d && this.f26214e == binaryVersion.f26214e && this.f26210a == binaryVersion.f26210a && Intrinsics.m26845a(this.f26211b, binaryVersion.f26211b) != null) {
                return true;
            }
        }
        return null;
    }

    public int hashCode() {
        int i = this.f26213d;
        i += (31 * i) + this.f26214e;
        i += (31 * i) + this.f26210a;
        return i + ((31 * i) + this.f26211b.hashCode());
    }

    public String toString() {
        int[] iArr = this.f26212c;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if ((i != f26209g ? 1 : null) == null) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        List list = arrayList;
        return list.isEmpty() ? "unknown" : CollectionsKt___CollectionsKt.m41412a((Iterable) list, (CharSequence) ".", null, null, 0, null, null, 62);
    }
}
