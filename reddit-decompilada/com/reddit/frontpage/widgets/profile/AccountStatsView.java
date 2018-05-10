package com.reddit.frontpage.widgets.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.AnkoLinearLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/widgets/profile/AccountStatsView;", "Lcom/reddit/frontpage/util/kotlin/AnkoLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bindAccount", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "Lcom/reddit/frontpage/presentation/profile/user/model/UserAccountPresentationModel;", "init", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountStatsView.kt */
public final class AccountStatsView extends AnkoLinearLayout {
    private HashMap f29528a;

    public AccountStatsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View mo5068a(int i) {
        if (this.f29528a == null) {
            this.f29528a = new HashMap();
        }
        View view = (View) this.f29528a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f29528a.put(Integer.valueOf(i), view);
        return view;
    }

    public AccountStatsView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        m30524a();
    }

    public /* synthetic */ AccountStatsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    @TargetApi(21)
    public AccountStatsView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        m30524a();
    }

    private void m30524a() {
        setOrientation(0);
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        setDividerDrawable(ResourcesUtil.m22723b(context, (int) C1761R.attr.rdt_vertical_divider_drawable));
        setShowDividers(2);
        LinearLayout.inflate(getContext(), C1761R.layout.merge_user_stats, this);
        FancyStat fancyStat = (FancyStat) mo5068a(C1761R.id.karma_stat);
        Object f = Util.m24027f((int) C1761R.string.value_placeholder);
        Intrinsics.m26843a(f, "Util.getString(R.string.value_placeholder)");
        fancyStat.setStatValue(f);
        fancyStat.setStatIcon(C1761R.drawable.ic_icon_karma);
        f = fancyStat.getResources().getString(C1761R.string.karma);
        Intrinsics.m26843a(f, "resources.getString(R.string.karma)");
        fancyStat.setStatUnit(f);
        fancyStat = (FancyStat) mo5068a(C1761R.id.account_age_stat);
        Object f2 = Util.m24027f((int) C1761R.string.value_placeholder);
        Intrinsics.m26843a(f2, "Util.getString(R.string.value_placeholder)");
        fancyStat.setStatValue(f2);
        fancyStat.setStatIcon(C1761R.drawable.ic_icon_cake);
        f2 = Util.m24027f((int) C1761R.string.label_reddit_age);
        Intrinsics.m26843a(f2, "Util.getString(R.string.label_reddit_age)");
        fancyStat.setStatUnit(f2);
    }

    public final void m30526a(UserAccountPresentationModel userAccountPresentationModel) {
        Intrinsics.m26847b(userAccountPresentationModel, "account");
        ((FancyStat) mo5068a(C1761R.id.karma_stat)).setStatValue(userAccountPresentationModel.f20961a);
        ((FancyStat) mo5068a(C1761R.id.account_age_stat)).setStatValue(userAccountPresentationModel.f20962b);
    }
}
