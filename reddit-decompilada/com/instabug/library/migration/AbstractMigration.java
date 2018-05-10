package com.instabug.library.migration;

import android.content.Context;
import rx.Observable;

public abstract class AbstractMigration {
    private String migrationId;

    public abstract void doAfterMigration();

    public abstract void doPreMigration();

    public abstract int getMigrationVersion();

    public abstract void initialize(Context context);

    public abstract Observable<AbstractMigration> migrate();

    public abstract boolean shouldMigrate();

    public AbstractMigration(String str) {
        this.migrationId = str;
    }

    public String getMigrationId() {
        return this.migrationId;
    }
}
