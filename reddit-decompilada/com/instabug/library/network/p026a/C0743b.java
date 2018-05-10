package com.instabug.library.network.p026a;

import android.content.Context;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.NetworkManager.RequestType;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* compiled from: FilesService */
public class C0743b {
    private static C0743b f9839a;
    private NetworkManager f9840b = new NetworkManager();

    public static C0743b m8306a() {
        if (f9839a == null) {
            f9839a = new C0743b();
        }
        return f9839a;
    }

    private C0743b() {
    }

    public final Subscription m8307a(Context context, final AssetEntity assetEntity, final Callbacks<AssetEntity, Throwable> callbacks) {
        StringBuilder stringBuilder;
        InstabugSDKLogger.m8356d(this, "Downloading file request");
        Context context2 = null;
        try {
            context = this.f9840b.buildRequest(context, assetEntity.getUrl(), RequestMethod.Get, RequestType.FILE_DOWNLOAD);
            try {
                context.setDownloadedFile(assetEntity.getFile().getPath());
            } catch (JSONException e) {
                JSONException jSONException = e;
                context2 = context;
                context = jSONException;
                stringBuilder = new StringBuilder("create downloadFile request got error: ");
                stringBuilder.append(context.getMessage());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                context = context2;
                return Observable.a(new Subscriber<RequestResponse>(this) {
                    final /* synthetic */ C0743b f18578c;

                    public final /* synthetic */ void a_(Object obj) {
                        RequestResponse requestResponse = (RequestResponse) obj;
                        StringBuilder stringBuilder = new StringBuilder("downloadFile request onNext, Response code: ");
                        stringBuilder.append(requestResponse.getResponseCode());
                        stringBuilder.append(", Response body: ");
                        stringBuilder.append(requestResponse.getResponseBody());
                        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                        callbacks.onSucceeded(assetEntity);
                    }

                    public final void aV_() {
                        InstabugSDKLogger.m8356d(this, "downloadFile request started");
                    }

                    public final void m19512b() {
                        InstabugSDKLogger.m8356d(this, "downloadFile request completed");
                    }

                    public final void m19511a(Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder("downloadFile request got error: ");
                        stringBuilder.append(th.getMessage());
                        InstabugSDKLogger.m8357e(this, stringBuilder.toString());
                        callbacks.onFailed(th);
                    }
                }, this.f9840b.doRequest(context).b(Schedulers.d()).a(AndroidSchedulers.a()));
            }
        } catch (JSONException e2) {
            context = e2;
            stringBuilder = new StringBuilder("create downloadFile request got error: ");
            stringBuilder.append(context.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            context = context2;
            return Observable.a(/* anonymous class already generated */, this.f9840b.doRequest(context).b(Schedulers.d()).a(AndroidSchedulers.a()));
        }
        return Observable.a(/* anonymous class already generated */, this.f9840b.doRequest(context).b(Schedulers.d()).a(AndroidSchedulers.a()));
    }
}
