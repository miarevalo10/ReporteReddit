package com.reddit.frontpage.widgets.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import butterknife.BindView;
import com.reddit.frontpage.C1761R;
import timber.log.Timber;

public class LDVideoPlayerOld extends VideoPlayerOld {
    private SurfaceTextureListener f29541c;
    private boolean f29542d;
    @BindView
    TextureView textureView;

    class C19331 implements SurfaceTextureListener {
        final /* synthetic */ LDVideoPlayerOld f22110a;
        private boolean f22111b = null;

        C19331(LDVideoPlayerOld lDVideoPlayerOld) {
            this.f22110a = lDVideoPlayerOld;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.f22110a.a != null) {
                if (this.f22110a.f29541c == this) {
                    if (this.f22111b != null) {
                        this.f22110a.m24387e();
                        this.f22111b = null;
                    }
                    this.f22110a.a.a(this.f22110a.textureView);
                    this.f22110a.textureView.setSurfaceTextureListener(this);
                }
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f22110a.m24396n();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (this.f22110a.f29541c != this) {
                return true;
            }
            Timber.b("onSurfaceTextureDestroyed: %s", new Object[]{this.f22110a.b});
            this.f22111b = true;
            this.f22110a.f29542d = false;
            this.f22110a.m24395m();
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (this.f22110a.f29541c == this && this.f22110a.a != null && this.f22110a.f29542d != null && this.f22110a.a.a() == 3) {
                Timber.b("playback state: %s", new Object[]{Integer.valueOf(this.f22110a.a.a())});
                this.f22110a.m24396n();
            }
        }
    }

    public int getLayoutId() {
        return C1761R.layout.ld_video_player;
    }

    public LDVideoPlayerOld(Context context) {
        super(context);
    }

    public LDVideoPlayerOld(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LDVideoPlayerOld(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public LDVideoPlayerOld(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected final void mo5072a() {
        this.f29542d = true;
    }

    protected final void mo5074c() {
        this.f29541c = new C19331(this);
        this.textureView.setSurfaceTextureListener(this.f29541c);
        if (this.textureView.getSurfaceTexture() != null) {
            this.a.a(this.textureView);
            this.textureView.setSurfaceTextureListener(this.f29541c);
        }
    }
}
