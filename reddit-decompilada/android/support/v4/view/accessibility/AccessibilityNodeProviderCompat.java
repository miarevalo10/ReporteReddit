package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public final Object f1526a;

    @RequiresApi(16)
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat f1525a;

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return null;
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return null;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return false;
        }

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f1525a = accessibilityNodeProviderCompat;
        }
    }

    @RequiresApi(19)
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        public AccessibilityNodeInfo findFocus(int i) {
            return null;
        }

        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (VERSION.SDK_INT >= 19) {
            this.f1526a = new AccessibilityNodeProviderApi19(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.f1526a = new AccessibilityNodeProviderApi16(this);
        } else {
            this.f1526a = null;
        }
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f1526a = obj;
    }
}
