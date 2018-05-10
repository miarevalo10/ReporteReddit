package com.reddit.frontpage.ui.detail.comments;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.More;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.HolderCallbacks;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.comment.CommentIndentView;

public class CommentTreeAdapter extends Adapter {
    public Link f28955a;
    public HolderCallbacks f28956b;
    final CommentAdapterCallbacks f28957c;

    public interface CommentAdapterCallbacks {
        int mo4962a();

        ReplyableTreeNode mo4963a(int i);

        void mo4964a(Comment comment);

        void mo4965a(MoreViewHolder moreViewHolder, ReplyableTreeNode replyableTreeNode);

        void mo4966a(LegacyCommentViewHolder legacyCommentViewHolder, ReplyableTreeNode replyableTreeNode);

        boolean mo4967b();
    }

    public class MoreViewHolder extends ViewHolder {
        final /* synthetic */ CommentTreeAdapter f28953a;
        @BindView
        CommentIndentView indentView;
        @BindView
        public TextView replyCount;

        public MoreViewHolder(CommentTreeAdapter commentTreeAdapter, View view) {
            this.f28953a = commentTreeAdapter;
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public class MoreViewHolder_ViewBinding implements Unbinder {
        private MoreViewHolder f28954b;

        public MoreViewHolder_ViewBinding(MoreViewHolder moreViewHolder, View view) {
            this.f28954b = moreViewHolder;
            moreViewHolder.replyCount = (TextView) Utils.b(view, C1761R.id.num_replies, "field 'replyCount'", TextView.class);
            moreViewHolder.indentView = (CommentIndentView) Utils.b(view, C1761R.id.indent_indicator, "field 'indentView'", CommentIndentView.class);
        }

        public final void m30014a() {
            MoreViewHolder moreViewHolder = this.f28954b;
            if (moreViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f28954b = null;
            moreViewHolder.replyCount = null;
            moreViewHolder.indentView = null;
        }
    }

    public CommentTreeAdapter(CommentAdapterCallbacks commentAdapterCallbacks) {
        this.f28957c = commentAdapterCallbacks;
    }

    public final void m30018a(ViewHolder viewHolder, int i) {
        viewHolder.c.clearAnimation();
        ReplyableTreeNode a = this.f28957c.mo4963a(i);
        if (this.f28957c.mo4962a() - 1 > i) {
            i = this.f28957c.mo4963a(i + 1).f21183b;
        } else {
            i = 0;
        }
        String kind = a.f21182a.getKind();
        int i2 = -1;
        int hashCode = kind.hashCode();
        if (hashCode != 3645) {
            if (hashCode == 3357525) {
                if (kind.equals(Kind.MORE)) {
                    i2 = 0;
                }
            }
        } else if (kind.equals(Kind.COMMENT)) {
            i2 = 1;
        }
        switch (i2) {
            case 0:
                MoreViewHolder moreViewHolder = (MoreViewHolder) viewHolder;
                int i3 = ((More) a.f21182a.getData()).count;
                if (i3 == 0) {
                    ViewsKt.m24109d(moreViewHolder.replyCount);
                } else {
                    moreViewHolder.replyCount.setText(moreViewHolder.replyCount.getContext().getResources().getQuantityString(C1761R.plurals.fmt_num_replies, i3, new Object[]{Integer.valueOf(i3)}));
                }
                ((CommentIndentView) moreViewHolder.c.findViewById(C1761R.id.indent_indicator)).m24213a(a.f21183b, i);
                this.f28957c.mo4965a(moreViewHolder, a);
                return;
            case 1:
                LegacyCommentViewHolder legacyCommentViewHolder = (LegacyCommentViewHolder) viewHolder;
                if (a.f21182a.getData() instanceof Comment) {
                    legacyCommentViewHolder.m34969a((Comment) a.f21182a.getData(), a.f21184c);
                    legacyCommentViewHolder.c.setPadding(0, a.f21183b == 0 ? legacyCommentViewHolder.c.getContext().getResources().getDimensionPixelOffset(C1761R.dimen.single_pad) : 0, 0, 0);
                    legacyCommentViewHolder.indentView.m24213a(a.f21183b, i);
                    legacyCommentViewHolder.f34262b = a;
                    legacyCommentViewHolder.m34973v();
                    if (this.f28956b != 0) {
                        legacyCommentViewHolder.f34269v = this.f28956b;
                    }
                    this.f28957c.mo4966a(legacyCommentViewHolder, a);
                    break;
                }
                throw new RuntimeException("This holder only accepts tree nodes that contain comments");
            default:
                break;
        }
    }

    public final long m30016a(int i) {
        return (long) this.f28957c.mo4963a(i).hashCode();
    }

    public final int m30015a() {
        return this.f28957c.mo4962a();
    }

    public final int m30019b(int i) {
        return TextUtils.equals(this.f28957c.mo4963a(i).f21182a.getKind(), Kind.COMMENT) != 0 ? 0 : 1;
    }

    public final ViewHolder m30017a(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new MoreViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.comment_expand, viewGroup, false));
        }
        viewGroup = LegacyCommentViewHolder.m34954a(viewGroup);
        viewGroup.f34264q = new CommentTreeAdapter$$Lambda$0(this);
        i = this.f28957c.mo4967b();
        viewGroup.f34267t = i;
        viewGroup.body.setHtmlLinksClickable(i);
        viewGroup.body.setOnUriClickListener(new LegacyCommentViewHolder$$Lambda$8(viewGroup));
        viewGroup.m34970a(this.f28955a);
        if (this.f28956b != 0) {
            viewGroup.f34269v = this.f28956b;
        }
        return viewGroup;
    }
}
