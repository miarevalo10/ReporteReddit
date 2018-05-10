package com.reddit.frontpage.ui.inbox;

import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import java.io.Serializable;
import java.util.LinkedHashSet;

public class MessageThread implements Serializable {
    public final String f21243a;
    public final LinkedHashSet<String> f21244b = new LinkedHashSet();
    public final CollapseTree f21245c = new CollapseTree();

    public MessageThread(String str) {
        this.f21243a = str;
    }
}
