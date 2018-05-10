package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/* compiled from: SDKForwardMigration */
public class C1385e extends AbstractMigration {

    /* compiled from: SDKForwardMigration */
    class C16591 implements OnSubscribe<AbstractMigration> {
        final /* synthetic */ C1385e f18570a;

        C16591(C1385e c1385e) {
            this.f18570a = c1385e;
        }

        public final /* synthetic */ void m19506a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            CacheManager.getInstance().invalidateAllCaches();
            subscriber.a_(this.f18570a);
            subscriber.b();
        }
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 4;
    }

    public void initialize(Context context) {
    }

    C1385e() {
        super("sdk_forward_migration");
    }

    public boolean shouldMigrate() {
        String lastSDKVersion = SettingsManager.getInstance().getLastSDKVersion();
        if (!"4.11.1".contains(Operation.MINUS)) {
            if (!lastSDKVersion.contains(Operation.MINUS)) {
                if (StringUtility.compareVersion("4.11.1", lastSDKVersion) != 1) {
                    if (SettingsManager.getInstance().isSDKVersionSet()) {
                        return false;
                    }
                }
                return true;
            }
        }
        if (StringUtility.compareVersion(String.valueOf("4.11.1".charAt(0)), String.valueOf(lastSDKVersion.charAt(0))) != 1) {
            if (SettingsManager.getInstance().isSDKVersionSet()) {
                return false;
            }
        }
        return true;
    }

    public Observable<AbstractMigration> migrate() {
        return Observable.a(new C16591(this));
    }

    public void doAfterMigration() {
        InstabugSDKLogger.m8359i(this, "doAfterMigration called");
        SettingsManager.getInstance().setCurrentSDKVersion("4.11.1");
    }
}
