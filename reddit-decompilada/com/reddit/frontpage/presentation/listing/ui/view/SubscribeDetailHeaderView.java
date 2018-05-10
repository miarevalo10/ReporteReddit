package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.HeaderMetadataView.StringWithIndicators;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.SubredditUtil;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/SubscribeDetailHeaderView;", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "generateBottomMetadata", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView$StringWithIndicators;", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "generateTopMetadata", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubscribeDetailHeaderView.kt */
public final class SubscribeDetailHeaderView extends HeaderMetadataView {
    private HashMap f28502b;

    public SubscribeDetailHeaderView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View mo4901a(int i) {
        if (this.f28502b == null) {
            this.f28502b = new HashMap();
        }
        View view = (View) this.f28502b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28502b.put(Integer.valueOf(i), view);
        return view;
    }

    protected final String mo4902a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        return "";
    }

    public /* synthetic */ SubscribeDetailHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        if (attributeSet == null) {
            Intrinsics.m26842a();
        }
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SubscribeDetailHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
    }

    protected final StringWithIndicators mo4903b(LinkPresentationModel linkPresentationModel) {
        int i;
        Object stringBuilder;
        Set set;
        Object stringBuilder2;
        Object stringBuilder3;
        Intrinsics.m26847b(linkPresentationModel, "link");
        String string = getContext().getString(C1761R.string.unicode_delimiter);
        StringBuilder stringBuilder4 = new StringBuilder();
        int i2 = 0;
        if (!SubredditUtil.m23920a((CharSequence) linkPresentationModel.f33979f) || linkPresentationModel.f33962O) {
            stringBuilder4.append(getContext().getString(C1761R.string.fmt_u_name, new Object[]{linkPresentationModel.f33985l}));
        }
        Object noneOf = EnumSet.noneOf(Indicator.class);
        if (Intrinsics.m26845a(linkPresentationModel.f33985l, SessionUtil.m23899e())) {
            noneOf.add(Indicator.f20734c);
        }
        if (linkPresentationModel.f33987n) {
            noneOf.add(Indicator.f20736e);
        }
        if (Intrinsics.m26845a(linkPresentationModel.f33993t, DistinguishType.c)) {
            noneOf.add(Indicator.f20732a);
        } else if (Intrinsics.m26845a(linkPresentationModel.f33993t, DistinguishType.a)) {
            noneOf.add(Indicator.f20733b);
        } else if (ModUtil.m23824a().getDistinguishState(linkPresentationModel.getName(), linkPresentationModel.m34744a())) {
            noneOf.add(Indicator.f20733b);
        }
        int i3 = linkPresentationModel.f33990q;
        if (i3 > 0) {
            noneOf.add(Indicator.f20737f);
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        if (i3 > 1) {
            stringBuilder5.append(getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(i3)}));
        }
        StringBuilder stringBuilder6 = new StringBuilder();
        CharSequence charSequence = linkPresentationModel.f33949B;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                i = 0;
                if (i == 0) {
                    stringBuilder6.append(string);
                    stringBuilder6.append(linkPresentationModel.f33949B);
                }
                if (!linkPresentationModel.f33962O) {
                    stringBuilder5.append(string);
                    DateUtil dateUtil = DateUtil.f20370a;
                    stringBuilder5.append(DateUtil.m22706b(linkPresentationModel.f33982i));
                }
                if (linkPresentationModel.as || linkPresentationModel.ar) {
                    linkPresentationModel = DomainUtil.m22714a(linkPresentationModel.f33974a);
                    charSequence = (CharSequence) linkPresentationModel;
                    if (charSequence == null || charSequence.length() == 0) {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        stringBuilder5.append(string);
                        stringBuilder5.append(linkPresentationModel);
                    }
                }
                stringBuilder = stringBuilder4.toString();
                Intrinsics.m26843a(stringBuilder, "beforeIndicatorsBuilder.toString()");
                Intrinsics.m26843a(noneOf, "indicators");
                set = (Set) noneOf;
                stringBuilder2 = stringBuilder6.toString();
                Intrinsics.m26843a(stringBuilder2, "authorFlairBuilder.toString()");
                stringBuilder3 = stringBuilder5.toString();
                Intrinsics.m26843a(stringBuilder3, "afterIndicatorsBuilder.toString()");
                return new StringWithIndicators(stringBuilder, set, stringBuilder2, stringBuilder3);
            }
        }
        i = 1;
        if (i == 0) {
            stringBuilder6.append(string);
            stringBuilder6.append(linkPresentationModel.f33949B);
        }
        if (linkPresentationModel.f33962O) {
            stringBuilder5.append(string);
            DateUtil dateUtil2 = DateUtil.f20370a;
            stringBuilder5.append(DateUtil.m22706b(linkPresentationModel.f33982i));
        }
        linkPresentationModel = DomainUtil.m22714a(linkPresentationModel.f33974a);
        charSequence = (CharSequence) linkPresentationModel;
        i2 = 1;
        if (i2 == 0) {
            stringBuilder5.append(string);
            stringBuilder5.append(linkPresentationModel);
        }
        stringBuilder = stringBuilder4.toString();
        Intrinsics.m26843a(stringBuilder, "beforeIndicatorsBuilder.toString()");
        Intrinsics.m26843a(noneOf, "indicators");
        set = (Set) noneOf;
        stringBuilder2 = stringBuilder6.toString();
        Intrinsics.m26843a(stringBuilder2, "authorFlairBuilder.toString()");
        stringBuilder3 = stringBuilder5.toString();
        Intrinsics.m26843a(stringBuilder3, "afterIndicatorsBuilder.toString()");
        return new StringWithIndicators(stringBuilder, set, stringBuilder2, stringBuilder3);
    }
}
