package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.Companion;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;

/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$getJdkMethodStatus$2 extends AbstractNodeHandler<ClassDescriptor, JDKMemberStatus> {
    final /* synthetic */ String f36116a;
    final /* synthetic */ ObjectRef f36117b;

    JvmBuiltInsSettings$getJdkMethodStatus$2(String str, ObjectRef objectRef) {
        this.f36116a = str;
        this.f36117b = objectRef;
    }

    public final /* synthetic */ boolean mo5948a(Object obj) {
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        Intrinsics.m26847b(classDescriptor, "javaClassDescriptor");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        String str = this.f36116a;
        Intrinsics.m26843a((Object) str, "jvmDescriptor");
        obj = SignatureBuildingComponents.m27359a(classDescriptor, str);
        Companion companion = JvmBuiltInsSettings.f32795b;
        if (Companion.m27304b().contains(obj)) {
            this.f36117b.f25291a = JDKMemberStatus.f25790a;
        } else {
            companion = JvmBuiltInsSettings.f32795b;
            if (Companion.m27306c().contains(obj)) {
                this.f36117b.f25291a = JDKMemberStatus.f25791b;
            } else {
                companion = JvmBuiltInsSettings.f32795b;
                if (Companion.m27302a().contains(obj) != null) {
                    this.f36117b.f25291a = JDKMemberStatus.f25793d;
                }
            }
        }
        return ((JDKMemberStatus) this.f36117b.f25291a) == null ? true : null;
    }

    public final /* bridge */ /* synthetic */ Object mo6700a() {
        JDKMemberStatus jDKMemberStatus = (JDKMemberStatus) this.f36117b.f25291a;
        return jDKMemberStatus == null ? JDKMemberStatus.f25792c : jDKMemberStatus;
    }
}
