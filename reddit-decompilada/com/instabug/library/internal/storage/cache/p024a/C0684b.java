package com.instabug.library.internal.storage.cache.p024a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: InstabugDbHelper */
public class C0684b extends SQLiteOpenHelper {
    public C0684b(Context context) {
        super(context, "instabug.db", null, 5);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE network_logs (_id INTEGER PRIMARY KEY,url TEXT,request TEXT,method TEXT,response TEXT,status INTEGER,headers TEXT,date TEXT,response_time INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS instabug_logs (log_message TEXT,log_level TEXT,log_date TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_events_logs ( event_identifier TEXT,event_logging_count INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_event ( event_identifier TEXT,time_stamp TEXT,extra_attributes TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_api ( time_stamp TEXT, api_name TEXT, count INTEGER, is_deprecated TEXT, parameters TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m8193a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m8193a(sQLiteDatabase);
    }

    private void m8193a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network_logs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS instabug_logs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_events_logs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sdk_event");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sdk_api");
        onCreate(sQLiteDatabase);
    }
}
