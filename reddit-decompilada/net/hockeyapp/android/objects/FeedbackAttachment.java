package net.hockeyapp.android.objects;

import java.io.Serializable;

public class FeedbackAttachment implements Serializable {
    private static final long serialVersionUID = 5059651319640956830L;
    private String mCreatedAt;
    private String mFilename;
    private int mId;
    private int mMessageId;
    private String mUpdatedAt;
    private String mUrl;

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public int getMessageId() {
        return this.mMessageId;
    }

    public void setMessageId(int i) {
        this.mMessageId = i;
    }

    public String getFilename() {
        return this.mFilename;
    }

    public void setFilename(String str) {
        this.mFilename = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public void setCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public String getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public void setUpdatedAt(String str) {
        this.mUpdatedAt = str;
    }

    public String getCacheId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mMessageId);
        stringBuilder.append(this.mId);
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append(FeedbackAttachment.class.getSimpleName());
        stringBuilder.append("\nid         ");
        stringBuilder.append(this.mId);
        stringBuilder.append("\nmessage id ");
        stringBuilder.append(this.mMessageId);
        stringBuilder.append("\nfilename   ");
        stringBuilder.append(this.mFilename);
        stringBuilder.append("\nurl        ");
        stringBuilder.append(this.mUrl);
        stringBuilder.append("\ncreatedAt  ");
        stringBuilder.append(this.mCreatedAt);
        stringBuilder.append("\nupdatedAt  ");
        stringBuilder.append(this.mUpdatedAt);
        return stringBuilder.toString();
    }
}
