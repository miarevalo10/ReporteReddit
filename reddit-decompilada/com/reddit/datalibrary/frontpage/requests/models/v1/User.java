package com.reddit.datalibrary.frontpage.requests.models.v1;

public class User extends BaseThing {
    private long comment_karma;
    private boolean is_gold;
    private boolean is_mod;
    private long link_karma;

    public User() {
        super((byte) 0);
    }
}
