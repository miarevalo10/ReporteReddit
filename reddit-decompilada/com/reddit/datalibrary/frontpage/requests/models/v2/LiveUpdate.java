package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.frontpage.util.Util;
import java.util.Collections;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class LiveUpdate implements Identifiable {
    long _uniqueId;
    String author;
    String body;
    String body_html;
    long created_utc;
    String id;
    List<MobileEmbed> mobile_embeds;
    String name;
    boolean stricken;

    @Parcel
    public static class MobileEmbed {
        String description;
        int height;
        String original_url;
        String provider_name;
        String provider_url;
        int thumbnail_height;
        String thumbnail_url;
        int thumbnail_width;
        String title;
        String type;
        String url;
        int width;

        public String getProviderUrl() {
            return this.provider_url;
        }

        public String getDescription() {
            return this.description;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public String getOriginalUrl() {
            return this.original_url;
        }

        public String getProviderName() {
            return this.provider_name;
        }

        public String getType() {
            return this.type;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public String getThumbnailUrl() {
            return this.thumbnail_url;
        }

        public int getThumbnailWidth() {
            return this.thumbnail_width;
        }

        public int getThumbnailHeight() {
            return this.thumbnail_height;
        }
    }

    LiveUpdate() {
        this.mobile_embeds = Collections.emptyList();
        this._uniqueId = Util.m24013d();
    }

    LiveUpdate(long j) {
        this.mobile_embeds = Collections.emptyList();
        this._uniqueId = j;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getBody() {
        return this.body;
    }

    public String getBodyHtml() {
        return this.body_html;
    }

    public boolean isStricken() {
        return this.stricken;
    }

    public void setStricken(boolean z) {
        this.stricken = z;
    }

    public List<MobileEmbed> getMobileEmbeds() {
        return this.mobile_embeds;
    }

    public void setMobileEmbeds(List<MobileEmbed> list) {
        this.mobile_embeds = list;
    }

    public long getCreatedUtc() {
        return this.created_utc;
    }

    public long getUniqueID() {
        return this._uniqueId;
    }
}
