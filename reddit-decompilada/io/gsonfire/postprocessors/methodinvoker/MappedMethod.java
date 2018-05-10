package io.gsonfire.postprocessors.methodinvoker;

import io.gsonfire.annotations.ExposeMethodResult.ConflictResolutionStrategy;
import java.lang.reflect.Method;

public final class MappedMethod {
    final Method f24963a;
    final String f24964b;
    final ConflictResolutionStrategy f24965c;

    public MappedMethod(Method method, String str, ConflictResolutionStrategy conflictResolutionStrategy) {
        this.f24963a = method;
        this.f24964b = str;
        this.f24965c = conflictResolutionStrategy;
    }
}
