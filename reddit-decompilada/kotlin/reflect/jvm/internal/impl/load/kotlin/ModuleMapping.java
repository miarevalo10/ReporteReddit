package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageParts;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageTable;

/* compiled from: ModuleMapping.kt */
public final class ModuleMapping {
    public static final String f25802b = "kotlin_module";
    public static final ModuleMapping f25803c = new ModuleMapping(MapsKt__MapsKt.m36116a(), "EMPTY");
    public static final Companion f25804d = new Companion();
    public final Map<String, PackageParts> f25805a;
    private final String f25806e;

    /* compiled from: ModuleMapping.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModuleMapping m27355a(byte[] bArr, String str) {
            if (bArr == null) {
                return ModuleMapping.f25803c;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            int readInt = dataInputStream.readInt();
            int[] iArr = new int[readInt];
            int i = readInt - 1;
            if (i >= 0) {
                int i2 = 0;
                while (true) {
                    iArr[i2] = dataInputStream.readInt();
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            if (new JvmMetadataVersion(Arrays.copyOf(iArr, readInt)).m33204a() == null) {
                return ModuleMapping.f25803c;
            }
            bArr = PackageTable.m40326a((InputStream) dataInputStream);
            if (bArr == null) {
                return ModuleMapping.f25803c;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PackageParts packageParts : bArr.f39901c) {
                Map map = linkedHashMap;
                Object i3 = packageParts.m40309i();
                Intrinsics.m26843a(i3, "proto.packageFqName");
                Object obj = map.get(i3);
                if (obj == null) {
                    Object i4 = packageParts.m40309i();
                    Intrinsics.m26843a(i4, "proto.packageFqName");
                    obj = new PackageParts(i4);
                    map.put(i3, obj);
                }
                PackageParts packageParts2 = (PackageParts) obj;
                for (IndexedValue indexedValue : CollectionsKt___CollectionsKt.m41452q(packageParts.f39887c)) {
                    int i5 = indexedValue.f25277a;
                    i3 = (String) indexedValue.f25278b;
                    Integer num = (Integer) CollectionsKt___CollectionsKt.m41425c(packageParts.f39888d, i5);
                    Object obj2 = null;
                    num = num != null ? Integer.valueOf(num.intValue() - 1) : null;
                    Intrinsics.m26843a(i3, "partShortName");
                    if (num != null) {
                        obj2 = (String) CollectionsKt___CollectionsKt.m41425c((List) packageParts.f39889e, num.intValue());
                    }
                    Intrinsics.m26847b(i3, "partShortName");
                    packageParts2.f25807a.put(i3, obj2);
                }
            }
            for (PackageParts packageParts3 : bArr.f39902d) {
                Map map2 = linkedHashMap;
                Object i6 = packageParts3.m40309i();
                Intrinsics.m26843a(i6, "proto.packageFqName");
                i3 = map2.get(i6);
                if (i3 == null) {
                    obj = packageParts3.m40309i();
                    Intrinsics.m26843a(obj, "proto.packageFqName");
                    i3 = new PackageParts(obj);
                    map2.put(i6, i3);
                }
                for (String str2 : packageParts3.f39887c) {
                    PackageParts packageParts4 = (PackageParts) i3;
                    Intrinsics.m26847b(str2, "shortName");
                    Set set = packageParts4.f25808b;
                    if (set == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
                    }
                    TypeIntrinsics.m26873c(set).add(str2);
                }
            }
            Map map3 = linkedHashMap;
            if (str == null) {
                str = "<unknown>";
            }
            return new ModuleMapping(map3, str);
        }
    }

    private ModuleMapping(Map<String, PackageParts> map, String str) {
        this.f25805a = map;
        this.f25806e = str;
    }

    public final String toString() {
        return this.f25806e;
    }
}
