package com.instabug.chat.model;

import android.webkit.MimeTypeMap;
import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import org.jcodec.common.StringUtils;
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
    public static final String STATE_NOT_AVAILABLE = "not_available";
    public static final String STATE_OFFLINE = "offline";
    public static final String STATE_SYNCED = "synced";
    public static final String TYPE_AUDIO = "audio";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_NOT_AVAILABLE = "not_available";
    public static final String TYPE_VIDEO = "video";
    private String duration;
    private boolean isVideoEncoded = false;
    private String localPath;
    private String name;
    private String state;
    private String type;
    private String url;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttachmentState {
    }

    public Attachment() {
        setType("not_available");
        setState("not_available");
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

    public String getType() {
        return this.type;
    }

    public Attachment setType(String str) {
        this.type = str;
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
        if (fileExtensionFromUrl == null || StringUtils.isEmpty(fileExtensionFromUrl)) {
            return getType();
        }
        fileExtensionFromUrl = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        return (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("")) ? getType() : fileExtensionFromUrl;
    }

    public String getState() {
        return this.state;
    }

    public Attachment setState(String str) {
        this.state = str;
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
        jSONObject.put(KEY_NAME, getName()).put(KEY_LOCALE_PATH, getLocalPath()).put("url", getUrl()).put(KEY_TYPE, getType()).put(KEY_ATTACHMENT_STATE, getState().toString()).put(KEY_VIDEO_ENCODED, isVideoEncoded()).put("duration", getDuration());
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        int hashCode;
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
        Object obj = 1;
        if (jSONObject.has(KEY_TYPE) != null) {
            str = jSONObject.getString(KEY_TYPE);
            hashCode = str.hashCode();
            if (hashCode == 93166550) {
                if (str.equals(TYPE_AUDIO) != null) {
                    str = 1;
                    switch (str) {
                        case null:
                            setType(TYPE_IMAGE);
                            break;
                        case 1:
                            setType(TYPE_AUDIO);
                            break;
                        case 2:
                            setType(TYPE_VIDEO);
                            break;
                        default:
                            setType("not_available");
                            break;
                    }
                }
            } else if (hashCode == 100313435) {
                if (str.equals(TYPE_IMAGE) != null) {
                    str = null;
                    switch (str) {
                        case null:
                            setType(TYPE_IMAGE);
                            break;
                        case 1:
                            setType(TYPE_AUDIO);
                            break;
                        case 2:
                            setType(TYPE_VIDEO);
                            break;
                        default:
                            setType("not_available");
                            break;
                    }
                }
            } else if (hashCode == 112202875) {
                if (str.equals(TYPE_VIDEO) != null) {
                    str = 2;
                    switch (str) {
                        case null:
                            setType(TYPE_IMAGE);
                            break;
                        case 1:
                            setType(TYPE_AUDIO);
                            break;
                        case 2:
                            setType(TYPE_VIDEO);
                            break;
                        default:
                            setType("not_available");
                            break;
                    }
                }
            }
            str = -1;
            switch (str) {
                case null:
                    setType(TYPE_IMAGE);
                    break;
                case 1:
                    setType(TYPE_AUDIO);
                    break;
                case 2:
                    setType(TYPE_VIDEO);
                    break;
                default:
                    setType("not_available");
                    break;
            }
        }
        if (jSONObject.has(KEY_ATTACHMENT_STATE) != null) {
            str = jSONObject.getString(KEY_ATTACHMENT_STATE);
            hashCode = str.hashCode();
            if (hashCode == -1548612125) {
                if (str.equals(STATE_OFFLINE) != null) {
                    obj = null;
                    switch (obj) {
                        case null:
                            setState(STATE_OFFLINE);
                            break;
                        case 1:
                            setState(STATE_SYNCED);
                            break;
                        default:
                            setState("not_available");
                            break;
                    }
                }
            } else if (hashCode == -887493510) {
                if (str.equals(STATE_SYNCED) != null) {
                    switch (obj) {
                        case null:
                            setState(STATE_OFFLINE);
                            break;
                        case 1:
                            setState(STATE_SYNCED);
                            break;
                        default:
                            setState("not_available");
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    setState(STATE_OFFLINE);
                    break;
                case 1:
                    setState(STATE_SYNCED);
                    break;
                default:
                    setState("not_available");
                    break;
            }
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
        stringBuilder.append(", Url: ");
        stringBuilder.append(getUrl());
        stringBuilder.append(", Attachment State: ");
        stringBuilder.append(getState());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) obj;
        if (String.valueOf(attachment.getName()).equals(String.valueOf(getName())) && String.valueOf(attachment.getLocalPath()).equals(String.valueOf(getLocalPath())) && String.valueOf(attachment.getUrl()).equals(String.valueOf(getUrl())) && attachment.getType().equals(getType()) && attachment.getState().equals(getState()) && attachment.isVideoEncoded() == isVideoEncoded() && String.valueOf(attachment.getDuration()).equals(String.valueOf(getDuration())) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getName() != null ? getName().hashCode() : -1;
    }
}
