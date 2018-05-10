package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class RecentSubreddit_Table extends ModelAdapter<RecentSubreddit> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, username, subredditName, subredditId, icon, headerImg, keyColor, visitTime};
    public static final Property<String> headerImg = new Property(RecentSubreddit.class, "headerImg");
    public static final Property<String> icon = new Property(RecentSubreddit.class, "icon");
    public static final Property<Long> id = new Property(RecentSubreddit.class, "id");
    public static final Property<String> keyColor = new Property(RecentSubreddit.class, "keyColor");
    public static final Property<String> subredditId = new Property(RecentSubreddit.class, "subredditId");
    public static final Property<String> subredditName = new Property(RecentSubreddit.class, "subredditName");
    public static final Property<String> username = new Property(RecentSubreddit.class, "username");
    public static final Property<Long> visitTime = new Property(RecentSubreddit.class, "visitTime");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `recent_subreddit`(`id`,`username`,`subredditName`,`subredditId`,`icon`,`headerImg`,`keyColor`,`visitTime`) VALUES (?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `recent_subreddit`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT, `subredditName` TEXT, `subredditId` TEXT, `icon` TEXT, `headerImg` TEXT, `keyColor` TEXT, `visitTime` INTEGER, UNIQUE(`username`,`subredditName`) ON CONFLICT REPLACE)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `recent_subreddit` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `recent_subreddit`(`username`,`subredditName`,`subredditId`,`icon`,`headerImg`,`keyColor`,`visitTime`) VALUES (?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`recent_subreddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `recent_subreddit` SET `id`=?,`username`=?,`subredditName`=?,`subredditId`=?,`icon`=?,`headerImg`=?,`keyColor`=?,`visitTime`=? WHERE `id`=?";
    }

    public final /* synthetic */ void bindToContentValues(ContentValues contentValues, Object obj) {
        RecentSubreddit recentSubreddit = (RecentSubreddit) obj;
        contentValues.put("`id`", Long.valueOf(recentSubreddit.id));
        m36666a(contentValues, recentSubreddit);
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindLong(1, ((RecentSubreddit) obj).id);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        m36667a(databaseStatement, (RecentSubreddit) obj, i);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        m36666a(contentValues, (RecentSubreddit) obj);
    }

    public final /* synthetic */ void bindToStatement(DatabaseStatement databaseStatement, Object obj) {
        RecentSubreddit recentSubreddit = (RecentSubreddit) obj;
        databaseStatement.bindLong(1, recentSubreddit.id);
        m36667a(databaseStatement, recentSubreddit, 1);
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        RecentSubreddit recentSubreddit = (RecentSubreddit) obj;
        databaseStatement.bindLong(1, recentSubreddit.id);
        if (recentSubreddit.username != null) {
            databaseStatement.bindString(2, recentSubreddit.username);
        } else {
            databaseStatement.bindString(2, "");
        }
        if (recentSubreddit.subredditName != null) {
            databaseStatement.bindString(3, recentSubreddit.subredditName);
        } else {
            databaseStatement.bindString(3, "");
        }
        if (recentSubreddit.subredditId != null) {
            databaseStatement.bindString(4, recentSubreddit.subredditId);
        } else {
            databaseStatement.bindString(4, "");
        }
        databaseStatement.bindStringOrNull(5, recentSubreddit.icon);
        databaseStatement.bindStringOrNull(6, recentSubreddit.headerImg);
        databaseStatement.bindStringOrNull(7, recentSubreddit.keyColor);
        databaseStatement.bindNumberOrNull(8, recentSubreddit.visitTime);
        databaseStatement.bindLong(9, recentSubreddit.id);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        if (((RecentSubreddit) obj).id > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(RecentSubreddit.class).where(new SQLOperator[]{m36665a(r5)}).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Number getAutoIncrementingId(Object obj) {
        return Long.valueOf(((RecentSubreddit) obj).id);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36665a((RecentSubreddit) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        RecentSubreddit recentSubreddit = (RecentSubreddit) obj;
        recentSubreddit.id = flowCursor.getLongOrDefault("id");
        recentSubreddit.m36662a(flowCursor.getStringOrDefault("username", ""));
        recentSubreddit.m36663b(flowCursor.getStringOrDefault("subredditName", ""));
        recentSubreddit.m36664c(flowCursor.getStringOrDefault("subredditId", ""));
        recentSubreddit.icon = flowCursor.getStringOrDefault("icon");
        recentSubreddit.headerImg = flowCursor.getStringOrDefault("headerImg");
        recentSubreddit.keyColor = flowCursor.getStringOrDefault("keyColor");
        recentSubreddit.visitTime = flowCursor.getLongOrDefault("visitTime", null);
    }

    public final /* synthetic */ void updateAutoIncrement(Object obj, Number number) {
        ((RecentSubreddit) obj).id = number.longValue();
    }

    public RecentSubreddit_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<RecentSubreddit> getModelClass() {
        return RecentSubreddit.class;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -1446539609: goto L_0x0052;
            case -1332609558: goto L_0x0048;
            case -953668201: goto L_0x003e;
            case -747364985: goto L_0x0034;
            case 2964037: goto L_0x002a;
            case 158412860: goto L_0x0020;
            case 1268560266: goto L_0x0016;
            case 1728538888: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x005c;
    L_0x000c:
        r0 = "`visitTime`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0014:
        r2 = 7;
        goto L_0x005d;
    L_0x0016:
        r0 = "`headerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x001e:
        r2 = 5;
        goto L_0x005d;
    L_0x0020:
        r0 = "`keyColor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0028:
        r2 = 6;
        goto L_0x005d;
    L_0x002a:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0032:
        r2 = 0;
        goto L_0x005d;
    L_0x0034:
        r0 = "`subredditId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x003c:
        r2 = 3;
        goto L_0x005d;
    L_0x003e:
        r0 = "`subredditName`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0046:
        r2 = 2;
        goto L_0x005d;
    L_0x0048:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0050:
        r2 = 1;
        goto L_0x005d;
    L_0x0052:
        r0 = "`icon`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x005a:
        r2 = 4;
        goto L_0x005d;
    L_0x005c:
        r2 = -1;
    L_0x005d:
        switch(r2) {
            case 0: goto L_0x007d;
            case 1: goto L_0x007a;
            case 2: goto L_0x0077;
            case 3: goto L_0x0074;
            case 4: goto L_0x0071;
            case 5: goto L_0x006e;
            case 6: goto L_0x006b;
            case 7: goto L_0x0068;
            default: goto L_0x0060;
        };
    L_0x0060:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x0068:
        r2 = visitTime;
        return r2;
    L_0x006b:
        r2 = keyColor;
        return r2;
    L_0x006e:
        r2 = headerImg;
        return r2;
    L_0x0071:
        r2 = icon;
        return r2;
    L_0x0074:
        r2 = subredditId;
        return r2;
    L_0x0077:
        r2 = subredditName;
        return r2;
    L_0x007a:
        r2 = username;
        return r2;
    L_0x007d:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final ModelSaver<RecentSubreddit> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    private static OperatorGroup m36665a(RecentSubreddit recentSubreddit) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(recentSubreddit.id)));
        return clause;
    }

    private static void m36666a(ContentValues contentValues, RecentSubreddit recentSubreddit) {
        String str;
        String str2 = "`username`";
        if (recentSubreddit.username != null) {
            str = recentSubreddit.username;
        } else {
            str = "";
        }
        contentValues.put(str2, str);
        str2 = "`subredditName`";
        if (recentSubreddit.subredditName != null) {
            str = recentSubreddit.subredditName;
        } else {
            str = "";
        }
        contentValues.put(str2, str);
        str2 = "`subredditId`";
        if (recentSubreddit.subredditId != null) {
            str = recentSubreddit.subredditId;
        } else {
            str = "";
        }
        contentValues.put(str2, str);
        contentValues.put("`icon`", recentSubreddit.icon);
        contentValues.put("`headerImg`", recentSubreddit.headerImg);
        contentValues.put("`keyColor`", recentSubreddit.keyColor);
        contentValues.put("`visitTime`", recentSubreddit.visitTime);
    }

    private static void m36667a(DatabaseStatement databaseStatement, RecentSubreddit recentSubreddit, int i) {
        if (recentSubreddit.username != null) {
            databaseStatement.bindString(1 + i, recentSubreddit.username);
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        if (recentSubreddit.subredditName != null) {
            databaseStatement.bindString(2 + i, recentSubreddit.subredditName);
        } else {
            databaseStatement.bindString(2 + i, "");
        }
        if (recentSubreddit.subredditId != null) {
            databaseStatement.bindString(3 + i, recentSubreddit.subredditId);
        } else {
            databaseStatement.bindString(3 + i, "");
        }
        databaseStatement.bindStringOrNull(4 + i, recentSubreddit.icon);
        databaseStatement.bindStringOrNull(5 + i, recentSubreddit.headerImg);
        databaseStatement.bindStringOrNull(6 + i, recentSubreddit.keyColor);
        databaseStatement.bindNumberOrNull(7 + i, recentSubreddit.visitTime);
    }

    public final /* synthetic */ Object newInstance() {
        return new RecentSubreddit((byte) 0);
    }
}
