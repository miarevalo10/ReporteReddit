package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public final Class<GifDrawable> mo925a() {
        return GifDrawable.class;
    }

    public final int mo927c() {
        GifFrameLoader gifFrameLoader = ((GifDrawable) this.a).f12628a.f3556a;
        return gifFrameLoader.f3558a.mo881g() + Util.m3223a(gifFrameLoader.m3074b().getWidth(), gifFrameLoader.m3074b().getHeight(), gifFrameLoader.m3074b().getConfig());
    }

    public final void mo928d() {
        ((GifDrawable) this.a).stop();
        GifDrawable gifDrawable = (GifDrawable) this.a;
        gifDrawable.f12629b = true;
        GifFrameLoader gifFrameLoader = gifDrawable.f12628a.f3556a;
        gifFrameLoader.f3559b.clear();
        gifFrameLoader.m3076d();
        gifFrameLoader.f3561d = false;
        if (gifFrameLoader.f3562e != null) {
            gifFrameLoader.f3560c.m11200a(gifFrameLoader.f3562e);
            gifFrameLoader.f3562e = null;
        }
        if (gifFrameLoader.f3564g != null) {
            gifFrameLoader.f3560c.m11200a(gifFrameLoader.f3564g);
            gifFrameLoader.f3564g = null;
        }
        if (gifFrameLoader.f3566i != null) {
            gifFrameLoader.f3560c.m11200a(gifFrameLoader.f3566i);
            gifFrameLoader.f3566i = null;
        }
        gifFrameLoader.f3558a.mo883i();
        gifFrameLoader.f3563f = true;
    }

    public final void mo981e() {
        ((GifDrawable) this.a).m11674a().prepareToDraw();
    }
}
