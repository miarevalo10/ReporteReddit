package com.reddit.frontpage.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkFooterView;

public class SaveMediaScreen_ViewBinding implements Unbinder {
    private SaveMediaScreen f28890b;

    public SaveMediaScreen_ViewBinding(SaveMediaScreen saveMediaScreen, View view) {
        this.f28890b = saveMediaScreen;
        saveMediaScreen.footerView = (LinkFooterView) Utils.b(view, C1761R.id.footer_bar, "field 'footerView'", LinkFooterView.class);
        saveMediaScreen.background = Utils.a(view, C1761R.id.background, "field 'background'");
        saveMediaScreen.topBottom = (ViewGroup) Utils.b(view, C1761R.id.top_bottom, "field 'topBottom'", ViewGroup.class);
        saveMediaScreen.lightboxTitleHeader = (LinearLayout) Utils.b(view, C1761R.id.lightbox_title_header, "field 'lightboxTitleHeader'", LinearLayout.class);
        saveMediaScreen.lightboxTitleHeaderDetails = (TextView) Utils.b(view, C1761R.id.lightbox_title_header_details, "field 'lightboxTitleHeaderDetails'", TextView.class);
        saveMediaScreen.lightboxTitleHeaderTitle = (TextView) Utils.b(view, C1761R.id.lightbox_title_header_title, "field 'lightboxTitleHeaderTitle'", TextView.class);
    }

    public void mo6499a() {
        SaveMediaScreen saveMediaScreen = this.f28890b;
        if (saveMediaScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28890b = null;
        saveMediaScreen.footerView = null;
        saveMediaScreen.background = null;
        saveMediaScreen.topBottom = null;
        saveMediaScreen.lightboxTitleHeader = null;
        saveMediaScreen.lightboxTitleHeaderDetails = null;
        saveMediaScreen.lightboxTitleHeaderTitle = null;
    }
}
