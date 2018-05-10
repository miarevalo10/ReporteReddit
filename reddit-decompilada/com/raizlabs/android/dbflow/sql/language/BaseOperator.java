package com.raizlabs.android.dbflow.sql.language;

import android.database.DatabaseUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public abstract class BaseOperator implements SQLOperator {
    protected boolean isValueSet;
    protected NameAlias nameAlias;
    protected String operation = "";
    protected String postArg;
    protected String separator;
    protected Object value;

    public static String convertValueToString(Object obj, boolean z) {
        return convertValueToString(obj, z, true);
    }

    public static String convertValueToString(Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return "NULL";
        }
        if (z2) {
            z2 = FlowManager.getTypeConverterForClass(obj.getClass());
            if (z2) {
                obj = z2.getDBValue(obj);
            }
        }
        if (obj instanceof Number) {
            obj = String.valueOf(obj);
        } else if (obj instanceof Enum) {
            obj = DatabaseUtils.sqlEscapeString(((Enum) obj).name());
        } else if (z && (obj instanceof BaseModelQueriable)) {
            obj = String.format("(%1s)", new Object[]{((BaseModelQueriable) obj).getQuery().trim()});
        } else if (obj instanceof NameAlias) {
            obj = ((NameAlias) obj).getQuery();
        } else if (obj instanceof SQLOperator) {
            z = new QueryBuilder();
            ((SQLOperator) obj).appendConditionToQuery(z);
            obj = z.toString();
        } else if (obj instanceof Query) {
            obj = ((Query) obj).getQuery();
        } else {
            z = obj instanceof Blob;
            if (!z) {
                if (!(obj instanceof byte[])) {
                    obj = String.valueOf(obj);
                    if (!obj.equals(Operation.EMPTY_PARAM)) {
                        obj = DatabaseUtils.sqlEscapeString(obj);
                    }
                }
            }
            if (z) {
                obj = ((Blob) obj).getBlob();
            } else {
                obj = (byte[]) obj;
            }
            z = new StringBuilder("X");
            z.append(DatabaseUtils.sqlEscapeString(SqlUtils.byteArrayToHexString(obj)));
            obj = z.toString();
        }
        return obj;
    }

    public static String joinArguments(CharSequence charSequence, Iterable iterable, BaseOperator baseOperator) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean z = true;
        for (Object next : iterable) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(baseOperator.convertObjectToString(next, false));
        }
        return stringBuilder.toString();
    }

    public static String joinArguments(CharSequence charSequence, Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean z = true;
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(convertValueToString(obj, false, true));
        }
        return stringBuilder.toString();
    }

    public static String joinArguments(CharSequence charSequence, Iterable iterable) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean z = true;
        for (Object next : iterable) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(convertValueToString(next, false, true));
        }
        return stringBuilder.toString();
    }

    BaseOperator(NameAlias nameAlias) {
        this.nameAlias = nameAlias;
    }

    public Object value() {
        return this.value;
    }

    public String columnName() {
        return this.nameAlias.getQuery();
    }

    public SQLOperator separator(String str) {
        this.separator = str;
        return this;
    }

    public String separator() {
        return this.separator;
    }

    public boolean hasSeparator() {
        return this.separator != null && this.separator.length() > 0;
    }

    public String operation() {
        return this.operation;
    }

    public String postArgument() {
        return this.postArg;
    }

    NameAlias columnAlias() {
        return this.nameAlias;
    }

    public String convertObjectToString(Object obj, boolean z) {
        return convertValueToString(obj, z);
    }
}
