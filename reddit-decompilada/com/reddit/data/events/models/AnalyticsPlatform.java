package com.reddit.data.events.models;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0012\u0010\u0018\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/reddit/data/events/models/AnalyticsPlatform;", "", "appInstallTime", "", "getAppInstallTime", "()Ljava/lang/Long;", "appVersionCode", "", "getAppVersionCode", "()I", "appVersionName", "", "getAppVersionName", "()Ljava/lang/String;", "browserName", "getBrowserName", "deviceId", "getDeviceId", "deviceName", "getDeviceName", "osName", "getOsName", "osVersion", "getOsVersion", "platformName", "getPlatformName", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsPlatform.kt */
public interface AnalyticsPlatform {
    Long getAppInstallTime();

    int getAppVersionCode();

    String getAppVersionName();

    String getBrowserName();

    String getDeviceId();

    String getDeviceName();

    String getOsName();

    String getOsVersion();

    String getPlatformName();
}
