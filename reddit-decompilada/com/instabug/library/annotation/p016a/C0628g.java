package com.instabug.library.annotation.p016a;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"EQ_COMPARETO_USE_OBJECT_EQUALS", "UUF_UNUSED_FIELD", "URF_UNREAD_FIELD"})
/* compiled from: Weight */
public class C0628g implements Comparable<C0628g> {
    int f9512a;
    int f9513b;
    float f9514c;
    float f9515d;
    float f9516e;
    float f9517f;
    float f9518g;
    int f9519h;
    int f9520i;
    int f9521j;
    int f9522k;
    float f9523l;

    /* compiled from: Weight */
    public enum C0627a {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public /* synthetic */ int compareTo(Object obj) {
        C0628g c0628g = (C0628g) obj;
        if (c0628g.f9512a > this.f9512a) {
            return -1;
        }
        return c0628g.f9512a < this.f9512a ? 1 : null;
    }

    public final C0627a m8052a() {
        if (this.f9522k > this.f9520i) {
            return C0627a.BOTTOM;
        }
        return C0627a.TOP;
    }
}
