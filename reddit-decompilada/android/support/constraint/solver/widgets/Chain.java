package android.support.constraint.solver.widgets;

class Chain {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m82a(android.support.constraint.solver.widgets.ConstraintWidgetContainer r42, android.support.constraint.solver.LinearSystem r43, int r44) {
        /*
        r0 = r42;
        r10 = r43;
        r11 = r44;
        r12 = 2;
        if (r11 != 0) goto L_0x0012;
    L_0x0009:
        r1 = r0.am;
        r2 = r0.ap;
        r15 = r1;
        r16 = r2;
        r14 = 0;
        goto L_0x001a;
    L_0x0012:
        r1 = r0.an;
        r2 = r0.ao;
        r15 = r1;
        r16 = r2;
        r14 = r12;
    L_0x001a:
        r9 = 0;
    L_0x001b:
        if (r9 >= r15) goto L_0x0557;
    L_0x001d:
        r8 = r16[r9];
        r1 = 4;
        r1 = r0.m16515g(r1);
        if (r1 == 0) goto L_0x0033;
    L_0x0026:
        r1 = android.support.constraint.solver.widgets.Optimizer.m132a(r0, r10, r11, r14, r8);
        if (r1 != 0) goto L_0x002d;
    L_0x002c:
        goto L_0x0033;
    L_0x002d:
        r18 = r9;
        r29 = r15;
        goto L_0x054c;
    L_0x0033:
        r1 = r0.B;
        r1 = r1[r11];
        r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r3 = 1;
        if (r1 != r2) goto L_0x003e;
    L_0x003c:
        r1 = r3;
        goto L_0x003f;
    L_0x003e:
        r1 = 0;
    L_0x003f:
        r17 = 0;
        if (r11 != 0) goto L_0x0071;
    L_0x0043:
        r2 = r0.f16396a;
        if (r2 == 0) goto L_0x0071;
    L_0x0047:
        r4 = r8;
        r2 = 0;
    L_0x0049:
        if (r2 != 0) goto L_0x0072;
    L_0x004b:
        r5 = r4.f348z;
        r6 = r14 + 1;
        r5 = r5[r6];
        r5 = r5.f283d;
        if (r5 == 0) goto L_0x0069;
    L_0x0055:
        r5 = r5.f281b;
        r6 = r5.f348z;
        r6 = r6[r14];
        r6 = r6.f283d;
        if (r6 == 0) goto L_0x0069;
    L_0x005f:
        r6 = r5.f348z;
        r6 = r6[r14];
        r6 = r6.f283d;
        r6 = r6.f281b;
        if (r6 == r4) goto L_0x006b;
    L_0x0069:
        r5 = r17;
    L_0x006b:
        if (r5 == 0) goto L_0x006f;
    L_0x006d:
        r4 = r5;
        goto L_0x0049;
    L_0x006f:
        r2 = r3;
        goto L_0x0049;
    L_0x0071:
        r4 = r8;
    L_0x0072:
        if (r11 != 0) goto L_0x009e;
    L_0x0074:
        r5 = r4.f321Y;
        if (r5 != 0) goto L_0x007a;
    L_0x0078:
        r5 = r3;
        goto L_0x007b;
    L_0x007a:
        r5 = 0;
    L_0x007b:
        r6 = r4.f321Y;
        if (r6 != r3) goto L_0x0081;
    L_0x007f:
        r6 = r3;
        goto L_0x0082;
    L_0x0081:
        r6 = 0;
    L_0x0082:
        r7 = r4.f321Y;
        if (r7 != r12) goto L_0x0088;
    L_0x0086:
        r7 = r3;
        goto L_0x0089;
    L_0x0088:
        r7 = 0;
    L_0x0089:
        r21 = r5;
        r22 = r6;
        r20 = r7;
        r7 = r8;
        r24 = r9;
        r3 = r17;
        r6 = r3;
        r12 = r6;
        r19 = r12;
        r5 = 0;
        r18 = 0;
        r23 = 0;
        goto L_0x00b1;
    L_0x009e:
        r5 = r4.f322Z;
        if (r5 != 0) goto L_0x00a4;
    L_0x00a2:
        r5 = r3;
        goto L_0x00a5;
    L_0x00a4:
        r5 = 0;
    L_0x00a5:
        r6 = r4.f322Z;
        if (r6 != r3) goto L_0x00ab;
    L_0x00a9:
        r6 = r3;
        goto L_0x00ac;
    L_0x00ab:
        r6 = 0;
    L_0x00ac:
        r7 = r4.f322Z;
        if (r7 != r12) goto L_0x0088;
    L_0x00b0:
        goto L_0x0086;
    L_0x00b1:
        if (r5 != 0) goto L_0x0198;
    L_0x00b3:
        r13 = r7.ae;
        r13[r11] = r17;
        r13 = r7.f317U;
        r2 = 8;
        if (r13 == r2) goto L_0x00c7;
    L_0x00bd:
        if (r6 == 0) goto L_0x00c3;
    L_0x00bf:
        r6 = r6.ae;
        r6[r11] = r7;
    L_0x00c3:
        if (r12 != 0) goto L_0x00c6;
    L_0x00c5:
        r12 = r7;
    L_0x00c6:
        r6 = r7;
    L_0x00c7:
        r13 = r7.f348z;
        r13 = r13[r14];
        r25 = r13.m85b();
        r9 = r13.f283d;
        if (r9 == 0) goto L_0x00e1;
    L_0x00d3:
        if (r7 == r8) goto L_0x00e1;
    L_0x00d5:
        r9 = r7.f317U;
        if (r9 == r2) goto L_0x00e1;
    L_0x00d9:
        r9 = r13.f283d;
        r9 = r9.m85b();
        r25 = r25 + r9;
    L_0x00e1:
        r9 = r25;
        if (r20 == 0) goto L_0x00eb;
    L_0x00e5:
        if (r7 == r8) goto L_0x00eb;
    L_0x00e7:
        if (r7 == r12) goto L_0x00eb;
    L_0x00e9:
        r2 = 6;
        goto L_0x00ec;
    L_0x00eb:
        r2 = 1;
    L_0x00ec:
        if (r7 != r12) goto L_0x00ff;
    L_0x00ee:
        r26 = r5;
        r5 = r13.f288i;
        r27 = r6;
        r6 = r13.f283d;
        r6 = r6.f288i;
        r28 = r12;
        r12 = 5;
        r10.m68a(r5, r6, r9, r12);
        goto L_0x010f;
    L_0x00ff:
        r26 = r5;
        r27 = r6;
        r28 = r12;
        r5 = r13.f288i;
        r6 = r13.f283d;
        r6 = r6.f288i;
        r12 = 6;
        r10.m68a(r5, r6, r9, r12);
    L_0x010f:
        r5 = r13.f288i;
        r6 = r13.f283d;
        r6 = r6.f288i;
        r10.m73c(r5, r6, r9, r2);
        r2 = r7.ad;
        r2[r11] = r17;
        r2 = r7.f317U;
        r5 = 8;
        if (r2 == r5) goto L_0x0151;
    L_0x0122:
        r2 = r7.f299B;
        r2 = r2[r11];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r2 != r5) goto L_0x0151;
    L_0x012a:
        r18 = r18 + 1;
        r2 = r7.ac;
        r2 = r2[r11];
        r23 = r23 + r2;
        if (r19 != 0) goto L_0x0137;
    L_0x0134:
        r19 = r7;
        goto L_0x013b;
    L_0x0137:
        r2 = r3.ad;
        r2[r11] = r7;
    L_0x013b:
        if (r1 == 0) goto L_0x0150;
    L_0x013d:
        r2 = r7.f348z;
        r3 = r14 + 1;
        r2 = r2[r3];
        r2 = r2.f288i;
        r3 = r7.f348z;
        r3 = r3[r14];
        r3 = r3.f288i;
        r5 = 0;
        r6 = 6;
        r10.m68a(r2, r3, r5, r6);
    L_0x0150:
        r3 = r7;
    L_0x0151:
        if (r1 == 0) goto L_0x0165;
    L_0x0153:
        r2 = r7.f348z;
        r2 = r2[r14];
        r2 = r2.f288i;
        r5 = r0.z;
        r5 = r5[r14];
        r5 = r5.f288i;
        r6 = 6;
        r13 = 0;
        r10.m68a(r2, r5, r13, r6);
        goto L_0x0166;
    L_0x0165:
        r13 = 0;
    L_0x0166:
        r2 = r7.f348z;
        r5 = r14 + 1;
        r2 = r2[r5];
        r2 = r2.f283d;
        if (r2 == 0) goto L_0x0184;
    L_0x0170:
        r2 = r2.f281b;
        r5 = r2.f348z;
        r5 = r5[r14];
        r5 = r5.f283d;
        if (r5 == 0) goto L_0x0184;
    L_0x017a:
        r5 = r2.f348z;
        r5 = r5[r14];
        r5 = r5.f283d;
        r5 = r5.f281b;
        if (r5 == r7) goto L_0x0186;
    L_0x0184:
        r2 = r17;
    L_0x0186:
        if (r2 == 0) goto L_0x0191;
    L_0x0188:
        r7 = r2;
        r5 = r26;
        r6 = r27;
        r12 = r28;
        goto L_0x00b1;
    L_0x0191:
        r6 = r27;
        r12 = r28;
        r5 = 1;
        goto L_0x00b1;
    L_0x0198:
        r13 = 0;
        if (r6 == 0) goto L_0x01bd;
    L_0x019b:
        r2 = r7.f348z;
        r3 = r14 + 1;
        r2 = r2[r3];
        r2 = r2.f283d;
        if (r2 == 0) goto L_0x01bd;
    L_0x01a5:
        r2 = r6.f348z;
        r2 = r2[r3];
        r5 = r2.f288i;
        r9 = r7.f348z;
        r3 = r9[r3];
        r3 = r3.f283d;
        r3 = r3.f288i;
        r2 = r2.m85b();
        r2 = -r2;
        r9 = 5;
        r10.m71b(r5, r3, r2, r9);
        goto L_0x01be;
    L_0x01bd:
        r9 = 5;
    L_0x01be:
        if (r1 == 0) goto L_0x01da;
    L_0x01c0:
        r1 = r0.z;
        r2 = r14 + 1;
        r1 = r1[r2];
        r1 = r1.f288i;
        r3 = r7.f348z;
        r3 = r3[r2];
        r3 = r3.f288i;
        r5 = r7.f348z;
        r2 = r5[r2];
        r2 = r2.m85b();
        r5 = 6;
        r10.m68a(r1, r3, r2, r5);
    L_0x01da:
        if (r18 <= 0) goto L_0x0297;
    L_0x01dc:
        r1 = r19;
    L_0x01de:
        if (r1 == 0) goto L_0x0297;
    L_0x01e0:
        r2 = r1.ad;
        r2 = r2[r11];
        if (r2 == 0) goto L_0x0284;
    L_0x01e6:
        r3 = r1.ac;
        r3 = r3[r11];
        r5 = r2.ac;
        r5 = r5[r11];
        r9 = r1.f348z;
        r9 = r9[r14];
        r9 = r9.f288i;
        r13 = r1.f348z;
        r18 = r14 + 1;
        r13 = r13[r18];
        r13 = r13.f288i;
        r0 = r2.f348z;
        r0 = r0[r14];
        r0 = r0.f288i;
        r29 = r15;
        r15 = r2.f348z;
        r15 = r15[r18];
        r15 = r15.f288i;
        if (r11 != 0) goto L_0x021a;
    L_0x020c:
        r1 = r1.f326d;
        r30 = r1;
        r1 = r2.f326d;
        r32 = r2;
        r33 = r4;
        r2 = r1;
        r1 = r30;
        goto L_0x0227;
    L_0x021a:
        r1 = r1.f327e;
        r31 = r1;
        r1 = r2.f327e;
        r32 = r2;
        r33 = r4;
        r2 = r1;
        r1 = r31;
    L_0x0227:
        r4 = 3;
        if (r1 == 0) goto L_0x022c;
    L_0x022a:
        if (r1 != r4) goto L_0x0231;
    L_0x022c:
        if (r2 == 0) goto L_0x0233;
    L_0x022e:
        if (r2 != r4) goto L_0x0231;
    L_0x0230:
        goto L_0x0233;
    L_0x0231:
        r1 = 0;
        goto L_0x0234;
    L_0x0233:
        r1 = 1;
    L_0x0234:
        if (r1 == 0) goto L_0x028a;
    L_0x0236:
        r1 = r43.m72c();
        r2 = 0;
        r4 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1));
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r4 == 0) goto L_0x0267;
    L_0x0241:
        r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r4 != 0) goto L_0x0246;
    L_0x0245:
        goto L_0x0267;
    L_0x0246:
        r3 = r3 / r23;
        r5 = r5 / r23;
        r3 = r3 / r5;
        r4 = 0;
        r1.f10989b = r4;
        r4 = r1.f10991d;
        r4.m43a(r9, r2);
        r2 = r1.f10991d;
        r4 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r2.m43a(r13, r4);
        r2 = r1.f10991d;
        r2.m43a(r15, r3);
        r2 = r1.f10991d;
        r3 = -r3;
        r2.m43a(r0, r3);
        r3 = 0;
        goto L_0x0280;
    L_0x0267:
        r3 = 0;
        r1.f10989b = r3;
        r4 = r1.f10991d;
        r4.m43a(r9, r2);
        r4 = r1.f10991d;
        r5 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r4.m43a(r13, r5);
        r4 = r1.f10991d;
        r4.m43a(r15, r2);
        r2 = r1.f10991d;
        r2.m43a(r0, r5);
    L_0x0280:
        r10.m63a(r1);
        goto L_0x028b;
    L_0x0284:
        r32 = r2;
        r33 = r4;
        r29 = r15;
    L_0x028a:
        r3 = 0;
    L_0x028b:
        r15 = r29;
        r1 = r32;
        r4 = r33;
        r0 = r42;
        r9 = 5;
        r13 = 0;
        goto L_0x01de;
    L_0x0297:
        r33 = r4;
        r29 = r15;
        if (r12 == 0) goto L_0x0316;
    L_0x029d:
        if (r12 == r6) goto L_0x02a1;
    L_0x029f:
        if (r20 == 0) goto L_0x0316;
    L_0x02a1:
        r0 = r8.f348z;
        r0 = r0[r14];
        r1 = r7.f348z;
        r2 = r14 + 1;
        r1 = r1[r2];
        r3 = r8.f348z;
        r3 = r3[r14];
        r3 = r3.f283d;
        if (r3 == 0) goto L_0x02bc;
    L_0x02b3:
        r3 = r8.f348z;
        r3 = r3[r14];
        r3 = r3.f283d;
        r3 = r3.f288i;
        goto L_0x02be;
    L_0x02bc:
        r3 = r17;
    L_0x02be:
        r4 = r7.f348z;
        r4 = r4[r2];
        r4 = r4.f283d;
        if (r4 == 0) goto L_0x02d0;
    L_0x02c6:
        r4 = r7.f348z;
        r4 = r4[r2];
        r4 = r4.f283d;
        r4 = r4.f288i;
        r8 = r4;
        goto L_0x02d2;
    L_0x02d0:
        r8 = r17;
    L_0x02d2:
        if (r12 != r6) goto L_0x02dc;
    L_0x02d4:
        r0 = r12.f348z;
        r0 = r0[r14];
        r1 = r12.f348z;
        r1 = r1[r2];
    L_0x02dc:
        if (r3 == 0) goto L_0x0311;
    L_0x02de:
        if (r8 == 0) goto L_0x0311;
    L_0x02e0:
        if (r11 != 0) goto L_0x02e8;
    L_0x02e2:
        r4 = r33;
        r4 = r4.f314R;
    L_0x02e6:
        r5 = r4;
        goto L_0x02ed;
    L_0x02e8:
        r4 = r33;
        r4 = r4.f315S;
        goto L_0x02e6;
    L_0x02ed:
        r4 = r0.m85b();
        if (r6 != 0) goto L_0x02f5;
    L_0x02f3:
        r13 = r7;
        goto L_0x02f6;
    L_0x02f5:
        r13 = r6;
    L_0x02f6:
        r6 = r13.f348z;
        r2 = r6[r2];
        r9 = r2.m85b();
        r2 = r0.f288i;
        r0 = r1.f288i;
        r15 = 5;
        r1 = r10;
        r6 = r8;
        r8 = r7;
        r7 = r0;
        r0 = r8;
        r8 = r9;
        r18 = r24;
        r9 = r15;
        r1.m67a(r2, r3, r4, r5, r6, r7, r8, r9);
        goto L_0x04f5;
    L_0x0311:
        r0 = r7;
        r18 = r24;
        goto L_0x03dd;
    L_0x0316:
        r0 = r7;
        r18 = r24;
        if (r21 == 0) goto L_0x03e0;
    L_0x031b:
        if (r12 == 0) goto L_0x03e0;
    L_0x031d:
        r1 = r12;
        r13 = r1;
    L_0x031f:
        if (r13 == 0) goto L_0x03dd;
    L_0x0321:
        r2 = r13.ae;
        r15 = r2[r11];
        if (r15 != 0) goto L_0x032f;
    L_0x0327:
        if (r13 != r6) goto L_0x032a;
    L_0x0329:
        goto L_0x032f;
    L_0x032a:
        r36 = r13;
        r13 = r6;
        goto L_0x03d7;
    L_0x032f:
        r2 = r13.f348z;
        r2 = r2[r14];
        r3 = r2.f288i;
        r4 = r2.f283d;
        if (r4 == 0) goto L_0x033e;
    L_0x0339:
        r4 = r2.f283d;
        r4 = r4.f288i;
        goto L_0x0340;
    L_0x033e:
        r4 = r17;
    L_0x0340:
        if (r1 == r13) goto L_0x034a;
    L_0x0342:
        r4 = r1.f348z;
        r5 = r14 + 1;
        r4 = r4[r5];
        r4 = r4.f288i;
    L_0x034a:
        r2 = r2.m85b();
        r5 = r13.f348z;
        r7 = r14 + 1;
        r5 = r5[r7];
        r5 = r5.m85b();
        if (r15 == 0) goto L_0x036e;
    L_0x035a:
        r8 = r15.f348z;
        r8 = r8[r14];
        r9 = r8.f288i;
        r34 = r9;
        r9 = r8.f283d;
        if (r9 == 0) goto L_0x036b;
    L_0x0366:
        r9 = r8.f283d;
        r9 = r9.f288i;
        goto L_0x038a;
    L_0x036b:
        r9 = r17;
        goto L_0x038a;
    L_0x036e:
        r8 = r0.f348z;
        r8 = r8[r7];
        r8 = r8.f283d;
        if (r8 == 0) goto L_0x037b;
    L_0x0376:
        r9 = r8.f288i;
        r35 = r8;
        goto L_0x037f;
    L_0x037b:
        r35 = r8;
        r9 = r17;
    L_0x037f:
        r8 = r13.f348z;
        r8 = r8[r7];
        r8 = r8.f288i;
        r34 = r9;
        r9 = r8;
        r8 = r35;
    L_0x038a:
        if (r8 == 0) goto L_0x0391;
    L_0x038c:
        r8 = r8.m85b();
        r5 = r5 + r8;
    L_0x0391:
        if (r1 == 0) goto L_0x039c;
    L_0x0393:
        r1 = r1.f348z;
        r1 = r1[r7];
        r1 = r1.m85b();
        r2 = r2 + r1;
    L_0x039c:
        if (r3 == 0) goto L_0x032a;
    L_0x039e:
        if (r4 == 0) goto L_0x032a;
    L_0x03a0:
        if (r34 == 0) goto L_0x032a;
    L_0x03a2:
        if (r9 == 0) goto L_0x032a;
    L_0x03a4:
        if (r13 != r12) goto L_0x03b0;
    L_0x03a6:
        r1 = r12.f348z;
        r1 = r1[r14];
        r1 = r1.m85b();
        r8 = r1;
        goto L_0x03b1;
    L_0x03b0:
        r8 = r2;
    L_0x03b1:
        if (r13 != r6) goto L_0x03be;
    L_0x03b3:
        r1 = r6.f348z;
        r1 = r1[r7];
        r1 = r1.m85b();
        r19 = r1;
        goto L_0x03c0;
    L_0x03be:
        r19 = r5;
    L_0x03c0:
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r20 = 4;
        r1 = r10;
        r2 = r3;
        r3 = r4;
        r4 = r8;
        r8 = r6;
        r6 = r34;
        r7 = r9;
        r9 = r8;
        r8 = r19;
        r36 = r13;
        r13 = r9;
        r9 = r20;
        r1.m67a(r2, r3, r4, r5, r6, r7, r8, r9);
    L_0x03d7:
        r6 = r13;
        r13 = r15;
        r1 = r36;
        goto L_0x031f;
    L_0x03dd:
        r13 = r6;
        goto L_0x04f5;
    L_0x03e0:
        r13 = r6;
        if (r22 == 0) goto L_0x04f5;
    L_0x03e3:
        if (r12 == 0) goto L_0x04f5;
    L_0x03e5:
        r1 = r12;
        r15 = r1;
    L_0x03e7:
        if (r15 == 0) goto L_0x0492;
    L_0x03e9:
        r2 = r15.ae;
        r2 = r2[r11];
        if (r15 == r12) goto L_0x0487;
    L_0x03ef:
        if (r15 == r13) goto L_0x0487;
    L_0x03f1:
        if (r2 == 0) goto L_0x0487;
    L_0x03f3:
        if (r2 != r13) goto L_0x03f8;
    L_0x03f5:
        r9 = r17;
        goto L_0x03f9;
    L_0x03f8:
        r9 = r2;
    L_0x03f9:
        r2 = r15.f348z;
        r2 = r2[r14];
        r3 = r2.f288i;
        r4 = r1.f348z;
        r5 = r14 + 1;
        r4 = r4[r5];
        r4 = r4.f288i;
        r2 = r2.m85b();
        r6 = r15.f348z;
        r6 = r6[r5];
        r6 = r6.m85b();
        if (r9 == 0) goto L_0x042b;
    L_0x0415:
        r7 = r9.f348z;
        r7 = r7[r14];
        r37 = r8;
        r8 = r7.f288i;
        r38 = r8;
        r8 = r7.f283d;
        if (r8 == 0) goto L_0x0428;
    L_0x0423:
        r8 = r7.f283d;
        r8 = r8.f288i;
        goto L_0x0449;
    L_0x0428:
        r8 = r17;
        goto L_0x0449;
    L_0x042b:
        r37 = r8;
        r7 = r15.f348z;
        r7 = r7[r5];
        r7 = r7.f283d;
        if (r7 == 0) goto L_0x043a;
    L_0x0435:
        r8 = r7.f288i;
        r39 = r7;
        goto L_0x043e;
    L_0x043a:
        r39 = r7;
        r8 = r17;
    L_0x043e:
        r7 = r15.f348z;
        r7 = r7[r5];
        r7 = r7.f288i;
        r38 = r8;
        r8 = r7;
        r7 = r39;
    L_0x0449:
        if (r7 == 0) goto L_0x0450;
    L_0x044b:
        r7 = r7.m85b();
        r6 = r6 + r7;
    L_0x0450:
        r19 = r6;
        if (r1 == 0) goto L_0x045d;
    L_0x0454:
        r1 = r1.f348z;
        r1 = r1[r5];
        r1 = r1.m85b();
        r2 = r2 + r1;
    L_0x045d:
        r5 = r2;
        if (r3 == 0) goto L_0x047f;
    L_0x0460:
        if (r4 == 0) goto L_0x047f;
    L_0x0462:
        if (r38 == 0) goto L_0x047f;
    L_0x0464:
        if (r8 == 0) goto L_0x047f;
    L_0x0466:
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r20 = 4;
        r1 = r10;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r38;
        r7 = r8;
        r40 = r37;
        r8 = r19;
        r19 = r9;
        r11 = 5;
        r9 = r20;
        r1.m67a(r2, r3, r4, r5, r6, r7, r8, r9);
        goto L_0x0484;
    L_0x047f:
        r19 = r9;
        r40 = r37;
        r11 = 5;
    L_0x0484:
        r2 = r19;
        goto L_0x048a;
    L_0x0487:
        r40 = r8;
        r11 = 5;
    L_0x048a:
        r1 = r15;
        r8 = r40;
        r11 = r44;
        r15 = r2;
        goto L_0x03e7;
    L_0x0492:
        r40 = r8;
        r11 = 5;
        r1 = r12.f348z;
        r1 = r1[r14];
        r2 = r40;
        r2 = r2.f348z;
        r2 = r2[r14];
        r2 = r2.f283d;
        r3 = r13.f348z;
        r4 = r14 + 1;
        r15 = r3[r4];
        r3 = r0.f348z;
        r3 = r3[r4];
        r9 = r3.f283d;
        if (r2 == 0) goto L_0x04e3;
    L_0x04af:
        if (r12 == r13) goto L_0x04bd;
    L_0x04b1:
        r3 = r1.f288i;
        r2 = r2.f288i;
        r1 = r1.m85b();
        r10.m73c(r3, r2, r1, r11);
        goto L_0x04e3;
    L_0x04bd:
        if (r9 == 0) goto L_0x04e3;
    L_0x04bf:
        r3 = r1.f288i;
        r4 = r2.f288i;
        r5 = r1.m85b();
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = r15.f288i;
        r8 = r9.f288i;
        r19 = r15.m85b();
        r20 = 5;
        r1 = r10;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r19;
        r11 = r9;
        r9 = r20;
        r1.m67a(r2, r3, r4, r5, r6, r7, r8, r9);
        goto L_0x04e4;
    L_0x04e3:
        r11 = r9;
    L_0x04e4:
        if (r11 == 0) goto L_0x04f5;
    L_0x04e6:
        if (r12 == r13) goto L_0x04f5;
    L_0x04e8:
        r1 = r15.f288i;
        r2 = r11.f288i;
        r3 = r15.m85b();
        r3 = -r3;
        r4 = 5;
        r10.m73c(r1, r2, r3, r4);
    L_0x04f5:
        r7 = r13;
        if (r21 != 0) goto L_0x04fa;
    L_0x04f8:
        if (r22 == 0) goto L_0x054c;
    L_0x04fa:
        if (r12 == 0) goto L_0x054c;
    L_0x04fc:
        r1 = r12.f348z;
        r1 = r1[r14];
        r2 = r7.f348z;
        r3 = r14 + 1;
        r2 = r2[r3];
        r4 = r1.f283d;
        if (r4 == 0) goto L_0x050f;
    L_0x050a:
        r4 = r1.f283d;
        r4 = r4.f288i;
        goto L_0x0511;
    L_0x050f:
        r4 = r17;
    L_0x0511:
        r5 = r2.f283d;
        if (r5 == 0) goto L_0x051b;
    L_0x0515:
        r5 = r2.f283d;
        r5 = r5.f288i;
        r6 = r5;
        goto L_0x051d;
    L_0x051b:
        r6 = r17;
    L_0x051d:
        if (r12 != r7) goto L_0x0527;
    L_0x051f:
        r1 = r12.f348z;
        r1 = r1[r14];
        r2 = r12.f348z;
        r2 = r2[r3];
    L_0x0527:
        if (r4 == 0) goto L_0x054c;
    L_0x0529:
        if (r6 == 0) goto L_0x054c;
    L_0x052b:
        r5 = r1.m85b();
        if (r7 != 0) goto L_0x0532;
    L_0x0531:
        goto L_0x0533;
    L_0x0532:
        r0 = r7;
    L_0x0533:
        r0 = r0.f348z;
        r0 = r0[r3];
        r8 = r0.m85b();
        r0 = r1.f288i;
        r7 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r9 = r2.f288i;
        r11 = 5;
        r1 = r10;
        r2 = r0;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r11;
        r1.m67a(r2, r3, r4, r5, r6, r7, r8, r9);
    L_0x054c:
        r9 = r18 + 1;
        r15 = r29;
        r0 = r42;
        r11 = r44;
        r12 = 2;
        goto L_0x001b;
    L_0x0557:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.a(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int):void");
    }
}
