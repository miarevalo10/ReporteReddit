package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    public final DataSetObservable f1449a = new DataSetObservable();
    private DataSetObserver f1450b;

    public void mo232a() {
    }

    public void mo233a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void mo234a(ViewGroup viewGroup) {
    }

    public void mo236a(Object obj) {
    }

    public abstract boolean mo237a(View view, Object obj);

    public Parcelable mo238b() {
        return null;
    }

    public CharSequence m1144b(int i) {
        return null;
    }

    public abstract int mo3684c();

    public void m1146d() {
        synchronized (this) {
            if (this.f1450b != null) {
                this.f1450b.onChanged();
            }
        }
        this.f1449a.notifyChanged();
    }

    final void m1137a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1450b = dataSetObserver;
        }
    }

    public Object mo231a(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void mo235a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
}
