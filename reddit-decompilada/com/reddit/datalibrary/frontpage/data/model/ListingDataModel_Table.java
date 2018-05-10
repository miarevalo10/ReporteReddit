package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.WrapperProperty;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.common.ListingType;

public final class ListingDataModel_Table extends ModelAdapter<ListingDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, sort, sortTimeFrame, before, after, adDistance, username, listingType};
    public static final Property<String> adDistance = new Property(ListingDataModel.class, "adDistance");
    public static final Property<String> after = new Property(ListingDataModel.class, "after");
    public static final Property<String> before = new Property(ListingDataModel.class, "before");
    public static final Property<Long> id = new Property(ListingDataModel.class, "id");
    public static final WrapperProperty<String, ListingType> listingType = new WrapperProperty(ListingDataModel.class, "listingType");
    public static final WrapperProperty<String, SortType> sort = new WrapperProperty(ListingDataModel.class, "sort");
    public static final WrapperProperty<String, SortTimeFrame> sortTimeFrame = new WrapperProperty(ListingDataModel.class, "sortTimeFrame");
    public static final Property<String> username = new Property(ListingDataModel.class, "username");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `listing`(`id`,`sort`,`sortTimeFrame`,`before`,`after`,`adDistance`,`username`,`listingType`) VALUES (?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `listing`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `sort` TEXT, `sortTimeFrame` TEXT, `before` TEXT, `after` TEXT, `adDistance` TEXT, `username` TEXT, `listingType` TEXT, UNIQUE(`sort`,`sortTimeFrame`,`before`,`after`,`adDistance`,`username`,`listingType`) ON CONFLICT ABORT)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `listing` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `listing`(`sort`,`sortTimeFrame`,`before`,`after`,`adDistance`,`username`,`listingType`) VALUES (?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`listing`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `listing` SET `id`=?,`sort`=?,`sortTimeFrame`=?,`before`=?,`after`=?,`adDistance`=?,`username`=?,`listingType`=? WHERE `id`=?";
    }

    public ListingDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<ListingDataModel> getModelClass() {
        return ListingDataModel.class;
    }

    public final ListingDataModel newInstance() {
        return new ListingDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2119176604: goto L_0x0052;
            case -1436943838: goto L_0x0048;
            case -1332609558: goto L_0x003e;
            case -1194979166: goto L_0x0034;
            case -423721887: goto L_0x002a;
            case 2964037: goto L_0x0020;
            case 138244702: goto L_0x0016;
            case 1181221320: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x005c;
    L_0x000c:
        r0 = "`adDistance`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0014:
        r2 = 5;
        goto L_0x005d;
    L_0x0016:
        r0 = "`sortTimeFrame`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x001e:
        r2 = 2;
        goto L_0x005d;
    L_0x0020:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0028:
        r2 = 0;
        goto L_0x005d;
    L_0x002a:
        r0 = "`before`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0032:
        r2 = 3;
        goto L_0x005d;
    L_0x0034:
        r0 = "`listingType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x003c:
        r2 = 7;
        goto L_0x005d;
    L_0x003e:
        r0 = "`username`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0046:
        r2 = 6;
        goto L_0x005d;
    L_0x0048:
        r0 = "`sort`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x005c;
    L_0x0050:
        r2 = 1;
        goto L_0x005d;
    L_0x0052:
        r0 = "`after`";
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
        r2 = listingType;
        return r2;
    L_0x006b:
        r2 = username;
        return r2;
    L_0x006e:
        r2 = adDistance;
        return r2;
    L_0x0071:
        r2 = after;
        return r2;
    L_0x0074:
        r2 = before;
        return r2;
    L_0x0077:
        r2 = sortTimeFrame;
        return r2;
    L_0x007a:
        r2 = sort;
        return r2;
    L_0x007d:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.ListingDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(ListingDataModel listingDataModel, Number number) {
        listingDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(ListingDataModel listingDataModel) {
        return Long.valueOf(listingDataModel.getId());
    }

    public final ModelSaver<ListingDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, ListingDataModel listingDataModel) {
        String str = null;
        contentValues.put("`sort`", listingDataModel.getSort() != null ? listingDataModel.getSort().name() : null);
        contentValues.put("`sortTimeFrame`", listingDataModel.getSortTimeFrame() != null ? listingDataModel.getSortTimeFrame().name() : null);
        contentValues.put("`before`", listingDataModel.getBefore());
        contentValues.put("`after`", listingDataModel.getAfter());
        contentValues.put("`adDistance`", listingDataModel.getAdDistance());
        contentValues.put("`username`", listingDataModel.getUsername());
        if (listingDataModel.getListingType() != null) {
            str = listingDataModel.getListingType().name();
        }
        contentValues.put("`listingType`", str);
    }

    public final void bindToContentValues(ContentValues contentValues, ListingDataModel listingDataModel) {
        contentValues.put("`id`", Long.valueOf(listingDataModel.getId()));
        bindToInsertValues(contentValues, listingDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, ListingDataModel listingDataModel, int i) {
        String str = null;
        databaseStatement.bindStringOrNull(1 + i, listingDataModel.getSort() != null ? listingDataModel.getSort().name() : null);
        databaseStatement.bindStringOrNull(2 + i, listingDataModel.getSortTimeFrame() != null ? listingDataModel.getSortTimeFrame().name() : null);
        databaseStatement.bindStringOrNull(3 + i, listingDataModel.getBefore());
        databaseStatement.bindStringOrNull(4 + i, listingDataModel.getAfter());
        databaseStatement.bindStringOrNull(5 + i, listingDataModel.getAdDistance());
        databaseStatement.bindStringOrNull(6 + i, listingDataModel.getUsername());
        if (listingDataModel.getListingType() != null) {
            str = listingDataModel.getListingType().name();
        }
        databaseStatement.bindStringOrNull(7 + i, str);
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, ListingDataModel listingDataModel) {
        databaseStatement.bindLong(1, listingDataModel.getId());
        bindToInsertStatement(databaseStatement, listingDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, ListingDataModel listingDataModel) {
        databaseStatement.bindLong(1, listingDataModel.getId());
        String str = null;
        databaseStatement.bindStringOrNull(2, listingDataModel.getSort() != null ? listingDataModel.getSort().name() : null);
        databaseStatement.bindStringOrNull(3, listingDataModel.getSortTimeFrame() != null ? listingDataModel.getSortTimeFrame().name() : null);
        databaseStatement.bindStringOrNull(4, listingDataModel.getBefore());
        databaseStatement.bindStringOrNull(5, listingDataModel.getAfter());
        databaseStatement.bindStringOrNull(6, listingDataModel.getAdDistance());
        databaseStatement.bindStringOrNull(7, listingDataModel.getUsername());
        if (listingDataModel.getListingType() != null) {
            str = listingDataModel.getListingType().name();
        }
        databaseStatement.bindStringOrNull(8, str);
        databaseStatement.bindLong(9, listingDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, ListingDataModel listingDataModel) {
        databaseStatement.bindLong(1, listingDataModel.getId());
    }

    public final void loadFromCursor(com.raizlabs.android.dbflow.structure.database.FlowCursor r5, com.reddit.datalibrary.frontpage.data.model.ListingDataModel r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = "id";
        r0 = r5.getLongOrDefault(r0);
        r6.setId(r0);
        r0 = "sort";
        r0 = r5.getColumnIndex(r0);
        r1 = 0;
        r2 = -1;
        if (r0 == r2) goto L_0x0025;
    L_0x0013:
        r3 = r5.isNull(r0);
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        r0 = r5.getString(r0);	 Catch:{ IllegalArgumentException -> 0x0025 }
        r0 = com.reddit.datalibrary.frontpage.data.feature.common.SortType.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x0025 }
        r6.setSort(r0);	 Catch:{ IllegalArgumentException -> 0x0025 }
        goto L_0x0028;
    L_0x0025:
        r6.setSort(r1);
    L_0x0028:
        r0 = "sortTimeFrame";
        r0 = r5.getColumnIndex(r0);
        if (r0 == r2) goto L_0x0042;
    L_0x0030:
        r3 = r5.isNull(r0);
        if (r3 != 0) goto L_0x0042;
    L_0x0036:
        r0 = r5.getString(r0);	 Catch:{ IllegalArgumentException -> 0x0042 }
        r0 = com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x0042 }
        r6.setSortTimeFrame(r0);	 Catch:{ IllegalArgumentException -> 0x0042 }
        goto L_0x0045;
    L_0x0042:
        r6.setSortTimeFrame(r1);
    L_0x0045:
        r0 = "before";
        r0 = r5.getStringOrDefault(r0);
        r6.setBefore(r0);
        r0 = "after";
        r0 = r5.getStringOrDefault(r0);
        r6.setAfter(r0);
        r0 = "adDistance";
        r0 = r5.getStringOrDefault(r0);
        r6.setAdDistance(r0);
        r0 = "username";
        r0 = r5.getStringOrDefault(r0);
        r6.setUsername(r0);
        r0 = "listingType";
        r0 = r5.getColumnIndex(r0);
        if (r0 == r2) goto L_0x0086;
    L_0x0071:
        r2 = r5.isNull(r0);
        if (r2 != 0) goto L_0x0086;
    L_0x0077:
        r5 = r5.getString(r0);	 Catch:{ IllegalArgumentException -> 0x0083 }
        r5 = com.reddit.frontpage.presentation.listing.common.ListingType.valueOf(r5);	 Catch:{ IllegalArgumentException -> 0x0083 }
        r6.setListingType(r5);	 Catch:{ IllegalArgumentException -> 0x0083 }
        goto L_0x0086;
    L_0x0083:
        r6.setListingType(r1);
    L_0x0086:
        r6.getLinks();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.ListingDataModel_Table.loadFromCursor(com.raizlabs.android.dbflow.structure.database.FlowCursor, com.reddit.datalibrary.frontpage.data.model.ListingDataModel):void");
    }

    public final boolean exists(ListingDataModel listingDataModel, DatabaseWrapper databaseWrapper) {
        if (listingDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(ListingDataModel.class).where(getPrimaryConditionClause(listingDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(ListingDataModel listingDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(listingDataModel.getId())));
        return clause;
    }

    public final boolean delete(ListingDataModel listingDataModel) {
        boolean delete = super.delete(listingDataModel);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).deleteAll(listingDataModel.getLinks());
        }
        listingDataModel.setLinks(null);
        return delete;
    }

    public final boolean delete(ListingDataModel listingDataModel, DatabaseWrapper databaseWrapper) {
        boolean delete = super.delete(listingDataModel, databaseWrapper);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).deleteAll(listingDataModel.getLinks(), databaseWrapper);
        }
        listingDataModel.setLinks(null);
        return delete;
    }

    public final boolean save(ListingDataModel listingDataModel) {
        boolean save = super.save(listingDataModel);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).saveAll(listingDataModel.getLinks());
        }
        return save;
    }

    public final long insert(ListingDataModel listingDataModel) {
        long insert = super.insert(listingDataModel);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).insertAll(listingDataModel.getLinks());
        }
        return insert;
    }

    public final boolean update(ListingDataModel listingDataModel) {
        boolean update = super.update(listingDataModel);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).updateAll(listingDataModel.getLinks());
        }
        return update;
    }

    public final boolean save(ListingDataModel listingDataModel, DatabaseWrapper databaseWrapper) {
        boolean save = super.save(listingDataModel, databaseWrapper);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).saveAll(listingDataModel.getLinks(), databaseWrapper);
        }
        return save;
    }

    public final long insert(ListingDataModel listingDataModel, DatabaseWrapper databaseWrapper) {
        long insert = super.insert(listingDataModel, databaseWrapper);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).insertAll(listingDataModel.getLinks(), databaseWrapper);
        }
        return insert;
    }

    public final boolean update(ListingDataModel listingDataModel, DatabaseWrapper databaseWrapper) {
        boolean update = super.update(listingDataModel, databaseWrapper);
        if (listingDataModel.getLinks() != null) {
            FlowManager.getModelAdapter(LinkDataModel.class).updateAll(listingDataModel.getLinks(), databaseWrapper);
        }
        return update;
    }
}
