package com.bumptech.glide;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder.Factory;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registry {
    public final ModelLoaderRegistry f3237a = new ModelLoaderRegistry(this.f3246j);
    public final EncoderRegistry f3238b = new EncoderRegistry();
    public final ResourceDecoderRegistry f3239c = new ResourceDecoderRegistry();
    public final ResourceEncoderRegistry f3240d = new ResourceEncoderRegistry();
    public final DataRewinderRegistry f3241e = new DataRewinderRegistry();
    public final TranscoderRegistry f3242f = new TranscoderRegistry();
    final ImageHeaderParserRegistry f3243g = new ImageHeaderParserRegistry();
    public final ModelToResourceClassCache f3244h = new ModelToResourceClassCache();
    public final LoadPathCache f3245i = new LoadPathCache();
    public final Pool<List<Throwable>> f3246j = FactoryPools.m3242a();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            StringBuilder stringBuilder = new StringBuilder("Failed to find any ModelLoaders for model: ");
            stringBuilder.append(obj);
            super(stringBuilder.toString());
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            StringBuilder stringBuilder = new StringBuilder("Failed to find any ModelLoaders for model: ");
            stringBuilder.append(cls);
            stringBuilder.append(" and data: ");
            stringBuilder.append(cls2);
            super(stringBuilder.toString());
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            StringBuilder stringBuilder = new StringBuilder("Failed to find result encoder for resource class: ");
            stringBuilder.append(cls);
            super(stringBuilder.toString());
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            StringBuilder stringBuilder = new StringBuilder("Failed to find source encoder for data class: ");
            stringBuilder.append(cls);
            super(stringBuilder.toString());
        }
    }

    public Registry() {
        List arrayList = new ArrayList(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f3239c.m3116a(arrayList);
    }

    public final <Data> Registry m2784a(Class<Data> cls, Encoder<Data> encoder) {
        this.f3238b.m3109a(cls, encoder);
        return this;
    }

    public final <Data, TResource> Registry m2786a(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        m2789a("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    public final <Data, TResource> Registry m2789a(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f3239c.m3115a(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final <TResource> Registry m2785a(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.f3240d.m3119a(cls, resourceEncoder);
        return this;
    }

    public final Registry m2783a(Factory<?> factory) {
        this.f3241e.m2867a((Factory) factory);
        return this;
    }

    public final <TResource, Transcode> Registry m2788a(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f3242f.m3080a(cls, cls2, resourceTranscoder);
        return this;
    }

    public final <Model, Data> Registry m2787a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f3237a.m3006a(cls, cls2, modelLoaderFactory);
        return this;
    }

    public final <Model, Data> Registry m2792b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f3237a.m3007b(cls, cls2, modelLoaderFactory);
        return this;
    }

    public final <Model> List<ModelLoader<Model, ?>> m2791a(Model model) {
        List<ModelLoader<Model, ?>> a = this.f3237a.m3005a((Object) model);
        if (!a.isEmpty()) {
            return a;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    public final List<ImageHeaderParser> m2790a() {
        List<ImageHeaderParser> a = this.f3243g.m3110a();
        if (!a.isEmpty()) {
            return a;
        }
        throw new NoImageHeaderParserException();
    }
}
