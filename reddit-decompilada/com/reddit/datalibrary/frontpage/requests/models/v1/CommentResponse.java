package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

public class CommentResponse {
    public CommentListing commentListing;
    public Link link;

    public CommentResponse(Link link, CommentListing commentListing) {
        this.link = link;
        this.commentListing = commentListing;
    }
}
