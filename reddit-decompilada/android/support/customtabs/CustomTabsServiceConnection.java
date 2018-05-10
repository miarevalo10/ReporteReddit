package android.support.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService.Stub;

public abstract class CustomTabsServiceConnection implements ServiceConnection {
    public abstract void mo1942a(CustomTabsClient customTabsClient);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mo1942a(new CustomTabsClient(this, Stub.m9476a(iBinder), componentName) {
            final /* synthetic */ CustomTabsServiceConnection f10996a;
        });
    }
}
