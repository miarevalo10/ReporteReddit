package com.reddit.datalibrary.frontpage.redditauth.models;

import android.text.TextUtils;

public class Scope {
    private static final String ACCOUNT = "account";
    public static final Scope ALL_SCOPE = new Scope(SCOPE_SET_ALL);
    private static final String CREDDITS = "creddits";
    private static final String EDIT = "edit";
    private static final String FLAIR = "flair";
    private static final String HISTORY = "history";
    public static final Scope IDENTIFY_SCOPE = new Scope(SCOPE_SET_IDENTIFY);
    private static final String IDENTITY = "identity";
    private static final String MOD_CONFIG = "modconfig";
    private static final String MOD_CONTRIBUTORS = "modcontributors";
    private static final String MOD_FLAIR = "modflair";
    private static final String MOD_LOG = "modlog";
    private static final String MOD_OTHERS = "modothers";
    private static final String MOD_POSTS = "modposts";
    private static final String MOD_WIKI = "modwiki";
    private static final String MY_SUBREDDITS = "mysubreddits";
    public static final Scope NULL_SCOPE = new Scope(SCOPE_SET_IDENTIFY);
    private static final String PRIVATE_MESSAGES = "privatemessages";
    private static final String READ = "read";
    private static final String REPORT = "report";
    private static final String SAVE = "save";
    public static final String[] SCOPE_SET_ALL = new String[]{IDENTITY, READ, VOTE, REPORT, "submit", EDIT, HISTORY, FLAIR, MOD_CONFIG, MOD_FLAIR, MOD_CONTRIBUTORS, MOD_OTHERS, MOD_LOG, MOD_POSTS, MOD_WIKI, SAVE, MY_SUBREDDITS, PRIVATE_MESSAGES, SUBSCRIBE, WIKI_EDIT, WIKI_READ, ACCOUNT, CREDDITS};
    public static final String[] SCOPE_SET_IDENTIFY = new String[]{IDENTITY};
    public static final String[] SCOPE_SET_WILD = new String[]{"*"};
    private static final String SUBMIT = "submit";
    private static final String SUBSCRIBE = "subscribe";
    private static final String VOTE = "vote";
    private static final String WIKI_EDIT = "wikiedit";
    private static final String WIKI_READ = "wikiread";
    private static final String WILD = "*";
    public static final Scope WILD_SCOPE = new Scope(SCOPE_SET_WILD);
    private final String[] mScopes;

    public Scope(String[] strArr) {
        this.mScopes = strArr;
    }

    public static Scope fromString(String str) {
        return new Scope(str.split(","));
    }

    public String toString() {
        return TextUtils.join(",", this.mScopes);
    }
}
