package com.reddit.frontpage.presentation.onboarding;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import com.reddit.frontpage.util.BundlerSetString;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public class OnboardingScreen$$StateSaver<T extends OnboardingScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.onboarding.OnboardingScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("SeenCategoryIds", new BundlerSetString());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "SelectedTab", t.selectedTab);
        HELPER.putWithBundler(bundle, "SeenCategoryIds", t.seenCategoryIds);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.selectedTab = HELPER.getInt(bundle, "SelectedTab");
        Set set = (Set) HELPER.getWithBundler(bundle, "SeenCategoryIds");
        Intrinsics.m26847b(set, "<set-?>");
        t.seenCategoryIds = set;
    }
}
