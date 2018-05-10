package com.facebook.stetho.inspector.elements.android;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.widget.EditText;
import com.facebook.stetho.common.android.AccessibilityUtil;
import com.google.android.gms.ads.AdRequest;
import java.util.Iterator;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class AccessibilityNodeInfoWrapper {
    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1318a();
        ViewCompat.m1223a(view, a);
        return a;
    }

    public static boolean getIsAccessibilityFocused(View view) {
        view = createNodeInfoFromView(view);
        boolean c = view.m1332c();
        view.f1523a.recycle();
        return c;
    }

    public static boolean getIgnored(View view) {
        int d = ViewCompat.m1237d(view);
        if (d != 2) {
            if (d != 4) {
                for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                    if (ViewCompat.m1237d((View) parent) == 4) {
                        return true;
                    }
                }
                AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
                try {
                    if (!createNodeInfoFromView.m1330b()) {
                        return true;
                    }
                    if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                        if (createNodeInfoFromView.f1523a.getChildCount() <= 0) {
                            createNodeInfoFromView.f1523a.recycle();
                            return false;
                        } else if (AccessibilityUtil.isSpeakingNode(createNodeInfoFromView, view) != null) {
                            createNodeInfoFromView.f1523a.recycle();
                            return false;
                        } else {
                            createNodeInfoFromView.f1523a.recycle();
                            return true;
                        }
                    } else if (AccessibilityUtil.hasFocusableAncestor(createNodeInfoFromView, view) != null || AccessibilityUtil.hasText(createNodeInfoFromView) == null) {
                        createNodeInfoFromView.f1523a.recycle();
                        return true;
                    } else {
                        createNodeInfoFromView.f1523a.recycle();
                        return false;
                    }
                } finally {
                    createNodeInfoFromView.f1523a.recycle();
                }
            }
        }
        return true;
    }

    public static String getIgnoredReasons(View view) {
        int d = ViewCompat.m1237d(view);
        if (d == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (d == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.m1237d((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.m1330b()) {
                view = "View is not visible.";
                return view;
            } else if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view) != null) {
                view = "View is actionable, but has no description.";
                createNodeInfoFromView.f1523a.recycle();
                return view;
            } else if (AccessibilityUtil.hasText(createNodeInfoFromView) != null) {
                view = "View is not actionable, and an ancestor View has co-opted its description.";
                createNodeInfoFromView.f1523a.recycle();
                return view;
            } else {
                view = "View is not actionable and has no description.";
                createNodeInfoFromView.f1523a.recycle();
                return view;
            }
        } finally {
            createNodeInfoFromView.f1523a.recycle();
        }
    }

    public static String getFocusableReasons(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean hasText = AccessibilityUtil.hasText(createNodeInfoFromView);
            boolean isCheckable = createNodeInfoFromView.f1523a.isCheckable();
            boolean hasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(createNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(createNodeInfoFromView)) {
                if (createNodeInfoFromView.f1523a.getChildCount() <= 0) {
                    view = "View is actionable and has no children.";
                    return view;
                } else if (hasText) {
                    view = "View is actionable and has a description.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                } else if (isCheckable) {
                    view = "View is actionable and checkable.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                } else if (hasNonActionableSpeakingDescendants) {
                    view = "View is actionable and has non-actionable descendants with descriptions.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(createNodeInfoFromView, view) != null) {
                if (hasText) {
                    view = "View is a direct child of a scrollable container and has a description.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                } else if (isCheckable) {
                    view = "View is a direct child of a scrollable container and is checkable.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                } else if (hasNonActionableSpeakingDescendants) {
                    view = "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                    createNodeInfoFromView.f1523a.recycle();
                    return view;
                }
            }
            if (hasText) {
                view = "View has a description and is not actionable, but has no actionable ancestor.";
                createNodeInfoFromView.f1523a.recycle();
                return view;
            }
            createNodeInfoFromView.f1523a.recycle();
            return null;
        } finally {
            createNodeInfoFromView.f1523a.recycle();
        }
    }

    public static String getActions(View view) {
        view = createNodeInfoFromView(view);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = view.m1333d().iterator();
            while (true) {
                String str = null;
                if (it.hasNext()) {
                    AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) it.next();
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    switch (VERSION.SDK_INT >= 21 ? ((AccessibilityAction) accessibilityActionCompat.f1520E).getId() : 0) {
                        case 1:
                            stringBuilder.append("focus");
                            break;
                        case 2:
                            stringBuilder.append("clear-focus");
                            break;
                        case 4:
                            stringBuilder.append("select");
                            break;
                        case 8:
                            stringBuilder.append("clear-selection");
                            break;
                        case 16:
                            stringBuilder.append("click");
                            break;
                        case 32:
                            stringBuilder.append("long-click");
                            break;
                        case 64:
                            stringBuilder.append("accessibility-focus");
                            break;
                        case 128:
                            stringBuilder.append("clear-accessibility-focus");
                            break;
                        case 256:
                            stringBuilder.append("next-at-movement-granularity");
                            break;
                        case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                            stringBuilder.append("previous-at-movement-granularity");
                            break;
                        case 1024:
                            stringBuilder.append("next-html-element");
                            break;
                        case MPEGConst.CODE_END /*2048*/:
                            stringBuilder.append("previous-html-element");
                            break;
                        case 4096:
                            stringBuilder.append("scroll-forward");
                            break;
                        case 8192:
                            stringBuilder.append("scroll-backward");
                            break;
                        case 16384:
                            stringBuilder.append("copy");
                            break;
                        case 32768:
                            stringBuilder.append("paste");
                            break;
                        case 65536:
                            stringBuilder.append("cut");
                            break;
                        case 131072:
                            stringBuilder.append("set-selection");
                            break;
                        default:
                            CharSequence label;
                            if (VERSION.SDK_INT >= 21) {
                                label = ((AccessibilityAction) accessibilityActionCompat.f1520E).getLabel();
                            }
                            if (label == null) {
                                stringBuilder.append("unknown");
                                break;
                            }
                            stringBuilder.append(label);
                            break;
                    }
                }
                if (stringBuilder.length() > 0) {
                    str = stringBuilder.toString();
                }
                view.f1523a.recycle();
                return str;
            }
        } catch (Throwable th) {
            view.f1523a.recycle();
        }
    }

    public static CharSequence getDescription(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence contentDescription = createNodeInfoFromView.f1523a.getContentDescription();
            CharSequence text = createNodeInfoFromView.f1523a.getText();
            int isEmpty = TextUtils.isEmpty(text) ^ 1;
            boolean z = view instanceof EditText;
            if (!TextUtils.isEmpty(contentDescription) && (!z || isEmpty == 0)) {
                createNodeInfoFromView.f1523a.recycle();
                return contentDescription;
            } else if (isEmpty != 0) {
                createNodeInfoFromView.f1523a.recycle();
                return text;
            } else {
                text = null;
                if (view instanceof ViewGroup) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (isEmpty = 0; isEmpty < childCount; isEmpty++) {
                        View childAt = viewGroup.getChildAt(isEmpty);
                        AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1318a();
                        ViewCompat.m1223a(childAt, a);
                        CharSequence description = (!AccessibilityUtil.isSpeakingNode(a, childAt) || AccessibilityUtil.isAccessibilityFocusable(a, childAt)) ? null : getDescription(childAt);
                        if (!TextUtils.isEmpty(description)) {
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(description);
                        }
                        a.f1523a.recycle();
                    }
                    if (stringBuilder.length() > null) {
                        text = stringBuilder.toString();
                    }
                    createNodeInfoFromView.f1523a.recycle();
                    return text;
                }
                createNodeInfoFromView.f1523a.recycle();
                return null;
            }
        } catch (Throwable th) {
            createNodeInfoFromView.f1523a.recycle();
        }
    }
}
