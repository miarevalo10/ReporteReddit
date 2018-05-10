package com.reddit.frontpage.ui.detail.web;

import android.os.Bundle;
import android.view.View;
import com.reddit.frontpage.C1761R;

public class GatewayBrowserFragment extends WebBrowserFragment {
    protected final int mo6998a() {
        return C1761R.layout.gateway_browser;
    }

    public static WebBrowserFragment m37573a(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.reddit.args.initial_url", str);
        bundle.putInt("com.reddit.arg.color", i);
        bundle.putString("com.reddit.arg.title_override", str2);
        str = new GatewayBrowserFragment();
        str.setArguments(bundle);
        return str;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b.setVisibility(8);
    }

    protected final void mo6999a(String str) {
        this.d.setTitle(str);
    }
}
