package android.support.design.widget;

import android.content.Context;
import android.support.design.C0016R;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.BaseTransientBottomBar.ContentViewCallback;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {

    public static final class SnackbarLayout extends SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            i = getChildCount();
            i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
    }

    public static Snackbar m9591a(View view, int i, int i2) {
        return m9592a(view, view.getResources().getText(i), i2);
    }

    public final Snackbar m9594a(CharSequence charSequence, final OnClickListener onClickListener) {
        TextView actionView = ((SnackbarContentLayout) this.d.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence)) {
            if (onClickListener != null) {
                actionView.setVisibility(0);
                actionView.setText(charSequence);
                actionView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ Snackbar f603b;

                    public void onClick(View view) {
                        onClickListener.onClick(view);
                        this.f603b.m181a(1);
                    }
                });
                return this;
            }
        }
        actionView.setVisibility(8);
        actionView.setOnClickListener(null);
        return this;
    }

    public static Snackbar m9592a(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    view = (ViewGroup) view;
                    break;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                view = view.getParent();
                if (view instanceof View) {
                    view = view;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                view = r1;
                break;
            }
        }
        view = (ViewGroup) view;
        if (view == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(view.getContext()).inflate(C0016R.layout.design_layout_snackbar_include, view, false);
        BaseTransientBottomBar snackbar = new Snackbar(view, snackbarContentLayout, snackbarContentLayout);
        ((SnackbarContentLayout) snackbar.d.getChildAt(0)).getMessageView().setText(charSequence);
        snackbar.f445e = i;
        return snackbar;
    }

    public final Snackbar m9593a(int i, OnClickListener onClickListener) {
        return m9594a(this.f443c.getText(i), onClickListener);
    }
}
