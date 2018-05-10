package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import net.hockeyapp.android.UpdateFragment;

public final class OutboundLink_Table extends ModelAdapter<OutboundLink> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{url, expiration, created};
    public static final Property<Long> created = new Property(OutboundLink.class, "created");
    public static final Property<Long> expiration = new Property(OutboundLink.class, "expiration");
    public static final Property<String> url = new Property(OutboundLink.class, UpdateFragment.FRAGMENT_URL);

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `outbound_link`(`url`,`expiration`,`created`) VALUES (?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `outbound_link`(`url` TEXT, `expiration` INTEGER, `created` INTEGER, PRIMARY KEY(`url`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `outbound_link` WHERE `url`=?";
    }

    public final String getTableName() {
        return "`outbound_link`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `outbound_link` SET `url`=?,`expiration`=?,`created`=? WHERE `url`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindStringOrNull(1, ((OutboundLink) obj).getUrl());
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        OutboundLink outboundLink = (OutboundLink) obj;
        databaseStatement.bindStringOrNull(1 + i, outboundLink.getUrl());
        databaseStatement.bindNumberOrNull(2 + i, outboundLink.getExpiration());
        databaseStatement.bindNumberOrNull(3 + i, outboundLink.getCreated());
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        OutboundLink outboundLink = (OutboundLink) obj;
        contentValues.put("`url`", outboundLink.getUrl());
        contentValues.put("`expiration`", outboundLink.getExpiration());
        contentValues.put("`created`", outboundLink.getCreated());
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        OutboundLink outboundLink = (OutboundLink) obj;
        databaseStatement.bindStringOrNull(1, outboundLink.getUrl());
        databaseStatement.bindNumberOrNull(2, outboundLink.getExpiration());
        databaseStatement.bindNumberOrNull(3, outboundLink.getCreated());
        databaseStatement.bindStringOrNull(4, outboundLink.getUrl());
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        OutboundLink outboundLink = (OutboundLink) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(OutboundLink.class).where(new SQLOperator[]{m36661a(outboundLink)}).hasData(databaseWrapper);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36661a((OutboundLink) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        OutboundLink outboundLink = (OutboundLink) obj;
        outboundLink.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL));
        outboundLink.setExpiration(flowCursor.getLongOrDefault("expiration", null));
        outboundLink.setCreated(flowCursor.getLongOrDefault("created", null));
    }

    public OutboundLink_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<OutboundLink> getModelClass() {
        return OutboundLink.class;
    }

    public final Property getProperty(String str) {
        str = QueryBuilder.quoteIfNeeded(str);
        int hashCode = str.hashCode();
        if (hashCode != -684585167) {
            if (hashCode != 92256561) {
                if (hashCode == 103481048) {
                    if (str.equals("`created`") != null) {
                        str = 2;
                        switch (str) {
                            case null:
                                return url;
                            case 1:
                                return expiration;
                            case 2:
                                return created;
                            default:
                                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                        }
                    }
                }
            } else if (str.equals("`url`") != null) {
                str = null;
                switch (str) {
                    case null:
                        return url;
                    case 1:
                        return expiration;
                    case 2:
                        return created;
                    default:
                        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                }
            }
        } else if (str.equals("`expiration`") != null) {
            str = true;
            switch (str) {
                case null:
                    return url;
                case 1:
                    return expiration;
                case 2:
                    return created;
                default:
                    throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
            }
        }
        str = -1;
        switch (str) {
            case null:
                return url;
            case 1:
                return expiration;
            case 2:
                return created;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    private static OperatorGroup m36661a(OutboundLink outboundLink) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(url.eq(outboundLink.getUrl()));
        return clause;
    }

    public final /* synthetic */ Object newInstance() {
        return new OutboundLink();
    }
}
