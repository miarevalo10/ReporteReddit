package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.presentation.theme.ThemeOption;

final /* synthetic */ class BaseScreen$$Lambda$8 implements OnClickListener {
    private final BaseScreen f21065a;

    BaseScreen$$Lambda$8(BaseScreen baseScreen) {
        this.f21065a = baseScreen;
    }

    public final void onClick(View view) {
        view = this.f21065a;
        if (view.am_() != null) {
            int i;
            RedditThemedActivity redditThemedActivity = (RedditThemedActivity) view.am_();
            FrontpageSettings a = FrontpageSettings.a();
            ThemeOption c = a.c(true);
            if (c != ThemeOption.f20981c) {
                if (c != ThemeOption.f20984f) {
                    i = 0;
                    a.b(i ^ 1);
                    if (i != 0) {
                        a.b(c);
                        a.a(ThemeOption.f20981c);
                    } else if (c == redditThemedActivity.f40551f) {
                        a.a(ThemeOption.valueOf(a.a.getString("com.reddit.pref.prev_theme", ThemeOption.f20979a.name())));
                        if (a.e()) {
                            a.d(false);
                        }
                    }
                    redditThemedActivity.m41959b(true);
                }
            }
            i = 1;
            a.b(i ^ 1);
            if (i != 0) {
                a.b(c);
                a.a(ThemeOption.f20981c);
            } else if (c == redditThemedActivity.f40551f) {
                a.a(ThemeOption.valueOf(a.a.getString("com.reddit.pref.prev_theme", ThemeOption.f20979a.name())));
                if (a.e()) {
                    a.d(false);
                }
            }
            redditThemedActivity.m41959b(true);
        }
    }
}
