package com.sendbird.android;

import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.Command.SendCommandHandler;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class OpenChannel extends BaseChannel {
    private static final ConcurrentHashMap<String, OpenChannel> f30112j = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, OpenChannel> f30113k = new ConcurrentHashMap();
    protected int f30114g;
    protected List<User> f30115h;
    boolean f30116i;
    private String f30117l;

    public interface OpenChannelEnterHandler {
        void mo5236a(SendBirdException sendBirdException);
    }

    public interface OpenChannelGetHandler {
        void mo5220a(OpenChannel openChannel, SendBirdException sendBirdException);
    }

    static synchronized void m31003h() {
        synchronized (OpenChannel.class) {
            f30112j.clear();
        }
    }

    protected static void m31004i() {
        f30113k.clear();
    }

    static synchronized void m31000a(String str) {
        synchronized (OpenChannel.class) {
            f30112j.remove(str);
        }
    }

    protected static Collection<OpenChannel> m31005j() {
        return f30113k.values();
    }

    protected static synchronized OpenChannel m30999a(JsonElement jsonElement, boolean z) {
        OpenChannel openChannel;
        synchronized (OpenChannel.class) {
            String c = jsonElement.m25073h().m31130b("channel_url").mo5244c();
            if (f30112j.containsKey(c)) {
                OpenChannel openChannel2 = (OpenChannel) f30112j.get(c);
                if (!z || openChannel2.f22561f) {
                    openChannel2.mo5218a(jsonElement);
                    openChannel2.f22561f = z;
                }
            } else {
                f30112j.put(c, new OpenChannel(jsonElement));
            }
            openChannel = (OpenChannel) f30112j.get(c);
        }
        return openChannel;
    }

    private OpenChannel(JsonElement jsonElement) {
        super(jsonElement);
    }

    protected final void mo5218a(JsonElement jsonElement) {
        super.mo5218a(jsonElement);
        jsonElement = jsonElement.m25073h();
        if (jsonElement.m31129a("participant_count")) {
            this.f30114g = jsonElement.m31130b("participant_count").mo5247f();
        }
        if (jsonElement.m31129a("operators") && (jsonElement.m31130b("operators") instanceof JsonArray)) {
            this.f30115h = new ArrayList();
            JsonArray i = jsonElement.m31130b("operators").m25074i();
            for (int i2 = 0; i2 < i.m31115a(); i2++) {
                this.f30115h.add(new User(i.m31116a(i2)));
            }
        }
        if (jsonElement.m31129a("custom_type")) {
            this.f30117l = jsonElement.m31130b("custom_type").mo5244c();
        }
        if (jsonElement.m31129a("freeze")) {
            this.f30116i = jsonElement.m31130b("freeze").mo5248g();
        }
    }

    final JsonElement mo5217a() {
        JsonElement h = super.mo5217a().m25073h();
        h.m31128a("channel_type", "open");
        h.m31127a("participant_count", Integer.valueOf(this.f30114g));
        if (this.f30117l != null) {
            h.m31128a("custom_type", this.f30117l);
        }
        if (this.f30115h != null) {
            JsonElement jsonArray = new JsonArray();
            for (User a : this.f30115h) {
                jsonArray.m31117a(a.mo5219a());
            }
            h.m31125a("operators", jsonArray);
        }
        h.m31126a("freeze", Boolean.valueOf(this.f30116i));
        return h;
    }

    protected final void m31009a(int i) {
        this.f30114g = i;
    }

    protected static void m31001a(final String str, final OpenChannelGetHandler openChannelGetHandler) {
        APIClient.m24818a().m24850b(String.format("/v3/open_channels/%s", new Object[]{UrlUtil.m24816a(str)}), new APIClientHandler() {
            public final void mo5216a(JsonElement jsonElement, SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (openChannelGetHandler != null) {
                        openChannelGetHandler.mo5220a(null, sendBirdException);
                    }
                    return;
                }
                OpenChannel.m30999a(jsonElement, (boolean) null);
                if (openChannelGetHandler != null) {
                    openChannelGetHandler.mo5220a((OpenChannel) OpenChannel.f30112j.get(str), null);
                }
            }
        });
    }

    public static void m31002b(final String str, final OpenChannelGetHandler openChannelGetHandler) {
        if (str != null) {
            if (str.length() != 0) {
                if (!f30112j.containsKey(str) || ((OpenChannel) f30112j.get(str)).f22561f) {
                    m31001a(str, new OpenChannelGetHandler() {
                        public final void mo5220a(final OpenChannel openChannel, final SendBirdException sendBirdException) {
                            if (openChannelGetHandler != null) {
                                SendBird.m24968a(new Runnable(this) {
                                    final /* synthetic */ C24056 f22689c;

                                    public void run() {
                                        openChannelGetHandler.mo5220a(openChannel, sendBirdException);
                                    }
                                });
                            }
                        }
                    });
                    return;
                } else {
                    SendBird.m24968a(new Runnable() {
                        public final void run() {
                            OpenChannel openChannel = (OpenChannel) OpenChannel.f30112j.get(str);
                            if (openChannel != null) {
                                openChannelGetHandler.mo5220a(openChannel, null);
                            }
                        }
                    });
                    return;
                }
            }
        }
        SendBird.m24968a(new Runnable() {
            public final void run() {
                openChannelGetHandler.mo5220a(null, new SendBirdException("Invalid arguments.", 800110));
            }
        });
    }

    public final void m31010a(final OpenChannelEnterHandler openChannelEnterHandler) {
        SendBird.m24988e().m25014a(Command.m24890b(m24870d()), new SendCommandHandler(this) {
            final /* synthetic */ OpenChannel f30111b;

            class C19902 implements Runnable {
                final /* synthetic */ C24069 f22692a;

                C19902(C24069 c24069) {
                    this.f22692a = c24069;
                }

                public void run() {
                    openChannelEnterHandler.mo5236a(null);
                }
            }

            public final void mo5215a(Command command, final SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (openChannelEnterHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ C24069 f22691b;

                            public void run() {
                                openChannelEnterHandler.mo5236a(sendBirdException);
                            }
                        });
                    }
                    return;
                }
                OpenChannel.f30113k.put(this.f30111b.m24870d(), this.f30111b);
                command = command.m24896d().m25073h();
                if (command.m31129a("participant_count") != null) {
                    this.f30111b.m31009a(command.m31130b("participant_count").mo5247f());
                }
                if (openChannelEnterHandler != null) {
                    SendBird.m24968a(new C19902(this));
                }
            }
        });
    }
}
