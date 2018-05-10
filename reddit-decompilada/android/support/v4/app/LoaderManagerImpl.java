package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCanceledListener;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager */
class LoaderManagerImpl extends LoaderManager {
    static boolean f11370a = false;
    final SparseArrayCompat<LoaderInfo> f11371b = new SparseArrayCompat();
    final SparseArrayCompat<LoaderInfo> f11372c = new SparseArrayCompat();
    final String f11373d;
    boolean f11374e;
    boolean f11375f;
    boolean f11376g;
    FragmentHostCallback f11377h;

    /* compiled from: LoaderManager */
    final class LoaderInfo implements OnLoadCanceledListener<Object>, OnLoadCompleteListener<Object> {
        final int f11355a;
        final Bundle f11356b = null;
        LoaderCallbacks<Object> f11357c;
        Loader<Object> f11358d;
        boolean f11359e;
        boolean f11360f;
        Object f11361g;
        boolean f11362h;
        boolean f11363i;
        boolean f11364j;
        boolean f11365k;
        boolean f11366l;
        boolean f11367m;
        LoaderInfo f11368n;
        final /* synthetic */ LoaderManagerImpl f11369o;

        public LoaderInfo(LoaderManagerImpl loaderManagerImpl, int i, Bundle bundle) {
            this.f11369o = loaderManagerImpl;
            this.f11355a = i;
            this.f11357c = bundle;
        }

