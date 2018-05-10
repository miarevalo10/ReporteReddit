package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.io.Serializable;

public class CommunityRule implements Thing, Serializable {
    private final long created_utc;
    private final String description;
    private final String description_html;
    private String id;
    private final String kind;
    private final int priority;
    private final String short_name;
    private final String violation_reason;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.short_name;
    }

    public long getCreatedUtc() {
        return this.created_utc;
    }
}
