package com.reddit.frontpage.ui.submit;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.ui.listener.TextChangedListener;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.SubmitUtil;
import com.reddit.frontpage.util.Util;

public class LinkSubmitScreen extends BaseSubmitScreen {
    @State
    String defaultLink;
    @BindView
    TextView safeHarborText;
    @BindView
    EditText submitLink;

    class C23721 extends TextChangedListener {
        final /* synthetic */ LinkSubmitScreen f29312a;

        C23721(LinkSubmitScreen linkSubmitScreen) {
            this.f29312a = linkSubmitScreen;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (Util.m24016d(charSequence.toString()) != null) {
                this.f29312a.safeHarborText.setVisibility(0);
            } else {
                this.f29312a.safeHarborText.setVisibility(8);
            }
            this.f29312a.mo7479W();
        }
    }

    public String getAnalyticsScreenName() {
        return "post_link";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_submit_link;
    }

    public final int mo7480y() {
        return C1761R.string.title_submit_link;
    }

    public static LinkSubmitScreen m41098a(Subreddit subreddit, String str) {
        BaseSubmitScreen linkSubmitScreen = new LinkSubmitScreen();
        linkSubmitScreen.originSubreddit = subreddit;
        if (LinkUtil.m23789a((CharSequence) str) != null) {
            linkSubmitScreen.defaultLink = str;
        }
        return linkSubmitScreen;
    }

    public final void mo7477U() {
        SubmitUtil.m23909b(am_(), this.submitRequestId, m39519O(), m39543x().getText().toString(), this.submitLink.getText().toString(), m39524T(), this.latitude, this.longitude, m39522R(), m39523S());
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        if (this.defaultLink != null) {
            this.submitLink.setText(this.defaultLink);
        }
        layoutInflater = new C23721(this);
        m39543x().addTextChangedListener(layoutInflater);
        this.submitLink.addTextChangedListener(layoutInflater);
        return this.K;
    }

    public final void mo7479W() {
        boolean z = super.mo7487X() && LinkUtil.m23789a(this.submitLink.getText());
        if (this.f39344y != null) {
            this.f39344y.setEnabled(z);
        }
    }

    protected final boolean mo7476Q() {
        if (TextUtils.isEmpty(m39543x().getText().toString())) {
            mo7204a(Util.m24027f((int) C1761R.string.error_title_missing));
            return false;
        } else if (!TextUtils.isEmpty(this.submitLink.getText().toString())) {
            return super.mo7476Q();
        } else {
            mo7204a(Util.m24027f((int) C1761R.string.error_link_missing));
            return false;
        }
    }

    protected final void mo7478V() {
        if (m39520P()) {
            m39543x().setHint(C1761R.string.submit_link_title_hint_promoter);
        } else {
            m39543x().setHint(C1761R.string.submit_title_hint);
        }
    }
}
