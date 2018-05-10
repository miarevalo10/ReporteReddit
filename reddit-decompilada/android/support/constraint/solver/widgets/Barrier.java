package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import java.util.ArrayList;

public class Barrier extends Helper {
    public int f16395a = 0;
    private ArrayList<ResolutionNode> aj = new ArrayList(4);

    public final boolean mo16a() {
        return true;
    }

    public final void mo3072b() {
        super.mo3072b();
        this.aj.clear();
    }

    public final void mo17c() {
        if (this.C != null && ((ConstraintWidgetContainer) this.C).m16515g(2)) {
            ResolutionNode resolutionNode;
            int i;
            ConstraintWidget constraintWidget;
            ResolutionNode resolutionNode2;
            switch (this.f16395a) {
                case 0:
                    resolutionNode = this.r.f280a;
                    break;
                case 1:
                    resolutionNode = this.t.f280a;
                    break;
                case 2:
                    resolutionNode = this.s.f280a;
                    break;
                case 3:
                    resolutionNode = this.u.f280a;
                    break;
                default:
                    return;
            }
            resolutionNode.f358h = 5;
            if (this.f16395a != 0) {
                if (this.f16395a != 1) {
                    this.r.f280a.m136a(null, 0.0f);
                    this.t.f280a.m136a(null, 0.0f);
                    this.aj.clear();
                    for (i = 0; i < this.ai; i++) {
                        constraintWidget = this.ah[i];
                        if (constraintWidget.mo16a()) {
                            switch (this.f16395a) {
                                case 0:
                                    resolutionNode2 = constraintWidget.f340r.f280a;
                                    break;
                                case 1:
                                    resolutionNode2 = constraintWidget.f342t.f280a;
                                    break;
                                case 2:
                                    resolutionNode2 = constraintWidget.f341s.f280a;
                                    break;
                                case 3:
                                    resolutionNode2 = constraintWidget.f343u.f280a;
                                    break;
                                default:
                                    resolutionNode2 = null;
                                    break;
                            }
                            if (resolutionNode2 != null) {
                                this.aj.add(resolutionNode2);
                                resolutionNode2.m135a(resolutionNode);
                            }
                        }
                    }
                }
            }
            this.s.f280a.m136a(null, 0.0f);
            this.u.f280a.m136a(null, 0.0f);
            this.aj.clear();
            for (i = 0; i < this.ai; i++) {
                constraintWidget = this.ah[i];
                if (constraintWidget.mo16a()) {
                    switch (this.f16395a) {
                        case 0:
                            resolutionNode2 = constraintWidget.f340r.f280a;
                            break;
                        case 1:
                            resolutionNode2 = constraintWidget.f342t.f280a;
                            break;
                        case 2:
                            resolutionNode2 = constraintWidget.f341s.f280a;
                            break;
                        case 3:
                            resolutionNode2 = constraintWidget.f343u.f280a;
                            break;
                        default:
                            resolutionNode2 = null;
                            break;
                    }
                    if (resolutionNode2 != null) {
                        this.aj.add(resolutionNode2);
                        resolutionNode2.m135a(resolutionNode);
                    }
                }
            }
        }
    }

