package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static Method f11997a;
    private static Method f11998b;
    private static Method f11999c;
    private boolean f12000A;
    private View f12001B;
    private DataSetObserver f12002C;
    private Drawable f12003D;
    private OnItemSelectedListener f12004E;
    private final PopupTouchInterceptor f12005F;
    private final PopupScrollListener f12006G;
    private final ListSelectorHider f12007H;
    private Runnable f12008I;
    private final Rect f12009J;
    private Context f12010d;
    public DropDownListView f12011e;
    int f12012f;
    public int f12013g;
    public boolean f12014h;
    public boolean f12015i;
    public int f12016j;
    int f12017k;
    int f12018l;
    public View f12019m;
    public OnItemClickListener f12020n;
    final ResizePopupRunnable f12021o;
    final Handler f12022p;
    public Rect f12023q;
    public boolean f12024r;
    public PopupWindow f12025s;
    private ListAdapter f12026t;
    private int f12027u;
    private int f12028v;
    private int f12029w;
    private boolean f12030x;
    private boolean f12031y;
    private boolean f12032z;

    class C02092 implements Runnable {
        final /* synthetic */ ListPopupWindow f2321a;

        C02092(ListPopupWindow listPopupWindow) {
            this.f2321a = listPopupWindow;
        }

        public void run() {
            View view = this.f2321a.f12019m;
            if (view != null && view.getWindowToken() != null) {
                this.f2321a.mo653d();
            }
        }
    }

    class C02103 implements OnItemSelectedListener {
        final /* synthetic */ ListPopupWindow f2322a;

        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C02103(ListPopupWindow listPopupWindow) {
            this.f2322a = listPopupWindow;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                adapterView = this.f2322a.f12011e;
                if (adapterView != null) {
                    adapterView.setListSelectionHidden(null);
                }
            }
        }
    }

    private class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow f2323a;

        ListSelectorHider(ListPopupWindow listPopupWindow) {
            this.f2323a = listPopupWindow;
        }

        public void run() {
            this.f2323a.m10748i();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow f2324a;

        PopupDataSetObserver(ListPopupWindow listPopupWindow) {
            this.f2324a = listPopupWindow;
        }

        public void onChanged() {
            if (this.f2324a.f12025s.isShowing()) {
                this.f2324a.mo653d();
            }
        }

        public void onInvalidated() {
            this.f2324a.mo654e();
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        final /* synthetic */ ListPopupWindow f2325a;

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        PopupScrollListener(ListPopupWindow listPopupWindow) {
            this.f2325a = listPopupWindow;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && this.f2325a.m10749j() == null && this.f2325a.f12025s.getContentView() != null) {
                this.f2325a.f12022p.removeCallbacks(this.f2325a.f12021o);
                this.f2325a.f12021o.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        final /* synthetic */ ListPopupWindow f2326a;

        PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
            this.f2326a = listPopupWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            motionEvent = (int) motionEvent.getY();
            if (view == null && this.f2326a.f12025s != null && this.f2326a.f12025s.isShowing() && x >= 0 && x < this.f2326a.f12025s.getWidth() && motionEvent >= null && motionEvent < this.f2326a.f12025s.getHeight()) {
                this.f2326a.f12022p.postDelayed(this.f2326a.f12021o, 250);
            } else if (view == 1) {
                this.f2326a.f12022p.removeCallbacks(this.f2326a.f12021o);
            }
            return null;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow f2327a;

        ResizePopupRunnable(ListPopupWindow listPopupWindow) {
            this.f2327a = listPopupWindow;
        }

        public void run() {
            if (this.f2327a.f12011e != null && ViewCompat.m1209J(this.f2327a.f12011e) && this.f2327a.f12011e.getCount() > this.f2327a.f12011e.getChildCount() && this.f2327a.f12011e.getChildCount() <= this.f2327a.f12017k) {
                this.f2327a.f12025s.setInputMethodMode(2);
                this.f2327a.mo653d();
            }
        }
    }

    static {
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
        r0 = 0;
        r1 = 1;
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r3 = "setClipToScreenEnabled";	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0013 }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0013 }
        f11997a = r2;	 Catch:{ NoSuchMethodException -> 0x0013 }
        goto L_0x001a;
    L_0x0013:
        r2 = "ListPopupWindow";
        r3 = "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r2, r3);
    L_0x001a:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r3 = "getMaxAvailableHeight";	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = 3;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = 2;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0035 }
        f11998b = r2;	 Catch:{ NoSuchMethodException -> 0x0035 }
        goto L_0x003c;
    L_0x0035:
        r2 = "ListPopupWindow";
        r3 = "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.";
        android.util.Log.i(r2, r3);
    L_0x003c:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x004d }
        r3 = "setEpicenterBounds";	 Catch:{ NoSuchMethodException -> 0x004d }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x004d }
        r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x004d }
        r1[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x004d }
        r0 = r2.getDeclaredMethod(r3, r1);	 Catch:{ NoSuchMethodException -> 0x004d }
        f11999c = r0;	 Catch:{ NoSuchMethodException -> 0x004d }
        return;
    L_0x004d:
        r0 = "ListPopupWindow";
        r1 = "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.<clinit>():void");
    }

    public ListPopupWindow(Context context) {
        this(context, null, C0164R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f12027u = -2;
        this.f12012f = -2;
        this.f12029w = 1002;
        this.f12031y = true;
        this.f12016j = 0;
        this.f12032z = false;
        this.f12000A = false;
        this.f12017k = RedditJobManager.f10810d;
        this.f12018l = 0;
        this.f12021o = new ResizePopupRunnable(this);
        this.f12005F = new PopupTouchInterceptor(this);
        this.f12006G = new PopupScrollListener(this);
        this.f12007H = new ListSelectorHider(this);
        this.f12009J = new Rect();
        this.f12010d = context;
        this.f12022p = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0164R.styleable.ListPopupWindow, i, i2);
        this.f12013g = obtainStyledAttributes.getDimensionPixelOffset(C0164R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f12028v = obtainStyledAttributes.getDimensionPixelOffset(C0164R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f12028v != 0) {
            this.f12030x = true;
        }
        obtainStyledAttributes.recycle();
        this.f12025s = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f12025s.setInputMethodMode(1);
    }

    public void mo3229a(ListAdapter listAdapter) {
        if (this.f12002C == null) {
            this.f12002C = new PopupDataSetObserver(this);
        } else if (this.f12026t != null) {
            this.f12026t.unregisterDataSetObserver(this.f12002C);
        }
        this.f12026t = listAdapter;
        if (this.f12026t != null) {
            listAdapter.registerDataSetObserver(this.f12002C);
        }
        if (this.f12011e != null) {
            this.f12011e.setAdapter(this.f12026t);
        }
    }

    public final void m10740b() {
        this.f12024r = true;
        this.f12025s.setFocusable(true);
    }

    public final void m10737a(Drawable drawable) {
        this.f12025s.setBackgroundDrawable(drawable);
    }

    public final int m10742c() {
        if (this.f12030x) {
            return this.f12028v;
        }
        return 0;
    }

    public final void m10736a(int i) {
        this.f12028v = i;
        this.f12030x = true;
    }

    public final void m10741b(int i) {
        Drawable background = this.f12025s.getBackground();
        if (background != null) {
            background.getPadding(this.f12009J);
            this.f12012f = (this.f12009J.left + this.f12009J.right) + i;
            return;
        }
        this.f12012f = i;
    }

    public final void mo654e() {
        this.f12025s.dismiss();
        if (this.f12001B != null) {
            ViewParent parent = this.f12001B.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f12001B);
            }
        }
        this.f12025s.setContentView(null);
        this.f12011e = null;
        this.f12022p.removeCallbacks(this.f12021o);
    }

    public final void m10739a(OnDismissListener onDismissListener) {
        this.f12025s.setOnDismissListener(onDismissListener);
    }

    public final void m10747h() {
        this.f12025s.setInputMethodMode(2);
    }

    public final void m10748i() {
        DropDownListView dropDownListView = this.f12011e;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public final boolean mo655f() {
        return this.f12025s.isShowing();
    }

    public final boolean m10749j() {
        return this.f12025s.getInputMethodMode() == 2;
    }

    public final ListView mo656g() {
        return this.f12011e;
    }

    DropDownListView mo3252a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    private int m10734a(android.view.View r6, int r7, boolean r8) {
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
        r5 = this;
        r0 = f11998b;
        if (r0 == 0) goto L_0x002e;
    L_0x0004:
        r0 = f11998b;	 Catch:{ Exception -> 0x0027 }
        r1 = r5.f12025s;	 Catch:{ Exception -> 0x0027 }
        r2 = 3;	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0027 }
        r3 = 0;	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r6;	 Catch:{ Exception -> 0x0027 }
        r3 = 1;	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0027 }
        r3 = 2;	 Catch:{ Exception -> 0x0027 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0027 }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r8.intValue();	 Catch:{ Exception -> 0x0027 }
        return r8;
    L_0x0027:
        r8 = "ListPopupWindow";
        r0 = "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.";
        android.util.Log.i(r8, r0);
    L_0x002e:
        r8 = r5.f12025s;
        r6 = r8.getMaxAvailableHeight(r6, r7);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.a(android.view.View, int, boolean):int");
    }

    public void mo653d() {
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
        r12 = this;
        r0 = r12.f12011e;
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = 1;
        r3 = 0;
        r4 = -1;
        if (r0 != 0) goto L_0x00c2;
    L_0x0009:
        r0 = r12.f12010d;
        r5 = new android.support.v7.widget.ListPopupWindow$2;
        r5.<init>(r12);
        r12.f12008I = r5;
        r5 = r12.f12024r;
        r5 = r5 ^ r2;
        r5 = r12.mo3252a(r0, r5);
        r12.f12011e = r5;
        r5 = r12.f12003D;
        if (r5 == 0) goto L_0x0026;
    L_0x001f:
        r5 = r12.f12011e;
        r6 = r12.f12003D;
        r5.setSelector(r6);
    L_0x0026:
        r5 = r12.f12011e;
        r6 = r12.f12026t;
        r5.setAdapter(r6);
        r5 = r12.f12011e;
        r6 = r12.f12020n;
        r5.setOnItemClickListener(r6);
        r5 = r12.f12011e;
        r5.setFocusable(r2);
        r5 = r12.f12011e;
        r5.setFocusableInTouchMode(r2);
        r5 = r12.f12011e;
        r6 = new android.support.v7.widget.ListPopupWindow$3;
        r6.<init>(r12);
        r5.setOnItemSelectedListener(r6);
        r5 = r12.f12011e;
        r6 = r12.f12006G;
        r5.setOnScrollListener(r6);
        r5 = r12.f12004E;
        if (r5 == 0) goto L_0x005a;
    L_0x0053:
        r5 = r12.f12011e;
        r6 = r12.f12004E;
        r5.setOnItemSelectedListener(r6);
    L_0x005a:
        r5 = r12.f12011e;
        r6 = r12.f12001B;
        if (r6 == 0) goto L_0x00bb;
    L_0x0060:
        r7 = new android.widget.LinearLayout;
        r7.<init>(r0);
        r7.setOrientation(r2);
        r0 = new android.widget.LinearLayout$LayoutParams;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r4, r3, r8);
        r8 = r12.f12018l;
        switch(r8) {
            case 0: goto L_0x0091;
            case 1: goto L_0x008a;
            default: goto L_0x0074;
        };
    L_0x0074:
        r0 = "ListPopupWindow";
        r5 = new java.lang.StringBuilder;
        r8 = "Invalid hint position ";
        r5.<init>(r8);
        r8 = r12.f12018l;
        r5.append(r8);
        r5 = r5.toString();
        android.util.Log.e(r0, r5);
        goto L_0x0097;
    L_0x008a:
        r7.addView(r5, r0);
        r7.addView(r6);
        goto L_0x0097;
    L_0x0091:
        r7.addView(r6);
        r7.addView(r5, r0);
    L_0x0097:
        r0 = r12.f12012f;
        if (r0 < 0) goto L_0x009f;
    L_0x009b:
        r0 = r12.f12012f;
        r5 = r1;
        goto L_0x00a1;
    L_0x009f:
        r0 = r3;
        r5 = r0;
    L_0x00a1:
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5);
        r6.measure(r0, r3);
        r0 = r6.getLayoutParams();
        r0 = (android.widget.LinearLayout.LayoutParams) r0;
        r5 = r6.getMeasuredHeight();
        r6 = r0.topMargin;
        r5 = r5 + r6;
        r0 = r0.bottomMargin;
        r5 = r5 + r0;
        r0 = r5;
        r5 = r7;
        goto L_0x00bc;
    L_0x00bb:
        r0 = r3;
    L_0x00bc:
        r6 = r12.f12025s;
        r6.setContentView(r5);
        goto L_0x00dd;
    L_0x00c2:
        r0 = r12.f12025s;
        r0.getContentView();
        r0 = r12.f12001B;
        if (r0 == 0) goto L_0x00dc;
    L_0x00cb:
        r5 = r0.getLayoutParams();
        r5 = (android.widget.LinearLayout.LayoutParams) r5;
        r0 = r0.getMeasuredHeight();
        r6 = r5.topMargin;
        r0 = r0 + r6;
        r5 = r5.bottomMargin;
        r0 = r0 + r5;
        goto L_0x00dd;
    L_0x00dc:
        r0 = r3;
    L_0x00dd:
        r5 = r12.f12025s;
        r5 = r5.getBackground();
        if (r5 == 0) goto L_0x00ff;
    L_0x00e5:
        r6 = r12.f12009J;
        r5.getPadding(r6);
        r5 = r12.f12009J;
        r5 = r5.top;
        r6 = r12.f12009J;
        r6 = r6.bottom;
        r5 = r5 + r6;
        r6 = r12.f12030x;
        if (r6 != 0) goto L_0x0105;
    L_0x00f7:
        r6 = r12.f12009J;
        r6 = r6.top;
        r6 = -r6;
        r12.f12028v = r6;
        goto L_0x0105;
    L_0x00ff:
        r5 = r12.f12009J;
        r5.setEmpty();
        r5 = r3;
    L_0x0105:
        r6 = r12.f12025s;
        r6 = r6.getInputMethodMode();
        r7 = 2;
        if (r6 != r7) goto L_0x0110;
    L_0x010e:
        r6 = r2;
        goto L_0x0111;
    L_0x0110:
        r6 = r3;
    L_0x0111:
        r7 = r12.f12019m;
        r8 = r12.f12028v;
        r6 = r12.m10734a(r7, r8, r6);
        r7 = r12.f12032z;
        if (r7 != 0) goto L_0x017f;
    L_0x011d:
        r7 = r12.f12027u;
        if (r7 != r4) goto L_0x0122;
    L_0x0121:
        goto L_0x017f;
    L_0x0122:
        r7 = r12.f12012f;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        switch(r7) {
            case -2: goto L_0x014b;
            case -1: goto L_0x0130;
            default: goto L_0x0129;
        };
    L_0x0129:
        r1 = r12.f12012f;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8);
        goto L_0x0165;
    L_0x0130:
        r1 = r12.f12010d;
        r1 = r1.getResources();
        r1 = r1.getDisplayMetrics();
        r1 = r1.widthPixels;
        r7 = r12.f12009J;
        r7 = r7.left;
        r9 = r12.f12009J;
        r9 = r9.right;
        r7 = r7 + r9;
        r1 = r1 - r7;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8);
        goto L_0x0165;
    L_0x014b:
        r7 = r12.f12010d;
        r7 = r7.getResources();
        r7 = r7.getDisplayMetrics();
        r7 = r7.widthPixels;
        r8 = r12.f12009J;
        r8 = r8.left;
        r9 = r12.f12009J;
        r9 = r9.right;
        r8 = r8 + r9;
        r7 = r7 - r8;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1);
    L_0x0165:
        r7 = r12.f12011e;
        r6 = r6 - r0;
        r1 = r7.m1980a(r1, r6);
        if (r1 <= 0) goto L_0x017d;
    L_0x016e:
        r6 = r12.f12011e;
        r6 = r6.getPaddingTop();
        r7 = r12.f12011e;
        r7 = r7.getPaddingBottom();
        r6 = r6 + r7;
        r5 = r5 + r6;
        r0 = r0 + r5;
    L_0x017d:
        r1 = r1 + r0;
        goto L_0x0181;
    L_0x017f:
        r6 = r6 + r5;
        r1 = r6;
    L_0x0181:
        r0 = r12.m10749j();
        r5 = r12.f12025s;
        r6 = r12.f12029w;
        android.support.v4.widget.PopupWindowCompat.m1415a(r5, r6);
        r5 = r12.f12025s;
        r5 = r5.isShowing();
        r6 = -2;
        if (r5 == 0) goto L_0x020b;
    L_0x0195:
        r5 = r12.f12019m;
        r5 = android.support.v4.view.ViewCompat.m1209J(r5);
        if (r5 != 0) goto L_0x019e;
    L_0x019d:
        return;
    L_0x019e:
        r5 = r12.f12012f;
        if (r5 != r4) goto L_0x01a4;
    L_0x01a2:
        r5 = r4;
        goto L_0x01b1;
    L_0x01a4:
        r5 = r12.f12012f;
        if (r5 != r6) goto L_0x01af;
    L_0x01a8:
        r5 = r12.f12019m;
        r5 = r5.getWidth();
        goto L_0x01b1;
    L_0x01af:
        r5 = r12.f12012f;
    L_0x01b1:
        r7 = r12.f12027u;
        if (r7 != r4) goto L_0x01df;
    L_0x01b5:
        if (r0 == 0) goto L_0x01b8;
    L_0x01b7:
        goto L_0x01b9;
    L_0x01b8:
        r1 = r4;
    L_0x01b9:
        if (r0 == 0) goto L_0x01cd;
    L_0x01bb:
        r0 = r12.f12025s;
        r6 = r12.f12012f;
        if (r6 != r4) goto L_0x01c3;
    L_0x01c1:
        r6 = r4;
        goto L_0x01c4;
    L_0x01c3:
        r6 = r3;
    L_0x01c4:
        r0.setWidth(r6);
        r0 = r12.f12025s;
        r0.setHeight(r3);
        goto L_0x01e6;
    L_0x01cd:
        r0 = r12.f12025s;
        r6 = r12.f12012f;
        if (r6 != r4) goto L_0x01d5;
    L_0x01d3:
        r6 = r4;
        goto L_0x01d6;
    L_0x01d5:
        r6 = r3;
    L_0x01d6:
        r0.setWidth(r6);
        r0 = r12.f12025s;
        r0.setHeight(r4);
        goto L_0x01e6;
    L_0x01df:
        r0 = r12.f12027u;
        if (r0 == r6) goto L_0x01e6;
    L_0x01e3:
        r0 = r12.f12027u;
        r1 = r0;
    L_0x01e6:
        r0 = r12.f12025s;
        r6 = r12.f12000A;
        if (r6 != 0) goto L_0x01f1;
    L_0x01ec:
        r6 = r12.f12032z;
        if (r6 != 0) goto L_0x01f1;
    L_0x01f0:
        goto L_0x01f2;
    L_0x01f1:
        r2 = r3;
    L_0x01f2:
        r0.setOutsideTouchable(r2);
        r6 = r12.f12025s;
        r7 = r12.f12019m;
        r8 = r12.f12013g;
        r9 = r12.f12028v;
        if (r5 >= 0) goto L_0x0201;
    L_0x01ff:
        r10 = r4;
        goto L_0x0202;
    L_0x0201:
        r10 = r5;
    L_0x0202:
        if (r1 >= 0) goto L_0x0206;
    L_0x0204:
        r11 = r4;
        goto L_0x0207;
    L_0x0206:
        r11 = r1;
    L_0x0207:
        r6.update(r7, r8, r9, r10, r11);
        return;
    L_0x020b:
        r0 = r12.f12012f;
        if (r0 != r4) goto L_0x0211;
    L_0x020f:
        r0 = r4;
        goto L_0x021e;
    L_0x0211:
        r0 = r12.f12012f;
        if (r0 != r6) goto L_0x021c;
    L_0x0215:
        r0 = r12.f12019m;
        r0 = r0.getWidth();
        goto L_0x021e;
    L_0x021c:
        r0 = r12.f12012f;
    L_0x021e:
        r5 = r12.f12027u;
        if (r5 != r4) goto L_0x0224;
    L_0x0222:
        r1 = r4;
        goto L_0x022a;
    L_0x0224:
        r5 = r12.f12027u;
        if (r5 == r6) goto L_0x022a;
    L_0x0228:
        r1 = r12.f12027u;
    L_0x022a:
        r5 = r12.f12025s;
        r5.setWidth(r0);
        r0 = r12.f12025s;
        r0.setHeight(r1);
        r0 = f11997a;
        if (r0 == 0) goto L_0x024f;
    L_0x0238:
        r0 = f11997a;	 Catch:{ Exception -> 0x0248 }
        r1 = r12.f12025s;	 Catch:{ Exception -> 0x0248 }
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0248 }
        r6 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0248 }
        r5[r3] = r6;	 Catch:{ Exception -> 0x0248 }
        r0.invoke(r1, r5);	 Catch:{ Exception -> 0x0248 }
        goto L_0x024f;
    L_0x0248:
        r0 = "ListPopupWindow";
        r1 = "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
    L_0x024f:
        r0 = r12.f12025s;
        r1 = r12.f12000A;
        if (r1 != 0) goto L_0x025b;
    L_0x0255:
        r1 = r12.f12032z;
        if (r1 != 0) goto L_0x025b;
    L_0x0259:
        r1 = r2;
        goto L_0x025c;
    L_0x025b:
        r1 = r3;
    L_0x025c:
        r0.setOutsideTouchable(r1);
        r0 = r12.f12025s;
        r1 = r12.f12005F;
        r0.setTouchInterceptor(r1);
        r0 = r12.f12015i;
        if (r0 == 0) goto L_0x0271;
    L_0x026a:
        r0 = r12.f12025s;
        r1 = r12.f12014h;
        android.support.v4.widget.PopupWindowCompat.m1417a(r0, r1);
    L_0x0271:
        r0 = f11999c;
        if (r0 == 0) goto L_0x028b;
    L_0x0275:
        r0 = f11999c;	 Catch:{ Exception -> 0x0283 }
        r1 = r12.f12025s;	 Catch:{ Exception -> 0x0283 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0283 }
        r5 = r12.f12023q;	 Catch:{ Exception -> 0x0283 }
        r2[r3] = r5;	 Catch:{ Exception -> 0x0283 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0283 }
        goto L_0x028b;
    L_0x0283:
        r0 = move-exception;
        r1 = "ListPopupWindow";
        r2 = "Could not invoke setEpicenterBounds on PopupWindow";
        android.util.Log.e(r1, r2, r0);
    L_0x028b:
        r0 = r12.f12025s;
        r1 = r12.f12019m;
        r2 = r12.f12013g;
        r3 = r12.f12028v;
        r5 = r12.f12016j;
        android.support.v4.widget.PopupWindowCompat.m1416a(r0, r1, r2, r3, r5);
        r0 = r12.f12011e;
        r0.setSelection(r4);
        r0 = r12.f12024r;
        if (r0 == 0) goto L_0x02a9;
    L_0x02a1:
        r0 = r12.f12011e;
        r0 = r0.isInTouchMode();
        if (r0 == 0) goto L_0x02ac;
    L_0x02a9:
        r12.m10748i();
    L_0x02ac:
        r0 = r12.f12024r;
        if (r0 != 0) goto L_0x02b7;
    L_0x02b0:
        r0 = r12.f12022p;
        r1 = r12.f12007H;
        r0.post(r1);
    L_0x02b7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.d():void");
    }
}
