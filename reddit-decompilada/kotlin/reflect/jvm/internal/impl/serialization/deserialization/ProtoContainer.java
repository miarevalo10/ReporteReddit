package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind;

/* compiled from: ProtoContainer.kt */
public abstract class ProtoContainer {
    public final NameResolver f26267a;
    public final TypeTable f26268b;
    public final SourceElement f26269c;

    /* compiled from: ProtoContainer.kt */
    public static final class Class extends ProtoContainer {
        public final ClassId f33041d;
        public final Kind f33042e;
        public final boolean f33043f;
        final kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class f33044g;
        public final Class f33045h;

        public Class(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class classR, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, Class classR2) {
            Intrinsics.m26847b(classR, "classProto");
            Intrinsics.m26847b(nameResolver, "nameResolver");
            Intrinsics.m26847b(typeTable, "typeTable");
            super(nameResolver, typeTable, sourceElement);
            this.f33044g = classR;
            this.f33045h = classR2;
            Object c = nameResolver.mo5831c(this.f33044g.f40316f);
            Intrinsics.m26843a(c, "nameResolver.getClassId(classProto.fqName)");
            this.f33041d = c;
            classR = (Kind) Flags.f26154e.mo5920b(this.f33044g.f40315e);
            if (classR == null) {
                classR = Kind.CLASS;
            }
            this.f33042e = classR;
            c = Flags.f26155f.m33502a(this.f33044g.f40315e);
            Intrinsics.m26843a(c, "Flags.IS_INNER.get(classProto.flags)");
            this.f33043f = c.booleanValue();
        }

        public final FqName mo5923a() {
            Object f = this.f33041d.m27403f();
            Intrinsics.m26843a(f, "classId.asSingleFqName()");
            return f;
        }
    }

    /* compiled from: ProtoContainer.kt */
    public static final class Package extends ProtoContainer {
        private final FqName f33046d;

        public Package(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            Intrinsics.m26847b(fqName, "fqName");
            Intrinsics.m26847b(nameResolver, "nameResolver");
            Intrinsics.m26847b(typeTable, "typeTable");
            super(nameResolver, typeTable, sourceElement);
            this.f33046d = fqName;
        }

        public final FqName mo5923a() {
            return this.f33046d;
        }
    }

    public abstract FqName mo5923a();

    private ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
        this.f26267a = nameResolver;
        this.f26268b = typeTable;
        this.f26269c = sourceElement;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(mo5923a());
        return stringBuilder.toString();
    }
}
