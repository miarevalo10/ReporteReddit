package com.raizlabs.android.dbflow.structure.cache;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowLog.Level;
import java.util.HashMap;
import java.util.Map;

public class SimpleMapCache<TModel> extends ModelCache<TModel, Map<Object, TModel>> {
    public SimpleMapCache(int i) {
        super(new HashMap(i));
    }

    public SimpleMapCache(Map<Object, TModel> map) {
        super(map);
    }

    public void addModel(Object obj, TModel tModel) {
        ((Map) getCache()).put(obj, tModel);
    }

    public TModel removeModel(Object obj) {
        return ((Map) getCache()).remove(obj);
    }

    public void clear() {
        ((Map) getCache()).clear();
    }

    public TModel get(Object obj) {
        return ((Map) getCache()).get(obj);
    }

    public void setCacheSize(int i) {
        Level level = Level.I;
        StringBuilder stringBuilder = new StringBuilder("The cache size for ");
        stringBuilder.append(SimpleMapCache.class.getSimpleName());
        stringBuilder.append(" is not re-configurable.");
        FlowLog.log(level, stringBuilder.toString());
    }
}
