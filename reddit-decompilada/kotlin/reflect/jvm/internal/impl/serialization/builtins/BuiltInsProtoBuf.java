package kotlin.reflect.jvm.internal.impl.serialization.builtins;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.StringTable;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;

public final class BuiltInsProtoBuf {
    public static final GeneratedExtension<Package, Integer> f26188a = GeneratedMessageLite.m38549a(Package.m41698f(), Integer.valueOf(0), null, 151, FieldType.INT32, Integer.class);
    public static final GeneratedExtension<Class, List<Annotation>> f26189b = GeneratedMessageLite.m38550a(Class.m41556f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Constructor, List<Annotation>> f26190c = GeneratedMessageLite.m38550a(Constructor.m41596f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Function, List<Annotation>> f26191d = GeneratedMessageLite.m38550a(Function.m41657f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Property, List<Annotation>> f26192e = GeneratedMessageLite.m38550a(Property.m41734f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Property, Value> f26193f = GeneratedMessageLite.m38549a(Property.m41734f(), Value.m39990f(), Value.m39990f(), 151, FieldType.MESSAGE, Value.class);
    public static final GeneratedExtension<EnumEntry, List<Annotation>> f26194g = GeneratedMessageLite.m38550a(EnumEntry.m41621f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<ValueParameter, List<Annotation>> f26195h = GeneratedMessageLite.m38550a(ValueParameter.m41905f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<Type, List<Annotation>> f26196i = GeneratedMessageLite.m38550a(Type.m41783f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);
    public static final GeneratedExtension<TypeParameter, List<Annotation>> f26197j = GeneratedMessageLite.m38550a(TypeParameter.m41872f(), Annotation.m40031f(), ModuleDescriptor.MODULE_VERSION, FieldType.MESSAGE, Annotation.class);

    public interface BuiltInsOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class BuiltIns extends GeneratedMessageLite implements BuiltInsOrBuilder {
        public static Parser<BuiltIns> f39867b = new C27891();
        private static final BuiltIns f39868h;
        int f39869c;
        public StringTable f39870d;
        public QualifiedNameTable f39871e;
        public Package f39872f;
        public List<Class> f39873g;
        private final ByteString f39874i;
        private byte f39875j;
        private int f39876k;

        static class C27891 extends AbstractParser<BuiltIns> {
            C27891() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BuiltIns(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<BuiltIns, Builder> implements BuiltInsOrBuilder {
            private int f39862b;
            private StringTable f39863c = StringTable.m40164f();
            private QualifiedNameTable f39864d = QualifiedNameTable.m40086f();
            private Package f39865e = Package.m41698f();
            private List<Class> f39866f = Collections.emptyList();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40230h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40228c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40230h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40228c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40230h();
            }

            private Builder() {
            }

            private BuiltIns m40231i() {
                int i = 0;
                BuiltIns builtIns = new BuiltIns((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39862b;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                builtIns.f39870d = this.f39863c;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                builtIns.f39871e = this.f39864d;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                builtIns.f39872f = this.f39865e;
                if ((this.f39862b & 8) == 8) {
                    this.f39866f = Collections.unmodifiableList(this.f39866f);
                    this.f39862b &= -9;
                }
                builtIns.f39873g = this.f39866f;
                builtIns.f39869c = i;
                return builtIns;
            }

            public final Builder m40235a(BuiltIns builtIns) {
                if (builtIns == BuiltIns.m40250f()) {
                    return this;
                }
                if (((builtIns.f39869c & 1) == 1 ? 1 : 0) != 0) {
                    StringTable stringTable = builtIns.f39870d;
                    if ((this.f39862b & 1) != 1 || this.f39863c == StringTable.m40164f()) {
                        this.f39863c = stringTable;
                    } else {
                        this.f39863c = StringTable.m40161a(this.f39863c).m40152a(stringTable).m40157e();
                    }
                    this.f39862b |= 1;
                }
                if (builtIns.m40257h()) {
                    QualifiedNameTable qualifiedNameTable = builtIns.f39871e;
                    if ((this.f39862b & 2) != 2 || this.f39864d == QualifiedNameTable.m40086f()) {
                        this.f39864d = qualifiedNameTable;
                    } else {
                        this.f39864d = QualifiedNameTable.m40083a(this.f39864d).m40047a(qualifiedNameTable).m40052e();
                    }
                    this.f39862b |= 2;
                }
                if (builtIns.m40258i()) {
                    Package packageR = builtIns.f39872f;
                    if ((this.f39862b & 4) != 4 || this.f39865e == Package.m41698f()) {
                        this.f39865e = packageR;
                    } else {
                        this.f39865e = Package.m41688a(this.f39865e).m41677a(packageR).m41685h();
                    }
                    this.f39862b |= 4;
                }
                if (!builtIns.f39873g.isEmpty()) {
                    if (this.f39866f.isEmpty()) {
                        this.f39866f = builtIns.f39873g;
                        this.f39862b &= -9;
                    } else {
                        if ((this.f39862b & 8) != 8) {
                            this.f39866f = new ArrayList(this.f39866f);
                            this.f39862b |= 8;
                        }
                        this.f39866f.addAll(builtIns.f39873g);
                    }
                }
                this.f38788a = this.f38788a.m27460a(builtIns.f39874i);
                return this;
            }

            private Builder m40228c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                BuiltIns builtIns;
                BuiltIns builtIns2 = null;
                try {
                    m40235a((BuiltIns) BuiltIns.f39867b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    builtIns = (BuiltIns) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    builtIns2 = builtIns;
                }
                if (builtIns2 != null) {
                    m40235a(builtIns2);
                }
                throw codedInputStream2;
            }

            private Builder m40230h() {
                return new Builder().m40235a(m40231i());
            }

            public final boolean mo7303g() {
                if (((this.f39862b & 2) == 2) && !this.f39864d.mo7303g()) {
                    return false;
                }
                if (((this.f39862b & 4) == 4) && !this.f39865e.mo7303g()) {
                    return false;
                }
                for (int i = 0; i < this.f39866f.size(); i++) {
                    if (!((Class) this.f39866f.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return BuiltIns.m40250f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40231i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return BuiltIns.m40250f();
            }
        }

        private BuiltIns(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39875j = (byte) -1;
            this.f39876k = -1;
            this.f39874i = builder.f38788a;
        }

        private BuiltIns() {
            this.f39875j = (byte) -1;
            this.f39876k = -1;
            this.f39874i = ByteString.f25891b;
        }

        public static BuiltIns m40250f() {
            return f39868h;
        }

        private BuiltIns(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r9.<init>();
            r0 = -1;
            r9.f39875j = r0;
            r9.f39876k = r0;
            r9.m40251j();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 8;
            if (r2 != 0) goto L_0x0106;
        L_0x001a:
            r6 = r10.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == 0) goto L_0x00ce;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0020:
            r7 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == r7) goto L_0x00a5;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0025:
            r7 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == r7) goto L_0x007b;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0029:
            r7 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == r7) goto L_0x0052;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x002d:
            r7 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == r7) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0031:
            r6 = r9.mo7294a(r10, r1, r11, r6);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0037:
            goto L_0x00ce;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0039:
            r6 = r4 & 8;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 == r5) goto L_0x0046;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x003d:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39873g = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r4 = r4 | 8;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0046:
            r6 = r9.f39873g;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.f40311c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r7 = r10.m27483a(r7, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0052:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r7 = 4;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 & r7;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 != r7) goto L_0x005e;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0058:
            r6 = r9.f39872f;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8 = r6.m41706i();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x005e:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package.f40393c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package) r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39872f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r8 == 0) goto L_0x0075;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x006a:
            r6 = r9.f39872f;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8.m41677a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r8.m41685h();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39872f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0075:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39869c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x007b:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r7 = 2;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 & r7;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 != r7) goto L_0x0087;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0081:
            r6 = r9.f39871e;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8 = r6.m40093h();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0087:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.f39799b;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable) r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39871e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r8 == 0) goto L_0x009e;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x0093:
            r6 = r9.f39871e;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8.m40047a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r8.m40052e();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39871e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x009e:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39869c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x00a5:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 & r3;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r6 != r3) goto L_0x00b0;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x00aa:
            r6 = r9.f39870d;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8 = r6.m40171h();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x00b0:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.StringTable.f39832b;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.StringTable) r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39870d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            if (r8 == 0) goto L_0x00c7;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x00bc:
            r6 = r9.f39870d;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r8.m40152a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r8.m40157e();	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39870d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
        L_0x00c7:
            r6 = r9.f39869c;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r6 = r6 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            r9.f39869c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x00e0, IOException -> 0x00d3 }
            goto L_0x0016;
        L_0x00ce:
            r2 = r3;
            goto L_0x0016;
        L_0x00d1:
            r10 = move-exception;
            goto L_0x00e4;
        L_0x00d3:
            r10 = move-exception;
            r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00d1 }
            r10 = r10.getMessage();	 Catch:{ all -> 0x00d1 }
            r11.<init>(r10);	 Catch:{ all -> 0x00d1 }
            r11.f25930a = r9;	 Catch:{ all -> 0x00d1 }
            throw r11;	 Catch:{ all -> 0x00d1 }
        L_0x00e0:
            r10 = move-exception;	 Catch:{ all -> 0x00d1 }
            r10.f25930a = r9;	 Catch:{ all -> 0x00d1 }
            throw r10;	 Catch:{ all -> 0x00d1 }
        L_0x00e4:
            r11 = r4 & 8;
            if (r11 != r5) goto L_0x00f0;
        L_0x00e8:
            r11 = r9.f39873g;
            r11 = java.util.Collections.unmodifiableList(r11);
            r9.f39873g = r11;
        L_0x00f0:
            r1.m27501b();	 Catch:{ IOException -> 0x00f3, all -> 0x00fa }
        L_0x00f3:
            r11 = r0.m27451a();
            r9.f39874i = r11;
            goto L_0x0102;
        L_0x00fa:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f39874i = r11;
            throw r10;
        L_0x0102:
            r9.mo7295b();
            throw r10;
        L_0x0106:
            r10 = r4 & 8;
            if (r10 != r5) goto L_0x0112;
        L_0x010a:
            r10 = r9.f39873g;
            r10 = java.util.Collections.unmodifiableList(r10);
            r9.f39873g = r10;
        L_0x0112:
            r1.m27501b();	 Catch:{ IOException -> 0x0115, all -> 0x011c }
        L_0x0115:
            r10 = r0.m27451a();
            r9.f39874i = r10;
            goto L_0x0124;
        L_0x011c:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f39874i = r11;
            throw r10;
        L_0x0124:
            r9.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf.BuiltIns.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            BuiltIns builtIns = new BuiltIns();
            f39868h = builtIns;
            builtIns.m40251j();
        }

        public final Parser<BuiltIns> mo7112a() {
            return f39867b;
        }

        public final boolean m40257h() {
            return (this.f39869c & 2) == 2;
        }

        public final boolean m40258i() {
            return (this.f39869c & 4) == 4;
        }

        private void m40251j() {
            this.f39870d = StringTable.m40164f();
            this.f39871e = QualifiedNameTable.m40086f();
            this.f39872f = Package.m41698f();
            this.f39873g = Collections.emptyList();
        }

        public final boolean mo7303g() {
            byte b = this.f39875j;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (m40257h() && !this.f39871e.mo7303g()) {
                this.f39875j = (byte) 0;
                return false;
            } else if (!m40258i() || this.f39872f.mo7303g()) {
                int i = 0;
                while (i < this.f39873g.size()) {
                    if (((Class) this.f39873g.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f39875j = (byte) 0;
                        return false;
                    }
                }
                this.f39875j = (byte) 1;
                return true;
            } else {
                this.f39875j = (byte) 0;
                return false;
            }
        }

        public static BuiltIns m40248a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BuiltIns) f39867b.mo5862b(inputStream, extensionRegistryLite);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40235a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39868h;
        }
    }

    public static void m27798a(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.m27505a(f26188a);
        extensionRegistryLite.m27505a(f26189b);
        extensionRegistryLite.m27505a(f26190c);
        extensionRegistryLite.m27505a(f26191d);
        extensionRegistryLite.m27505a(f26192e);
        extensionRegistryLite.m27505a(f26193f);
        extensionRegistryLite.m27505a(f26194g);
        extensionRegistryLite.m27505a(f26195h);
        extensionRegistryLite.m27505a(f26196i);
        extensionRegistryLite.m27505a(f26197j);
    }
}
