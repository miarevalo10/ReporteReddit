package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;

public final class JvmProtoBuf {
    public static final GeneratedExtension<Constructor, JvmMethodSignature> f26287a = GeneratedMessageLite.m38549a(Constructor.m41596f(), JvmMethodSignature.m40385f(), JvmMethodSignature.m40385f(), 100, FieldType.MESSAGE, JvmMethodSignature.class);
    public static final GeneratedExtension<Function, JvmMethodSignature> f26288b = GeneratedMessageLite.m38549a(Function.m41657f(), JvmMethodSignature.m40385f(), JvmMethodSignature.m40385f(), 100, FieldType.MESSAGE, JvmMethodSignature.class);
    public static final GeneratedExtension<Property, JvmPropertySignature> f26289c = GeneratedMessageLite.m38549a(Property.m41734f(), JvmPropertySignature.m40415f(), JvmPropertySignature.m40415f(), 100, FieldType.MESSAGE, JvmPropertySignature.class);
    public static final GeneratedExtension<Type, List<Annotation>> f26290d = GeneratedMessageLite.m38550a(Type.m41783f(), Annotation.m40031f(), 100, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Type, Boolean> f26291e = GeneratedMessageLite.m38549a(Type.m41783f(), Boolean.valueOf(false), null, 101, FieldType.BOOL, Boolean.class);
    public static final GeneratedExtension<TypeParameter, List<Annotation>> f26292f = GeneratedMessageLite.m38550a(TypeParameter.m41872f(), Annotation.m40031f(), 100, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Class, Integer> f26293g = GeneratedMessageLite.m38549a(Class.m41556f(), Integer.valueOf(0), null, 101, FieldType.INT32, Integer.class);
    public static final GeneratedExtension<Package, Integer> f26294h = GeneratedMessageLite.m38549a(Package.m41698f(), Integer.valueOf(0), null, 101, FieldType.INT32, Integer.class);

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> f39909b = new C27931();
        private static final JvmFieldSignature f39910e;
        int f39911c;
        int f39912d;
        private final ByteString f39913f;
        private int f39914g;
        private byte f39915h;
        private int f39916i;

        static class C27931 extends AbstractParser<JvmFieldSignature> {
            C27931() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int f39906b;
            private int f39907c;
            private int f39908d;

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40339i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40337c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40339i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40337c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40339i();
            }

            private Builder() {
            }

            public final JvmFieldSignature m40348e() {
                int i = 0;
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39906b;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                jvmFieldSignature.f39911c = this.f39907c;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                jvmFieldSignature.f39912d = this.f39908d;
                jvmFieldSignature.f39914g = i;
                return jvmFieldSignature;
            }

            public final Builder m40343a(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.m40356f()) {
                    return this;
                }
                if (jvmFieldSignature.m40363h()) {
                    int i = jvmFieldSignature.f39911c;
                    this.f39906b |= 1;
                    this.f39907c = i;
                }
                if (jvmFieldSignature.m40364i()) {
                    i = jvmFieldSignature.f39912d;
                    this.f39906b |= 2;
                    this.f39908d = i;
                }
                this.f38788a = this.f38788a.m27460a(jvmFieldSignature.f39913f);
                return this;
            }

            private Builder m40337c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmFieldSignature jvmFieldSignature;
                JvmFieldSignature jvmFieldSignature2 = null;
                try {
                    m40343a((JvmFieldSignature) JvmFieldSignature.f39909b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    jvmFieldSignature = (JvmFieldSignature) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    jvmFieldSignature2 = jvmFieldSignature;
                }
                if (jvmFieldSignature2 != null) {
                    m40343a(jvmFieldSignature2);
                }
                throw codedInputStream2;
            }

            private Builder m40339i() {
                return new Builder().m40343a(m40348e());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return JvmFieldSignature.m40356f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40348e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return JvmFieldSignature.m40356f();
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return m40365j();
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39915h = (byte) -1;
            this.f39916i = -1;
            this.f39913f = builder.f38788a;
        }

        private JvmFieldSignature() {
            this.f39915h = (byte) -1;
            this.f39916i = -1;
            this.f39913f = ByteString.f25891b;
        }

        public static JvmFieldSignature m40356f() {
            return f39910e;
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r8) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = -1;
            r6.f39915h = r0;
            r6.f39916i = r0;
            r6.m40357k();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
        L_0x0015:
            if (r2 != 0) goto L_0x0070;
        L_0x0017:
            r4 = r7.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == 0) goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x001d:
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == r5) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0021:
            r5 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == r5) goto L_0x002c;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0025:
            r4 = r6.mo7294a(r7, r1, r8, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002b:
            goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002c:
            r4 = r6.f39914g;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39914g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r7.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39912d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0039:
            r4 = r6.f39914g;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39914g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r7.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39911c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0015;
        L_0x0045:
            r2 = r3;
            goto L_0x0015;
        L_0x0047:
            r7 = move-exception;
            goto L_0x005a;
        L_0x0049:
            r7 = move-exception;
            r8 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0047 }
            r7 = r7.getMessage();	 Catch:{ all -> 0x0047 }
            r8.<init>(r7);	 Catch:{ all -> 0x0047 }
            r8.f25930a = r6;	 Catch:{ all -> 0x0047 }
            throw r8;	 Catch:{ all -> 0x0047 }
        L_0x0056:
            r7 = move-exception;	 Catch:{ all -> 0x0047 }
            r7.f25930a = r6;	 Catch:{ all -> 0x0047 }
            throw r7;	 Catch:{ all -> 0x0047 }
        L_0x005a:
            r1.m27501b();	 Catch:{ IOException -> 0x005d, all -> 0x0064 }
        L_0x005d:
            r8 = r0.m27451a();
            r6.f39913f = r8;
            goto L_0x006c;
        L_0x0064:
            r7 = move-exception;
            r8 = r0.m27451a();
            r6.f39913f = r8;
            throw r7;
        L_0x006c:
            r6.mo7295b();
            throw r7;
        L_0x0070:
            r1.m27501b();	 Catch:{ IOException -> 0x0073, all -> 0x007a }
        L_0x0073:
            r7 = r0.m27451a();
            r6.f39913f = r7;
            goto L_0x0082;
        L_0x007a:
            r7 = move-exception;
            r8 = r0.m27451a();
            r6.f39913f = r8;
            throw r7;
        L_0x0082:
            r6.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmFieldSignature.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature();
            f39910e = jvmFieldSignature;
            jvmFieldSignature.m40357k();
        }

        public final Parser<JvmFieldSignature> mo7112a() {
            return f39909b;
        }

        public final boolean m40363h() {
            return (this.f39914g & 1) == 1;
        }

        public final boolean m40364i() {
            return (this.f39914g & 2) == 2;
        }

        private void m40357k() {
            this.f39911c = 0;
            this.f39912d = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f39915h;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39915h = (byte) 1;
            return true;
        }

        public static Builder m40352a(JvmFieldSignature jvmFieldSignature) {
            return new Builder().m40343a(jvmFieldSignature);
        }

        public final Builder m40365j() {
            return new Builder().m40343a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39910e;
        }
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> f39920b = new C27941();
        private static final JvmMethodSignature f39921e;
        public int f39922c;
        public int f39923d;
        private final ByteString f39924f;
        private int f39925g;
        private byte f39926h;
        private int f39927i;

        static class C27941 extends AbstractParser<JvmMethodSignature> {
            C27941() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int f39917b;
            private int f39918c;
            private int f39919d;

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40368i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40366c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40368i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40366c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40368i();
            }

            private Builder() {
            }

            public final JvmMethodSignature m40377e() {
                int i = 0;
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39917b;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                jvmMethodSignature.f39922c = this.f39918c;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                jvmMethodSignature.f39923d = this.f39919d;
                jvmMethodSignature.f39925g = i;
                return jvmMethodSignature;
            }

            public final Builder m40372a(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.m40385f()) {
                    return this;
                }
                if (jvmMethodSignature.m40392h()) {
                    int i = jvmMethodSignature.f39922c;
                    this.f39917b |= 1;
                    this.f39918c = i;
                }
                if (jvmMethodSignature.m40393i()) {
                    i = jvmMethodSignature.f39923d;
                    this.f39917b |= 2;
                    this.f39919d = i;
                }
                this.f38788a = this.f38788a.m27460a(jvmMethodSignature.f39924f);
                return this;
            }

            private Builder m40366c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmMethodSignature jvmMethodSignature;
                JvmMethodSignature jvmMethodSignature2 = null;
                try {
                    m40372a((JvmMethodSignature) JvmMethodSignature.f39920b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    jvmMethodSignature = (JvmMethodSignature) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    jvmMethodSignature2 = jvmMethodSignature;
                }
                if (jvmMethodSignature2 != null) {
                    m40372a(jvmMethodSignature2);
                }
                throw codedInputStream2;
            }

            private Builder m40368i() {
                return new Builder().m40372a(m40377e());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return JvmMethodSignature.m40385f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40377e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return JvmMethodSignature.m40385f();
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return m40394j();
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39926h = (byte) -1;
            this.f39927i = -1;
            this.f39924f = builder.f38788a;
        }

        private JvmMethodSignature() {
            this.f39926h = (byte) -1;
            this.f39927i = -1;
            this.f39924f = ByteString.f25891b;
        }

        public static JvmMethodSignature m40385f() {
            return f39921e;
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r8) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = -1;
            r6.f39926h = r0;
            r6.f39927i = r0;
            r6.m40386k();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
        L_0x0015:
            if (r2 != 0) goto L_0x0070;
        L_0x0017:
            r4 = r7.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == 0) goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x001d:
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == r5) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0021:
            r5 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 == r5) goto L_0x002c;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0025:
            r4 = r6.mo7294a(r7, r1, r8, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002b:
            goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002c:
            r4 = r6.f39925g;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39925g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r7.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39923d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0039:
            r4 = r6.f39925g;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39925g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r7.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6.f39922c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0015;
        L_0x0045:
            r2 = r3;
            goto L_0x0015;
        L_0x0047:
            r7 = move-exception;
            goto L_0x005a;
        L_0x0049:
            r7 = move-exception;
            r8 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0047 }
            r7 = r7.getMessage();	 Catch:{ all -> 0x0047 }
            r8.<init>(r7);	 Catch:{ all -> 0x0047 }
            r8.f25930a = r6;	 Catch:{ all -> 0x0047 }
            throw r8;	 Catch:{ all -> 0x0047 }
        L_0x0056:
            r7 = move-exception;	 Catch:{ all -> 0x0047 }
            r7.f25930a = r6;	 Catch:{ all -> 0x0047 }
            throw r7;	 Catch:{ all -> 0x0047 }
        L_0x005a:
            r1.m27501b();	 Catch:{ IOException -> 0x005d, all -> 0x0064 }
        L_0x005d:
            r8 = r0.m27451a();
            r6.f39924f = r8;
            goto L_0x006c;
        L_0x0064:
            r7 = move-exception;
            r8 = r0.m27451a();
            r6.f39924f = r8;
            throw r7;
        L_0x006c:
            r6.mo7295b();
            throw r7;
        L_0x0070:
            r1.m27501b();	 Catch:{ IOException -> 0x0073, all -> 0x007a }
        L_0x0073:
            r7 = r0.m27451a();
            r6.f39924f = r7;
            goto L_0x0082;
        L_0x007a:
            r7 = move-exception;
            r8 = r0.m27451a();
            r6.f39924f = r8;
            throw r7;
        L_0x0082:
            r6.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature();
            f39921e = jvmMethodSignature;
            jvmMethodSignature.m40386k();
        }

        public final Parser<JvmMethodSignature> mo7112a() {
            return f39920b;
        }

        public final boolean m40392h() {
            return (this.f39925g & 1) == 1;
        }

        public final boolean m40393i() {
            return (this.f39925g & 2) == 2;
        }

        private void m40386k() {
            this.f39922c = 0;
            this.f39923d = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f39926h;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39926h = (byte) 1;
            return true;
        }

        public static Builder m40381a(JvmMethodSignature jvmMethodSignature) {
            return new Builder().m40372a(jvmMethodSignature);
        }

        public final Builder m40394j() {
            return new Builder().m40372a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39921e;
        }
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> f39933b = new C27951();
        private static final JvmPropertySignature f39934g;
        JvmFieldSignature f39935c;
        public JvmMethodSignature f39936d;
        public JvmMethodSignature f39937e;
        public JvmMethodSignature f39938f;
        private final ByteString f39939h;
        private int f39940i;
        private byte f39941j;
        private int f39942k;

        static class C27951 extends AbstractParser<JvmPropertySignature> {
            C27951() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int f39928b;
            private JvmFieldSignature f39929c = JvmFieldSignature.m40356f();
            private JvmMethodSignature f39930d = JvmMethodSignature.m40385f();
            private JvmMethodSignature f39931e = JvmMethodSignature.m40385f();
            private JvmMethodSignature f39932f = JvmMethodSignature.m40385f();

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40397h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40395c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40397h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40395c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40397h();
            }

            private Builder() {
            }

            private JvmPropertySignature m40398i() {
                int i = 0;
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39928b;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                jvmPropertySignature.f39935c = this.f39929c;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                jvmPropertySignature.f39936d = this.f39930d;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                jvmPropertySignature.f39937e = this.f39931e;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                jvmPropertySignature.f39938f = this.f39932f;
                jvmPropertySignature.f39940i = i;
                return jvmPropertySignature;
            }

            public final Builder m40402a(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.m40415f()) {
                    return this;
                }
                JvmMethodSignature jvmMethodSignature;
                if (jvmPropertySignature.m40422h()) {
                    JvmFieldSignature jvmFieldSignature = jvmPropertySignature.f39935c;
                    if ((this.f39928b & 1) != 1 || this.f39929c == JvmFieldSignature.m40356f()) {
                        this.f39929c = jvmFieldSignature;
                    } else {
                        this.f39929c = JvmFieldSignature.m40352a(this.f39929c).m40343a(jvmFieldSignature).m40348e();
                    }
                    this.f39928b |= 1;
                }
                if (jvmPropertySignature.m40423i()) {
                    jvmMethodSignature = jvmPropertySignature.f39936d;
                    if ((this.f39928b & 2) != 2 || this.f39930d == JvmMethodSignature.m40385f()) {
                        this.f39930d = jvmMethodSignature;
                    } else {
                        this.f39930d = JvmMethodSignature.m40381a(this.f39930d).m40372a(jvmMethodSignature).m40377e();
                    }
                    this.f39928b |= 2;
                }
                if (jvmPropertySignature.m40424j()) {
                    jvmMethodSignature = jvmPropertySignature.f39937e;
                    if ((this.f39928b & 4) != 4 || this.f39931e == JvmMethodSignature.m40385f()) {
                        this.f39931e = jvmMethodSignature;
                    } else {
                        this.f39931e = JvmMethodSignature.m40381a(this.f39931e).m40372a(jvmMethodSignature).m40377e();
                    }
                    this.f39928b |= 4;
                }
                if (jvmPropertySignature.m40425k()) {
                    jvmMethodSignature = jvmPropertySignature.f39938f;
                    if ((this.f39928b & 8) != 8 || this.f39932f == JvmMethodSignature.m40385f()) {
                        this.f39932f = jvmMethodSignature;
                    } else {
                        this.f39932f = JvmMethodSignature.m40381a(this.f39932f).m40372a(jvmMethodSignature).m40377e();
                    }
                    this.f39928b |= 8;
                }
                this.f38788a = this.f38788a.m27460a(jvmPropertySignature.f39939h);
                return this;
            }

            private Builder m40395c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmPropertySignature jvmPropertySignature;
                JvmPropertySignature jvmPropertySignature2 = null;
                try {
                    m40402a((JvmPropertySignature) JvmPropertySignature.f39933b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    jvmPropertySignature = (JvmPropertySignature) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    jvmPropertySignature2 = jvmPropertySignature;
                }
                if (jvmPropertySignature2 != null) {
                    m40402a(jvmPropertySignature2);
                }
                throw codedInputStream2;
            }

            private Builder m40397h() {
                return new Builder().m40402a(m40398i());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return JvmPropertySignature.m40415f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40398i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return JvmPropertySignature.m40415f();
            }
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39941j = (byte) -1;
            this.f39942k = -1;
            this.f39939h = builder.f38788a;
        }

        private JvmPropertySignature() {
            this.f39941j = (byte) -1;
            this.f39942k = -1;
            this.f39939h = ByteString.f25891b;
        }

        public static JvmPropertySignature m40415f() {
            return f39934g;
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = -1;
            r7.f39941j = r0;
            r7.f39942k = r0;
            r7.m40416l();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
        L_0x0015:
            if (r2 != 0) goto L_0x0108;
        L_0x0017:
            r4 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 == 0) goto L_0x00dc;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x001d:
            r5 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 == r5) goto L_0x00b3;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0022:
            r5 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 == r5) goto L_0x0089;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0026:
            r5 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 == r5) goto L_0x0060;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x002a:
            r5 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 == r5) goto L_0x0036;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x002e:
            r4 = r7.mo7294a(r8, r1, r9, r4);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0034:
            goto L_0x00dc;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0036:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 & r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 != r5) goto L_0x0043;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x003d:
            r4 = r7.f39938f;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6 = r4.m40394j();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0043:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature.f39920b;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r8.m27483a(r4, r9);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39938f = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r6 == 0) goto L_0x005a;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x004f:
            r4 = r7.f39938f;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6.m40372a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r6.m40377e();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39938f = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x005a:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39940i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0060:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r5 = 4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 & r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 != r5) goto L_0x006c;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0066:
            r4 = r7.f39937e;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6 = r4.m40394j();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x006c:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature.f39920b;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r8.m27483a(r4, r9);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39937e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r6 == 0) goto L_0x0083;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0078:
            r4 = r7.f39937e;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6.m40372a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r6.m40377e();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39937e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0083:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39940i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0089:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r5 = 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 & r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 != r5) goto L_0x0095;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x008f:
            r4 = r7.f39936d;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6 = r4.m40394j();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x0095:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature.f39920b;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r8.m27483a(r4, r9);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39936d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r6 == 0) goto L_0x00ac;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00a1:
            r4 = r7.f39936d;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6.m40372a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r6.m40377e();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39936d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00ac:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39940i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00b3:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 & r3;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r4 != r3) goto L_0x00be;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00b8:
            r4 = r7.f39935c;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6 = r4.m40365j();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00be:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmFieldSignature.f39909b;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r8.m27483a(r4, r9);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmFieldSignature) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39935c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            if (r6 == 0) goto L_0x00d5;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00ca:
            r4 = r7.f39935c;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r6.m40343a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r6.m40348e();	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39935c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
        L_0x00d5:
            r4 = r7.f39940i;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            r7.f39940i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00ee, IOException -> 0x00e1 }
            goto L_0x0015;
        L_0x00dc:
            r2 = r3;
            goto L_0x0015;
        L_0x00df:
            r8 = move-exception;
            goto L_0x00f2;
        L_0x00e1:
            r8 = move-exception;
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00df }
            r8 = r8.getMessage();	 Catch:{ all -> 0x00df }
            r9.<init>(r8);	 Catch:{ all -> 0x00df }
            r9.f25930a = r7;	 Catch:{ all -> 0x00df }
            throw r9;	 Catch:{ all -> 0x00df }
        L_0x00ee:
            r8 = move-exception;	 Catch:{ all -> 0x00df }
            r8.f25930a = r7;	 Catch:{ all -> 0x00df }
            throw r8;	 Catch:{ all -> 0x00df }
        L_0x00f2:
            r1.m27501b();	 Catch:{ IOException -> 0x00f5, all -> 0x00fc }
        L_0x00f5:
            r9 = r0.m27451a();
            r7.f39939h = r9;
            goto L_0x0104;
        L_0x00fc:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39939h = r9;
            throw r8;
        L_0x0104:
            r7.mo7295b();
            throw r8;
        L_0x0108:
            r1.m27501b();	 Catch:{ IOException -> 0x010b, all -> 0x0112 }
        L_0x010b:
            r8 = r0.m27451a();
            r7.f39939h = r8;
            goto L_0x011a;
        L_0x0112:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39939h = r9;
            throw r8;
        L_0x011a:
            r7.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature();
            f39934g = jvmPropertySignature;
            jvmPropertySignature.m40416l();
        }

        public final Parser<JvmPropertySignature> mo7112a() {
            return f39933b;
        }

        public final boolean m40422h() {
            return (this.f39940i & 1) == 1;
        }

        public final boolean m40423i() {
            return (this.f39940i & 2) == 2;
        }

        public final boolean m40424j() {
            return (this.f39940i & 4) == 4;
        }

        public final boolean m40425k() {
            return (this.f39940i & 8) == 8;
        }

        private void m40416l() {
            this.f39935c = JvmFieldSignature.m40356f();
            this.f39936d = JvmMethodSignature.m40385f();
            this.f39937e = JvmMethodSignature.m40385f();
            this.f39938f = JvmMethodSignature.m40385f();
        }

        public final boolean mo7303g() {
            byte b = this.f39941j;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39941j = (byte) 1;
            return true;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40402a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39934g;
        }
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> f39967b = new C27961();
        private static final StringTableTypes f39968e;
        public List<Record> f39969c;
        public List<Integer> f39970d;
        private final ByteString f39971f;
        private int f39972g;
        private byte f39973h;
        private int f39974i;

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        static class C27961 extends AbstractParser<StringTableTypes> {
            C27961() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTableTypes(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int f39943b;
            private List<Record> f39944c = Collections.emptyList();
            private List<Integer> f39945d = Collections.emptyList();

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40428h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40426c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40428h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40426c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40428h();
            }

            private Builder() {
            }

            private StringTableTypes m40429i() {
                StringTableTypes stringTableTypes = new StringTableTypes((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39943b & 1) == 1) {
                    this.f39944c = Collections.unmodifiableList(this.f39944c);
                    this.f39943b &= -2;
                }
                stringTableTypes.f39969c = this.f39944c;
                if ((this.f39943b & 2) == 2) {
                    this.f39945d = Collections.unmodifiableList(this.f39945d);
                    this.f39943b &= -3;
                }
                stringTableTypes.f39970d = this.f39945d;
                return stringTableTypes;
            }

            public final Builder m40433a(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.m40480f()) {
                    return this;
                }
                if (!stringTableTypes.f39969c.isEmpty()) {
                    if (this.f39944c.isEmpty()) {
                        this.f39944c = stringTableTypes.f39969c;
                        this.f39943b &= -2;
                    } else {
                        if ((this.f39943b & 1) != 1) {
                            this.f39944c = new ArrayList(this.f39944c);
                            this.f39943b |= 1;
                        }
                        this.f39944c.addAll(stringTableTypes.f39969c);
                    }
                }
                if (!stringTableTypes.f39970d.isEmpty()) {
                    if (this.f39945d.isEmpty()) {
                        this.f39945d = stringTableTypes.f39970d;
                        this.f39943b &= -3;
                    } else {
                        if ((this.f39943b & 2) != 2) {
                            this.f39945d = new ArrayList(this.f39945d);
                            this.f39943b |= 2;
                        }
                        this.f39945d.addAll(stringTableTypes.f39970d);
                    }
                }
                this.f38788a = this.f38788a.m27460a(stringTableTypes.f39971f);
                return this;
            }

            private Builder m40426c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTableTypes stringTableTypes;
                StringTableTypes stringTableTypes2 = null;
                try {
                    m40433a((StringTableTypes) StringTableTypes.f39967b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    stringTableTypes = (StringTableTypes) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    stringTableTypes2 = stringTableTypes;
                }
                if (stringTableTypes2 != null) {
                    m40433a(stringTableTypes2);
                }
                throw codedInputStream2;
            }

            private Builder m40428h() {
                return new Builder().m40433a(m40429i());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return StringTableTypes.m40480f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40429i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return StringTableTypes.m40480f();
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> f39953b = new C27971();
            private static final Record f39954j;
            int f39955c;
            public int f39956d;
            public int f39957e;
            public Object f39958f;
            public Operation f39959g;
            public List<Integer> f39960h;
            public List<Integer> f39961i;
            private final ByteString f39962k;
            private int f39963l;
            private int f39964m;
            private byte f39965n;
            private int f39966o;

            public enum Operation implements EnumLite {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);
                
                private static EnumLiteMap<Operation> f33050d;
                private final int f33052e;

                static class C25941 implements EnumLiteMap<Operation> {
                    C25941() {
                    }

                    public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                        return Operation.m33557a(i);
                    }
                }

                static {
                    f33050d = new C25941();
                }

                public final int mo5922a() {
                    return this.f33052e;
                }

                public static Operation m33557a(int i) {
                    switch (i) {
                        case 0:
                            return NONE;
                        case 1:
                            return INTERNAL_TO_CLASS_ID;
                        case 2:
                            return DESC_TO_CLASS_ID;
                        default:
                            return 0;
                    }
                }

                private Operation(int i) {
                    this.f33052e = i;
                }
            }

            static class C27971 extends AbstractParser<Record> {
                C27971() {
                }

                public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Record(codedInputStream, extensionRegistryLite);
                }
            }

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int f39946b;
                private int f39947c = 1;
                private int f39948d;
                private Object f39949e = "";
                private Operation f39950f = Operation.NONE;
                private List<Integer> f39951g = Collections.emptyList();
                private List<Integer> f39952h = Collections.emptyList();

                public final boolean mo7303g() {
                    return true;
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                    return m40442h();
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return m40440c(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                    return m40442h();
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return m40440c(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return m40442h();
                }

                private Builder() {
                }

                private Record m40443i() {
                    int i = 0;
                    Record record = new Record((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                    int i2 = this.f39946b;
                    if ((i2 & 1) == 1) {
                        i = 1;
                    }
                    record.f39956d = this.f39947c;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    record.f39957e = this.f39948d;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    record.f39958f = this.f39949e;
                    if ((i2 & 8) == 8) {
                        i |= 8;
                    }
                    record.f39959g = this.f39950f;
                    if ((this.f39946b & 16) == 16) {
                        this.f39951g = Collections.unmodifiableList(this.f39951g);
                        this.f39946b &= -17;
                    }
                    record.f39960h = this.f39951g;
                    if ((this.f39946b & 32) == 32) {
                        this.f39952h = Collections.unmodifiableList(this.f39952h);
                        this.f39946b &= -33;
                    }
                    record.f39961i = this.f39952h;
                    record.f39955c = i;
                    return record;
                }

                public final Builder m40447a(Record record) {
                    if (record == Record.m40465f()) {
                        return this;
                    }
                    int i = 1;
                    if (((record.f39955c & 1) == 1 ? 1 : 0) != 0) {
                        int i2 = record.f39956d;
                        this.f39946b |= 1;
                        this.f39947c = i2;
                    }
                    if (record.m40472h()) {
                        i2 = record.f39957e;
                        this.f39946b |= 2;
                        this.f39948d = i2;
                    }
                    if (record.m40473i()) {
                        this.f39946b |= 4;
                        this.f39949e = record.f39958f;
                    }
                    if ((record.f39955c & 8) != 8) {
                        i = 0;
                    }
                    if (i != 0) {
                        Operation operation = record.f39959g;
                        if (operation == null) {
                            throw new NullPointerException();
                        }
                        this.f39946b |= 8;
                        this.f39950f = operation;
                    }
                    if (!record.f39960h.isEmpty()) {
                        if (this.f39951g.isEmpty()) {
                            this.f39951g = record.f39960h;
                            this.f39946b &= -17;
                        } else {
                            if ((this.f39946b & 16) != 16) {
                                this.f39951g = new ArrayList(this.f39951g);
                                this.f39946b |= 16;
                            }
                            this.f39951g.addAll(record.f39960h);
                        }
                    }
                    if (!record.f39961i.isEmpty()) {
                        if (this.f39952h.isEmpty()) {
                            this.f39952h = record.f39961i;
                            this.f39946b &= -33;
                        } else {
                            if ((this.f39946b & 32) != 32) {
                                this.f39952h = new ArrayList(this.f39952h);
                                this.f39946b |= 32;
                            }
                            this.f39952h.addAll(record.f39961i);
                        }
                    }
                    this.f38788a = this.f38788a.m27460a(record.f39962k);
                    return this;
                }

                private Builder m40440c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Record record;
                    Record record2 = null;
                    try {
                        m40447a((Record) Record.f39953b.mo6731a(codedInputStream, extensionRegistryLite));
                        return this;
                    } catch (CodedInputStream codedInputStream2) {
                        record = (Record) codedInputStream2.f25930a;
                        throw codedInputStream2;
                    } catch (Throwable th) {
                        codedInputStream2 = th;
                        record2 = record;
                    }
                    if (record2 != null) {
                        m40447a(record2);
                    }
                    throw codedInputStream2;
                }

                private Builder m40442h() {
                    return new Builder().m40447a(m40443i());
                }

                public final /* synthetic */ GeneratedMessageLite mo7301c() {
                    return Record.m40465f();
                }

                public final /* synthetic */ MessageLite mo7302f() {
                    MessageLite i = m40443i();
                    if (i.mo7303g()) {
                        return i;
                    }
                    throw new UninitializedMessageException();
                }

                public final /* synthetic */ MessageLite mo7111d() {
                    return Record.m40465f();
                }
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
                super((byte) 0);
                this.f39963l = -1;
                this.f39964m = -1;
                this.f39965n = (byte) -1;
                this.f39966o = -1;
                this.f39962k = builder.f38788a;
            }

            private Record() {
                this.f39963l = -1;
                this.f39964m = -1;
                this.f39965n = (byte) -1;
                this.f39966o = -1;
                this.f39962k = ByteString.f25891b;
            }

            public static Record m40465f() {
                return f39954j;
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r12, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r13) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r11 = this;
                r11.<init>();
                r0 = -1;
                r11.f39963l = r0;
                r11.f39964m = r0;
                r11.f39965n = r0;
                r11.f39966o = r0;
                r11.m40466j();
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
                r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
                r2 = 0;
                r3 = 1;
                r4 = r2;
            L_0x001a:
                r5 = 32;
                r6 = 16;
                if (r2 != 0) goto L_0x0170;
            L_0x0020:
                r7 = r12.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == 0) goto L_0x012c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0026:
                r8 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r8) goto L_0x011f;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x002a:
                if (r7 == r6) goto L_0x0111;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x002c:
                r9 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r9) goto L_0x00f6;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0030:
                if (r7 == r5) goto L_0x00da;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0032:
                r8 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r8) goto L_0x00a6;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0036:
                r8 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r8) goto L_0x008a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x003a:
                r8 = 42;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r8) goto L_0x0057;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x003e:
                r8 = 50;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r8) goto L_0x004a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0042:
                r7 = r11.mo7294a(r12, r1, r13, r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 != 0) goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0048:
                goto L_0x012c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x004a:
                r7 = r12.m27490d();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r11.f39955c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r8 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39955c = r8;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39958f = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0057:
                r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r12.m27487b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 == r5) goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0063:
                r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 <= 0) goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0069:
                r8 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39961i = r8;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0072:
                r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 <= 0) goto L_0x0086;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0078:
                r8 = r11.f39961i;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r9 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0086:
                r12.m27488c(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x008a:
                r7 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r5) goto L_0x0097;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x008e:
                r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39961i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0097:
                r7 = r11.f39961i;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = java.lang.Integer.valueOf(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00a6:
                r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r12.m27487b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r4 & 16;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 == r6) goto L_0x00c1;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00b2:
                r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 <= 0) goto L_0x00c1;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00b8:
                r8 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39960h = r8;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r4 = r4 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00c1:
                r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r8 <= 0) goto L_0x00d5;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00c7:
                r8 = r11.f39960h;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r9 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x00c1;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00d5:
                r12.m27488c(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00da:
                r7 = r4 & 16;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r7 == r6) goto L_0x00e7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00de:
                r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39960h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r4 = r4 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00e7:
                r7 = r11.f39960h;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r8 = java.lang.Integer.valueOf(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x00f6:
                r9 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r10 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.m33557a(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                if (r10 != 0) goto L_0x0108;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0100:
                r1.m27502b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r1.m27502b(r9);	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0108:
                r7 = r11.f39955c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r7 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39955c = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39959g = r10;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x0111:
                r7 = r11.f39955c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r7 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39955c = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39957e = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
            L_0x011f:
                r7 = r11.f39955c;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r7 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39955c = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                r11.f39956d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013e, IOException -> 0x0131 }
                goto L_0x001a;
            L_0x012c:
                r2 = r3;
                goto L_0x001a;
            L_0x012f:
                r12 = move-exception;
                goto L_0x0142;
            L_0x0131:
                r12 = move-exception;
                r13 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x012f }
                r12 = r12.getMessage();	 Catch:{ all -> 0x012f }
                r13.<init>(r12);	 Catch:{ all -> 0x012f }
                r13.f25930a = r11;	 Catch:{ all -> 0x012f }
                throw r13;	 Catch:{ all -> 0x012f }
            L_0x013e:
                r12 = move-exception;	 Catch:{ all -> 0x012f }
                r12.f25930a = r11;	 Catch:{ all -> 0x012f }
                throw r12;	 Catch:{ all -> 0x012f }
            L_0x0142:
                r13 = r4 & 16;
                if (r13 != r6) goto L_0x014e;
            L_0x0146:
                r13 = r11.f39960h;
                r13 = java.util.Collections.unmodifiableList(r13);
                r11.f39960h = r13;
            L_0x014e:
                r13 = r4 & 32;
                if (r13 != r5) goto L_0x015a;
            L_0x0152:
                r13 = r11.f39961i;
                r13 = java.util.Collections.unmodifiableList(r13);
                r11.f39961i = r13;
            L_0x015a:
                r1.m27501b();	 Catch:{ IOException -> 0x015d, all -> 0x0164 }
            L_0x015d:
                r13 = r0.m27451a();
                r11.f39962k = r13;
                goto L_0x016c;
            L_0x0164:
                r12 = move-exception;
                r13 = r0.m27451a();
                r11.f39962k = r13;
                throw r12;
            L_0x016c:
                r11.mo7295b();
                throw r12;
            L_0x0170:
                r12 = r4 & 16;
                if (r12 != r6) goto L_0x017c;
            L_0x0174:
                r12 = r11.f39960h;
                r12 = java.util.Collections.unmodifiableList(r12);
                r11.f39960h = r12;
            L_0x017c:
                r12 = r4 & 32;
                if (r12 != r5) goto L_0x0188;
            L_0x0180:
                r12 = r11.f39961i;
                r12 = java.util.Collections.unmodifiableList(r12);
                r11.f39961i = r12;
            L_0x0188:
                r1.m27501b();	 Catch:{ IOException -> 0x018b, all -> 0x0192 }
            L_0x018b:
                r12 = r0.m27451a();
                r11.f39962k = r12;
                goto L_0x019a;
            L_0x0192:
                r12 = move-exception;
                r13 = r0.m27451a();
                r11.f39962k = r13;
                throw r12;
            L_0x019a:
                r11.mo7295b();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.Record.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
            }

            static {
                Record record = new Record();
                f39954j = record;
                record.m40466j();
            }

            public final Parser<Record> mo7112a() {
                return f39953b;
            }

            public final boolean m40472h() {
                return (this.f39955c & 2) == 2;
            }

            public final boolean m40473i() {
                return (this.f39955c & 4) == 4;
            }

            private void m40466j() {
                this.f39956d = 1;
                this.f39957e = 0;
                this.f39958f = "";
                this.f39959g = Operation.NONE;
                this.f39960h = Collections.emptyList();
                this.f39961i = Collections.emptyList();
            }

            public final boolean mo7303g() {
                byte b = this.f39965n;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                this.f39965n = (byte) 1;
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
                return new Builder().m40447a(this);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
                return new Builder();
            }

            public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
                return f39954j;
            }
        }

        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39972g = -1;
            this.f39973h = (byte) -1;
            this.f39974i = -1;
            this.f39971f = builder.f38788a;
        }

        private StringTableTypes() {
            this.f39972g = -1;
            this.f39973h = (byte) -1;
            this.f39974i = -1;
            this.f39971f = ByteString.f25891b;
        }

        public static StringTableTypes m40480f() {
            return f39968e;
        }

        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r9.<init>();
            r0 = -1;
            r9.f39972g = r0;
            r9.f39973h = r0;
            r9.f39974i = r0;
            r9.m40481h();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0018:
            r5 = 2;
            if (r2 != 0) goto L_0x00e0;
        L_0x001b:
            r6 = r10.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == 0) goto L_0x009c;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0021:
            r7 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == r7) goto L_0x0082;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0025:
            r7 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == r7) goto L_0x0067;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0029:
            r7 = 42;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == r7) goto L_0x0034;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x002d:
            r6 = r9.mo7294a(r10, r1, r11, r6);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 != 0) goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0033:
            goto L_0x009c;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0034:
            r6 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r6 = r10.m27487b(r6);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r7 == r5) goto L_0x004f;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0040:
            r7 = r10.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r7 <= 0) goto L_0x004f;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0046:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r9.f39970d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x004f:
            r7 = r10.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r7 <= 0) goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0055:
            r7 = r9.f39970d;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r8 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            goto L_0x004f;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0063:
            r10.m27488c(r6);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0067:
            r6 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == r5) goto L_0x0074;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x006b:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r9.f39970d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0074:
            r6 = r9.f39970d;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0082:
            r6 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            if (r6 == r3) goto L_0x008f;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x0086:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r9.f39969c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
        L_0x008f:
            r6 = r9.f39969c;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.Record.f39953b;	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r7 = r10.m27483a(r7, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ae, IOException -> 0x00a1 }
            goto L_0x0018;
        L_0x009c:
            r2 = r3;
            goto L_0x0018;
        L_0x009f:
            r10 = move-exception;
            goto L_0x00b2;
        L_0x00a1:
            r10 = move-exception;
            r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x009f }
            r10 = r10.getMessage();	 Catch:{ all -> 0x009f }
            r11.<init>(r10);	 Catch:{ all -> 0x009f }
            r11.f25930a = r9;	 Catch:{ all -> 0x009f }
            throw r11;	 Catch:{ all -> 0x009f }
        L_0x00ae:
            r10 = move-exception;	 Catch:{ all -> 0x009f }
            r10.f25930a = r9;	 Catch:{ all -> 0x009f }
            throw r10;	 Catch:{ all -> 0x009f }
        L_0x00b2:
            r11 = r4 & 1;
            if (r11 != r3) goto L_0x00be;
        L_0x00b6:
            r11 = r9.f39969c;
            r11 = java.util.Collections.unmodifiableList(r11);
            r9.f39969c = r11;
        L_0x00be:
            r11 = r4 & 2;
            if (r11 != r5) goto L_0x00ca;
        L_0x00c2:
            r11 = r9.f39970d;
            r11 = java.util.Collections.unmodifiableList(r11);
            r9.f39970d = r11;
        L_0x00ca:
            r1.m27501b();	 Catch:{ IOException -> 0x00cd, all -> 0x00d4 }
        L_0x00cd:
            r11 = r0.m27451a();
            r9.f39971f = r11;
            goto L_0x00dc;
        L_0x00d4:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f39971f = r11;
            throw r10;
        L_0x00dc:
            r9.mo7295b();
            throw r10;
        L_0x00e0:
            r10 = r4 & 1;
            if (r10 != r3) goto L_0x00ec;
        L_0x00e4:
            r10 = r9.f39969c;
            r10 = java.util.Collections.unmodifiableList(r10);
            r9.f39969c = r10;
        L_0x00ec:
            r10 = r4 & 2;
            if (r10 != r5) goto L_0x00f8;
        L_0x00f0:
            r10 = r9.f39970d;
            r10 = java.util.Collections.unmodifiableList(r10);
            r9.f39970d = r10;
        L_0x00f8:
            r1.m27501b();	 Catch:{ IOException -> 0x00fb, all -> 0x0102 }
        L_0x00fb:
            r10 = r0.m27451a();
            r9.f39971f = r10;
            goto L_0x010a;
        L_0x0102:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f39971f = r11;
            throw r10;
        L_0x010a:
            r9.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes();
            f39968e = stringTableTypes;
            stringTableTypes.m40481h();
        }

        public final Parser<StringTableTypes> mo7112a() {
            return f39967b;
        }

        private void m40481h() {
            this.f39969c = Collections.emptyList();
            this.f39970d = Collections.emptyList();
        }

        public final boolean mo7303g() {
            byte b = this.f39973h;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39973h = (byte) 1;
            return true;
        }

        public static StringTableTypes m40476a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringTableTypes) f39967b.mo5860a(inputStream, extensionRegistryLite);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40433a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39968e;
        }
    }

    public static void m27905a(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.m27505a(f26287a);
        extensionRegistryLite.m27505a(f26288b);
        extensionRegistryLite.m27505a(f26289c);
        extensionRegistryLite.m27505a(f26290d);
        extensionRegistryLite.m27505a(f26291e);
        extensionRegistryLite.m27505a(f26292f);
        extensionRegistryLite.m27505a(f26293g);
        extensionRegistryLite.m27505a(f26294h);
    }
}
