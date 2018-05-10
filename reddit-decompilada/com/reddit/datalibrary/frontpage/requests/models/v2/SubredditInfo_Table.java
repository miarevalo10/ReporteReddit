package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleKeyCacheableListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleKeyCacheableModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.sql.saveable.CacheableListModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ListModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import net.hockeyapp.android.UpdateFragment;

public final class SubredditInfo_Table extends ModelAdapter<SubredditInfo> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{_id, id, name, display_name, display_name_prefixed, icon_img, key_color, url, description, description_html, subscribers, accounts_active, banner_img, wiki_enabled, is_default, over18, whitelist_status, subreddit_type};
    public static final Property<Long> _id = new Property(SubredditInfo.class, "_id");
    public static final Property<Long> accounts_active = new Property(SubredditInfo.class, "accounts_active");
    public static final Property<String> banner_img = new Property(SubredditInfo.class, "banner_img");
    public static final Property<String> description = new Property(SubredditInfo.class, "description");
    public static final Property<String> description_html = new Property(SubredditInfo.class, "description_html");
    public static final Property<String> display_name = new Property(SubredditInfo.class, "display_name");
    public static final Property<String> display_name_prefixed = new Property(SubredditInfo.class, "display_name_prefixed");
    public static final Property<String> icon_img = new Property(SubredditInfo.class, "icon_img");
    public static final Property<String> id = new Property(SubredditInfo.class, "id");
    public static final Property<Boolean> is_default = new Property(SubredditInfo.class, "is_default");
    public static final Property<String> key_color = new Property(SubredditInfo.class, "key_color");
    public static final Property<String> name = new Property(SubredditInfo.class, "name");
    public static final Property<Boolean> over18 = new Property(SubredditInfo.class, "over18");
    public static final Property<String> subreddit_type = new Property(SubredditInfo.class, "subreddit_type");
    public static final Property<Long> subscribers = new Property(SubredditInfo.class, "subscribers");
    public static final Property<String> url = new Property(SubredditInfo.class, UpdateFragment.FRAGMENT_URL);
    public static final Property<String> whitelist_status = new Property(SubredditInfo.class, "whitelist_status");
    public static final Property<Boolean> wiki_enabled = new Property(SubredditInfo.class, "wiki_enabled");

    public final boolean cachingEnabled() {
        return true;
    }

    public final int getCacheSize() {
        return 100;
    }

    public final String getCompiledStatementQuery() {
        return "INSERT OR REPLACE INTO `subreddit_info`(`_id`,`id`,`name`,`display_name`,`display_name_prefixed`,`icon_img`,`key_color`,`url`,`description`,`description_html`,`subscribers`,`accounts_active`,`banner_img`,`wiki_enabled`,`is_default`,`over18`,`whitelist_status`,`subreddit_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `subreddit_info`(`_id` INTEGER, `id` TEXT, `name` TEXT, `display_name` TEXT, `display_name_prefixed` TEXT, `icon_img` TEXT, `key_color` TEXT, `url` TEXT, `description` TEXT, `description_html` TEXT, `subscribers` INTEGER, `accounts_active` INTEGER, `banner_img` TEXT, `wiki_enabled` INTEGER, `is_default` INTEGER, `over18` INTEGER, `whitelist_status` TEXT, `subreddit_type` TEXT, PRIMARY KEY(`_id`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `subreddit_info` WHERE `_id`=?";
    }

    public final String getTableName() {
        return "`subreddit_info`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE OR REPLACE `subreddit_info` SET `_id`=?,`id`=?,`name`=?,`display_name`=?,`display_name_prefixed`=?,`icon_img`=?,`key_color`=?,`url`=?,`description`=?,`description_html`=?,`subscribers`=?,`accounts_active`=?,`banner_img`=?,`wiki_enabled`=?,`is_default`=?,`over18`=?,`whitelist_status`=?,`subreddit_type`=? WHERE `_id`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindLong(1, ((SubredditInfo) obj)._id);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        databaseStatement.bindLong(1 + i, subredditInfo._id);
        databaseStatement.bindStringOrNull(2 + i, subredditInfo.id);
        databaseStatement.bindStringOrNull(3 + i, subredditInfo.name);
        databaseStatement.bindStringOrNull(4 + i, subredditInfo.display_name);
        databaseStatement.bindStringOrNull(5 + i, subredditInfo.display_name_prefixed);
        databaseStatement.bindStringOrNull(6 + i, subredditInfo.icon_img);
        databaseStatement.bindStringOrNull(7 + i, subredditInfo.key_color);
        databaseStatement.bindStringOrNull(8 + i, subredditInfo.url);
        databaseStatement.bindStringOrNull(9 + i, subredditInfo.description);
        databaseStatement.bindStringOrNull(10 + i, subredditInfo.description_html);
        databaseStatement.bindLong(11 + i, subredditInfo.subscribers);
        databaseStatement.bindLong(12 + i, subredditInfo.accounts_active);
        databaseStatement.bindStringOrNull(13 + i, subredditInfo.banner_img);
        long j = 0;
        databaseStatement.bindLong(14 + i, subredditInfo.wiki_enabled ? 1 : 0);
        databaseStatement.bindLong(15 + i, subredditInfo.is_default ? 1 : 0);
        int i2 = 16 + i;
        if (subredditInfo.over18) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
        databaseStatement.bindStringOrNull(17 + i, subredditInfo.whitelist_status);
        databaseStatement.bindStringOrNull(18 + i, subredditInfo.subreddit_type);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        contentValues.put("`_id`", Long.valueOf(subredditInfo._id));
        contentValues.put("`id`", subredditInfo.id);
        contentValues.put("`name`", subredditInfo.name);
        contentValues.put("`display_name`", subredditInfo.display_name);
        contentValues.put("`display_name_prefixed`", subredditInfo.display_name_prefixed);
        contentValues.put("`icon_img`", subredditInfo.icon_img);
        contentValues.put("`key_color`", subredditInfo.key_color);
        contentValues.put("`url`", subredditInfo.url);
        contentValues.put("`description`", subredditInfo.description);
        contentValues.put("`description_html`", subredditInfo.description_html);
        contentValues.put("`subscribers`", Long.valueOf(subredditInfo.subscribers));
        contentValues.put("`accounts_active`", Long.valueOf(subredditInfo.accounts_active));
        contentValues.put("`banner_img`", subredditInfo.banner_img);
        contentValues.put("`wiki_enabled`", Integer.valueOf(subredditInfo.wiki_enabled));
        contentValues.put("`is_default`", Integer.valueOf(subredditInfo.is_default));
        contentValues.put("`over18`", Integer.valueOf(subredditInfo.over18));
        contentValues.put("`whitelist_status`", subredditInfo.whitelist_status);
        contentValues.put("`subreddit_type`", subredditInfo.subreddit_type);
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        databaseStatement.bindLong(1, subredditInfo._id);
        databaseStatement.bindStringOrNull(2, subredditInfo.id);
        databaseStatement.bindStringOrNull(3, subredditInfo.name);
        databaseStatement.bindStringOrNull(4, subredditInfo.display_name);
        databaseStatement.bindStringOrNull(5, subredditInfo.display_name_prefixed);
        databaseStatement.bindStringOrNull(6, subredditInfo.icon_img);
        databaseStatement.bindStringOrNull(7, subredditInfo.key_color);
        databaseStatement.bindStringOrNull(8, subredditInfo.url);
        databaseStatement.bindStringOrNull(9, subredditInfo.description);
        databaseStatement.bindStringOrNull(10, subredditInfo.description_html);
        databaseStatement.bindLong(11, subredditInfo.subscribers);
        databaseStatement.bindLong(12, subredditInfo.accounts_active);
        databaseStatement.bindStringOrNull(13, subredditInfo.banner_img);
        long j = 0;
        databaseStatement.bindLong(14, subredditInfo.wiki_enabled ? 1 : 0);
        databaseStatement.bindLong(15, subredditInfo.is_default ? 1 : 0);
        if (subredditInfo.over18) {
            j = 1;
        }
        databaseStatement.bindLong(16, j);
        databaseStatement.bindStringOrNull(17, subredditInfo.whitelist_status);
        databaseStatement.bindStringOrNull(18, subredditInfo.subreddit_type);
        databaseStatement.bindLong(19, subredditInfo._id);
    }

    public final /* synthetic */ boolean delete(Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        getModelCache().removeModel(Long.valueOf(subredditInfo._id));
        return super.delete(subredditInfo);
    }

    public final /* synthetic */ boolean delete(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        getModelCache().removeModel(Long.valueOf(subredditInfo._id));
        return super.delete(subredditInfo, databaseWrapper);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(SubredditInfo.class).where(new SQLOperator[]{m36668a(subredditInfo)}).hasData(databaseWrapper);
    }

    public final /* synthetic */ Object getCachingColumnValueFromModel(Object obj) {
        return Long.valueOf(((SubredditInfo) obj)._id);
    }

    public final /* synthetic */ Object getCachingId(Object obj) {
        return Long.valueOf(((SubredditInfo) obj)._id);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36668a((SubredditInfo) obj);
    }

    public final /* synthetic */ long insert(Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        long insert = super.insert(subredditInfo);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return insert;
    }

    public final /* synthetic */ long insert(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        long insert = super.insert(subredditInfo, databaseWrapper);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return insert;
    }

    public final /* synthetic */ void load(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        super.load(subredditInfo, databaseWrapper);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        subredditInfo._id = flowCursor.getLongOrDefault("_id");
        subredditInfo.id = flowCursor.getStringOrDefault("id");
        subredditInfo.name = flowCursor.getStringOrDefault("name");
        subredditInfo.display_name = flowCursor.getStringOrDefault("display_name");
        subredditInfo.display_name_prefixed = flowCursor.getStringOrDefault("display_name_prefixed");
        subredditInfo.icon_img = flowCursor.getStringOrDefault("icon_img");
        subredditInfo.key_color = flowCursor.getStringOrDefault("key_color");
        subredditInfo.url = flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL);
        subredditInfo.description = flowCursor.getStringOrDefault("description");
        subredditInfo.description_html = flowCursor.getStringOrDefault("description_html");
        subredditInfo.subscribers = flowCursor.getLongOrDefault("subscribers");
        subredditInfo.accounts_active = flowCursor.getLongOrDefault("accounts_active");
        subredditInfo.banner_img = flowCursor.getStringOrDefault("banner_img");
        int columnIndex = flowCursor.getColumnIndex("wiki_enabled");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditInfo.wiki_enabled = false;
        } else {
            subredditInfo.wiki_enabled = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("is_default");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditInfo.is_default = false;
        } else {
            subredditInfo.is_default = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("over18");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditInfo.over18 = false;
        } else {
            subredditInfo.over18 = flowCursor.getBoolean(columnIndex);
        }
        subredditInfo.whitelist_status = flowCursor.getStringOrDefault("whitelist_status");
        subredditInfo.subreddit_type = flowCursor.getStringOrDefault("subreddit_type");
    }

    public final /* synthetic */ boolean save(Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        boolean save = super.save(subredditInfo);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return save;
    }

    public final /* synthetic */ boolean save(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        databaseWrapper = super.save(subredditInfo, databaseWrapper);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return databaseWrapper;
    }

    public final /* synthetic */ boolean update(Object obj) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        boolean update = super.update(subredditInfo);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return update;
    }

    public final /* synthetic */ boolean update(Object obj, DatabaseWrapper databaseWrapper) {
        SubredditInfo subredditInfo = (SubredditInfo) obj;
        databaseWrapper = super.update(subredditInfo, databaseWrapper);
        getModelCache().addModel(Long.valueOf(subredditInfo._id), subredditInfo);
        return databaseWrapper;
    }

    public SubredditInfo_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<SubredditInfo> getModelClass() {
        return SubredditInfo.class;
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
            case -2069049067: goto L_0x00c8;
            case -1897029490: goto L_0x00bd;
            case -1441983787: goto L_0x00b3;
            case -1285278363: goto L_0x00a8;
            case -767367016: goto L_0x009e;
            case -644740195: goto L_0x0094;
            case -583710380: goto L_0x0089;
            case -23237564: goto L_0x007e;
            case 2964037: goto L_0x0074;
            case 91592262: goto L_0x006a;
            case 92256561: goto L_0x005f;
            case 1005667621: goto L_0x0053;
            case 1218784419: goto L_0x0048;
            case 1295105825: goto L_0x003c;
            case 1534055704: goto L_0x0031;
            case 1596634034: goto L_0x0025;
            case 1894857168: goto L_0x0019;
            case 2119674454: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x00d3;
    L_0x000d:
        r0 = "`whitelist_status`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0015:
        r2 = 16;
        goto L_0x00d4;
    L_0x0019:
        r0 = "`banner_img`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0021:
        r2 = 12;
        goto L_0x00d4;
    L_0x0025:
        r0 = "`description_html`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x002d:
        r2 = 9;
        goto L_0x00d4;
    L_0x0031:
        r0 = "`display_name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0039:
        r2 = 3;
        goto L_0x00d4;
    L_0x003c:
        r0 = "`accounts_active`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0044:
        r2 = 11;
        goto L_0x00d4;
    L_0x0048:
        r0 = "`icon_img`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0050:
        r2 = 5;
        goto L_0x00d4;
    L_0x0053:
        r0 = "`subreddit_type`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x005b:
        r2 = 17;
        goto L_0x00d4;
    L_0x005f:
        r0 = "`url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0067:
        r2 = 7;
        goto L_0x00d4;
    L_0x006a:
        r0 = "`_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0072:
        r2 = 0;
        goto L_0x00d4;
    L_0x0074:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x007c:
        r2 = 1;
        goto L_0x00d4;
    L_0x007e:
        r0 = "`description`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0086:
        r2 = 8;
        goto L_0x00d4;
    L_0x0089:
        r0 = "`is_default`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x0091:
        r2 = 14;
        goto L_0x00d4;
    L_0x0094:
        r0 = "`key_color`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x009c:
        r2 = 6;
        goto L_0x00d4;
    L_0x009e:
        r0 = "`display_name_prefixed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x00a6:
        r2 = 4;
        goto L_0x00d4;
    L_0x00a8:
        r0 = "`over18`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x00b0:
        r2 = 15;
        goto L_0x00d4;
    L_0x00b3:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x00bb:
        r2 = 2;
        goto L_0x00d4;
    L_0x00bd:
        r0 = "`wiki_enabled`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x00c5:
        r2 = 13;
        goto L_0x00d4;
    L_0x00c8:
        r0 = "`subscribers`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00d3;
    L_0x00d0:
        r2 = 10;
        goto L_0x00d4;
    L_0x00d3:
        r2 = -1;
    L_0x00d4:
        switch(r2) {
            case 0: goto L_0x0112;
            case 1: goto L_0x010f;
            case 2: goto L_0x010c;
            case 3: goto L_0x0109;
            case 4: goto L_0x0106;
            case 5: goto L_0x0103;
            case 6: goto L_0x0100;
            case 7: goto L_0x00fd;
            case 8: goto L_0x00fa;
            case 9: goto L_0x00f7;
            case 10: goto L_0x00f4;
            case 11: goto L_0x00f1;
            case 12: goto L_0x00ee;
            case 13: goto L_0x00eb;
            case 14: goto L_0x00e8;
            case 15: goto L_0x00e5;
            case 16: goto L_0x00e2;
            case 17: goto L_0x00df;
            default: goto L_0x00d7;
        };
    L_0x00d7:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x00df:
        r2 = subreddit_type;
        return r2;
    L_0x00e2:
        r2 = whitelist_status;
        return r2;
    L_0x00e5:
        r2 = over18;
        return r2;
    L_0x00e8:
        r2 = is_default;
        return r2;
    L_0x00eb:
        r2 = wiki_enabled;
        return r2;
    L_0x00ee:
        r2 = banner_img;
        return r2;
    L_0x00f1:
        r2 = accounts_active;
        return r2;
    L_0x00f4:
        r2 = subscribers;
        return r2;
    L_0x00f7:
        r2 = description_html;
        return r2;
    L_0x00fa:
        r2 = description;
        return r2;
    L_0x00fd:
        r2 = url;
        return r2;
    L_0x0100:
        r2 = key_color;
        return r2;
    L_0x0103:
        r2 = icon_img;
        return r2;
    L_0x0106:
        r2 = display_name_prefixed;
        return r2;
    L_0x0109:
        r2 = display_name;
        return r2;
    L_0x010c:
        r2 = name;
        return r2;
    L_0x010f:
        r2 = id;
        return r2;
    L_0x0112:
        r2 = _id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final SingleModelLoader createSingleModelLoader() {
        return new SingleKeyCacheableModelLoader(getModelClass());
    }

    public final ListModelLoader createListModelLoader() {
        return new SingleKeyCacheableListModelLoader(getModelClass());
    }

    public final Object getCachingColumnValueFromCursor(FlowCursor flowCursor) {
        return Long.valueOf(flowCursor.getLong(flowCursor.getColumnIndex("_id")));
    }

    public final String[] createCachingColumns() {
        return new String[]{"`_id`"};
    }

    private static OperatorGroup m36668a(SubredditInfo subredditInfo) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(_id.eq(Long.valueOf(subredditInfo._id)));
        return clause;
    }

    protected final /* synthetic */ ListModelSaver createListModelSaver() {
        return new CacheableListModelSaver(getModelSaver());
    }

    public final /* synthetic */ Object newInstance() {
        return new SubredditInfo();
    }
}
