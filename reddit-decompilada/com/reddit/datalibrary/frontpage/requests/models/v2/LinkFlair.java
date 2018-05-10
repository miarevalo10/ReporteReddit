package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.frontpage.util.RichTextUtil;
import java.io.Serializable;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class LinkFlair implements Serializable {
    String id;
    List<FlairRichTextItem> richtext;
    String text;
    boolean text_editable;
    String type;

    public LinkFlair(String str, boolean z, String str2) {
        this.text = str;
        this.text_editable = z;
        this.id = str2;
    }

    public String getText() {
        return this.text;
    }

    public boolean getTextEditable() {
        return this.text_editable;
    }

    public String getId() {
        return this.id;
    }

    public String getFlairRichText() {
        if (this.richtext != null) {
            return RichTextUtil.m23882a(this.richtext);
        }
        return this.text != null ? this.text : "";
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LinkFlair) {
            return hashCode() == obj.hashCode() ? true : null;
        } else {
            return super.equals(obj);
        }
    }
}
