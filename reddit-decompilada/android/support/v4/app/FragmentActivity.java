package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.ActivityCompat.PermissionCompatDelegate;
import android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends BaseFragmentActivityApi16 implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final FragmentController mFragments = FragmentController.m549a(new HostCallbacks(this));
    final Handler mHandler = new C00821(this);
    int mNextCandidateRequestIndex;
    SparseArrayCompat<String> mPendingFragmentActivityResults;
    boolean mReallyStopped = true;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped = true;

    class C00821 extends Handler {
        final /* synthetic */ FragmentActivity f976a;

        C00821(FragmentActivity fragmentActivity) {
            this.f976a = fragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f976a.mStopped != null) {
                        this.f976a.doReallyStop(false);
                        return;
                    }
                    break;
                case 2:
                    this.f976a.onResumeFragments();
                    this.f976a.mFragments.m553b();
                    return;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    }

    static final class NonConfigurationInstances {
        Object f977a;
        FragmentManagerNonConfig f978b;
        SimpleArrayMap<String, LoaderManager> f979c;

        NonConfigurationInstances() {
        }
    }

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
        final /* synthetic */ FragmentActivity f16496a;

        public HostCallbacks(FragmentActivity fragmentActivity) {
            this.f16496a = fragmentActivity;
            super(fragmentActivity);
        }

        public final void mo3124a(String str, PrintWriter printWriter, String[] strArr) {
            this.f16496a.dump(str, null, printWriter, strArr);
        }

        public final boolean mo3126b() {
            return !this.f16496a.isFinishing();
        }

        public final LayoutInflater mo3127c() {
            return this.f16496a.getLayoutInflater().cloneInContext(this.f16496a);
        }

        public final void mo3128d() {
            this.f16496a.supportInvalidateOptionsMenu();
        }

        public final void mo3121a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f16496a.startActivityFromFragment(fragment, intent, i, bundle);
        }

        public final void mo3122a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
            this.f16496a.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public final void mo3123a(Fragment fragment, String[] strArr, int i) {
            this.f16496a.requestPermissionsFromFragment(fragment, strArr, i);
        }

        public final boolean mo3125a(String str) {
            return ActivityCompat.m9757a(this.f16496a, str);
        }

        public final boolean mo3129e() {
            return this.f16496a.getWindow() != null;
        }

        public final int mo3130f() {
            Window window = this.f16496a.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public final void mo3120a(Fragment fragment) {
            this.f16496a.onAttachFragment(fragment);
        }

        public final View mo209a(int i) {
            return this.f16496a.findViewById(i);
        }

        public final boolean mo210a() {
            Window window = this.f16496a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object mo3131g() {
            return this.f16496a;
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @RequiresApi(16)
    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @RequiresApi(16)
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m551a();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            String str = (String) this.mPendingFragmentActivityResults.m1059a(i3);
            this.mPendingFragmentActivityResults.m1062b(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.mFragments.m550a(str);
            if (a == null) {
                i = TAG;
                i2 = new StringBuilder("Activity result no fragment exists for who: ");
                i2.append(str);
                Log.w(i, i2.toString());
                return;
            }
            a.onActivityResult(i & 65535, i2, intent);
            return;
        }
        PermissionCompatDelegate a2 = ActivityCompat.m9751a();
        if (a2 == null || !a2.m518b()) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = this.mFragments.f980a.f11278f;
        boolean g = fragmentManager.mo230g();
        if (!g || VERSION.SDK_INT > 25) {
            if (g || !fragmentManager.mo227d()) {
                super.onBackPressed();
            }
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.m9758b(this);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.m9755a((Activity) this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.m9759b(this, sharedElementCallback);
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.m9760c(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.m9761d(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f980a.f11278f.m9886a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f980a.f11278f.m9896b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.f980a.f11278f.m9877a(configuration);
    }

    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    public void onCreate(Bundle bundle) {
        FragmentController fragmentController = this.mFragments;
        FragmentManagerNonConfig fragmentManagerNonConfig = null;
        fragmentController.f980a.f11278f.m9882a(fragmentController.f980a, fragmentController.f980a, null);
        super.onCreate(bundle);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            FragmentController fragmentController2 = this.mFragments;
            SimpleArrayMap simpleArrayMap = nonConfigurationInstances.f979c;
            FragmentHostCallback fragmentHostCallback = fragmentController2.f980a;
            if (simpleArrayMap != null) {
                int size = simpleArrayMap.size();
                for (int i = 0; i < size; i++) {
                    ((LoaderManagerImpl) simpleArrayMap.m1054c(i)).f11377h = fragmentHostCallback;
                }
            }
            fragmentHostCallback.f11279g = simpleArrayMap;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            FragmentController fragmentController3 = this.mFragments;
            if (nonConfigurationInstances != null) {
                fragmentManagerNonConfig = nonConfigurationInstances.f978b;
            }
            fragmentController3.f980a.f11278f.m9879a(parcelable, fragmentManagerNonConfig);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                bundle = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (!(intArray == null || bundle == null)) {
                    if (intArray.length == bundle.length) {
                        this.mPendingFragmentActivityResults = new SparseArrayCompat(intArray.length);
                        for (int i2 = 0; i2 < intArray.length; i2++) {
                            this.mPendingFragmentActivityResults.m1060a(intArray[i2], bundle[i2]);
                        }
                    }
                }
                Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new SparseArrayCompat();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.f980a.f11278f.m9916l();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        i = super.onCreatePanelMenu(i, menu);
        FragmentController fragmentController = this.mFragments;
        return i | fragmentController.f980a.f11278f.m9888a(menu, getMenuInflater());
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f980a.f11278f.onCreateView(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.f980a.f11278f.m9921q();
        FragmentHostCallback fragmentHostCallback = this.mFragments.f980a;
        if (fragmentHostCallback.f11281i != null) {
            fragmentHostCallback.f11281i.m9993g();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f980a.f11278f.m9922r();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.f980a.f11278f.m9889a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.f980a.f11278f.m9898b(menuItem);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.f980a.f11278f.m9894b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.f980a.f11278f.m9901c(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.m551a();
    }

    public void onStateNotSaved() {
        this.mFragments.m551a();
    }

    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.m553b();
    }

    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.m553b();
    }

    protected void onResumeFragments() {
        this.mFragments.f980a.f11278f.m9919o();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : onPrepareOptionsPanel(view, menu) | this.mFragments.f980a.f11278f.m9887a(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        SimpleArrayMap simpleArrayMap;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.f980a.f11278f;
        FragmentManagerImpl.m9833a(fragmentManagerImpl.f11304C);
        FragmentManagerNonConfig fragmentManagerNonConfig = fragmentManagerImpl.f11304C;
        FragmentHostCallback fragmentHostCallback = this.mFragments.f980a;
        int i = 0;
        if (fragmentHostCallback.f11279g != null) {
            int size = fragmentHostCallback.f11279g.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                loaderManagerImplArr[i2] = (LoaderManagerImpl) fragmentHostCallback.f11279g.m1054c(i2);
            }
            boolean z = fragmentHostCallback.f11280h;
            int i3 = 0;
            while (i < size) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i];
                if (!loaderManagerImpl.f11375f && z) {
                    if (!loaderManagerImpl.f11374e) {
                        loaderManagerImpl.m9988b();
                    }
                    loaderManagerImpl.m9990d();
                }
                if (loaderManagerImpl.f11375f) {
                    i3 = true;
                } else {
                    loaderManagerImpl.m9993g();
                    fragmentHostCallback.f11279g.remove(loaderManagerImpl.f11373d);
                }
                i++;
            }
            i = i3;
        }
        if (i != 0) {
            simpleArrayMap = fragmentHostCallback.f11279g;
        } else {
            simpleArrayMap = null;
        }
        if (fragmentManagerNonConfig == null && simpleArrayMap == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.f977a = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances.f978b = fragmentManagerNonConfig;
        nonConfigurationInstances.f979c = simpleArrayMap;
        return nonConfigurationInstances;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable j = this.mFragments.f980a.f11278f.m9913j();
        if (j != null) {
            bundle.putParcelable(FRAGMENTS_TAG, j);
        }
        if (this.mPendingFragmentActivityResults.m1058a() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.m1058a()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.m1058a()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.m1058a(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.m1064c(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.m1065d(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.f980a.f11278f.m9917m();
        }
        this.mFragments.m551a();
        this.mFragments.m553b();
        this.mFragments.m554c();
        this.mFragments.f980a.f11278f.m9918n();
        FragmentHostCallback fragmentHostCallback = this.mFragments.f980a;
        if (fragmentHostCallback.f11279g != null) {
            int size = fragmentHostCallback.f11279g.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) fragmentHostCallback.f11279g.m1054c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                if (loaderManagerImpl.f11375f) {
                    if (LoaderManagerImpl.f11370a) {
                        StringBuilder stringBuilder = new StringBuilder("Finished Retaining in ");
                        stringBuilder.append(loaderManagerImpl);
                        Log.v("LoaderManager", stringBuilder.toString());
                    }
                    loaderManagerImpl.f11375f = false;
                    for (int a = loaderManagerImpl.f11371b.m1058a() - 1; a >= 0; a--) {
                        LoaderInfo loaderInfo = (LoaderInfo) loaderManagerImpl.f11371b.m1065d(a);
                        if (loaderInfo.f11363i) {
                            if (LoaderManagerImpl.f11370a) {
                                StringBuilder stringBuilder2 = new StringBuilder("  Finished Retaining: ");
                                stringBuilder2.append(loaderInfo);
                                Log.v("LoaderManager", stringBuilder2.toString());
                            }
                            loaderInfo.f11363i = false;
                            if (!(loaderInfo.f11362h == loaderInfo.f11364j || loaderInfo.f11362h)) {
                                loaderInfo.m9977b();
                            }
                        }
                        if (loaderInfo.f11362h && loaderInfo.f11359e && !loaderInfo.f11365k) {
                            loaderInfo.m9978b(loaderInfo.f11358d, loaderInfo.f11361g);
                        }
                    }
                }
                loaderManagerImpl.m9992f();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.f980a.f11278f.m9920p();
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        return nonConfigurationInstances != null ? nonConfigurationInstances.f977a : null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        String stringBuilder2 = stringBuilder.toString();
        printWriter.print(stringBuilder2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        FragmentHostCallback fragmentHostCallback = this.mFragments.f980a;
        printWriter.print(stringBuilder2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(fragmentHostCallback.f11283k);
        if (fragmentHostCallback.f11281i != null) {
            printWriter.print(stringBuilder2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(fragmentHostCallback.f11281i)));
            printWriter.println(":");
            LoaderManagerImpl loaderManagerImpl = fragmentHostCallback.f11281i;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("  ");
            loaderManagerImpl.m9985a(stringBuilder3.toString(), fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f980a.f11278f.mo222a(str, fileDescriptor, printWriter, strArr);
    }

    void doReallyStop(boolean z) {
        if (this.mReallyStopped) {
            if (z) {
                this.mFragments.m554c();
                this.mFragments.m552a(true);
            }
            return;
        }
        this.mReallyStopped = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        onReallyStop();
    }

    void onReallyStop() {
        this.mFragments.m552a(this.mRetaining);
        this.mFragments.f980a.f11278f.m9901c(2);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.f980a.f11278f;
    }

    public LoaderManager getSupportLoaderManager() {
        FragmentHostCallback fragmentHostCallback = this.mFragments.f980a;
        if (fragmentHostCallback.f11281i != null) {
            return fragmentHostCallback.f11281i;
        }
        fragmentHostCallback.f11282j = true;
        fragmentHostCallback.f11281i = fragmentHostCallback.m9798a("(root)", fragmentHostCallback.f11283k, true);
        return fragmentHostCallback.f11281i;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            BaseFragmentActivityApi14.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            BaseFragmentActivityApi14.checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.m551a();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            i2--;
            String str = (String) this.mPendingFragmentActivityResults.m1059a(i2);
            this.mPendingFragmentActivityResults.m1062b(i2);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.mFragments.m550a(str);
            if (a == null) {
                i = TAG;
                strArr = new StringBuilder("Activity result no fragment exists for who: ");
                strArr.append(str);
                Log.w(i, strArr.toString());
                return;
            }
            a.onRequestPermissionsResult(i & 65535, strArr, iArr);
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                ActivityCompat.m9753a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            BaseFragmentActivityApi14.checkForValidRequestCode(i);
            ActivityCompat.m9753a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                ActivityCompat.m9754a(r9, intentSender, i5, intent, i2, i3, i4, bundle);
                r9.mStartedIntentSenderFromFragment = false;
            } catch (Throwable th) {
                Throwable th2 = th;
                r9.mStartedIntentSenderFromFragment = false;
            }
        } else {
            BaseFragmentActivityApi14.checkForValidRequestCode(i5);
            ActivityCompat.m9754a(r9, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i5), intent, i2, i3, i4, bundle);
            r9.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.m1058a() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.m1066e(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.m1060a(i, fragment.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
        return i;
    }

    void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ActivityCompat.m9756a(this, strArr, i);
            return;
        }
        BaseFragmentActivityApi14.checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            ActivityCompat.m9756a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), State.CREATED));
    }

    private static boolean markState(FragmentManager fragmentManager, State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.mo229f()) {
            if (fragment != null) {
                if (fragment.getLifecycle().mo2a().isAtLeast(State.STARTED)) {
                    fragment.mLifecycleRegistry.m9414a(state);
                    z = true;
                }
                FragmentManager peekChildFragmentManager = fragment.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    z |= markState(peekChildFragmentManager, state);
                }
            }
        }
        return z;
    }
}
