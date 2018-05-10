package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.io.UnsupportedEncodingException;
import net.hockeyapp.android.UpdateFragment;

public abstract class BaseMessage {
    protected long f22562b;
    protected String f22563c;
    protected String f22564d;
    protected long f22565e;
    protected long f22566f;

    protected static BaseMessage m24874a(JsonElement jsonElement, String str, String str2) {
        try {
            JsonObject h = jsonElement.m25073h();
            String c = h.m31130b("type").mo5244c();
            Object obj = -1;
            int hashCode = c.hashCode();
            if (hashCode != 2004227) {
                if (hashCode != 2047193) {
                    if (hashCode != 2157948) {
                        if (hashCode == 2362860) {
                            if (c.equals("MESG")) {
                                obj = null;
                            }
                        }
                    } else if (c.equals("FILE")) {
                        obj = 1;
                    }
                } else if (c.equals("BRDM")) {
                    obj = 2;
                }
            } else if (c.equals("ADMM")) {
                obj = 3;
            }
            long j = 0;
            switch (obj) {
                case null:
                    String c2 = h.m31129a("req_id") ? h.m31130b("req_id").mo5244c() : "";
                    User user = new User(h.m31130b("user"));
                    long e = h.m31130b("message_id").mo5246e();
                    String c3 = h.m31130b("message").mo5244c();
                    String c4 = h.m31130b("data").mo5244c();
                    long e2 = h.m31130b("created_at").mo5246e();
                    if (h.m31129a("updated_at")) {
                        j = h.m31130b("updated_at").mo5246e();
                    }
                    return new UserMessage(UserMessage.m31079a(c2, e, user, str, str2, c3, c4, h.m31129a("custom_type") ? h.m31130b("custom_type").mo5244c() : null, h.m31129a("translations") ? h.m31130b("translations").toString() : null, e2, j));
                case 1:
                    String c5 = h.m31129a("req_id") ? h.m31130b("req_id").mo5244c() : "";
                    User user2 = new User(h.m31130b("user"));
                    long e3 = h.m31130b("message_id").mo5246e();
                    JsonObject h2 = h.m31130b("file").m25073h();
                    String c6 = h2.m31130b(UpdateFragment.FRAGMENT_URL).mo5244c();
                    String c7 = h2.m31130b("name").mo5244c();
                    String c8 = h2.m31130b("type").mo5244c();
                    int f = h2.m31130b("size").mo5247f();
                    String c9 = h2.m31130b("data").mo5244c();
                    long e4 = h.m31130b("created_at").mo5246e();
                    if (h.m31129a("updated_at")) {
                        j = h.m31130b("updated_at").mo5246e();
                    }
                    long j2 = j;
                    String c10 = h.m31129a("custom_type") ? h.m31130b("custom_type").mo5244c() : null;
                    String jsonElement2 = h.m31129a("thumbnails") ? h.m31130b("thumbnails").toString() : null;
                    boolean z = h.m31129a("require_auth") && h.m31130b("require_auth").mo5248g();
                    return new FileMessage(FileMessage.m30936a(c5, e3, user2, str, str2, c6, c7, c8, f, c9, c10, jsonElement2, z, e4, j2));
                case 2:
                case 3:
                    long e5 = h.m31130b("message_id").mo5246e();
                    String c11 = h.m31130b("message").mo5244c();
                    String c12 = h.m31130b("data").mo5244c();
                    long e6 = h.m31130b("created_at").mo5246e();
                    if (h.m31129a("updated_at")) {
                        j = h.m31130b("updated_at").mo5246e();
                    }
                    return new AdminMessage(AdminMessage.m30926a(e5, str, str2, c11, c12, h.m31129a("custom_type") ? h.m31130b("custom_type").mo5244c() : null, e6, j));
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown message type: ");
                    stringBuilder.append(c);
                    Logger.m24932a(stringBuilder.toString());
                    break;
            }
        } catch (Exception e7) {
            Logger.m24931a(e7);
        }
        return null;
    }

    protected BaseMessage(JsonElement jsonElement) {
        jsonElement = jsonElement.m25073h();
        long j = 0;
        this.f22562b = jsonElement.m31129a("msg_id") ? jsonElement.m31130b("msg_id").mo5246e() : 0;
        this.f22563c = jsonElement.m31129a("channel_url") ? jsonElement.m31130b("channel_url").mo5244c() : "";
        this.f22564d = jsonElement.m31129a("channel_type") ? jsonElement.m31130b("channel_type").mo5244c() : "group";
        this.f22565e = jsonElement.m31129a("ts") ? jsonElement.m31130b("ts").mo5246e() : 0;
        if (jsonElement.m31129a("updated_at")) {
            j = jsonElement.m31130b("updated_at").mo5246e();
        }
        this.f22566f = j;
    }

    JsonElement mo5214a() {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31127a("message_id", Long.valueOf(this.f22562b));
        jsonObject.m31128a("channel_url", this.f22563c);
        jsonObject.m31128a("channel_type", this.f22564d);
        jsonObject.m31127a("created_at", Long.valueOf(this.f22565e));
        jsonObject.m31127a("updated_at", Long.valueOf(this.f22566f));
        return jsonObject;
    }

    public static BaseMessage m24875a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ (i & 255));
        }
        try {
            String str = new String(Base64.decode(bArr, 0), "UTF-8");
            bArr = new JsonParser();
            bArr = JsonParser.m25078a(str).m25073h();
            return m24874a(bArr, bArr.m31130b("channel_url").mo5244c(), bArr.m31130b("channel_type").mo5244c());
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public final byte[] m24877e() {
        JsonObject h = mo5214a().m25073h();
        h.m31128a("version", SendBird.m24983c());
        try {
            int i = 0;
            byte[] encode = Base64.encode(h.toString().getBytes("UTF-8"), 0);
            while (i < encode.length) {
                encode[i] = (byte) (encode[i] ^ (i & 255));
                i++;
            }
            return encode;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final long m24878f() {
        return this.f22562b;
    }

    public final long m24879g() {
        return this.f22565e;
    }

    public final String m24880h() {
        return this.f22563c;
    }

    public final boolean m24881i() {
        return this.f22564d.equals("group");
    }
}
