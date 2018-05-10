package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/* compiled from: V2CacheFilesMigration */
public class C1386f extends AbstractMigration {
    private Context f15523a;

    /* compiled from: V2CacheFilesMigration */
    class C16601 implements OnSubscribe<AbstractMigration> {
        final /* synthetic */ C1386f f18571a;

        C16601(C1386f c1386f) {
            this.f18571a = c1386f;
        }

        public final /* synthetic */ void m19507a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f18571a.f15523a.getCacheDir());
            stringBuilder.append("/issues.cache");
            File file = new File(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.f18571a.f15523a.getCacheDir());
            stringBuilder2.append("/conversations.cache");
            File file2 = new File(stringBuilder2.toString());
            boolean z = false;
            if (file.exists() ? file.delete() : false) {
                InstabugSDKLogger.m8360v(C1386f.class, "Issues cache file found and deleted");
            }
            if (file2.exists()) {
                z = file2.delete();
            }
            if (z) {
                InstabugSDKLogger.m8360v(C1386f.class, "Conversations cache file found and deleted");
            }
            subscriber.a_(this.f18571a);
            subscriber.b();
        }
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 2;
    }

    C1386f() {
        super("v2_cache_files_migration");
    }

    public void initialize(Context context) {
        this.f15523a = context;
    }

    public boolean shouldMigrate() {
        if (getMigrationVersion() <= SettingsManager.getInstance().getLastMigrationVersion()) {
            return false;
        }
        boolean z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f15523a.getCacheDir());
        stringBuilder.append("/issues.cache");
        File file = new File(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.f15523a.getCacheDir());
        stringBuilder2.append("/conversations.cache");
        File file2 = new File(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getMigrationId());
        stringBuilder2.append(" is ");
        if (!file.exists()) {
            if (!file2.exists()) {
                z = false;
                stringBuilder2.append(z);
                InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
                if (!file.exists()) {
                    if (file2.exists()) {
                        return false;
                    }
                }
                return true;
            }
        }
        z = true;
        stringBuilder2.append(z);
        InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
        if (file.exists()) {
            if (file2.exists()) {
                return false;
            }
        }
        return true;
    }

    public Observable<AbstractMigration> migrate() {
        return Observable.a(new C16601(this));
    }
}
