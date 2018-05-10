package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.data.Blob;
import java.util.HashMap;
import java.util.Map;

public enum SQLiteType {
    INTEGER,
    REAL,
    TEXT,
    BLOB;
    
    private static final Map<String, SQLiteType> sTypeMap = null;

    static class C08731 extends HashMap<String, SQLiteType> {
        C08731() {
            put(Byte.TYPE.getName(), SQLiteType.INTEGER);
            put(Short.TYPE.getName(), SQLiteType.INTEGER);
            put(Integer.TYPE.getName(), SQLiteType.INTEGER);
            put(Long.TYPE.getName(), SQLiteType.INTEGER);
            put(Float.TYPE.getName(), SQLiteType.REAL);
            put(Double.TYPE.getName(), SQLiteType.REAL);
            put(Boolean.TYPE.getName(), SQLiteType.INTEGER);
            put(Character.TYPE.getName(), SQLiteType.TEXT);
            put(byte[].class.getName(), SQLiteType.BLOB);
            put(Byte.class.getName(), SQLiteType.INTEGER);
            put(Short.class.getName(), SQLiteType.INTEGER);
            put(Integer.class.getName(), SQLiteType.INTEGER);
            put(Long.class.getName(), SQLiteType.INTEGER);
            put(Float.class.getName(), SQLiteType.REAL);
            put(Double.class.getName(), SQLiteType.REAL);
            put(Boolean.class.getName(), SQLiteType.INTEGER);
            put(Character.class.getName(), SQLiteType.TEXT);
            put(CharSequence.class.getName(), SQLiteType.TEXT);
            put(String.class.getName(), SQLiteType.TEXT);
            put(Byte[].class.getName(), SQLiteType.BLOB);
            put(Blob.class.getName(), SQLiteType.BLOB);
        }
    }

    static {
        sTypeMap = new C08731();
    }

    public static SQLiteType get(String str) {
        return (SQLiteType) sTypeMap.get(str);
    }

    public static boolean containsClass(String str) {
        return sTypeMap.containsKey(str);
    }
}
