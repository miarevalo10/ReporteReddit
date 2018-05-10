package io.fabric.sdk.android.services.settings;

import android.content.res.Resources.NotFoundException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

abstract class AbstractAppSpiCall extends AbstractSpiCall {
    public AbstractAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public boolean mo6604a(AppRequestData appRequestData) {
        HttpRequest a = m31992a(getHttpRequest().header(AbstractSpiCall.HEADER_API_KEY, appRequestData.f24877a).header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android").header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion()), appRequestData);
        StringBuilder stringBuilder = new StringBuilder("Sending app info to ");
        stringBuilder.append(getUrl());
        Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
        if (appRequestData.f24886j != null) {
            stringBuilder = new StringBuilder("App icon hash is ");
            stringBuilder.append(appRequestData.f24886j.hash);
            Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
            stringBuilder = new StringBuilder("App icon size is ");
            stringBuilder.append(appRequestData.f24886j.width);
            stringBuilder.append("x");
            stringBuilder.append(appRequestData.f24886j.height);
            Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
        }
        appRequestData = a.code();
        String str = HttpRequest.METHOD_POST.equals(a.method()) ? "Create" : "Update";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(" app request ID: ");
        stringBuilder2.append(a.header(AbstractSpiCall.HEADER_REQUEST_ID));
        Fabric.m26243b().mo5562a("Fabric", stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder("Result was ");
        stringBuilder3.append(appRequestData);
        Fabric.m26243b().mo5562a("Fabric", stringBuilder3.toString());
        return ResponseParser.m26362a(appRequestData) == null ? true : null;
    }

    private HttpRequest m31992a(HttpRequest httpRequest, AppRequestData appRequestData) {
        Closeable openRawResource;
        Throwable e;
        StringBuilder stringBuilder;
        httpRequest = httpRequest.part("app[identifier]", appRequestData.f24878b).part("app[name]", appRequestData.f24882f).part("app[display_version]", appRequestData.f24879c).part("app[build_version]", appRequestData.f24880d).part("app[source]", Integer.valueOf(appRequestData.f24883g)).part("app[minimum_sdk_version]", appRequestData.f24884h).part("app[built_sdk_version]", appRequestData.f24885i);
        if (!CommonUtils.m26308d(appRequestData.f24881e)) {
            httpRequest.part("app[instance_identifier]", appRequestData.f24881e);
        }
        if (appRequestData.f24886j != null) {
            try {
                openRawResource = this.kit.getContext().getResources().openRawResource(appRequestData.f24886j.iconResourceId);
                try {
                    httpRequest.part("app[icon][hash]", appRequestData.f24886j.hash).part("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) openRawResource).part("app[icon][width]", Integer.valueOf(appRequestData.f24886j.width)).part("app[icon][height]", Integer.valueOf(appRequestData.f24886j.height));
                } catch (NotFoundException e2) {
                    e = e2;
                    try {
                        stringBuilder = new StringBuilder("Failed to find app icon with resource ID: ");
                        stringBuilder.append(appRequestData.f24886j.iconResourceId);
                        Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), e);
                        CommonUtils.m26294a(openRawResource, "Failed to close app icon InputStream.");
                        if (appRequestData.f24887k != null) {
                            for (KitInfo kitInfo : appRequestData.f24887k) {
                                httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kitInfo.f24711a}), kitInfo.f24712b);
                                httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kitInfo.f24711a}), kitInfo.f24713c);
                            }
                        }
                        return httpRequest;
                    } catch (Throwable th) {
                        httpRequest = th;
                        CommonUtils.m26294a(openRawResource, "Failed to close app icon InputStream.");
                        throw httpRequest;
                    }
                }
            } catch (Throwable e3) {
                Throwable th2 = e3;
                openRawResource = null;
                e = th2;
                stringBuilder = new StringBuilder("Failed to find app icon with resource ID: ");
                stringBuilder.append(appRequestData.f24886j.iconResourceId);
                Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), e);
                CommonUtils.m26294a(openRawResource, "Failed to close app icon InputStream.");
                if (appRequestData.f24887k != null) {
                    for (KitInfo kitInfo2 : appRequestData.f24887k) {
                        httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kitInfo2.f24711a}), kitInfo2.f24712b);
                        httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kitInfo2.f24711a}), kitInfo2.f24713c);
                    }
                }
                return httpRequest;
            } catch (Throwable th3) {
                httpRequest = th3;
                openRawResource = null;
                CommonUtils.m26294a(openRawResource, "Failed to close app icon InputStream.");
                throw httpRequest;
            }
            CommonUtils.m26294a(openRawResource, "Failed to close app icon InputStream.");
        }
        if (appRequestData.f24887k != null) {
            for (KitInfo kitInfo22 : appRequestData.f24887k) {
                httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kitInfo22.f24711a}), kitInfo22.f24712b);
                httpRequest.part(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kitInfo22.f24711a}), kitInfo22.f24713c);
            }
        }
        return httpRequest;
    }
}
