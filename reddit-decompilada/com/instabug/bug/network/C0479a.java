package com.instabug.bug.network;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.instabug.bug.cache.BugsCacheManager;
import com.instabug.bug.model.Bug;
import com.instabug.bug.settings.C0485a;
import com.instabug.library.broadcast.LastContactedChangedBroadcast;
import com.instabug.library.core.InstabugCore;
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
import com.instabug.library.util.StringUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;

/* compiled from: BugsService */
public class C0479a {
    private static C0479a f9114a;
    private NetworkManager f9115b = new NetworkManager();

    public static C0479a m7775a() {
        if (f9114a == null) {
            f9114a = new C0479a();
        }
        return f9114a;
    }

    private C0479a() {
    }

    public final void m7776a(final Context context, Bug bug, final Callbacks<String, Throwable> callbacks) throws JSONException, IOException {
        StringBuilder stringBuilder = new StringBuilder("Reporting a bug with message: ");
        stringBuilder.append(bug.f15313d);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        Request buildRequest = this.f9115b.buildRequest(context, Endpoint.ReportBug, RequestMethod.Post);
        ArrayList stateItems = bug.getState().getStateItems();
        for (int i = 0; i < stateItems.size(); i++) {
            StringBuilder stringBuilder2 = new StringBuilder("Bug State Key: ");
            stringBuilder2.append(((StateItem) stateItems.get(i)).getKey());
            stringBuilder2.append(", Bug State value: ");
            stringBuilder2.append(((StateItem) stateItems.get(i)).getValue());
            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
            buildRequest.addRequestBodyParameter(((StateItem) bug.getState().getStateItems().get(i)).getKey(), ((StateItem) bug.getState().getStateItems().get(i)).getValue());
        }
        buildRequest.addRequestBodyParameter("title", bug.f15313d);
        buildRequest.addRequestBodyParameter("attachments_count", Integer.valueOf(bug.f15314e.size()));
        buildRequest.addRequestBodyParameter("categories", StringUtility.toCommaSeparated(bug.f15320k));
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0479a f18505c;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("reportingBugRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append("Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                try {
                    callbacks.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("id"));
                } catch (Throwable e) {
                    StringBuilder stringBuilder2 = new StringBuilder("reportingBugRequest onNext got error: ");
                    stringBuilder2.append(e.getMessage());
                    InstabugSDKLogger.m8358e(this, stringBuilder2.toString(), e);
                }
                if (requestResponse.getResponseCode() == 200) {
                    obj = Calendar.getInstance(Locale.ENGLISH);
                    stringBuilder = new StringBuilder("Updating last_contacted_at to ");
                    stringBuilder.append(obj.getTime());
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                    C0485a.m7793a();
                    C0485a.m7794a(obj.getTime().getTime());
                    InstabugCore.setLastContactedAt(obj.getTime().getTime());
                    Intent intent = new Intent();
                    intent.setAction(LastContactedChangedBroadcast.LAST_CONTACTED_CHANGED);
                    intent.putExtra(LastContactedChangedBroadcast.LAST_CONTACTED_AT, obj.getTime().getTime());
                    LocalBroadcastManager.m744a(context).m748a(intent);
                }
            }

            public final void aV_() {
                InstabugSDKLogger.m8356d(this, "reportingBugRequest started");
            }

            public final void m19367b() {
                InstabugSDKLogger.m8356d(this, "reportingBugRequest completed");
            }

            public final void m19366a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("reportingBugRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                callbacks.onFailed(th);
            }
        }, this.f9115b.doRequest(buildRequest));
    }

    public final void m7777b(Context context, final Bug bug, final Callbacks<Boolean, Bug> callbacks) throws JSONException, FileNotFoundException {
        InstabugSDKLogger.m8356d(this, "Uploading Bug attachments");
        Observable[] observableArr = new Observable[bug.f15314e.size()];
        for (int i = 0; i < observableArr.length; i++) {
            Attachment attachment = (Attachment) bug.f15314e.get(i);
            Request buildRequest = this.f9115b.buildRequest(context, Endpoint.AddBugAttachment, RequestMethod.Post, RequestType.MULTI_PART);
            buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":bug_token", bug.f15311b));
            buildRequest.addParameter("metadata[file_type]", attachment.getType());
            if (attachment.getType() == Type.AUDIO) {
                buildRequest.addParameter("metadata[duration]", attachment.getDuration());
            }
            buildRequest.setFileToUpload(new FileToUpload("file", attachment.getName(), attachment.getLocalPath(), attachment.getFileType()));
            observableArr[i] = this.f9115b.doRequest(buildRequest);
        }
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0479a f18508c;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("uploadingBugAttachmentRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append(", Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                if (new File(((Attachment) bug.f15314e.get(0)).getLocalPath()).delete() != null) {
                    InstabugSDKLogger.m8356d(this, "uploadingBugAttachmentRequest onNext, attachment file deleted successfully");
                }
                bug.f15314e.remove(0);
                BugsCacheManager.addBug(bug);
                BugsCacheManager.saveCacheToDisk();
            }

            public final void aV_() {
                InstabugSDKLogger.m8356d(this, "uploadingBugAttachmentRequest started");
            }

            public final void m19369b() {
                InstabugSDKLogger.m8356d(this, "uploadingBugAttachmentRequest completed");
                if (bug.f15314e.size() == 0) {
                    callbacks.onSucceeded(Boolean.valueOf(true));
                }
            }

            public final void m19368a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("uploadingBugAttachmentRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                callbacks.onFailed(bug);
            }
        }, Observable.b(observableArr));
    }

    public final void m7778c(Context context, final Bug bug, final Callbacks<Boolean, Bug> callbacks) {
        try {
            context = this.f9115b.buildRequest(context, Endpoint.bugLogs, RequestMethod.Post);
            context.setEndpoint(context.getEndpoint().replaceAll(":bug_token", bug.f15311b));
            Iterator it = bug.getState().getLogsItems().iterator();
            while (it.hasNext()) {
                StateItem stateItem = (StateItem) it.next();
                context.addRequestBodyParameter(stateItem.getKey(), stateItem.getValue());
            }
            if (bug.f15316g != null) {
                context.addRequestBodyParameter("view_hierarchy", bug.f15316g);
            }
            Observable.a(new Subscriber<RequestResponse>(this) {
                final /* synthetic */ C0479a f18511c;

                public final /* synthetic */ void a_(Object obj) {
                    RequestResponse requestResponse = (RequestResponse) obj;
                    StringBuilder stringBuilder = new StringBuilder("uploading bug logs onNext, Response code: ");
                    stringBuilder.append(requestResponse.getResponseCode());
                    stringBuilder.append("Response body: ");
                    stringBuilder.append(requestResponse.getResponseBody());
                    InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                }

                public final void aV_() {
                    InstabugSDKLogger.m8356d(this, "uploading bug logs started");
                }

                public final void m19371b() {
                    InstabugSDKLogger.m8356d(this, "uploading bug logs completed");
                    callbacks.onSucceeded(Boolean.valueOf(true));
                }

                public final void m19370a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("uploading bug logs got error: ");
                    stringBuilder.append(th.getMessage());
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                    callbacks.onFailed(bug);
                }
            }, this.f9115b.doRequest(context));
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("uploading bug logs got Json error: ");
            stringBuilder.append(context2.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            callbacks.onFailed(bug);
        }
    }
}
