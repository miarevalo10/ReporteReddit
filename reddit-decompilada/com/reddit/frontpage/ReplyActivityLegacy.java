package com.reddit.frontpage;

import android.os.Bundle;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.submit.CommentReplyFragment;
import com.reddit.frontpage.ui.submit.LinkReplyFragmentLegacy;
import com.reddit.frontpage.ui.submit.MessageReplyFragment;
import com.reddit.frontpage.ui.submit.ReplyFragmentLegacy;
import org.parceler.Parcels;

public class ReplyActivityLegacy<T extends Replyable> extends BaseActivity {
    private T f40825d;

    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        this.f40825d = (Replyable) bundle.getSerializableExtra("wrapper");
        if (this.f40825d == null) {
            this.f40825d = (Replyable) Parcels.m28673a(bundle.getParcelableExtra("wrapper"));
        }
        if (m42718f() == null) {
            if ((this.f40825d instanceof Comment) != null) {
                bundle = CommentReplyFragment.m41082a((Comment) this.f40825d);
            } else if ((this.f40825d instanceof Message) != null) {
                bundle = MessageReplyFragment.m41132a((Message) this.f40825d);
            } else if ((this.f40825d instanceof Link) != null) {
                bundle = LinkReplyFragmentLegacy.m41092a((Link) this.f40825d);
            } else {
                StringBuilder stringBuilder = new StringBuilder("Couldn't make a reply fragment for replyable: ");
                stringBuilder.append(this.f40825d);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            getSupportFragmentManager().a().a(C1761R.id.container, bundle, "reply").e();
        }
    }

    private ReplyFragmentLegacy m42718f() {
        return (ReplyFragmentLegacy) getSupportFragmentManager().a("reply");
    }

    public void onBackPressed() {
        ReplyFragmentLegacy f = m42718f();
        if (f == null || !f.mo7172k()) {
            super.onBackPressed();
        }
    }
}
