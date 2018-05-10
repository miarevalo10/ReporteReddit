package com.reddit.frontpage.commons.analytics.events.v2;

public abstract class VideoPlayerEvent extends BaseEvent<VideoPlayerPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "videoplayer_events";
    public static final String VIDEO_PLAYER_CHANGE_PAGETYPE = "videoplayer__change_pagetype";
    public static final String VIDEO_PLAYER_CLICK_1080 = "videoplayer__click_1080";
    public static final String VIDEO_PLAYER_CLICK_240 = "videoplayer__click_240";
    public static final String VIDEO_PLAYER_CLICK_360 = "videoplayer__click_360";
    public static final String VIDEO_PLAYER_CLICK_480 = "videoplayer__click_480";
    public static final String VIDEO_PLAYER_CLICK_720 = "videoplayer__click_720";
    public static final String VIDEO_PLAYER_CLICK_AUTO = "videoplayer__click_auto";
    public static final String VIDEO_PLAYER_CLICK_FULLSCREEN = "videoplayer__click_fullscreen";
    public static final String VIDEO_PLAYER_CLICK_MUTE = "videoplayer__click_mute";
    public static final String VIDEO_PLAYER_CLICK_OVERFLOW = "videoplayer__click_overflow";
    public static final String VIDEO_PLAYER_CLICK_PAUSE = "videoplayer__click_pause";
    public static final String VIDEO_PLAYER_CLICK_PLAY = "videoplayer__click_play";
    public static final String VIDEO_PLAYER_CLICK_REPLAY = "videoplayer__click_replay";
    public static final String VIDEO_PLAYER_CLICK_SAVE = "videoplayer__click_save";
    public static final String VIDEO_PLAYER_CLICK_SEEK = "videoplayer__click_seek";
    public static final String VIDEO_PLAYER_CLICK_UNMUTE = "videoplayer__click_unmute";
    public static final String VIDEO_PLAYER_PAUSE_CLOSED = "pinnedvideoplayer__pause_closed";
    public static final String VIDEO_PLAYER_ROTATE_FULLSCREEN = "videoplayer__rotate_fullscreen";
    public static final String VIDEO_PLAYER_SCROLL_ACTIVATED = "pinnedvideoplayer__scroll_activated";
    public static final String VIDEO_PLAYER_SCROLL_AUTOPLAY = "videoplayer__scroll_autoplay";
    public static final String VIDEO_PLAYER_SCROLL_PAUSE = "videoplayer__scroll_pause";
    public static final String VIDEO_PLAYER_SERVED_VIDEO = "videoplayer__served_video";

    public static class VideoPlayerPayload extends BasePayload {
        public String base_url;
        public String listing_name;
        public long load_time;
        public long max_timestamp_served;
        public String media_id;
        public boolean nsfw;
        public String page_type;
        public float percent_served;
        public boolean pinned_player;
        public String referrer_domain;
        public String referrer_url;
        public boolean spoiler;
        public String sr_fullname;
        public String target_author_name;
        public long target_created_ts;
        public long target_id;
        public String target_url;
        public String target_url_domain;
        public long user_id;
        public boolean vertical;
        public long video_duration;
        public Long video_first_frame;
        public long video_time;

        private VideoPlayerPayload(String str) {
            super(str);
            this.video_first_frame = null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("VideoPlayerPayload{source='");
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
            stringBuilder.append(", listing_name='");
            stringBuilder.append(this.listing_name);
            stringBuilder.append('\'');
            stringBuilder.append(", load_time=");
            stringBuilder.append(this.load_time);
            stringBuilder.append(", max_timestamp_served=");
            stringBuilder.append(this.max_timestamp_served);
            stringBuilder.append(", nsfw=");
            stringBuilder.append(this.nsfw);
            stringBuilder.append(", page_type='");
            stringBuilder.append(this.page_type);
            stringBuilder.append('\'');
            stringBuilder.append(", percent_served=");
            stringBuilder.append(this.percent_served);
            stringBuilder.append(", pinned_player=");
            stringBuilder.append(this.pinned_player);
            stringBuilder.append(", spoiler=");
            stringBuilder.append(this.spoiler);
            stringBuilder.append(", sr_id=");
            stringBuilder.append(this.sr_id);
            stringBuilder.append(", sr_fullname='");
            stringBuilder.append(this.sr_fullname);
            stringBuilder.append('\'');
            stringBuilder.append(", sr_name='");
            stringBuilder.append(this.sr_name);
            stringBuilder.append('\'');
            stringBuilder.append(", referrer_domain='");
            stringBuilder.append(this.referrer_domain);
            stringBuilder.append('\'');
            stringBuilder.append(", referrer_url='");
            stringBuilder.append(this.referrer_url);
            stringBuilder.append('\'');
            stringBuilder.append(", target_author_name='");
            stringBuilder.append(this.target_author_name);
            stringBuilder.append('\'');
            stringBuilder.append(", target_created_ts=");
            stringBuilder.append(this.target_created_ts);
            stringBuilder.append(", target_id=");
            stringBuilder.append(this.target_id);
            stringBuilder.append(", target_fullname=");
            stringBuilder.append(this.target_fullname);
            stringBuilder.append(", target_url_domain='");
            stringBuilder.append(this.target_url_domain);
            stringBuilder.append('\'');
            stringBuilder.append(", target_url='");
            stringBuilder.append(this.target_url);
            stringBuilder.append('\'');
            stringBuilder.append(", user_id='");
            stringBuilder.append(this.user_id);
            stringBuilder.append('\'');
            stringBuilder.append(", vertical=");
            stringBuilder.append(this.vertical);
            stringBuilder.append(", video_duration=");
            stringBuilder.append(this.video_duration);
            stringBuilder.append(", video_time=");
            stringBuilder.append(this.video_time);
            stringBuilder.append(", media_id='");
            stringBuilder.append(this.media_id);
            stringBuilder.append('\'');
            stringBuilder.append(", video_first_frame=");
            stringBuilder.append(this.video_first_frame);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public final String mo6421a() {
        return DEFAULT_EVENT_TOPIC;
    }

    protected final /* synthetic */ BasePayload mo6422c() {
        return new VideoPlayerPayload(mo6423b());
    }
}
