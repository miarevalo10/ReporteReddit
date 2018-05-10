package com.reddit.frontpage.ui.detail.live;

import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class LiveDetailsFragment extends BaseFrontpageFragment {
    @State
    String details;
    @BindView
    BaseHtmlTextView detailsView;

    public final int mo7160h() {
        return C1761R.layout.fragment_live_details;
    }

    public static LiveDetailsFragment m39144a(LiveThread liveThread) {
        LiveDetailsFragment liveDetailsFragment = new LiveDetailsFragment();
        liveDetailsFragment.details = liveThread.getResourcesHtml();
        return liveDetailsFragment;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.detailsView.setHtmlFromString(this.details);
    }
}
