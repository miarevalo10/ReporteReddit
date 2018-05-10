package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType;

public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet f25919d = new FieldSet((byte) 0);
    final SmallSortedMap<FieldDescriptorType, Object> f25920a = SmallSortedMap.m27559a(16);
    private boolean f25921b;
    private boolean f25922c = false;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Builder mo5864a(Builder builder, MessageLite messageLite);

        FieldType mo5865a();

        JavaType mo5866b();

        boolean mo5867c();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m27522d();
    }

    private FieldSet() {
    }

    private FieldSet(byte b) {
        m27521c();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> m27513a() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> m27515b() {
        return f25919d;
    }

    public final void m27521c() {
        if (!this.f25921b) {
            this.f25920a.mo5881a();
            this.f25921b = true;
        }
    }

    public final Object m27517a(FieldDescriptorType fieldDescriptorType) {
        fieldDescriptorType = this.f25920a.get(fieldDescriptorType);
        return fieldDescriptorType instanceof LazyField ? ((LazyField) fieldDescriptorType).m33289a() : fieldDescriptorType;
    }

    public final void m27519a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.mo5867c()) {
            m27514a(fieldDescriptorType.mo5865a(), obj);
        } else if (obj instanceof List) {
            List<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                m27514a(fieldDescriptorType.mo5865a(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.f25922c = true;
        }
        this.f25920a.m27566a((Comparable) fieldDescriptorType, obj);
    }

    public final void m27520b(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (fieldDescriptorType.mo5867c()) {
            List arrayList;
            m27514a(fieldDescriptorType.mo5865a(), obj);
            Object a = m27517a((FieldDescriptorLite) fieldDescriptorType);
            if (a == null) {
                arrayList = new ArrayList();
                this.f25920a.m27566a((Comparable) fieldDescriptorType, (Object) arrayList);
            } else {
                arrayList = (List) a;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m27514a(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
        if (r3 != 0) goto L_0x0008;
    L_0x0002:
        r2 = new java.lang.NullPointerException;
        r2.<init>();
        throw r2;
    L_0x0008:
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.C21391.f25917a;
        r2 = r2.f25984s;
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0043;
            case 2: goto L_0x0040;
            case 3: goto L_0x003d;
            case 4: goto L_0x003a;
            case 5: goto L_0x0037;
            case 6: goto L_0x0034;
            case 7: goto L_0x002b;
            case 8: goto L_0x0021;
            case 9: goto L_0x0018;
            default: goto L_0x0017;
        };
    L_0x0017:
        goto L_0x0046;
    L_0x0018:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
        if (r2 != 0) goto L_0x0029;
    L_0x001c:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField;
        if (r2 == 0) goto L_0x0046;
    L_0x0020:
        goto L_0x0029;
    L_0x0021:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0029;
    L_0x0025:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
        if (r2 == 0) goto L_0x0046;
    L_0x0029:
        r1 = r0;
        goto L_0x0046;
    L_0x002b:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
        if (r2 != 0) goto L_0x0029;
    L_0x002f:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0046;
    L_0x0033:
        goto L_0x0029;
    L_0x0034:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0029;
    L_0x0037:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0029;
    L_0x003a:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0029;
    L_0x003d:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0029;
    L_0x0040:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0029;
    L_0x0043:
        r0 = r3 instanceof java.lang.Integer;
        goto L_0x0029;
    L_0x0046:
        if (r1 != 0) goto L_0x0050;
    L_0x0048:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.a(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public final boolean m27523e() {
        for (int i = 0; i < this.f25920a.m27568b(); i++) {
            if (!m27516b(this.f25920a.m27569b(i))) {
                return false;
            }
        }
        for (Entry b : this.f25920a.m27570c()) {
            if (!m27516b(b)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m27516b(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.mo5866b() == JavaType.MESSAGE) {
            if (fieldDescriptorLite.mo5867c()) {
                for (MessageLite g : (List) entry.getValue()) {
                    if (!g.mo7303g()) {
                        return false;
                    }
                }
            }
            entry = entry.getValue();
            if (entry instanceof MessageLite) {
                if (((MessageLite) entry).mo7303g() == null) {
                    return false;
                }
            } else if ((entry instanceof LazyField) != null) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static Object m27511a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    final void m27518a(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).m33289a();
        }
        Object a;
        if (comparable.mo5867c()) {
            a = m27517a((FieldDescriptorLite) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(m27511a(a2));
            }
            this.f25920a.m27566a(comparable, a);
        } else if (comparable.mo5866b() == JavaType.MESSAGE) {
            a = m27517a((FieldDescriptorLite) comparable);
            if (a == null) {
                this.f25920a.m27566a(comparable, m27511a(value));
                return;
            }
            this.f25920a.m27566a(comparable, comparable.mo5864a(((MessageLite) a).mo7305e(), (MessageLite) value).mo7302f());
        } else {
            this.f25920a.m27566a(comparable, m27511a(value));
        }
    }

    public static Object m27512a(CodedInputStream codedInputStream, FieldType fieldType) throws IOException {
        switch (fieldType) {
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(codedInputStream.m27496i()));
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(codedInputStream.m27495h()));
            case INT64:
                return Long.valueOf(codedInputStream.m27494g());
            case UINT64:
                return Long.valueOf(codedInputStream.m27494g());
            case INT32:
                return Integer.valueOf(codedInputStream.m27493f());
            case FIXED64:
                return Long.valueOf(codedInputStream.m27496i());
            case FIXED32:
                return Integer.valueOf(codedInputStream.m27495h());
            case BOOL:
                return Boolean.valueOf(codedInputStream.m27489c());
            case STRING:
                fieldType = codedInputStream.m27493f();
                if (fieldType <= codedInputStream.f25894b - codedInputStream.f25895c && fieldType > null) {
                    String str = new String(codedInputStream.f25893a, codedInputStream.f25895c, fieldType, "UTF-8");
                    codedInputStream.f25895c += fieldType;
                    return str;
                } else if (fieldType == null) {
                    return "";
                } else {
                    return new String(codedInputStream.m27491d(fieldType), "UTF-8");
                }
            case BYTES:
                return codedInputStream.m27490d();
            case UINT32:
                return Integer.valueOf(codedInputStream.m27493f());
            case SFIXED32:
                return Integer.valueOf(codedInputStream.m27495h());
            case SFIXED64:
                return Long.valueOf(codedInputStream.m27496i());
            case SINT32:
                codedInputStream = codedInputStream.m27493f();
                return Integer.valueOf((-(codedInputStream & 1)) ^ (codedInputStream >>> 1));
            case SINT64:
                return Long.valueOf(codedInputStream.m27492e());
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public final FieldSet<FieldDescriptorType> m27522d() {
        FieldSet<FieldDescriptorType> fieldSet = new FieldSet();
        for (int i = 0; i < this.f25920a.m27568b(); i++) {
            Entry b = this.f25920a.m27569b(i);
            fieldSet.m27519a((FieldDescriptorLite) b.getKey(), b.getValue());
        }
        for (Entry b2 : this.f25920a.m27570c()) {
            fieldSet.m27519a((FieldDescriptorLite) b2.getKey(), b2.getValue());
        }
        fieldSet.f25922c = this.f25922c;
        return fieldSet;
    }

    static int m27510a(FieldType fieldType, boolean z) {
        return z ? 2 : fieldType.f25985t;
    }
}
