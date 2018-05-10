package com.reddit.datalibrary.frontpage.data.model;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.WrapperProperty;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;

public final class CommentDataModel_Table extends ModelAdapter<CommentDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{commentId, parentId, linkId, listingPosition, commentJson, type, sortType};
    public static final Property<String> commentId = new Property(CommentDataModel.class, "commentId");
    public static final Property<String> commentJson = new Property(CommentDataModel.class, "commentJson");
    public static final Property<String> linkId = new Property(CommentDataModel.class, "linkId");
    public static final Property<Integer> listingPosition = new Property(CommentDataModel.class, "listingPosition");
    public static final Property<String> parentId = new Property(CommentDataModel.class, "parentId");
    public static final WrapperProperty<String, CommentSortType> sortType = new WrapperProperty(CommentDataModel.class, "sortType");
    public static final WrapperProperty<String, CommentDataModelType> type = new WrapperProperty(CommentDataModel.class, "type");

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `comments`(`commentId`,`parentId`,`linkId`,`listingPosition`,`commentJson`,`type`,`sortType`) VALUES (?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `comments`(`commentId` TEXT, `parentId` TEXT, `linkId` TEXT, `listingPosition` INTEGER, `commentJson` TEXT, `type` TEXT, `sortType` TEXT, PRIMARY KEY(`commentId`, `sortType`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `comments` WHERE `commentId`=? AND `sortType`=?";
    }

    public final String getTableName() {
        return "`comments`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `comments` SET `commentId`=?,`parentId`=?,`linkId`=?,`listingPosition`=?,`commentJson`=?,`type`=?,`sortType`=? WHERE `commentId`=? AND `sortType`=?";
    }

    public CommentDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<CommentDataModel> getModelClass() {
        return CommentDataModel.class;
    }

    public final CommentDataModel newInstance() {
        return new CommentDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -1707364088: goto L_0x0048;
            case -1620679239: goto L_0x003e;
            case -1435724794: goto L_0x0034;
            case -16873493: goto L_0x002a;
            case 190490662: goto L_0x0020;
            case 384878907: goto L_0x0016;
            case 387761811: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0052;
    L_0x000c:
        r0 = "`listingPosition`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x0014:
        r2 = 3;
        goto L_0x0053;
    L_0x0016:
        r0 = "`parentId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x001e:
        r2 = 1;
        goto L_0x0053;
    L_0x0020:
        r0 = "`commentId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x0028:
        r2 = 0;
        goto L_0x0053;
    L_0x002a:
        r0 = "`linkId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x0032:
        r2 = 2;
        goto L_0x0053;
    L_0x0034:
        r0 = "`type`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x003c:
        r2 = 5;
        goto L_0x0053;
    L_0x003e:
        r0 = "`commentJson`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x0046:
        r2 = 4;
        goto L_0x0053;
    L_0x0048:
        r0 = "`sortType`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0052;
    L_0x0050:
        r2 = 6;
        goto L_0x0053;
    L_0x0052:
        r2 = -1;
    L_0x0053:
        switch(r2) {
            case 0: goto L_0x0070;
            case 1: goto L_0x006d;
            case 2: goto L_0x006a;
            case 3: goto L_0x0067;
            case 4: goto L_0x0064;
            case 5: goto L_0x0061;
            case 6: goto L_0x005e;
            default: goto L_0x0056;
        };
    L_0x0056:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x005e:
        r2 = sortType;
        return r2;
    L_0x0061:
        r2 = type;
        return r2;
    L_0x0064:
        r2 = commentJson;
        return r2;
    L_0x0067:
        r2 = listingPosition;
        return r2;
    L_0x006a:
        r2 = linkId;
        return r2;
    L_0x006d:
        r2 = parentId;
        return r2;
    L_0x0070:
        r2 = commentId;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.CommentDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, CommentDataModel commentDataModel) {
        contentValues.put("`commentId`", commentDataModel.getCommentId() != null ? commentDataModel.getCommentId() : "");
        contentValues.put("`parentId`", commentDataModel.getParentId());
        contentValues.put("`linkId`", commentDataModel.getLinkId());
        contentValues.put("`listingPosition`", Integer.valueOf(commentDataModel.getListingPosition()));
        contentValues.put("`commentJson`", commentDataModel.getCommentJson() != null ? commentDataModel.getCommentJson() : "");
        String str = null;
        contentValues.put("`type`", commentDataModel.getType() != null ? commentDataModel.getType().name() : null);
        if (commentDataModel.getSortType() != null) {
            str = commentDataModel.getSortType().name();
        }
        contentValues.put("`sortType`", str);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, CommentDataModel commentDataModel, int i) {
        if (commentDataModel.getCommentId() != null) {
            databaseStatement.bindString(1 + i, commentDataModel.getCommentId());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        databaseStatement.bindStringOrNull(2 + i, commentDataModel.getParentId());
        databaseStatement.bindStringOrNull(3 + i, commentDataModel.getLinkId());
        databaseStatement.bindLong(4 + i, (long) commentDataModel.getListingPosition());
        if (commentDataModel.getCommentJson() != null) {
            databaseStatement.bindString(5 + i, commentDataModel.getCommentJson());
        } else {
            databaseStatement.bindString(5 + i, "");
        }
        String str = null;
        databaseStatement.bindStringOrNull(6 + i, commentDataModel.getType() != null ? commentDataModel.getType().name() : null);
        if (commentDataModel.getSortType() != null) {
            str = commentDataModel.getSortType().name();
        }
        databaseStatement.bindStringOrNull(7 + i, str);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, CommentDataModel commentDataModel) {
        if (commentDataModel.getCommentId() != null) {
            databaseStatement.bindString(1, commentDataModel.getCommentId());
        } else {
            databaseStatement.bindString(1, "");
        }
        databaseStatement.bindStringOrNull(2, commentDataModel.getParentId());
        databaseStatement.bindStringOrNull(3, commentDataModel.getLinkId());
        databaseStatement.bindLong(4, (long) commentDataModel.getListingPosition());
        if (commentDataModel.getCommentJson() != null) {
            databaseStatement.bindString(5, commentDataModel.getCommentJson());
        } else {
            databaseStatement.bindString(5, "");
        }
        String str = null;
        databaseStatement.bindStringOrNull(6, commentDataModel.getType() != null ? commentDataModel.getType().name() : null);
        if (commentDataModel.getSortType() != null) {
            str = commentDataModel.getSortType().name();
        }
        databaseStatement.bindStringOrNull(7, str);
        if (commentDataModel.getCommentId() != null) {
            databaseStatement.bindString(8, commentDataModel.getCommentId());
        } else {
            databaseStatement.bindString(8, "");
        }
        databaseStatement.bindStringOrNull(9, str);
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, CommentDataModel commentDataModel) {
        if (commentDataModel.getCommentId() != null) {
            databaseStatement.bindString(1, commentDataModel.getCommentId());
        } else {
            databaseStatement.bindString(1, "");
        }
        databaseStatement.bindStringOrNull(2, commentDataModel.getSortType() != null ? commentDataModel.getSortType().name() : null);
    }

    public final void loadFromCursor(com.raizlabs.android.dbflow.structure.database.FlowCursor r5, com.reddit.datalibrary.frontpage.data.model.CommentDataModel r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "commentId";
        r1 = "";
        r0 = r5.getStringOrDefault(r0, r1);
        r6.setCommentId(r0);
        r0 = "parentId";
        r0 = r5.getStringOrDefault(r0);
        r6.setParentId(r0);
        r0 = "linkId";
        r0 = r5.getStringOrDefault(r0);
        r6.setLinkId(r0);
        r0 = "listingPosition";
        r0 = r5.getIntOrDefault(r0);
        r6.setListingPosition(r0);
        r0 = "commentJson";
        r1 = "";
        r0 = r5.getStringOrDefault(r0, r1);
        r6.setCommentJson(r0);
        r0 = "type";
        r0 = r5.getColumnIndex(r0);
        r1 = 0;
        r2 = -1;
        if (r0 == r2) goto L_0x0050;
    L_0x003b:
        r3 = r5.isNull(r0);
        if (r3 != 0) goto L_0x0050;
    L_0x0041:
        r0 = r5.getString(r0);	 Catch:{ IllegalArgumentException -> 0x004d }
        r0 = com.reddit.datalibrary.frontpage.data.model.CommentDataModelType.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x004d }
        r6.setType(r0);	 Catch:{ IllegalArgumentException -> 0x004d }
        goto L_0x0050;
    L_0x004d:
        r6.setType(r1);
    L_0x0050:
        r0 = "sortType";
        r0 = r5.getColumnIndex(r0);
        if (r0 == r2) goto L_0x006a;
    L_0x0058:
        r2 = r5.isNull(r0);
        if (r2 != 0) goto L_0x006a;
    L_0x005e:
        r5 = r5.getString(r0);	 Catch:{ IllegalArgumentException -> 0x006a }
        r5 = com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType.valueOf(r5);	 Catch:{ IllegalArgumentException -> 0x006a }
        r6.setSortType(r5);	 Catch:{ IllegalArgumentException -> 0x006a }
        return;
    L_0x006a:
        r6.setSortType(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.CommentDataModel_Table.loadFromCursor(com.raizlabs.android.dbflow.structure.database.FlowCursor, com.reddit.datalibrary.frontpage.data.model.CommentDataModel):void");
    }

    public final boolean exists(CommentDataModel commentDataModel, DatabaseWrapper databaseWrapper) {
        return SQLite.selectCountOf(new IProperty[0]).from(CommentDataModel.class).where(getPrimaryConditionClause(commentDataModel)).hasData(databaseWrapper);
    }

    public final OperatorGroup getPrimaryConditionClause(CommentDataModel commentDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(commentId.eq(commentDataModel.getCommentId()));
        clause.and(sortType.invertProperty().eq(commentDataModel.getSortType() != null ? commentDataModel.getSortType().name() : null));
        return clause;
    }
}
