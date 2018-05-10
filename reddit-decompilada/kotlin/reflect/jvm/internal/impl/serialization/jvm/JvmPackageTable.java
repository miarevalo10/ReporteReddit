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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class JvmPackageTable {

    public interface PackagePartsOrBuilder extends MessageLiteOrBuilder {
    }

    public interface PackageTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class PackageParts extends GeneratedMessageLite implements PackagePartsOrBuilder {
        public static Parser<PackageParts> f39885b = new C27911();
        private static final PackageParts f39886f;
        public LazyStringList f39887c;
        public List<Integer> f39888d;
        public LazyStringList f39889e;
        private final ByteString f39890g;
        private int f39891h;
        private Object f39892i;
        private int f39893j;
        private byte f39894k;
        private int f39895l;

        static class C27911 extends AbstractParser<PackageParts> {
            C27911() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageParts(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<PackageParts, Builder> implements PackagePartsOrBuilder {
            private int f39880b;
            private Object f39881c = "";
            private LazyStringList f39882d = LazyStringArrayList.f36132a;
            private List<Integer> f39883e = Collections.emptyList();
            private LazyStringList f39884f = LazyStringArrayList.f36132a;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40279h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40277c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40279h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40277c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40279h();
            }

            private Builder() {
            }

            private PackageParts m40280i() {
                int i = 0;
                PackageParts packageParts = new PackageParts((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39880b & 1) == 1) {
                    i = 1;
                }
                packageParts.f39892i = this.f39881c;
                if ((this.f39880b & 2) == 2) {
                    this.f39882d = this.f39882d.mo6728b();
                    this.f39880b &= -3;
                }
                packageParts.f39887c = this.f39882d;
                if ((this.f39880b & 4) == 4) {
                    this.f39883e = Collections.unmodifiableList(this.f39883e);
                    this.f39880b &= -5;
                }
                packageParts.f39888d = this.f39883e;
                if ((this.f39880b & 8) == 8) {
                    this.f39884f = this.f39884f.mo6728b();
                    this.f39880b &= -9;
                }
                packageParts.f39889e = this.f39884f;
                packageParts.f39891h = i;
                return packageParts;
            }

            public final Builder m40284a(PackageParts packageParts) {
                if (packageParts == PackageParts.m40301f()) {
                    return this;
                }
                if (packageParts.m40308h()) {
                    this.f39880b |= 1;
                    this.f39881c = packageParts.f39892i;
                }
                if (!packageParts.f39887c.isEmpty()) {
                    if (this.f39882d.isEmpty()) {
                        this.f39882d = packageParts.f39887c;
                        this.f39880b &= -3;
                    } else {
                        if ((this.f39880b & 2) != 2) {
                            this.f39882d = new LazyStringArrayList(this.f39882d);
                            this.f39880b |= 2;
                        }
                        this.f39882d.addAll(packageParts.f39887c);
                    }
                }
                if (!packageParts.f39888d.isEmpty()) {
                    if (this.f39883e.isEmpty()) {
                        this.f39883e = packageParts.f39888d;
                        this.f39880b &= -5;
                    } else {
                        if ((this.f39880b & 4) != 4) {
                            this.f39883e = new ArrayList(this.f39883e);
                            this.f39880b |= 4;
                        }
                        this.f39883e.addAll(packageParts.f39888d);
                    }
                }
                if (!packageParts.f39889e.isEmpty()) {
                    if (this.f39884f.isEmpty()) {
                        this.f39884f = packageParts.f39889e;
                        this.f39880b &= -9;
                    } else {
                        if ((this.f39880b & 8) != 8) {
                            this.f39884f = new LazyStringArrayList(this.f39884f);
                            this.f39880b |= 8;
                        }
                        this.f39884f.addAll(packageParts.f39889e);
                    }
                }
                this.f38788a = this.f38788a.m27460a(packageParts.f39890g);
                return this;
            }

            private Builder m40277c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageParts packageParts;
                PackageParts packageParts2 = null;
                try {
                    m40284a((PackageParts) PackageParts.f39885b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    packageParts = (PackageParts) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    packageParts2 = packageParts;
                }
                if (packageParts2 != null) {
                    m40284a(packageParts2);
                }
                throw codedInputStream2;
            }

            private Builder m40279h() {
                return new Builder().m40284a(m40280i());
            }

            public final boolean mo7303g() {
                return (this.f39880b & 1) == 1;
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return PackageParts.m40301f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40280i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return PackageParts.m40301f();
            }
        }

        private PackageParts(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39893j = -1;
            this.f39894k = (byte) -1;
            this.f39895l = -1;
            this.f39890g = builder.f38788a;
        }

        private PackageParts() {
            this.f39893j = -1;
            this.f39894k = (byte) -1;
            this.f39895l = -1;
            this.f39890g = ByteString.f25891b;
        }

        public static PackageParts m40301f() {
            return f39886f;
        }

        private PackageParts(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r12, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r13) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r11 = this;
            r11.<init>();
            r0 = -1;
            r11.f39893j = r0;
            r11.f39894k = r0;
            r11.f39895l = r0;
            r11.m40302j();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0018:
            r5 = 2;
            r6 = 8;
            r7 = 4;
            if (r2 != 0) goto L_0x011b;
        L_0x001e:
            r8 = r12.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == 0) goto L_0x00cb;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0024:
            r9 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r9) goto L_0x00be;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0028:
            r9 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r9) goto L_0x00a6;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x002c:
            r9 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r9) goto L_0x008a;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0030:
            r9 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r9) goto L_0x0057;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0034:
            r9 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r9) goto L_0x0040;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0038:
            r8 = r11.mo7294a(r12, r1, r13, r8);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 != 0) goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x003e:
            goto L_0x00cb;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0040:
            r8 = r12.m27490d();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r4 & 8;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r9 == r6) goto L_0x0051;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0048:
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39889e = r9;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r4 = r4 | 8;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0051:
            r9 = r11.f39889e;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.mo6727a(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0057:
            r8 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r8 = r12.m27487b(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r4 & 4;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r9 == r7) goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0063:
            r9 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r9 <= 0) goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0069:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39888d = r9;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0072:
            r9 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r9 <= 0) goto L_0x0086;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0078:
            r9 = r11.f39888d;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r10 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0072;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0086:
            r12.m27488c(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x008a:
            r8 = r4 & 4;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r8 == r7) goto L_0x0097;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x008e:
            r8 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r8.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39888d = r8;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x0097:
            r8 = r11.f39888d;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r8.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x00a6:
            r8 = r12.m27490d();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            if (r9 == r5) goto L_0x00b7;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x00ae:
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39887c = r9;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x00b7:
            r9 = r11.f39887c;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9.mo6727a(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0018;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
        L_0x00be:
            r8 = r12.m27490d();	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r11.f39891h;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r9 = r9 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39891h = r9;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            r11.f39892i = r8;	 Catch:{ InvalidProtocolBufferException -> 0x00dd, IOException -> 0x00d0 }
            goto L_0x0018;
        L_0x00cb:
            r2 = r3;
            goto L_0x0018;
        L_0x00ce:
            r12 = move-exception;
            goto L_0x00e1;
        L_0x00d0:
            r12 = move-exception;
            r13 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00ce }
            r12 = r12.getMessage();	 Catch:{ all -> 0x00ce }
            r13.<init>(r12);	 Catch:{ all -> 0x00ce }
            r13.f25930a = r11;	 Catch:{ all -> 0x00ce }
            throw r13;	 Catch:{ all -> 0x00ce }
        L_0x00dd:
            r12 = move-exception;	 Catch:{ all -> 0x00ce }
            r12.f25930a = r11;	 Catch:{ all -> 0x00ce }
            throw r12;	 Catch:{ all -> 0x00ce }
        L_0x00e1:
            r13 = r4 & 2;
            if (r13 != r5) goto L_0x00ed;
        L_0x00e5:
            r13 = r11.f39887c;
            r13 = r13.mo6728b();
            r11.f39887c = r13;
        L_0x00ed:
            r13 = r4 & 4;
            if (r13 != r7) goto L_0x00f9;
        L_0x00f1:
            r13 = r11.f39888d;
            r13 = java.util.Collections.unmodifiableList(r13);
            r11.f39888d = r13;
        L_0x00f9:
            r13 = r4 & 8;
            if (r13 != r6) goto L_0x0105;
        L_0x00fd:
            r13 = r11.f39889e;
            r13 = r13.mo6728b();
            r11.f39889e = r13;
        L_0x0105:
            r1.m27501b();	 Catch:{ IOException -> 0x0108, all -> 0x010f }
        L_0x0108:
            r13 = r0.m27451a();
            r11.f39890g = r13;
            goto L_0x0117;
        L_0x010f:
            r12 = move-exception;
            r13 = r0.m27451a();
            r11.f39890g = r13;
            throw r12;
        L_0x0117:
            r11.mo7295b();
            throw r12;
        L_0x011b:
            r12 = r4 & 2;
            if (r12 != r5) goto L_0x0127;
        L_0x011f:
            r12 = r11.f39887c;
            r12 = r12.mo6728b();
            r11.f39887c = r12;
        L_0x0127:
            r12 = r4 & 4;
            if (r12 != r7) goto L_0x0133;
        L_0x012b:
            r12 = r11.f39888d;
            r12 = java.util.Collections.unmodifiableList(r12);
            r11.f39888d = r12;
        L_0x0133:
            r12 = r4 & 8;
            if (r12 != r6) goto L_0x013f;
        L_0x0137:
            r12 = r11.f39889e;
            r12 = r12.mo6728b();
            r11.f39889e = r12;
        L_0x013f:
            r1.m27501b();	 Catch:{ IOException -> 0x0142, all -> 0x0149 }
        L_0x0142:
            r12 = r0.m27451a();
            r11.f39890g = r12;
            goto L_0x0151;
        L_0x0149:
            r12 = move-exception;
            r13 = r0.m27451a();
            r11.f39890g = r13;
            throw r12;
        L_0x0151:
            r11.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageParts.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            PackageParts packageParts = new PackageParts();
            f39886f = packageParts;
            packageParts.m40302j();
        }

        public final Parser<PackageParts> mo7112a() {
            return f39885b;
        }

        public final boolean m40308h() {
            return (this.f39891h & 1) == 1;
        }

        public final String m40309i() {
            Object obj = this.f39892i;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m27467e();
            if (byteString.mo5875f()) {
                this.f39892i = e;
            }
            return e;
        }

        private void m40302j() {
            this.f39892i = "";
            this.f39887c = LazyStringArrayList.f36132a;
            this.f39888d = Collections.emptyList();
            this.f39889e = LazyStringArrayList.f36132a;
        }

        public final boolean mo7303g() {
            byte b = this.f39894k;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (m40308h()) {
                this.f39894k = (byte) 1;
                return true;
            }
            this.f39894k = (byte) 0;
            return false;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40284a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39886f;
        }
    }

    public static final class PackageTable extends GeneratedMessageLite implements PackageTableOrBuilder {
        public static Parser<PackageTable> f39899b = new C27921();
        private static final PackageTable f39900e;
        public List<PackageParts> f39901c;
        public List<PackageParts> f39902d;
        private final ByteString f39903f;
        private byte f39904g;
        private int f39905h;

        static class C27921 extends AbstractParser<PackageTable> {
            C27921() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageTable(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<PackageTable, Builder> implements PackageTableOrBuilder {
            private int f39896b;
            private List<PackageParts> f39897c = Collections.emptyList();
            private List<PackageParts> f39898d = Collections.emptyList();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40312h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40310c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40312h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40310c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40312h();
            }

            private Builder() {
            }

            private PackageTable m40313i() {
                PackageTable packageTable = new PackageTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39896b & 1) == 1) {
                    this.f39897c = Collections.unmodifiableList(this.f39897c);
                    this.f39896b &= -2;
                }
                packageTable.f39901c = this.f39897c;
                if ((this.f39896b & 2) == 2) {
                    this.f39898d = Collections.unmodifiableList(this.f39898d);
                    this.f39896b &= -3;
                }
                packageTable.f39902d = this.f39898d;
                return packageTable;
            }

            public final Builder m40317a(PackageTable packageTable) {
                if (packageTable == PackageTable.m40330f()) {
                    return this;
                }
                if (!packageTable.f39901c.isEmpty()) {
                    if (this.f39897c.isEmpty()) {
                        this.f39897c = packageTable.f39901c;
                        this.f39896b &= -2;
                    } else {
                        if ((this.f39896b & 1) != 1) {
                            this.f39897c = new ArrayList(this.f39897c);
                            this.f39896b |= 1;
                        }
                        this.f39897c.addAll(packageTable.f39901c);
                    }
                }
                if (!packageTable.f39902d.isEmpty()) {
                    if (this.f39898d.isEmpty()) {
                        this.f39898d = packageTable.f39902d;
                        this.f39896b &= -3;
                    } else {
                        if ((this.f39896b & 2) != 2) {
                            this.f39898d = new ArrayList(this.f39898d);
                            this.f39896b |= 2;
                        }
                        this.f39898d.addAll(packageTable.f39902d);
                    }
                }
                this.f38788a = this.f38788a.m27460a(packageTable.f39903f);
                return this;
            }

            private Builder m40310c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageTable packageTable;
                PackageTable packageTable2 = null;
                try {
                    m40317a((PackageTable) PackageTable.f39899b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    packageTable = (PackageTable) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    packageTable2 = packageTable;
                }
                if (packageTable2 != null) {
                    m40317a(packageTable2);
                }
                throw codedInputStream2;
            }

            private Builder m40312h() {
                return new Builder().m40317a(m40313i());
            }

            public final boolean mo7303g() {
                int i;
                for (i = 0; i < this.f39897c.size(); i++) {
                    if (!((PackageParts) this.f39897c.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f39898d.size(); i++) {
                    if (!((PackageParts) this.f39898d.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return PackageTable.m40330f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40313i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return PackageTable.m40330f();
            }
        }

        private PackageTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39904g = (byte) -1;
            this.f39905h = -1;
            this.f39903f = builder.f38788a;
        }

        private PackageTable() {
            this.f39904g = (byte) -1;
            this.f39905h = -1;
            this.f39903f = ByteString.f25891b;
        }

        public static PackageTable m40330f() {
            return f39900e;
        }

        private PackageTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.<init>();
            r0 = -1;
            r8.f39904g = r0;
            r8.f39905h = r0;
            r8.m40331h();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 2;
            if (r2 != 0) goto L_0x00a3;
        L_0x0019:
            r6 = r9.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 == 0) goto L_0x0060;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x001f:
            r7 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 == r7) goto L_0x0047;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x0023:
            r7 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 == r7) goto L_0x002e;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x0027:
            r6 = r8.mo7294a(r9, r1, r10, r6);	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x002d:
            goto L_0x0060;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x002e:
            r6 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 == r5) goto L_0x003b;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x0032:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r8.f39902d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x003b:
            r6 = r8.f39902d;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageParts.f39885b;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r7 = r9.m27483a(r7, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x0047:
            r6 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            if (r6 == r3) goto L_0x0054;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x004b:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r8.f39901c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
        L_0x0054:
            r6 = r8.f39901c;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageParts.f39885b;	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r7 = r9.m27483a(r7, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0071, IOException -> 0x0064 }
            goto L_0x0016;
        L_0x0060:
            r2 = r3;
            goto L_0x0016;
        L_0x0062:
            r9 = move-exception;
            goto L_0x0075;
        L_0x0064:
            r9 = move-exception;
            r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0062 }
            r9 = r9.getMessage();	 Catch:{ all -> 0x0062 }
            r10.<init>(r9);	 Catch:{ all -> 0x0062 }
            r10.f25930a = r8;	 Catch:{ all -> 0x0062 }
            throw r10;	 Catch:{ all -> 0x0062 }
        L_0x0071:
            r9 = move-exception;	 Catch:{ all -> 0x0062 }
            r9.f25930a = r8;	 Catch:{ all -> 0x0062 }
            throw r9;	 Catch:{ all -> 0x0062 }
        L_0x0075:
            r10 = r4 & 1;
            if (r10 != r3) goto L_0x0081;
        L_0x0079:
            r10 = r8.f39901c;
            r10 = java.util.Collections.unmodifiableList(r10);
            r8.f39901c = r10;
        L_0x0081:
            r10 = r4 & 2;
            if (r10 != r5) goto L_0x008d;
        L_0x0085:
            r10 = r8.f39902d;
            r10 = java.util.Collections.unmodifiableList(r10);
            r8.f39902d = r10;
        L_0x008d:
            r1.m27501b();	 Catch:{ IOException -> 0x0090, all -> 0x0097 }
        L_0x0090:
            r10 = r0.m27451a();
            r8.f39903f = r10;
            goto L_0x009f;
        L_0x0097:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39903f = r10;
            throw r9;
        L_0x009f:
            r8.mo7295b();
            throw r9;
        L_0x00a3:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x00af;
        L_0x00a7:
            r9 = r8.f39901c;
            r9 = java.util.Collections.unmodifiableList(r9);
            r8.f39901c = r9;
        L_0x00af:
            r9 = r4 & 2;
            if (r9 != r5) goto L_0x00bb;
        L_0x00b3:
            r9 = r8.f39902d;
            r9 = java.util.Collections.unmodifiableList(r9);
            r8.f39902d = r9;
        L_0x00bb:
            r1.m27501b();	 Catch:{ IOException -> 0x00be, all -> 0x00c5 }
        L_0x00be:
            r9 = r0.m27451a();
            r8.f39903f = r9;
            goto L_0x00cd;
        L_0x00c5:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39903f = r10;
            throw r9;
        L_0x00cd:
            r8.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable.PackageTable.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            PackageTable packageTable = new PackageTable();
            f39900e = packageTable;
            packageTable.m40331h();
        }

        public final Parser<PackageTable> mo7112a() {
            return f39899b;
        }

        private void m40331h() {
            this.f39901c = Collections.emptyList();
            this.f39902d = Collections.emptyList();
        }

        public final boolean mo7303g() {
            byte b = this.f39904g;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < this.f39901c.size()) {
                if (((PackageParts) this.f39901c.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f39904g = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < this.f39902d.size()) {
                if (((PackageParts) this.f39902d.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f39904g = (byte) 0;
                    return false;
                }
            }
            this.f39904g = (byte) 1;
            return true;
        }

        public static PackageTable m40326a(InputStream inputStream) throws IOException {
            return (PackageTable) f39899b.mo5859a(inputStream);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40317a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39900e;
        }
    }
}
