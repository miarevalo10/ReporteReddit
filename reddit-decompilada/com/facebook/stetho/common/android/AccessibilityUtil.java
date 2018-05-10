package com.facebook.stetho.common.android;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;

public final class AccessibilityUtil {
    private AccessibilityUtil() {
    }

    public static boolean isSpeakingNode(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                if (!accessibilityNodeInfoCompat.m1330b()) {
                    return false;
                }
                int d = ViewCompat.m1237d(view);
                if (d != 4) {
                    if (d != 2 || accessibilityNodeInfoCompat.f1523a.getChildCount() > 0) {
                        if (!(accessibilityNodeInfoCompat.f1523a.isCheckable() || hasText(accessibilityNodeInfoCompat))) {
                            if (hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view) == null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (!(accessibilityNodeInfoCompat == null || view == null)) {
            if ((view instanceof ViewGroup) != null) {
                view = (ViewGroup) view;
                accessibilityNodeInfoCompat = view.getChildCount();
                for (int i = 0; i < accessibilityNodeInfoCompat; i++) {
                    View childAt = view.getChildAt(i);
                    if (childAt != null) {
                        AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1318a();
                        ViewCompat.m1223a(childAt, a);
                        if (!isAccessibilityFocusable(a, childAt)) {
                            try {
                                if (isSpeakingNode(a, childAt)) {
                                    a.f1523a.recycle();
                                    return true;
                                }
                                a.f1523a.recycle();
                            } finally {
                                view = a.f1523a;
                                view.recycle();
                            }
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                if (!accessibilityNodeInfoCompat.m1330b()) {
                    return false;
                }
                if (isActionableForAccessibility(accessibilityNodeInfoCompat)) {
                    return true;
                }
                if (!isTopLevelScrollItem(accessibilityNodeInfoCompat, view) || isSpeakingNode(accessibilityNodeInfoCompat, view) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isTopLevelScrollItem(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                view = (View) ViewCompat.m1244g(view);
                if (view == null) {
                    return false;
                }
                if (accessibilityNodeInfoCompat.f1523a.isScrollable()) {
                    return true;
                }
                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.m1333d();
                if (!accessibilityNodeInfoCompat.contains(Integer.valueOf(4096))) {
                    if (accessibilityNodeInfoCompat.contains(Integer.valueOf(8192)) == null) {
                        if ((view instanceof Spinner) != null) {
                            return false;
                        }
                        if ((view instanceof AdapterView) == null && (view instanceof ScrollView) == null) {
                            if ((view instanceof HorizontalScrollView) == null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean hasFocusableAncestor(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                accessibilityNodeInfoCompat = ViewCompat.m1244g(view);
                if ((accessibilityNodeInfoCompat instanceof View) == null) {
                    return false;
                }
                AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1318a();
                try {
                    ViewCompat.m1223a((View) accessibilityNodeInfoCompat, a);
                    if (a == null) {
                        return false;
                    }
                    if (isAccessibilityFocusable(a, (View) accessibilityNodeInfoCompat)) {
                        a.f1523a.recycle();
                        return true;
                    } else if (hasFocusableAncestor(a, (View) accessibilityNodeInfoCompat) != null) {
                        a.f1523a.recycle();
                        return true;
                    } else {
                        a.f1523a.recycle();
                        return false;
                    }
                } finally {
                    a.f1523a.recycle();
                }
            }
        }
        return false;
    }

    public static boolean hasText(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfoCompat.f1523a.getText())) {
            if (TextUtils.isEmpty(accessibilityNodeInfoCompat.f1523a.getContentDescription()) != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (!(accessibilityNodeInfoCompat.f1523a.isClickable() || accessibilityNodeInfoCompat.f1523a.isLongClickable())) {
            if (!accessibilityNodeInfoCompat.f1523a.isFocusable()) {
                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.m1333d();
                if (!(accessibilityNodeInfoCompat.contains(Integer.valueOf(16)) || accessibilityNodeInfoCompat.contains(Integer.valueOf(32)))) {
                    if (accessibilityNodeInfoCompat.contains(Integer.valueOf(1)) == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
