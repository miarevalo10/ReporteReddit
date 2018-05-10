package com.reddit.frontpage.video.mpdparser.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/util/UtilIO;", "", "()V", "createByteArray", "", "inputStream", "Ljava/io/InputStream;", "streamToString", "", "stream", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UtilIO.kt */
public final class UtilIO {
    public static final UtilIO f21844a = new UtilIO();

    private UtilIO() {
    }

    public static final String m24129a(InputStream inputStream) {
        Intrinsics.m26847b(inputStream, "stream");
        inputStream = new Scanner(inputStream).useDelimiter("\\A");
        if (!inputStream.hasNext()) {
            return "";
        }
        Object next = inputStream.next();
        Intrinsics.m26843a(next, "s.next()");
        return next;
    }

    public static final byte[] m24130b(InputStream inputStream) {
        Intrinsics.m26847b(inputStream, "inputStream");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.m28334a(inputStream, byteArrayOutputStream);
        Object toByteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.m26843a(toByteArray, "bytesStream.toByteArray()");
        return toByteArray;
    }
}
