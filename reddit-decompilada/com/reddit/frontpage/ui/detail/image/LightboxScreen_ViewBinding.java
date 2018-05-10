package com.reddit.frontpage.ui.detail.image;

import android.view.View;
import butterknife.internal.Utils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.SaveMediaScreen_ViewBinding;

public class LightboxScreen_ViewBinding extends SaveMediaScreen_ViewBinding {
    private LightboxScreen f34271b;

    public LightboxScreen_ViewBinding(LightboxScreen lightboxScreen, View view) {
        super(lightboxScreen, view);
        this.f34271b = lightboxScreen;
        lightboxScreen.imageLoading = Utils.a(view, C1761R.id.image_loading, "field 'imageLoading'");
        lightboxScreen.imageView = (SubsamplingScaleImageView) Utils.b(view, C1761R.id.image_view, "field 'imageView'", SubsamplingScaleImageView.class);
    }

    public final void mo6499a() {
        LightboxScreen lightboxScreen = this.f34271b;
        if (lightboxScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34271b = null;
        lightboxScreen.imageLoading = null;
        lightboxScreen.imageView = null;
        super.mo6499a();
    }
}
