package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.queriable.CacheableListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.CacheableModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.sql.saveable.CacheableListModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ListModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.IMultiKeyCacheConverter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class Multireddit_Table extends ModelAdapter<Multireddit> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{username, name, can_edit, path, icon_url, key_color};
    public static final Property<Boolean> can_edit = new Property(Multireddit.class, "can_edit");
    public static final Property<String> icon_url = new Property(Multireddit.class, "icon_url");
    public static final Property<String> key_color = new Property(Multireddit.class, "key_color");
    public static final Property<String> name = new Property(Multireddit.class, "name");
    public static final Property<String> path = new Property(Multireddit.class, "path");
    public static final Property<String> username = new Property(Multireddit.class, "username");

    public final boolean cachingEnabled() {
        return true;
    }

    public final int getCacheSize() {
        return 100;
    }

    public final String getCompiledStatementQuery() {
        return "INSERT OR REPLACE INTO `multireddit`(`username`,`name`,`can_edit`,`path`,`icon_url`,`key_color`) VALUES (?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `multireddit`(`username` TEXT, `name` TEXT, `can_edit` INTEGER, `path` TEXT, `icon_url` TEXT, `key_color` TEXT, PRIMARY KEY(`username`, `name`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `multireddit` WHERE `username`=? AND `name`=?";
    }

    public final String getTableName() {
        return "`multireddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE OR REPLACE `multireddit` SET `username`=?,`name`=?,`can_edit`=?,`path`=?,`icon_url`=?,`key_color`=? WHERE `username`=? AND `name`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        databaseStatement.bindStringOrNull(1, multireddit._username);
        databaseStatement.bindStringOrNull(2, multireddit.name);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        Multireddit multireddit = (Multireddit) obj;
        databaseStatement.bindStringOrNull(1 + i, multireddit._username);
        databaseStatement.bindStringOrNull(2 + i, multireddit.name);
        databaseStatement.bindLong(3 + i, multireddit.can_edit ? 1 : 0);
        databaseStatement.bindStringOrNull(4 + i, multireddit.path);
        databaseStatement.bindStringOrNull(5 + i, multireddit.icon_url);
        databaseStatement.bindStringOrNull(6 + i, multireddit.key_color);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        contentValues.put("`username`", multireddit._username);
        contentValues.put("`name`", multireddit.name);
        contentValues.put("`can_edit`", Integer.valueOf(multireddit.can_edit));
        contentValues.put("`path`", multireddit.path);
        contentValues.put("`icon_url`", multireddit.icon_url);
        contentValues.put("`key_color`", multireddit.key_color);
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        databaseStatement.bindStringOrNull(1, multireddit._username);
        databaseStatement.bindStringOrNull(2, multireddit.name);
        databaseStatement.bindLong(3, multireddit.can_edit ? 1 : 0);
        databaseStatement.bindStringOrNull(4, multireddit.path);
        databaseStatement.bindStringOrNull(5, multireddit.icon_url);
        databaseStatement.bindStringOrNull(6, multireddit.key_color);
        databaseStatement.bindStringOrNull(7, multireddit._username);
        databaseStatement.bindStringOrNull(8, multireddit.name);
    }

    public final /* synthetic */ boolean delete(Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        getModelCache().removeModel(getCachingId(multireddit));
        return super.delete(multireddit);
    }

    public final /* synthetic */ boolean delete(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        getModelCache().removeModel(getCachingId(multireddit));
        return super.delete(multireddit, databaseWrapper);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(Multireddit.class).where(new SQLOperator[]{m36660a(multireddit)}).hasData(databaseWrapper);
    }

    public final /* bridge */ /* synthetic */ Object[] getCachingColumnValuesFromModel(Object[] objArr, Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        objArr[0] = multireddit._username;
        objArr[1] = multireddit.name;
        return objArr;
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36660a((Multireddit) obj);
    }

    public final /* synthetic */ long insert(Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        long insert = super.insert(multireddit);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return insert;
    }

    public final /* synthetic */ long insert(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        long insert = super.insert(multireddit, databaseWrapper);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return insert;
    }

    public final /* synthetic */ void load(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        super.load(multireddit, databaseWrapper);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        multireddit._username = flowCursor.getStringOrDefault("username");
        multireddit.name = flowCursor.getStringOrDefault("name");
        int columnIndex = flowCursor.getColumnIndex("can_edit");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            multireddit.can_edit = false;
        } else {
            multireddit.can_edit = flowCursor.getBoolean(columnIndex);
        }
        multireddit.path = flowCursor.getStringOrDefault("path");
        multireddit.icon_url = flowCursor.getStringOrDefault("icon_url");
        multireddit.key_color = flowCursor.getStringOrDefault("key_color");
    }

    public final /* synthetic */ boolean save(Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        boolean save = super.save(multireddit);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return save;
    }

    public final /* synthetic */ boolean save(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        databaseWrapper = super.save(multireddit, databaseWrapper);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return databaseWrapper;
    }

    public final /* synthetic */ boolean update(Object obj) {
        Multireddit multireddit = (Multireddit) obj;
        boolean update = super.update(multireddit);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return update;
    }

    public final /* synthetic */ boolean update(Object obj, DatabaseWrapper databaseWrapper) {
        Multireddit multireddit = (Multireddit) obj;
        databaseWrapper = super.update(multireddit, databaseWrapper);
        getModelCache().addModel(getCachingId(multireddit), multireddit);
        return databaseWrapper;
    }

    public Multireddit_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<Multireddit> getModelClass() {
        return Multireddit.class;
    }

    public final ConflictAction getUpdateOnConflictAction() {
        return ConflictAction.REPLACE;
    }

    public final ConflictAction getInsertOnConflictAction() {
        return ConflictAction.REPLACE;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -1441983787: goto L_0x003e;
            case -1440129925: goto L_0x0034;
            case -1332609558: goto L_0x002a;
            case -1323596281: goto L_0x0020;
            case -644740195: goto L_0x0016;
            case 1219146871: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0048;
    L_0x000c:
        r0 = "`icon_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0014:
        r2 = 4;
        goto L_0x0049;
    L_0x0016:
        r0 = "`key_color`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x001e:
        r2 = 5;
        goto L_0x0049;
    L_0x0020:
        r0 = "`can_edit`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0028:
        r2 = 2;
        goto L_0x0049;
    L_0x002a:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0032:
        r2 = 0;
        goto L_0x0049;
    L_0x0034:
        r0 = "`path`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x003c:
        r2 = 3;
        goto L_0x0049;
    L_0x003e:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0046:
        r2 = 1;
        goto L_0x0049;
    L_0x0048:
        r2 = -1;
    L_0x0049:
        switch(r2) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0060;
            case 2: goto L_0x005d;
            case 3: goto L_0x005a;
            case 4: goto L_0x0057;
            case 5: goto L_0x0054;
            default: goto L_0x004c;
        };
    L_0x004c:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x0054:
        r2 = key_color;
        return r2;
    L_0x0057:
        r2 = icon_url;
        return r2;
    L_0x005a:
        r2 = path;
        return r2;
    L_0x005d:
        r2 = can_edit;
        return r2;
    L_0x0060:
        r2 = name;
        return r2;
    L_0x0063:
        r2 = username;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final SingleModelLoader createSingleModelLoader() {
        return new CacheableModelLoader(getModelClass());
    }

    public final ListModelLoader createListModelLoader() {
        return new CacheableListModelLoader(getModelClass());
    }

    public final Object[] getCachingColumnValuesFromCursor(Object[] objArr, FlowCursor flowCursor) {
        objArr[0] = flowCursor.getString(flowCursor.getColumnIndex("username"));
        objArr[1] = flowCursor.getString(flowCursor.getColumnIndex("name"));
        return objArr;
    }

    public final String[] createCachingColumns() {
        return new String[]{"`username`", "`name`"};
    }

    public final IMultiKeyCacheConverter<?> getCacheConverter() {
        return Multireddit.MULTI_CACHE_KEY_MODEL;
    }

    private static OperatorGroup m36660a(Multireddit multireddit) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(username.eq(multireddit._username));
        clause.and(name.eq(multireddit.name));
        return clause;
    }

    protected final /* synthetic */ ListModelSaver createListModelSaver() {
        return new CacheableListModelSaver(getModelSaver());
    }

    public final /* synthetic */ Object newInstance() {
        return new Multireddit();
    }
}
