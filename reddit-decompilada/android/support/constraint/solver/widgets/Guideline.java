package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
    protected float f10995a = -1.0f;
    protected int ah = -1;
    protected int ai = -1;
    private ConstraintAnchor aj = this.s;
    private int ak;
    private boolean al;
    private int am;
    private Rectangle an;
    private int ao;

    public final boolean mo16a() {
        return true;
    }

    public Guideline() {
        int i = 0;
        this.ak = 0;
        this.al = false;
        this.am = 0;
        this.an = new Rectangle();
        this.ao = 8;
        this.A.clear();
        this.A.add(this.aj);
        int length = this.z.length;
        while (i < length) {
            this.z[i] = this.aj;
            i++;
        }
    }

    public final void m9446g(int i) {
        if (this.ak != i) {
            this.ak = i;
            this.A.clear();
            if (this.ak == 1) {
                this.aj = this.r;
            } else {
                this.aj = this.s;
            }
            this.A.add(this.aj);
            i = this.z.length;
            for (int i2 = 0; i2 < i; i2++) {
                this.z[i2] = this.aj;
            }
        }
    }

    public final ConstraintAnchor mo14a(Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.ak == 1) {
                    return this.aj;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.ak == 0) {
                    return this.aj;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
            default:
                break;
        }
        throw new AssertionError(type.name());
    }

    public final ArrayList<ConstraintAnchor> mo18r() {
        return this.A;
    }

    public final void m9442a(float f) {
        if (f > -1.0f) {
            this.f10995a = f;
            this.ah = -1;
            this.ai = -1;
        }
    }

    public final void m9447h(int i) {
        if (i >= 0) {
            this.f10995a = -1.0f;
            this.ah = i;
            this.ai = -1;
        }
    }

    public final void m9448i(int i) {
        if (i >= 0) {
            this.f10995a = -1.0f;
            this.ah = -1;
            this.ai = i;
        }
    }

    public final void mo17c() {
        ConstraintWidget constraintWidget = this.f300C;
        if (constraintWidget != null) {
            int i;
            if (this.ak == 1) {
                this.s.f280a.m137a(constraintWidget.f341s.f280a, 0);
                this.u.f280a.m137a(constraintWidget.f341s.f280a, 0);
                if (this.ah != -1) {
                    this.r.f280a.m137a(constraintWidget.f340r.f280a, this.ah);
                    this.t.f280a.m137a(constraintWidget.f340r.f280a, this.ah);
                    return;
                } else if (this.ai != -1) {
                    this.r.f280a.m137a(constraintWidget.f342t.f280a, -this.ai);
                    this.t.f280a.m137a(constraintWidget.f342t.f280a, -this.ai);
                    return;
                } else if (this.f10995a != -1.0f && constraintWidget.m126u() == DimensionBehaviour.FIXED) {
                    i = (int) (((float) constraintWidget.f301D) * this.f10995a);
                    this.r.f280a.m137a(constraintWidget.f340r.f280a, i);
                    this.t.f280a.m137a(constraintWidget.f340r.f280a, i);
                    return;
                }
            }
            this.r.f280a.m137a(constraintWidget.f340r.f280a, 0);
            this.t.f280a.m137a(constraintWidget.f340r.f280a, 0);
            if (this.ah != -1) {
                this.s.f280a.m137a(constraintWidget.f341s.f280a, this.ah);
                this.u.f280a.m137a(constraintWidget.f341s.f280a, this.ah);
            } else if (this.ai != -1) {
                this.s.f280a.m137a(constraintWidget.f343u.f280a, -this.ai);
                this.u.f280a.m137a(constraintWidget.f343u.f280a, -this.ai);
            } else if (this.f10995a != -1.0f && constraintWidget.m127v() == DimensionBehaviour.FIXED) {
                i = (int) (((float) constraintWidget.f302E) * this.f10995a);
                this.s.f280a.m137a(constraintWidget.f341s.f280a, i);
                this.u.f280a.m137a(constraintWidget.f341s.f280a, i);
            }
        }
    }

    public final void mo15a(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.f300C;
        if (constraintWidgetContainer != null) {
            Object a = constraintWidgetContainer.mo14a(Type.LEFT);
            Object a2 = constraintWidgetContainer.mo14a(Type.RIGHT);
            int i = (this.C == null || this.C.f299B[0] != DimensionBehaviour.WRAP_CONTENT) ? 0 : 1;
            if (this.ak == 0) {
                a = constraintWidgetContainer.mo14a(Type.TOP);
                a2 = constraintWidgetContainer.mo14a(Type.BOTTOM);
                i = (this.C == null || this.C.f299B[1] != DimensionBehaviour.WRAP_CONTENT) ? 0 : 1;
            }
            SolverVariable a3;
            if (this.ah != -1) {
                a3 = linearSystem.m62a(this.aj);
                linearSystem.m73c(a3, linearSystem.m62a(a), this.ah, 6);
                if (i != 0) {
                    linearSystem.m68a(linearSystem.m62a(a2), a3, 0, 5);
                }
            } else if (this.ai != -1) {
                a3 = linearSystem.m62a(this.aj);
                SolverVariable a4 = linearSystem.m62a(a2);
                linearSystem.m73c(a3, a4, -this.ai, 6);
                if (i != 0) {
                    linearSystem.m68a(a3, linearSystem.m62a(a), 0, 5);
                    linearSystem.m68a(a4, a3, 0, 5);
                }
            } else {
                if (this.f10995a != -1.0f) {
                    linearSystem.m63a(LinearSystem.m52a(linearSystem, linearSystem.m62a(this.aj), linearSystem.m62a(a), linearSystem.m62a(a2), this.f10995a, this.al));
                }
            }
        }
    }

    public final void mo19w() {
        if (this.f300C != null) {
            int b = LinearSystem.m56b(this.aj);
            if (this.ak == 1) {
                m90a(b);
                m99b(0);
                m106d(this.f300C.m115j());
                m103c(0);
                return;
            }
            m90a(0);
            m99b(b);
            m103c(this.f300C.m114i());
            m106d(0);
        }
    }
}
