package com.reddit.frontpage.presentation.modtools.ban.add;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class AddBannedUserScreen$$StateSaver<T extends AddBannedUserScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putParcelable(bundle, "Comment", t.comment);
        HELPER.putSerializable(bundle, "Link", t.link);
        HELPER.putString(bundle, "commentId", t.commentId);
        HELPER.putString(bundle, "subredditId", t.subredditId);
        HELPER.putString(bundle, "subredditName", t.subredditName);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.comment = (Comment) HELPER.getParcelable(bundle, "Comment");
        t.link = (Link) HELPER.getSerializable(bundle, "Link");
        t.commentId = HELPER.getString(bundle, "commentId");
        t.subredditId = HELPER.getString(bundle, "subredditId");
        t.subredditName = HELPER.getString(bundle, "subredditName");
    }
}
