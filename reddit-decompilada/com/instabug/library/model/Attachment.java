package com.instabug.library.model;

import android.webkit.MimeTypeMap;
import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Attachment implements Cacheable, Serializable {
    static final String KEY_ATTACHMENT_STATE = "attachment_state";
    static final String KEY_DURATION = "duration";
    static final String KEY_LOCALE_PATH = "local_path";
    static final String KEY_NAME = "name";
    static final String KEY_TYPE = "type";
    static final String KEY_URL = "url";
    static final String KEY_VIDEO_ENCODED = "video_encoded";
    private AttachmentState attachmentState;
    private String duration;
    private boolean isVideoEncoded = false;
    private String localPath;
    private String name;
    private Type type;
    private String url;

    public enum AttachmentState {
        OFFLINE,
        SYNCED,
        NOT_AVAILABLE
    }

    public enum Type {
        MAIN_SCREENSHOT("main-screenshot"),
        IMAGE(com.instabug.chat.model.Attachment.TYPE_IMAGE),
        AUDIO(com.instabug.chat.model.Attachment.TYPE_AUDIO),
        VIDEO(com.instabug.chat.model.Attachment.TYPE_VIDEO),
        ATTACHMENT_FILE("attachment-file"),
        VIEW_HIERARCHY("view-hierarchy"),
        NOT_AVAILABLE("not-available"),
        VISUAL_USER_STEPS("user-repro-steps"),
        AUTO_SCREEN_RECORDING("auto-screen-recording");
        
        private static final Map<String, Type> lookup = null;
        private final String name;

        static {
            lookup = new HashMap();
            Type[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                Type type = values[i];
                lookup.put(type.name, type);
                i++;
            }
        }

        private Type(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }

        public static Type get(String str) {
            Type type = (Type) lookup.get(str);
            return type == null ? NOT_AVAILABLE : type;
        }
    }

    public Attachment() {
        setType(Type.NOT_AVAILABLE);
        setAttachmentState(AttachmentState.NOT_AVAILABLE);
    }

    public static JSONArray toJson(ArrayList<Attachment> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(new JSONObject(((Attachment) arrayList.get(i)).toJson()));
        }
        return jSONArray;
    }

    public static ArrayList<Attachment> fromJson(JSONArray jSONArray) throws JSONException {
        ArrayList<Attachment> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Attachment attachment = new Attachment();
            attachment.fromJson(jSONArray.getJSONObject(i).toString());
            arrayList.add(attachment);
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }

    public Attachment setName(String str) {
        this.name = str;
        return this;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public Attachment setLocalPath(String str) {
        this.localPath = str;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Attachment setUrl(String str) {
        this.url = str;
        return this;
    }

    public Type getType() {
        return this.type;
    }

    public Attachment setType(Type type) {
        this.type = type;
        return this;
    }

    public boolean isVideoEncoded() {
        return this.isVideoEncoded;
    }

    public Attachment setVideoEncoded(boolean z) {
        this.isVideoEncoded = z;
        return this;
    }

    public String getFileType() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getName());
        if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("")) {
            return getType().toString();
        }
        fileExtensionFromUrl = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        return (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("")) ? getType().toString() : fileExtensionFromUrl;
    }

    public AttachmentState getAttachmentState() {
        return this.attachmentState;
    }

    public Attachment setAttachmentState(AttachmentState attachmentState) {
        this.attachmentState = attachmentState;
        return this;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_NAME, getName()).put(KEY_LOCALE_PATH, getLocalPath()).put("url", getUrl()).put(KEY_TYPE, getType().toString()).put(KEY_ATTACHMENT_STATE, getAttachmentState().toString()).put(KEY_VIDEO_ENCODED, isVideoEncoded()).put("duration", getDuration());
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(KEY_NAME) != null) {
            setName(jSONObject.getString(KEY_NAME));
        }
        if (jSONObject.has(KEY_LOCALE_PATH) != null) {
            setLocalPath(jSONObject.getString(KEY_LOCALE_PATH));
        }
        if (jSONObject.has("url") != null) {
            setUrl(jSONObject.getString("url"));
        }
        if (jSONObject.has(KEY_TYPE) != null) {
            setType(Type.get(jSONObject.getString(KEY_TYPE)));
        }
        if (jSONObject.has(KEY_ATTACHMENT_STATE) != null) {
            setAttachmentState(AttachmentState.valueOf(jSONObject.getString(KEY_ATTACHMENT_STATE)));
        }
        if (jSONObject.has(KEY_VIDEO_ENCODED) != null) {
            setVideoEncoded(jSONObject.getBoolean(KEY_VIDEO_ENCODED));
        }
        if (jSONObject.has("duration") != null) {
            setDuration(jSONObject.getString("duration"));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name: ");
        stringBuilder.append(getName());
        stringBuilder.append(", Local Path: ");
        stringBuilder.append(getLocalPath());
        stringBuilder.append(", Type: ");
        stringBuilder.append(getType());
        stringBuilder.append(", Duration: ");
        stringBuilder.append(getDuration());
        stringBuilder.append(", Url: ");
        stringBuilder.append(getUrl());
        stringBuilder.append(", Attachment State: ");
        stringBuilder.append(getAttachmentState());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) obj;
        if (String.valueOf(attachment.getName()).equals(String.valueOf(getName())) && String.valueOf(attachment.getLocalPath()).equals(String.valueOf(getLocalPath())) && String.valueOf(attachment.getUrl()).equals(String.valueOf(getUrl())) && attachment.getType() == getType() && attachment.getAttachmentState() == getAttachmentState() && attachment.isVideoEncoded() == isVideoEncoded() && String.valueOf(attachment.getDuration()).equals(String.valueOf(getDuration())) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getName() != null ? getName().hashCode() : -1;
    }
}
