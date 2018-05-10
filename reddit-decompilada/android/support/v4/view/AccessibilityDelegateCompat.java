package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class AccessibilityDelegateCompat {
    private static final AccessibilityDelegateBaseImpl f1430a;
    private static final AccessibilityDelegate f1431c = new AccessibilityDelegate();
    final AccessibilityDelegate f1432b = f1430a.mo365a(this);

    static class AccessibilityDelegateBaseImpl {
        public AccessibilityNodeProviderCompat mo364a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public boolean mo366a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }

        AccessibilityDelegateBaseImpl() {
        }

        public AccessibilityDelegate mo365a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ AccessibilityDelegateBaseImpl f1429b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo388d(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo84a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    accessibilityDelegateCompat.mo38a(view, AccessibilityNodeInfoCompat.m1320a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo122b(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo387a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    AccessibilityDelegateCompat.m1076a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    AccessibilityDelegateCompat.m1077c(view, accessibilityEvent);
                }
            };
        }
    }

    @RequiresApi(16)
    static class AccessibilityDelegateApi16Impl extends AccessibilityDelegateBaseImpl {
        AccessibilityDelegateApi16Impl() {
        }

        public final AccessibilityDelegate mo365a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ AccessibilityDelegateApi16Impl f1427b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo388d(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo84a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    accessibilityDelegateCompat.mo38a(view, AccessibilityNodeInfoCompat.m1320a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo122b(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.mo387a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    AccessibilityDelegateCompat.m1076a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    AccessibilityDelegateCompat.m1077c(view, accessibilityEvent);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    view = AccessibilityDelegateCompat.m1075a(view);
                    return view != null ? (AccessibilityNodeProvider) view.f1526a : null;
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return accessibilityDelegateCompat.mo82a(view, i, bundle);
                }
            };
        }

        public final AccessibilityNodeProviderCompat mo364a(AccessibilityDelegate accessibilityDelegate, View view) {
            accessibilityDelegate = accessibilityDelegate.getAccessibilityNodeProvider(view);
            return accessibilityDelegate != null ? new AccessibilityNodeProviderCompat(accessibilityDelegate) : null;
        }

        public final boolean mo366a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1430a = new AccessibilityDelegateApi16Impl();
        } else {
            f1430a = new AccessibilityDelegateBaseImpl();
        }
    }

    public static void m1076a(View view, int i) {
        f1431c.sendAccessibilityEvent(view, i);
    }

    public static void m1077c(View view, AccessibilityEvent accessibilityEvent) {
        f1431c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean mo388d(View view, AccessibilityEvent accessibilityEvent) {
        return f1431c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void mo122b(View view, AccessibilityEvent accessibilityEvent) {
        f1431c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void mo84a(View view, AccessibilityEvent accessibilityEvent) {
        f1431c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f1431c.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.f1523a);
    }

    public boolean mo387a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f1431c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static AccessibilityNodeProviderCompat m1075a(View view) {
        return f1430a.mo364a(f1431c, view);
    }

    public boolean mo82a(View view, int i, Bundle bundle) {
        return f1430a.mo366a(f1431c, view, i, bundle);
    }
}
