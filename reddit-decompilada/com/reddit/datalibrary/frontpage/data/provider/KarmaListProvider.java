package com.reddit.datalibrary.frontpage.data.provider;

import com.birbit.android.jobqueue.TagConstraint;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class KarmaListProvider extends BaseOtherProvider {
    @State
    String username;

    public void finish() {
        super.finish();
        RedditJobManager.m9150a().m2522a(TagConstraint.ANY, this.providerId);
    }
}