        final void m9974a() {
            if (this.f11363i && this.f11364j) {
                this.f11362h = true;
            } else if (!this.f11362h) {
                this.f11362h = true;
                if (LoaderManagerImpl.f11370a) {
                    StringBuilder stringBuilder = new StringBuilder("  Starting: ");
                    stringBuilder.append(this);
                    Log.v("LoaderManager", stringBuilder.toString());
                }
                if (this.f11358d == null && this.f11357c != null) {
                    this.f11358d = this.f11357c.mo1526a();
                }
                if (this.f11358d != null) {
                    if (!this.f11358d.getClass().isMemberClass() || Modifier.isStatic(this.f11358d.getClass().getModifiers())) {
                        if (!this.f11367m) {
                            Loader loader = this.f11358d;
                            int i = this.f11355a;
                            if (loader.f1187g != null) {
                                throw new IllegalStateException("There is already a listener registered");
                            }
                            loader.f1187g = this;
                            loader.f1186f = i;
                            loader = this.f11358d;
                            if (loader.f1188h != null) {
                                throw new IllegalStateException("There is already a listener registered");
                            }
                            loader.f1188h = this;
                            this.f11367m = true;
                        }
                        this.f11358d.m736e();
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ");
                        stringBuilder2.append(this.f11358d);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                }
            }
        }

        final void m9977b() {
            if (LoaderManagerImpl.f11370a) {
                StringBuilder stringBuilder = new StringBuilder("  Stopping: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.f11362h = false;
            if (!this.f11363i && this.f11358d != null && this.f11367m) {
                this.f11367m = false;
                this.f11358d.m732a((OnLoadCompleteListener) this);
                this.f11358d.m731a((OnLoadCanceledListener) this);
                this.f11358d.m740i();
            }
        }

        final void m9979c() {
            String str;
            OnLoadCanceledListener onLoadCanceledListener = this;
            while (true) {
                if (LoaderManagerImpl.f11370a) {
                    StringBuilder stringBuilder = new StringBuilder("  Destroying: ");
                    stringBuilder.append(onLoadCanceledListener);
                    Log.v("LoaderManager", stringBuilder.toString());
                }
                onLoadCanceledListener.f11366l = true;
                boolean z = onLoadCanceledListener.f11360f;
                onLoadCanceledListener.f11360f = false;
                if (onLoadCanceledListener.f11357c != null && onLoadCanceledListener.f11358d != null && onLoadCanceledListener.f11359e && z) {
                    if (LoaderManagerImpl.f11370a) {
                        StringBuilder stringBuilder2 = new StringBuilder("  Resetting: ");
                        stringBuilder2.append(onLoadCanceledListener);
                        Log.v("LoaderManager", stringBuilder2.toString());
                    }
                    if (onLoadCanceledListener.f11369o.f11377h != null) {
                        str = onLoadCanceledListener.f11369o.f11377h.f11278f.f11325u;
                        onLoadCanceledListener.f11369o.f11377h.f11278f.f11325u = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        onLoadCanceledListener.f11357c.mo1528b();
                    } finally {
                        if (onLoadCanceledListener.f11369o.f11377h != null) {
                            onLoadCanceledListener = onLoadCanceledListener.f11369o.f11377h.f11278f;
                            onLoadCanceledListener.f11325u = str;
                        }
                    }
                }
                onLoadCanceledListener.f11357c = null;
                onLoadCanceledListener.f11361g = null;
                onLoadCanceledListener.f11359e = false;
                if (onLoadCanceledListener.f11358d != null) {
                    if (onLoadCanceledListener.f11367m) {
                        onLoadCanceledListener.f11367m = false;
                        onLoadCanceledListener.f11358d.m732a((OnLoadCompleteListener) onLoadCanceledListener);
                        onLoadCanceledListener.f11358d.m731a(onLoadCanceledListener);
                    }
                    onLoadCanceledListener.f11358d.m742k();
                }
                if (onLoadCanceledListener.f11368n != null) {
                    onLoadCanceledListener = onLoadCanceledListener.f11368n;
                } else {
                    return;
                }
            }
        }

        public final void mo251d() {
            if (LoaderManagerImpl.f11370a) {
                StringBuilder stringBuilder = new StringBuilder("onLoadCanceled: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            if (this.f11366l) {
                if (LoaderManagerImpl.f11370a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (this.f11369o.f11371b.m1059a(this.f11355a) != this) {
                if (LoaderManagerImpl.f11370a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- not active");
                }
            } else {
                LoaderInfo loaderInfo = this.f11368n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f11370a) {
                        StringBuilder stringBuilder2 = new StringBuilder("  Switching to pending loader: ");
                        stringBuilder2.append(loaderInfo);
                        Log.v("LoaderManager", stringBuilder2.toString());
                    }
                    this.f11368n = null;
                    this.f11369o.f11371b.m1060a(this.f11355a, null);
                    m9979c();
                    this.f11369o.m9984a(loaderInfo);
                }
            }
        }

        public final void mo250a(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.f11370a) {
                StringBuilder stringBuilder = new StringBuilder("onLoadComplete: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            if (this.f11366l) {
                if (LoaderManagerImpl.f11370a != null) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.f11369o.f11371b.m1059a(this.f11355a) != this) {
                if (LoaderManagerImpl.f11370a != null) {
                    Log.v("LoaderManager", "  Ignoring load complete -- not active");
                }
            } else {
                LoaderInfo loaderInfo = this.f11368n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f11370a != null) {
                        obj = new StringBuilder("  Switching to pending loader: ");
                        obj.append(loaderInfo);
                        Log.v("LoaderManager", obj.toString());
                    }
                    this.f11368n = null;
                    this.f11369o.f11371b.m1060a(this.f11355a, null);
                    m9979c();
                    this.f11369o.m9984a(loaderInfo);
                    return;
                }
                if (!(this.f11361g == obj && this.f11359e)) {
                    this.f11361g = obj;
                    this.f11359e = true;
                    if (this.f11362h) {
                        m9978b(loader, obj);
                    }
                }
                LoaderInfo loaderInfo2 = (LoaderInfo) this.f11369o.f11372c.m1059a(this.f11355a);
                if (!(loaderInfo2 == null || loaderInfo2 == this)) {
                    loaderInfo2.f11360f = null;
                    loaderInfo2.m9979c();
                    this.f11369o.f11372c.m1062b(this.f11355a);
                }
                if (this.f11369o.f11377h != null && this.f11369o.mo253a() == null) {
                    this.f11369o.f11377h.f11278f.m9909h();
                }
            }
        }

        final void m9978b(Loader<Object> loader, Object obj) {
            if (this.f11357c != null) {
                String str = null;
                if (this.f11369o.f11377h != null) {
                    str = this.f11369o.f11377h.f11278f.f11325u;
                    this.f11369o.f11377h.f11278f.f11325u = "onLoadFinished";
                }
                try {
                    if (LoaderManagerImpl.f11370a) {
                        StringBuilder stringBuilder = new StringBuilder("  onLoadFinished in ");
                        stringBuilder.append(loader);
                        stringBuilder.append(": ");
                        stringBuilder.append(Loader.m729c(obj));
                        Log.v("LoaderManager", stringBuilder.toString());
                    }
                    this.f11357c.mo1527a(obj);
                    this.f11360f = true;
                } finally {
                    if (this.f11369o.f11377h != null) {
                        this.f11369o.f11377h.f11278f.f11325u = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f11355a);
            stringBuilder.append(" : ");
            DebugUtils.m1011a(this.f11358d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void m9976a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            LoaderInfo loaderInfo = this;
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(loaderInfo.f11355a);
                printWriter.print(" mArgs=");
                printWriter.println(loaderInfo.f11356b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(loaderInfo.f11357c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(loaderInfo.f11358d);
                if (loaderInfo.f11358d != null) {
                    Loader loader = loaderInfo.f11358d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("  ");
                    loader.mo263a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
                }
                if (loaderInfo.f11359e || loaderInfo.f11360f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(loaderInfo.f11359e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(loaderInfo.f11360f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(loaderInfo.f11361g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(loaderInfo.f11362h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(loaderInfo.f11365k);
                printWriter.print(" mDestroyed=");
                printWriter.println(loaderInfo.f11366l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(loaderInfo.f11363i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(loaderInfo.f11364j);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(loaderInfo.f11367m);
                if (loaderInfo.f11368n != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(loaderInfo.f11368n);
                    printWriter.println(":");
                    loaderInfo = loaderInfo.f11368n;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("  ");
                    str = stringBuilder2.toString();
                } else {
                    return;
                }
            }
        }
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.f11373d = str;
        this.f11377h = fragmentHostCallback;
        this.f11374e = z;
    }

    private LoaderInfo m9981c(int i, LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo = new LoaderInfo(this, i, loaderCallbacks);
        loaderInfo.f11358d = loaderCallbacks.mo1526a();
        return loaderInfo;
    }

    private LoaderInfo m9982d(int i, LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.f11376g = true;
            i = m9981c(i, loaderCallbacks);
            m9984a(i);
            return i;
        } finally {
            this.f11376g = false;
        }
    }

    final void m9984a(LoaderInfo loaderInfo) {
        this.f11371b.m1060a(loaderInfo.f11355a, loaderInfo);
        if (this.f11374e) {
            loaderInfo.m9974a();
        }
    }

    public final <D> Loader<D> mo252a(int i, LoaderCallbacks<D> loaderCallbacks) {
        if (this.f11376g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1059a(i);
        if (f11370a) {
            StringBuilder stringBuilder = new StringBuilder("initLoader in ");
            stringBuilder.append(this);
            stringBuilder.append(": args=");
            stringBuilder.append(null);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        if (loaderInfo == null) {
            loaderInfo = m9982d(i, loaderCallbacks);
            if (f11370a != 0) {
                loaderCallbacks = new StringBuilder("  Created new loader ");
                loaderCallbacks.append(loaderInfo);
                Log.v("LoaderManager", loaderCallbacks.toString());
            }
        } else {
            if (f11370a != 0) {
                StringBuilder stringBuilder2 = new StringBuilder("  Re-using existing loader ");
                stringBuilder2.append(loaderInfo);
                Log.v("LoaderManager", stringBuilder2.toString());
            }
            loaderInfo.f11357c = loaderCallbacks;
        }
        if (!(loaderInfo.f11359e == 0 || this.f11374e == 0)) {
            loaderInfo.m9978b(loaderInfo.f11358d, loaderInfo.f11361g);
        }
        return loaderInfo.f11358d;
    }

    public final <D> Loader<D> mo254b(int i, LoaderCallbacks<D> loaderCallbacks) {
        if (this.f11376g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1059a(i);
        if (f11370a) {
            StringBuilder stringBuilder = new StringBuilder("restartLoader in ");
            stringBuilder.append(this);
            stringBuilder.append(": args=");
            stringBuilder.append(null);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        if (loaderInfo != null) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.f11372c.m1059a(i);
            if (loaderInfo2 != null) {
                boolean z = false;
                if (loaderInfo.f11359e) {
                    if (f11370a) {
                        stringBuilder = new StringBuilder("  Removing last inactive loader: ");
                        stringBuilder.append(loaderInfo);
                        Log.v("LoaderManager", stringBuilder.toString());
                    }
                    loaderInfo2.f11360f = false;
                    loaderInfo2.m9979c();
                } else {
                    if (f11370a) {
                        stringBuilder = new StringBuilder("  Canceling: ");
                        stringBuilder.append(loaderInfo);
                        Log.v("LoaderManager", stringBuilder.toString());
                    }
                    if (loaderInfo.f11362h && loaderInfo.f11358d != null && loaderInfo.f11367m) {
                        z = loaderInfo.f11358d.m738g();
                        if (!z) {
                            loaderInfo.mo251d();
                        }
                    }
                    if (z) {
                        if (f11370a) {
                            Log.v("LoaderManager", "  Current loader is running; configuring pending loader");
                        }
                        if (loaderInfo.f11368n != null) {
                            if (f11370a) {
                                stringBuilder = new StringBuilder("  Removing pending loader: ");
                                stringBuilder.append(loaderInfo.f11368n);
                                Log.v("LoaderManager", stringBuilder.toString());
                            }
                            loaderInfo.f11368n.m9979c();
                            loaderInfo.f11368n = null;
                        }
                        if (f11370a) {
                            Log.v("LoaderManager", "  Enqueuing as new pending loader");
                        }
                        loaderInfo.f11368n = m9981c(i, loaderCallbacks);
                        return loaderInfo.f11368n.f11358d;
                    }
                    if (f11370a) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    this.f11371b.m1060a(i, null);
                    loaderInfo.m9979c();
                }
            } else if (f11370a) {
                StringBuilder stringBuilder2 = new StringBuilder("  Making last loader inactive: ");
                stringBuilder2.append(loaderInfo);
                Log.v("LoaderManager", stringBuilder2.toString());
            }
            loaderInfo.f11358d.f1191k = true;
            this.f11372c.m1060a(i, loaderInfo);
        }
        return m9982d(i, loaderCallbacks).f11358d;
    }

    final void m9988b() {
        if (f11370a) {
            StringBuilder stringBuilder = new StringBuilder("Starting in ");
            stringBuilder.append(this);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        if (this.f11374e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            StringBuilder stringBuilder2 = new StringBuilder("Called doStart when already started: ");
            stringBuilder2.append(this);
            Log.w("LoaderManager", stringBuilder2.toString(), runtimeException);
            return;
        }
        this.f11374e = true;
        for (int a = this.f11371b.m1058a() - 1; a >= 0; a--) {
            ((LoaderInfo) this.f11371b.m1065d(a)).m9974a();
        }
    }

    final void m9989c() {
        if (f11370a) {
            StringBuilder stringBuilder = new StringBuilder("Stopping in ");
            stringBuilder.append(this);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        if (this.f11374e) {
            for (int a = this.f11371b.m1058a() - 1; a >= 0; a--) {
                ((LoaderInfo) this.f11371b.m1065d(a)).m9977b();
            }
            this.f11374e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        StringBuilder stringBuilder2 = new StringBuilder("Called doStop when not started: ");
        stringBuilder2.append(this);
        Log.w("LoaderManager", stringBuilder2.toString(), runtimeException);
    }

    final void m9990d() {
        if (f11370a) {
            StringBuilder stringBuilder = new StringBuilder("Retaining in ");
            stringBuilder.append(this);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        if (this.f11374e) {
            this.f11375f = true;
            this.f11374e = false;
            for (int a = this.f11371b.m1058a() - 1; a >= 0; a--) {
                LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1065d(a);
                if (f11370a) {
                    StringBuilder stringBuilder2 = new StringBuilder("  Retaining: ");
                    stringBuilder2.append(loaderInfo);
                    Log.v("LoaderManager", stringBuilder2.toString());
                }
                loaderInfo.f11363i = true;
                loaderInfo.f11364j = loaderInfo.f11362h;
                loaderInfo.f11362h = false;
                loaderInfo.f11357c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        StringBuilder stringBuilder3 = new StringBuilder("Called doRetain when not started: ");
        stringBuilder3.append(this);
        Log.w("LoaderManager", stringBuilder3.toString(), runtimeException);
    }

    final void m9991e() {
        for (int a = this.f11371b.m1058a() - 1; a >= 0; a--) {
            ((LoaderInfo) this.f11371b.m1065d(a)).f11365k = true;
        }
    }

    final void m9992f() {
        for (int a = this.f11371b.m1058a() - 1; a >= 0; a--) {
            LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1065d(a);
            if (loaderInfo.f11362h && loaderInfo.f11365k) {
                loaderInfo.f11365k = false;
                if (loaderInfo.f11359e && !loaderInfo.f11363i) {
                    loaderInfo.m9978b(loaderInfo.f11358d, loaderInfo.f11361g);
                }
            }
        }
    }

    final void m9993g() {
        int a;
        if (!this.f11375f) {
            if (f11370a) {
                StringBuilder stringBuilder = new StringBuilder("Destroying Active in ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            for (a = this.f11371b.m1058a() - 1; a >= 0; a--) {
                ((LoaderInfo) this.f11371b.m1065d(a)).m9979c();
            }
            this.f11371b.m1061b();
        }
        if (f11370a) {
            stringBuilder = new StringBuilder("Destroying Inactive in ");
            stringBuilder.append(this);
            Log.v("LoaderManager", stringBuilder.toString());
        }
        for (a = this.f11372c.m1058a() - 1; a >= 0; a--) {
            ((LoaderInfo) this.f11372c.m1065d(a)).m9979c();
        }
        this.f11372c.m1061b();
        this.f11377h = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.m1011a(this.f11377h, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void m9985a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String stringBuilder;
        int i = 0;
        if (this.f11371b.m1058a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("    ");
            stringBuilder = stringBuilder2.toString();
            for (int i2 = 0; i2 < this.f11371b.m1058a(); i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1065d(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f11371b.m1064c(i2));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m9976a(stringBuilder, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f11372c.m1058a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("    ");
            stringBuilder = stringBuilder2.toString();
            while (i < this.f11372c.m1058a()) {
                LoaderInfo loaderInfo2 = (LoaderInfo) this.f11372c.m1065d(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f11372c.m1064c(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo2.toString());
                loaderInfo2.m9976a(stringBuilder, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean mo253a() {
        int a = this.f11371b.m1058a();
        int i = 0;
        boolean z = i;
        while (i < a) {
            LoaderInfo loaderInfo = (LoaderInfo) this.f11371b.m1065d(i);
            int i2 = (!loaderInfo.f11362h || loaderInfo.f11360f) ? 0 : 1;
            z |= i2;
            i++;
        }
        return z;
    }
}
