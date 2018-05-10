package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class CommentEditResponse extends GenericResponse<CommentEditList> {

    public class CommentEditList {
        public final List<CommentWrapper> things;
        final /* synthetic */ CommentEditResponse this$0;
    }
}
