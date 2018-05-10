package io.gsonfire;

import java.util.ArrayList;
import java.util.Collection;

public final class ClassConfig<T> {
    public Class<T> f24934a;
    public TypeSelector<? super T> f24935b;
    public Collection<Object<T>> f24936c;
    public boolean f24937d;
    private Collection<PostProcessor<T>> f24938e;

    public ClassConfig(Class<T> cls) {
        this.f24934a = cls;
    }

    public final Collection<PostProcessor<T>> m26447a() {
        if (this.f24938e == null) {
            this.f24938e = new ArrayList();
        }
        return this.f24938e;
    }
}
