package com.instabug.chat.ui.p009a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.instabug.chat.ui.p009a.C0557a.C1315a;
import com.instabug.chat.ui.p009a.C0557a.C1316b;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.BitmapUtils;

/* compiled from: AnnotationPresenter */
class C1638c extends BasePresenter<C1316b> implements C1315a {
    C1638c(C1316b c1316b) {
        super(c1316b);
    }

    public final void mo3645a(Bitmap bitmap, Uri uri) {
        if (this.view != null) {
            C1316b c1316b = (C1316b) this.view.get();
            if (c1316b != null && bitmap != null) {
                BitmapUtils.saveBitmap(bitmap, uri, ((Fragment) c1316b.getViewContext()).getContext());
            }
        }
    }
}
