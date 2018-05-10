package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import org.jcodec.containers.mps.MPSUtils;

public class ActionMenuItemView extends AppCompatTextView implements ItemView, ActionMenuChildView, OnClickListener {
    MenuItemImpl f16598b;
    ItemInvoker f16599c;
    PopupCallback f16600d;
    private CharSequence f16601e;
    private Drawable f16602f;
    private ForwardingListener f16603g;
    private boolean f16604h;
    private boolean f16605i;
    private int f16606j;
    private int f16607k;
    private int f16608l;

    public static abstract class PopupCallback {
        public abstract ShowableListMenu mo568a();
    }

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView f11716a;

        public ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
            this.f11716a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public final ShowableListMenu mo532a() {
            return this.f11716a.f16600d != null ? this.f11716a.f16600d.mo568a() : null;
        }

        protected final boolean mo533b() {
            if (this.f11716a.f16599c == null || !this.f11716a.f16599c.mo537a(this.f11716a.f16598b)) {
                return false;
            }
            ShowableListMenu a = mo532a();
            if (a == null || !a.mo655f()) {
                return false;
            }
            return true;
        }
    }

    public final boolean mo539a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f16604h = m16813e();
        context = context.obtainStyledAttributes(attributeSet, C0164R.styleable.ActionMenuItemView, i, 0);
        this.f16606j = context.getDimensionPixelSize(C0164R.styleable.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.f16608l = (int) ((1107296256 * resources.getDisplayMetrics().density) + 1056964608);
        setOnClickListener(this);
        this.f16607k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f16604h = m16813e();
        m16814f();
    }

    private boolean m16813e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < MPSUtils.VIDEO_MIN && (i < 640 || i2 < MPSUtils.VIDEO_MIN)) {
            if (configuration.orientation != 2) {
                return false;
            }
        }
        return true;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f16607k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public MenuItemImpl getItemData() {
        return this.f16598b;
    }

    public final void mo538a(MenuItemImpl menuItemImpl) {
        this.f16598b = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.m10477a((ItemView) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() != null && this.f16603g == null) {
            this.f16603g = new ActionMenuItemForwardingListener(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f16598b.hasSubMenu() && this.f16603g != null && this.f16603g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f16599c != null) {
            this.f16599c.mo537a(this.f16598b);
        }
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.f16599c = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f16600d = popupCallback;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f16605i != z) {
            this.f16605i = z;
            if (this.f16598b) {
                z = this.f16598b;
                z.f11778b.onItemActionRequestChanged(z);
            }
        }
    }

    private void m16814f() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.f16601e) ^ 1;
        if (this.f16602f != null) {
            if (((this.f16598b.f11779c & 4) == 4 ? 1 : 0) != 0) {
                if (!this.f16604h) {
                    if (this.f16605i) {
                    }
                }
            }
            i = 0;
        }
        isEmpty &= i;
        CharSequence charSequence = null;
        setText(isEmpty != 0 ? this.f16601e : null);
        CharSequence contentDescription = this.f16598b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty != 0) {
                contentDescription = null;
            } else {
                contentDescription = this.f16598b.getTitle();
            }
            setContentDescription(contentDescription);
        } else {
            setContentDescription(contentDescription);
        }
        contentDescription = this.f16598b.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty == 0) {
                charSequence = this.f16598b.getTitle();
            }
            TooltipCompat.m2349a(this, charSequence);
            return;
        }
        TooltipCompat.m2349a(this, contentDescription);
    }

    public void setIcon(Drawable drawable) {
        this.f16602f = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f16608l) {
                f = ((float) this.f16608l) / ((float) intrinsicWidth);
                intrinsicWidth = this.f16608l;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f16608l) {
                f = ((float) this.f16608l) / ((float) intrinsicHeight);
                intrinsicHeight = this.f16608l;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m16814f();
    }

    public final boolean m16817b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f16601e = charSequence;
        m16814f();
    }

    public final boolean mo3198c() {
        return m16817b() && this.f16598b.getIcon() == null;
    }

    public final boolean mo3199d() {
        return m16817b();
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m16817b();
        if (b && this.f16607k >= 0) {
            super.setPadding(this.f16607k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        i = mode == Integer.MIN_VALUE ? Math.min(i, this.f16606j) : this.f16606j;
        if (mode != 1073741824 && this.f16606j > 0 && measuredWidth < i) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), i2);
        }
        if (!b && this.f16602f != 0) {
            super.setPadding((getMeasuredWidth() - this.f16602f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
