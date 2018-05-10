package com.reddit.frontpage.ui.detail.image;

import android.animation.LayoutTransition;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.evernote.android.state.State;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.util.ImageUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import java.io.File;

public class LightboxScreen extends SaveMediaScreen {
    @State
    String domain;
    @State
    String fullname;
    @State
    int imageHeight;
    @BindView
    View imageLoading;
    @BindView
    SubsamplingScaleImageView imageView;
    @State
    int imageWidth;
    private Bitmap f40142x;
    private SnooProgressDrawable f40143y;

    class C30371 extends SimpleTarget<Bitmap> {
        final /* synthetic */ LightboxScreen f39169a;

        C30371(LightboxScreen lightboxScreen) {
            this.f39169a = lightboxScreen;
        }

        public final /* synthetic */ void m39142a(Object obj, Transition transition) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f39169a.imageLoading != null && this.f39169a.imageView != null) {
                this.f39169a.f40142x = bitmap;
                this.f39169a.imageLoading.setVisibility(8);
                this.f39169a.imageView.setImage(ImageSource.a(bitmap));
            }
        }
    }

    class C30382 extends SimpleTarget<File> {
        final /* synthetic */ LightboxScreen f39170a;

        C30382(LightboxScreen lightboxScreen) {
            this.f39170a = lightboxScreen;
        }

        public final /* synthetic */ void m39143a(Object obj, Transition transition) {
            File file = (File) obj;
            if (this.f39170a.e != null) {
                this.f39170a.imageLoading.setVisibility(8);
                this.f39170a.imageView.setImage(ImageSource.b(file.getAbsolutePath()));
            }
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_lightbox_image;
    }

    public static LightboxScreen m40921a(Link link, String str) {
        LightboxScreen lightboxScreen = new LightboxScreen();
        ImageResolution a = LinkUtil.m23774a(link);
        lightboxScreen.link = link;
        lightboxScreen.fullname = link.getName();
        lightboxScreen.domain = link.getDomain();
        lightboxScreen.sourcePage = str;
        if (a != null) {
            lightboxScreen.mediaUri = a.getUrl();
            lightboxScreen.imageWidth = a.getWidth();
            lightboxScreen.imageHeight = a.getHeight();
        } else {
            lightboxScreen.mediaUri = link.getUrl();
            lightboxScreen.imageWidth = -1;
            lightboxScreen.imageHeight = -1;
        }
        return lightboxScreen;
    }

    public static LightboxScreen m40922a(String str, String str2, int i, int i2) {
        LightboxScreen lightboxScreen = new LightboxScreen();
        lightboxScreen.mediaUri = str;
        lightboxScreen.sourcePage = str2;
        lightboxScreen.imageWidth = i;
        lightboxScreen.imageHeight = i2;
        return lightboxScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.imageView.setOnClickListener(new LightboxScreen$$Lambda$0(this));
        this.f40143y = new SnooProgressDrawable(viewGroup.getContext());
        this.imageLoading.setBackground(this.f40143y);
        if (ImageUtil.m23724a(this.imageWidth, this.imageHeight) == null) {
            this.imageLoading.setVisibility(0);
            GlideApp.a(am_()).j().load(this.mediaUri).listener(ImageProgressLoadListener.a(this.f40143y, this.mediaUri)).into(new C30382(this));
        } else if (this.f40142x == null || this.f40142x.isRecycled() != null) {
            this.imageLoading.setVisibility(0);
            GlideApp.a(am_()).h().load(this.mediaUri).listener(ImageProgressLoadListener.a(this.f40143y, this.mediaUri)).into(new C30371(this));
        } else {
            this.imageView.setImage(ImageSource.a(this.f40142x));
        }
        this.imageView.setOnTouchListener(mo7442y());
        return this.K;
    }

    public final void m40927a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_lightbox_image, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1761R.id.action_save) {
            menuItem = AppAnalytics.m21858b();
            menuItem.f19954a = "lightbox";
            menuItem.f19955b = "lightbox_save";
            menuItem.f19957d = this.fullname;
            menuItem.f19959f = this.domain;
            menuItem.m21825a();
            Util.m23974a((Screen) this, this.mediaUri);
            return true;
        } else if (itemId != C1761R.id.action_share) {
            return super.mo7201a(menuItem);
        } else {
            a(IntentUtil.m23746a(am_(), LinkUtil.m23778a(this.mediaUri)));
            return true;
        }
    }

    protected final String mo7433T() {
        return Util.m24027f((int) C1761R.string.save_image_success);
    }

    protected final String mo7434U() {
        return Util.m24027f((int) C1761R.string.error_unable_save_image);
    }

    final /* synthetic */ void mo7435X() {
        if (this.e) {
            ((ViewGroup) this.K).setLayoutTransition(new LayoutTransition());
            m39064x();
        }
    }
}
