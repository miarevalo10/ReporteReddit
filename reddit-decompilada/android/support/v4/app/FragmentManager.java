package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager {

    public interface OnBackStackChangedListener {
        void mo4426a();
    }

    public abstract SavedState mo215a(Fragment fragment);

    public abstract Fragment mo216a(int i);

    public abstract Fragment mo217a(Bundle bundle, String str);

    public abstract Fragment mo218a(String str);

    public abstract FragmentTransaction mo219a();

    public abstract void mo220a(Bundle bundle, String str, Fragment fragment);

    public abstract void mo221a(OnBackStackChangedListener onBackStackChangedListener);

    public abstract void mo222a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void mo223b(int i);

    public abstract void mo224b(String str);

    public abstract boolean mo225b();

    public abstract void mo226c();

    public abstract boolean mo227d();

    public abstract int mo228e();

    public abstract List<Fragment> mo229f();

    public abstract boolean mo230g();
}
