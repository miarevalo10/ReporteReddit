package com.reddit.frontpage.ui.detail.comments.collapsetree;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.More;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import timber.log.Timber;

public class CollapseTree implements Serializable {
    public ConcurrentHashMap<ReplyableTreeNode, List<ReplyableTreeNode>> f21185a = new ConcurrentHashMap();
    public ArrayList<ReplyableTreeNode> f21186b = new ArrayList();

    public final ReplyableTreeNode m23360a(int i) {
        return (ReplyableTreeNode) this.f21186b.get(i);
    }

    public final int m23359a(ReplyableTreeNode replyableTreeNode) {
        return this.f21186b.indexOf(replyableTreeNode);
    }

    public final void m23363a(ReplyableTreeNode replyableTreeNode, List<ReplyableTreeNode> list) {
        if (replyableTreeNode == null) {
            this.f21186b.addAll(list);
            return;
        }
        List list2 = (List) this.f21185a.putIfAbsent(replyableTreeNode, list);
        if (list2 == null) {
            this.f21186b.addAll(this.f21186b.indexOf(replyableTreeNode) + 1, list);
            replyableTreeNode.f21184c = true;
            return;
        }
        list2.addAll(list);
        if (replyableTreeNode.f21184c != null) {
            m23366c(replyableTreeNode);
            m23367d(replyableTreeNode);
        }
    }

    private void m23357a(ReplyableTreeNode replyableTreeNode, boolean z) {
        int indexOf = this.f21186b.indexOf(replyableTreeNode);
        if (indexOf != -1) {
            List list = (List) this.f21185a.remove(replyableTreeNode);
            ReplyableTreeNode b = m23364b(replyableTreeNode);
            List list2 = null;
            int i = 0;
            this.f21186b.remove(indexOf);
            if (b != null && this.f21185a.containsKey(b)) {
                list2 = (List) this.f21185a.remove(b);
                i = list2.indexOf(replyableTreeNode);
                list2.remove(i);
            }
            replyableTreeNode.f21184c = z;
            this.f21186b.add(indexOf, replyableTreeNode);
            if (list != null) {
                this.f21185a.put(replyableTreeNode, list);
            }
            if (list2 != null) {
                list2.add(i, replyableTreeNode);
                this.f21185a.put(b, list2);
            }
        }
    }

    public final int m23366c(ReplyableTreeNode replyableTreeNode) {
        m23357a(replyableTreeNode, false);
        Timber.b("CollapseTree: collapsed %s", new Object[]{replyableTreeNode.f21182a.getName()});
        if (!m23368e(replyableTreeNode)) {
            return 0;
        }
        int i = replyableTreeNode.f21183b;
        replyableTreeNode = this.f21186b.indexOf(replyableTreeNode);
        int size = this.f21186b.size();
        if (replyableTreeNode == -1) {
            return 0;
        }
        Object[] objArr;
        replyableTreeNode = this.f21186b.listIterator(replyableTreeNode);
        replyableTreeNode.next();
        while (replyableTreeNode.hasNext()) {
            ReplyableTreeNode replyableTreeNode2 = (ReplyableTreeNode) replyableTreeNode.next();
            String name = replyableTreeNode2.f21182a.getName();
            Timber.b("collapse(): next is %s", new Object[]{name});
            if (replyableTreeNode2.f21183b > i) {
                Timber.b("collapse(): %s is getting removed", new Object[]{name});
                replyableTreeNode.remove();
            } else {
                if (replyableTreeNode2.f21183b == i) {
                    Timber.b("collapse(): %s is a sibling", new Object[]{name});
                } else {
                    Timber.b("collapse(): %s is not in the same subtree", new Object[]{name});
                }
                objArr = new Object[1];
                size -= this.f21186b.size();
                objArr[0] = Integer.valueOf(size);
                Timber.b("CollapseTree: collapse size %d", objArr);
                return size;
            }
        }
        objArr = new Object[1];
        size -= this.f21186b.size();
        objArr[0] = Integer.valueOf(size);
        Timber.b("CollapseTree: collapse size %d", objArr);
        return size;
    }

