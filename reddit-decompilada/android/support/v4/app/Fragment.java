package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements LifecycleOwner, ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    FragmentManagerImpl mChildFragmentManager;
    FragmentManagerNonConfig mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible = true;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    int mState = 0;
    String mTag;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    String mWho;

    class C00801 implements Runnable {
        final /* synthetic */ Fragment f956a;

        C00801(Fragment fragment) {
            this.f956a = fragment;
        }

        public void run() {
            this.f956a.callStartTransitionListener();
        }
    }

    static class AnimationInfo {
        View f957a;
        Animator f958b;
        int f959c;
        int f960d;
        int f961e;
        int f962f;
        SharedElementCallback f963g = null;
        SharedElementCallback f964h = null;
        boolean f965i;
        OnStartEnterTransitionListener f966j;
        boolean f967k;
        private Object f968l = null;
        private Object f969m = Fragment.USE_DEFAULT_TRANSITION;
        private Object f970n = null;
        private Object f971o = Fragment.USE_DEFAULT_TRANSITION;
        private Object f972p = null;
        private Object f973q = Fragment.USE_DEFAULT_TRANSITION;
        private Boolean f974r;
        private Boolean f975s;

        AnimationInfo() {
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exception) {
            super(str, exception);
        }
    }

    interface OnStartEnterTransitionListener {
        void mo213a();

        void mo214b();
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C00811();
        final Bundle mState;

        static class C00811 implements Creator<SavedState> {
            C00811() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public int describeContents() {
            return 0;
        }

        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.mState = parcel.readBundle();
            if (classLoader != null && this.mState != null) {
                this.mState.setClassLoader(classLoader);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    class C09992 extends FragmentContainer {
        final /* synthetic */ Fragment f11273a;

        C09992(Fragment fragment) {
            this.f11273a = fragment;
        }

        public final View mo209a(int i) {
            if (this.f11273a.mView != null) {
                return this.f11273a.mView.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public final boolean mo210a() {
            return this.f11273a.mView != null;
        }

        public final Fragment mo208a(Context context, String str, Bundle bundle) {
            return this.f11273a.mHost.mo208a(context, str, bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        StringBuilder stringBuilder;
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (Context context2) {
            stringBuilder = new StringBuilder("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(stringBuilder.toString(), context2);
        } catch (Context context22) {
            stringBuilder = new StringBuilder("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(stringBuilder.toString(), context22);
        } catch (Context context222) {
            stringBuilder = new StringBuilder("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(stringBuilder.toString(), context222);
        } catch (Context context2222) {
            stringBuilder = new StringBuilder("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": could not find Fragment constructor");
            throw new InstantiationException(stringBuilder.toString(), context2222);
        } catch (Context context22222) {
            stringBuilder = new StringBuilder("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(stringBuilder.toString(), context22222);
        }
    }

    static boolean isSupportFragmentClass(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = sClassMap;	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = r0.get(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = (java.lang.Class) r0;	 Catch:{ ClassNotFoundException -> 0x001e }
        if (r0 != 0) goto L_0x0017;	 Catch:{ ClassNotFoundException -> 0x001e }
    L_0x000a:
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r1 = sClassMap;	 Catch:{ ClassNotFoundException -> 0x001e }
        r1.put(r2, r0);	 Catch:{ ClassNotFoundException -> 0x001e }
    L_0x0017:
        r1 = android.support.v4.app.Fragment.class;	 Catch:{ ClassNotFoundException -> 0x001e }
        r1 = r1.isAssignableFrom(r0);	 Catch:{ ClassNotFoundException -> 0x001e }
        return r1;
    L_0x001e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.Fragment.isSupportFragmentClass(android.content.Context, java.lang.String):boolean");
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onViewStateRestored()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
    }

    final void setIndex(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            i = new StringBuilder();
            i.append(fragment.mWho);
            i.append(":");
            i.append(this.mIndex);
            this.mWho = i.toString();
            return;
        }
        i = new StringBuilder("android:fragment:");
        i.append(this.mIndex);
        this.mWho = i.toString();
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        DebugUtils.m1011a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex < 0 || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final boolean isStateSaved() {
        if (this.mFragmentManager == null) {
            return false;
        }
        return this.mFragmentManager.f11323s;
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        savedState = (savedState == null || savedState.mState == null) ? null : savedState.mState;
        this.mSavedFragmentState = savedState;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentManager fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
                if (fragment2 == this) {
                    StringBuilder stringBuilder = new StringBuilder("Setting ");
                    stringBuilder.append(fragment);
                    stringBuilder.append(" as the target of ");
                    stringBuilder.append(this);
                    stringBuilder.append(" would create a target cycle");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.mTarget = fragment;
            this.mTargetRequestCode = i;
            return;
        }
        stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" must share the same FragmentManager to be set as a target fragment");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        return this.mHost == null ? null : this.mHost.f11275c;
    }

    public final FragmentActivity getActivity() {
        if (this.mHost == null) {
            return null;
        }
        return (FragmentActivity) this.mHost.f11274b;
    }

    public final Object getHost() {
        return this.mHost == null ? null : this.mHost.mo3131g();
    }

    public final Resources getResources() {
        if (this.mHost != null) {
            return this.mHost.f11275c.getResources();
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to Activity");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 5) {
                this.mChildFragmentManager.m9919o();
            } else if (this.mState >= 4) {
                this.mChildFragmentManager.m9918n();
            } else if (this.mState >= 2) {
                this.mChildFragmentManager.m9917m();
            } else if (this.mState > 0) {
                this.mChildFragmentManager.m9916l();
            }
        }
        return this.mChildFragmentManager;
    }

    FragmentManager peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 5;
    }

    public final boolean isVisible() {
        return (!isAdded() || isHidden() || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.mo3128d();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo3128d();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 4 && this.mFragmentManager != null && isAdded()) {
            this.mFragmentManager.m9892b(this);
        }
        this.mUserVisibleHint = z;
        z = this.mState < 4 && !z;
        this.mDeferStart = z;
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public LoaderManager getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        if (this.mHost == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" not attached to Activity");
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.m9798a(this.mWho, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if (this.mHost == null) {
            bundle = new StringBuilder("Fragment ");
            bundle.append(this);
            bundle.append(" not attached to Activity");
            throw new IllegalStateException(bundle.toString());
        }
        this.mHost.mo3121a(this, intent, -1, bundle);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            i = new StringBuilder("Fragment ");
            i.append(this);
            i.append(" not attached to Activity");
            throw new IllegalStateException(i.toString());
        }
        this.mHost.mo3121a(this, intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (this.mHost == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(r9);
            stringBuilder.append(" not attached to Activity");
            throw new IllegalStateException(stringBuilder.toString());
        }
        r9.mHost.mo3122a(r9, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            i = new StringBuilder("Fragment ");
            i.append(this);
            i.append(" not attached to Activity");
            throw new IllegalStateException(i.toString());
        }
        this.mHost.mo3123a(this, strArr, i);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mHost != null ? this.mHost.mo3125a(str) : null;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        if (this.mLayoutInflater == null) {
            return performGetLayoutInflater(null);
        }
        return this.mLayoutInflater;
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        bundle = this.mHost.mo3127c();
        getChildFragmentManager();
        LayoutInflaterCompat.m1100b(bundle, this.mChildFragmentManager);
        return bundle;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Activity activity = this.mHost == null ? null : this.mHost.f11274b;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Activity activity = this.mHost == null ? null : this.mHost.f11274b;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager != null) {
            if (this.mChildFragmentManager.f11317l <= null) {
                z = false;
            }
            if (!z) {
                this.mChildFragmentManager.m9916l();
            }
        }
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.m9879a(parcelable, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.m9916l();
            }
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m9798a(this.mWho, this.mLoadersStarted, false);
            } else if (this.mLoaderManager != null) {
                this.mLoaderManager.m9988b();
            }
        }
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.m9798a(this.mWho, this.mLoadersStarted, false);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.m9993g();
        }
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().f963g = sharedElementCallback;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().f964h = sharedElementCallback;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f968l = obj;
    }

    public Object getEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f968l;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f969m = obj;
    }

    public Object getReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        if (this.mAnimationInfo.f969m == USE_DEFAULT_TRANSITION) {
            return getEnterTransition();
        }
        return this.mAnimationInfo.f969m;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f970n = obj;
    }

    public Object getExitTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f970n;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f971o = obj;
    }

    public Object getReenterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        if (this.mAnimationInfo.f971o == USE_DEFAULT_TRANSITION) {
            return getExitTransition();
        }
        return this.mAnimationInfo.f971o;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f972p = obj;
    }

    public Object getSharedElementEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f972p;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f973q = obj;
    }

    public Object getSharedElementReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        if (this.mAnimationInfo.f973q == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return this.mAnimationInfo.f973q;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f975s = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.mAnimationInfo != null) {
            if (this.mAnimationInfo.f975s != null) {
                return this.mAnimationInfo.f975s.booleanValue();
            }
        }
        return true;
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f974r = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.mAnimationInfo != null) {
            if (this.mAnimationInfo.f974r != null) {
                return this.mAnimationInfo.f974r.booleanValue();
            }
        }
        return true;
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f965i = true;
    }

    public void startPostponedEnterTransition() {
        if (this.mFragmentManager != null) {
            if (this.mFragmentManager.f11318m != null) {
                if (Looper.myLooper() != this.mFragmentManager.f11318m.f11276d.getLooper()) {
                    this.mFragmentManager.f11318m.f11276d.postAtFrontOfQueue(new C00801(this));
                    return;
                } else {
                    callStartTransitionListener();
                    return;
                }
            }
        }
        ensureAnimationInfo().f965i = false;
    }

    private void callStartTransitionListener() {
        OnStartEnterTransitionListener onStartEnterTransitionListener;
        if (this.mAnimationInfo == null) {
            onStartEnterTransitionListener = null;
        } else {
            this.mAnimationInfo.f965i = false;
            onStartEnterTransitionListener = this.mAnimationInfo.f966j;
            this.mAnimationInfo.f966j = null;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.mo213a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            loaderManagerImpl.m9985a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(str);
            StringBuilder stringBuilder2 = new StringBuilder("Child ");
            stringBuilder2.append(this.mChildFragmentManager);
            stringBuilder2.append(":");
            printWriter.println(stringBuilder2.toString());
            FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            fragmentManagerImpl.mo222a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
        }
    }

    Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager != null ? this.mChildFragmentManager.m9899c(str) : null;
    }

    void instantiateChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mChildFragmentManager.m9882a(this.mHost, new C09992(this), this);
    }

    void performCreate(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
        }
        this.mState = 1;
        this.mCalled = false;
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onCreate()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
        this.mLifecycleRegistry.m9413a(Event.ON_CREATE);
    }

    View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
        }
        this.mPerformedCreateView = true;
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    void performActivityCreated(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
        }
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onActivityCreated()");
            throw new SuperNotCalledException(stringBuilder.toString());
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9917m();
        }
    }

    void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
            this.mChildFragmentManager.m9912i();
        }
        this.mState = 4;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9918n();
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m9992f();
            }
            this.mLifecycleRegistry.m9413a(Event.ON_START);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStart()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
            this.mChildFragmentManager.m9912i();
        }
        this.mState = 5;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9919o();
                this.mChildFragmentManager.m9912i();
            }
            this.mLifecycleRegistry.m9413a(Event.ON_RESUME);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onResume()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void noteStateNotSaved() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9915k();
        }
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9886a(z);
        }
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9896b(z);
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9877a(configuration);
        }
    }

    void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9922r();
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m9888a(menu, menuInflater) : z;
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m9887a(menu) : z;
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (!(this.mChildFragmentManager == null || this.mChildFragmentManager.m9889a(menuItem) == null)) {
                return true;
            }
        }
        return null;
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (!(this.mChildFragmentManager == null || this.mChildFragmentManager.m9898b(menuItem) == null)) {
                return true;
            }
        }
        return null;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9894b(menu);
            }
        }
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.mChildFragmentManager != null) {
            Parcelable j = this.mChildFragmentManager.m9913j();
            if (j != null) {
                bundle.putParcelable("android:support:fragments", j);
            }
        }
    }

    void performPause() {
        this.mLifecycleRegistry.m9413a(Event.ON_PAUSE);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9901c(4);
        }
        this.mState = 4;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onPause()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
    }

    void performStop() {
        this.mLifecycleRegistry.m9413a(Event.ON_STOP);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9920p();
        }
        this.mState = 3;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onStop()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
    }

    void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9901c(2);
        }
        this.mState = 2;
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m9798a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                if (this.mHost.f11280h) {
                    this.mLoaderManager.m9990d();
                    return;
                }
                this.mLoaderManager.m9989c();
            }
        }
    }

    void performDestroyView() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9901c(1);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m9991e();
            }
            this.mPerformedCreateView = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performDestroy() {
        this.mLifecycleRegistry.m9413a(Event.ON_DESTROY);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9921q();
        }
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        StringBuilder stringBuilder;
        if (!this.mCalled) {
            stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onDetach()");
            throw new SuperNotCalledException(stringBuilder.toString());
        } else if (this.mChildFragmentManager == null) {
        } else {
            if (this.mRetaining) {
                this.mChildFragmentManager.m9921q();
                this.mChildFragmentManager = null;
                return;
            }
            stringBuilder = new StringBuilder("Child FragmentManager of ");
            stringBuilder.append(this);
            stringBuilder.append(" was not  destroyed and this fragment is not retaining instance");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ensureAnimationInfo();
        if (onStartEnterTransitionListener != this.mAnimationInfo.f966j) {
            if (onStartEnterTransitionListener == null || this.mAnimationInfo.f966j == null) {
                if (this.mAnimationInfo.f965i) {
                    this.mAnimationInfo.f966j = onStartEnterTransitionListener;
                }
                if (onStartEnterTransitionListener != null) {
                    onStartEnterTransitionListener.mo214b();
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Trying to set a replacement startPostponedEnterTransition on ");
            stringBuilder.append(this);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    int getNextAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f960d;
    }

    void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().f960d = i;
        }
    }

    int getNextTransition() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f961e;
    }

    void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo != null || i != 0 || i2 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.f961e = i;
            this.mAnimationInfo.f962f = i2;
        }
    }

    int getNextTransitionStyle() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f962f;
    }

    SharedElementCallback getEnterTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f963g;
    }

    SharedElementCallback getExitTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f964h;
    }

    View getAnimatingAway() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f957a;
    }

    void setAnimatingAway(View view) {
        ensureAnimationInfo().f957a = view;
    }

    void setAnimator(Animator animator) {
        ensureAnimationInfo().f958b = animator;
    }

    Animator getAnimator() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f958b;
    }

    int getStateAfterAnimating() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f959c;
    }

    void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f959c = i;
    }

    boolean isPostponed() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.f965i;
    }

    boolean isHideReplaced() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.f967k;
    }

    void setHideReplaced(boolean z) {
        ensureAnimationInfo().f967k = z;
    }
}
