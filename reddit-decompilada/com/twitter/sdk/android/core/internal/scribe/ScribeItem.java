package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import java.io.Serializable;

public class ScribeItem implements Serializable {
    @SerializedName(a = "item_type")
    public final Integer f24013a;
    @SerializedName(a = "id")
    public final Long f24014b;
    @SerializedName(a = "description")
    public final String f24015c;
    @SerializedName(a = "card_event")
    public final CardEvent f24016d;
    @SerializedName(a = "media_details")
    public final MediaDetails f24017e;

    public static class Builder {
        MediaDetails f24004a;
        private Integer f24005b;
        private Long f24006c;
        private String f24007d;
        private CardEvent f24008e;

        public final Builder m25881a() {
            this.f24005b = Integer.valueOf(0);
            return this;
        }

        public final Builder m25882a(long j) {
            this.f24006c = Long.valueOf(j);
            return this;
        }

        public final ScribeItem m25883b() {
            return new ScribeItem(this.f24005b, this.f24006c, this.f24007d, this.f24008e, this.f24004a);
        }
    }

    public static class CardEvent implements Serializable {
        @SerializedName(a = "promotion_card_type")
        final int f24009a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    return this.f24009a == ((CardEvent) obj).f24009a;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f24009a;
        }
    }

    public static class MediaDetails implements Serializable {
        @SerializedName(a = "content_id")
        public final long f24010a;
        @SerializedName(a = "media_type")
        public final int f24011b;
        @SerializedName(a = "publisher_id")
        public final long f24012c;

        public MediaDetails(long j, int i, long j2) {
            this.f24010a = j;
            this.f24011b = i;
            this.f24012c = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    MediaDetails mediaDetails = (MediaDetails) obj;
                    return this.f24010a == mediaDetails.f24010a && this.f24011b == mediaDetails.f24011b && this.f24012c == mediaDetails.f24012c;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((int) (this.f24010a ^ (this.f24010a >>> 32))) * 31) + this.f24011b)) + ((int) (this.f24012c ^ (this.f24012c >>> 32)));
        }
    }

    private ScribeItem(Integer num, Long l, String str, CardEvent cardEvent, MediaDetails mediaDetails) {
        this.f24013a = num;
        this.f24014b = l;
        this.f24015c = str;
        this.f24016d = cardEvent;
        this.f24017e = mediaDetails;
    }

    public static ScribeItem m25886a(Tweet tweet) {
        return new Builder().m25881a().m25882a(tweet.f24051i).m25883b();
    }

    public static ScribeItem m25884a(long j, Card card) {
        Builder a = new Builder().m25881a().m25882a(j);
        a.f24004a = new MediaDetails(j, 4, Long.valueOf(VineCardUtils.m25865b(card)).longValue());
        return a.m25883b();
    }

    public static ScribeItem m25885a(long j, MediaEntity mediaEntity) {
        Builder a = new Builder().m25881a().m25882a(j);
        a.f24004a = new MediaDetails(j, "animated_gif".equals(mediaEntity.f34649e) ? 3 : 1, mediaEntity.f34646b);
        return a.m25883b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x007a;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x007a;
    L_0x0013:
        r5 = (com.twitter.sdk.android.core.internal.scribe.ScribeItem) r5;
        r2 = r4.f24013a;
        if (r2 == 0) goto L_0x0024;
    L_0x0019:
        r2 = r4.f24013a;
        r3 = r5.f24013a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0029;
    L_0x0023:
        goto L_0x0028;
    L_0x0024:
        r2 = r5.f24013a;
        if (r2 == 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = r4.f24014b;
        if (r2 == 0) goto L_0x0038;
    L_0x002d:
        r2 = r4.f24014b;
        r3 = r5.f24014b;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003d;
    L_0x0037:
        goto L_0x003c;
    L_0x0038:
        r2 = r5.f24014b;
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        return r1;
    L_0x003d:
        r2 = r4.f24015c;
        if (r2 == 0) goto L_0x004c;
    L_0x0041:
        r2 = r4.f24015c;
        r3 = r5.f24015c;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0051;
    L_0x004b:
        goto L_0x0050;
    L_0x004c:
        r2 = r5.f24015c;
        if (r2 == 0) goto L_0x0051;
    L_0x0050:
        return r1;
    L_0x0051:
        r2 = r4.f24016d;
        if (r2 == 0) goto L_0x0060;
    L_0x0055:
        r2 = r4.f24016d;
        r3 = r5.f24016d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0065;
    L_0x005f:
        goto L_0x0064;
    L_0x0060:
        r2 = r5.f24016d;
        if (r2 == 0) goto L_0x0065;
    L_0x0064:
        return r1;
    L_0x0065:
        r2 = r4.f24017e;
        if (r2 == 0) goto L_0x0074;
    L_0x0069:
        r2 = r4.f24017e;
        r5 = r5.f24017e;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x0078;
    L_0x0073:
        goto L_0x0079;
    L_0x0074:
        r5 = r5.f24017e;
        if (r5 != 0) goto L_0x0079;
    L_0x0078:
        return r0;
    L_0x0079:
        return r1;
    L_0x007a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.scribe.ScribeItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((this.f24013a != null ? this.f24013a.hashCode() : 0) * 31) + (this.f24014b != null ? this.f24014b.hashCode() : 0)) * 31) + (this.f24015c != null ? this.f24015c.hashCode() : 0)) * 31) + (this.f24016d != null ? this.f24016d.hashCode() : 0));
        if (this.f24017e != null) {
            i = this.f24017e.hashCode();
        }
        return hashCode + i;
    }
}
