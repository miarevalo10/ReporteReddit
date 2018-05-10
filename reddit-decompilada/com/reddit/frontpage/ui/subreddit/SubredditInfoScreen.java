package com.reddit.frontpage.ui.subreddit;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.profile.user.UserAccountScreen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import io.reactivex.disposables.Disposable;
import org.parceler.Parcel;

public class SubredditInfoScreen extends AbstractSubredditHtmlScreen {
    @State
    Subreddit subreddit;
    private Disposable f40184x;

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        String subredditName;

        DeepLinker() {
        }

        public Screen createScreen() {
            return UserAccountScreen.m40890a(this.subredditName, null);
        }
    }

    public static SubredditInfoScreen m41148a(Subreddit subreddit) {
        SubredditInfoScreen subredditInfoScreen = new SubredditInfoScreen();
        subredditInfoScreen.subreddit = subreddit;
        return subredditInfoScreen;
    }

    public static DeepLinker m41149b(String str) {
        DeepLinker deepLinker = new DeepLinker();
        deepLinker.subredditName = str;
        return deepLinker;
    }

    protected final void mo7142t() {
        super.mo7142t();
        if (this.subreddit != null) {
            this.subredditName = this.subreddit.getDisplayName();
        }
    }

    public final void m41151a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_subreddit_info, menu);
    }

    public final void m41150a(Menu menu) {
        super.a(menu);
        if (this.subreddit != null) {
            menu.findItem(C1761R.id.action_view_wiki).setVisible(Boolean.TRUE.equals(this.subreddit.getWikiEnabled()));
        }
        menu.findItem(C1761R.id.action_contact_moderators).setVisible(SessionManager.b().c.isAnonymous() ^ 1);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1761R.id.action_contact_moderators) {
            Routing.m22623a((Screen) this, Nav.m22591i(this.subredditName));
            return true;
        } else if (itemId != C1761R.id.action_view_wiki) {
            return super.mo7201a(menuItem);
        } else {
            StringBuilder stringBuilder = new StringBuilder("https://reddit.com/r/");
            stringBuilder.append(this.subredditName);
            stringBuilder.append("/wiki");
            a(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString())));
            return true;
        }
    }

    public final boolean mo7488w() {
        return this.subreddit != null;
    }

    public final void mo7489x() {
        if (this.subreddit == null && this.subredditName != null) {
            this.f40184x = FrontpageApplication.m28875k().mo4635w().m22493a(this.subredditName).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new SubredditInfoScreen$$Lambda$0(this));
        }
    }

    final /* synthetic */ void m41153b(Subreddit subreddit) throws Exception {
        this.subreddit = subreddit;
        mo7490y();
    }

    public final void mo7490y() {
        m39611a(this.subreddit.getDescriptionHtml());
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        if (this.f40184x != null && this.f40184x.mo5627b() == null) {
            this.f40184x.mo5626a();
        }
    }
}
