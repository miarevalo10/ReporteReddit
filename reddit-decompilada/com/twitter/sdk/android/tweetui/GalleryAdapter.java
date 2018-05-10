package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Request;
import com.squareup.picasso.Target;
import com.squareup.picasso.TargetAction;
import com.squareup.picasso.Utils;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.GalleryImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;
import java.util.ArrayList;
import java.util.List;

class GalleryAdapter extends PagerAdapter {
    final List<MediaEntity> f30770b = new ArrayList();
    final Context f30771c;
    final Callback f30772d;

    public final boolean m31774a(View view, Object obj) {
        return view == obj;
    }

    GalleryAdapter(Context context, Callback callback) {
        this.f30771c = context;
        this.f30772d = callback;
    }

    public final int m31775c() {
        return this.f30770b.size();
    }

    public final Object m31772a(ViewGroup viewGroup, int i) {
        Target galleryImageView = new GalleryImageView(this.f30771c);
        galleryImageView.setSwipeToDismissCallback(this.f30772d);
        viewGroup.addView(galleryImageView);
        viewGroup = Picasso.m25774a(this.f30771c).m25776a(((MediaEntity) this.f30770b.get(i)).f34647c);
        long nanoTime = System.nanoTime();
        Utils.m25822a();
        if (viewGroup.f23871c != 0) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (viewGroup.f23870b.m25786a() == 0) {
            viewGroup.f23869a.m25779a((Object) galleryImageView);
            if (viewGroup.f23872d != 0) {
                viewGroup.m25791b();
            }
            galleryImageView.mo5511a();
        } else {
            Request a = viewGroup.m25787a(nanoTime);
            String a2 = Utils.m25821a(a);
            if (MemoryPolicy.m25768a(viewGroup.f23875g) != 0) {
                i = viewGroup.f23869a.m25780b(a2);
                if (i != 0) {
                    viewGroup.f23869a.m25779a((Object) galleryImageView);
                    viewGroup = LoadedFrom.MEMORY;
                    galleryImageView.mo5512a(i);
                }
            }
            if (viewGroup.f23872d != 0) {
                viewGroup.m25791b();
            }
            galleryImageView.mo5511a();
            viewGroup.f23869a.m25778a(new TargetAction(viewGroup.f23869a, galleryImageView, a, viewGroup.f23875g, viewGroup.f23876h, viewGroup.f23878j, a2, viewGroup.f23879k, viewGroup.f23874f));
        }
        return galleryImageView;
    }

    public final void m31773a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
