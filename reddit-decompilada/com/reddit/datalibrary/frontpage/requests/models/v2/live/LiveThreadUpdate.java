package com.reddit.datalibrary.frontpage.requests.models.v2.live;

import com.google.gson.annotations.SerializedName;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import java.util.List;

public abstract class LiveThreadUpdate {

    public static class EmbedsReady extends LiveThreadUpdate {
        @SerializedName(a = "mobile_embeds")
        List<MobileEmbed> embeds;
        @SerializedName(a = "liveupdate_id")
        String name;

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5007a(this.name, this.embeds);
        }
    }

    public static class SettingsUpdated extends LiveThreadUpdate {
        @SerializedName(a = "payload")
        LiveThread updated;

        public SettingsUpdated(LiveThread liveThread) {
            this.updated = liveThread;
        }

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5004a(this.updated);
        }
    }

    public static class ThreadCompleted extends LiveThreadUpdate {
        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
        }
    }

    public static class UpdateAdded extends LiveThreadUpdate {
        @SerializedName(a = "data")
        LiveUpdate liveUpdate;

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5005a(this.liveUpdate);
        }
    }

    public static class UpdateDeleted extends LiveThreadUpdate {
        String name;

        public UpdateDeleted(String str) {
            this.name = str;
        }

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5008b(this.name);
        }
    }

    public static class UpdateStricken extends LiveThreadUpdate {
        String name;

        public UpdateStricken(String str) {
            this.name = str;
        }

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5006a(this.name);
        }
    }

    public static class ViewerCountChanged extends LiveThreadUpdate {
        int count;
        boolean fuzzed;

        public final void mo4462a(LiveThreadUpdater liveThreadUpdater) {
            liveThreadUpdater.mo5003a(this.count);
        }
    }

    public abstract void mo4462a(LiveThreadUpdater liveThreadUpdater);
}
