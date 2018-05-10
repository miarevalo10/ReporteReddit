package com.reddit.frontpage.presentation.onboarding;

import android.content.Context;
import android.graphics.Color;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingUtil;", "", "()V", "categoryColorInt", "", "Lcom/reddit/frontpage/util/kotlin/ColorInt;", "context", "Landroid/content/Context;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "isEnabled", "", "launch", "", "from", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingUtil.kt */
public final class OnboardingUtil {
    public static final OnboardingUtil f20948a = new OnboardingUtil();

    private OnboardingUtil() {
    }

    public static final boolean m23163a() {
        Object a = FrontpageSettings.a();
        if (a.s()) {
            return true;
        }
        Intrinsics.m26843a(a, "setting");
        a = a.t().experiments;
        Intrinsics.m26843a(a, "setting.appConfig.experiments");
        return a.b().active;
    }

    public static final void m23162a(Screen screen) {
        Intrinsics.m26847b(screen, "from");
        Routing.m22623a(screen, Nav.m22601m());
    }

    public static final int m23161a(Context context, SubredditCategory subredditCategory) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(subredditCategory, "category");
        subredditCategory = subredditCategory.getColor();
        if (subredditCategory != null) {
            try {
                subredditCategory = Integer.valueOf(Color.parseColor(subredditCategory));
            } catch (SubredditCategory subredditCategory2) {
                Timber.c((Throwable) subredditCategory2, "Unable to parse color for category", new Object[0]);
                subredditCategory2 = null;
            }
            if (subredditCategory2 != null) {
                return subredditCategory2.intValue();
            }
        }
        return ContextsKt.m24075a(context, C1761R.color.category_default);
    }
}
