package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SyndicatedSdkImpressionEvent extends ScribeEvent {
    @SerializedName(a = "external_ids")
    public final ExternalIds f30749f;
    @SerializedName(a = "device_id_created_at")
    public final long f30750g = null;
    @SerializedName(a = "language")
    public final String f30751h;

    public class ExternalIds {
        @SerializedName(a = "AD_ID")
        public final String f24018a;
        final /* synthetic */ SyndicatedSdkImpressionEvent f24019b;

        public ExternalIds(SyndicatedSdkImpressionEvent syndicatedSdkImpressionEvent, String str) {
            this.f24019b = syndicatedSdkImpressionEvent;
            this.f24018a = str;
        }
    }

    public SyndicatedSdkImpressionEvent(EventNamespace eventNamespace, long j, String str, String str2, List<ScribeItem> list) {
        super("syndicated_sdk_impression", eventNamespace, j, list);
        this.f30751h = str;
        this.f30749f = new ExternalIds(this, str2);
    }
}
