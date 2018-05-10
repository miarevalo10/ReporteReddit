package android.support.v4.content;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

public final class PermissionChecker {
    public static int m759a(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        str = AppOpsManagerCompat.m522a(str);
        if (str != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid != null) {
                    if (packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                return -1;
            }
            if (AppOpsManagerCompat.m521a(context, str, packageName) != null) {
                return -2;
            }
        }
        return 0;
    }
}
