package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/* compiled from: MigrationManager */
public final class C0736c {
    private static final AbstractMigration[] f9801a = new AbstractMigration[]{new C1382a(), new C1386f(), new C1383b(), new C1384d(), new C1385e()};

    /* compiled from: MigrationManager */
    static class C16571 extends Subscriber<AbstractMigration> {
        C16571() {
        }

        public final /* synthetic */ void a_(Object obj) {
            AbstractMigration abstractMigration = (AbstractMigration) obj;
            StringBuilder stringBuilder = new StringBuilder("Migration ");
            stringBuilder.append(abstractMigration.getMigrationId());
            stringBuilder.append(" done");
            InstabugSDKLogger.m8356d(C0736c.class, stringBuilder.toString());
            abstractMigration.doAfterMigration();
        }

        public final void aV_() {
            super.aV_();
        }

        public final void m19504b() {
            InstabugSDKLogger.m8356d(C0736c.class, "All Migrations completed, setting lastMigrationVersion to 4");
            SettingsManager.getInstance().setLastMigrationVersion(4);
        }

        public final void m19503a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Migration failed");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8356d(C0736c.class, stringBuilder.toString());
        }
    }

    private static Observable[] m8304a(ArrayList<Observable<AbstractMigration>> arrayList) {
        Observable[] observableArr = new Observable[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            observableArr[i] = (Observable) arrayList.get(i);
        }
        return observableArr;
    }

    public static void m8303a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (AbstractMigration abstractMigration : f9801a) {
            abstractMigration.initialize(context);
            boolean z = abstractMigration.getMigrationVersion() <= 4 && abstractMigration.shouldMigrate();
            StringBuilder stringBuilder = new StringBuilder("Checking if should apply this migration: ");
            stringBuilder.append(abstractMigration.getMigrationId());
            stringBuilder.append(", result is ");
            stringBuilder.append(z);
            stringBuilder.append(" last migration version is ");
            stringBuilder.append(SettingsManager.getInstance().getLastMigrationVersion());
            stringBuilder.append(" target migration version 4");
            InstabugSDKLogger.m8356d(C0736c.class, stringBuilder.toString());
            if (z) {
                abstractMigration.doPreMigration();
                arrayList.add(abstractMigration.migrate());
            }
        }
        context = C0736c.m8304a(arrayList);
        if (context.length != 0) {
            Observable.a(new C16571(), Observable.a(context).a(Schedulers.d()).b(Schedulers.d()));
        } else {
            InstabugSDKLogger.m8356d(C0736c.class, "No migrations to run");
        }
    }
}
