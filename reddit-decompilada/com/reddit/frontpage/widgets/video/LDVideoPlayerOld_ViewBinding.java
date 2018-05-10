package com.reddit.frontpage.widgets.video;

import android.view.TextureView;
import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LDVideoPlayerOld_ViewBinding extends VideoPlayerOld_ViewBinding {
    private LDVideoPlayerOld f34564b;

    public LDVideoPlayerOld_ViewBinding(LDVideoPlayerOld lDVideoPlayerOld, View view) {
        super(lDVideoPlayerOld, view);
        this.f34564b = lDVideoPlayerOld;
        lDVideoPlayerOld.textureView = (TextureView) Utils.b(view, C1761R.id.texture_view, "field 'textureView'", TextureView.class);
    }

    public final void mo6543a() {
        LDVideoPlayerOld lDVideoPlayerOld = this.f34564b;
        if (lDVideoPlayerOld == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34564b = null;
        lDVideoPlayerOld.textureView = null;
        super.mo6543a();
    }
}
