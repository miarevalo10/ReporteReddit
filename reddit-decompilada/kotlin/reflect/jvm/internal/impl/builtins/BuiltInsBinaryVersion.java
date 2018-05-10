package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;

/* compiled from: BuiltInsBinaryVersion.kt */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final BuiltInsBinaryVersion f32613a = new BuiltInsBinaryVersion(1, 0, 0);
    public static final Companion f32614b = new Companion();

    /* compiled from: BuiltInsBinaryVersion.kt */
    public static final class Companion {
        private Companion() {
        }

        public static BuiltInsBinaryVersion m26937a(InputStream inputStream) {
            Intrinsics.m26847b(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            Iterable intRange = new IntRange(1, dataInputStream.readInt());
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(intRange));
            Iterator it = intRange.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).mo6663a();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] b = CollectionsKt___CollectionsKt.m41424b((List) arrayList);
            return new BuiltInsBinaryVersion(Arrays.copyOf(b, b.length));
        }
    }

    public BuiltInsBinaryVersion(int... iArr) {
        Intrinsics.m26847b(iArr, "numbers");
        super(Arrays.copyOf(iArr, iArr.length));
    }

    public final boolean m32912a() {
        BinaryVersion binaryVersion = f32613a;
        Intrinsics.m26847b(binaryVersion, "ourVersion");
        return this.f26213d == 0 ? binaryVersion.f26213d == 0 && this.f26214e == binaryVersion.f26214e : this.f26213d == binaryVersion.f26213d && this.f26214e <= binaryVersion.f26214e;
    }
}
