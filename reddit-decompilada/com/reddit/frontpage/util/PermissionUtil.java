package com.reddit.frontpage.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import java.util.ArrayList;

public class PermissionUtil {

    public enum Permission {
        STORAGE("android.permission.WRITE_EXTERNAL_STORAGE", C1761R.string.permission_label_storage),
        LOCATION("android.permission.ACCESS_COARSE_LOCATION", C1761R.string.permission_label_location),
        CONTACTS("android.permission.WRITE_CONTACTS", C1761R.string.permission_label_contacts);
        
        public final String f21782d;
        final int f21783e;

        private Permission(String str, int i) {
            this.f21782d = str;
            this.f21783e = i;
        }
    }

    public static boolean m23862a(Activity activity, int i) {
        String[] c = m23869c(activity);
        if (c.length <= 0) {
            return true;
        }
        ActivityCompat.a(activity, c, i);
        return null;
    }

    public static boolean m23865a(Screen screen) {
        String[] c = m23869c(screen.am_());
        if (c.length <= 0) {
            return true;
        }
        screen.a(c, 10);
        return null;
    }

    public static boolean m23861a(Activity activity) {
        return m23862a(activity, 10);
    }

    @SuppressLint({"InlinedApi"})
    private static String[] m23869c(Activity activity) {
        ArrayList arrayList = new ArrayList(2);
        if ((ActivityCompat.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == null ? true : null) == null) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean m23866a(int[] iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return 1;
    }

    public static boolean m23864a(Context context) {
        return ActivityCompat.a(context, "android.permission.ACCESS_COARSE_LOCATION") == null ? true : null;
    }

    @TargetApi(23)
    public static boolean m23863a(Activity activity, Permission permission) {
        return (ContextCompat.a(activity, permission.f21782d) == -1 && activity.shouldShowRequestPermissionRationale(permission.f21782d) == null) ? true : null;
    }

    @TargetApi(23)
    public static boolean m23868b(Activity activity, Permission permission) {
        if (!m23863a(activity, permission)) {
            return false;
        }
        new Builder(activity).a(C1761R.string.dialog_permission_permenantly_denied_title).b(activity.getString(C1761R.string.dialog_permission_permenantly_denied_message, new Object[]{activity.getString(permission.f21783e)})).a(C1761R.string.dialog_permission_permenantly_denied_positive_button_label, new PermissionUtil$$Lambda$0(activity)).b(C1761R.string.dialog_permission_permenantly_denied_negative_button_label, null).c();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.reddit.frontpage.util.PermissionUtil.Permission m23860a(java.lang.String r1) {
        /*
        r0 = r1.hashCode();
        switch(r0) {
            case -1888586689: goto L_0x003a;
            case -406040016: goto L_0x0030;
            case -63024214: goto L_0x0026;
            case 214526995: goto L_0x001c;
            case 1365911975: goto L_0x0012;
            case 1977429404: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0044;
    L_0x0008:
        r0 = "android.permission.READ_CONTACTS";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0010:
        r1 = 5;
        goto L_0x0045;
    L_0x0012:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x001a:
        r1 = 1;
        goto L_0x0045;
    L_0x001c:
        r0 = "android.permission.WRITE_CONTACTS";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0024:
        r1 = 4;
        goto L_0x0045;
    L_0x0026:
        r0 = "android.permission.ACCESS_COARSE_LOCATION";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x002e:
        r1 = 2;
        goto L_0x0045;
    L_0x0030:
        r0 = "android.permission.READ_EXTERNAL_STORAGE";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0038:
        r1 = 0;
        goto L_0x0045;
    L_0x003a:
        r0 = "android.permission.ACCESS_FINE_LOCATION";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0042:
        r1 = 3;
        goto L_0x0045;
    L_0x0044:
        r1 = -1;
    L_0x0045:
        switch(r1) {
            case 0: goto L_0x0050;
            case 1: goto L_0x0050;
            case 2: goto L_0x004d;
            case 3: goto L_0x004d;
            case 4: goto L_0x004a;
            case 5: goto L_0x004a;
            default: goto L_0x0048;
        };
    L_0x0048:
        r1 = 0;
        return r1;
    L_0x004a:
        r1 = com.reddit.frontpage.util.PermissionUtil.Permission.CONTACTS;
        return r1;
    L_0x004d:
        r1 = com.reddit.frontpage.util.PermissionUtil.Permission.LOCATION;
        return r1;
    L_0x0050:
        r1 = com.reddit.frontpage.util.PermissionUtil.Permission.STORAGE;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.PermissionUtil.a(java.lang.String):com.reddit.frontpage.util.PermissionUtil$Permission");
    }
}
