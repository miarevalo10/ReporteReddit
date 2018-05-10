package com.reddit.datalibrary.frontpage.service.api;

import android.util.Xml;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.jakewharton.byteunits.DecimalByteUnit;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.IOUtil;
import com.reddit.frontpage.util.XmlUtils;
import com.reddit.frontpage.util.XmlUtils.XMLObject;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import org.xmlpull.v1.XmlPullParser;
import timber.log.Timber;

public class AwsFileUploadRequest extends Request<FileUploadResponse> {
    private static final long MAX_BUFFERED_BYTES = DecimalByteUnit.c.a(1);
    private final String boundary;
    private final Listener<FileUploadResponse> listener;
    private final Builder multipartBody;
    private final UploadProgressListener progressListener;
    private final String requestId;

    private static class StreamedRequestBody extends RequestBody {
        final InputStream input;
        long length;
        final Request request;
        final String requestId;
        final MediaType type;
        final UploadProgressListener uploadProgressListener;

        StreamedRequestBody(com.android.volley.Request r1, java.io.InputStream r2, okhttp3.MediaType r3, java.lang.String r4, com.reddit.datalibrary.frontpage.service.api.UploadProgressListener r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            r0.<init>();
            r0.request = r1;
            r0.input = r2;
            r0.type = r3;
            r0.requestId = r4;
            r0.uploadProgressListener = r5;
            r1 = r2.available();	 Catch:{ IOException -> 0x0015 }
            r1 = (long) r1;	 Catch:{ IOException -> 0x0015 }
            r0.length = r1;	 Catch:{ IOException -> 0x0015 }
            return;
        L_0x0015:
            r1 = -1;
            r0.length = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.service.api.AwsFileUploadRequest.StreamedRequestBody.<init>(com.android.volley.Request, java.io.InputStream, okhttp3.MediaType, java.lang.String, com.reddit.datalibrary.frontpage.service.api.UploadProgressListener):void");
        }

        public long contentLength() throws IOException {
            return this.length;
        }

        public MediaType contentType() {
            return this.type;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            OutputStream b = bufferedSink.mo6759b();
            byte[] bArr = new byte[65536];
            int i = -1;
            int i2 = 0;
            int i3 = i2;
            while (true) {
                int read = this.input.read(bArr);
                if (read == -1) {
                    break;
                } else if (this.request.isCanceled()) {
                    break;
                } else {
                    b.write(bArr, 0, read);
                    i2 += read;
                    if (this.uploadProgressListener != null) {
                        i3 += read;
                        read = (int) (((((float) i3) / ((float) this.length)) * 100.0f) + 0.5f);
                        if (read > i) {
                            this.uploadProgressListener.onProgress(this.requestId, ((float) read) / 100.0f);
                            i = read;
                        }
                        bufferedSink.flush();
                    } else if (((long) i2) > AwsFileUploadRequest.MAX_BUFFERED_BYTES) {
                        bufferedSink.mo6763c();
                        i2 = 0;
                    }
                }
            }
            Timber.c("Aborting upload for cancelled request", new Object[0]);
            bufferedSink.flush();
        }
    }

    public AwsFileUploadRequest(String str, ErrorListener errorListener, Listener<FileUploadResponse> listener) {
        this(str, errorListener, listener, null, null);
    }

    public AwsFileUploadRequest(String str, ErrorListener errorListener, Listener<FileUploadResponse> listener, String str2, UploadProgressListener uploadProgressListener) {
        super(1, str, errorListener);
        this.boundary = UUID.randomUUID().toString();
        this.listener = listener;
        this.requestId = str2;
        this.progressListener = uploadProgressListener;
        this.multipartBody = new Builder(this.boundary).setType(MultipartBody.FORM);
    }

    public void addFormData(String str, String str2) {
        this.multipartBody.addFormDataPart(str, str2);
    }

    public void addFormData(String str, String str2, InputStream inputStream, String str3) {
        this.multipartBody.addFormDataPart(str, str2, new StreamedRequestBody(this, inputStream, MediaType.parse(str3), this.requestId, this.progressListener));
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getBodyContentType() {
        StringBuilder stringBuilder = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder.append(this.boundary);
        return stringBuilder.toString();
    }

    public byte[] getBody() throws AuthFailureError {
        throw new UnsupportedOperationException("Don't build byte array from files so as files can be big");
    }

    public File getBodyFile() {
        Throwable th;
        File file;
        Closeable closeable = null;
        try {
            File createTempFile = File.createTempFile("upload", null, FrontpageApplication.f27402a.getCacheDir());
            try {
                Closeable a = Okio.m28288a(Okio.m28298b(createTempFile));
                try {
                    this.multipartBody.build().writeTo(a);
                    IOUtil.m23719a(a);
                    return createTempFile;
                } catch (Throwable e) {
                    File file2 = createTempFile;
                    th = e;
                    closeable = a;
                    file = file2;
                    try {
                        VolleyLog.a(th, "Error during creating temporary upload file", new Object[0]);
                        IOUtil.m23719a(closeable);
                        return file;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtil.m23719a(closeable);
                        throw th;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    closeable = a;
                    IOUtil.m23719a(closeable);
                    throw th;
                }
            } catch (Throwable e3) {
                Throwable th3 = e3;
                file = createTempFile;
                th = th3;
                VolleyLog.a(th, "Error during creating temporary upload file", new Object[0]);
                IOUtil.m23719a(closeable);
                return file;
            }
        } catch (IOException e4) {
            th = e4;
            file = null;
            VolleyLog.a(th, "Error during creating temporary upload file", new Object[0]);
            IOUtil.m23719a(closeable);
            return file;
        }
    }

    protected Response<FileUploadResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(new InputStreamReader(new ByteArrayInputStream(networkResponse.b)));
            XMLObject a = XmlUtils.m24069a(newPullParser);
            if (a.f21824d.equalsIgnoreCase("Error")) {
                return Response.a(new VolleyError(a.m24067a("Message").f21823c));
            }
            String str;
            String str2 = a.m24067a(HttpRequest.HEADER_LOCATION).f21823c;
            a = a.m24067a("Key");
            if (a != null) {
                str = a.f21823c;
            } else {
                str = null;
            }
            FileUploadResponse fileUploadResponse = new FileUploadResponse();
            fileUploadResponse.success = true;
            fileUploadResponse.fileUrl = str2;
            fileUploadResponse.fileKey = str;
            return Response.a(fileUploadResponse, HttpHeaderParser.a(networkResponse));
        } catch (NetworkResponse networkResponse2) {
            Timber.c(networkResponse2, networkResponse2.getMessage(), new Object[0]);
            return Response.a(new VolleyError());
        }
    }

    protected void deliverResponse(FileUploadResponse fileUploadResponse) {
        this.listener.a(fileUploadResponse);
    }
}
