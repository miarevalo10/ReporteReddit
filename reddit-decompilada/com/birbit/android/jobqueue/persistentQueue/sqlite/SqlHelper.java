package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.birbit.android.jobqueue.log.JqLog;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public class SqlHelper {
    String f3043a;
    String f3044b;
    String f3045c;
    String f3046d;
    String f3047e;
    SQLiteStatement f3048f;
    SQLiteStatement f3049g;
    SQLiteStatement f3050h;
    SQLiteStatement f3051i;
    SQLiteStatement f3052j;
    SQLiteStatement f3053k;
    SQLiteStatement f3054l;
    final StringBuilder f3055m = new StringBuilder();
    final SQLiteDatabase f3056n;
    final String f3057o;
    final String f3058p;
    final int f3059q;
    final String f3060r;
    final int f3061s;
    final long f3062t;
    private SQLiteStatement f3063u;

    public static class ForeignKey {
        final String f3031a;
        final String f3032b;

        public ForeignKey(String str, String str2) {
            this.f3031a = str;
            this.f3032b = str2;
        }
    }

    public static class Order {
        final Property f3036a;
        final Type f3037b;

        public enum Type {
            ASC,
            DESC
        }

        public Order(Property property, Type type) {
            this.f3036a = property;
            this.f3037b = type;
        }
    }

    public static class Property {
        final String f3038a;
        final String f3039b;
        public final int f3040c;
        public final ForeignKey f3041d;
        public final boolean f3042e;

        public Property(String str, String str2, int i) {
            this(str, str2, i, null, false);
        }

        public Property(String str, String str2, ForeignKey foreignKey) {
            this(str, str2, 1, foreignKey, false);
        }

        public Property(String str, String str2, int i, ForeignKey foreignKey, boolean z) {
            this.f3038a = str;
            this.f3039b = str2;
            this.f3040c = i;
            this.f3041d = foreignKey;
            this.f3042e = z;
        }
    }

    public SqlHelper(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, long j) {
        this.f3056n = sQLiteDatabase;
        this.f3057o = str;
        this.f3059q = 12;
        this.f3058p = str2;
        this.f3062t = j;
        this.f3061s = 3;
        this.f3060r = str3;
        sQLiteDatabase = new StringBuilder("SELECT * FROM ");
        sQLiteDatabase.append(str);
        sQLiteDatabase.append(" WHERE ");
        sQLiteDatabase.append(DbOpenHelper.f3016b.f3038a);
        sQLiteDatabase.append(" = ?");
        this.f3043a = sQLiteDatabase.toString();
        sQLiteDatabase = new StringBuilder("SELECT * FROM ");
        sQLiteDatabase.append(str);
        sQLiteDatabase.append(" WHERE ");
        sQLiteDatabase.append(DbOpenHelper.f3016b.f3038a);
        sQLiteDatabase.append(" IN ( SELECT ");
        sQLiteDatabase.append(DbOpenHelper.f3028n.f3038a);
        sQLiteDatabase.append(" FROM ");
        sQLiteDatabase.append(str3);
        sQLiteDatabase.append(" WHERE ");
        sQLiteDatabase.append(DbOpenHelper.f3029o.f3038a);
        sQLiteDatabase.append(" = ?)");
        this.f3044b = sQLiteDatabase.toString();
        sQLiteDatabase = new StringBuilder("SELECT ");
        sQLiteDatabase.append(DbOpenHelper.f3016b.f3038a);
        sQLiteDatabase.append(" FROM ");
        sQLiteDatabase.append(str);
        this.f3045c = sQLiteDatabase.toString();
        sQLiteDatabase = new StringBuilder("SELECT ");
        sQLiteDatabase.append(DbOpenHelper.f3029o.f3038a);
        sQLiteDatabase.append(" FROM job_holder_tags WHERE ");
        sQLiteDatabase.append(DbOpenHelper.f3028n.f3038a);
        sQLiteDatabase.append(" = ?");
        this.f3046d = sQLiteDatabase.toString();
        sQLiteDatabase = new StringBuilder("UPDATE ");
        sQLiteDatabase.append(str);
        sQLiteDatabase.append(" SET ");
        sQLiteDatabase.append(DbOpenHelper.f3026l.f3038a);
        sQLiteDatabase.append(" = 0");
        this.f3047e = sQLiteDatabase.toString();
    }

    public static String m2583a(String str, Property property, Property... propertyArr) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(property.f3038a);
        stringBuilder.append(" ");
        stringBuilder.append(property.f3039b);
        stringBuilder.append("  primary key ");
        for (Property property2 : propertyArr) {
            stringBuilder.append(", `");
            stringBuilder.append(property2.f3038a);
            stringBuilder.append("` ");
            stringBuilder.append(property2.f3039b);
            if (property2.f3042e) {
                stringBuilder.append(" UNIQUE");
            }
        }
        for (Property property22 : propertyArr) {
            if (property22.f3041d != null) {
                ForeignKey foreignKey = property22.f3041d;
                stringBuilder.append(", FOREIGN KEY(`");
                stringBuilder.append(property22.f3038a);
                stringBuilder.append("`) REFERENCES ");
                stringBuilder.append(foreignKey.f3031a);
                stringBuilder.append("(`");
                stringBuilder.append(foreignKey.f3032b);
                stringBuilder.append("`) ON DELETE CASCADE");
            }
        }
        stringBuilder.append(" );");
        JqLog.m2558a(stringBuilder.toString(), new Object[0]);
        return stringBuilder.toString();
    }

    public static String m2582a(String str) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final SQLiteStatement m2585a() {
        if (this.f3063u == null) {
            int i = 0;
            this.f3055m.setLength(0);
            StringBuilder stringBuilder = this.f3055m;
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append(this.f3057o);
            this.f3055m.append(" VALUES (");
            while (i < this.f3059q) {
                if (i != 0) {
                    this.f3055m.append(",");
                }
                this.f3055m.append(Operation.EMPTY_PARAM);
                i++;
            }
            this.f3055m.append(")");
            this.f3063u = this.f3056n.compileStatement(this.f3055m.toString());
        }
        return this.f3063u;
    }

    public final String m2586a(String str, Integer num, Order... orderArr) {
        this.f3055m.setLength(0);
        this.f3055m.append("SELECT * FROM ");
        this.f3055m.append(this.f3057o);
        if (str != null) {
            StringBuilder stringBuilder = this.f3055m;
            stringBuilder.append(" WHERE ");
            stringBuilder.append(str);
        }
        int length = orderArr.length;
        int i = 1;
        str = null;
        while (str < length) {
            Order order = orderArr[str];
            if (i != 0) {
                this.f3055m.append(" ORDER BY ");
            } else {
                this.f3055m.append(",");
            }
            StringBuilder stringBuilder2 = this.f3055m;
            stringBuilder2.append(order.f3036a.f3038a);
            stringBuilder2.append(" ");
            stringBuilder2.append(order.f3037b);
            str++;
            i = 0;
        }
        if (num != null) {
            str = this.f3055m;
            str.append(" LIMIT ");
            str.append(num);
        }
        return this.f3055m.toString();
    }

    public final String m2587a(String str, String str2) {
        this.f3055m.setLength(0);
        StringBuilder stringBuilder = this.f3055m;
        stringBuilder.append("SELECT ");
        stringBuilder.append(str);
        stringBuilder.append(" FROM ");
        stringBuilder.append(this.f3057o);
        if (str2 != null) {
            str = this.f3055m;
            str.append(" WHERE ");
            str.append(str2);
        }
        return this.f3055m.toString();
    }

    static void m2584a(StringBuilder stringBuilder, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("cannot create placeholders for 0 items");
        }
        stringBuilder.append(Operation.EMPTY_PARAM);
        for (int i2 = 1; i2 < i; i2++) {
            stringBuilder.append(",?");
        }
    }
}
