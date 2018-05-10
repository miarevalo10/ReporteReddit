package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node implements Cloneable {
    private static final List<Node> f26995a = Collections.emptyList();
    public Node f26996d;
    public List<Node> f26997e;
    public Attributes f26998f;
    public String f26999g;
    int f27000h;

    class C26601 implements NodeVisitor {
        final /* synthetic */ String f33335a;
        final /* synthetic */ Node f33336b;

        public final void mo6333b(Node node, int i) {
        }

        public C26601(Node node, String str) {
            this.f33336b = node;
            this.f33335a = str;
        }

        public final void mo6332a(Node node, int i) {
            node.f26999g = this.f33335a;
        }
    }

    private static class OuterHtmlVisitor implements NodeVisitor {
        private Appendable f33337a;
        private OutputSettings f33338b;

        OuterHtmlVisitor(Appendable appendable, OutputSettings outputSettings) {
            this.f33337a = appendable;
            this.f33338b = outputSettings;
        }

        public final void mo6332a(Node node, int i) {
            try {
                node.mo6329a(this.f33337a, i, this.f33338b);
            } catch (Node node2) {
                throw new SerializationException(node2);
            }
        }

        public final void mo6333b(Node node, int i) {
            if (!node.mo6328a().equals("#text")) {
                try {
                    node.mo6330b(this.f33337a, i, this.f33338b);
                } catch (Node node2) {
                    throw new SerializationException(node2);
                }
            }
        }
    }

    public abstract String mo6328a();

    abstract void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException;

    abstract void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) throws IOException;

    public boolean equals(Object obj) {
        return this == obj;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo6338d();
    }

    protected Node(String str, Attributes attributes) {
        Validate.m28452a((Object) str);
        Validate.m28452a((Object) attributes);
        this.f26997e = f26995a;
        this.f26999g = str.trim();
        this.f26998f = attributes;
    }

    protected Node(String str) {
        this(str, new Attributes());
    }

    protected Node() {
        this.f26997e = f26995a;
        this.f26998f = null;
    }

    public String mo6341b(String str) {
        Validate.m28452a((Object) str);
        String b = this.f26998f.m28473b(str);
        if (b.length() > 0) {
            return b;
        }
        return str.toLowerCase().startsWith("abs:") ? mo6343d(str.substring(4)) : "";
    }

    public Attributes mo6344m() {
        return this.f26998f;
    }

    public Node mo6336b(String str, String str2) {
        this.f26998f.m28470a(str, str2);
        return this;
    }

    public boolean mo6342c(String str) {
        Validate.m28452a((Object) str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (this.f26998f.m28476d(substring) && !mo6343d(substring).equals("")) {
                return true;
            }
        }
        return this.f26998f.m28476d(str);
    }

    public String mo6343d(String str) {
        Validate.m28454a(str);
        if (mo6342c(str)) {
            return StringUtil.m28443a(this.f26999g, mo6341b(str));
        }
        return "";
    }

    public final Node m28512n() {
        return (Node) this.f26997e.get(0);
    }

    public final int m28513o() {
        return this.f26997e.size();
    }

    public Node mo6340l() {
        return this.f26996d;
    }

    public final void m28514p() {
        Validate.m28452a(this.f26996d);
        this.f26996d.mo6334a(this);
    }

    public Node mo6339d(Node node) {
        Validate.m28452a((Object) node);
        Validate.m28452a(this.f26996d);
        Node node2 = this.f26996d;
        int i = this.f27000h;
        Object[] objArr = new Node[]{node};
        Validate.m28458a(objArr);
        node2.m28515q();
        for (node = null; node >= null; node--) {
            Node node3 = objArr[0];
            node2.m28509e(node3);
            node2.f26997e.add(i, node3);
            node2.m28495a(i);
        }
        return this;
    }

    private void mo6334a(Node node) {
        Validate.m28456a(node.f26996d == this);
        int i = node.f27000h;
        this.f26997e.remove(i);
        m28495a(i);
        node.f26996d = null;
    }

    protected final void m28515q() {
        if (this.f26997e == f26995a) {
            this.f26997e = new ArrayList(4);
        }
    }

    protected final void m28509e(Node node) {
        if (node.f26996d != null) {
            node.f26996d.mo6334a(node);
        }
        if (node.f26996d != null) {
            node.f26996d.mo6334a(node);
        }
        node.f26996d = this;
    }

    private void m28495a(int i) {
        while (i < this.f26997e.size()) {
            ((Node) this.f26997e.get(i)).f27000h = i;
            i++;
        }
    }

    public final Node m28516r() {
        if (this.f26996d == null) {
            return null;
        }
        List list = this.f26996d.f26997e;
        int i = this.f27000h + 1;
        if (list.size() > i) {
            return (Node) list.get(i);
        }
        return null;
    }

    public String aU_() {
        Appendable stringBuilder = new StringBuilder(128);
        m28500a(stringBuilder);
        return stringBuilder.toString();
    }

    protected final void m28500a(Appendable appendable) {
        new NodeTraversor(new OuterHtmlVisitor(appendable, m28517s())).m28627a(this);
    }

    public String toString() {
        return aU_();
    }

    protected static void m28498c(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append("\n").append(StringUtil.m28442a(i * outputSettings.f26974e));
    }

    public Node mo6338d() {
        Node b = mo6335b(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(b);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            for (int i = 0; i < node.f26997e.size(); i++) {
                Node b2 = ((Node) node.f26997e.get(i)).mo6335b(node);
                node.f26997e.set(i, b2);
                linkedList.add(b2);
            }
        }
        return b;
    }

    private Node mo6335b(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.f26996d = node;
            if (node == null) {
                node = null;
            } else {
                node = this.f27000h;
            }
            node2.f27000h = node;
            node2.f26998f = this.f26998f != null ? this.f26998f.m28474b() : null;
            node2.f26999g = this.f26999g;
            node2.f26997e = new ArrayList(this.f26997e.size());
            for (Node add : this.f26997e) {
                node2.f26997e.add(add);
            }
            return node2;
        } catch (Node node3) {
            throw new RuntimeException(node3);
        }
    }

    final OutputSettings m28517s() {
        Node node = this;
        while (node.f26996d != null) {
            node = node.f26996d;
        }
        Document document = node instanceof Document ? (Document) node : null;
        if (document != null) {
            return document.f36228a;
        }
        return new Document("").f36228a;
    }
}
