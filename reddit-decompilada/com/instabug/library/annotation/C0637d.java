package com.instabug.library.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* compiled from: MarkUpStack */
public class C0637d {
    List<C0636c> f9550a = new ArrayList();
    List<C0636c> f9551b = new ArrayList();
    List<C0636c> f9552c = new ArrayList();
    Stack<C0636c> f9553d = new Stack();

    public final void m8098a(C0636c c0636c) {
        this.f9551b.add(c0636c);
        m8095b();
        this.f9553d.add(c0636c);
    }

    public final void m8099b(C0636c c0636c) {
        this.f9552c.add(c0636c);
        m8095b();
        this.f9553d.add(c0636c);
    }

    private void m8095b() {
        this.f9550a.clear();
        this.f9550a.addAll(this.f9552c);
        this.f9550a.addAll(this.f9551b);
    }

    public final C0636c m8097a(int i) {
        return (C0636c) this.f9550a.get(i);
    }

    public final int m8096a() {
        return this.f9550a.size();
    }

    public final void m8100c(C0636c c0636c) {
        this.f9553d.push(c0636c);
    }
}
