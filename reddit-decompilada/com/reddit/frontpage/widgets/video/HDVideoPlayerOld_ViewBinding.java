package com.reddit.frontpage.widgets.video;

import android.view.SurfaceView;
import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class HDVideoPlayerOld_ViewBinding extends VideoPlayerOld_ViewBinding {
    private HDVideoPlayerOld f34563b;

    public HDVideoPlayerOld_ViewBinding(HDVideoPlayerOld hDVideoPlayerOld, View view) {
        super(hDVideoPlayerOld, view);
        this.f34563b = hDVideoPlayerOld;
        hDVideoPlayerOld.surfaceView = (SurfaceView) Utils.b(view, C1761R.id.surface_view, "field 'surfaceView'", SurfaceView.class);
    }

    public final void mo6543a() {
        HDVideoPlayerOld hDVideoPlayerOld = this.f34563b;
        if (hDVideoPlayerOld == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34563b = null;
        hDVideoPlayerOld.surfaceView = null;
        super.mo6543a();
    }
}
