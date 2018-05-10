package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode {
    ConstraintAnchor f351a;
    float f352b;
    ResolutionNode f353c;
    float f354d;
    HashSet<ResolutionNode> f355e = new HashSet(4);
    ResolutionNode f356f;
    float f357g;
    int f358h = 0;
    int f359i = 0;
    private ResolutionNode f360j;
    private float f361k;

    public ResolutionNode(ConstraintAnchor constraintAnchor) {
        this.f351a = constraintAnchor;
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.f359i != 1) {
            stringBuilder = new StringBuilder("{ ");
            stringBuilder.append(this.f351a);
            stringBuilder.append(" UNRESOLVED}");
            return stringBuilder.toString();
        } else if (this.f356f == this) {
            stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.f351a);
            stringBuilder.append(", RESOLVED: ");
            stringBuilder.append(this.f357g);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.f351a);
            stringBuilder.append(", RESOLVED: ");
            stringBuilder.append(this.f356f);
            stringBuilder.append(":");
            stringBuilder.append(this.f357g);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public final void m133a() {
        this.f359i = 1;
        Iterator it = this.f355e.iterator();
        while (it.hasNext()) {
            ResolutionNode resolutionNode = (ResolutionNode) it.next();
            if (!(resolutionNode.f359i == 1 || resolutionNode.f358h == 4)) {
                if (resolutionNode.f358h == 1 && (resolutionNode.f353c == null || resolutionNode.f353c.f359i == 1)) {
                    if (resolutionNode.f353c == null) {
                        resolutionNode.f356f = resolutionNode;
                        resolutionNode.f357g = resolutionNode.f354d;
                    } else {
                        resolutionNode.f356f = resolutionNode.f353c.f356f;
                        resolutionNode.f357g = resolutionNode.f353c.f357g + resolutionNode.f354d;
                    }
                    resolutionNode.m133a();
                } else if (resolutionNode.f358h == 2 && resolutionNode.f353c != null && resolutionNode.f353c.f359i == 1 && resolutionNode.f360j != null && resolutionNode.f360j.f353c != null && resolutionNode.f360j.f353c.f359i == 1) {
                    float f;
                    float f2;
                    int b;
                    int b2;
                    float f3;
                    float f4;
                    if (LinearSystem.m53a() != null) {
                        r3 = LinearSystem.m53a();
                        r3.f234t++;
                    }
                    resolutionNode.f356f = resolutionNode.f353c.f356f;
                    resolutionNode.f360j.f356f = resolutionNode.f360j.f353c.f356f;
                    if (resolutionNode.f361k > 0.0f) {
                        f = resolutionNode.f353c.f357g - resolutionNode.f360j.f353c.f357g;
                    } else {
                        f = resolutionNode.f360j.f353c.f357g - resolutionNode.f353c.f357g;
                    }
                    if (resolutionNode.f351a.f282c != Type.LEFT) {
                        if (resolutionNode.f351a.f282c != Type.RIGHT) {
                            f -= (float) resolutionNode.f351a.f281b.m115j();
                            f2 = resolutionNode.f351a.f281b.f315S;
                            b = resolutionNode.f351a.m85b();
                            b2 = resolutionNode.f360j.f351a.m85b();
                            if (resolutionNode.f351a.f283d == resolutionNode.f360j.f351a.f283d) {
                                f2 = 0.5f;
                                b = 0;
                                b2 = b;
                            }
                            f3 = (float) b;
                            f4 = (float) b2;
                            f = (f - f3) - f4;
                            if (resolutionNode.f361k <= 0.0f) {
                                resolutionNode.f360j.f357g = (resolutionNode.f360j.f353c.f357g + f4) + (f * f2);
                                resolutionNode.f357g = (resolutionNode.f353c.f357g - f3) - (f * (1.0f - f2));
                            } else {
                                resolutionNode.f357g = (resolutionNode.f353c.f357g + f3) + (f * f2);
                                resolutionNode.f360j.f357g = (resolutionNode.f360j.f353c.f357g - f4) - (f * (1.0f - f2));
                            }
                            resolutionNode.m133a();
                            resolutionNode.f360j.m133a();
                        }
                    }
                    f -= (float) resolutionNode.f351a.f281b.m114i();
                    f2 = resolutionNode.f351a.f281b.f314R;
                    b = resolutionNode.f351a.m85b();
                    b2 = resolutionNode.f360j.f351a.m85b();
                    if (resolutionNode.f351a.f283d == resolutionNode.f360j.f351a.f283d) {
                        f2 = 0.5f;
                        b = 0;
                        b2 = b;
                    }
                    f3 = (float) b;
                    f4 = (float) b2;
                    f = (f - f3) - f4;
                    if (resolutionNode.f361k <= 0.0f) {
                        resolutionNode.f357g = (resolutionNode.f353c.f357g + f3) + (f * f2);
                        resolutionNode.f360j.f357g = (resolutionNode.f360j.f353c.f357g - f4) - (f * (1.0f - f2));
                    } else {
                        resolutionNode.f360j.f357g = (resolutionNode.f360j.f353c.f357g + f4) + (f * f2);
                        resolutionNode.f357g = (resolutionNode.f353c.f357g - f3) - (f * (1.0f - f2));
                    }
                    resolutionNode.m133a();
                    resolutionNode.f360j.m133a();
                } else if (resolutionNode.f358h == 3 && resolutionNode.f353c != null && resolutionNode.f353c.f359i == 1 && resolutionNode.f360j != null && resolutionNode.f360j.f353c != null && resolutionNode.f360j.f353c.f359i == 1) {
                    if (LinearSystem.m53a() != null) {
                        r3 = LinearSystem.m53a();
                        r3.f235u++;
                    }
                    resolutionNode.f356f = resolutionNode.f353c.f356f;
                    resolutionNode.f360j.f356f = resolutionNode.f360j.f353c.f356f;
                    resolutionNode.f357g = resolutionNode.f353c.f357g + resolutionNode.f354d;
                    resolutionNode.f360j.f357g = resolutionNode.f360j.f353c.f357g + resolutionNode.f360j.f354d;
                    resolutionNode.m133a();
                    resolutionNode.f360j.m133a();
                } else if (resolutionNode.f358h == 5) {
                    resolutionNode.f351a.f281b.mo3073d();
                }
            }
        }
    }

    public final void m136a(ResolutionNode resolutionNode, float f) {
        this.f356f = resolutionNode;
        this.f357g = f;
        m133a();
    }

    public final void m135a(ResolutionNode resolutionNode) {
        this.f355e.add(resolutionNode);
    }

    public final void m138b() {
        this.f353c = null;
        this.f354d = 0.0f;
        this.f355e.clear();
        this.f356f = null;
        this.f357g = 0.0f;
        this.f352b = 0.0f;
        this.f360j = null;
        this.f361k = 0.0f;
        this.f358h = 0;
        this.f359i = 0;
    }

    public final void m137a(ResolutionNode resolutionNode, int i) {
        this.f358h = 1;
        this.f353c = resolutionNode;
        this.f354d = (float) i;
        this.f353c.m135a(this);
    }

    public final void m140b(ResolutionNode resolutionNode, int i) {
        this.f353c = resolutionNode;
        this.f354d = (float) i;
        this.f353c.m135a(this);
    }

    public final void m139b(ResolutionNode resolutionNode, float f) {
        this.f360j = resolutionNode;
        this.f361k = f;
    }

    final void m134a(LinearSystem linearSystem) {
        SolverVariable solverVariable = this.f351a.f288i;
        if (this.f356f == null) {
            linearSystem.m66a(solverVariable, (int) this.f357g);
        } else {
            linearSystem.m73c(solverVariable, linearSystem.m62a(this.f356f.f351a), (int) this.f357g, 6);
        }
    }
}
