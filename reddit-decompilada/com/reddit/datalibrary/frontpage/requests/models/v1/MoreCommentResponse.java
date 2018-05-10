package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class MoreCommentResponse {
    public Json json;

    public class Data {
        public List<ReplyableWrapper> things;
        final /* synthetic */ MoreCommentResponse this$0;
    }

    public class Json {
        public Data data;
        final /* synthetic */ MoreCommentResponse this$0;
    }
}
