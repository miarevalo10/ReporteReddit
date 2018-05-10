package org.jcodec.common.tools;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;

public class ToJSON {
    static Set<String> omitMethods = new HashSet();
    static Set<Class> primitive = new HashSet();

    static {
        primitive.add(Boolean.class);
        primitive.add(Byte.class);
        primitive.add(Short.class);
        primitive.add(Integer.class);
        primitive.add(Long.class);
        primitive.add(Float.class);
        primitive.add(Double.class);
        primitive.add(Character.class);
        omitMethods.add("getClass");
        omitMethods.add("get");
    }

    public static List<String> allFields(Class cls) {
        return allFieldsExcept(cls, new String[0]);
    }

    public static java.util.List<java.lang.String> allFieldsExcept(java.lang.Class r4, java.lang.String... r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = new java.util.ArrayList;
        r5.<init>();
        r4 = r4.getDeclaredMethods();
        r0 = 0;
        r1 = r4.length;
    L_0x000b:
        if (r0 >= r1) goto L_0x001f;
    L_0x000d:
        r2 = r4[r0];
        r3 = isGetter(r2);
        if (r3 == 0) goto L_0x001c;
    L_0x0015:
        r2 = toName(r2);	 Catch:{ Exception -> 0x001c }
        r5.add(r2);	 Catch:{ Exception -> 0x001c }
    L_0x001c:
        r0 = r0 + 1;
        goto L_0x000b;
    L_0x001f:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.ToJSON.allFieldsExcept(java.lang.Class, java.lang.String[]):java.util.List<java.lang.String>");
    }

    public static String toJSON(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        toJSONSub(obj, new IntArrayList(), stringBuilder);
        return stringBuilder.toString();
    }

    public static void fieldsToJSON(Object obj, StringBuilder stringBuilder, String... strArr) {
        Method[] methods = obj.getClass().getMethods();
        for (String str : strArr) {
            Method findGetter = findGetter(methods, str);
            if (findGetter != null) {
                invoke(obj, new IntArrayList(), stringBuilder, findGetter, str);
            }
        }
    }

    private static Method findGetter(Method[] methodArr, String str) {
        String str2 = getterName("is", str);
        str = getterName("get", str);
        for (Method method : methodArr) {
            if ((str2.equals(method.getName()) || str.equals(method.getName())) && isGetter(method)) {
                return method;
            }
        }
        return null;
    }

