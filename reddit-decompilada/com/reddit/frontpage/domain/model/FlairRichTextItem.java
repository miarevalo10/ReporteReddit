package com.reddit.frontpage.domain.model;

import com.raizlabs.android.dbflow.structure.BaseModel;
import com.squareup.moshi.Json;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/domain/model/FlairRichTextItem;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "Ljava/io/Serializable;", "emojiMarkup", "", "typeString", "emojiUrl", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmojiMarkup", "()Ljava/lang/String;", "setEmojiMarkup", "(Ljava/lang/String;)V", "getEmojiUrl", "setEmojiUrl", "getText", "setText", "type", "Lcom/reddit/frontpage/domain/model/FlairRichTextItemType;", "getType", "()Lcom/reddit/frontpage/domain/model/FlairRichTextItemType;", "getTypeString", "setTypeString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@Parcel
/* compiled from: FlairRichTextItem.kt */
public final class FlairRichTextItem extends BaseModel implements Serializable {
    @Json(a = "a")
    private String emojiMarkup;
    @Json(a = "u")
    private String emojiUrl;
    @Json(a = "t")
    private String text;
    @Json(a = "e")
    private String typeString;

    public static /* synthetic */ FlairRichTextItem copy$default(FlairRichTextItem flairRichTextItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flairRichTextItem.emojiMarkup;
        }
        if ((i & 2) != 0) {
            str2 = flairRichTextItem.typeString;
        }
        if ((i & 4) != 0) {
            str3 = flairRichTextItem.emojiUrl;
        }
        if ((i & 8) != 0) {
            str4 = flairRichTextItem.text;
        }
        return flairRichTextItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.emojiMarkup;
    }

    public final String component2() {
        return this.typeString;
    }

    public final String component3() {
        return this.emojiUrl;
    }

    public final String component4() {
        return this.text;
    }

    public final FlairRichTextItem copy(String str, String str2, String str3, String str4) {
        Intrinsics.m26847b(str2, "typeString");
        return new FlairRichTextItem(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FlairRichTextItem) {
                FlairRichTextItem flairRichTextItem = (FlairRichTextItem) obj;
                if (Intrinsics.m26845a(this.emojiMarkup, flairRichTextItem.emojiMarkup) && Intrinsics.m26845a(this.typeString, flairRichTextItem.typeString) && Intrinsics.m26845a(this.emojiUrl, flairRichTextItem.emojiUrl) && Intrinsics.m26845a(this.text, flairRichTextItem.text)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.emojiMarkup;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.typeString;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.emojiUrl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("FlairRichTextItem(emojiMarkup=");
        stringBuilder.append(this.emojiMarkup);
        stringBuilder.append(", typeString=");
        stringBuilder.append(this.typeString);
        stringBuilder.append(", emojiUrl=");
        stringBuilder.append(this.emojiUrl);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getEmojiMarkup() {
        return this.emojiMarkup;
    }

    public final void setEmojiMarkup(String str) {
        this.emojiMarkup = str;
    }

    public final String getTypeString() {
        return this.typeString;
    }

    public final void setTypeString(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.typeString = str;
    }

    public final String getEmojiUrl() {
        return this.emojiUrl;
    }

    public final void setEmojiUrl(String str) {
        this.emojiUrl = str;
    }

    public /* synthetic */ FlairRichTextItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != null) {
            str = null;
        }
        if ((i & 4) != null) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        this(str, str2, str3, str4);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public FlairRichTextItem(String str, String str2, String str3, String str4) {
        Intrinsics.m26847b(str2, "typeString");
        this.emojiMarkup = str;
        this.typeString = str2;
        this.emojiUrl = str3;
        this.text = str4;
    }

    public final FlairRichTextItemType getType() {
        return Intrinsics.m26845a(this.typeString, (Object) "text") ? FlairRichTextItemType.Text : FlairRichTextItemType.Emoji;
    }
}
