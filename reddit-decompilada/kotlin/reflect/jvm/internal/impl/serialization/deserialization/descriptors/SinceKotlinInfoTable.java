package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfo;

/* compiled from: SinceKotlinInfo.kt */
public final class SinceKotlinInfoTable {
    public static final Companion f26281a = new Companion();
    private static final SinceKotlinInfoTable f26282c = new SinceKotlinInfoTable(CollectionsKt__CollectionsKt.m26790a());
    private final List<SinceKotlinInfo> f26283b;

    /* compiled from: SinceKotlinInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SinceKotlinInfoTable m27896a() {
            return SinceKotlinInfoTable.f26282c;
        }

        public static SinceKotlinInfoTable m27897a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable sinceKotlinInfoTable) {
            Intrinsics.m26847b(sinceKotlinInfoTable, "table");
            if (sinceKotlinInfoTable.f39826c.size() == 0) {
                return SinceKotlinInfoTable.f26282c;
            }
            Object obj = sinceKotlinInfoTable.f39826c;
            Intrinsics.m26843a(obj, "table.infoList");
            return new SinceKotlinInfoTable(obj);
        }
    }

    private SinceKotlinInfoTable(List<SinceKotlinInfo> list) {
        this.f26283b = list;
    }
}
