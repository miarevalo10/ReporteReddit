package android.support.v4.app;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
    public static final TaskStackBuilderBaseImpl f1177a;
    public final ArrayList<Intent> f1178b = new ArrayList();
    public final Context f1179c;

    public interface SupportParentable {
        Intent w_();
    }

    static class TaskStackBuilderBaseImpl {
        TaskStackBuilderBaseImpl() {
        }

        public PendingIntent mo258a(Context context, Intent[] intentArr, int i) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(context, i, intentArr, 1073741824);
        }
    }

    @RequiresApi(16)
    static class TaskStackBuilderApi16Impl extends TaskStackBuilderBaseImpl {
        TaskStackBuilderApi16Impl() {
        }

        public final PendingIntent mo258a(Context context, Intent[] intentArr, int i) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(context, i, intentArr, 1073741824, null);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1177a = new TaskStackBuilderApi16Impl();
        } else {
            f1177a = new TaskStackBuilderBaseImpl();
        }
    }

    private TaskStackBuilder(Context context) {
        this.f1179c = context;
    }

    public static TaskStackBuilder m707a(Context context) {
        return new TaskStackBuilder(context);
    }

    public final TaskStackBuilder m710a(Intent intent) {
        this.f1178b.add(intent);
        return this;
    }

    public final TaskStackBuilder m712b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f1179c.getPackageManager());
        }
        if (component != null) {
            m709a(component);
        }
        m710a(intent);
        return this;
    }

    public final TaskStackBuilder m709a(ComponentName componentName) {
        int size = this.f1178b.size();
        try {
            componentName = NavUtils.m665a(this.f1179c, componentName);
            while (componentName != null) {
                this.f1178b.add(size, componentName);
                componentName = NavUtils.m665a(this.f1179c, componentName.getComponent());
            }
            return this;
        } catch (ComponentName componentName2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(componentName2);
        }
    }

    public final Intent m708a(int i) {
        return (Intent) this.f1178b.get(i);
    }

    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f1178b.iterator();
    }

    public final void m711a() {
        if (this.f1178b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f1178b.toArray(new Intent[this.f1178b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        ContextCompat.m715a(this.f1179c, intentArr);
    }
}
