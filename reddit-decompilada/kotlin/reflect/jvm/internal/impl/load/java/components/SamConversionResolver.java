package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;

/* compiled from: SamConversionResolver.kt */
public interface SamConversionResolver {
    public static final EMPTY f25662a = new EMPTY();

    /* compiled from: SamConversionResolver.kt */
    public static final class EMPTY implements SamConversionResolver {
        private EMPTY() {
        }

        public final /* synthetic */ FunctionDescriptor mo5774a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "original");
            return null;
        }

        public final /* synthetic */ SamConstructorDescriptor mo5775a(DeclarationDescriptor declarationDescriptor, Function0 function0) {
            Intrinsics.m26847b(declarationDescriptor, "constructorOwner");
            Intrinsics.m26847b(function0, "classifier");
            return null;
        }
    }

    <D extends FunctionDescriptor> D mo5774a(D d);

    SamConstructorDescriptor mo5775a(DeclarationDescriptor declarationDescriptor, Function0<? extends ClassifierDescriptor> function0);
}
