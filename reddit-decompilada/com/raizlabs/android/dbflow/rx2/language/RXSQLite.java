package com.raizlabs.android.dbflow.rx2.language;

import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;

public class RXSQLite {
    public static <T> RXModelQueriableImpl<T> rx(ModelQueriable<T> modelQueriable) {
        return new RXModelQueriableImpl(modelQueriable);
    }

    public static RXQueriableImpl rx(Class<?> cls, Queriable queriable) {
        return new RXQueriableImpl(cls, queriable);
    }
}
