package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.listing.ui.view.HeaderMetadataView.StringWithIndicators;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SubscribeDetailHeaderView extends HeaderMetadataView {
    public SubscribeDetailHeaderView(Context context) {
        this(context, null);
    }

    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        getOverflowLayout().setVisibility(8);
    }

    protected final String mo5061a() {
        return new StringBuilder().toString();
    }

    protected final StringWithIndicators mo5062b(Link link) {
        String f = Util.m24027f((int) C1761R.string.unicode_delimiter);
        StringBuilder stringBuilder = new StringBuilder();
        if (!SubredditUtil.m23920a(link.getSubredditNamePrefixed()) || link.isPromoted()) {
            stringBuilder.append(Util.m23960a((int) C1761R.string.fmt_u_name, link.getAuthor()));
        }
        Set arraySet = new ArraySet();
        if (link.getAuthor().equals(SessionUtil.m23899e())) {
            arraySet.add(Indicator.f20734c);
        }
        if (link.getAuthorCakeday().booleanValue()) {
            arraySet.add(Indicator.f20736e);
        }
        if (link.getDistinguishedType() == 1) {
            arraySet.add(Indicator.f20732a);
        } else if (link.getDistinguishedType() == 2) {
            arraySet.add(Indicator.f20733b);
        } else if (ModUtil.m23824a().getDistinguishState(link.getName(), link.isDistinguished())) {
            arraySet.add(Indicator.f20733b);
        }
        int gilded = link.getGilded();
        if (gilded > 0) {
            arraySet.add(Indicator.f20737f);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (gilded > 1) {
            stringBuilder2.append(getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(gilded)}));
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        if (!TextUtils.isEmpty(link.getAuthorFlairRichText())) {
            stringBuilder3.append(f);
            stringBuilder3.append(link.getAuthorFlairRichText());
        }
        if (!link.isPromoted()) {
            stringBuilder2.append(f);
            stringBuilder2.append(DateUtil.m23682a(link.getCreatedUtc(), TimeUnit.SECONDS));
        }
        int linkType = link.getLinkType();
        if (linkType == 4 || linkType == 5) {
            link = DomainUtil.m22714a(link.getDisplayDomain());
            if (!TextUtils.isEmpty(link)) {
                stringBuilder2.append(f);
                stringBuilder2.append(link);
            }
        }
        return new StringWithIndicators(stringBuilder.toString(), arraySet, stringBuilder3.toString(), stringBuilder2.toString());
    }
}
