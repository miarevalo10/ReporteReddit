package com.sendbird.android;

import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;

public class PreviousMessageListQuery {
    private boolean f22699a = false;
    private BaseChannel f22700b;
    private long f22701c = Long.MAX_VALUE;
    private boolean f22702d = true;

    public interface MessageListQueryResult {
        void mo4497a(List<BaseMessage> list, SendBirdException sendBirdException);
    }

    PreviousMessageListQuery(BaseChannel baseChannel) {
        this.f22700b = baseChannel;
    }

    public final boolean m24944a() {
        return this.f22702d;
    }

    public final synchronized boolean m24945b() {
        return this.f22699a;
    }

    final synchronized void m24943a(boolean z) {
        this.f22699a = z;
    }

    public final synchronized void m24942a(final int i, final MessageListQueryResult messageListQueryResult) {
        if (!this.f22702d) {
            return;
        }
        if (m24945b()) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ PreviousMessageListQuery f22694b;

                public void run() {
                    messageListQueryResult.mo4497a(null, new SendBirdException("Query in progress.", 800170));
                }
            });
            return;
        }
        m24943a(true);
        APIClient.m24818a().m24846a(this.f22700b instanceof OpenChannel, this.f22700b.m24870d(), this.f22701c, i, new APIClientHandler(this) {
            final /* synthetic */ PreviousMessageListQuery f30120c;

            public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                int i = 0;
                this.f30120c.m24943a(false);
                if (sendBirdException != null) {
                    if (messageListQueryResult != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ C24072 f22696b;

                            public void run() {
                                messageListQueryResult.mo4497a(null, sendBirdException);
                            }
                        });
                    }
                    return;
                }
                jsonElement = jsonElement.m25073h().m31130b("messages").m25074i();
                sendBirdException = new ArrayList();
                while (i < jsonElement.m31115a()) {
                    BaseMessage a = BaseMessage.m24874a(jsonElement.m31116a(i), this.f30120c.f22700b.m24870d(), this.f30120c.f22700b.m24869c());
                    if (a != null) {
                        sendBirdException.add(a);
                        if (a.m24879g() <= this.f30120c.f22701c) {
                            this.f30120c.f22701c = a.m24879g();
                        }
                    }
                    i++;
                }
                if (sendBirdException.size() < i) {
                    this.f30120c.f22702d = false;
                }
                if (messageListQueryResult != null) {
                    SendBird.m24968a(new Runnable(this) {
                        final /* synthetic */ C24072 f22698b;

                        public void run() {
                            messageListQueryResult.mo4497a(sendBirdException, null);
                        }
                    });
                }
            }
        });
    }
}
