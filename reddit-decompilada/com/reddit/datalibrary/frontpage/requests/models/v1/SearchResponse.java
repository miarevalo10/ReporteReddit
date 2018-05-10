package com.reddit.datalibrary.frontpage.requests.models.v1;

public class SearchResponse {
    public final LinkListing mLinks;
    public final SubredditListing mSubreddits;

    public SearchResponse(SubredditListing subredditListing, LinkListing linkListing) {
        this.mSubreddits = subredditListing;
        this.mLinks = linkListing;
    }
}
