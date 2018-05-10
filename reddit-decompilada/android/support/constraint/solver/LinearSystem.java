package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static Metrics f197h = null;
    private static int f198i = 1000;
    int f199a;
    public Row f200b;
    public ArrayRow[] f201c;
    public boolean f202d;
    int f203e;
    public int f204f;
    public final Cache f205g;
    private HashMap<String, SolverVariable> f206j;
    private int f207k;
    private int f208l;
    private boolean[] f209m;
    private int f210n;
    private SolverVariable[] f211o;
    private int f212p;
    private ArrayRow[] f213q;

    interface Row {
        SolverVariable mo6a(boolean[] zArr);

        void mo7a(Row row);

        void mo8b();

        void mo9b(SolverVariable solverVariable);

        SolverVariable mo10c();
    }

    public LinearSystem() {
        this.f199a = 0;
        this.f206j = null;
        this.f207k = 32;
        this.f208l = this.f207k;
        this.f201c = null;
        this.f202d = false;
        this.f209m = new boolean[this.f207k];
        this.f203e = 1;
        this.f204f = 0;
        this.f210n = this.f207k;
        this.f211o = new SolverVariable[f198i];
        this.f212p = 0;
        this.f213q = new ArrayRow[this.f207k];
        this.f201c = new ArrayRow[this.f207k];
        m60g();
        this.f205g = new Cache();
        this.f200b = new GoalRow(this.f205g);
    }

    public static Metrics m53a() {
        return f197h;
    }

    private void m59f() {
        this.f207k *= 2;
        this.f201c = (ArrayRow[]) Arrays.copyOf(this.f201c, this.f207k);
        this.f205g.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.f205g.mIndexedVariables, this.f207k);
        this.f209m = new boolean[this.f207k];
        this.f208l = this.f207k;
        this.f210n = this.f207k;
        if (f197h != null) {
            Metrics metrics = f197h;
            metrics.f215a++;
            f197h.f227m = Math.max(f197h.f227m, (long) this.f207k);
            f197h.f214A = f197h.f227m;
        }
    }

    private void m60g() {
        for (int i = 0; i < this.f201c.length; i++) {
            Object obj = this.f201c[i];
            if (obj != null) {
                this.f205g.arrayRowPool.mo13a(obj);
            }
            this.f201c[i] = null;
        }
    }

    public final void m70b() {
        int i;
        for (SolverVariable solverVariable : this.f205g.mIndexedVariables) {
            if (solverVariable != null) {
                solverVariable.m81b();
            }
        }
        this.f205g.solverVariablePool.mo12a(this.f211o, this.f212p);
        this.f212p = 0;
        Arrays.fill(this.f205g.mIndexedVariables, null);
        if (this.f206j != null) {
            this.f206j.clear();
        }
        this.f199a = 0;
        this.f200b.mo8b();
        this.f203e = 1;
        for (i = 0; i < this.f204f; i++) {
            this.f201c[i].f10990c = false;
        }
        m60g();
        this.f204f = 0;
    }

    public final SolverVariable m62a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f203e + 1 >= this.f208l) {
            m59f();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.f288i;
            if (solverVariable == null) {
                constraintAnchor.m83a();
                solverVariable = constraintAnchor.f288i;
            }
            if (solverVariable.f252a == -1 || solverVariable.f252a > this.f199a || this.f205g.mIndexedVariables[solverVariable.f252a] == null) {
                if (solverVariable.f252a != -1) {
                    solverVariable.m81b();
                }
                this.f199a++;
                this.f203e++;
                solverVariable.f252a = this.f199a;
                solverVariable.f257f = Type.UNRESTRICTED;
                this.f205g.mIndexedVariables[this.f199a] = solverVariable;
            }
        }
        return solverVariable;
    }

    public final ArrayRow m72c() {
        ArrayRow arrayRow = (ArrayRow) this.f205g.arrayRowPool.mo11a();
        if (arrayRow == null) {
            arrayRow = new ArrayRow(this.f205g);
        } else {
            arrayRow.f10988a = null;
            arrayRow.f10991d.m41a();
            arrayRow.f10989b = 0.0f;
            arrayRow.f10992e = false;
        }
        SolverVariable.m79a();
        return arrayRow;
    }

    public final SolverVariable m74d() {
        if (f197h != null) {
            Metrics metrics = f197h;
            metrics.f225k++;
        }
        if (this.f203e + 1 >= this.f208l) {
            m59f();
        }
        SolverVariable a = m54a(Type.SLACK);
        this.f199a++;
        this.f203e++;
        a.f252a = this.f199a;
        this.f205g.mIndexedVariables[this.f199a] = a;
        return a;
    }

    public final void m64a(ArrayRow arrayRow, int i, int i2) {
        arrayRow.f10991d.m43a(m61a(i2), (float) i);
    }

    public final SolverVariable m61a(int i) {
        if (f197h != null) {
            Metrics metrics = f197h;
            metrics.f224j++;
        }
        if (this.f203e + 1 >= this.f208l) {
            m59f();
        }
        SolverVariable a = m54a(Type.ERROR);
        this.f199a++;
        this.f203e++;
        a.f252a = this.f199a;
        a.f254c = i;
        this.f205g.mIndexedVariables[this.f199a] = a;
        this.f200b.mo9b(a);
        return a;
    }

    private SolverVariable m54a(Type type) {
        SolverVariable solverVariable = (SolverVariable) this.f205g.solverVariablePool.mo11a();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type);
            solverVariable.f257f = type;
        } else {
            solverVariable.m81b();
            solverVariable.f257f = type;
        }
        if (this.f212p >= f198i) {
            f198i *= 2;
            this.f211o = (SolverVariable[]) Arrays.copyOf(this.f211o, f198i);
        }
        type = this.f211o;
        int i = this.f212p;
        this.f212p = i + 1;
        type[i] = solverVariable;
        return solverVariable;
    }

    public static int m56b(Object obj) {
        obj = ((ConstraintAnchor) obj).f288i;
        return obj != null ? (int) (obj.f255d + 0.5f) : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m65a(android.support.constraint.solver.LinearSystem.Row r18) throws java.lang.Exception {
        /*
        r17 = this;
        r0 = r17;
        r1 = f197h;
        r2 = 1;
        if (r1 == 0) goto L_0x002d;
    L_0x0008:
        r1 = f197h;
        r4 = r1.f231q;
        r4 = r4 + r2;
        r1.f231q = r4;
        r1 = f197h;
        r4 = f197h;
        r4 = r4.f232r;
        r6 = r0.f203e;
        r6 = (long) r6;
        r4 = java.lang.Math.max(r4, r6);
        r1.f232r = r4;
        r1 = f197h;
        r4 = f197h;
        r4 = r4.f233s;
        r6 = r0.f204f;
        r6 = (long) r6;
        r4 = java.lang.Math.max(r4, r6);
        r1.f233s = r4;
    L_0x002d:
        r4 = r18;
        r4 = (android.support.constraint.solver.ArrayRow) r4;
        r0.m57b(r4);
        r6 = 0;
    L_0x0035:
        r7 = r0.f204f;
        r8 = 0;
        if (r6 >= r7) goto L_0x0055;
    L_0x003a:
        r7 = r0.f201c;
        r7 = r7[r6];
        r7 = r7.f10988a;
        r7 = r7.f257f;
        r10 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED;
        if (r7 == r10) goto L_0x0052;
    L_0x0046:
        r7 = r0.f201c;
        r7 = r7[r6];
        r7 = r7.f10989b;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 >= 0) goto L_0x0052;
    L_0x0050:
        r6 = 1;
        goto L_0x0056;
    L_0x0052:
        r6 = r6 + 1;
        goto L_0x0035;
    L_0x0055:
        r6 = 0;
    L_0x0056:
        if (r6 == 0) goto L_0x0102;
    L_0x0058:
        r6 = 0;
    L_0x0059:
        if (r6 != 0) goto L_0x0102;
    L_0x005b:
        r7 = f197h;
        if (r7 == 0) goto L_0x0066;
    L_0x005f:
        r7 = f197h;
        r10 = r7.f222h;
        r10 = r10 + r2;
        r7.f222h = r10;
    L_0x0066:
        r7 = 2139095039; // 0x7f7fffff float:3.4028235E38 double:1.056853372E-314;
        r10 = -1;
        r13 = r7;
        r11 = r10;
        r12 = r11;
        r7 = 0;
        r14 = 0;
    L_0x006f:
        r15 = r0.f204f;
        if (r7 >= r15) goto L_0x00be;
    L_0x0073:
        r15 = r0.f201c;
        r15 = r15[r7];
        r5 = r15.f10988a;
        r5 = r5.f257f;
        r9 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED;
        if (r5 == r9) goto L_0x00b8;
    L_0x007f:
        r5 = r15.f10989b;
        r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));
        if (r5 >= 0) goto L_0x00b8;
    L_0x0085:
        r5 = 1;
    L_0x0086:
        r9 = r0.f203e;
        if (r5 >= r9) goto L_0x00b8;
    L_0x008a:
        r9 = r0.f205g;
        r9 = r9.mIndexedVariables;
        r9 = r9[r5];
        r2 = r15.f10991d;
        r2 = r2.m46c(r9);
        r3 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r3 <= 0) goto L_0x00b2;
    L_0x009a:
        r3 = 0;
    L_0x009b:
        r8 = 7;
        if (r3 >= r8) goto L_0x00b2;
    L_0x009e:
        r8 = r9.f256e;
        r8 = r8[r3];
        r8 = r8 / r2;
        r16 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1));
        if (r16 >= 0) goto L_0x00a9;
    L_0x00a7:
        if (r3 == r14) goto L_0x00ab;
    L_0x00a9:
        if (r3 <= r14) goto L_0x00af;
    L_0x00ab:
        r14 = r3;
        r12 = r5;
        r11 = r7;
        r13 = r8;
    L_0x00af:
        r3 = r3 + 1;
        goto L_0x009b;
    L_0x00b2:
        r5 = r5 + 1;
        r2 = 1;
        r8 = 0;
        goto L_0x0086;
    L_0x00b8:
        r7 = r7 + 1;
        r2 = 1;
        r8 = 0;
        goto L_0x006f;
    L_0x00be:
        if (r11 == r10) goto L_0x00fc;
    L_0x00c0:
        r2 = r0.f201c;
        r2 = r2[r11];
        r3 = r2.f10988a;
        r3.f253b = r10;
        r3 = f197h;
        if (r3 == 0) goto L_0x00d6;
    L_0x00cc:
        r3 = f197h;
        r7 = r3.f221g;
        r9 = 1;
        r7 = r7 + r9;
        r3.f221g = r7;
        goto L_0x00d8;
    L_0x00d6:
        r9 = 1;
    L_0x00d8:
        r3 = r0.f205g;
        r3 = r3.mIndexedVariables;
        r3 = r3[r12];
        r2.m9431a(r3);
        r2.m9429a();
        r3 = r2.f10988a;
        r3.f253b = r11;
        r3 = 0;
    L_0x00e9:
        r5 = r0.f204f;
        if (r3 >= r5) goto L_0x00f7;
    L_0x00ed:
        r5 = r0.f201c;
        r5 = r5[r3];
        r5.m9432a(r2);
        r3 = r3 + 1;
        goto L_0x00e9;
    L_0x00f7:
        r0.m57b(r4);
        r2 = r9;
        goto L_0x00ff;
    L_0x00fc:
        r2 = 1;
        r6 = 1;
    L_0x00ff:
        r8 = 0;
        goto L_0x0059;
    L_0x0102:
        r2 = 0;
    L_0x0103:
        r3 = r0.f204f;
        if (r2 >= r3) goto L_0x0123;
    L_0x0107:
        r3 = r0.f201c;
        r3 = r3[r2];
        r3 = r3.f10988a;
        r3 = r3.f257f;
        r4 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED;
        if (r3 == r4) goto L_0x011f;
    L_0x0113:
        r3 = r0.f201c;
        r3 = r3[r2];
        r3 = r3.f10989b;
        r4 = 0;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 < 0) goto L_0x0123;
    L_0x011e:
        goto L_0x0120;
    L_0x011f:
        r4 = 0;
    L_0x0120:
        r2 = r2 + 1;
        goto L_0x0103;
    L_0x0123:
        r17.m55b(r18);
        r17.m75e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.LinearSystem.a(android.support.constraint.solver.LinearSystem$Row):void");
    }

    private void m57b(ArrayRow arrayRow) {
        if (this.f204f > 0) {
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.f10991d;
            ArrayRow[] arrayRowArr = this.f201c;
            int i = arrayLinkedVariables.f191f;
            loop0:
            while (true) {
                int i2 = 0;
                while (i != -1 && i2 < arrayLinkedVariables.f186a) {
                    SolverVariable solverVariable = arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i]];
                    if (solverVariable.f253b != -1) {
                        float f = arrayLinkedVariables.f190e[i];
                        arrayLinkedVariables.m38a(solverVariable);
                        ArrayRow arrayRow2 = arrayRowArr[solverVariable.f253b];
                        if (!arrayRow2.f10992e) {
                            ArrayLinkedVariables arrayLinkedVariables2 = arrayRow2.f10991d;
                            int i3 = arrayLinkedVariables2.f191f;
                            int i4 = 0;
                            while (i3 != -1 && i4 < arrayLinkedVariables2.f186a) {
                                arrayLinkedVariables.m45b(arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables2.f188c[i3]], arrayLinkedVariables2.f190e[i3] * f);
                                i3 = arrayLinkedVariables2.f189d[i3];
                                i4++;
                            }
                        }
                        arrayRow.f10989b += arrayRow2.f10989b * f;
                        arrayRow2.f10988a.m80a(arrayRow);
                        i = arrayLinkedVariables.f191f;
                    } else {
                        i = arrayLinkedVariables.f189d[i];
                        i2++;
                    }
                }
            }
            if (arrayRow.f10991d.f186a == 0) {
                arrayRow.f10992e = true;
            }
        }
    }

    public final void m63a(ArrayRow arrayRow) {
        LinearSystem linearSystem = this;
        ArrayRow arrayRow2 = arrayRow;
        if (arrayRow2 != null) {
            Metrics metrics;
            boolean z;
            if (f197h != null) {
                metrics = f197h;
                metrics.f217c++;
                if (arrayRow2.f10992e) {
                    metrics = f197h;
                    metrics.f218d++;
                }
            }
            if (linearSystem.f204f + 1 >= linearSystem.f210n || linearSystem.f203e + 1 >= linearSystem.f208l) {
                m59f();
            }
            if (arrayRow2.f10992e) {
                z = false;
            } else {
                m57b(arrayRow);
                boolean z2 = arrayRow2.f10988a == null && arrayRow2.f10989b == 0.0f && arrayRow2.f10991d.f186a == 0;
                if (!z2) {
                    ArrayLinkedVariables arrayLinkedVariables;
                    int i;
                    boolean z3;
                    int i2 = -1;
                    if (arrayRow2.f10989b < 0.0f) {
                        arrayRow2.f10989b *= -1.0f;
                        arrayLinkedVariables = arrayRow2.f10991d;
                        int i3 = arrayLinkedVariables.f191f;
                        i = 0;
                        while (i3 != -1 && i < arrayLinkedVariables.f186a) {
                            float[] fArr = arrayLinkedVariables.f190e;
                            fArr[i3] = fArr[i3] * -1.0f;
                            i3 = arrayLinkedVariables.f189d[i3];
                            i++;
                        }
                    }
                    arrayLinkedVariables = arrayRow2.f10991d;
                    int i4 = arrayLinkedVariables.f191f;
                    float f = 0.0f;
                    float f2 = f;
                    i = 0;
                    SolverVariable solverVariable = null;
                    SolverVariable solverVariable2 = null;
                    boolean z4 = false;
                    boolean z5 = false;
                    while (i4 != i2 && i < arrayLinkedVariables.f186a) {
                        SolverVariable solverVariable3;
                        boolean b;
                        float f3 = arrayLinkedVariables.f190e[i4];
                        if (f3 < 0.0f) {
                            if (f3 > -0.001f) {
                                arrayLinkedVariables.f190e[i4] = 0.0f;
                            }
                            solverVariable3 = arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i4]];
                            if (solverVariable3.f257f == Type.UNRESTRICTED) {
                                if (solverVariable != null) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (f > f3) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (!z4 && ArrayLinkedVariables.m37b(solverVariable3)) {
                                    z4 = true;
                                    f = f3;
                                    solverVariable = solverVariable3;
                                }
                                z4 = b;
                                f = f3;
                                solverVariable = solverVariable3;
                            } else if (solverVariable == null && f3 < 0.0f) {
                                if (solverVariable2 != null) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (f2 > f3) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (!z5 && ArrayLinkedVariables.m37b(solverVariable3)) {
                                    z5 = true;
                                    f2 = f3;
                                    solverVariable2 = solverVariable3;
                                }
                                z5 = b;
                                f2 = f3;
                                solverVariable2 = solverVariable3;
                            }
                            i4 = arrayLinkedVariables.f189d[i4];
                            i++;
                            i2 = -1;
                        } else {
                            if (f3 < 0.001f) {
                                arrayLinkedVariables.f190e[i4] = 0.0f;
                            }
                            solverVariable3 = arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i4]];
                            if (solverVariable3.f257f == Type.UNRESTRICTED) {
                                if (solverVariable2 != null) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (f2 > f3) {
                                    z5 = true;
                                    f2 = f3;
                                    solverVariable2 = solverVariable3;
                                } else {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                }
                                z5 = b;
                                f2 = f3;
                                solverVariable2 = solverVariable3;
                            } else {
                                if (solverVariable != null) {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                } else if (f > f3) {
                                    z4 = true;
                                    f = f3;
                                    solverVariable = solverVariable3;
                                } else {
                                    b = ArrayLinkedVariables.m37b(solverVariable3);
                                }
                                z4 = b;
                                f = f3;
                                solverVariable = solverVariable3;
                            }
                            i4 = arrayLinkedVariables.f189d[i4];
                            i++;
                            i2 = -1;
                        }
                        f3 = 0.0f;
                        solverVariable3 = arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i4]];
                        if (solverVariable3.f257f == Type.UNRESTRICTED) {
                            if (solverVariable != null) {
                                b = ArrayLinkedVariables.m37b(solverVariable3);
                            } else if (f > f3) {
                                b = ArrayLinkedVariables.m37b(solverVariable3);
                            } else {
                                z4 = true;
                                f = f3;
                                solverVariable = solverVariable3;
                            }
                            z4 = b;
                            f = f3;
                            solverVariable = solverVariable3;
                        } else {
                            if (solverVariable2 != null) {
                                b = ArrayLinkedVariables.m37b(solverVariable3);
                            } else if (f2 > f3) {
                                b = ArrayLinkedVariables.m37b(solverVariable3);
                            } else {
                                z5 = true;
                                f2 = f3;
                                solverVariable2 = solverVariable3;
                            }
                            z5 = b;
                            f2 = f3;
                            solverVariable2 = solverVariable3;
                        }
                        i4 = arrayLinkedVariables.f189d[i4];
                        i++;
                        i2 = -1;
                    }
                    if (solverVariable == null) {
                        solverVariable = solverVariable2;
                    }
                    if (solverVariable == null) {
                        z2 = true;
                    } else {
                        arrayRow2.m9431a(solverVariable);
                        z2 = false;
                    }
                    if (arrayRow2.f10991d.f186a == 0) {
                        arrayRow2.f10992e = true;
                    }
                    if (z2) {
                        if (f197h != null) {
                            metrics = f197h;
                            metrics.f226l++;
                        }
                        if (linearSystem.f203e + 1 >= linearSystem.f208l) {
                            m59f();
                        }
                        SolverVariable a = m54a(Type.SLACK);
                        linearSystem.f199a++;
                        linearSystem.f203e++;
                        a.f252a = linearSystem.f199a;
                        linearSystem.f205g.mIndexedVariables[linearSystem.f199a] = a;
                        arrayRow2.f10988a = a;
                        m58c(arrayRow);
                        Row arrayRow3 = new ArrayRow(linearSystem.f205g);
                        arrayRow3.mo7a((Row) arrayRow2);
                        m55b(arrayRow3);
                        if (a.f253b == -1) {
                            int i5;
                            if (arrayRow2.f10988a == a) {
                                SolverVariable a2 = arrayRow2.f10991d.m40a(null, a);
                                if (a2 != null) {
                                    if (f197h != null) {
                                        Metrics metrics2 = f197h;
                                        metrics2.f221g++;
                                    }
                                    arrayRow2.m9431a(a2);
                                    arrayRow.m9429a();
                                }
                            }
                            for (int i6 = 0; i6 < linearSystem.f204f; i6++) {
                                linearSystem.f201c[i6].f10991d.m38a(a);
                            }
                            for (i5 = 0; i5 < linearSystem.f204f; i5++) {
                                ArrayRow arrayRow4 = linearSystem.f201c[i5];
                                if (arrayRow4 != arrayRow2) {
                                    arrayRow4.m9432a(arrayRow2);
                                }
                            }
                            if (!arrayRow2.f10992e) {
                                arrayRow.m9429a();
                                i5 = arrayRow2.f10988a.f259h;
                                if (i5 > 0) {
                                    int i7;
                                    while (linearSystem.f213q.length < i5) {
                                        linearSystem.f213q = new ArrayRow[(linearSystem.f213q.length * 2)];
                                    }
                                    ArrayRow[] arrayRowArr = linearSystem.f213q;
                                    for (i7 = 0; i7 < i5; i7++) {
                                        arrayRowArr[i7] = arrayRow2.f10988a.f258g[i7];
                                    }
                                    for (i7 = 0; i7 < i5; i7++) {
                                        ArrayRow arrayRow5 = arrayRowArr[i7];
                                        if (arrayRow5 != arrayRow2) {
                                            arrayRow5.f10991d.m42a(arrayRow5, arrayRow2);
                                            arrayRow5.m9429a();
                                        }
                                    }
                                }
                            }
                        }
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z = arrayRow2.f10988a != null && (arrayRow2.f10988a.f257f == Type.UNRESTRICTED || arrayRow2.f10989b >= 0.0f);
                    if (z) {
                        z = z3;
                    } else {
                        return;
                    }
                }
                return;
            }
            if (!z) {
                m58c(arrayRow);
            }
        }
    }

    private void m58c(ArrayRow arrayRow) {
        if (this.f201c[this.f204f] != null) {
            this.f205g.arrayRowPool.mo13a(this.f201c[this.f204f]);
        }
        if (!arrayRow.f10992e) {
            arrayRow.m9429a();
        }
        this.f201c[this.f204f] = arrayRow;
        arrayRow.f10988a.f253b = this.f204f;
        this.f204f++;
        int i = arrayRow.f10988a.f259h;
        if (i > 0) {
            while (this.f213q.length < i) {
                this.f213q = new ArrayRow[(this.f213q.length * 2)];
            }
            ArrayRow[] arrayRowArr = this.f213q;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                arrayRowArr[i3] = arrayRow.f10988a.f258g[i3];
            }
            while (i2 < i) {
                ArrayRow arrayRow2 = arrayRowArr[i2];
                if (arrayRow2 != arrayRow) {
                    arrayRow2.f10991d.m42a(arrayRow2, arrayRow);
                    arrayRow2.m9429a();
                }
                i2++;
            }
        }
        m57b((GoalRow) this.f200b);
    }

    private int m55b(Row row) {
        LinearSystem linearSystem = this;
        Row row2 = row;
        long j = 1;
        if (f197h != null) {
            Metrics metrics = f197h;
            metrics.f219e++;
        }
        boolean z = false;
        for (int i = 0; i < linearSystem.f203e; i++) {
            linearSystem.f209m[i] = false;
        }
        boolean z2 = true;
        boolean z3 = false;
        int i2 = z3;
        while (!z3) {
            if (f197h != null) {
                Metrics metrics2 = f197h;
                metrics2.f220f += j;
            }
            i2++;
            if (i2 >= 2 * linearSystem.f203e) {
                return i2;
            }
            if (row.mo10c() != null) {
                linearSystem.f209m[row.mo10c().f252a] = z2;
            }
            SolverVariable a = row2.mo6a(linearSystem.f209m);
            if (a != null) {
                if (linearSystem.f209m[a.f252a]) {
                    return i2;
                }
                linearSystem.f209m[a.f252a] = z2;
            }
            if (a != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                int i4 = z;
                while (i4 < linearSystem.f204f) {
                    int i5;
                    ArrayRow arrayRow = linearSystem.f201c[i4];
                    if (arrayRow.f10988a.f257f != Type.UNRESTRICTED) {
                        Object obj;
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow.f10991d;
                        if (arrayLinkedVariables.f191f != -1) {
                            int i6 = arrayLinkedVariables.f191f;
                            while (i6 != -1 && i5 < arrayLinkedVariables.f186a) {
                                if (arrayLinkedVariables.f188c[i6] == a.f252a) {
                                    obj = 1;
                                    break;
                                }
                                i6 = arrayLinkedVariables.f189d[i6];
                                i5++;
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            float c = arrayRow.f10991d.m46c(a);
                            if (c < 0.0f) {
                                float f2 = (-arrayRow.f10989b) / c;
                                if (f2 < f) {
                                    f = f2;
                                    i3 = i4;
                                }
                            }
                        }
                    }
                    i4++;
                    i5 = 0;
                }
                if (i3 >= 0) {
                    long j2;
                    ArrayRow arrayRow2 = linearSystem.f201c[i3];
                    arrayRow2.f10988a.f253b = -1;
                    if (f197h != null) {
                        Metrics metrics3 = f197h;
                        j2 = 1;
                        metrics3.f221g++;
                    } else {
                        j2 = 1;
                    }
                    arrayRow2.m9431a(a);
                    arrayRow2.m9429a();
                    arrayRow2.f10988a.f253b = i3;
                    for (int i7 = 0; i7 < linearSystem.f204f; i7++) {
                        linearSystem.f201c[i7].m9432a(arrayRow2);
                    }
                    m57b((ArrayRow) row2);
                    j = j2;
                    z = false;
                    z2 = true;
                } else {
                    System.out.println("we couldn't find an equation to pivot upon");
                    j = 1;
                    z = false;
                }
            }
            z2 = true;
            z3 = true;
        }
        return i2;
    }

    public final void m75e() {
        for (int i = 0; i < this.f204f; i++) {
            ArrayRow arrayRow = this.f201c[i];
            arrayRow.f10988a.f255d = arrayRow.f10989b;
        }
    }

    public final void m68a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow c = m72c();
        SolverVariable d = m74d();
        d.f254c = 0;
        c.m9426a(solverVariable, solverVariable2, d, i);
        if (i2 != 6) {
            m64a(c, (int) (-1082130432 * c.f10991d.m46c(d)), i2);
        }
        m63a(c);
    }

    public final void m71b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow c = m72c();
        SolverVariable d = m74d();
        d.f254c = 0;
        c.m9433b(solverVariable, solverVariable2, d, i);
        if (i2 != 6) {
            m64a(c, (int) (-1082130432 * c.f10991d.m46c(d)), i2);
        }
        m63a(c);
    }

    public final void m67a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow c = m72c();
        if (solverVariable2 == solverVariable3) {
            c.f10991d.m43a(solverVariable, 1.0f);
            c.f10991d.m43a(solverVariable4, 1.0f);
            c.f10991d.m43a(solverVariable2, (float) -1073741824);
        } else if (f == 0.5f) {
            c.f10991d.m43a(solverVariable, 1.0f);
            c.f10991d.m43a(solverVariable2, -1.0f);
            c.f10991d.m43a(solverVariable3, -1.0f);
            c.f10991d.m43a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                c.f10989b = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            c.f10991d.m43a(solverVariable, -1.0f);
            c.f10991d.m43a(solverVariable2, 1.0f);
            c.f10989b = (float) i;
        } else if (f >= 1.0f) {
            c.f10991d.m43a(solverVariable3, -1.0f);
            c.f10991d.m43a(solverVariable4, 1.0f);
            c.f10989b = (float) i2;
        } else {
            float f2 = 1.0f - f;
            c.f10991d.m43a(solverVariable, 1.0f * f2);
            c.f10991d.m43a(solverVariable2, -1.0f * f2);
            c.f10991d.m43a(solverVariable3, -1.0f * f);
            c.f10991d.m43a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                c.f10989b = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        if (i3 != 6) {
            c.m9425a(this, i3);
        }
        m63a(c);
    }

    public final void m69a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        ArrayRow c = m72c();
        c.m9427a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        m63a(c);
    }

    public final ArrayRow m73c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow c = m72c();
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            c.f10989b = (float) i;
        }
        if (obj == null) {
            c.f10991d.m43a(solverVariable, -1.0f);
            c.f10991d.m43a(solverVariable2, 1.0f);
        } else {
            c.f10991d.m43a(solverVariable, 1.0f);
            c.f10991d.m43a(solverVariable2, -1.0f);
        }
        if (i2 != 6) {
            c.m9425a(this, i2);
        }
        m63a(c);
        return c;
    }

    public final void m66a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f253b;
        ArrayRow arrayRow;
        if (solverVariable.f253b != -1) {
            arrayRow = this.f201c[i2];
            if (arrayRow.f10992e) {
                arrayRow.f10989b = (float) i;
                return;
            } else if (arrayRow.f10991d.f186a == 0) {
                arrayRow.f10992e = true;
                arrayRow.f10989b = (float) i;
                return;
            } else {
                arrayRow = m72c();
                if (i < 0) {
                    arrayRow.f10989b = (float) (-1 * i);
                    arrayRow.f10991d.m43a(solverVariable, 1.0f);
                } else {
                    arrayRow.f10989b = (float) i;
                    arrayRow.f10991d.m43a(solverVariable, -1.0f);
                }
                m63a(arrayRow);
                return;
            }
        }
        arrayRow = m72c();
        arrayRow.f10988a = solverVariable;
        i = (float) i;
        solverVariable.f255d = i;
        arrayRow.f10989b = i;
        arrayRow.f10992e = true;
        m63a(arrayRow);
    }

    public static ArrayRow m52a(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow c = linearSystem.m72c();
        if (z) {
            c.m9425a(linearSystem, false);
        }
        c.f10991d.m43a(solverVariable, (float) true);
        c.f10991d.m43a(solverVariable2, 1065353216 - f);
        c.f10991d.m43a(solverVariable3, f);
        return c;
    }
}
