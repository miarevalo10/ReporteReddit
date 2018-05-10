package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.BooleanConverter;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty.TypeConverterGetter;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class AccountDataModel_Table extends ModelAdapter<AccountDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, accountId, name, createdUtc, isEmployee, isFriend, isSuspended, suspensionExpiration, hideFromRobots, linkKarma, commentKarma, isGold, isMod, hasVerifiedEmail, inboxCount, hasMail, hasModMail, hideAds, goldCredits, iconUrl, showMyActiveCommunities};
    public static final Property<String> accountId = new Property(AccountDataModel.class, "accountId");
    public static final Property<Integer> commentKarma = new Property(AccountDataModel.class, "commentKarma");
    public static final Property<Long> createdUtc = new Property(AccountDataModel.class, "createdUtc");
    public static final Property<Integer> goldCredits = new Property(AccountDataModel.class, "goldCredits");
    public static final Property<Boolean> hasMail = new Property(AccountDataModel.class, "hasMail");
    public static final Property<Boolean> hasModMail = new Property(AccountDataModel.class, "hasModMail");
    public static final TypeConvertedProperty<Integer, Boolean> hasVerifiedEmail = new TypeConvertedProperty(AccountDataModel.class, "hasVerifiedEmail", true, new C15231());
    public static final Property<Boolean> hideAds = new Property(AccountDataModel.class, "hideAds");
    public static final Property<Boolean> hideFromRobots = new Property(AccountDataModel.class, "hideFromRobots");
    public static final Property<String> iconUrl = new Property(AccountDataModel.class, "iconUrl");
    public static final Property<Long> id = new Property(AccountDataModel.class, "id");
    public static final Property<Integer> inboxCount = new Property(AccountDataModel.class, "inboxCount");
    public static final Property<Boolean> isEmployee = new Property(AccountDataModel.class, "isEmployee");
    public static final Property<Boolean> isFriend = new Property(AccountDataModel.class, "isFriend");
    public static final Property<Boolean> isGold = new Property(AccountDataModel.class, "isGold");
    public static final Property<Boolean> isMod = new Property(AccountDataModel.class, "isMod");
    public static final Property<Boolean> isSuspended = new Property(AccountDataModel.class, "isSuspended");
    public static final Property<Integer> linkKarma = new Property(AccountDataModel.class, "linkKarma");
    public static final Property<String> name = new Property(AccountDataModel.class, "name");
    public static final TypeConvertedProperty<Integer, Boolean> showMyActiveCommunities = new TypeConvertedProperty(AccountDataModel.class, "showMyActiveCommunities", true, new C15242());
    public static final Property<Integer> suspensionExpiration = new Property(AccountDataModel.class, "suspensionExpiration");
    private final BooleanConverter global_typeConverterBooleanConverter;

    static class C15231 implements TypeConverterGetter {
        C15231() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((AccountDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15242 implements TypeConverterGetter {
        C15242() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((AccountDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `account`(`id`,`accountId`,`name`,`createdUtc`,`isEmployee`,`isFriend`,`isSuspended`,`suspensionExpiration`,`hideFromRobots`,`linkKarma`,`commentKarma`,`isGold`,`isMod`,`hasVerifiedEmail`,`inboxCount`,`hasMail`,`hasModMail`,`hideAds`,`goldCredits`,`iconUrl`,`showMyActiveCommunities`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `account`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `accountId` TEXT UNIQUE ON CONFLICT REPLACE, `name` TEXT UNIQUE ON CONFLICT REPLACE, `createdUtc` INTEGER, `isEmployee` INTEGER, `isFriend` INTEGER, `isSuspended` INTEGER, `suspensionExpiration` INTEGER, `hideFromRobots` INTEGER, `linkKarma` INTEGER, `commentKarma` INTEGER, `isGold` INTEGER, `isMod` INTEGER, `hasVerifiedEmail` INTEGER, `inboxCount` INTEGER, `hasMail` INTEGER, `hasModMail` INTEGER, `hideAds` INTEGER, `goldCredits` INTEGER, `iconUrl` TEXT, `showMyActiveCommunities` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `account` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `account`(`accountId`,`name`,`createdUtc`,`isEmployee`,`isFriend`,`isSuspended`,`suspensionExpiration`,`hideFromRobots`,`linkKarma`,`commentKarma`,`isGold`,`isMod`,`hasVerifiedEmail`,`inboxCount`,`hasMail`,`hasModMail`,`hideAds`,`goldCredits`,`iconUrl`,`showMyActiveCommunities`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`account`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `account` SET `id`=?,`accountId`=?,`name`=?,`createdUtc`=?,`isEmployee`=?,`isFriend`=?,`isSuspended`=?,`suspensionExpiration`=?,`hideFromRobots`=?,`linkKarma`=?,`commentKarma`=?,`isGold`=?,`isMod`=?,`hasVerifiedEmail`=?,`inboxCount`=?,`hasMail`=?,`hasModMail`=?,`hideAds`=?,`goldCredits`=?,`iconUrl`=?,`showMyActiveCommunities`=? WHERE `id`=?";
    }

    public AccountDataModel_Table(DatabaseHolder databaseHolder, DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
        this.global_typeConverterBooleanConverter = (BooleanConverter) databaseHolder.getTypeConverterForClass(Boolean.class);
    }

    public final Class<AccountDataModel> getModelClass() {
        return AccountDataModel.class;
    }

    public final AccountDataModel newInstance() {
        return new AccountDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2097294362: goto L_0x00ec;
            case -1879290296: goto L_0x00e1;
            case -1593286801: goto L_0x00d6;
            case -1511992936: goto L_0x00cc;
            case -1466010581: goto L_0x00c1;
            case -1441983787: goto L_0x00b7;
            case -982830620: goto L_0x00ad;
            case -971688696: goto L_0x00a3;
            case -196502769: goto L_0x0099;
            case -111924502: goto L_0x008e;
            case -43882761: goto L_0x0082;
            case 2964037: goto L_0x0077;
            case 44621544: goto L_0x006b;
            case 296718854: goto L_0x005f;
            case 764216084: goto L_0x0054;
            case 803544690: goto L_0x0048;
            case 1310645455: goto L_0x003c;
            case 1429666968: goto L_0x0031;
            case 1739975681: goto L_0x0025;
            case 1840141642: goto L_0x0019;
            case 1866009750: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x00f7;
    L_0x000d:
        r0 = "`isGold`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0015:
        r2 = 11;
        goto L_0x00f8;
    L_0x0019:
        r0 = "`iconUrl`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0021:
        r2 = 19;
        goto L_0x00f8;
    L_0x0025:
        r0 = "`hasModMail`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x002d:
        r2 = 16;
        goto L_0x00f8;
    L_0x0031:
        r0 = "`isFriend`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0039:
        r2 = 5;
        goto L_0x00f8;
    L_0x003c:
        r0 = "`commentKarma`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0044:
        r2 = 10;
        goto L_0x00f8;
    L_0x0048:
        r0 = "`hideAds`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0050:
        r2 = 17;
        goto L_0x00f8;
    L_0x0054:
        r0 = "`suspensionExpiration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x005c:
        r2 = 7;
        goto L_0x00f8;
    L_0x005f:
        r0 = "`hasVerifiedEmail`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0067:
        r2 = 13;
        goto L_0x00f8;
    L_0x006b:
        r0 = "`showMyActiveCommunities`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0073:
        r2 = 20;
        goto L_0x00f8;
    L_0x0077:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x007f:
        r2 = 0;
        goto L_0x00f8;
    L_0x0082:
        r0 = "`inboxCount`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x008a:
        r2 = 14;
        goto L_0x00f8;
    L_0x008e:
        r0 = "`linkKarma`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x0096:
        r2 = 9;
        goto L_0x00f8;
    L_0x0099:
        r0 = "`isSuspended`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00a1:
        r2 = 6;
        goto L_0x00f8;
    L_0x00a3:
        r0 = "`isEmployee`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00ab:
        r2 = 4;
        goto L_0x00f8;
    L_0x00ad:
        r0 = "`createdUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00b5:
        r2 = 3;
        goto L_0x00f8;
    L_0x00b7:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00bf:
        r2 = 2;
        goto L_0x00f8;
    L_0x00c1:
        r0 = "`hideFromRobots`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00c9:
        r2 = 8;
        goto L_0x00f8;
    L_0x00cc:
        r0 = "`accountId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00d4:
        r2 = 1;
        goto L_0x00f8;
    L_0x00d6:
        r0 = "`hasMail`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00de:
        r2 = 15;
        goto L_0x00f8;
    L_0x00e1:
        r0 = "`isMod`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00e9:
        r2 = 12;
        goto L_0x00f8;
    L_0x00ec:
        r0 = "`goldCredits`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00f7;
    L_0x00f4:
        r2 = 18;
        goto L_0x00f8;
    L_0x00f7:
        r2 = -1;
    L_0x00f8:
        switch(r2) {
            case 0: goto L_0x013f;
            case 1: goto L_0x013c;
            case 2: goto L_0x0139;
            case 3: goto L_0x0136;
            case 4: goto L_0x0133;
            case 5: goto L_0x0130;
            case 6: goto L_0x012d;
            case 7: goto L_0x012a;
            case 8: goto L_0x0127;
            case 9: goto L_0x0124;
            case 10: goto L_0x0121;
            case 11: goto L_0x011e;
            case 12: goto L_0x011b;
            case 13: goto L_0x0118;
            case 14: goto L_0x0115;
            case 15: goto L_0x0112;
            case 16: goto L_0x010f;
            case 17: goto L_0x010c;
            case 18: goto L_0x0109;
            case 19: goto L_0x0106;
            case 20: goto L_0x0103;
            default: goto L_0x00fb;
        };
    L_0x00fb:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x0103:
        r2 = showMyActiveCommunities;
        return r2;
    L_0x0106:
        r2 = iconUrl;
        return r2;
    L_0x0109:
        r2 = goldCredits;
        return r2;
    L_0x010c:
        r2 = hideAds;
        return r2;
    L_0x010f:
        r2 = hasModMail;
        return r2;
    L_0x0112:
        r2 = hasMail;
        return r2;
    L_0x0115:
        r2 = inboxCount;
        return r2;
    L_0x0118:
        r2 = hasVerifiedEmail;
        return r2;
    L_0x011b:
        r2 = isMod;
        return r2;
    L_0x011e:
        r2 = isGold;
        return r2;
    L_0x0121:
        r2 = commentKarma;
        return r2;
    L_0x0124:
        r2 = linkKarma;
        return r2;
    L_0x0127:
        r2 = hideFromRobots;
        return r2;
    L_0x012a:
        r2 = suspensionExpiration;
        return r2;
    L_0x012d:
        r2 = isSuspended;
        return r2;
    L_0x0130:
        r2 = isFriend;
        return r2;
    L_0x0133:
        r2 = isEmployee;
        return r2;
    L_0x0136:
        r2 = createdUtc;
        return r2;
    L_0x0139:
        r2 = name;
        return r2;
    L_0x013c:
        r2 = accountId;
        return r2;
    L_0x013f:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.AccountDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(AccountDataModel accountDataModel, Number number) {
        accountDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(AccountDataModel accountDataModel) {
        return Long.valueOf(accountDataModel.getId());
    }

    public final ModelSaver<AccountDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, AccountDataModel accountDataModel) {
        contentValues.put("`accountId`", accountDataModel.getAccountId() != null ? accountDataModel.getAccountId() : "");
        contentValues.put("`name`", accountDataModel.getName() != null ? accountDataModel.getName() : "");
        contentValues.put("`createdUtc`", Long.valueOf(accountDataModel.getCreatedUtc()));
        contentValues.put("`isEmployee`", Integer.valueOf(accountDataModel.isEmployee()));
        contentValues.put("`isFriend`", Integer.valueOf(accountDataModel.isFriend()));
        contentValues.put("`isSuspended`", Integer.valueOf(accountDataModel.isSuspended()));
        contentValues.put("`suspensionExpiration`", accountDataModel.getSuspensionExpiration());
        contentValues.put("`hideFromRobots`", Integer.valueOf(accountDataModel.getHideFromRobots()));
        contentValues.put("`linkKarma`", Integer.valueOf(accountDataModel.getLinkKarma()));
        contentValues.put("`commentKarma`", Integer.valueOf(accountDataModel.getCommentKarma()));
        contentValues.put("`isGold`", Integer.valueOf(accountDataModel.isGold()));
        contentValues.put("`isMod`", Integer.valueOf(accountDataModel.isMod()));
        Integer num = null;
        contentValues.put("`hasVerifiedEmail`", accountDataModel.getHasVerifiedEmail() != null ? this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getHasVerifiedEmail()) : null);
        contentValues.put("`inboxCount`", Integer.valueOf(accountDataModel.getInboxCount()));
        contentValues.put("`hasMail`", Integer.valueOf(accountDataModel.getHasMail()));
        contentValues.put("`hasModMail`", Integer.valueOf(accountDataModel.getHasModMail()));
        contentValues.put("`hideAds`", Integer.valueOf(accountDataModel.getHideAds()));
        contentValues.put("`goldCredits`", Integer.valueOf(accountDataModel.getGoldCredits()));
        contentValues.put("`iconUrl`", accountDataModel.getIconUrl() != null ? accountDataModel.getIconUrl() : "");
        if (accountDataModel.getShowMyActiveCommunities() != null) {
            num = this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getShowMyActiveCommunities());
        }
        contentValues.put("`showMyActiveCommunities`", num);
    }

    public final void bindToContentValues(ContentValues contentValues, AccountDataModel accountDataModel) {
        contentValues.put("`id`", Long.valueOf(accountDataModel.getId()));
        bindToInsertValues(contentValues, accountDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, AccountDataModel accountDataModel, int i) {
        if (accountDataModel.getAccountId() != null) {
            databaseStatement.bindString(1 + i, accountDataModel.getAccountId());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        if (accountDataModel.getName() != null) {
            databaseStatement.bindString(2 + i, accountDataModel.getName());
        } else {
            databaseStatement.bindString(2 + i, "");
        }
        databaseStatement.bindLong(3 + i, accountDataModel.getCreatedUtc());
        long j = 0;
        databaseStatement.bindLong(4 + i, accountDataModel.isEmployee() ? 1 : 0);
        databaseStatement.bindLong(5 + i, accountDataModel.isFriend() ? 1 : 0);
        databaseStatement.bindLong(6 + i, accountDataModel.isSuspended() ? 1 : 0);
        databaseStatement.bindNumberOrNull(7 + i, accountDataModel.getSuspensionExpiration());
        databaseStatement.bindLong(8 + i, accountDataModel.getHideFromRobots() ? 1 : 0);
        databaseStatement.bindLong(9 + i, (long) accountDataModel.getLinkKarma());
        databaseStatement.bindLong(10 + i, (long) accountDataModel.getCommentKarma());
        databaseStatement.bindLong(11 + i, accountDataModel.isGold() ? 1 : 0);
        databaseStatement.bindLong(12 + i, accountDataModel.isMod() ? 1 : 0);
        Number number = null;
        databaseStatement.bindNumberOrNull(13 + i, accountDataModel.getHasVerifiedEmail() != null ? this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getHasVerifiedEmail()) : null);
        databaseStatement.bindLong(14 + i, (long) accountDataModel.getInboxCount());
        databaseStatement.bindLong(15 + i, accountDataModel.getHasMail() ? 1 : 0);
        databaseStatement.bindLong(16 + i, accountDataModel.getHasModMail() ? 1 : 0);
        int i2 = 17 + i;
        if (accountDataModel.getHideAds()) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
        databaseStatement.bindLong(18 + i, (long) accountDataModel.getGoldCredits());
        if (accountDataModel.getIconUrl() != null) {
            databaseStatement.bindString(19 + i, accountDataModel.getIconUrl());
        } else {
            databaseStatement.bindString(19 + i, "");
        }
        if (accountDataModel.getShowMyActiveCommunities() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getShowMyActiveCommunities());
        }
        databaseStatement.bindNumberOrNull(20 + i, number);
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, AccountDataModel accountDataModel) {
        databaseStatement.bindLong(1, accountDataModel.getId());
        bindToInsertStatement(databaseStatement, accountDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, AccountDataModel accountDataModel) {
        databaseStatement.bindLong(1, accountDataModel.getId());
        if (accountDataModel.getAccountId() != null) {
            databaseStatement.bindString(2, accountDataModel.getAccountId());
        } else {
            databaseStatement.bindString(2, "");
        }
        if (accountDataModel.getName() != null) {
            databaseStatement.bindString(3, accountDataModel.getName());
        } else {
            databaseStatement.bindString(3, "");
        }
        databaseStatement.bindLong(4, accountDataModel.getCreatedUtc());
        long j = 0;
        databaseStatement.bindLong(5, accountDataModel.isEmployee() ? 1 : 0);
        databaseStatement.bindLong(6, accountDataModel.isFriend() ? 1 : 0);
        databaseStatement.bindLong(7, accountDataModel.isSuspended() ? 1 : 0);
        databaseStatement.bindNumberOrNull(8, accountDataModel.getSuspensionExpiration());
        databaseStatement.bindLong(9, accountDataModel.getHideFromRobots() ? 1 : 0);
        databaseStatement.bindLong(10, (long) accountDataModel.getLinkKarma());
        databaseStatement.bindLong(11, (long) accountDataModel.getCommentKarma());
        databaseStatement.bindLong(12, accountDataModel.isGold() ? 1 : 0);
        databaseStatement.bindLong(13, accountDataModel.isMod() ? 1 : 0);
        Number number = null;
        databaseStatement.bindNumberOrNull(14, accountDataModel.getHasVerifiedEmail() != null ? this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getHasVerifiedEmail()) : null);
        databaseStatement.bindLong(15, (long) accountDataModel.getInboxCount());
        databaseStatement.bindLong(16, accountDataModel.getHasMail() ? 1 : 0);
        databaseStatement.bindLong(17, accountDataModel.getHasModMail() ? 1 : 0);
        if (accountDataModel.getHideAds()) {
            j = 1;
        }
        databaseStatement.bindLong(18, j);
        databaseStatement.bindLong(19, (long) accountDataModel.getGoldCredits());
        if (accountDataModel.getIconUrl() != null) {
            databaseStatement.bindString(20, accountDataModel.getIconUrl());
        } else {
            databaseStatement.bindString(20, "");
        }
        if (accountDataModel.getShowMyActiveCommunities() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(accountDataModel.getShowMyActiveCommunities());
        }
        databaseStatement.bindNumberOrNull(21, number);
        databaseStatement.bindLong(22, accountDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, AccountDataModel accountDataModel) {
        databaseStatement.bindLong(1, accountDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, AccountDataModel accountDataModel) {
        accountDataModel.setId(flowCursor.getLongOrDefault("id"));
        accountDataModel.setAccountId(flowCursor.getStringOrDefault("accountId", ""));
        accountDataModel.setName(flowCursor.getStringOrDefault("name", ""));
        accountDataModel.setCreatedUtc(flowCursor.getLongOrDefault("createdUtc"));
        int columnIndex = flowCursor.getColumnIndex("isEmployee");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setEmployee(false);
        } else {
            accountDataModel.setEmployee(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("isFriend");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setFriend(false);
        } else {
            accountDataModel.setFriend(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("isSuspended");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setSuspended(false);
        } else {
            accountDataModel.setSuspended(flowCursor.getBoolean(columnIndex));
        }
        accountDataModel.setSuspensionExpiration(flowCursor.getIntOrDefault("suspensionExpiration", null));
        columnIndex = flowCursor.getColumnIndex("hideFromRobots");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setHideFromRobots(false);
        } else {
            accountDataModel.setHideFromRobots(flowCursor.getBoolean(columnIndex));
        }
        accountDataModel.setLinkKarma(flowCursor.getIntOrDefault("linkKarma"));
        accountDataModel.setCommentKarma(flowCursor.getIntOrDefault("commentKarma"));
        columnIndex = flowCursor.getColumnIndex("isGold");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setGold(false);
        } else {
            accountDataModel.setGold(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("isMod");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setMod(false);
        } else {
            accountDataModel.setMod(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("hasVerifiedEmail");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setHasVerifiedEmail(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            accountDataModel.setHasVerifiedEmail(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        accountDataModel.setInboxCount(flowCursor.getIntOrDefault("inboxCount"));
        columnIndex = flowCursor.getColumnIndex("hasMail");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setHasMail(false);
        } else {
            accountDataModel.setHasMail(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("hasModMail");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setHasModMail(false);
        } else {
            accountDataModel.setHasModMail(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("hideAds");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setHideAds(false);
        } else {
            accountDataModel.setHideAds(flowCursor.getBoolean(columnIndex));
        }
        accountDataModel.setGoldCredits(flowCursor.getIntOrDefault("goldCredits"));
        accountDataModel.setIconUrl(flowCursor.getStringOrDefault("iconUrl", ""));
        columnIndex = flowCursor.getColumnIndex("showMyActiveCommunities");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            accountDataModel.setShowMyActiveCommunities(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            accountDataModel.setShowMyActiveCommunities(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
    }

    public final boolean exists(AccountDataModel accountDataModel, DatabaseWrapper databaseWrapper) {
        if (accountDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(AccountDataModel.class).where(getPrimaryConditionClause(accountDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(AccountDataModel accountDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(accountDataModel.getId())));
        return clause;
    }
}
