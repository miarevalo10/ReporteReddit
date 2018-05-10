package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.io.Serializable;
import org.parceler.Parcel;

@Parcel
public class VideoUpload extends BaseModel implements Serializable, Comparable<VideoUpload> {
    int attempts;
    int duration;
    String filePath;
    boolean gif;
    int id;
    int originalDuration;
    String posterUrl;
    String requestId;
    String source;
    int status;
    String subreddit;
    String thumbnail;
    long timestamp;
    String title;
    long uploadDuration;
    String uploadError;
    String uploadUrl;
    int videoHeight;
    String videoKey;
    int videoWidth;

    public boolean hasPostData() {
        return (TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.subreddit) || TextUtils.isEmpty(this.filePath)) ? false : true;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubreddit() {
        return this.subreddit;
    }

    public void setSubreddit(String str) {
        this.subreddit = str;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
    }

    public String getPosterUrl() {
        return this.posterUrl;
    }

    public void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public String getVideoKey() {
        return this.videoKey;
    }

    public void setVideoKey(String str) {
        this.videoKey = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean isGif() {
        return this.gif;
    }

    public void setGif(boolean z) {
        this.gif = z;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int i) {
        this.attempts = i;
    }

    public int getOriginalDuration() {
        return this.originalDuration;
    }

    public void setOriginalDuration(int i) {
        this.originalDuration = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public long getUploadDuration() {
        return this.uploadDuration;
    }

    public void setUploadDuration(long j) {
        this.uploadDuration = j;
    }

    public String getUploadError() {
        return this.uploadError;
    }

    public void setUploadError(String str) {
        this.uploadError = str;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x00cf;
    L_0x0007:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x00cf;
    L_0x0013:
        r7 = (com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload) r7;
        r2 = r6.id;
        r3 = r7.id;
        if (r2 != r3) goto L_0x00ce;
    L_0x001b:
        r2 = r6.timestamp;
        r4 = r7.timestamp;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x00ce;
    L_0x0023:
        r2 = r6.status;
        r3 = r7.status;
        if (r2 != r3) goto L_0x00ce;
    L_0x0029:
        r2 = r6.gif;
        r3 = r7.gif;
        if (r2 != r3) goto L_0x00ce;
    L_0x002f:
        r2 = r6.attempts;
        r3 = r7.attempts;
        if (r2 != r3) goto L_0x00ce;
    L_0x0035:
        r2 = r6.requestId;
        if (r2 == 0) goto L_0x0044;
    L_0x0039:
        r2 = r6.requestId;
        r3 = r7.requestId;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x0043:
        goto L_0x0048;
    L_0x0044:
        r2 = r7.requestId;
        if (r2 != 0) goto L_0x00ce;
    L_0x0048:
        r2 = r6.filePath;
        if (r2 == 0) goto L_0x0057;
    L_0x004c:
        r2 = r6.filePath;
        r3 = r7.filePath;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x0056:
        goto L_0x005b;
    L_0x0057:
        r2 = r7.filePath;
        if (r2 != 0) goto L_0x00ce;
    L_0x005b:
        r2 = r6.title;
        if (r2 == 0) goto L_0x006a;
    L_0x005f:
        r2 = r6.title;
        r3 = r7.title;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x0069:
        goto L_0x006e;
    L_0x006a:
        r2 = r7.title;
        if (r2 != 0) goto L_0x00ce;
    L_0x006e:
        r2 = r6.subreddit;
        if (r2 == 0) goto L_0x007d;
    L_0x0072:
        r2 = r6.subreddit;
        r3 = r7.subreddit;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x007c:
        goto L_0x0081;
    L_0x007d:
        r2 = r7.subreddit;
        if (r2 != 0) goto L_0x00ce;
    L_0x0081:
        r2 = r6.uploadUrl;
        if (r2 == 0) goto L_0x0090;
    L_0x0085:
        r2 = r6.uploadUrl;
        r3 = r7.uploadUrl;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x008f:
        goto L_0x0094;
    L_0x0090:
        r2 = r7.uploadUrl;
        if (r2 != 0) goto L_0x00ce;
    L_0x0094:
        r2 = r6.posterUrl;
        if (r2 == 0) goto L_0x00a3;
    L_0x0098:
        r2 = r6.posterUrl;
        r3 = r7.posterUrl;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x00a2:
        goto L_0x00a7;
    L_0x00a3:
        r2 = r7.posterUrl;
        if (r2 != 0) goto L_0x00ce;
    L_0x00a7:
        r2 = r6.thumbnail;
        if (r2 == 0) goto L_0x00b6;
    L_0x00ab:
        r2 = r6.thumbnail;
        r3 = r7.thumbnail;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ce;
    L_0x00b5:
        goto L_0x00ba;
    L_0x00b6:
        r2 = r7.thumbnail;
        if (r2 != 0) goto L_0x00ce;
    L_0x00ba:
        r2 = r6.videoKey;
        if (r2 == 0) goto L_0x00c9;
    L_0x00be:
        r2 = r6.videoKey;
        r7 = r7.videoKey;
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x00ce;
    L_0x00c8:
        goto L_0x00cd;
    L_0x00c9:
        r7 = r7.videoKey;
        if (r7 != 0) goto L_0x00ce;
    L_0x00cd:
        return r0;
    L_0x00ce:
        return r1;
    L_0x00cf:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((this.id * 31) + (this.requestId != null ? this.requestId.hashCode() : 0)) * 31) + (this.filePath != null ? this.filePath.hashCode() : 0)) * 31) + (this.title != null ? this.title.hashCode() : 0)) * 31) + (this.subreddit != null ? this.subreddit.hashCode() : 0)) * 31) + (this.uploadUrl != null ? this.uploadUrl.hashCode() : 0)) * 31) + (this.posterUrl != null ? this.posterUrl.hashCode() : 0)) * 31) + (this.thumbnail != null ? this.thumbnail.hashCode() : 0)) * 31;
        if (this.videoKey != null) {
            i = this.videoKey.hashCode();
        }
        return (31 * (((((((hashCode + i) * 31) + ((int) (this.timestamp ^ (this.timestamp >>> 32)))) * 31) + this.status) * 31) + this.gif)) + this.attempts;
    }

    public int compareTo(VideoUpload videoUpload) {
        if (this.timestamp > videoUpload.timestamp) {
            return -1;
        }
        return this.timestamp == videoUpload.timestamp ? null : 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VideoUpload{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", requestId='");
        stringBuilder.append(this.requestId);
        stringBuilder.append('\'');
        stringBuilder.append(", filePath='");
        stringBuilder.append(this.filePath);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", subreddit='");
        stringBuilder.append(this.subreddit);
        stringBuilder.append('\'');
        stringBuilder.append(", uploadUrl='");
        stringBuilder.append(this.uploadUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", posterUrl='");
        stringBuilder.append(this.posterUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", thumbnail='");
        stringBuilder.append(this.thumbnail);
        stringBuilder.append('\'');
        stringBuilder.append(", videoKey='");
        stringBuilder.append(this.videoKey);
        stringBuilder.append('\'');
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", gif=");
        stringBuilder.append(this.gif);
        stringBuilder.append(", attempts=");
        stringBuilder.append(this.attempts);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
