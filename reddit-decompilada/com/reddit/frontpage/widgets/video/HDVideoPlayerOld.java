package com.reddit.frontpage.widgets.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import butterknife.BindView;
import com.reddit.frontpage.C1761R;

public class HDVideoPlayerOld extends VideoPlayerOld {
    private boolean f29539c;
    private Callback f29540d;
    @BindView
    SurfaceView surfaceView;

    class C19321 implements Callback {
        final /* synthetic */ HDVideoPlayerOld f22108a;
        private boolean f22109b = null;

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        C19321(HDVideoPlayerOld hDVideoPlayerOld) {
            this.f22108a = hDVideoPlayerOld;
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (this.f22108a.a != null) {
                if (this.f22109b != null) {
                    this.f22108a.m24387e();
                    this.f22109b = null;
                }
                this.f22108a.a.a(this.f22108a.surfaceView);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f22109b = true;
            this.f22108a.f29539c = false;
            this.f22108a.m24395m();
        }
    }

    public int getLayoutId() {
        return C1761R.layout.hd_video_player;
    }

    public HDVideoPlayerOld(Context context) {
        super(context);
    }

    public HDVideoPlayerOld(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HDVideoPlayerOld(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public HDVideoPlayerOld(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected final void mo5072a() {
        super.mo5072a();
        this.f29539c = true;
    }

    protected final void mo5073b() {
        super.mo5073b();
        if (this.f29539c) {
            m24396n();
        }
    }

    protected final void mo5074c() {
        if (this.f29540d != null) {
            this.surfaceView.getHolder().removeCallback(this.f29540d);
        }
        this.f29540d = new C19321(this);
        this.surfaceView.getHolder().addCallback(this.f29540d);
    }
}
