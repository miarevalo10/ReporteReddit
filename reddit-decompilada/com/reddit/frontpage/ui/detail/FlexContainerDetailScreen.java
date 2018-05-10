package com.reddit.frontpage.ui.detail;

import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import timber.log.Timber;

public abstract class FlexContainerDetailScreen extends BaseDetailScreen {
    public abstract int ag();

    protected FlexContainerDetailScreen(Bundle bundle) {
        super(bundle);
    }

    public final void mo7431S() {
        if (am_() != null) {
            Timber.b("at setup %s:%d", new Object[]{this.f39153F.getId(), Integer.valueOf(ag())});
            LayoutParams layoutParams = (LayoutParams) this.f39167y.getLayoutParams();
            layoutParams.height = r0;
            this.f39167y.setLayoutParams(layoutParams);
        }
    }
}