    public final int m23367d(ReplyableTreeNode replyableTreeNode) {
        int size = this.f21186b.size();
        m23357a(replyableTreeNode, Kind.MORE.equals(replyableTreeNode.f21182a.getKind()) ^ true);
        Timber.b("CollapseTree: expanded %s", new Object[]{replyableTreeNode.f21182a.getName()});
        if (!m23368e(replyableTreeNode)) {
            return 0;
        }
        Collection arrayList;
        if (m23368e(replyableTreeNode)) {
            arrayList = new ArrayList((Collection) this.f21185a.get(replyableTreeNode));
            arrayList.listIterator();
            for (int i = 0; i < arrayList.size(); i++) {
                ReplyableTreeNode replyableTreeNode2 = (ReplyableTreeNode) arrayList.get(i);
                if (m23368e(replyableTreeNode2) && replyableTreeNode2.f21184c) {
                    arrayList.addAll(i + 1, (List) this.f21185a.get(replyableTreeNode2));
                }
            }
            Timber.b("CollapseTree: subtree size of %d", new Object[]{Integer.valueOf(arrayList.size())});
        } else {
            arrayList = null;
        }
        this.f21186b.addAll(this.f21186b.indexOf(replyableTreeNode) + 1, arrayList);
        return this.f21186b.size() - size;
    }

    public final boolean m23368e(ReplyableTreeNode replyableTreeNode) {
        return this.f21185a.containsKey(replyableTreeNode);
    }

    public final void m23362a(ReplyableTreeNode replyableTreeNode, ReplyableTreeNode replyableTreeNode2) {
        List list = (List) this.f21185a.get(replyableTreeNode);
        if (list == null) {
            list = new ArrayList(1);
            this.f21185a.put(replyableTreeNode, list);
        }
        list.add(replyableTreeNode2);
    }

    private void m23358c(ReplyableTreeNode replyableTreeNode, List<ReplyableTreeNode> list) {
        m23363a(replyableTreeNode, (List) list);
        for (ReplyableTreeNode replyableTreeNode2 : list) {
            Replyable replyable = (Replyable) replyableTreeNode2.f21182a.getData();
            if (replyable.getReplies() != null) {
                m23365b(replyableTreeNode2, replyable.getReplies().a().b());
                replyable.setReplies(null);
            }
        }
    }

    public final void m23365b(ReplyableTreeNode replyableTreeNode, List<ReplyableWrapper> list) {
        int i;
        List arrayList = new ArrayList();
        if (replyableTreeNode == null) {
            i = 0;
        } else {
            i = replyableTreeNode.f21183b + 1;
        }
        for (ReplyableWrapper replyableWrapper : list) {
            ReplyableTreeNode replyableTreeNode2 = new ReplyableTreeNode(replyableWrapper, i);
            if (replyableWrapper instanceof MoreWrapper) {
                if (((More) ((MoreWrapper) replyableWrapper).getData()).count > 0) {
                    replyableTreeNode2.f21184c = false;
                }
            }
            arrayList.add(replyableTreeNode2);
        }
        m23358c(replyableTreeNode, arrayList);
    }

    public final void m23361a(int i, CommentWrapper commentWrapper) {
        int i2;
        int i3 = i == 0 ? 1 : 0;
        Object obj = null;
        if (i3 == 0) {
            i--;
            obj = (ReplyableTreeNode) this.f21186b.get(i);
            i2 = obj.f21183b;
        } else {
            i2 = -1;
        }
        ReplyableTreeNode replyableTreeNode = new ReplyableTreeNode(commentWrapper, i2 + 1);
        if (i3 == 0) {
            i++;
        }
        this.f21186b.add(i, replyableTreeNode);
        if (i3 == 0) {
            i = (List) this.f21185a.remove(obj);
            if (i == null) {
                i = new ArrayList(1);
            }
            i.add(0, replyableTreeNode);
            this.f21185a.put(obj, i);
        }
    }

    public final ReplyableTreeNode m23364b(ReplyableTreeNode replyableTreeNode) {
        if (replyableTreeNode.f21183b == 0) {
            return null;
        }
        replyableTreeNode = replyableTreeNode.f21182a.a();
        for (int size = this.f21186b.size() - 1; size >= 0; size--) {
            ReplyableTreeNode replyableTreeNode2 = (ReplyableTreeNode) this.f21186b.get(size);
            if (TextUtils.equals(replyableTreeNode2.f21182a.getName(), replyableTreeNode)) {
                return replyableTreeNode2;
            }
        }
        return null;
    }

    public final int m23369f(ReplyableTreeNode replyableTreeNode) {
        int i;
        if (replyableTreeNode.f21182a instanceof CommentWrapper) {
            replyableTreeNode = replyableTreeNode.f21182a.b();
            i = 0;
            while (i < this.f21186b.size()) {
                ReplyableWrapper replyableWrapper = m23360a(i).f21182a;
                if ((replyableWrapper instanceof CommentWrapper) && TextUtils.equals(replyableTreeNode, replyableWrapper.b())) {
                    break;
                }
                i++;
            }
            i = -1;
            while (i >= 0) {
                if (m23360a(i).f21183b == null) {
                    break;
                }
                i--;
            }
        }
        i = -1;
        if (i != -1) {
            return i;
        }
        Timber.d("Could not find parent position!", new Object[0]);
        return 0;
    }
}
