package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.reddit.frontpage.domain.model.FlairRichTextItemType;
import java.io.Serializable;
import org.parceler.Parcel;

@Parcel
public class FlairRichTextItem extends BaseModel implements Serializable {
    @SerializedName(a = "a")
    public String emojiMarkup;
    @SerializedName(a = "u")
    public String emojiUrl;
    @SerializedName(a = "t")
    public String text;
    @SerializedName(a = "e")
    public String typeString;

    public FlairRichTextItem(com.reddit.frontpage.domain.model.FlairRichTextItem flairRichTextItem) {
        this.emojiMarkup = flairRichTextItem.getEmojiMarkup();
        this.typeString = flairRichTextItem.getTypeString();
        this.emojiUrl = flairRichTextItem.getEmojiUrl();
        this.text = flairRichTextItem.getText();
    }

    public FlairRichTextItemType getType() {
        if (this.typeString.equals("text")) {
            return FlairRichTextItemType.Text;
        }
        return FlairRichTextItemType.Emoji;
    }
}
