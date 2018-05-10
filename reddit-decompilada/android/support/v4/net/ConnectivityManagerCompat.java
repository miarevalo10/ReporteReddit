package android.support.v4.net;

import android.net.ConnectivityManager;
import android.os.Build.VERSION;

public final class ConnectivityManagerCompat {
    public static boolean m970a(ConnectivityManager connectivityManager) {
        if (VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        connectivityManager = connectivityManager.getActiveNetworkInfo();
        if (connectivityManager == null) {
            return true;
        }
        switch (connectivityManager.getType()) {
            case null:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            case 1:
            case 7:
            case 9:
                return null;
            default:
                return true;
        }
    }
}
