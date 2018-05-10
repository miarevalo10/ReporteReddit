package com.reddit.datalibrary.frontpage.requests.models.frontpage;

import com.reddit.datalibrary.frontpage.requests.models.v1.BaseThing;

public class Topic extends BaseThing {
    private String display_name;
    private String icon_url;
    private String key_color;
    private String path;

    public Topic() {
        super((byte) 0);
    }
}
