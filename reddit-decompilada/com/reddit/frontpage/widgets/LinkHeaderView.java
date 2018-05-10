package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.android.view.TouchDelegate;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class LinkHeaderView extends BaseHeaderView implements LinkHeader {
    Link f29461a;
    @BindView
    TextView domainLabel;
    boolean f29462e;
    ModQueueCheckListener<Thing> f29463f;
    private boolean f29464g;
    @BindView
    TextView gildedCount;
    private int f29465h;
    private MenuItem f29466i;
    @BindView
    IconStatusView iconStatusView;
    private MenuItem f29467j;
    private MenuItem f29468k;
    private MenuItem f29469l;
    @BindView
    TextView linkAltLinkLabel;
    @BindView
    UserIndicatorsView linkUserIndicators;
    private MenuItem f29470m;
    private MenuItem f29471n;
    @BindView
    CheckBox selectListingBox;
    @BindView
    TextView timePostedLabel;
    @BindView
    ImageView xpostIndicator;

    public LinkHeaderView(Context context) {
        this(context, null);
    }

    public LinkHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30489a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public LinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m30489a(context, attributeSet, i, i2);
    }

    private void m30489a(Context context, AttributeSet attributeSet, int i, int i2) {
        inflate(context, C1761R.layout.merge_link_header, this);
        setClipToPadding(false);
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.LinkHeaderView, i, i2);
        try {
            this.f29464g = context.getBoolean(0, false);
            ButterKnife.a(this);
            if (ModUtil.m23834b(Routing.m22617a(getContext())) != null) {
                this.selectListingBox.setVisibility(0);
            }
            m24133a(new LinkHeaderView$$Lambda$0(this));
        } finally {
            context.recycle();
        }
    }

    protected void onFinishInflate() {
        int i;
        super.onFinishInflate();
        MenuUtil.m23812a(this.d.a);
        this.d.a(C1761R.menu.menu_link_options);
        if (SessionManager.b().c.isAnonymous()) {
            this.d.a.findItem(C1761R.id.action_report).setVisible(false);
        }
        this.f29466i = this.d.a.findItem(C1761R.id.action_hide);
        this.f29467j = this.d.a.findItem(C1761R.id.action_unhide);
        this.f29468k = this.d.a.findItem(C1761R.id.action_report);
        this.f29469l = this.d.a.findItem(C1761R.id.action_save);
        this.f29470m = this.d.a.findItem(C1761R.id.action_unsave);
        this.f29471n = this.d.a.findItem(C1761R.id.action_share);
        if (ModUtil.m23834b(Routing.m22617a(getContext()))) {
            i = 0;
        } else {
            i = this.linkAltLinkLabel.getPaddingLeft() + getPaddingLeft();
        }
        this.linkAltLinkLabel.setPadding(i, this.linkAltLinkLabel.getPaddingTop() + getPaddingTop(), this.linkAltLinkLabel.getPaddingRight(), this.linkAltLinkLabel.getPaddingBottom() + getPaddingBottom());
        this.timePostedLabel.setPadding(this.timePostedLabel.getPaddingLeft(), this.timePostedLabel.getPaddingTop() + getPaddingTop(), this.timePostedLabel.getPaddingRight(), this.timePostedLabel.getPaddingBottom() + getPaddingBottom());
        this.domainLabel.setPadding(this.domainLabel.getPaddingLeft(), this.domainLabel.getPaddingTop() + getPaddingTop(), this.domainLabel.getPaddingRight(), this.domainLabel.getPaddingBottom() + getPaddingBottom());
        this.b.setPadding(this.b.getPaddingLeft(), this.b.getPaddingTop() + getPaddingTop(), this.b.getPaddingRight() + getPaddingRight(), this.b.getPaddingBottom() + getPaddingBottom());
        this.f29465h = getPaddingRight();
        setPadding(0, 0, 0, 0);
        post(new LinkHeaderView$$Lambda$1(this));
    }

    final /* synthetic */ void mo5055d() {
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = this.b.getWidth();
        rect.bottom = this.b.getHeight();
        this.b.setTouchDelegate(new TouchDelegate(rect, this.c));
    }

    public void setDisplaySubredditName(boolean z) {
        this.f29462e = z;
    }

    public final void b_(Link link) {
        TextView textView;
        CharSequence subredditNamePrefixed;
        this.f29461a = link;
        Session session = SessionManager.b().c;
        int i = 0;
        boolean z = true;
        boolean z2 = (session.isAnonymous() || SessionUtil.m23895a(session, link.getAuthor())) ? false : true;
        boolean isHidden = this.f29461a.isHidden();
        MenuItem menuItem = this.f29466i;
        boolean z3 = z2 && !isHidden;
        menuItem.setVisible(z3);
        menuItem = this.f29467j;
        isHidden = z2 && isHidden;
        menuItem.setVisible(isHidden);
        this.f29468k.setVisible(z2);
        this.f29469l.setVisible(link.isSaved() ^ true);
        this.f29470m.setVisible(link.isSaved());
        Subreddit subredditDetail = link.getSubredditDetail();
        MenuItem menuItem2 = this.f29471n;
        z2 = subredditDetail != null && subredditDetail.user_is_moderator;
        menuItem2.setVisible(z2);
        this.linkAltLinkLabel.setTextColor(ResourcesUtil.m22740i(getContext(), C1761R.attr.rdt_metadata_text_color));
        this.linkAltLinkLabel.setAllCaps(false);
        this.linkUserIndicators.setActiveIndicators(Collections.emptySet());
        if (link.isPromoted()) {
            this.linkAltLinkLabel.setText(getContext().getString(C1761R.string.label_promoted));
            this.linkAltLinkLabel.setTextColor(ContextCompat.c(getContext(), C1761R.color.rdt_blue));
            this.linkAltLinkLabel.setAllCaps(true);
        } else if (this.f29462e) {
            textView = this.linkAltLinkLabel;
            subredditNamePrefixed = link.getSubredditNamePrefixed();
            if (TextUtils.isEmpty(subredditNamePrefixed)) {
                StringBuilder stringBuilder = new StringBuilder("r/");
                stringBuilder.append(link.getSubreddit());
                subredditNamePrefixed = stringBuilder.toString();
            }
            textView.setText(subredditNamePrefixed);
        } else {
            this.linkAltLinkLabel.setText(Util.m23960a((int) C1761R.string.fmt_u_name, link.getAuthor()));
            Set noneOf = EnumSet.noneOf(Indicator.class);
            if (link.getAuthorCakeday().booleanValue()) {
                noneOf.add(Indicator.f20736e);
            }
            if (SessionUtil.m23895a(session, link.getAuthor())) {
                noneOf.add(Indicator.f20734c);
            }
            boolean distinguishState = ModUtil.m23824a().getDistinguishState(link.getName(), link.isDistinguished());
            if (link.getDistinguishedType() == 1 && distinguishState) {
                noneOf.add(Indicator.f20732a);
            } else if (link.getDistinguishedType() == 2 && distinguishState) {
                noneOf.add(Indicator.f20733b);
            } else if (distinguishState) {
                noneOf.add(Indicator.f20733b);
            }
            int gilded = link.getGilded();
            if (gilded > 0) {
                noneOf.add(Indicator.f20737f);
                if (gilded > 1) {
                    this.gildedCount.setText(getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(link.getGilded())}));
                    this.gildedCount.setVisibility(0);
                } else {
                    this.gildedCount.setVisibility(8);
                }
            }
            this.linkUserIndicators.setActiveIndicators(noneOf);
        }
        View view = this.linkAltLinkLabel;
        view.setOnClickListener(new LinkHeaderView$$Lambda$5(this, view, link));
        this.selectListingBox.setChecked(false);
        this.selectListingBox.setOnCheckedChangeListener(new LinkHeaderView$$Lambda$2(this, link));
        subredditNamePrefixed = null;
        StringBuilder stringBuilder2;
        if (link.isPromoted()) {
            Context context = getContext();
            this.timePostedLabel.setText(null);
            TextView textView2 = this.domainLabel;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getString(C1761R.string.unicode_delimiter));
            stringBuilder2.append(context.getString(C1761R.string.fmt_u_name, new Object[]{link.getAuthor()}));
            TextView textView3 = textView2;
            subredditNamePrefixed = stringBuilder2.toString();
            textView = textView3;
        } else {
            textView = this.timePostedLabel;
            Context context2 = this.linkAltLinkLabel.getContext();
            stringBuilder2 = new StringBuilder();
            CharSequence b = DateUtil.m23684b(link.getCreatedUtc());
            String string = context2.getString(C1761R.string.unicode_bullet);
            String string2 = context2.getString(C1761R.string.unicode_space);
            stringBuilder2.append(string2);
            stringBuilder2.append(string);
            stringBuilder2.append(string2);
            stringBuilder2.append(b);
            textView.setText(stringBuilder2.toString());
            textView = this.domainLabel;
            int linkType = link.getLinkType();
            if (linkType == 4 || linkType == 5 || (this.f29464g && linkType == 1)) {
                Object a = link.getDomain() != null ? DomainUtil.m22714a(link.getDisplayDomain()) : null;
                if (!TextUtils.isEmpty(a)) {
                    Context context3 = this.linkAltLinkLabel.getContext();
                    stringBuilder2 = new StringBuilder();
                    String string3 = context3.getString(C1761R.string.unicode_bullet);
                    String string4 = context3.getString(C1761R.string.unicode_space);
                    stringBuilder2.append(string4);
                    stringBuilder2.append(string3);
                    stringBuilder2.append(string4);
                    stringBuilder2.append(a);
                    subredditNamePrefixed = stringBuilder2.toString();
                }
            }
        }
        textView.setText(subredditNamePrefixed);
        this.iconStatusView.m24155a(link);
        this.iconStatusView.setOnClickListener(new LinkHeaderView$$Lambda$3(this, link));
        link = link.getCrosspostParentList();
        if (link == null || link.isEmpty() != null) {
            z = false;
        }
        link = this.xpostIndicator;
        if (!z) {
            i = 8;
        }
        link.setVisibility(i);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.d.c = onMenuItemClickListener;
    }

    public void setShowOverflow(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, 0, this.f29465h, 0);
        }
    }

    public void setModQueueCheckListener(ModQueueCheckListener<Thing> modQueueCheckListener) {
        this.f29463f = modQueueCheckListener;
    }

    public void setDomainClickListener(OnClickListener onClickListener) {
        this.domainLabel.setOnClickListener(onClickListener);
    }
}
