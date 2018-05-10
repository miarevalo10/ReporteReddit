package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    public final /* bridge */ /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return true;
    }

    public final /* bridge */ /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return NonOwnedDrawableResource.m17024a((Drawable) obj);
    }
}
