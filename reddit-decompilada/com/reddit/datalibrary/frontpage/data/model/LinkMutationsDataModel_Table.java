package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class LinkMutationsDataModel_Table extends ModelAdapter<LinkMutationsDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{linkId, isRead, readTimestampUtc, isHidden, isSaved};
    public static final Property<Boolean> isHidden = new Property(LinkMutationsDataModel.class, "isHidden");
    public static final Property<Boolean> isRead = new Property(LinkMutationsDataModel.class, "isRead");
    public static final Property<Boolean> isSaved = new Property(LinkMutationsDataModel.class, "isSaved");
    public static final Property<String> linkId = new Property(LinkMutationsDataModel.class, "linkId");
    public static final Property<Long> readTimestampUtc = new Property(LinkMutationsDataModel.class, "readTimestampUtc");

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `link_mutations`(`linkId`,`isRead`,`readTimestampUtc`,`isHidden`,`isSaved`) VALUES (?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `link_mutations`(`linkId` TEXT, `isRead` INTEGER, `readTimestampUtc` INTEGER, `isHidden` INTEGER, `isSaved` INTEGER, PRIMARY KEY(`linkId`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `link_mutations` WHERE `linkId`=?";
    }

    public final String getTableName() {
        return "`link_mutations`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `link_mutations` SET `linkId`=?,`isRead`=?,`readTimestampUtc`=?,`isHidden`=?,`isSaved`=? WHERE `linkId`=?";
    }

    public LinkMutationsDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<LinkMutationsDataModel> getModelClass() {
        return LinkMutationsDataModel.class;
    }

    public final LinkMutationsDataModel newInstance() {
        return new LinkMutationsDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -1952320285: goto L_0x0034;
            case -1858701540: goto L_0x002a;
            case -1352611060: goto L_0x0020;
            case -16873493: goto L_0x0016;
            case 1875860000: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x003e;
    L_0x000c:
        r0 = "`isRead`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0014:
        r2 = 1;
        goto L_0x003f;
    L_0x0016:
        r0 = "`linkId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x001e:
        r2 = 0;
        goto L_0x003f;
    L_0x0020:
        r0 = "`isHidden`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0028:
        r2 = 3;
        goto L_0x003f;
    L_0x002a:
        r0 = "`readTimestampUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0032:
        r2 = 2;
        goto L_0x003f;
    L_0x0034:
        r0 = "`isSaved`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x003c:
        r2 = 4;
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
        r2 = isSaved;
        return r2;
    L_0x004d:
        r2 = isHidden;
        return r2;
    L_0x0050:
        r2 = readTimestampUtc;
        return r2;
    L_0x0053:
        r2 = isRead;
        return r2;
    L_0x0056:
        r2 = linkId;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, LinkMutationsDataModel linkMutationsDataModel) {
        contentValues.put("`linkId`", linkMutationsDataModel.getLinkId() != null ? linkMutationsDataModel.getLinkId() : "");
        contentValues.put("`isRead`", Integer.valueOf(linkMutationsDataModel.isRead()));
        contentValues.put("`readTimestampUtc`", Long.valueOf(linkMutationsDataModel.getReadTimestampUtc()));
        contentValues.put("`isHidden`", Integer.valueOf(linkMutationsDataModel.isHidden()));
        contentValues.put("`isSaved`", Integer.valueOf(linkMutationsDataModel.isSaved()));
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, LinkMutationsDataModel linkMutationsDataModel, int i) {
        if (linkMutationsDataModel.getLinkId() != null) {
            databaseStatement.bindString(1 + i, linkMutationsDataModel.getLinkId());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        long j = 0;
        databaseStatement.bindLong(2 + i, linkMutationsDataModel.isRead() ? 1 : 0);
        databaseStatement.bindLong(3 + i, linkMutationsDataModel.getReadTimestampUtc());
        databaseStatement.bindLong(4 + i, linkMutationsDataModel.isHidden() ? 1 : 0);
        int i2 = 5 + i;
        if (linkMutationsDataModel.isSaved() != null) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, LinkMutationsDataModel linkMutationsDataModel) {
        if (linkMutationsDataModel.getLinkId() != null) {
            databaseStatement.bindString(1, linkMutationsDataModel.getLinkId());
        } else {
            databaseStatement.bindString(1, "");
        }
        long j = 0;
        databaseStatement.bindLong(2, linkMutationsDataModel.isRead() ? 1 : 0);
        databaseStatement.bindLong(3, linkMutationsDataModel.getReadTimestampUtc());
        databaseStatement.bindLong(4, linkMutationsDataModel.isHidden() ? 1 : 0);
        if (linkMutationsDataModel.isSaved()) {
            j = 1;
        }
        databaseStatement.bindLong(5, j);
        if (linkMutationsDataModel.getLinkId() != null) {
            databaseStatement.bindString(6, linkMutationsDataModel.getLinkId());
        } else {
            databaseStatement.bindString(6, "");
        }
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, LinkMutationsDataModel linkMutationsDataModel) {
        if (linkMutationsDataModel.getLinkId() != null) {
            databaseStatement.bindString(1, linkMutationsDataModel.getLinkId());
        } else {
            databaseStatement.bindString(1, "");
        }
    }

    public final void loadFromCursor(FlowCursor flowCursor, LinkMutationsDataModel linkMutationsDataModel) {
        linkMutationsDataModel.setLinkId(flowCursor.getStringOrDefault(0, linkMutationsDataModel.getLinkId()));
        if (!flowCursor.isNull(1)) {
            linkMutationsDataModel.setRead(flowCursor.getBoolean(1));
        }
        linkMutationsDataModel.setReadTimestampUtc(flowCursor.getLongOrDefault(2));
        if (!flowCursor.isNull(3)) {
            linkMutationsDataModel.setHidden(flowCursor.getBoolean(3));
        }
        if (!flowCursor.isNull(4)) {
            linkMutationsDataModel.setSaved(flowCursor.getBoolean(4));
        }
    }

    public final boolean exists(LinkMutationsDataModel linkMutationsDataModel, DatabaseWrapper databaseWrapper) {
        return SQLite.selectCountOf(new IProperty[0]).from(LinkMutationsDataModel.class).where(getPrimaryConditionClause(linkMutationsDataModel)).hasData(databaseWrapper);
    }

    public final OperatorGroup getPrimaryConditionClause(LinkMutationsDataModel linkMutationsDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(linkId.eq(linkMutationsDataModel.getLinkId()));
        return clause;
    }
}
