package com.reddit.frontpage.video.mpdparser.core.parser;

import android.net.Uri;
import com.reddit.frontpage.video.mpdparser.data.model.DashManifest;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/core/parser/MPDParser;", "", "parseManifest", "Lcom/reddit/frontpage/video/mpdparser/data/model/DashManifest;", "url", "Landroid/net/Uri;", "inputStream", "Ljava/io/InputStream;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MPDParser.kt */
public interface MPDParser {
    DashManifest mo6533c(Uri uri, InputStream inputStream);
}
