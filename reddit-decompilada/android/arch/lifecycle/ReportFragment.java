package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.arch.lifecycle.Lifecycle.Event;
import android.os.Bundle;

public class ReportFragment extends Fragment {
    private ActivityInitializationListener f23a;

    interface ActivityInitializationListener {
    }

    public static void m4a(Activity activity) {
        activity = activity.getFragmentManager();
        if (activity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            activity.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            activity.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m5a(Event.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        m5a(Event.ON_START);
    }

    public void onResume() {
        super.onResume();
        m5a(Event.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m5a(Event.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m5a(Event.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m5a(Event.ON_DESTROY);
        this.f23a = null;
    }

    private void m5a(Event event) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).m9415a().m9413a(event);
            return;
        }
        if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).m9413a(event);
            }
        }
    }
}
