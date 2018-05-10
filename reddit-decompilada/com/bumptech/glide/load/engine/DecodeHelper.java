package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class DecodeHelper<Transcode> {
    final List<LoadData<?>> f3367a = new ArrayList();
    final List<Key> f3368b = new ArrayList();
    public GlideContext f3369c;
    public Object f3370d;
    public int f3371e;
    public int f3372f;
    public Class<?> f3373g;
    public DiskCacheProvider f3374h;
    public Options f3375i;
    public Map<Class<?>, Transformation<?>> f3376j;
    public Class<Transcode> f3377k;
    boolean f3378l;
    boolean f3379m;
    public Key f3380n;
    public Priority f3381o;
    public DiskCacheStrategy f3382p;
    public boolean f3383q;
    public boolean f3384r;

    DecodeHelper() {
    }

    final DiskCache m2889a() {
        return this.f3374h.mo917a();
    }

    final boolean m2891a(Class<?> cls) {
        return m2892b(cls) != null ? true : null;
    }

    final <Data> LoadPath<Data, ?, Transcode> m2892b(Class<Data> cls) {
        Class<Data> cls2 = cls;
        Registry registry = this.f3369c.f3221d;
        Class cls3 = this.f3373g;
        Class cls4 = this.f3377k;
        LoadPath<Data, ?, Transcode> loadPath = registry.f3245i.get(cls2, cls3, cls4);
        if (registry.f3245i.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            List arrayList = new ArrayList();
            for (Class cls5 : registry.f3239c.m3117b(cls2, cls3)) {
                Iterator it = registry.f3242f.m3081b(cls5, cls4).iterator();
                while (it.hasNext()) {
                    Class cls6 = (Class) it.next();
                    DecodePath decodePath = r1;
                    Iterator it2 = it;
                    DecodePath decodePath2 = new DecodePath(cls2, cls5, cls6, registry.f3239c.m3114a(cls2, cls5), registry.f3242f.m3079a(cls5, cls6), registry.f3246j);
                    arrayList.add(decodePath);
                    it = it2;
                }
            }
            if (arrayList.isEmpty()) {
                loadPath = null;
            } else {
                loadPath = new LoadPath(cls2, cls3, cls4, arrayList, registry.f3246j);
            }
            registry.f3245i.put(cls2, cls3, cls4, loadPath);
        }
        return loadPath;
    }

    final <Z> Transformation<Z> m2894c(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation) this.f3376j.get(cls);
        if (transformation == null) {
            for (Entry entry : this.f3376j.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f3376j.isEmpty() || !this.f3383q) {
            return UnitTransformation.m17011a();
        }
        StringBuilder stringBuilder = new StringBuilder("Missing transformation for ");
        stringBuilder.append(cls);
        stringBuilder.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    final List<ModelLoader<File, ?>> m2890a(File file) throws NoModelLoaderAvailableException {
        return this.f3369c.f3221d.m2791a((Object) file);
    }

    final List<LoadData<?>> m2893b() {
        if (!this.f3378l) {
            this.f3378l = true;
            this.f3367a.clear();
            List a = this.f3369c.f3221d.m2791a(this.f3370d);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                LoadData a2 = ((ModelLoader) a.get(i)).mo890a(this.f3370d, this.f3371e, this.f3372f, this.f3375i);
                if (a2 != null) {
                    this.f3367a.add(a2);
                }
            }
        }
        return this.f3367a;
    }

    final List<Key> m2895c() {
        if (!this.f3379m) {
            this.f3379m = true;
            this.f3368b.clear();
            List b = m2893b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                LoadData loadData = (LoadData) b.get(i);
                if (!this.f3368b.contains(loadData.f3498a)) {
                    this.f3368b.add(loadData.f3498a);
                }
                for (int i2 = 0; i2 < loadData.f3499b.size(); i2++) {
                    if (!this.f3368b.contains(loadData.f3499b.get(i2))) {
                        this.f3368b.add(loadData.f3499b.get(i2));
                    }
                }
            }
        }
        return this.f3368b;
    }
}
