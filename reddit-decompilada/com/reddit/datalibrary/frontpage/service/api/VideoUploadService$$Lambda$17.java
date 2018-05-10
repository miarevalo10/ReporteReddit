package com.reddit.datalibrary.frontpage.service.api;

import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import java.util.concurrent.Callable;

final /* synthetic */ class VideoUploadService$$Lambda$17 implements Callable {
    static final Callable $instance = new VideoUploadService$$Lambda$17();

    private VideoUploadService$$Lambda$17() {
    }

    public final Object call() {
        return SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.status.notEq(Integer.valueOf(5))}).queryList();
    }
}
