package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.Gildable;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import java.io.Serializable;

public class CommentWrapper extends ReplyableWrapper<Comment> implements Gildable, Votable, Serializable {
    public String getDomain() {
        return null;
    }

    public int getVoteDirection() {
        return ((Comment) getData()).getVoteDirection();
    }

    public int getScore() {
        return ((Comment) getData()).getScore();
    }

    public String getName() {
        return ((Comment) getData()).getName();
    }

    public boolean isScoreHidden() {
        return ((Comment) getData()).isScoreHidden();
    }

    public final String mo3814a() {
        return ((Comment) getData()).parent_id;
    }

    public int getGilded() {
        return ((Comment) getData()).getGilded();
    }

    public String getVotableType() {
        return ((Comment) getData()).getVotableType();
    }

    public String getInstanceId() {
        return ((Comment) getData()).getInstanceId();
    }
}
