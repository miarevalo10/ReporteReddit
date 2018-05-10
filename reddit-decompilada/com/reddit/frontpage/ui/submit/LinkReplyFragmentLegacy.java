package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.submit.ReplyableLinkPreview;
import org.parceler.Parcels;

public class LinkReplyFragmentLegacy extends ReplyFragmentLegacy {
    public final int mo7473c() {
        return C1761R.string.title_reply_link;
    }

    protected final int mo7474d() {
        return C1761R.string.hint_link_reply;
    }

    protected final int mo7475e() {
        return C1761R.string.discard_comment;
    }

    public static LinkReplyFragmentLegacy m41092a(Link link) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("link", Parcels.m28672a((Object) link));
        link = new LinkReplyFragmentLegacy();
        link.setArguments(bundle);
        return link;
    }

    public final View mo7471a() {
        View replyableLinkPreview = new ReplyableLinkPreview(getActivity());
        replyableLinkPreview.m30529a((Link) mo7472b());
        return replyableLinkPreview;
    }

    public final Replyable mo7472b() {
        return (Replyable) Parcels.m28673a(getArguments().getParcelable("link"));
    }
}
