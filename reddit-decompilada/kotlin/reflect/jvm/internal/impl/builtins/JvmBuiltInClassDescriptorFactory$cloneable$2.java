package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements Function0<ClassDescriptorImpl> {
    final /* synthetic */ JvmBuiltInClassDescriptorFactory f38318a;
    final /* synthetic */ StorageManager f38319b;

    JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        this.f38318a = jvmBuiltInClassDescriptorFactory;
        this.f38319b = storageManager;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) this.f38318a.f32626e.mo6492a(this.f38318a.f32625d);
        Companion companion = JvmBuiltInClassDescriptorFactory.f32620b;
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, JvmBuiltInClassDescriptorFactory.f32622g, Modality.f25491d, ClassKind.INTERFACE, CollectionsKt__CollectionsKt.m26791a((Object) this.f38318a.f32625d.mo7089b().m27015m()), SourceElement.f25498a);
        classDescriptorImpl.m42902a(new CloneableClassScope(this.f38319b, classDescriptorImpl), SetsKt__SetsKt.m26799a(), null);
        return classDescriptorImpl;
    }
}
