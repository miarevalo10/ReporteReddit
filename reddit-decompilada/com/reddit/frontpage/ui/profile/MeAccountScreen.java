package com.reddit.frontpage.ui.profile;

import android.support.v7.widget.LinearLayoutManager;
import com.reddit.frontpage.util.ListUtil;

public class MeAccountScreen extends BaseAccountScreen {
    public String getAnalyticsScreenName() {
        return "profile_about";
    }

    public static MeAccountScreen m41054y() {
        return new MeAccountScreen();
    }

    protected final ProfileAction[] mo7460x() {
        return new ProfileAction[0];
    }

    public final boolean mo7200K() {
        if (!ListUtil.m23810a((LinearLayoutManager) m39366w().getLayoutManager())) {
            m39366w().smoothScrollToPosition(0);
        }
        return true;
    }
}
