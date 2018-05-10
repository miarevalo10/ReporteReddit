package io.gsonfire.gson;

import io.gsonfire.postprocessors.methodinvoker.MappedMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class FireExclusionStrategyComposite implements FireExclusionStrategy {
    private final Collection<FireExclusionStrategy> f31054a;

    public FireExclusionStrategyComposite(FireExclusionStrategy... fireExclusionStrategyArr) {
        this(Arrays.asList(fireExclusionStrategyArr));
    }

    public FireExclusionStrategyComposite(Collection<FireExclusionStrategy> collection) {
        this.f31054a = new ArrayList(collection);
    }

    public final boolean mo5616a(MappedMethod mappedMethod) {
        for (FireExclusionStrategy a : this.f31054a) {
            if (a.mo5616a(mappedMethod)) {
                return true;
            }
        }
        return null;
    }
}
