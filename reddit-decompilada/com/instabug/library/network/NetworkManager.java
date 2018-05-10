package com.instabug.library.network;

import android.content.Context;
import android.net.ConnectivityManager;
import com.instabug.library.Instabug;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.Request.RequestParameter;
import com.instabug.library.user.C0770a;
import com.instabug.library.util.InstabugSDKLogger;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class NetworkManager {
    public static final String APP_TOKEN = "application_token";
    private static final int DEFAULT_CONNECTION_TIME_OUT = 15000;
    private static final int DEFAULT_READ_TIME_OUT = 10000;
    public static final String UUID = "uuid";

    public enum RequestType {
        NORMAL,
        MULTI_PART,
        FILE_DOWNLOAD
    }

    public static boolean isOnline(Context context) {
        try {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(context == null || context.isConnectedOrConnecting() == null)) {
                return true;
            }
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("Could not read network state. To enable please add the following line in your AndroidManifest.xml <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\"/>\n");
            stringBuilder.append(context2.getMessage());
            InstabugSDKLogger.m8361w(NetworkManager.class, stringBuilder.toString());
        } catch (Context context22) {
            InstabugSDKLogger.m8358e(NetworkManager.class, "Something went wrong while checking network state", context22);
        }
        return null;
    }

    public Observable<RequestResponse> doRequest(final Request request) {
        return Observable.a(new OnSubscribe<RequestResponse>(this) {
            final /* synthetic */ NetworkManager f18573b;

            public final /* synthetic */ void m19508a(Object obj) {
                StringBuilder stringBuilder;
                Subscriber subscriber = (Subscriber) obj;
                try {
                    subscriber.aV_();
                    InstabugSDKLogger.m8360v(NetworkManager.class, "Starting do request");
                    StringBuilder stringBuilder2 = new StringBuilder("Request Url: ");
                    stringBuilder2.append(request.getRequestUrl());
                    InstabugSDKLogger.m8360v(NetworkManager.class, stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("Request Type: ");
                    stringBuilder2.append(request.getRequestMethod().toString());
                    InstabugSDKLogger.m8360v(NetworkManager.class, stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("Request Body: ");
                    stringBuilder2.append(request.getRequestBody());
                    InstabugSDKLogger.m8360v(NetworkManager.class, stringBuilder2.toString());
                    HttpURLConnection httpURLConnection = null;
                    switch (request.getRequestType()) {
                        case NORMAL:
                            httpURLConnection = this.f18573b.connectWithNormalType(request);
                            break;
                        case FILE_DOWNLOAD:
                            httpURLConnection = this.f18573b.connectWithFileDownloadType(request);
                            break;
                        case MULTI_PART:
                            httpURLConnection = this.f18573b.connectWithMultiPartType(request);
                            break;
                        default:
                            break;
                    }
                    if (httpURLConnection != null) {
                        if (httpURLConnection.getResponseCode() >= 300) {
                            InstabugSDKLogger.m8357e(NetworkManager.class, "Network request got error");
                            this.f18573b.handleServerConnectionError(httpURLConnection);
                        }
                        InstabugSDKLogger.m8360v(NetworkManager.class, "Network request completed successfully");
                        switch (request.getRequestType()) {
                            case NORMAL:
                                subscriber.a_(this.f18573b.handleRequestResponse(httpURLConnection));
                                break;
                            case FILE_DOWNLOAD:
                                subscriber.a_(this.f18573b.handleFileDownloadRequestResponse(request, httpURLConnection));
                                break;
                            case MULTI_PART:
                                subscriber.a_(this.f18573b.handleMultipartRequestResponse(httpURLConnection));
                                break;
                            default:
                                break;
                        }
                    }
                    subscriber.b();
                } catch (Throwable e) {
                    stringBuilder = new StringBuilder("Request got error: ");
                    stringBuilder.append(request.getRequestUrl());
                    InstabugSDKLogger.m8358e(NetworkManager.class, stringBuilder.toString(), e);
                    subscriber.a(e);
                } catch (Throwable e2) {
                    stringBuilder = new StringBuilder("Request got error: ");
                    stringBuilder.append(request.getRequestUrl());
                    InstabugSDKLogger.m8358e(NetworkManager.class, stringBuilder.toString(), e2);
                    subscriber.a(e2);
                } catch (C0748c e3) {
                    stringBuilder = new StringBuilder("Request got error: ");
                    stringBuilder.append(request.getRequestUrl());
                    stringBuilder.append(", error message: ");
                    stringBuilder.append(e3.getMessage());
                    InstabugSDKLogger.m8361w(NetworkManager.class, stringBuilder.toString());
                    subscriber.b();
                }
            }
        });
    }

    public Request buildRequest(Context context, Endpoint endpoint, RequestMethod requestMethod) throws JSONException {
        return buildRequest(context, endpoint, requestMethod, RequestType.NORMAL);
    }

    public Request buildRequest(Context context, Endpoint endpoint, RequestMethod requestMethod, RequestType requestType) throws JSONException {
        Request request = new Request(endpoint, requestType);
        request.setRequestMethod(requestMethod);
        return buildRequest(context, request);
    }

    public Request buildRequest(Context context, String str, RequestMethod requestMethod) throws JSONException {
        return buildRequest(context, str, requestMethod, RequestType.NORMAL);
    }

    public Request buildRequest(Context context, String str, RequestMethod requestMethod, RequestType requestType) throws JSONException {
        Request request = new Request(str, requestType);
        request.setRequestMethod(requestMethod);
        return buildRequest(context, request);
    }

    public Request buildRequestWithoutUUID(Context context, Endpoint endpoint, RequestMethod requestMethod) throws JSONException {
        context = new Request(endpoint, RequestType.NORMAL);
        context.setRequestMethod(requestMethod);
        context.addParameter(APP_TOKEN, Instabug.getAppToken());
        return context;
    }

    private Request buildRequest(Context context, Request request) throws JSONException {
        request.addParameter(APP_TOKEN, Instabug.getAppToken());
        request.addParameter("uuid", C0770a.m8348d());
        return request;
    }

    public HttpURLConnection buildConnection(Request request) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.getRequestUrl()).openConnection();
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT_CHARSET, "UTF-8");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
        request = request.getHeaders().iterator();
        while (request.hasNext()) {
            RequestParameter requestParameter = (RequestParameter) request.next();
            httpURLConnection.setRequestProperty(requestParameter.getKey(), (String) requestParameter.getValue());
        }
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private HttpURLConnection setURLConnectionDefaultTimeOut(HttpURLConnection httpURLConnection) {
        return setURLConnectionTimeOut(httpURLConnection, 10000, DEFAULT_CONNECTION_TIME_OUT);
    }

    public HttpURLConnection setURLConnectionTimeOut(HttpURLConnection httpURLConnection, int i, int i2) {
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setConnectTimeout(i2);
        return httpURLConnection;
    }

    private HttpURLConnection connectWithNormalType(Request request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("Connect to: ");
        stringBuilder.append(request.getRequestUrl());
        stringBuilder.append(" with normal type");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        HttpURLConnection buildConnection = buildConnection(request);
        setURLConnectionDefaultTimeOut(buildConnection);
        buildConnection.setRequestMethod(request.getRequestMethod().toString());
        if (request.getRequestMethod() == RequestMethod.Post || request.getRequestMethod() == RequestMethod.put) {
            buildConnection.setDoOutput(true);
            writeRequestBody(buildConnection.getOutputStream(), request.getRequestBody());
        }
        return buildConnection;
    }

    private void writeRequestBody(OutputStream outputStream, String str) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes(Charset.forName("UTF8")));
        gZIPOutputStream.close();
        outputStream.write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    private HttpURLConnection connectWithFileDownloadType(Request request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("Connect to: ");
        stringBuilder.append(request.getRequestUrl());
        stringBuilder.append(" with fileDownload type");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        return connectWithNormalType(request);
    }

    private HttpURLConnection connectWithMultiPartType(Request request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("Connect to: ");
        stringBuilder.append(request.getRequestUrl());
        stringBuilder.append(" with multiPart type");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        HttpURLConnection buildConnection = buildConnection(request);
        buildConnection.setRequestMethod(request.getRequestMethod().toString());
        buildConnection.setRequestProperty("Connection", "Keep-Alive");
        buildConnection.setRequestProperty(HttpRequest.HEADER_CACHE_CONTROL, "no-cache");
        buildConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, "");
        C0747b c0747b = new C0747b(buildConnection);
        Iterator it = request.getRequestBodyParameters().iterator();
        while (it.hasNext()) {
            RequestParameter requestParameter = (RequestParameter) it.next();
            CharSequence key = requestParameter.getKey();
            CharSequence obj = requestParameter.getValue().toString();
            c0747b.f9846b.append("--").append(c0747b.f9845a).append("\r\n");
            c0747b.f9846b.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append("\r\n");
            c0747b.f9846b.append("\r\n");
            c0747b.f9846b.append(obj).append("\r\n");
            c0747b.f9846b.flush();
        }
        request = request.getFileToUpload();
        c0747b.m8310a(request.getFilePartName(), new File(request.getFilePath()), request.getFileName(), request.getFileType());
        c0747b.f9846b.append("\r\n").flush();
        c0747b.f9846b.append("--").append(c0747b.f9845a).append("--").append("\r\n");
        c0747b.f9846b.close();
        return buildConnection;
    }

    private RequestResponse handleRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        int responseCode = httpURLConnection.getResponseCode();
        requestResponse.setResponseCode(responseCode);
        StringBuilder stringBuilder = new StringBuilder("Request response code: ");
        stringBuilder.append(responseCode);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        String convertStreamToString = convertStreamToString(httpURLConnection.getInputStream());
        requestResponse.setResponseBody(convertStreamToString);
        stringBuilder = new StringBuilder("Request response: ");
        stringBuilder.append(convertStreamToString);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        httpURLConnection.disconnect();
        return requestResponse;
    }

    private RequestResponse handleMultipartRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        return handleRequestResponse(httpURLConnection);
    }

    private RequestResponse handleFileDownloadRequestResponse(Request request, HttpURLConnection httpURLConnection) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        int responseCode = httpURLConnection.getResponseCode();
        requestResponse.setResponseCode(responseCode);
        StringBuilder stringBuilder = new StringBuilder("File downloader request response code: ");
        stringBuilder.append(responseCode);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        copyStream(httpURLConnection.getInputStream(), new FileOutputStream(request.getDownloadedFile()));
        requestResponse.setResponseBody(request.getDownloadedFile());
        StringBuilder stringBuilder2 = new StringBuilder("File downloader request response: ");
        stringBuilder2.append(request.getDownloadedFile().getPath());
        InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
        httpURLConnection.disconnect();
        return requestResponse;
    }

    private void handleServerConnectionError(HttpURLConnection httpURLConnection) throws IOException, C0748c {
        int responseCode = httpURLConnection.getResponseCode();
        httpURLConnection = httpURLConnection.getErrorStream();
        StringBuilder stringBuilder = new StringBuilder("Error getting Network request response: ");
        stringBuilder.append(convertStreamToString(httpURLConnection));
        InstabugSDKLogger.m8357e(this, stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("responseCode: ");
        stringBuilder2.append(responseCode);
        stringBuilder2.append("\n");
        stringBuilder2.append(convertStreamToString(httpURLConnection));
        throw new C0748c(stringBuilder2.toString());
    }

    private String convertStreamToString(InputStream inputStream) {
        inputStream = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        return inputStream.hasNext() ? inputStream.next() : "";
    }

    private void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                outputStream.write(read);
            } else {
                return;
            }
        }
    }
}
