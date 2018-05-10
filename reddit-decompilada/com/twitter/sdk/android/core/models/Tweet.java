package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tweet {
    @SerializedName(a = "text", b = {"full_text"})
    public final String f24035A;
    @SerializedName(a = "display_text_range")
    public final List<Integer> f24036B;
    @SerializedName(a = "truncated")
    public final boolean f24037C;
    @SerializedName(a = "user")
    public final User f24038D;
    @SerializedName(a = "withheld_copyright")
    public final boolean f24039E;
    @SerializedName(a = "withheld_in_countries")
    public final List<String> f24040F;
    @SerializedName(a = "withheld_scope")
    public final String f24041G;
    @SerializedName(a = "card")
    public final Card f24042H;
    @SerializedName(a = "coordinates")
    public final Coordinates f24043a;
    @SerializedName(a = "created_at")
    public final String f24044b;
    @SerializedName(a = "current_user_retweet")
    public final Object f24045c;
    @SerializedName(a = "entities")
    public final TweetEntities f24046d;
    @SerializedName(a = "extended_entities")
    public final TweetEntities f24047e;
    @SerializedName(a = "favorite_count")
    public final Integer f24048f;
    @SerializedName(a = "favorited")
    public final boolean f24049g;
    @SerializedName(a = "filter_level")
    public final String f24050h;
    @SerializedName(a = "id")
    public final long f24051i;
    @SerializedName(a = "id_str")
    public final String f24052j;
    @SerializedName(a = "in_reply_to_screen_name")
    public final String f24053k;
    @SerializedName(a = "in_reply_to_status_id")
    public final long f24054l;
    @SerializedName(a = "in_reply_to_status_id_str")
    public final String f24055m;
    @SerializedName(a = "in_reply_to_user_id")
    public final long f24056n;
    @SerializedName(a = "in_reply_to_user_id_str")
    public final String f24057o;
    @SerializedName(a = "lang")
    public final String f24058p;
    @SerializedName(a = "place")
    public final Place f24059q;
    @SerializedName(a = "possibly_sensitive")
    public final boolean f24060r;
    @SerializedName(a = "scopes")
    public final Object f24061s;
    @SerializedName(a = "quoted_status_id")
    public final long f24062t;
    @SerializedName(a = "quoted_status_id_str")
    public final String f24063u;
    @SerializedName(a = "quoted_status")
    public final Tweet f24064v;
    @SerializedName(a = "retweet_count")
    public final int f24065w;
    @SerializedName(a = "retweeted")
    public final boolean f24066x;
    @SerializedName(a = "retweeted_status")
    public final Tweet f24067y;
    @SerializedName(a = "source")
    public final String f24068z;

    public Tweet(Coordinates coordinates, String str, Object obj, TweetEntities tweetEntities, TweetEntities tweetEntities2, Integer num, boolean z, String str2, long j, String str3, String str4, long j2, String str5, long j3, String str6, String str7, Place place, boolean z2, Object obj2, long j4, String str8, Tweet tweet, int i, boolean z3, Tweet tweet2, String str9, String str10, List<Integer> list, boolean z4, User user, boolean z5, List<String> list2, String str11, Card card) {
        this.f24043a = coordinates;
        this.f24044b = str;
        this.f24045c = obj;
        this.f24046d = tweetEntities;
        this.f24047e = tweetEntities2;
        this.f24048f = num;
        this.f24049g = z;
        this.f24050h = str2;
        this.f24051i = j;
        this.f24052j = str3;
        this.f24053k = str4;
        this.f24054l = j2;
        this.f24055m = str5;
        this.f24056n = j3;
        this.f24057o = str6;
        this.f24058p = str7;
        this.f24059q = place;
        this.f24060r = z2;
        this.f24061s = obj2;
        this.f24062t = j4;
        this.f24063u = str8;
        this.f24064v = tweet;
        this.f24065w = i;
        this.f24066x = z3;
        this.f24067y = tweet2;
        this.f24068z = str9;
        this.f24035A = str10;
        this.f24036B = list;
        this.f24037C = z4;
        this.f24038D = user;
        this.f24039E = z5;
        this.f24040F = list2;
        this.f24041G = str11;
        this.f24042H = card;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tweet)) {
            return false;
        }
        if (this.f24051i == ((Tweet) obj).f24051i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) this.f24051i;
    }
}
