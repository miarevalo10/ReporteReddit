package com.reddit.frontpage.ui.detail.video;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.evernote.android.state.State;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;

@TargetApi(16)
public class VideoPlayerScreenLegacy extends SaveMediaScreen {
    @State
    String fullName;
    @State
    String gifUri;
    @State
    String imageUri;
    @State
    String mp4Uri;
    @State
    int videoHeight = -1;
    @BindView
    ViewGroup videoLayout;
    @BindView
    VideoPlayerOld videoPlayerOld;
    @State
    int videoWidth = -1;

    public final int mo7141s() {
        return C1761R.layout.screen_lightbox_video_legacy;
    }

    public static VideoPlayerScreenLegacy m40969a(Link link, String str) {
        VideoPlayerScreenLegacy videoPlayerScreenLegacy = new VideoPlayerScreenLegacy();
        videoPlayerScreenLegacy.link = link;
        if (!(link.getPreview() == null || TextUtils.isEmpty(link.getPreview().getSourceUrl()))) {
            videoPlayerScreenLegacy.imageUri = link.getPreview().getSourceUrl();
            if (link.getPreview().getSource() != null) {
                videoPlayerScreenLegacy.videoWidth = link.getPreview().getSource().getWidth();
                videoPlayerScreenLegacy.videoHeight = link.getPreview().getSource().getHeight();
            }
        }
        videoPlayerScreenLegacy.mp4Uri = Util.m24036i(link);
        videoPlayerScreenLegacy.gifUri = Util.m24040k(link);
        videoPlayerScreenLegacy.sourcePage = str;
        videoPlayerScreenLegacy.fullName = link.getName();
        return videoPlayerScreenLegacy;
    }

    public static VideoPlayerScreenLegacy m40970a(String str, String str2, String str3) {
        VideoPlayerScreenLegacy videoPlayerScreenLegacy = new VideoPlayerScreenLegacy();
        videoPlayerScreenLegacy.imageUri = str;
        videoPlayerScreenLegacy.mp4Uri = str2;
        videoPlayerScreenLegacy.gifUri = null;
        videoPlayerScreenLegacy.sourcePage = str3;
        videoPlayerScreenLegacy.fullName = null;
        return videoPlayerScreenLegacy;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        if (TextUtils.isEmpty(this.imageUri) == null) {
            GlideApp.a(am_()).b(this.imageUri).into(new DrawableImageViewTarget(this, this.videoPlayerOld.getPreviewImage()) {
                final /* synthetic */ VideoPlayerScreenLegacy f40602c;

                public final /* synthetic */ void m42212a(Object obj, Transition transition) {
                    Drawable drawable = (Drawable) obj;
                    if (this.f40602c.e && !this.f40602c.videoPlayerOld.m24391i()) {
                        super.a(drawable, transition);
                    }
                }
            });
        }
        layoutInflater = new VideoPlayerScreenLegacy$$Lambda$0(this);
        this.videoPlayerOld.setOnClickListener(layoutInflater);
        this.videoLayout.setOnClickListener(layoutInflater);
        super.mo7441d(null);
        this.videoPlayerOld.getPreviewImage().setOnTouchListener(mo7442y());
        this.videoPlayerOld.setOnTouchListener(mo7442y());
        if (this.videoWidth > null && this.videoHeight > null) {
            layoutInflater = Util.m23955a(am_());
            this.videoHeight = (int) (((float) layoutInflater.x) * (((float) this.videoHeight) / (((float) this.videoWidth) * 1.0f)));
            this.videoWidth = layoutInflater.x;
            this.videoPlayerOld.getLayoutParams().width = this.videoWidth;
            this.videoPlayerOld.getLayoutParams().height = this.videoHeight;
            this.videoPlayerOld.setPlayListener(new VideoPlayerScreenLegacy$$Lambda$1(this));
        }
        return this.K;
    }

    final /* synthetic */ void mo7435X() {
        if (this.videoPlayerOld != null && Math.abs(this.videoPlayerOld.getTranslationY()) <= 100.0f) {
            ((ViewGroup) this.K).setLayoutTransition(new LayoutTransition());
            m39064x();
        }
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        this.videoPlayerOld.m24383a(this.mp4Uri, true, true);
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.videoPlayerOld.m24392j();
    }

    public final void m40975a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_lightbox_video, menu);
        if (TextUtils.isEmpty(this.gifUri) != null) {
            menu.findItem(C1761R.id.action_save_gif).setVisible(false);
        }
        if (TextUtils.isEmpty(this.gifUri) == null || TextUtils.isEmpty(this.mp4Uri) != null) {
            menu.findItem(C1761R.id.action_save_video).setVisible(false);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != C1761R.id.action_share) {
            switch (itemId) {
                case C1761R.id.action_save_gif:
                    Util.m23975a((Screen) this, this.gifUri, null);
                    return true;
                case C1761R.id.action_save_video:
                    Util.m23975a((Screen) this, this.mp4Uri, "mp4");
                    return true;
                default:
                    return super.mo7201a(menuItem);
            }
        }
        Context am_ = am_();
        String str = this.mediaUri != null ? this.mediaUri : this.mp4Uri != null ? this.mp4Uri : this.gifUri;
        a(IntentUtil.m23746a(am_, LinkUtil.m23778a(str)));
        return true;
    }

    protected final String mo7433T() {
        return Util.m24027f((int) C1761R.string.save_video_success);
    }

    protected final String mo7434U() {
        return Util.m24027f((int) C1761R.string.error_unable_save_video);
    }

    protected final void mo7440a(int[] iArr) {
        if (PermissionUtil.m23866a(iArr) == null) {
            m37532c((int) 2131886372);
        }
    }
}
