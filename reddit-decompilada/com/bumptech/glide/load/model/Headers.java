package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders.Builder;
import java.util.Collections;
import java.util.Map;

public interface Headers {
    @Deprecated
    public static final Headers f3487a = new C10761();
    public static final Headers f3488b;

    class C10761 implements Headers {
        C10761() {
        }

        public final Map<String, String> mo976a() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> mo976a();

    static {
        Builder builder = new Builder();
        builder.f3491a = true;
        f3488b = new LazyHeaders(builder.f3492b);
    }
}
