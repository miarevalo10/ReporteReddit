package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SyndicationClientEvent extends ScribeEvent {
    @SerializedName(a = "language")
    public final String f30752f;
    @SerializedName(a = "event_info")
    public final String f30753g;
    @SerializedName(a = "external_ids")
    public final ExternalIds f30754h;

    public class ExternalIds {
        @SerializedName(a = "6")
        public final String f24020a;
        final /* synthetic */ SyndicationClientEvent f24021b;

        public ExternalIds(SyndicationClientEvent syndicationClientEvent, String str) {
            this.f24021b = syndicationClientEvent;
            this.f24020a = str;
        }
    }

    public SyndicationClientEvent(EventNamespace eventNamespace, String str, long j, String str2, String str3, List<ScribeItem> list) {
        super("tfw_client_event", eventNamespace, j, list);
        this.f30752f = str2;
        this.f30753g = str;
        this.f30754h = new ExternalIds(this, str3);
    }
}
