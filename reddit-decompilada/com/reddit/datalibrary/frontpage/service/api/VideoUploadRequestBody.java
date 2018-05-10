package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.frontpage.util.Util;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class VideoUploadRequestBody extends RequestBody {
    private static final int DEFAULT_BUFFER_SIZE = 65536;
    private final String contentTypeStr;
    private final File file;
    private final UploadProgressListener progressListener;
    private final String requestId;

    public VideoUploadRequestBody(File file, String str, String str2, UploadProgressListener uploadProgressListener) {
        this.file = file;
        this.contentTypeStr = str;
        this.requestId = str2;
        this.progressListener = uploadProgressListener;
    }

    public MediaType contentType() {
        return MediaType.parse(this.contentTypeStr);
    }

    public long contentLength() throws IOException {
        return this.file.length();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        long length = this.file.length();
        byte[] bArr = new byte[DEFAULT_BUFFER_SIZE];
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file), DEFAULT_BUFFER_SIZE);
            int i = 0;
            int i2 = -1;
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedSink.mo6765c(bArr, 0, read);
                        if (this.progressListener != null) {
                            i += read;
                            read = (int) (((((float) i) / ((float) length)) * 100.0f) + 0.5f);
                            if (read > i2) {
                                this.progressListener.onProgress(this.requestId, ((float) read) / 100.0f);
                                i2 = read;
                            }
                            bufferedSink.flush();
                        }
                    } else {
                        Util.m23989a(bufferedInputStream);
                        return;
                    }
                } catch (Throwable th) {
                    bufferedSink = th;
                }
            }
        } catch (Throwable th2) {
            bufferedSink = th2;
            bufferedInputStream = null;
            Util.m23989a(bufferedInputStream);
            throw bufferedSink;
        }
    }
}
