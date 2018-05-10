package com.instabug.library.invocation;

import com.instabug.library.invocation.p025a.C1372b.C0716d;
import com.instabug.library.invocation.p025a.C1376e;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.invocation.util.InstabugVideoRecordingButtonCorner;

/* compiled from: InvocationSettings */
public class C0731c {
    public final boolean[] f9781a = new boolean[5];
    public int f9782b = 0;
    public InstabugVideoRecordingButtonCorner f9783c = InstabugVideoRecordingButtonCorner.BOTTOM_RIGHT;
    public C0716d f9784d = new C0716d();
    int f9785e = 350;

    C0731c() {
    }

    public final void m8285a(InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
        this.f9784d.f9726a = instabugFloatingButtonEdge;
    }

    public final void m8284a(int i) {
        this.f9784d.f9727b = i;
    }

    public final void m8286b(int i) {
        if (i > 0) {
            this.f9785e = i;
            if (C1381b.m15431c().f15518c instanceof C1376e) {
                ((C1376e) C1381b.m15431c().f15518c).m15415a(i);
            }
        }
    }
}
