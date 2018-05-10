package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import net.hockeyapp.android.UpdateFragment;

class Command {
    private static long f22572d = System.currentTimeMillis();
    private static final Gson f22573e = new Gson();
    String f22574a;
    String f22575b;
    String f22576c;

    public interface SendCommandHandler {
        void mo5215a(Command command, SendBirdException sendBirdException);
    }

    protected static synchronized String m24889a() {
        String valueOf;
        synchronized (Command.class) {
            long j = f22572d + 1;
            f22572d = j;
            valueOf = String.valueOf(j);
        }
        return valueOf;
    }

    public Command(String str) {
        if (str != null) {
            if (str.length() > 4) {
                str = str.trim();
                this.f22574a = str.substring(0, 4);
                this.f22575b = str.substring(4);
                if (m24893f() != null) {
                    str = m24896d();
                    if (str != null && (str instanceof JsonObject)) {
                        str = str.m25073h();
                        this.f22576c = str.m31129a("req_id") ? str.m31130b("req_id").mo5244c() : "";
                    }
                }
                return;
            }
        }
        this.f22574a = "NOOP";
        this.f22575b = "{}";
    }

    private Command(String str, JsonElement jsonElement) {
        this(str, jsonElement, null);
    }

    private Command(String str, JsonElement jsonElement, String str2) {
        this.f22574a = str;
        this.f22576c = str2;
        if (this.f22576c == null && m24893f() != null) {
            this.f22576c = m24889a();
        }
        jsonElement.m25073h().m31128a("req_id", this.f22576c);
        this.f22575b = f22573e.m25064a(jsonElement);
    }

    protected final boolean m24894b() {
        if (!(this.f22574a.equals("MESG") || this.f22574a.equals("FILE") || this.f22574a.equals("ENTR") || this.f22574a.equals("EXIT") || this.f22574a.equals("READ") || this.f22574a.equals("MEDI"))) {
            if (!this.f22574a.equals("FEDI")) {
                return false;
            }
        }
        return true;
    }

    private boolean m24893f() {
        if (!m24894b()) {
            if (!this.f22574a.equals("EROR")) {
                return false;
            }
        }
        return true;
    }

    public final String m24895c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f22574a);
        stringBuilder.append(this.f22575b);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public final JsonElement m24896d() {
        JsonParser jsonParser = new JsonParser();
        return JsonParser.m25078a(this.f22575b);
    }

    public static Command m24887a(String str, String str2, String str3) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str);
        jsonObject.m31128a("message", str2);
        jsonObject.m31128a("data", str3);
        jsonObject.m31128a("custom_type", null);
        return new Command("MESG", jsonObject);
    }

    public static Command m24886a(String str, long j) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str);
        jsonObject.m31127a("time", Long.valueOf(j));
        return new Command("TPST", jsonObject);
    }

    public static Command m24891b(String str, long j) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str);
        jsonObject.m31127a("time", Long.valueOf(j));
        return new Command("TPEN", jsonObject);
    }

    public static Command m24885a(String str) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str);
        return new Command("READ", jsonObject);
    }

    public static Command m24888a(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, boolean z) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str2);
        jsonObject.m31128a(UpdateFragment.FRAGMENT_URL, str3);
        jsonObject.m31128a("name", str4);
        jsonObject.m31128a("type", str5);
        jsonObject.m31127a("size", Integer.valueOf(i));
        jsonObject.m31128a("custom", str6);
        jsonObject.m31128a("custom_type", str7);
        if (str8 != null) {
            str3 = new JsonParser();
            jsonObject.m31125a("thumbnails", JsonParser.m25078a(str8));
        }
        if (z) {
            jsonObject.m31126a("require_auth", Boolean.valueOf(z));
        }
        return new Command("FILE", jsonObject, str);
    }

    public static Command m24892e() {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31127a("id", Long.valueOf(System.currentTimeMillis()));
        return new Command("PING", jsonObject);
    }

    public static Command m24890b(String str) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", str);
        return new Command("ENTR", jsonObject);
    }
}
