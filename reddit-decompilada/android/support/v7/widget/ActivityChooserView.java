package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.ActivityChooserModel.ActivityResolveInfo;
import android.support.v7.widget.ActivityChooserModel.HistoricalRecord;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class ActivityChooserView extends ViewGroup {
    final ActivityChooserViewAdapter f2106a;
    final FrameLayout f2107b;
    final FrameLayout f2108c;
    ActionProvider f2109d;
    final DataSetObserver f2110e;
    OnDismissListener f2111f;
    boolean f2112g;
    int f2113h;
    private final Callbacks f2114i;
    private final LinearLayoutCompat f2115j;
    private final ImageView f2116k;
    private final int f2117l;
    private final OnGlobalLayoutListener f2118m;
    private ListPopupWindow f2119n;
    private boolean f2120o;
    private int f2121p;

    private class ActivityChooserViewAdapter extends BaseAdapter {
        ActivityChooserModel f2099a;
        boolean f2100b;
        final /* synthetic */ ActivityChooserView f2101c;
        private int f2102d;
        private boolean f2103e;
        private boolean f2104f;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getItemViewType(int i) {
            return (this.f2104f && i == getCount() - 1) ? 1 : 0;
        }

        public int getCount() {
            int a = this.f2099a.m1768a();
            if (!(this.f2100b || this.f2099a.m1773b() == null)) {
                a--;
            }
            a = Math.min(a, this.f2102d);
            return this.f2104f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f2100b || this.f2099a.m1773b() == null)) {
                        i++;
                    }
                    return this.f2099a.m1770a(i);
                case 1:
                    return 0;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0164R.id.list_item) {
                        view = LayoutInflater.from(this.f2101c.getContext()).inflate(C0164R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    viewGroup = this.f2101c.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0164R.id.icon)).setImageDrawable(resolveInfo.loadIcon(viewGroup));
                    ((TextView) view.findViewById(C0164R.id.title)).setText(resolveInfo.loadLabel(viewGroup));
                    if (this.f2100b == null || i != 0 || this.f2103e == 0) {
                        view.setActivated(false);
                    } else {
                        view.setActivated(true);
                    }
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        view = LayoutInflater.from(this.f2101c.getContext()).inflate(C0164R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        view.setId(1);
                        ((TextView) view.findViewById(C0164R.id.title)).setText(this.f2101c.getContext().getString(C0164R.string.abc_activity_chooser_view_see_all));
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int m1775a() {
            int i = this.f2102d;
            this.f2102d = RedditJobManager.f10810d;
            int i2 = 0;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i3 = 0;
            View view = null;
            while (i2 < count) {
                view = getView(i2, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i2++;
            }
            this.f2102d = i;
            return i3;
        }

        public final void m1776a(int i) {
            if (this.f2102d != i) {
                this.f2102d = i;
                notifyDataSetChanged();
            }
        }

        public final void m1777a(boolean z) {
            if (this.f2104f != z) {
                this.f2104f = z;
                notifyDataSetChanged();
            }
        }

        public final void m1778a(boolean z, boolean z2) {
            if (this.f2100b != z || this.f2103e != z2) {
                this.f2100b = z;
                this.f2103e = z2;
                notifyDataSetChanged();
            }
        }
    }

    private class Callbacks implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f2105a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i)) {
                case null:
                    this.f2105a.m1781a();
                    if (this.f2105a.f2112g == null) {
                        if (this.f2105a.f2106a.f2100b == null) {
                            i++;
                        }
                        adapterView = this.f2105a.f2106a.f2099a.m1772b(i);
                        if (adapterView != null) {
                            adapterView.addFlags(524288);
                            this.f2105a.getContext().startActivity(adapterView);
                        }
                        return;
                    } else if (i > 0) {
                        adapterView = this.f2105a.f2106a.f2099a;
                        synchronized (adapterView.f2086b) {
                            adapterView.m1774c();
                            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) adapterView.f2087c.get(i);
                            ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) adapterView.f2087c.get(0);
                            adapterView.m1771a(new HistoricalRecord(new ComponentName(activityResolveInfo.f2077a.activityInfo.packageName, activityResolveInfo.f2077a.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.f2078b - activityResolveInfo.f2078b) + 5.0f : 1.0f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f2105a.m1780a(RedditJobManager.f10810d);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f2105a.f2108c) {
                this.f2105a.m1781a();
                view = this.f2105a.f2106a.f2099a.m1772b(this.f2105a.f2106a.f2099a.m1769a(this.f2105a.f2106a.f2099a.m1773b()));
                if (view != null) {
                    view.addFlags(524288);
                    this.f2105a.getContext().startActivity(view);
                }
            } else if (view == this.f2105a.f2107b) {
                this.f2105a.f2112g = false;
                this.f2105a.m1780a(this.f2105a.f2113h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f2105a.f2108c) {
                if (this.f2105a.f2106a.getCount() > null) {
                    this.f2105a.f2112g = true;
                    this.f2105a.m1780a(this.f2105a.f2113h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            if (this.f2105a.f2111f != null) {
                this.f2105a.f2111f.onDismiss();
            }
            if (this.f2105a.f2109d != null) {
                this.f2105a.f2109d.m1090a(false);
            }
        }
    }

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] f11873a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = TintTypedArray.m2307a(context, attributeSet, f11873a);
            setBackgroundDrawable(context.m2311a(null));
            context.f2595b.recycle();
        }
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserViewAdapter activityChooserViewAdapter = this.f2106a;
        ActivityChooserModel activityChooserModel2 = activityChooserViewAdapter.f2101c.f2106a.f2099a;
        if (activityChooserModel2 != null && activityChooserViewAdapter.f2101c.isShown()) {
            activityChooserModel2.unregisterObserver(activityChooserViewAdapter.f2101c.f2110e);
        }
        activityChooserViewAdapter.f2099a = activityChooserModel;
        if (activityChooserModel != null && activityChooserViewAdapter.f2101c.isShown()) {
            activityChooserModel.registerObserver(activityChooserViewAdapter.f2101c.f2110e);
        }
        activityChooserViewAdapter.notifyDataSetChanged();
        if (getListPopupWindow().f12025s.isShowing() != null) {
            m1781a();
            if (getListPopupWindow().f12025s.isShowing() == null) {
                if (this.f2120o != null) {
                    this.f2112g = null;
                    m1780a(this.f2113h);
                }
            }
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2116k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2116k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f2109d = actionProvider;
    }

    final void m1780a(int i) {
        if (this.f2106a.f2099a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2118m);
        boolean z = this.f2108c.getVisibility() == 0;
        int a = this.f2106a.f2099a.m1768a();
        if (i == RedditJobManager.f10810d || a <= i + z) {
            this.f2106a.m1777a(false);
            this.f2106a.m1776a(i);
        } else {
            this.f2106a.m1777a(true);
            this.f2106a.m1776a(i - 1);
        }
        i = getListPopupWindow();
        if (!i.f12025s.isShowing()) {
            if (!this.f2112g) {
                if (z) {
                    this.f2106a.m1778a(false, false);
                    i.m10741b(Math.min(this.f2106a.m1775a(), this.f2117l));
                    i.mo653d();
                    if (this.f2109d != null) {
                        this.f2109d.m1090a(true);
                    }
                    i.f12011e.setContentDescription(getContext().getString(C0164R.string.abc_activitychooserview_choose_application));
                    i.f12011e.setSelector(new ColorDrawable(0));
                }
            }
            this.f2106a.m1778a(true, z);
            i.m10741b(Math.min(this.f2106a.m1775a(), this.f2117l));
            i.mo653d();
            if (this.f2109d != null) {
                this.f2109d.m1090a(true);
            }
            i.f12011e.setContentDescription(getContext().getString(C0164R.string.abc_activitychooserview_choose_application));
            i.f12011e.setSelector(new ColorDrawable(0));
        }
    }

    private boolean m1779b() {
        return getListPopupWindow().f12025s.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.f2106a.f2099a;
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver(this.f2110e);
        }
        this.f2120o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.f2106a.f2099a;
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver(this.f2110e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2118m);
        }
        if (m1779b()) {
            m1781a();
        }
        this.f2120o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f2115j;
        if (this.f2108c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2115j.layout(0, 0, i3 - i, i4 - i2);
        if (!m1779b()) {
            m1781a();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f2106a.f2099a;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2111f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f2113h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f2121p = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f2119n == null) {
            this.f2119n = new ListPopupWindow(getContext());
            this.f2119n.mo3229a(this.f2106a);
            this.f2119n.f12019m = this;
            this.f2119n.m10740b();
            this.f2119n.f12020n = this.f2114i;
            this.f2119n.m10739a(this.f2114i);
        }
        return this.f2119n;
    }

    public final boolean m1781a() {
        if (getListPopupWindow().f12025s.isShowing()) {
            getListPopupWindow().mo654e();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f2118m);
            }
        }
        return true;
    }
}
