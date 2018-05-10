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

public final class ImageResolution_Table extends ModelAdapter<ImageResolution> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{url, width, height};
    public static final Property<Integer> height = new Property(ImageResolution.class, "height");
    public static final Property<String> url = new Property(ImageResolution.class, UpdateFragment.FRAGMENT_URL);
    public static final Property<Integer> width = new Property(ImageResolution.class, "width");

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `image_resolution`(`url`,`width`,`height`) VALUES (?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `image_resolution`(`url` TEXT, `width` INTEGER, `height` INTEGER, PRIMARY KEY(`url`))";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `image_resolution` WHERE `url`=?";
    }

    public final String getTableName() {
        return "`image_resolution`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `image_resolution` SET `url`=?,`width`=?,`height`=? WHERE `url`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        ImageResolution imageResolution = (ImageResolution) obj;
        if (imageResolution.getUrl() != null) {
            databaseStatement.bindString(1, imageResolution.getUrl());
        } else {
            databaseStatement.bindString(1, "");
        }
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        ImageResolution imageResolution = (ImageResolution) obj;
        if (imageResolution.getUrl() != null) {
            databaseStatement.bindString(1 + i, imageResolution.getUrl());
        } else {
            databaseStatement.bindString(1 + i, "");
        }
        databaseStatement.bindLong(2 + i, (long) imageResolution.getWidth());
        databaseStatement.bindLong(3 + i, (long) imageResolution.getHeight());
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        ImageResolution imageResolution = (ImageResolution) obj;
        contentValues.put("`url`", imageResolution.getUrl() != null ? imageResolution.getUrl() : "");
        contentValues.put("`width`", Integer.valueOf(imageResolution.getWidth()));
        contentValues.put("`height`", Integer.valueOf(imageResolution.getHeight()));
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        ImageResolution imageResolution = (ImageResolution) obj;
        if (imageResolution.getUrl() != null) {
            databaseStatement.bindString(1, imageResolution.getUrl());
        } else {
            databaseStatement.bindString(1, "");
        }
        databaseStatement.bindLong(2, (long) imageResolution.getWidth());
        databaseStatement.bindLong(3, (long) imageResolution.getHeight());
        if (imageResolution.getUrl() != null) {
            databaseStatement.bindString(4, imageResolution.getUrl());
        } else {
            databaseStatement.bindString(4, "");
        }
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        ImageResolution imageResolution = (ImageResolution) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(ImageResolution.class).where(m20725a(imageResolution)).hasData(databaseWrapper);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m20725a((ImageResolution) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        ImageResolution imageResolution = (ImageResolution) obj;
        imageResolution.setUrl(flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL, ""));
        imageResolution.setWidth(flowCursor.getIntOrDefault("width"));
        imageResolution.setHeight(flowCursor.getIntOrDefault("height"));
    }

    public ImageResolution_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<ImageResolution> getModelClass() {
        return ImageResolution.class;
    }

    public final Property getProperty(String str) {
        str = QueryBuilder.quoteIfNeeded(str);
        int hashCode = str.hashCode();
        if (hashCode != -1487027270) {
            if (hashCode != 92256561) {
                if (hashCode == 608855993) {
                    if (str.equals("`height`") != null) {
                        str = 2;
                        switch (str) {
                            case null:
                                return url;
                            case 1:
                                return width;
                            case 2:
                                return height;
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
                        return width;
                    case 2:
                        return height;
                    default:
                        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
                }
            }
        } else if (str.equals("`width`") != null) {
            str = true;
            switch (str) {
                case null:
                    return url;
                case 1:
                    return width;
                case 2:
                    return height;
                default:
                    throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
            }
        }
        str = -1;
        switch (str) {
            case null:
                return url;
            case 1:
                return width;
            case 2:
                return height;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    private static OperatorGroup m20725a(ImageResolution imageResolution) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(url.eq(imageResolution.getUrl()));
        return clause;
    }

    public final /* synthetic */ Object newInstance() {
        return new ImageResolution();
    }
}
