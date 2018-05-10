package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] f11907a = new int[]{16843505};
    private final AppCompatBackgroundHelper f11908b;
    private final Context f11909c;
    private ForwardingListener f11910d;
    private SpinnerAdapter f11911e;
    private final boolean f11912f;
    private DropdownPopup f11913g;
    private int f11914h;
    private final Rect f11915i;

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2167a;
        private ListAdapter f2168b;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2167a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2168b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public int getCount() {
            return this.f2167a == null ? 0 : this.f2167a.getCount();
        }

        public Object getItem(int i) {
            return this.f2167a == null ? 0 : this.f2167a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2167a == null ? -1 : this.f2167a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f2167a == null) {
                return 0;
            }
            return this.f2167a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2167a != null && this.f2167a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2167a != null) {
                this.f2167a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2167a != null) {
                this.f2167a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2168b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2168b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class DropdownPopup extends ListPopupWindow {
        CharSequence f16683a;
        ListAdapter f16684b;
        final Rect f16685c = new Rect();
        final /* synthetic */ AppCompatSpinner f16686d;

        class C01962 implements OnGlobalLayoutListener {
            final /* synthetic */ DropdownPopup f2171a;

            C01962(DropdownPopup dropdownPopup) {
                this.f2171a = dropdownPopup;
            }

            public void onGlobalLayout() {
                DropdownPopup dropdownPopup = this.f2171a;
                View view = this.f2171a.f16686d;
                Object obj = (ViewCompat.m1209J(view) && view.getGlobalVisibleRect(dropdownPopup.f16685c)) ? 1 : null;
                if (obj == null) {
                    this.f2171a.mo654e();
                    return;
                }
                this.f2171a.m16902a();
                super.mo653d();
            }
        }

        public DropdownPopup(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.f16686d = appCompatSpinner;
            super(context, attributeSet, i);
            this.f12019m = appCompatSpinner;
            m10740b();
            this.f12018l = null;
            this.f12020n = new OnItemClickListener(this) {
                final /* synthetic */ DropdownPopup f2170b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2170b.f16686d.setSelection(i);
                    if (this.f2170b.f16686d.getOnItemClickListener() != null) {
                        this.f2170b.f16686d.performItemClick(view, i, this.f2170b.f16684b.getItemId(i));
                    }
                    this.f2170b.mo654e();
                }
            };
        }

        public final void mo3229a(ListAdapter listAdapter) {
            super.mo3229a(listAdapter);
            this.f16684b = listAdapter;
        }

        final void m16902a() {
            int i;
            Drawable background = this.f12025s.getBackground();
            int i2 = 0;
            if (background != null) {
                background.getPadding(this.f16686d.f11915i);
                if (ViewUtils.m2390a(this.f16686d)) {
                    i = this.f16686d.f11915i.right;
                } else {
                    i = -this.f16686d.f11915i.left;
                }
                i2 = i;
            } else {
                Rect b = this.f16686d.f11915i;
                this.f16686d.f11915i.right = 0;
                b.left = 0;
            }
            i = this.f16686d.getPaddingLeft();
            int paddingRight = this.f16686d.getPaddingRight();
            int width = this.f16686d.getWidth();
            if (this.f16686d.f11914h == -2) {
                int a = this.f16686d.m10583a((SpinnerAdapter) this.f16684b, this.f12025s.getBackground());
                int i3 = (this.f16686d.getContext().getResources().getDisplayMetrics().widthPixels - this.f16686d.f11915i.left) - this.f16686d.f11915i.right;
                if (a > i3) {
                    a = i3;
                }
                m10741b(Math.max(a, (width - i) - paddingRight));
            } else if (this.f16686d.f11914h == -1) {
                m10741b((width - i) - paddingRight);
            } else {
                m10741b(this.f16686d.f11914h);
            }
            this.f12013g = ViewUtils.m2390a(this.f16686d) ? i2 + ((width - paddingRight) - this.f12012f) : i2 + i;
        }

        public final void mo653d() {
            boolean isShowing = this.f12025s.isShowing();
            m16902a();
            m10747h();
            super.mo653d();
            this.f12011e.setChoiceMode(1);
            int selectedItemPosition = this.f16686d.getSelectedItemPosition();
            DropDownListView dropDownListView = this.f12011e;
            if (this.f12025s.isShowing() && dropDownListView != null) {
                dropDownListView.setListSelectionHidden(false);
                dropDownListView.setSelection(selectedItemPosition);
                if (dropDownListView.getChoiceMode() != 0) {
                    dropDownListView.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = this.f16686d.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c01962 = new C01962(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c01962);
                    m10739a(new OnDismissListener(this) {
                        final /* synthetic */ DropdownPopup f2173b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2173b.f16686d.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c01962);
                            }
                        }
                    });
                }
            }
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, (int) (byte) -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12) {
        /*
        r8 = this;
        r8.<init>(r9, r10, r11);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r8.f11915i = r0;
        r0 = android.support.v7.appcompat.C0164R.styleable.Spinner;
        r1 = 0;
        r0 = android.support.v7.widget.TintTypedArray.m2308a(r9, r10, r0, r11, r1);
        r2 = new android.support.v7.widget.AppCompatBackgroundHelper;
        r2.<init>(r8);
        r8.f11908b = r2;
        r2 = android.support.v7.appcompat.C0164R.styleable.Spinner_popupTheme;
        r2 = r0.m2323g(r2, r1);
        r3 = 0;
        if (r2 == 0) goto L_0x0027;
    L_0x0021:
        r4 = new android.support.v7.view.ContextThemeWrapper;
        r4.<init>(r9, r2);
        goto L_0x0030;
    L_0x0027:
        r2 = android.os.Build.VERSION.SDK_INT;
        r4 = 23;
        if (r2 >= r4) goto L_0x002f;
    L_0x002d:
        r4 = r9;
        goto L_0x0030;
    L_0x002f:
        r4 = r3;
    L_0x0030:
        r8.f11909c = r4;
        r2 = r8.f11909c;
        r4 = 1;
        if (r2 == 0) goto L_0x00a0;
    L_0x0037:
        r2 = f11907a;	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r2 = r9.obtainStyledAttributes(r10, r2, r11, r1);	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r5 = r2.hasValue(r1);	 Catch:{ Exception -> 0x004e }
        if (r5 == 0) goto L_0x0048;
    L_0x0043:
        r5 = r2.getInt(r1, r1);	 Catch:{ Exception -> 0x004e }
        r12 = r5;
    L_0x0048:
        if (r2 == 0) goto L_0x005f;
    L_0x004a:
        r2.recycle();
        goto L_0x005f;
    L_0x004e:
        r5 = move-exception;
        goto L_0x0055;
    L_0x0050:
        r9 = move-exception;
        r2 = r3;
        goto L_0x009a;
    L_0x0053:
        r5 = move-exception;
        r2 = r3;
    L_0x0055:
        r6 = "AppCompatSpinner";
        r7 = "Could not read android:spinnerMode";
        android.util.Log.i(r6, r7, r5);	 Catch:{ all -> 0x0099 }
        if (r2 == 0) goto L_0x005f;
    L_0x005e:
        goto L_0x004a;
    L_0x005f:
        if (r12 != r4) goto L_0x00a0;
    L_0x0061:
        r12 = new android.support.v7.widget.AppCompatSpinner$DropdownPopup;
        r2 = r8.f11909c;
        r12.<init>(r8, r2, r10, r11);
        r2 = r8.f11909c;
        r5 = android.support.v7.appcompat.C0164R.styleable.Spinner;
        r1 = android.support.v7.widget.TintTypedArray.m2308a(r2, r10, r5, r11, r1);
        r2 = android.support.v7.appcompat.C0164R.styleable.Spinner_android_dropDownWidth;
        r5 = -2;
        r2 = r1.m2321f(r2, r5);
        r8.f11914h = r2;
        r2 = android.support.v7.appcompat.C0164R.styleable.Spinner_android_popupBackground;
        r2 = r1.m2311a(r2);
        r12.m10737a(r2);
        r2 = android.support.v7.appcompat.C0164R.styleable.Spinner_android_prompt;
        r2 = r0.m2318d(r2);
        r12.f16683a = r2;
        r1 = r1.f2595b;
        r1.recycle();
        r8.f11913g = r12;
        r1 = new android.support.v7.widget.AppCompatSpinner$1;
        r1.<init>(r8, r8, r12);
        r8.f11910d = r1;
        goto L_0x00a0;
    L_0x0099:
        r9 = move-exception;
    L_0x009a:
        if (r2 == 0) goto L_0x009f;
    L_0x009c:
        r2.recycle();
    L_0x009f:
        throw r9;
    L_0x00a0:
        r12 = android.support.v7.appcompat.C0164R.styleable.Spinner_android_entries;
        r1 = r0.f2595b;
        r12 = r1.getTextArray(r12);
        if (r12 == 0) goto L_0x00ba;
    L_0x00aa:
        r1 = new android.widget.ArrayAdapter;
        r2 = 17367048; // 0x1090008 float:2.5162948E-38 double:8.580462E-317;
        r1.<init>(r9, r2, r12);
        r9 = android.support.v7.appcompat.C0164R.layout.support_simple_spinner_dropdown_item;
        r1.setDropDownViewResource(r9);
        r8.setAdapter(r1);
    L_0x00ba:
        r9 = r0.f2595b;
        r9.recycle();
        r8.f11912f = r4;
        r9 = r8.f11911e;
        if (r9 == 0) goto L_0x00cc;
    L_0x00c5:
        r9 = r8.f11911e;
        r8.setAdapter(r9);
        r8.f11911e = r3;
    L_0x00cc:
        r9 = r8.f11908b;
        r9.m1795a(r10, r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public Context getPopupContext() {
        if (this.f11913g != null) {
            return this.f11909c;
        }
        return VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f11913g != null) {
            this.f11913g.m10737a(drawable);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AppCompatResources.m1570b(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f11913g != null) {
            return this.f11913g.f12025s.getBackground();
        }
        return VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f11913g != null) {
            this.f11913g.m10736a(i);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f11913g != null) {
            return this.f11913g.m10742c();
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f11913g != null) {
            this.f11913g.f12013g = i;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f11913g != null) {
            return this.f11913g.f12013g;
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f11913g != null) {
            this.f11914h = i;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f11913g != null) {
            return this.f11914h;
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f11912f) {
            super.setAdapter(spinnerAdapter);
            if (this.f11913g != null) {
                this.f11913g.mo3229a(new DropDownAdapter(spinnerAdapter, (this.f11909c == null ? getContext() : this.f11909c).getTheme()));
            }
            return;
        }
        this.f11911e = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f11913g != null && this.f11913g.f12025s.isShowing()) {
            this.f11913g.mo654e();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11910d == null || !this.f11910d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11913g != 0 && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m10583a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f11913g == null) {
            return super.performClick();
        }
        if (!this.f11913g.f12025s.isShowing()) {
            this.f11913g.mo653d();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f11913g != null) {
            this.f11913g.f16683a = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        if (this.f11913g != null) {
            return this.f11913g.f16683a;
        }
        return super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11908b != null) {
            this.f11908b.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11908b != null) {
            this.f11908b.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11908b != null) {
            this.f11908b.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11908b != null ? this.f11908b.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11908b != null) {
            this.f11908b.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11908b != null ? this.f11908b.m1797c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11908b != null) {
            this.f11908b.m1798d();
        }
    }

    final int m10583a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i2 = 0;
        View view = null;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f11915i);
            i2 += this.f11915i.left + this.f11915i.right;
        }
        return i2;
    }
}
