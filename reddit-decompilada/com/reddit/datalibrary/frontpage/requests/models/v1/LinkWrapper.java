package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.Commentable;
import com.reddit.datalibrary.frontpage.requests.models.Gildable;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

@Deprecated
public class LinkWrapper extends ThingWrapper<Link> implements Commentable, Gildable, Votable {
    public String getDomain() {
        return ((Link) getData()).getDomain();
    }

    public int getScore() {
        return ((Link) getData()).getScore();
    }

    public int getGilded() {
        return ((Link) getData()).getGilded();
    }

    public String getName() {
        return ((Link) getData()).getName();
    }

    public boolean isScoreHidden() {
        return ((Link) getData()).isScoreHidden();
    }

    public String getVotableType() {
        return ((Link) getData()).getVotableType();
    }

    public String getInstanceId() {
        return ((Link) getData()).getInstanceId();
    }

    public int getVoteDirection() {
        Boolean likes = ((Link) getData()).getLikes();
        if (likes == null) {
            return 0;
        }
        return likes.booleanValue() ? 1 : -1;
    }
}
