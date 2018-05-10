package com.reddit.frontpage.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class AcknowledgementsFragment extends Fragment {
    private ViewGroup f34194a;
    private BaseHtmlTextView f34195b;

    public static AcknowledgementsFragment m34892a() {
        return new AcknowledgementsFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f34194a = (ViewGroup) layoutInflater.inflate(C1761R.layout.fragment_acknowledgements, viewGroup, false);
        this.f34195b = (BaseHtmlTextView) this.f34194a.findViewById(C1761R.id.acknowledgements_text);
        this.f34195b.setHtmlFromString(Util.m24026f());
        return this.f34194a;
    }
}
