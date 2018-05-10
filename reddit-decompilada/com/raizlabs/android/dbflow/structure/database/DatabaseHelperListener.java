package com.raizlabs.android.dbflow.structure.database;

public interface DatabaseHelperListener {
    void onCreate(DatabaseWrapper databaseWrapper);

    void onDowngrade(DatabaseWrapper databaseWrapper, int i, int i2);

    void onOpen(DatabaseWrapper databaseWrapper);

    void onUpgrade(DatabaseWrapper databaseWrapper, int i, int i2);
}
