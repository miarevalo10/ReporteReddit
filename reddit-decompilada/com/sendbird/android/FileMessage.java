package com.sendbird.android;

import com.sendbird.android.SendBird.Options;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import net.hockeyapp.android.UpdateFragment;

public final class FileMessage extends BaseMessage {
    User f30052a;
    private String f30053g;
    private String f30054h;
    private int f30055i;
    private String f30056j;
    private String f30057k;
    private String f30058l = "";
    private String f30059m = "";
    private List<Thumbnail> f30060n;
    private boolean f30061o;

    public static class Thumbnail {
        int f22584a;
        int f22585b;
        int f22586c;
        int f22587d;
        String f22588e;
        private boolean f22589f;

        private Thumbnail(JsonElement jsonElement, boolean z) {
            jsonElement = jsonElement.m25073h();
            int i = 0;
            this.f22584a = jsonElement.m31129a("width") ? jsonElement.m31130b("width").mo5247f() : 0;
            if (jsonElement.m31129a("height")) {
                i = jsonElement.m31130b("height").mo5247f();
            }
            this.f22585b = i;
            i = -1;
            this.f22586c = jsonElement.m31129a("real_width") ? jsonElement.m31130b("real_width").mo5247f() : -1;
            if (jsonElement.m31129a("real_height")) {
                i = jsonElement.m31130b("real_height").mo5247f();
            }
            this.f22587d = i;
            this.f22588e = jsonElement.m31129a(UpdateFragment.FRAGMENT_URL) ? jsonElement.m31130b(UpdateFragment.FRAGMENT_URL).mo5244c() : "";
            this.f22589f = z;
        }

        public final String m24910a() {
            if (!this.f22589f) {
                return this.f22588e;
            }
            return String.format("%s?auth=%s", new Object[]{this.f22588e, APIClient.m24818a().m24858f()});
        }
    }

    public static class ThumbnailSize {
        int f22590a;
        int f22591b;

        public ThumbnailSize(int i, int i2) {
            if (i < 0) {
                i = 0;
            }
            this.f22590a = i;
            if (i2 < 0) {
                i2 = 0;
            }
            this.f22591b = i2;
        }
    }

    static JsonElement m30936a(String str, long j, User user, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, boolean z, long j2, long j3) {
        User user2 = user;
        String str10 = str7;
        String str11 = str8;
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("req_id", str);
        jsonObject.m31127a("msg_id", Long.valueOf(j));
        jsonObject.m31128a("channel_url", str2);
        jsonObject.m31128a("channel_type", str3);
        jsonObject.m31127a("ts", Long.valueOf(j2));
        jsonObject.m31127a("updated_at", Long.valueOf(j3));
        jsonObject.m31128a(UpdateFragment.FRAGMENT_URL, str4);
        jsonObject.m31128a("name", str5);
        jsonObject.m31128a("type", str6);
        jsonObject.m31127a("size", Integer.valueOf(i));
        if (str10 != null) {
            jsonObject.m31128a("custom", str10);
        }
        if (str11 != null) {
            jsonObject.m31128a("custom_type", str11);
        }
        if (str9 != null) {
            JsonParser jsonParser = new JsonParser();
            jsonObject.m31125a("thumbnails", JsonParser.m25078a(str9));
        }
        if (z) {
            jsonObject.m31126a("require_auth", Boolean.valueOf(z));
        }
        JsonElement jsonObject2 = new JsonObject();
        jsonObject2.m31128a("user_id", user2.f22858c);
        jsonObject2.m31128a("nickname", user2.f22859d);
        jsonObject2.m31128a("profile_url", user2.f22860e);
        jsonObject.m31125a("user", jsonObject2);
        return jsonObject;
    }

