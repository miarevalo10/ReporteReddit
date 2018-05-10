package com.reddit.datalibrary.frontpage.data.provider;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final /* synthetic */ class CommentsProvider$LoadMoreCommentsJob$$Lambda$0 implements Runnable {
    private final LoadMoreCommentsJob f10787a;
    private final List f10788b;

    CommentsProvider$LoadMoreCommentsJob$$Lambda$0(LoadMoreCommentsJob loadMoreCommentsJob, List list) {
        this.f10787a = loadMoreCommentsJob;
        this.f10788b = list;
    }

    public final void run() {
        LoadMoreCommentsJob loadMoreCommentsJob = this.f10787a;
        List<ReplyableWrapper> list = this.f10788b;
        int a = loadMoreCommentsJob.f18732p.a(loadMoreCommentsJob.f18731o);
        if (a != -1) {
            CollapseTree collapseTree = loadMoreCommentsJob.f18732p;
            ReplyableTreeNode replyableTreeNode = loadMoreCommentsJob.f18731o;
            int size = collapseTree.b.size();
            Collection<ReplyableTreeNode> arrayList = new ArrayList(list.size());
            CharSequence a2 = replyableTreeNode.a.mo3814a();
            int i = replyableTreeNode.b;
            int i2 = 0;
            int i3 = i == 0 ? 1 : 0;
            if (i3 == 0) {
                i2 = i - 1;
            }
            ReplyableTreeNode replyableTreeNode2 = null;
            if (i3 == 0) {
                replyableTreeNode2 = collapseTree.b(replyableTreeNode);
            }
            collapseTree.a.remove(replyableTreeNode);
            for (ReplyableWrapper replyableWrapper : list) {
                CharSequence a3 = replyableWrapper.mo3814a();
                if (TextUtils.equals(a3, a2)) {
                    Object replyableTreeNode3;
                    if (i3 != 0 || replyableTreeNode2 == null) {
                        replyableTreeNode3 = new ReplyableTreeNode(replyableWrapper, i2);
                    } else {
                        replyableTreeNode3 = new ReplyableTreeNode(replyableWrapper, i2 + 1);
                        collapseTree.a(replyableTreeNode2, replyableTreeNode3);
                    }
                    arrayList.add(replyableTreeNode3);
                } else {
                    for (ReplyableTreeNode replyableTreeNode4 : arrayList) {
                        CommentsProvider$LoadMoreCommentsJob$$Lambda$0 commentsProvider$LoadMoreCommentsJob$$Lambda$0;
                        if (TextUtils.equals(replyableTreeNode4.a.getName(), a3)) {
                            ReplyableTreeNode replyableTreeNode5 = new ReplyableTreeNode(replyableWrapper, replyableTreeNode4.b + 1);
                            collapseTree.a(replyableTreeNode4, replyableTreeNode5);
                            arrayList.add(replyableTreeNode5);
                            commentsProvider$LoadMoreCommentsJob$$Lambda$0 = this;
                            break;
                        }
                        commentsProvider$LoadMoreCommentsJob$$Lambda$0 = this;
                    }
                }
            }
            if (replyableTreeNode2 != null) {
                ((List) collapseTree.a.get(replyableTreeNode2)).remove(replyableTreeNode);
            }
            int a4 = collapseTree.a(replyableTreeNode);
            collapseTree.b.remove(a4);
            collapseTree.b.addAll(a4, arrayList);
            a4 = collapseTree.b.size() - size;
            if (loadMoreCommentsJob.f18734r.f16231d != null) {
                loadMoreCommentsJob.f18734r.f16231d.m9130b(a, 1);
                CommentsPerformanceTracker.e(loadMoreCommentsJob.f18733q);
                loadMoreCommentsJob.f18734r.f16231d.m9128a(a, a4 + 1);
                CommentsPerformanceTracker.f(loadMoreCommentsJob.f18733q);
            }
        }
    }
}
