package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.google.android.gms.ads.AdRequest;
import com.instabug.library.model.State;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;

class MediaStoreRequestHandler extends ContentStreamRequestHandler {
    private static final String[] f34633b = new String[]{State.KEY_ORIENTATION};

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, AdRequest.MAX_CONTENT_URL_LENGTH, 384),
        FULL(2, -1, -1);
        
        final int f23791d;
        final int f23792e;
        final int f23793f;

        private PicassoKind(int i, int i2, int i3) {
            this.f23791d = i;
            this.f23792e = i2;
            this.f23793f = i3;
        }
    }

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    public final boolean mo5445a(Request request) {
        request = request.uri;
        return (!"content".equals(request.getScheme()) || "media".equals(request.getAuthority()) == null) ? null : true;
    }

    public final Result mo5446b(Request request) throws IOException {
        Request request2 = request;
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = m35554a(contentResolver, request2.uri);
        String type = contentResolver.getType(request2.uri);
        boolean z = type != null && type.startsWith("video/");
        if (request.hasSize()) {
            PicassoKind picassoKind;
            int i = request2.targetWidth;
            int i2 = request2.targetHeight;
            if (i <= PicassoKind.MICRO.f23792e && i2 <= PicassoKind.MICRO.f23793f) {
                picassoKind = PicassoKind.MICRO;
            } else if (i > PicassoKind.MINI.f23792e || i2 > PicassoKind.MINI.f23793f) {
                picassoKind = PicassoKind.FULL;
            } else {
                picassoKind = PicassoKind.MINI;
            }
            PicassoKind picassoKind2 = picassoKind;
            if (!z && picassoKind2 == PicassoKind.FULL) {
                return new Result(null, m31683c(request), LoadedFrom.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(request2.uri);
            Options d = RequestHandler.m25795d(request);
            d.inJustDecodeBounds = true;
            Options options = d;
            RequestHandler.m25792a(request2.targetWidth, request2.targetHeight, picassoKind2.f23792e, picassoKind2.f23793f, d, request2);
            if (z) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, picassoKind2 == PicassoKind.FULL ? 1 : picassoKind2.f23791d, options);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, picassoKind2.f23791d, options);
            }
            if (thumbnail != null) {
                return new Result(thumbnail, null, LoadedFrom.DISK, a);
            }
        }
        return new Result(null, m31683c(request), LoadedFrom.DISK, a);
    }

    private static int m35554a(android.content.ContentResolver r8, android.net.Uri r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 0;
        r4 = f34633b;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r5 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r6 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r7 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r2 = r8;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r3 = r9;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r8 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        if (r8 == 0) goto L_0x0022;
    L_0x000f:
        r9 = r8.moveToFirst();	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
        if (r9 != 0) goto L_0x0016;	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
    L_0x0015:
        goto L_0x0022;	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
    L_0x0016:
        r9 = r8.getInt(r0);	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
        if (r8 == 0) goto L_0x001f;
    L_0x001c:
        r8.close();
    L_0x001f:
        return r9;
    L_0x0020:
        r9 = move-exception;
        goto L_0x002a;
    L_0x0022:
        if (r8 == 0) goto L_0x0027;
    L_0x0024:
        r8.close();
    L_0x0027:
        return r0;
    L_0x0028:
        r9 = move-exception;
        r8 = r1;
    L_0x002a:
        if (r8 == 0) goto L_0x002f;
    L_0x002c:
        r8.close();
    L_0x002f:
        throw r9;
    L_0x0030:
        r8 = r1;
    L_0x0031:
        if (r8 == 0) goto L_0x0036;
    L_0x0033:
        r8.close();
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.MediaStoreRequestHandler.a(android.content.ContentResolver, android.net.Uri):int");
    }
}
