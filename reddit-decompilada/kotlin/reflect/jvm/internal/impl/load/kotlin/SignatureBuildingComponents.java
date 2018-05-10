package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: methodSignatureBuilding.kt */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents f25810a = null;

    static {
        SignatureBuildingComponents signatureBuildingComponents = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
        f25810a = this;
    }

    public static String m27357a(String str) {
        Intrinsics.m26847b(str, "name");
        StringBuilder stringBuilder = new StringBuilder("java/lang/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m27362b(String str) {
        Intrinsics.m26847b(str, "name");
        StringBuilder stringBuilder = new StringBuilder("java/util/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m27364c(String str) {
        Intrinsics.m26847b(str, "name");
        StringBuilder stringBuilder = new StringBuilder("java/util/function/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String[] m27361a(String... strArr) {
        Intrinsics.m26847b(strArr, "signatures");
        Object[] objArr = (Object[]) strArr;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            String str = (String) obj;
            StringBuilder stringBuilder = new StringBuilder("<init>(");
            stringBuilder.append(str);
            stringBuilder.append(")V");
            arrayList.add(stringBuilder.toString());
        }
        arrayList = (List) arrayList;
        strArr = arrayList.toArray(new String[arrayList.size()]);
        if (strArr != null) {
            return (String[]) ((Object[]) strArr);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static LinkedHashSet<String> m27360a(String str, String... strArr) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(strArr, "signatures");
        return m27365c(m27357a(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static LinkedHashSet<String> m27363b(String str, String... strArr) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(strArr, "signatures");
        return m27365c(m27362b(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    private static LinkedHashSet<String> m27365c(String str, String... strArr) {
        Intrinsics.m26847b(str, "internalName");
        Intrinsics.m26847b(strArr, "signatures");
        Object[] objArr = (Object[]) strArr;
        Collection linkedHashSet = new LinkedHashSet();
        for (Object obj : objArr) {
            String str2 = (String) obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(str2);
            linkedHashSet.add(stringBuilder.toString());
        }
        return (LinkedHashSet) linkedHashSet;
    }

    public static String m27359a(ClassDescriptor classDescriptor, String str) {
        Intrinsics.m26847b(classDescriptor, "classDescriptor");
        Intrinsics.m26847b(str, "jvmDescriptor");
        return m27358a(MethodSignatureMappingKt.m27349a(classDescriptor), str);
    }

    public static String m27358a(String str, String str2) {
        Intrinsics.m26847b(str, "internalName");
        Intrinsics.m26847b(str2, "jvmDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static String m27366d(String str) {
        if (str.length() <= 1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("L");
        stringBuilder.append(str);
        stringBuilder.append(";");
        return stringBuilder.toString();
    }
}
