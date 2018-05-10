package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import org.parceler.Parcel;

@Parcel
public class LiveThread extends ClientIdentified implements Thing, Listable, Shareable {
    private static final String STATE_LIVE = "live";
    long created_utc;
    String description;
    String description_html;
    String id;
    String name;
    Boolean nsfw;
    String resources_html;
    String state;
    String subreddit;
    String title;
    int viewer_count;
    Boolean viewer_count_fuzzed;
    String websocket_url;

    public int getListableType() {
        return 3;
    }

    public int getMinAndroidVersion() {
        return 0;
    }

    LiveThread() {
    }

    LiveThread(long j) {
        super(j);
    }

    public void merge(LiveThread liveThread) {
        if (!TextUtils.isEmpty(liveThread.title)) {
            this.title = liveThread.getTitle();
        }
        if (!TextUtils.isEmpty(liveThread.description)) {
            this.description = liveThread.getDescription();
        }
        if (!TextUtils.isEmpty(liveThread.description_html)) {
            this.description_html = liveThread.description_html;
        }
        if (liveThread.nsfw != null) {
            this.nsfw = liveThread.nsfw;
        }
        if (liveThread.viewer_count_fuzzed != null) {
            this.viewer_count_fuzzed = liveThread.viewer_count_fuzzed;
        }
        if (liveThread.resources_html != null) {
            this.resources_html = liveThread.resources_html;
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getCreatedUtc() {
        return this.created_utc;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.websocket_url;
    }

    public Boolean isOver18() {
        return this.nsfw;
    }

    public Boolean isViewerCountFuzzed() {
        return this.viewer_count_fuzzed;
    }

    public Boolean isNsfw() {
        return isOver18();
    }

    public long getUniqueID() {
        return this._uniqueId;
    }

    public int getViewerCount() {
        return this.viewer_count;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionHtml() {
        return this.description_html;
    }

    public String getResourcesHtml() {
        return this.resources_html;
    }

    public String getState() {
        return this.state;
    }

    public boolean isLive() {
        return "live".equals(this.state);
    }

    public String getPermalink() {
        StringBuilder stringBuilder = new StringBuilder("https://www.reddit.com/live/");
        stringBuilder.append(this.id);
        return stringBuilder.toString();
    }
}
