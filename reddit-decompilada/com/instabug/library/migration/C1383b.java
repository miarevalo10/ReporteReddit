package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.settings.SettingsManager;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/* compiled from: LastContactedAtToLastBugAndLastChatTimeMigration */
public class C1383b extends AbstractMigration {

    /* compiled from: LastContactedAtToLastBugAndLastChatTimeMigration */
    class C16561 implements OnSubscribe<AbstractMigration> {
        final /* synthetic */ C1383b f18568a;

        C16561(C1383b c1383b) {
            this.f18568a = c1383b;
        }

        public final /* synthetic */ void m19502a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.a_(this.f18568a);
            subscriber.b();
        }
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public String getMigrationId() {
        return "last_contacted_at_to_last_bug_and_last_chat_time_migration";
    }

    public int getMigrationVersion() {
        return 3;
    }

    public void initialize(Context context) {
    }

    public C1383b() {
        super("last_contacted_at_to_last_bug_and_last_chat_time_migration");
    }

    public boolean shouldMigrate() {
        return getMigrationVersion() > SettingsManager.getInstance().getLastMigrationVersion() && SettingsManager.getInstance().getLastContactedAt() != 0;
    }

    public Observable<AbstractMigration> migrate() {
        return Observable.a(new C16561(this));
    }
}
