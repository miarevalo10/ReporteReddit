package com.bluelinelabs.conductor.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ActivityHostedRouter;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LifecycleHandler extends Fragment implements ActivityLifecycleCallbacks {
    private static final Map<Activity, LifecycleHandler> f3166g = new HashMap();
    public Activity f3167a;
    public SparseArray<String> f3168b = new SparseArray();
    public final Map<Integer, ActivityHostedRouter> f3169c = new HashMap();
    private boolean f3170d;
    private boolean f3171e;
    private boolean f3172f;
    private SparseArray<String> f3173h = new SparseArray();
    private ArrayList<PendingPermissionRequest> f3174i = new ArrayList();

    private static class PendingPermissionRequest implements Parcelable {
        public static final Creator<PendingPermissionRequest> CREATOR = new C02591();
        final String f3163a;
        final String[] f3164b;
        final int f3165c;

        static class C02591 implements Creator<PendingPermissionRequest> {
            C02591() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PendingPermissionRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new PendingPermissionRequest(parcel);
            }
        }

        public int describeContents() {
            return 0;
        }

        PendingPermissionRequest(String str, String[] strArr, int i) {
            this.f3163a = str;
            this.f3164b = strArr;
            this.f3165c = i;
        }

        private PendingPermissionRequest(Parcel parcel) {
            this.f3163a = parcel.readString();
            this.f3164b = parcel.createStringArray();
            this.f3165c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3163a);
            parcel.writeStringArray(this.f3164b);
            parcel.writeInt(this.f3165c);
        }
    }

    public LifecycleHandler() {
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    private static LifecycleHandler m2758b(Activity activity) {
        LifecycleHandler lifecycleHandler = (LifecycleHandler) f3166g.get(activity);
        if (lifecycleHandler == null) {
            lifecycleHandler = (LifecycleHandler) activity.getFragmentManager().findFragmentByTag("LifecycleHandler");
        }
        if (lifecycleHandler != null) {
            lifecycleHandler.m2760c(activity);
        }
        return lifecycleHandler;
    }

    public static LifecycleHandler m2756a(Activity activity) {
        LifecycleHandler b = m2758b(activity);
        if (b == null) {
            b = new LifecycleHandler();
            activity.getFragmentManager().beginTransaction().add(b, "LifecycleHandler").commit();
        }
        b.m2760c(activity);
        return b;
    }

    public static int m2755a(ViewGroup viewGroup) {
        return viewGroup.getId();
    }

    private void m2760c(Activity activity) {
        this.f3167a = activity;
        if (!this.f3170d) {
            this.f3170d = true;
            activity.getApplication().registerActivityLifecycleCallbacks(this);
            f3166g.put(activity, this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            SparseArray sparseArray;
            StringSparseArrayParceler stringSparseArrayParceler = (StringSparseArrayParceler) bundle.getParcelable("LifecycleHandler.permissionRequests");
            if (stringSparseArrayParceler != null) {
                sparseArray = stringSparseArrayParceler.f3175a;
            } else {
                sparseArray = new SparseArray();
            }
            this.f3173h = sparseArray;
            stringSparseArrayParceler = (StringSparseArrayParceler) bundle.getParcelable("LifecycleHandler.activityRequests");
            if (stringSparseArrayParceler != null) {
                sparseArray = stringSparseArrayParceler.f3175a;
            } else {
                sparseArray = new SparseArray();
            }
            this.f3168b = sparseArray;
            bundle = bundle.getParcelableArrayList("LifecycleHandler.pendingPermissionRequests");
            if (bundle == null) {
                bundle = new ArrayList();
            }
            this.f3174i = bundle;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("LifecycleHandler.permissionRequests", new StringSparseArrayParceler(this.f3173h));
        bundle.putParcelable("LifecycleHandler.activityRequests", new StringSparseArrayParceler(this.f3168b));
        bundle.putParcelableArrayList("LifecycleHandler.pendingPermissionRequests", this.f3174i);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f3167a != null) {
            this.f3167a.getApplication().unregisterActivityLifecycleCallbacks(this);
            f3166g.remove(this.f3167a);
            m2759b();
            this.f3167a = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3171e = null;
        m2757a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f3171e = null;
        m2757a();
    }

    public void onDetach() {
        super.onDetach();
        this.f3172f = false;
        m2759b();
    }

    private void m2757a() {
        if (!this.f3172f) {
            this.f3172f = true;
            for (int size = this.f3174i.size() - 1; size >= 0; size--) {
                PendingPermissionRequest pendingPermissionRequest = (PendingPermissionRequest) this.f3174i.remove(size);
                m2761a(pendingPermissionRequest.f3163a, pendingPermissionRequest.f3164b, pendingPermissionRequest.f3165c);
            }
        }
        for (ActivityHostedRouter g : this.f3169c.values()) {
            g.mo846g();
        }
    }

    private void m2759b() {
        if (!this.f3171e) {
            this.f3171e = true;
            if (this.f3167a != null) {
                for (Router a : this.f3169c.values()) {
                    a.mo834a(this.f3167a);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = (String) this.f3168b.get(i);
        if (str != null) {
            for (Router c : this.f3169c.values()) {
                Controller c2 = c.m2723c(str);
                if (c2 != null) {
                    c2.m2634a(i, i2, intent);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        String str = (String) this.f3173h.get(i);
        if (str != null) {
            for (Router c : this.f3169c.values()) {
                Controller c2 = c.m2723c(str);
                if (c2 != null) {
                    c2.f3110u.removeAll(Arrays.asList(strArr));
                    c2.m2635a(i, strArr, iArr);
                }
            }
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        for (Router router : this.f3169c.values()) {
            Boolean valueOf;
            Iterator it = router.f3138c.iterator();
            while (it.hasNext()) {
                RouterTransaction routerTransaction = (RouterTransaction) it.next();
                if (routerTransaction.f3144a.f3110u.contains(str)) {
                    boolean z = VERSION.SDK_INT >= 23 && routerTransaction.f3144a.am_().shouldShowRequestPermissionRationale(str);
                    valueOf = Boolean.valueOf(z);
                    continue;
                    if (valueOf != null) {
                        return valueOf.booleanValue();
                    }
                }
            }
            valueOf = null;
            continue;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        return super.shouldShowRequestPermissionRationale(str);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        for (Router a : this.f3169c.values()) {
            a.m2705a(menu, menuInflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        for (Router a : this.f3169c.values()) {
            a.m2704a(menu);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        for (Router a : this.f3169c.values()) {
            if (a.m2713a(menuItem)) {
                return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @TargetApi(23)
    public final void m2761a(String str, String[] strArr, int i) {
        if (this.f3172f) {
            this.f3173h.put(i, str);
            requestPermissions(strArr, i);
            return;
        }
        this.f3174i.add(new PendingPermissionRequest(str, strArr, i));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f3167a == null && m2758b(activity) == this) {
            this.f3167a = activity;
            for (ActivityHostedRouter g : this.f3169c.values()) {
                g.mo846g();
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.f3167a == activity) {
            for (Router b : this.f3169c.values()) {
                b.m2716b(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.f3167a == activity) {
            for (Router c : this.f3169c.values()) {
                c.m2724c(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        if (this.f3167a == activity) {
            for (Router d : this.f3169c.values()) {
                d.m2728d(activity);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.f3167a == activity) {
            for (Router e : this.f3169c.values()) {
                e.m2731e(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.f3167a == activity) {
            for (Router router : this.f3169c.values()) {
                Bundle bundle2 = new Bundle();
                router.mo836a(bundle2);
                StringBuilder stringBuilder = new StringBuilder("LifecycleHandler.routerState");
                stringBuilder.append(router.m2736k());
                bundle.putBundle(stringBuilder.toString(), bundle2);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        f3166g.remove(activity);
    }
}
