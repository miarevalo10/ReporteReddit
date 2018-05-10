package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class GenericResponse<T> {
    public static final int ERROR_FIELD = 2;
    public static final int ERROR_MESSAGE = 1;
    public static final int ERROR_NAME = 0;
    public final Json<T> json;

    public class Json<D> {
        public final D data;
        public final List<List<String>> errors;
        final /* synthetic */ GenericResponse this$0;
    }

    public final boolean m9384a() {
        return this.json.errors.size() > 0;
    }

    public final String m9385b() {
        return (String) ((List) this.json.errors.get(0)).get(1);
    }
}
