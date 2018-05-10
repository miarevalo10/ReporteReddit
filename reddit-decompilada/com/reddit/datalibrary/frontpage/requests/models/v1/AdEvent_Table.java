package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import net.hockeyapp.android.UpdateFragment;

public final class AdEvent_Table extends ModelAdapter<AdEvent> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{url, type};
    public static final Property<Integer> type = new Property(AdEvent.class, "type");
    public static final Property<String> url = new Property(AdEvent.class, UpdateFragment.FRAGMENT_URL);

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `ad_event`(`url`,`type`) VALUES (?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `ad_event`(`url` TEXT, `type` INTEGER, PRIMARY KEY(`url`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `ad_event` WHERE `url`=?";
    }

    public final String getTableName() {
        return "`ad_event`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `ad_event` SET `url`=?,`type`=? WHERE `url`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindStringOrNull(1, ((AdEvent) obj).getUrl());
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        AdEvent adEvent = (AdEvent) obj;
        databaseStatement.bindStringOrNull(1 + i, adEvent.getUrl());
        databaseStatement.bindLong(2 + i, (long) adEvent.getType());
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        AdEvent adEvent = (AdEvent) obj;
        contentValues.put("`url`", adEvent.getUrl());
        contentValues.put("`type`", Integer.valueOf(adEvent.getType()));
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        AdEvent adEvent = (AdEvent) obj;
        databaseStatement.bindStringOrNull(1, adEvent.getUrl());
        databaseStatement.bindLong(2, (long) adEvent.getType());
        databaseStatement.bindStringOrNull(3, adEvent.getUrl());
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        AdEvent adEvent = (AdEvent) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(AdEvent.class).where(m20724a(adEvent)).hasData(databaseWrapper);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m20724a((AdEvent) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        AdEvent adEvent = (AdEvent) obj;
        adEvent.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL));
        adEvent.setType(flowCursor.getIntOrDefault("type"));
    }

    public AdEvent_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<AdEvent> getModelClass() {
        return AdEvent.class;
    }

    public final Property getProperty(String str) {
        str = QueryBuilder.quoteIfNeeded(str);
        int hashCode = str.hashCode();
        if (hashCode != -1435724794) {
            if (hashCode == 92256561) {
                if (str.equals("`url`") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            return url;
                        case 1:
                            return type;
                        default:
                            throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                    }
                }
            }
        } else if (str.equals("`type`") != null) {
            str = true;
            switch (str) {
                case null:
                    return url;
                case 1:
                    return type;
                default:
                    throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
            }
        }
        str = -1;
        switch (str) {
            case null:
                return url;
            case 1:
                return type;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    private static OperatorGroup m20724a(AdEvent adEvent) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(url.eq(adEvent.getUrl()));
        return clause;
    }

    public final /* synthetic */ Object newInstance() {
        return new AdEvent();
    }
}
