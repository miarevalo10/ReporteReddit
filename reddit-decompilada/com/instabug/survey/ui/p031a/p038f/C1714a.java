package com.instabug.survey.ui.p031a.p038f;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.instabug.library.Instabug;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.survey.C0787R;

/* compiled from: ThanksFragment */
public class C1714a extends BaseFragment {
    public static C1714a m20562a() {
        Bundle bundle = new Bundle();
        C1714a c1714a = new C1714a();
        c1714a.setArguments(bundle);
        return c1714a;
    }

    protected int getLayout() {
        return C0787R.layout.instabug_survey_fragment_thanks_dialog;
    }

    protected void initViews(View view, Bundle bundle) {
        ((ImageView) findViewById(C0787R.id.instabug_img_thanks)).setColorFilter(Instabug.getPrimaryColor());
    }
}
