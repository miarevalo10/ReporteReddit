package com.reddit.frontpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.submit.CommentEditFragmentLegacy;
import com.reddit.frontpage.ui.submit.LinkEditFragmentLegacy;
import org.parceler.Parcels;

public class EditActivityLegacy<T extends Replyable> extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Replyable replyable = (Replyable) Parcels.m28673a(getIntent().getParcelableExtra("extra_wrapper"));
        if (replyable == null) {
            replyable = (Replyable) getIntent().getSerializableExtra("extra_wrapper");
        }
        if (bundle == null) {
            Fragment a;
            bundle = getSupportFragmentManager().a();
            if (replyable instanceof Comment) {
                a = CommentEditFragmentLegacy.m41077a((Comment) replyable);
            } else if (replyable instanceof Link) {
                a = LinkEditFragmentLegacy.m41088a((Link) replyable);
            } else {
                a = null;
            }
            bundle.a(C1761R.id.container, a, "editable").c();
        }
    }
}
