package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mps.MPSUtils;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean DBG = false;
    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final OnEditorActionListener mOnEditorActionListener;
    private final OnItemClickListener mOnItemClickListener;
    private final OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    class C02171 implements Runnable {
        final /* synthetic */ SearchView f2492a;

        C02171(SearchView searchView) {
            this.f2492a = searchView;
        }

        public void run() {
            this.f2492a.updateFocusedState();
        }
    }

    class C02182 implements Runnable {
        final /* synthetic */ SearchView f2493a;

        C02182(SearchView searchView) {
            this.f2493a = searchView;
        }

        public void run() {
            if (this.f2493a.mSuggestionsAdapter != null && (this.f2493a.mSuggestionsAdapter instanceof SuggestionsAdapter)) {
                this.f2493a.mSuggestionsAdapter.mo385a(null);
            }
        }
    }

    class C02193 implements OnFocusChangeListener {
        final /* synthetic */ SearchView f2494a;

        C02193(SearchView searchView) {
            this.f2494a = searchView;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f2494a.mOnQueryTextFocusChangeListener != null) {
                this.f2494a.mOnQueryTextFocusChangeListener.onFocusChange(this.f2494a, z);
            }
        }
    }

    class C02204 implements OnLayoutChangeListener {
        final /* synthetic */ SearchView f2495a;

        C02204(SearchView searchView) {
            this.f2495a = searchView;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f2495a.adjustDropDownSizeAndPosition();
        }
    }

    class C02215 implements OnClickListener {
        final /* synthetic */ SearchView f2496a;

        C02215(SearchView searchView) {
            this.f2496a = searchView;
        }

        public void onClick(View view) {
            if (view == this.f2496a.mSearchButton) {
                this.f2496a.onSearchClicked();
            } else if (view == this.f2496a.mCloseButton) {
                this.f2496a.onCloseClicked();
            } else if (view == this.f2496a.mGoButton) {
                this.f2496a.onSubmitQuery();
            } else if (view == this.f2496a.mVoiceButton) {
                this.f2496a.onVoiceClicked();
            } else {
                if (view == this.f2496a.mSearchSrcTextView) {
                    this.f2496a.forceSuggestionQuery();
                }
            }
        }
    }

    class C02226 implements OnKeyListener {
        final /* synthetic */ SearchView f2497a;

        C02226(SearchView searchView) {
            this.f2497a = searchView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (this.f2497a.mSearchable == null) {
                return false;
            }
            if (this.f2497a.mSearchSrcTextView.isPopupShowing() && this.f2497a.mSearchSrcTextView.getListSelection() != -1) {
                return this.f2497a.onSuggestionsKey(view, i, keyEvent);
            }
            if (SearchAutoComplete.m16981a(this.f2497a.mSearchSrcTextView) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            this.f2497a.launchQuerySearch(0, 0, this.f2497a.mSearchSrcTextView.getText().toString());
            return true;
        }
    }

    class C02237 implements OnEditorActionListener {
        final /* synthetic */ SearchView f2498a;

        C02237(SearchView searchView) {
            this.f2498a = searchView;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            this.f2498a.onSubmitQuery();
            return true;
        }
    }

    class C02248 implements OnItemClickListener {
        final /* synthetic */ SearchView f2499a;

        C02248(SearchView searchView) {
            this.f2499a = searchView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f2499a.onItemClicked(i, null, 0);
        }
    }

    class C02259 implements OnItemSelectedListener {
        final /* synthetic */ SearchView f2500a;

        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C02259(SearchView searchView) {
            this.f2500a = searchView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f2500a.onItemSelected(i);
        }
    }

    private static class AutoCompleteTextViewReflector {
        Method f2501a;
        Method f2502b;
        private Method f2503c;

        AutoCompleteTextViewReflector() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r3 = "doBeforeTextChanged";	 Catch:{ NoSuchMethodException -> 0x0016 }
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0016 }
            r6.f2501a = r2;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r6.f2501a;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0016 }
        L_0x0016:
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r3 = "doAfterTextChanged";	 Catch:{ NoSuchMethodException -> 0x0027 }
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0027 }
            r6.f2502b = r2;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r6.f2502b;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0027 }
        L_0x0027:
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x003d }
            r3 = "ensureImeVisible";	 Catch:{ NoSuchMethodException -> 0x003d }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x003d }
            r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x003d }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x003d }
            r0 = r2.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x003d }
            r6.f2503c = r0;	 Catch:{ NoSuchMethodException -> 0x003d }
            r0 = r6.f2503c;	 Catch:{ NoSuchMethodException -> 0x003d }
            r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003d }
            return;
        L_0x003d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.AutoCompleteTextViewReflector.<init>():void");
        }

        final void m2261a(android.widget.AutoCompleteTextView r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f2503c;
            if (r0 == 0) goto L_0x0014;
        L_0x0004:
            r0 = r4.f2503c;	 Catch:{ Exception -> 0x0014 }
            r1 = 1;	 Catch:{ Exception -> 0x0014 }
            r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0014 }
            r3 = 0;	 Catch:{ Exception -> 0x0014 }
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0014 }
            r2[r3] = r1;	 Catch:{ Exception -> 0x0014 }
            r0.invoke(r5, r2);	 Catch:{ Exception -> 0x0014 }
            return;
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.AutoCompleteTextViewReflector.a(android.widget.AutoCompleteTextView):void");
        }
    }

    public interface OnCloseListener {
        boolean m2262a();
    }

    public interface OnQueryTextListener {
        boolean m2263a(String str);

        boolean m2264b(String str);
    }

    public interface OnSuggestionListener {
        boolean m2265a();

        boolean m2266b();
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {
        private final View f2505a;
        private final Rect f2506b = new Rect();
        private final Rect f2507c = new Rect();
        private final Rect f2508d = new Rect();
        private final int f2509e;
        private boolean f2510f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2509e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            m2267a(rect, rect2);
            this.f2505a = view;
        }

        public final void m2267a(Rect rect, Rect rect2) {
            this.f2506b.set(rect);
            this.f2508d.set(rect);
            this.f2508d.inset(-this.f2509e, -this.f2509e);
            this.f2507c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r0 = r7.getX();
            r0 = (int) r0;
            r1 = r7.getY();
            r1 = (int) r1;
            r2 = r7.getAction();
            r3 = 1;
            r4 = 0;
            switch(r2) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0019;
                case 2: goto L_0x0019;
                case 3: goto L_0x0014;
                default: goto L_0x0013;
            };
        L_0x0013:
            goto L_0x0033;
        L_0x0014:
            r2 = r6.f2510f;
            r6.f2510f = r4;
            goto L_0x0034;
        L_0x0019:
            r2 = r6.f2510f;
            if (r2 == 0) goto L_0x0034;
        L_0x001d:
            r5 = r6.f2508d;
            r5 = r5.contains(r0, r1);
            if (r5 != 0) goto L_0x0034;
        L_0x0025:
            r3 = r4;
            goto L_0x0034;
        L_0x0027:
            r2 = r6.f2506b;
            r2 = r2.contains(r0, r1);
            if (r2 == 0) goto L_0x0033;
        L_0x002f:
            r6.f2510f = r3;
            r2 = r3;
            goto L_0x0034;
        L_0x0033:
            r2 = r4;
        L_0x0034:
            if (r2 == 0) goto L_0x006b;
        L_0x0036:
            if (r3 == 0) goto L_0x0056;
        L_0x0038:
            r2 = r6.f2507c;
            r2 = r2.contains(r0, r1);
            if (r2 != 0) goto L_0x0056;
        L_0x0040:
            r0 = r6.f2505a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.f2505a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0065;
        L_0x0056:
            r2 = r6.f2507c;
            r2 = r2.left;
            r0 = r0 - r2;
            r0 = (float) r0;
            r2 = r6.f2507c;
            r2 = r2.top;
            r1 = r1 - r2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0065:
            r0 = r6.f2505a;
            r4 = r0.dispatchTouchEvent(r7);
        L_0x006b:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C02261();
        boolean f12051a;

        static class C02261 implements ClassLoaderCreator<SavedState> {
            C02261() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12051a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f12051a));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("SearchView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" isIconified=");
            stringBuilder.append(this.f12051a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        final Runnable f16718a;
        private int f16719b;
        private SearchView f16720c;
        private boolean f16721d;

        class C02271 implements Runnable {
            final /* synthetic */ SearchAutoComplete f2504a;

            C02271(SearchAutoComplete searchAutoComplete) {
                this.f2504a = searchAutoComplete;
            }

            public void run() {
                SearchAutoComplete.m16982b(this.f2504a);
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0164R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f16718a = new C02271(this);
            this.f16719b = getThreshold();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f16720c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f16719b = i;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f16720c.hasFocus() && !getVisibility()) {
                this.f16721d = true;
                if (SearchView.isLandscapeMode(getContext())) {
                    SearchView.HIDDEN_METHOD_INVOKER.m2261a(this);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f16720c.onTextFocusChanged();
        }

        public boolean enoughToFilter() {
            if (this.f16719b > 0) {
                if (!super.enoughToFilter()) {
                    return false;
                }
            }
            return true;
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    i = getKeyDispatcherState();
                    if (i != 0) {
                        i.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f16720c.clearFocus();
                        setImeVisibility(0);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                if (i < 640 || i2 < MPSUtils.VIDEO_MIN) {
                    return 160;
                }
            }
            return JpegConst.SOF0;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            editorInfo = super.onCreateInputConnection(editorInfo);
            if (this.f16721d) {
                removeCallbacks(this.f16718a);
                post(this.f16718a);
            }
            return editorInfo;
        }

        private void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f16721d = false;
                removeCallbacks(this.f16718a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f16721d = false;
                removeCallbacks(this.f16718a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f16721d = true;
            }
        }

        static /* synthetic */ boolean m16981a(SearchAutoComplete searchAutoComplete) {
            return TextUtils.getTrimmedLength(searchAutoComplete.getText()) == null ? true : null;
        }

        static /* synthetic */ void m16982b(SearchAutoComplete searchAutoComplete) {
            if (searchAutoComplete.f16721d) {
                ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                searchAutoComplete.f16721d = false;
            }
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new C02171(this);
        this.mReleaseCursorRunnable = new C02182(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        this.mOnClickListener = new C02215(this);
        this.mTextKeyListener = new C02226(this);
        this.mOnEditorActionListener = new C02237(this);
        this.mOnItemClickListener = new C02248(this);
        this.mOnItemSelectedListener = new C02259(this);
        this.mTextWatcher = new TextWatcher(this) {
            final /* synthetic */ SearchView f2491a;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.f2491a = r1;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f2491a.onTextChanged(charSequence);
            }
        };
        attributeSet = TintTypedArray.m2308a(context, attributeSet, C0164R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(attributeSet.m2323g(C0164R.styleable.SearchView_layout, C0164R.layout.abc_search_view), this, true);
        this.mSearchSrcTextView = (SearchAutoComplete) findViewById(C0164R.id.search_src_text);
        this.mSearchSrcTextView.setSearchView(this);
        this.mSearchEditFrame = findViewById(C0164R.id.search_edit_frame);
        this.mSearchPlate = findViewById(C0164R.id.search_plate);
        this.mSubmitArea = findViewById(C0164R.id.submit_area);
        this.mSearchButton = (ImageView) findViewById(C0164R.id.search_button);
        this.mGoButton = (ImageView) findViewById(C0164R.id.search_go_btn);
        this.mCloseButton = (ImageView) findViewById(C0164R.id.search_close_btn);
        this.mVoiceButton = (ImageView) findViewById(C0164R.id.search_voice_btn);
        this.mCollapsedIcon = (ImageView) findViewById(C0164R.id.search_mag_icon);
        ViewCompat.m1219a(this.mSearchPlate, attributeSet.m2311a(C0164R.styleable.SearchView_queryBackground));
        ViewCompat.m1219a(this.mSubmitArea, attributeSet.m2311a(C0164R.styleable.SearchView_submitBackground));
        this.mSearchButton.setImageDrawable(attributeSet.m2311a(C0164R.styleable.SearchView_searchIcon));
        this.mGoButton.setImageDrawable(attributeSet.m2311a(C0164R.styleable.SearchView_goIcon));
        this.mCloseButton.setImageDrawable(attributeSet.m2311a(C0164R.styleable.SearchView_closeIcon));
        this.mVoiceButton.setImageDrawable(attributeSet.m2311a(C0164R.styleable.SearchView_voiceIcon));
        this.mCollapsedIcon.setImageDrawable(attributeSet.m2311a(C0164R.styleable.SearchView_searchIcon));
        this.mSearchHintIcon = attributeSet.m2311a(C0164R.styleable.SearchView_searchHintIcon);
        TooltipCompat.m2349a(this.mSearchButton, getResources().getString(C0164R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = attributeSet.m2323g(C0164R.styleable.SearchView_suggestionRowLayout, C0164R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = attributeSet.m2323g(C0164R.styleable.SearchView_commitIcon, 0);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mGoButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
        this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
        this.mSearchSrcTextView.setOnFocusChangeListener(new C02193(this));
        setIconifiedByDefault(attributeSet.m2312a(C0164R.styleable.SearchView_iconifiedByDefault, true));
        context = attributeSet.m2319e(C0164R.styleable.SearchView_android_maxWidth, -1);
        if (context != -1) {
            setMaxWidth(context);
        }
        this.mDefaultQueryHint = attributeSet.m2316c(C0164R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = attributeSet.m2316c(C0164R.styleable.SearchView_queryHint);
        context = attributeSet.m2310a(C0164R.styleable.SearchView_android_imeOptions, -1);
        if (context != -1) {
            setImeOptions(context);
        }
        context = attributeSet.m2310a(C0164R.styleable.SearchView_android_inputType, -1);
        if (context != -1) {
            setInputType(context);
        }
        setFocusable(attributeSet.m2312a(C0164R.styleable.SearchView_android_focusable, true));
        attributeSet.f2595b.recycle();
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(268435456);
        this.mDropDownAnchor = findViewById(this.mSearchSrcTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            this.mDropDownAnchor.addOnLayoutChangeListener(new C02204(this));
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (this.mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled != null) {
            this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        i = this.mSearchSrcTextView.requestFocus(i, rect);
        if (i != 0) {
            updateViewsVisibility(false);
        }
        return i;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.mOnQueryChangeListener = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
            this.mUserQuery = charSequence;
        }
        if (z && TextUtils.isEmpty(charSequence) == null) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (this.mSearchable == null || this.mSearchable.getHintId() == 0) {
            return this.mDefaultQueryHint;
        }
        return getContext().getText(this.mSearchable.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault != z) {
            this.mIconifiedByDefault = z;
            updateViewsVisibility(z);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.mQueryRefinement = z;
        if (this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) this.mSuggestionsAdapter).f18868j = z ? true : true;
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    protected void onMeasure(int i, int i2) {
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            i = this.mMaxWidth > 0 ? Math.min(this.mMaxWidth, i) : Math.min(getPreferredWidth(), i);
        } else if (mode == 0) {
            i = this.mMaxWidth > 0 ? this.mMaxWidth : getPreferredWidth();
        } else if (mode == 1073741824) {
            if (this.mMaxWidth > 0) {
                i = Math.min(this.mMaxWidth, i);
            }
        }
        mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(getPreferredHeight(), i2);
        } else if (mode == 0) {
            i2 = getPreferredHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, i4 - i2);
            if (this.mTouchDelegate) {
                this.mTouchDelegate.m2267a(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
            } else {
                this.mTouchDelegate = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                setTouchDelegate(this.mTouchDelegate);
            }
        }
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int i = this.mTemp[1] - this.mTemp2[1];
        int i2 = this.mTemp[0] - this.mTemp2[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0164R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0164R.dimen.abc_search_view_preferred_height);
    }

    private void updateViewsVisibility(boolean z) {
        this.mIconified = z;
        int i = 8;
        boolean z2 = false;
        boolean isEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ^ true;
        this.mSearchButton.setVisibility(z ? 0 : 8);
        updateSubmitButton(isEmpty);
        this.mSearchEditFrame.setVisibility(z ? true : false);
        if (this.mCollapsedIcon.getDrawable()) {
            if (!this.mIconifiedByDefault) {
                i = 0;
            }
        }
        this.mCollapsedIcon.setVisibility(i);
        updateCloseButton();
        if (!isEmpty) {
            z2 = true;
        }
        updateVoiceButton(z2);
        updateSubmitArea();
    }

    private boolean hasVoiceSearch() {
        if (this.mSearchable != null && this.mSearchable.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                intent = this.mVoiceWebSearchIntent;
            } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                intent = this.mVoiceAppSearchIntent;
            }
            if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    private void updateSubmitButton(boolean z) {
        z = (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (z || !this.mVoiceButtonEnabled)) ? false : true;
        this.mGoButton.setVisibility(z);
    }

    private void updateSubmitArea() {
        int i = (isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) ? 0 : 8;
        this.mSubmitArea.setVisibility(i);
    }

    private void updateCloseButton() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ^ 1;
        int i2 = 0;
        if (isEmpty == 0) {
            if (!this.mIconifiedByDefault || this.mExpandedInActionView) {
                i = 0;
            }
        }
        ImageView imageView = this.mCloseButton;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(isEmpty != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    void updateFocusedState() {
        int[] iArr = this.mSearchSrcTextView.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = this.mSubmitArea.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        invalidate();
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean onSuggestionsKey(View view, int i, KeyEvent keyEvent) {
        if (!(this.mSearchable == null || this.mSuggestionsAdapter == null || keyEvent.getAction() != null || keyEvent.hasNoModifiers() == null)) {
            if (!(i == 66 || i == 84)) {
                if (i != 61) {
                    if (i != 21) {
                        if (i != 22) {
                            if (i != 19 || this.mSearchSrcTextView.getListSelection() == null) {
                                return false;
                            }
                        }
                    }
                    if (i == 21) {
                        view = null;
                    } else {
                        view = this.mSearchSrcTextView.length();
                    }
                    this.mSearchSrcTextView.setSelection(view);
                    this.mSearchSrcTextView.setListSelection(0);
                    this.mSearchSrcTextView.clearListSelection();
                    HIDDEN_METHOD_INVOKER.m2261a(this.mSearchSrcTextView);
                    return true;
                }
            }
            return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, 0);
        }
        return false;
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (this.mIconifiedByDefault) {
            if (this.mSearchHintIcon != null) {
                int textSize = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
                this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
                CharSequence spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                return spannableStringBuilder;
            }
        }
        return charSequence;
    }

    private void updateQueryHint() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(getDecoratedHint(queryHint));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.mo385a(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            suggestionsAdapter.f18868j = i;
        }
    }

    private void updateVoiceButton(boolean z) {
        if (this.mVoiceButtonEnabled && !isIconified() && z) {
            z = false;
            this.mGoButton.setVisibility(8);
        } else {
            z = true;
        }
        this.mVoiceButton.setVisibility(z);
    }

    void onTextChanged(CharSequence charSequence) {
        CharSequence text = this.mSearchSrcTextView.getText();
        this.mUserQuery = text;
        boolean z = true;
        boolean isEmpty = TextUtils.isEmpty(text) ^ true;
        updateSubmitButton(isEmpty);
        if (isEmpty) {
            z = false;
        }
        updateVoiceButton(z);
        updateCloseButton();
        updateSubmitArea();
        if (!(this.mOnQueryChangeListener == null || TextUtils.equals(charSequence, this.mOldQueryText))) {
            this.mOnQueryChangeListener.m2264b(charSequence.toString());
        }
        this.mOldQueryText = charSequence.toString();
    }

    void onSubmitQuery() {
        CharSequence text = this.mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.m2263a(text.toString())) {
                if (this.mSearchable != null) {
                    launchQuerySearch(0, null, text.toString());
                }
                this.mSearchSrcTextView.setImeVisibility(false);
                dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.setImeVisibility(true);
        } else if (this.mIconifiedByDefault && (this.mOnCloseListener == null || !this.mOnCloseListener.m2262a())) {
            clearFocus();
            updateViewsVisibility(true);
        }
    }

    void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        if (this.mOnSearchClickListener != null) {
            this.mOnSearchClickListener.onClick(this);
        }
    }

    void onVoiceClicked() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.mSearchable;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.mSearchable;
        r1 = r0.getVoiceSearchLaunchWebSearch();	 Catch:{ ActivityNotFoundException -> 0x002f }
        if (r1 == 0) goto L_0x001b;	 Catch:{ ActivityNotFoundException -> 0x002f }
    L_0x000d:
        r1 = r2.mVoiceWebSearchIntent;	 Catch:{ ActivityNotFoundException -> 0x002f }
        r0 = r2.createVoiceWebSearchIntent(r1, r0);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r1 = r2.getContext();	 Catch:{ ActivityNotFoundException -> 0x002f }
        r1.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x002f }
        return;	 Catch:{ ActivityNotFoundException -> 0x002f }
    L_0x001b:
        r1 = r0.getVoiceSearchLaunchRecognizer();	 Catch:{ ActivityNotFoundException -> 0x002f }
        if (r1 == 0) goto L_0x002e;	 Catch:{ ActivityNotFoundException -> 0x002f }
    L_0x0021:
        r1 = r2.mVoiceAppSearchIntent;	 Catch:{ ActivityNotFoundException -> 0x002f }
        r0 = r2.createVoiceAppSearchIntent(r1, r0);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r1 = r2.getContext();	 Catch:{ ActivityNotFoundException -> 0x002f }
        r1.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x002f }
    L_0x002e:
        return;
    L_0x002f:
        r0 = "SearchView";
        r1 = "Could not find voice search activity";
        android.util.Log.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.onVoiceClicked():void");
    }

    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        postUpdateFocusedState();
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
            this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 33554432);
            this.mSearchSrcTextView.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12051a = isIconified();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            updateViewsVisibility(savedState.f12051a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            int i;
            Resources resources = getContext().getResources();
            int paddingLeft = this.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = ViewUtils.m2390a(this);
            int dimensionPixelSize = this.mIconifiedByDefault ? resources.getDimensionPixelSize(C0164R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(C0164R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(i);
            this.mSearchSrcTextView.setDropDownWidth((((this.mDropDownAnchor.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    boolean onItemClicked(int i, int i2, String str) {
        if (this.mOnSuggestionListener != 0) {
            if (this.mOnSuggestionListener.m2266b() != 0) {
                return false;
            }
        }
        launchSuggestion(i, 0, 0);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    boolean onItemSelected(int i) {
        if (this.mOnSuggestionListener != null) {
            if (this.mOnSuggestionListener.m2265a()) {
                return false;
            }
        }
        rewriteQueryFromSuggestion(i);
        return true;
    }

    private void rewriteQueryFromSuggestion(int i) {
        CharSequence text = this.mSearchSrcTextView.getText();
        Cursor a = this.mSuggestionsAdapter.mo383a();
        if (a != null) {
            if (a.moveToPosition(i) != 0) {
                i = this.mSuggestionsAdapter.mo386b(a);
                if (i != 0) {
                    setQuery(i);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private boolean launchSuggestion(int i, int i2, String str) {
        Cursor a = this.mSuggestionsAdapter.mo383a();
        if (a == null || a.moveToPosition(i) == 0) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(a, i2, str));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (Throwable e) {
                String str = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder("Failed launch activity: ");
                stringBuilder.append(intent);
                Log.e(str, stringBuilder.toString(), e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? null : charSequence.length());
    }

    void launchQuerySearch(int i, String str, String str2) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra("app_data", this.mAppSearchData);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        intent = searchableInfo.getSearchActivity();
        searchableInfo = "calling_package";
        if (intent == null) {
            intent = null;
        } else {
            intent = intent.flattenToShortString();
        }
        intent2.putExtra(searchableInfo, intent);
        return intent2;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Parcelable activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.mAppSearchData != null) {
            bundle.putParcelable("app_data", this.mAppSearchData);
        }
        Intent intent3 = new Intent(intent);
        intent = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            intent = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String str = null;
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", intent);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        intent = "calling_package";
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra(intent, str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private android.content.Intent createIntentFromSuggestion(android.database.Cursor r9, int r10, java.lang.String r11) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = "suggest_intent_action";	 Catch:{ RuntimeException -> 0x0061 }
        r1 = android.support.v7.widget.SuggestionsAdapter.m19962a(r9, r1);	 Catch:{ RuntimeException -> 0x0061 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0009:
        r1 = r8.mSearchable;	 Catch:{ RuntimeException -> 0x0061 }
        r1 = r1.getSuggestIntentAction();	 Catch:{ RuntimeException -> 0x0061 }
    L_0x000f:
        if (r1 != 0) goto L_0x0013;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0011:
        r1 = "android.intent.action.SEARCH";	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0013:
        r2 = r1;	 Catch:{ RuntimeException -> 0x0061 }
        r1 = "suggest_intent_data";	 Catch:{ RuntimeException -> 0x0061 }
        r1 = android.support.v7.widget.SuggestionsAdapter.m19962a(r9, r1);	 Catch:{ RuntimeException -> 0x0061 }
        if (r1 != 0) goto L_0x0022;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x001c:
        r1 = r8.mSearchable;	 Catch:{ RuntimeException -> 0x0061 }
        r1 = r1.getSuggestIntentData();	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0022:
        if (r1 == 0) goto L_0x0044;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0024:
        r3 = "suggest_intent_data_id";	 Catch:{ RuntimeException -> 0x0061 }
        r3 = android.support.v7.widget.SuggestionsAdapter.m19962a(r9, r3);	 Catch:{ RuntimeException -> 0x0061 }
        if (r3 == 0) goto L_0x0044;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x002c:
        r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0061 }
        r4.<init>();	 Catch:{ RuntimeException -> 0x0061 }
        r4.append(r1);	 Catch:{ RuntimeException -> 0x0061 }
        r1 = "/";	 Catch:{ RuntimeException -> 0x0061 }
        r4.append(r1);	 Catch:{ RuntimeException -> 0x0061 }
        r1 = android.net.Uri.encode(r3);	 Catch:{ RuntimeException -> 0x0061 }
        r4.append(r1);	 Catch:{ RuntimeException -> 0x0061 }
        r1 = r4.toString();	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0044:
        if (r1 != 0) goto L_0x0048;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0046:
        r3 = r0;	 Catch:{ RuntimeException -> 0x0061 }
        goto L_0x004d;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x0048:
        r1 = android.net.Uri.parse(r1);	 Catch:{ RuntimeException -> 0x0061 }
        r3 = r1;	 Catch:{ RuntimeException -> 0x0061 }
    L_0x004d:
        r1 = "suggest_intent_query";	 Catch:{ RuntimeException -> 0x0061 }
        r5 = android.support.v7.widget.SuggestionsAdapter.m19962a(r9, r1);	 Catch:{ RuntimeException -> 0x0061 }
        r1 = "suggest_intent_extra_data";	 Catch:{ RuntimeException -> 0x0061 }
        r4 = android.support.v7.widget.SuggestionsAdapter.m19962a(r9, r1);	 Catch:{ RuntimeException -> 0x0061 }
        r1 = r8;	 Catch:{ RuntimeException -> 0x0061 }
        r6 = r10;	 Catch:{ RuntimeException -> 0x0061 }
        r7 = r11;	 Catch:{ RuntimeException -> 0x0061 }
        r10 = r1.createIntent(r2, r3, r4, r5, r6, r7);	 Catch:{ RuntimeException -> 0x0061 }
        return r10;
    L_0x0061:
        r10 = move-exception;
        r9 = r9.getPosition();	 Catch:{ RuntimeException -> 0x0067 }
        goto L_0x0068;
    L_0x0067:
        r9 = -1;
    L_0x0068:
        r11 = "SearchView";
        r1 = new java.lang.StringBuilder;
        r2 = "Search suggestions cursor at row ";
        r1.<init>(r2);
        r1.append(r9);
        r9 = " returned exception.";
        r1.append(r9);
        r9 = r1.toString();
        android.util.Log.w(r11, r9, r10);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.createIntentFromSuggestion(android.database.Cursor, int, java.lang.String):android.content.Intent");
    }

    void forceSuggestionQuery() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = HIDDEN_METHOD_INVOKER;
        r1 = r4.mSearchSrcTextView;
        r2 = r0.f2501a;
        r3 = 0;
        if (r2 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r0.f2501a;	 Catch:{ Exception -> 0x0010 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0010 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0010 }
    L_0x0010:
        r0 = HIDDEN_METHOD_INVOKER;
        r1 = r4.mSearchSrcTextView;
        r2 = r0.f2502b;
        if (r2 == 0) goto L_0x0020;
    L_0x0018:
        r0 = r0.f2502b;	 Catch:{ Exception -> 0x0020 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0020 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0020 }
        return;
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.forceSuggestionQuery():void");
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? true : null;
    }
}
