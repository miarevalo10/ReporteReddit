package com.instabug.library.network;

import android.net.Uri.Builder;
import com.instabug.library.network.NetworkManager.RequestType;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {
    protected static final String BASE_URL = "https://api.instabug.com/api/sdk/v3";
    private ArrayList<RequestParameter> bodyParameters;
    private File downloadedFile;
    private String endPoint;
    private FileToUpload fileToUpload;
    private ArrayList<RequestParameter> headers;
    private RequestMethod requestMethod;
    private RequestType requestType;
    private String requestUrl;
    private ArrayList<RequestParameter> urlParameters;

    public interface Callbacks<T, K> {
        void onFailed(K k);

        void onSucceeded(T t);
    }

    public enum Endpoint {
        ReportBug("/bugs"),
        AddBugAttachment("/bugs/:bug_token/attachments"),
        ReportCrash("/crashes"),
        AddCrashAttachment("/crashes/:crash_token/attachments"),
        TriggerChat("/chats"),
        SendMessage("/chats/:chat_number/messages"),
        AddMessageAttachment("/chats/:chat_number/messages/:message_id/attachments"),
        SyncChats("/chats/sync"),
        AppSettings("/features"),
        SendSession("/sessions"),
        GetSurveys("/surveys/v3"),
        SubmitSurvey("/surveys/:survey_id/v3/responses"),
        bugLogs("/bugs/:bug_token/state_logs"),
        crashLogs("/crashes/:crash_token/state_logs"),
        chatLogs("/chats/:chat_token/state_logs"),
        MigrateUUID("/migrate_uuid"),
        Analytics("/analytics"),
        PushToken("/push_token"),
        ReportCategories("/application_categories");
        
        private final String name;

        private Endpoint(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static class FileToUpload {
        private String fileName;
        private String filePartName;
        private String filePath;
        private String fileType;

        public FileToUpload(String str, String str2, String str3, String str4) {
            this.filePartName = str;
            this.fileName = str2;
            this.filePath = str3;
            this.fileType = str4;
        }

        public String getFilePartName() {
            return this.filePartName;
        }

        public String getFileName() {
            return this.fileName;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public String getFileType() {
            return this.fileType;
        }
    }

    public enum RequestMethod {
        Get(HttpRequest.METHOD_GET),
        Post(HttpRequest.METHOD_POST),
        put(HttpRequest.METHOD_PUT);
        
        private final String name;

        private RequestMethod(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static class RequestParameter implements Serializable {
        private String key;
        private Object value;

        public RequestParameter(String str, Object obj) {
            this.key = str;
            this.value = obj;
        }

        public Object getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }
    }

    public Request(Endpoint endpoint, RequestType requestType) {
        this.endPoint = endpoint.toString();
        endpoint = new StringBuilder(BASE_URL);
        endpoint.append(getEndpoint());
        this.requestUrl = endpoint.toString();
        this.requestType = requestType;
        initialize();
    }

    public Request(String str, RequestType requestType) {
        this.requestUrl = str;
        this.requestType = requestType;
        initialize();
    }

    private void initialize() {
        this.urlParameters = new ArrayList();
        this.bodyParameters = new ArrayList();
        this.headers = new ArrayList();
    }

    public String getEndpoint() {
        return this.endPoint;
    }

    public void setEndpoint(String str) {
        this.endPoint = str;
        str = new StringBuilder(BASE_URL);
        str.append(getEndpoint());
        this.requestUrl = str.toString();
    }

    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.requestUrl);
        stringBuilder.append(getUrlEncodedParameters());
        return stringBuilder.toString();
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public void addHeader(RequestParameter requestParameter) {
        this.headers.add(requestParameter);
    }

    public ArrayList<RequestParameter> getHeaders() {
        return this.headers;
    }

    public Request addParameter(String str, Object obj) throws JSONException {
        if (this.requestMethod.equals(RequestMethod.Get)) {
            addRequestUrlParameter(str, obj);
        } else {
            addRequestBodyParameter(str, obj);
        }
        return this;
    }

    public void addRequestUrlParameter(String str, Object obj) throws JSONException {
        this.urlParameters.add(new RequestParameter(str, obj));
    }

    public ArrayList<RequestParameter> setRequestUrlParameters(ArrayList<RequestParameter> arrayList) {
        this.urlParameters = arrayList;
        return arrayList;
    }

    public ArrayList<RequestParameter> getRequestUrlParameters() {
        return this.urlParameters;
    }

    public ArrayList<RequestParameter> clearRequestUrlParameters() {
        this.urlParameters.clear();
        return this.urlParameters;
    }

    public void addRequestBodyParameter(String str, Object obj) throws JSONException {
        this.bodyParameters.add(new RequestParameter(str, obj));
    }

    public ArrayList<RequestParameter> setRequestBodyParameters(ArrayList<RequestParameter> arrayList) {
        this.bodyParameters = arrayList;
        return arrayList;
    }

    public ArrayList<RequestParameter> getRequestBodyParameters() {
        return this.bodyParameters;
    }

    public ArrayList<RequestParameter> clearRequestBodyParameters() {
        this.bodyParameters.clear();
        return this.bodyParameters;
    }

    private String getUrlEncodedParameters() {
        Builder builder = new Builder();
        Iterator it = this.urlParameters.iterator();
        while (it.hasNext()) {
            RequestParameter requestParameter = (RequestParameter) it.next();
            builder.appendQueryParameter(requestParameter.getKey(), requestParameter.getValue().toString());
        }
        return builder.toString();
    }

    public String getRequestBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator it = getRequestBodyParameters().iterator();
            while (it.hasNext()) {
                RequestParameter requestParameter = (RequestParameter) it.next();
                jSONObject.put(requestParameter.getKey(), requestParameter.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public FileToUpload getFileToUpload() {
        return this.fileToUpload;
    }

    public Request setFileToUpload(FileToUpload fileToUpload) {
        this.fileToUpload = fileToUpload;
        return this;
    }

    public File getDownloadedFile() {
        return this.downloadedFile;
    }

    public Request setDownloadedFile(String str) {
        this.downloadedFile = new File(str);
        return this;
    }
}
