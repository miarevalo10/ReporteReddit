package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class GalleryActivity extends Activity {
    GalleryItem f24177a;
    final GalleryScribeClient f24178b = new GalleryScribeClientImpl(TweetUi.m31786a());

    public static class GalleryItem implements Serializable {
        public final long f24174a;
        public final int f24175b;
        public final List<MediaEntity> f24176c;

        public GalleryItem(List<MediaEntity> list) {
            this(0, 0, list);
        }

        public GalleryItem(long j, int i, List<MediaEntity> list) {
            this.f24174a = j;
            this.f24175b = i;
            this.f24176c = list;
        }
    }

    class C25311 implements OnPageChangeListener {
        int f30767a = -1;
        final /* synthetic */ GalleryActivity f30768b;

        public final void m31768a(int i) {
        }

        C25311(GalleryActivity galleryActivity) {
            this.f30768b = galleryActivity;
        }

        public final void m31769a(int i, float f) {
            if (this.f30767a == -1 && i == 0 && ((double) f) == 0.0d) {
                this.f30768b.m25913a(i);
                this.f30767a++;
            }
        }

        public final void m31770b(int i) {
            if (this.f30767a >= 0) {
                this.f30768b.f24178b.mo5496b();
            }
            this.f30767a++;
            this.f30768b.m25913a(i);
        }
    }

    class C25322 implements Callback {
        final /* synthetic */ GalleryActivity f30769a;

        C25322(GalleryActivity galleryActivity) {
            this.f30769a = galleryActivity;
        }

        public final void mo5493a() {
            this.f30769a.m25912a();
            this.f30769a.finish();
            this.f30769a.overridePendingTransition(0, C2075R.anim.tw__slide_out);
        }
    }

    protected void onCreate(Bundle bundle) {
        GalleryItem galleryItem;
        super.onCreate(bundle);
        setContentView(C2075R.layout.tw__gallery_activity);
        MediaEntity mediaEntity = (MediaEntity) getIntent().getSerializableExtra("MEDIA_ENTITY");
        if (mediaEntity != null) {
            galleryItem = new GalleryItem(Collections.singletonList(mediaEntity));
        } else {
            galleryItem = (GalleryItem) getIntent().getSerializableExtra("GALLERY_ITEM");
        }
        this.f24177a = galleryItem;
        if (bundle == null) {
            this.f24178b.mo5494a();
        }
        bundle = new GalleryAdapter(this, new C25322(this));
        bundle.f30770b.addAll(this.f24177a.f24176c);
        bundle.d();
        ViewPager viewPager = (ViewPager) findViewById(C2075R.id.tw__view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(C2075R.dimen.tw__gallery_page_margin));
        viewPager.addOnPageChangeListener(new C25311(this));
        viewPager.setAdapter(bundle);
        viewPager.setCurrentItem(this.f24177a.f24175b);
    }

    public void onBackPressed() {
        m25912a();
        super.onBackPressed();
        overridePendingTransition(0, C2075R.anim.tw__slide_out);
    }

    final void m25912a() {
        this.f24178b.mo5497c();
    }

    final void m25913a(int i) {
        this.f24178b.mo5495a(ScribeItem.m25885a(this.f24177a.f24174a, (MediaEntity) this.f24177a.f24176c.get(i)));
    }
}