    private static String getterName(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("Passed null string as field name");
        }
        str2 = str2.toCharArray();
        if (str2.length == 0) {
            return str;
        }
        if (str2.length <= 1 || !Character.isUpperCase(str2[1])) {
            str2[0] = Character.toUpperCase(str2[0]);
        } else {
            str2[0] = Character.toLowerCase(str2[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(new String(str2));
        return stringBuilder.toString();
    }

    private static void toJSONSub(Object obj, IntArrayList intArrayList, StringBuilder stringBuilder) {
        int identityHashCode = System.identityHashCode(obj);
        if (intArrayList.contains(identityHashCode)) {
            stringBuilder.append("\"!-!-!-!-LOOP-!-!-!-!\"");
            return;
        }
        intArrayList.push(identityHashCode);
        if (obj instanceof ByteBuffer) {
            obj = NIOUtils.toArray((ByteBuffer) obj);
        }
        if (obj == null) {
            stringBuilder.append("null");
        } else if (obj instanceof String) {
            stringBuilder.append("\"");
            escape((String) obj, stringBuilder);
            stringBuilder.append("\"");
        } else if (obj instanceof Map) {
            obj = ((Map) obj).entrySet().iterator();
            stringBuilder.append("{");
            while (obj.hasNext()) {
                Entry entry = (Entry) obj.next();
                stringBuilder.append("\"");
                stringBuilder.append(entry.getKey());
                stringBuilder.append("\":");
                toJSONSub(entry.getValue(), intArrayList, stringBuilder);
                if (obj.hasNext()) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("}");
        } else if (obj instanceof Iterable) {
            obj = ((Iterable) obj).iterator();
            stringBuilder.append("[");
            while (obj.hasNext()) {
                toJSONSub(obj.next(), intArrayList, stringBuilder);
                if (obj.hasNext()) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
        } else {
            int i = 0;
            if (obj instanceof Object[]) {
                stringBuilder.append("[");
                identityHashCode = Array.getLength(obj);
                while (i < identityHashCode) {
                    toJSONSub(Array.get(obj, i), intArrayList, stringBuilder);
                    if (i < identityHashCode - 1) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                stringBuilder.append("]");
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < jArr.length; identityHashCode++) {
                    stringBuilder.append(String.format("0x%016x", new Object[]{Long.valueOf(jArr[identityHashCode])}));
                    if (identityHashCode < jArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < iArr.length; identityHashCode++) {
                    stringBuilder.append(String.format("0x%08x", new Object[]{Integer.valueOf(iArr[identityHashCode])}));
                    if (identityHashCode < iArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < fArr.length; identityHashCode++) {
                    stringBuilder.append(String.format(".3f", new Object[]{Float.valueOf(fArr[identityHashCode])}));
                    if (identityHashCode < fArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < dArr.length; identityHashCode++) {
                    stringBuilder.append(String.format(".6f", new Object[]{Double.valueOf(dArr[identityHashCode])}));
                    if (identityHashCode < dArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < sArr.length; identityHashCode++) {
                    stringBuilder.append(String.format("0x%04x", new Object[]{Short.valueOf(sArr[identityHashCode])}));
                    if (identityHashCode < sArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                stringBuilder.append("[");
                for (identityHashCode = 0; identityHashCode < bArr.length; identityHashCode++) {
                    stringBuilder.append(String.format("0x%02x", new Object[]{Byte.valueOf(bArr[identityHashCode])}));
                    if (identityHashCode < bArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                stringBuilder.append("[");
                while (i < zArr.length) {
                    stringBuilder.append(zArr[i]);
                    if (i < zArr.length - 1) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                stringBuilder.append("]");
            } else {
                stringBuilder.append("{");
                Method[] methods = obj.getClass().getMethods();
                int length = methods.length;
                while (i < length) {
                    Method method = methods[i];
                    if (!omitMethods.contains(method.getName()) && isGetter(method)) {
                        invoke(obj, intArrayList, stringBuilder, method, toName(method));
                    }
                    i++;
                }
                stringBuilder.append("}");
            }
        }
        intArrayList.pop();
    }

    private static void invoke(java.lang.Object r1, org.jcodec.common.IntArrayList r2, java.lang.StringBuilder r3, java.lang.reflect.Method r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x002f }
        r1 = r4.invoke(r1, r0);	 Catch:{ Exception -> 0x002f }
        r4 = 34;	 Catch:{ Exception -> 0x002f }
        r3.append(r4);	 Catch:{ Exception -> 0x002f }
        r3.append(r5);	 Catch:{ Exception -> 0x002f }
        r4 = "\":";	 Catch:{ Exception -> 0x002f }
        r3.append(r4);	 Catch:{ Exception -> 0x002f }
        if (r1 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x002f }
    L_0x0016:
        r4 = primitive;	 Catch:{ Exception -> 0x002f }
        r5 = r1.getClass();	 Catch:{ Exception -> 0x002f }
        r4 = r4.contains(r5);	 Catch:{ Exception -> 0x002f }
        if (r4 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x002f }
    L_0x0022:
        r3.append(r1);	 Catch:{ Exception -> 0x002f }
        goto L_0x0029;	 Catch:{ Exception -> 0x002f }
    L_0x0026:
        toJSONSub(r1, r2, r3);	 Catch:{ Exception -> 0x002f }
    L_0x0029:
        r1 = ",";	 Catch:{ Exception -> 0x002f }
        r3.append(r1);	 Catch:{ Exception -> 0x002f }
        return;
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.ToJSON.invoke(java.lang.Object, org.jcodec.common.IntArrayList, java.lang.StringBuilder, java.lang.reflect.Method, java.lang.String):void");
    }

    private static void escape(String str, StringBuilder stringBuilder) {
        for (char c : str.toCharArray()) {
            if (c < ' ') {
                stringBuilder.append(String.format("\\%02x", new Object[]{Integer.valueOf(c)}));
            } else {
                stringBuilder.append(c);
            }
        }
    }

    private static String toName(Method method) {
        if (isGetter(method)) {
            method = method.getName().toCharArray();
            int i = method[0] == 'g' ? 3 : 2;
            method[i] = Character.toLowerCase(method[i]);
            return new String(method, i, method.length - i);
        }
        throw new IllegalArgumentException("Not a getter");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isGetter(java.lang.reflect.Method r3) {
        /*
        r0 = r3.getModifiers();
        r0 = java.lang.reflect.Modifier.isPublic(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = r3.getName();
        r2 = "get";
        r0 = r0.startsWith(r2);
        if (r0 != 0) goto L_0x002d;
    L_0x0018:
        r0 = r3.getName();
        r2 = "is";
        r0 = r0.startsWith(r2);
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r3.getReturnType();
        r2 = java.lang.Boolean.TYPE;
        if (r0 == r2) goto L_0x002d;
    L_0x002c:
        return r1;
    L_0x002d:
        r0 = r3.getParameterTypes();
        r0 = r0.length;
        if (r0 == 0) goto L_0x0035;
    L_0x0034:
        return r1;
    L_0x0035:
        r0 = java.lang.Void.TYPE;
        r3 = r3.getReturnType();
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0042;
    L_0x0041:
        return r1;
    L_0x0042:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.ToJSON.isGetter(java.lang.reflect.Method):boolean");
    }
}
