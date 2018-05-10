package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    final ActivityFragmentLifecycle f16741a;
    final RequestManagerTreeNode f16742b;
    RequestManager f16743c;
    Fragment f16744d;
    private final Set<SupportRequestManagerFragment> f16745e;
    private SupportRequestManagerFragment f16746f;

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        final /* synthetic */ SupportRequestManagerFragment f12653a;

        SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment supportRequestManagerFragment) {
            this.f12653a = supportRequestManagerFragment;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("{fragment=");
            stringBuilder.append(this.f12653a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    private SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f16742b = new SupportFragmentRequestManagerTreeNode(this);
        this.f16745e = new HashSet();
        this.f16741a = activityFragmentLifecycle;
    }

    final void m17045a(FragmentActivity fragmentActivity) {
        m17044a();
        this.f16746f = Glide.m2775a((Context) fragmentActivity).f3196e.m3100a(fragmentActivity.getSupportFragmentManager(), null);
        if (equals(this.f16746f) == null) {
            this.f16746f.f16745e.add(this);
        }
    }

    private void m17044a() {
        if (this.f16746f != null) {
            this.f16746f.f16745e.remove(this);
            this.f16746f = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m17045a(getActivity());
        } catch (Context context2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", context2);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f16744d = null;
        m17044a();
    }

    public void onStart() {
        super.onStart();
        this.f16741a.m11688a();
    }

    public void onStop() {
        super.onStop();
        this.f16741a.m11690b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f16741a.m11692c();
        m17044a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        Object parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f16744d;
        }
        stringBuilder.append(parentFragment);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
