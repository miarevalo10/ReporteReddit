package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
    private final FragmentManager f11331b;
    private FragmentTransaction f11332c = null;
    private Fragment f11333d = null;

    public abstract Fragment mo3683a(int i);

    public final void mo233a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final Parcelable mo238b() {
        return null;
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f11331b = fragmentManager;
    }

    public final void mo234a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder stringBuilder = new StringBuilder("ViewPager with adapter ");
            stringBuilder.append(this);
            stringBuilder.append(" requires a view id");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final Object mo231a(ViewGroup viewGroup, int i) {
        if (this.f11332c == null) {
            this.f11332c = this.f11331b.mo219a();
        }
        long j = (long) i;
        Fragment a = this.f11331b.mo218a(m9923a(viewGroup.getId(), j));
        if (a != null) {
            this.f11332c.mo204c(a);
        } else {
            a = mo3683a(i);
            this.f11332c.mo195a(viewGroup.getId(), a, m9923a(viewGroup.getId(), j));
        }
        if (a != this.f11333d) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    public final void mo235a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f11332c == null) {
            this.f11332c = this.f11331b.mo219a();
        }
        this.f11332c.mo202b((Fragment) obj);
    }

    public final void mo236a(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f11333d) {
            if (this.f11333d != null) {
                this.f11333d.setMenuVisibility(false);
                this.f11333d.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f11333d = fragment;
        }
    }

    public final void mo232a() {
        if (this.f11332c != null) {
            this.f11332c.mo207f();
            this.f11332c = null;
        }
    }

    public final boolean mo237a(View view, Object obj) {
        return ((Fragment) obj).getView() == view ? true : null;
    }

    private static String m9923a(int i, long j) {
        StringBuilder stringBuilder = new StringBuilder("android:switcher:");
        stringBuilder.append(i);
        stringBuilder.append(":");
        stringBuilder.append(j);
        return stringBuilder.toString();
    }
}
