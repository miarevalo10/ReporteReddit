package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;

public class ConstraintWidget {
    public static float f297Q = 0.5f;
    protected ArrayList<ConstraintAnchor> f298A = new ArrayList();
    protected DimensionBehaviour[] f299B = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
    ConstraintWidget f300C = null;
    int f301D = 0;
    int f302E = 0;
    protected float f303F = 0.0f;
    protected int f304G = -1;
    protected int f305H = 0;
    protected int f306I = 0;
    protected int f307J = 0;
    protected int f308K = 0;
    public int f309L = 0;
    protected int f310M;
    protected int f311N;
    public int f312O;
    public int f313P;
    public float f314R = f297Q;
    public float f315S = f297Q;
    public Object f316T;
    public int f317U = 0;
    public String f318V = null;
    boolean f319W;
    boolean f320X;
    public int f321Y = 0;
    public int f322Z = 0;
    private int f323a = 0;
    boolean aa;
    boolean ab;
    public float[] ac = new float[]{0.0f, 0.0f};
    protected ConstraintWidget[] ad = new ConstraintWidget[]{null, null};
    protected ConstraintWidget[] ae = new ConstraintWidget[]{null, null};
    ConstraintWidget af = null;
    ConstraintWidget ag = null;
    private int ah = 0;
    private int ai = 0;
    private int aj = 0;
    private int ak = 0;
    private String al = null;
    public int f324b = -1;
    public int f325c = -1;
    public int f326d = 0;
    public int f327e = 0;
    public int f328f = 0;
    public int f329g = 0;
    public float f330h = 1.0f;
    public int f331i = 0;
    public int f332j = 0;
    public float f333k = 1.0f;
    public boolean f334l;
    public boolean f335m;
    int f336n = -1;
    float f337o = 1.0f;
    public int[] f338p = new int[]{RedditJobManager.f10810d, RedditJobManager.f10810d};
    public float f339q = 0.0f;
    ConstraintAnchor f340r = new ConstraintAnchor(this, Type.LEFT);
    ConstraintAnchor f341s = new ConstraintAnchor(this, Type.TOP);
    ConstraintAnchor f342t = new ConstraintAnchor(this, Type.RIGHT);
    ConstraintAnchor f343u = new ConstraintAnchor(this, Type.BOTTOM);
    ConstraintAnchor f344v = new ConstraintAnchor(this, Type.BASELINE);
    ConstraintAnchor f345w = new ConstraintAnchor(this, Type.CENTER_X);
    ConstraintAnchor f346x = new ConstraintAnchor(this, Type.CENTER_Y);
    ConstraintAnchor f347y = new ConstraintAnchor(this, Type.CENTER);
    protected ConstraintAnchor[] f348z = new ConstraintAnchor[]{this.f340r, this.f342t, this.f341s, this.f343u, this.f344v, this.f347y};

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void mo3073d() {
    }

    public void mo22e() {
        this.f340r.m86c();
        this.f341s.m86c();
        this.f342t.m86c();
        this.f343u.m86c();
        this.f344v.m86c();
        this.f345w.m86c();
        this.f346x.m86c();
        this.f347y.m86c();
        this.f300C = null;
        this.f339q = 0.0f;
        this.f301D = 0;
        this.f302E = 0;
        this.f303F = 0.0f;
        this.f304G = -1;
        this.f305H = 0;
        this.f306I = 0;
        this.f323a = 0;
        this.ah = 0;
        this.ai = 0;
        this.aj = 0;
        this.f307J = 0;
        this.f308K = 0;
        this.f309L = 0;
        this.f310M = 0;
        this.f311N = 0;
        this.f312O = 0;
        this.f313P = 0;
        this.f314R = f297Q;
        this.f315S = f297Q;
        this.f299B[0] = DimensionBehaviour.FIXED;
        this.f299B[1] = DimensionBehaviour.FIXED;
        this.f316T = null;
        this.ak = 0;
        this.f317U = 0;
        this.al = null;
        this.f319W = false;
        this.f320X = false;
        this.f321Y = 0;
        this.f322Z = 0;
        this.aa = false;
        this.ab = false;
        this.ac[0] = 0.0f;
        this.ac[1] = 0.0f;
        this.f324b = -1;
        this.f325c = -1;
        this.f338p[0] = RedditJobManager.f10810d;
        this.f338p[1] = RedditJobManager.f10810d;
        this.f326d = 0;
        this.f327e = 0;
        this.f330h = 1.0f;
        this.f333k = 1.0f;
        this.f329g = RedditJobManager.f10810d;
        this.f332j = RedditJobManager.f10810d;
        this.f328f = 0;
        this.f331i = 0;
        this.f336n = -1;
        this.f337o = 1.0f;
    }

    public void mo3072b() {
        for (int i = 0; i < 6; i++) {
            this.f348z[i].f280a.m138b();
        }
    }

    public final void m110f() {
        for (int i = 0; i < 6; i++) {
            ResolutionNode resolutionNode = this.f348z[i].f280a;
            ConstraintAnchor constraintAnchor = resolutionNode.f351a.f283d;
            if (constraintAnchor != null) {
                if (constraintAnchor.f283d == resolutionNode.f351a) {
                    resolutionNode.f358h = 4;
                    constraintAnchor.f280a.f358h = 4;
                }
                int b = resolutionNode.f351a.m85b();
                if (resolutionNode.f351a.f282c == Type.RIGHT || resolutionNode.f351a.f282c == Type.BOTTOM) {
                    b = -b;
                }
                resolutionNode.m140b(constraintAnchor.f280a, b);
            }
        }
    }

    public void mo17c() {
        Optimizer.m129a(this);
    }

    public ConstraintWidget() {
        this.f298A.add(this.f340r);
        this.f298A.add(this.f341s);
        this.f298A.add(this.f342t);
        this.f298A.add(this.f343u);
        this.f298A.add(this.f345w);
        this.f298A.add(this.f346x);
        this.f298A.add(this.f347y);
        this.f298A.add(this.f344v);
    }

