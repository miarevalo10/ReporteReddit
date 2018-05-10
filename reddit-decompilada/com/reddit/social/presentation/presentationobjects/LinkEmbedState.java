package com.reddit.social.presentation.presentationobjects;

import com.reddit.social.presentation.messaginglist.LinkEmbed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "Error", "Loaded", "NotLoaded", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$Loaded;", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$NotLoaded;", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$Error;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkContentMessageData.kt */
public abstract class LinkEmbedState {
    private final String url;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$Error;", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "embedUrl", "", "(Ljava/lang/String;)V", "getEmbedUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkContentMessageData.kt */
    public static final class Error extends LinkEmbedState {
        private final String f29943a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Error) {
                    if (Intrinsics.m26845a(this.f29943a, ((Error) obj).f29943a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f29943a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Error(embedUrl=");
            stringBuilder.append(this.f29943a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Error(String str) {
            Intrinsics.m26847b(str, "embedUrl");
            super(str);
            this.f29943a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$Loaded;", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "embedUrl", "", "linkEmbed", "Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "(Ljava/lang/String;Lcom/reddit/social/presentation/messaginglist/LinkEmbed;)V", "getEmbedUrl", "()Ljava/lang/String;", "getLinkEmbed", "()Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkContentMessageData.kt */
    public static final class Loaded extends LinkEmbedState {
        public final LinkEmbed f29944a;
        private final String f29945b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Loaded) {
                    Loaded loaded = (Loaded) obj;
                    if (Intrinsics.m26845a(this.f29945b, loaded.f29945b) && Intrinsics.m26845a(this.f29944a, loaded.f29944a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f29945b;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            LinkEmbed linkEmbed = this.f29944a;
            if (linkEmbed != null) {
                i = linkEmbed.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Loaded(embedUrl=");
            stringBuilder.append(this.f29945b);
            stringBuilder.append(", linkEmbed=");
            stringBuilder.append(this.f29944a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Loaded(String str, LinkEmbed linkEmbed) {
            Intrinsics.m26847b(str, "embedUrl");
            Intrinsics.m26847b(linkEmbed, "linkEmbed");
            super(str);
            this.f29945b = str;
            this.f29944a = linkEmbed;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState$NotLoaded;", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "embedUrl", "", "(Ljava/lang/String;)V", "getEmbedUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkContentMessageData.kt */
    public static final class NotLoaded extends LinkEmbedState {
        private final String f29946a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof NotLoaded) {
                    if (Intrinsics.m26845a(this.f29946a, ((NotLoaded) obj).f29946a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f29946a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotLoaded(embedUrl=");
            stringBuilder.append(this.f29946a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public NotLoaded(String str) {
            Intrinsics.m26847b(str, "embedUrl");
            super(str);
            this.f29946a = str;
        }
    }

    private LinkEmbedState(String str) {
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
