package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.ForeignKey;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Property;

public class DbOpenHelper extends SQLiteOpenHelper {
    static final Property f3015a = new Property("insertionOrder", "integer", 0);
    static final Property f3016b = new Property("_id", "text", 1, null, true);
    static final Property f3017c = new Property("priority", "integer", 2);
    static final Property f3018d = new Property("group_id", "text", 3);
    static final Property f3019e = new Property("run_count", "integer", 4);
    static final Property f3020f = new Property("created_ns", "long", 5);
    static final Property f3021g = new Property("delay_until_ns", "long", 6);
    static final Property f3022h = new Property("running_session_id", "long", 7);
    static final Property f3023i = new Property("network_type", "integer", 8);
    static final Property f3024j = new Property("deadline", "integer", 9);
    static final Property f3025k = new Property("cancel_on_deadline", "integer", 10);
    static final Property f3026l = new Property("cancelled", "integer", 11);
    static final Property f3027m = new Property("_id", "integer", 0);
    static final Property f3028n = new Property("job_id", "text", new ForeignKey("job_holder", f3016b.f3038a));
    static final Property f3029o = new Property("tag_name", "text", 2);

    public DbOpenHelper(Context context, String str) {
        super(context, str, null, 12);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SqlHelper.m2583a("job_holder", f3015a, f3016b, f3017c, f3018d, f3019e, f3020f, f3021g, f3022h, f3023i, f3024j, f3025k, f3026l));
        sQLiteDatabase.execSQL(SqlHelper.m2583a("job_holder_tags", f3027m, f3028n, f3029o));
        StringBuilder stringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS TAG_NAME_INDEX ON job_holder_tags(");
        stringBuilder.append(f3029o.f3038a);
        stringBuilder.append(")");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 11) {
            i = new StringBuilder("ALTER TABLE job_holder ADD COLUMN ");
            i.append(f3026l.f3038a);
            i.append(" ");
            i.append(f3026l.f3039b);
            sQLiteDatabase.execSQL(i.toString());
            return;
        }
        sQLiteDatabase.execSQL(SqlHelper.m2582a("job_holder"));
        sQLiteDatabase.execSQL(SqlHelper.m2582a("job_holder_tags"));
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS TAG_NAME_INDEX");
        onCreate(sQLiteDatabase);
    }
}
