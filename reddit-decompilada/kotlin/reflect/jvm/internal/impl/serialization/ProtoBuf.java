package kotlin.reflect.jvm.internal.impl.serialization;

import com.google.android.gms.ads.AdRequest;
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
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class ProtoBuf {

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public enum MemberKind implements EnumLite {
        DECLARATION(0),
        FAKE_OVERRIDE(1),
        DELEGATION(2),
        SYNTHESIZED(3);
        
        private static EnumLiteMap<MemberKind> f32986e;
        private final int f32988f;

        static class C25861 implements EnumLiteMap<MemberKind> {
            C25861() {
            }

            public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                return MemberKind.m33513a(i);
            }
        }

        static {
            f32986e = new C25861();
        }

        public final int mo5922a() {
            return this.f32988f;
        }

        public static MemberKind m33513a(int i) {
            switch (i) {
                case 0:
                    return DECLARATION;
                case 1:
                    return FAKE_OVERRIDE;
                case 2:
                    return DELEGATION;
                case 3:
                    return SYNTHESIZED;
                default:
                    return 0;
            }
        }

        private MemberKind(int i) {
            this.f32988f = i;
        }
    }

    public enum Modality implements EnumLite {
        FINAL(0),
        OPEN(1),
        ABSTRACT(2),
        SEALED(3);
        
        private static EnumLiteMap<Modality> f32993e;
        private final int f32995f;

        static class C25871 implements EnumLiteMap<Modality> {
            C25871() {
            }

            public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                return Modality.m33516a(i);
            }
        }

        static {
            f32993e = new C25871();
        }

        public final int mo5922a() {
            return this.f32995f;
        }

        public static Modality m33516a(int i) {
            switch (i) {
                case 0:
                    return FINAL;
                case 1:
                    return OPEN;
                case 2:
                    return ABSTRACT;
                case 3:
                    return SEALED;
                default:
                    return 0;
            }
        }

        private Modality(int i) {
            this.f32995f = i;
        }
    }

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface SinceKotlinInfoOrBuilder extends MessageLiteOrBuilder {
    }

    public interface SinceKotlinInfoTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public enum Visibility implements EnumLite {
        INTERNAL(0),
        PRIVATE(1),
        PROTECTED(2),
        PUBLIC(3),
        PRIVATE_TO_THIS(4),
        LOCAL(5);
        
        private static EnumLiteMap<Visibility> f33027g;
        private final int f33029h;

        static class C25921 implements EnumLiteMap<Visibility> {
            C25921() {
            }

            public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                return Visibility.m33531a(i);
            }
        }

        static {
            f33027g = new C25921();
        }

        public final int mo5922a() {
            return this.f33029h;
        }

        public static Visibility m33531a(int i) {
            switch (i) {
                case 0:
                    return INTERNAL;
                case 1:
                    return PRIVATE;
                case 2:
                    return PROTECTED;
                case 3:
                    return PUBLIC;
                case 4:
                    return PRIVATE_TO_THIS;
                case 5:
                    return LOCAL;
                default:
                    return 0;
            }
        }

        private Visibility(int i) {
            this.f33029h = i;
        }
    }

    public interface ClassOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface ConstructorOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface EnumEntryOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface FunctionOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface PropertyOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface TypeAliasOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface TypeParameterOrBuilder extends ExtendableMessageOrBuilder {
    }

    public interface ValueParameterOrBuilder extends ExtendableMessageOrBuilder {
    }

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> f39776b = new C27691();
        private static final Annotation f39777e;
        public int f39778c;
        public List<Argument> f39779d;
        private final ByteString f39780f;
        private int f39781g;
        private byte f39782h;
        private int f39783i;

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        static class C27691 extends AbstractParser<Annotation> {
            C27691() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.1.<init>():void");
            }

            public final /* synthetic */ java.lang.Object mo6731a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation;
                r1 = 0;
                r0.<init>(r3, r4, r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.1.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
            }
        }

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> f39765b = new C27701();
            private static final Argument f39766e;
            public int f39767c;
            public Value f39768d;
            private final ByteString f39769f;
            private int f39770g;
            private byte f39771h;
            private int f39772i;

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            static class C27701 extends AbstractParser<Argument> {
                C27701() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.1.<init>():void");
                }

                public final /* synthetic */ java.lang.Object mo6731a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument;
                    r1 = 0;
                    r0.<init>(r3, r4, r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.1.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
                }
            }

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int f39737b;
                private int f39738c;
                private Value f39739d = Value.m39990f();

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m39951h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.a():kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r1 = r0.m39949c(r1, r2);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m39951h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.b():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r1 = r0.m39949c(r1, r2);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ java.lang.Object clone() throws java.lang.CloneNotSupportedException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m39951h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.clone():java.lang.Object");
                }

                private Builder() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r1.<init>();
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                    r1.f39739d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.<init>():void");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument m39952i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument;
                    r1 = 0;
                    r0.<init>(r5, r1);
                    r2 = r5.f39737b;
                    r3 = r2 & 1;
                    r4 = 1;
                    if (r3 != r4) goto L_0x000e;
                L_0x000d:
                    r1 = r4;
                L_0x000e:
                    r3 = r5.f39738c;
                    r0.f39767c = r3;
                    r3 = 2;
                    r2 = r2 & r3;
                    if (r2 != r3) goto L_0x0019;
                L_0x0017:
                    r1 = r1 | 2;
                L_0x0019:
                    r2 = r5.f39739d;
                    r0.f39768d = r2;
                    r0.f39770g = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.i():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument");
                }

                public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder m39956a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument r5) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.m40002f();
                    if (r5 != r0) goto L_0x0007;
                L_0x0006:
                    return r4;
                L_0x0007:
                    r0 = r5.m40009h();
                    if (r0 == 0) goto L_0x0017;
                L_0x000d:
                    r0 = r5.f39767c;
                    r1 = r4.f39737b;
                    r1 = r1 | 1;
                    r4.f39737b = r1;
                    r4.f39738c = r0;
                L_0x0017:
                    r0 = r5.m40010i();
                    if (r0 == 0) goto L_0x0045;
                L_0x001d:
                    r0 = r5.f39768d;
                    r1 = r4.f39737b;
                    r2 = 2;
                    r1 = r1 & r2;
                    if (r1 != r2) goto L_0x003e;
                L_0x0025:
                    r1 = r4.f39739d;
                    r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                    if (r1 == r3) goto L_0x003e;
                L_0x002d:
                    r1 = r4.f39739d;
                    r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39982a(r1);
                    r0 = r1.m39969a(r0);
                    r0 = r0.m39974e();
                    r4.f39739d = r0;
                    goto L_0x0040;
                L_0x003e:
                    r4.f39739d = r0;
                L_0x0040:
                    r0 = r4.f39737b;
                    r0 = r0 | r2;
                    r4.f39737b = r0;
                L_0x0045:
                    r0 = r4.f38788a;
                    r5 = r5.f39769f;
                    r5 = r0.m27460a(r5);
                    r4.f38788a = r5;
                    return r4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Builder");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder m39949c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.f39765b;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r3 = r1.mo6731a(r3, r4);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument) r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r2.m39956a(r3);
                    return r2;
                L_0x000d:
                    r3 = move-exception;
                    goto L_0x0017;
                L_0x000f:
                    r3 = move-exception;
                    r4 = r3.f25930a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument) r4;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    throw r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                L_0x0015:
                    r3 = move-exception;
                    r0 = r4;
                L_0x0017:
                    if (r0 == 0) goto L_0x001c;
                L_0x0019:
                    r2.m39956a(r0);
                L_0x001c:
                    throw r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Builder");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder m39951h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Builder;
                    r0.<init>();
                    r1 = r2.m39952i();
                    r0 = r0.m39956a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.h():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Builder");
                }

                public final boolean mo7303g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f39737b;
                    r1 = 1;
                    r0 = r0 & r1;
                    r2 = 0;
                    if (r0 != r1) goto L_0x0009;
                L_0x0007:
                    r0 = r1;
                    goto L_0x000a;
                L_0x0009:
                    r0 = r2;
                L_0x000a:
                    if (r0 != 0) goto L_0x000d;
                L_0x000c:
                    return r2;
                L_0x000d:
                    r0 = r4.f39737b;
                    r3 = 2;
                    r0 = r0 & r3;
                    if (r0 != r3) goto L_0x0015;
                L_0x0013:
                    r0 = r1;
                    goto L_0x0016;
                L_0x0015:
                    r0 = r2;
                L_0x0016:
                    if (r0 != 0) goto L_0x0019;
                L_0x0018:
                    return r2;
                L_0x0019:
                    r0 = r4.f39739d;
                    r0 = r0.mo7303g();
                    if (r0 != 0) goto L_0x0022;
                L_0x0021:
                    return r2;
                L_0x0022:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.g():boolean");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite mo7301c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.m40002f();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.c():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7302f() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.m39952i();
                    r1 = r0.mo7303g();
                    if (r1 != 0) goto L_0x0010;
                L_0x000a:
                    r0 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
                    r0.<init>();
                    throw r0;
                L_0x0010:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.f():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.m40002f();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                }
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> f39750b = new C27711();
                private static final Value f39751m;
                int f39752c;
                public Type f39753d;
                public long f39754e;
                public float f39755f;
                public double f39756g;
                public int f39757h;
                public int f39758i;
                public int f39759j;
                public Annotation f39760k;
                public List<Value> f39761l;
                private final ByteString f39762n;
                private byte f39763o;
                private int f39764p;

                public enum Type implements EnumLite {
                    BYTE(0),
                    CHAR(1),
                    SHORT(2),
                    INT(3),
                    LONG(4),
                    FLOAT(5),
                    DOUBLE(6),
                    BOOLEAN(7),
                    STRING(8),
                    CLASS(9),
                    ENUM(10),
                    ANNOTATION(11),
                    ARRAY(12);
                    
                    private static EnumLiteMap<Type> f32969n;
                    private final int f32971o;

                    static class C25841 implements EnumLiteMap<Type> {
                        C25841() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.1.<init>():void");
                        }

                        public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite mo5921a(int r1) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.m33507a(r1);
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.1.a(int):kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite");
                        }
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "BYTE";
                        r2 = 0;
                        r0.<init>(r1, r2, r2);
                        BYTE = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "CHAR";
                        r3 = 1;
                        r0.<init>(r1, r3, r3);
                        CHAR = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "SHORT";
                        r4 = 2;
                        r0.<init>(r1, r4, r4);
                        SHORT = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "INT";
                        r5 = 3;
                        r0.<init>(r1, r5, r5);
                        INT = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "LONG";
                        r6 = 4;
                        r0.<init>(r1, r6, r6);
                        LONG = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "FLOAT";
                        r7 = 5;
                        r0.<init>(r1, r7, r7);
                        FLOAT = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "DOUBLE";
                        r8 = 6;
                        r0.<init>(r1, r8, r8);
                        DOUBLE = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "BOOLEAN";
                        r9 = 7;
                        r0.<init>(r1, r9, r9);
                        BOOLEAN = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "STRING";
                        r10 = 8;
                        r0.<init>(r1, r10, r10);
                        STRING = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "CLASS";
                        r11 = 9;
                        r0.<init>(r1, r11, r11);
                        CLASS = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "ENUM";
                        r12 = 10;
                        r0.<init>(r1, r12, r12);
                        ENUM = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "ANNOTATION";
                        r13 = 11;
                        r0.<init>(r1, r13, r13);
                        ANNOTATION = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
                        r1 = "ARRAY";
                        r14 = 12;
                        r0.<init>(r1, r14, r14);
                        ARRAY = r0;
                        r0 = 13;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type[r0];
                        r1 = BYTE;
                        r0[r2] = r1;
                        r1 = CHAR;
                        r0[r3] = r1;
                        r1 = SHORT;
                        r0[r4] = r1;
                        r1 = INT;
                        r0[r5] = r1;
                        r1 = LONG;
                        r0[r6] = r1;
                        r1 = FLOAT;
                        r0[r7] = r1;
                        r1 = DOUBLE;
                        r0[r8] = r1;
                        r1 = BOOLEAN;
                        r0[r9] = r1;
                        r1 = STRING;
                        r0[r10] = r1;
                        r1 = CLASS;
                        r0[r11] = r1;
                        r1 = ENUM;
                        r0[r12] = r1;
                        r1 = ANNOTATION;
                        r0[r13] = r1;
                        r1 = ARRAY;
                        r0[r14] = r1;
                        f32970p = r0;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type$1;
                        r0.<init>();
                        f32969n = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.<clinit>():void");
                    }

                    public final int mo5922a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.f32971o;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.a():int");
                    }

                    public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type m33507a(int r0) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        switch(r0) {
                            case 0: goto L_0x0029;
                            case 1: goto L_0x0026;
                            case 2: goto L_0x0023;
                            case 3: goto L_0x0020;
                            case 4: goto L_0x001d;
                            case 5: goto L_0x001a;
                            case 6: goto L_0x0017;
                            case 7: goto L_0x0014;
                            case 8: goto L_0x0011;
                            case 9: goto L_0x000e;
                            case 10: goto L_0x000b;
                            case 11: goto L_0x0008;
                            case 12: goto L_0x0005;
                            default: goto L_0x0003;
                        };
                    L_0x0003:
                        r0 = 0;
                        return r0;
                    L_0x0005:
                        r0 = ARRAY;
                        return r0;
                    L_0x0008:
                        r0 = ANNOTATION;
                        return r0;
                    L_0x000b:
                        r0 = ENUM;
                        return r0;
                    L_0x000e:
                        r0 = CLASS;
                        return r0;
                    L_0x0011:
                        r0 = STRING;
                        return r0;
                    L_0x0014:
                        r0 = BOOLEAN;
                        return r0;
                    L_0x0017:
                        r0 = DOUBLE;
                        return r0;
                    L_0x001a:
                        r0 = FLOAT;
                        return r0;
                    L_0x001d:
                        r0 = LONG;
                        return r0;
                    L_0x0020:
                        r0 = INT;
                        return r0;
                    L_0x0023:
                        r0 = SHORT;
                        return r0;
                    L_0x0026:
                        r0 = CHAR;
                        return r0;
                    L_0x0029:
                        r0 = BYTE;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.a(int):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type");
                    }

                    private Type(int r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>(r1, r2);
                        r0.f32971o = r3;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.<init>(java.lang.String, int, int):void");
                    }
                }

                static class C27711 extends AbstractParser<Value> {
                    C27711() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.1.<init>():void");
                    }

                    public final /* synthetic */ java.lang.Object mo6731a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value;
                        r1 = 0;
                        r0.<init>(r3, r4, r1);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.1.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
                    }
                }

                public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private int f39740b;
                    private Type f39741c = Type.BYTE;
                    private long f39742d;
                    private float f39743e;
                    private double f39744f;
                    private int f39745g;
                    private int f39746h;
                    private int f39747i;
                    private Annotation f39748j = Annotation.m40031f();
                    private List<Value> f39749k = Collections.emptyList();

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m39965i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.a():kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r1 = r0.m39963c(r1, r2);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m39965i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.b():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r1 = r0.m39963c(r1, r2);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
                    }

                    public final /* synthetic */ java.lang.Object clone() throws java.lang.CloneNotSupportedException {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m39965i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.clone():java.lang.Object");
                    }

                    private Builder() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r1.<init>();
                        r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.BYTE;
                        r1.f39741c = r0;
                        r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                        r1.f39748j = r0;
                        r0 = java.util.Collections.emptyList();
                        r1.f39749k = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.<init>():void");
                    }

                    public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value m39974e() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r5 = this;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value;
                        r1 = 0;
                        r0.<init>(r5, r1);
                        r2 = r5.f39740b;
                        r3 = r2 & 1;
                        r4 = 1;
                        if (r3 != r4) goto L_0x000e;
                    L_0x000d:
                        r1 = r4;
                    L_0x000e:
                        r3 = r5.f39741c;
                        r0.f39753d = r3;
                        r3 = r2 & 2;
                        r4 = 2;
                        if (r3 != r4) goto L_0x001a;
                    L_0x0018:
                        r1 = r1 | 2;
                    L_0x001a:
                        r3 = r5.f39742d;
                        r0.f39754e = r3;
                        r3 = r2 & 4;
                        r4 = 4;
                        if (r3 != r4) goto L_0x0026;
                    L_0x0024:
                        r1 = r1 | 4;
                    L_0x0026:
                        r3 = r5.f39743e;
                        r0.f39755f = r3;
                        r3 = r2 & 8;
                        r4 = 8;
                        if (r3 != r4) goto L_0x0033;
                    L_0x0031:
                        r1 = r1 | 8;
                    L_0x0033:
                        r3 = r5.f39744f;
                        r0.f39756g = r3;
                        r3 = r2 & 16;
                        r4 = 16;
                        if (r3 != r4) goto L_0x0040;
                    L_0x003e:
                        r1 = r1 | 16;
                    L_0x0040:
                        r3 = r5.f39745g;
                        r0.f39757h = r3;
                        r3 = r2 & 32;
                        r4 = 32;
                        if (r3 != r4) goto L_0x004d;
                    L_0x004b:
                        r1 = r1 | 32;
                    L_0x004d:
                        r3 = r5.f39746h;
                        r0.f39758i = r3;
                        r3 = r2 & 64;
                        r4 = 64;
                        if (r3 != r4) goto L_0x005a;
                    L_0x0058:
                        r1 = r1 | 64;
                    L_0x005a:
                        r3 = r5.f39747i;
                        r0.f39759j = r3;
                        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r2 = r2 & r3;
                        if (r2 != r3) goto L_0x0066;
                    L_0x0064:
                        r1 = r1 | 128;
                    L_0x0066:
                        r2 = r5.f39748j;
                        r0.f39760k = r2;
                        r2 = r5.f39740b;
                        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                        r2 = r2 & r3;
                        if (r2 != r3) goto L_0x0080;
                    L_0x0072:
                        r2 = r5.f39749k;
                        r2 = java.util.Collections.unmodifiableList(r2);
                        r5.f39749k = r2;
                        r2 = r5.f39740b;
                        r2 = r2 & -257;
                        r5.f39740b = r2;
                    L_0x0080:
                        r2 = r5.f39749k;
                        r0.f39761l = r2;
                        r0.f39752c = r1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.e():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value");
                    }

                    public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder m39969a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value r7) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r6 = this;
                        r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                        if (r7 != r0) goto L_0x0007;
                    L_0x0006:
                        return r6;
                    L_0x0007:
                        r0 = r7.f39752c;
                        r1 = 1;
                        r0 = r0 & r1;
                        r2 = 0;
                        if (r0 != r1) goto L_0x0010;
                    L_0x000e:
                        r0 = r1;
                        goto L_0x0011;
                    L_0x0010:
                        r0 = r2;
                    L_0x0011:
                        if (r0 == 0) goto L_0x0024;
                    L_0x0013:
                        r0 = r7.f39753d;
                        if (r0 != 0) goto L_0x001d;
                    L_0x0017:
                        r7 = new java.lang.NullPointerException;
                        r7.<init>();
                        throw r7;
                    L_0x001d:
                        r3 = r6.f39740b;
                        r3 = r3 | r1;
                        r6.f39740b = r3;
                        r6.f39741c = r0;
                    L_0x0024:
                        r0 = r7.f39752c;
                        r3 = 2;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x002c;
                    L_0x002a:
                        r0 = r1;
                        goto L_0x002d;
                    L_0x002c:
                        r0 = r2;
                    L_0x002d:
                        if (r0 == 0) goto L_0x0038;
                    L_0x002f:
                        r4 = r7.f39754e;
                        r0 = r6.f39740b;
                        r0 = r0 | r3;
                        r6.f39740b = r0;
                        r6.f39742d = r4;
                    L_0x0038:
                        r0 = r7.f39752c;
                        r3 = 4;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x0040;
                    L_0x003e:
                        r0 = r1;
                        goto L_0x0041;
                    L_0x0040:
                        r0 = r2;
                    L_0x0041:
                        if (r0 == 0) goto L_0x004c;
                    L_0x0043:
                        r0 = r7.f39755f;
                        r4 = r6.f39740b;
                        r3 = r3 | r4;
                        r6.f39740b = r3;
                        r6.f39743e = r0;
                    L_0x004c:
                        r0 = r7.f39752c;
                        r3 = 8;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x0055;
                    L_0x0053:
                        r0 = r1;
                        goto L_0x0056;
                    L_0x0055:
                        r0 = r2;
                    L_0x0056:
                        if (r0 == 0) goto L_0x0061;
                    L_0x0058:
                        r4 = r7.f39756g;
                        r0 = r6.f39740b;
                        r0 = r0 | r3;
                        r6.f39740b = r0;
                        r6.f39744f = r4;
                    L_0x0061:
                        r0 = r7.f39752c;
                        r3 = 16;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x006a;
                    L_0x0068:
                        r0 = r1;
                        goto L_0x006b;
                    L_0x006a:
                        r0 = r2;
                    L_0x006b:
                        if (r0 == 0) goto L_0x0076;
                    L_0x006d:
                        r0 = r7.f39757h;
                        r4 = r6.f39740b;
                        r3 = r3 | r4;
                        r6.f39740b = r3;
                        r6.f39745g = r0;
                    L_0x0076:
                        r0 = r7.f39752c;
                        r3 = 32;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x007f;
                    L_0x007d:
                        r0 = r1;
                        goto L_0x0080;
                    L_0x007f:
                        r0 = r2;
                    L_0x0080:
                        if (r0 == 0) goto L_0x008b;
                    L_0x0082:
                        r0 = r7.f39758i;
                        r4 = r6.f39740b;
                        r3 = r3 | r4;
                        r6.f39740b = r3;
                        r6.f39746h = r0;
                    L_0x008b:
                        r0 = r7.f39752c;
                        r3 = 64;
                        r0 = r0 & r3;
                        if (r0 != r3) goto L_0x0093;
                    L_0x0092:
                        goto L_0x0094;
                    L_0x0093:
                        r1 = r2;
                    L_0x0094:
                        if (r1 == 0) goto L_0x009f;
                    L_0x0096:
                        r0 = r7.f39759j;
                        r1 = r6.f39740b;
                        r1 = r1 | r3;
                        r6.f39740b = r1;
                        r6.f39747i = r0;
                    L_0x009f:
                        r0 = r7.m39997h();
                        if (r0 == 0) goto L_0x00ce;
                    L_0x00a5:
                        r0 = r7.f39760k;
                        r1 = r6.f39740b;
                        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r1 = r1 & r2;
                        if (r1 != r2) goto L_0x00c7;
                    L_0x00ae:
                        r1 = r6.f39748j;
                        r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                        if (r1 == r3) goto L_0x00c7;
                    L_0x00b6:
                        r1 = r6.f39748j;
                        r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40027a(r1);
                        r0 = r1.m40017a(r0);
                        r0 = r0.m40022e();
                        r6.f39748j = r0;
                        goto L_0x00c9;
                    L_0x00c7:
                        r6.f39748j = r0;
                    L_0x00c9:
                        r0 = r6.f39740b;
                        r0 = r0 | r2;
                        r6.f39740b = r0;
                    L_0x00ce:
                        r0 = r7.f39761l;
                        r0 = r0.isEmpty();
                        if (r0 != 0) goto L_0x010b;
                    L_0x00d8:
                        r0 = r6.f39749k;
                        r0 = r0.isEmpty();
                        if (r0 == 0) goto L_0x00ed;
                    L_0x00e0:
                        r0 = r7.f39761l;
                        r6.f39749k = r0;
                        r0 = r6.f39740b;
                        r0 = r0 & -257;
                        r6.f39740b = r0;
                        goto L_0x010b;
                    L_0x00ed:
                        r0 = r6.f39740b;
                        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                        r0 = r0 & r1;
                        if (r0 == r1) goto L_0x0102;
                    L_0x00f4:
                        r0 = new java.util.ArrayList;
                        r2 = r6.f39749k;
                        r0.<init>(r2);
                        r6.f39749k = r0;
                        r0 = r6.f39740b;
                        r0 = r0 | r1;
                        r6.f39740b = r0;
                    L_0x0102:
                        r0 = r6.f39749k;
                        r1 = r7.f39761l;
                        r0.addAll(r1);
                    L_0x010b:
                        r0 = r6.f38788a;
                        r7 = r7.f39762n;
                        r7 = r0.m27460a(r7);
                        r6.f38788a = r7;
                        return r6;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Builder");
                    }

                    private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder m39963c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = 0;
                        r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.f39750b;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                        r3 = r1.mo6731a(r3, r4);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                        r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                        r2.m39969a(r3);
                        return r2;
                    L_0x000d:
                        r3 = move-exception;
                        goto L_0x0017;
                    L_0x000f:
                        r3 = move-exception;
                        r4 = r3.f25930a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                        r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r4;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                        throw r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    L_0x0015:
                        r3 = move-exception;
                        r0 = r4;
                    L_0x0017:
                        if (r0 == 0) goto L_0x001c;
                    L_0x0019:
                        r2.m39969a(r0);
                    L_0x001c:
                        throw r3;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Builder");
                    }

                    private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder m39965i() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Builder;
                        r0.<init>();
                        r1 = r2.m39974e();
                        r0 = r0.m39969a(r1);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.i():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Builder");
                    }

                    public final boolean mo7303g() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r4 = this;
                        r0 = r4.f39740b;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0 = r0 & r1;
                        r2 = 1;
                        r3 = 0;
                        if (r0 != r1) goto L_0x000b;
                    L_0x0009:
                        r0 = r2;
                        goto L_0x000c;
                    L_0x000b:
                        r0 = r3;
                    L_0x000c:
                        if (r0 == 0) goto L_0x0017;
                    L_0x000e:
                        r0 = r4.f39748j;
                        r0 = r0.mo7303g();
                        if (r0 != 0) goto L_0x0017;
                    L_0x0016:
                        return r3;
                    L_0x0017:
                        r0 = r3;
                    L_0x0018:
                        r1 = r4.f39749k;
                        r1 = r1.size();
                        if (r0 >= r1) goto L_0x0032;
                    L_0x0020:
                        r1 = r4.f39749k;
                        r1 = r1.get(r0);
                        r1 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r1;
                        r1 = r1.mo7303g();
                        if (r1 != 0) goto L_0x002f;
                    L_0x002e:
                        return r3;
                    L_0x002f:
                        r0 = r0 + 1;
                        goto L_0x0018;
                    L_0x0032:
                        return r2;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.g():boolean");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite mo7301c() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.c():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7302f() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.m39974e();
                        r1 = r0.mo7303g();
                        if (r1 != 0) goto L_0x0010;
                    L_0x000a:
                        r0 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
                        r0.<init>();
                        throw r0;
                    L_0x0010:
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.f():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                    }

                    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                    }
                }

                private Value(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.<init>(r0);
                    r0 = -1;
                    r1.f39763o = r0;
                    r1.f39764p = r0;
                    r2 = r2.f38788a;
                    r1.f39762n = r2;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.<init>(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder):void");
                }

                private Value() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r1.<init>();
                    r0 = -1;
                    r1.f39763o = r0;
                    r1.f39764p = r0;
                    r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.f25891b;
                    r1.f39762n = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.<init>():void");
                }

                public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value m39990f() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = f39751m;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.f():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value");
                }

                private Value(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r10 = this;
                    r10.<init>();
                    r0 = -1;
                    r10.f39763o = r0;
                    r10.f39764p = r0;
                    r10.m39991i();
                    r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
                    r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
                    r2 = 0;
                    r3 = 1;
                    r4 = r2;
                L_0x0016:
                    r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                    if (r2 != 0) goto L_0x013d;
                L_0x001a:
                    r6 = r11.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == 0) goto L_0x0105;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0020:
                    r7 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x00ea;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0024:
                    r8 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r8) goto L_0x00dc;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0028:
                    r9 = 29;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r9) goto L_0x00ca;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x002c:
                    r9 = 33;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r9) goto L_0x00b9;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0030:
                    r7 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x00ac;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0034:
                    r7 = 48;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x009e;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0038:
                    r7 = 56;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x0090;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x003c:
                    r7 = 66;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x0065;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0040:
                    r7 = 74;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r7) goto L_0x004c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0044:
                    r6 = r10.mo7294a(r11, r1, r12, r6);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x004a:
                    goto L_0x0105;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x004c:
                    r6 = r4 & 256;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == r5) goto L_0x0059;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0050:
                    r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39761l = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r4 = r4 | 256;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0059:
                    r6 = r10.f39761l;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = f39750b;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0065:
                    r6 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = r7 & r8;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r7 != r8) goto L_0x0073;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x006d:
                    r6 = r10.f39760k;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6.m40040j();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0073:
                    r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.f39776b;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation) r7;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39760k = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r6 == 0) goto L_0x008a;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x007f:
                    r7 = r10.f39760k;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6.m40017a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6.m40022e();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39760k = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x008a:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x0090:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39759j = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x009e:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39758i = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00ac:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39757h = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00b9:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27496i();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = java.lang.Double.longBitsToDouble(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39756g = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00ca:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27495h();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = java.lang.Float.intBitsToFloat(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39755f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00dc:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r11.m27492e();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39754e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00ea:
                    r7 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.m33507a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    if (r8 != 0) goto L_0x00fc;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00f4:
                    r1.m27502b(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r1.m27502b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                L_0x00fc:
                    r6 = r10.f39752c;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r6 = r6 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39752c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    r10.f39753d = r8;	 Catch:{ InvalidProtocolBufferException -> 0x0117, IOException -> 0x010a }
                    goto L_0x0016;
                L_0x0105:
                    r2 = r3;
                    goto L_0x0016;
                L_0x0108:
                    r11 = move-exception;
                    goto L_0x011b;
                L_0x010a:
                    r11 = move-exception;
                    r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0108 }
                    r11 = r11.getMessage();	 Catch:{ all -> 0x0108 }
                    r12.<init>(r11);	 Catch:{ all -> 0x0108 }
                    r12.f25930a = r10;	 Catch:{ all -> 0x0108 }
                    throw r12;	 Catch:{ all -> 0x0108 }
                L_0x0117:
                    r11 = move-exception;	 Catch:{ all -> 0x0108 }
                    r11.f25930a = r10;	 Catch:{ all -> 0x0108 }
                    throw r11;	 Catch:{ all -> 0x0108 }
                L_0x011b:
                    r12 = r4 & 256;
                    if (r12 != r5) goto L_0x0127;
                L_0x011f:
                    r12 = r10.f39761l;
                    r12 = java.util.Collections.unmodifiableList(r12);
                    r10.f39761l = r12;
                L_0x0127:
                    r1.m27501b();	 Catch:{ IOException -> 0x012a, all -> 0x0131 }
                L_0x012a:
                    r12 = r0.m27451a();
                    r10.f39762n = r12;
                    goto L_0x0139;
                L_0x0131:
                    r11 = move-exception;
                    r12 = r0.m27451a();
                    r10.f39762n = r12;
                    throw r11;
                L_0x0139:
                    r10.mo7295b();
                    throw r11;
                L_0x013d:
                    r11 = r4 & 256;
                    if (r11 != r5) goto L_0x0149;
                L_0x0141:
                    r11 = r10.f39761l;
                    r11 = java.util.Collections.unmodifiableList(r11);
                    r10.f39761l = r11;
                L_0x0149:
                    r1.m27501b();	 Catch:{ IOException -> 0x014c, all -> 0x0153 }
                L_0x014c:
                    r11 = r0.m27451a();
                    r10.f39762n = r11;
                    goto L_0x015b;
                L_0x0153:
                    r11 = move-exception;
                    r12 = r0.m27451a();
                    r10.f39762n = r12;
                    throw r11;
                L_0x015b:
                    r10.mo7295b();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
                }

                static {
                    Value value = new Value();
                    f39751m = value;
                    value.m39991i();
                }

                public final kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value> mo7112a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f39750b;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.a():kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value>");
                }

                public final boolean m39997h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f39752c;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0 = r0 & r1;
                    if (r0 != r1) goto L_0x0009;
                L_0x0007:
                    r0 = 1;
                    return r0;
                L_0x0009:
                    r0 = 0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.h():boolean");
                }

                private void m39991i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type.BYTE;
                    r2.f39753d = r0;
                    r0 = 0;
                    r2.f39754e = r0;
                    r0 = 0;
                    r2.f39755f = r0;
                    r0 = 0;
                    r2.f39756g = r0;
                    r0 = 0;
                    r2.f39757h = r0;
                    r2.f39758i = r0;
                    r2.f39759j = r0;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                    r2.f39760k = r0;
                    r0 = java.util.Collections.emptyList();
                    r2.f39761l = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.i():void");
                }

                public final boolean mo7303g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f39763o;
                    r1 = 1;
                    if (r0 != r1) goto L_0x0006;
                L_0x0005:
                    return r1;
                L_0x0006:
                    r2 = 0;
                    if (r0 != 0) goto L_0x000a;
                L_0x0009:
                    return r2;
                L_0x000a:
                    r0 = r4.m39997h();
                    if (r0 == 0) goto L_0x001b;
                L_0x0010:
                    r0 = r4.f39760k;
                    r0 = r0.mo7303g();
                    if (r0 != 0) goto L_0x001b;
                L_0x0018:
                    r4.f39763o = r2;
                    return r2;
                L_0x001b:
                    r0 = r2;
                L_0x001c:
                    r3 = r4.f39761l;
                    r3 = r3.size();
                    if (r0 >= r3) goto L_0x0038;
                L_0x0024:
                    r3 = r4.f39761l;
                    r3 = r3.get(r0);
                    r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r3;
                    r3 = r3.mo7303g();
                    if (r3 != 0) goto L_0x0035;
                L_0x0032:
                    r4.f39763o = r2;
                    return r2;
                L_0x0035:
                    r0 = r0 + 1;
                    goto L_0x001c;
                L_0x0038:
                    r4.f39763o = r1;
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.g():boolean");
                }

                public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder m39982a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder();
                    r1 = r0.m39969a(r1);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder();
                    r0 = r0.m39969a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.e():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Builder();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.c():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
                }

                public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f39751m;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                }
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.<init>(r0);
                r0 = -1;
                r1.f39771h = r0;
                r1.f39772i = r0;
                r2 = r2.f38788a;
                r1.f39769f = r2;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.<init>(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder):void");
            }

            private Argument() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = -1;
                r1.f39771h = r0;
                r1.f39772i = r0;
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.f25891b;
                r1.f39769f = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.<init>():void");
            }

            public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument m40002f() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = f39766e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.f():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument");
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r7.<init>();
                r0 = -1;
                r7.f39771h = r0;
                r7.f39772i = r0;
                r7.m40003j();
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
                r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
                r2 = 0;
                r3 = 1;
            L_0x0015:
                if (r2 != 0) goto L_0x008d;
            L_0x0017:
                r4 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r4 == 0) goto L_0x0062;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x001d:
                r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r4 == r5) goto L_0x0056;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0021:
                r5 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r4 == r5) goto L_0x002c;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0025:
                r4 = r7.mo7294a(r8, r1, r9, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x002b:
                goto L_0x0062;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x002c:
                r4 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r5 = r7.f39770g;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r6 = 2;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r5 = r5 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r5 != r6) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0033:
                r4 = r7.f39768d;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39982a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0039:
                r5 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.f39750b;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r5 = r8.m27483a(r5, r9);	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r5 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r5;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r7.f39768d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                if (r4 == 0) goto L_0x0050;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0045:
                r5 = r7.f39768d;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4.m39969a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4 = r4.m39974e();	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r7.f39768d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0050:
                r4 = r7.f39770g;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4 = r4 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r7.f39770g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
            L_0x0056:
                r4 = r7.f39770g;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r7.f39770g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r4 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                r7.f39767c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0073, IOException -> 0x0066 }
                goto L_0x0015;
            L_0x0062:
                r2 = r3;
                goto L_0x0015;
            L_0x0064:
                r8 = move-exception;
                goto L_0x0077;
            L_0x0066:
                r8 = move-exception;
                r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0064 }
                r8 = r8.getMessage();	 Catch:{ all -> 0x0064 }
                r9.<init>(r8);	 Catch:{ all -> 0x0064 }
                r9.f25930a = r7;	 Catch:{ all -> 0x0064 }
                throw r9;	 Catch:{ all -> 0x0064 }
            L_0x0073:
                r8 = move-exception;	 Catch:{ all -> 0x0064 }
                r8.f25930a = r7;	 Catch:{ all -> 0x0064 }
                throw r8;	 Catch:{ all -> 0x0064 }
            L_0x0077:
                r1.m27501b();	 Catch:{ IOException -> 0x007a, all -> 0x0081 }
            L_0x007a:
                r9 = r0.m27451a();
                r7.f39769f = r9;
                goto L_0x0089;
            L_0x0081:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39769f = r9;
                throw r8;
            L_0x0089:
                r7.mo7295b();
                throw r8;
            L_0x008d:
                r1.m27501b();	 Catch:{ IOException -> 0x0090, all -> 0x0097 }
            L_0x0090:
                r8 = r0.m27451a();
                r7.f39769f = r8;
                goto L_0x009f;
            L_0x0097:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39769f = r9;
                throw r8;
            L_0x009f:
                r7.mo7295b();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
            }

            static {
                Argument argument = new Argument();
                f39766e = argument;
                argument.m40003j();
            }

            public final kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument> mo7112a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f39765b;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.a():kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument>");
            }

            public final boolean m40009h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f39770g;
                r1 = 1;
                r0 = r0 & r1;
                if (r0 != r1) goto L_0x0007;
            L_0x0006:
                return r1;
            L_0x0007:
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.h():boolean");
            }

            public final boolean m40010i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f39770g;
                r1 = 2;
                r0 = r0 & r1;
                if (r0 != r1) goto L_0x0008;
            L_0x0006:
                r0 = 1;
                return r0;
            L_0x0008:
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.i():boolean");
            }

            private void m40003j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.f39767c = r0;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.m39990f();
                r1.f39768d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.j():void");
            }

            public final boolean mo7303g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f39771h;
                r1 = 1;
                if (r0 != r1) goto L_0x0006;
            L_0x0005:
                return r1;
            L_0x0006:
                r2 = 0;
                if (r0 != 0) goto L_0x000a;
            L_0x0009:
                return r2;
            L_0x000a:
                r0 = r3.m40009h();
                if (r0 != 0) goto L_0x0013;
            L_0x0010:
                r3.f39771h = r2;
                return r2;
            L_0x0013:
                r0 = r3.m40010i();
                if (r0 != 0) goto L_0x001c;
            L_0x0019:
                r3.f39771h = r2;
                return r2;
            L_0x001c:
                r0 = r3.f39768d;
                r0 = r0.mo7303g();
                if (r0 != 0) goto L_0x0027;
            L_0x0024:
                r3.f39771h = r2;
                return r2;
            L_0x0027:
                r3.f39771h = r1;
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.g():boolean");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder();
                r0 = r0.m39956a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.e():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Builder();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.c():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f39766e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private int f39773b;
            private int f39774c;
            private List<Argument> f39775d = Collections.emptyList();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m40013i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.a():kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r1 = r0.m40011c(r1, r2);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m40013i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.b():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r1 = r0.m40011c(r1, r2);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* synthetic */ java.lang.Object clone() throws java.lang.CloneNotSupportedException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m40013i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.clone():java.lang.Object");
            }

            private Builder() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = java.util.Collections.emptyList();
                r1.f39775d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.<init>():void");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation m40022e() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation;
                r1 = 0;
                r0.<init>(r4, r1);
                r2 = r4.f39773b;
                r3 = 1;
                r2 = r2 & r3;
                if (r2 != r3) goto L_0x000d;
            L_0x000c:
                r1 = r3;
            L_0x000d:
                r2 = r4.f39774c;
                r0.f39778c = r2;
                r2 = r4.f39773b;
                r3 = 2;
                r2 = r2 & r3;
                if (r2 != r3) goto L_0x0026;
            L_0x0018:
                r2 = r4.f39775d;
                r2 = java.util.Collections.unmodifiableList(r2);
                r4.f39775d = r2;
                r2 = r4.f39773b;
                r2 = r2 & -3;
                r4.f39773b = r2;
            L_0x0026:
                r2 = r4.f39775d;
                r0.f39779d = r2;
                r0.f39781g = r1;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.e():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder m40017a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                if (r4 != r0) goto L_0x0007;
            L_0x0006:
                return r3;
            L_0x0007:
                r0 = r4.m40038h();
                if (r0 == 0) goto L_0x0017;
            L_0x000d:
                r0 = r4.f39778c;
                r1 = r3.f39773b;
                r1 = r1 | 1;
                r3.f39773b = r1;
                r3.f39774c = r0;
            L_0x0017:
                r0 = r4.f39779d;
                r0 = r0.isEmpty();
                if (r0 != 0) goto L_0x0053;
            L_0x0021:
                r0 = r3.f39775d;
                r0 = r0.isEmpty();
                if (r0 == 0) goto L_0x0036;
            L_0x0029:
                r0 = r4.f39779d;
                r3.f39775d = r0;
                r0 = r3.f39773b;
                r0 = r0 & -3;
                r3.f39773b = r0;
                goto L_0x0053;
            L_0x0036:
                r0 = r3.f39773b;
                r1 = 2;
                r0 = r0 & r1;
                if (r0 == r1) goto L_0x004a;
            L_0x003c:
                r0 = new java.util.ArrayList;
                r2 = r3.f39775d;
                r0.<init>(r2);
                r3.f39775d = r0;
                r0 = r3.f39773b;
                r0 = r0 | r1;
                r3.f39773b = r0;
            L_0x004a:
                r0 = r3.f39775d;
                r1 = r4.f39779d;
                r0.addAll(r1);
            L_0x0053:
                r0 = r3.f38788a;
                r4 = r4.f39780f;
                r4 = r0.m27460a(r4);
                r3.f38788a = r4;
                return r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder");
            }

            private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder m40011c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.f39776b;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r3 = r1.mo6731a(r3, r4);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation) r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r2.m40017a(r3);
                return r2;
            L_0x000d:
                r3 = move-exception;
                goto L_0x0017;
            L_0x000f:
                r3 = move-exception;
                r4 = r3.f25930a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation) r4;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                throw r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
            L_0x0015:
                r3 = move-exception;
                r0 = r4;
            L_0x0017:
                if (r0 == 0) goto L_0x001c;
            L_0x0019:
                r2.m40017a(r0);
            L_0x001c:
                throw r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder");
            }

            private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder m40013i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder;
                r0.<init>();
                r1 = r2.m40022e();
                r0 = r0.m40017a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.i():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder");
            }

            public final boolean mo7303g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.f39773b;
                r1 = 1;
                r0 = r0 & r1;
                r2 = 0;
                if (r0 != r1) goto L_0x0009;
            L_0x0007:
                r0 = r1;
                goto L_0x000a;
            L_0x0009:
                r0 = r2;
            L_0x000a:
                if (r0 != 0) goto L_0x000d;
            L_0x000c:
                return r2;
            L_0x000d:
                r0 = r2;
            L_0x000e:
                r3 = r4.f39775d;
                r3 = r3.size();
                if (r0 >= r3) goto L_0x0028;
            L_0x0016:
                r3 = r4.f39775d;
                r3 = r3.get(r0);
                r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument) r3;
                r3 = r3.mo7303g();
                if (r3 != 0) goto L_0x0025;
            L_0x0024:
                return r2;
            L_0x0025:
                r0 = r0 + 1;
                goto L_0x000e;
            L_0x0028:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.g():boolean");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite mo7301c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.c():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7302f() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.m40022e();
                r1 = r0.mo7303g();
                if (r1 != 0) goto L_0x0010;
            L_0x000a:
                r0 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
                r0.<init>();
                throw r0;
            L_0x0010:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.f():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.m40031f();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m40040j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.e():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
        }

        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 0;
            r1.<init>(r0);
            r0 = -1;
            r1.f39782h = r0;
            r1.f39783i = r0;
            r2 = r2.f38788a;
            r1.f39780f = r2;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.<init>(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder):void");
        }

        private Annotation() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r1.<init>();
            r0 = -1;
            r1.f39782h = r0;
            r1.f39783i = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.f25891b;
            r1.f39780f = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.<init>():void");
        }

        public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation m40031f() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f39777e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.f():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation");
        }

        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.<init>();
            r0 = -1;
            r8.f39782h = r0;
            r8.f39783i = r0;
            r8.m40032k();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 2;
            if (r2 != 0) goto L_0x008a;
        L_0x0019:
            r6 = r9.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            if (r6 == 0) goto L_0x0053;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x001f:
            r7 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            if (r6 == r7) goto L_0x0047;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x0023:
            r7 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            if (r6 == r7) goto L_0x002e;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x0027:
            r6 = r8.mo7294a(r9, r1, r10, r6);	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            if (r6 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x002d:
            goto L_0x0053;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x002e:
            r6 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            if (r6 == r5) goto L_0x003b;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x0032:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r8.f39779d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x003b:
            r6 = r8.f39779d;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.f39765b;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r7 = r9.m27483a(r7, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
        L_0x0047:
            r6 = r8.f39781g;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r6 = r6 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r8.f39781g = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r6 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            r8.f39778c = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0064, IOException -> 0x0057 }
            goto L_0x0016;
        L_0x0053:
            r2 = r3;
            goto L_0x0016;
        L_0x0055:
            r9 = move-exception;
            goto L_0x0068;
        L_0x0057:
            r9 = move-exception;
            r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0055 }
            r9 = r9.getMessage();	 Catch:{ all -> 0x0055 }
            r10.<init>(r9);	 Catch:{ all -> 0x0055 }
            r10.f25930a = r8;	 Catch:{ all -> 0x0055 }
            throw r10;	 Catch:{ all -> 0x0055 }
        L_0x0064:
            r9 = move-exception;	 Catch:{ all -> 0x0055 }
            r9.f25930a = r8;	 Catch:{ all -> 0x0055 }
            throw r9;	 Catch:{ all -> 0x0055 }
        L_0x0068:
            r10 = r4 & 2;
            if (r10 != r5) goto L_0x0074;
        L_0x006c:
            r10 = r8.f39779d;
            r10 = java.util.Collections.unmodifiableList(r10);
            r8.f39779d = r10;
        L_0x0074:
            r1.m27501b();	 Catch:{ IOException -> 0x0077, all -> 0x007e }
        L_0x0077:
            r10 = r0.m27451a();
            r8.f39780f = r10;
            goto L_0x0086;
        L_0x007e:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39780f = r10;
            throw r9;
        L_0x0086:
            r8.mo7295b();
            throw r9;
        L_0x008a:
            r9 = r4 & 2;
            if (r9 != r5) goto L_0x0096;
        L_0x008e:
            r9 = r8.f39779d;
            r9 = java.util.Collections.unmodifiableList(r9);
            r8.f39779d = r9;
        L_0x0096:
            r1.m27501b();	 Catch:{ IOException -> 0x0099, all -> 0x00a0 }
        L_0x0099:
            r9 = r0.m27451a();
            r8.f39780f = r9;
            goto L_0x00a8;
        L_0x00a0:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39780f = r10;
            throw r9;
        L_0x00a8:
            r8.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Annotation annotation = new Annotation();
            f39777e = annotation;
            annotation.m40032k();
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation> mo7112a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f39776b;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.a():kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation>");
        }

        public final boolean m40038h() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f39781g;
            r1 = 1;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0007;
        L_0x0006:
            return r1;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.h():boolean");
        }

        public final int m40039i() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f39779d;
            r0 = r0.size();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.i():int");
        }

        private void m40032k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 0;
            r1.f39778c = r0;
            r0 = java.util.Collections.emptyList();
            r1.f39779d = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.k():void");
        }

        public final boolean mo7303g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f39782h;
            r1 = 1;
            if (r0 != r1) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r2 = 0;
            if (r0 != 0) goto L_0x000a;
        L_0x0009:
            return r2;
        L_0x000a:
            r0 = r4.m40038h();
            if (r0 != 0) goto L_0x0013;
        L_0x0010:
            r4.f39782h = r2;
            return r2;
        L_0x0013:
            r0 = r2;
        L_0x0014:
            r3 = r4.m40039i();
            if (r0 >= r3) goto L_0x002e;
        L_0x001a:
            r3 = r4.f39779d;
            r3 = r3.get(r0);
            r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument) r3;
            r3 = r3.mo7303g();
            if (r3 != 0) goto L_0x002b;
        L_0x0028:
            r4.f39782h = r2;
            return r2;
        L_0x002b:
            r0 = r0 + 1;
            goto L_0x0014;
        L_0x002e:
            r4.f39782h = r1;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.g():boolean");
        }

        public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder m40027a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder();
            r1 = r0.m40017a(r1);
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder");
        }

        public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder m40040j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder();
            r0 = r0.m40017a(r1);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.j():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder");
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Builder();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.c():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
        }

        public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f39777e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
        }
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> f39799b = new C27781();
        private static final QualifiedNameTable f39800c;
        private final ByteString f39801d;
        private List<QualifiedName> f39802e;
        private byte f39803f;
        private int f39804g;

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static class C27781 extends AbstractParser<QualifiedNameTable> {
            C27781() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int f39784b;
            private List<QualifiedName> f39785c = Collections.emptyList();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40043i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40041c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40043i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40041c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40043i();
            }

            private Builder() {
            }

            public final QualifiedNameTable m40052e() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39784b & 1) == 1) {
                    this.f39785c = Collections.unmodifiableList(this.f39785c);
                    this.f39784b &= -2;
                }
                qualifiedNameTable.f39802e = this.f39785c;
                return qualifiedNameTable;
            }

            public final Builder m40047a(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.m40086f()) {
                    return this;
                }
                if (!qualifiedNameTable.f39802e.isEmpty()) {
                    if (this.f39785c.isEmpty()) {
                        this.f39785c = qualifiedNameTable.f39802e;
                        this.f39784b &= -2;
                    } else {
                        if ((this.f39784b & 1) != 1) {
                            this.f39785c = new ArrayList(this.f39785c);
                            this.f39784b |= 1;
                        }
                        this.f39785c.addAll(qualifiedNameTable.f39802e);
                    }
                }
                this.f38788a = this.f38788a.m27460a(qualifiedNameTable.f39801d);
                return this;
            }

            private Builder m40041c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedNameTable qualifiedNameTable;
                QualifiedNameTable qualifiedNameTable2 = null;
                try {
                    m40047a((QualifiedNameTable) QualifiedNameTable.f39799b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    qualifiedNameTable = (QualifiedNameTable) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    qualifiedNameTable2 = qualifiedNameTable;
                }
                if (qualifiedNameTable2 != null) {
                    m40047a(qualifiedNameTable2);
                }
                throw codedInputStream2;
            }

            private Builder m40043i() {
                return new Builder().m40047a(m40052e());
            }

            public final boolean mo7303g() {
                for (int i = 0; i < this.f39785c.size(); i++) {
                    if (!((QualifiedName) this.f39785c.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return QualifiedNameTable.m40086f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40052e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return QualifiedNameTable.m40086f();
            }
        }

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> f39790b = new C27791();
            private static final QualifiedName f39791g;
            int f39792c;
            public int f39793d;
            public int f39794e;
            public Kind f39795f;
            private final ByteString f39796h;
            private byte f39797i;
            private int f39798j;

            public enum Kind implements EnumLite {
                CLASS(0),
                PACKAGE(1),
                LOCAL(2);
                
                private static EnumLiteMap<Kind> f32999d;
                private final int f33001e;

                static class C25881 implements EnumLiteMap<Kind> {
                    C25881() {
                    }

                    public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                        return Kind.m33519a(i);
                    }
                }

                static {
                    f32999d = new C25881();
                }

                public final int mo5922a() {
                    return this.f33001e;
                }

                public static Kind m33519a(int i) {
                    switch (i) {
                        case 0:
                            return CLASS;
                        case 1:
                            return PACKAGE;
                        case 2:
                            return LOCAL;
                        default:
                            return 0;
                    }
                }

                private Kind(int i) {
                    this.f33001e = i;
                }
            }

            static class C27791 extends AbstractParser<QualifiedName> {
                C27791() {
                }

                public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite);
                }
            }

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int f39786b;
                private int f39787c = -1;
                private int f39788d;
                private Kind f39789e = Kind.PACKAGE;

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                    return m40057h();
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return m40055c(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                    return m40057h();
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return m40055c(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return m40057h();
                }

                private Builder() {
                }

                private QualifiedName m40058i() {
                    int i = 0;
                    QualifiedName qualifiedName = new QualifiedName((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                    int i2 = this.f39786b;
                    if ((i2 & 1) == 1) {
                        i = 1;
                    }
                    qualifiedName.f39793d = this.f39787c;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    qualifiedName.f39794e = this.f39788d;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    qualifiedName.f39795f = this.f39789e;
                    qualifiedName.f39792c = i;
                    return qualifiedName;
                }

                public final Builder m40062a(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.m40074f()) {
                        return this;
                    }
                    int i = 1;
                    if (((qualifiedName.f39792c & 1) == 1 ? 1 : 0) != 0) {
                        int i2 = qualifiedName.f39793d;
                        this.f39786b |= 1;
                        this.f39787c = i2;
                    }
                    if (qualifiedName.m40081h()) {
                        i2 = qualifiedName.f39794e;
                        this.f39786b |= 2;
                        this.f39788d = i2;
                    }
                    if ((qualifiedName.f39792c & 4) != 4) {
                        i = 0;
                    }
                    if (i != 0) {
                        Kind kind = qualifiedName.f39795f;
                        if (kind == null) {
                            throw new NullPointerException();
                        }
                        this.f39786b |= 4;
                        this.f39789e = kind;
                    }
                    this.f38788a = this.f38788a.m27460a(qualifiedName.f39796h);
                    return this;
                }

                private Builder m40055c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    QualifiedName qualifiedName;
                    QualifiedName qualifiedName2 = null;
                    try {
                        m40062a((QualifiedName) QualifiedName.f39790b.mo6731a(codedInputStream, extensionRegistryLite));
                        return this;
                    } catch (CodedInputStream codedInputStream2) {
                        qualifiedName = (QualifiedName) codedInputStream2.f25930a;
                        throw codedInputStream2;
                    } catch (Throwable th) {
                        codedInputStream2 = th;
                        qualifiedName2 = qualifiedName;
                    }
                    if (qualifiedName2 != null) {
                        m40062a(qualifiedName2);
                    }
                    throw codedInputStream2;
                }

                private Builder m40057h() {
                    return new Builder().m40062a(m40058i());
                }

                public final boolean mo7303g() {
                    return (this.f39786b & 2) == 2;
                }

                public final /* synthetic */ GeneratedMessageLite mo7301c() {
                    return QualifiedName.m40074f();
                }

                public final /* synthetic */ MessageLite mo7302f() {
                    MessageLite i = m40058i();
                    if (i.mo7303g()) {
                        return i;
                    }
                    throw new UninitializedMessageException();
                }

                public final /* synthetic */ MessageLite mo7111d() {
                    return QualifiedName.m40074f();
                }
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
                super((byte) 0);
                this.f39797i = (byte) -1;
                this.f39798j = -1;
                this.f39796h = builder.f38788a;
            }

            private QualifiedName() {
                this.f39797i = (byte) -1;
                this.f39798j = -1;
                this.f39796h = ByteString.f25891b;
            }

            public static QualifiedName m40074f() {
                return f39791g;
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r7.<init>();
                r0 = -1;
                r7.f39797i = r0;
                r7.f39798j = r0;
                r7.m40075i();
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
                r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
                r2 = 0;
                r3 = 1;
            L_0x0015:
                if (r2 != 0) goto L_0x008e;
            L_0x0017:
                r4 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r4 == 0) goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x001d:
                r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r4 == r5) goto L_0x0057;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0021:
                r5 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r4 == r5) goto L_0x004a;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0025:
                r5 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r4 == r5) goto L_0x0030;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0029:
                r4 = r7.mo7294a(r8, r1, r9, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x002f:
                goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0030:
                r5 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.m33519a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                if (r6 != 0) goto L_0x0041;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x003a:
                r1.m27502b(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r1.m27502b(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0041:
                r4 = r7.f39792c;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39792c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39795f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x004a:
                r4 = r7.f39792c;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39792c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r4 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39794e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            L_0x0057:
                r4 = r7.f39792c;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39792c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r4 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                r7.f39793d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
                goto L_0x0015;
            L_0x0063:
                r2 = r3;
                goto L_0x0015;
            L_0x0065:
                r8 = move-exception;
                goto L_0x0078;
            L_0x0067:
                r8 = move-exception;
                r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0065 }
                r8 = r8.getMessage();	 Catch:{ all -> 0x0065 }
                r9.<init>(r8);	 Catch:{ all -> 0x0065 }
                r9.f25930a = r7;	 Catch:{ all -> 0x0065 }
                throw r9;	 Catch:{ all -> 0x0065 }
            L_0x0074:
                r8 = move-exception;	 Catch:{ all -> 0x0065 }
                r8.f25930a = r7;	 Catch:{ all -> 0x0065 }
                throw r8;	 Catch:{ all -> 0x0065 }
            L_0x0078:
                r1.m27501b();	 Catch:{ IOException -> 0x007b, all -> 0x0082 }
            L_0x007b:
                r9 = r0.m27451a();
                r7.f39796h = r9;
                goto L_0x008a;
            L_0x0082:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39796h = r9;
                throw r8;
            L_0x008a:
                r7.mo7295b();
                throw r8;
            L_0x008e:
                r1.m27501b();	 Catch:{ IOException -> 0x0091, all -> 0x0098 }
            L_0x0091:
                r8 = r0.m27451a();
                r7.f39796h = r8;
                goto L_0x00a0;
            L_0x0098:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39796h = r9;
                throw r8;
            L_0x00a0:
                r7.mo7295b();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.QualifiedName.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
            }

            static {
                QualifiedName qualifiedName = new QualifiedName();
                f39791g = qualifiedName;
                qualifiedName.m40075i();
            }

            public final Parser<QualifiedName> mo7112a() {
                return f39790b;
            }

            public final boolean m40081h() {
                return (this.f39792c & 2) == 2;
            }

            private void m40075i() {
                this.f39793d = -1;
                this.f39794e = 0;
                this.f39795f = Kind.PACKAGE;
            }

            public final boolean mo7303g() {
                byte b = this.f39797i;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                if (m40081h()) {
                    this.f39797i = (byte) 1;
                    return true;
                }
                this.f39797i = (byte) 0;
                return false;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
                return new Builder().m40062a(this);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
                return new Builder();
            }

            public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
                return f39791g;
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return m40093h();
        }

        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39803f = (byte) -1;
            this.f39804g = -1;
            this.f39801d = builder.f38788a;
        }

        private QualifiedNameTable() {
            this.f39803f = (byte) -1;
            this.f39804g = -1;
            this.f39801d = ByteString.f25891b;
        }

        public static QualifiedNameTable m40086f() {
            return f39800c;
        }

        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = -1;
            r7.f39803f = r0;
            r7.f39804g = r0;
            r0 = java.util.Collections.emptyList();
            r7.f39802e = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0019:
            if (r2 != 0) goto L_0x007c;
        L_0x001b:
            r5 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == 0) goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0021:
            r6 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == r6) goto L_0x002c;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0025:
            r5 = r7.mo7294a(r8, r1, r9, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 != 0) goto L_0x0019;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002b:
            goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002c:
            r5 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == r3) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0030:
            r5 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r5.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r7.f39802e = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0039:
            r5 = r7.f39802e;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.QualifiedName.f39790b;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6 = r8.m27483a(r6, r9);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r5.add(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0019;
        L_0x0045:
            r2 = r3;
            goto L_0x0019;
        L_0x0047:
            r8 = move-exception;
            goto L_0x005a;
        L_0x0049:
            r8 = move-exception;
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0047 }
            r8 = r8.getMessage();	 Catch:{ all -> 0x0047 }
            r9.<init>(r8);	 Catch:{ all -> 0x0047 }
            r9.f25930a = r7;	 Catch:{ all -> 0x0047 }
            throw r9;	 Catch:{ all -> 0x0047 }
        L_0x0056:
            r8 = move-exception;	 Catch:{ all -> 0x0047 }
            r8.f25930a = r7;	 Catch:{ all -> 0x0047 }
            throw r8;	 Catch:{ all -> 0x0047 }
        L_0x005a:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x0066;
        L_0x005e:
            r9 = r7.f39802e;
            r9 = java.util.Collections.unmodifiableList(r9);
            r7.f39802e = r9;
        L_0x0066:
            r1.m27501b();	 Catch:{ IOException -> 0x0069, all -> 0x0070 }
        L_0x0069:
            r9 = r0.m27451a();
            r7.f39801d = r9;
            goto L_0x0078;
        L_0x0070:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39801d = r9;
            throw r8;
        L_0x0078:
            r7.mo7295b();
            throw r8;
        L_0x007c:
            r8 = r4 & 1;
            if (r8 != r3) goto L_0x0088;
        L_0x0080:
            r8 = r7.f39802e;
            r8 = java.util.Collections.unmodifiableList(r8);
            r7.f39802e = r8;
        L_0x0088:
            r1.m27501b();	 Catch:{ IOException -> 0x008b, all -> 0x0092 }
        L_0x008b:
            r8 = r0.m27451a();
            r7.f39801d = r8;
            goto L_0x009a;
        L_0x0092:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39801d = r9;
            throw r8;
        L_0x009a:
            r7.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable();
            f39800c = qualifiedNameTable;
            qualifiedNameTable.f39802e = Collections.emptyList();
        }

        public final Parser<QualifiedNameTable> mo7112a() {
            return f39799b;
        }

        public final QualifiedName m40088a(int i) {
            return (QualifiedName) this.f39802e.get(i);
        }

        public final boolean mo7303g() {
            byte b = this.f39803f;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < this.f39802e.size()) {
                if (m40088a(i).mo7303g()) {
                    i++;
                } else {
                    this.f39803f = (byte) 0;
                    return false;
                }
            }
            this.f39803f = (byte) 1;
            return true;
        }

        public static Builder m40083a(QualifiedNameTable qualifiedNameTable) {
            return new Builder().m40047a(qualifiedNameTable);
        }

        public final Builder m40093h() {
            return new Builder().m40047a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39800c;
        }
    }

    public static final class SinceKotlinInfo extends GeneratedMessageLite implements SinceKotlinInfoOrBuilder {
        public static Parser<SinceKotlinInfo> f39811b = new C27801();
        private static final SinceKotlinInfo f39812i;
        int f39813c;
        int f39814d;
        int f39815e;
        Level f39816f;
        int f39817g;
        int f39818h;
        private final ByteString f39819j;
        private byte f39820k;
        private int f39821l;

        public enum Level implements EnumLite {
            WARNING(0),
            ERROR(1),
            HIDDEN(2);
            
            private static EnumLiteMap<Level> f33005d;
            private final int f33007e;

            static class C25891 implements EnumLiteMap<Level> {
                C25891() {
                }

                public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                    return Level.m33522a(i);
                }
            }

            static {
                f33005d = new C25891();
            }

            public final int mo5922a() {
                return this.f33007e;
            }

            public static Level m33522a(int i) {
                switch (i) {
                    case 0:
                        return WARNING;
                    case 1:
                        return ERROR;
                    case 2:
                        return HIDDEN;
                    default:
                        return 0;
                }
            }

            private Level(int i) {
                this.f33007e = i;
            }
        }

        static class C27801 extends AbstractParser<SinceKotlinInfo> {
            C27801() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SinceKotlinInfo(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<SinceKotlinInfo, Builder> implements SinceKotlinInfoOrBuilder {
            private int f39805b;
            private int f39806c;
            private int f39807d;
            private Level f39808e = Level.ERROR;
            private int f39809f;
            private int f39810g;

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40096h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40094c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40096h();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40094c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40096h();
            }

            private Builder() {
            }

            private SinceKotlinInfo m40097i() {
                int i = 0;
                SinceKotlinInfo sinceKotlinInfo = new SinceKotlinInfo((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39805b;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                sinceKotlinInfo.f39814d = this.f39806c;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                sinceKotlinInfo.f39815e = this.f39807d;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                sinceKotlinInfo.f39816f = this.f39808e;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                sinceKotlinInfo.f39817g = this.f39809f;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                sinceKotlinInfo.f39818h = this.f39810g;
                sinceKotlinInfo.f39813c = i;
                return sinceKotlinInfo;
            }

            public final Builder m40101a(SinceKotlinInfo sinceKotlinInfo) {
                if (sinceKotlinInfo == SinceKotlinInfo.m40115f()) {
                    return this;
                }
                int i = 1;
                if (((sinceKotlinInfo.f39813c & 1) == 1 ? 1 : 0) != 0) {
                    int i2 = sinceKotlinInfo.f39814d;
                    this.f39805b |= 1;
                    this.f39806c = i2;
                }
                if (((sinceKotlinInfo.f39813c & 2) == 2 ? 1 : 0) != 0) {
                    i2 = sinceKotlinInfo.f39815e;
                    this.f39805b = 2 | this.f39805b;
                    this.f39807d = i2;
                }
                if (((sinceKotlinInfo.f39813c & 4) == 4 ? 1 : 0) != 0) {
                    Level level = sinceKotlinInfo.f39816f;
                    if (level == null) {
                        throw new NullPointerException();
                    }
                    this.f39805b = 4 | this.f39805b;
                    this.f39808e = level;
                }
                if (((sinceKotlinInfo.f39813c & 8) == 8 ? 1 : 0) != 0) {
                    i2 = sinceKotlinInfo.f39817g;
                    this.f39805b = 8 | this.f39805b;
                    this.f39809f = i2;
                }
                if ((sinceKotlinInfo.f39813c & 16) != 16) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = sinceKotlinInfo.f39818h;
                    this.f39805b |= 16;
                    this.f39810g = i2;
                }
                this.f38788a = this.f38788a.m27460a(sinceKotlinInfo.f39819j);
                return this;
            }

            private Builder m40094c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                SinceKotlinInfo sinceKotlinInfo;
                SinceKotlinInfo sinceKotlinInfo2 = null;
                try {
                    m40101a((SinceKotlinInfo) SinceKotlinInfo.f39811b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    sinceKotlinInfo = (SinceKotlinInfo) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    sinceKotlinInfo2 = sinceKotlinInfo;
                }
                if (sinceKotlinInfo2 != null) {
                    m40101a(sinceKotlinInfo2);
                }
                throw codedInputStream2;
            }

            private Builder m40096h() {
                return new Builder().m40101a(m40097i());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return SinceKotlinInfo.m40115f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite i = m40097i();
                if (i.mo7303g()) {
                    return i;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return SinceKotlinInfo.m40115f();
            }
        }

        private SinceKotlinInfo(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39820k = (byte) -1;
            this.f39821l = -1;
            this.f39819j = builder.f38788a;
        }

        private SinceKotlinInfo() {
            this.f39820k = (byte) -1;
            this.f39821l = -1;
            this.f39819j = ByteString.f25891b;
        }

        public static SinceKotlinInfo m40115f() {
            return f39812i;
        }

        private SinceKotlinInfo(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.<init>();
            r0 = -1;
            r8.f39820k = r0;
            r8.f39821l = r0;
            r8.m40116h();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
        L_0x0015:
            if (r2 != 0) goto L_0x00ae;
        L_0x0017:
            r4 = r9.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == 0) goto L_0x0083;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x001d:
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == r5) goto L_0x0077;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0021:
            r6 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == r6) goto L_0x006a;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0025:
            r7 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == r7) goto L_0x0050;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0029:
            r7 = 32;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == r7) goto L_0x0044;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x002d:
            r5 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 == r5) goto L_0x0038;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0031:
            r4 = r8.mo7294a(r9, r1, r10, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0037:
            goto L_0x0083;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0038:
            r4 = r8.f39813c;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r4 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39813c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39818h = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0044:
            r4 = r8.f39813c;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39813c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39817g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0050:
            r5 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfo.Level.m33522a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            if (r6 != 0) goto L_0x0061;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x005a:
            r1.m27502b(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r1.m27502b(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0061:
            r4 = r8.f39813c;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39813c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39816f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x006a:
            r4 = r8.f39813c;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39813c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39815e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
        L_0x0077:
            r4 = r8.f39813c;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39813c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r4 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            r8.f39814d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0094, IOException -> 0x0087 }
            goto L_0x0015;
        L_0x0083:
            r2 = r3;
            goto L_0x0015;
        L_0x0085:
            r9 = move-exception;
            goto L_0x0098;
        L_0x0087:
            r9 = move-exception;
            r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0085 }
            r9 = r9.getMessage();	 Catch:{ all -> 0x0085 }
            r10.<init>(r9);	 Catch:{ all -> 0x0085 }
            r10.f25930a = r8;	 Catch:{ all -> 0x0085 }
            throw r10;	 Catch:{ all -> 0x0085 }
        L_0x0094:
            r9 = move-exception;	 Catch:{ all -> 0x0085 }
            r9.f25930a = r8;	 Catch:{ all -> 0x0085 }
            throw r9;	 Catch:{ all -> 0x0085 }
        L_0x0098:
            r1.m27501b();	 Catch:{ IOException -> 0x009b, all -> 0x00a2 }
        L_0x009b:
            r10 = r0.m27451a();
            r8.f39819j = r10;
            goto L_0x00aa;
        L_0x00a2:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39819j = r10;
            throw r9;
        L_0x00aa:
            r8.mo7295b();
            throw r9;
        L_0x00ae:
            r1.m27501b();	 Catch:{ IOException -> 0x00b1, all -> 0x00b8 }
        L_0x00b1:
            r9 = r0.m27451a();
            r8.f39819j = r9;
            goto L_0x00c0;
        L_0x00b8:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f39819j = r10;
            throw r9;
        L_0x00c0:
            r8.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfo.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            SinceKotlinInfo sinceKotlinInfo = new SinceKotlinInfo();
            f39812i = sinceKotlinInfo;
            sinceKotlinInfo.m40116h();
        }

        public final Parser<SinceKotlinInfo> mo7112a() {
            return f39811b;
        }

        private void m40116h() {
            this.f39814d = 0;
            this.f39815e = 0;
            this.f39816f = Level.ERROR;
            this.f39817g = 0;
            this.f39818h = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f39820k;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39820k = (byte) 1;
            return true;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40101a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39812i;
        }
    }

    public static final class SinceKotlinInfoTable extends GeneratedMessageLite implements SinceKotlinInfoTableOrBuilder {
        public static Parser<SinceKotlinInfoTable> f39824b = new C27811();
        private static final SinceKotlinInfoTable f39825d;
        public List<SinceKotlinInfo> f39826c;
        private final ByteString f39827e;
        private byte f39828f;
        private int f39829g;

        static class C27811 extends AbstractParser<SinceKotlinInfoTable> {
            C27811() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SinceKotlinInfoTable(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<SinceKotlinInfoTable, Builder> implements SinceKotlinInfoTableOrBuilder {
            private int f39822b;
            private List<SinceKotlinInfo> f39823c = Collections.emptyList();

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40124i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40122c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40124i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40122c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40124i();
            }

            private Builder() {
            }

            public final SinceKotlinInfoTable m40133e() {
                SinceKotlinInfoTable sinceKotlinInfoTable = new SinceKotlinInfoTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39822b & 1) == 1) {
                    this.f39823c = Collections.unmodifiableList(this.f39823c);
                    this.f39822b &= -2;
                }
                sinceKotlinInfoTable.f39826c = this.f39823c;
                return sinceKotlinInfoTable;
            }

            public final Builder m40128a(SinceKotlinInfoTable sinceKotlinInfoTable) {
                if (sinceKotlinInfoTable == SinceKotlinInfoTable.m40140f()) {
                    return this;
                }
                if (!sinceKotlinInfoTable.f39826c.isEmpty()) {
                    if (this.f39823c.isEmpty()) {
                        this.f39823c = sinceKotlinInfoTable.f39826c;
                        this.f39822b &= -2;
                    } else {
                        if ((this.f39822b & 1) != 1) {
                            this.f39823c = new ArrayList(this.f39823c);
                            this.f39822b |= 1;
                        }
                        this.f39823c.addAll(sinceKotlinInfoTable.f39826c);
                    }
                }
                this.f38788a = this.f38788a.m27460a(sinceKotlinInfoTable.f39827e);
                return this;
            }

            private Builder m40122c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                SinceKotlinInfoTable sinceKotlinInfoTable;
                SinceKotlinInfoTable sinceKotlinInfoTable2 = null;
                try {
                    m40128a((SinceKotlinInfoTable) SinceKotlinInfoTable.f39824b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    sinceKotlinInfoTable = (SinceKotlinInfoTable) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    sinceKotlinInfoTable2 = sinceKotlinInfoTable;
                }
                if (sinceKotlinInfoTable2 != null) {
                    m40128a(sinceKotlinInfoTable2);
                }
                throw codedInputStream2;
            }

            private Builder m40124i() {
                return new Builder().m40128a(m40133e());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return SinceKotlinInfoTable.m40140f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40133e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return SinceKotlinInfoTable.m40140f();
            }
        }

        private SinceKotlinInfoTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39828f = (byte) -1;
            this.f39829g = -1;
            this.f39827e = builder.f38788a;
        }

        private SinceKotlinInfoTable() {
            this.f39828f = (byte) -1;
            this.f39829g = -1;
            this.f39827e = ByteString.f25891b;
        }

        public static SinceKotlinInfoTable m40140f() {
            return f39825d;
        }

        private SinceKotlinInfoTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = -1;
            r7.f39828f = r0;
            r7.f39829g = r0;
            r0 = java.util.Collections.emptyList();
            r7.f39826c = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0019:
            if (r2 != 0) goto L_0x007c;
        L_0x001b:
            r5 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == 0) goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0021:
            r6 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == r6) goto L_0x002c;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0025:
            r5 = r7.mo7294a(r8, r1, r9, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 != 0) goto L_0x0019;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002b:
            goto L_0x0045;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x002c:
            r5 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            if (r5 == r3) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0030:
            r5 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r5.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r7.f39826c = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
        L_0x0039:
            r5 = r7.f39826c;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfo.f39811b;	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r6 = r8.m27483a(r6, r9);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            r5.add(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0056, IOException -> 0x0049 }
            goto L_0x0019;
        L_0x0045:
            r2 = r3;
            goto L_0x0019;
        L_0x0047:
            r8 = move-exception;
            goto L_0x005a;
        L_0x0049:
            r8 = move-exception;
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0047 }
            r8 = r8.getMessage();	 Catch:{ all -> 0x0047 }
            r9.<init>(r8);	 Catch:{ all -> 0x0047 }
            r9.f25930a = r7;	 Catch:{ all -> 0x0047 }
            throw r9;	 Catch:{ all -> 0x0047 }
        L_0x0056:
            r8 = move-exception;	 Catch:{ all -> 0x0047 }
            r8.f25930a = r7;	 Catch:{ all -> 0x0047 }
            throw r8;	 Catch:{ all -> 0x0047 }
        L_0x005a:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x0066;
        L_0x005e:
            r9 = r7.f39826c;
            r9 = java.util.Collections.unmodifiableList(r9);
            r7.f39826c = r9;
        L_0x0066:
            r1.m27501b();	 Catch:{ IOException -> 0x0069, all -> 0x0070 }
        L_0x0069:
            r9 = r0.m27451a();
            r7.f39827e = r9;
            goto L_0x0078;
        L_0x0070:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39827e = r9;
            throw r8;
        L_0x0078:
            r7.mo7295b();
            throw r8;
        L_0x007c:
            r8 = r4 & 1;
            if (r8 != r3) goto L_0x0088;
        L_0x0080:
            r8 = r7.f39826c;
            r8 = java.util.Collections.unmodifiableList(r8);
            r7.f39826c = r8;
        L_0x0088:
            r1.m27501b();	 Catch:{ IOException -> 0x008b, all -> 0x0092 }
        L_0x008b:
            r8 = r0.m27451a();
            r7.f39827e = r8;
            goto L_0x009a;
        L_0x0092:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39827e = r9;
            throw r8;
        L_0x009a:
            r7.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            SinceKotlinInfoTable sinceKotlinInfoTable = new SinceKotlinInfoTable();
            f39825d = sinceKotlinInfoTable;
            sinceKotlinInfoTable.f39826c = Collections.emptyList();
        }

        public final Parser<SinceKotlinInfoTable> mo7112a() {
            return f39824b;
        }

        public final boolean mo7303g() {
            byte b = this.f39828f;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39828f = (byte) 1;
            return true;
        }

        public static Builder m40137a(SinceKotlinInfoTable sinceKotlinInfoTable) {
            return new Builder().m40128a(sinceKotlinInfoTable);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40128a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39825d;
        }
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> f39832b = new C27821();
        private static final StringTable f39833c;
        private final ByteString f39834d;
        private LazyStringList f39835e;
        private byte f39836f;
        private int f39837g;

        static class C27821 extends AbstractParser<StringTable> {
            C27821() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int f39830b;
            private LazyStringList f39831c = LazyStringArrayList.f36132a;

            public final boolean mo7303g() {
                return true;
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40148i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40146c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40148i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40146c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40148i();
            }

            private Builder() {
            }

            public final StringTable m40157e() {
                StringTable stringTable = new StringTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.f39830b & 1) == 1) {
                    this.f39831c = this.f39831c.mo6728b();
                    this.f39830b &= -2;
                }
                stringTable.f39835e = this.f39831c;
                return stringTable;
            }

            public final Builder m40152a(StringTable stringTable) {
                if (stringTable == StringTable.m40164f()) {
                    return this;
                }
                if (!stringTable.f39835e.isEmpty()) {
                    if (this.f39831c.isEmpty()) {
                        this.f39831c = stringTable.f39835e;
                        this.f39830b &= -2;
                    } else {
                        if ((this.f39830b & 1) != 1) {
                            this.f39831c = new LazyStringArrayList(this.f39831c);
                            this.f39830b |= 1;
                        }
                        this.f39831c.addAll(stringTable.f39835e);
                    }
                }
                this.f38788a = this.f38788a.m27460a(stringTable.f39834d);
                return this;
            }

            private Builder m40146c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTable stringTable;
                StringTable stringTable2 = null;
                try {
                    m40152a((StringTable) StringTable.f39832b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    stringTable = (StringTable) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    stringTable2 = stringTable;
                }
                if (stringTable2 != null) {
                    m40152a(stringTable2);
                }
                throw codedInputStream2;
            }

            private Builder m40148i() {
                return new Builder().m40152a(m40157e());
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return StringTable.m40164f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40157e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return StringTable.m40164f();
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return m40171h();
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39836f = (byte) -1;
            this.f39837g = -1;
            this.f39834d = builder.f38788a;
        }

        private StringTable() {
            this.f39836f = (byte) -1;
            this.f39837g = -1;
            this.f39834d = ByteString.f25891b;
        }

        public static StringTable m40164f() {
            return f39833c;
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = -1;
            r7.f39836f = r0;
            r7.f39837g = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList.f36132a;
            r7.f39835e = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0017:
            if (r2 != 0) goto L_0x0078;
        L_0x0019:
            r5 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            if (r5 == 0) goto L_0x0041;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x001f:
            r6 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            if (r5 == r6) goto L_0x002a;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x0023:
            r5 = r7.mo7294a(r8, r1, r9, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            if (r5 != 0) goto L_0x0017;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x0029:
            goto L_0x0041;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x002a:
            r5 = r8.m27490d();	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            r6 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            if (r6 == r3) goto L_0x003b;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x0032:
            r6 = new kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            r7.f39835e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
        L_0x003b:
            r6 = r7.f39835e;	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            r6.mo6727a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0052, IOException -> 0x0045 }
            goto L_0x0017;
        L_0x0041:
            r2 = r3;
            goto L_0x0017;
        L_0x0043:
            r8 = move-exception;
            goto L_0x0056;
        L_0x0045:
            r8 = move-exception;
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0043 }
            r8 = r8.getMessage();	 Catch:{ all -> 0x0043 }
            r9.<init>(r8);	 Catch:{ all -> 0x0043 }
            r9.f25930a = r7;	 Catch:{ all -> 0x0043 }
            throw r9;	 Catch:{ all -> 0x0043 }
        L_0x0052:
            r8 = move-exception;	 Catch:{ all -> 0x0043 }
            r8.f25930a = r7;	 Catch:{ all -> 0x0043 }
            throw r8;	 Catch:{ all -> 0x0043 }
        L_0x0056:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x0062;
        L_0x005a:
            r9 = r7.f39835e;
            r9 = r9.mo6728b();
            r7.f39835e = r9;
        L_0x0062:
            r1.m27501b();	 Catch:{ IOException -> 0x0065, all -> 0x006c }
        L_0x0065:
            r9 = r0.m27451a();
            r7.f39834d = r9;
            goto L_0x0074;
        L_0x006c:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39834d = r9;
            throw r8;
        L_0x0074:
            r7.mo7295b();
            throw r8;
        L_0x0078:
            r8 = r4 & 1;
            if (r8 != r3) goto L_0x0084;
        L_0x007c:
            r8 = r7.f39835e;
            r8 = r8.mo6728b();
            r7.f39835e = r8;
        L_0x0084:
            r1.m27501b();	 Catch:{ IOException -> 0x0087, all -> 0x008e }
        L_0x0087:
            r8 = r0.m27451a();
            r7.f39834d = r8;
            goto L_0x0096;
        L_0x008e:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39834d = r9;
            throw r8;
        L_0x0096:
            r7.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.StringTable.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            StringTable stringTable = new StringTable();
            f39833c = stringTable;
            stringTable.f39835e = LazyStringArrayList.f36132a;
        }

        public final Parser<StringTable> mo7112a() {
            return f39832b;
        }

        public final String m40165a(int i) {
            return (String) this.f39835e.get(i);
        }

        public final boolean mo7303g() {
            byte b = this.f39836f;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.f39836f = (byte) 1;
            return true;
        }

        public static Builder m40161a(StringTable stringTable) {
            return new Builder().m40152a(stringTable);
        }

        public final Builder m40171h() {
            return new Builder().m40152a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39833c;
        }
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> f39854b = new C27871();
        private static final TypeTable f39855e;
        public List<Type> f39856c;
        public int f39857d;
        private final ByteString f39858f;
        private int f39859g;
        private byte f39860h;
        private int f39861i;

        static class C27871 extends AbstractParser<TypeTable> {
            C27871() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int f39851b;
            private List<Type> f39852c = Collections.emptyList();
            private int f39853d = -1;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m40202i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40200c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m40202i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m40200c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m40202i();
            }

            private Builder() {
            }

            public final TypeTable m40211e() {
                int i = 0;
                TypeTable typeTable = new TypeTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.f39851b;
                if ((this.f39851b & 1) == 1) {
                    this.f39852c = Collections.unmodifiableList(this.f39852c);
                    this.f39851b &= -2;
                }
                typeTable.f39856c = this.f39852c;
                if ((i2 & 2) == 2) {
                    i = 1;
                }
                typeTable.f39857d = this.f39853d;
                typeTable.f39859g = i;
                return typeTable;
            }

            public final Builder m40206a(TypeTable typeTable) {
                if (typeTable == TypeTable.m40220f()) {
                    return this;
                }
                if (!typeTable.f39856c.isEmpty()) {
                    if (this.f39852c.isEmpty()) {
                        this.f39852c = typeTable.f39856c;
                        this.f39851b &= -2;
                    } else {
                        if ((this.f39851b & 1) != 1) {
                            this.f39852c = new ArrayList(this.f39852c);
                            this.f39851b |= 1;
                        }
                        this.f39852c.addAll(typeTable.f39856c);
                    }
                }
                if (typeTable.m40227h()) {
                    int i = typeTable.f39857d;
                    this.f39851b |= 2;
                    this.f39853d = i;
                }
                this.f38788a = this.f38788a.m27460a(typeTable.f39858f);
                return this;
            }

            private Builder m40200c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeTable typeTable;
                TypeTable typeTable2 = null;
                try {
                    m40206a((TypeTable) TypeTable.f39854b.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    typeTable = (TypeTable) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    typeTable2 = typeTable;
                }
                if (typeTable2 != null) {
                    m40206a(typeTable2);
                }
                throw codedInputStream2;
            }

            private Builder m40202i() {
                return new Builder().m40206a(m40211e());
            }

            public final boolean mo7303g() {
                for (int i = 0; i < this.f39852c.size(); i++) {
                    if (!((Type) this.f39852c.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return true;
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return TypeTable.m40220f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite e = m40211e();
                if (e.mo7303g()) {
                    return e;
                }
                throw new UninitializedMessageException();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return TypeTable.m40220f();
            }
        }

        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder) {
            super((byte) 0);
            this.f39860h = (byte) -1;
            this.f39861i = -1;
            this.f39858f = builder.f38788a;
        }

        private TypeTable() {
            this.f39860h = (byte) -1;
            this.f39861i = -1;
            this.f39858f = ByteString.f25891b;
        }

        public static TypeTable m40220f() {
            return f39855e;
        }

        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = -1;
            r7.f39860h = r0;
            r7.f39861i = r0;
            r7.m40221i();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            if (r2 != 0) goto L_0x0089;
        L_0x0018:
            r5 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            if (r5 == 0) goto L_0x0052;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x001e:
            r6 = 10;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            if (r5 == r6) goto L_0x0039;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x0022:
            r6 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            if (r5 == r6) goto L_0x002d;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x0026:
            r5 = r7.mo7294a(r8, r1, r9, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            if (r5 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x002c:
            goto L_0x0052;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x002d:
            r5 = r7.f39859g;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r5 = r5 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r7.f39859g = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r5 = r8.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r7.f39857d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x0039:
            r5 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            if (r5 == r3) goto L_0x0046;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x003d:
            r5 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r5.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r7.f39856c = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
        L_0x0046:
            r5 = r7.f39856c;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r6 = r8.m27483a(r6, r9);	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            r5.add(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0063, IOException -> 0x0056 }
            goto L_0x0016;
        L_0x0052:
            r2 = r3;
            goto L_0x0016;
        L_0x0054:
            r8 = move-exception;
            goto L_0x0067;
        L_0x0056:
            r8 = move-exception;
            r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0054 }
            r8 = r8.getMessage();	 Catch:{ all -> 0x0054 }
            r9.<init>(r8);	 Catch:{ all -> 0x0054 }
            r9.f25930a = r7;	 Catch:{ all -> 0x0054 }
            throw r9;	 Catch:{ all -> 0x0054 }
        L_0x0063:
            r8 = move-exception;	 Catch:{ all -> 0x0054 }
            r8.f25930a = r7;	 Catch:{ all -> 0x0054 }
            throw r8;	 Catch:{ all -> 0x0054 }
        L_0x0067:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x0073;
        L_0x006b:
            r9 = r7.f39856c;
            r9 = java.util.Collections.unmodifiableList(r9);
            r7.f39856c = r9;
        L_0x0073:
            r1.m27501b();	 Catch:{ IOException -> 0x0076, all -> 0x007d }
        L_0x0076:
            r9 = r0.m27451a();
            r7.f39858f = r9;
            goto L_0x0085;
        L_0x007d:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39858f = r9;
            throw r8;
        L_0x0085:
            r7.mo7295b();
            throw r8;
        L_0x0089:
            r8 = r4 & 1;
            if (r8 != r3) goto L_0x0095;
        L_0x008d:
            r8 = r7.f39856c;
            r8 = java.util.Collections.unmodifiableList(r8);
            r7.f39856c = r8;
        L_0x0095:
            r1.m27501b();	 Catch:{ IOException -> 0x0098, all -> 0x009f }
        L_0x0098:
            r8 = r0.m27451a();
            r7.f39858f = r8;
            goto L_0x00a7;
        L_0x009f:
            r8 = move-exception;
            r9 = r0.m27451a();
            r7.f39858f = r9;
            throw r8;
        L_0x00a7:
            r7.mo7295b();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            TypeTable typeTable = new TypeTable();
            f39855e = typeTable;
            typeTable.m40221i();
        }

        public final Parser<TypeTable> mo7112a() {
            return f39854b;
        }

        public final boolean m40227h() {
            return (this.f39859g & 1) == 1;
        }

        private void m40221i() {
            this.f39856c = Collections.emptyList();
            this.f39857d = -1;
        }

        public final boolean mo7303g() {
            byte b = this.f39860h;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < this.f39856c.size()) {
                if (((Type) this.f39856c.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f39860h = (byte) 0;
                    return false;
                }
            }
            this.f39860h = (byte) 1;
            return true;
        }

        public static Builder m40216a(TypeTable typeTable) {
            return new Builder().m40206a(typeTable);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m40206a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f39855e;
        }
    }

    public static final class Class extends ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> f40311c = new C27721();
        private static final Class f40312u;
        private int f40313A;
        int f40314d;
        public int f40315e;
        public int f40316f;
        public int f40317g;
        public List<TypeParameter> f40318h;
        public List<Type> f40319i;
        public List<Integer> f40320j;
        public List<Integer> f40321k;
        public List<Constructor> f40322l;
        public List<Function> f40323m;
        public List<Property> f40324n;
        public List<TypeAlias> f40325o;
        public List<EnumEntry> f40326p;
        public List<Integer> f40327q;
        public TypeTable f40328r;
        int f40329s;
        public SinceKotlinInfoTable f40330t;
        private final ByteString f40331v;
        private int f40332w;
        private int f40333x;
        private int f40334y;
        private byte f40335z;

        public enum Kind implements EnumLite {
            CLASS(0),
            INTERFACE(1),
            ENUM_CLASS(2),
            ENUM_ENTRY(3),
            ANNOTATION_CLASS(4),
            OBJECT(5),
            COMPANION_OBJECT(6);
            
            private static EnumLiteMap<Kind> f32979h;
            private final int f32981i;

            static class C25851 implements EnumLiteMap<Kind> {
                C25851() {
                }

                public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                    return Kind.m33510a(i);
                }
            }

            static {
                f32979h = new C25851();
            }

            public final int mo5922a() {
                return this.f32981i;
            }

            public static Kind m33510a(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return 0;
                }
            }

            private Kind(int i) {
                this.f32981i = i;
            }
        }

        static class C27721 extends AbstractParser<Class> {
            C27721() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int f40294c;
            private int f40295d = 6;
            private int f40296e;
            private int f40297f;
            private List<TypeParameter> f40298g = Collections.emptyList();
            private List<Type> f40299h = Collections.emptyList();
            private List<Integer> f40300i = Collections.emptyList();
            private List<Integer> f40301j = Collections.emptyList();
            private List<Constructor> f40302k = Collections.emptyList();
            private List<Function> f40303l = Collections.emptyList();
            private List<Property> f40304m = Collections.emptyList();
            private List<TypeAlias> f40305n = Collections.emptyList();
            private List<EnumEntry> f40306o = Collections.emptyList();
            private List<Integer> f40307p = Collections.emptyList();
            private TypeTable f40308q = TypeTable.m40220f();
            private int f40309r;
            private SinceKotlinInfoTable f40310s = SinceKotlinInfoTable.m40140f();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41523i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41521c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41523i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41521c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41523i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41523i();
            }

            private Builder() {
            }

            private Class m41524j() {
                int i = 0;
                Class classR = new Class((ExtendableBuilder) this);
                int i2 = this.f40294c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                classR.f40315e = this.f40295d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                classR.f40316f = this.f40296e;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                classR.f40317g = this.f40297f;
                if ((this.f40294c & 8) == 8) {
                    this.f40298g = Collections.unmodifiableList(this.f40298g);
                    this.f40294c &= -9;
                }
                classR.f40318h = this.f40298g;
                if ((this.f40294c & 16) == 16) {
                    this.f40299h = Collections.unmodifiableList(this.f40299h);
                    this.f40294c &= -17;
                }
                classR.f40319i = this.f40299h;
                if ((this.f40294c & 32) == 32) {
                    this.f40300i = Collections.unmodifiableList(this.f40300i);
                    this.f40294c &= -33;
                }
                classR.f40320j = this.f40300i;
                if ((this.f40294c & 64) == 64) {
                    this.f40301j = Collections.unmodifiableList(this.f40301j);
                    this.f40294c &= -65;
                }
                classR.f40321k = this.f40301j;
                if ((this.f40294c & 128) == 128) {
                    this.f40302k = Collections.unmodifiableList(this.f40302k);
                    this.f40294c &= -129;
                }
                classR.f40322l = this.f40302k;
                if ((this.f40294c & 256) == 256) {
                    this.f40303l = Collections.unmodifiableList(this.f40303l);
                    this.f40294c &= -257;
                }
                classR.f40323m = this.f40303l;
                if ((this.f40294c & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH) {
                    this.f40304m = Collections.unmodifiableList(this.f40304m);
                    this.f40294c &= -513;
                }
                classR.f40324n = this.f40304m;
                if ((this.f40294c & 1024) == 1024) {
                    this.f40305n = Collections.unmodifiableList(this.f40305n);
                    this.f40294c &= -1025;
                }
                classR.f40325o = this.f40305n;
                if ((this.f40294c & MPEGConst.CODE_END) == MPEGConst.CODE_END) {
                    this.f40306o = Collections.unmodifiableList(this.f40306o);
                    this.f40294c &= -2049;
                }
                classR.f40326p = this.f40306o;
                if ((this.f40294c & 4096) == 4096) {
                    this.f40307p = Collections.unmodifiableList(this.f40307p);
                    this.f40294c &= -4097;
                }
                classR.f40327q = this.f40307p;
                if ((i2 & 8192) == 8192) {
                    i |= 8;
                }
                classR.f40328r = this.f40308q;
                if ((i2 & 16384) == 16384) {
                    i |= 16;
                }
                classR.f40329s = this.f40309r;
                if ((i2 & 32768) == 32768) {
                    i |= 32;
                }
                classR.f40330t = this.f40310s;
                classR.f40314d = i;
                return classR;
            }

            public final Builder m41528a(Class classR) {
                if (classR == Class.m41556f()) {
                    return this;
                }
                int i = 1;
                if (((classR.f40314d & 1) == 1 ? 1 : 0) != 0) {
                    int i2 = classR.f40315e;
                    this.f40294c |= 1;
                    this.f40295d = i2;
                }
                if (classR.m41572h()) {
                    i2 = classR.f40316f;
                    this.f40294c |= 2;
                    this.f40296e = i2;
                }
                if (classR.m41573i()) {
                    i2 = classR.f40317g;
                    this.f40294c |= 4;
                    this.f40297f = i2;
                }
                if (!classR.f40318h.isEmpty()) {
                    if (this.f40298g.isEmpty()) {
                        this.f40298g = classR.f40318h;
                        this.f40294c &= -9;
                    } else {
                        if ((this.f40294c & 8) != 8) {
                            this.f40298g = new ArrayList(this.f40298g);
                            this.f40294c |= 8;
                        }
                        this.f40298g.addAll(classR.f40318h);
                    }
                }
                if (!classR.f40319i.isEmpty()) {
                    if (this.f40299h.isEmpty()) {
                        this.f40299h = classR.f40319i;
                        this.f40294c &= -17;
                    } else {
                        if ((this.f40294c & 16) != 16) {
                            this.f40299h = new ArrayList(this.f40299h);
                            this.f40294c |= 16;
                        }
                        this.f40299h.addAll(classR.f40319i);
                    }
                }
                if (!classR.f40320j.isEmpty()) {
                    if (this.f40300i.isEmpty()) {
                        this.f40300i = classR.f40320j;
                        this.f40294c &= -33;
                    } else {
                        if ((this.f40294c & 32) != 32) {
                            this.f40300i = new ArrayList(this.f40300i);
                            this.f40294c |= 32;
                        }
                        this.f40300i.addAll(classR.f40320j);
                    }
                }
                if (!classR.f40321k.isEmpty()) {
                    if (this.f40301j.isEmpty()) {
                        this.f40301j = classR.f40321k;
                        this.f40294c &= -65;
                    } else {
                        if ((this.f40294c & 64) != 64) {
                            this.f40301j = new ArrayList(this.f40301j);
                            this.f40294c |= 64;
                        }
                        this.f40301j.addAll(classR.f40321k);
                    }
                }
                if (!classR.f40322l.isEmpty()) {
                    if (this.f40302k.isEmpty()) {
                        this.f40302k = classR.f40322l;
                        this.f40294c &= -129;
                    } else {
                        if ((this.f40294c & 128) != 128) {
                            this.f40302k = new ArrayList(this.f40302k);
                            this.f40294c |= 128;
                        }
                        this.f40302k.addAll(classR.f40322l);
                    }
                }
                if (!classR.f40323m.isEmpty()) {
                    if (this.f40303l.isEmpty()) {
                        this.f40303l = classR.f40323m;
                        this.f40294c &= -257;
                    } else {
                        if ((this.f40294c & 256) != 256) {
                            this.f40303l = new ArrayList(this.f40303l);
                            this.f40294c |= 256;
                        }
                        this.f40303l.addAll(classR.f40323m);
                    }
                }
                if (!classR.f40324n.isEmpty()) {
                    if (this.f40304m.isEmpty()) {
                        this.f40304m = classR.f40324n;
                        this.f40294c &= -513;
                    } else {
                        if ((this.f40294c & AdRequest.MAX_CONTENT_URL_LENGTH) != AdRequest.MAX_CONTENT_URL_LENGTH) {
                            this.f40304m = new ArrayList(this.f40304m);
                            this.f40294c |= AdRequest.MAX_CONTENT_URL_LENGTH;
                        }
                        this.f40304m.addAll(classR.f40324n);
                    }
                }
                if (!classR.f40325o.isEmpty()) {
                    if (this.f40305n.isEmpty()) {
                        this.f40305n = classR.f40325o;
                        this.f40294c &= -1025;
                    } else {
                        if ((this.f40294c & 1024) != 1024) {
                            this.f40305n = new ArrayList(this.f40305n);
                            this.f40294c |= 1024;
                        }
                        this.f40305n.addAll(classR.f40325o);
                    }
                }
                if (!classR.f40326p.isEmpty()) {
                    if (this.f40306o.isEmpty()) {
                        this.f40306o = classR.f40326p;
                        this.f40294c &= -2049;
                    } else {
                        if ((this.f40294c & MPEGConst.CODE_END) != MPEGConst.CODE_END) {
                            this.f40306o = new ArrayList(this.f40306o);
                            this.f40294c |= MPEGConst.CODE_END;
                        }
                        this.f40306o.addAll(classR.f40326p);
                    }
                }
                if (!classR.f40327q.isEmpty()) {
                    if (this.f40307p.isEmpty()) {
                        this.f40307p = classR.f40327q;
                        this.f40294c &= -4097;
                    } else {
                        if ((this.f40294c & 4096) != 4096) {
                            this.f40307p = new ArrayList(this.f40307p);
                            this.f40294c |= 4096;
                        }
                        this.f40307p.addAll(classR.f40327q);
                    }
                }
                if (classR.m41574j()) {
                    TypeTable typeTable = classR.f40328r;
                    if ((this.f40294c & 8192) != 8192 || this.f40308q == TypeTable.m40220f()) {
                        this.f40308q = typeTable;
                    } else {
                        this.f40308q = TypeTable.m40216a(this.f40308q).m40206a(typeTable).m40211e();
                    }
                    this.f40294c |= 8192;
                }
                if (((classR.f40314d & 16) == 16 ? 1 : 0) != 0) {
                    i2 = classR.f40329s;
                    this.f40294c |= 16384;
                    this.f40309r = i2;
                }
                if ((classR.f40314d & 32) != 32) {
                    i = 0;
                }
                if (i != 0) {
                    SinceKotlinInfoTable sinceKotlinInfoTable = classR.f40330t;
                    if ((this.f40294c & 32768) != 32768 || this.f40310s == SinceKotlinInfoTable.m40140f()) {
                        this.f40310s = sinceKotlinInfoTable;
                    } else {
                        this.f40310s = SinceKotlinInfoTable.m40137a(this.f40310s).m40128a(sinceKotlinInfoTable).m40133e();
                    }
                    this.f40294c |= 32768;
                }
                m39924a((ExtendableMessage) classR);
                this.f38788a = this.f38788a.m27460a(classR.f40331v);
                return this;
            }

            private Builder m41521c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Class classR;
                Class classR2 = null;
                try {
                    m41528a((Class) Class.f40311c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    classR = (Class) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    classR2 = classR;
                }
                if (classR2 != null) {
                    m41528a(classR2);
                }
                throw codedInputStream2;
            }

            private Builder m41523i() {
                return new Builder().m41528a(m41524j());
            }

            public final boolean mo7303g() {
                if (!((this.f40294c & 2) == 2)) {
                    return false;
                }
                int i;
                for (i = 0; i < this.f40298g.size(); i++) {
                    if (!((TypeParameter) this.f40298g.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40299h.size(); i++) {
                    if (!((Type) this.f40299h.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40302k.size(); i++) {
                    if (!((Constructor) this.f40302k.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40303l.size(); i++) {
                    if (!((Function) this.f40303l.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40304m.size(); i++) {
                    if (!((Property) this.f40304m.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40305n.size(); i++) {
                    if (!((TypeAlias) this.f40305n.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40306o.size(); i++) {
                    if (!((EnumEntry) this.f40306o.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return (!((this.f40294c & 8192) == 8192) || this.f40308q.mo7303g()) && this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return Class.m41556f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return Class.m41556f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41524j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private Class(ExtendableBuilder<Class, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40332w = -1;
            this.f40333x = -1;
            this.f40334y = -1;
            this.f40335z = (byte) -1;
            this.f40313A = -1;
            this.f40331v = extendableBuilder.f38788a;
        }

        private Class() {
            this.f40332w = -1;
            this.f40333x = -1;
            this.f40334y = -1;
            this.f40335z = (byte) -1;
            this.f40313A = -1;
            this.f40331v = ByteString.f25891b;
        }

        public static Class m41556f() {
            return f40312u;
        }

        private Class(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r19, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r20) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r18 = this;
            r1 = r18;
            r2 = r19;
            r3 = r20;
            r18.<init>();
            r4 = -1;
            r1.f40332w = r4;
            r1.f40333x = r4;
            r1.f40334y = r4;
            r1.f40335z = r4;
            r1.f40313A = r4;
            r18.m41566k();
            r4 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r5 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r4);
            r6 = 0;
            r8 = r6;
        L_0x0021:
            r12 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r13 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
            r14 = 16;
            r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r15 = 8;
            r9 = 32;
            if (r6 != 0) goto L_0x0337;
        L_0x002f:
            r10 = r19.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r16 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            switch(r10) {
                case 0: goto L_0x0280;
                case 8: goto L_0x0272;
                case 16: goto L_0x0254;
                case 18: goto L_0x021e;
                case 24: goto L_0x0210;
                case 32: goto L_0x0202;
                case 42: goto L_0x01e8;
                case 50: goto L_0x01ce;
                case 56: goto L_0x01b0;
                case 58: goto L_0x017a;
                case 66: goto L_0x015e;
                case 74: goto L_0x0142;
                case 82: goto L_0x0126;
                case 90: goto L_0x010c;
                case 106: goto L_0x00f2;
                case 128: goto L_0x00d6;
                case 130: goto L_0x00a0;
                case 242: goto L_0x0076;
                case 248: goto L_0x006a;
                case 258: goto L_0x003f;
                default: goto L_0x0038;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0038:
            r11 = 1;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r1.mo7294a(r2, r5, r3, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0284;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x003f:
            r10 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10 & r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 != r9) goto L_0x004a;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0044:
            r10 = r1.f40330t;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r16 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable.m40137a(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x004a:
            r10 = r16;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable.f39824b;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = r2.m27483a(r11, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable) r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40330t = r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 == 0) goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0058:
            r11 = r1.f40330t;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.m40128a(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10.m40133e();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40330t = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0063:
            r10 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10 | r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0068:
            r11 = 1;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x006a:
            r10 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10 | r14;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40329s = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0068;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0076:
            r10 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10 & r15;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 != r15) goto L_0x0081;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x007b:
            r10 = r1.f40328r;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r16 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.m40216a(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0081:
            r10 = r16;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.f39854b;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = r2.m27483a(r11, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable) r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40328r = r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 == 0) goto L_0x009a;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x008f:
            r11 = r1.f40328r;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.m40206a(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10.m40211e();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40328r = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x009a:
            r10 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r10 | r15;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0068;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00a0:
            r10 = r19.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27487b(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = r8 & 4096;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r11 == r7) goto L_0x00bb;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00ac:
            r11 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r11 <= 0) goto L_0x00bb;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00b2:
            r11 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40327q = r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 4096;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00bb:
            r11 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r11 <= 0) goto L_0x00d1;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00c1:
            r11 = r1.f40327q;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x00bb;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00d1:
            r2.m27488c(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00d6:
            r9 = r8 & 4096;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r7) goto L_0x00e3;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00da:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40327q = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 4096;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00e3:
            r9 = r1.f40327q;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00f2:
            r9 = r8 & 2048;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r13) goto L_0x00ff;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00f6:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40326p = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 2048;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x00ff:
            r9 = r1.f40326p;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry.f40351c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x010c:
            r9 = r8 & 1024;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r12) goto L_0x0119;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0110:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40325o = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 1024;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0119:
            r9 = r1.f40325o;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias.f40480c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0126:
            r9 = r8 & 512;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = 512; // 0x200 float:7.175E-43 double:2.53E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r10) goto L_0x0135;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x012c:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40324n = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 512;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0135:
            r9 = r1.f40324n;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property.f40417c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0142:
            r9 = r8 & 256;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r10) goto L_0x0151;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0148:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40323m = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 256;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0151:
            r9 = r1.f40323m;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function.f40370c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x015e:
            r9 = r8 & 128;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r10) goto L_0x016d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0164:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40322l = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 128;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x016d:
            r9 = r1.f40322l;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor.f40340c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x017a:
            r9 = r19.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r2.m27487b(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r8 & 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 == r11) goto L_0x0197;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0188:
            r10 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 <= 0) goto L_0x0197;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x018e:
            r10 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40321k = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0197:
            r10 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 <= 0) goto L_0x01ab;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x019d:
            r10 = r1.f40321k;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.add(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0197;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01ab:
            r2.m27488c(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01b0:
            r9 = r8 & 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r10) goto L_0x01bf;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01b6:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40321k = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01bf:
            r9 = r1.f40321k;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01ce:
            r9 = r8 & 16;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r14) goto L_0x01db;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01d2:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40319i = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01db:
            r9 = r1.f40319i;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01e8:
            r9 = r8 & 8;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r15) goto L_0x01f5;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01ec:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40318h = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 8;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x01f5:
            r9 = r1.f40318h;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.f40502c;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r2.m27483a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0202:
            r9 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r9 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40317g = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0068;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0210:
            r9 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r9 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40316f = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0068;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x021e:
            r9 = r19.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r2.m27487b(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r8 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 == r11) goto L_0x023b;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x022c:
            r10 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 <= 0) goto L_0x023b;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0232:
            r10 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40320j = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x023b:
            r10 = r19.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r10 <= 0) goto L_0x024f;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0241:
            r10 = r1.f40320j;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10.add(r11);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x023b;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x024f:
            r2.m27488c(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0254:
            r9 = r8 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            if (r9 == r10) goto L_0x0263;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x025a:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40320j = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r8 = r8 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0263:
            r9 = r1.f40320j;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = r19.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
        L_0x0272:
            r9 = r1.f40314d;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r11 = 1;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r9 | r11;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40314d = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r9 = r19.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            r1.f40315e = r9;	 Catch:{ InvalidProtocolBufferException -> 0x0298, IOException -> 0x028a }
            goto L_0x0021;
        L_0x0280:
            r11 = 1;
        L_0x0281:
            r6 = r11;
            goto L_0x0021;
        L_0x0284:
            if (r9 != 0) goto L_0x0021;
        L_0x0286:
            goto L_0x0281;
        L_0x0287:
            r0 = move-exception;
            r2 = r0;
            goto L_0x029d;
        L_0x028a:
            r0 = move-exception;
            r2 = r0;
            r3 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0287 }
            r2 = r2.getMessage();	 Catch:{ all -> 0x0287 }
            r3.<init>(r2);	 Catch:{ all -> 0x0287 }
            r3.f25930a = r1;	 Catch:{ all -> 0x0287 }
            throw r3;	 Catch:{ all -> 0x0287 }
        L_0x0298:
            r0 = move-exception;	 Catch:{ all -> 0x0287 }
            r2 = r0;	 Catch:{ all -> 0x0287 }
            r2.f25930a = r1;	 Catch:{ all -> 0x0287 }
            throw r2;	 Catch:{ all -> 0x0287 }
        L_0x029d:
            r3 = r8 & 32;
            r6 = 32;
            if (r3 != r6) goto L_0x02ab;
        L_0x02a3:
            r3 = r1.f40320j;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40320j = r3;
        L_0x02ab:
            r3 = r8 & 8;
            if (r3 != r15) goto L_0x02b7;
        L_0x02af:
            r3 = r1.f40318h;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40318h = r3;
        L_0x02b7:
            r3 = r8 & 16;
            if (r3 != r14) goto L_0x02c3;
        L_0x02bb:
            r3 = r1.f40319i;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40319i = r3;
        L_0x02c3:
            r3 = r8 & 64;
            r6 = 64;
            if (r3 != r6) goto L_0x02d1;
        L_0x02c9:
            r3 = r1.f40321k;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40321k = r3;
        L_0x02d1:
            r3 = r8 & 128;
            r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r3 != r6) goto L_0x02df;
        L_0x02d7:
            r3 = r1.f40322l;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40322l = r3;
        L_0x02df:
            r3 = r8 & 256;
            r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r3 != r6) goto L_0x02ed;
        L_0x02e5:
            r3 = r1.f40323m;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40323m = r3;
        L_0x02ed:
            r3 = r8 & 512;
            r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r3 != r6) goto L_0x02fb;
        L_0x02f3:
            r3 = r1.f40324n;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40324n = r3;
        L_0x02fb:
            r3 = r8 & 1024;
            if (r3 != r12) goto L_0x0307;
        L_0x02ff:
            r3 = r1.f40325o;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40325o = r3;
        L_0x0307:
            r3 = r8 & 2048;
            if (r3 != r13) goto L_0x0313;
        L_0x030b:
            r3 = r1.f40326p;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40326p = r3;
        L_0x0313:
            r3 = r8 & 4096;
            if (r3 != r7) goto L_0x031f;
        L_0x0317:
            r3 = r1.f40327q;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.f40327q = r3;
        L_0x031f:
            r5.m27501b();	 Catch:{ IOException -> 0x0322, all -> 0x0329 }
        L_0x0322:
            r3 = r4.m27451a();
            r1.f40331v = r3;
            goto L_0x0331;
        L_0x0329:
            r0 = move-exception;
            r2 = r4.m27451a();
            r1.f40331v = r2;
            throw r0;
        L_0x0331:
            r3 = r1.f39732b;
            r3.m27521c();
            throw r2;
        L_0x0337:
            r2 = r8 & 32;
            r3 = 32;
            if (r2 != r3) goto L_0x0345;
        L_0x033d:
            r2 = r1.f40320j;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40320j = r2;
        L_0x0345:
            r2 = r8 & 8;
            if (r2 != r15) goto L_0x0351;
        L_0x0349:
            r2 = r1.f40318h;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40318h = r2;
        L_0x0351:
            r2 = r8 & 16;
            if (r2 != r14) goto L_0x035d;
        L_0x0355:
            r2 = r1.f40319i;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40319i = r2;
        L_0x035d:
            r2 = r8 & 64;
            r3 = 64;
            if (r2 != r3) goto L_0x036b;
        L_0x0363:
            r2 = r1.f40321k;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40321k = r2;
        L_0x036b:
            r2 = r8 & 128;
            r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r2 != r3) goto L_0x0379;
        L_0x0371:
            r2 = r1.f40322l;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40322l = r2;
        L_0x0379:
            r2 = r8 & 256;
            r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r2 != r3) goto L_0x0387;
        L_0x037f:
            r2 = r1.f40323m;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40323m = r2;
        L_0x0387:
            r2 = r8 & 512;
            r3 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r2 != r3) goto L_0x0395;
        L_0x038d:
            r2 = r1.f40324n;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40324n = r2;
        L_0x0395:
            r2 = r8 & 1024;
            if (r2 != r12) goto L_0x03a1;
        L_0x0399:
            r2 = r1.f40325o;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40325o = r2;
        L_0x03a1:
            r2 = r8 & 2048;
            if (r2 != r13) goto L_0x03ad;
        L_0x03a5:
            r2 = r1.f40326p;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40326p = r2;
        L_0x03ad:
            r2 = r8 & 4096;
            if (r2 != r7) goto L_0x03b9;
        L_0x03b1:
            r2 = r1.f40327q;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.f40327q = r2;
        L_0x03b9:
            r5.m27501b();	 Catch:{ IOException -> 0x03bc, all -> 0x03c3 }
        L_0x03bc:
            r2 = r4.m27451a();
            r1.f40331v = r2;
            goto L_0x03cb;
        L_0x03c3:
            r0 = move-exception;
            r2 = r4.m27451a();
            r1.f40331v = r2;
            throw r0;
        L_0x03cb:
            r2 = r1.f39732b;
            r2.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Class classR = new Class();
            f40312u = classR;
            classR.m41566k();
        }

        public final Parser<Class> mo7112a() {
            return f40311c;
        }

        public final boolean m41572h() {
            return (this.f40314d & 2) == 2;
        }

        public final boolean m41573i() {
            return (this.f40314d & 4) == 4;
        }

        public final boolean m41574j() {
            return (this.f40314d & 8) == 8;
        }

        private void m41566k() {
            this.f40315e = 6;
            this.f40316f = 0;
            this.f40317g = 0;
            this.f40318h = Collections.emptyList();
            this.f40319i = Collections.emptyList();
            this.f40320j = Collections.emptyList();
            this.f40321k = Collections.emptyList();
            this.f40322l = Collections.emptyList();
            this.f40323m = Collections.emptyList();
            this.f40324n = Collections.emptyList();
            this.f40325o = Collections.emptyList();
            this.f40326p = Collections.emptyList();
            this.f40327q = Collections.emptyList();
            this.f40328r = TypeTable.m40220f();
            this.f40329s = 0;
            this.f40330t = SinceKotlinInfoTable.m40140f();
        }

        public final boolean mo7303g() {
            byte b = this.f40335z;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (m41572h()) {
                int i = 0;
                while (i < this.f40318h.size()) {
                    if (((TypeParameter) this.f40318h.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40319i.size()) {
                    if (((Type) this.f40319i.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40322l.size()) {
                    if (((Constructor) this.f40322l.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40323m.size()) {
                    if (((Function) this.f40323m.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40324n.size()) {
                    if (((Property) this.f40324n.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40325o.size()) {
                    if (((TypeAlias) this.f40325o.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < this.f40326p.size()) {
                    if (((EnumEntry) this.f40326p.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40335z = (byte) 0;
                        return false;
                    }
                }
                if (m41574j() && !this.f40328r.mo7303g()) {
                    this.f40335z = (byte) 0;
                    return false;
                } else if (this.f39732b.m27523e()) {
                    this.f40335z = (byte) 1;
                    return true;
                } else {
                    this.f40335z = (byte) 0;
                    return false;
                }
            }
            this.f40335z = (byte) 0;
            return false;
        }

        public static Class m41539a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Class) f40311c.mo5862b(inputStream, extensionRegistryLite);
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40312u;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41528a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class Constructor extends ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> f40340c = new C27731();
        private static final Constructor f40341h;
        int f40342d;
        public int f40343e;
        public List<ValueParameter> f40344f;
        int f40345g;
        private final ByteString f40346i;
        private byte f40347j;
        private int f40348k;

        static class C27731 extends AbstractParser<Constructor> {
            C27731() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int f40336c;
            private int f40337d = 6;
            private List<ValueParameter> f40338e = Collections.emptyList();
            private int f40339f;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41577i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41575c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41577i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41575c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41577i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41577i();
            }

            private Builder() {
            }

            private Constructor m41578j() {
                int i = 0;
                Constructor constructor = new Constructor((ExtendableBuilder) this);
                int i2 = this.f40336c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                constructor.f40343e = this.f40337d;
                if ((this.f40336c & 2) == 2) {
                    this.f40338e = Collections.unmodifiableList(this.f40338e);
                    this.f40336c &= -3;
                }
                constructor.f40344f = this.f40338e;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                constructor.f40345g = this.f40339f;
                constructor.f40342d = i;
                return constructor;
            }

            public final Builder m41582a(Constructor constructor) {
                if (constructor == Constructor.m41596f()) {
                    return this;
                }
                int i = 1;
                if (((constructor.f40342d & 1) == 1 ? 1 : 0) != 0) {
                    int i2 = constructor.f40343e;
                    this.f40336c |= 1;
                    this.f40337d = i2;
                }
                if (!constructor.f40344f.isEmpty()) {
                    if (this.f40338e.isEmpty()) {
                        this.f40338e = constructor.f40344f;
                        this.f40336c &= -3;
                    } else {
                        if ((this.f40336c & 2) != 2) {
                            this.f40338e = new ArrayList(this.f40338e);
                            this.f40336c |= 2;
                        }
                        this.f40338e.addAll(constructor.f40344f);
                    }
                }
                if ((constructor.f40342d & 2) != 2) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = constructor.f40345g;
                    this.f40336c |= 4;
                    this.f40339f = i2;
                }
                m39924a((ExtendableMessage) constructor);
                this.f38788a = this.f38788a.m27460a(constructor.f40346i);
                return this;
            }

            private Builder m41575c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Constructor constructor;
                Constructor constructor2 = null;
                try {
                    m41582a((Constructor) Constructor.f40340c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    constructor = (Constructor) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    constructor2 = constructor;
                }
                if (constructor2 != null) {
                    m41582a(constructor2);
                }
                throw codedInputStream2;
            }

            private Builder m41577i() {
                return new Builder().m41582a(m41578j());
            }

            public final boolean mo7303g() {
                for (int i = 0; i < this.f40338e.size(); i++) {
                    if (!((ValueParameter) this.f40338e.get(i)).mo7303g()) {
                        return false;
                    }
                }
                if (this.f39730b.m27523e()) {
                    return true;
                }
                return false;
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return Constructor.m41596f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return Constructor.m41596f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41578j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private Constructor(ExtendableBuilder<Constructor, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40347j = (byte) -1;
            this.f40348k = -1;
            this.f40346i = extendableBuilder.f38788a;
        }

        private Constructor() {
            this.f40347j = (byte) -1;
            this.f40348k = -1;
            this.f40346i = ByteString.f25891b;
        }

        public static Constructor m41596f() {
            return f40341h;
        }

        private Constructor(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.<init>();
            r0 = -1;
            r8.f40347j = r0;
            r8.f40348k = r0;
            r8.m41597h();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 2;
            if (r2 != 0) goto L_0x009c;
        L_0x0019:
            r6 = r9.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 == 0) goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x001f:
            r7 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 == r7) goto L_0x0057;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0023:
            r7 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 == r7) goto L_0x003e;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0027:
            r7 = 248; // 0xf8 float:3.48E-43 double:1.225E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 == r7) goto L_0x0032;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x002b:
            r6 = r8.mo7294a(r9, r1, r10, r6);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0031:
            goto L_0x0063;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0032:
            r6 = r8.f40342d;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6 = r6 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r8.f40342d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r8.f40345g = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x003e:
            r6 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            if (r6 == r5) goto L_0x004b;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0042:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r8.f40344f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x004b:
            r6 = r8.f40344f;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter.f40521c;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r7 = r9.m27483a(r7, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
        L_0x0057:
            r6 = r8.f40342d;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6 = r6 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r8.f40342d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r6 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            r8.f40343e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0074, IOException -> 0x0067 }
            goto L_0x0016;
        L_0x0063:
            r2 = r3;
            goto L_0x0016;
        L_0x0065:
            r9 = move-exception;
            goto L_0x0078;
        L_0x0067:
            r9 = move-exception;
            r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0065 }
            r9 = r9.getMessage();	 Catch:{ all -> 0x0065 }
            r10.<init>(r9);	 Catch:{ all -> 0x0065 }
            r10.f25930a = r8;	 Catch:{ all -> 0x0065 }
            throw r10;	 Catch:{ all -> 0x0065 }
        L_0x0074:
            r9 = move-exception;	 Catch:{ all -> 0x0065 }
            r9.f25930a = r8;	 Catch:{ all -> 0x0065 }
            throw r9;	 Catch:{ all -> 0x0065 }
        L_0x0078:
            r10 = r4 & 2;
            if (r10 != r5) goto L_0x0084;
        L_0x007c:
            r10 = r8.f40344f;
            r10 = java.util.Collections.unmodifiableList(r10);
            r8.f40344f = r10;
        L_0x0084:
            r1.m27501b();	 Catch:{ IOException -> 0x0087, all -> 0x008e }
        L_0x0087:
            r10 = r0.m27451a();
            r8.f40346i = r10;
            goto L_0x0096;
        L_0x008e:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f40346i = r10;
            throw r9;
        L_0x0096:
            r10 = r8.f39732b;
            r10.m27521c();
            throw r9;
        L_0x009c:
            r9 = r4 & 2;
            if (r9 != r5) goto L_0x00a8;
        L_0x00a0:
            r9 = r8.f40344f;
            r9 = java.util.Collections.unmodifiableList(r9);
            r8.f40344f = r9;
        L_0x00a8:
            r1.m27501b();	 Catch:{ IOException -> 0x00ab, all -> 0x00b2 }
        L_0x00ab:
            r9 = r0.m27451a();
            r8.f40346i = r9;
            goto L_0x00ba;
        L_0x00b2:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f40346i = r10;
            throw r9;
        L_0x00ba:
            r9 = r8.f39732b;
            r9.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Constructor constructor = new Constructor();
            f40341h = constructor;
            constructor.m41597h();
        }

        public final Parser<Constructor> mo7112a() {
            return f40340c;
        }

        private void m41597h() {
            this.f40343e = 6;
            this.f40344f = Collections.emptyList();
            this.f40345g = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f40347j;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < this.f40344f.size()) {
                if (((ValueParameter) this.f40344f.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f40347j = (byte) 0;
                    return false;
                }
            }
            if (this.f39732b.m27523e()) {
                this.f40347j = (byte) 1;
                return true;
            }
            this.f40347j = (byte) 0;
            return false;
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40341h;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41582a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class EnumEntry extends ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> f40351c = new C27741();
        private static final EnumEntry f40352f;
        int f40353d;
        public int f40354e;
        private final ByteString f40355g;
        private byte f40356h;
        private int f40357i;

        static class C27741 extends AbstractParser<EnumEntry> {
            C27741() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int f40349c;
            private int f40350d;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41605i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41603c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41605i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41603c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41605i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41605i();
            }

            private Builder() {
            }

            private EnumEntry m41606j() {
                int i = 0;
                EnumEntry enumEntry = new EnumEntry((ExtendableBuilder) this);
                if ((this.f40349c & 1) == 1) {
                    i = 1;
                }
                enumEntry.f40354e = this.f40350d;
                enumEntry.f40353d = i;
                return enumEntry;
            }

            public final Builder m41610a(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.m41621f()) {
                    return this;
                }
                if (((enumEntry.f40353d & 1) == 1 ? 1 : 0) != 0) {
                    int i = enumEntry.f40354e;
                    this.f40349c = 1 | this.f40349c;
                    this.f40350d = i;
                }
                m39924a((ExtendableMessage) enumEntry);
                this.f38788a = this.f38788a.m27460a(enumEntry.f40355g);
                return this;
            }

            private Builder m41603c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                EnumEntry enumEntry;
                EnumEntry enumEntry2 = null;
                try {
                    m41610a((EnumEntry) EnumEntry.f40351c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    enumEntry = (EnumEntry) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    enumEntry2 = enumEntry;
                }
                if (enumEntry2 != null) {
                    m41610a(enumEntry2);
                }
                throw codedInputStream2;
            }

            private Builder m41605i() {
                return new Builder().m41610a(m41606j());
            }

            public final boolean mo7303g() {
                return this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return EnumEntry.m41621f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return EnumEntry.m41621f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41606j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private EnumEntry(ExtendableBuilder<EnumEntry, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40356h = (byte) -1;
            this.f40357i = -1;
            this.f40355g = extendableBuilder.f38788a;
        }

        private EnumEntry() {
            this.f40356h = (byte) -1;
            this.f40357i = -1;
            this.f40355g = ByteString.f25891b;
        }

        public static EnumEntry m41621f() {
            return f40352f;
        }

        private EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r8) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = -1;
            r6.f40356h = r0;
            r6.f40357i = r0;
            r0 = 0;
            r6.f40354e = r0;
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r1);
            r3 = 1;
        L_0x0014:
            if (r0 != 0) goto L_0x0060;
        L_0x0016:
            r4 = r7.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            if (r4 == 0) goto L_0x0033;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
        L_0x001c:
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            if (r4 == r5) goto L_0x0027;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
        L_0x0020:
            r4 = r6.mo7294a(r7, r2, r8, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            if (r4 != 0) goto L_0x0014;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
        L_0x0026:
            goto L_0x0033;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
        L_0x0027:
            r4 = r6.f40353d;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            r6.f40353d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            r4 = r7.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            r6.f40354e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0044, IOException -> 0x0037 }
            goto L_0x0014;
        L_0x0033:
            r0 = r3;
            goto L_0x0014;
        L_0x0035:
            r7 = move-exception;
            goto L_0x0048;
        L_0x0037:
            r7 = move-exception;
            r8 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0035 }
            r7 = r7.getMessage();	 Catch:{ all -> 0x0035 }
            r8.<init>(r7);	 Catch:{ all -> 0x0035 }
            r8.f25930a = r6;	 Catch:{ all -> 0x0035 }
            throw r8;	 Catch:{ all -> 0x0035 }
        L_0x0044:
            r7 = move-exception;	 Catch:{ all -> 0x0035 }
            r7.f25930a = r6;	 Catch:{ all -> 0x0035 }
            throw r7;	 Catch:{ all -> 0x0035 }
        L_0x0048:
            r2.m27501b();	 Catch:{ IOException -> 0x004b, all -> 0x0052 }
        L_0x004b:
            r8 = r1.m27451a();
            r6.f40355g = r8;
            goto L_0x005a;
        L_0x0052:
            r7 = move-exception;
            r8 = r1.m27451a();
            r6.f40355g = r8;
            throw r7;
        L_0x005a:
            r8 = r6.f39732b;
            r8.m27521c();
            throw r7;
        L_0x0060:
            r2.m27501b();	 Catch:{ IOException -> 0x0063, all -> 0x006a }
        L_0x0063:
            r7 = r1.m27451a();
            r6.f40355g = r7;
            goto L_0x0072;
        L_0x006a:
            r7 = move-exception;
            r8 = r1.m27451a();
            r6.f40355g = r8;
            throw r7;
        L_0x0072:
            r7 = r6.f39732b;
            r7.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            EnumEntry enumEntry = new EnumEntry();
            f40352f = enumEntry;
            enumEntry.f40354e = 0;
        }

        public final Parser<EnumEntry> mo7112a() {
            return f40351c;
        }

        public final boolean mo7303g() {
            byte b = this.f40356h;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (this.f39732b.m27523e()) {
                this.f40356h = (byte) 1;
                return true;
            }
            this.f40356h = (byte) 0;
            return false;
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40352f;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41610a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class Function extends ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> f40370c = new C27751();
        private static final Function f40371p;
        int f40372d;
        public int f40373e;
        public int f40374f;
        public int f40375g;
        public Type f40376h;
        public int f40377i;
        public List<TypeParameter> f40378j;
        public Type f40379k;
        public int f40380l;
        public List<ValueParameter> f40381m;
        public TypeTable f40382n;
        int f40383o;
        private final ByteString f40384q;
        private byte f40385r;
        private int f40386s;

        static class C27751 extends AbstractParser<Function> {
            C27751() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int f40358c;
            private int f40359d = 6;
            private int f40360e = 6;
            private int f40361f;
            private Type f40362g = Type.m41783f();
            private int f40363h;
            private List<TypeParameter> f40364i = Collections.emptyList();
            private Type f40365j = Type.m41783f();
            private int f40366k;
            private List<ValueParameter> f40367l = Collections.emptyList();
            private TypeTable f40368m = TypeTable.m40220f();
            private int f40369n;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41629i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41627c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41629i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41627c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41629i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41629i();
            }

            private Builder() {
            }

            private Function m41630j() {
                int i = 0;
                Function function = new Function((ExtendableBuilder) this);
                int i2 = this.f40358c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                function.f40373e = this.f40359d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                function.f40374f = this.f40360e;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                function.f40375g = this.f40361f;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                function.f40376h = this.f40362g;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                function.f40377i = this.f40363h;
                if ((this.f40358c & 32) == 32) {
                    this.f40364i = Collections.unmodifiableList(this.f40364i);
                    this.f40358c &= -33;
                }
                function.f40378j = this.f40364i;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                function.f40379k = this.f40365j;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                function.f40380l = this.f40366k;
                if ((this.f40358c & 256) == 256) {
                    this.f40367l = Collections.unmodifiableList(this.f40367l);
                    this.f40358c &= -257;
                }
                function.f40381m = this.f40367l;
                if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH) {
                    i |= 128;
                }
                function.f40382n = this.f40368m;
                if ((i2 & 1024) == 1024) {
                    i |= 256;
                }
                function.f40383o = this.f40369n;
                function.f40372d = i;
                return function;
            }

            public final Builder m41634a(Function function) {
                if (function == Function.m41657f()) {
                    return this;
                }
                Type type;
                int i = 1;
                if (function.m41665h()) {
                    int i2 = function.f40373e;
                    this.f40358c |= 1;
                    this.f40359d = i2;
                }
                if (((function.f40372d & 2) == 2 ? 1 : 0) != 0) {
                    i2 = function.f40374f;
                    this.f40358c = 2 | this.f40358c;
                    this.f40360e = i2;
                }
                if (function.m41666i()) {
                    i2 = function.f40375g;
                    this.f40358c |= 4;
                    this.f40361f = i2;
                }
                if (function.m41667j()) {
                    type = function.f40376h;
                    if ((this.f40358c & 8) != 8 || this.f40362g == Type.m41783f()) {
                        this.f40362g = type;
                    } else {
                        this.f40362g = Type.m41771a(this.f40362g).m41758a(type).m41768i();
                    }
                    this.f40358c |= 8;
                }
                if (((function.f40372d & 16) == 16 ? 1 : 0) != 0) {
                    i2 = function.f40377i;
                    this.f40358c = 16 | this.f40358c;
                    this.f40363h = i2;
                }
                if (!function.f40378j.isEmpty()) {
                    if (this.f40364i.isEmpty()) {
                        this.f40364i = function.f40378j;
                        this.f40358c &= -33;
                    } else {
                        if ((this.f40358c & 32) != 32) {
                            this.f40364i = new ArrayList(this.f40364i);
                            this.f40358c |= 32;
                        }
                        this.f40364i.addAll(function.f40378j);
                    }
                }
                if (function.m41668k()) {
                    type = function.f40379k;
                    if ((this.f40358c & 64) != 64 || this.f40365j == Type.m41783f()) {
                        this.f40365j = type;
                    } else {
                        this.f40365j = Type.m41771a(this.f40365j).m41758a(type).m41768i();
                    }
                    this.f40358c |= 64;
                }
                if (function.m41669l()) {
                    i2 = function.f40380l;
                    this.f40358c |= 128;
                    this.f40366k = i2;
                }
                if (!function.f40381m.isEmpty()) {
                    if (this.f40367l.isEmpty()) {
                        this.f40367l = function.f40381m;
                        this.f40358c &= -257;
                    } else {
                        if ((this.f40358c & 256) != 256) {
                            this.f40367l = new ArrayList(this.f40367l);
                            this.f40358c |= 256;
                        }
                        this.f40367l.addAll(function.f40381m);
                    }
                }
                if (function.m41670m()) {
                    TypeTable typeTable = function.f40382n;
                    if ((this.f40358c & AdRequest.MAX_CONTENT_URL_LENGTH) != AdRequest.MAX_CONTENT_URL_LENGTH || this.f40368m == TypeTable.m40220f()) {
                        this.f40368m = typeTable;
                    } else {
                        this.f40368m = TypeTable.m40216a(this.f40368m).m40206a(typeTable).m40211e();
                    }
                    this.f40358c |= AdRequest.MAX_CONTENT_URL_LENGTH;
                }
                if ((function.f40372d & 256) != 256) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = function.f40383o;
                    this.f40358c |= 1024;
                    this.f40369n = i2;
                }
                m39924a((ExtendableMessage) function);
                this.f38788a = this.f38788a.m27460a(function.f40384q);
                return this;
            }

            private Builder m41627c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Function function;
                Function function2 = null;
                try {
                    m41634a((Function) Function.f40370c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    function = (Function) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    function2 = function;
                }
                if (function2 != null) {
                    m41634a(function2);
                }
                throw codedInputStream2;
            }

            private Builder m41629i() {
                return new Builder().m41634a(m41630j());
            }

            public final boolean mo7303g() {
                if (!((this.f40358c & 4) == 4)) {
                    return false;
                }
                if (((this.f40358c & 8) == 8) && !this.f40362g.mo7303g()) {
                    return false;
                }
                int i;
                for (i = 0; i < this.f40364i.size(); i++) {
                    if (!((TypeParameter) this.f40364i.get(i)).mo7303g()) {
                        return false;
                    }
                }
                if (((this.f40358c & 64) == 64) && !this.f40365j.mo7303g()) {
                    return false;
                }
                for (i = 0; i < this.f40367l.size(); i++) {
                    if (!((ValueParameter) this.f40367l.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return (!((this.f40358c & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH) || this.f40368m.mo7303g()) && this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return Function.m41657f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return Function.m41657f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41630j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private Function(ExtendableBuilder<Function, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40385r = (byte) -1;
            this.f40386s = -1;
            this.f40384q = extendableBuilder.f38788a;
        }

        private Function() {
            this.f40385r = (byte) -1;
            this.f40386s = -1;
            this.f40384q = ByteString.f25891b;
        }

        public static Function m41657f() {
            return f40371p;
        }

        private Function(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r10.<init>();
            r0 = -1;
            r10.f40385r = r0;
            r10.f40386s = r0;
            r10.m41659n();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            r6 = 32;
            if (r2 != 0) goto L_0x0173;
        L_0x001c:
            r7 = r11.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            switch(r7) {
                case 0: goto L_0x012a;
                case 8: goto L_0x011c;
                case 16: goto L_0x010e;
                case 26: goto L_0x00e3;
                case 34: goto L_0x00c9;
                case 42: goto L_0x00a0;
                case 50: goto L_0x0086;
                case 56: goto L_0x0079;
                case 64: goto L_0x006c;
                case 72: goto L_0x0060;
                case 242: goto L_0x0036;
                case 248: goto L_0x002a;
                default: goto L_0x0024;
            };	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0024:
            r7 = r10.mo7294a(r11, r1, r12, r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x012d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x002a:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40383o = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0036:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 & r9;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 != r9) goto L_0x0043;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x003d:
            r7 = r10.f40382n;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.m40216a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0043:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.f39854b;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable) r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40382n = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r8 == 0) goto L_0x005a;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x004f:
            r7 = r10.f40382n;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8.m40206a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r8.m40211e();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40382n = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x005a:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | r9;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0060:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40373e = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x006c:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40380l = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0079:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40377i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0086:
            r7 = r4 & 256;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 == r5) goto L_0x0093;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x008a:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40381m = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r4 = r4 | 256;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0093:
            r7 = r10.f40381m;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter.f40521c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = r11.m27483a(r8, r12);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00a0:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 != r6) goto L_0x00ab;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00a5:
            r7 = r10.f40379k;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00ab:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40379k = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r8 == 0) goto L_0x00c2;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00b7:
            r7 = r10.f40379k;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8.m41758a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r8.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40379k = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00c2:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00c9:
            r7 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 == r6) goto L_0x00d6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00cd:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40378j = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00d6:
            r7 = r10.f40378j;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.f40502c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = r11.m27483a(r8, r12);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00e3:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 & r9;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 != r9) goto L_0x00f0;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00ea:
            r7 = r10.f40376h;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00f0:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40376h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r8 == 0) goto L_0x0107;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00fc:
            r7 = r10.f40376h;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8.m41758a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r8.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40376h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0107:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | r9;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x010e:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40375g = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x011c:
            r7 = r10.f40372d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r7 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40372d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r11.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r10.f40374f = r7;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;
        L_0x012a:
            r2 = r3;
            goto L_0x0016;
        L_0x012d:
            if (r7 != 0) goto L_0x0016;
        L_0x012f:
            goto L_0x012a;
        L_0x0130:
            r11 = move-exception;
            goto L_0x0143;
        L_0x0132:
            r11 = move-exception;
            r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0130 }
            r11 = r11.getMessage();	 Catch:{ all -> 0x0130 }
            r12.<init>(r11);	 Catch:{ all -> 0x0130 }
            r12.f25930a = r10;	 Catch:{ all -> 0x0130 }
            throw r12;	 Catch:{ all -> 0x0130 }
        L_0x013f:
            r11 = move-exception;	 Catch:{ all -> 0x0130 }
            r11.f25930a = r10;	 Catch:{ all -> 0x0130 }
            throw r11;	 Catch:{ all -> 0x0130 }
        L_0x0143:
            r12 = r4 & 32;
            if (r12 != r6) goto L_0x014f;
        L_0x0147:
            r12 = r10.f40378j;
            r12 = java.util.Collections.unmodifiableList(r12);
            r10.f40378j = r12;
        L_0x014f:
            r12 = r4 & 256;
            if (r12 != r5) goto L_0x015b;
        L_0x0153:
            r12 = r10.f40381m;
            r12 = java.util.Collections.unmodifiableList(r12);
            r10.f40381m = r12;
        L_0x015b:
            r1.m27501b();	 Catch:{ IOException -> 0x015e, all -> 0x0165 }
        L_0x015e:
            r12 = r0.m27451a();
            r10.f40384q = r12;
            goto L_0x016d;
        L_0x0165:
            r11 = move-exception;
            r12 = r0.m27451a();
            r10.f40384q = r12;
            throw r11;
        L_0x016d:
            r12 = r10.f39732b;
            r12.m27521c();
            throw r11;
        L_0x0173:
            r11 = r4 & 32;
            if (r11 != r6) goto L_0x017f;
        L_0x0177:
            r11 = r10.f40378j;
            r11 = java.util.Collections.unmodifiableList(r11);
            r10.f40378j = r11;
        L_0x017f:
            r11 = r4 & 256;
            if (r11 != r5) goto L_0x018b;
        L_0x0183:
            r11 = r10.f40381m;
            r11 = java.util.Collections.unmodifiableList(r11);
            r10.f40381m = r11;
        L_0x018b:
            r1.m27501b();	 Catch:{ IOException -> 0x018e, all -> 0x0195 }
        L_0x018e:
            r11 = r0.m27451a();
            r10.f40384q = r11;
            goto L_0x019d;
        L_0x0195:
            r11 = move-exception;
            r12 = r0.m27451a();
            r10.f40384q = r12;
            throw r11;
        L_0x019d:
            r11 = r10.f39732b;
            r11.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Function function = new Function();
            f40371p = function;
            function.m41659n();
        }

        public final Parser<Function> mo7112a() {
            return f40370c;
        }

        public final boolean m41665h() {
            return (this.f40372d & 1) == 1;
        }

        public final boolean m41666i() {
            return (this.f40372d & 4) == 4;
        }

        public final boolean m41667j() {
            return (this.f40372d & 8) == 8;
        }

        public final boolean m41668k() {
            return (this.f40372d & 32) == 32;
        }

        public final boolean m41669l() {
            return (this.f40372d & 64) == 64;
        }

        public final boolean m41670m() {
            return (this.f40372d & 128) == 128;
        }

        private void m41659n() {
            this.f40373e = 6;
            this.f40374f = 6;
            this.f40375g = 0;
            this.f40376h = Type.m41783f();
            this.f40377i = 0;
            this.f40378j = Collections.emptyList();
            this.f40379k = Type.m41783f();
            this.f40380l = 0;
            this.f40381m = Collections.emptyList();
            this.f40382n = TypeTable.m40220f();
            this.f40383o = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f40385r;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!m41666i()) {
                this.f40385r = (byte) 0;
                return false;
            } else if (!m41667j() || this.f40376h.mo7303g()) {
                int i = 0;
                while (i < this.f40378j.size()) {
                    if (((TypeParameter) this.f40378j.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40385r = (byte) 0;
                        return false;
                    }
                }
                if (!m41668k() || this.f40379k.mo7303g()) {
                    i = 0;
                    while (i < this.f40381m.size()) {
                        if (((ValueParameter) this.f40381m.get(i)).mo7303g()) {
                            i++;
                        } else {
                            this.f40385r = (byte) 0;
                            return false;
                        }
                    }
                    if (m41670m() && !this.f40382n.mo7303g()) {
                        this.f40385r = (byte) 0;
                        return false;
                    } else if (this.f39732b.m27523e()) {
                        this.f40385r = (byte) 1;
                        return true;
                    } else {
                        this.f40385r = (byte) 0;
                        return false;
                    }
                }
                this.f40385r = (byte) 0;
                return false;
            } else {
                this.f40385r = (byte) 0;
                return false;
            }
        }

        public static Function m41645a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Function) f40370c.mo5862b(inputStream, extensionRegistryLite);
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40371p;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41634a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class Package extends ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> f40393c = new C27761();
        private static final Package f40394j;
        int f40395d;
        public List<Function> f40396e;
        public List<Property> f40397f;
        public List<TypeAlias> f40398g;
        public TypeTable f40399h;
        public SinceKotlinInfoTable f40400i;
        private final ByteString f40401k;
        private byte f40402l;
        private int f40403m;

        static class C27761 extends AbstractParser<Package> {
            C27761() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int f40387c;
            private List<Function> f40388d = Collections.emptyList();
            private List<Property> f40389e = Collections.emptyList();
            private List<TypeAlias> f40390f = Collections.emptyList();
            private TypeTable f40391g = TypeTable.m40220f();
            private SinceKotlinInfoTable f40392h = SinceKotlinInfoTable.m40140f();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41673j();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41671c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41673j();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41671c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41673j();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41673j();
            }

            private Builder() {
            }

            public final Package m41685h() {
                int i = 0;
                Package packageR = new Package((ExtendableBuilder) this);
                int i2 = this.f40387c;
                if ((this.f40387c & 1) == 1) {
                    this.f40388d = Collections.unmodifiableList(this.f40388d);
                    this.f40387c &= -2;
                }
                packageR.f40396e = this.f40388d;
                if ((this.f40387c & 2) == 2) {
                    this.f40389e = Collections.unmodifiableList(this.f40389e);
                    this.f40387c &= -3;
                }
                packageR.f40397f = this.f40389e;
                if ((this.f40387c & 4) == 4) {
                    this.f40390f = Collections.unmodifiableList(this.f40390f);
                    this.f40387c &= -5;
                }
                packageR.f40398g = this.f40390f;
                if ((i2 & 8) == 8) {
                    i = 1;
                }
                packageR.f40399h = this.f40391g;
                if ((i2 & 16) == 16) {
                    i |= 2;
                }
                packageR.f40400i = this.f40392h;
                packageR.f40395d = i;
                return packageR;
            }

            public final Builder m41677a(Package packageR) {
                if (packageR == Package.m41698f()) {
                    return this;
                }
                int i = 1;
                if (!packageR.f40396e.isEmpty()) {
                    if (this.f40388d.isEmpty()) {
                        this.f40388d = packageR.f40396e;
                        this.f40387c &= -2;
                    } else {
                        if ((this.f40387c & 1) != 1) {
                            this.f40388d = new ArrayList(this.f40388d);
                            this.f40387c |= 1;
                        }
                        this.f40388d.addAll(packageR.f40396e);
                    }
                }
                if (!packageR.f40397f.isEmpty()) {
                    if (this.f40389e.isEmpty()) {
                        this.f40389e = packageR.f40397f;
                        this.f40387c &= -3;
                    } else {
                        if ((this.f40387c & 2) != 2) {
                            this.f40389e = new ArrayList(this.f40389e);
                            this.f40387c |= 2;
                        }
                        this.f40389e.addAll(packageR.f40397f);
                    }
                }
                if (!packageR.f40398g.isEmpty()) {
                    if (this.f40390f.isEmpty()) {
                        this.f40390f = packageR.f40398g;
                        this.f40387c &= -5;
                    } else {
                        if ((this.f40387c & 4) != 4) {
                            this.f40390f = new ArrayList(this.f40390f);
                            this.f40387c |= 4;
                        }
                        this.f40390f.addAll(packageR.f40398g);
                    }
                }
                if (packageR.m41705h()) {
                    TypeTable typeTable = packageR.f40399h;
                    if ((this.f40387c & 8) != 8 || this.f40391g == TypeTable.m40220f()) {
                        this.f40391g = typeTable;
                    } else {
                        this.f40391g = TypeTable.m40216a(this.f40391g).m40206a(typeTable).m40211e();
                    }
                    this.f40387c |= 8;
                }
                if ((packageR.f40395d & 2) != 2) {
                    i = 0;
                }
                if (i != 0) {
                    SinceKotlinInfoTable sinceKotlinInfoTable = packageR.f40400i;
                    if ((this.f40387c & 16) != 16 || this.f40392h == SinceKotlinInfoTable.m40140f()) {
                        this.f40392h = sinceKotlinInfoTable;
                    } else {
                        this.f40392h = SinceKotlinInfoTable.m40137a(this.f40392h).m40128a(sinceKotlinInfoTable).m40133e();
                    }
                    this.f40387c |= 16;
                }
                m39924a((ExtendableMessage) packageR);
                this.f38788a = this.f38788a.m27460a(packageR.f40401k);
                return this;
            }

            private Builder m41671c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Package packageR;
                Package packageR2 = null;
                try {
                    m41677a((Package) Package.f40393c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    packageR = (Package) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    packageR2 = packageR;
                }
                if (packageR2 != null) {
                    m41677a(packageR2);
                }
                throw codedInputStream2;
            }

            private Builder m41673j() {
                return new Builder().m41677a(m41685h());
            }

            public final boolean mo7303g() {
                int i;
                for (i = 0; i < this.f40388d.size(); i++) {
                    if (!((Function) this.f40388d.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40389e.size(); i++) {
                    if (!((Property) this.f40389e.get(i)).mo7303g()) {
                        return false;
                    }
                }
                for (i = 0; i < this.f40390f.size(); i++) {
                    if (!((TypeAlias) this.f40390f.get(i)).mo7303g()) {
                        return false;
                    }
                }
                if ((!((this.f40387c & 8) == 8) || this.f40391g.mo7303g()) && this.f39730b.m27523e()) {
                    return true;
                }
                return false;
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return Package.m41698f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return Package.m41698f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite h = m41685h();
                if (h.mo7303g()) {
                    return h;
                }
                throw new UninitializedMessageException();
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return m41706i();
        }

        private Package(ExtendableBuilder<Package, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40402l = (byte) -1;
            this.f40403m = -1;
            this.f40401k = extendableBuilder.f38788a;
        }

        private Package() {
            this.f40402l = (byte) -1;
            this.f40403m = -1;
            this.f40401k = ByteString.f25891b;
        }

        public static Package m41698f() {
            return f40394j;
        }

        private Package(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r10.<init>();
            r0 = -1;
            r10.f40402l = r0;
            r10.f40403m = r0;
            r10.m41699j();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 4;
            r6 = 2;
            if (r2 != 0) goto L_0x012d;
        L_0x001a:
            r7 = r11.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == 0) goto L_0x00db;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0020:
            r8 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r8) goto L_0x00c1;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0024:
            r8 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r8) goto L_0x00a7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0028:
            r8 = 42;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r8) goto L_0x008d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x002c:
            r8 = 242; // 0xf2 float:3.39E-43 double:1.196E-321;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r9 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r8) goto L_0x0065;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0031:
            r8 = 258; // 0x102 float:3.62E-43 double:1.275E-321;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r8) goto L_0x003d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0035:
            r7 = r10.mo7294a(r11, r1, r12, r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x003b:
            goto L_0x00db;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x003d:
            r7 = r10.f40395d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r7 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 != r6) goto L_0x0048;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0042:
            r7 = r10.f40400i;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r9 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable.m40137a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0048:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable.f39824b;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.SinceKotlinInfoTable) r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40400i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r9 == 0) goto L_0x005f;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0054:
            r7 = r10.f40400i;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r9.m40128a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r9.m40133e();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40400i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x005f:
            r7 = r10.f40395d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r7 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40395d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0065:
            r7 = r10.f40395d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r7 & r3;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 != r3) goto L_0x0070;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x006a:
            r7 = r10.f40399h;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r9 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.m40216a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0070:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable.f39854b;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r11.m27483a(r7, r12);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable) r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40399h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r9 == 0) goto L_0x0087;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x007c:
            r7 = r10.f40399h;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r9.m40206a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r9.m40211e();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40399h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0087:
            r7 = r10.f40395d;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7 = r7 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40395d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x008d:
            r7 = r4 & 4;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r5) goto L_0x009a;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x0091:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40398g = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x009a:
            r7 = r10.f40398g;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias.f40480c;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = r11.m27483a(r8, r12);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00a7:
            r7 = r4 & 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r6) goto L_0x00b4;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00ab:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40397f = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00b4:
            r7 = r10.f40397f;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property.f40417c;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = r11.m27483a(r8, r12);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00c1:
            r7 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            if (r7 == r3) goto L_0x00ce;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00c5:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r10.f40396e = r7;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
        L_0x00ce:
            r7 = r10.f40396e;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function.f40370c;	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r8 = r11.m27483a(r8, r12);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x00ed, IOException -> 0x00e0 }
            goto L_0x0016;
        L_0x00db:
            r2 = r3;
            goto L_0x0016;
        L_0x00de:
            r11 = move-exception;
            goto L_0x00f1;
        L_0x00e0:
            r11 = move-exception;
            r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00de }
            r11 = r11.getMessage();	 Catch:{ all -> 0x00de }
            r12.<init>(r11);	 Catch:{ all -> 0x00de }
            r12.f25930a = r10;	 Catch:{ all -> 0x00de }
            throw r12;	 Catch:{ all -> 0x00de }
        L_0x00ed:
            r11 = move-exception;	 Catch:{ all -> 0x00de }
            r11.f25930a = r10;	 Catch:{ all -> 0x00de }
            throw r11;	 Catch:{ all -> 0x00de }
        L_0x00f1:
            r12 = r4 & 1;
            if (r12 != r3) goto L_0x00fd;
        L_0x00f5:
            r12 = r10.f40396e;
            r12 = java.util.Collections.unmodifiableList(r12);
            r10.f40396e = r12;
        L_0x00fd:
            r12 = r4 & 2;
            if (r12 != r6) goto L_0x0109;
        L_0x0101:
            r12 = r10.f40397f;
            r12 = java.util.Collections.unmodifiableList(r12);
            r10.f40397f = r12;
        L_0x0109:
            r12 = r4 & 4;
            if (r12 != r5) goto L_0x0115;
        L_0x010d:
            r12 = r10.f40398g;
            r12 = java.util.Collections.unmodifiableList(r12);
            r10.f40398g = r12;
        L_0x0115:
            r1.m27501b();	 Catch:{ IOException -> 0x0118, all -> 0x011f }
        L_0x0118:
            r12 = r0.m27451a();
            r10.f40401k = r12;
            goto L_0x0127;
        L_0x011f:
            r11 = move-exception;
            r12 = r0.m27451a();
            r10.f40401k = r12;
            throw r11;
        L_0x0127:
            r12 = r10.f39732b;
            r12.m27521c();
            throw r11;
        L_0x012d:
            r11 = r4 & 1;
            if (r11 != r3) goto L_0x0139;
        L_0x0131:
            r11 = r10.f40396e;
            r11 = java.util.Collections.unmodifiableList(r11);
            r10.f40396e = r11;
        L_0x0139:
            r11 = r4 & 2;
            if (r11 != r6) goto L_0x0145;
        L_0x013d:
            r11 = r10.f40397f;
            r11 = java.util.Collections.unmodifiableList(r11);
            r10.f40397f = r11;
        L_0x0145:
            r11 = r4 & 4;
            if (r11 != r5) goto L_0x0151;
        L_0x0149:
            r11 = r10.f40398g;
            r11 = java.util.Collections.unmodifiableList(r11);
            r10.f40398g = r11;
        L_0x0151:
            r1.m27501b();	 Catch:{ IOException -> 0x0154, all -> 0x015b }
        L_0x0154:
            r11 = r0.m27451a();
            r10.f40401k = r11;
            goto L_0x0163;
        L_0x015b:
            r11 = move-exception;
            r12 = r0.m27451a();
            r10.f40401k = r12;
            throw r11;
        L_0x0163:
            r11 = r10.f39732b;
            r11.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Package packageR = new Package();
            f40394j = packageR;
            packageR.m41699j();
        }

        public final Parser<Package> mo7112a() {
            return f40393c;
        }

        public final boolean m41705h() {
            return (this.f40395d & 1) == 1;
        }

        private void m41699j() {
            this.f40396e = Collections.emptyList();
            this.f40397f = Collections.emptyList();
            this.f40398g = Collections.emptyList();
            this.f40399h = TypeTable.m40220f();
            this.f40400i = SinceKotlinInfoTable.m40140f();
        }

        public final boolean mo7303g() {
            byte b = this.f40402l;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < this.f40396e.size()) {
                if (((Function) this.f40396e.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f40402l = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < this.f40397f.size()) {
                if (((Property) this.f40397f.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f40402l = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < this.f40398g.size()) {
                if (((TypeAlias) this.f40398g.get(i)).mo7303g()) {
                    i++;
                } else {
                    this.f40402l = (byte) 0;
                    return false;
                }
            }
            if (m41705h() && !this.f40399h.mo7303g()) {
                this.f40402l = (byte) 0;
                return false;
            } else if (this.f39732b.m27523e()) {
                this.f40402l = (byte) 1;
                return true;
            } else {
                this.f40402l = (byte) 0;
                return false;
            }
        }

        public static Package m41689a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Package) f40393c.mo5862b(inputStream, extensionRegistryLite);
        }

        public static Builder m41688a(Package packageR) {
            return new Builder().m41677a(packageR);
        }

        public final Builder m41706i() {
            return new Builder().m41677a(this);
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40394j;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class Property extends ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> f40417c = new C27771();
        private static final Property f40418q;
        int f40419d;
        public int f40420e;
        public int f40421f;
        public int f40422g;
        public Type f40423h;
        public int f40424i;
        public List<TypeParameter> f40425j;
        public Type f40426k;
        public int f40427l;
        public ValueParameter f40428m;
        public int f40429n;
        public int f40430o;
        int f40431p;
        private final ByteString f40432r;
        private byte f40433s;
        private int f40434t;

        static class C27771 extends AbstractParser<Property> {
            C27771() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int f40404c;
            private int f40405d = 518;
            private int f40406e = 2054;
            private int f40407f;
            private Type f40408g = Type.m41783f();
            private int f40409h;
            private List<TypeParameter> f40410i = Collections.emptyList();
            private Type f40411j = Type.m41783f();
            private int f40412k;
            private ValueParameter f40413l = ValueParameter.m41905f();
            private int f40414m;
            private int f40415n;
            private int f40416o;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41709i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41707c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41709i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41707c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41709i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41709i();
            }

            private Builder() {
            }

            private Property m41710j() {
                int i = 0;
                Property property = new Property((ExtendableBuilder) this);
                int i2 = this.f40404c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                property.f40420e = this.f40405d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                property.f40421f = this.f40406e;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                property.f40422g = this.f40407f;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                property.f40423h = this.f40408g;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                property.f40424i = this.f40409h;
                if ((this.f40404c & 32) == 32) {
                    this.f40410i = Collections.unmodifiableList(this.f40410i);
                    this.f40404c &= -33;
                }
                property.f40425j = this.f40410i;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                property.f40426k = this.f40411j;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                property.f40427l = this.f40412k;
                if ((i2 & 256) == 256) {
                    i |= 128;
                }
                property.f40428m = this.f40413l;
                if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH) {
                    i |= 256;
                }
                property.f40429n = this.f40414m;
                if ((i2 & 1024) == 1024) {
                    i |= AdRequest.MAX_CONTENT_URL_LENGTH;
                }
                property.f40430o = this.f40415n;
                if ((i2 & MPEGConst.CODE_END) == MPEGConst.CODE_END) {
                    i |= 1024;
                }
                property.f40431p = this.f40416o;
                property.f40419d = i;
                return property;
            }

            public final Builder m41714a(Property property) {
                if (property == Property.m41734f()) {
                    return this;
                }
                Type type;
                int i = 1;
                if (property.m41744h()) {
                    int i2 = property.f40420e;
                    this.f40404c |= 1;
                    this.f40405d = i2;
                }
                if (((property.f40419d & 2) == 2 ? 1 : 0) != 0) {
                    i2 = property.f40421f;
                    this.f40404c = 2 | this.f40404c;
                    this.f40406e = i2;
                }
                if (property.m41745i()) {
                    i2 = property.f40422g;
                    this.f40404c |= 4;
                    this.f40407f = i2;
                }
                if (property.m41746j()) {
                    type = property.f40423h;
                    if ((this.f40404c & 8) != 8 || this.f40408g == Type.m41783f()) {
                        this.f40408g = type;
                    } else {
                        this.f40408g = Type.m41771a(this.f40408g).m41758a(type).m41768i();
                    }
                    this.f40404c |= 8;
                }
                if (((property.f40419d & 16) == 16 ? 1 : 0) != 0) {
                    i2 = property.f40424i;
                    this.f40404c = 16 | this.f40404c;
                    this.f40409h = i2;
                }
                if (!property.f40425j.isEmpty()) {
                    if (this.f40410i.isEmpty()) {
                        this.f40410i = property.f40425j;
                        this.f40404c &= -33;
                    } else {
                        if ((this.f40404c & 32) != 32) {
                            this.f40410i = new ArrayList(this.f40410i);
                            this.f40404c |= 32;
                        }
                        this.f40410i.addAll(property.f40425j);
                    }
                }
                if (property.m41747k()) {
                    type = property.f40426k;
                    if ((this.f40404c & 64) != 64 || this.f40411j == Type.m41783f()) {
                        this.f40411j = type;
                    } else {
                        this.f40411j = Type.m41771a(this.f40411j).m41758a(type).m41768i();
                    }
                    this.f40404c |= 64;
                }
                if (property.m41748l()) {
                    i2 = property.f40427l;
                    this.f40404c |= 128;
                    this.f40412k = i2;
                }
                if (property.m41749m()) {
                    ValueParameter valueParameter = property.f40428m;
                    if ((this.f40404c & 256) != 256 || this.f40413l == ValueParameter.m41905f()) {
                        this.f40413l = valueParameter;
                    } else {
                        this.f40413l = ValueParameter.m41898a(this.f40413l).m41887a(valueParameter).m41895h();
                    }
                    this.f40404c |= 256;
                }
                if (property.m41750n()) {
                    i2 = property.f40429n;
                    this.f40404c |= AdRequest.MAX_CONTENT_URL_LENGTH;
                    this.f40414m = i2;
                }
                if (property.m41751o()) {
                    i2 = property.f40430o;
                    this.f40404c |= 1024;
                    this.f40415n = i2;
                }
                if ((property.f40419d & 1024) != 1024) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = property.f40431p;
                    this.f40404c |= MPEGConst.CODE_END;
                    this.f40416o = i2;
                }
                m39924a((ExtendableMessage) property);
                this.f38788a = this.f38788a.m27460a(property.f40432r);
                return this;
            }

            private Builder m41707c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Property property;
                Property property2 = null;
                try {
                    m41714a((Property) Property.f40417c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    property = (Property) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    property2 = property;
                }
                if (property2 != null) {
                    m41714a(property2);
                }
                throw codedInputStream2;
            }

            private Builder m41709i() {
                return new Builder().m41714a(m41710j());
            }

            public final boolean mo7303g() {
                if (!((this.f40404c & 4) == 4)) {
                    return false;
                }
                if (((this.f40404c & 8) == 8) && !this.f40408g.mo7303g()) {
                    return false;
                }
                for (int i = 0; i < this.f40410i.size(); i++) {
                    if (!((TypeParameter) this.f40410i.get(i)).mo7303g()) {
                        return false;
                    }
                }
                if (((this.f40404c & 64) == 64) && !this.f40411j.mo7303g()) {
                    return false;
                }
                return (!((this.f40404c & 256) == 256) || this.f40413l.mo7303g()) && this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return Property.m41734f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return Property.m41734f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41710j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private Property(ExtendableBuilder<Property, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40433s = (byte) -1;
            this.f40434t = -1;
            this.f40432r = extendableBuilder.f38788a;
        }

        private Property() {
            this.f40433s = (byte) -1;
            this.f40434t = -1;
            this.f40432r = ByteString.f25891b;
        }

        public static Property m41734f() {
            return f40418q;
        }

        private Property(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r9.<init>();
            r0 = -1;
            r9.f40433s = r0;
            r9.f40434t = r0;
            r9.m41738p();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 32;
            if (r2 != 0) goto L_0x0167;
        L_0x001a:
            r6 = r10.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            switch(r6) {
                case 0: goto L_0x012a;
                case 8: goto L_0x011c;
                case 16: goto L_0x010e;
                case 26: goto L_0x00e3;
                case 34: goto L_0x00c9;
                case 42: goto L_0x00a0;
                case 50: goto L_0x0075;
                case 56: goto L_0x0068;
                case 64: goto L_0x005b;
                case 72: goto L_0x004e;
                case 80: goto L_0x0041;
                case 88: goto L_0x0035;
                case 248: goto L_0x0028;
                default: goto L_0x0022;
            };	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0022:
            r6 = r9.mo7294a(r10, r1, r11, r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x012d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0028:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 1024;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40431p = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0035:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40420e = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0041:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40427l = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x004e:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40424i = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x005b:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 512;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40430o = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0068:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 256;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40429n = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0075:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 & r8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r6 != r8) goto L_0x0082;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x007c:
            r6 = r9.f40428m;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter.m41898a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0082:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter.f40521c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter) r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40428m = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 == 0) goto L_0x0099;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x008e:
            r6 = r9.f40428m;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.m41887a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r7.m41895h();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40428m = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0099:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00a0:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 & r5;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r6 != r5) goto L_0x00ab;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00a5:
            r6 = r9.f40426k;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00ab:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40426k = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 == 0) goto L_0x00c2;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00b7:
            r6 = r9.f40426k;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.m41758a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r7.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40426k = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00c2:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00c9:
            r6 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r6 == r5) goto L_0x00d6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00cd:
            r6 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40425j = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00d6:
            r6 = r9.f40425j;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.f40502c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = r10.m27483a(r7, r11);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00e3:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r8 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 & r8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r6 != r8) goto L_0x00f0;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00ea:
            r6 = r9.f40423h;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00f0:
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27483a(r6, r11);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40423h = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            if (r7 == 0) goto L_0x0107;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x00fc:
            r6 = r9.f40423h;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r7.m41758a(r6);	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r7.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40423h = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x0107:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x010e:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40422g = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
        L_0x011c:
            r6 = r9.f40419d;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r6 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40419d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r6 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            r9.f40421f = r6;	 Catch:{ InvalidProtocolBufferException -> 0x013f, IOException -> 0x0132 }
            goto L_0x0016;
        L_0x012a:
            r2 = r3;
            goto L_0x0016;
        L_0x012d:
            if (r6 != 0) goto L_0x0016;
        L_0x012f:
            goto L_0x012a;
        L_0x0130:
            r10 = move-exception;
            goto L_0x0143;
        L_0x0132:
            r10 = move-exception;
            r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0130 }
            r10 = r10.getMessage();	 Catch:{ all -> 0x0130 }
            r11.<init>(r10);	 Catch:{ all -> 0x0130 }
            r11.f25930a = r9;	 Catch:{ all -> 0x0130 }
            throw r11;	 Catch:{ all -> 0x0130 }
        L_0x013f:
            r10 = move-exception;	 Catch:{ all -> 0x0130 }
            r10.f25930a = r9;	 Catch:{ all -> 0x0130 }
            throw r10;	 Catch:{ all -> 0x0130 }
        L_0x0143:
            r11 = r4 & 32;
            if (r11 != r5) goto L_0x014f;
        L_0x0147:
            r11 = r9.f40425j;
            r11 = java.util.Collections.unmodifiableList(r11);
            r9.f40425j = r11;
        L_0x014f:
            r1.m27501b();	 Catch:{ IOException -> 0x0152, all -> 0x0159 }
        L_0x0152:
            r11 = r0.m27451a();
            r9.f40432r = r11;
            goto L_0x0161;
        L_0x0159:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f40432r = r11;
            throw r10;
        L_0x0161:
            r11 = r9.f39732b;
            r11.m27521c();
            throw r10;
        L_0x0167:
            r10 = r4 & 32;
            if (r10 != r5) goto L_0x0173;
        L_0x016b:
            r10 = r9.f40425j;
            r10 = java.util.Collections.unmodifiableList(r10);
            r9.f40425j = r10;
        L_0x0173:
            r1.m27501b();	 Catch:{ IOException -> 0x0176, all -> 0x017d }
        L_0x0176:
            r10 = r0.m27451a();
            r9.f40432r = r10;
            goto L_0x0185;
        L_0x017d:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f40432r = r11;
            throw r10;
        L_0x0185:
            r10 = r9.f39732b;
            r10.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Property property = new Property();
            f40418q = property;
            property.m41738p();
        }

        public final Parser<Property> mo7112a() {
            return f40417c;
        }

        public final boolean m41744h() {
            return (this.f40419d & 1) == 1;
        }

        public final boolean m41745i() {
            return (this.f40419d & 4) == 4;
        }

        public final boolean m41746j() {
            return (this.f40419d & 8) == 8;
        }

        public final boolean m41747k() {
            return (this.f40419d & 32) == 32;
        }

        public final boolean m41748l() {
            return (this.f40419d & 64) == 64;
        }

        public final boolean m41749m() {
            return (this.f40419d & 128) == 128;
        }

        public final boolean m41750n() {
            return (this.f40419d & 256) == 256;
        }

        public final boolean m41751o() {
            return (this.f40419d & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH;
        }

        private void m41738p() {
            this.f40420e = 518;
            this.f40421f = 2054;
            this.f40422g = 0;
            this.f40423h = Type.m41783f();
            this.f40424i = 0;
            this.f40425j = Collections.emptyList();
            this.f40426k = Type.m41783f();
            this.f40427l = 0;
            this.f40428m = ValueParameter.m41905f();
            this.f40429n = 0;
            this.f40430o = 0;
            this.f40431p = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f40433s;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!m41745i()) {
                this.f40433s = (byte) 0;
                return false;
            } else if (!m41746j() || this.f40423h.mo7303g()) {
                int i = 0;
                while (i < this.f40425j.size()) {
                    if (((TypeParameter) this.f40425j.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40433s = (byte) 0;
                        return false;
                    }
                }
                if (m41747k() && !this.f40426k.mo7303g()) {
                    this.f40433s = (byte) 0;
                    return false;
                } else if (m41749m() && !this.f40428m.mo7303g()) {
                    this.f40433s = (byte) 0;
                    return false;
                } else if (this.f39732b.m27523e()) {
                    this.f40433s = (byte) 1;
                    return true;
                } else {
                    this.f40433s = (byte) 0;
                    return false;
                }
            } else {
                this.f40433s = (byte) 0;
                return false;
            }
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40418q;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41714a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class Type extends ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> f40450c = new C27831();
        private static final Type f40451s;
        int f40452d;
        public List<Argument> f40453e;
        public boolean f40454f;
        public int f40455g;
        public Type f40456h;
        public int f40457i;
        public int f40458j;
        public int f40459k;
        public int f40460l;
        public int f40461m;
        public Type f40462n;
        public int f40463o;
        public Type f40464p;
        public int f40465q;
        public int f40466r;
        private final ByteString f40467t;
        private byte f40468u;
        private int f40469v;

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        static class C27831 extends AbstractParser<Type> {
            C27831() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.1.<init>():void");
            }

            public final /* synthetic */ java.lang.Object mo6731a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type;
                r1 = 0;
                r0.<init>(r3, r4, r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.1.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
            }
        }

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> f39842b = new C27841();
            private static final Argument f39843g;
            int f39844c;
            public Projection f39845d;
            public Type f39846e;
            public int f39847f;
            private final ByteString f39848h;
            private byte f39849i;
            private int f39850j;

            public enum Projection implements EnumLite {
                f33008a(0),
                OUT(1),
                INV(2),
                STAR(3);
                
                private static EnumLiteMap<Projection> f33012e;
                private final int f33014f;

                static class C25901 implements EnumLiteMap<Projection> {
                    C25901() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.1.<init>():void");
                    }

                    public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite mo5921a(int r1) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.m33525a(r1);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.1.a(int):kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite");
                    }
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection;
                    r1 = "IN";
                    r2 = 0;
                    r0.<init>(r1, r2, r2);
                    f33008a = r0;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection;
                    r1 = "OUT";
                    r3 = 1;
                    r0.<init>(r1, r3, r3);
                    OUT = r0;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection;
                    r1 = "INV";
                    r4 = 2;
                    r0.<init>(r1, r4, r4);
                    INV = r0;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection;
                    r1 = "STAR";
                    r5 = 3;
                    r0.<init>(r1, r5, r5);
                    STAR = r0;
                    r0 = 4;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection[r0];
                    r1 = f33008a;
                    r0[r2] = r1;
                    r1 = OUT;
                    r0[r3] = r1;
                    r1 = INV;
                    r0[r4] = r1;
                    r1 = STAR;
                    r0[r5] = r1;
                    f33013g = r0;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection$1;
                    r0.<init>();
                    f33012e = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.<clinit>():void");
                }

                public final int mo5922a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f33014f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.a():int");
                }

                public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection m33525a(int r0) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    switch(r0) {
                        case 0: goto L_0x000e;
                        case 1: goto L_0x000b;
                        case 2: goto L_0x0008;
                        case 3: goto L_0x0005;
                        default: goto L_0x0003;
                    };
                L_0x0003:
                    r0 = 0;
                    return r0;
                L_0x0005:
                    r0 = STAR;
                    return r0;
                L_0x0008:
                    r0 = INV;
                    return r0;
                L_0x000b:
                    r0 = OUT;
                    return r0;
                L_0x000e:
                    r0 = f33008a;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.a(int):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Projection");
                }

                private Projection(int r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>(r1, r2);
                    r0.f33014f = r3;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.<init>(java.lang.String, int, int):void");
                }
            }

            static class C27841 extends AbstractParser<Argument> {
                C27841() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.1.<init>():void");
                }

                public final /* synthetic */ java.lang.Object mo6731a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument;
                    r1 = 0;
                    r0.<init>(r3, r4, r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.1.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
                }
            }

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int f39838b;
                private Projection f39839c = Projection.INV;
                private Type f39840d = Type.m41783f();
                private int f39841e;

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m40174h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.a():kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r1 = r0.m40172c(r1, r2);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m40174h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.b():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r1 = r0.m40172c(r1, r2);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ java.lang.Object clone() throws java.lang.CloneNotSupportedException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m40174h();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.clone():java.lang.Object");
                }

                private Builder() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r1.<init>();
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.INV;
                    r1.f39839c = r0;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                    r1.f39840d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.<init>():void");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument m40175i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument;
                    r1 = 0;
                    r0.<init>(r5, r1);
                    r2 = r5.f39838b;
                    r3 = r2 & 1;
                    r4 = 1;
                    if (r3 != r4) goto L_0x000e;
                L_0x000d:
                    r1 = r4;
                L_0x000e:
                    r3 = r5.f39839c;
                    r0.f39845d = r3;
                    r3 = r2 & 2;
                    r4 = 2;
                    if (r3 != r4) goto L_0x001a;
                L_0x0018:
                    r1 = r1 | 2;
                L_0x001a:
                    r3 = r5.f39840d;
                    r0.f39846e = r3;
                    r3 = 4;
                    r2 = r2 & r3;
                    if (r2 != r3) goto L_0x0025;
                L_0x0023:
                    r1 = r1 | 4;
                L_0x0025:
                    r2 = r5.f39841e;
                    r0.f39847f = r2;
                    r0.f39844c = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.i():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument");
                }

                public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder m40179a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument r5) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.m40191f();
                    if (r5 != r0) goto L_0x0007;
                L_0x0006:
                    return r4;
                L_0x0007:
                    r0 = r5.f39844c;
                    r1 = 1;
                    r0 = r0 & r1;
                    if (r0 != r1) goto L_0x000f;
                L_0x000d:
                    r0 = r1;
                    goto L_0x0010;
                L_0x000f:
                    r0 = 0;
                L_0x0010:
                    if (r0 == 0) goto L_0x0023;
                L_0x0012:
                    r0 = r5.f39845d;
                    if (r0 != 0) goto L_0x001c;
                L_0x0016:
                    r5 = new java.lang.NullPointerException;
                    r5.<init>();
                    throw r5;
                L_0x001c:
                    r2 = r4.f39838b;
                    r1 = r1 | r2;
                    r4.f39838b = r1;
                    r4.f39839c = r0;
                L_0x0023:
                    r0 = r5.m40198h();
                    if (r0 == 0) goto L_0x0051;
                L_0x0029:
                    r0 = r5.f39846e;
                    r1 = r4.f39838b;
                    r2 = 2;
                    r1 = r1 & r2;
                    if (r1 != r2) goto L_0x004a;
                L_0x0031:
                    r1 = r4.f39840d;
                    r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                    if (r1 == r3) goto L_0x004a;
                L_0x0039:
                    r1 = r4.f39840d;
                    r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r1);
                    r0 = r1.m41758a(r0);
                    r0 = r0.m41768i();
                    r4.f39840d = r0;
                    goto L_0x004c;
                L_0x004a:
                    r4.f39840d = r0;
                L_0x004c:
                    r0 = r4.f39838b;
                    r0 = r0 | r2;
                    r4.f39838b = r0;
                L_0x0051:
                    r0 = r5.m40199i();
                    if (r0 == 0) goto L_0x0061;
                L_0x0057:
                    r0 = r5.f39847f;
                    r1 = r4.f39838b;
                    r1 = r1 | 4;
                    r4.f39838b = r1;
                    r4.f39841e = r0;
                L_0x0061:
                    r0 = r4.f38788a;
                    r5 = r5.f39848h;
                    r5 = r0.m27460a(r5);
                    r4.f38788a = r5;
                    return r4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Builder");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder m40172c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.f39842b;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r3 = r1.mo6731a(r3, r4);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument) r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r2.m40179a(r3);
                    return r2;
                L_0x000d:
                    r3 = move-exception;
                    goto L_0x0017;
                L_0x000f:
                    r3 = move-exception;
                    r4 = r3.f25930a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument) r4;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                    throw r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                L_0x0015:
                    r3 = move-exception;
                    r0 = r4;
                L_0x0017:
                    if (r0 == 0) goto L_0x001c;
                L_0x0019:
                    r2.m40179a(r0);
                L_0x001c:
                    throw r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Builder");
                }

                private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder m40174h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Builder;
                    r0.<init>();
                    r1 = r2.m40175i();
                    r0 = r0.m40179a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.h():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument$Builder");
                }

                public final boolean mo7303g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f39838b;
                    r1 = 2;
                    r0 = r0 & r1;
                    r2 = 0;
                    r3 = 1;
                    if (r0 != r1) goto L_0x000a;
                L_0x0008:
                    r0 = r3;
                    goto L_0x000b;
                L_0x000a:
                    r0 = r2;
                L_0x000b:
                    if (r0 == 0) goto L_0x0016;
                L_0x000d:
                    r0 = r4.f39840d;
                    r0 = r0.mo7303g();
                    if (r0 != 0) goto L_0x0016;
                L_0x0015:
                    return r2;
                L_0x0016:
                    return r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.g():boolean");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite mo7301c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.m40191f();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.c():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7302f() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.m40175i();
                    r1 = r0.mo7303g();
                    if (r1 != 0) goto L_0x0010;
                L_0x000a:
                    r0 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
                    r0.<init>();
                    throw r0;
                L_0x0010:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.f():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                }

                public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.m40191f();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
                }
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.<init>(r0);
                r0 = -1;
                r1.f39849i = r0;
                r1.f39850j = r0;
                r2 = r2.f38788a;
                r1.f39848h = r2;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.<init>(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder):void");
            }

            private Argument() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = -1;
                r1.f39849i = r0;
                r1.f39850j = r0;
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.f25891b;
                r1.f39848h = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.<init>():void");
            }

            public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument m40191f() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = f39843g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.f():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument");
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r7.<init>();
                r0 = -1;
                r7.f39849i = r0;
                r7.f39850j = r0;
                r7.m40192j();
                r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
                r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
                r2 = 0;
                r3 = 1;
            L_0x0015:
                if (r2 != 0) goto L_0x00ab;
            L_0x0017:
                r4 = r8.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 == 0) goto L_0x0080;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x001d:
                r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 == r5) goto L_0x0067;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0021:
                r5 = 18;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 == r5) goto L_0x003d;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0025:
                r5 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 == r5) goto L_0x0030;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0029:
                r4 = r7.mo7294a(r8, r1, r9, r4);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x002f:
                goto L_0x0080;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0030:
                r4 = r7.f39844c;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39844c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39847f = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x003d:
                r4 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r5 = r7.f39844c;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r6 = 2;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r5 = r5 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r5 != r6) goto L_0x004a;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0044:
                r4 = r7.f39846e;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r4.m41806t();	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x004a:
                r5 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r5 = r8.m27483a(r5, r9);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r5 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r5;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39846e = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r4 == 0) goto L_0x0061;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0056:
                r5 = r7.f39846e;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r4.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39846e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0061:
                r4 = r7.f39844c;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r4 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39844c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0067:
                r5 = r8.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.m33525a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                if (r6 != 0) goto L_0x0078;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0071:
                r1.m27502b(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r1.m27502b(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
            L_0x0078:
                r4 = r7.f39844c;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39844c = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                r7.f39845d = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0091, IOException -> 0x0084 }
                goto L_0x0015;
            L_0x0080:
                r2 = r3;
                goto L_0x0015;
            L_0x0082:
                r8 = move-exception;
                goto L_0x0095;
            L_0x0084:
                r8 = move-exception;
                r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0082 }
                r8 = r8.getMessage();	 Catch:{ all -> 0x0082 }
                r9.<init>(r8);	 Catch:{ all -> 0x0082 }
                r9.f25930a = r7;	 Catch:{ all -> 0x0082 }
                throw r9;	 Catch:{ all -> 0x0082 }
            L_0x0091:
                r8 = move-exception;	 Catch:{ all -> 0x0082 }
                r8.f25930a = r7;	 Catch:{ all -> 0x0082 }
                throw r8;	 Catch:{ all -> 0x0082 }
            L_0x0095:
                r1.m27501b();	 Catch:{ IOException -> 0x0098, all -> 0x009f }
            L_0x0098:
                r9 = r0.m27451a();
                r7.f39848h = r9;
                goto L_0x00a7;
            L_0x009f:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39848h = r9;
                throw r8;
            L_0x00a7:
                r7.mo7295b();
                throw r8;
            L_0x00ab:
                r1.m27501b();	 Catch:{ IOException -> 0x00ae, all -> 0x00b5 }
            L_0x00ae:
                r8 = r0.m27451a();
                r7.f39848h = r8;
                goto L_0x00bd;
            L_0x00b5:
                r8 = move-exception;
                r9 = r0.m27451a();
                r7.f39848h = r9;
                throw r8;
            L_0x00bd:
                r7.mo7295b();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
            }

            static {
                Argument argument = new Argument();
                f39843g = argument;
                argument.m40192j();
            }

            public final kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument> mo7112a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f39842b;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.a():kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Argument>");
            }

            public final boolean m40198h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f39844c;
                r1 = 2;
                r0 = r0 & r1;
                if (r0 != r1) goto L_0x0008;
            L_0x0006:
                r0 = 1;
                return r0;
            L_0x0008:
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.h():boolean");
            }

            public final boolean m40199i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f39844c;
                r1 = 4;
                r0 = r0 & r1;
                if (r0 != r1) goto L_0x0008;
            L_0x0006:
                r0 = 1;
                return r0;
            L_0x0008:
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.i():boolean");
            }

            private void m40192j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.INV;
                r1.f39845d = r0;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                r1.f39846e = r0;
                r0 = 0;
                r1.f39847f = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.j():void");
            }

            public final boolean mo7303g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f39849i;
                r1 = 1;
                if (r0 != r1) goto L_0x0006;
            L_0x0005:
                return r1;
            L_0x0006:
                r2 = 0;
                if (r0 != 0) goto L_0x000a;
            L_0x0009:
                return r2;
            L_0x000a:
                r0 = r3.m40198h();
                if (r0 == 0) goto L_0x001b;
            L_0x0010:
                r0 = r3.f39846e;
                r0 = r0.mo7303g();
                if (r0 != 0) goto L_0x001b;
            L_0x0018:
                r3.f39849i = r2;
                return r2;
            L_0x001b:
                r3.f39849i = r1;
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.g():boolean");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder();
                r0 = r0.m40179a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.e():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Builder();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.c():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f39843g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }
        }

        public static final class Builder extends ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int f40435c;
            private List<Argument> f40436d = Collections.emptyList();
            private boolean f40437e;
            private int f40438f;
            private Type f40439g = Type.m41783f();
            private int f40440h;
            private int f40441i;
            private int f40442j;
            private int f40443k;
            private int f40444l;
            private Type f40445m = Type.m41783f();
            private int f40446n;
            private Type f40447o = Type.m41783f();
            private int f40448p;
            private int f40449q;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m41754k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.a():kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r1 = r0.m41752c(r1, r2);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.a(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m41754k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.b():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$Builder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r1, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r1 = r0.m41752c(r1, r2);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.b(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
            }

            public final /* synthetic */ java.lang.Object clone() throws java.lang.CloneNotSupportedException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m41754k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.clone():java.lang.Object");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder mo7612e() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m41754k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.e():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableBuilder");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7302f() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m41767h();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.f():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }

            private Builder() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = java.util.Collections.emptyList();
                r1.f40436d = r0;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                r1.f40439g = r0;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                r1.f40445m = r0;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                r1.f40447o = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.<init>():void");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type m41767h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.m41768i();
                r1 = r0.mo7303g();
                if (r1 != 0) goto L_0x0010;
            L_0x000a:
                r0 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
                r0.<init>();
                throw r0;
            L_0x0010:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.h():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type m41768i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type;
                r1 = 0;
                r0.<init>(r6, r1);
                r2 = r6.f40435c;
                r3 = r6.f40435c;
                r4 = 1;
                r3 = r3 & r4;
                if (r3 != r4) goto L_0x001c;
            L_0x000e:
                r3 = r6.f40436d;
                r3 = java.util.Collections.unmodifiableList(r3);
                r6.f40436d = r3;
                r3 = r6.f40435c;
                r3 = r3 & -2;
                r6.f40435c = r3;
            L_0x001c:
                r3 = r6.f40436d;
                r0.f40453e = r3;
                r3 = r2 & 2;
                r5 = 2;
                if (r3 != r5) goto L_0x0027;
            L_0x0026:
                r1 = r4;
            L_0x0027:
                r3 = r6.f40437e;
                r0.f40454f = r3;
                r3 = r2 & 4;
                r4 = 4;
                if (r3 != r4) goto L_0x0033;
            L_0x0031:
                r1 = r1 | 2;
            L_0x0033:
                r3 = r6.f40438f;
                r0.f40455g = r3;
                r3 = r2 & 8;
                r4 = 8;
                if (r3 != r4) goto L_0x0040;
            L_0x003e:
                r1 = r1 | 4;
            L_0x0040:
                r3 = r6.f40439g;
                r0.f40456h = r3;
                r3 = r2 & 16;
                r4 = 16;
                if (r3 != r4) goto L_0x004d;
            L_0x004b:
                r1 = r1 | 8;
            L_0x004d:
                r3 = r6.f40440h;
                r0.f40457i = r3;
                r3 = r2 & 32;
                r4 = 32;
                if (r3 != r4) goto L_0x005a;
            L_0x0058:
                r1 = r1 | 16;
            L_0x005a:
                r3 = r6.f40441i;
                r0.f40458j = r3;
                r3 = r2 & 64;
                r4 = 64;
                if (r3 != r4) goto L_0x0067;
            L_0x0065:
                r1 = r1 | 32;
            L_0x0067:
                r3 = r6.f40442j;
                r0.f40459k = r3;
                r3 = r2 & 128;
                r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                if (r3 != r4) goto L_0x0074;
            L_0x0072:
                r1 = r1 | 64;
            L_0x0074:
                r3 = r6.f40443k;
                r0.f40460l = r3;
                r3 = r2 & 256;
                r4 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                if (r3 != r4) goto L_0x0081;
            L_0x007f:
                r1 = r1 | 128;
            L_0x0081:
                r3 = r6.f40444l;
                r0.f40461m = r3;
                r3 = r2 & 512;
                r4 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
                if (r3 != r4) goto L_0x008e;
            L_0x008c:
                r1 = r1 | 256;
            L_0x008e:
                r3 = r6.f40445m;
                r0.f40462n = r3;
                r3 = r2 & 1024;
                r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
                if (r3 != r4) goto L_0x009b;
            L_0x0099:
                r1 = r1 | 512;
            L_0x009b:
                r3 = r6.f40446n;
                r0.f40463o = r3;
                r3 = r2 & 2048;
                r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                if (r3 != r4) goto L_0x00a8;
            L_0x00a6:
                r1 = r1 | 1024;
            L_0x00a8:
                r3 = r6.f40447o;
                r0.f40464p = r3;
                r3 = r2 & 4096;
                r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
                if (r3 != r4) goto L_0x00b5;
            L_0x00b3:
                r1 = r1 | 2048;
            L_0x00b5:
                r3 = r6.f40448p;
                r0.f40465q = r3;
                r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
                r2 = r2 & r3;
                if (r2 != r3) goto L_0x00c1;
            L_0x00bf:
                r1 = r1 | 4096;
            L_0x00c1:
                r2 = r6.f40449q;
                r0.f40466r = r2;
                r0.f40452d = r1;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.i():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder m41758a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                if (r7 != r0) goto L_0x0007;
            L_0x0006:
                return r6;
            L_0x0007:
                r0 = r7.f40453e;
                r0 = r0.isEmpty();
                r1 = 1;
                if (r0 != 0) goto L_0x0043;
            L_0x0012:
                r0 = r6.f40436d;
                r0 = r0.isEmpty();
                if (r0 == 0) goto L_0x0027;
            L_0x001a:
                r0 = r7.f40453e;
                r6.f40436d = r0;
                r0 = r6.f40435c;
                r0 = r0 & -2;
                r6.f40435c = r0;
                goto L_0x0043;
            L_0x0027:
                r0 = r6.f40435c;
                r0 = r0 & r1;
                if (r0 == r1) goto L_0x003a;
            L_0x002c:
                r0 = new java.util.ArrayList;
                r2 = r6.f40436d;
                r0.<init>(r2);
                r6.f40436d = r0;
                r0 = r6.f40435c;
                r0 = r0 | r1;
                r6.f40435c = r0;
            L_0x003a:
                r0 = r6.f40436d;
                r2 = r7.f40453e;
                r0.addAll(r2);
            L_0x0043:
                r0 = r7.f40452d;
                r0 = r0 & r1;
                r2 = 0;
                if (r0 != r1) goto L_0x004b;
            L_0x0049:
                r0 = r1;
                goto L_0x004c;
            L_0x004b:
                r0 = r2;
            L_0x004c:
                if (r0 == 0) goto L_0x0053;
            L_0x004e:
                r0 = r7.f40454f;
                r6.m41759a(r0);
            L_0x0053:
                r0 = r7.m41795i();
                if (r0 == 0) goto L_0x0063;
            L_0x0059:
                r0 = r7.f40455g;
                r3 = r6.f40435c;
                r3 = r3 | 4;
                r6.f40435c = r3;
                r6.f40438f = r0;
            L_0x0063:
                r0 = r7.m41796j();
                if (r0 == 0) goto L_0x0092;
            L_0x0069:
                r0 = r7.f40456h;
                r3 = r6.f40435c;
                r4 = 8;
                r3 = r3 & r4;
                if (r3 != r4) goto L_0x008b;
            L_0x0072:
                r3 = r6.f40439g;
                r5 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                if (r3 == r5) goto L_0x008b;
            L_0x007a:
                r3 = r6.f40439g;
                r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r3);
                r0 = r3.m41758a(r0);
                r0 = r0.m41768i();
                r6.f40439g = r0;
                goto L_0x008d;
            L_0x008b:
                r6.f40439g = r0;
            L_0x008d:
                r0 = r6.f40435c;
                r0 = r0 | r4;
                r6.f40435c = r0;
            L_0x0092:
                r0 = r7.m41797k();
                if (r0 == 0) goto L_0x00a2;
            L_0x0098:
                r0 = r7.f40457i;
                r3 = r6.f40435c;
                r3 = r3 | 16;
                r6.f40435c = r3;
                r6.f40440h = r0;
            L_0x00a2:
                r0 = r7.m41798l();
                if (r0 == 0) goto L_0x00b2;
            L_0x00a8:
                r0 = r7.f40458j;
                r3 = r6.f40435c;
                r3 = r3 | 32;
                r6.f40435c = r3;
                r6.f40441i = r0;
            L_0x00b2:
                r0 = r7.m41799m();
                if (r0 == 0) goto L_0x00c2;
            L_0x00b8:
                r0 = r7.f40459k;
                r3 = r6.f40435c;
                r3 = r3 | 64;
                r6.f40435c = r3;
                r6.f40442j = r0;
            L_0x00c2:
                r0 = r7.m41800n();
                if (r0 == 0) goto L_0x00d2;
            L_0x00c8:
                r0 = r7.f40460l;
                r3 = r6.f40435c;
                r3 = r3 | 128;
                r6.f40435c = r3;
                r6.f40443k = r0;
            L_0x00d2:
                r0 = r7.m41801o();
                if (r0 == 0) goto L_0x00e2;
            L_0x00d8:
                r0 = r7.f40461m;
                r3 = r6.f40435c;
                r3 = r3 | 256;
                r6.f40435c = r3;
                r6.f40444l = r0;
            L_0x00e2:
                r0 = r7.m41802p();
                if (r0 == 0) goto L_0x0111;
            L_0x00e8:
                r0 = r7.f40462n;
                r3 = r6.f40435c;
                r4 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
                r3 = r3 & r4;
                if (r3 != r4) goto L_0x010a;
            L_0x00f1:
                r3 = r6.f40445m;
                r5 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                if (r3 == r5) goto L_0x010a;
            L_0x00f9:
                r3 = r6.f40445m;
                r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r3);
                r0 = r3.m41758a(r0);
                r0 = r0.m41768i();
                r6.f40445m = r0;
                goto L_0x010c;
            L_0x010a:
                r6.f40445m = r0;
            L_0x010c:
                r0 = r6.f40435c;
                r0 = r0 | r4;
                r6.f40435c = r0;
            L_0x0111:
                r0 = r7.m41803q();
                if (r0 == 0) goto L_0x0121;
            L_0x0117:
                r0 = r7.f40463o;
                r3 = r6.f40435c;
                r3 = r3 | 1024;
                r6.f40435c = r3;
                r6.f40446n = r0;
            L_0x0121:
                r0 = r7.m41804r();
                if (r0 == 0) goto L_0x0150;
            L_0x0127:
                r0 = r7.f40464p;
                r3 = r6.f40435c;
                r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                r3 = r3 & r4;
                if (r3 != r4) goto L_0x0149;
            L_0x0130:
                r3 = r6.f40447o;
                r5 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                if (r3 == r5) goto L_0x0149;
            L_0x0138:
                r3 = r6.f40447o;
                r3 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41771a(r3);
                r0 = r3.m41758a(r0);
                r0 = r0.m41768i();
                r6.f40447o = r0;
                goto L_0x014b;
            L_0x0149:
                r6.f40447o = r0;
            L_0x014b:
                r0 = r6.f40435c;
                r0 = r0 | r4;
                r6.f40435c = r0;
            L_0x0150:
                r0 = r7.m41805s();
                r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
                if (r0 == 0) goto L_0x0161;
            L_0x0158:
                r0 = r7.f40465q;
                r4 = r6.f40435c;
                r4 = r4 | r3;
                r6.f40435c = r4;
                r6.f40448p = r0;
            L_0x0161:
                r0 = r7.f40452d;
                r0 = r0 & r3;
                if (r0 != r3) goto L_0x0167;
            L_0x0166:
                goto L_0x0168;
            L_0x0167:
                r1 = r2;
            L_0x0168:
                if (r1 == 0) goto L_0x0174;
            L_0x016a:
                r0 = r7.f40466r;
                r1 = r6.f40435c;
                r1 = r1 | 8192;
                r6.f40435c = r1;
                r6.f40449q = r0;
            L_0x0174:
                r6.m39924a(r7);
                r0 = r6.f38788a;
                r7 = r7.f40467t;
                r7 = r0.m27460a(r7);
                r6.f38788a = r7;
                return r6;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder");
            }

            private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder m41752c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r3 = r1.mo6731a(r3, r4);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r2.m41758a(r3);
                return r2;
            L_0x000d:
                r3 = move-exception;
                goto L_0x0017;
            L_0x000f:
                r3 = move-exception;
                r4 = r3.f25930a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r4;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
                throw r3;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x000d, all -> 0x0015, all -> 0x000d, all -> 0x0015 }
            L_0x0015:
                r3 = move-exception;
                r0 = r4;
            L_0x0017:
                if (r0 == 0) goto L_0x001c;
            L_0x0019:
                r2.m41758a(r0);
            L_0x001c:
                throw r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.c(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder");
            }

            public final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder m41759a(boolean r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f40435c;
                r0 = r0 | 2;
                r1.f40435c = r0;
                r1.f40437e = r2;
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.a(boolean):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder");
            }

            private kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder m41754k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder;
                r0.<init>();
                r1 = r2.m41768i();
                r0 = r0.m41758a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.k():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder");
            }

            public final boolean mo7303g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = 0;
                r1 = r0;
            L_0x0002:
                r2 = r4.f40436d;
                r2 = r2.size();
                if (r1 >= r2) goto L_0x001c;
            L_0x000a:
                r2 = r4.f40436d;
                r2 = r2.get(r1);
                r2 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument) r2;
                r2 = r2.mo7303g();
                if (r2 != 0) goto L_0x0019;
            L_0x0018:
                return r0;
            L_0x0019:
                r1 = r1 + 1;
                goto L_0x0002;
            L_0x001c:
                r1 = r4.f40435c;
                r2 = 8;
                r1 = r1 & r2;
                r3 = 1;
                if (r1 != r2) goto L_0x0026;
            L_0x0024:
                r1 = r3;
                goto L_0x0027;
            L_0x0026:
                r1 = r0;
            L_0x0027:
                if (r1 == 0) goto L_0x0032;
            L_0x0029:
                r1 = r4.f40439g;
                r1 = r1.mo7303g();
                if (r1 != 0) goto L_0x0032;
            L_0x0031:
                return r0;
            L_0x0032:
                r1 = r4.f40435c;
                r2 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
                r1 = r1 & r2;
                if (r1 != r2) goto L_0x003b;
            L_0x0039:
                r1 = r3;
                goto L_0x003c;
            L_0x003b:
                r1 = r0;
            L_0x003c:
                if (r1 == 0) goto L_0x0047;
            L_0x003e:
                r1 = r4.f40445m;
                r1 = r1.mo7303g();
                if (r1 != 0) goto L_0x0047;
            L_0x0046:
                return r0;
            L_0x0047:
                r1 = r4.f40435c;
                r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                r1 = r1 & r2;
                if (r1 != r2) goto L_0x0050;
            L_0x004e:
                r1 = r3;
                goto L_0x0051;
            L_0x0050:
                r1 = r0;
            L_0x0051:
                if (r1 == 0) goto L_0x005c;
            L_0x0053:
                r1 = r4.f40447o;
                r1 = r1.mo7303g();
                if (r1 != 0) goto L_0x005c;
            L_0x005b:
                return r0;
            L_0x005c:
                r1 = r4.f39730b;
                r1 = r1.m27523e();
                if (r1 != 0) goto L_0x0065;
            L_0x0064:
                return r0;
            L_0x0065:
                return r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.g():boolean");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite mo7301c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m41783f();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder.c():kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite");
            }
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m41806t();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.e():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
        }

        private Type(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type, ?> r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r1.<init>(r2);
            r0 = -1;
            r1.f40468u = r0;
            r1.f40469v = r0;
            r2 = r2.f38788a;
            r1.f40467t = r2;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.<init>(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableBuilder):void");
        }

        private Type() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r1.<init>();
            r0 = -1;
            r1.f40468u = r0;
            r1.f40469v = r0;
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.f25891b;
            r1.f40467t = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.<init>():void");
        }

        public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type m41783f() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f40451s;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f():kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type");
        }

        private Type(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.<init>();
            r0 = -1;
            r8.f40468u = r0;
            r8.f40469v = r0;
            r8.m41788u();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            if (r2 != 0) goto L_0x0190;
        L_0x0018:
            r5 = r9.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            switch(r5) {
                case 0: goto L_0x0153;
                case 8: goto L_0x0145;
                case 18: goto L_0x012b;
                case 24: goto L_0x011e;
                case 32: goto L_0x0110;
                case 42: goto L_0x00e2;
                case 48: goto L_0x00d4;
                case 56: goto L_0x00c6;
                case 64: goto L_0x00b8;
                case 72: goto L_0x00aa;
                case 82: goto L_0x007b;
                case 88: goto L_0x006e;
                case 96: goto L_0x0061;
                case 106: goto L_0x0033;
                case 112: goto L_0x0026;
                default: goto L_0x0020;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0020:
            r5 = r8.mo7294a(r9, r1, r10, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0156;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0026:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 2048;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40465q = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0033:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 & r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r5 != r7) goto L_0x0044;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x003a:
            r5 = r8.f40464p;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0044:
            r5 = f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27483a(r5, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40464p = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r6 == 0) goto L_0x005b;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0050:
            r5 = r8.f40464p;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r6.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40464p = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x005b:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0061:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 128;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40461m = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x006e:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 512;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40463o = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x007b:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r7 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 & r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r5 != r7) goto L_0x008c;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0082:
            r5 = r8.f40462n;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x008c:
            r5 = f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27483a(r5, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40462n = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r6 == 0) goto L_0x00a3;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0098:
            r5 = r8.f40462n;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r6.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40462n = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00a3:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00aa:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40460l = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00b8:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 8;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40457i = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00c6:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40459k = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00d4:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40458j = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00e2:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r7 = 4;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 & r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r5 != r7) goto L_0x00f2;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00e8:
            r5 = r8.f40456h;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00f2:
            r5 = f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27483a(r5, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40456h = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r6 == 0) goto L_0x0109;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x00fe:
            r5 = r8.f40456h;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6.m41758a(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r6.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40456h = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0109:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | r7;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0110:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40455g = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x011e:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27489c();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40454f = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x012b:
            r5 = r4 & 1;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            if (r5 == r3) goto L_0x0138;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x012f:
            r5 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40453e = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r4 = r4 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0138:
            r5 = r8.f40453e;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.f39842b;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r6 = r9.m27483a(r6, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5.add(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
        L_0x0145:
            r5 = r8.f40452d;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r5 | 4096;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40452d = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r5 = r9.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            r8.f40466r = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0168, IOException -> 0x015b }
            goto L_0x0016;
        L_0x0153:
            r2 = r3;
            goto L_0x0016;
        L_0x0156:
            if (r5 != 0) goto L_0x0016;
        L_0x0158:
            goto L_0x0153;
        L_0x0159:
            r9 = move-exception;
            goto L_0x016c;
        L_0x015b:
            r9 = move-exception;
            r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0159 }
            r9 = r9.getMessage();	 Catch:{ all -> 0x0159 }
            r10.<init>(r9);	 Catch:{ all -> 0x0159 }
            r10.f25930a = r8;	 Catch:{ all -> 0x0159 }
            throw r10;	 Catch:{ all -> 0x0159 }
        L_0x0168:
            r9 = move-exception;	 Catch:{ all -> 0x0159 }
            r9.f25930a = r8;	 Catch:{ all -> 0x0159 }
            throw r9;	 Catch:{ all -> 0x0159 }
        L_0x016c:
            r10 = r4 & 1;
            if (r10 != r3) goto L_0x0178;
        L_0x0170:
            r10 = r8.f40453e;
            r10 = java.util.Collections.unmodifiableList(r10);
            r8.f40453e = r10;
        L_0x0178:
            r1.m27501b();	 Catch:{ IOException -> 0x017b, all -> 0x0182 }
        L_0x017b:
            r10 = r0.m27451a();
            r8.f40467t = r10;
            goto L_0x018a;
        L_0x0182:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f40467t = r10;
            throw r9;
        L_0x018a:
            r10 = r8.f39732b;
            r10.m27521c();
            throw r9;
        L_0x0190:
            r9 = r4 & 1;
            if (r9 != r3) goto L_0x019c;
        L_0x0194:
            r9 = r8.f40453e;
            r9 = java.util.Collections.unmodifiableList(r9);
            r8.f40453e = r9;
        L_0x019c:
            r1.m27501b();	 Catch:{ IOException -> 0x019f, all -> 0x01a6 }
        L_0x019f:
            r9 = r0.m27451a();
            r8.f40467t = r9;
            goto L_0x01ae;
        L_0x01a6:
            r9 = move-exception;
            r10 = r0.m27451a();
            r8.f40467t = r10;
            throw r9;
        L_0x01ae:
            r9 = r8.f39732b;
            r9.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Type type = new Type();
            f40451s = type;
            type.m41788u();
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type> mo7112a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f40450c;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.a():kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type>");
        }

        public final int m41794h() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f40453e;
            r0 = r0.size();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.h():int");
        }

        public final boolean m41795i() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 2;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0008;
        L_0x0006:
            r0 = 1;
            return r0;
        L_0x0008:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.i():boolean");
        }

        public final boolean m41796j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 4;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0008;
        L_0x0006:
            r0 = 1;
            return r0;
        L_0x0008:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.j():boolean");
        }

        public final boolean m41797k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 8;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.k():boolean");
        }

        public final boolean m41798l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 16;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.l():boolean");
        }

        public final boolean m41799m() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 32;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.m():boolean");
        }

        public final boolean m41800n() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 64;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.n():boolean");
        }

        public final boolean m41801o() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.o():boolean");
        }

        public final boolean m41802p() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.p():boolean");
        }

        public final boolean m41803q() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.q():boolean");
        }

        public final boolean m41804r() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f40452d;
            r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = r0 & r1;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
            return r0;
        L_0x0009:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.r():boolean");
        }

        public final boolean m41805s() {
            return (this.f40452d & MPEGConst.CODE_END) == MPEGConst.CODE_END;
        }

        private void m41788u() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = java.util.Collections.emptyList();
            r2.f40453e = r0;
            r0 = 0;
            r2.f40454f = r0;
            r2.f40455g = r0;
            r1 = f40451s;
            r2.f40456h = r1;
            r2.f40457i = r0;
            r2.f40458j = r0;
            r2.f40459k = r0;
            r2.f40460l = r0;
            r2.f40461m = r0;
            r1 = f40451s;
            r2.f40462n = r1;
            r2.f40463o = r0;
            r1 = f40451s;
            r2.f40464p = r1;
            r2.f40465q = r0;
            r2.f40466r = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.u():void");
        }

        public final boolean mo7303g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f40468u;
            r1 = 1;
            if (r0 != r1) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r2 = 0;
            if (r0 != 0) goto L_0x000a;
        L_0x0009:
            return r2;
        L_0x000a:
            r0 = r2;
        L_0x000b:
            r3 = r4.m41794h();
            if (r0 >= r3) goto L_0x0025;
        L_0x0011:
            r3 = r4.f40453e;
            r3 = r3.get(r0);
            r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument) r3;
            r3 = r3.mo7303g();
            if (r3 != 0) goto L_0x0022;
        L_0x001f:
            r4.f40468u = r2;
            return r2;
        L_0x0022:
            r0 = r0 + 1;
            goto L_0x000b;
        L_0x0025:
            r0 = r4.m41796j();
            if (r0 == 0) goto L_0x0036;
        L_0x002b:
            r0 = r4.f40456h;
            r0 = r0.mo7303g();
            if (r0 != 0) goto L_0x0036;
        L_0x0033:
            r4.f40468u = r2;
            return r2;
        L_0x0036:
            r0 = r4.m41802p();
            if (r0 == 0) goto L_0x0047;
        L_0x003c:
            r0 = r4.f40462n;
            r0 = r0.mo7303g();
            if (r0 != 0) goto L_0x0047;
        L_0x0044:
            r4.f40468u = r2;
            return r2;
        L_0x0047:
            r0 = r4.m41804r();
            if (r0 == 0) goto L_0x0058;
        L_0x004d:
            r0 = r4.f40464p;
            r0 = r0.mo7303g();
            if (r0 != 0) goto L_0x0058;
        L_0x0055:
            r4.f40468u = r2;
            return r2;
        L_0x0058:
            r0 = r4.f39732b;
            r0 = r0.m27523e();
            if (r0 != 0) goto L_0x0063;
        L_0x0060:
            r4.f40468u = r2;
            return r2;
        L_0x0063:
            r4.f40468u = r1;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.g():boolean");
        }

        public static kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder m41771a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder();
            r1 = r0.m41758a(r1);
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.a(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type):kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder");
        }

        public final Builder m41806t() {
            return new Builder().m41758a(this);
        }

        public final /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite mo7111d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f40451s;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.d():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = new kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Builder();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.c():kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
        }
    }

    public static final class TypeAlias extends ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> f40480c = new C27851();
        private static final TypeAlias f40481n;
        int f40482d;
        public int f40483e;
        public int f40484f;
        public List<TypeParameter> f40485g;
        public Type f40486h;
        public int f40487i;
        public Type f40488j;
        public int f40489k;
        public List<Annotation> f40490l;
        int f40491m;
        private final ByteString f40492o;
        private byte f40493p;
        private int f40494q;

        static class C27851 extends AbstractParser<TypeAlias> {
            C27851() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private int f40470c;
            private int f40471d = 6;
            private int f40472e;
            private List<TypeParameter> f40473f = Collections.emptyList();
            private Type f40474g = Type.m41783f();
            private int f40475h;
            private Type f40476i = Type.m41783f();
            private int f40477j;
            private List<Annotation> f40478k = Collections.emptyList();
            private int f40479l;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41809i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41807c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41809i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41807c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41809i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41809i();
            }

            private Builder() {
            }

            private TypeAlias m41810j() {
                int i = 0;
                TypeAlias typeAlias = new TypeAlias((ExtendableBuilder) this);
                int i2 = this.f40470c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                typeAlias.f40483e = this.f40471d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                typeAlias.f40484f = this.f40472e;
                if ((this.f40470c & 4) == 4) {
                    this.f40473f = Collections.unmodifiableList(this.f40473f);
                    this.f40470c &= -5;
                }
                typeAlias.f40485g = this.f40473f;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                typeAlias.f40486h = this.f40474g;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                typeAlias.f40487i = this.f40475h;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                typeAlias.f40488j = this.f40476i;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                typeAlias.f40489k = this.f40477j;
                if ((this.f40470c & 128) == 128) {
                    this.f40478k = Collections.unmodifiableList(this.f40478k);
                    this.f40470c &= -129;
                }
                typeAlias.f40490l = this.f40478k;
                if ((i2 & 256) == 256) {
                    i |= 64;
                }
                typeAlias.f40491m = this.f40479l;
                typeAlias.f40482d = i;
                return typeAlias;
            }

            public final Builder m41814a(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.m41835f()) {
                    return this;
                }
                Type type;
                int i = 1;
                if (((typeAlias.f40482d & 1) == 1 ? 1 : 0) != 0) {
                    int i2 = typeAlias.f40483e;
                    this.f40470c |= 1;
                    this.f40471d = i2;
                }
                if (typeAlias.m41842h()) {
                    i2 = typeAlias.f40484f;
                    this.f40470c |= 2;
                    this.f40472e = i2;
                }
                if (!typeAlias.f40485g.isEmpty()) {
                    if (this.f40473f.isEmpty()) {
                        this.f40473f = typeAlias.f40485g;
                        this.f40470c &= -5;
                    } else {
                        if ((this.f40470c & 4) != 4) {
                            this.f40473f = new ArrayList(this.f40473f);
                            this.f40470c |= 4;
                        }
                        this.f40473f.addAll(typeAlias.f40485g);
                    }
                }
                if (typeAlias.m41843i()) {
                    type = typeAlias.f40486h;
                    if ((this.f40470c & 8) != 8 || this.f40474g == Type.m41783f()) {
                        this.f40474g = type;
                    } else {
                        this.f40474g = Type.m41771a(this.f40474g).m41758a(type).m41768i();
                    }
                    this.f40470c |= 8;
                }
                if (typeAlias.m41844j()) {
                    i2 = typeAlias.f40487i;
                    this.f40470c |= 16;
                    this.f40475h = i2;
                }
                if (typeAlias.m41845k()) {
                    type = typeAlias.f40488j;
                    if ((this.f40470c & 32) != 32 || this.f40476i == Type.m41783f()) {
                        this.f40476i = type;
                    } else {
                        this.f40476i = Type.m41771a(this.f40476i).m41758a(type).m41768i();
                    }
                    this.f40470c |= 32;
                }
                if (typeAlias.m41846l()) {
                    i2 = typeAlias.f40489k;
                    this.f40470c |= 64;
                    this.f40477j = i2;
                }
                if (!typeAlias.f40490l.isEmpty()) {
                    if (this.f40478k.isEmpty()) {
                        this.f40478k = typeAlias.f40490l;
                        this.f40470c &= -129;
                    } else {
                        if ((this.f40470c & 128) != 128) {
                            this.f40478k = new ArrayList(this.f40478k);
                            this.f40470c |= 128;
                        }
                        this.f40478k.addAll(typeAlias.f40490l);
                    }
                }
                if ((typeAlias.f40482d & 64) != 64) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = typeAlias.f40491m;
                    this.f40470c |= 256;
                    this.f40479l = i2;
                }
                m39924a((ExtendableMessage) typeAlias);
                this.f38788a = this.f38788a.m27460a(typeAlias.f40492o);
                return this;
            }

            private Builder m41807c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeAlias typeAlias;
                TypeAlias typeAlias2 = null;
                try {
                    m41814a((TypeAlias) TypeAlias.f40480c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    typeAlias = (TypeAlias) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    typeAlias2 = typeAlias;
                }
                if (typeAlias2 != null) {
                    m41814a(typeAlias2);
                }
                throw codedInputStream2;
            }

            private Builder m41809i() {
                return new Builder().m41814a(m41810j());
            }

            public final boolean mo7303g() {
                if (!((this.f40470c & 2) == 2)) {
                    return false;
                }
                int i;
                for (i = 0; i < this.f40473f.size(); i++) {
                    if (!((TypeParameter) this.f40473f.get(i)).mo7303g()) {
                        return false;
                    }
                }
                if (((this.f40470c & 8) == 8) && !this.f40474g.mo7303g()) {
                    return false;
                }
                if (((this.f40470c & 32) == 32) && !this.f40476i.mo7303g()) {
                    return false;
                }
                for (i = 0; i < this.f40478k.size(); i++) {
                    if (!((Annotation) this.f40478k.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return TypeAlias.m41835f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return TypeAlias.m41835f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41810j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private TypeAlias(ExtendableBuilder<TypeAlias, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40493p = (byte) -1;
            this.f40494q = -1;
            this.f40492o = extendableBuilder.f38788a;
        }

        private TypeAlias() {
            this.f40493p = (byte) -1;
            this.f40494q = -1;
            this.f40492o = ByteString.f25891b;
        }

        public static TypeAlias m41835f() {
            return f40481n;
        }

        private TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r13, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r14) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r12 = this;
            r12.<init>();
            r0 = -1;
            r12.f40493p = r0;
            r12.f40494q = r0;
            r12.m41836m();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            r6 = 4;
            if (r2 != 0) goto L_0x015b;
        L_0x001b:
            r7 = r13.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == 0) goto L_0x0115;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0021:
            r8 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r8) goto L_0x0108;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0025:
            r9 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r9) goto L_0x00fa;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0029:
            r10 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r10) goto L_0x00e0;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x002d:
            r10 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r11 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r10) goto L_0x00b7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0032:
            r10 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r10) goto L_0x00aa;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0036:
            r8 = 50;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r8) goto L_0x0081;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x003a:
            r8 = 56;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r8) goto L_0x0074;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x003e:
            r8 = 66;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r8) goto L_0x005b;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0042:
            r8 = 248; // 0xf8 float:3.48E-43 double:1.225E-321;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r8) goto L_0x004e;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0046:
            r7 = r12.mo7294a(r13, r1, r14, r7);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x004c:
            goto L_0x0115;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x004e:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | 64;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40491m = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x005b:
            r7 = r4 & 128;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r5) goto L_0x0068;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x005f:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40490l = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r4 = r4 | 128;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0068:
            r7 = r12.f40490l;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.f39776b;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r8 = r13.m27483a(r8, r14);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0074:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40489k = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0081:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 & r9;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 != r9) goto L_0x008c;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0086:
            r7 = r12.f40488j;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r11 = r7.m41806t();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x008c:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27483a(r7, r14);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40488j = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r11 == 0) goto L_0x00a3;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0098:
            r7 = r12.f40488j;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r11.m41758a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r11.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40488j = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00a3:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | r9;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00aa:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40487i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00b7:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 != r6) goto L_0x00c2;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00bc:
            r7 = r12.f40486h;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r11 = r7.m41806t();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00c2:
            r7 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27483a(r7, r14);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40486h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r11 == 0) goto L_0x00d9;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00ce:
            r7 = r12.f40486h;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r11.m41758a(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r11.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40486h = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00d9:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00e0:
            r7 = r4 & 4;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            if (r7 == r6) goto L_0x00ed;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00e4:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40485g = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r4 = r4 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00ed:
            r7 = r12.f40485g;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.f40502c;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r8 = r13.m27483a(r8, r14);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x00fa:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40484f = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
        L_0x0108:
            r7 = r12.f40482d;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r7 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40482d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r7 = r13.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            r12.f40483e = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0127, IOException -> 0x011a }
            goto L_0x0016;
        L_0x0115:
            r2 = r3;
            goto L_0x0016;
        L_0x0118:
            r13 = move-exception;
            goto L_0x012b;
        L_0x011a:
            r13 = move-exception;
            r14 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0118 }
            r13 = r13.getMessage();	 Catch:{ all -> 0x0118 }
            r14.<init>(r13);	 Catch:{ all -> 0x0118 }
            r14.f25930a = r12;	 Catch:{ all -> 0x0118 }
            throw r14;	 Catch:{ all -> 0x0118 }
        L_0x0127:
            r13 = move-exception;	 Catch:{ all -> 0x0118 }
            r13.f25930a = r12;	 Catch:{ all -> 0x0118 }
            throw r13;	 Catch:{ all -> 0x0118 }
        L_0x012b:
            r14 = r4 & 4;
            if (r14 != r6) goto L_0x0137;
        L_0x012f:
            r14 = r12.f40485g;
            r14 = java.util.Collections.unmodifiableList(r14);
            r12.f40485g = r14;
        L_0x0137:
            r14 = r4 & 128;
            if (r14 != r5) goto L_0x0143;
        L_0x013b:
            r14 = r12.f40490l;
            r14 = java.util.Collections.unmodifiableList(r14);
            r12.f40490l = r14;
        L_0x0143:
            r1.m27501b();	 Catch:{ IOException -> 0x0146, all -> 0x014d }
        L_0x0146:
            r14 = r0.m27451a();
            r12.f40492o = r14;
            goto L_0x0155;
        L_0x014d:
            r13 = move-exception;
            r14 = r0.m27451a();
            r12.f40492o = r14;
            throw r13;
        L_0x0155:
            r14 = r12.f39732b;
            r14.m27521c();
            throw r13;
        L_0x015b:
            r13 = r4 & 4;
            if (r13 != r6) goto L_0x0167;
        L_0x015f:
            r13 = r12.f40485g;
            r13 = java.util.Collections.unmodifiableList(r13);
            r12.f40485g = r13;
        L_0x0167:
            r13 = r4 & 128;
            if (r13 != r5) goto L_0x0173;
        L_0x016b:
            r13 = r12.f40490l;
            r13 = java.util.Collections.unmodifiableList(r13);
            r12.f40490l = r13;
        L_0x0173:
            r1.m27501b();	 Catch:{ IOException -> 0x0176, all -> 0x017d }
        L_0x0176:
            r13 = r0.m27451a();
            r12.f40492o = r13;
            goto L_0x0185;
        L_0x017d:
            r13 = move-exception;
            r14 = r0.m27451a();
            r12.f40492o = r14;
            throw r13;
        L_0x0185:
            r13 = r12.f39732b;
            r13.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            TypeAlias typeAlias = new TypeAlias();
            f40481n = typeAlias;
            typeAlias.m41836m();
        }

        public final Parser<TypeAlias> mo7112a() {
            return f40480c;
        }

        public final boolean m41842h() {
            return (this.f40482d & 2) == 2;
        }

        public final boolean m41843i() {
            return (this.f40482d & 4) == 4;
        }

        public final boolean m41844j() {
            return (this.f40482d & 8) == 8;
        }

        public final boolean m41845k() {
            return (this.f40482d & 16) == 16;
        }

        public final boolean m41846l() {
            return (this.f40482d & 32) == 32;
        }

        private void m41836m() {
            this.f40483e = 6;
            this.f40484f = 0;
            this.f40485g = Collections.emptyList();
            this.f40486h = Type.m41783f();
            this.f40487i = 0;
            this.f40488j = Type.m41783f();
            this.f40489k = 0;
            this.f40490l = Collections.emptyList();
            this.f40491m = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f40493p;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (m41842h()) {
                int i = 0;
                while (i < this.f40485g.size()) {
                    if (((TypeParameter) this.f40485g.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40493p = (byte) 0;
                        return false;
                    }
                }
                if (m41843i() && !this.f40486h.mo7303g()) {
                    this.f40493p = (byte) 0;
                    return false;
                } else if (!m41845k() || this.f40488j.mo7303g()) {
                    i = 0;
                    while (i < this.f40490l.size()) {
                        if (((Annotation) this.f40490l.get(i)).mo7303g()) {
                            i++;
                        } else {
                            this.f40493p = (byte) 0;
                            return false;
                        }
                    }
                    if (this.f39732b.m27523e()) {
                        this.f40493p = (byte) 1;
                        return true;
                    }
                    this.f40493p = (byte) 0;
                    return false;
                } else {
                    this.f40493p = (byte) 0;
                    return false;
                }
            }
            this.f40493p = (byte) 0;
            return false;
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40481n;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41814a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class TypeParameter extends ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> f40502c = new C27861();
        private static final TypeParameter f40503k;
        int f40504d;
        public int f40505e;
        public int f40506f;
        public boolean f40507g;
        public Variance f40508h;
        public List<Type> f40509i;
        public List<Integer> f40510j;
        private final ByteString f40511l;
        private byte f40512m;
        private int f40513n;

        public enum Variance implements EnumLite {
            f33015a(0),
            OUT(1),
            INV(2);
            
            private static EnumLiteMap<Variance> f33018d;
            private final int f33020e;

            static class C25911 implements EnumLiteMap<Variance> {
                C25911() {
                }

                public final /* bridge */ /* synthetic */ EnumLite mo5921a(int i) {
                    return Variance.m33528a(i);
                }
            }

            static {
                f33018d = new C25911();
            }

            public final int mo5922a() {
                return this.f33020e;
            }

            public static Variance m33528a(int i) {
                switch (i) {
                    case 0:
                        return f33015a;
                    case 1:
                        return OUT;
                    case 2:
                        return INV;
                    default:
                        return 0;
                }
            }

            private Variance(int i) {
                this.f33020e = i;
            }
        }

        static class C27861 extends AbstractParser<TypeParameter> {
            C27861() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int f40495c;
            private int f40496d;
            private int f40497e;
            private boolean f40498f;
            private Variance f40499g = Variance.INV;
            private List<Type> f40500h = Collections.emptyList();
            private List<Integer> f40501i = Collections.emptyList();

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41849i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41847c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41849i();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41847c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41849i();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41849i();
            }

            private Builder() {
            }

            private TypeParameter m41850j() {
                int i = 0;
                TypeParameter typeParameter = new TypeParameter((ExtendableBuilder) this);
                int i2 = this.f40495c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                typeParameter.f40505e = this.f40496d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                typeParameter.f40506f = this.f40497e;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                typeParameter.f40507g = this.f40498f;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                typeParameter.f40508h = this.f40499g;
                if ((this.f40495c & 16) == 16) {
                    this.f40500h = Collections.unmodifiableList(this.f40500h);
                    this.f40495c &= -17;
                }
                typeParameter.f40509i = this.f40500h;
                if ((this.f40495c & 32) == 32) {
                    this.f40501i = Collections.unmodifiableList(this.f40501i);
                    this.f40495c &= -33;
                }
                typeParameter.f40510j = this.f40501i;
                typeParameter.f40504d = i;
                return typeParameter;
            }

            public final Builder m41854a(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.m41872f()) {
                    return this;
                }
                int i = 1;
                if (typeParameter.m41879h()) {
                    int i2 = typeParameter.f40505e;
                    this.f40495c |= 1;
                    this.f40496d = i2;
                }
                if (typeParameter.m41880i()) {
                    i2 = typeParameter.f40506f;
                    this.f40495c |= 2;
                    this.f40497e = i2;
                }
                if (((typeParameter.f40504d & 4) == 4 ? 1 : 0) != 0) {
                    boolean z = typeParameter.f40507g;
                    this.f40495c = 4 | this.f40495c;
                    this.f40498f = z;
                }
                if ((typeParameter.f40504d & 8) != 8) {
                    i = 0;
                }
                if (i != 0) {
                    Variance variance = typeParameter.f40508h;
                    if (variance == null) {
                        throw new NullPointerException();
                    }
                    this.f40495c |= 8;
                    this.f40499g = variance;
                }
                if (!typeParameter.f40509i.isEmpty()) {
                    if (this.f40500h.isEmpty()) {
                        this.f40500h = typeParameter.f40509i;
                        this.f40495c &= -17;
                    } else {
                        if ((this.f40495c & 16) != 16) {
                            this.f40500h = new ArrayList(this.f40500h);
                            this.f40495c |= 16;
                        }
                        this.f40500h.addAll(typeParameter.f40509i);
                    }
                }
                if (!typeParameter.f40510j.isEmpty()) {
                    if (this.f40501i.isEmpty()) {
                        this.f40501i = typeParameter.f40510j;
                        this.f40495c &= -33;
                    } else {
                        if ((this.f40495c & 32) != 32) {
                            this.f40501i = new ArrayList(this.f40501i);
                            this.f40495c |= 32;
                        }
                        this.f40501i.addAll(typeParameter.f40510j);
                    }
                }
                m39924a((ExtendableMessage) typeParameter);
                this.f38788a = this.f38788a.m27460a(typeParameter.f40511l);
                return this;
            }

            private Builder m41847c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeParameter typeParameter;
                TypeParameter typeParameter2 = null;
                try {
                    m41854a((TypeParameter) TypeParameter.f40502c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    typeParameter = (TypeParameter) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    typeParameter2 = typeParameter;
                }
                if (typeParameter2 != null) {
                    m41854a(typeParameter2);
                }
                throw codedInputStream2;
            }

            private Builder m41849i() {
                return new Builder().m41854a(m41850j());
            }

            public final boolean mo7303g() {
                if (!((this.f40495c & 1) == 1)) {
                    return false;
                }
                if (!((this.f40495c & 2) == 2)) {
                    return false;
                }
                for (int i = 0; i < this.f40500h.size(); i++) {
                    if (!((Type) this.f40500h.get(i)).mo7303g()) {
                        return false;
                    }
                }
                return this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return TypeParameter.m41872f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return TypeParameter.m41872f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite j = m41850j();
                if (j.mo7303g()) {
                    return j;
                }
                throw new UninitializedMessageException();
            }
        }

        private TypeParameter(ExtendableBuilder<TypeParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40512m = (byte) -1;
            this.f40513n = -1;
            this.f40511l = extendableBuilder.f38788a;
        }

        private TypeParameter() {
            this.f40512m = (byte) -1;
            this.f40513n = -1;
            this.f40511l = ByteString.f25891b;
        }

        public static TypeParameter m41872f() {
            return f40503k;
        }

        private TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r12, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r13) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r11 = this;
            r11.<init>();
            r0 = -1;
            r11.f40512m = r0;
            r11.f40513n = r0;
            r11.m41873j();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
            r4 = r2;
        L_0x0016:
            r5 = 16;
            r6 = 32;
            if (r2 != 0) goto L_0x0134;
        L_0x001c:
            r7 = r12.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == 0) goto L_0x00ee;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0022:
            r8 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r8) goto L_0x00e1;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0026:
            if (r7 == r5) goto L_0x00d3;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0028:
            r9 = 24;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r9) goto L_0x00c5;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x002c:
            if (r7 == r6) goto L_0x00aa;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x002e:
            r8 = 42;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r8) goto L_0x0090;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0032:
            r8 = 48;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r8) goto L_0x0075;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0036:
            r8 = 50;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r8) goto L_0x0042;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x003a:
            r7 = r11.mo7294a(r12, r1, r13, r7);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0040:
            goto L_0x00ee;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0042:
            r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r12.m27487b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r8 == r6) goto L_0x005d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x004e:
            r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r8 <= 0) goto L_0x005d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0054:
            r8 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40510j = r8;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x005d:
            r8 = r12.m27497j();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r8 <= 0) goto L_0x0071;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0063:
            r8 = r11.f40510j;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r9 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x005d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0071:
            r12.m27488c(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0075:
            r7 = r4 & 32;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r6) goto L_0x0082;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0079:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40510j = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0082:
            r7 = r11.f40510j;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8 = r12.m27486b();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0090:
            r7 = r4 & 16;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r7 == r5) goto L_0x009d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x0094:
            r7 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40509i = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r4 = r4 | 16;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x009d:
            r7 = r11.f40509i;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r8 = r12.m27483a(r8, r13);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7.add(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00aa:
            r9 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r10 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.Variance.m33528a(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            if (r10 != 0) goto L_0x00bc;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00b4:
            r1.m27502b(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r1.m27502b(r9);	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00bc:
            r7 = r11.f40504d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r7 | r8;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40504d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40508h = r10;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00c5:
            r7 = r11.f40504d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r7 | 4;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40504d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r12.m27489c();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40507g = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00d3:
            r7 = r11.f40504d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r7 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40504d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40506f = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
        L_0x00e1:
            r7 = r11.f40504d;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r7 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40504d = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r7 = r12.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            r11.f40505e = r7;	 Catch:{ InvalidProtocolBufferException -> 0x0100, IOException -> 0x00f3 }
            goto L_0x0016;
        L_0x00ee:
            r2 = r3;
            goto L_0x0016;
        L_0x00f1:
            r12 = move-exception;
            goto L_0x0104;
        L_0x00f3:
            r12 = move-exception;
            r13 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00f1 }
            r12 = r12.getMessage();	 Catch:{ all -> 0x00f1 }
            r13.<init>(r12);	 Catch:{ all -> 0x00f1 }
            r13.f25930a = r11;	 Catch:{ all -> 0x00f1 }
            throw r13;	 Catch:{ all -> 0x00f1 }
        L_0x0100:
            r12 = move-exception;	 Catch:{ all -> 0x00f1 }
            r12.f25930a = r11;	 Catch:{ all -> 0x00f1 }
            throw r12;	 Catch:{ all -> 0x00f1 }
        L_0x0104:
            r13 = r4 & 16;
            if (r13 != r5) goto L_0x0110;
        L_0x0108:
            r13 = r11.f40509i;
            r13 = java.util.Collections.unmodifiableList(r13);
            r11.f40509i = r13;
        L_0x0110:
            r13 = r4 & 32;
            if (r13 != r6) goto L_0x011c;
        L_0x0114:
            r13 = r11.f40510j;
            r13 = java.util.Collections.unmodifiableList(r13);
            r11.f40510j = r13;
        L_0x011c:
            r1.m27501b();	 Catch:{ IOException -> 0x011f, all -> 0x0126 }
        L_0x011f:
            r13 = r0.m27451a();
            r11.f40511l = r13;
            goto L_0x012e;
        L_0x0126:
            r12 = move-exception;
            r13 = r0.m27451a();
            r11.f40511l = r13;
            throw r12;
        L_0x012e:
            r13 = r11.f39732b;
            r13.m27521c();
            throw r12;
        L_0x0134:
            r12 = r4 & 16;
            if (r12 != r5) goto L_0x0140;
        L_0x0138:
            r12 = r11.f40509i;
            r12 = java.util.Collections.unmodifiableList(r12);
            r11.f40509i = r12;
        L_0x0140:
            r12 = r4 & 32;
            if (r12 != r6) goto L_0x014c;
        L_0x0144:
            r12 = r11.f40510j;
            r12 = java.util.Collections.unmodifiableList(r12);
            r11.f40510j = r12;
        L_0x014c:
            r1.m27501b();	 Catch:{ IOException -> 0x014f, all -> 0x0156 }
        L_0x014f:
            r12 = r0.m27451a();
            r11.f40511l = r12;
            goto L_0x015e;
        L_0x0156:
            r12 = move-exception;
            r13 = r0.m27451a();
            r11.f40511l = r13;
            throw r12;
        L_0x015e:
            r12 = r11.f39732b;
            r12.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            TypeParameter typeParameter = new TypeParameter();
            f40503k = typeParameter;
            typeParameter.m41873j();
        }

        public final Parser<TypeParameter> mo7112a() {
            return f40502c;
        }

        public final boolean m41879h() {
            return (this.f40504d & 1) == 1;
        }

        public final boolean m41880i() {
            return (this.f40504d & 2) == 2;
        }

        private void m41873j() {
            this.f40505e = 0;
            this.f40506f = 0;
            this.f40507g = false;
            this.f40508h = Variance.INV;
            this.f40509i = Collections.emptyList();
            this.f40510j = Collections.emptyList();
        }

        public final boolean mo7303g() {
            byte b = this.f40512m;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!m41879h()) {
                this.f40512m = (byte) 0;
                return false;
            } else if (m41880i()) {
                int i = 0;
                while (i < this.f40509i.size()) {
                    if (((Type) this.f40509i.get(i)).mo7303g()) {
                        i++;
                    } else {
                        this.f40512m = (byte) 0;
                        return false;
                    }
                }
                if (this.f39732b.m27523e()) {
                    this.f40512m = (byte) 1;
                    return true;
                }
                this.f40512m = (byte) 0;
                return false;
            } else {
                this.f40512m = (byte) 0;
                return false;
            }
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40503k;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41854a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }

    public static final class ValueParameter extends ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> f40521c = new C27881();
        private static final ValueParameter f40522k;
        int f40523d;
        public int f40524e;
        public int f40525f;
        public Type f40526g;
        public int f40527h;
        public Type f40528i;
        public int f40529j;
        private final ByteString f40530l;
        private byte f40531m;
        private int f40532n;

        static class C27881 extends AbstractParser<ValueParameter> {
            C27881() {
            }

            public final /* synthetic */ Object mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite);
            }
        }

        public static final class Builder extends ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int f40514c;
            private int f40515d;
            private int f40516e;
            private Type f40517f = Type.m41783f();
            private int f40518g;
            private Type f40519h = Type.m41783f();
            private int f40520i;

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7109a() {
                return m41883j();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41881c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mo7293b() {
                return m41883j();
            }

            public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return m41881c(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() throws CloneNotSupportedException {
                return m41883j();
            }

            public final /* synthetic */ ExtendableBuilder mo7612e() {
                return m41883j();
            }

            private Builder() {
            }

            public final ValueParameter m41895h() {
                int i = 0;
                ValueParameter valueParameter = new ValueParameter((ExtendableBuilder) this);
                int i2 = this.f40514c;
                if ((i2 & 1) == 1) {
                    i = 1;
                }
                valueParameter.f40524e = this.f40515d;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                valueParameter.f40525f = this.f40516e;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                valueParameter.f40526g = this.f40517f;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                valueParameter.f40527h = this.f40518g;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                valueParameter.f40528i = this.f40519h;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                valueParameter.f40529j = this.f40520i;
                valueParameter.f40523d = i;
                return valueParameter;
            }

            public final Builder m41887a(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.m41905f()) {
                    return this;
                }
                Type type;
                int i = 1;
                if (valueParameter.m41912h()) {
                    int i2 = valueParameter.f40524e;
                    this.f40514c |= 1;
                    this.f40515d = i2;
                }
                if (valueParameter.m41913i()) {
                    i2 = valueParameter.f40525f;
                    this.f40514c |= 2;
                    this.f40516e = i2;
                }
                if (valueParameter.m41914j()) {
                    type = valueParameter.f40526g;
                    if ((this.f40514c & 4) != 4 || this.f40517f == Type.m41783f()) {
                        this.f40517f = type;
                    } else {
                        this.f40517f = Type.m41771a(this.f40517f).m41758a(type).m41768i();
                    }
                    this.f40514c |= 4;
                }
                if ((valueParameter.f40523d & 8) != 8) {
                    i = 0;
                }
                if (i != 0) {
                    i2 = valueParameter.f40527h;
                    this.f40514c |= 8;
                    this.f40518g = i2;
                }
                if (valueParameter.m41915k()) {
                    type = valueParameter.f40528i;
                    if ((this.f40514c & 16) != 16 || this.f40519h == Type.m41783f()) {
                        this.f40519h = type;
                    } else {
                        this.f40519h = Type.m41771a(this.f40519h).m41758a(type).m41768i();
                    }
                    this.f40514c |= 16;
                }
                if (valueParameter.m41916l()) {
                    i2 = valueParameter.f40529j;
                    this.f40514c |= 32;
                    this.f40520i = i2;
                }
                m39924a((ExtendableMessage) valueParameter);
                this.f38788a = this.f38788a.m27460a(valueParameter.f40530l);
                return this;
            }

            private Builder m41881c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ValueParameter valueParameter;
                ValueParameter valueParameter2 = null;
                try {
                    m41887a((ValueParameter) ValueParameter.f40521c.mo6731a(codedInputStream, extensionRegistryLite));
                    return this;
                } catch (CodedInputStream codedInputStream2) {
                    valueParameter = (ValueParameter) codedInputStream2.f25930a;
                    throw codedInputStream2;
                } catch (Throwable th) {
                    codedInputStream2 = th;
                    valueParameter2 = valueParameter;
                }
                if (valueParameter2 != null) {
                    m41887a(valueParameter2);
                }
                throw codedInputStream2;
            }

            private Builder m41883j() {
                return new Builder().m41887a(m41895h());
            }

            public final boolean mo7303g() {
                if (!((this.f40514c & 2) == 2)) {
                    return false;
                }
                if (((this.f40514c & 4) == 4) && !this.f40517f.mo7303g()) {
                    return false;
                }
                return (!((this.f40514c & 16) == 16) || this.f40519h.mo7303g()) && this.f39730b.m27523e();
            }

            public final /* synthetic */ MessageLite mo7111d() {
                return ValueParameter.m41905f();
            }

            public final /* synthetic */ GeneratedMessageLite mo7301c() {
                return ValueParameter.m41905f();
            }

            public final /* synthetic */ MessageLite mo7302f() {
                MessageLite h = m41895h();
                if (h.mo7303g()) {
                    return h;
                }
                throw new UninitializedMessageException();
            }
        }

        private ValueParameter(ExtendableBuilder<ValueParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f40531m = (byte) -1;
            this.f40532n = -1;
            this.f40530l = extendableBuilder.f38788a;
        }

        private ValueParameter() {
            this.f40531m = (byte) -1;
            this.f40532n = -1;
            this.f40530l = ByteString.f25891b;
        }

        public static ValueParameter m41905f() {
            return f40522k;
        }

        private ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r9.<init>();
            r0 = -1;
            r9.f40531m = r0;
            r9.f40532n = r0;
            r9.m41906m();
            r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.m27456h();
            r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.m27498a(r0);
            r2 = 0;
            r3 = 1;
        L_0x0015:
            if (r2 != 0) goto L_0x00f2;
        L_0x0017:
            r4 = r10.m27482a();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == 0) goto L_0x00c4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x001d:
            r5 = 8;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r5) goto L_0x00b7;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0021:
            r6 = 16;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r6) goto L_0x00a9;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0025:
            r7 = 26;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r8 = 0;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r7) goto L_0x007f;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x002a:
            r7 = 34;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r7) goto L_0x0057;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x002e:
            r6 = 40;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r6) goto L_0x004b;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0032:
            r5 = 48;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 == r5) goto L_0x003e;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0036:
            r4 = r9.mo7294a(r10, r1, r11, r4);	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 != 0) goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x003c:
            goto L_0x00c4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x003e:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | 32;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40529j = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x004b:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40527h = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0057:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 & r6;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 != r6) goto L_0x0062;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x005c:
            r4 = r9.f40528i;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r8 = r4.m41806t();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0062:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27483a(r4, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40528i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r8 == 0) goto L_0x0079;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x006e:
            r4 = r9.f40528i;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r8.m41758a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r8.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40528i = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0079:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | r6;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x007f:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r5 = 4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 & r5;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r4 != r5) goto L_0x008b;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0085:
            r4 = r9.f40526g;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r8 = r4.m41806t();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x008b:
            r4 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.f40450c;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27483a(r4, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type) r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40526g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            if (r8 == 0) goto L_0x00a2;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x0097:
            r4 = r9.f40526g;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r8.m41758a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r8.m41768i();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40526g = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x00a2:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | r5;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x00a9:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | 2;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40525f = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
        L_0x00b7:
            r4 = r9.f40523d;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r4 | r3;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40523d = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r4 = r10.m27493f();	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            r9.f40524e = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00d6, IOException -> 0x00c9 }
            goto L_0x0015;
        L_0x00c4:
            r2 = r3;
            goto L_0x0015;
        L_0x00c7:
            r10 = move-exception;
            goto L_0x00da;
        L_0x00c9:
            r10 = move-exception;
            r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00c7 }
            r10 = r10.getMessage();	 Catch:{ all -> 0x00c7 }
            r11.<init>(r10);	 Catch:{ all -> 0x00c7 }
            r11.f25930a = r9;	 Catch:{ all -> 0x00c7 }
            throw r11;	 Catch:{ all -> 0x00c7 }
        L_0x00d6:
            r10 = move-exception;	 Catch:{ all -> 0x00c7 }
            r10.f25930a = r9;	 Catch:{ all -> 0x00c7 }
            throw r10;	 Catch:{ all -> 0x00c7 }
        L_0x00da:
            r1.m27501b();	 Catch:{ IOException -> 0x00dd, all -> 0x00e4 }
        L_0x00dd:
            r11 = r0.m27451a();
            r9.f40530l = r11;
            goto L_0x00ec;
        L_0x00e4:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f40530l = r11;
            throw r10;
        L_0x00ec:
            r11 = r9.f39732b;
            r11.m27521c();
            throw r10;
        L_0x00f2:
            r1.m27501b();	 Catch:{ IOException -> 0x00f5, all -> 0x00fc }
        L_0x00f5:
            r10 = r0.m27451a();
            r9.f40530l = r10;
            goto L_0x0104;
        L_0x00fc:
            r10 = move-exception;
            r11 = r0.m27451a();
            r9.f40530l = r11;
            throw r10;
        L_0x0104:
            r10 = r9.f39732b;
            r10.m27521c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            ValueParameter valueParameter = new ValueParameter();
            f40522k = valueParameter;
            valueParameter.m41906m();
        }

        public final Parser<ValueParameter> mo7112a() {
            return f40521c;
        }

        public final boolean m41912h() {
            return (this.f40523d & 1) == 1;
        }

        public final boolean m41913i() {
            return (this.f40523d & 2) == 2;
        }

        public final boolean m41914j() {
            return (this.f40523d & 4) == 4;
        }

        public final boolean m41915k() {
            return (this.f40523d & 16) == 16;
        }

        public final boolean m41916l() {
            return (this.f40523d & 32) == 32;
        }

        private void m41906m() {
            this.f40524e = 0;
            this.f40525f = 0;
            this.f40526g = Type.m41783f();
            this.f40527h = 0;
            this.f40528i = Type.m41783f();
            this.f40529j = 0;
        }

        public final boolean mo7303g() {
            byte b = this.f40531m;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!m41913i()) {
                this.f40531m = (byte) 0;
                return false;
            } else if (m41914j() && !this.f40526g.mo7303g()) {
                this.f40531m = (byte) 0;
                return false;
            } else if (m41915k() && !this.f40528i.mo7303g()) {
                this.f40531m = (byte) 0;
                return false;
            } else if (this.f39732b.m27523e()) {
                this.f40531m = (byte) 1;
                return true;
            } else {
                this.f40531m = (byte) 0;
                return false;
            }
        }

        public static Builder m41898a(ValueParameter valueParameter) {
            return new Builder().m41887a(valueParameter);
        }

        public final /* bridge */ /* synthetic */ MessageLite mo7111d() {
            return f40522k;
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7305e() {
            return new Builder().m41887a(this);
        }

        public final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo7304c() {
            return new Builder();
        }
    }
}
