package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

public class RequestManagerFragment extends Fragment {
    final ActivityFragmentLifecycle f3580a;
    final RequestManagerTreeNode f3581b;
    RequestManager f3582c;
    Fragment f3583d;
    private final Set<RequestManagerFragment> f3584e;
    private RequestManagerFragment f3585f;

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        final /* synthetic */ RequestManagerFragment f12652a;

        FragmentRequestManagerTreeNode(RequestManagerFragment requestManagerFragment) {
            this.f12652a = requestManagerFragment;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("{fragment=");
            stringBuilder.append(this.f12652a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    private RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f3581b = new FragmentRequestManagerTreeNode(this);
        this.f3584e = new HashSet();
        this.f3580a = activityFragmentLifecycle;
    }

    final void m3090a(Activity activity) {
        m3089a();
        this.f3585f = Glide.m2775a((Context) activity).f3196e.m3099a(activity.getFragmentManager(), null);
        if (equals(this.f3585f) == null) {
            this.f3585f.f3584e.add(this);
        }
    }

    private void m3089a() {
        if (this.f3585f != null) {
            this.f3585f.f3584e.remove(this);
            this.f3585f = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m3090a(activity);
        } catch (Activity activity2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", activity2);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        m3089a();
    }

    public void onStart() {
        super.onStart();
        this.f3580a.m11688a();
    }

    public void onStop() {
        super.onStop();
        this.f3580a.m11690b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3580a.m11692c();
        m3089a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        Object parentFragment = VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        if (parentFragment == null) {
            parentFragment = this.f3583d;
        }
        stringBuilder.append(parentFragment);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
