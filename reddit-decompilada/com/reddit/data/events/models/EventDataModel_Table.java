package com.reddit.data.events.models;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
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
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class EventDataModel_Table extends ModelAdapter<EventDataModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, timestamp, event, dispatched};
    public static final Property<Boolean> dispatched = new Property(EventDataModel.class, "dispatched");
    public static final WrapperProperty<byte[], Blob> event = new WrapperProperty(EventDataModel.class, "event");
    public static final Property<Long> id = new Property(EventDataModel.class, "id");
    public static final Property<Long> timestamp = new Property(EventDataModel.class, "timestamp");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `event`(`id`,`timestamp`,`event`,`dispatched`) VALUES (?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `event`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER, `event` BLOB, `dispatched` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `event` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `event`(`timestamp`,`event`,`dispatched`) VALUES (?,?,?)";
    }

    public final String getTableName() {
        return "`event`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `event` SET `id`=?,`timestamp`=?,`event`=?,`dispatched`=? WHERE `id`=?";
    }

    public EventDataModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<EventDataModel> getModelClass() {
        return EventDataModel.class;
    }

    public final EventDataModel newInstance() {
        return new EventDataModel();
    }

    public final Property getProperty(String str) {
        str = QueryBuilder.quoteIfNeeded(str);
        int hashCode = str.hashCode();
        if (hashCode != -1990321818) {
            if (hashCode != 2964037) {
                if (hashCode != 572996743) {
                    if (hashCode == 1000276586) {
                        if (str.equals("`timestamp`") != null) {
                            str = true;
                            switch (str) {
                                case null:
                                    return id;
                                case 1:
                                    return timestamp;
                                case 2:
                                    return event;
                                case 3:
                                    return dispatched;
                                default:
                                    throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                            }
                        }
                    }
                } else if (str.equals("`dispatched`") != null) {
                    str = 3;
                    switch (str) {
                        case null:
                            return id;
                        case 1:
                            return timestamp;
                        case 2:
                            return event;
                        case 3:
                            return dispatched;
                        default:
                            throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                    }
                }
            } else if (str.equals("`id`") != null) {
                str = null;
                switch (str) {
                    case null:
                        return id;
                    case 1:
                        return timestamp;
                    case 2:
                        return event;
                    case 3:
                        return dispatched;
                    default:
                        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                }
            }
        } else if (str.equals("`event`") != null) {
            str = 2;
            switch (str) {
                case null:
                    return id;
                case 1:
                    return timestamp;
                case 2:
                    return event;
                case 3:
                    return dispatched;
                default:
                    throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
            }
        }
        str = -1;
        switch (str) {
            case null:
                return id;
            case 1:
                return timestamp;
            case 2:
                return event;
            case 3:
                return dispatched;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    public final void updateAutoIncrement(EventDataModel eventDataModel, Number number) {
        eventDataModel.setId(number.longValue());
    }

    public final Number getAutoIncrementingId(EventDataModel eventDataModel) {
        return Long.valueOf(eventDataModel.getId());
    }

    public final ModelSaver<EventDataModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final void bindToInsertValues(ContentValues contentValues, EventDataModel eventDataModel) {
        contentValues.put("`timestamp`", Long.valueOf(eventDataModel.getTimestamp()));
        contentValues.put("`event`", eventDataModel.getEvent() != null ? eventDataModel.getEvent().getBlob() : null);
        contentValues.put("`dispatched`", Integer.valueOf(eventDataModel.getDispatched()));
    }

    public final void bindToContentValues(ContentValues contentValues, EventDataModel eventDataModel) {
        contentValues.put("`id`", Long.valueOf(eventDataModel.getId()));
        bindToInsertValues(contentValues, eventDataModel);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, EventDataModel eventDataModel, int i) {
        databaseStatement.bindLong(1 + i, eventDataModel.getTimestamp());
        databaseStatement.bindBlobOrNull(2 + i, eventDataModel.getEvent() != null ? eventDataModel.getEvent().getBlob() : null);
        databaseStatement.bindLong(3 + i, eventDataModel.getDispatched() != null ? true : 0);
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, EventDataModel eventDataModel) {
        databaseStatement.bindLong(1, eventDataModel.getId());
        bindToInsertStatement(databaseStatement, eventDataModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, EventDataModel eventDataModel) {
        databaseStatement.bindLong(1, eventDataModel.getId());
        databaseStatement.bindLong(2, eventDataModel.getTimestamp());
        databaseStatement.bindBlobOrNull(3, eventDataModel.getEvent() != null ? eventDataModel.getEvent().getBlob() : null);
        databaseStatement.bindLong(4, eventDataModel.getDispatched() ? 1 : 0);
        databaseStatement.bindLong(5, eventDataModel.getId());
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, EventDataModel eventDataModel) {
        databaseStatement.bindLong(1, eventDataModel.getId());
    }

    public final void loadFromCursor(FlowCursor flowCursor, EventDataModel eventDataModel) {
        eventDataModel.setId(flowCursor.getLongOrDefault("id"));
        eventDataModel.setTimestamp(flowCursor.getLongOrDefault("timestamp"));
        int columnIndex = flowCursor.getColumnIndex("event");
        if (!(columnIndex == -1 || flowCursor.isNull(columnIndex))) {
            eventDataModel.setEvent(new Blob(flowCursor.getBlob(columnIndex)));
        }
        columnIndex = flowCursor.getColumnIndex("dispatched");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            eventDataModel.setDispatched(null);
        } else {
            eventDataModel.setDispatched(flowCursor.getBoolean(columnIndex));
        }
    }

    public final boolean exists(EventDataModel eventDataModel, DatabaseWrapper databaseWrapper) {
        if (eventDataModel.getId() > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(EventDataModel.class).where(getPrimaryConditionClause(eventDataModel)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final OperatorGroup getPrimaryConditionClause(EventDataModel eventDataModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Long.valueOf(eventDataModel.getId())));
        return clause;
    }
}
