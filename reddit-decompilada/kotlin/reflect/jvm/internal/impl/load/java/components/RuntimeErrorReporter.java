package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* compiled from: RuntimeErrorReporter.kt */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter f32702a = null;

    static {
        RuntimeErrorReporter runtimeErrorReporter = new RuntimeErrorReporter();
    }

    private RuntimeErrorReporter() {
        f32702a = this;
    }

    public final void mo5772a(ClassDescriptor classDescriptor, List<String> list) {
        Intrinsics.m26847b(classDescriptor, "descriptor");
        Intrinsics.m26847b(list, "unresolvedSuperClasses");
        StringBuilder stringBuilder = new StringBuilder("Incomplete hierarchy for class ");
        stringBuilder.append(classDescriptor.mo6689i());
        stringBuilder.append(", unresolved classes ");
        stringBuilder.append(list);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void mo5771a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "descriptor");
        StringBuilder stringBuilder = new StringBuilder("Cannot infer visibility for ");
        stringBuilder.append(callableMemberDescriptor);
        throw new IllegalStateException(stringBuilder.toString());
    }
}
