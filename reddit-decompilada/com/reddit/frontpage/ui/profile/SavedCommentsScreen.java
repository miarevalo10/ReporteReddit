package com.reddit.frontpage.ui.profile;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.internal.Utils;
import com.reddit.datalibrary.frontpage.data.provider.SavedCommentsProvider;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder_ViewBinding;
import com.reddit.frontpage.util.Util;

public class SavedCommentsScreen extends SavedListingScreen {

    private class SavedCommentsAdapter extends Adapter<SavedCommentViewHolder> {
        final /* synthetic */ SavedCommentsScreen f29234a;

        private SavedCommentsAdapter(SavedCommentsScreen savedCommentsScreen) {
            this.f29234a = savedCommentsScreen;
        }

        public final /* synthetic */ void m30339a(ViewHolder viewHolder, int i) {
            ((SavedCommentViewHolder) viewHolder).m34968a((Comment) ((ThingWrapper) this.f29234a.w.a(i)).getData());
        }

        public final int m30337a() {
            return this.f29234a.w.c();
        }

        public final /* synthetic */ ViewHolder m30338a(ViewGroup viewGroup, int i) {
            i = SavedCommentViewHolder.m37750b(viewGroup);
            i.m34970a(null);
            i.c.setBackgroundColor(ResourcesUtil.m22740i(viewGroup.getContext(), C1761R.attr.rdt_body_color));
            i.c.setOnClickListener(new SavedCommentsScreen$SavedCommentsAdapter$$Lambda$0(this, i));
            i.f34265r = new SavedCommentsScreen$SavedCommentsAdapter$$Lambda$1(this);
            i.f34264q = new SavedCommentsScreen$SavedCommentsAdapter$$Lambda$2(this);
            return i;
        }
    }

    public class SavedCommentViewHolder_ViewBinding extends LegacyCommentViewHolder_ViewBinding {
        private SavedCommentViewHolder f34410b;

        public SavedCommentViewHolder_ViewBinding(SavedCommentViewHolder savedCommentViewHolder, View view) {
            super(savedCommentViewHolder, view);
            this.f34410b = savedCommentViewHolder;
            savedCommentViewHolder.linkTitle = (TextView) Utils.b(view, C1761R.id.link_title, "field 'linkTitle'", TextView.class);
        }

        public final void mo6521a() {
            SavedCommentViewHolder savedCommentViewHolder = this.f34410b;
            if (savedCommentViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f34410b = null;
            savedCommentViewHolder.linkTitle = null;
            super.mo6521a();
        }
    }

    static class SavedCommentViewHolder extends LegacyCommentViewHolder {
        @BindView
        TextView linkTitle;

        private SavedCommentViewHolder(View view) {
            super(view);
        }

        public static SavedCommentViewHolder m37750b(ViewGroup viewGroup) {
            return new SavedCommentViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.comment_with_link_title, viewGroup, false));
        }

        protected final void mo7007a(Session session) {
            super.mo7007a(session);
            session = new StringBuilder(this.author.getText());
            session.append(this.a.subreddit_name_prefixed);
            session.append(Util.m24027f((int) C1761R.string.unicode_delimiter));
            this.author.setText(session.toString());
            this.linkTitle.setText(this.a.link_title);
        }
    }

    public String getAnalyticsScreenName() {
        return "profile_saved_comments";
    }

    public final /* bridge */ /* synthetic */ void mo7461O() {
        super.mo7461O();
    }

    public final /* bridge */ /* synthetic */ void mo7462P() {
        super.mo7462P();
    }

    public final /* bridge */ /* synthetic */ View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return super.mo7139a(layoutInflater, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int mo7141s() {
        return super.mo7141s();
    }

    public final /* bridge */ /* synthetic */ void mo7466y() {
        super.mo7466y();
    }

    public static SavedCommentsScreen m41057w() {
        SavedCommentsScreen savedCommentsScreen = new SavedCommentsScreen();
        savedCommentsScreen.isCompact = false;
        return savedCommentsScreen;
    }

    protected final void mo7144v() {
        this.w = new SavedCommentsProvider();
        m37523a(this.w);
    }

    protected final Adapter mo7465x() {
        return new SavedCommentsAdapter();
    }
}
