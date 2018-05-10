package com.reddit.datalibrary.frontpage.requests.models.v1;

public class WikiPageData extends BaseThing {
    private String content_html;
    private String content_md;
    private String may_revise;
    private UserWrapper revision_by;
    private long revision_date;

    public WikiPageData() {
        super((byte) 0);
    }
}
