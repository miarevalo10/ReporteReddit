package com.instabug.bug.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.bug.C0465R;
import com.instabug.library.C0593R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.InstabugLogoProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PlaceHolderUtils;

/* compiled from: InstabugSuccessFragment */
public class C1708g extends BaseFragment {

    /* compiled from: InstabugSuccessFragment */
    class C05191 implements OnClickListener {
        final /* synthetic */ C1708g f9205a;

        C05191(C1708g c1708g) {
            this.f9205a = c1708g;
        }

        public void onClick(View view) {
            this.f9205a.finishActivity();
        }
    }

    protected int getLayout() {
        return C0465R.layout.instabug_lyt_success;
    }

    protected void initViews(View view, Bundle bundle) {
        view = Key.REPORT_SUCCESSFULLY_SENT;
        bundle = new InstabugAppData(getActivity().getApplicationContext()).getAppName();
        if (bundle == null) {
            InstabugSDKLogger.m8361w(this, "It seems app:name isn't defined in your manifest. Using a generic name instead");
        }
        int i = C0465R.string.instabug_str_success_note;
        Object[] objArr = new Object[1];
        if (bundle == null) {
            bundle = "App";
        }
        objArr[0] = bundle;
        ((TextView) findViewById(C0465R.id.instabug_txt_success_note)).setText(PlaceHolderUtils.getPlaceHolder(view, getString(i, objArr)));
        if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.ENABLED) {
            findViewById(C0465R.id.instabug_pbi_container).setVisibility(8);
        } else {
            getActivity().findViewById(C0465R.id.instabug_pbi_footer).setVisibility(8);
            ((ImageView) findViewById(C0465R.id.image_instabug_logo)).setImageBitmap(InstabugLogoProvider.getInstabugLogo());
        }
        ((TextView) findViewById(C0593R.id.instabug_fragment_title)).setText(PlaceHolderUtils.getPlaceHolder(Key.SUCCESS_DIALOG_HEADER, getString(C0465R.string.instabug_str_thank_you)));
        findViewById(C0465R.id.instabug_success_dialog_container).setOnClickListener(new C05191(this));
    }
}
