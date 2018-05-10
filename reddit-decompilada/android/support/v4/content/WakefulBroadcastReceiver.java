package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f1229a = new SparseArray();
    private static int f1230b = 1;

    public static ComponentName a_(Context context, Intent intent) {
        synchronized (f1229a) {
            int i = f1230b;
            int i2 = f1230b + 1;
            f1230b = i2;
            if (i2 <= 0) {
                f1230b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            intent = context.startService(intent);
            if (intent == null) {
                return null;
            }
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder("wake:");
            stringBuilder.append(intent.flattenToShortString());
            context = powerManager.newWakeLock(1, stringBuilder.toString());
            context.setReferenceCounted(false);
            context.acquire(60000);
            f1229a.put(i, context);
            return intent;
        }
    }

    public static boolean m760a(Intent intent) {
        intent = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intent == null) {
            return false;
        }
        synchronized (f1229a) {
            WakeLock wakeLock = (WakeLock) f1229a.get(intent);
            if (wakeLock != null) {
                wakeLock.release();
                f1229a.remove(intent);
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder("No active wake lock id #");
            stringBuilder.append(intent);
            Log.w("WakefulBroadcastReceiv.", stringBuilder.toString());
            return true;
        }
    }
}
