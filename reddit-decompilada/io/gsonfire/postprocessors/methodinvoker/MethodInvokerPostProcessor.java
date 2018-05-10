package io.gsonfire.postprocessors.methodinvoker;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.gsonfire.PostProcessor;
import io.gsonfire.annotations.ExposeMethodResult;
import io.gsonfire.annotations.ExposeMethodResult.ConflictResolutionStrategy;
import io.gsonfire.gson.FireExclusionStrategy;
import io.gsonfire.gson.FireExclusionStrategyComposite;
import java.lang.reflect.InvocationTargetException;

public final class MethodInvokerPostProcessor<T> implements PostProcessor<T> {
    private static MappedMethodInspector f31077a = new MappedMethodInspector();
    private final FireExclusionStrategy f31078b;

    public final void mo4763a(T t) {
    }

    public MethodInvokerPostProcessor() {
        this(new FireExclusionStrategyComposite(new FireExclusionStrategy[0]));
    }

    public MethodInvokerPostProcessor(FireExclusionStrategy fireExclusionStrategy) {
        this.f31078b = fireExclusionStrategy;
    }

    public final void mo4762a(JsonElement jsonElement, T t, Gson gson) {
        if (jsonElement instanceof JsonObject) {
            jsonElement = jsonElement.h();
            for (MappedMethod mappedMethod : f31077a.m26465a(t.getClass(), ExposeMethodResult.class)) {
                if (!this.f31078b.mo5616a(mappedMethod)) {
                    try {
                        if (mappedMethod.f24965c == ConflictResolutionStrategy.OVERWRITE || (mappedMethod.f24965c == ConflictResolutionStrategy.SKIP && !jsonElement.b(mappedMethod.f24964b))) {
                            jsonElement.a(mappedMethod.f24964b, gson.a(mappedMethod.f24963a.invoke(t, new Object[0])));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
