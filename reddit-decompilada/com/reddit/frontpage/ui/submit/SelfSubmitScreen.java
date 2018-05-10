package com.reddit.frontpage.ui.submit;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.ui.listener.TextChangedListener;
import com.reddit.frontpage.util.SubmitUtil;
import com.reddit.frontpage.util.Util;

public class SelfSubmitScreen extends BaseSubmitScreen {
    @State
    String defaultText;
    @BindView
    EditText submitText;

    class C23741 extends TextChangedListener {
        final /* synthetic */ SelfSubmitScreen f29330a;

        C23741(SelfSubmitScreen selfSubmitScreen) {
            this.f29330a = selfSubmitScreen;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f29330a.mo7479W();
        }
    }

    class C23752 extends TextChangedListener {
        final /* synthetic */ SelfSubmitScreen f29331a;

        C23752(SelfSubmitScreen selfSubmitScreen) {
            this.f29331a = selfSubmitScreen;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f29331a.mo7479W();
        }
    }

    public String getAnalyticsScreenName() {
        return "post_text";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_submit_self;
    }

    public final int mo7480y() {
        return C1761R.string.title_submit_self;
    }

    public static SelfSubmitScreen m41139a(Subreddit subreddit, String str) {
        BaseSubmitScreen selfSubmitScreen = new SelfSubmitScreen();
        selfSubmitScreen.originSubreddit = subreddit;
        selfSubmitScreen.defaultText = str;
        return selfSubmitScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        if (this.defaultText != null) {
            this.submitText.setText(this.defaultText);
        }
        m39543x().addTextChangedListener(new C23741(this));
        this.submitText.addTextChangedListener(new C23752(this));
        return this.K;
    }

    public final void mo7479W() {
        boolean X = mo7487X();
        if (this.f39344y != null) {
            this.f39344y.setEnabled(X);
        }
    }

    public final void mo7477U() {
        SubmitUtil.m23908a(am_(), this.submitRequestId, m39519O(), m39543x().getText().toString(), this.submitText.getText().toString(), m39524T(), this.latitude, this.longitude, m39522R(), m39523S());
    }

    protected final boolean mo7476Q() {
        if (!TextUtils.isEmpty(m39543x().getText().toString())) {
            return super.mo7476Q();
        }
        mo7204a(Util.m24027f((int) C1761R.string.error_title_missing));
        return false;
    }

    protected final void mo7478V() {
        if (m39520P()) {
            m39543x().setHint(C1761R.string.submit_self_title_hint_promoter);
            this.submitText.setHint(C1761R.string.submit_self_body_hint_promoter);
            return;
        }
        m39543x().setHint(C1761R.string.submit_title_hint);
        this.submitText.setHint(C1761R.string.submit_self_body_hint);
    }

    public final boolean mo7487X() {
        return this.f39344y != null && super.mo7487X();
    }
}
