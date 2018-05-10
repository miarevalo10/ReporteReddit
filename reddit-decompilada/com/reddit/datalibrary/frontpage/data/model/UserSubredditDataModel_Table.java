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
import net.hockeyapp.android.UpdateFragment;

public final class UserSubredditDataModel_Table extends ModelAdapter<UserSubredditDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, username, bannerImg, userIsBanned, description, userIsMuted, displayName, headerImg, title, userIsModerator, over18, iconImg, displayNamePrefixed, subscribers, isDefaultIcon, keyColor, name, isDefaultBanner, url, userIsContributor, publicDescription, subredditType, userIsSubscriber, showInDefaultSubreddits};
    public static final Property<String> bannerImg = new Property(UserSubredditDataModel.class, "bannerImg");
    public static final Property<String> description = new Property(UserSubredditDataModel.class, "description");
    public static final Property<String> displayName = new Property(UserSubredditDataModel.class, "displayName");
    public static final Property<String> displayNamePrefixed = new Property(UserSubredditDataModel.class, "displayNamePrefixed");
    public static final Property<String> headerImg = new Property(UserSubredditDataModel.class, "headerImg");
    public static final Property<String> iconImg = new Property(UserSubredditDataModel.class, "iconImg");
    public static final Property<Long> id = new Property(UserSubredditDataModel.class, "id");
    public static final Property<Boolean> isDefaultBanner = new Property(UserSubredditDataModel.class, "isDefaultBanner");
    public static final Property<Boolean> isDefaultIcon = new Property(UserSubredditDataModel.class, "isDefaultIcon");
    public static final Property<String> keyColor = new Property(UserSubredditDataModel.class, "keyColor");
    public static final Property<String> name = new Property(UserSubredditDataModel.class, "name");
    public static final Property<Boolean> over18 = new Property(UserSubredditDataModel.class, "over18");
    public static final Property<String> publicDescription = new Property(UserSubredditDataModel.class, "publicDescription");
    public static final Property<Boolean> showInDefaultSubreddits = new Property(UserSubredditDataModel.class, "showInDefaultSubreddits");
    public static final Property<String> subredditType = new Property(UserSubredditDataModel.class, "subredditType");
    public static final Property<Integer> subscribers = new Property(UserSubredditDataModel.class, "subscribers");
    public static final Property<String> title = new Property(UserSubredditDataModel.class, "title");
    public static final Property<String> url = new Property(UserSubredditDataModel.class, UpdateFragment.FRAGMENT_URL);
    public static final TypeConvertedProperty<Integer, Boolean> userIsBanned = new TypeConvertedProperty(UserSubredditDataModel.class, "userIsBanned", true, new C15331());
    public static final TypeConvertedProperty<Integer, Boolean> userIsContributor = new TypeConvertedProperty(UserSubredditDataModel.class, "userIsContributor", true, new C15364());
    public static final TypeConvertedProperty<Integer, Boolean> userIsModerator = new TypeConvertedProperty(UserSubredditDataModel.class, "userIsModerator", true, new C15353());
    public static final TypeConvertedProperty<Integer, Boolean> userIsMuted = new TypeConvertedProperty(UserSubredditDataModel.class, "userIsMuted", true, new C15342());
    public static final TypeConvertedProperty<Integer, Boolean> userIsSubscriber = new TypeConvertedProperty(UserSubredditDataModel.class, "userIsSubscriber", true, new C15375());
    public static final Property<String> username = new Property(UserSubredditDataModel.class, "username");
    private final BooleanConverter global_typeConverterBooleanConverter;

    static class C15331 implements TypeConverterGetter {
        C15331() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((UserSubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15342 implements TypeConverterGetter {
        C15342() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((UserSubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15353 implements TypeConverterGetter {
        C15353() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((UserSubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15364 implements TypeConverterGetter {
        C15364() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((UserSubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15375 implements TypeConverterGetter {
        C15375() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((UserSubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `user_subreddit`(`id`,`username`,`bannerImg`,`userIsBanned`,`description`,`userIsMuted`,`displayName`,`headerImg`,`title`,`userIsModerator`,`over18`,`iconImg`,`displayNamePrefixed`,`subscribers`,`isDefaultIcon`,`keyColor`,`name`,`isDefaultBanner`,`url`,`userIsContributor`,`publicDescription`,`subredditType`,`userIsSubscriber`,`showInDefaultSubreddits`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `user_subreddit`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT UNIQUE ON CONFLICT REPLACE, `bannerImg` TEXT, `userIsBanned` INTEGER, `description` TEXT, `userIsMuted` INTEGER, `displayName` TEXT, `headerImg` TEXT, `title` TEXT, `userIsModerator` INTEGER, `over18` INTEGER, `iconImg` TEXT, `displayNamePrefixed` TEXT, `subscribers` INTEGER, `isDefaultIcon` INTEGER, `keyColor` TEXT, `name` TEXT, `isDefaultBanner` INTEGER, `url` TEXT, `userIsContributor` INTEGER, `publicDescription` TEXT, `subredditType` TEXT, `userIsSubscriber` INTEGER, `showInDefaultSubreddits` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `user_subreddit` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `user_subreddit`(`username`,`bannerImg`,`userIsBanned`,`description`,`userIsMuted`,`displayName`,`headerImg`,`title`,`userIsModerator`,`over18`,`iconImg`,`displayNamePrefixed`,`subscribers`,`isDefaultIcon`,`keyColor`,`name`,`isDefaultBanner`,`url`,`userIsContributor`,`publicDescription`,`subredditType`,`userIsSubscriber`,`showInDefaultSubreddits`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`user_subreddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `user_subreddit` SET `id`=?,`username`=?,`bannerImg`=?,`userIsBanned`=?,`description`=?,`userIsMuted`=?,`displayName`=?,`headerImg`=?,`title`=?,`userIsModerator`=?,`over18`=?,`iconImg`=?,`displayNamePrefixed`=?,`subscribers`=?,`isDefaultIcon`=?,`keyColor`=?,`name`=?,`isDefaultBanner`=?,`url`=?,`userIsContributor`=?,`publicDescription`=?,`subredditType`=?,`userIsSubscriber`=?,`showInDefaultSubreddits`=? WHERE `id`=?";
    }

    public UserSubredditDataModel_Table(DatabaseHolder databaseHolder, DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
        this.global_typeConverterBooleanConverter = (BooleanConverter) databaseHolder.getTypeConverterForClass(Boolean.class);
    }

    public final Class<UserSubredditDataModel> getModelClass() {
        return UserSubredditDataModel.class;
    }

    public final UserSubredditDataModel newInstance() {
        return new UserSubredditDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2069049067: goto L_0x0111;
            case -1740642647: goto L_0x0107;
            case -1572445848: goto L_0x00fc;
            case -1510852542: goto L_0x00f1;
            case -1441983787: goto L_0x00e6;
            case -1332609558: goto L_0x00dc;
            case -1285278363: goto L_0x00d1;
            case -1213508275: goto L_0x00c6;
            case -947409208: goto L_0x00bb;
            case -797874189: goto L_0x00b0;
            case -241725299: goto L_0x00a5;
            case -23237564: goto L_0x009a;
            case -17551613: goto L_0x008e;
            case 2964037: goto L_0x0083;
            case 92256561: goto L_0x0077;
            case 158412860: goto L_0x006b;
            case 449847440: goto L_0x005f;
            case 504041018: goto L_0x0053;
            case 741405546: goto L_0x0048;
            case 1237161309: goto L_0x003c;
            case 1268560266: goto L_0x0031;
            case 1374514028: goto L_0x0025;
            case 1558648816: goto L_0x0019;
            case 1839779190: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x011c;
    L_0x000d:
        r0 = "`iconImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0015:
        r2 = 11;
        goto L_0x011d;
    L_0x0019:
        r0 = "`isDefaultIcon`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0021:
        r2 = 14;
        goto L_0x011d;
    L_0x0025:
        r0 = "`showInDefaultSubreddits`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x002d:
        r2 = 23;
        goto L_0x011d;
    L_0x0031:
        r0 = "`headerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0039:
        r2 = 7;
        goto L_0x011d;
    L_0x003c:
        r0 = "`isDefaultBanner`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0044:
        r2 = 17;
        goto L_0x011d;
    L_0x0048:
        r0 = "`userIsMuted`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0050:
        r2 = 5;
        goto L_0x011d;
    L_0x0053:
        r0 = "`userIsContributor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x005b:
        r2 = 19;
        goto L_0x011d;
    L_0x005f:
        r0 = "`userIsModerator`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0067:
        r2 = 9;
        goto L_0x011d;
    L_0x006b:
        r0 = "`keyColor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0073:
        r2 = 15;
        goto L_0x011d;
    L_0x0077:
        r0 = "`url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x007f:
        r2 = 18;
        goto L_0x011d;
    L_0x0083:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x008b:
        r2 = 0;
        goto L_0x011d;
    L_0x008e:
        r0 = "`userIsSubscriber`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0096:
        r2 = 22;
        goto L_0x011d;
    L_0x009a:
        r0 = "`description`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00a2:
        r2 = 4;
        goto L_0x011d;
    L_0x00a5:
        r0 = "`userIsBanned`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00ad:
        r2 = 3;
        goto L_0x011d;
    L_0x00b0:
        r0 = "`displayName`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00b8:
        r2 = 6;
        goto L_0x011d;
    L_0x00bb:
        r0 = "`subredditType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00c3:
        r2 = 21;
        goto L_0x011d;
    L_0x00c6:
        r0 = "`publicDescription`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00ce:
        r2 = 20;
        goto L_0x011d;
    L_0x00d1:
        r0 = "`over18`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00d9:
        r2 = 10;
        goto L_0x011d;
    L_0x00dc:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00e4:
        r2 = 1;
        goto L_0x011d;
    L_0x00e6:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00ee:
        r2 = 16;
        goto L_0x011d;
    L_0x00f1:
        r0 = "`displayNamePrefixed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x00f9:
        r2 = 12;
        goto L_0x011d;
    L_0x00fc:
        r0 = "`title`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0104:
        r2 = 8;
        goto L_0x011d;
    L_0x0107:
        r0 = "`bannerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x010f:
        r2 = 2;
        goto L_0x011d;
    L_0x0111:
        r0 = "`subscribers`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x011c;
    L_0x0119:
        r2 = 13;
        goto L_0x011d;
    L_0x011c:
        r2 = -1;
    L_0x011d:
        switch(r2) {
            case 0: goto L_0x016d;
            case 1: goto L_0x016a;
            case 2: goto L_0x0167;
            case 3: goto L_0x0164;
            case 4: goto L_0x0161;
            case 5: goto L_0x015e;
            case 6: goto L_0x015b;
            case 7: goto L_0x0158;
            case 8: goto L_0x0155;
            case 9: goto L_0x0152;
            case 10: goto L_0x014f;
            case 11: goto L_0x014c;
            case 12: goto L_0x0149;
            case 13: goto L_0x0146;
            case 14: goto L_0x0143;
            case 15: goto L_0x0140;
            case 16: goto L_0x013d;
            case 17: goto L_0x013a;
            case 18: goto L_0x0137;
            case 19: goto L_0x0134;
            case 20: goto L_0x0131;
            case 21: goto L_0x012e;
            case 22: goto L_0x012b;
            case 23: goto L_0x0128;
            default: goto L_0x0120;
        };
    L_0x0120:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x0128:
        r2 = showInDefaultSubreddits;
        return r2;
    L_0x012b:
        r2 = userIsSubscriber;
        return r2;
    L_0x012e:
        r2 = subredditType;
        return r2;
    L_0x0131:
        r2 = publicDescription;
        return r2;
    L_0x0134:
        r2 = userIsContributor;
        return r2;
    L_0x0137:
        r2 = url;
        return r2;
    L_0x013a:
        r2 = isDefaultBanner;
        return r2;
    L_0x013d:
        r2 = name;
        return r2;
    L_0x0140:
        r2 = keyColor;
        return r2;
    L_0x0143:
        r2 = isDefaultIcon;
        return r2;
    L_0x0146:
        r2 = subscribers;
        return r2;
    L_0x0149:
        r2 = displayNamePrefixed;
        return r2;
    L_0x014c:
        r2 = iconImg;
        return r2;
    L_0x014f:
        r2 = over18;
        return r2;
    L_0x0152:
        r2 = userIsModerator;
        return r2;
    L_0x0155:
        r2 = title;
        return r2;
    L_0x0158:
        r2 = headerImg;
        return r2;
    L_0x015b:
        r2 = displayName;
        return r2;
    L_0x015e:
        r2 = userIsMuted;
        return r2;
    L_0x0161:
        r2 = description;
        return r2;
    L_0x0164:
        r2 = userIsBanned;
        return r2;
    L_0x0167:
        r2 = bannerImg;
        return r2;
    L_0x016a:
        r2 = username;
        return r2;
    L_0x016d:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(UserSubredditDataModel userSubredditDataModel, Number number) {
        userSubredditDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(UserSubredditDataModel userSubredditDataModel) {
        return Long.valueOf(userSubredditDataModel.getId());
    }

    public final ModelSaver<UserSubredditDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, UserSubredditDataModel userSubredditDataModel) {
        contentValues.put("`username`", userSubredditDataModel.getUsername() != null ? userSubredditDataModel.getUsername() : "");
        contentValues.put("`bannerImg`", userSubredditDataModel.getBannerImg());
        Integer num = null;
        contentValues.put("`userIsBanned`", userSubredditDataModel.getUserIsBanned() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsBanned()) : null);
        contentValues.put("`description`", userSubredditDataModel.getDescription() != null ? userSubredditDataModel.getDescription() : "");
        contentValues.put("`userIsMuted`", userSubredditDataModel.getUserIsMuted() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsMuted()) : null);
        contentValues.put("`displayName`", userSubredditDataModel.getDisplayName() != null ? userSubredditDataModel.getDisplayName() : "");
        contentValues.put("`headerImg`", userSubredditDataModel.getHeaderImg());
        contentValues.put("`title`", userSubredditDataModel.getTitle() != null ? userSubredditDataModel.getTitle() : "");
        contentValues.put("`userIsModerator`", userSubredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsModerator()) : null);
        contentValues.put("`over18`", Integer.valueOf(userSubredditDataModel.getOver18()));
        contentValues.put("`iconImg`", userSubredditDataModel.getIconImg() != null ? userSubredditDataModel.getIconImg() : "");
        contentValues.put("`displayNamePrefixed`", userSubredditDataModel.getDisplayNamePrefixed() != null ? userSubredditDataModel.getDisplayNamePrefixed() : "");
        contentValues.put("`subscribers`", Integer.valueOf(userSubredditDataModel.getSubscribers()));
        contentValues.put("`isDefaultIcon`", Integer.valueOf(userSubredditDataModel.isDefaultIcon()));
        contentValues.put("`keyColor`", userSubredditDataModel.getKeyColor() != null ? userSubredditDataModel.getKeyColor() : "");
        contentValues.put("`name`", userSubredditDataModel.getName() != null ? userSubredditDataModel.getName() : "");
        contentValues.put("`isDefaultBanner`", Integer.valueOf(userSubredditDataModel.isDefaultBanner()));
        contentValues.put("`url`", userSubredditDataModel.getUrl() != null ? userSubredditDataModel.getUrl() : "");
        contentValues.put("`userIsContributor`", userSubredditDataModel.getUserIsContributor() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsContributor()) : null);
        contentValues.put("`publicDescription`", userSubredditDataModel.getPublicDescription() != null ? userSubredditDataModel.getPublicDescription() : "");
        contentValues.put("`subredditType`", userSubredditDataModel.getSubredditType() != null ? userSubredditDataModel.getSubredditType() : "");
        if (userSubredditDataModel.getUserIsSubscriber() != null) {
            num = this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsSubscriber());
        }
        contentValues.put("`userIsSubscriber`", num);
        contentValues.put("`showInDefaultSubreddits`", Integer.valueOf(userSubredditDataModel.getShowInDefaultSubreddits()));
    }

    public final void bindToContentValues(ContentValues contentValues, UserSubredditDataModel userSubredditDataModel) {
        contentValues.put("`id`", Long.valueOf(userSubredditDataModel.getId()));
        bindToInsertValues(contentValues, userSubredditDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, UserSubredditDataModel userSubredditDataModel, int i) {
        if (userSubredditDataModel.getUsername() != null) {
            databaseStatement.bindString(1 + i, userSubredditDataModel.getUsername());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        databaseStatement.bindStringOrNull(2 + i, userSubredditDataModel.getBannerImg());
        Number number = null;
        databaseStatement.bindNumberOrNull(3 + i, userSubredditDataModel.getUserIsBanned() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsBanned()) : null);
        if (userSubredditDataModel.getDescription() != null) {
            databaseStatement.bindString(4 + i, userSubredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(4 + i, "");
        }
        databaseStatement.bindNumberOrNull(5 + i, userSubredditDataModel.getUserIsMuted() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsMuted()) : null);
        if (userSubredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(6 + i, userSubredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(6 + i, "");
        }
        databaseStatement.bindStringOrNull(7 + i, userSubredditDataModel.getHeaderImg());
        if (userSubredditDataModel.getTitle() != null) {
            databaseStatement.bindString(8 + i, userSubredditDataModel.getTitle());
        } else {
            databaseStatement.bindString(8 + i, "");
        }
        databaseStatement.bindNumberOrNull(9 + i, userSubredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsModerator()) : null);
        long j = 0;
        databaseStatement.bindLong(10 + i, userSubredditDataModel.getOver18() ? 1 : 0);
        if (userSubredditDataModel.getIconImg() != null) {
            databaseStatement.bindString(11 + i, userSubredditDataModel.getIconImg());
        } else {
            databaseStatement.bindString(11 + i, "");
        }
        if (userSubredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(12 + i, userSubredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(12 + i, "");
        }
        databaseStatement.bindLong(13 + i, (long) userSubredditDataModel.getSubscribers());
        databaseStatement.bindLong(14 + i, userSubredditDataModel.isDefaultIcon() ? 1 : 0);
        if (userSubredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(15 + i, userSubredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(15 + i, "");
        }
        if (userSubredditDataModel.getName() != null) {
            databaseStatement.bindString(16 + i, userSubredditDataModel.getName());
        } else {
            databaseStatement.bindString(16 + i, "");
        }
        databaseStatement.bindLong(17 + i, userSubredditDataModel.isDefaultBanner() ? 1 : 0);
        if (userSubredditDataModel.getUrl() != null) {
            databaseStatement.bindString(18 + i, userSubredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(18 + i, "");
        }
        databaseStatement.bindNumberOrNull(19 + i, userSubredditDataModel.getUserIsContributor() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsContributor()) : null);
        if (userSubredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(20 + i, userSubredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(20 + i, "");
        }
        if (userSubredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(21 + i, userSubredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(21 + i, "");
        }
        if (userSubredditDataModel.getUserIsSubscriber() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsSubscriber());
        }
        databaseStatement.bindNumberOrNull(22 + i, number);
        int i2 = 23 + i;
        if (userSubredditDataModel.getShowInDefaultSubreddits() != null) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, UserSubredditDataModel userSubredditDataModel) {
        databaseStatement.bindLong(1, userSubredditDataModel.getId());
        bindToInsertStatement(databaseStatement, userSubredditDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, UserSubredditDataModel userSubredditDataModel) {
        databaseStatement.bindLong(1, userSubredditDataModel.getId());
        if (userSubredditDataModel.getUsername() != null) {
            databaseStatement.bindString(2, userSubredditDataModel.getUsername());
        } else {
            databaseStatement.bindString(2, "");
        }
        databaseStatement.bindStringOrNull(3, userSubredditDataModel.getBannerImg());
        Number number = null;
        databaseStatement.bindNumberOrNull(4, userSubredditDataModel.getUserIsBanned() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsBanned()) : null);
        if (userSubredditDataModel.getDescription() != null) {
            databaseStatement.bindString(5, userSubredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(5, "");
        }
        databaseStatement.bindNumberOrNull(6, userSubredditDataModel.getUserIsMuted() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsMuted()) : null);
        if (userSubredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(7, userSubredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(7, "");
        }
        databaseStatement.bindStringOrNull(8, userSubredditDataModel.getHeaderImg());
        if (userSubredditDataModel.getTitle() != null) {
            databaseStatement.bindString(9, userSubredditDataModel.getTitle());
        } else {
            databaseStatement.bindString(9, "");
        }
        databaseStatement.bindNumberOrNull(10, userSubredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsModerator()) : null);
        long j = 0;
        databaseStatement.bindLong(11, userSubredditDataModel.getOver18() ? 1 : 0);
        if (userSubredditDataModel.getIconImg() != null) {
            databaseStatement.bindString(12, userSubredditDataModel.getIconImg());
        } else {
            databaseStatement.bindString(12, "");
        }
        if (userSubredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(13, userSubredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(13, "");
        }
        databaseStatement.bindLong(14, (long) userSubredditDataModel.getSubscribers());
        databaseStatement.bindLong(15, userSubredditDataModel.isDefaultIcon() ? 1 : 0);
        if (userSubredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(16, userSubredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(16, "");
        }
        if (userSubredditDataModel.getName() != null) {
            databaseStatement.bindString(17, userSubredditDataModel.getName());
        } else {
            databaseStatement.bindString(17, "");
        }
        databaseStatement.bindLong(18, userSubredditDataModel.isDefaultBanner() ? 1 : 0);
        if (userSubredditDataModel.getUrl() != null) {
            databaseStatement.bindString(19, userSubredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(19, "");
        }
        databaseStatement.bindNumberOrNull(20, userSubredditDataModel.getUserIsContributor() != null ? this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsContributor()) : null);
        if (userSubredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(21, userSubredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(21, "");
        }
        if (userSubredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(22, userSubredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(22, "");
        }
        if (userSubredditDataModel.getUserIsSubscriber() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(userSubredditDataModel.getUserIsSubscriber());
        }
        databaseStatement.bindNumberOrNull(23, number);
        if (userSubredditDataModel.getShowInDefaultSubreddits()) {
            j = 1;
        }
        databaseStatement.bindLong(24, j);
        databaseStatement.bindLong(25, userSubredditDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, UserSubredditDataModel userSubredditDataModel) {
        databaseStatement.bindLong(1, userSubredditDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, UserSubredditDataModel userSubredditDataModel) {
        userSubredditDataModel.setId(flowCursor.getLongOrDefault("id"));
        userSubredditDataModel.setUsername(flowCursor.getStringOrDefault("username", ""));
        userSubredditDataModel.setBannerImg(flowCursor.getStringOrDefault("bannerImg"));
        int columnIndex = flowCursor.getColumnIndex("userIsBanned");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setUserIsBanned(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            userSubredditDataModel.setUserIsBanned(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        userSubredditDataModel.setDescription(flowCursor.getStringOrDefault("description", ""));
        columnIndex = flowCursor.getColumnIndex("userIsMuted");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setUserIsMuted(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            userSubredditDataModel.setUserIsMuted(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        userSubredditDataModel.setDisplayName(flowCursor.getStringOrDefault("displayName", ""));
        userSubredditDataModel.setHeaderImg(flowCursor.getStringOrDefault("headerImg"));
        userSubredditDataModel.setTitle(flowCursor.getStringOrDefault("title", ""));
        columnIndex = flowCursor.getColumnIndex("userIsModerator");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setUserIsModerator(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            userSubredditDataModel.setUserIsModerator(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("over18");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setOver18(false);
        } else {
            userSubredditDataModel.setOver18(flowCursor.getBoolean(columnIndex));
        }
        userSubredditDataModel.setIconImg(flowCursor.getStringOrDefault("iconImg", ""));
        userSubredditDataModel.setDisplayNamePrefixed(flowCursor.getStringOrDefault("displayNamePrefixed", ""));
        userSubredditDataModel.setSubscribers(flowCursor.getIntOrDefault("subscribers"));
        columnIndex = flowCursor.getColumnIndex("isDefaultIcon");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setDefaultIcon(false);
        } else {
            userSubredditDataModel.setDefaultIcon(flowCursor.getBoolean(columnIndex));
        }
        userSubredditDataModel.setKeyColor(flowCursor.getStringOrDefault("keyColor", ""));
        userSubredditDataModel.setName(flowCursor.getStringOrDefault("name", ""));
        columnIndex = flowCursor.getColumnIndex("isDefaultBanner");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setDefaultBanner(false);
        } else {
            userSubredditDataModel.setDefaultBanner(flowCursor.getBoolean(columnIndex));
        }
        userSubredditDataModel.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL, ""));
        columnIndex = flowCursor.getColumnIndex("userIsContributor");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setUserIsContributor(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            userSubredditDataModel.setUserIsContributor(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        userSubredditDataModel.setPublicDescription(flowCursor.getStringOrDefault("publicDescription", ""));
        userSubredditDataModel.setSubredditType(flowCursor.getStringOrDefault("subredditType", ""));
        columnIndex = flowCursor.getColumnIndex("userIsSubscriber");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setUserIsSubscriber(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            userSubredditDataModel.setUserIsSubscriber(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("showInDefaultSubreddits");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            userSubredditDataModel.setShowInDefaultSubreddits(false);
        } else {
            userSubredditDataModel.setShowInDefaultSubreddits(flowCursor.getBoolean(columnIndex));
        }
    }

    public final boolean exists(UserSubredditDataModel userSubredditDataModel, DatabaseWrapper databaseWrapper) {
        if (userSubredditDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(UserSubredditDataModel.class).where(getPrimaryConditionClause(userSubredditDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(UserSubredditDataModel userSubredditDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(userSubredditDataModel.getId())));
        return clause;
    }
}
