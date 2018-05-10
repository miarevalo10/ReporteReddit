package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Optimizer {
    static boolean[] f350a = new boolean[3];

    static void m130a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.B[0] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.f299B[0] == DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.f340r.f284e;
            int i2 = constraintWidgetContainer.m114i() - constraintWidget.f342t.f284e;
            constraintWidget.f340r.f288i = linearSystem.m62a(constraintWidget.f340r);
            constraintWidget.f342t.f288i = linearSystem.m62a(constraintWidget.f342t);
            linearSystem.m66a(constraintWidget.f340r.f288i, i);
            linearSystem.m66a(constraintWidget.f342t.f288i, i2);
            constraintWidget.f324b = 2;
            constraintWidget.m104c(i, i2);
        }
        if (constraintWidgetContainer.B[1] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.f299B[1] == DimensionBehaviour.MATCH_PARENT) {
            i = constraintWidget.f341s.f284e;
            constraintWidgetContainer = constraintWidgetContainer.m115j() - constraintWidget.f343u.f284e;
            constraintWidget.f341s.f288i = linearSystem.m62a(constraintWidget.f341s);
            constraintWidget.f343u.f288i = linearSystem.m62a(constraintWidget.f343u);
            linearSystem.m66a(constraintWidget.f341s.f288i, i);
            linearSystem.m66a(constraintWidget.f343u.f288i, constraintWidgetContainer);
            if (constraintWidget.f309L > 0 || constraintWidget.f317U == 8) {
                constraintWidget.f344v.f288i = linearSystem.m62a(constraintWidget.f344v);
                linearSystem.m66a(constraintWidget.f344v.f288i, constraintWidget.f309L + i);
            }
            constraintWidget.f325c = 2;
            constraintWidget.m107d(i, constraintWidgetContainer);
        }
    }

    private static boolean m131a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.f299B[i] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        int i2 = 1;
        if (constraintWidget.f303F != 0.0f) {
            constraintWidget = constraintWidget.f299B;
            if (i != 0) {
                i2 = 0;
            }
            return constraintWidget[i2] == DimensionBehaviour.MATCH_CONSTRAINT ? false : false;
        } else {
            if (i != 0) {
                if (constraintWidget.f327e == 0 && constraintWidget.f331i == 0) {
                    if (constraintWidget.f332j != null) {
                    }
                }
                return false;
            } else if (constraintWidget.f326d == 0 && constraintWidget.f328f == 0 && constraintWidget.f329g == null) {
                return true;
            } else {
                return false;
            }
            return true;
        }
    }

    static void m129a(ConstraintWidget constraintWidget) {
        constraintWidget.m110f();
        ResolutionNode resolutionNode = constraintWidget.f340r.f280a;
        ResolutionNode resolutionNode2 = constraintWidget.f341s.f280a;
        ResolutionNode resolutionNode3 = constraintWidget.f342t.f280a;
        ResolutionNode resolutionNode4 = constraintWidget.f343u.f280a;
        if (!(resolutionNode.f358h == 4 || resolutionNode3.f358h == 4)) {
            if (constraintWidget.f299B[0] == DimensionBehaviour.FIXED) {
                if (constraintWidget.f340r.f283d == null && constraintWidget.f342t.f283d == null) {
                    resolutionNode.f358h = 1;
                    resolutionNode3.f358h = 1;
                    resolutionNode3.m140b(resolutionNode, constraintWidget.m114i());
                } else if (constraintWidget.f340r.f283d != null && constraintWidget.f342t.f283d == null) {
                    resolutionNode.f358h = 1;
                    resolutionNode3.f358h = 1;
                    resolutionNode3.m140b(resolutionNode, constraintWidget.m114i());
                } else if (constraintWidget.f340r.f283d == null && constraintWidget.f342t.f283d != null) {
                    resolutionNode.f358h = 1;
                    resolutionNode3.f358h = 1;
                    resolutionNode.m140b(resolutionNode3, -constraintWidget.m114i());
                } else if (!(constraintWidget.f340r.f283d == null || constraintWidget.f342t.f283d == null)) {
                    resolutionNode.f358h = 2;
                    resolutionNode3.f358h = 2;
                    resolutionNode.m139b(resolutionNode3, (float) (-constraintWidget.m114i()));
                    resolutionNode3.m139b(resolutionNode, (float) constraintWidget.m114i());
                }
            } else if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT && m131a(constraintWidget, 0)) {
                int i = constraintWidget.m114i();
                if (constraintWidget.f303F != 0.0f) {
                    i = (int) (((float) constraintWidget.m115j()) * constraintWidget.f303F);
                }
                resolutionNode.f358h = 1;
                resolutionNode3.f358h = 1;
                if (constraintWidget.f340r.f283d == null && constraintWidget.f342t.f283d == null) {
                    resolutionNode3.m140b(resolutionNode, i);
                } else if (constraintWidget.f340r.f283d != null && constraintWidget.f342t.f283d == null) {
                    resolutionNode3.m140b(resolutionNode, i);
                } else if (constraintWidget.f340r.f283d == null && constraintWidget.f342t.f283d != null) {
                    resolutionNode.m140b(resolutionNode3, -i);
                } else if (!(constraintWidget.f340r.f283d == null || constraintWidget.f342t.f283d == null)) {
                    if (constraintWidget.f303F == 0.0f) {
                        resolutionNode.f358h = 3;
                        resolutionNode3.f358h = 3;
                        resolutionNode.m139b(resolutionNode3, 0.0f);
                        resolutionNode3.m139b(resolutionNode, 0.0f);
                    } else {
                        resolutionNode.f358h = 2;
                        resolutionNode3.f358h = 2;
                        resolutionNode.m139b(resolutionNode3, (float) (-i));
                        resolutionNode3.m139b(resolutionNode, (float) i);
                        constraintWidget.m103c(i);
                    }
                }
            }
        }
        if (!(resolutionNode2.f358h == 4 || resolutionNode4.f358h == 4)) {
            if (constraintWidget.f299B[1] == DimensionBehaviour.FIXED) {
                if (constraintWidget.f341s.f283d == null && constraintWidget.f343u.f283d == null) {
                    resolutionNode2.f358h = 1;
                    resolutionNode4.f358h = 1;
                    resolutionNode4.m140b(resolutionNode2, constraintWidget.m115j());
                    if (constraintWidget.f344v.f283d != null) {
                        constraintWidget.f344v.f280a.f358h = 1;
                        resolutionNode2.m137a(constraintWidget.f344v.f280a, -constraintWidget.f309L);
                    }
                } else if (constraintWidget.f341s.f283d != null && constraintWidget.f343u.f283d == null) {
                    resolutionNode2.f358h = 1;
                    resolutionNode4.f358h = 1;
                    resolutionNode4.m140b(resolutionNode2, constraintWidget.m115j());
                    if (constraintWidget.f309L > 0) {
                        constraintWidget.f344v.f280a.m137a(resolutionNode2, constraintWidget.f309L);
                    }
                } else if (constraintWidget.f341s.f283d == null && constraintWidget.f343u.f283d != null) {
                    resolutionNode2.f358h = 1;
                    resolutionNode4.f358h = 1;
                    resolutionNode2.m140b(resolutionNode4, -constraintWidget.m115j());
                    if (constraintWidget.f309L > 0) {
                        constraintWidget.f344v.f280a.m137a(resolutionNode2, constraintWidget.f309L);
                    }
                } else if (!(constraintWidget.f341s.f283d == null || constraintWidget.f343u.f283d == null)) {
                    resolutionNode2.f358h = 2;
                    resolutionNode4.f358h = 2;
                    resolutionNode2.m139b(resolutionNode4, (float) (-constraintWidget.m115j()));
                    resolutionNode4.m139b(resolutionNode2, (float) constraintWidget.m115j());
                    if (constraintWidget.f309L > 0) {
                        constraintWidget.f344v.f280a.m137a(resolutionNode2, constraintWidget.f309L);
                    }
                }
            } else if (constraintWidget.f299B[1] == DimensionBehaviour.MATCH_CONSTRAINT && m131a(constraintWidget, 1)) {
                int j = constraintWidget.m115j();
                if (constraintWidget.f303F != 0.0f) {
                    j = (int) (((float) constraintWidget.m114i()) * constraintWidget.f303F);
                }
                resolutionNode2.f358h = 1;
                resolutionNode4.f358h = 1;
                if (constraintWidget.f341s.f283d == null && constraintWidget.f343u.f283d == null) {
                    resolutionNode4.m140b(resolutionNode2, j);
                } else if (constraintWidget.f341s.f283d != null && constraintWidget.f343u.f283d == null) {
                    resolutionNode4.m140b(resolutionNode2, j);
                } else if (constraintWidget.f341s.f283d == null && constraintWidget.f343u.f283d != null) {
                    resolutionNode2.m140b(resolutionNode4, -j);
                } else if (!(constraintWidget.f341s.f283d == null || constraintWidget.f343u.f283d == null)) {
                    if (constraintWidget.f303F == 0.0f) {
                        resolutionNode2.f358h = 3;
                        resolutionNode4.f358h = 3;
                        resolutionNode2.m139b(resolutionNode4, 0.0f);
                        resolutionNode4.m139b(resolutionNode2, 0.0f);
                        return;
                    }
                    resolutionNode2.f358h = 2;
                    resolutionNode4.f358h = 2;
                    resolutionNode2.m139b(resolutionNode4, (float) (-j));
                    resolutionNode4.m139b(resolutionNode2, (float) j);
                    constraintWidget.m106d(j);
                    if (constraintWidget.f309L > 0) {
                        constraintWidget.f344v.f280a.m137a(resolutionNode2, constraintWidget.f309L);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m132a(android.support.constraint.solver.widgets.ConstraintWidgetContainer r21, android.support.constraint.solver.LinearSystem r22, int r23, int r24, android.support.constraint.solver.widgets.ConstraintWidget r25) {
        /*
        r0 = r22;
        r1 = r25;
        r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r2 = 0;
        r4 = 1;
        if (r23 != 0) goto L_0x0039;
    L_0x000a:
        r5 = r21;
        r5 = r5.f16396a;
        if (r5 == 0) goto L_0x0039;
    L_0x0010:
        r6 = r1;
        r5 = 0;
    L_0x0012:
        if (r5 != 0) goto L_0x003a;
    L_0x0014:
        r7 = r6.f348z;
        r8 = r24 + 1;
        r7 = r7[r8];
        r7 = r7.f283d;
        if (r7 == 0) goto L_0x0032;
    L_0x001e:
        r7 = r7.f281b;
        r8 = r7.f348z;
        r8 = r8[r24];
        r8 = r8.f283d;
        if (r8 == 0) goto L_0x0032;
    L_0x0028:
        r8 = r7.f348z;
        r8 = r8[r24];
        r8 = r8.f283d;
        r8 = r8.f281b;
        if (r8 == r6) goto L_0x0033;
    L_0x0032:
        r7 = r2;
    L_0x0033:
        if (r7 == 0) goto L_0x0037;
    L_0x0035:
        r6 = r7;
        goto L_0x0012;
    L_0x0037:
        r5 = r4;
        goto L_0x0012;
    L_0x0039:
        r6 = r1;
    L_0x003a:
        r5 = 2;
        if (r23 != 0) goto L_0x0053;
    L_0x003d:
        r7 = r6.f321Y;
        if (r7 != 0) goto L_0x0043;
    L_0x0041:
        r7 = r4;
        goto L_0x0044;
    L_0x0043:
        r7 = 0;
    L_0x0044:
        r8 = r6.f321Y;
        if (r8 != r4) goto L_0x004a;
    L_0x0048:
        r8 = r4;
        goto L_0x004b;
    L_0x004a:
        r8 = 0;
    L_0x004b:
        r6 = r6.f321Y;
        if (r6 != r5) goto L_0x0051;
    L_0x004f:
        r5 = r4;
        goto L_0x0066;
    L_0x0051:
        r5 = 0;
        goto L_0x0066;
    L_0x0053:
        r7 = r6.f322Z;
        if (r7 != 0) goto L_0x0059;
    L_0x0057:
        r7 = r4;
        goto L_0x005a;
    L_0x0059:
        r7 = 0;
    L_0x005a:
        r8 = r6.f322Z;
        if (r8 != r4) goto L_0x0060;
    L_0x005e:
        r8 = r4;
        goto L_0x0061;
    L_0x0060:
        r8 = 0;
    L_0x0061:
        r6 = r6.f322Z;
        if (r6 != r5) goto L_0x0051;
    L_0x0065:
        goto L_0x004f;
    L_0x0066:
        r10 = r1;
        r4 = r2;
        r11 = r4;
        r12 = r11;
        r17 = r12;
        r6 = 0;
        r9 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r16 = 0;
    L_0x0073:
        if (r9 != 0) goto L_0x0130;
    L_0x0075:
        r3 = r10.ae;
        r3[r23] = r2;
        r3 = r10.f317U;
        r2 = 8;
        if (r3 == r2) goto L_0x00bc;
    L_0x007f:
        if (r11 == 0) goto L_0x0085;
    L_0x0081:
        r3 = r11.ae;
        r3[r23] = r10;
    L_0x0085:
        if (r12 != 0) goto L_0x0088;
    L_0x0087:
        r12 = r10;
    L_0x0088:
        r13 = r13 + 1;
        if (r23 != 0) goto L_0x0093;
    L_0x008c:
        r3 = r10.m114i();
        r3 = (float) r3;
        r14 = r14 + r3;
        goto L_0x0099;
    L_0x0093:
        r3 = r10.m115j();
        r3 = (float) r3;
        r14 = r14 + r3;
    L_0x0099:
        if (r10 == r12) goto L_0x00a5;
    L_0x009b:
        r3 = r10.f348z;
        r3 = r3[r24];
        r3 = r3.m85b();
        r3 = (float) r3;
        r14 = r14 + r3;
    L_0x00a5:
        r3 = r10.f348z;
        r3 = r3[r24];
        r3 = r3.m85b();
        r3 = (float) r3;
        r15 = r15 + r3;
        r3 = r10.f348z;
        r11 = r24 + 1;
        r3 = r3[r11];
        r3 = r3.m85b();
        r3 = (float) r3;
        r15 = r15 + r3;
        r11 = r10;
    L_0x00bc:
        r3 = r10.ad;
        r18 = 0;
        r3[r23] = r18;
        r3 = r10.f317U;
        if (r3 == r2) goto L_0x0104;
    L_0x00c6:
        r2 = r10.f299B;
        r2 = r2[r23];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r2 != r3) goto L_0x0104;
    L_0x00ce:
        r6 = r6 + 1;
        if (r23 != 0) goto L_0x00e2;
    L_0x00d2:
        r2 = r10.f326d;
        if (r2 == 0) goto L_0x00d8;
    L_0x00d6:
        r2 = 0;
        return r2;
    L_0x00d8:
        r2 = 0;
        r3 = r10.f328f;
        if (r3 != 0) goto L_0x00e1;
    L_0x00dd:
        r3 = r10.f329g;
        if (r3 == 0) goto L_0x00f1;
    L_0x00e1:
        return r2;
    L_0x00e2:
        r2 = 0;
        r3 = r10.f327e;
        if (r3 == 0) goto L_0x00e8;
    L_0x00e7:
        return r2;
    L_0x00e8:
        r2 = r10.f331i;
        if (r2 != 0) goto L_0x0102;
    L_0x00ec:
        r2 = r10.f332j;
        if (r2 == 0) goto L_0x00f1;
    L_0x00f0:
        goto L_0x0102;
    L_0x00f1:
        r2 = r10.ac;
        r2 = r2[r23];
        r16 = r16 + r2;
        if (r17 != 0) goto L_0x00fc;
    L_0x00f9:
        r17 = r10;
        goto L_0x0100;
    L_0x00fc:
        r2 = r4.ad;
        r2[r23] = r10;
    L_0x0100:
        r4 = r10;
        goto L_0x0104;
    L_0x0102:
        r0 = 0;
        return r0;
    L_0x0104:
        r2 = r10.f348z;
        r3 = r24 + 1;
        r2 = r2[r3];
        r2 = r2.f283d;
        if (r2 == 0) goto L_0x0122;
    L_0x010e:
        r2 = r2.f281b;
        r3 = r2.f348z;
        r3 = r3[r24];
        r3 = r3.f283d;
        if (r3 == 0) goto L_0x0122;
    L_0x0118:
        r3 = r2.f348z;
        r3 = r3[r24];
        r3 = r3.f283d;
        r3 = r3.f281b;
        if (r3 == r10) goto L_0x0124;
    L_0x0122:
        r2 = r18;
    L_0x0124:
        if (r2 == 0) goto L_0x012b;
    L_0x0126:
        r10 = r2;
        r2 = r18;
        goto L_0x0073;
    L_0x012b:
        r2 = r18;
        r9 = 1;
        goto L_0x0073;
    L_0x0130:
        r2 = r1.f348z;
        r2 = r2[r24];
        r2 = r2.f280a;
        r3 = r10.f348z;
        r4 = r24 + 1;
        r3 = r3[r4];
        r3 = r3.f280a;
        r9 = r2.f353c;
        if (r9 == 0) goto L_0x0366;
    L_0x0142:
        r9 = r3.f353c;
        if (r9 != 0) goto L_0x0148;
    L_0x0146:
        goto L_0x0366;
    L_0x0148:
        r9 = r2.f353c;
        r9 = r9.f359i;
        r1 = 1;
        if (r9 == r1) goto L_0x0157;
    L_0x014f:
        r9 = r3.f353c;
        r9 = r9.f359i;
        if (r9 == r1) goto L_0x0157;
    L_0x0155:
        r1 = 0;
        return r1;
    L_0x0157:
        r1 = 0;
        if (r6 <= 0) goto L_0x015d;
    L_0x015a:
        if (r6 == r13) goto L_0x015d;
    L_0x015c:
        return r1;
    L_0x015d:
        if (r5 != 0) goto L_0x0166;
    L_0x015f:
        if (r7 != 0) goto L_0x0166;
    L_0x0161:
        if (r8 == 0) goto L_0x0164;
    L_0x0163:
        goto L_0x0166;
    L_0x0164:
        r1 = 0;
        goto L_0x017f;
    L_0x0166:
        if (r12 == 0) goto L_0x0172;
    L_0x0168:
        r1 = r12.f348z;
        r1 = r1[r24];
        r1 = r1.m85b();
        r1 = (float) r1;
        goto L_0x0173;
    L_0x0172:
        r1 = 0;
    L_0x0173:
        if (r11 == 0) goto L_0x017f;
    L_0x0175:
        r9 = r11.f348z;
        r9 = r9[r4];
        r9 = r9.m85b();
        r9 = (float) r9;
        r1 = r1 + r9;
    L_0x017f:
        r9 = r2.f353c;
        r9 = r9.f357g;
        r3 = r3.f353c;
        r3 = r3.f357g;
        r17 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r17 >= 0) goto L_0x018e;
    L_0x018b:
        r3 = r3 - r9;
        r3 = r3 - r14;
        goto L_0x0191;
    L_0x018e:
        r3 = r9 - r3;
        r3 = r3 - r14;
    L_0x0191:
        r19 = 1;
        if (r6 <= 0) goto L_0x0242;
    L_0x0195:
        if (r6 != r13) goto L_0x0242;
    L_0x0197:
        r5 = r10.f300C;
        if (r5 == 0) goto L_0x01a7;
    L_0x019b:
        r5 = r10.f300C;
        r5 = r5.f299B;
        r5 = r5[r23];
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r5 != r8) goto L_0x01a7;
    L_0x01a5:
        r5 = 0;
        return r5;
    L_0x01a7:
        r3 = r3 + r14;
        r3 = r3 - r15;
        if (r7 == 0) goto L_0x01ad;
    L_0x01ab:
        r15 = r15 - r1;
        r3 = r3 - r15;
    L_0x01ad:
        if (r7 == 0) goto L_0x01c9;
    L_0x01af:
        r1 = r12.f348z;
        r1 = r1[r4];
        r1 = r1.m85b();
        r1 = (float) r1;
        r9 = r9 + r1;
        r1 = r12.ae;
        r1 = r1[r23];
        if (r1 == 0) goto L_0x01c9;
    L_0x01bf:
        r1 = r1.f348z;
        r1 = r1[r24];
        r1 = r1.m85b();
        r1 = (float) r1;
        r9 = r9 + r1;
    L_0x01c9:
        if (r12 == 0) goto L_0x0240;
    L_0x01cb:
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        if (r1 == 0) goto L_0x01e7;
    L_0x01cf:
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r7 = r1.f239y;
        r7 = r7 - r19;
        r1.f239y = r7;
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r7 = r1.f230p;
        r7 = r7 + r19;
        r1.f230p = r7;
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r7 = r1.f236v;
        r7 = r7 + r19;
        r1.f236v = r7;
    L_0x01e7:
        r1 = r12.ae;
        r1 = r1[r23];
        if (r1 != 0) goto L_0x01f2;
    L_0x01ed:
        if (r12 != r11) goto L_0x01f0;
    L_0x01ef:
        goto L_0x01f2;
    L_0x01f0:
        r7 = 0;
        goto L_0x023e;
    L_0x01f2:
        r5 = (float) r6;
        r5 = r3 / r5;
        r7 = 0;
        r8 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1));
        if (r8 <= 0) goto L_0x0201;
    L_0x01fa:
        r5 = r12.ac;
        r5 = r5[r23];
        r5 = r5 * r3;
        r5 = r5 / r16;
    L_0x0201:
        r8 = r12.f348z;
        r8 = r8[r24];
        r8 = r8.m85b();
        r8 = (float) r8;
        r9 = r9 + r8;
        r8 = r12.f348z;
        r8 = r8[r24];
        r8 = r8.f280a;
        r10 = r2.f356f;
        r8.m136a(r10, r9);
        r8 = r12.f348z;
        r8 = r8[r4];
        r8 = r8.f280a;
        r10 = r2.f356f;
        r9 = r9 + r5;
        r8.m136a(r10, r9);
        r5 = r12.f348z;
        r5 = r5[r24];
        r5 = r5.f280a;
        r5.m134a(r0);
        r5 = r12.f348z;
        r5 = r5[r4];
        r5 = r5.f280a;
        r5.m134a(r0);
        r5 = r12.f348z;
        r5 = r5[r4];
        r5 = r5.m85b();
        r5 = (float) r5;
        r9 = r9 + r5;
    L_0x023e:
        r12 = r1;
        goto L_0x01c9;
    L_0x0240:
        r1 = 1;
        return r1;
    L_0x0242:
        r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1));
        if (r6 >= 0) goto L_0x0248;
    L_0x0246:
        r6 = 0;
        return r6;
    L_0x0248:
        if (r5 == 0) goto L_0x02c6;
    L_0x024a:
        r3 = r3 - r1;
        r1 = r25;
        r1 = r1.f314R;
        r3 = r3 * r1;
        r9 = r9 + r3;
    L_0x0251:
        if (r12 == 0) goto L_0x02c3;
    L_0x0253:
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        if (r1 == 0) goto L_0x026f;
    L_0x0257:
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r5 = r1.f239y;
        r5 = r5 - r19;
        r1.f239y = r5;
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r5 = r1.f230p;
        r5 = r5 + r19;
        r1.f230p = r5;
        r1 = android.support.constraint.solver.LinearSystem.f197h;
        r5 = r1.f236v;
        r5 = r5 + r19;
        r1.f236v = r5;
    L_0x026f:
        r1 = r12.ae;
        r1 = r1[r23];
        if (r1 != 0) goto L_0x0277;
    L_0x0275:
        if (r12 != r11) goto L_0x02c1;
    L_0x0277:
        if (r23 != 0) goto L_0x027f;
    L_0x0279:
        r3 = r12.m114i();
        r3 = (float) r3;
        goto L_0x0284;
    L_0x027f:
        r3 = r12.m115j();
        r3 = (float) r3;
    L_0x0284:
        r5 = r12.f348z;
        r5 = r5[r24];
        r5 = r5.m85b();
        r5 = (float) r5;
        r9 = r9 + r5;
        r5 = r12.f348z;
        r5 = r5[r24];
        r5 = r5.f280a;
        r6 = r2.f356f;
        r5.m136a(r6, r9);
        r5 = r12.f348z;
        r5 = r5[r4];
        r5 = r5.f280a;
        r6 = r2.f356f;
        r9 = r9 + r3;
        r5.m136a(r6, r9);
        r3 = r12.f348z;
        r3 = r3[r24];
        r3 = r3.f280a;
        r3.m134a(r0);
        r3 = r12.f348z;
        r3 = r3[r4];
        r3 = r3.f280a;
        r3.m134a(r0);
        r3 = r12.f348z;
        r3 = r3[r4];
        r3 = r3.m85b();
        r3 = (float) r3;
        r9 = r9 + r3;
    L_0x02c1:
        r12 = r1;
        goto L_0x0251;
    L_0x02c3:
        r0 = 1;
        goto L_0x0365;
    L_0x02c6:
        if (r7 != 0) goto L_0x02ca;
    L_0x02c8:
        if (r8 == 0) goto L_0x02c3;
    L_0x02ca:
        if (r7 == 0) goto L_0x02ce;
    L_0x02cc:
        r3 = r3 - r1;
        goto L_0x02d1;
    L_0x02ce:
        if (r8 == 0) goto L_0x02d1;
    L_0x02d0:
        r3 = r3 - r1;
    L_0x02d1:
        r1 = r13 + 1;
        r1 = (float) r1;
        r1 = r3 / r1;
        if (r8 == 0) goto L_0x02e5;
    L_0x02d8:
        r5 = 1;
        if (r13 <= r5) goto L_0x02e1;
    L_0x02db:
        r1 = r13 + -1;
        r1 = (float) r1;
        r1 = r3 / r1;
        goto L_0x02e5;
    L_0x02e1:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r3 / r1;
    L_0x02e5:
        r3 = r9 + r1;
        if (r8 == 0) goto L_0x02f6;
    L_0x02e9:
        r5 = 1;
        if (r13 <= r5) goto L_0x02f6;
    L_0x02ec:
        r3 = r12.f348z;
        r3 = r3[r24];
        r3 = r3.m85b();
        r3 = (float) r3;
        r3 = r3 + r9;
    L_0x02f6:
        if (r7 == 0) goto L_0x0304;
    L_0x02f8:
        if (r12 == 0) goto L_0x0304;
    L_0x02fa:
        r5 = r12.f348z;
        r5 = r5[r24];
        r5 = r5.m85b();
        r5 = (float) r5;
        r3 = r3 + r5;
    L_0x0304:
        if (r12 == 0) goto L_0x02c3;
    L_0x0306:
        r5 = android.support.constraint.solver.LinearSystem.f197h;
        if (r5 == 0) goto L_0x0322;
    L_0x030a:
        r5 = android.support.constraint.solver.LinearSystem.f197h;
        r6 = r5.f239y;
        r6 = r6 - r19;
        r5.f239y = r6;
        r5 = android.support.constraint.solver.LinearSystem.f197h;
        r6 = r5.f230p;
        r6 = r6 + r19;
        r5.f230p = r6;
        r5 = android.support.constraint.solver.LinearSystem.f197h;
        r6 = r5.f236v;
        r6 = r6 + r19;
        r5.f236v = r6;
    L_0x0322:
        r5 = r12.ae;
        r5 = r5[r23];
        if (r5 != 0) goto L_0x032a;
    L_0x0328:
        if (r12 != r11) goto L_0x0363;
    L_0x032a:
        if (r23 != 0) goto L_0x0332;
    L_0x032c:
        r6 = r12.m114i();
        r6 = (float) r6;
        goto L_0x0337;
    L_0x0332:
        r6 = r12.m115j();
        r6 = (float) r6;
    L_0x0337:
        r7 = r12.f348z;
        r7 = r7[r24];
        r7 = r7.f280a;
        r8 = r2.f356f;
        r7.m136a(r8, r3);
        r7 = r12.f348z;
        r7 = r7[r4];
        r7 = r7.f280a;
        r8 = r2.f356f;
        r9 = r3 + r6;
        r7.m136a(r8, r9);
        r7 = r12.f348z;
        r7 = r7[r24];
        r7 = r7.f280a;
        r7.m134a(r0);
        r7 = r12.f348z;
        r7 = r7[r4];
        r7 = r7.f280a;
        r7.m134a(r0);
        r6 = r6 + r1;
        r3 = r3 + r6;
    L_0x0363:
        r12 = r5;
        goto L_0x0304;
    L_0x0365:
        return r0;
    L_0x0366:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.a(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ConstraintWidget):boolean");
    }
}
