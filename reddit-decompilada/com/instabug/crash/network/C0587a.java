package com.instabug.crash.network;

import android.content.Context;
import com.instabug.crash.cache.CrashesCacheManager;
import com.instabug.crash.models.Crash;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.model.State.StateItem;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.NetworkManager.RequestType;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.FileToUpload;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;

/* compiled from: CrashesService */
public class C0587a {
    private static C0587a f9376a;
    private NetworkManager f9377b = new NetworkManager();

    private C0587a() {
    }

    public static C0587a m8009a() {
        if (f9376a == null) {
            f9376a = new C0587a();
        }
        return f9376a;
    }

    public final void m8010a(Context context, Crash crash, final Callbacks<String, Throwable> callbacks) throws JSONException, IOException {
        StringBuilder stringBuilder = new StringBuilder("Reporting crash with crash message: ");
        stringBuilder.append(crash.f15424c);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        context = this.f9377b.buildRequest(context, Endpoint.ReportCrash, RequestMethod.Post);
        if (crash.f15424c != null && crash.f15424c.contains("InstabugSDK-v: ")) {
            context.addRequestBodyParameter(NetworkManager.APP_TOKEN, "b1a9630002b2cbdfbfecd942744b9018");
        }
        ArrayList stateItems = crash.f15426e.getStateItems();
        if (stateItems != null && stateItems.size() > 0) {
            for (int i = 0; i < stateItems.size(); i++) {
                StringBuilder stringBuilder2 = new StringBuilder("Crash State Key: ");
                stringBuilder2.append(((StateItem) stateItems.get(i)).getKey());
                stringBuilder2.append(", Crash State value: ");
                stringBuilder2.append(((StateItem) stateItems.get(i)).getValue());
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                context.addRequestBodyParameter(((StateItem) stateItems.get(i)).getKey(), ((StateItem) stateItems.get(i)).getValue());
            }
        }
        context.addRequestBodyParameter("title", crash.f15424c);
        context.addRequestBodyParameter("attachments_count", Integer.valueOf(crash.f15425d.size()));
        context.addRequestBodyParameter("handled", Boolean.valueOf(crash.f15428g));
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0587a f18542b;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("reportingCrashRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append("Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                try {
                    callbacks.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("id"));
                } catch (Object obj2) {
                    obj2.printStackTrace();
                }
            }

            public final void aV_() {
                InstabugSDKLogger.m8356d(this, "reportingCrashRequest started");
            }

            public final void m19464b() {
                InstabugSDKLogger.m8356d(this, "reportingCrashRequest completed");
            }

            public final void m19463a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("reportingCrashRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                callbacks.onFailed(th);
            }
        }, this.f9377b.doRequest(context));
    }

    public final void m8011b(Context context, final Crash crash, final Callbacks<Boolean, Crash> callbacks) throws JSONException, FileNotFoundException {
        InstabugSDKLogger.m8356d(this, "Uploading Crash attachments");
        Observable[] observableArr = new Observable[crash.f15425d.size()];
        for (int i = 0; i < observableArr.length; i++) {
            Attachment attachment = (Attachment) crash.f15425d.get(i);
            Request buildRequest = this.f9377b.buildRequest(context, Endpoint.AddCrashAttachment, RequestMethod.Post, RequestType.MULTI_PART);
            buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":crash_token", crash.f15423b));
            buildRequest.addParameter("metadata[file_type]", attachment.getType());
            if (attachment.getType() == Type.AUDIO) {
                buildRequest.addParameter("metadata[duration]", attachment.getDuration());
            }
            buildRequest.setFileToUpload(new FileToUpload("file", attachment.getName(), attachment.getLocalPath(), attachment.getFileType()));
            observableArr[i] = this.f9377b.doRequest(buildRequest);
        }
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0587a f18545c;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("uploadingCrashAttachmentRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append(", Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                Attachment attachment = (Attachment) crash.f15425d.remove(0);
                if (new File(((Attachment) crash.f15425d.get(0)).getLocalPath()).delete() == null) {
                    obj = new StringBuilder("Attachment: ");
                    obj.append(attachment);
                    obj.append(" is not removed");
                    InstabugSDKLogger.m8357e(this, obj.toString());
                } else {
                    obj = new StringBuilder("Attachment: ");
                    obj.append(attachment);
                    obj.append(" is removed");
                    InstabugSDKLogger.m8356d(this, obj.toString());
                }
                CrashesCacheManager.addCrash(crash);
                CrashesCacheManager.saveCacheToDisk();
            }

            public final void aV_() {
                InstabugSDKLogger.m8356d(this, "uploadingCrashAttachmentRequest started");
            }

            public final void m19466b() {
                InstabugSDKLogger.m8356d(this, "uploadingCrashAttachmentRequest completed");
                if (crash.f15425d.size() == 0) {
                    callbacks.onSucceeded(Boolean.valueOf(true));
                }
            }

            public final void m19465a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("uploadingCrashAttachmentRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                callbacks.onFailed(crash);
            }
        }, Observable.b(observableArr));
    }

    public final void m8012c(Context context, final Crash crash, final Callbacks<Boolean, Crash> callbacks) {
        try {
            context = this.f9377b.buildRequest(context, Endpoint.crashLogs, RequestMethod.Post);
            context.setEndpoint(context.getEndpoint().replaceAll(":crash_token", crash.f15423b));
            ArrayList logsItems = crash.f15426e.getLogsItems();
            if (logsItems != null && logsItems.size() > 0) {
                Iterator it = logsItems.iterator();
                while (it.hasNext()) {
                    StateItem stateItem = (StateItem) it.next();
                    context.addRequestBodyParameter(stateItem.getKey(), stateItem.getValue());
                }
            }
            Observable.a(new Subscriber<RequestResponse>(this) {
                final /* synthetic */ C0587a f18548c;

                public final /* synthetic */ void a_(Object obj) {
                    RequestResponse requestResponse = (RequestResponse) obj;
                    StringBuilder stringBuilder = new StringBuilder("uploading crash logs onNext, Response code: ");
                    stringBuilder.append(requestResponse.getResponseCode());
                    stringBuilder.append("Response body: ");
                    stringBuilder.append(requestResponse.getResponseBody());
                    InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                }

                public final void aV_() {
                    InstabugSDKLogger.m8356d(this, "uploading crash logs started");
                }

                public final void m19468b() {
                    InstabugSDKLogger.m8356d(this, "uploading crash logs completed");
                    callbacks.onSucceeded(Boolean.valueOf(true));
                }

                public final void m19467a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("uploading crash logs got error: ");
                    stringBuilder.append(th.getMessage());
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                    callbacks.onFailed(crash);
                }
            }, this.f9377b.doRequest(context));
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("uploading crash logs got Json error: ");
            stringBuilder.append(context2.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            callbacks.onFailed(crash);
        }
    }
}
