package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType f25924a;
        final Type f25925b;
        final MessageLite f25926c;
        final ExtensionDescriptor f25927d;
        final Class f25928e;
        final Method f25929f;

        GeneratedExtension(ContainingType containingType, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingType == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.f32863c == FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f25924a = containingType;
                this.f25925b = type;
                this.f25926c = messageLite;
                this.f25927d = extensionDescriptor;
                this.f25928e = cls;
                if (EnumLite.class.isAssignableFrom(cls) != null) {
                    this.f25929f = GeneratedMessageLite.m38548a(cls, "valueOf", new Class[]{Integer.TYPE});
                    return;
                }
                this.f25929f = null;
            }
        }

        final Object m27524a(Object obj) {
            if (this.f25927d.f32863c.f25984s != JavaType.ENUM) {
                return obj;
            }
            return GeneratedMessageLite.m38547a(this.f25929f, (Integer) obj);
        }

        final Object m27525b(Object obj) {
            return this.f25927d.f32863c.f25984s == JavaType.ENUM ? Integer.valueOf(((EnumLite) obj).mo5922a()) : obj;
        }
    }

    public interface ExtendableMessageOrBuilder extends MessageLiteOrBuilder {
    }

    static final class ExtensionDescriptor implements FieldDescriptorLite<ExtensionDescriptor> {
        final EnumLiteMap<?> f32861a = null;
        final int f32862b;
        final FieldType f32863c;
        final boolean f32864d;
        final boolean f32865e;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f32862b - ((ExtensionDescriptor) obj).f32862b;
        }

        ExtensionDescriptor(int i, FieldType fieldType, boolean z) {
            this.f32862b = i;
            this.f32863c = fieldType;
            this.f32864d = z;
            this.f32865e = false;
        }

        public final FieldType mo5865a() {
            return this.f32863c;
        }

        public final JavaType mo5866b() {
            return this.f32863c.f25984s;
        }

        public final boolean mo5867c() {
            return this.f32864d;
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo5864a(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mo7300a((GeneratedMessageLite) messageLite);
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder<BuilderType> {
        public ByteString f38788a = ByteString.f25891b;

        public abstract BuilderType mo7300a(MessageType messageType);

        public abstract MessageType mo7301c();

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
            return mo7293b();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo7293b();
        }

        public /* synthetic */ MessageLite mo7111d() {
            return mo7301c();
        }

        protected Builder() {
        }

        public BuilderType mo7293b() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        protected FieldSet<ExtensionDescriptor> f39730b = FieldSet.m27515b();
        private boolean f39731c;

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
            return mo7612e();
        }

        public /* synthetic */ Builder mo7293b() {
            return mo7612e();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo7612e();
        }

        protected ExtendableBuilder() {
        }

        public BuilderType mo7612e() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected final void m39924a(MessageType messageType) {
            if (!this.f39731c) {
                this.f39730b = this.f39730b.m27522d();
                this.f39731c = true;
            }
            FieldSet fieldSet = this.f39730b;
            messageType = messageType.f39732b;
            for (int i = 0; i < messageType.f25920a.m27568b(); i++) {
                fieldSet.m27518a(messageType.f25920a.m27569b(i));
            }
            for (Entry a : messageType.f25920a.m27570c()) {
                fieldSet.m27518a(a);
            }
        }

        static /* synthetic */ FieldSet m39922a(ExtendableBuilder extendableBuilder) {
            extendableBuilder.f39730b.m27521c();
            extendableBuilder.f39731c = false;
            return extendableBuilder.f39730b;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        protected final FieldSet<ExtensionDescriptor> f39732b;

        protected ExtendableMessage() {
            this.f39732b = FieldSet.m27513a();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.f39732b = ExtendableBuilder.m39922a((ExtendableBuilder) extendableBuilder);
        }

        public final <Type> boolean m39930a(GeneratedExtension<MessageType, Type> generatedExtension) {
            m39928c(generatedExtension);
            FieldSet fieldSet = this.f39732b;
            generatedExtension = generatedExtension.f25927d;
            if (!generatedExtension.mo5867c()) {
                return fieldSet.f25920a.get(generatedExtension) != null ? true : null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        public final <Type> Type m39931b(GeneratedExtension<MessageType, Type> generatedExtension) {
            m39928c(generatedExtension);
            Type a = this.f39732b.m27517a(generatedExtension.f25927d);
            if (a == null) {
                return generatedExtension.f25925b;
            }
            if (!generatedExtension.f25927d.f32864d) {
                return generatedExtension.m27524a(a);
            }
            if (generatedExtension.f25927d.f32863c.f25984s != JavaType.ENUM) {
                return a;
            }
            Type arrayList = new ArrayList();
            for (Object a2 : (List) a) {
                arrayList.add(generatedExtension.m27524a(a2));
            }
            return arrayList;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final boolean mo7294a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9, int r10) throws java.io.IOException {
            /*
            r6 = this;
            r0 = r6.f39732b;
            r1 = r6.mo7111d();
            r2 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.m27579a(r10);
            r3 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.m27580b(r10);
            r4 = r9.f25916a;
            r5 = new kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite$ObjectIntPair;
            r5.<init>(r1, r3);
            r1 = r4.get(r5);
            r1 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension) r1;
            r3 = 0;
            r4 = 1;
            if (r1 == 0) goto L_0x0049;
        L_0x001f:
            r5 = r1.f25927d;
            r5 = r5.f32863c;
            r5 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.m27510a(r5, r3);
            if (r2 != r5) goto L_0x002c;
        L_0x0029:
            r2 = r3;
            r5 = r2;
            goto L_0x004b;
        L_0x002c:
            r5 = r1.f25927d;
            r5 = r5.f32864d;
            if (r5 == 0) goto L_0x0049;
        L_0x0032:
            r5 = r1.f25927d;
            r5 = r5.f32863c;
            r5 = r5.mo5883a();
            if (r5 == 0) goto L_0x0049;
        L_0x003c:
            r5 = r1.f25927d;
            r5 = r5.f32863c;
            r5 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.m27510a(r5, r4);
            if (r2 != r5) goto L_0x0049;
        L_0x0046:
            r2 = r3;
            r5 = r4;
            goto L_0x004b;
        L_0x0049:
            r5 = r3;
            r2 = r4;
        L_0x004b:
            if (r2 == 0) goto L_0x0052;
        L_0x004d:
            r7 = r7.m27485a(r10, r8);
            return r7;
        L_0x0052:
            if (r5 == 0) goto L_0x009b;
        L_0x0054:
            r8 = r7.m27493f();
            r8 = r7.m27487b(r8);
            r9 = r1.f25927d;
            r9 = r9.f32863c;
            r10 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.ENUM;
            if (r9 != r10) goto L_0x0082;
        L_0x0064:
            r9 = r7.m27497j();
            if (r9 <= 0) goto L_0x0096;
        L_0x006a:
            r9 = r7.m27493f();
            r10 = r1.f25927d;
            r10 = r10.f32861a;
            r9 = r10.mo5921a(r9);
            if (r9 == 0) goto L_0x0158;
        L_0x0078:
            r10 = r1.f25927d;
            r9 = r1.m27525b(r9);
            r0.m27520b(r10, r9);
            goto L_0x0064;
        L_0x0082:
            r9 = r7.m27497j();
            if (r9 <= 0) goto L_0x0096;
        L_0x0088:
            r9 = r1.f25927d;
            r9 = r9.f32863c;
            r9 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.m27512a(r7, r9);
            r10 = r1.f25927d;
            r0.m27520b(r10, r9);
            goto L_0x0082;
        L_0x0096:
            r7.m27488c(r8);
            goto L_0x0158;
        L_0x009b:
            r2 = kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.C21401.f25923a;
            r5 = r1.f25927d;
            r5 = r5.f32863c;
            r5 = r5.f25984s;
            r5 = r5.ordinal();
            r2 = r2[r5];
            switch(r2) {
                case 1: goto L_0x00cc;
                case 2: goto L_0x00b6;
                default: goto L_0x00ac;
            };
        L_0x00ac:
            r8 = r1.f25927d;
            r8 = r8.f32863c;
            r9 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.m27512a(r7, r8);
            goto L_0x013f;
        L_0x00b6:
            r7 = r7.m27493f();
            r9 = r1.f25927d;
            r9 = r9.f32861a;
            r9 = r9.mo5921a(r7);
            if (r9 != 0) goto L_0x013f;
        L_0x00c4:
            r8.m27502b(r10);
            r8.m27502b(r7);
            goto L_0x0158;
        L_0x00cc:
            r8 = 0;
            r10 = r1.f25927d;
            r10 = r10.f32864d;
            if (r10 != 0) goto L_0x00e1;
        L_0x00d3:
            r10 = r1.f25927d;
            r10 = r0.m27517a(r10);
            r10 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r10;
            if (r10 == 0) goto L_0x00e1;
        L_0x00dd:
            r8 = r10.mo7305e();
        L_0x00e1:
            if (r8 != 0) goto L_0x00e9;
        L_0x00e3:
            r8 = r1.f25926c;
            r8 = r8.mo7304c();
        L_0x00e9:
            r10 = r1.f25927d;
            r10 = r10.f32863c;
            r2 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.GROUP;
            if (r10 != r2) goto L_0x0115;
        L_0x00f1:
            r10 = r1.f25927d;
            r10 = r10.f32862b;
            r2 = r7.f25896d;
            r3 = r7.f25897e;
            if (r2 < r3) goto L_0x0100;
        L_0x00fb:
            r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.m27534g();
            throw r7;
        L_0x0100:
            r2 = r7.f25896d;
            r2 = r2 + r4;
            r7.f25896d = r2;
            r8.mo6723b(r7, r9);
            r9 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.m27581c(r10);
            r7.m27484a(r9);
            r9 = r7.f25896d;
            r9 = r9 - r4;
            r7.f25896d = r9;
            goto L_0x013b;
        L_0x0115:
            r10 = r7.m27493f();
            r2 = r7.f25896d;
            r5 = r7.f25897e;
            if (r2 < r5) goto L_0x0124;
        L_0x011f:
            r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.m27534g();
            throw r7;
        L_0x0124:
            r10 = r7.m27487b(r10);
            r2 = r7.f25896d;
            r2 = r2 + r4;
            r7.f25896d = r2;
            r8.mo6723b(r7, r9);
            r7.m27484a(r3);
            r9 = r7.f25896d;
            r9 = r9 - r4;
            r7.f25896d = r9;
            r7.m27488c(r10);
        L_0x013b:
            r9 = r8.mo7302f();
        L_0x013f:
            r7 = r1.f25927d;
            r7 = r7.f32864d;
            if (r7 == 0) goto L_0x014f;
        L_0x0145:
            r7 = r1.f25927d;
            r8 = r1.m27525b(r9);
            r0.m27520b(r7, r8);
            goto L_0x0158;
        L_0x014f:
            r7 = r1.f25927d;
            r8 = r1.m27525b(r9);
            r0.m27519a(r7, r8);
        L_0x0158:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, int):boolean");
        }

        protected final void mo7295b() {
            this.f39732b.m27521c();
        }

        private void m39928c(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.f25924a != mo7111d()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }
    }

    protected void mo7295b() {
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(byte b) {
    }

    public Parser<? extends MessageLite> mo7112a() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean mo7294a(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return codedInputStream.m27485a(i, codedOutputStream);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> m38549a(ContainingType containingType, Type type, MessageLite messageLite, int i, FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingType, type, messageLite, new ExtensionDescriptor(i, fieldType, false), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> m38550a(ContainingType containingType, MessageLite messageLite, int i, FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingType, Collections.emptyList(), messageLite, new ExtensionDescriptor(i, fieldType, true), cls);
    }

    static Method m38548a(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Class[] clsArr2) {
            cls = String.valueOf(String.valueOf(cls.getName()));
            str = String.valueOf(String.valueOf(str));
            StringBuilder stringBuilder = new StringBuilder((45 + cls.length()) + str.length());
            stringBuilder.append("Generated message class \"");
            stringBuilder.append(cls);
            stringBuilder.append("\" missing method \"");
            stringBuilder.append(str);
            stringBuilder.append("\".");
            throw new RuntimeException(stringBuilder.toString(), clsArr2);
        }
    }

    static Object m38547a(Method method, Object... objArr) {
        try {
            return method.invoke(null, objArr);
        } catch (Method method2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", method2);
        } catch (Method method22) {
            method22 = method22.getCause();
            if ((method22 instanceof RuntimeException) != null) {
                throw ((RuntimeException) method22);
            } else if ((method22 instanceof Error) != null) {
                throw ((Error) method22);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", method22);
            }
        }
    }
}
