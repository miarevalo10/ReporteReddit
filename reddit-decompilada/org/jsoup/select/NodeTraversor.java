package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor {
    private NodeVisitor f27170a;

    public NodeTraversor(NodeVisitor nodeVisitor) {
        this.f27170a = nodeVisitor;
    }

    public final void m28627a(Node node) {
        int i = 0;
        Node node2 = node;
        while (node2 != null) {
            this.f27170a.mo6332a(node2, i);
            if (node2.m28513o() > 0) {
                node2 = node2.m28512n();
                i++;
            } else {
                while (node2.m28516r() == null && i > 0) {
                    this.f27170a.mo6333b(node2, i);
                    node2 = node2.f26996d;
                    i--;
                }
                this.f27170a.mo6333b(node2, i);
                if (node2 != node) {
                    node2 = node2.m28516r();
                } else {
                    return;
                }
            }
        }
    }
}