    FileMessage(JsonElement jsonElement) {
        super(jsonElement);
        jsonElement = jsonElement.m25073h();
        this.f30052a = new User(jsonElement.m31130b("user"));
        this.f30053g = jsonElement.m31130b(UpdateFragment.FRAGMENT_URL).mo5244c();
        this.f30054h = jsonElement.m31129a("name") ? jsonElement.m31130b("name").mo5244c() : "File";
        this.f30055i = jsonElement.m31130b("size").mo5247f();
        this.f30056j = jsonElement.m31130b("type").mo5244c();
        this.f30057k = jsonElement.m31129a("custom") ? jsonElement.m31130b("custom").mo5244c() : "";
        this.f30058l = jsonElement.m31129a("req_id") ? jsonElement.m31130b("req_id").mo5244c() : "";
        this.f30059m = jsonElement.m31129a("custom_type") ? jsonElement.m31130b("custom_type").mo5244c() : "";
        boolean z = jsonElement.m31129a("require_auth") && jsonElement.m31130b("require_auth").mo5248g();
        this.f30061o = z;
        this.f30060n = new ArrayList();
        if (jsonElement.m31129a("thumbnails")) {
            jsonElement = jsonElement.m31130b("thumbnails").m25074i().iterator();
            while (jsonElement.hasNext()) {
                this.f30060n.add(new Thumbnail((JsonElement) jsonElement.next(), this.f30061o));
            }
        }
    }

    final JsonElement mo5214a() {
        JsonElement h = super.mo5214a().m25073h();
        h.m31128a("type", "FILE");
        h.m31128a("req_id", this.f30058l);
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a(UpdateFragment.FRAGMENT_URL, this.f30053g);
        jsonObject.m31128a("name", this.f30054h);
        jsonObject.m31128a("type", this.f30056j);
        jsonObject.m31127a("size", Integer.valueOf(this.f30055i));
        jsonObject.m31128a("data", this.f30057k);
        h.m31125a("file", jsonObject);
        h.m31128a("custom_type", this.f30059m);
        h.m31125a("user", this.f30052a.mo5219a());
        if (this.f30061o) {
            h.m31126a("require_auth", Boolean.valueOf(this.f30061o));
        }
        jsonObject = new JsonArray();
        for (Thumbnail thumbnail : this.f30060n) {
            JsonElement jsonObject2 = new JsonObject();
            jsonObject2.m31127a("width", Integer.valueOf(thumbnail.f22584a));
            jsonObject2.m31127a("height", Integer.valueOf(thumbnail.f22585b));
            jsonObject2.m31127a("real_width", Integer.valueOf(thumbnail.f22586c));
            jsonObject2.m31127a("real_height", Integer.valueOf(thumbnail.f22587d));
            jsonObject2.m31128a(UpdateFragment.FRAGMENT_URL, thumbnail.f22588e);
            jsonObject.m31117a(jsonObject2);
        }
        h.m31125a("thumbnails", jsonObject);
        return h;
    }

    public final String m30938b() {
        return this.f30058l;
    }

    public final User m30939c() {
        if (Options.f22815a && GroupChannel.f30084g.containsKey(this.c)) {
            User user = (User) ((GroupChannel) GroupChannel.f30084g.get(this.c)).f30092o.get(this.f30052a.f22858c);
            if (user != null) {
                if (!user.f22859d.equals(this.f30052a.f22859d)) {
                    this.f30052a.f22859d = user.f22859d;
                }
                if (!user.f22860e.equals(this.f30052a.f22860e)) {
                    this.f30052a.f22860e = user.f22860e;
                }
            }
        }
        return this.f30052a;
    }

    public final String m30940d() {
        if (!this.f30061o) {
            return this.f30053g;
        }
        return String.format("%s?auth=%s", new Object[]{this.f30053g, APIClient.m24818a().m24858f()});
    }

    public final String m30941j() {
        return this.f30054h;
    }

    public final String m30942k() {
        return this.f30057k;
    }

    public final String m30943l() {
        return this.f30059m;
    }

    public final List<Thumbnail> m30944m() {
        return this.f30060n;
    }
}
