package com.reddit.frontpage.video.mpdparser.core.parser;

import android.net.Uri;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.reddit.frontpage.video.mpdparser.data.model.DashManifest;
import com.reddit.frontpage.video.mpdparser.data.model.ExoDashManifest;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/core/parser/ExoPlayerManifestParser;", "Lcom/google/android/exoplayer2/source/dash/manifest/DashManifestParser;", "Lcom/reddit/frontpage/video/mpdparser/core/parser/MPDParser;", "()V", "parseManifest", "Lcom/reddit/frontpage/video/mpdparser/data/model/DashManifest;", "url", "Landroid/net/Uri;", "inputStream", "Ljava/io/InputStream;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ExoPlayerManifestParser.kt */
public final class ExoPlayerManifestParser extends DashManifestParser implements MPDParser {
    public final DashManifest mo6533c(Uri uri, InputStream inputStream) {
        Intrinsics.m26847b(uri, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(inputStream, "inputStream");
        Object b = b(uri, inputStream);
        Intrinsics.m26843a(b, "parse(url, inputStream)");
        return new ExoDashManifest(b);
    }
}
