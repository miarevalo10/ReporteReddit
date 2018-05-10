package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class AccessibilityNodeInfoCompat {
    public final AccessibilityNodeInfo f1523a;
    public int f1524b = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat f1490A = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_DOWN : null);
        public static final AccessibilityActionCompat f1491B = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_RIGHT : null);
        public static final AccessibilityActionCompat f1492C = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_CONTEXT_CLICK : null);
        public static final AccessibilityActionCompat f1493D;
        public static final AccessibilityActionCompat f1494a = new AccessibilityActionCompat(1);
        public static final AccessibilityActionCompat f1495b = new AccessibilityActionCompat(2);
        public static final AccessibilityActionCompat f1496c = new AccessibilityActionCompat(4);
        public static final AccessibilityActionCompat f1497d = new AccessibilityActionCompat(8);
        public static final AccessibilityActionCompat f1498e = new AccessibilityActionCompat(16);
        public static final AccessibilityActionCompat f1499f = new AccessibilityActionCompat(32);
        public static final AccessibilityActionCompat f1500g = new AccessibilityActionCompat(64);
        public static final AccessibilityActionCompat f1501h = new AccessibilityActionCompat(128);
        public static final AccessibilityActionCompat f1502i = new AccessibilityActionCompat(256);
        public static final AccessibilityActionCompat f1503j = new AccessibilityActionCompat((int) AdRequest.MAX_CONTENT_URL_LENGTH);
        public static final AccessibilityActionCompat f1504k = new AccessibilityActionCompat(1024);
        public static final AccessibilityActionCompat f1505l = new AccessibilityActionCompat((int) MPEGConst.CODE_END);
        public static final AccessibilityActionCompat f1506m = new AccessibilityActionCompat(4096);
        public static final AccessibilityActionCompat f1507n = new AccessibilityActionCompat(8192);
        public static final AccessibilityActionCompat f1508o = new AccessibilityActionCompat(16384);
        public static final AccessibilityActionCompat f1509p = new AccessibilityActionCompat(32768);
        public static final AccessibilityActionCompat f1510q = new AccessibilityActionCompat(65536);
        public static final AccessibilityActionCompat f1511r = new AccessibilityActionCompat(131072);
        public static final AccessibilityActionCompat f1512s = new AccessibilityActionCompat(262144);
        public static final AccessibilityActionCompat f1513t = new AccessibilityActionCompat(524288);
        public static final AccessibilityActionCompat f1514u = new AccessibilityActionCompat(1048576);
        public static final AccessibilityActionCompat f1515v = new AccessibilityActionCompat(2097152);
        public static final AccessibilityActionCompat f1516w = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);
        public static final AccessibilityActionCompat f1517x = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
        public static final AccessibilityActionCompat f1518y = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_UP : null);
        public static final AccessibilityActionCompat f1519z = new AccessibilityActionCompat(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_LEFT : null);
        public final Object f1520E;

        static {
            Object obj = null;
            if (VERSION.SDK_INT >= 24) {
                obj = AccessibilityAction.ACTION_SET_PROGRESS;
            }
            f1493D = new AccessibilityActionCompat(obj);
        }

        private AccessibilityActionCompat(int i) {
            this(VERSION.SDK_INT >= 21 ? new AccessibilityAction(i, null) : null);
        }

        AccessibilityActionCompat(Object obj) {
            this.f1520E = obj;
        }
    }

    public static class CollectionInfoCompat {
        public final Object f1521a;

        public static CollectionInfoCompat m1316a(int i, int i2) {
            if (VERSION.SDK_INT >= 21) {
                return new CollectionInfoCompat(CollectionInfo.obtain(i, i2, false, 0));
            }
            if (VERSION.SDK_INT >= 19) {
                return new CollectionInfoCompat(CollectionInfo.obtain(i, i2, false));
            }
            return new CollectionInfoCompat(0);
        }

        private CollectionInfoCompat(Object obj) {
            this.f1521a = obj;
        }
    }

    public static class CollectionItemInfoCompat {
        public final Object f1522a;

        public static CollectionItemInfoCompat m1317a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 21) {
                return new CollectionItemInfoCompat(CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (VERSION.SDK_INT >= true) {
                return new CollectionItemInfoCompat(CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new CollectionItemInfoCompat(0);
        }

        public CollectionItemInfoCompat(Object obj) {
            this.f1522a = obj;
        }
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.toString():java.lang.String
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.toString():java.lang.String");
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1523a = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat m1320a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static AccessibilityNodeInfoCompat m1318a() {
        return m1320a(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat m1319a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return m1320a(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f1523a));
    }

    public final void m1321a(int i) {
        this.f1523a.addAction(i);
    }

    public final boolean m1327a(AccessibilityActionCompat accessibilityActionCompat) {
        return VERSION.SDK_INT >= 21 ? this.f1523a.removeAction((AccessibilityAction) accessibilityActionCompat.f1520E) : null;
    }

    public final void m1323a(View view) {
        this.f1523a.setParent(view);
    }

    public final void m1322a(Rect rect) {
        this.f1523a.getBoundsInParent(rect);
    }

    public final void m1328b(Rect rect) {
        this.f1523a.getBoundsInScreen(rect);
    }

    public final void m1326a(boolean z) {
        this.f1523a.setCheckable(z);
    }

    public final void m1329b(boolean z) {
        this.f1523a.setFocusable(z);
    }

    public final void m1331c(boolean z) {
        this.f1523a.setFocused(z);
    }

    public final boolean m1330b() {
        return VERSION.SDK_INT >= 16 ? this.f1523a.isVisibleToUser() : false;
    }

    public final boolean m1332c() {
        return VERSION.SDK_INT >= 16 ? this.f1523a.isAccessibilityFocused() : false;
    }

    public final void m1334d(boolean z) {
        this.f1523a.setScrollable(z);
    }

    public final void m1324a(CharSequence charSequence) {
        this.f1523a.setClassName(charSequence);
    }

    public final void m1325a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f1523a.setCollectionItemInfo((CollectionItemInfo) ((CollectionItemInfoCompat) obj).f1522a);
        }
    }

    public final List<AccessibilityActionCompat> m1333d() {
        List actionList = VERSION.SDK_INT >= 21 ? this.f1523a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        List<AccessibilityActionCompat> arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public final void m1335e(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f1523a.setDismissable(z);
        }
    }

    public int hashCode() {
        return this.f1523a == null ? 0 : this.f1523a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        if (this.f1523a == null) {
            if (accessibilityNodeInfoCompat.f1523a != null) {
                return false;
            }
        } else if (this.f1523a.equals(accessibilityNodeInfoCompat.f1523a) == null) {
            return false;
        }
        return true;
    }
}
