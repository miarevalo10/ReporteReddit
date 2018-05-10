package com.reddit.frontpage.commons.analytics.events.v2;

public class VideoUploadEvent extends BaseEvent<VideoUploadPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "videoupload_events";
    private static final String DEFAULT_EVENT_TYPE = "videoupload__upload_video";

    public static class VideoUploadPayload extends BasePayload {
        public String base_url;
        public boolean is_retry;
        public int original_duration;
        public String process_notes;
        public String referrer_domain;
        public String sr_fullname;
        public boolean successful;
        public boolean trimmed;
        public long upload_duration;
        public long user_id;
        public int video_duration;
        public int video_height;
        public String video_mimetype;
        public int video_size;
        public String video_source;
        public boolean video_to_gif;
        public String video_url;
        public int video_width;

        private VideoUploadPayload(String str) {
            super(str);
            this.video_mimetype = "video/mp4";
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("VideoUploadPayload{source='");
            stringBuilder.append(this.source);
            stringBuilder.append('\'');
            stringBuilder.append(", verb='");
            stringBuilder.append(this.verb);
            stringBuilder.append('\'');
            stringBuilder.append(", noun='");
            stringBuilder.append(this.noun);
            stringBuilder.append('\'');
            stringBuilder.append(", base_url='");
            stringBuilder.append(this.base_url);
            stringBuilder.append('\'');
            stringBuilder.append(", is_retry=");
            stringBuilder.append(this.is_retry);
            stringBuilder.append(", original_duration=");
            stringBuilder.append(this.original_duration);
            stringBuilder.append(", process_notes='");
            stringBuilder.append(this.process_notes);
            stringBuilder.append('\'');
            stringBuilder.append(", referrer_domain='");
            stringBuilder.append(this.referrer_domain);
            stringBuilder.append('\'');
            stringBuilder.append(", sr_fullname='");
            stringBuilder.append(this.sr_fullname);
            stringBuilder.append('\'');
            stringBuilder.append(", sr_name='");
            stringBuilder.append(this.sr_name);
            stringBuilder.append('\'');
            stringBuilder.append(", trimmed=");
            stringBuilder.append(this.trimmed);
            stringBuilder.append(", upload_duration=");
            stringBuilder.append(this.upload_duration);
            stringBuilder.append(", user_id=");
            stringBuilder.append(this.user_id);
            stringBuilder.append(", successful=");
            stringBuilder.append(this.successful);
            stringBuilder.append(", video_duration=");
            stringBuilder.append(this.video_duration);
            stringBuilder.append(", video_height=");
            stringBuilder.append(this.video_height);
            stringBuilder.append(", video_mimetype='");
            stringBuilder.append(this.video_mimetype);
            stringBuilder.append('\'');
            stringBuilder.append(", video_size=");
            stringBuilder.append(this.video_size);
            stringBuilder.append(", video_source='");
            stringBuilder.append(this.video_source);
            stringBuilder.append('\'');
            stringBuilder.append(", video_to_gif=");
            stringBuilder.append(this.video_to_gif);
            stringBuilder.append(", video_url='");
            stringBuilder.append(this.video_url);
            stringBuilder.append('\'');
            stringBuilder.append(", video_width=");
            stringBuilder.append(this.video_width);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public final String mo6421a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6423b() {
        return DEFAULT_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6422c() {
        return new VideoUploadPayload(DEFAULT_EVENT_TYPE);
    }
}
