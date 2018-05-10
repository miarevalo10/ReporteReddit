package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentProviderDatabaseDriver extends DatabaseDriver2<ContentProviderDatabaseDescriptor> {
    private static final String sDatabaseName = "content-providers";
    private final ContentProviderSchema[] mContentProviderSchemas;
    private List<String> mTableNames;

    static class ContentProviderDatabaseDescriptor implements DatabaseDescriptor {
        public String name() {
            return ContentProviderDatabaseDriver.sDatabaseName;
        }
    }

    public ContentProviderDatabaseDriver(Context context, ContentProviderSchema... contentProviderSchemaArr) {
        super(context);
        this.mContentProviderSchemas = contentProviderSchemaArr;
    }

    public List<ContentProviderDatabaseDescriptor> getDatabaseNames() {
        return Collections.singletonList(new ContentProviderDatabaseDescriptor());
    }

    public List<String> getTableNames(ContentProviderDatabaseDescriptor contentProviderDatabaseDescriptor) {
        if (this.mTableNames == null) {
            this.mTableNames = new ArrayList();
            for (ContentProviderSchema tableName : this.mContentProviderSchemas) {
                this.mTableNames.add(tableName.getTableName());
            }
        }
        return this.mTableNames;
    }

    public ExecuteSQLResponse executeSQL(ContentProviderDatabaseDescriptor contentProviderDatabaseDescriptor, String str, ExecuteResultHandler<ExecuteSQLResponse> executeResultHandler) throws SQLiteException {
        contentProviderDatabaseDescriptor = this.mContentProviderSchemas[this.mTableNames.indexOf(fetchTableName(str))];
        contentProviderDatabaseDescriptor = this.mContext.getContentResolver().query(contentProviderDatabaseDescriptor.getUri(), contentProviderDatabaseDescriptor.getProjection(), null, null, null);
        try {
            ExecuteSQLResponse executeSQLResponse = (ExecuteSQLResponse) executeResultHandler.handleSelect(contentProviderDatabaseDescriptor);
            return executeSQLResponse;
        } finally {
            contentProviderDatabaseDescriptor.close();
        }
    }

    private String fetchTableName(String str) {
        for (String str2 : this.mTableNames) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }
}
