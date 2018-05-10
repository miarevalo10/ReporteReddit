package com.reddit.frontpage.ui.detail.comments;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import java.io.Serializable;

public class ReplyableTreeNode implements Serializable {
    public final ReplyableWrapper f21182a;
    public int f21183b;
    public boolean f21184c = true;

    public ReplyableTreeNode(ReplyableWrapper replyableWrapper, int i) {
        this.f21182a = replyableWrapper;
        this.f21183b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ReplyableTreeNode replyableTreeNode = (ReplyableTreeNode) obj;
                if (this.f21182a == null) {
                    return replyableTreeNode.f21182a == null;
                } else {
                    if (replyableTreeNode.f21182a != null) {
                        if (TextUtils.equals(this.f21182a.getName(), replyableTreeNode.f21182a.getName()) == null) {
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f21182a == null || this.f21182a.getName() == null) ? 0 : this.f21182a.getName().hashCode();
    }
}
