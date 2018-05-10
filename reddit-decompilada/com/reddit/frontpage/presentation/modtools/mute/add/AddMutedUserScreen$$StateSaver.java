package com.reddit.frontpage.presentation.modtools.mute.add;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class AddMutedUserScreen$$StateSaver<T extends AddMutedUserScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, "subredditName", t.subredditName);
        HELPER.putString(bundle, "postTitle", t.postTitle);
        HELPER.putString(bundle, "subredditId", t.subredditId);
        HELPER.putString(bundle, "commentId", t.commentId);
        HELPER.putString(bundle, "postId", t.postId);
        HELPER.putString(bundle, "postType", t.postType);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.subredditName = HELPER.getString(bundle, "subredditName");
        t.postTitle = HELPER.getString(bundle, "postTitle");
        t.subredditId = HELPER.getString(bundle, "subredditId");
        t.commentId = HELPER.getString(bundle, "commentId");
        t.postId = HELPER.getString(bundle, "postId");
        t.postType = HELPER.getString(bundle, "postType");
    }
}
