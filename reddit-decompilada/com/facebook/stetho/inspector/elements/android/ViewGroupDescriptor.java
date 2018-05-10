package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.android.FragmentCompatUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

final class ViewGroupDescriptor extends AbstractChainedDescriptor<ViewGroup> implements HighlightableDescriptor<ViewGroup> {
    private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap());

    public final View getViewAndBoundsForHighlighting(ViewGroup viewGroup, Rect rect) {
        return viewGroup;
    }

    protected final void onGetChildren(ViewGroup viewGroup, Accumulator<Object> accumulator) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (isChildVisible(childAt)) {
                accumulator.store(getElementForView(viewGroup, childAt));
            }
        }
    }

    private boolean isChildVisible(View view) {
        return (view instanceof DocumentHiddenView) == null ? true : null;
    }

    private Object getElementForView(ViewGroup viewGroup, View view) {
        Object obj = this.mViewToElementMap.get(view);
        if (obj != null) {
            obj = getElement(view, obj);
            if (obj != null && view.getParent() == viewGroup) {
                return obj;
            }
            this.mViewToElementMap.remove(view);
        }
        viewGroup = FragmentCompatUtil.findFragmentForView(view);
        if (viewGroup == null || FragmentCompatUtil.isDialogFragment(viewGroup)) {
            this.mViewToElementMap.put(view, this);
            return view;
        }
        this.mViewToElementMap.put(view, new WeakReference(viewGroup));
        return viewGroup;
    }

    private Object getElement(View view, Object obj) {
        return obj == this ? view : ((WeakReference) obj).get();
    }

    public final Object getElementToHighlightAtPosition(ViewGroup viewGroup, int i, int i2, Rect rect) {
        Object childAt;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            childAt = viewGroup.getChildAt(childCount);
            if (isChildVisible(childAt) && childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    break;
                }
            }
        }
        childAt = null;
        if (childAt != null) {
            return childAt;
        }
        rect.set(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        return viewGroup;
    }
}
