package com.reddit.datalibrary.frontpage.requests.models.v2.live;

import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;

public interface LiveCommentsUpdate {

    public static class LiveComment extends Comment implements LiveCommentsUpdate {
        LiveComment() {
        }
    }
}
