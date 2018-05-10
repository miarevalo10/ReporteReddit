package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class CommentReplyResponse extends GenericResponse<CommentReplyList> {

    public class CommentReplyList {
        public final List<CommentWrapper> things;
        final /* synthetic */ CommentReplyResponse this$0;
    }
}
