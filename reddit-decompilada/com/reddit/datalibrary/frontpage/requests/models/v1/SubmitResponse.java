package com.reddit.datalibrary.frontpage.requests.models.v1;

public class SubmitResponse extends GenericResponse<LinkResult> {
    public static final String ERROR_RATELIMIT = "RATELIMIT";
    public static final String ERROR_SUBREDDIT_NOEXISTS = "SUBREDDIT_NOEXIST";

    public class LinkResult {
        private String id;
        private String name;
        final /* synthetic */ SubmitResponse this$0;
        private String url;

        public final String m9392a() {
            return this.id;
        }
    }
}
