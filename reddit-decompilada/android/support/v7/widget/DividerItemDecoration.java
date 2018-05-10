package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
    private static final int[] f11927b = new int[]{16843284};
    public Drawable f11928a;
    private int f11929c;
    private final Rect f11930d = new Rect();

    public DividerItemDecoration(Context context) {
        context = context.obtainStyledAttributes(f11927b);
        this.f11928a = context.getDrawable(0);
        if (this.f11928a == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        context.recycle();
        this.f11929c = 1;
    }

    public final void mo614b(Canvas canvas, RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.f11928a != null) {
                int i = 0;
                int paddingLeft;
                int width;
                int childCount;
                View childAt;
                int round;
                if (this.f11929c == 1) {
                    canvas.save();
                    if (recyclerView.getClipToPadding()) {
                        paddingLeft = recyclerView.getPaddingLeft();
                        width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                        canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                    } else {
                        width = recyclerView.getWidth();
                        paddingLeft = 0;
                    }
                    childCount = recyclerView.getChildCount();
                    while (i < childCount) {
                        childAt = recyclerView.getChildAt(i);
                        recyclerView.getDecoratedBoundsWithMargins(childAt, this.f11930d);
                        round = this.f11930d.bottom + Math.round(childAt.getTranslationY());
                        this.f11928a.setBounds(paddingLeft, round - this.f11928a.getIntrinsicHeight(), width, round);
                        this.f11928a.draw(canvas);
                        i++;
                    }
                    canvas.restore();
                    return;
                }
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    paddingLeft = recyclerView.getPaddingTop();
                    width = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                    canvas.clipRect(recyclerView.getPaddingLeft(), paddingLeft, recyclerView.getWidth() - recyclerView.getPaddingRight(), width);
                } else {
                    width = recyclerView.getHeight();
                    paddingLeft = 0;
                }
                childCount = recyclerView.getChildCount();
                while (i < childCount) {
                    childAt = recyclerView.getChildAt(i);
                    recyclerView.getLayoutManager();
                    LayoutManager.m2075b(childAt, this.f11930d);
                    round = this.f11930d.right + Math.round(childAt.getTranslationX());
                    this.f11928a.setBounds(round - this.f11928a.getIntrinsicWidth(), paddingLeft, round, width);
                    this.f11928a.draw(canvas);
                    i++;
                }
                canvas.restore();
            }
        }
    }

    public final void mo484a(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (this.f11928a == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f11929c == 1) {
            rect.set(0, 0, 0, this.f11928a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f11928a.getIntrinsicWidth(), 0);
        }
    }
}