    public final void mo3073d() {
        ResolutionNode resolutionNode;
        float f = Float.MAX_VALUE;
        switch (this.f16395a) {
            case 0:
                resolutionNode = this.r.f280a;
                break;
            case 1:
                resolutionNode = this.t.f280a;
                break;
            case 2:
                resolutionNode = this.s.f280a;
                break;
            case 3:
                resolutionNode = this.u.f280a;
                break;
            default:
                return;
        }
        f = 0.0f;
        int size = this.aj.size();
        ResolutionNode resolutionNode2 = null;
        int i = 0;
        while (i < size) {
            ResolutionNode resolutionNode3 = (ResolutionNode) this.aj.get(i);
            if (resolutionNode3.f359i == 1) {
                if (this.f16395a != 0) {
                    if (this.f16395a != 2) {
                        if (resolutionNode3.f357g > f) {
                            f = resolutionNode3.f357g;
                            resolutionNode2 = resolutionNode3.f356f;
                        }
                        i++;
                    }
                }
                if (resolutionNode3.f357g < f) {
                    f = resolutionNode3.f357g;
                    resolutionNode2 = resolutionNode3.f356f;
                }
                i++;
            } else {
                return;
            }
        }
        if (LinearSystem.m53a() != null) {
            Metrics a = LinearSystem.m53a();
            a.f237w++;
        }
        resolutionNode.f356f = resolutionNode2;
        resolutionNode.f357g = f;
        resolutionNode.m133a();
        switch (this.f16395a) {
            case 0:
                this.t.f280a.m136a(resolutionNode2, f);
                return;
            case 1:
                this.r.f280a.m136a(resolutionNode2, f);
                return;
            case 2:
                this.u.f280a.m136a(resolutionNode2, f);
                return;
            case 3:
                this.s.f280a.m136a(resolutionNode2, f);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo15a(android.support.constraint.solver.LinearSystem r13) {
        /*
        r12 = this;
        r0 = r12.z;
        r1 = r12.r;
        r2 = 0;
        r0[r2] = r1;
        r0 = r12.z;
        r1 = r12.s;
        r3 = 2;
        r0[r3] = r1;
        r0 = r12.z;
        r1 = r12.t;
        r4 = 1;
        r0[r4] = r1;
        r0 = r12.z;
        r1 = r12.u;
        r5 = 3;
        r0[r5] = r1;
        r0 = r2;
    L_0x001d:
        r1 = r12.z;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0033;
    L_0x0022:
        r1 = r12.z;
        r1 = r1[r0];
        r6 = r12.z;
        r6 = r6[r0];
        r6 = r13.m62a(r6);
        r1.f288i = r6;
        r0 = r0 + 1;
        goto L_0x001d;
    L_0x0033:
        r0 = r12.f16395a;
        if (r0 < 0) goto L_0x0183;
    L_0x0037:
        r0 = r12.f16395a;
        r1 = 4;
        if (r0 >= r1) goto L_0x0183;
    L_0x003c:
        r0 = r12.z;
        r1 = r12.f16395a;
        r0 = r0[r1];
        r1 = r2;
    L_0x0043:
        r6 = r12.ai;
        if (r1 >= r6) goto L_0x0077;
    L_0x0047:
        r6 = r12.ah;
        r6 = r6[r1];
        r7 = r6.mo16a();
        if (r7 == 0) goto L_0x0074;
    L_0x0051:
        r7 = r12.f16395a;
        if (r7 == 0) goto L_0x0059;
    L_0x0055:
        r7 = r12.f16395a;
        if (r7 != r4) goto L_0x0063;
    L_0x0059:
        r7 = r6.m126u();
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r7 != r8) goto L_0x0063;
    L_0x0061:
        r1 = r4;
        goto L_0x0078;
    L_0x0063:
        r7 = r12.f16395a;
        if (r7 == r3) goto L_0x006b;
    L_0x0067:
        r7 = r12.f16395a;
        if (r7 != r5) goto L_0x0074;
    L_0x006b:
        r6 = r6.m127v();
        r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r6 != r7) goto L_0x0074;
    L_0x0073:
        goto L_0x0061;
    L_0x0074:
        r1 = r1 + 1;
        goto L_0x0043;
    L_0x0077:
        r1 = r2;
    L_0x0078:
        r6 = r12.f16395a;
        if (r6 == 0) goto L_0x008c;
    L_0x007c:
        r6 = r12.f16395a;
        if (r6 != r4) goto L_0x0081;
    L_0x0080:
        goto L_0x008c;
    L_0x0081:
        r6 = r12.f300C;
        r6 = r6.m127v();
        r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r6 != r7) goto L_0x0097;
    L_0x008b:
        goto L_0x0096;
    L_0x008c:
        r6 = r12.f300C;
        r6 = r6.m126u();
        r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r6 != r7) goto L_0x0097;
    L_0x0096:
        r1 = r2;
    L_0x0097:
        r6 = r2;
    L_0x0098:
        r7 = r12.ai;
        if (r6 >= r7) goto L_0x0105;
    L_0x009c:
        r7 = r12.ah;
        r7 = r7[r6];
        r8 = r7.mo16a();
        if (r8 == 0) goto L_0x0102;
    L_0x00a6:
        r8 = r7.f348z;
        r9 = r12.f16395a;
        r8 = r8[r9];
        r8 = r13.m62a(r8);
        r7 = r7.f348z;
        r9 = r12.f16395a;
        r7 = r7[r9];
        r7.f288i = r8;
        r7 = r12.f16395a;
        r9 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        if (r7 == 0) goto L_0x00e3;
    L_0x00be:
        r7 = r12.f16395a;
        if (r7 != r3) goto L_0x00c3;
    L_0x00c2:
        goto L_0x00e3;
    L_0x00c3:
        r7 = r0.f288i;
        r10 = r13.m72c();
        r11 = r13.m74d();
        r11.f254c = r2;
        r10.m9426a(r7, r8, r11, r2);
        if (r1 == 0) goto L_0x00df;
    L_0x00d4:
        r7 = r10.f10991d;
        r7 = r7.m46c(r11);
        r9 = r9 * r7;
        r7 = (int) r9;
        r13.m64a(r10, r7, r4);
    L_0x00df:
        r13.m63a(r10);
        goto L_0x0102;
    L_0x00e3:
        r7 = r0.f288i;
        r10 = r13.m72c();
        r11 = r13.m74d();
        r11.f254c = r2;
        r10.m9433b(r7, r8, r11, r2);
        if (r1 == 0) goto L_0x00ff;
    L_0x00f4:
        r7 = r10.f10991d;
        r7 = r7.m46c(r11);
        r9 = r9 * r7;
        r7 = (int) r9;
        r13.m64a(r10, r7, r4);
    L_0x00ff:
        r13.m63a(r10);
    L_0x0102:
        r6 = r6 + 1;
        goto L_0x0098;
    L_0x0105:
        r0 = r12.f16395a;
        r6 = 5;
        r7 = 6;
        if (r0 != 0) goto L_0x0126;
    L_0x010b:
        r0 = r12.t;
        r0 = r0.f288i;
        r3 = r12.r;
        r3 = r3.f288i;
        r13.m73c(r0, r3, r2, r7);
        if (r1 != 0) goto L_0x0182;
    L_0x0118:
        r0 = r12.r;
        r0 = r0.f288i;
        r1 = r12.C;
        r1 = r1.f342t;
        r1 = r1.f288i;
        r13.m73c(r0, r1, r2, r6);
        return;
    L_0x0126:
        r0 = r12.f16395a;
        if (r0 != r4) goto L_0x0145;
    L_0x012a:
        r0 = r12.r;
        r0 = r0.f288i;
        r3 = r12.t;
        r3 = r3.f288i;
        r13.m73c(r0, r3, r2, r7);
        if (r1 != 0) goto L_0x0182;
    L_0x0137:
        r0 = r12.r;
        r0 = r0.f288i;
        r1 = r12.C;
        r1 = r1.f340r;
        r1 = r1.f288i;
        r13.m73c(r0, r1, r2, r6);
        return;
    L_0x0145:
        r0 = r12.f16395a;
        if (r0 != r3) goto L_0x0164;
    L_0x0149:
        r0 = r12.u;
        r0 = r0.f288i;
        r3 = r12.s;
        r3 = r3.f288i;
        r13.m73c(r0, r3, r2, r7);
        if (r1 != 0) goto L_0x0182;
    L_0x0156:
        r0 = r12.s;
        r0 = r0.f288i;
        r1 = r12.C;
        r1 = r1.f343u;
        r1 = r1.f288i;
        r13.m73c(r0, r1, r2, r6);
        return;
    L_0x0164:
        r0 = r12.f16395a;
        if (r0 != r5) goto L_0x0182;
    L_0x0168:
        r0 = r12.s;
        r0 = r0.f288i;
        r3 = r12.u;
        r3 = r3.f288i;
        r13.m73c(r0, r3, r2, r7);
        if (r1 != 0) goto L_0x0182;
    L_0x0175:
        r0 = r12.s;
        r0 = r0.f288i;
        r1 = r12.C;
        r1 = r1.f341s;
        r1 = r1.f288i;
        r13.m73c(r0, r1, r2, r6);
    L_0x0182:
        return;
    L_0x0183:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Barrier.a(android.support.constraint.solver.LinearSystem):void");
    }
}
