package com.reddit.frontpage.ui.profile;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.frontpage.util.kotlin.TextViewsKt;

final /* synthetic */ class ProfilePagerScreen$$Lambda$9 implements OnClickListener {
    private final ProfilePagerScreen f21525a;

    ProfilePagerScreen$$Lambda$9(ProfilePagerScreen profilePagerScreen) {
        this.f21525a = profilePagerScreen;
    }

    public final void onClick(View view) {
        view = this.f21525a;
        if (view.profileDescription != null) {
            if (view.profileDescription.getMaxLines() == RedditJobManager.f10810d) {
                view.profileDescription.setMaxLines(3);
            } else if (TextViewsKt.m24098a(view.profileDescription)) {
                view.profileDescription.setMaxLines(RedditJobManager.f10810d);
            }
        }
    }
}
