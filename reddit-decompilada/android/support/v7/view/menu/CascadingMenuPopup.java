package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnDismissListener {
    private OnDismissListener f16609A;
    final Handler f16610a;
    final List<CascadingMenuInfo> f16611b = new ArrayList();
    View f16612c;
    boolean f16613d;
    private final Context f16614f;
    private final int f16615g;
    private final int f16616h;
    private final int f16617i;
    private final boolean f16618j;
    private final List<MenuBuilder> f16619k = new LinkedList();
    private final OnGlobalLayoutListener f16620l = new C01841(this);
    private final OnAttachStateChangeListener f16621m = new C01852(this);
    private final MenuItemHoverListener f16622n = new C10193(this);
    private int f16623o = 0;
    private int f16624p = 0;
    private View f16625q;
    private int f16626r;
    private boolean f16627s;
    private boolean f16628t;
    private int f16629u;
    private int f16630v;
    private boolean f16631w;
    private boolean f16632x;
    private Callback f16633y;
    private ViewTreeObserver f16634z;

    class C01841 implements OnGlobalLayoutListener {
        final /* synthetic */ CascadingMenuPopup f2018a;

        C01841(CascadingMenuPopup cascadingMenuPopup) {
            this.f2018a = cascadingMenuPopup;
        }

        public void onGlobalLayout() {
            if (this.f2018a.mo655f() && this.f2018a.f16611b.size() > 0 && !((CascadingMenuInfo) this.f2018a.f16611b.get(0)).f2024a.f12024r) {
                View view = this.f2018a.f16612c;
                if (view != null) {
                    if (view.isShown()) {
                        for (CascadingMenuInfo cascadingMenuInfo : this.f2018a.f16611b) {
                            cascadingMenuInfo.f2024a.mo653d();
                        }
                    }
                }
                this.f2018a.mo654e();
            }
        }
    }

    class C01852 implements OnAttachStateChangeListener {
        final /* synthetic */ CascadingMenuPopup f2019a;

        public void onViewAttachedToWindow(View view) {
        }

        C01852(CascadingMenuPopup cascadingMenuPopup) {
            this.f2019a = cascadingMenuPopup;
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f2019a.f16634z != null) {
                if (!this.f2019a.f16634z.isAlive()) {
                    this.f2019a.f16634z = view.getViewTreeObserver();
                }
                this.f2019a.f16634z.removeGlobalOnLayoutListener(this.f2019a.f16620l);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private static class CascadingMenuInfo {
        public final MenuPopupWindow f2024a;
        public final MenuBuilder f2025b;
        public final int f2026c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f2024a = menuPopupWindow;
            this.f2025b = menuBuilder;
            this.f2026c = i;
        }
    }

    class C10193 implements MenuItemHoverListener {
        final /* synthetic */ CascadingMenuPopup f11730a;

        C10193(CascadingMenuPopup cascadingMenuPopup) {
            this.f11730a = cascadingMenuPopup;
        }

        public final void mo534a(MenuBuilder menuBuilder, MenuItem menuItem) {
            this.f11730a.f16610a.removeCallbacksAndMessages(menuBuilder);
        }

        public final void mo535b(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            CascadingMenuInfo cascadingMenuInfo = null;
            this.f11730a.f16610a.removeCallbacksAndMessages(null);
            int size = this.f11730a.f16611b.size();
            int i = 0;
            while (i < size) {
                if (menuBuilder == ((CascadingMenuInfo) this.f11730a.f16611b.get(i)).f2025b) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                i++;
                if (i < this.f11730a.f16611b.size()) {
                    cascadingMenuInfo = (CascadingMenuInfo) this.f11730a.f16611b.get(i);
                }
                this.f11730a.f16610a.postAtTime(new Runnable(this) {
                    final /* synthetic */ C10193 f2023d;

                    public void run() {
                        if (cascadingMenuInfo != null) {
                            this.f2023d.f11730a.f16613d = true;
                            cascadingMenuInfo.f2025b.close(false);
                            this.f2023d.f11730a.f16613d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    public final void mo46a(Parcelable parcelable) {
    }

    public final boolean mo50a() {
        return false;
    }

    public final Parcelable mo55c() {
        return null;
    }

    protected final boolean mo3208h() {
        return false;
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.f16614f = context;
        this.f16625q = view;
        this.f16616h = i;
        this.f16617i = i2;
        this.f16618j = z;
        this.f16631w = false;
        this.f16626r = m16824i();
        context = context.getResources();
        this.f16615g = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(C0164R.dimen.abc_config_prefDialogWidth));
        this.f16610a = new Handler();
    }

    public final void mo3205b(boolean z) {
        this.f16631w = z;
    }

    public final void mo653d() {
        if (!mo655f()) {
            for (MenuBuilder c : this.f16619k) {
                m16823c(c);
            }
            this.f16619k.clear();
            this.f16612c = this.f16625q;
            if (this.f16612c != null) {
                Object obj = this.f16634z == null ? 1 : null;
                this.f16634z = this.f16612c.getViewTreeObserver();
                if (obj != null) {
                    this.f16634z.addOnGlobalLayoutListener(this.f16620l);
                }
                this.f16612c.addOnAttachStateChangeListener(this.f16621m);
            }
        }
    }

    public final void mo654e() {
        int size = this.f16611b.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f16611b.toArray(new CascadingMenuInfo[size]);
            for (size--; size >= 0; size--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[size];
                if (cascadingMenuInfo.f2024a.f12025s.isShowing()) {
                    cascadingMenuInfo.f2024a.mo654e();
                }
            }
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return null;
        }
        mo654e();
        return true;
    }

    private int m16824i() {
        return ViewCompat.m1242f(this.f16625q) == 1 ? 0 : 1;
    }

    public final void mo3201a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f16614f);
        if (mo655f()) {
            m16823c(menuBuilder);
        } else {
            this.f16619k.add(menuBuilder);
        }
    }

    private void m16823c(android.support.v7.view.menu.MenuBuilder r18) {
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
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r0.f16614f;
        r2 = android.view.LayoutInflater.from(r2);
        r3 = new android.support.v7.view.menu.MenuAdapter;
        r4 = r0.f16618j;
        r3.<init>(r1, r2, r4);
        r4 = r17.mo655f();
        r5 = 1;
        if (r4 != 0) goto L_0x001f;
    L_0x0018:
        r4 = r0.f16631w;
        if (r4 == 0) goto L_0x001f;
    L_0x001c:
        r3.f2031c = r5;
        goto L_0x002b;
    L_0x001f:
        r4 = r17.mo655f();
        if (r4 == 0) goto L_0x002b;
    L_0x0025:
        r4 = android.support.v7.view.menu.MenuPopup.m10499b(r18);
        r3.f2031c = r4;
    L_0x002b:
        r4 = r0.f16614f;
        r6 = r0.f16615g;
        r7 = 0;
        r4 = android.support.v7.view.menu.MenuPopup.m10497a(r3, r7, r4, r6);
        r6 = new android.support.v7.widget.MenuPopupWindow;
        r8 = r0.f16614f;
        r9 = r0.f16616h;
        r10 = r0.f16617i;
        r6.<init>(r8, r9, r10);
        r8 = r0.f16622n;
        r6.f16714b = r8;
        r6.f12020n = r0;
        r6.m10739a(r0);
        r8 = r0.f16625q;
        r6.f12019m = r8;
        r8 = r0.f16624p;
        r6.f12016j = r8;
        r6.m10740b();
        r6.m10747h();
        r6.mo3229a(r3);
        r6.m10741b(r4);
        r3 = r0.f16624p;
        r6.f12016j = r3;
        r3 = r0.f16611b;
        r3 = r3.size();
        r8 = 0;
        if (r3 <= 0) goto L_0x00e0;
    L_0x0069:
        r3 = r0.f16611b;
        r9 = r0.f16611b;
        r9 = r9.size();
        r9 = r9 - r5;
        r3 = r3.get(r9);
        r3 = (android.support.v7.view.menu.CascadingMenuPopup.CascadingMenuInfo) r3;
        r9 = r3.f2025b;
        r10 = r9.size();
        r11 = r8;
    L_0x007f:
        if (r11 >= r10) goto L_0x0095;
    L_0x0081:
        r12 = r9.getItem(r11);
        r13 = r12.hasSubMenu();
        if (r13 == 0) goto L_0x0092;
    L_0x008b:
        r13 = r12.getSubMenu();
        if (r1 != r13) goto L_0x0092;
    L_0x0091:
        goto L_0x0096;
    L_0x0092:
        r11 = r11 + 1;
        goto L_0x007f;
    L_0x0095:
        r12 = r7;
    L_0x0096:
        if (r12 != 0) goto L_0x0099;
    L_0x0098:
        goto L_0x00e2;
    L_0x0099:
        r9 = r3.f2024a;
        r9 = r9.f12011e;
        r10 = r9.getAdapter();
        r11 = r10 instanceof android.widget.HeaderViewListAdapter;
        if (r11 == 0) goto L_0x00b2;
    L_0x00a5:
        r10 = (android.widget.HeaderViewListAdapter) r10;
        r11 = r10.getHeadersCount();
        r10 = r10.getWrappedAdapter();
        r10 = (android.support.v7.view.menu.MenuAdapter) r10;
        goto L_0x00b5;
    L_0x00b2:
        r10 = (android.support.v7.view.menu.MenuAdapter) r10;
        r11 = r8;
    L_0x00b5:
        r13 = r10.getCount();
        r14 = r8;
    L_0x00ba:
        r15 = -1;
        if (r14 >= r13) goto L_0x00c8;
    L_0x00bd:
        r7 = r10.m1710a(r14);
        if (r12 != r7) goto L_0x00c4;
    L_0x00c3:
        goto L_0x00c9;
    L_0x00c4:
        r14 = r14 + 1;
        r7 = 0;
        goto L_0x00ba;
    L_0x00c8:
        r14 = r15;
    L_0x00c9:
        if (r14 != r15) goto L_0x00cc;
    L_0x00cb:
        goto L_0x00e1;
    L_0x00cc:
        r14 = r14 + r11;
        r7 = r9.getFirstVisiblePosition();
        r14 = r14 - r7;
        if (r14 < 0) goto L_0x00e1;
    L_0x00d4:
        r7 = r9.getChildCount();
        if (r14 < r7) goto L_0x00db;
    L_0x00da:
        goto L_0x00e1;
    L_0x00db:
        r7 = r9.getChildAt(r14);
        goto L_0x00e2;
    L_0x00e0:
        r3 = 0;
    L_0x00e1:
        r7 = 0;
    L_0x00e2:
        if (r7 == 0) goto L_0x0193;
    L_0x00e4:
        r9 = android.support.v7.widget.MenuPopupWindow.f16713a;
        if (r9 == 0) goto L_0x00ff;
    L_0x00e8:
        r9 = android.support.v7.widget.MenuPopupWindow.f16713a;	 Catch:{ Exception -> 0x00f8 }
        r10 = r6.s;	 Catch:{ Exception -> 0x00f8 }
        r11 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00f8 }
        r12 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x00f8 }
        r11[r8] = r12;	 Catch:{ Exception -> 0x00f8 }
        r9.invoke(r10, r11);	 Catch:{ Exception -> 0x00f8 }
        goto L_0x00ff;
    L_0x00f8:
        r9 = "MenuPopupWindow";
        r10 = "Could not invoke setTouchModal() on PopupWindow. Oh well.";
        android.util.Log.i(r9, r10);
    L_0x00ff:
        r9 = android.os.Build.VERSION.SDK_INT;
        r10 = 23;
        if (r9 < r10) goto L_0x010b;
    L_0x0105:
        r9 = r6.s;
        r10 = 0;
        r9.setEnterTransition(r10);
    L_0x010b:
        r9 = r0.f16611b;
        r10 = r0.f16611b;
        r10 = r10.size();
        r10 = r10 - r5;
        r9 = r9.get(r10);
        r9 = (android.support.v7.view.menu.CascadingMenuPopup.CascadingMenuInfo) r9;
        r9 = r9.f2024a;
        r9 = r9.f12011e;
        r10 = 2;
        r11 = new int[r10];
        r9.getLocationOnScreen(r11);
        r12 = new android.graphics.Rect;
        r12.<init>();
        r13 = r0.f16612c;
        r13.getWindowVisibleDisplayFrame(r12);
        r13 = r0.f16626r;
        if (r13 != r5) goto L_0x0140;
    L_0x0132:
        r11 = r11[r8];
        r9 = r9.getWidth();
        r11 = r11 + r9;
        r11 = r11 + r4;
        r9 = r12.right;
        if (r11 > r9) goto L_0x0146;
    L_0x013e:
        r9 = r5;
        goto L_0x0147;
    L_0x0140:
        r9 = r11[r8];
        r9 = r9 - r4;
        if (r9 >= 0) goto L_0x0146;
    L_0x0145:
        goto L_0x013e;
    L_0x0146:
        r9 = r8;
    L_0x0147:
        if (r9 != r5) goto L_0x014b;
    L_0x0149:
        r11 = r5;
        goto L_0x014c;
    L_0x014b:
        r11 = r8;
    L_0x014c:
        r0.f16626r = r9;
        r9 = android.os.Build.VERSION.SDK_INT;
        r12 = 26;
        if (r9 < r12) goto L_0x0159;
    L_0x0154:
        r6.f12019m = r7;
        r9 = r8;
        r12 = r9;
        goto L_0x0170;
    L_0x0159:
        r9 = new int[r10];
        r12 = r0.f16625q;
        r12.getLocationOnScreen(r9);
        r10 = new int[r10];
        r7.getLocationOnScreen(r10);
        r12 = r10[r8];
        r13 = r9[r8];
        r12 = r12 - r13;
        r10 = r10[r5];
        r9 = r9[r5];
        r9 = r10 - r9;
    L_0x0170:
        r10 = r0.f16624p;
        r13 = 5;
        r10 = r10 & r13;
        if (r10 != r13) goto L_0x0180;
    L_0x0176:
        if (r11 == 0) goto L_0x017a;
    L_0x0178:
        r12 = r12 + r4;
        goto L_0x0189;
    L_0x017a:
        r4 = r7.getWidth();
        r12 = r12 - r4;
        goto L_0x0189;
    L_0x0180:
        if (r11 == 0) goto L_0x0188;
    L_0x0182:
        r4 = r7.getWidth();
        r12 = r12 + r4;
        goto L_0x0189;
    L_0x0188:
        r12 = r12 - r4;
    L_0x0189:
        r6.f12013g = r12;
        r6.f12015i = r5;
        r6.f12014h = r5;
        r6.m10736a(r9);
        goto L_0x01a8;
    L_0x0193:
        r4 = r0.f16627s;
        if (r4 == 0) goto L_0x019b;
    L_0x0197:
        r4 = r0.f16629u;
        r6.f12013g = r4;
    L_0x019b:
        r4 = r0.f16628t;
        if (r4 == 0) goto L_0x01a4;
    L_0x019f:
        r4 = r0.f16630v;
        r6.m10736a(r4);
    L_0x01a4:
        r4 = r0.f11804e;
        r6.f12023q = r4;
    L_0x01a8:
        r4 = new android.support.v7.view.menu.CascadingMenuPopup$CascadingMenuInfo;
        r5 = r0.f16626r;
        r4.<init>(r6, r1, r5);
        r5 = r0.f16611b;
        r5.add(r4);
        r6.mo653d();
        r4 = r6.f12011e;
        r4.setOnKeyListener(r0);
        if (r3 != 0) goto L_0x01ea;
    L_0x01be:
        r3 = r0.f16632x;
        if (r3 == 0) goto L_0x01ea;
    L_0x01c2:
        r3 = r18.getHeaderTitle();
        if (r3 == 0) goto L_0x01ea;
    L_0x01c8:
        r3 = android.support.v7.appcompat.C0164R.layout.abc_popup_menu_header_item_layout;
        r2 = r2.inflate(r3, r4, r8);
        r2 = (android.widget.FrameLayout) r2;
        r3 = 16908310; // 0x1020016 float:2.387729E-38 double:8.353815E-317;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.TextView) r3;
        r2.setEnabled(r8);
        r1 = r18.getHeaderTitle();
        r3.setText(r1);
        r1 = 0;
        r4.addHeaderView(r2, r1, r8);
        r6.mo653d();
    L_0x01ea:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.CascadingMenuPopup.c(android.support.v7.view.menu.MenuBuilder):void");
    }

    public final boolean mo655f() {
        return this.f16611b.size() > 0 && ((CascadingMenuInfo) this.f16611b.get(0)).f2024a.f12025s.isShowing();
    }

    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f16611b.size();
        for (int i = 0; i < size; i++) {
            cascadingMenuInfo = (CascadingMenuInfo) this.f16611b.get(i);
            if (!cascadingMenuInfo.f2024a.f12025s.isShowing()) {
                break;
            }
        }
        cascadingMenuInfo = null;
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f2025b.close(false);
        }
    }

    public final void mo49a(boolean z) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f16611b) {
            MenuPopup.m10498a(cascadingMenuInfo.f2024a.f12011e.getAdapter()).notifyDataSetChanged();
        }
    }

    public final void mo48a(Callback callback) {
        this.f16633y = callback;
    }

    public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f16611b) {
            if (subMenuBuilder == cascadingMenuInfo.f2025b) {
                cascadingMenuInfo.f2024a.f12011e.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return null;
        }
        mo3201a((MenuBuilder) subMenuBuilder);
        if (this.f16633y != null) {
            this.f16633y.mo429a(subMenuBuilder);
        }
        return true;
    }

    public final void mo3200a(int i) {
        if (this.f16623o != i) {
            this.f16623o = i;
            this.f16624p = GravityCompat.m1096a(i, ViewCompat.m1242f(this.f16625q));
        }
    }

    public final void mo3202a(View view) {
        if (this.f16625q != view) {
            this.f16625q = view;
            this.f16624p = GravityCompat.m1096a(this.f16623o, ViewCompat.m1242f(this.f16625q));
        }
    }

    public final void mo3203a(OnDismissListener onDismissListener) {
        this.f16609A = onDismissListener;
    }

    public final ListView mo656g() {
        if (this.f16611b.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) this.f16611b.get(this.f16611b.size() - 1)).f2024a.f12011e;
    }

    public final void mo3204b(int i) {
        this.f16627s = true;
        this.f16629u = i;
    }

    public final void mo3206c(int i) {
        this.f16628t = true;
        this.f16630v = i;
    }

    public final void mo3207c(boolean z) {
        this.f16632x = z;
    }

    public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        int size = this.f16611b.size();
        int i = 0;
        while (i < size) {
            if (menuBuilder == ((CascadingMenuInfo) this.f16611b.get(i)).f2025b) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            size = i + 1;
            if (size < this.f16611b.size()) {
                ((CascadingMenuInfo) this.f16611b.get(size)).f2025b.close(false);
            }
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) this.f16611b.remove(i);
            cascadingMenuInfo.f2025b.removeMenuPresenter(this);
            if (this.f16613d) {
                MenuPopupWindow menuPopupWindow = cascadingMenuInfo.f2024a;
                if (VERSION.SDK_INT >= 23) {
                    menuPopupWindow.s.setExitTransition(null);
                }
                cascadingMenuInfo.f2024a.f12025s.setAnimationStyle(0);
            }
            cascadingMenuInfo.f2024a.mo654e();
            size = this.f16611b.size();
            if (size > 0) {
                this.f16626r = ((CascadingMenuInfo) this.f16611b.get(size - 1)).f2026c;
            } else {
                this.f16626r = m16824i();
            }
            if (size == 0) {
                mo654e();
                if (this.f16633y) {
                    this.f16633y.mo428a(menuBuilder, true);
                }
                if (this.f16634z != null) {
                    if (this.f16634z.isAlive() != null) {
                        this.f16634z.removeGlobalOnLayoutListener(this.f16620l);
                    }
                    this.f16634z = null;
                }
                this.f16612c.removeOnAttachStateChangeListener(this.f16621m);
                this.f16609A.onDismiss();
                return;
            }
            if (z) {
                ((CascadingMenuInfo) this.f16611b.get(0)).f2025b.close(false);
            }
        }
    }
}
