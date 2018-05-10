package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import java.util.ArrayList;

public class Snapshot {
    int f367a;
    int f368b;
    int f369c;
    int f370d;
    ArrayList<Connection> f371e = new ArrayList();

    static class Connection {
        ConstraintAnchor f362a;
        ConstraintAnchor f363b;
        int f364c;
        Strength f365d;
        int f366e;

        public Connection(ConstraintAnchor constraintAnchor) {
            this.f362a = constraintAnchor;
            this.f363b = constraintAnchor.f283d;
            this.f364c = constraintAnchor.m85b();
            this.f365d = constraintAnchor.f286g;
            this.f366e = constraintAnchor.f287h;
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.f367a = constraintWidget.m112g();
        this.f368b = constraintWidget.m113h();
        this.f369c = constraintWidget.m114i();
        this.f370d = constraintWidget.m115j();
        constraintWidget = constraintWidget.mo18r();
        int size = constraintWidget.size();
        for (int i = 0; i < size; i++) {
            this.f371e.add(new Connection((ConstraintAnchor) constraintWidget.get(i)));
        }
    }

    public final void m141a(ConstraintWidget constraintWidget) {
        constraintWidget.m90a(this.f367a);
        constraintWidget.m99b(this.f368b);
        constraintWidget.m103c(this.f369c);
        constraintWidget.m106d(this.f370d);
        int size = this.f371e.size();
        for (int i = 0; i < size; i++) {
            Connection connection = (Connection) this.f371e.get(i);
            constraintWidget.mo14a(connection.f362a.f282c).m84a(connection.f363b, connection.f364c, -1, connection.f365d, connection.f366e, false);
        }
    }
}
