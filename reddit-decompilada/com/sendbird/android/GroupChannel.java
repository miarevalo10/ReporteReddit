package com.sendbird.android;

import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.Command.SendCommandHandler;
import com.sendbird.android.SendBird.ChannelHandler;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class GroupChannel extends BaseChannel {
    protected static final ConcurrentHashMap<String, GroupChannel> f30084g = new ConcurrentHashMap();
    protected ConcurrentHashMap<String, Long> f30085h = new ConcurrentHashMap();
    protected ConcurrentHashMap<String, Long> f30086i;
    protected boolean f30087j;
    protected boolean f30088k;
    protected boolean f30089l;
    protected int f30090m;
    protected List<Member> f30091n;
    protected HashMap<String, Member> f30092o;
    protected BaseMessage f30093p;
    protected User f30094q;
    protected int f30095r;
    protected long f30096s;
    protected long f30097t;
    boolean f30098u;
    boolean f30099v;
    private String f30100w;
    private boolean f30101x;

    public interface GroupChannelAcceptInvitationHandler {
        void mo4486a(SendBirdException sendBirdException);
    }

    public interface GroupChannelDeclineInvitationHandler {
        void mo4488a(SendBirdException sendBirdException);
    }

    public interface GroupChannelGetHandler {
        void mo4490a(GroupChannel groupChannel, SendBirdException sendBirdException);
    }

    public interface GroupChannelHideHandler {
        void mo4492a(SendBirdException sendBirdException);
    }

    public interface GroupChannelLeaveHandler {
        void mo4496a(SendBirdException sendBirdException);
    }

    @Deprecated
    public interface GroupChannelMarkAsReadHandler {
    }

    public interface GroupChannelRefreshHandler {
        void mo4498a(SendBirdException sendBirdException);
    }

    public interface GroupChannelSetPushPreferenceHandler {
        void mo4502a(SendBirdException sendBirdException);
    }

    public interface GroupChannelTotalUnreadMessageCountHandler {
        void mo4503a(int i, SendBirdException sendBirdException);
    }

    public interface GroupChannelUpdateHandler {
        void mo4501a(SendBirdException sendBirdException);
    }

    public enum MemberState {
        ALL,
        INVITED,
        INVITED_BY_FRIEND,
        INVITED_BY_NON_FRIEND,
        JOINED
    }

    static synchronized void m30963h() {
        synchronized (GroupChannel.class) {
            f30084g.clear();
        }
    }

    static synchronized void m30958a(String str) {
        synchronized (GroupChannel.class) {
            f30084g.remove(str);
        }
    }

    public final void m30972a(final GroupChannelRefreshHandler groupChannelRefreshHandler) {
        m30959a(m24870d(), new GroupChannelGetHandler(this) {
            final /* synthetic */ GroupChannel f30065b;

            class C19622 implements Runnable {
                final /* synthetic */ C24011 f22594a;

                C19622(C24011 c24011) {
                    this.f22594a = c24011;
                }

                public void run() {
                    groupChannelRefreshHandler.mo4498a(null);
                }
            }

            public final void mo4490a(GroupChannel groupChannel, final SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (groupChannelRefreshHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ C24011 f22593b;

                            public void run() {
                                groupChannelRefreshHandler.mo4498a(sendBirdException);
                            }
                        });
                    }
                    return;
                }
                if (groupChannelRefreshHandler != null) {
                    SendBird.m24968a(new C19622(this));
                }
            }
        });
    }

    public static GroupChannelListQuery m30964i() {
        return new GroupChannelListQuery(SendBird.m25001k());
    }

    protected static void m30959a(final String str, final GroupChannelGetHandler groupChannelGetHandler) {
        APIClient.m24818a().m24841a(str, new APIClientHandler() {
            public final void mo5216a(JsonElement jsonElement, SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (groupChannelGetHandler != null) {
                        groupChannelGetHandler.mo4490a(null, sendBirdException);
                    }
                    return;
                }
                GroupChannel.m30956a(jsonElement, (boolean) null);
                if (groupChannelGetHandler != null) {
                    groupChannelGetHandler.mo4490a((GroupChannel) GroupChannel.f30084g.get(str), null);
                }
            }
        });
    }

    public static void m30962b(final String str, final GroupChannelGetHandler groupChannelGetHandler) {
        if (str == null) {
            SendBird.m24968a(new Runnable() {
                public final void run() {
                    groupChannelGetHandler.mo4490a(null, new SendBirdException("Invalid arguments.", 800110));
                }
            });
        } else if (!f30084g.containsKey(str) || ((GroupChannel) f30084g.get(str)).f22561f) {
            m30959a(str, new GroupChannelGetHandler() {
                public final void mo4490a(final GroupChannel groupChannel, final SendBirdException sendBirdException) {
                    if (groupChannelGetHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 f22600c;

                            public void run() {
                                if (groupChannel != null || sendBirdException != null) {
                                    groupChannelGetHandler.mo4490a(groupChannel, sendBirdException);
                                }
                            }
                        });
                    }
                }
            });
        } else {
            SendBird.m24968a(new Runnable() {
                public final void run() {
                    if (((GroupChannel) GroupChannel.f30084g.get(str)) != null) {
                        groupChannelGetHandler.mo4490a((GroupChannel) GroupChannel.f30084g.get(str), null);
                    }
                }
            });
        }
    }

    public static void m30957a(final GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable() {
                public final void run() {
                    groupChannelTotalUnreadMessageCountHandler.mo4503a(0, new SendBirdException("Connection must be made before you get total unread message count.", 800101));
                }
            });
            return;
        }
        APIClient a = APIClient.m24818a();
        String str = SendBird.m25001k().f22858c;
        a.m24850b(String.format("/v3/users/%s/unread_message_count", new Object[]{UrlUtil.m24816a(str)}), new APIClientHandler() {
            public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (groupChannelTotalUnreadMessageCountHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass14 f22603b;

                            public void run() {
                                groupChannelTotalUnreadMessageCountHandler.mo4503a(0, sendBirdException);
                            }
                        });
                    }
                    return;
                }
                jsonElement = jsonElement.m25073h().m31130b("unread_count").mo5247f();
                if (groupChannelTotalUnreadMessageCountHandler != null) {
                    SendBird.m24968a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass14 f22605b;

                        public void run() {
                            groupChannelTotalUnreadMessageCountHandler.mo4503a(jsonElement, null);
                        }
                    });
                }
            }
        });
    }

    protected static synchronized GroupChannel m30956a(JsonElement jsonElement, boolean z) {
        GroupChannel groupChannel;
        synchronized (GroupChannel.class) {
            String c = jsonElement.m25073h().m31130b("channel_url").mo5244c();
            if (f30084g.containsKey(c)) {
                GroupChannel groupChannel2 = (GroupChannel) f30084g.get(c);
                if (!z || groupChannel2.f22561f) {
                    groupChannel2.mo5218a(jsonElement);
                    groupChannel2.f22561f = z;
                }
            } else {
                f30084g.put(c, new GroupChannel(jsonElement));
            }
            groupChannel = (GroupChannel) f30084g.get(c);
        }
        return groupChannel;
    }

    private GroupChannel(JsonElement jsonElement) {
        super(jsonElement);
    }

    protected final void mo5218a(JsonElement jsonElement) {
        super.mo5218a(jsonElement);
        jsonElement = jsonElement.m25073h();
        boolean z = true;
        boolean z2 = jsonElement.m31129a("is_super") && jsonElement.m31130b("is_super").mo5248g();
        this.f30087j = z2;
        if (!jsonElement.m31129a("is_public") || !jsonElement.m31130b("is_public").mo5248g()) {
            z = false;
        }
        this.f30088k = z;
        this.f30089l = jsonElement.m31130b("is_distinct").mo5248g();
        this.f30090m = jsonElement.m31130b("unread_message_count").mo5247f();
        if (jsonElement.m31129a("read_receipt")) {
            if (this.f30086i != null) {
                this.f30086i.clear();
            } else {
                this.f30086i = new ConcurrentHashMap();
            }
            for (Entry entry : jsonElement.m31130b("read_receipt").m25073h().f30235a.entrySet()) {
                m30976a((String) entry.getKey(), ((JsonElement) entry.getValue()).mo5246e());
            }
        }
        if (jsonElement.m31129a("members")) {
            if (this.f30091n != null) {
                this.f30091n.clear();
            } else {
                this.f30091n = new ArrayList();
            }
            if (this.f30092o != null) {
                this.f30092o.clear();
            } else {
                this.f30092o = new HashMap();
            }
            JsonArray i = jsonElement.m31130b("members").m25074i();
            for (int i2 = 0; i2 < i.m31115a(); i2++) {
                User member = new Member(i.m31116a(i2));
                this.f30091n.add(member);
                this.f30092o.put(member.f22858c, member);
            }
            this.f30095r = this.f30091n.size();
        }
        if (jsonElement.m31129a("member_count")) {
            this.f30095r = jsonElement.m31130b("member_count").mo5247f();
        }
        if (jsonElement.m31129a("last_message") && (jsonElement.m31130b("last_message") instanceof JsonObject)) {
            this.f30093p = BaseMessage.m24874a(jsonElement.m31130b("last_message"), m24870d(), m24869c());
        } else {
            this.f30093p = null;
        }
        if (jsonElement.m31129a("inviter") && (jsonElement.m31130b("inviter") instanceof JsonObject)) {
            this.f30094q = new User(jsonElement.m31130b("inviter").m25073h());
        } else {
            this.f30094q = null;
        }
        if (jsonElement.m31129a("custom_type")) {
            this.f30100w = jsonElement.m31130b("custom_type").mo5244c();
        }
        if (jsonElement.m31129a("is_push_enabled")) {
            this.f30101x = jsonElement.m31130b("is_push_enabled").mo5248g();
        }
        if (jsonElement.m31129a("is_hidden")) {
            this.f30098u = jsonElement.m31130b("is_hidden").mo5248g();
        } else {
            this.f30098u = false;
        }
    }

    final JsonElement mo5217a() {
        JsonElement h = super.mo5217a().m25073h();
        h.m31128a("channel_type", "group");
        h.m31126a("is_super", Boolean.valueOf(this.f30087j));
        h.m31126a("is_public", Boolean.valueOf(this.f30088k));
        h.m31126a("is_distinct", Boolean.valueOf(this.f30089l));
        h.m31127a("unread_message_count", Integer.valueOf(this.f30090m));
        h.m31127a("member_count", Integer.valueOf(this.f30095r));
        h.m31126a("is_push_enabled", Boolean.valueOf(this.f30101x));
        h.m31126a("is_hidden", Boolean.valueOf(this.f30098u));
        if (this.f30100w != null) {
            h.m31128a("custom_type", this.f30100w);
        }
        JsonElement jsonObject = new JsonObject();
        for (Entry entry : this.f30086i.entrySet()) {
            jsonObject.m31127a((String) entry.getKey(), (Number) entry.getValue());
        }
        h.m31125a("read_receipt", jsonObject);
        if (this.f30091n != null) {
            jsonObject = new JsonArray();
            for (Member a : this.f30091n) {
                jsonObject.m31117a(a.mo5219a());
            }
            h.m31125a("members", jsonObject);
        }
        if (this.f30093p != null) {
            h.m31125a("last_message", this.f30093p.mo5214a());
        }
        if (this.f30094q != null) {
            h.m31125a("inviter", this.f30094q.mo5219a());
        }
        return h;
    }

    public final BaseMessage m30980j() {
        return this.f30093p;
    }

    protected final synchronized void m30967a(BaseMessage baseMessage) {
        this.f30093p = baseMessage;
    }

    public final User m30981k() {
        return this.f30094q;
    }

    public final int m30982l() {
        return this.f30090m;
    }

    protected final synchronized void m30966a(int i) {
        this.f30090m = i;
    }

    public final List<Member> m30983m() {
        return Arrays.asList(this.f30091n.toArray(new Member[0]));
    }

    public final int m30984n() {
        return this.f30095r;
    }

    public final boolean m30985o() {
        return this.f30089l;
    }

    public final boolean m30986p() {
        return this.f30101x;
    }

    public final void m30971a(final GroupChannelLeaveHandler groupChannelLeaveHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ GroupChannel f22616b;

                public void run() {
                    groupChannelLeaveHandler.mo4496a(new SendBirdException("Connection must be made before you leave channel.", 800101));
                }
            });
        } else {
            APIClient.m24818a().m24851b(m24870d(), SendBird.m25001k().f22858c, new APIClientHandler(this) {
                final /* synthetic */ GroupChannel f30072b;

                class C19712 implements Runnable {
                    final /* synthetic */ AnonymousClass31 f22619a;

                    C19712(AnonymousClass31 anonymousClass31) {
                        this.f22619a = anonymousClass31;
                    }

                    public void run() {
                        groupChannelLeaveHandler.mo4496a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (groupChannelLeaveHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass31 f22618b;

                                public void run() {
                                    groupChannelLeaveHandler.mo4496a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    if (groupChannelLeaveHandler != null) {
                        SendBird.m24968a(new C19712(this));
                    }
                }
            });
        }
    }

    public final void m30968a(final GroupChannelAcceptInvitationHandler groupChannelAcceptInvitationHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ GroupChannel f22621b;

                public void run() {
                    groupChannelAcceptInvitationHandler.mo4486a(new SendBirdException("Connection must be made before you accept the invitation.", 800101));
                }
            });
        } else {
            APIClient.m24818a().m24853c(m24870d(), SendBird.m25001k().f22858c, new APIClientHandler(this) {
                final /* synthetic */ GroupChannel f30074b;

                class C19732 implements Runnable {
                    final /* synthetic */ AnonymousClass33 f22624a;

                    C19732(AnonymousClass33 anonymousClass33) {
                        this.f22624a = anonymousClass33;
                    }

                    public void run() {
                        groupChannelAcceptInvitationHandler.mo4486a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (groupChannelAcceptInvitationHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass33 f22623b;

                                public void run() {
                                    groupChannelAcceptInvitationHandler.mo4486a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    if (groupChannelAcceptInvitationHandler != null) {
                        SendBird.m24968a(new C19732(this));
                    }
                }
            });
        }
    }

    public final void m30969a(final GroupChannelDeclineInvitationHandler groupChannelDeclineInvitationHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ GroupChannel f22626b;

                public void run() {
                    groupChannelDeclineInvitationHandler.mo4488a(new SendBirdException("Connection must be made before you decline the invitation.", 800101));
                }
            });
        } else {
            APIClient.m24818a().m24855d(m24870d(), SendBird.m25001k().f22858c, new APIClientHandler(this) {
                final /* synthetic */ GroupChannel f30076b;

                class C19752 implements Runnable {
                    final /* synthetic */ AnonymousClass35 f22629a;

                    C19752(AnonymousClass35 anonymousClass35) {
                        this.f22629a = anonymousClass35;
                    }

                    public void run() {
                        groupChannelDeclineInvitationHandler.mo4488a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (groupChannelDeclineInvitationHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass35 f22628b;

                                public void run() {
                                    groupChannelDeclineInvitationHandler.mo4488a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    if (groupChannelDeclineInvitationHandler != null) {
                        SendBird.m24968a(new C19752(this));
                    }
                }
            });
        }
    }

    public final void m30978a(final boolean z, final GroupChannelSetPushPreferenceHandler groupChannelSetPushPreferenceHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ GroupChannel f22631b;

                public void run() {
                    groupChannelSetPushPreferenceHandler.mo4502a(new SendBirdException("Connection must be made before you set push preference setting for this channel.", 800101));
                }
            });
        } else {
            APIClient.m24818a().m24845a(SendBird.m25001k().f22858c, m24870d(), z, new APIClientHandler(this) {
                final /* synthetic */ GroupChannel f30079c;

                class C19772 implements Runnable {
                    final /* synthetic */ AnonymousClass37 f22634a;

                    C19772(AnonymousClass37 anonymousClass37) {
                        this.f22634a = anonymousClass37;
                    }

                    public void run() {
                        groupChannelSetPushPreferenceHandler.mo4502a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (groupChannelSetPushPreferenceHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass37 f22633b;

                                public void run() {
                                    groupChannelSetPushPreferenceHandler.mo4502a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    this.f30079c.f30101x = z;
                    if (groupChannelSetPushPreferenceHandler != null) {
                        SendBird.m24968a(new C19772(this));
                    }
                }
            });
        }
    }

    protected final synchronized void m30976a(String str, long j) {
        Long l = (Long) this.f30086i.get(str);
        if (l == null || l.longValue() < j) {
            this.f30086i.put(str, Long.valueOf(j));
        }
    }

    public final void m30988r() {
        if (System.currentTimeMillis() - this.f30096s >= 1000) {
            this.f30097t = 0;
            this.f30096s = System.currentTimeMillis();
            SendBird.m24988e().m25014a(Command.m24886a(m24870d(), this.f30096s), null);
        }
    }

    public final void m30989s() {
        if (System.currentTimeMillis() - this.f30097t >= 1000) {
            this.f30096s = 0;
            this.f30097t = System.currentTimeMillis();
            SendBird.m24988e().m25014a(Command.m24891b(m24870d(), this.f30097t), null);
        }
    }

    protected final synchronized boolean m30990t() {
        boolean z;
        z = false;
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry entry : this.f30085h.entrySet()) {
            if (currentTimeMillis - ((Long) entry.getValue()).longValue() >= 10000) {
                this.f30085h.remove(entry.getKey());
                z = true;
            }
        }
        return z;
    }

    protected final synchronized void m30974a(User user, boolean z) {
        if (z) {
            this.f30085h.put(user.f22858c, Long.valueOf(System.currentTimeMillis()));
        } else {
            this.f30085h.remove(user.f22858c);
        }
    }

    public final List<Member> m30991u() {
        List<Member> arrayList = new ArrayList();
        Enumeration keys = this.f30085h.keys();
        while (keys.hasMoreElements()) {
            Member member = (Member) this.f30092o.get((String) keys.nextElement());
            if (member != null) {
                arrayList.add(member);
            }
        }
        return arrayList;
    }

    protected final synchronized void m30973a(Member member) {
        m30979b(member);
        this.f30092o.put(member.f22858c, member);
        this.f30091n.add(member);
        this.f30095r++;
        m30976a(member.f22858c, 0);
    }

    protected final synchronized void m30979b(Member member) {
        if (this.f30092o.containsKey(member.f22858c)) {
            this.f30091n.remove(this.f30092o.remove(member.f22858c));
            this.f30095r--;
        }
    }

    public final void m30977a(String str, final GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        APIClient.m24818a().m24842a(m24870d(), Boolean.valueOf(this.f30089l), str, new APIClientHandler(this) {
            final /* synthetic */ GroupChannel f30067b;

            public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (groupChannelUpdateHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass20 f22607b;

                            public void run() {
                                groupChannelUpdateHandler.mo4501a(sendBirdException);
                            }
                        });
                    }
                    return;
                }
                jsonElement = GroupChannel.m30956a(jsonElement, (boolean) null);
                if (groupChannelUpdateHandler != null) {
                    SendBird.m24968a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass20 f22609b;

                        public void run() {
                            groupChannelUpdateHandler.mo4501a(null);
                        }
                    });
                }
            }
        });
    }

    public final void m30970a(final GroupChannelHideHandler groupChannelHideHandler) {
        if (SendBird.m25001k() == null) {
            SendBird.m24968a(new Runnable(this) {
                final /* synthetic */ GroupChannel f22611b;

                public void run() {
                    groupChannelHideHandler.mo4492a(new SendBirdException("Connection must be made before you hide channel.", 800101));
                }
            });
        } else {
            APIClient.m24818a().m24844a(m24870d(), SendBird.m25001k().f22858c, new APIClientHandler(this) {
                final /* synthetic */ boolean f30069b = null;
                final /* synthetic */ GroupChannel f30070c;

                class C19692 implements Runnable {
                    final /* synthetic */ AnonymousClass29 f22614a;

                    C19692(AnonymousClass29 anonymousClass29) {
                        this.f22614a = anonymousClass29;
                    }

                    public void run() {
                        groupChannelHideHandler.mo4492a(null);
                    }
                }

                public final void mo5216a(JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (groupChannelHideHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass29 f22613b;

                                public void run() {
                                    groupChannelHideHandler.mo4492a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    this.f30070c.f30098u = true;
                    if (this.f30069b != null) {
                        this.f30070c.m30966a((int) null);
                    }
                    if (groupChannelHideHandler != null) {
                        SendBird.m24968a(new C19692(this));
                    }
                }
            });
        }
    }

    public final void m30987q() {
        if (SendBird.m25001k() != null) {
            SendBird.m24988e().m25014a(Command.m24885a(m24870d()), new SendCommandHandler(this) {
                final /* synthetic */ GroupChannelMarkAsReadHandler f30080a = null;
                final /* synthetic */ GroupChannel f30081b;

                class C19792 implements Runnable {
                    final /* synthetic */ AnonymousClass46 f22637a;

                    C19792(AnonymousClass46 anonymousClass46) {
                        this.f22637a = anonymousClass46;
                    }

                    public void run() {
                        for (ChannelHandler a : SendBird.m24988e().f22830d.values()) {
                            a.mo4504a(this.f22637a.f30081b);
                        }
                    }
                }

                class C19803 implements Runnable {
                    final /* synthetic */ AnonymousClass46 f22638a;

                    public void run() {
                    }

                    C19803(AnonymousClass46 anonymousClass46) {
                        this.f22638a = anonymousClass46;
                    }
                }

                {
                    this.f30081b = r1;
                }

                public final void mo5215a(Command command, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (this.f30080a != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass46 f22636b;

                                public void run() {
                                }
                            });
                        }
                        return;
                    }
                    if (this.f30081b.f30090m > null) {
                        this.f30081b.m30966a((int) null);
                        SendBird.m24968a(new C19792(this));
                    }
                    if (this.f30080a != null) {
                        SendBird.m24968a(new C19803(this));
                    }
                }
            });
        }
    }
}
