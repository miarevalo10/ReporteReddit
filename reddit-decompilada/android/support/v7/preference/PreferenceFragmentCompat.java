package android.support.v7.preference;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.preference.DialogPreference.TargetFragment;
import android.support.v7.preference.PreferenceManager.OnDisplayPreferenceDialogListener;
import android.support.v7.preference.PreferenceManager.OnNavigateToScreenListener;
import android.support.v7.preference.PreferenceManager.OnPreferenceTreeClickListener;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PreferenceFragmentCompat extends Fragment implements TargetFragment, OnDisplayPreferenceDialogListener, OnNavigateToScreenListener, OnPreferenceTreeClickListener {
    private PreferenceManager f16578a;
    private RecyclerView f16579b;
    private boolean f16580c;
    private boolean f16581d;
    private Context f16582e;
    private int f16583f = C0177R.layout.preference_list_fragment;
    private final DividerDecoration f16584g = new DividerDecoration();
    private Handler f16585h = new C01731(this);
    private final Runnable f16586i = new C01742(this);
    private Runnable f16587j;

    class C01731 extends Handler {
        final /* synthetic */ PreferenceFragmentCompat f1908a;

        C01731(PreferenceFragmentCompat preferenceFragmentCompat) {
            this.f1908a = preferenceFragmentCompat;
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                this.f1908a.m16795b();
            }
        }
    }

    class C01742 implements Runnable {
        final /* synthetic */ PreferenceFragmentCompat f1909a;

        C01742(PreferenceFragmentCompat preferenceFragmentCompat) {
            this.f1909a = preferenceFragmentCompat;
        }

        public void run() {
            this.f1909a.f16579b.focusableViewAvailable(this.f1909a.f16579b);
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean m1629a();
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean m1630a();
    }

    public interface OnPreferenceStartScreenCallback {
    }

    private class DividerDecoration extends ItemDecoration {
        Drawable f11630a;
        int f11631b;
        boolean f11632c;
        final /* synthetic */ PreferenceFragmentCompat f11633d;

        private DividerDecoration(PreferenceFragmentCompat preferenceFragmentCompat) {
            this.f11633d = preferenceFragmentCompat;
            this.f11632c = true;
        }

        public final void mo483a(Canvas canvas, RecyclerView recyclerView) {
            if (this.f11630a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (m10335a(childAt, recyclerView)) {
                        int y = ((int) childAt.getY()) + childAt.getHeight();
                        this.f11630a.setBounds(0, y, width, this.f11631b + y);
                        this.f11630a.draw(canvas);
                    }
                }
            }
        }

        public final void mo484a(Rect rect, View view, RecyclerView recyclerView, State state) {
            if (m10335a(view, recyclerView) != null) {
                rect.bottom = this.f11631b;
            }
        }

        private boolean m10335a(View view, RecyclerView recyclerView) {
            ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            int i = ((childViewHolder instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder).f11654b) ? 1 : false;
            if (i == 0) {
                return false;
            }
            boolean z = this.f11632c;
            view = recyclerView.indexOfChild(view);
            if (view < recyclerView.getChildCount() - 1) {
                view = recyclerView.getChildViewHolder(recyclerView.getChildAt(view + 1));
                z = ((view instanceof PreferenceViewHolder) == null || ((PreferenceViewHolder) view).f11653a == null) ? false : true;
            }
            return z;
        }
    }

    public abstract void m16799a(Bundle bundle);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(C0177R.attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            throw new IllegalStateException("Must specify preferenceTheme in theme");
        }
        this.f16582e = new ContextThemeWrapper(getActivity(), i);
        this.f16578a = new PreferenceManager(this.f16582e);
        this.f16578a.f1927g = this;
        if (getArguments() != null) {
            getArguments().getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        }
        m16799a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        bundle = this.f16582e.obtainStyledAttributes(null, C0177R.styleable.PreferenceFragmentCompat, C0177R.attr.preferenceFragmentCompatStyle, 0);
        this.f16583f = bundle.getResourceId(C0177R.styleable.PreferenceFragmentCompat_android_layout, this.f16583f);
        Drawable drawable = bundle.getDrawable(C0177R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = bundle.getDimensionPixelSize(C0177R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = bundle.getBoolean(C0177R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        bundle.recycle();
        bundle = new TypedValue();
        getActivity().getTheme().resolveAttribute(C0177R.attr.preferenceTheme, bundle, true);
        layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(layoutInflater.getContext(), bundle.resourceId));
        viewGroup = layoutInflater.inflate(this.f16583f, viewGroup, false);
        bundle = viewGroup.findViewById(16908351);
        if (bundle instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) bundle;
            RecyclerView recyclerView = (RecyclerView) layoutInflater.inflate(C0177R.layout.preference_recyclerview, viewGroup2, false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView));
            if (recyclerView == null) {
                throw new RuntimeException("Could not create RecyclerView");
            }
            this.f16579b = recyclerView;
            recyclerView.addItemDecoration(this.f16584g);
            layoutInflater = this.f16584g;
            if (drawable != null) {
                layoutInflater.f11631b = drawable.getIntrinsicHeight();
            } else {
                layoutInflater.f11631b = 0;
            }
            layoutInflater.f11630a = drawable;
            layoutInflater.f11633d.f16579b.invalidateItemDecorations();
            if (dimensionPixelSize != -1) {
                layoutInflater = this.f16584g;
                layoutInflater.f11631b = dimensionPixelSize;
                layoutInflater.f11633d.f16579b.invalidateItemDecorations();
            }
            this.f16584g.f11632c = z;
            viewGroup2.addView(this.f16579b);
            this.f16585h.post(this.f16586i);
            return viewGroup;
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f16580c != null) {
            m16795b();
            if (this.f16587j != null) {
                this.f16587j.run();
                this.f16587j = null;
            }
        }
        this.f16581d = true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            bundle = bundle.getBundle("android:preferences");
            if (bundle != null) {
                Preference preference = this.f16578a.f1923c;
                if (preference != null) {
                    preference.mo486b(bundle);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.f16578a.f1925e = this;
        this.f16578a.f1926f = this;
    }

    public void onStop() {
        super.onStop();
        this.f16578a.f1925e = null;
        this.f16578a.f1926f = null;
    }

    public void onDestroyView() {
        this.f16585h.removeCallbacks(this.f16586i);
        this.f16585h.removeMessages(1);
        if (this.f16580c) {
            PreferenceScreen preferenceScreen = this.f16578a.f1923c;
            if (preferenceScreen != null) {
                preferenceScreen.mo490n();
            }
        }
        this.f16579b = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Preference preference = this.f16578a.f1923c;
        if (preference != null) {
            Bundle bundle2 = new Bundle();
            preference.mo485a(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public final void mo3192a() {
        if (getActivity() instanceof OnPreferenceStartScreenCallback) {
            getActivity();
        }
    }

    public final Preference mo3191a(CharSequence charSequence) {
        if (this.f16578a == null) {
            return null;
        }
        return this.f16578a.m1649a(charSequence);
    }

    public void mo3194b(Preference preference) {
        if (!(getActivity() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) getActivity()).m1629a() : false) && getFragmentManager().mo218a("android.support.v7.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                preference = EditTextPreferenceDialogFragmentCompat.m20746a(preference.f1898q);
            } else if (preference instanceof ListPreference) {
                preference = ListPreferenceDialogFragmentCompat.m20751a(preference.f1898q);
            } else if (preference instanceof AbstractMultiSelectListPreference) {
                preference = MultiSelectListPreferenceDialogFragmentCompat.m20756a(preference.f1898q);
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            preference.setTargetFragment(this, 0);
            preference.mo3959a(getFragmentManager(), "android.support.v7.preference.PreferenceFragment.DIALOG");
        }
    }

    public final void m16798a(int i) {
        if (this.f16578a == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        boolean z;
        i = this.f16578a.m1650a(this.f16582e, i, this.f16578a.f1923c);
        PreferenceManager preferenceManager = this.f16578a;
        if (i != preferenceManager.f1923c) {
            if (preferenceManager.f1923c != null) {
                preferenceManager.f1923c.mo490n();
            }
            preferenceManager.f1923c = i;
            z = true;
        } else {
            z = false;
        }
        if (z && i != 0) {
            this.f16580c = true;
            if (this.f16581d != 0 && this.f16585h.hasMessages(1) == 0) {
                this.f16585h.obtainMessage(1).sendToTarget();
            }
        }
    }

    public final boolean mo3193a(Preference preference) {
        boolean z = false;
        if (preference.f1900s == null) {
            return false;
        }
        if ((getActivity() instanceof OnPreferenceStartFragmentCallback) != null) {
            z = ((OnPreferenceStartFragmentCallback) getActivity()).m1630a();
        }
        return z;
    }

    private void m16795b() {
        PreferenceGroup preferenceGroup = this.f16578a.f1923c;
        if (preferenceGroup != null) {
            this.f16579b.setAdapter(new PreferenceGroupAdapter(preferenceGroup));
            preferenceGroup.mo489m();
        }
    }
}
