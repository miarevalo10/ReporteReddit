package com.instabug.library;

import java.util.HashMap;

public class InstabugCustomTextPlaceHolder {
    private HashMap<Key, String> placeHoldersMap = new HashMap();

    public enum Key {
        SHAKE_HINT,
        SWIPE_HINT,
        INVALID_EMAIL_MESSAGE,
        INVALID_COMMENT_MESSAGE,
        INVOCATION_HEADER,
        START_CHATS,
        REPORT_BUG,
        REPORT_FEEDBACK,
        EMAIL_FIELD_HINT,
        COMMENT_FIELD_HINT_FOR_BUG_REPORT,
        COMMENT_FIELD_HINT_FOR_FEEDBACK,
        ADD_VOICE_MESSAGE,
        ADD_IMAGE_FROM_GALLERY,
        ADD_EXTRA_SCREENSHOT,
        CONVERSATIONS_LIST_TITLE,
        AUDIO_RECORDING_PERMISSION_DENIED,
        CONVERSATION_TEXT_FIELD_HINT,
        BUG_REPORT_HEADER,
        FEEDBACK_REPORT_HEADER,
        VOICE_MESSAGE_PRESS_AND_HOLD_TO_RECORD,
        VOICE_MESSAGE_RELEASE_TO_ATTACH,
        REPORT_SUCCESSFULLY_SENT,
        SUCCESS_DIALOG_HEADER,
        ADD_VIDEO,
        VIDEO_PLAYER_TITLE
    }

    public void set(Key key, String str) {
        this.placeHoldersMap.put(key, str);
    }

    public String get(Key key) {
        return this.placeHoldersMap.containsKey(key) ? (String) this.placeHoldersMap.get(key) : null;
    }

    public void setPlaceHoldersMap(HashMap<Key, String> hashMap) {
        this.placeHoldersMap = hashMap;
    }
}
