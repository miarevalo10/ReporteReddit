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

public final class MultiredditDataModel_Table extends ModelAdapter<MultiredditDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, name, editable, path, iconUrl, keyColor};
    public static final Property<Boolean> editable = new Property(MultiredditDataModel.class, "editable");
    public static final Property<String> iconUrl = new Property(MultiredditDataModel.class, "iconUrl");
    public static final Property<Long> id = new Property(MultiredditDataModel.class, "id");
    public static final Property<String> keyColor = new Property(MultiredditDataModel.class, "keyColor");
    public static final Property<String> name = new Property(MultiredditDataModel.class, "name");
    public static final Property<String> path = new Property(MultiredditDataModel.class, "path");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `multireddit`(`id`,`name`,`editable`,`path`,`iconUrl`,`keyColor`) VALUES (?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `multireddit`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT UNIQUE ON CONFLICT REPLACE, `editable` INTEGER, `path` TEXT, `iconUrl` TEXT, `keyColor` TEXT)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `multireddit` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `multireddit`(`name`,`editable`,`path`,`iconUrl`,`keyColor`) VALUES (?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`multireddit`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `multireddit` SET `id`=?,`name`=?,`editable`=?,`path`=?,`iconUrl`=?,`keyColor`=? WHERE `id`=?";
    }

    public MultiredditDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<MultiredditDataModel> getModelClass() {
        return MultiredditDataModel.class;
    }

    public final MultiredditDataModel newInstance() {
        return new MultiredditDataModel();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -1441983787: goto L_0x003e;
            case -1440129925: goto L_0x0034;
            case 2964037: goto L_0x002a;
            case 158412860: goto L_0x0020;
            case 744835612: goto L_0x0016;
            case 1840141642: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0048;
    L_0x000c:
        r0 = "`iconUrl`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0014:
        r2 = 4;
        goto L_0x0049;
    L_0x0016:
        r0 = "`editable`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x001e:
        r2 = 2;
        goto L_0x0049;
    L_0x0020:
        r0 = "`keyColor`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0028:
        r2 = 5;
        goto L_0x0049;
    L_0x002a:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0032:
        r2 = 0;
        goto L_0x0049;
    L_0x0034:
        r0 = "`path`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x003c:
        r2 = 3;
        goto L_0x0049;
    L_0x003e:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0046:
        r2 = 1;
        goto L_0x0049;
    L_0x0048:
        r2 = -1;
    L_0x0049:
        switch(r2) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0060;
            case 2: goto L_0x005d;
            case 3: goto L_0x005a;
            case 4: goto L_0x0057;
            case 5: goto L_0x0054;
            default: goto L_0x004c;
        };
    L_0x004c:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x0054:
        r2 = keyColor;
        return r2;
    L_0x0057:
        r2 = iconUrl;
        return r2;
    L_0x005a:
        r2 = path;
        return r2;
    L_0x005d:
        r2 = editable;
        return r2;
    L_0x0060:
        r2 = name;
        return r2;
    L_0x0063:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.model.MultiredditDataModel_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final void updateAutoIncrement(MultiredditDataModel multiredditDataModel, Number number) {
        multiredditDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(MultiredditDataModel multiredditDataModel) {
        return Long.valueOf(multiredditDataModel.getId());
    }

    public final ModelSaver<MultiredditDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, MultiredditDataModel multiredditDataModel) {
        contentValues.put("`name`", multiredditDataModel.getName() != null ? multiredditDataModel.getName() : "");
        contentValues.put("`editable`", Integer.valueOf(multiredditDataModel.getEditable()));
        contentValues.put("`path`", multiredditDataModel.getPath() != null ? multiredditDataModel.getPath() : "");
        contentValues.put("`iconUrl`", multiredditDataModel.getIconUrl());
        contentValues.put("`keyColor`", multiredditDataModel.getKeyColor());
    }

    public final void bindToContentValues(ContentValues contentValues, MultiredditDataModel multiredditDataModel) {
        contentValues.put("`id`", Long.valueOf(multiredditDataModel.getId()));
        bindToInsertValues(contentValues, multiredditDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, MultiredditDataModel multiredditDataModel, int i) {
        if (multiredditDataModel.getName() != null) {
            databaseStatement.bindString(1 + i, multiredditDataModel.getName());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        databaseStatement.bindLong(2 + i, multiredditDataModel.getEditable() ? 1 : 0);
        if (multiredditDataModel.getPath() != null) {
            databaseStatement.bindString(3 + i, multiredditDataModel.getPath());
        } else {
            databaseStatement.bindString(3 + i, "");
        }
        databaseStatement.bindStringOrNull(4 + i, multiredditDataModel.getIconUrl());
        databaseStatement.bindStringOrNull(5 + i, multiredditDataModel.getKeyColor());
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, MultiredditDataModel multiredditDataModel) {
        databaseStatement.bindLong(1, multiredditDataModel.getId());
        bindToInsertStatement(databaseStatement, multiredditDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, MultiredditDataModel multiredditDataModel) {
        databaseStatement.bindLong(1, multiredditDataModel.getId());
        if (multiredditDataModel.getName() != null) {
            databaseStatement.bindString(2, multiredditDataModel.getName());
        } else {
            databaseStatement.bindString(2, "");
        }
        databaseStatement.bindLong(3, multiredditDataModel.getEditable() ? 1 : 0);
        if (multiredditDataModel.getPath() != null) {
            databaseStatement.bindString(4, multiredditDataModel.getPath());
        } else {
            databaseStatement.bindString(4, "");
        }
        databaseStatement.bindStringOrNull(5, multiredditDataModel.getIconUrl());
        databaseStatement.bindStringOrNull(6, multiredditDataModel.getKeyColor());
        databaseStatement.bindLong(7, multiredditDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, MultiredditDataModel multiredditDataModel) {
        databaseStatement.bindLong(1, multiredditDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, MultiredditDataModel multiredditDataModel) {
        multiredditDataModel.setId(flowCursor.getLongOrDefault("id"));
        multiredditDataModel.setName(flowCursor.getStringOrDefault("name", ""));
        int columnIndex = flowCursor.getColumnIndex("editable");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            multiredditDataModel.setEditable(false);
        } else {
            multiredditDataModel.setEditable(flowCursor.getBoolean(columnIndex));
        }
        multiredditDataModel.setPath(flowCursor.getStringOrDefault("path", ""));
        multiredditDataModel.setIconUrl(flowCursor.getStringOrDefault("iconUrl"));
        multiredditDataModel.setKeyColor(flowCursor.getStringOrDefault("keyColor"));
    }

    public final boolean exists(MultiredditDataModel multiredditDataModel, DatabaseWrapper databaseWrapper) {
        if (multiredditDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(MultiredditDataModel.class).where(getPrimaryConditionClause(multiredditDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(MultiredditDataModel multiredditDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(multiredditDataModel.getId())));
        return clause;
    }
}
