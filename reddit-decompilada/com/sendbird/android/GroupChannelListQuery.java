package com.sendbird.android;

import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;

public final class GroupChannelListQuery {
    private final User f22665a;
    private String f22666b = "";
    private boolean f22667c = true;
    private int f22668d = 20;
    private boolean f22669e = false;
    private boolean f22670f = false;
    private String f22671g = "latest_last_message";
    private FilterMode f22672h = FilterMode.ALL;
    private QueryType f22673i = QueryType.f22658a;
    private ArrayList<String> f22674j;
    private String f22675k;
    private String f22676l;
    private String f22677m = "all";
    private ArrayList<String> f22678n;
    private String f22679o;
    private ArrayList<String> f22680p;
    private SuperChannelFilter f22681q = SuperChannelFilter.ALL;
    private PublicChannelFilter f22682r = PublicChannelFilter.ALL;

    enum FilterMode {
        ALL,
        MEMBERS_EXACTLY_IN,
        MEMBERS_NICKNAME_CONTAINS,
        MEMBERS_INCLUDE_IN
    }

    public interface GroupChannelListQueryResultHandler {
        void mo4491a(List<GroupChannel> list, SendBirdException sendBirdException);
    }

    @Deprecated
    public enum MemberState {
        ALL,
        INVITED_ONLY,
        JOINED_ONLY
    }

    public enum PublicChannelFilter {
        ALL,
        PUBLIC,
        PRIVATE
    }

    public enum QueryType {
        f22658a,
        f22659b
    }

    public enum SuperChannelFilter {
        ALL,
        SUPER_CHANNEL_ONLY,
        NONSUPER_CHANNEL_ONLY
    }

    class C24034 implements APIClientHandler {
        final /* synthetic */ GroupChannelListQueryResultHandler f30102a;
        final /* synthetic */ GroupChannelListQuery f30103b;

        C24034(GroupChannelListQuery groupChannelListQuery, GroupChannelListQueryResultHandler groupChannelListQueryResultHandler) {
            this.f30103b = groupChannelListQuery;
            this.f30102a = groupChannelListQueryResultHandler;
        }

