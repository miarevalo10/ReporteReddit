package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.settings.SettingsManager;
import rx.Observable;
import rx.Observable.OnSubscribe;

/* compiled from: LastContactedAtMigration */
public class C1382a extends AbstractMigration {
    private static String f15521b = "last_contacted_at_migration";
    private Context f15522a;

    /* compiled from: LastContactedAtMigration */
    class C16551 implements OnSubscribe<AbstractMigration> {
        final /* synthetic */ C1382a f18567a;

        public final /* synthetic */ void m19501a(Object obj) {
        }

        C16551(C1382a c1382a) {
            this.f18567a = c1382a;
        }
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 1;
    }

    public C1382a() {
        super(f15521b);
    }

    public String getMigrationId() {
        return f15521b;
    }

    public void initialize(Context context) {
        this.f15522a = context;
    }

    public boolean shouldMigrate() {
        return getMigrationVersion() > SettingsManager.getInstance().getLastMigrationVersion() && SettingsManager.getInstance().isDeviceRegistered() && SettingsManager.getInstance().getLastContactedAt() == 0;
    }

    public Observable<AbstractMigration> migrate() {
        return Observable.a(new C16551(this));
    }
}
