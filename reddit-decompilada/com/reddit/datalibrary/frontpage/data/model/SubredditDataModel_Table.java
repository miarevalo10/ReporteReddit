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

public final class SubredditDataModel_Table extends ModelAdapter<SubredditDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, subredditId, name, displayName, displayNamePrefixed, iconImg, keyColor, bannerImg, headerImg, title, description, publicDescription, descriptionHtml, publicDescriptionHtml, subscribers, accountsActive, createdUtc, subredditType, url, over18, wikiEnabled, whitelistStatus, newModMailEnabled, submitType, allowImages, allowVideos, spoilersEnabled, userIsSubscriber, userIsModerator, userHasFavorited, updatedTimestampUtc};
    public static final Property<Long> accountsActive = new Property(SubredditDataModel.class, "accountsActive");
    public static final TypeConvertedProperty<Integer, Boolean> allowImages = new TypeConvertedProperty(SubredditDataModel.class, "allowImages", true, new C15273());
    public static final TypeConvertedProperty<Integer, Boolean> allowVideos = new TypeConvertedProperty(SubredditDataModel.class, "allowVideos", true, new C15284());
    public static final Property<String> bannerImg = new Property(SubredditDataModel.class, "bannerImg");
    public static final Property<Long> createdUtc = new Property(SubredditDataModel.class, "createdUtc");
    public static final Property<String> description = new Property(SubredditDataModel.class, "description");
    public static final Property<String> descriptionHtml = new Property(SubredditDataModel.class, "descriptionHtml");
    public static final Property<String> displayName = new Property(SubredditDataModel.class, "displayName");
    public static final Property<String> displayNamePrefixed = new Property(SubredditDataModel.class, "displayNamePrefixed");
    public static final Property<String> headerImg = new Property(SubredditDataModel.class, "headerImg");
    public static final Property<String> iconImg = new Property(SubredditDataModel.class, "iconImg");
    public static final Property<Long> id = new Property(SubredditDataModel.class, "id");
    public static final Property<String> keyColor = new Property(SubredditDataModel.class, "keyColor");
    public static final Property<String> name = new Property(SubredditDataModel.class, "name");
    public static final TypeConvertedProperty<Integer, Boolean> newModMailEnabled = new TypeConvertedProperty(SubredditDataModel.class, "newModMailEnabled", true, new C15262());
    public static final Property<Boolean> over18 = new Property(SubredditDataModel.class, "over18");
    public static final Property<String> publicDescription = new Property(SubredditDataModel.class, "publicDescription");
    public static final Property<String> publicDescriptionHtml = new Property(SubredditDataModel.class, "publicDescriptionHtml");
    public static final TypeConvertedProperty<Integer, Boolean> spoilersEnabled = new TypeConvertedProperty(SubredditDataModel.class, "spoilersEnabled", true, new C15295());
    public static final Property<String> submitType = new Property(SubredditDataModel.class, "submitType");
    public static final Property<String> subredditId = new Property(SubredditDataModel.class, "subredditId");
    public static final Property<String> subredditType = new Property(SubredditDataModel.class, "subredditType");
    public static final Property<Long> subscribers = new Property(SubredditDataModel.class, "subscribers");
    public static final Property<String> title = new Property(SubredditDataModel.class, "title");
    public static final Property<Long> updatedTimestampUtc = new Property(SubredditDataModel.class, "updatedTimestampUtc");
    public static final Property<String> url = new Property(SubredditDataModel.class, UpdateFragment.FRAGMENT_URL);
    public static final TypeConvertedProperty<Integer, Boolean> userHasFavorited = new TypeConvertedProperty(SubredditDataModel.class, "userHasFavorited", true, new C15328());
    public static final TypeConvertedProperty<Integer, Boolean> userIsModerator = new TypeConvertedProperty(SubredditDataModel.class, "userIsModerator", true, new C15317());
    public static final TypeConvertedProperty<Integer, Boolean> userIsSubscriber = new TypeConvertedProperty(SubredditDataModel.class, "userIsSubscriber", true, new C15306());
    public static final Property<String> whitelistStatus = new Property(SubredditDataModel.class, "whitelistStatus");
    public static final TypeConvertedProperty<Integer, Boolean> wikiEnabled = new TypeConvertedProperty(SubredditDataModel.class, "wikiEnabled", true, new C15251());
    private final BooleanConverter global_typeConverterBooleanConverter;

    static class C15251 implements TypeConverterGetter {
        C15251() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15262 implements TypeConverterGetter {
        C15262() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15273 implements TypeConverterGetter {
        C15273() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15284 implements TypeConverterGetter {
        C15284() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15295 implements TypeConverterGetter {
        C15295() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15306 implements TypeConverterGetter {
        C15306() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15317 implements TypeConverterGetter {
        C15317() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    static class C15328 implements TypeConverterGetter {
        C15328() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((SubredditDataModel_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `subreddit`(`id`,`subredditId`,`name`,`displayName`,`displayNamePrefixed`,`iconImg`,`keyColor`,`bannerImg`,`headerImg`,`title`,`description`,`publicDescription`,`descriptionHtml`,`publicDescriptionHtml`,`subscribers`,`accountsActive`,`createdUtc`,`subredditType`,`url`,`over18`,`wikiEnabled`,`whitelistStatus`,`newModMailEnabled`,`submitType`,`allowImages`,`allowVideos`,`spoilersEnabled`,`userIsSubscriber`,`userIsModerator`,`userHasFavorited`,`updatedTimestampUtc`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `subreddit`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `subredditId` TEXT UNIQUE ON CONFLICT REPLACE, `name` TEXT, `displayName` TEXT, `displayNamePrefixed` TEXT, `iconImg` TEXT, `keyColor` TEXT, `bannerImg` TEXT, `headerImg` TEXT, `title` TEXT, `description` TEXT, `publicDescription` TEXT, `descriptionHtml` TEXT, `publicDescriptionHtml` TEXT, `subscribers` INTEGER, `accountsActive` INTEGER, `createdUtc` INTEGER, `subredditType` TEXT, `url` TEXT, `over18` INTEGER, `wikiEnabled` INTEGER, `whitelistStatus` TEXT, `newModMailEnabled` INTEGER, `submitType` TEXT, `allowImages` INTEGER, `allowVideos` INTEGER, `spoilersEnabled` INTEGER, `userIsSubscriber` INTEGER, `userIsModerator` INTEGER, `userHasFavorited` INTEGER, `updatedTimestampUtc` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `subreddit` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `subreddit`(`subredditId`,`name`,`displayName`,`displayNamePrefixed`,`iconImg`,`keyColor`,`bannerImg`,`headerImg`,`title`,`description`,`publicDescription`,`descriptionHtml`,`publicDescriptionHtml`,`subscribers`,`accountsActive`,`createdUtc`,`subredditType`,`url`,`over18`,`wikiEnabled`,`whitelistStatus`,`newModMailEnabled`,`submitType`,`allowImages`,`allowVideos`,`spoilersEnabled`,`userIsSubscriber`,`userIsModerator`,`userHasFavorited`,`updatedTimestampUtc`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`subreddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `subreddit` SET `id`=?,`subredditId`=?,`name`=?,`displayName`=?,`displayNamePrefixed`=?,`iconImg`=?,`keyColor`=?,`bannerImg`=?,`headerImg`=?,`title`=?,`description`=?,`publicDescription`=?,`descriptionHtml`=?,`publicDescriptionHtml`=?,`subscribers`=?,`accountsActive`=?,`createdUtc`=?,`subredditType`=?,`url`=?,`over18`=?,`wikiEnabled`=?,`whitelistStatus`=?,`newModMailEnabled`=?,`submitType`=?,`allowImages`=?,`allowVideos`=?,`spoilersEnabled`=?,`userIsSubscriber`=?,`userIsModerator`=?,`userHasFavorited`=?,`updatedTimestampUtc`=? WHERE `id`=?";
    }

    public SubredditDataModel_Table(DatabaseHolder databaseHolder, DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
        this.global_typeConverterBooleanConverter = (BooleanConverter) databaseHolder.getTypeConverterForClass(Boolean.class);
    }

    public final Class<SubredditDataModel> getModelClass() {
        return SubredditDataModel.class;
    }

    public final SubredditDataModel newInstance() {
        return new SubredditDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2069049067: goto L_0x0164;
            case -1987812620: goto L_0x0159;
            case -1740642647: goto L_0x014f;
            case -1692789662: goto L_0x0144;
            case -1572445848: goto L_0x0139;
            case -1552966209: goto L_0x012e;
            case -1510852542: goto L_0x0124;
            case -1441983787: goto L_0x011a;
            case -1285278363: goto L_0x010f;
            case -1213508275: goto L_0x0104;
            case -982830620: goto L_0x00f8;
            case -947409208: goto L_0x00ec;
            case -797874189: goto L_0x00e1;
            case -747364985: goto L_0x00d6;
            case -449414450: goto L_0x00ca;
            case -40421177: goto L_0x00be;
            case -23237564: goto L_0x00b2;
            case -17551613: goto L_0x00a6;
            case 2964037: goto L_0x009b;
            case 92256561: goto L_0x008f;
            case 158412860: goto L_0x0084;
            case 449847440: goto L_0x0078;
            case 1167026904: goto L_0x006c;
            case 1268560266: goto L_0x0060;
            case 1282851039: goto L_0x0054;
            case 1554634713: goto L_0x0048;
            case 1728295279: goto L_0x003c;
            case 1732257511: goto L_0x0030;
            case 1836795824: goto L_0x0024;
            case 1839779190: goto L_0x0019;
            case 2014165207: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x016f;
    L_0x000d:
        r0 = "`updatedTimestampUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0015:
        r2 = 30;
        goto L_0x0170;
    L_0x0019:
        r0 = "`iconImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0021:
        r2 = 5;
        goto L_0x0170;
    L_0x0024:
        r0 = "`spoilersEnabled`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x002c:
        r2 = 26;
        goto L_0x0170;
    L_0x0030:
        r0 = "`userHasFavorited`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0038:
        r2 = 29;
        goto L_0x0170;
    L_0x003c:
        r0 = "`wikiEnabled`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0044:
        r2 = 20;
        goto L_0x0170;
    L_0x0048:
        r0 = "`descriptionHtml`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0050:
        r2 = 12;
        goto L_0x0170;
    L_0x0054:
        r0 = "`allowVideos`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x005c:
        r2 = 25;
        goto L_0x0170;
    L_0x0060:
        r0 = "`headerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0068:
        r2 = 8;
        goto L_0x0170;
    L_0x006c:
        r0 = "`newModMailEnabled`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0074:
        r2 = 22;
        goto L_0x0170;
    L_0x0078:
        r0 = "`userIsModerator`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0080:
        r2 = 28;
        goto L_0x0170;
    L_0x0084:
        r0 = "`keyColor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x008c:
        r2 = 6;
        goto L_0x0170;
    L_0x008f:
        r0 = "`url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0097:
        r2 = 18;
        goto L_0x0170;
    L_0x009b:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00a3:
        r2 = 0;
        goto L_0x0170;
    L_0x00a6:
        r0 = "`userIsSubscriber`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00ae:
        r2 = 27;
        goto L_0x0170;
    L_0x00b2:
        r0 = "`description`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00ba:
        r2 = 10;
        goto L_0x0170;
    L_0x00be:
        r0 = "`whitelistStatus`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00c6:
        r2 = 21;
        goto L_0x0170;
    L_0x00ca:
        r0 = "`submitType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00d2:
        r2 = 23;
        goto L_0x0170;
    L_0x00d6:
        r0 = "`subredditId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00de:
        r2 = 1;
        goto L_0x0170;
    L_0x00e1:
        r0 = "`displayName`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00e9:
        r2 = 3;
        goto L_0x0170;
    L_0x00ec:
        r0 = "`subredditType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x00f4:
        r2 = 17;
        goto L_0x0170;
    L_0x00f8:
        r0 = "`createdUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0100:
        r2 = 16;
        goto L_0x0170;
    L_0x0104:
        r0 = "`publicDescription`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x010c:
        r2 = 11;
        goto L_0x0170;
    L_0x010f:
        r0 = "`over18`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0117:
        r2 = 19;
        goto L_0x0170;
    L_0x011a:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0122:
        r2 = 2;
        goto L_0x0170;
    L_0x0124:
        r0 = "`displayNamePrefixed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x012c:
        r2 = 4;
        goto L_0x0170;
    L_0x012e:
        r0 = "`allowImages`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0136:
        r2 = 24;
        goto L_0x0170;
    L_0x0139:
        r0 = "`title`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0141:
        r2 = 9;
        goto L_0x0170;
    L_0x0144:
        r0 = "`publicDescriptionHtml`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x014c:
        r2 = 13;
        goto L_0x0170;
    L_0x014f:
        r0 = "`bannerImg`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0157:
        r2 = 7;
        goto L_0x0170;
    L_0x0159:
        r0 = "`accountsActive`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0161:
        r2 = 15;
        goto L_0x0170;
    L_0x0164:
        r0 = "`subscribers`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x016c:
        r2 = 14;
        goto L_0x0170;
    L_0x016f:
        r2 = -1;
    L_0x0170:
        switch(r2) {
            case 0: goto L_0x01d5;
            case 1: goto L_0x01d2;
            case 2: goto L_0x01cf;
            case 3: goto L_0x01cc;
            case 4: goto L_0x01c9;
            case 5: goto L_0x01c6;
            case 6: goto L_0x01c3;
            case 7: goto L_0x01c0;
            case 8: goto L_0x01bd;
            case 9: goto L_0x01ba;
            case 10: goto L_0x01b7;
            case 11: goto L_0x01b4;
            case 12: goto L_0x01b1;
            case 13: goto L_0x01ae;
            case 14: goto L_0x01ab;
            case 15: goto L_0x01a8;
            case 16: goto L_0x01a5;
            case 17: goto L_0x01a2;
            case 18: goto L_0x019f;
            case 19: goto L_0x019c;
            case 20: goto L_0x0199;
            case 21: goto L_0x0196;
            case 22: goto L_0x0193;
            case 23: goto L_0x0190;
            case 24: goto L_0x018d;
            case 25: goto L_0x018a;
            case 26: goto L_0x0187;
            case 27: goto L_0x0184;
            case 28: goto L_0x0181;
            case 29: goto L_0x017e;
            case 30: goto L_0x017b;
            default: goto L_0x0173;
        };
    L_0x0173:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x017b:
        r2 = updatedTimestampUtc;
        return r2;
    L_0x017e:
        r2 = userHasFavorited;
        return r2;
    L_0x0181:
        r2 = userIsModerator;
        return r2;
    L_0x0184:
        r2 = userIsSubscriber;
        return r2;
    L_0x0187:
        r2 = spoilersEnabled;
        return r2;
    L_0x018a:
        r2 = allowVideos;
        return r2;
    L_0x018d:
        r2 = allowImages;
        return r2;
    L_0x0190:
        r2 = submitType;
        return r2;
    L_0x0193:
        r2 = newModMailEnabled;
        return r2;
    L_0x0196:
        r2 = whitelistStatus;
        return r2;
    L_0x0199:
        r2 = wikiEnabled;
        return r2;
    L_0x019c:
        r2 = over18;
        return r2;
    L_0x019f:
        r2 = url;
        return r2;
    L_0x01a2:
        r2 = subredditType;
        return r2;
    L_0x01a5:
        r2 = createdUtc;
        return r2;
    L_0x01a8:
        r2 = accountsActive;
        return r2;
    L_0x01ab:
        r2 = subscribers;
        return r2;
    L_0x01ae:
        r2 = publicDescriptionHtml;
        return r2;
    L_0x01b1:
        r2 = descriptionHtml;
        return r2;
    L_0x01b4:
        r2 = publicDescription;
        return r2;
    L_0x01b7:
        r2 = description;
        return r2;
    L_0x01ba:
        r2 = title;
        return r2;
    L_0x01bd:
        r2 = headerImg;
        return r2;
    L_0x01c0:
        r2 = bannerImg;
        return r2;
    L_0x01c3:
        r2 = keyColor;
        return r2;
    L_0x01c6:
        r2 = iconImg;
        return r2;
    L_0x01c9:
        r2 = displayNamePrefixed;
        return r2;
    L_0x01cc:
        r2 = displayName;
        return r2;
    L_0x01cf:
        r2 = name;
        return r2;
    L_0x01d2:
        r2 = subredditId;
        return r2;
    L_0x01d5:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.SubredditDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(SubredditDataModel subredditDataModel, Number number) {
        subredditDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(SubredditDataModel subredditDataModel) {
        return Long.valueOf(subredditDataModel.getId());
    }

    public final ModelSaver<SubredditDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, SubredditDataModel subredditDataModel) {
        contentValues.put("`subredditId`", subredditDataModel.getSubredditId() != null ? subredditDataModel.getSubredditId() : "");
        contentValues.put("`name`", subredditDataModel.getName() != null ? subredditDataModel.getName() : "");
        contentValues.put("`displayName`", subredditDataModel.getDisplayName() != null ? subredditDataModel.getDisplayName() : "");
        contentValues.put("`displayNamePrefixed`", subredditDataModel.getDisplayNamePrefixed() != null ? subredditDataModel.getDisplayNamePrefixed() : "");
        contentValues.put("`iconImg`", subredditDataModel.getIconImg());
        contentValues.put("`keyColor`", subredditDataModel.getKeyColor() != null ? subredditDataModel.getKeyColor() : "");
        contentValues.put("`bannerImg`", subredditDataModel.getBannerImg());
        contentValues.put("`headerImg`", subredditDataModel.getHeaderImg());
        contentValues.put("`title`", subredditDataModel.getTitle());
        contentValues.put("`description`", subredditDataModel.getDescription() != null ? subredditDataModel.getDescription() : "");
        contentValues.put("`publicDescription`", subredditDataModel.getPublicDescription() != null ? subredditDataModel.getPublicDescription() : "");
        contentValues.put("`descriptionHtml`", subredditDataModel.getDescriptionHtml());
        contentValues.put("`publicDescriptionHtml`", subredditDataModel.getPublicDescriptionHtml());
        contentValues.put("`subscribers`", Long.valueOf(subredditDataModel.getSubscribers()));
        contentValues.put("`accountsActive`", subredditDataModel.getAccountsActive());
        contentValues.put("`createdUtc`", Long.valueOf(subredditDataModel.getCreatedUtc()));
        contentValues.put("`subredditType`", subredditDataModel.getSubredditType() != null ? subredditDataModel.getSubredditType() : "");
        contentValues.put("`url`", subredditDataModel.getUrl() != null ? subredditDataModel.getUrl() : "");
        contentValues.put("`over18`", Integer.valueOf(subredditDataModel.getOver18()));
        Integer num = null;
        contentValues.put("`wikiEnabled`", subredditDataModel.getWikiEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getWikiEnabled()) : null);
        contentValues.put("`whitelistStatus`", subredditDataModel.getWhitelistStatus());
        contentValues.put("`newModMailEnabled`", subredditDataModel.getNewModMailEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getNewModMailEnabled()) : null);
        contentValues.put("`submitType`", subredditDataModel.getSubmitType());
        contentValues.put("`allowImages`", subredditDataModel.getAllowImages() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowImages()) : null);
        contentValues.put("`allowVideos`", subredditDataModel.getAllowVideos() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowVideos()) : null);
        contentValues.put("`spoilersEnabled`", subredditDataModel.getSpoilersEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getSpoilersEnabled()) : null);
        contentValues.put("`userIsSubscriber`", subredditDataModel.getUserIsSubscriber() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsSubscriber()) : null);
        contentValues.put("`userIsModerator`", subredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsModerator()) : null);
        if (subredditDataModel.getUserHasFavorited() != null) {
            num = this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserHasFavorited());
        }
        contentValues.put("`userHasFavorited`", num);
        contentValues.put("`updatedTimestampUtc`", Long.valueOf(subredditDataModel.getUpdatedTimestampUtc()));
    }

    public final void bindToContentValues(ContentValues contentValues, SubredditDataModel subredditDataModel) {
        contentValues.put("`id`", Long.valueOf(subredditDataModel.getId()));
        bindToInsertValues(contentValues, subredditDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, SubredditDataModel subredditDataModel, int i) {
        if (subredditDataModel.getSubredditId() != null) {
            databaseStatement.bindString(1 + i, subredditDataModel.getSubredditId());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        if (subredditDataModel.getName() != null) {
            databaseStatement.bindString(2 + i, subredditDataModel.getName());
        } else {
            databaseStatement.bindString(2 + i, "");
        }
        if (subredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(3 + i, subredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(3 + i, "");
        }
        if (subredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(4 + i, subredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(4 + i, "");
        }
        databaseStatement.bindStringOrNull(5 + i, subredditDataModel.getIconImg());
        if (subredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(6 + i, subredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(6 + i, "");
        }
        databaseStatement.bindStringOrNull(7 + i, subredditDataModel.getBannerImg());
        databaseStatement.bindStringOrNull(8 + i, subredditDataModel.getHeaderImg());
        databaseStatement.bindStringOrNull(9 + i, subredditDataModel.getTitle());
        if (subredditDataModel.getDescription() != null) {
            databaseStatement.bindString(10 + i, subredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(10 + i, "");
        }
        if (subredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(11 + i, subredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(11 + i, "");
        }
        databaseStatement.bindStringOrNull(12 + i, subredditDataModel.getDescriptionHtml());
        databaseStatement.bindStringOrNull(13 + i, subredditDataModel.getPublicDescriptionHtml());
        databaseStatement.bindLong(14 + i, subredditDataModel.getSubscribers());
        databaseStatement.bindNumberOrNull(15 + i, subredditDataModel.getAccountsActive());
        databaseStatement.bindLong(16 + i, subredditDataModel.getCreatedUtc());
        if (subredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(17 + i, subredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(17 + i, "");
        }
        if (subredditDataModel.getUrl() != null) {
            databaseStatement.bindString(18 + i, subredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(18 + i, "");
        }
        databaseStatement.bindLong(19 + i, subredditDataModel.getOver18() ? 1 : 0);
        Number number = null;
        databaseStatement.bindNumberOrNull(20 + i, subredditDataModel.getWikiEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getWikiEnabled()) : null);
        databaseStatement.bindStringOrNull(21 + i, subredditDataModel.getWhitelistStatus());
        databaseStatement.bindNumberOrNull(22 + i, subredditDataModel.getNewModMailEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getNewModMailEnabled()) : null);
        databaseStatement.bindStringOrNull(23 + i, subredditDataModel.getSubmitType());
        databaseStatement.bindNumberOrNull(24 + i, subredditDataModel.getAllowImages() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowImages()) : null);
        databaseStatement.bindNumberOrNull(25 + i, subredditDataModel.getAllowVideos() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowVideos()) : null);
        databaseStatement.bindNumberOrNull(26 + i, subredditDataModel.getSpoilersEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getSpoilersEnabled()) : null);
        databaseStatement.bindNumberOrNull(27 + i, subredditDataModel.getUserIsSubscriber() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsSubscriber()) : null);
        databaseStatement.bindNumberOrNull(28 + i, subredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsModerator()) : null);
        if (subredditDataModel.getUserHasFavorited() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserHasFavorited());
        }
        databaseStatement.bindNumberOrNull(29 + i, number);
        databaseStatement.bindLong(30 + i, subredditDataModel.getUpdatedTimestampUtc());
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, SubredditDataModel subredditDataModel) {
        databaseStatement.bindLong(1, subredditDataModel.getId());
        bindToInsertStatement(databaseStatement, subredditDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, SubredditDataModel subredditDataModel) {
        databaseStatement.bindLong(1, subredditDataModel.getId());
        if (subredditDataModel.getSubredditId() != null) {
            databaseStatement.bindString(2, subredditDataModel.getSubredditId());
        } else {
            databaseStatement.bindString(2, "");
        }
        if (subredditDataModel.getName() != null) {
            databaseStatement.bindString(3, subredditDataModel.getName());
        } else {
            databaseStatement.bindString(3, "");
        }
        if (subredditDataModel.getDisplayName() != null) {
            databaseStatement.bindString(4, subredditDataModel.getDisplayName());
        } else {
            databaseStatement.bindString(4, "");
        }
        if (subredditDataModel.getDisplayNamePrefixed() != null) {
            databaseStatement.bindString(5, subredditDataModel.getDisplayNamePrefixed());
        } else {
            databaseStatement.bindString(5, "");
        }
        databaseStatement.bindStringOrNull(6, subredditDataModel.getIconImg());
        if (subredditDataModel.getKeyColor() != null) {
            databaseStatement.bindString(7, subredditDataModel.getKeyColor());
        } else {
            databaseStatement.bindString(7, "");
        }
        databaseStatement.bindStringOrNull(8, subredditDataModel.getBannerImg());
        databaseStatement.bindStringOrNull(9, subredditDataModel.getHeaderImg());
        databaseStatement.bindStringOrNull(10, subredditDataModel.getTitle());
        if (subredditDataModel.getDescription() != null) {
            databaseStatement.bindString(11, subredditDataModel.getDescription());
        } else {
            databaseStatement.bindString(11, "");
        }
        if (subredditDataModel.getPublicDescription() != null) {
            databaseStatement.bindString(12, subredditDataModel.getPublicDescription());
        } else {
            databaseStatement.bindString(12, "");
        }
        databaseStatement.bindStringOrNull(13, subredditDataModel.getDescriptionHtml());
        databaseStatement.bindStringOrNull(14, subredditDataModel.getPublicDescriptionHtml());
        databaseStatement.bindLong(15, subredditDataModel.getSubscribers());
        databaseStatement.bindNumberOrNull(16, subredditDataModel.getAccountsActive());
        databaseStatement.bindLong(17, subredditDataModel.getCreatedUtc());
        if (subredditDataModel.getSubredditType() != null) {
            databaseStatement.bindString(18, subredditDataModel.getSubredditType());
        } else {
            databaseStatement.bindString(18, "");
        }
        if (subredditDataModel.getUrl() != null) {
            databaseStatement.bindString(19, subredditDataModel.getUrl());
        } else {
            databaseStatement.bindString(19, "");
        }
        databaseStatement.bindLong(20, subredditDataModel.getOver18() ? 1 : 0);
        Number number = null;
        databaseStatement.bindNumberOrNull(21, subredditDataModel.getWikiEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getWikiEnabled()) : null);
        databaseStatement.bindStringOrNull(22, subredditDataModel.getWhitelistStatus());
        databaseStatement.bindNumberOrNull(23, subredditDataModel.getNewModMailEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getNewModMailEnabled()) : null);
        databaseStatement.bindStringOrNull(24, subredditDataModel.getSubmitType());
        databaseStatement.bindNumberOrNull(25, subredditDataModel.getAllowImages() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowImages()) : null);
        databaseStatement.bindNumberOrNull(26, subredditDataModel.getAllowVideos() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getAllowVideos()) : null);
        databaseStatement.bindNumberOrNull(27, subredditDataModel.getSpoilersEnabled() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getSpoilersEnabled()) : null);
        databaseStatement.bindNumberOrNull(28, subredditDataModel.getUserIsSubscriber() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsSubscriber()) : null);
        databaseStatement.bindNumberOrNull(29, subredditDataModel.getUserIsModerator() != null ? this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserIsModerator()) : null);
        if (subredditDataModel.getUserHasFavorited() != null) {
            number = this.global_typeConverterBooleanConverter.getDBValue(subredditDataModel.getUserHasFavorited());
        }
        databaseStatement.bindNumberOrNull(30, number);
        databaseStatement.bindLong(31, subredditDataModel.getUpdatedTimestampUtc());
        databaseStatement.bindLong(32, subredditDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, SubredditDataModel subredditDataModel) {
        databaseStatement.bindLong(1, subredditDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, SubredditDataModel subredditDataModel) {
        subredditDataModel.setId(flowCursor.getLongOrDefault("id"));
        subredditDataModel.setSubredditId(flowCursor.getStringOrDefault("subredditId", ""));
        subredditDataModel.setName(flowCursor.getStringOrDefault("name", ""));
        subredditDataModel.setDisplayName(flowCursor.getStringOrDefault("displayName", ""));
        subredditDataModel.setDisplayNamePrefixed(flowCursor.getStringOrDefault("displayNamePrefixed", ""));
        subredditDataModel.setIconImg(flowCursor.getStringOrDefault("iconImg"));
        subredditDataModel.setKeyColor(flowCursor.getStringOrDefault("keyColor", ""));
        subredditDataModel.setBannerImg(flowCursor.getStringOrDefault("bannerImg"));
        subredditDataModel.setHeaderImg(flowCursor.getStringOrDefault("headerImg"));
        subredditDataModel.setTitle(flowCursor.getStringOrDefault("title"));
        subredditDataModel.setDescription(flowCursor.getStringOrDefault("description", ""));
        subredditDataModel.setPublicDescription(flowCursor.getStringOrDefault("publicDescription", ""));
        subredditDataModel.setDescriptionHtml(flowCursor.getStringOrDefault("descriptionHtml"));
        subredditDataModel.setPublicDescriptionHtml(flowCursor.getStringOrDefault("publicDescriptionHtml"));
        subredditDataModel.setSubscribers(flowCursor.getLongOrDefault("subscribers"));
        subredditDataModel.setAccountsActive(flowCursor.getLongOrDefault("accountsActive", null));
        subredditDataModel.setCreatedUtc(flowCursor.getLongOrDefault("createdUtc"));
        subredditDataModel.setSubredditType(flowCursor.getStringOrDefault("subredditType", ""));
        subredditDataModel.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL, ""));
        int columnIndex = flowCursor.getColumnIndex("over18");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setOver18(false);
        } else {
            subredditDataModel.setOver18(flowCursor.getBoolean(columnIndex));
        }
        columnIndex = flowCursor.getColumnIndex("wikiEnabled");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setWikiEnabled(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setWikiEnabled(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        subredditDataModel.setWhitelistStatus(flowCursor.getStringOrDefault("whitelistStatus"));
        columnIndex = flowCursor.getColumnIndex("newModMailEnabled");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setNewModMailEnabled(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setNewModMailEnabled(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        subredditDataModel.setSubmitType(flowCursor.getStringOrDefault("submitType"));
        columnIndex = flowCursor.getColumnIndex("allowImages");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setAllowImages(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setAllowImages(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("allowVideos");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setAllowVideos(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setAllowVideos(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("spoilersEnabled");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setSpoilersEnabled(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setSpoilersEnabled(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("userIsSubscriber");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setUserIsSubscriber(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setUserIsSubscriber(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("userIsModerator");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setUserIsModerator(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setUserIsModerator(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        columnIndex = flowCursor.getColumnIndex("userHasFavorited");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            subredditDataModel.setUserHasFavorited(this.global_typeConverterBooleanConverter.getModelValue(null));
        } else {
            subredditDataModel.setUserHasFavorited(this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex))));
        }
        subredditDataModel.setUpdatedTimestampUtc(flowCursor.getLongOrDefault("updatedTimestampUtc"));
    }

    public final boolean exists(SubredditDataModel subredditDataModel, DatabaseWrapper databaseWrapper) {
        if (subredditDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(SubredditDataModel.class).where(getPrimaryConditionClause(subredditDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(SubredditDataModel subredditDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(subredditDataModel.getId())));
        return clause;
    }
}
