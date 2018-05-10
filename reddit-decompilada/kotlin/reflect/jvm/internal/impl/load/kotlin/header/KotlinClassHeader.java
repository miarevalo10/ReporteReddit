package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {
    public final Kind f25837a;
    public final JvmMetadataVersion f25838b;
    public final String[] f25839c;
    public final String[] f25840d;
    public final String[] f25841e;
    public final int f25842f;
    private final JvmBytecodeBinaryVersion f25843g;
    private final String f25844h;

    /* compiled from: KotlinClassHeader.kt */
    public enum Kind {
        ;
        
        public static final Companion f25833g = null;
        private static final Map<Integer, Kind> f25835j = null;
        private final int f25836i;

        /* compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            private Companion() {
            }

            static Map<Integer, Kind> m27382a() {
                return Kind.f25835j;
            }
        }

        private Kind(int i) {
            this.f25836i = i;
        }

        static {
            f25833g = new Companion();
            Object[] objArr = (Object[]) values();
            Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(objArr.length), 16));
            int i;
            while (i < objArr.length) {
                Object obj = objArr[i];
                linkedHashMap.put(Integer.valueOf(((Kind) obj).f25836i), obj);
                i++;
            }
            f25835j = linkedHashMap;
        }

        public static final Kind m27384a(int i) {
            Kind kind = (Kind) Companion.m27382a().get(Integer.valueOf(i));
            return kind == null ? f25827a : kind;
        }
    }

    public KotlinClassHeader(Kind kind, JvmMetadataVersion jvmMetadataVersion, JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i) {
        Intrinsics.m26847b(kind, "kind");
        Intrinsics.m26847b(jvmMetadataVersion, "metadataVersion");
        Intrinsics.m26847b(jvmBytecodeBinaryVersion, "bytecodeVersion");
        this.f25837a = kind;
        this.f25838b = jvmMetadataVersion;
        this.f25843g = jvmBytecodeBinaryVersion;
        this.f25839c = strArr;
        this.f25840d = strArr2;
        this.f25841e = strArr3;
        this.f25844h = str;
        this.f25842f = i;
    }

    public final String m27385a() {
        return Intrinsics.m26845a(this.f25837a, Kind.f25832f) ? this.f25844h : null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f25837a);
        stringBuilder.append(" version=");
        stringBuilder.append(this.f25838b);
        return stringBuilder.toString();
    }
}
