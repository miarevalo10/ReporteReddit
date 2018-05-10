package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> au = new ArrayList();

    public void mo22e() {
        this.au.clear();
        super.mo22e();
    }

    public final void m9454a(ConstraintWidget constraintWidget) {
        this.au.add(constraintWidget);
        if (constraintWidget.f300C != null) {
            ((WidgetContainer) constraintWidget.f300C).m9456b(constraintWidget);
        }
        constraintWidget.f300C = this;
    }

    public final void m9456b(ConstraintWidget constraintWidget) {
        this.au.remove(constraintWidget);
        constraintWidget.f300C = null;
    }

    public final void mo21b(int i, int i2) {
        super.mo21b(i, i2);
        i = this.au.size();
        for (i2 = 0; i2 < i; i2++) {
            ((ConstraintWidget) this.au.get(i2)).mo21b(m118m(), m119n());
        }
    }

    public final void mo23s() {
        super.mo23s();
        if (this.au != null) {
            int size = this.au.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.au.get(i);
                constraintWidget.mo21b(m116k(), m117l());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.mo23s();
                }
            }
        }
    }

    public void mo3074x() {
        mo23s();
        if (this.au != null) {
            int size = this.au.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.au.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).mo3074x();
                }
            }
        }
    }

    public final void mo20a(Cache cache) {
        super.mo20a(cache);
        int size = this.au.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.au.get(i)).mo20a(cache);
        }
    }

    public final void m9461z() {
        this.au.clear();
    }

    public final ConstraintWidgetContainer m9460y() {
        ConstraintWidget constraintWidget = this.f300C;
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (constraintWidget != null) {
            ConstraintWidget constraintWidget2 = constraintWidget.f300C;
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
            }
            constraintWidget = constraintWidget2;
        }
        return constraintWidgetContainer;
    }
}
