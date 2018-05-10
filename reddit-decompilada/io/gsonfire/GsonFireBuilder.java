package io.gsonfire;

import com.google.gson.GsonBuilder;
import io.gsonfire.gson.EnumDefaultValueTypeAdapterFactory;
import io.gsonfire.gson.ExcludeByValueTypeAdapterFactory;
import io.gsonfire.gson.FireExclusionStrategy;
import io.gsonfire.gson.FireExclusionStrategyComposite;
import io.gsonfire.gson.FireTypeAdapterFactory;
import io.gsonfire.gson.SimpleIterableTypeAdapterFactory;
import io.gsonfire.gson.TypeSelectorTypeAdapterFactory;
import io.gsonfire.gson.WrapTypeAdapterFactory;
import io.gsonfire.postprocessors.methodinvoker.MethodInvokerPostProcessor;
import io.gsonfire.util.Mapper;
import io.gsonfire.util.reflection.CachedReflectionFactory;
import io.gsonfire.util.reflection.Factory;
import io.gsonfire.util.reflection.FieldInspector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class GsonFireBuilder {
    private final Map<Class, ClassConfig> f24946a = new HashMap();
    private final Map<Class, Mapper> f24947b = new HashMap();
    private final List<Class> f24948c = new ArrayList();
    private final List<FireExclusionStrategy> f24949d = new ArrayList();
    private final FieldInspector f24950e = new FieldInspector();
    private final Factory f24951f = new CachedReflectionFactory();
    private final Map<Class, Enum> f24952g = new HashMap();
    private DateSerializationPolicy f24953h;
    private boolean f24954i = true;
    private TimeZone f24955j = TimeZone.getDefault();
    private boolean f24956k = false;
    private boolean f24957l = false;

    public final GsonBuilder m26449a() {
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (this.f24956k) {
            m26450a(Object.class, new MethodInvokerPostProcessor(new FireExclusionStrategyComposite(this.f24949d)));
        }
        if (this.f24957l) {
            gsonBuilder.a(new ExcludeByValueTypeAdapterFactory(this.f24950e, this.f24951f));
        }
        for (Class cls : this.f24948c) {
            ClassConfig classConfig = (ClassConfig) this.f24946a.get(cls);
            if (classConfig.f24935b != null) {
                gsonBuilder.a(new TypeSelectorTypeAdapterFactory(classConfig, newSetFromMap));
            }
            gsonBuilder.a(new FireTypeAdapterFactory(classConfig));
        }
        for (Entry entry : this.f24952g.entrySet()) {
            gsonBuilder.a(new EnumDefaultValueTypeAdapterFactory((Class) entry.getKey(), (Enum) entry.getValue()));
        }
        if (this.f24953h != null) {
            gsonBuilder.a(Date.class, this.f24953h.mo5615a(this.f24955j));
        }
        gsonBuilder.a(new SimpleIterableTypeAdapterFactory());
        gsonBuilder.a(new WrapTypeAdapterFactory(this.f24947b));
        return gsonBuilder;
    }

    public final <T> GsonFireBuilder m26450a(Class<T> cls, PostProcessor<? super T> postProcessor) {
        ClassConfig classConfig = (ClassConfig) this.f24946a.get(cls);
        if (classConfig == null) {
            classConfig = new ClassConfig(cls);
            this.f24946a.put(cls, classConfig);
            List list = this.f24948c;
            for (int size = list.size() - 1; size >= 0; size--) {
                if (((Class) list.get(size)).isAssignableFrom(cls)) {
                    list.add(size + 1, cls);
                    break;
                }
            }
            list.add(0, cls);
        }
        classConfig.m26447a().add(postProcessor);
        return this;
    }
}