    public void mo20a(Cache cache) {
        this.f340r.m83a();
        this.f341s.m83a();
        this.f342t.m83a();
        this.f343u.m83a();
        this.f344v.m83a();
        this.f347y.m83a();
        this.f345w.m83a();
        this.f346x.m83a();
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (this.al != null) {
            StringBuilder stringBuilder3 = new StringBuilder("type: ");
            stringBuilder3.append(this.al);
            stringBuilder3.append(" ");
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        if (this.f318V != null) {
            stringBuilder3 = new StringBuilder("id: ");
            stringBuilder3.append(this.f318V);
            stringBuilder3.append(" ");
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append("(");
        stringBuilder2.append(this.f305H);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.f306I);
        stringBuilder2.append(") - (");
        stringBuilder2.append(this.f301D);
        stringBuilder2.append(" x ");
        stringBuilder2.append(this.f302E);
        stringBuilder2.append(") wrap: (");
        stringBuilder2.append(this.f312O);
        stringBuilder2.append(" x ");
        stringBuilder2.append(this.f313P);
        stringBuilder2.append(")");
        return stringBuilder2.toString();
    }

    public final int m112g() {
        return this.f305H;
    }

    public final int m113h() {
        return this.f306I;
    }

    public final int m114i() {
        if (this.f317U == 8) {
            return 0;
        }
        return this.f301D;
    }

    public final int m115j() {
        if (this.f317U == 8) {
            return 0;
        }
        return this.f302E;
    }

    public final int m116k() {
        return this.f323a + this.f307J;
    }

    public final int m117l() {
        return this.ah + this.f308K;
    }

    protected final int m118m() {
        return this.f305H + this.f307J;
    }

    protected final int m119n() {
        return this.f306I + this.f308K;
    }

    public final boolean m122q() {
        return this.f309L > 0;
    }

    public ArrayList<ConstraintAnchor> mo18r() {
        return this.f298A;
    }

    public final void m90a(int i) {
        this.f305H = i;
    }

    public final void m99b(int i) {
        this.f306I = i;
    }

    public final void m91a(int i, int i2) {
        this.f305H = i;
        this.f306I = i2;
    }

    public void mo21b(int i, int i2) {
        this.f307J = i;
        this.f308K = i2;
    }

    public void mo23s() {
        int i = this.f305H;
        int i2 = this.f306I;
        int i3 = this.f305H + this.f301D;
        int i4 = this.f306I + this.f302E;
        this.f323a = i;
        this.ah = i2;
        this.ai = i3 - i;
        this.aj = i4 - i2;
    }

    public final void m103c(int i) {
        this.f301D = i;
        if (this.f301D < this.f310M) {
            this.f301D = this.f310M;
        }
    }

    public final void m106d(int i) {
        this.f302E = i;
        if (this.f302E < this.f311N) {
            this.f302E = this.f311N;
        }
    }

    public final void m96a(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x008e;
    L_0x0003:
        r1 = r9.length();
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x008e;
    L_0x000b:
        r1 = -1;
        r2 = r9.length();
        r3 = 44;
        r3 = r9.indexOf(r3);
        r4 = 0;
        r5 = 1;
        if (r3 <= 0) goto L_0x0037;
    L_0x001a:
        r6 = r2 + -1;
        if (r3 >= r6) goto L_0x0037;
    L_0x001e:
        r6 = r9.substring(r4, r3);
        r7 = "W";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x002c;
    L_0x002a:
        r1 = r4;
        goto L_0x0035;
    L_0x002c:
        r4 = "H";
        r4 = r6.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0035;
    L_0x0034:
        r1 = r5;
    L_0x0035:
        r4 = r3 + 1;
    L_0x0037:
        r3 = 58;
        r3 = r9.indexOf(r3);
        if (r3 < 0) goto L_0x0075;
    L_0x003f:
        r2 = r2 - r5;
        if (r3 >= r2) goto L_0x0075;
    L_0x0042:
        r2 = r9.substring(r4, r3);
        r3 = r3 + r5;
        r9 = r9.substring(r3);
        r3 = r2.length();
        if (r3 <= 0) goto L_0x0084;
    L_0x0051:
        r3 = r9.length();
        if (r3 <= 0) goto L_0x0084;
    L_0x0057:
        r2 = java.lang.Float.parseFloat(r2);	 Catch:{ NumberFormatException -> 0x0084 }
        r9 = java.lang.Float.parseFloat(r9);	 Catch:{ NumberFormatException -> 0x0084 }
        r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0084 }
        if (r3 <= 0) goto L_0x0084;	 Catch:{ NumberFormatException -> 0x0084 }
    L_0x0063:
        r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0084 }
        if (r3 <= 0) goto L_0x0084;	 Catch:{ NumberFormatException -> 0x0084 }
    L_0x0067:
        if (r1 != r5) goto L_0x006f;	 Catch:{ NumberFormatException -> 0x0084 }
    L_0x0069:
        r9 = r9 / r2;	 Catch:{ NumberFormatException -> 0x0084 }
        r9 = java.lang.Math.abs(r9);	 Catch:{ NumberFormatException -> 0x0084 }
        goto L_0x0085;	 Catch:{ NumberFormatException -> 0x0084 }
    L_0x006f:
        r2 = r2 / r9;	 Catch:{ NumberFormatException -> 0x0084 }
        r9 = java.lang.Math.abs(r2);	 Catch:{ NumberFormatException -> 0x0084 }
        goto L_0x0085;
    L_0x0075:
        r9 = r9.substring(r4);
        r2 = r9.length();
        if (r2 <= 0) goto L_0x0084;
    L_0x007f:
        r9 = java.lang.Float.parseFloat(r9);	 Catch:{ NumberFormatException -> 0x0084 }
        goto L_0x0085;
    L_0x0084:
        r9 = r0;
    L_0x0085:
        r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x008d;
    L_0x0089:
        r8.f303F = r9;
        r8.f304G = r1;
    L_0x008d:
        return;
    L_0x008e:
        r8.f303F = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.a(java.lang.String):void");
    }

    public final void m109e(int i) {
        if (i < 0) {
            this.f310M = 0;
        } else {
            this.f310M = i;
        }
    }

    public final void m111f(int i) {
        if (i < 0) {
            this.f311N = 0;
        } else {
            this.f311N = i;
        }
    }

    public final void m104c(int i, int i2) {
        this.f305H = i;
        this.f301D = i2 - i;
        if (this.f301D < this.f310M) {
            this.f301D = this.f310M;
        }
    }

    public final void m107d(int i, int i2) {
        this.f306I = i;
        this.f302E = i2 - i;
        if (this.f302E < this.f311N) {
            this.f302E = this.f311N;
        }
    }

    public boolean mo16a() {
        return this.f317U != 8;
    }

    public final void m94a(Type type, ConstraintWidget constraintWidget, Type type2, int i, int i2) {
        mo14a(type).m84a(constraintWidget.mo14a(type2), i, i2, Strength.STRONG, 0, true);
    }

    public final void m125t() {
        int size = this.f298A.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintAnchor) this.f298A.get(i)).m86c();
        }
    }

    public ConstraintAnchor mo14a(Type type) {
        switch (type) {
            case LEFT:
                return this.f340r;
            case TOP:
                return this.f341s;
            case RIGHT:
                return this.f342t;
            case BOTTOM:
                return this.f343u;
            case BASELINE:
                return this.f344v;
            case CENTER:
                return this.f347y;
            case CENTER_X:
                return this.f345w;
            case CENTER_Y:
                return this.f346x;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final DimensionBehaviour m126u() {
        return this.f299B[0];
    }

    public final DimensionBehaviour m127v() {
        return this.f299B[1];
    }

    public final void m95a(DimensionBehaviour dimensionBehaviour) {
        this.f299B[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            m103c(this.f312O);
        }
    }

    public final void m101b(DimensionBehaviour dimensionBehaviour) {
        this.f299B[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            m106d(this.f313P);
        }
    }

    public void mo15a(LinearSystem linearSystem) {
        ConstraintWidget constraintWidget;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable a = linearSystem2.m62a(this.f340r);
        SolverVariable a2 = linearSystem2.m62a(this.f342t);
        SolverVariable a3 = linearSystem2.m62a(this.f341s);
        SolverVariable a4 = linearSystem2.m62a(this.f343u);
        SolverVariable a5 = linearSystem2.m62a(this.f344v);
        if (this.f300C != null) {
            boolean z5;
            boolean z6;
            boolean z7 = constraintWidget.f300C != null && constraintWidget.f300C.f299B[0] == DimensionBehaviour.WRAP_CONTENT;
            z = constraintWidget.f300C != null && constraintWidget.f300C.f299B[1] == DimensionBehaviour.WRAP_CONTENT;
            if ((constraintWidget.f340r.f283d == null || constraintWidget.f340r.f283d.f283d != constraintWidget.f340r) && (constraintWidget.f342t.f283d == null || constraintWidget.f342t.f283d.f283d != constraintWidget.f342t)) {
                z5 = false;
            } else {
                ((ConstraintWidgetContainer) constraintWidget.f300C).m16512a(constraintWidget, 0);
                z5 = true;
            }
            if ((constraintWidget.f341s.f283d == null || constraintWidget.f341s.f283d.f283d != constraintWidget.f341s) && (constraintWidget.f343u.f283d == null || constraintWidget.f343u.f283d.f283d != constraintWidget.f343u)) {
                z6 = false;
            } else {
                ((ConstraintWidgetContainer) constraintWidget.f300C).m16512a(constraintWidget, 1);
                z6 = true;
            }
            if (z7 && constraintWidget.f317U != 8 && constraintWidget.f340r.f283d == null && constraintWidget.f342t.f283d == null) {
                linearSystem2.m68a(linearSystem2.m62a(constraintWidget.f300C.f342t), a2, 0, 1);
            }
            if (z && constraintWidget.f317U != 8 && constraintWidget.f341s.f283d == null && constraintWidget.f343u.f283d == null && constraintWidget.f344v == null) {
                linearSystem2.m68a(linearSystem2.m62a(constraintWidget.f300C.f343u), a4, 0, 1);
            }
            z2 = z;
            z3 = z5;
            z4 = z6;
            z = z7;
        } else {
            z = false;
            z3 = z;
            z2 = z3;
            z4 = z2;
        }
        int i4 = constraintWidget.f301D;
        if (i4 < constraintWidget.f310M) {
            i4 = constraintWidget.f310M;
        }
        int i5 = constraintWidget.f302E;
        if (i5 < constraintWidget.f311N) {
            i5 = constraintWidget.f311N;
        }
        int i6 = constraintWidget.f299B[0] != DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        int i7 = constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        constraintWidget.f336n = constraintWidget.f304G;
        constraintWidget.f337o = constraintWidget.f303F;
        if (constraintWidget.f303F <= 0.0f || constraintWidget.f317U == 8) {
            i = i4;
            i2 = i5;
            i3 = 0;
        } else {
            if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f299B[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (constraintWidget.f326d == 0) {
                    constraintWidget.f326d = 3;
                }
                if (constraintWidget.f327e == 0) {
                    constraintWidget.f327e = 3;
                }
                if (constraintWidget.f336n == -1) {
                    if (i6 != 0 && i7 == 0) {
                        constraintWidget.f336n = 0;
                    } else if (i6 == 0 && i7 != 0) {
                        constraintWidget.f336n = 1;
                        if (constraintWidget.f304G == -1) {
                            constraintWidget.f337o = 1.0f / constraintWidget.f337o;
                        }
                    }
                }
                if (constraintWidget.f336n == 0 && (!constraintWidget.f341s.m87d() || !constraintWidget.f343u.m87d())) {
                    constraintWidget.f336n = 1;
                } else if (constraintWidget.f336n == 1 && !(constraintWidget.f340r.m87d() && constraintWidget.f342t.m87d())) {
                    constraintWidget.f336n = 0;
                }
                if (constraintWidget.f336n == -1 && !(constraintWidget.f341s.m87d() && constraintWidget.f343u.m87d() && constraintWidget.f340r.m87d() && constraintWidget.f342t.m87d())) {
                    if (constraintWidget.f341s.m87d() && constraintWidget.f343u.m87d()) {
                        constraintWidget.f336n = 0;
                    } else if (constraintWidget.f340r.m87d() && constraintWidget.f342t.m87d()) {
                        constraintWidget.f337o = 1.0f / constraintWidget.f337o;
                        constraintWidget.f336n = 1;
                    }
                }
                if (constraintWidget.f336n == -1) {
                    if (z && !z2) {
                        constraintWidget.f336n = 0;
                    } else if (!z && z2) {
                        constraintWidget.f337o = 1.0f / constraintWidget.f337o;
                        constraintWidget.f336n = 1;
                    }
                }
                if (constraintWidget.f336n == -1) {
                    if (constraintWidget.f328f <= 0 || constraintWidget.f331i != 0) {
                        constraintWidget.f337o = 1.0f / constraintWidget.f337o;
                        constraintWidget.f336n = 1;
                    } else {
                        constraintWidget.f336n = 0;
                    }
                }
            } else if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.f336n = 0;
                i4 = (int) (constraintWidget.f337o * ((float) constraintWidget.f302E));
            } else if (constraintWidget.f299B[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.f336n = 1;
                if (constraintWidget.f304G == -1) {
                    constraintWidget.f337o = 1.0f / constraintWidget.f337o;
                }
                i = i4;
                i2 = (int) (constraintWidget.f337o * ((float) constraintWidget.f301D));
                i3 = 1;
            }
            i = i4;
            i2 = i5;
            i3 = 1;
        }
        boolean z8 = i3 != 0 && (constraintWidget.f336n == 0 || constraintWidget.f336n == -1);
        boolean z9 = constraintWidget.f299B[0] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget instanceof ConstraintWidgetContainer);
        boolean d = constraintWidget.f347y.m87d() ^ 1;
        if (constraintWidget.f324b != 2) {
            solverVariable = a5;
            solverVariable2 = a4;
            solverVariable3 = a3;
            solverVariable4 = a2;
            m88a(linearSystem2, z, constraintWidget.f300C != null ? linearSystem2.m62a(constraintWidget.f300C.f340r) : null, constraintWidget.f300C != null ? linearSystem2.m62a(constraintWidget.f300C.f342t) : null, constraintWidget.f299B[0], z9, constraintWidget.f340r, constraintWidget.f342t, constraintWidget.f305H, i, constraintWidget.f310M, constraintWidget.f338p[0], constraintWidget.f314R, z8, z3, constraintWidget.f326d, constraintWidget.f328f, constraintWidget.f329g, constraintWidget.f330h, d);
            constraintWidget = this;
        } else {
            solverVariable = a5;
            solverVariable2 = a4;
            solverVariable3 = a3;
            solverVariable4 = a2;
        }
        if (constraintWidget.f325c != 2) {
            LinearSystem linearSystem3;
            boolean z10;
            int i8;
            SolverVariable solverVariable5;
            ConstraintWidget constraintWidget2;
            ConstraintWidget constraintWidget3;
            float toRadians;
            int b;
            LinearSystem linearSystem4;
            SolverVariable a6;
            SolverVariable a7;
            SolverVariable a8;
            SolverVariable a9;
            ArrayRow c;
            double d2;
            double d3;
            SolverVariable solverVariable6;
            z9 = constraintWidget.f299B[1] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget instanceof ConstraintWidgetContainer);
            z3 = i3 != 0 && (constraintWidget.f336n == 1 || constraintWidget.f336n == -1);
            if (constraintWidget.f309L <= 0) {
                a3 = solverVariable3;
                linearSystem3 = linearSystem;
            } else if (constraintWidget.f344v.f280a.f359i == 1) {
                linearSystem3 = linearSystem;
                constraintWidget.f344v.f280a.m134a(linearSystem3);
                a3 = solverVariable3;
            } else {
                linearSystem3 = linearSystem;
                SolverVariable solverVariable7 = solverVariable;
                a3 = solverVariable3;
                linearSystem3.m73c(solverVariable7, a3, constraintWidget.f309L, 6);
                if (constraintWidget.f344v.f283d != null) {
                    linearSystem3.m73c(solverVariable7, linearSystem3.m62a(constraintWidget.f344v.f283d), 0, 6);
                    z10 = false;
                    i8 = i2;
                    solverVariable5 = a3;
                    constraintWidget.m88a(linearSystem3, z2, constraintWidget.f300C == null ? linearSystem3.m62a(constraintWidget.f300C.f341s) : null, constraintWidget.f300C == null ? linearSystem3.m62a(constraintWidget.f300C.f343u) : null, constraintWidget.f299B[1], z9, constraintWidget.f341s, constraintWidget.f343u, constraintWidget.f306I, i8, constraintWidget.f311N, constraintWidget.f338p[1], constraintWidget.f315S, z3, z4, constraintWidget.f327e, constraintWidget.f331i, constraintWidget.f332j, constraintWidget.f333k, z10);
                    if (i3 != 0) {
                        constraintWidget2 = this;
                    } else if (this.f336n != 1) {
                        linearSystem.m69a(solverVariable2, solverVariable5, solverVariable4, a, constraintWidget2.f337o);
                    } else {
                        linearSystem.m69a(solverVariable4, a, solverVariable2, solverVariable5, constraintWidget2.f337o);
                    }
                    if (constraintWidget2.f347y.m87d()) {
                        constraintWidget3 = constraintWidget2.f347y.f283d.f281b;
                        toRadians = (float) Math.toRadians((double) (constraintWidget2.f339q + 90.0f));
                        b = constraintWidget2.f347y.m85b();
                        linearSystem4 = linearSystem;
                        a6 = linearSystem4.m62a(constraintWidget2.mo14a(Type.LEFT));
                        a5 = linearSystem4.m62a(constraintWidget2.mo14a(Type.TOP));
                        a7 = linearSystem4.m62a(constraintWidget2.mo14a(Type.RIGHT));
                        a4 = linearSystem4.m62a(constraintWidget2.mo14a(Type.BOTTOM));
                        a8 = linearSystem4.m62a(constraintWidget3.mo14a(Type.LEFT));
                        a3 = linearSystem4.m62a(constraintWidget3.mo14a(Type.TOP));
                        a9 = linearSystem4.m62a(constraintWidget3.mo14a(Type.RIGHT));
                        a2 = linearSystem4.m62a(constraintWidget3.mo14a(Type.BOTTOM));
                        c = linearSystem.m72c();
                        d2 = (double) toRadians;
                        d3 = (double) b;
                        solverVariable6 = a9;
                        c.m9434b(a5, a4, a3, a2, (float) (Math.sin(d2) * d3));
                        linearSystem4.m63a(c);
                        c = linearSystem.m72c();
                        c.m9434b(a6, a7, a8, solverVariable6, (float) (Math.cos(d2) * d3));
                        linearSystem4.m63a(c);
                    }
                }
            }
            z10 = d;
            if (constraintWidget.f300C == null) {
            }
            if (constraintWidget.f300C == null) {
            }
            i8 = i2;
            solverVariable5 = a3;
            constraintWidget.m88a(linearSystem3, z2, constraintWidget.f300C == null ? linearSystem3.m62a(constraintWidget.f300C.f341s) : null, constraintWidget.f300C == null ? linearSystem3.m62a(constraintWidget.f300C.f343u) : null, constraintWidget.f299B[1], z9, constraintWidget.f341s, constraintWidget.f343u, constraintWidget.f306I, i8, constraintWidget.f311N, constraintWidget.f338p[1], constraintWidget.f315S, z3, z4, constraintWidget.f327e, constraintWidget.f331i, constraintWidget.f332j, constraintWidget.f333k, z10);
            if (i3 != 0) {
                constraintWidget2 = this;
            } else if (this.f336n != 1) {
                linearSystem.m69a(solverVariable4, a, solverVariable2, solverVariable5, constraintWidget2.f337o);
            } else {
                linearSystem.m69a(solverVariable2, solverVariable5, solverVariable4, a, constraintWidget2.f337o);
            }
            if (constraintWidget2.f347y.m87d()) {
                constraintWidget3 = constraintWidget2.f347y.f283d.f281b;
                toRadians = (float) Math.toRadians((double) (constraintWidget2.f339q + 90.0f));
                b = constraintWidget2.f347y.m85b();
                linearSystem4 = linearSystem;
                a6 = linearSystem4.m62a(constraintWidget2.mo14a(Type.LEFT));
                a5 = linearSystem4.m62a(constraintWidget2.mo14a(Type.TOP));
                a7 = linearSystem4.m62a(constraintWidget2.mo14a(Type.RIGHT));
                a4 = linearSystem4.m62a(constraintWidget2.mo14a(Type.BOTTOM));
                a8 = linearSystem4.m62a(constraintWidget3.mo14a(Type.LEFT));
                a3 = linearSystem4.m62a(constraintWidget3.mo14a(Type.TOP));
                a9 = linearSystem4.m62a(constraintWidget3.mo14a(Type.RIGHT));
                a2 = linearSystem4.m62a(constraintWidget3.mo14a(Type.BOTTOM));
                c = linearSystem.m72c();
                d2 = (double) toRadians;
                d3 = (double) b;
                solverVariable6 = a9;
                c.m9434b(a5, a4, a3, a2, (float) (Math.sin(d2) * d3));
                linearSystem4.m63a(c);
                c = linearSystem.m72c();
                c.m9434b(a6, a7, a8, solverVariable6, (float) (Math.cos(d2) * d3));
                linearSystem4.m63a(c);
            }
        }
    }

    private void m88a(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        ConstraintWidget constraintWidget = this;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariable3 = solverVariable;
        SolverVariable solverVariable4 = solverVariable2;
        Object obj = constraintAnchor;
        Object obj2 = constraintAnchor2;
        int i8 = i3;
        int i9 = i4;
        SolverVariable a = linearSystem2.m62a(obj);
        SolverVariable a2 = linearSystem2.m62a(obj2);
        SolverVariable a3 = linearSystem2.m62a(obj.f283d);
        SolverVariable a4 = linearSystem2.m62a(obj2.f283d);
        if (linearSystem2.f202d && obj.f280a.f359i == 1 && obj2.f280a.f359i == 1) {
            if (LinearSystem.m53a() != null) {
                Metrics a5 = LinearSystem.m53a();
                a5.f230p++;
            }
            obj.f280a.m134a(linearSystem2);
            obj2.f280a.m134a(linearSystem2);
            if (!z4 && z) {
                linearSystem2.m68a(solverVariable4, a2, 0, 6);
            }
            return;
        }
        Object obj3;
        int i10;
        boolean z6;
        int i11;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        SolverVariable a6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i17;
        int i18;
        int i19;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        if (LinearSystem.m53a() != null) {
            a5 = LinearSystem.m53a();
            a5.f239y++;
        }
        boolean d = constraintAnchor.m87d();
        boolean d2 = constraintAnchor2.m87d();
        boolean d3 = constraintWidget.f347y.m87d();
        int i20 = d ? 1 : 0;
        if (d2) {
            i20++;
        }
        if (d3) {
            i20++;
        }
        int i21 = z3 ? 3 : i5;
        switch (dimensionBehaviour) {
            case MATCH_CONSTRAINT:
                obj3 = 1;
                break;
            default:
                obj3 = null;
                break;
        }
        int i22 = i20;
        if (constraintWidget.f317U == 8) {
            i10 = 0;
            obj3 = null;
        } else {
            i10 = i2;
        }
        if (z5) {
            if (!d && !d2 && !d3) {
                linearSystem2.m66a(a, i);
            } else if (d && !d2) {
                z6 = d3;
                i11 = 6;
                linearSystem2.m73c(a, a3, constraintAnchor.m85b(), 6);
                if (obj3 != null) {
                    if (z2) {
                        linearSystem2.m73c(a2, a, i10, i11);
                    } else {
                        linearSystem2.m73c(a2, a, 0, 3);
                        if (i8 <= 0) {
                            i20 = 6;
                            linearSystem2.m68a(a2, a, i8, 6);
                        } else {
                            i20 = 6;
                        }
                        if (i9 < RedditJobManager.f10810d) {
                            linearSystem2.m71b(a2, a, i9, i20);
                        }
                    }
                    i11 = i7;
                    solverVariable5 = a3;
                    solverVariable6 = a4;
                    i12 = i21;
                    i13 = i22;
                    i10 = 2;
                    i14 = 4;
                    i15 = i6;
                } else {
                    i20 = i11;
                    i11 = i6;
                    if (i11 != -2) {
                        i11 = i7;
                        i20 = i10;
                    } else {
                        i20 = i11;
                        i11 = i7;
                    }
                    if (i11 == -2) {
                        i11 = i10;
                    }
                    if (i20 <= 0) {
                        i9 = 6;
                        linearSystem2.m68a(a2, a, i20, 6);
                        i10 = Math.max(i10, i20);
                    } else {
                        i9 = 6;
                    }
                    if (i11 > 0) {
                        if (z) {
                            linearSystem2.m71b(a2, a, i11, i9);
                        } else {
                            linearSystem2.m71b(a2, a, i11, 1);
                        }
                        i10 = Math.min(i10, i11);
                    }
                    solverVariable5 = a3;
                    i9 = i10;
                    i10 = i21;
                    if (i10 == 1) {
                        if (z) {
                            linearSystem2.m73c(a2, a, i9, 6);
                        } else if (z4) {
                            linearSystem2.m73c(a2, a, i9, 1);
                        } else {
                            linearSystem2.m73c(a2, a, i9, 4);
                            i12 = i10;
                            solverVariable6 = a4;
                            i13 = i22;
                            i10 = 2;
                            i14 = 4;
                        }
                        i12 = i10;
                        i15 = i20;
                        solverVariable6 = a4;
                        i13 = i22;
                        i10 = 2;
                        i14 = 4;
                        if (!(obj3 == null || r13 == r14 || z3)) {
                            i9 = Math.max(i15, i9);
                            if (i11 > 0) {
                                i9 = Math.min(i11, i9);
                            }
                            linearSystem2.m73c(a2, a, i9, 6);
                            obj3 = null;
                        }
                    } else if (i10 != 2) {
                        i16 = i20;
                        if (obj.f282c != Type.TOP) {
                            if (obj.f282c == Type.BOTTOM) {
                                SolverVariable a7 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.LEFT));
                                a6 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.RIGHT));
                                solverVariable7 = a7;
                                i12 = i10;
                                solverVariable6 = a4;
                                i13 = i22;
                                i15 = i16;
                                i10 = 2;
                                i14 = 4;
                                linearSystem2.m63a(linearSystem.m72c().m9427a(a2, a, a6, solverVariable7, f2));
                                obj3 = null;
                                i9 = Math.max(i15, i9);
                                if (i11 > 0) {
                                    i9 = Math.min(i11, i9);
                                }
                                linearSystem2.m73c(a2, a, i9, 6);
                                obj3 = null;
                            }
                        }
                        a3 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.TOP));
                        a6 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.BOTTOM));
                        solverVariable7 = a3;
                        i12 = i10;
                        solverVariable6 = a4;
                        i13 = i22;
                        i15 = i16;
                        i10 = 2;
                        i14 = 4;
                        linearSystem2.m63a(linearSystem.m72c().m9427a(a2, a, a6, solverVariable7, f2));
                        obj3 = null;
                        i9 = Math.max(i15, i9);
                        if (i11 > 0) {
                            i9 = Math.min(i11, i9);
                        }
                        linearSystem2.m73c(a2, a, i9, 6);
                        obj3 = null;
                    } else {
                        i12 = i10;
                        solverVariable6 = a4;
                        i13 = i22;
                        i14 = 4;
                        i10 = 2;
                    }
                    i15 = i20;
                    i9 = Math.max(i15, i9);
                    if (i11 > 0) {
                        i9 = Math.min(i11, i9);
                    }
                    linearSystem2.m73c(a2, a, i9, 6);
                    obj3 = null;
                }
                if (z5) {
                    if (z4) {
                        i20 = 5;
                        if (!d || d2 || r24) {
                            solverVariable8 = solverVariable2;
                            if (d || d2) {
                                if (d && d2) {
                                    linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), 6);
                                    if (z) {
                                        linearSystem2.m68a(a, solverVariable, 0, 5);
                                    }
                                } else {
                                    i17 = 1;
                                    if (d && d2) {
                                        if (obj3 == null) {
                                            if (z || i8 != 0) {
                                                i8 = 6;
                                            } else {
                                                i8 = 6;
                                                linearSystem2.m68a(a2, a, 0, 6);
                                            }
                                            if (i12 != 0) {
                                                if (i11 <= 0) {
                                                    if (i15 > 0) {
                                                        i18 = i8;
                                                        i19 = 0;
                                                        solverVariable9 = solverVariable5;
                                                        linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                                                        linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                                                        if (i11 <= 0) {
                                                            if (i15 <= 0) {
                                                                i18 = 0;
                                                                i17 = i18;
                                                                i11 = i19;
                                                            }
                                                        }
                                                        i18 = 1;
                                                        i17 = i18;
                                                        i11 = i19;
                                                    }
                                                }
                                                i19 = 1;
                                                i18 = i14;
                                                solverVariable9 = solverVariable5;
                                                linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                                                linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                                                if (i11 <= 0) {
                                                    if (i15 <= 0) {
                                                        i18 = 0;
                                                        i17 = i18;
                                                        i11 = i19;
                                                    }
                                                }
                                                i18 = 1;
                                                i17 = i18;
                                                i11 = i19;
                                            } else {
                                                solverVariable9 = solverVariable5;
                                                i10 = i12;
                                                if (i10 == 1) {
                                                    i20 = i8;
                                                } else if (i10 != 3) {
                                                    i18 = z3 ? 5 : i14;
                                                    linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                                                    linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                                                } else {
                                                    i17 = 0;
                                                }
                                                i11 = i17;
                                            }
                                        } else {
                                            solverVariable9 = solverVariable5;
                                            i8 = 6;
                                            if (z) {
                                                linearSystem2.m68a(a, solverVariable9, constraintAnchor.m85b(), 5);
                                                linearSystem2.m71b(a2, solverVariable6, -constraintAnchor2.m85b(), 5);
                                            }
                                            i11 = 0;
                                        }
                                        if (i17 == 0) {
                                            SolverVariable solverVariable12 = solverVariable9;
                                            int i23 = i8;
                                            i13 = 0;
                                            solverVariable9 = solverVariable12;
                                            solverVariable8 = a2;
                                            solverVariable10 = a;
                                            linearSystem2.m67a(a, solverVariable9, constraintAnchor.m85b(), f, solverVariable6, a2, constraintAnchor2.m85b(), i20);
                                        } else {
                                            solverVariable8 = a2;
                                            solverVariable10 = a;
                                        }
                                        if (i11 != 0) {
                                            i8 = 6;
                                            linearSystem2.m68a(solverVariable10, solverVariable9, constraintAnchor.m85b(), 6);
                                            linearSystem2.m71b(solverVariable8, solverVariable6, -constraintAnchor2.m85b(), 6);
                                            if (z) {
                                                linearSystem2.m68a(solverVariable2, solverVariable8, 0, i8);
                                            }
                                            return;
                                        }
                                        i8 = 6;
                                        if (z) {
                                            linearSystem2.m68a(solverVariable2, solverVariable8, 0, i8);
                                        }
                                        return;
                                    }
                                }
                            } else if (z) {
                                linearSystem2.m68a(solverVariable8, a2, 0, 5);
                            }
                        } else if (z) {
                            linearSystem2.m68a(solverVariable2, a2, 0, 5);
                        }
                        solverVariable8 = a2;
                        i8 = 6;
                        if (z) {
                            linearSystem2.m68a(solverVariable2, solverVariable8, 0, i8);
                        }
                        return;
                    }
                }
                solverVariable11 = a;
                i20 = i13;
                solverVariable6 = solverVariable;
                solverVariable3 = solverVariable2;
                solverVariable8 = a2;
                if (i20 < i10 && z) {
                    linearSystem2.m68a(solverVariable11, solverVariable6, 0, 6);
                    linearSystem2.m68a(solverVariable3, solverVariable8, 0, 6);
                }
            }
        }
        z6 = d3;
        i11 = 6;
        if (obj3 != null) {
            i20 = i11;
            i11 = i6;
            if (i11 != -2) {
                i20 = i11;
                i11 = i7;
            } else {
                i11 = i7;
                i20 = i10;
            }
            if (i11 == -2) {
                i11 = i10;
            }
            if (i20 <= 0) {
                i9 = 6;
            } else {
                i9 = 6;
                linearSystem2.m68a(a2, a, i20, 6);
                i10 = Math.max(i10, i20);
            }
            if (i11 > 0) {
                if (z) {
                    linearSystem2.m71b(a2, a, i11, i9);
                } else {
                    linearSystem2.m71b(a2, a, i11, 1);
                }
                i10 = Math.min(i10, i11);
            }
            solverVariable5 = a3;
            i9 = i10;
            i10 = i21;
            if (i10 == 1) {
                if (z) {
                    linearSystem2.m73c(a2, a, i9, 6);
                } else if (z4) {
                    linearSystem2.m73c(a2, a, i9, 1);
                } else {
                    linearSystem2.m73c(a2, a, i9, 4);
                    i12 = i10;
                    solverVariable6 = a4;
                    i13 = i22;
                    i10 = 2;
                    i14 = 4;
                }
                i12 = i10;
                i15 = i20;
                solverVariable6 = a4;
                i13 = i22;
                i10 = 2;
                i14 = 4;
                i9 = Math.max(i15, i9);
                if (i11 > 0) {
                    i9 = Math.min(i11, i9);
                }
                linearSystem2.m73c(a2, a, i9, 6);
                obj3 = null;
            } else if (i10 != 2) {
                i12 = i10;
                solverVariable6 = a4;
                i13 = i22;
                i14 = 4;
                i10 = 2;
            } else {
                i16 = i20;
                if (obj.f282c != Type.TOP) {
                    if (obj.f282c == Type.BOTTOM) {
                        SolverVariable a72 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.LEFT));
                        a6 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.RIGHT));
                        solverVariable7 = a72;
                        i12 = i10;
                        solverVariable6 = a4;
                        i13 = i22;
                        i15 = i16;
                        i10 = 2;
                        i14 = 4;
                        linearSystem2.m63a(linearSystem.m72c().m9427a(a2, a, a6, solverVariable7, f2));
                        obj3 = null;
                        i9 = Math.max(i15, i9);
                        if (i11 > 0) {
                            i9 = Math.min(i11, i9);
                        }
                        linearSystem2.m73c(a2, a, i9, 6);
                        obj3 = null;
                    }
                }
                a3 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.TOP));
                a6 = linearSystem2.m62a(constraintWidget.f300C.mo14a(Type.BOTTOM));
                solverVariable7 = a3;
                i12 = i10;
                solverVariable6 = a4;
                i13 = i22;
                i15 = i16;
                i10 = 2;
                i14 = 4;
                linearSystem2.m63a(linearSystem.m72c().m9427a(a2, a, a6, solverVariable7, f2));
                obj3 = null;
                i9 = Math.max(i15, i9);
                if (i11 > 0) {
                    i9 = Math.min(i11, i9);
                }
                linearSystem2.m73c(a2, a, i9, 6);
                obj3 = null;
            }
            i15 = i20;
            i9 = Math.max(i15, i9);
            if (i11 > 0) {
                i9 = Math.min(i11, i9);
            }
            linearSystem2.m73c(a2, a, i9, 6);
            obj3 = null;
        } else {
            if (z2) {
                linearSystem2.m73c(a2, a, i10, i11);
            } else {
                linearSystem2.m73c(a2, a, 0, 3);
                if (i8 <= 0) {
                    i20 = 6;
                } else {
                    i20 = 6;
                    linearSystem2.m68a(a2, a, i8, 6);
                }
                if (i9 < RedditJobManager.f10810d) {
                    linearSystem2.m71b(a2, a, i9, i20);
                }
            }
            i11 = i7;
            solverVariable5 = a3;
            solverVariable6 = a4;
            i12 = i21;
            i13 = i22;
            i10 = 2;
            i14 = 4;
            i15 = i6;
        }
        if (z5) {
            if (z4) {
                i20 = 5;
                if (d) {
                }
                solverVariable8 = solverVariable2;
                if (d) {
                }
                if (d) {
                }
                i17 = 1;
                if (obj3 == null) {
                    solverVariable9 = solverVariable5;
                    i8 = 6;
                    if (z) {
                        linearSystem2.m68a(a, solverVariable9, constraintAnchor.m85b(), 5);
                        linearSystem2.m71b(a2, solverVariable6, -constraintAnchor2.m85b(), 5);
                    }
                    i11 = 0;
                } else {
                    if (z) {
                    }
                    i8 = 6;
                    if (i12 != 0) {
                        solverVariable9 = solverVariable5;
                        i10 = i12;
                        if (i10 == 1) {
                            i20 = i8;
                        } else if (i10 != 3) {
                            i17 = 0;
                        } else {
                            if (z3) {
                            }
                            linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                            linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                        }
                        i11 = i17;
                    } else {
                        if (i11 <= 0) {
                            if (i15 > 0) {
                                i18 = i8;
                                i19 = 0;
                                solverVariable9 = solverVariable5;
                                linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                                linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                                if (i11 <= 0) {
                                    if (i15 <= 0) {
                                        i18 = 0;
                                        i17 = i18;
                                        i11 = i19;
                                    }
                                }
                                i18 = 1;
                                i17 = i18;
                                i11 = i19;
                            }
                        }
                        i19 = 1;
                        i18 = i14;
                        solverVariable9 = solverVariable5;
                        linearSystem2.m73c(a, solverVariable9, constraintAnchor.m85b(), i18);
                        linearSystem2.m73c(a2, solverVariable6, -constraintAnchor2.m85b(), i18);
                        if (i11 <= 0) {
                            if (i15 <= 0) {
                                i18 = 0;
                                i17 = i18;
                                i11 = i19;
                            }
                        }
                        i18 = 1;
                        i17 = i18;
                        i11 = i19;
                    }
                }
                if (i17 == 0) {
                    solverVariable8 = a2;
                    solverVariable10 = a;
                } else {
                    SolverVariable solverVariable122 = solverVariable9;
                    int i232 = i8;
                    i13 = 0;
                    solverVariable9 = solverVariable122;
                    solverVariable8 = a2;
                    solverVariable10 = a;
                    linearSystem2.m67a(a, solverVariable9, constraintAnchor.m85b(), f, solverVariable6, a2, constraintAnchor2.m85b(), i20);
                }
                if (i11 != 0) {
                    i8 = 6;
                    linearSystem2.m68a(solverVariable10, solverVariable9, constraintAnchor.m85b(), 6);
                    linearSystem2.m71b(solverVariable8, solverVariable6, -constraintAnchor2.m85b(), 6);
                    if (z) {
                        linearSystem2.m68a(solverVariable2, solverVariable8, 0, i8);
                    }
                    return;
                }
                i8 = 6;
                if (z) {
                    linearSystem2.m68a(solverVariable2, solverVariable8, 0, i8);
                }
                return;
            }
        }
        solverVariable11 = a;
        i20 = i13;
        solverVariable6 = solverVariable;
        solverVariable3 = solverVariable2;
        solverVariable8 = a2;
        linearSystem2.m68a(solverVariable11, solverVariable6, 0, 6);
        linearSystem2.m68a(solverVariable3, solverVariable8, 0, 6);
    }

    public void mo19w() {
        int b = LinearSystem.m56b(this.f340r);
        int b2 = LinearSystem.m56b(this.f341s);
        int b3 = LinearSystem.m56b(this.f342t) - b;
        int b4 = LinearSystem.m56b(this.f343u) - b2;
        this.f305H = b;
        this.f306I = b2;
        if (this.f317U == 8) {
            this.f301D = 0;
            this.f302E = 0;
            return;
        }
        if (this.f299B[0] == DimensionBehaviour.FIXED && b3 < this.f301D) {
            b3 = this.f301D;
        }
        if (this.f299B[1] == DimensionBehaviour.FIXED && b4 < this.f302E) {
            b4 = this.f302E;
        }
        this.f301D = b3;
        this.f302E = b4;
        if (this.f302E < this.f311N) {
            this.f302E = this.f311N;
        }
        if (this.f301D < this.f310M) {
            this.f301D = this.f310M;
        }
    }

    public final int m120o() {
        return this.f305H + this.f301D;
    }

    public final int m121p() {
        return this.f306I + this.f302E;
    }
}
