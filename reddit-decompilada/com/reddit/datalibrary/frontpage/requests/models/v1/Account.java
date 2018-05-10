package com.reddit.datalibrary.frontpage.requests.models.v1;

public class Account extends BaseThing {
    public final int comment_karma;
    public final Features features;
    public int gold_creddits;
    public final boolean has_mail;
    public final boolean has_mod_mail;
    public final boolean has_verified_email;
    public final boolean hide_ads;
    public final boolean hide_from_robots;
    public final boolean in_beta;
    public final boolean in_chat;
    public int inbox_count;
    public final boolean is_employee;
    public final boolean is_friend;
    public final boolean is_gold;
    public final boolean is_mod;
    public final boolean is_suspended;
    public final int link_karma;
    public final Subreddit subreddit;
    public final Integer suspension_expiration_utc;

    public final boolean m19785a() {
        return this.is_gold;
    }
}
