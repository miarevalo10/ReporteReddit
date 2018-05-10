package com.instabug.library.annotation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.instabug.library.C0593R;
import com.instabug.library.util.AttrResolver;

public class ShapeSuggestionsLayout extends LinearLayout {
    boolean f9480a;
    final Runnable f9481b;
    Handler f9482c;
    private float f9483d;
    private C0617a f9484e;

    class C06141 implements Runnable {
        final /* synthetic */ ShapeSuggestionsLayout f9469a;

        C06141(ShapeSuggestionsLayout shapeSuggestionsLayout) {
            this.f9469a = shapeSuggestionsLayout;
        }

        public void run() {
            this.f9469a.m8041a();
        }
    }

    class C06152 implements AnimatorListener {
        final /* synthetic */ ShapeSuggestionsLayout f9470a;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        C06152(ShapeSuggestionsLayout shapeSuggestionsLayout) {
            this.f9470a = shapeSuggestionsLayout;
        }

        public void onAnimationEnd(Animator animator) {
            this.f9470a.setVisibility(4);
            this.f9470a.removeAllViews();
        }
    }

    class C06163 implements OnClickListener {
        final /* synthetic */ ShapeSuggestionsLayout f9471a;

        C06163(ShapeSuggestionsLayout shapeSuggestionsLayout) {
            this.f9471a = shapeSuggestionsLayout;
        }

        public void onClick(View view) {
            view = this.f9471a.indexOfChild(view);
            this.f9471a.m8042a((int) view);
            if (this.f9471a.f9484e != null) {
                this.f9471a.f9484e.mo2568a(view);
            }
            this.f9471a.m8041a();
        }
    }

    interface C0617a {
        void mo2568a(int i);
    }

    private final class C0618b extends View {
        final /* synthetic */ ShapeSuggestionsLayout f9472a;
        private Path f9473b;
        private Path f9474c;
        private Paint f9475d = new Paint(1);
        private RectF f9476e;
        private RectF f9477f;
        private int f9478g;
        private int f9479h;

        public C0618b(ShapeSuggestionsLayout shapeSuggestionsLayout, Context context, Path path, int i) {
            this.f9472a = shapeSuggestionsLayout;
            super(context);
            this.f9473b = path;
            this.f9475d.setStrokeWidth(4.0f);
            this.f9479h = i;
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            i = (int) getResources().getDimension(C0593R.dimen.instabug_path_view_margin);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.setMargins(i, i, i, i);
            setLayoutParams(layoutParams);
            i = (int) getResources().getDimension(C0593R.dimen.instabug_path_view_dimen);
            setMeasuredDimension(i, i);
            i = (float) i;
            this.f9476e = new RectF(0.0f, 0.0f, i, i);
            this.f9477f = new RectF(this.f9476e);
            this.f9477f.inset(8.0f, 8.0f);
            i = this.f9473b;
            i2 = this.f9477f;
            Path path = new Path(i);
            i = new RectF();
            path.computeBounds(i, true);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(i, i2, ScaleToFit.CENTER);
            path.transform(matrix);
            this.f9474c = path;
        }

        protected final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.f9475d.setColor(this.f9478g);
            this.f9475d.setStyle(Style.FILL);
            canvas.drawRoundRect(this.f9476e, this.f9472a.f9483d, this.f9472a.f9483d, this.f9475d);
            this.f9475d.setColor(this.f9479h);
            this.f9475d.setStyle(Style.STROKE);
            canvas.drawPath(this.f9474c, this.f9475d);
        }

        public final void setBackgroundColor(int i) {
            this.f9478g = i;
            invalidate();
        }
    }

    public ShapeSuggestionsLayout(Context context) {
        this(context, null);
    }

    public ShapeSuggestionsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public ShapeSuggestionsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9481b = new C06141(this);
        this.f9482c = new Handler();
        setVisibility(4);
        setGravity(17);
        context = context.getResources().getDisplayMetrics();
        this.f9483d = TypedValue.applyDimension(1, 1082130432, context);
        context = (int) TypedValue.applyDimension(1, 1069547520, context);
        attributeSet = new GradientDrawable();
        attributeSet.setColor(AttrResolver.getBackgroundColor(getContext()));
        attributeSet.setCornerRadius(this.f9483d);
        attributeSet.setStroke(context, AttrResolver.getDividerColor(getContext()));
        if (VERSION.SDK_INT >= 16) {
            setBackground(attributeSet);
        } else {
            setBackgroundDrawable(attributeSet);
        }
    }

    public void setOnShapeSelectedListener(C0617a c0617a) {
        this.f9484e = c0617a;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9482c.removeCallbacks(this.f9481b);
        this.f9482c = null;
    }

    final void m8041a() {
        this.f9482c.removeCallbacks(this.f9481b);
        if (!this.f9480a) {
            this.f9480a = true;
            if (VERSION.SDK_INT >= 12) {
                animate().alpha(0.0f).setDuration(400).setListener(new C06152(this));
            }
        }
    }

    final void m8042a(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setBackgroundColor(0);
        }
        getChildAt(i).setBackgroundColor(AttrResolver.getDividerColor(getContext()));
    }
}
