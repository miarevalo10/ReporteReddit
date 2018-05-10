package com.reddit.frontpage.widgets.submit;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.RedditView;
import com.reddit.frontpage.widgets.ShapedIconView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class SubredditLocationSelectView extends RedditView {
    String f29534b;
    private String f29535c;
    @BindString
    String defaultSubredditText;
    @BindView
    ImageView dropdownIcon;
    @BindView
    View locationContainer;
    @BindView
    ImageView locationIcon;
    @State
    boolean locationSet = null;
    @BindView
    TextView locationView;
    @State
    String requestTag;
    @BindView
    TextView rulesButton;
    @BindView
    ShapedIconView subredditIcon;
    @BindView
    TextView subredditView;

    public interface RulesClickListener {
        void mo5019a(String str);
    }

    public interface SelectionListener {
        void mo5017a();

        void mo5018b();
    }

    public int getLayoutId() {
        return C1761R.layout.widget_subreddit_select;
    }

    public SubredditLocationSelectView(Context context) {
        super(context);
    }

    public SubredditLocationSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubredditLocationSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SubredditLocationSelectView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void mo5070a() {
        super.mo5070a();
        this.f29534b = null;
        this.f29535c = null;
        setSelectedName(null);
        Util.m24000b(this.subredditIcon);
        Util.m23976a(this.subredditIcon);
    }

    public void setSubreddit(Subreddit subreddit) {
        m30538a(subreddit.getDisplayName(), subreddit.getIconImg(), subreddit.getKeyColor());
    }

    public final void m30538a(String str, String str2, String str3) {
        this.f29534b = SubredditUtil.m23930c(str);
        this.f29535c = str2;
        if (SubredditUtil.m23920a((CharSequence) str) != null) {
            setSelectedName(Util.m24027f((int) C1761R.string.rdt_promoter_my_profile));
            Util.m23987a(this.subredditIcon, this.f29535c, str3, true);
            this.rulesButton.setVisibility(8);
            return;
        }
        setSelectedName(Util.m23960a((int) C1761R.string.fmt_r_name, r0));
        Util.m23982a(this.subredditIcon, this.f29535c, str3);
        this.rulesButton.setVisibility(0);
    }

    private void setSelectedName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.subredditView.setTextColor(ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_meta_text_color));
            this.subredditView.setText(this.defaultSubredditText);
            return;
        }
        this.subredditView.setTextColor(ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_body_text_color));
        this.subredditView.setText(str);
    }

    public String getSubreddit() {
        return this.f29534b;
    }

    public String getLocation() {
        return this.locationSet ? this.locationView.getText().toString() : null;
    }

    public final void m30537a(String str, String str2) {
        this.locationContainer.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.locationView.setTextColor(ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_meta_text_color));
            this.locationView.setText(Util.m24027f((int) C1761R.string.add_location));
            this.locationSet = false;
        } else {
            this.locationView.setTextColor(ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_body_text_color));
            this.locationView.setText(str);
            this.locationSet = true;
        }
        if (TextUtils.isEmpty(str2) != null) {
            str = ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_default_key_color);
        } else {
            str = Color.parseColor(str2);
        }
        this.locationIcon.setImageDrawable(ResourcesUtil.m22730d(getContext(), C1761R.drawable.ind_location, str));
    }

    public void setSelectionListener(SelectionListener selectionListener) {
        this.subredditIcon.setOnClickListener(new SubredditLocationSelectView$$Lambda$0(selectionListener));
        this.subredditView.setOnClickListener(new SubredditLocationSelectView$$Lambda$1(selectionListener));
        this.dropdownIcon.setOnClickListener(new SubredditLocationSelectView$$Lambda$2(selectionListener));
        this.locationContainer.setOnClickListener(new SubredditLocationSelectView$$Lambda$3(selectionListener));
    }

    public void setOnRulesClickListener(RulesClickListener rulesClickListener) {
        this.rulesButton.setOnClickListener(new SubredditLocationSelectView$$Lambda$4(this, rulesClickListener));
    }

    public final Flowable<CharSequence> m30539b() {
        return RxTextView.a(this.subredditView).toFlowable(BackpressureStrategy.LATEST).filter(new SubredditLocationSelectView$$Lambda$5(this));
    }
}
