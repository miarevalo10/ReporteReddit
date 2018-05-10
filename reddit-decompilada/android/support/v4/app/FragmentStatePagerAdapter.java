package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private final FragmentManager f11334b;
    private FragmentTransaction f11335c = null;
    private ArrayList<SavedState> f11336d = new ArrayList();
    private ArrayList<Fragment> f11337e = new ArrayList();
    private Fragment f11338f = null;

    public abstract Fragment m9933a(int i);

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f11334b = fragmentManager;
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
        Fragment fragment;
        if (this.f11337e.size() > i) {
            fragment = (Fragment) this.f11337e.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f11335c == null) {
            this.f11335c = this.f11334b.mo219a();
        }
        fragment = m9933a(i);
        if (this.f11336d.size() > i) {
            SavedState savedState = (SavedState) this.f11336d.get(i);
            if (savedState != null) {
                fragment.setInitialSavedState(savedState);
            }
        }
        while (this.f11337e.size() <= i) {
            this.f11337e.add(null);
        }
        fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);
        this.f11337e.set(i, fragment);
        this.f11335c.mo194a(viewGroup.getId(), fragment);
        return fragment;
    }

    public final void mo235a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f11335c == null) {
            this.f11335c = this.f11334b.mo219a();
        }
        while (this.f11336d.size() <= i) {
            this.f11336d.add(null);
        }
        this.f11336d.set(i, fragment.isAdded() ? this.f11334b.mo215a(fragment) : null);
        this.f11337e.set(i, null);
        this.f11335c.mo196a(fragment);
    }

    public final void mo236a(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f11338f) {
            if (this.f11338f != null) {
                this.f11338f.setMenuVisibility(false);
                this.f11338f.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f11338f = fragment;
        }
    }

    public final void mo232a() {
        if (this.f11335c != null) {
            this.f11335c.mo207f();
            this.f11335c = null;
        }
    }

    public final boolean mo237a(View view, Object obj) {
        return ((Fragment) obj).getView() == view ? true : null;
    }

    public final Parcelable mo238b() {
        Parcelable bundle;
        if (this.f11336d.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.f11336d.size()];
            this.f11336d.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f11337e.size(); i++) {
            Fragment fragment = (Fragment) this.f11337e.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                StringBuilder stringBuilder = new StringBuilder("f");
                stringBuilder.append(i);
                this.f11334b.mo220a(bundle, stringBuilder.toString(), fragment);
            }
        }
        return bundle;
    }

    public final void mo233a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            classLoader = bundle.getParcelableArray("states");
            this.f11336d.clear();
            this.f11337e.clear();
            if (classLoader != null) {
                for (Object obj : classLoader) {
                    this.f11336d.add((SavedState) obj);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f11334b.mo217a(bundle, str);
                    if (a != null) {
                        while (this.f11337e.size() <= parseInt) {
                            this.f11337e.add(null);
                        }
                        a.setMenuVisibility(false);
                        this.f11337e.set(parseInt, a);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Bad fragment at key ");
                        stringBuilder.append(str);
                        Log.w("FragmentStatePagerAdapt", stringBuilder.toString());
                    }
                }
            }
        }
    }
}
