package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import net.hockeyapp.android.UpdateFragment;

public final class RecentSubredditDataModel_Table extends ModelAdapter<RecentSubredditDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, subredditId, name, username, displayName, displayNamePrefixed, iconImg, keyColor, description, publicDescription, descriptionHtml, url, subscribers, accountsActive, bannerImg, over18, subredditType, lastVisited, createdUtc};
    public static final Property<Long> accountsActive = new Property(RecentSubredditDataModel.class, "accountsActive");
    public static final Property<String> bannerImg = new Property(RecentSubredditDataModel.class, "bannerImg");
    public static final Property<Long> createdUtc = new Property(RecentSubredditDataModel.class, "createdUtc");
    public static final Property<String> description = new Property(RecentSubredditDataModel.class, "description");
    public static final Property<String> descriptionHtml = new Property(RecentSubredditDataModel.class, "descriptionHtml");
    public static final Property<String> displayName = new Property(RecentSubredditDataModel.class, "displayName");
    public static final Property<String> displayNamePrefixed = new Property(RecentSubredditDataModel.class, "displayNamePrefixed");
    public static final Property<String> iconImg = new Property(RecentSubredditDataModel.class, "iconImg");
    public static final Property<Long> id = new Property(RecentSubredditDataModel.class, "id");
    public static final Property<String> keyColor = new Property(RecentSubredditDataModel.class, "keyColor");
    public static final Property<Long> lastVisited = new Property(RecentSubredditDataModel.class, "lastVisited");
    public static final Property<String> name = new Property(RecentSubredditDataModel.class, "name");
    public static final Property<Boolean> over18 = new Property(RecentSubredditDataModel.class, "over18");
    public static final Property<String> publicDescription = new Property(RecentSubredditDataModel.class, "publicDescription");
    public static final Property<String> subredditId = new Property(RecentSubredditDataModel.class, "subredditId");
    public static final Property<String> subredditType = new Property(RecentSubredditDataModel.class, "subredditType");
    public static final Property<Long> subscribers = new Property(RecentSubredditDataModel.class, "subscribers");
    public static final Property<String> url = new Property(RecentSubredditDataModel.class, UpdateFragment.FRAGMENT_URL);
    public static final Property<String> username = new Property(RecentSubredditDataModel.class, "username");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `recent_subreddits`(`id`,`subredditId`,`name`,`username`,`displayName`,`displayNamePrefixed`,`iconImg`,`keyColor`,`description`,`publicDescription`,`descriptionHtml`,`url`,`subscribers`,`accountsActive`,`bannerImg`,`over18`,`subredditType`,`lastVisited`,`createdUtc`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `recent_subreddits`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `subredditId` TEXT UNIQUE ON CONFLICT REPLACE, `name` TEXT, `username` TEXT, `displayName` TEXT, `displayNamePrefixed` TEXT, `iconImg` TEXT, `keyColor` TEXT, `description` TEXT, `publicDescription` TEXT, `descriptionHtml` TEXT, `url` TEXT, `subscribers` INTEGER, `accountsActive` INTEGER, `bannerImg` TEXT, `over18` INTEGER, `subredditType` TEXT, `lastVisited` INTEGER, `createdUtc` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `recent_subreddits` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `recent_subreddits`(`subredditId`,`name`,`username`,`displayName`,`displayNamePrefixed`,`iconImg`,`keyColor`,`description`,`publicDescription`,`descriptionHtml`,`url`,`subscribers`,`accountsActive`,`bannerImg`,`over18`,`subredditType`,`lastVisited`,`createdUtc`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`recent_subreddits`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `recent_subreddits` SET `id`=?,`subredditId`=?,`name`=?,`username`=?,`displayName`=?,`displayNamePrefixed`=?,`iconImg`=?,`keyColor`=?,`description`=?,`publicDescription`=?,`descriptionHtml`=?,`url`=?,`subscribers`=?,`accountsActive`=?,`bannerImg`=?,`over18`=?,`subredditType`=?,`lastVisited`=?,`createdUtc`=? WHERE `id`=?";
    }

    public RecentSubredditDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<RecentSubredditDataModel> getModelClass() {
        return RecentSubredditDataModel.class;
    }

    public final RecentSubredditDataModel newInstance() {
        return new RecentSubredditDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2069049067: goto L_0x00d4;
            case -1987812620: goto L_0x00c9;
            case -1740642647: goto L_0x00be;
            case -1510852542: goto L_0x00b4;
            case -1441983787: goto L_0x00aa;
            case -1332609558: goto L_0x00a0;
            case -1285278363: goto L_0x0095;
            case -1213508275: goto L_0x008a;
            case -982830620: goto L_0x007f;
            case -947409208: goto L_0x0074;
            case -797874189: goto L_0x0069;
            case -747364985: goto L_0x005e;
            case -23237564: goto L_0x0052;
            case 2964037: goto L_0x0047;
            case 92256561: goto L_0x003b;
            case 158412860: goto L_0x0030;
            case 1554634713: goto L_0x0024;
            case 1762304908: goto L_0x0018;
            case 1839779190: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x00df;
    L_0x000d:
        r0 = "`iconImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0015:
        r2 = 6;
        goto L_0x00e0;
    L_0x0018:
        r0 = "`lastVisited`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0020:
        r2 = 17;
        goto L_0x00e0;
    L_0x0024:
        r0 = "`descriptionHtml`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x002c:
        r2 = 10;
        goto L_0x00e0;
    L_0x0030:
        r0 = "`keyColor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0038:
        r2 = 7;
        goto L_0x00e0;
    L_0x003b:
        r0 = "`url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0043:
        r2 = 11;
        goto L_0x00e0;
    L_0x0047:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x004f:
        r2 = 0;
        goto L_0x00e0;
    L_0x0052:
        r0 = "`description`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x005a:
        r2 = 8;
        goto L_0x00e0;
    L_0x005e:
        r0 = "`subredditId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0066:
        r2 = 1;
        goto L_0x00e0;
    L_0x0069:
        r0 = "`displayName`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0071:
        r2 = 4;
        goto L_0x00e0;
    L_0x0074:
        r0 = "`subredditType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x007c:
        r2 = 16;
        goto L_0x00e0;
    L_0x007f:
        r0 = "`createdUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0087:
        r2 = 18;
        goto L_0x00e0;
    L_0x008a:
        r0 = "`publicDescription`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x0092:
        r2 = 9;
        goto L_0x00e0;
    L_0x0095:
        r0 = "`over18`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x009d:
        r2 = 15;
        goto L_0x00e0;
    L_0x00a0:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00a8:
        r2 = 3;
        goto L_0x00e0;
    L_0x00aa:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00b2:
        r2 = 2;
        goto L_0x00e0;
    L_0x00b4:
        r0 = "`displayNamePrefixed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00bc:
        r2 = 5;
        goto L_0x00e0;
    L_0x00be:
        r0 = "`bannerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00c6:
        r2 = 14;
        goto L_0x00e0;
    L_0x00c9:
        r0 = "`accountsActive`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00d1:
        r2 = 13;
        goto L_0x00e0;
    L_0x00d4:
        r0 = "`subscribers`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x00dc:
        r2 = 12;
        goto L_0x00e0;
    L_0x00df:
        r2 = -1;
    L_0x00e0:
        switch(r2) {
            case 0: goto L_0x0121;
            case 1: goto L_0x011e;
            case 2: goto L_0x011b;
            case 3: goto L_0x0118;
            case 4: goto L_0x0115;
            case 5: goto L_0x0112;
            case 6: goto L_0x010f;
            case 7: goto L_0x010c;
            case 8: goto L_0x0109;
            case 9: goto L_0x0106;
            case 10: goto L_0x0103;
            case 11: goto L_0x0100;
            case 12: goto L_0x00fd;
            case 13: goto L_0x00fa;
            case 14: goto L_0x00f7;
            case 15: goto L_0x00f4;
            case 16: goto L_0x00f1;
            case 17: goto L_0x00ee;
            case 18: goto L_0x00eb;
            default: goto L_0x00e3;
        };
    L_0x00e3:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x00eb:
        r2 = createdUtc;
        return r2;
    L_0x00ee:
        r2 = lastVisited;
        return r2;
    L_0x00f1:
        r2 = subredditType;
        return r2;
    L_0x00f4:
        r2 = over18;
        return r2;
    L_0x00f7:
        r2 = bannerImg;
        return r2;
    L_0x00fa:
        r2 = accountsActive;
        return r2;
    L_0x00fd:
        r2 = subscribers;
        return r2;
    L_0x0100:
        r2 = url;
        return r2;
    L_0x0103:
        r2 = descriptionHtml;
        return r2;
    L_0x0106:
        r2 = publicDescription;
        return r2;
    L_0x0109:
        r2 = description;
        return r2;
    L_0x010c:
        r2 = keyColor;
        return r2;
    L_0x010f:
        r2 = iconImg;
        return r2;
    L_0x0112:
        r2 = displayNamePrefixed;
        return r2;
    L_0x0115:
        r2 = displayName;
        return r2;
    L_0x0118:
        r2 = username;
        return r2;
    L_0x011b:
        r2 = name;
        return r2;
    L_0x011e:
        r2 = subredditId;
        return r2;
    L_0x0121:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(RecentSubredditDataModel recentSubredditDataModel, Number number) {
        recentSubredditDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(RecentSubredditDataModel recentSubredditDataModel) {
        return Long.valueOf(recentSubredditDataModel.getId());
    }

    public final ModelSaver<RecentSubredditDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, RecentSubredditDataModel recentSubredditDataModel) {
        contentValues.put("`subredditId`", recentSubredditDataModel.getSubredditId() != null ? recentSubredditDataModel.getSubredditId() : "");
        contentValues.put("`name`", recentSubredditDataModel.getName() != null ? recentSubredditDataModel.getName() : "");
        contentValues.put("`username`", recentSubredditDataModel.getUsername() != null ? recentSubredditDataModel.getUsername() : "");
        contentValues.put("`displayName`", recentSubredditDataModel.getDisplayName() != null ? recentSubredditDataModel.getDisplayName() : "");
        contentValues.put("`displayNamePrefixed`", recentSubredditDataModel.getDisplayNamePrefixed() != null ? recentSubredditDataModel.getDisplayNamePrefixed() : "");
        contentValues.put("`iconImg`", recentSubredditDataModel.getIconImg());
        contentValues.put("`keyColor`", recentSubredditDataModel.getKeyColor() != null ? recentSubredditDataModel.getKeyColor() : "");
        contentValues.put("`description`", recentSubredditDataModel.getDescription() != null ? recentSubredditDataModel.getDescription() : "");
        contentValues.put("`publicDescription`", recentSubredditDataModel.getPublicDescription() != null ? recentSubredditDataModel.getPublicDescription() : "");
        contentValues.put("`descriptionHtml`", recentSubredditDataModel.getDescriptionHtml());
        contentValues.put("`url`", recentSubredditDataModel.getUrl() != null ? recentSubredditDataModel.getUrl() : "");
        contentValues.put("`subscribers`", Long.valueOf(recentSubredditDataModel.getSubscribers()));
        contentValues.put("`accountsActive`", Long.valueOf(recentSubredditDataModel.getAccountsActive()));
        contentValues.put("`bannerImg`", recentSubredditDataModel.getBannerImg());
        contentValues.put("`over18`", Integer.valueOf(recentSubredditDataModel.getOver18()));
        contentValues.put("`subredditType`", recentSubredditDataModel.getSubredditType() != null ? recentSubredditDataModel.getSubredditType() : "");
        contentValues.put("`lastVisited`", Long.valueOf(recentSubredditDataModel.getLastVisited()));
        contentValues.put("`createdUtc`", Long.valueOf(recentSubredditDataModel.getCreatedUtc()));
    }

    public final void bindToContentValues(ContentValues contentValues, RecentSubredditDataModel recentSubredditDataModel) {
        contentValues.put("`id`", Long.valueOf(recentSubredditDataModel.getId()));
        bindToInsertValues(contentValues, recentSubredditDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, RecentSubredditDataModel recentSubredditDataModel, int i) {
        if (recentSubredditDataModel.getSubredditId() != null) {
            databaseStatement.bindString(1 + i, recentSubredditDataModel.getSubredditId());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        if (recentSubredditDataModel.getName() != null) {
            databaseStatement.bindString(2 + i, recentSubredditDataModel.getName());
        } else {
            databaseStatement.bindString(2 + i, "");
        }
        if (recentSubredditDataModel.getUsername() != null) {
            databaseStatement.bindString(3 + i, recentSubredditDataModel.getUsername());
        } else {
            databaseStatement.bindString(3 + i, "");
        }
        if (recentSubredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(4 + i, recentSubredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(4 + i, "");
        }
        if (recentSubredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(5 + i, recentSubredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(5 + i, "");
        }
        databaseStatement.bindStringOrNull(6 + i, recentSubredditDataModel.getIconImg());
        if (recentSubredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(7 + i, recentSubredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(7 + i, "");
        }
        if (recentSubredditDataModel.getDescription() != null) {
            databaseStatement.bindString(8 + i, recentSubredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(8 + i, "");
        }
        if (recentSubredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(9 + i, recentSubredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(9 + i, "");
        }
        databaseStatement.bindStringOrNull(10 + i, recentSubredditDataModel.getDescriptionHtml());
        if (recentSubredditDataModel.getUrl() != null) {
            databaseStatement.bindString(11 + i, recentSubredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(11 + i, "");
        }
        databaseStatement.bindLong(12 + i, recentSubredditDataModel.getSubscribers());
        databaseStatement.bindLong(13 + i, recentSubredditDataModel.getAccountsActive());
        databaseStatement.bindStringOrNull(14 + i, recentSubredditDataModel.getBannerImg());
        databaseStatement.bindLong(15 + i, recentSubredditDataModel.getOver18() ? 1 : 0);
        if (recentSubredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(16 + i, recentSubredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(16 + i, "");
        }
        databaseStatement.bindLong(17 + i, recentSubredditDataModel.getLastVisited());
        databaseStatement.bindLong(18 + i, recentSubredditDataModel.getCreatedUtc());
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, RecentSubredditDataModel recentSubredditDataModel) {
        databaseStatement.bindLong(1, recentSubredditDataModel.getId());
        bindToInsertStatement(databaseStatement, recentSubredditDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, RecentSubredditDataModel recentSubredditDataModel) {
        databaseStatement.bindLong(1, recentSubredditDataModel.getId());
        if (recentSubredditDataModel.getSubredditId() != null) {
            databaseStatement.bindString(2, recentSubredditDataModel.getSubredditId());
        } else {
            databaseStatement.bindString(2, "");
        }
        if (recentSubredditDataModel.getName() != null) {
            databaseStatement.bindString(3, recentSubredditDataModel.getName());
        } else {
            databaseStatement.bindString(3, "");
        }
        if (recentSubredditDataModel.getUsername() != null) {
            databaseStatement.bindString(4, recentSubredditDataModel.getUsername());
        } else {
            databaseStatement.bindString(4, "");
        }
        if (recentSubredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(5, recentSubredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(5, "");
        }
        if (recentSubredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(6, recentSubredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(6, "");
        }
        databaseStatement.bindStringOrNull(7, recentSubredditDataModel.getIconImg());
        if (recentSubredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(8, recentSubredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(8, "");
        }
        if (recentSubredditDataModel.getDescription() != null) {
            databaseStatement.bindString(9, recentSubredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(9, "");
        }
        if (recentSubredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(10, recentSubredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(10, "");
        }
        databaseStatement.bindStringOrNull(11, recentSubredditDataModel.getDescriptionHtml());
        if (recentSubredditDataModel.getUrl() != null) {
            databaseStatement.bindString(12, recentSubredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(12, "");
        }
        databaseStatement.bindLong(13, recentSubredditDataModel.getSubscribers());
        databaseStatement.bindLong(14, recentSubredditDataModel.getAccountsActive());
        databaseStatement.bindStringOrNull(15, recentSubredditDataModel.getBannerImg());
        databaseStatement.bindLong(16, recentSubredditDataModel.getOver18() ? 1 : 0);
        if (recentSubredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(17, recentSubredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(17, "");
        }
        databaseStatement.bindLong(18, recentSubredditDataModel.getLastVisited());
        databaseStatement.bindLong(19, recentSubredditDataModel.getCreatedUtc());
        databaseStatement.bindLong(20, recentSubredditDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, RecentSubredditDataModel recentSubredditDataModel) {
        databaseStatement.bindLong(1, recentSubredditDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, RecentSubredditDataModel recentSubredditDataModel) {
        recentSubredditDataModel.setId(flowCursor.getLongOrDefault("id"));
        recentSubredditDataModel.setSubredditId(flowCursor.getStringOrDefault("subredditId", ""));
        recentSubredditDataModel.setName(flowCursor.getStringOrDefault("name", ""));
        recentSubredditDataModel.setUsername(flowCursor.getStringOrDefault("username", ""));
        recentSubredditDataModel.setDisplayName(flowCursor.getStringOrDefault("displayName", ""));
        recentSubredditDataModel.setDisplayNamePrefixed(flowCursor.getStringOrDefault("displayNamePrefixed", ""));
        recentSubredditDataModel.setIconImg(flowCursor.getStringOrDefault("iconImg"));
        recentSubredditDataModel.setKeyColor(flowCursor.getStringOrDefault("keyColor", ""));
        recentSubredditDataModel.setDescription(flowCursor.getStringOrDefault("description", ""));
        recentSubredditDataModel.setPublicDescription(flowCursor.getStringOrDefault("publicDescription", ""));
        recentSubredditDataModel.setDescriptionHtml(flowCursor.getStringOrDefault("descriptionHtml"));
        recentSubredditDataModel.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL, ""));
        recentSubredditDataModel.setSubscribers(flowCursor.getLongOrDefault("subscribers"));
        recentSubredditDataModel.setAccountsActive(flowCursor.getLongOrDefault("accountsActive"));
        recentSubredditDataModel.setBannerImg(flowCursor.getStringOrDefault("bannerImg"));
        int columnIndex = flowCursor.getColumnIndex("over18");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            recentSubredditDataModel.setOver18(false);
        } else {
            recentSubredditDataModel.setOver18(flowCursor.getBoolean(columnIndex));
        }
        recentSubredditDataModel.setSubredditType(flowCursor.getStringOrDefault("subredditType", ""));
        recentSubredditDataModel.setLastVisited(flowCursor.getLongOrDefault("lastVisited"));
        recentSubredditDataModel.setCreatedUtc(flowCursor.getLongOrDefault("createdUtc"));
    }

    public final boolean exists(RecentSubredditDataModel recentSubredditDataModel, DatabaseWrapper databaseWrapper) {
        if (recentSubredditDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(RecentSubredditDataModel.class).where(getPrimaryConditionClause(recentSubredditDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(RecentSubredditDataModel recentSubredditDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(recentSubredditDataModel.getId())));
        return clause;
    }
}
