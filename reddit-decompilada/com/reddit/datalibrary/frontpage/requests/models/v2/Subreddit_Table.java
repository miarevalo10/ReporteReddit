package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
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

public final class Subreddit_Table extends ModelAdapter<Subreddit> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{_id, username, user_is_subscriber, user_is_moderator, user_favorite};
    public static final Property<Long> _id = new Property(Subreddit.class, "_id");
    public static final IndexProperty<Subreddit> index_user_favorite = new IndexProperty("user_favorite", false, Subreddit.class, new IProperty[]{username, user_favorite});
    public static final IndexProperty<Subreddit> index_user_moderator = new IndexProperty("user_moderator", false, Subreddit.class, new IProperty[]{username, user_is_moderator});
    public static final IndexProperty<Subreddit> index_user_subscriber = new IndexProperty("user_subscriber", false, Subreddit.class, new IProperty[]{username, user_is_subscriber});
    public static final Property<Boolean> user_favorite = new Property(Subreddit.class, "user_favorite");
    public static final Property<Boolean> user_is_moderator = new Property(Subreddit.class, "user_is_moderator");
    public static final Property<Boolean> user_is_subscriber = new Property(Subreddit.class, "user_is_subscriber");
    public static final Property<String> username = new Property(Subreddit.class, "username");

    public final boolean cachingEnabled() {
        return true;
    }

    public final int getCacheSize() {
        return 100;
    }

    public final String getCompiledStatementQuery() {
        return "INSERT OR REPLACE INTO `subreddit`(`_id`,`username`,`user_is_subscriber`,`user_is_moderator`,`user_favorite`) VALUES (?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `subreddit`(`_id` INTEGER, `username` TEXT, `user_is_subscriber` INTEGER, `user_is_moderator` INTEGER, `user_favorite` INTEGER, PRIMARY KEY(`_id`, `username`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `subreddit` WHERE `_id`=? AND `username`=?";
    }

    public final String getTableName() {
        return "`subreddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE OR REPLACE `subreddit` SET `_id`=?,`username`=?,`user_is_subscriber`=?,`user_is_moderator`=?,`user_favorite`=? WHERE `_id`=? AND `username`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        databaseStatement.bindLong(1, subreddit._id);
        databaseStatement.bindStringOrNull(2, subreddit._username);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        Subreddit subreddit = (Subreddit) obj;
        databaseStatement.bindLong(1 + i, subreddit._id);
        databaseStatement.bindStringOrNull(2 + i, subreddit._username);
        long j = 0;
        databaseStatement.bindLong(3 + i, subreddit.user_is_subscriber ? 1 : 0);
        databaseStatement.bindLong(4 + i, subreddit.user_is_moderator ? 1 : 0);
        int i2 = 5 + i;
        if (subreddit.user_favorite != null) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        contentValues.put("`_id`", Long.valueOf(subreddit._id));
        contentValues.put("`username`", subreddit._username);
        contentValues.put("`user_is_subscriber`", Integer.valueOf(subreddit.user_is_subscriber));
        contentValues.put("`user_is_moderator`", Integer.valueOf(subreddit.user_is_moderator));
        contentValues.put("`user_favorite`", Integer.valueOf(subreddit.user_favorite));
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        databaseStatement.bindLong(1, subreddit._id);
        databaseStatement.bindStringOrNull(2, subreddit._username);
        long j = 0;
        databaseStatement.bindLong(3, subreddit.user_is_subscriber ? 1 : 0);
        databaseStatement.bindLong(4, subreddit.user_is_moderator ? 1 : 0);
        if (subreddit.user_favorite) {
            j = 1;
        }
        databaseStatement.bindLong(5, j);
        databaseStatement.bindLong(6, subreddit._id);
        databaseStatement.bindStringOrNull(7, subreddit._username);
    }

    public final /* synthetic */ boolean delete(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        getModelCache().removeModel(getCachingId(subreddit));
        return super.delete(subreddit);
    }

    public final /* synthetic */ boolean delete(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        getModelCache().removeModel(getCachingId(subreddit));
        return super.delete(subreddit, databaseWrapper);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(Subreddit.class).where(new SQLOperator[]{m36669a(subreddit)}).hasData(databaseWrapper);
    }

    public final /* synthetic */ Object[] getCachingColumnValuesFromModel(Object[] objArr, Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        objArr[0] = Long.valueOf(subreddit._id);
        objArr[1] = subreddit._username;
        return objArr;
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36669a((Subreddit) obj);
    }

    public final /* synthetic */ long insert(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        long insert = super.insert(subreddit);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return insert;
    }

    public final /* synthetic */ long insert(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        long insert = super.insert(subreddit, databaseWrapper);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return insert;
    }

    public final /* synthetic */ void load(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        super.load(subreddit, databaseWrapper);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        subreddit._id = flowCursor.getLongOrDefault("_id");
        subreddit._username = flowCursor.getStringOrDefault("username");
        int columnIndex = flowCursor.getColumnIndex("user_is_subscriber");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subreddit.user_is_subscriber = false;
        } else {
            subreddit.user_is_subscriber = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("user_is_moderator");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subreddit.user_is_moderator = false;
        } else {
            subreddit.user_is_moderator = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("user_favorite");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subreddit.user_favorite = false;
        } else {
            subreddit.user_favorite = flowCursor.getBoolean(columnIndex);
        }
    }

    public final /* synthetic */ boolean save(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        boolean save = super.save(subreddit);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return save;
    }

    public final /* synthetic */ boolean save(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        databaseWrapper = super.save(subreddit, databaseWrapper);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return databaseWrapper;
    }

    public final /* synthetic */ boolean update(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        boolean update = super.update(subreddit);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return update;
    }

    public final /* synthetic */ boolean update(Object obj, DatabaseWrapper databaseWrapper) {
        Subreddit subreddit = (Subreddit) obj;
        databaseWrapper = super.update(subreddit, databaseWrapper);
        getModelCache().addModel(getCachingId(subreddit), subreddit);
        return databaseWrapper;
    }

    public Subreddit_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<Subreddit> getModelClass() {
        return Subreddit.class;
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
            case -1653918729: goto L_0x0034;
            case -1522063568: goto L_0x002a;
            case -1332609558: goto L_0x0020;
            case 91592262: goto L_0x0016;
            case 397061404: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x003e;
    L_0x000c:
        r0 = "`user_is_moderator`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0014:
        r2 = 3;
        goto L_0x003f;
    L_0x0016:
        r0 = "`_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x001e:
        r2 = 0;
        goto L_0x003f;
    L_0x0020:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0028:
        r2 = 1;
        goto L_0x003f;
    L_0x002a:
        r0 = "`user_favorite`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0032:
        r2 = 4;
        goto L_0x003f;
    L_0x0034:
        r0 = "`user_is_subscriber`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x003c:
        r2 = 2;
        goto L_0x003f;
    L_0x003e:
        r2 = -1;
    L_0x003f:
        switch(r2) {
            case 0: goto L_0x0056;
            case 1: goto L_0x0053;
            case 2: goto L_0x0050;
            case 3: goto L_0x004d;
            case 4: goto L_0x004a;
            default: goto L_0x0042;
        };
    L_0x0042:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x004a:
        r2 = user_favorite;
        return r2;
    L_0x004d:
        r2 = user_is_moderator;
        return r2;
    L_0x0050:
        r2 = user_is_subscriber;
        return r2;
    L_0x0053:
        r2 = username;
        return r2;
    L_0x0056:
        r2 = _id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
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
        objArr[0] = Long.valueOf(flowCursor.getLong(flowCursor.getColumnIndex("_id")));
        objArr[1] = flowCursor.getString(flowCursor.getColumnIndex("username"));
        return objArr;
    }

    public final String[] createCachingColumns() {
        return new String[]{"`_id`", "`username`"};
    }

    public final IMultiKeyCacheConverter<?> getCacheConverter() {
        return Subreddit.MULTI_CACHE_KEY_MODEL;
    }

    private static OperatorGroup m36669a(Subreddit subreddit) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(_id.eq(Long.valueOf(subreddit._id)));
        clause.and(username.eq(subreddit._username));
        return clause;
    }

    protected final /* synthetic */ ListModelSaver createListModelSaver() {
        return new CacheableListModelSaver(getModelSaver());
    }

    public final /* synthetic */ Object newInstance() {
        return new Subreddit();
    }
}
