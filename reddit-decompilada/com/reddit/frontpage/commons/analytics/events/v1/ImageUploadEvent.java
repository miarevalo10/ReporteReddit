package com.reddit.frontpage.commons.analytics.events.v1;

public class ImageUploadEvent extends BaseEvent<ImageUploadPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "image_upload_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.upload_image";

    public static class ImageUploadPayload extends BasePayload {
        public String base_url;
        public int image_height;
        public String image_mimetype;
        public int image_size;
        public String image_source;
        public String image_url;
        public int image_width;
        public String process_notes;
        public Boolean succesful;

        private ImageUploadPayload() {
        }
    }

    public final String mo6418a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return DEFAULT_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ImageUploadPayload();
    }
}
