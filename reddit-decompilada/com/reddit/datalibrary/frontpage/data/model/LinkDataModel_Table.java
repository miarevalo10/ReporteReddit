package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class LinkDataModel_Table extends ModelAdapter<LinkDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{listing_id, mutations_linkId, linkId, listingPosition, linkJson};
    public static final Property<String> linkId = new Property(LinkDataModel.class, "linkId");
    public static final Property<String> linkJson = new Property(LinkDataModel.class, "linkJson");
    public static final Property<Integer> listingPosition = new Property(LinkDataModel.class, "listingPosition");
    public static final Property<Long> listing_id = new Property(LinkDataModel.class, "listing_id");
    public static final Property<String> mutations_linkId = new Property(LinkDataModel.class, "mutations_linkId");

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `links`(`listing_id`,`mutations_linkId`,`linkId`,`listingPosition`,`linkJson`) VALUES (?,?,?,?,?)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `links` WHERE `listing_id`=? AND `linkId`=?";
    }

    public final String getTableName() {
        return "`links`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `links` SET `listing_id`=?,`mutations_linkId`=?,`linkId`=?,`listingPosition`=?,`linkJson`=? WHERE `listing_id`=? AND `linkId`=?";
    }

    public LinkDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<LinkDataModel> getModelClass() {
        return LinkDataModel.class;
    }

    public final LinkDataModel newInstance() {
        return new LinkDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -16873493: goto L_0x0034;
            case 100311562: goto L_0x002a;
            case 387761811: goto L_0x0020;
            case 965830718: goto L_0x0016;
            case 1727487894: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x003e;
    L_0x000c:
        r0 = "`mutations_linkId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0014:
        r2 = 1;
        goto L_0x003f;
    L_0x0016:
        r0 = "`linkJson`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x001e:
        r2 = 4;
        goto L_0x003f;
    L_0x0020:
        r0 = "`listingPosition`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0028:
        r2 = 3;
        goto L_0x003f;
    L_0x002a:
        r0 = "`listing_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003e;
    L_0x0032:
        r2 = 0;
        goto L_0x003f;
    L_0x0034:
        r0 = "`linkId`";
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
        r2 = linkJson;
        return r2;
    L_0x004d:
        r2 = listingPosition;
        return r2;
    L_0x0050:
        r2 = linkId;
        return r2;
    L_0x0053:
        r2 = mutations_linkId;
        return r2;
    L_0x0056:
        r2 = listing_id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.LinkDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, LinkDataModel linkDataModel) {
        if (linkDataModel.getListing() != null) {
            contentValues.put("`listing_id`", Long.valueOf(linkDataModel.getListing().getId()));
        } else {
            contentValues.putNull("`listing_id`");
        }
        if (linkDataModel.getMutations() != null) {
            contentValues.put("`mutations_linkId`", linkDataModel.getMutations().getLinkId());
        } else {
            contentValues.putNull("`mutations_linkId`");
        }
        contentValues.put("`linkId`", linkDataModel.getLinkId() != null ? linkDataModel.getLinkId() : "");
        contentValues.put("`listingPosition`", Integer.valueOf(linkDataModel.getListingPosition()));
        contentValues.put("`linkJson`", linkDataModel.getLinkJson() != null ? linkDataModel.getLinkJson() : "");
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, LinkDataModel linkDataModel, int i) {
        if (linkDataModel.getListing() != null) {
            databaseStatement.bindLong(1 + i, linkDataModel.getListing().getId());
        } else {
            databaseStatement.bindNull(1 + i);
        }
        if (linkDataModel.getMutations() != null) {
            databaseStatement.bindStringOrNull(2 + i, linkDataModel.getMutations().getLinkId());
        } else {
            databaseStatement.bindNull(2 + i);
        }
        if (linkDataModel.getLinkId() != null) {
            databaseStatement.bindString(3 + i, linkDataModel.getLinkId());
        } else {
            databaseStatement.bindString(3 + i, "");
        }
        databaseStatement.bindLong(4 + i, (long) linkDataModel.getListingPosition());
        if (linkDataModel.getLinkJson() != null) {
            databaseStatement.bindString(5 + i, linkDataModel.getLinkJson());
        } else {
            databaseStatement.bindString(5 + i, "");
        }
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, LinkDataModel linkDataModel) {
        if (linkDataModel.getListing() != null) {
            databaseStatement.bindLong(1, linkDataModel.getListing().getId());
        } else {
            databaseStatement.bindNull(1);
        }
        if (linkDataModel.getMutations() != null) {
            databaseStatement.bindStringOrNull(2, linkDataModel.getMutations().getLinkId());
        } else {
            databaseStatement.bindNull(2);
        }
        if (linkDataModel.getLinkId() != null) {
            databaseStatement.bindString(3, linkDataModel.getLinkId());
        } else {
            databaseStatement.bindString(3, "");
        }
        databaseStatement.bindLong(4, (long) linkDataModel.getListingPosition());
        if (linkDataModel.getLinkJson() != null) {
            databaseStatement.bindString(5, linkDataModel.getLinkJson());
        } else {
            databaseStatement.bindString(5, "");
        }
        if (linkDataModel.getListing() != null) {
            databaseStatement.bindLong(6, linkDataModel.getListing().getId());
        } else {
            databaseStatement.bindNull(6);
        }
        if (linkDataModel.getLinkId() != null) {
            databaseStatement.bindString(7, linkDataModel.getLinkId());
        } else {
            databaseStatement.bindString(7, "");
        }
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, LinkDataModel linkDataModel) {
        if (linkDataModel.getListing() != null) {
            databaseStatement.bindLong(1, linkDataModel.getListing().getId());
        } else {
            databaseStatement.bindNull(1);
        }
        if (linkDataModel.getLinkId() != null) {
            databaseStatement.bindString(2, linkDataModel.getLinkId());
        } else {
            databaseStatement.bindString(2, "");
        }
    }

    public final String getCreationQuery() {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS `links`(`listing_id` INTEGER, `mutations_linkId` TEXT, `linkId` TEXT, `listingPosition` INTEGER, `linkJson` TEXT, PRIMARY KEY(`listing_id`, `linkId`), FOREIGN KEY(`listing_id`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(ListingDataModel.class));
        stringBuilder.append("(`id`) ON UPDATE NO ACTION ON DELETE CASCADE, FOREIGN KEY(`mutations_linkId`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(LinkMutationsDataModel.class));
        stringBuilder.append("(`linkId`) ON UPDATE NO ACTION ON DELETE NO ACTION);");
        return stringBuilder.toString();
    }

    public final void loadFromCursor(FlowCursor flowCursor, LinkDataModel linkDataModel) {
        if (flowCursor.isNull(0)) {
            linkDataModel.setListing(null);
        } else {
            linkDataModel.setListing(new ListingDataModel());
            linkDataModel.getListing().setId(flowCursor.getLong(0));
        }
        if (flowCursor.isNull(1)) {
            linkDataModel.setMutations(null);
        } else {
            linkDataModel.setMutations((LinkMutationsDataModel) SQLite.select(new IProperty[0]).from(LinkMutationsDataModel.class).where(new SQLOperator[0]).and(LinkMutationsDataModel_Table.linkId.eq(flowCursor.getString(1))).querySingle());
        }
        linkDataModel.setLinkId(flowCursor.getStringOrDefault(2, linkDataModel.getLinkId()));
        linkDataModel.setListingPosition(flowCursor.getIntOrDefault(3));
        linkDataModel.setLinkJson(flowCursor.getStringOrDefault(4, linkDataModel.getLinkJson()));
    }

    public final boolean exists(LinkDataModel linkDataModel, DatabaseWrapper databaseWrapper) {
        return SQLite.selectCountOf(new IProperty[0]).from(LinkDataModel.class).where(getPrimaryConditionClause(linkDataModel)).hasData(databaseWrapper);
    }

    public final OperatorGroup getPrimaryConditionClause(LinkDataModel linkDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        if (linkDataModel.getListing() != null) {
            clause.and(listing_id.eq(Long.valueOf(linkDataModel.getListing().getId())));
        } else {
            clause.and(listing_id.eq(null));
        }
        clause.and(linkId.eq(linkDataModel.getLinkId()));
        return clause;
    }
}
