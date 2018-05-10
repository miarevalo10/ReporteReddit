package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.io.PrintStream;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    public boolean f16396a = false;
    protected LinearSystem ah = new LinearSystem();
    int ai;
    int aj;
    int ak;
    int al;
    int am = 0;
    int an = 0;
    ConstraintWidget[] ao = new ConstraintWidget[4];
    ConstraintWidget[] ap = new ConstraintWidget[4];
    public int aq = 3;
    public boolean ar = false;
    public boolean as = false;
    int at = 0;
    private Snapshot av;

    public final boolean m16515g(int i) {
        return (this.aq & i) == i;
    }

    public final void mo22e() {
        this.ah.m70b();
        this.ai = 0;
        this.ak = 0;
        this.aj = 0;
        this.al = 0;
        super.mo22e();
    }

    private void m16511a(boolean[] zArr) {
        zArr[2] = false;
        mo19w();
        int size = this.au.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.au.get(i);
            constraintWidget.mo19w();
            if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m114i() < constraintWidget.f312O) {
                zArr[2] = true;
            }
            if (constraintWidget.f299B[1] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m115j() < constraintWidget.f313P) {
                zArr[2] = true;
            }
        }
    }

    public final void mo17c() {
        super.mo17c();
        int size = this.au.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.au.get(i)).mo17c();
        }
    }

    public final void mo3074x() {
        int size;
        int i;
        int i2;
        boolean z;
        Exception e;
        int i3;
        int i4;
        Exception exception;
        int i5;
        PrintStream printStream;
        StringBuilder stringBuilder;
        ConstraintWidget constraintWidget;
        boolean z2;
        boolean z3;
        int i6 = this.H;
        int i7 = this.I;
        boolean z4 = false;
        int max = Math.max(0, m114i());
        int max2 = Math.max(0, m115j());
        this.ar = false;
        this.as = false;
        if (this.C != null) {
            if (r1.av == null) {
                r1.av = new Snapshot(r1);
            }
            Snapshot snapshot = r1.av;
            snapshot.f367a = m112g();
            snapshot.f368b = m113h();
            snapshot.f369c = m114i();
            snapshot.f370d = m115j();
            size = snapshot.f371e.size();
            for (i = 0; i < size; i++) {
                Connection connection = (Connection) snapshot.f371e.get(i);
                connection.f362a = mo14a(connection.f362a.f282c);
                if (connection.f362a != null) {
                    connection.f363b = connection.f362a.f283d;
                    connection.f364c = connection.f362a.m85b();
                    connection.f365d = connection.f362a.f286g;
                    connection.f366e = connection.f362a.f287h;
                } else {
                    connection.f363b = null;
                    connection.f364c = 0;
                    connection.f365d = Strength.STRONG;
                    connection.f366e = 0;
                }
            }
            m90a(r1.ai);
            m99b(r1.aj);
            m125t();
            mo20a(r1.ah.f205g);
        } else {
            r1.H = 0;
            r1.I = 0;
        }
        size = 1;
        if (r1.aq != 0) {
            int size2 = r1.au.size();
            mo3072b();
            for (i = 0; i < size2; i++) {
                ((ConstraintWidget) r1.au.get(i)).mo3072b();
            }
            mo17c();
            ResolutionNode resolutionNode = mo14a(Type.LEFT).f280a;
            ResolutionNode resolutionNode2 = mo14a(Type.TOP).f280a;
            resolutionNode.m136a(null, 0.0f);
            resolutionNode2.m136a(null, 0.0f);
            r1.ah.f202d = true;
        } else {
            r1.ah.f202d = false;
        }
        DimensionBehaviour dimensionBehaviour = r1.B[1];
        DimensionBehaviour dimensionBehaviour2 = r1.B[0];
        r1.am = 0;
        r1.an = 0;
        i = r1.au.size();
        for (i2 = 0; i2 < i; i2++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) r1.au.get(i2);
            if (constraintWidget2 instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget2).mo3074x();
            }
        }
        int i8 = 0;
        boolean z5 = i8;
        i2 = 1;
        while (i2 != 0) {
            ConstraintWidget constraintWidget3;
            int i9;
            boolean z6;
            i8 += size;
            try {
                r1.ah.m70b();
                LinearSystem linearSystem = r1.ah;
                mo15a(linearSystem);
                int size3 = r1.au.size();
                size = z4;
                while (size < size3) {
                    try {
                        constraintWidget3 = (ConstraintWidget) r1.au.get(size);
                        i9 = i2;
                        try {
                            int i10;
                            if (constraintWidget3 instanceof ConstraintWidgetContainer) {
                                DimensionBehaviour dimensionBehaviour3 = constraintWidget3.f299B[0];
                                i10 = size3;
                                DimensionBehaviour dimensionBehaviour4 = constraintWidget3.f299B[1];
                                z = z5;
                                try {
                                    if (dimensionBehaviour3 == DimensionBehaviour.WRAP_CONTENT) {
                                        constraintWidget3.m95a(DimensionBehaviour.FIXED);
                                    }
                                    if (dimensionBehaviour4 == DimensionBehaviour.WRAP_CONTENT) {
                                        constraintWidget3.m101b(DimensionBehaviour.FIXED);
                                    }
                                    constraintWidget3.mo15a(linearSystem);
                                    if (dimensionBehaviour3 == DimensionBehaviour.WRAP_CONTENT) {
                                        constraintWidget3.m95a(dimensionBehaviour3);
                                    }
                                    if (dimensionBehaviour4 == DimensionBehaviour.WRAP_CONTENT) {
                                        constraintWidget3.m101b(dimensionBehaviour4);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } else {
                                z = z5;
                                i10 = size3;
                                Optimizer.m130a(r1, linearSystem, constraintWidget3);
                                constraintWidget3.mo15a(linearSystem);
                            }
                            size++;
                            i2 = i9;
                            size3 = i10;
                            z5 = z;
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i9 = i2;
                    }
                }
                i9 = i2;
                z = z5;
                try {
                    if (r1.am > 0) {
                        Chain.m82a(r1, linearSystem, 0);
                    }
                    if (r1.an > 0) {
                        Chain.m82a(r1, linearSystem, 1);
                    }
                    try {
                        LinearSystem linearSystem2 = r1.ah;
                        if (LinearSystem.f197h != null) {
                            try {
                                Metrics metrics = LinearSystem.f197h;
                                i3 = i6;
                                i4 = i7;
                                try {
                                    metrics.f216b++;
                                } catch (Exception e5) {
                                    e = e5;
                                    exception = e;
                                    i5 = max;
                                    size = 1;
                                    exception.printStackTrace();
                                    printStream = System.out;
                                    stringBuilder = new StringBuilder("EXCEPTION : ");
                                    stringBuilder.append(exception);
                                    printStream.println(stringBuilder.toString());
                                    if (size != 0) {
                                        m16511a(Optimizer.f350a);
                                    } else {
                                        mo19w();
                                        for (i7 = 0; i7 < i; i7++) {
                                            constraintWidget = (ConstraintWidget) r1.au.get(i7);
                                            if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                            }
                                            if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                            }
                                        }
                                    }
                                    if (i8 < 8) {
                                    }
                                    z6 = z;
                                    z4 = false;
                                    i6 = Math.max(r1.M, m114i());
                                    if (i6 > m114i()) {
                                        m103c(i6);
                                        r1.B[0] = DimensionBehaviour.FIXED;
                                        z4 = true;
                                        z6 = true;
                                    }
                                    i6 = Math.max(r1.N, m115j());
                                    if (i6 <= m115j()) {
                                        m106d(i6);
                                        z2 = true;
                                        r1.B[1] = DimensionBehaviour.FIXED;
                                        z4 = true;
                                        z6 = z4;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z6) {
                                        if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                                        }
                                        i2 = i5;
                                        r1.as = z2;
                                        r1.B[z2] = DimensionBehaviour.FIXED;
                                        m106d(max2);
                                        z4 = true;
                                        z5 = true;
                                        max = i2;
                                        i6 = i3;
                                        i7 = i4;
                                        size = 1;
                                        z3 = z4;
                                        z4 = false;
                                    } else {
                                        i2 = i5;
                                    }
                                    z5 = z6;
                                    max = i2;
                                    i6 = i3;
                                    i7 = i4;
                                    size = 1;
                                    z3 = z4;
                                    z4 = false;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                i3 = i6;
                                i4 = i7;
                                exception = e;
                                i5 = max;
                                size = 1;
                                exception.printStackTrace();
                                printStream = System.out;
                                stringBuilder = new StringBuilder("EXCEPTION : ");
                                stringBuilder.append(exception);
                                printStream.println(stringBuilder.toString());
                                if (size != 0) {
                                    mo19w();
                                    for (i7 = 0; i7 < i; i7++) {
                                        constraintWidget = (ConstraintWidget) r1.au.get(i7);
                                        if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                        }
                                        if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                        }
                                    }
                                } else {
                                    m16511a(Optimizer.f350a);
                                }
                                if (i8 < 8) {
                                }
                                z6 = z;
                                z4 = false;
                                i6 = Math.max(r1.M, m114i());
                                if (i6 > m114i()) {
                                    m103c(i6);
                                    r1.B[0] = DimensionBehaviour.FIXED;
                                    z4 = true;
                                    z6 = true;
                                }
                                i6 = Math.max(r1.N, m115j());
                                if (i6 <= m115j()) {
                                    z2 = true;
                                } else {
                                    m106d(i6);
                                    z2 = true;
                                    r1.B[1] = DimensionBehaviour.FIXED;
                                    z4 = true;
                                    z6 = z4;
                                }
                                if (z6) {
                                    i2 = i5;
                                } else {
                                    if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                                    }
                                    i2 = i5;
                                    r1.as = z2;
                                    r1.B[z2] = DimensionBehaviour.FIXED;
                                    m106d(max2);
                                    z4 = true;
                                    z5 = true;
                                    max = i2;
                                    i6 = i3;
                                    i7 = i4;
                                    size = 1;
                                    z3 = z4;
                                    z4 = false;
                                }
                                z5 = z6;
                                max = i2;
                                i6 = i3;
                                i7 = i4;
                                size = 1;
                                z3 = z4;
                                z4 = false;
                            }
                        } else {
                            i3 = i6;
                            i4 = i7;
                        }
                        try {
                            if (linearSystem2.f202d) {
                                Metrics metrics2;
                                Object obj;
                                if (LinearSystem.f197h != null) {
                                    metrics2 = LinearSystem.f197h;
                                    i5 = max;
                                    try {
                                        metrics2.f229o++;
                                    } catch (Exception e7) {
                                        e = e7;
                                        exception = e;
                                        size = 1;
                                        exception.printStackTrace();
                                        printStream = System.out;
                                        stringBuilder = new StringBuilder("EXCEPTION : ");
                                        stringBuilder.append(exception);
                                        printStream.println(stringBuilder.toString());
                                        if (size != 0) {
                                            mo19w();
                                            for (i7 = 0; i7 < i; i7++) {
                                                constraintWidget = (ConstraintWidget) r1.au.get(i7);
                                                if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                                }
                                                if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                                }
                                            }
                                        } else {
                                            m16511a(Optimizer.f350a);
                                        }
                                        if (i8 < 8) {
                                        }
                                        z6 = z;
                                        z4 = false;
                                        i6 = Math.max(r1.M, m114i());
                                        if (i6 > m114i()) {
                                            m103c(i6);
                                            r1.B[0] = DimensionBehaviour.FIXED;
                                            z4 = true;
                                            z6 = true;
                                        }
                                        i6 = Math.max(r1.N, m115j());
                                        if (i6 <= m115j()) {
                                            z2 = true;
                                        } else {
                                            m106d(i6);
                                            z2 = true;
                                            r1.B[1] = DimensionBehaviour.FIXED;
                                            z4 = true;
                                            z6 = z4;
                                        }
                                        if (z6) {
                                            i2 = i5;
                                        } else {
                                            if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                                            }
                                            i2 = i5;
                                            r1.as = z2;
                                            r1.B[z2] = DimensionBehaviour.FIXED;
                                            m106d(max2);
                                            z4 = true;
                                            z5 = true;
                                            max = i2;
                                            i6 = i3;
                                            i7 = i4;
                                            size = 1;
                                            z3 = z4;
                                            z4 = false;
                                        }
                                        z5 = z6;
                                        max = i2;
                                        i6 = i3;
                                        i7 = i4;
                                        size = 1;
                                        z3 = z4;
                                        z4 = false;
                                    }
                                } else {
                                    i5 = max;
                                }
                                for (i6 = 0; i6 < linearSystem2.f204f; i6++) {
                                    if (!linearSystem2.f201c[i6].f10992e) {
                                        obj = null;
                                        break;
                                    }
                                }
                                obj = 1;
                                if (obj == null) {
                                    linearSystem2.m65a(linearSystem2.f200b);
                                } else {
                                    if (LinearSystem.f197h != null) {
                                        metrics2 = LinearSystem.f197h;
                                        metrics2.f228n++;
                                    }
                                    linearSystem2.m75e();
                                }
                            } else {
                                i5 = max;
                                linearSystem2.m65a(linearSystem2.f200b);
                            }
                            size = 1;
                        } catch (Exception e8) {
                            e = e8;
                            i5 = max;
                            exception = e;
                            size = 1;
                            exception.printStackTrace();
                            printStream = System.out;
                            stringBuilder = new StringBuilder("EXCEPTION : ");
                            stringBuilder.append(exception);
                            printStream.println(stringBuilder.toString());
                            if (size != 0) {
                                mo19w();
                                for (i7 = 0; i7 < i; i7++) {
                                    constraintWidget = (ConstraintWidget) r1.au.get(i7);
                                    if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    }
                                    if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                    }
                                }
                            } else {
                                m16511a(Optimizer.f350a);
                            }
                            if (i8 < 8) {
                            }
                            z6 = z;
                            z4 = false;
                            i6 = Math.max(r1.M, m114i());
                            if (i6 > m114i()) {
                                m103c(i6);
                                r1.B[0] = DimensionBehaviour.FIXED;
                                z4 = true;
                                z6 = true;
                            }
                            i6 = Math.max(r1.N, m115j());
                            if (i6 <= m115j()) {
                                z2 = true;
                            } else {
                                m106d(i6);
                                z2 = true;
                                r1.B[1] = DimensionBehaviour.FIXED;
                                z4 = true;
                                z6 = z4;
                            }
                            if (z6) {
                                i2 = i5;
                            } else {
                                if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                                }
                                i2 = i5;
                                r1.as = z2;
                                r1.B[z2] = DimensionBehaviour.FIXED;
                                m106d(max2);
                                z4 = true;
                                z5 = true;
                                max = i2;
                                i6 = i3;
                                i7 = i4;
                                size = 1;
                                z3 = z4;
                                z4 = false;
                            }
                            z5 = z6;
                            max = i2;
                            i6 = i3;
                            i7 = i4;
                            size = 1;
                            z3 = z4;
                            z4 = false;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        i3 = i6;
                        i4 = i7;
                        i5 = max;
                        exception = e;
                        size = 1;
                        exception.printStackTrace();
                        printStream = System.out;
                        stringBuilder = new StringBuilder("EXCEPTION : ");
                        stringBuilder.append(exception);
                        printStream.println(stringBuilder.toString());
                        if (size != 0) {
                            m16511a(Optimizer.f350a);
                        } else {
                            mo19w();
                            for (i7 = 0; i7 < i; i7++) {
                                constraintWidget = (ConstraintWidget) r1.au.get(i7);
                                if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                }
                                if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                }
                            }
                        }
                        if (i8 < 8) {
                        }
                        z6 = z;
                        z4 = false;
                        i6 = Math.max(r1.M, m114i());
                        if (i6 > m114i()) {
                            m103c(i6);
                            r1.B[0] = DimensionBehaviour.FIXED;
                            z4 = true;
                            z6 = true;
                        }
                        i6 = Math.max(r1.N, m115j());
                        if (i6 <= m115j()) {
                            m106d(i6);
                            z2 = true;
                            r1.B[1] = DimensionBehaviour.FIXED;
                            z4 = true;
                            z6 = z4;
                        } else {
                            z2 = true;
                        }
                        if (z6) {
                            if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                            }
                            i2 = i5;
                            r1.as = z2;
                            r1.B[z2] = DimensionBehaviour.FIXED;
                            m106d(max2);
                            z4 = true;
                            z5 = true;
                            max = i2;
                            i6 = i3;
                            i7 = i4;
                            size = 1;
                            z3 = z4;
                            z4 = false;
                        } else {
                            i2 = i5;
                        }
                        z5 = z6;
                        max = i2;
                        i6 = i3;
                        i7 = i4;
                        size = 1;
                        z3 = z4;
                        z4 = false;
                    }
                } catch (Exception e10) {
                    e = e10;
                    i3 = i6;
                    i4 = i7;
                    i5 = max;
                    exception = e;
                    size = i9;
                    exception.printStackTrace();
                    printStream = System.out;
                    stringBuilder = new StringBuilder("EXCEPTION : ");
                    stringBuilder.append(exception);
                    printStream.println(stringBuilder.toString());
                    if (size != 0) {
                        m16511a(Optimizer.f350a);
                    } else {
                        mo19w();
                        for (i7 = 0; i7 < i; i7++) {
                            constraintWidget = (ConstraintWidget) r1.au.get(i7);
                            if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                            }
                            if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                            }
                        }
                    }
                    if (i8 < 8) {
                    }
                    z6 = z;
                    z4 = false;
                    i6 = Math.max(r1.M, m114i());
                    if (i6 > m114i()) {
                        m103c(i6);
                        r1.B[0] = DimensionBehaviour.FIXED;
                        z4 = true;
                        z6 = true;
                    }
                    i6 = Math.max(r1.N, m115j());
                    if (i6 <= m115j()) {
                        m106d(i6);
                        z2 = true;
                        r1.B[1] = DimensionBehaviour.FIXED;
                        z4 = true;
                        z6 = z4;
                    } else {
                        z2 = true;
                    }
                    if (z6) {
                        if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                        }
                        i2 = i5;
                        r1.as = z2;
                        r1.B[z2] = DimensionBehaviour.FIXED;
                        m106d(max2);
                        z4 = true;
                        z5 = true;
                        max = i2;
                        i6 = i3;
                        i7 = i4;
                        size = 1;
                        z3 = z4;
                        z4 = false;
                    } else {
                        i2 = i5;
                    }
                    z5 = z6;
                    max = i2;
                    i6 = i3;
                    i7 = i4;
                    size = 1;
                    z3 = z4;
                    z4 = false;
                }
            } catch (Exception e11) {
                e = e11;
                i3 = i6;
                i4 = i7;
                i5 = max;
                i9 = i2;
                z = z5;
                exception = e;
                size = i9;
                exception.printStackTrace();
                printStream = System.out;
                stringBuilder = new StringBuilder("EXCEPTION : ");
                stringBuilder.append(exception);
                printStream.println(stringBuilder.toString());
                if (size != 0) {
                    mo19w();
                    for (i7 = 0; i7 < i; i7++) {
                        constraintWidget = (ConstraintWidget) r1.au.get(i7);
                        if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                        if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                    }
                } else {
                    m16511a(Optimizer.f350a);
                }
                if (i8 < 8) {
                }
                z6 = z;
                z4 = false;
                i6 = Math.max(r1.M, m114i());
                if (i6 > m114i()) {
                    m103c(i6);
                    r1.B[0] = DimensionBehaviour.FIXED;
                    z4 = true;
                    z6 = true;
                }
                i6 = Math.max(r1.N, m115j());
                if (i6 <= m115j()) {
                    z2 = true;
                } else {
                    m106d(i6);
                    z2 = true;
                    r1.B[1] = DimensionBehaviour.FIXED;
                    z4 = true;
                    z6 = z4;
                }
                if (z6) {
                    i2 = i5;
                } else {
                    if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
                    }
                    i2 = i5;
                    r1.as = z2;
                    r1.B[z2] = DimensionBehaviour.FIXED;
                    m106d(max2);
                    z4 = true;
                    z5 = true;
                    max = i2;
                    i6 = i3;
                    i7 = i4;
                    size = 1;
                    z3 = z4;
                    z4 = false;
                }
                z5 = z6;
                max = i2;
                i6 = i3;
                i7 = i4;
                size = 1;
                z3 = z4;
                z4 = false;
            }
            if (size != 0) {
                mo19w();
                while (i7 < i) {
                    constraintWidget = (ConstraintWidget) r1.au.get(i7);
                    if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.m114i() >= constraintWidget.f312O) {
                        if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m115j() < constraintWidget.f313P) {
                            Optimizer.f350a[2] = true;
                            break;
                        }
                    } else {
                        Optimizer.f350a[2] = true;
                        break;
                    }
                }
            }
            m16511a(Optimizer.f350a);
            if (i8 < 8 || !Optimizer.f350a[2]) {
                z6 = z;
                z4 = false;
            } else {
                i7 = 0;
                max = 0;
                for (i6 = 0; i6 < i; i6++) {
                    constraintWidget3 = (ConstraintWidget) r1.au.get(i6);
                    i7 = Math.max(i7, constraintWidget3.f305H + constraintWidget3.m114i());
                    max = Math.max(max, constraintWidget3.f306I + constraintWidget3.m115j());
                }
                i6 = Math.max(r1.M, i7);
                i7 = Math.max(r1.N, max);
                if (dimensionBehaviour2 != DimensionBehaviour.WRAP_CONTENT || m114i() >= i6) {
                    z6 = z;
                    z4 = false;
                } else {
                    m103c(i6);
                    r1.B[0] = DimensionBehaviour.WRAP_CONTENT;
                    z4 = true;
                    z6 = true;
                }
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && m115j() < i7) {
                    m106d(i7);
                    r1.B[1] = DimensionBehaviour.WRAP_CONTENT;
                    z4 = true;
                    z6 = true;
                }
            }
            i6 = Math.max(r1.M, m114i());
            if (i6 > m114i()) {
                m103c(i6);
                r1.B[0] = DimensionBehaviour.FIXED;
                z4 = true;
                z6 = true;
            }
            i6 = Math.max(r1.N, m115j());
            if (i6 <= m115j()) {
                m106d(i6);
                z2 = true;
                r1.B[1] = DimensionBehaviour.FIXED;
                z4 = true;
                z6 = z4;
            } else {
                z2 = true;
            }
            if (z6) {
                if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT || i5 <= 0) {
                    i2 = i5;
                } else {
                    i2 = i5;
                    if (m114i() > i2) {
                        r1.ar = z2;
                        r1.B[0] = DimensionBehaviour.FIXED;
                        m103c(i2);
                        z4 = z2;
                        z6 = z4;
                    }
                }
                if (r1.B[z2] == DimensionBehaviour.WRAP_CONTENT && max2 > 0 && m115j() > max2) {
                    r1.as = z2;
                    r1.B[z2] = DimensionBehaviour.FIXED;
                    m106d(max2);
                    z4 = true;
                    z5 = true;
                    max = i2;
                    i6 = i3;
                    i7 = i4;
                    size = 1;
                    z3 = z4;
                    z4 = false;
                }
            } else {
                i2 = i5;
            }
            z5 = z6;
            max = i2;
            i6 = i3;
            i7 = i4;
            size = 1;
            z3 = z4;
            z4 = false;
        }
        i3 = i6;
        i4 = i7;
        z = z5;
        if (r1.C != null) {
            i6 = Math.max(r1.M, m114i());
            i7 = Math.max(r1.N, m115j());
            r1.av.m141a(r1);
            m103c((i6 + r1.ai) + r1.ak);
            m106d((i7 + r1.aj) + r1.al);
        } else {
            r1.H = i3;
            r1.I = i4;
        }
        if (z) {
            r1.B[0] = dimensionBehaviour2;
            r1.B[1] = dimensionBehaviour;
        }
        mo20a(r1.ah.f205g);
        if (r1 == m9460y()) {
            mo23s();
            return;
        }
        return;
        z = z5;
        i3 = i6;
        i4 = i7;
        i5 = max;
        size = i9;
        exception = e;
        exception.printStackTrace();
        printStream = System.out;
        stringBuilder = new StringBuilder("EXCEPTION : ");
        stringBuilder.append(exception);
        printStream.println(stringBuilder.toString());
        if (size != 0) {
            m16511a(Optimizer.f350a);
        } else {
            mo19w();
            for (i7 = 0; i7 < i; i7++) {
                constraintWidget = (ConstraintWidget) r1.au.get(i7);
                if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                }
                if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                }
            }
        }
        if (i8 < 8) {
        }
        z6 = z;
        z4 = false;
        i6 = Math.max(r1.M, m114i());
        if (i6 > m114i()) {
            m103c(i6);
            r1.B[0] = DimensionBehaviour.FIXED;
            z4 = true;
            z6 = true;
        }
        i6 = Math.max(r1.N, m115j());
        if (i6 <= m115j()) {
            m106d(i6);
            z2 = true;
            r1.B[1] = DimensionBehaviour.FIXED;
            z4 = true;
            z6 = z4;
        } else {
            z2 = true;
        }
        if (z6) {
            if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
            }
            i2 = i5;
            r1.as = z2;
            r1.B[z2] = DimensionBehaviour.FIXED;
            m106d(max2);
            z4 = true;
            z5 = true;
            max = i2;
            i6 = i3;
            i7 = i4;
            size = 1;
            z3 = z4;
            z4 = false;
        } else {
            i2 = i5;
        }
        z5 = z6;
        max = i2;
        i6 = i3;
        i7 = i4;
        size = 1;
        z3 = z4;
        z4 = false;
        i3 = i6;
        i4 = i7;
        i5 = max;
        size = i9;
        exception = e;
        exception.printStackTrace();
        printStream = System.out;
        stringBuilder = new StringBuilder("EXCEPTION : ");
        stringBuilder.append(exception);
        printStream.println(stringBuilder.toString());
        if (size != 0) {
            mo19w();
            for (i7 = 0; i7 < i; i7++) {
                constraintWidget = (ConstraintWidget) r1.au.get(i7);
                if (constraintWidget.f299B[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                }
                if (constraintWidget.f299B[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                }
            }
        } else {
            m16511a(Optimizer.f350a);
        }
        if (i8 < 8) {
        }
        z6 = z;
        z4 = false;
        i6 = Math.max(r1.M, m114i());
        if (i6 > m114i()) {
            m103c(i6);
            r1.B[0] = DimensionBehaviour.FIXED;
            z4 = true;
            z6 = true;
        }
        i6 = Math.max(r1.N, m115j());
        if (i6 <= m115j()) {
            z2 = true;
        } else {
            m106d(i6);
            z2 = true;
            r1.B[1] = DimensionBehaviour.FIXED;
            z4 = true;
            z6 = z4;
        }
        if (z6) {
            i2 = i5;
        } else {
            if (r1.B[0] == DimensionBehaviour.WRAP_CONTENT) {
            }
            i2 = i5;
            r1.as = z2;
            r1.B[z2] = DimensionBehaviour.FIXED;
            m106d(max2);
            z4 = true;
            z5 = true;
            max = i2;
            i6 = i3;
            i7 = i4;
            size = 1;
            z3 = z4;
            z4 = false;
        }
        z5 = z6;
        max = i2;
        i6 = i3;
        i7 = i4;
        size = 1;
        z3 = z4;
        z4 = false;
    }

    final void m16512a(ConstraintWidget constraintWidget, int i) {
        int i2 = 0;
        if (i == 0) {
            while (constraintWidget.f340r.f283d != 0 && constraintWidget.f340r.f283d.f281b.f342t.f283d != 0 && constraintWidget.f340r.f283d.f281b.f342t.f283d == constraintWidget.f340r && constraintWidget.f340r.f283d.f281b != constraintWidget) {
                constraintWidget = constraintWidget.f340r.f283d.f281b;
            }
            while (i2 < this.am) {
                if (this.ap[i2] == constraintWidget) {
                    break;
                }
                i2++;
            }
            if (this.am + 1 >= this.ap.length) {
                this.ap = (ConstraintWidget[]) Arrays.copyOf(this.ap, this.ap.length * 2);
            }
            this.ap[this.am] = constraintWidget;
            this.am += 1;
            return;
        }
        if (i == 1) {
            while (constraintWidget.f341s.f283d != 0 && constraintWidget.f341s.f283d.f281b.f343u.f283d != 0 && constraintWidget.f341s.f283d.f281b.f343u.f283d == constraintWidget.f341s && constraintWidget.f341s.f283d.f281b != constraintWidget) {
                constraintWidget = constraintWidget.f341s.f283d.f281b;
            }
            while (i2 < this.an) {
                if (this.ao[i2] == constraintWidget) {
                    break;
                }
                i2++;
            }
            if (this.an + 1 >= this.ao.length) {
                this.ao = (ConstraintWidget[]) Arrays.copyOf(this.ao, this.ao.length * 2);
            }
            this.ao[this.an] = constraintWidget;
            this.an += 1;
        }
    }
}
