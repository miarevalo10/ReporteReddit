package com.reddit.frontpage.commons.analytics.events.v1;

public class NewUserPromptEvent extends BaseEvent<PromptResponsePayload> {
    private static final String EVENT_TOPIC = "usercontrol_events";
    private static final String EVENT_TYPE = "cs.tap_android";
    public static final String RESPONSE_NO = "newuser_no";
    public static final String RESPONSE_YES = "newuser_yes";
    private static final String SCREEN_NAME = "new_user_survey";

    public static class PromptResponsePayload extends BasePayload {
        public String promptResponse;
    }

    public final String mo6418a() {
        return "usercontrol_events";
    }

    public final String mo6419b() {
        return "cs.tap_android";
    }

    public NewUserPromptEvent() {
        super(SCREEN_NAME);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new PromptResponsePayload();
    }
}
