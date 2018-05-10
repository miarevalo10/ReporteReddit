package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

public class TweetBuilder {
    private String f24069A;
    private List<Integer> f24070B = Collections.EMPTY_LIST;
    private boolean f24071C;
    private User f24072D;
    private boolean f24073E;
    private List<String> f24074F = Collections.EMPTY_LIST;
    private String f24075G;
    private Card f24076H;
    public boolean f24077a;
    public long f24078b = -1;
    private Coordinates f24079c;
    private String f24080d;
    private Object f24081e;
    private TweetEntities f24082f;
    private TweetEntities f24083g;
    private Integer f24084h;
    private String f24085i;
    private String f24086j;
    private String f24087k;
    private long f24088l;
    private String f24089m;
    private long f24090n;
    private String f24091o;
    private String f24092p;
    private Place f24093q;
    private boolean f24094r;
    private Object f24095s;
    private long f24096t;
    private String f24097u;
    private Tweet f24098v;
    private int f24099w;
    private boolean f24100x;
    private Tweet f24101y;
    private String f24102z;

    public final TweetBuilder m25893a(Tweet tweet) {
        this.f24079c = tweet.f24043a;
        this.f24080d = tweet.f24044b;
        this.f24081e = tweet.f24045c;
        this.f24082f = tweet.f24046d;
        this.f24083g = tweet.f24047e;
        this.f24084h = tweet.f24048f;
        this.f24077a = tweet.f24049g;
        this.f24085i = tweet.f24050h;
        this.f24078b = tweet.f24051i;
        this.f24086j = tweet.f24052j;
        this.f24087k = tweet.f24053k;
        this.f24088l = tweet.f24054l;
        this.f24089m = tweet.f24055m;
        this.f24090n = tweet.f24056n;
        this.f24091o = tweet.f24055m;
        this.f24092p = tweet.f24058p;
        this.f24093q = tweet.f24059q;
        this.f24094r = tweet.f24060r;
        this.f24095s = tweet.f24061s;
        this.f24096t = tweet.f24062t;
        this.f24097u = tweet.f24063u;
        this.f24098v = tweet.f24064v;
        this.f24099w = tweet.f24065w;
        this.f24100x = tweet.f24066x;
        this.f24101y = tweet.f24067y;
        this.f24102z = tweet.f24068z;
        this.f24069A = tweet.f24035A;
        this.f24070B = tweet.f24036B;
        this.f24071C = tweet.f24037C;
        this.f24072D = tweet.f24038D;
        this.f24073E = tweet.f24039E;
        this.f24074F = tweet.f24040F;
        this.f24075G = tweet.f24041G;
        this.f24076H = tweet.f24042H;
        return this;
    }

    public final Tweet m25892a() {
        Coordinates coordinates = this.f24079c;
        String str = this.f24080d;
        Object obj = this.f24081e;
        TweetEntities tweetEntities = this.f24082f;
        TweetEntities tweetEntities2 = this.f24083g;
        Integer num = this.f24084h;
        boolean z = this.f24077a;
        String str2 = this.f24085i;
        long j = this.f24078b;
        String str3 = this.f24086j;
        String str4 = this.f24087k;
        long j2 = this.f24088l;
        String str5 = this.f24089m;
        long j3 = j2;
        long j4 = this.f24090n;
        String str6 = this.f24091o;
        String str7 = this.f24092p;
        String str8 = str6;
        Place place = this.f24093q;
        boolean z2 = this.f24094r;
        Object obj2 = this.f24095s;
        String str9 = str7;
        long j5 = this.f24096t;
        str6 = this.f24097u;
        String str10 = str6;
        return new Tweet(coordinates, str, obj, tweetEntities, tweetEntities2, num, z, str2, j, str3, str4, j3, str5, j4, str8, str9, place, z2, obj2, j5, str10, this.f24098v, this.f24099w, this.f24100x, this.f24101y, this.f24102z, this.f24069A, this.f24070B, this.f24071C, this.f24072D, this.f24073E, this.f24074F, this.f24075G, this.f24076H);
    }
}
