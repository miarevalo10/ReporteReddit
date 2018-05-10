package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$2 implements Callable {
    public static final Callable f10698a = new LegacyLinkRepository$$Lambda$2();

    private LegacyLinkRepository$$Lambda$2() {
    }

    public final Object call() {
        return SQLite.select(new IProperty[0]).from(VideoUpload.class).queryList();
    }
}
