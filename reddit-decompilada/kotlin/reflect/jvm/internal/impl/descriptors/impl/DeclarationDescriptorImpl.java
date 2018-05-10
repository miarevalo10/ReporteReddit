package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;

public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    private final Name f36068a;

    public DeclarationDescriptorImpl(Annotations annotations, Name name) {
        if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "<init>"}));
        } else {
            super(annotations);
            this.f36068a = name;
        }
    }

    public final Name mo6689i() {
        Name name = this.f36068a;
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "getName"}));
    }

    public DeclarationDescriptor aJ_() {
        if (this != null) {
            return this;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "getOriginal"}));
    }

    public String toString() {
        return m36235a(this);
    }

    public static java.lang.String m36235a(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 2;
        r1 = 1;
        r2 = 0;
        if (r6 != 0) goto L_0x0020;
    L_0x0005:
        r6 = new java.lang.IllegalArgumentException;
        r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = "descriptor";
        r4[r2] = r5;
        r2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        r4[r1] = r2;
        r1 = "toString";
        r4[r0] = r1;
        r0 = java.lang.String.format(r3, r4);
        r6.<init>(r0);
        throw r6;
    L_0x0020:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0070 }
        r3.<init>();	 Catch:{ Throwable -> 0x0070 }
        r4 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.f26014g;	 Catch:{ Throwable -> 0x0070 }
        r4 = r4.mo5890a(r6);	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r4 = "[";	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r4 = r6.getClass();	 Catch:{ Throwable -> 0x0070 }
        r4 = r4.getSimpleName();	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r4 = "@";	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r4 = java.lang.System.identityHashCode(r6);	 Catch:{ Throwable -> 0x0070 }
        r4 = java.lang.Integer.toHexString(r4);	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r4 = "]";	 Catch:{ Throwable -> 0x0070 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0070 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0070 }
        if (r3 != 0) goto L_0x006f;
    L_0x0059:
        r6 = new java.lang.IllegalStateException;
        r3 = "@NotNull method %s.%s must not return null";
        r0 = new java.lang.Object[r0];
        r4 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        r0[r2] = r4;
        r2 = "toString";
        r0[r1] = r2;
        r0 = java.lang.String.format(r3, r0);
        r6.<init>(r0);
        throw r6;
    L_0x006f:
        return r3;
    L_0x0070:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r6.getClass();
        r4 = r4.getSimpleName();
        r3.append(r4);
        r4 = " ";
        r3.append(r4);
        r6 = r6.mo6689i();
        r3.append(r6);
        r6 = r3.toString();
        if (r6 != 0) goto L_0x00a8;
    L_0x0092:
        r6 = new java.lang.IllegalStateException;
        r3 = "@NotNull method %s.%s must not return null";
        r0 = new java.lang.Object[r0];
        r4 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        r0[r2] = r4;
        r2 = "toString";
        r0[r1] = r2;
        r0 = java.lang.String.format(r3, r0);
        r6.<init>(r0);
        throw r6;
    L_0x00a8:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl.a(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):java.lang.String");
    }
}
