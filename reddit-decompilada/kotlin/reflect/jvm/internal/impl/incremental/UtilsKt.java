package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final void m27123a(LookupTracker lookupTracker, LookupLocation lookupLocation, ClassDescriptor classDescriptor, Name name) {
        Intrinsics.m26847b(lookupTracker, "$receiver");
        Intrinsics.m26847b(lookupLocation, "from");
        Intrinsics.m26847b(classDescriptor, "scopeOwner");
        Intrinsics.m26847b(name, "name");
        lookupLocation = LookupTracker.f25593a;
        if (lookupTracker != Companion.m27125a()) {
        }
    }

    public static final void m27124a(LookupTracker lookupTracker, LookupLocation lookupLocation, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Intrinsics.m26847b(lookupTracker, "$receiver");
        Intrinsics.m26847b(lookupLocation, "from");
        Intrinsics.m26847b(packageFragmentDescriptor, "scopeOwner");
        Intrinsics.m26847b(name, "name");
        lookupLocation = LookupTracker.f25593a;
        if (lookupTracker != Companion.m27125a()) {
        }
    }
}
