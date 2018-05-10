package com.raizlabs.android.dbflow.sql;

import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Map.Entry;

public class SqlUtils {
    public static final String TABLE_QUERY_PARAM = "tableName";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    @Deprecated
    public static void notifyModelChanged(String str, Class<?> cls, Action action, Iterable<SQLOperator> iterable) {
        FlowManager.getContext().getContentResolver().notifyChange(getNotificationUri(str, (Class) cls, action, (Iterable) iterable), null, true);
    }

    @Deprecated
    public static <TModel> void notifyModelChanged(TModel tModel, ModelAdapter<TModel> modelAdapter, Action action) {
        NotifyDistributor.get().notifyModelChanged(tModel, modelAdapter, action);
    }

    @Deprecated
    public static <TModel> void notifyTableChanged(Class<TModel> cls, Action action) {
        NotifyDistributor.get().notifyTableChanged(cls, action);
    }

    public static Uri getNotificationUri(String str, Class<?> cls, Action action, Iterable<SQLOperator> iterable) {
        str = new Builder().scheme("dbflow").authority(str).appendQueryParameter(TABLE_QUERY_PARAM, FlowManager.getTableName(cls));
        if (action != null) {
            str.fragment(action.name());
        }
        if (iterable != null) {
            for (SQLOperator sQLOperator : iterable) {
                str.appendQueryParameter(Uri.encode(sQLOperator.columnName()), Uri.encode(String.valueOf(sQLOperator.value())));
            }
        }
        return str.build();
    }

    public static Uri getNotificationUri(String str, Class<?> cls, Action action, SQLOperator[] sQLOperatorArr) {
        str = new Builder().scheme("dbflow").authority(str).appendQueryParameter(TABLE_QUERY_PARAM, FlowManager.getTableName(cls));
        if (action != null) {
            str.fragment(action.name());
        }
        if (sQLOperatorArr != null && sQLOperatorArr.length > null) {
            for (SQLOperator sQLOperator : sQLOperatorArr) {
                if (sQLOperator != null) {
                    str.appendQueryParameter(Uri.encode(sQLOperator.columnName()), Uri.encode(String.valueOf(sQLOperator.value())));
                }
            }
        }
        return str.build();
    }

    public static Uri getNotificationUri(String str, Class<?> cls, Action action, String str2, Object obj) {
        str2 = StringUtils.isNotNullOrEmpty(str2) ? Operator.op(new NameAlias.Builder(str2).build()).value(obj) : null;
        return getNotificationUri(str, (Class) cls, action, new SQLOperator[]{str2});
    }

    public static Uri getNotificationUri(String str, Class<?> cls, Action action) {
        return getNotificationUri(str, cls, action, "", null);
    }

    public static void dropTrigger(Class<?> cls, String str) {
        FlowManager.getDatabaseForTable(cls).getWritableDatabase().execSQL(new QueryBuilder("DROP TRIGGER IF EXISTS ").append(str).getQuery());
    }

    public static void dropTrigger(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper.execSQL(new QueryBuilder("DROP TRIGGER IF EXISTS ").append(str).getQuery());
    }

    public static void dropIndex(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper.execSQL(new QueryBuilder("DROP INDEX IF EXISTS ").append(QueryBuilder.quoteIfNeeded(str)).getQuery());
    }

    public static void dropIndex(Class<?> cls, String str) {
        dropIndex(FlowManager.getDatabaseForTable(cls).getWritableDatabase(), str);
    }

    public static void addContentValues(ContentValues contentValues, OperatorGroup operatorGroup) {
        for (Entry key : contentValues.valueSet()) {
            String str = (String) key.getKey();
            operatorGroup.and(Operator.op(new NameAlias.Builder(str).build()).is(contentValues.get(str)));
        }
    }

    public static String getContentValuesKey(ContentValues contentValues, String str) {
        String quoteIfNeeded = QueryBuilder.quoteIfNeeded(str);
        if (contentValues.containsKey(quoteIfNeeded)) {
            return quoteIfNeeded;
        }
        str = QueryBuilder.stripQuotes(str);
        if (contentValues.containsKey(str) != null) {
            return str;
        }
        throw new IllegalArgumentException("Could not find the specified key in the Content Values object.");
    }

    public static long longForQuery(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper = databaseWrapper.compileStatement(str);
        try {
            long simpleQueryForLong = databaseWrapper.simpleQueryForLong();
            return simpleQueryForLong;
        } finally {
            databaseWrapper.close();
        }
    }

    public static double doubleForQuery(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper = databaseWrapper.compileStatement(str);
        try {
            double simpleQueryForLong = databaseWrapper.simpleQueryForLong();
            simpleQueryForLong = (double) simpleQueryForLong;
            return simpleQueryForLong;
        } finally {
            databaseWrapper.close();
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = hexArray[i2 >>> 4];
            cArr[i3 + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }
}
