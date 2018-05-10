package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.Command.SendCommandHandler;
import com.sendbird.android.FileMessage.ThumbnailSize;
import com.sendbird.android.SendBird.ConnectionState;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import net.hockeyapp.android.UpdateFragment;

public abstract class BaseChannel {
    protected String f22556a;
    protected String f22557b;
    protected String f22558c;
    protected long f22559d;
    protected String f22560e;
    boolean f22561f = false;

    public enum ChannelType {
        OPEN,
        GROUP
    }

    public interface DeleteMessageHandler {
        void mo4489a(SendBirdException sendBirdException);
    }

    public interface SendFileMessageHandler {
        void mo4499a(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface SendUserMessageHandler {
        void mo4500a(UserMessage userMessage, SendBirdException sendBirdException);
    }

    protected BaseChannel(JsonElement jsonElement) {
        mo5218a(jsonElement);
    }

    protected void mo5218a(JsonElement jsonElement) {
        jsonElement = jsonElement.m25073h();
        String c = (!jsonElement.m31129a("channel_url") || (jsonElement.m31130b("channel_url") instanceof JsonNull)) ? "" : jsonElement.m31130b("channel_url").mo5244c();
        this.f22556a = c;
        c = (!jsonElement.m31129a("name") || (jsonElement.m31130b("name") instanceof JsonNull)) ? "" : jsonElement.m31130b("name").mo5244c();
        this.f22557b = c;
        long e = (!jsonElement.m31129a("created_at") || (jsonElement.m31130b("created_at") instanceof JsonNull)) ? 0 : jsonElement.m31130b("created_at").mo5246e() * 1000;
        this.f22559d = e;
        c = (!jsonElement.m31129a("cover_url") || (jsonElement.m31130b("cover_url") instanceof JsonNull)) ? "" : jsonElement.m31130b("cover_url").mo5244c();
        this.f22558c = c;
        jsonElement = (!jsonElement.m31129a("data") || (jsonElement.m31130b("data") instanceof JsonNull)) ? "" : jsonElement.m31130b("data").mo5244c();
        this.f22560e = jsonElement;
    }

    JsonElement mo5217a() {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("channel_url", this.f22556a);
        jsonObject.m31128a("name", this.f22557b);
        jsonObject.m31128a("cover_url", this.f22558c);
        jsonObject.m31128a("data", this.f22560e);
        jsonObject.m31127a("created_at", Long.valueOf(this.f22559d));
        return jsonObject;
    }

    public static BaseChannel m24862a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ (i & 255));
        }
        try {
            String str = new String(Base64.decode(bArr, 0), "UTF-8");
            bArr = new JsonParser();
            JsonElement h = JsonParser.m25078a(str).m25073h();
            if (h.m31130b("channel_type").mo5244c().equals("open")) {
                bArr = OpenChannel.m30999a(h, true);
            } else if (!h.m31130b("channel_type").mo5244c().equals("group")) {
                return null;
            } else {
                bArr = GroupChannel.m30956a(h, true);
            }
            return bArr;
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public final byte[] m24868b() {
        JsonObject h = mo5217a().m25073h();
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

    public final String m24870d() {
        return this.f22556a;
    }

    public final long m24871e() {
        return this.f22559d;
    }

    public final String m24872f() {
        return this.f22557b;
    }

    public final PreviousMessageListQuery m24873g() {
        return new PreviousMessageListQuery(this);
    }

    public final FileMessage m24863a(File file, String str, String str2, int i, String str3, String str4, List<ThumbnailSize> list, SendFileMessageHandler sendFileMessageHandler) {
        BaseChannel baseChannel = this;
        final SendFileMessageHandler sendFileMessageHandler2 = sendFileMessageHandler;
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(baseChannel) {
                final /* synthetic */ BaseChannel f22550b;

                public void run() {
                    sendFileMessageHandler2.mo4499a(null, new SendBirdException("Connection must be made before you send message.", 800101));
                }
            });
            return null;
        }
        if (!(file == null || str == null || str.length() == 0 || str2 == null)) {
            if (str2.length() != 0) {
                String a = Command.m24889a();
                JsonObject jsonObject = new JsonObject();
                JsonElement jsonArray = new JsonArray();
                if (list != null) {
                    for (ThumbnailSize thumbnailSize : list) {
                        JsonElement jsonObject2 = new JsonObject();
                        jsonObject2.m31127a("width", Integer.valueOf(thumbnailSize.f22590a));
                        jsonObject2.m31127a("height", Integer.valueOf(thumbnailSize.f22591b));
                        jsonObject2.m31128a(UpdateFragment.FRAGMENT_URL, "");
                        jsonArray.m31117a(jsonObject2);
                    }
                }
                jsonObject.m31125a("thumbnails", jsonArray);
                String str5 = a;
                FileMessage fileMessage = new FileMessage(FileMessage.m30936a(str5, 0, SendBird.m25001k(), baseChannel.f22556a, m24869c(), "", file.getName(), str2, i, str3, str4, jsonObject.m31130b("thumbnails").toString(), false, System.currentTimeMillis(), 0));
                final FileMessage fileMessage2 = fileMessage;
                final String str6 = a;
                final String str7 = str;
                final String str8 = str2;
                final int i2 = i;
                final String str9 = str3;
                FileMessage fileMessage3 = fileMessage;
                final String str10 = str4;
                APIClient.m24818a().m24839a(file, str2, list, baseChannel.f22556a, a, new APIClientHandler(baseChannel) {
                    final /* synthetic */ BaseChannel f30046i;

                    class C23992 implements SendCommandHandler {
                        final /* synthetic */ AnonymousClass10 f30036a;

                        C23992(AnonymousClass10 anonymousClass10) {
                            this.f30036a = anonymousClass10;
                        }

                        public final void mo5215a(final Command command, final SendBirdException sendBirdException) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ C23992 f22535c;

                                public void run() {
                                    if (sendBirdException != null) {
                                        if (sendFileMessageHandler2 != null) {
                                            sendFileMessageHandler2.mo4499a(fileMessage2, sendBirdException);
                                        }
                                        return;
                                    }
                                    FileMessage fileMessage = new FileMessage(command.m24896d());
                                    if (sendFileMessageHandler2 != null) {
                                        sendFileMessageHandler2.mo4499a(fileMessage, null);
                                    }
                                }
                            });
                        }
                    }

                    class C24003 implements APIClientHandler {
                        final /* synthetic */ AnonymousClass10 f30037a;

                        C24003(AnonymousClass10 anonymousClass10) {
                            this.f30037a = anonymousClass10;
                        }

                        public final void mo5216a(final JsonElement jsonElement, final SendBirdException sendBirdException) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ C24003 f22538c;

                                public void run() {
                                    if (sendBirdException != null) {
                                        if (sendFileMessageHandler2 != null) {
                                            sendFileMessageHandler2.mo4499a(fileMessage2, sendBirdException);
                                        }
                                        return;
                                    }
                                    JsonElement h = jsonElement.m25073h();
                                    h.m31128a("req_id", str6);
                                    FileMessage fileMessage = (FileMessage) BaseMessage.m24874a(h, this.f22538c.f30037a.f30046i.m24870d(), this.f22538c.f30037a.f30046i.m24869c());
                                    if (sendFileMessageHandler2 != null) {
                                        sendFileMessageHandler2.mo4499a(fileMessage, null);
                                    }
                                }
                            });
                        }
                    }

                    public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                        if (sendBirdException != null) {
                            if (sendFileMessageHandler2 != null) {
                                SendBird.m24968a(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass10 f22532b;

                                    public void run() {
                                        sendFileMessageHandler2.mo4499a(fileMessage2, sendBirdException);
                                    }
                                });
                            }
                            return;
                        }
                        jsonElement = jsonElement.m25073h();
                        String c = jsonElement.m31130b(UpdateFragment.FRAGMENT_URL).mo5244c();
                        String jsonElement2 = jsonElement.m31129a("thumbnails") != null ? jsonElement.m31130b("thumbnails").toString() : null;
                        jsonElement = (jsonElement.m31129a("require_auth") == null || jsonElement.m31130b("require_auth").mo5248g() == null) ? null : true;
                        boolean z = jsonElement;
                        if (SendBird.m24995h() == ConnectionState.OPEN) {
                            SendBird.m24988e().m25014a(Command.m24888a(str6, this.f30046i.m24870d(), c, str7, str8, i2, str9, str10, jsonElement2, z), new C23992(this));
                        } else {
                            APIClient.m24818a().m24848a(this.f30046i instanceof OpenChannel, this.f30046i.m24870d(), SendBird.m25001k().f22858c, c, str7, i2, str8, str10, str9, jsonElement2, z, new C24003(this));
                        }
                    }
                });
                return fileMessage3;
            }
        }
        SendBird.m24968a(new Runnable(baseChannel) {
            final /* synthetic */ BaseChannel f22552b;

            public void run() {
                sendFileMessageHandler2.mo4499a(null, new SendBirdException("Invalid arguments.", 800110));
            }
        });
        return null;
    }

    public final void m24866a(BaseMessage baseMessage, final DeleteMessageHandler deleteMessageHandler) {
        if (baseMessage == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ BaseChannel f22545b;

                public void run() {
                    deleteMessageHandler.mo4489a(new SendBirdException("Invalid arguments.", 800110));
                }
            });
        } else {
            APIClient.m24818a().m24847a(this instanceof OpenChannel, this.f22556a, baseMessage.m24878f(), new APIClientHandler(this) {
                final /* synthetic */ BaseChannel f30051b;

                class C19572 implements Runnable {
                    final /* synthetic */ AnonymousClass51 f22548a;

                    C19572(AnonymousClass51 anonymousClass51) {
                        this.f22548a = anonymousClass51;
                    }

                    public void run() {
                        deleteMessageHandler.mo4489a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (deleteMessageHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass51 f22547b;

                                public void run() {
                                    deleteMessageHandler.mo4489a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    if (deleteMessageHandler != null) {
                        SendBird.m24968a(new C19572(this));
                    }
                }
            });
        }
    }

    final String m24869c() {
        return this instanceof OpenChannel ? "open" : "group";
    }

    public final UserMessage m24864a(String str, String str2, SendUserMessageHandler sendUserMessageHandler) {
        BaseChannel baseChannel = this;
        final SendUserMessageHandler sendUserMessageHandler2 = sendUserMessageHandler;
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(baseChannel) {
                final /* synthetic */ BaseChannel f22540b;

                public void run() {
                    sendUserMessageHandler2.mo4500a(null, new SendBirdException("Connection must be made before you send message.", 800101));
                }
            });
            return null;
        }
        String str3 = str == null ? "" : str;
        String str4 = str2;
        Command a = Command.m24887a(baseChannel.f22556a, str3, str4);
        JsonObject jsonObject = new JsonObject();
        jsonObject.m31125a("translations", new JsonObject());
        Command command = a;
        final UserMessage userMessage = new UserMessage(UserMessage.m31079a(a.f22576c, 0, SendBird.m25001k(), baseChannel.f22556a, m24869c(), str3, str4, null, jsonObject.m31130b("translations").toString(), System.currentTimeMillis(), 0));
        SendBird.m24988e().m25014a(command, new SendCommandHandler(baseChannel) {
            final /* synthetic */ BaseChannel f30049c;

            public final void mo5215a(final Command command, final SendBirdException sendBirdException) {
                SendBird.m24968a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass16 f22543c;

                    public void run() {
                        if (sendBirdException != null) {
                            if (sendUserMessageHandler2 != null) {
                                sendUserMessageHandler2.mo4500a(userMessage, sendBirdException);
                            }
                            return;
                        }
                        UserMessage userMessage = new UserMessage(command.m24896d());
                        if (sendUserMessageHandler2 != null) {
                            sendUserMessageHandler2.mo4500a(userMessage, null);
                        }
                    }
                });
            }
        });
        return userMessage;
    }
}
