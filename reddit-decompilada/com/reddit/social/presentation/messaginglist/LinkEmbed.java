package com.reddit.social.presentation.messaginglist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "", "url", "", "siteName", "title", "description", "favicon", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getFavicon", "getImage", "getSiteName", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
public final class LinkEmbed {
    public final String f22377a;
    public final String f22378b;
    public final String f22379c;
    public final String f22380d;
    public final String f22381e;
    public final String f22382f;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkEmbed) {
                LinkEmbed linkEmbed = (LinkEmbed) obj;
                if (Intrinsics.m26845a(this.f22377a, linkEmbed.f22377a) && Intrinsics.m26845a(this.f22378b, linkEmbed.f22378b) && Intrinsics.m26845a(this.f22379c, linkEmbed.f22379c) && Intrinsics.m26845a(this.f22380d, linkEmbed.f22380d) && Intrinsics.m26845a(this.f22381e, linkEmbed.f22381e) && Intrinsics.m26845a(this.f22382f, linkEmbed.f22382f)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f22377a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f22378b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22379c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22380d;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22381e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22382f;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkEmbed(url=");
        stringBuilder.append(this.f22377a);
        stringBuilder.append(", siteName=");
        stringBuilder.append(this.f22378b);
        stringBuilder.append(", title=");
        stringBuilder.append(this.f22379c);
        stringBuilder.append(", description=");
        stringBuilder.append(this.f22380d);
        stringBuilder.append(", favicon=");
        stringBuilder.append(this.f22381e);
        stringBuilder.append(", image=");
        stringBuilder.append(this.f22382f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkEmbed(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(str2, "siteName");
        this.f22377a = str;
        this.f22378b = str2;
        this.f22379c = str3;
        this.f22380d = str4;
        this.f22381e = str5;
        this.f22382f = str6;
    }
}
