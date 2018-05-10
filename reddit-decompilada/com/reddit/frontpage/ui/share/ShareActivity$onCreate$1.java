package com.reddit.frontpage.ui.share;

import android.database.Cursor;
import android.net.Uri;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: ShareActivity.kt */
final class ShareActivity$onCreate$1<V> implements Callable<T> {
    final /* synthetic */ ShareActivity f21597a;

    ShareActivity$onCreate$1(ShareActivity shareActivity) {
        this.f21597a = shareActivity;
    }

    public final /* synthetic */ Object call() {
        return m23609a();
    }

    private File m23609a() {
        Object parcelableExtra = this.f21597a.getIntent().getParcelableExtra("android.intent.extra.STREAM");
        Intrinsics.m26843a(parcelableExtra, "intent.getParcelableExtra(Intent.EXTRA_STREAM)");
        Uri uri = (Uri) parcelableExtra;
        Closeable query = this.f21597a.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        try {
            Cursor cursor = (Cursor) query;
            cursor.moveToFirst();
            String string = cursor.getString(0);
            CloseableKt.m26828a(query, null);
            InputStream openInputStream = this.f21597a.getContentResolver().openInputStream(uri);
            File file = new File(this.f21597a.getCacheDir(), string);
            FileUtils.m28333a(openInputStream, file);
            return file;
        } catch (Throwable th) {
            CloseableKt.m26828a(query, th);
        }
    }
}
