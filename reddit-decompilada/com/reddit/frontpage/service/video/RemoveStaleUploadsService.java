package com.reddit.frontpage.service.video;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.JobIntentService;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import timber.log.Timber;

public class RemoveStaleUploadsService extends JobIntentService {
    public static void m29918a(Context context, Intent intent) {
        a(context, RemoveStaleUploadsService.class, 1, intent);
    }

    protected final void m29919a(Intent intent) {
        Timber.b("Started removal of stale uploads", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis() - 86400000;
        Intent<VideoUpload> queryList = SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.timestamp.lessThan(Long.valueOf(currentTimeMillis))}).queryList();
        if (!queryList.isEmpty()) {
            for (VideoUpload videoUpload : queryList) {
                Timber.b("Deleting stale entry [%s]", new Object[]{videoUpload});
                videoUpload.delete();
            }
        }
    }
}
