package android.support.constraint.solver.widgets;

import java.util.Arrays;

public class Helper extends ConstraintWidget {
    protected ConstraintWidget[] ah = new ConstraintWidget[4];
    protected int ai = 0;

    public final void m9451a(ConstraintWidget constraintWidget) {
        if (this.ai + 1 > this.ah.length) {
            this.ah = (ConstraintWidget[]) Arrays.copyOf(this.ah, this.ah.length * 2);
        }
        this.ah[this.ai] = constraintWidget;
        this.ai++;
    }

    public final void m9452x() {
        this.ai = 0;
    }
}
