package com.reddit.frontpage.ui.detail.comments;

import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.More;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import java.util.ArrayList;
import java.util.List;

public class ReplyableCollapseTreeHelper {
    private static void m23356a(CollapseTree collapseTree, List<ReplyableTreeNode> list, ReplyableTreeNode replyableTreeNode) {
        collapseTree.m23363a(replyableTreeNode, (List) list);
        for (ReplyableTreeNode replyableTreeNode2 : list) {
            Replyable replyable = (Replyable) replyableTreeNode2.f21182a.getData();
            if (replyable.getReplies() != null) {
                int i;
                List<ReplyableWrapper> b = replyable.getReplies().a().b();
                List arrayList = new ArrayList();
                if (replyableTreeNode2 == null) {
                    i = 0;
                } else {
                    i = replyableTreeNode2.f21183b + 1;
                }
                for (ReplyableWrapper replyableWrapper : b) {
                    ReplyableTreeNode replyableTreeNode3 = new ReplyableTreeNode(replyableWrapper, i);
                    if (replyableWrapper instanceof MoreWrapper) {
                        if (((More) ((MoreWrapper) replyableWrapper).getData()).count > 0) {
                            replyableTreeNode3.f21184c = false;
                        }
                    }
                    arrayList.add(replyableTreeNode3);
                }
                m23356a(collapseTree, arrayList, replyableTreeNode2);
                replyable.setReplies(null);
            }
        }
    }

    public static void m23354a(CollapseTree collapseTree, ReplyableWrapper replyableWrapper) {
        ReplyableTreeNode replyableTreeNode = new ReplyableTreeNode(replyableWrapper, 0);
        if (replyableWrapper instanceof MoreWrapper) {
            if (((More) ((MoreWrapper) replyableWrapper).getData()).count > null) {
                replyableTreeNode.f21184c = false;
            } else {
                return;
            }
        }
        replyableWrapper = new ArrayList();
        replyableWrapper.add(replyableTreeNode);
        m23356a(collapseTree, replyableWrapper, null);
    }

    public static void m23355a(CollapseTree collapseTree, List<ReplyableWrapper> list) {
        List arrayList = new ArrayList();
        for (ReplyableWrapper replyableTreeNode : list) {
            arrayList.add(new ReplyableTreeNode(replyableTreeNode, 1));
        }
        m23356a(collapseTree, arrayList, null);
    }
}