        public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
            this.f30103b.m24928a(false);
            if (sendBirdException != null) {
                if (this.f30102a != null) {
                    SendBird.m24968a(new Runnable(this) {
                        final /* synthetic */ C24034 f22646b;

                        public void run() {
                            this.f22646b.f30102a.mo4491a(null, sendBirdException);
                        }
                    });
                }
                return;
            }
            jsonElement = jsonElement.m25073h();
            this.f30103b.f22666b = jsonElement.m31130b("next").mo5244c();
            if (this.f30103b.f22666b == null || this.f30103b.f22666b.length() <= null) {
                this.f30103b.f22667c = false;
            }
            jsonElement = jsonElement.m31130b("channels").m25074i();
            sendBirdException = new ArrayList();
            for (int i = 0; i < jsonElement.m31115a(); i++) {
                sendBirdException.add(GroupChannel.m30956a(jsonElement.m31116a(i), false));
            }
            if (this.f30102a != null) {
                SendBird.m24968a(new Runnable(this) {
                    final /* synthetic */ C24034 f22648b;

                    public void run() {
                        this.f22648b.f30102a.mo4491a(sendBirdException, null);
                    }
                });
            }
        }
    }

    GroupChannelListQuery(User user) {
        this.f22665a = user;
    }

    public final void m24925a(int i) {
        this.f22668d = i;
    }

    public final void m24924a() {
        this.f22670f = true;
    }

    public final void m24926a(com.sendbird.android.GroupChannel.MemberState memberState) {
        if (memberState == com.sendbird.android.GroupChannel.MemberState.INVITED) {
            this.f22677m = "invited_only";
        } else if (memberState == com.sendbird.android.GroupChannel.MemberState.INVITED_BY_FRIEND) {
            this.f22677m = "invited_by_friend";
        } else if (memberState == com.sendbird.android.GroupChannel.MemberState.INVITED_BY_NON_FRIEND) {
            this.f22677m = "invited_by_non_friend";
        } else if (memberState == com.sendbird.android.GroupChannel.MemberState.JOINED) {
            this.f22677m = "joined_only";
        } else {
            this.f22677m = "all";
        }
    }

    public final boolean m24929b() {
        return this.f22667c;
    }

    public final synchronized boolean m24930c() {
        return this.f22669e;
    }

    final synchronized void m24928a(boolean z) {
        this.f22669e = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m24927a(com.sendbird.android.GroupChannelListQuery.GroupChannelListQueryResultHandler r28) {
        /*
        r27 = this;
        r1 = r27;
        r2 = r28;
        monitor-enter(r27);
        r3 = r1.f22665a;	 Catch:{ all -> 0x007b }
        if (r3 != 0) goto L_0x0013;
    L_0x0009:
        r3 = new com.sendbird.android.GroupChannelListQuery$1;	 Catch:{ all -> 0x007b }
        r3.<init>(r1, r2);	 Catch:{ all -> 0x007b }
        com.sendbird.android.SendBird.m24968a(r3);	 Catch:{ all -> 0x007b }
        monitor-exit(r27);
        return;
    L_0x0013:
        r3 = r1.f22667c;	 Catch:{ all -> 0x007b }
        if (r3 != 0) goto L_0x0021;
    L_0x0017:
        r3 = new com.sendbird.android.GroupChannelListQuery$2;	 Catch:{ all -> 0x007b }
        r3.<init>(r1, r2);	 Catch:{ all -> 0x007b }
        com.sendbird.android.SendBird.m24968a(r3);	 Catch:{ all -> 0x007b }
        monitor-exit(r27);
        return;
    L_0x0021:
        r3 = r27.m24930c();	 Catch:{ all -> 0x007b }
        if (r3 == 0) goto L_0x0031;
    L_0x0027:
        r3 = new com.sendbird.android.GroupChannelListQuery$3;	 Catch:{ all -> 0x007b }
        r3.<init>(r1, r2);	 Catch:{ all -> 0x007b }
        com.sendbird.android.SendBird.m24968a(r3);	 Catch:{ all -> 0x007b }
        monitor-exit(r27);
        return;
    L_0x0031:
        r3 = 1;
        r1.m24928a(r3);	 Catch:{ all -> 0x007b }
        r4 = com.sendbird.android.APIClient.m24818a();	 Catch:{ all -> 0x007b }
        r3 = r1.f22665a;	 Catch:{ all -> 0x007b }
        r5 = r3.f22858c;	 Catch:{ all -> 0x007b }
        r6 = r1.f22666b;	 Catch:{ all -> 0x007b }
        r7 = r1.f22668d;	 Catch:{ all -> 0x007b }
        r8 = r1.f22670f;	 Catch:{ all -> 0x007b }
        r9 = r1.f22671g;	 Catch:{ all -> 0x007b }
        r10 = r1.f22672h;	 Catch:{ all -> 0x007b }
        r11 = r1.f22674j;	 Catch:{ all -> 0x007b }
        r12 = r1.f22673i;	 Catch:{ all -> 0x007b }
        r13 = r1.f22675k;	 Catch:{ all -> 0x007b }
        r14 = r1.f22676l;	 Catch:{ all -> 0x007b }
        r15 = r1.f22677m;	 Catch:{ all -> 0x007b }
        r3 = r1.f22678n;	 Catch:{ all -> 0x007b }
        r22 = r3;
        r3 = r1.f22679o;	 Catch:{ all -> 0x007b }
        r23 = r3;
        r3 = r1.f22680p;	 Catch:{ all -> 0x007b }
        r24 = r3;
        r3 = r1.f22681q;	 Catch:{ all -> 0x007b }
        r25 = r3;
        r3 = r1.f22682r;	 Catch:{ all -> 0x007b }
        r26 = r3;
        r3 = new com.sendbird.android.GroupChannelListQuery$4;	 Catch:{ all -> 0x007b }
        r3.<init>(r1, r2);	 Catch:{ all -> 0x007b }
        r16 = r22;
        r17 = r23;
        r18 = r24;
        r19 = r25;
        r20 = r26;
        r21 = r3;
        r4.m24843a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);	 Catch:{ all -> 0x007b }
        monitor-exit(r27);
        return;
    L_0x007b:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r27);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannelListQuery.a(com.sendbird.android.GroupChannelListQuery$GroupChannelListQueryResultHandler):void");
    }
}
