package com.reddit.frontpage.ui.detail;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;

final /* synthetic */ class BaseDetailScreen$$Lambda$17 implements OnClickListener {
    private final BaseDetailScreen f21142a;

    BaseDetailScreen$$Lambda$17(BaseDetailScreen baseDetailScreen) {
        this.f21142a = baseDetailScreen;
    }

    public final void onClick(View view) {
        view = this.f21142a;
        if (view.f39155H != null) {
            View findChildViewUnder = view.detailList.findChildViewUnder(0.0f, (float) (view.f39149B.getMeasuredHeight() + 1));
            if (findChildViewUnder != null) {
                ReplyableTreeNode a;
                ViewHolder findContainingViewHolder = view.detailList.findContainingViewHolder(findChildViewUnder);
                if (findContainingViewHolder == null || (findChildViewUnder instanceof DetailListHeader)) {
                    a = view.f39155H.a(0);
                } else {
                    view.f39155H.a(view.f39154G.m30148d(findContainingViewHolder));
                    int d = view.f39154G.m30148d(findContainingViewHolder);
                    CommentsProvider commentsProvider = view.f39155H;
                    if (d < 0) {
                        d = 0;
                    }
                    ReplyableTreeNode a2 = commentsProvider.a(d);
                    commentsProvider = view.f39155H;
                    for (d = commentsProvider.a.m23359a(a2) + 1; d < commentsProvider.a.f21186b.size() - 1; d++) {
                        a = commentsProvider.a.m23360a(d);
                        if (a.f21183b == 0) {
                            break;
                        }
                    }
                    a = null;
                }
                if (a != null) {
                    view.m39124a(a.f21182a.b(), true, false);
                }
            }
        }
    }
}
