package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final /* synthetic */ class CommentsProvider$LoadCommentsJob$$Lambda$0 implements Runnable {
    private final LoadCommentsJob f10782a;
    private final List f10783b;
    private final int f10784c;
    private final boolean f10785d;

    CommentsProvider$LoadCommentsJob$$Lambda$0(LoadCommentsJob loadCommentsJob, List list, int i, boolean z) {
        this.f10782a = loadCommentsJob;
        this.f10783b = list;
        this.f10784c = i;
        this.f10785d = z;
    }

    public final void run() {
        LoadCommentsJob loadCommentsJob = this.f10782a;
        List list = this.f10783b;
        int i = this.f10784c;
        boolean z = this.f10785d;
        if (loadCommentsJob.f18728o.f16228a == null) {
            loadCommentsJob.f18728o.f16228a = new CollapseTree();
        } else {
            CollapseTree collapseTree = loadCommentsJob.f18728o.f16228a;
            collapseTree.a = new ConcurrentHashMap();
            collapseTree.b = new ArrayList();
        }
        ReplyableTreeNode replyableTreeNode = null;
        loadCommentsJob.f18728o.f16228a.b(null, list);
        if (loadCommentsJob.f18728o.f16231d != null) {
            CommentsPerformanceTracker.b(loadCommentsJob.f18727n);
            loadCommentsJob.f18728o.f16231d.m9129a(0, i, loadCommentsJob.f18728o.f16228a.b.size());
        }
        if (loadCommentsJob.f18728o.f16228a.b.size() > 0) {
            replyableTreeNode = loadCommentsJob.f18728o.f16228a.a(loadCommentsJob.f18728o.f16228a.b.size() - 1);
        }
        if (z && replyableTreeNode != null && CommentsProvider.m16229d(replyableTreeNode)) {
            loadCommentsJob.f18728o.m16223a(replyableTreeNode, loadCommentsJob.f18727n);
        } else {
            CommentsPerformanceTracker.f(loadCommentsJob.f18727n);
        }
    }
}
