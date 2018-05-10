package com.raizlabs.android.dbflow.structure.cache;

public abstract class ModelCache<TModel, CacheClass> {
    private CacheClass cache;

    public abstract void addModel(Object obj, TModel tModel);

    public abstract void clear();

    public abstract TModel get(Object obj);

    public abstract TModel removeModel(Object obj);

    public abstract void setCacheSize(int i);

    public ModelCache(CacheClass cacheClass) {
        this.cache = cacheClass;
    }

    public CacheClass getCache() {
        return this.cache;
    }
}
