package com.instabug.bug.view.p002a;

import android.net.Uri;
import com.instabug.bug.view.p002a.C0496a.C1277a;
import com.instabug.bug.view.p002a.C0496a.C1278b;
import com.instabug.library.C0593R;
import com.instabug.library.core.ui.BasePresenter;

/* compiled from: AnnotationPresenter */
class C1626c extends BasePresenter<C1278b> implements C1277a {
    C1626c(C1278b c1278b) {
        super(c1278b);
    }

    final void m19374a(int i, Uri uri) {
        if (this.view != null) {
            C1278b c1278b = (C1278b) this.view.get();
            if (c1278b != null) {
                if (i == 0) {
                    c1278b.mo4308a(C0593R.drawable.instabug_ic_next);
                } else {
                    c1278b.mo4308a(C0593R.drawable.instabug_ic_check);
                    c1278b.mo4307a();
                }
                if (uri != null) {
                    c1278b.mo4309a(uri);
                }
            }
        }
    }
}
