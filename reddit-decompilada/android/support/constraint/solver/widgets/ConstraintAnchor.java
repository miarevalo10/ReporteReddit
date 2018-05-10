package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;

public class ConstraintAnchor {
    ResolutionNode f280a = new ResolutionNode(this);
    final ConstraintWidget f281b;
    final Type f282c;
    ConstraintAnchor f283d;
    public int f284e = 0;
    int f285f = -1;
    Strength f286g = Strength.NONE;
    int f287h = 0;
    public SolverVariable f288i;
    private ConnectionType f289j = ConnectionType.RELAXED;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f281b = constraintWidget;
        this.f282c = type;
    }

    public final void m83a() {
        if (this.f288i == null) {
            this.f288i = new SolverVariable(android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED);
        } else {
            this.f288i.m81b();
        }
    }

    public final int m85b() {
        if (this.f281b.f317U == 8) {
            return 0;
        }
        if (this.f285f < 0 || this.f283d == null || this.f283d.f281b.f317U != 8) {
            return this.f284e;
        }
        return this.f285f;
    }

    public final void m86c() {
        this.f283d = null;
        this.f284e = 0;
        this.f285f = -1;
        this.f286g = Strength.STRONG;
        this.f287h = 0;
        this.f289j = ConnectionType.RELAXED;
        this.f280a.m138b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m84a(android.support.constraint.solver.widgets.ConstraintAnchor r5, int r6, int r7, android.support.constraint.solver.widgets.ConstraintAnchor.Strength r8, int r9, boolean r10) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != 0) goto L_0x0014;
    L_0x0004:
        r5 = 0;
        r4.f283d = r5;
        r4.f284e = r1;
        r5 = -1;
        r4.f285f = r5;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.NONE;
        r4.f286g = r5;
        r5 = 2;
        r4.f287h = r5;
        return r0;
    L_0x0014:
        if (r10 != 0) goto L_0x0098;
    L_0x0016:
        if (r5 != 0) goto L_0x001b;
    L_0x0018:
        r10 = r1;
        goto L_0x0095;
    L_0x001b:
        r10 = r5.f282c;
        r2 = r4.f282c;
        if (r10 != r2) goto L_0x003b;
    L_0x0021:
        r10 = r4.f282c;
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE;
        if (r10 != r2) goto L_0x0038;
    L_0x0027:
        r10 = r5.f281b;
        r10 = r10.m122q();
        if (r10 == 0) goto L_0x0018;
    L_0x002f:
        r10 = r4.f281b;
        r10 = r10.m122q();
        if (r10 != 0) goto L_0x0038;
    L_0x0037:
        goto L_0x0018;
    L_0x0038:
        r10 = r0;
        goto L_0x0095;
    L_0x003b:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.C00051.f262a;
        r3 = r4.f282c;
        r3 = r3.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0088;
            case 2: goto L_0x006f;
            case 3: goto L_0x006f;
            case 4: goto L_0x0054;
            case 5: goto L_0x0054;
            case 6: goto L_0x0018;
            case 7: goto L_0x0018;
            case 8: goto L_0x0018;
            case 9: goto L_0x0018;
            default: goto L_0x0048;
        };
    L_0x0048:
        r5 = new java.lang.AssertionError;
        r6 = r4.f282c;
        r6 = r6.name();
        r5.<init>(r6);
        throw r5;
    L_0x0054:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        if (r10 == r2) goto L_0x005f;
    L_0x0058:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        if (r10 != r2) goto L_0x005d;
    L_0x005c:
        goto L_0x005f;
    L_0x005d:
        r2 = r1;
        goto L_0x0060;
    L_0x005f:
        r2 = r0;
    L_0x0060:
        r3 = r5.f281b;
        r3 = r3 instanceof android.support.constraint.solver.widgets.Guideline;
        if (r3 == 0) goto L_0x006d;
    L_0x0066:
        if (r2 != 0) goto L_0x0038;
    L_0x0068:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y;
        if (r10 != r2) goto L_0x0018;
    L_0x006c:
        goto L_0x0038;
    L_0x006d:
        r10 = r2;
        goto L_0x0095;
    L_0x006f:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT;
        if (r10 == r2) goto L_0x007a;
    L_0x0073:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        if (r10 != r2) goto L_0x0078;
    L_0x0077:
        goto L_0x007a;
    L_0x0078:
        r2 = r1;
        goto L_0x007b;
    L_0x007a:
        r2 = r0;
    L_0x007b:
        r3 = r5.f281b;
        r3 = r3 instanceof android.support.constraint.solver.widgets.Guideline;
        if (r3 == 0) goto L_0x006d;
    L_0x0081:
        if (r2 != 0) goto L_0x0038;
    L_0x0083:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X;
        if (r10 != r2) goto L_0x0018;
    L_0x0087:
        goto L_0x0038;
    L_0x0088:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE;
        if (r10 == r2) goto L_0x0018;
    L_0x008c:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X;
        if (r10 == r2) goto L_0x0018;
    L_0x0090:
        r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y;
        if (r10 == r2) goto L_0x0018;
    L_0x0094:
        goto L_0x0038;
    L_0x0095:
        if (r10 != 0) goto L_0x0098;
    L_0x0097:
        return r1;
    L_0x0098:
        r4.f283d = r5;
        if (r6 <= 0) goto L_0x009f;
    L_0x009c:
        r4.f284e = r6;
        goto L_0x00a1;
    L_0x009f:
        r4.f284e = r1;
    L_0x00a1:
        r4.f285f = r7;
        r4.f286g = r8;
        r4.f287h = r9;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintAnchor.a(android.support.constraint.solver.widgets.ConstraintAnchor, int, int, android.support.constraint.solver.widgets.ConstraintAnchor$Strength, int, boolean):boolean");
    }

    public final boolean m87d() {
        return this.f283d != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f281b.f318V);
        stringBuilder.append(":");
        stringBuilder.append(this.f282c.toString());
        return stringBuilder.toString();
    }
}
