package com.sendbird.android;

import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.server.http.HttpStatus;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.sendbird.android.FileMessage.ThumbnailSize;
import com.sendbird.android.GroupChannelListQuery.PublicChannelFilter;
import com.sendbird.android.GroupChannelListQuery.QueryType;
import com.sendbird.android.GroupChannelListQuery.SuperChannelFilter;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.Callback;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.MediaType;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.RealCall;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Request.Builder;
import com.sendbird.android.shadow.okhttp3.RequestBody;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.Okio;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import net.hockeyapp.android.UpdateFragment;

class APIClient {
    private static final Gson f22522a = new Gson();
    private static final MediaType f22523b = MediaType.m25307a("application/json; charset=utf-8");
    private static APIClient f22524c;
    private String f22525d = "";
    private String f22526e = "";
    private OkHttpClient f22527f = new OkHttpClient();
    private OkHttpClient f22528g;
    private ConcurrentHashMap<String, Call> f22529h;
    private final Object f22530i;

    class C19511 extends Thread {
        final /* synthetic */ APIClient f22516a;

        C19511(APIClient aPIClient) {
            this.f22516a = aPIClient;
        }

        public void run() {
            this.f22516a.f22527f.f23279u.m25214a();
            this.f22516a.f22528g.f23279u.m25214a();
        }
    }

    public interface APIClientHandler {
        void mo5216a(JsonElement jsonElement, SendBirdException sendBirdException);
    }

    public interface APIClientProgressHandler {
    }

    protected static class CheckRouting {
        private static CheckRouting f22517a;
        private static Object f22518b = new Object();
        private String f22519c;
        private String f22520d;
        private long f22521e = 0;

        public interface CheckRoutingHandler {
            void mo5210a(String str, String str2, SendBirdException sendBirdException);
        }

        protected CheckRouting() {
        }

        static void m24808a(OkHttpClient okHttpClient, final CheckRoutingHandler checkRoutingHandler) {
            synchronized (f22518b) {
                if (f22517a == null) {
                    CheckRouting checkRouting = new CheckRouting();
                    f22517a = checkRouting;
                    checkRouting.m24812b();
                }
            }
            CheckRouting checkRouting2 = f22517a;
            if (SendBird.m24986d() != null) {
                if (SendBird.m24986d().length() != 0) {
                    if (SendBird.f22817b != null && SendBird.f22818c != null) {
                        if (checkRoutingHandler != null) {
                            checkRoutingHandler.mo5210a(SendBird.f22818c, SendBird.f22817b, null);
                        }
                        return;
                    } else if (System.currentTimeMillis() - checkRouting2.f22521e > 300000 || !checkRouting2.m24814c()) {
                        boolean z;
                        if (!checkRouting2.m24814c() || checkRoutingHandler == null) {
                            z = false;
                        } else {
                            checkRoutingHandler.mo5210a(checkRouting2.f22519c, checkRouting2.f22520d, null);
                            z = true;
                        }
                        try {
                            String str = "https://api-p.sendbird.com/routing/%s";
                            StringBuilder stringBuilder = new StringBuilder("Router: ");
                            stringBuilder.append(str);
                            Logger.m24934b(stringBuilder.toString());
                            StringBuilder stringBuilder2 = new StringBuilder("Jand/");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2 = new StringBuilder("Android,");
                            stringBuilder2.append(SendBird.m24977b());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24986d());
                            Builder a = new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25315a(String.format(str, new Object[]{SendBird.m24986d()}));
                            a.f23295e = Boolean.valueOf(z);
                            RealCall.m31337a(okHttpClient, a.m25318a(), false).mo5319a(new Callback(checkRouting2) {
                                final /* synthetic */ CheckRouting f30020b;

                                public final void mo5209a(Call call, IOException iOException) {
                                    Logger.m24934b("Routing failed: ");
                                    Logger.m24933b((Exception) iOException);
                                    if (((Boolean) call.mo5318a().tag()).booleanValue() == null && checkRoutingHandler != null) {
                                        if (this.f30020b.m24814c() != null) {
                                            checkRoutingHandler.mo5210a(this.f30020b.f22519c, this.f30020b.f22520d, null);
                                            return;
                                        }
                                        checkRoutingHandler.mo5210a(null, null, new SendBirdException(iOException.getMessage(), 800121));
                                    }
                                }

                                public final void mo5208a(Call call, Response response) throws IOException {
                                    call = ((Boolean) call.mo5318a().tag()).booleanValue();
                                    try {
                                        response = APIClient.m24819a(response);
                                        this.f30020b.f22519c = response.m25073h().m31130b("api_server").mo5244c();
                                        this.f30020b.f22520d = response.m25073h().m31130b("ws_server").mo5244c();
                                        this.f30020b.f22521e = System.currentTimeMillis();
                                        CheckRouting.m24815d(this.f30020b);
                                        response = new StringBuilder("Routing to: ");
                                        response.append(this.f30020b.f22519c);
                                        response.append(" : ");
                                        response.append(this.f30020b.f22520d);
                                        Logger.m24934b(response.toString());
                                        if (call == null && checkRoutingHandler != null) {
                                            checkRoutingHandler.mo5210a(this.f30020b.f22519c, this.f30020b.f22520d, null);
                                        }
                                    } catch (Exception e) {
                                        Logger.m24933b(e);
                                        if (call == null && checkRoutingHandler != null) {
                                            if (this.f30020b.m24814c() != null) {
                                                checkRoutingHandler.mo5210a(this.f30020b.f22519c, this.f30020b.f22520d, null);
                                                return;
                                            }
                                            checkRoutingHandler.mo5210a(null, null, e);
                                        }
                                    } catch (Exception e2) {
                                        Logger.m24933b(e2);
                                        if (call == null && checkRoutingHandler != null) {
                                            if (this.f30020b.m24814c() != null) {
                                                checkRoutingHandler.mo5210a(this.f30020b.f22519c, this.f30020b.f22520d, null);
                                                return;
                                            }
                                            checkRoutingHandler.mo5210a(null, null, new SendBirdException(e2.getMessage(), 800121));
                                        }
                                    }
                                }
                            });
                            return;
                        } catch (OkHttpClient okHttpClient2) {
                            if (!(z || checkRoutingHandler == null)) {
                                if (checkRouting2.m24814c()) {
                                    checkRoutingHandler.mo5210a(checkRouting2.f22519c, checkRouting2.f22520d, null);
                                    return;
                                }
                                checkRoutingHandler.mo5210a(null, null, new SendBirdException(okHttpClient2.getMessage(), 800121));
                            }
                            return;
                        }
                    } else {
                        if (checkRoutingHandler != null) {
                            checkRoutingHandler.mo5210a(checkRouting2.f22519c, checkRouting2.f22520d, null);
                        }
                        return;
                    }
                }
            }
            if (checkRoutingHandler != null) {
                checkRoutingHandler.mo5210a(null, null, new SendBirdException("Application ID is not set. Initialize SendBird class.", 800100));
            }
        }

        static void m24807a() {
            SendBird.m24988e().m25018c(null);
            SendBird.m24988e().m25019d(null);
            if (f22517a != null) {
                f22517a.m24812b();
            }
        }

        private void m24812b() {
            SendBird e = SendBird.m24988e();
            this.f22519c = e.m25017b(e.f22832f);
            e = SendBird.m24988e();
            this.f22520d = e.m25017b(e.f22833g);
        }

        private boolean m24814c() {
            return this.f22519c != null && this.f22519c.length() > 0 && this.f22520d != null && this.f22520d.length() > 0;
        }

        static /* synthetic */ void m24815d(CheckRouting checkRouting) {
            SendBird.m24988e().m25018c(checkRouting.f22519c);
            SendBird.m24988e().m25019d(checkRouting.f22520d);
        }
    }

    static class UrlUtil {
        static String m24816a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (String str2) {
                throw new UnsupportedOperationException(str2);
            }
        }

        static String m24817a(Collection<String> collection) {
            if (collection == null || collection.size() <= 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = "";
            for (String str2 : collection) {
                stringBuilder.append(str);
                str = ",";
                stringBuilder.append(m24816a(str2));
            }
            return stringBuilder.toString();
        }
    }

    static final class FixedLengthMultipartRequestBody extends RequestBody {
        private static final MediaType f30021a = MediaType.m25307a("multipart/form-data");
        private static final byte[] f30022b = new byte[]{(byte) 58, (byte) 32};
        private static final byte[] f30023c = new byte[]{(byte) 13, (byte) 10};
        private static final byte[] f30024d = new byte[]{Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
        private final ByteString f30025e = ByteString.m25595a(UUID.randomUUID().toString());
        private final MediaType f30026f;
        private final List<Headers> f30027g;
        private final List<RequestBody> f30028h;
        private long f30029i;
        private long f30030j;
        private final APIClientProgressHandler f30031k;

        FixedLengthMultipartRequestBody(List<Headers> list, List<RequestBody> list2, APIClientProgressHandler aPIClientProgressHandler) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f30021a);
            stringBuilder.append("; boundary=");
            stringBuilder.append(this.f30025e.mo5394a());
            this.f30026f = MediaType.m25307a(stringBuilder.toString());
            this.f30027g = Util.m25362a((List) list);
            this.f30028h = Util.m25362a((List) list2);
            this.f30029i = 0;
            this.f30030j = 0;
            this.f30031k = aPIClientProgressHandler;
        }

        public final MediaType mo5211a() {
            return this.f30026f;
        }

        public final long mo5213b() throws IOException {
            int size = this.f30027g.size();
            int i = 0;
            int i2 = i;
            while (i < size) {
                Headers headers = (Headers) this.f30027g.get(i);
                RequestBody requestBody = (RequestBody) this.f30028h.get(i);
                long b = requestBody.mo5213b();
                if (b == -1) {
                    return -1;
                }
                i2 += (f30024d.length + this.f30025e.mo5405h()) + f30023c.length;
                if (headers != null) {
                    int i3 = i2;
                    for (i2 = 0; i2 < headers.f23197a.length / 2; i2++) {
                        i3 += ((headers.m25268a(i2).getBytes("UTF-8").length + f30022b.length) + headers.m25270b(i2).getBytes("UTF-8").length) + f30023c.length;
                    }
                    i2 = i3;
                }
                MediaType a = requestBody.mo5211a();
                if (a != null) {
                    i2 += ("Content-Type: ".getBytes("UTF-8").length + a.toString().getBytes("UTF-8").length) + f30023c.length;
                }
                i2 = (int) (((long) (i2 + (("Content-Length: ".getBytes("UTF-8").length + Long.toString(b).getBytes("UTF-8").length) + f30023c.length))) + ((((long) f30023c.length) + b) + ((long) f30023c.length)));
                i++;
            }
            long length = (long) (i2 + (((f30024d.length + this.f30025e.mo5405h()) + f30024d.length) + f30023c.length));
            this.f30030j = length;
            return length;
        }

        public final void mo5212a(BufferedSink bufferedSink) throws IOException {
            bufferedSink = Okio.m25614a(new ForwardingSink(this, bufferedSink) {
                final /* synthetic */ FixedLengthMultipartRequestBody f34603a;

                public final void a_(Buffer buffer, long j) throws IOException {
                    super.a_(buffer, j);
                    this.f34603a.f30029i = this.f34603a.f30029i + j;
                    if (this.f34603a.f30031k != null) {
                        this.f34603a.f30031k;
                        this.f34603a.f30029i;
                        this.f34603a.f30030j;
                    }
                }
            });
            int size = this.f30027g.size();
            for (int i = 0; i < size; i++) {
                Headers headers = (Headers) this.f30027g.get(i);
                RequestBody requestBody = (RequestBody) this.f30028h.get(i);
                bufferedSink.mo6558c(f30024d);
                bufferedSink.mo6557c(this.f30025e);
                bufferedSink.mo6558c(f30023c);
                if (headers != null) {
                    int length = headers.f23197a.length / 2;
                    for (int i2 = 0; i2 < length; i2++) {
                        bufferedSink.mo6553b(headers.m25268a(i2)).mo6558c(f30022b).mo6553b(headers.m25270b(i2)).mo6558c(f30023c);
                    }
                }
                MediaType a = requestBody.mo5211a();
                if (a != null) {
                    bufferedSink.mo6553b("Content-Type: ").mo6553b(a.toString()).mo6558c(f30023c);
                }
                long b = requestBody.mo5213b();
                if (b != -1) {
                    bufferedSink.mo6553b("Content-Length: ").mo6553b(Long.toString(b)).mo6558c(f30023c);
                }
                bufferedSink.mo6558c(f30023c);
                requestBody.mo5212a(bufferedSink);
                bufferedSink.mo6558c(f30023c);
            }
            bufferedSink.mo6558c(f30024d);
            bufferedSink.mo6557c(this.f30025e);
            bufferedSink.mo6558c(f30024d);
            bufferedSink.mo6558c(f30023c);
            bufferedSink.flush();
        }
    }

    static synchronized APIClient m24818a() {
        APIClient aPIClient;
        synchronized (APIClient.class) {
            if (f22524c == null) {
                Logger.m24932a("SendBird instance hasn't been initialized. Try SendBird.init().");
                throw new RuntimeException("SendBird instance hasn't been initialized.");
            }
            aPIClient = f22524c;
        }
        return aPIClient;
    }

    static synchronized void m24829b() {
        synchronized (APIClient.class) {
            if (f22524c == null) {
                f22524c = new APIClient();
            }
        }
    }

    protected APIClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.f23255z = Util.m25355a("timeout", 60000, TimeUnit.MILLISECONDS);
        this.f22528g = builder.m25309a();
        this.f22530i = new Object();
        this.f22529h = new ConcurrentHashMap();
    }

    final void m24852c() {
        Logger.m24934b("Evict all connections.");
        new C19511(this).start();
    }

    final void m24854d() {
        Logger.m24934b("Cancel all API calls.");
        this.f22527f.f23261c.m25232b();
        this.f22528g.f23261c.m25232b();
    }

    final void m24844a(String str, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s/hide", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("user_id", str2);
        jsonObject.m31126a("hide_previous_messages", Boolean.valueOf(false));
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24851b(String str, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s/leave", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("user_id", str2);
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24853c(String str, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s/accept", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("user_id", str2);
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24855d(String str, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s/decline", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("user_id", str2);
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24848a(boolean z, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, boolean z2, APIClientHandler aPIClientHandler) {
        String format;
        if (z) {
            format = String.format("/v3/open_channels/%s/messages", new Object[]{UrlUtil.m24816a(str)});
        } else {
            format = String.format("/v3/group_channels/%s/messages", new Object[]{UrlUtil.m24816a(str)});
        }
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("message_type", "FILE");
        jsonObject.m31128a("user_id", str2);
        jsonObject.m31128a(UpdateFragment.FRAGMENT_URL, str3);
        if (str4 != null) {
            jsonObject.m31128a("file_name", str4);
        }
        if (i > 0) {
            jsonObject.m31127a("file_size", Integer.valueOf(i));
        }
        if (str5 != null) {
            jsonObject.m31128a("file_type", str5);
        }
        if (str6 != null) {
            jsonObject.m31128a("custom_type", str6);
        }
        if (str7 != null) {
            jsonObject.m31128a("custom_field", str7);
        }
        if (str8 != null) {
            str3 = new JsonParser();
            jsonObject.m31125a("thumbnails", JsonParser.m25078a(str8));
        }
        if (z2) {
            jsonObject.m31126a("require_auth", Boolean.valueOf(true));
        }
        m24826a(format, jsonObject, aPIClientHandler);
    }

    final void m24846a(boolean z, String str, long j, int i, APIClientHandler aPIClientHandler) {
        String format;
        if (z) {
            format = String.format("/v3/open_channels/%s/messages", new Object[]{UrlUtil.m24816a(str)});
        } else {
            format = String.format("/v3/group_channels/%s/messages", new Object[]{UrlUtil.m24816a(str)});
        }
        Map hashMap = new HashMap();
        hashMap.put("is_sdk", "true");
        hashMap.put("message_ts", String.valueOf(j));
        hashMap.put("prev_limit", String.valueOf(i));
        hashMap.put("next_limit", "0");
        hashMap.put("include", "false");
        hashMap.put("reverse", "true");
        m24827a(format, hashMap, (Map) 0, aPIClientHandler);
    }

    final void m24841a(String str, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s", new Object[]{UrlUtil.m24816a(str)});
        Map hashMap = new HashMap();
        hashMap.put("member", "true");
        hashMap.put("read_receipt", "true");
        m24827a(str, hashMap, null, aPIClientHandler);
    }

    final void m24842a(String str, Boolean bool, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/group_channels/%s", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        if (bool != null) {
            jsonObject.m31126a("is_distinct", bool);
        }
        if (str2 != null) {
            jsonObject.m31128a("name", str2);
        }
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24843a(String str, String str2, int i, boolean z, String str3, FilterMode filterMode, List<String> list, QueryType queryType, String str4, String str5, String str6, List<String> list2, String str7, List<String> list3, SuperChannelFilter superChannelFilter, PublicChannelFilter publicChannelFilter, APIClientHandler aPIClientHandler) {
        FilterMode filterMode2 = filterMode;
        List<String> list4 = list;
        QueryType queryType2 = queryType;
        String str8 = str4;
        String str9 = str5;
        String str10 = str6;
        List<String> list5 = list2;
        String str11 = str7;
        List<String> list6 = list3;
        SuperChannelFilter superChannelFilter2 = superChannelFilter;
        PublicChannelFilter publicChannelFilter2 = publicChannelFilter;
        String format = String.format("/v3/users/%s/my_group_channels", new Object[]{UrlUtil.m24816a(str)});
        Map hashMap = new HashMap();
        hashMap.put("token", str2);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("show_read_receipt", "true");
        hashMap.put("show_member", "true");
        hashMap.put("show_empty", String.valueOf(z));
        hashMap.put("distinct_mode", "all");
        hashMap.put("order", str3);
        if (str8 != null) {
            hashMap.put("custom_type", str8);
        }
        if (str9 != null) {
            hashMap.put("custom_type_startswith", str9);
        }
        if (str10 != null) {
            hashMap.put("member_state_filter", str10);
        }
        if (str11 != null) {
            hashMap.put("name_contains", str11);
        }
        Object obj = null;
        if (filterMode2 == FilterMode.MEMBERS_EXACTLY_IN) {
            obj = "members_exactly_in";
        } else if (filterMode2 == FilterMode.MEMBERS_NICKNAME_CONTAINS) {
            obj = "members_nickname_contains";
        } else if (filterMode2 == FilterMode.MEMBERS_INCLUDE_IN) {
            String str12 = "members_include_in";
            if (queryType2 == QueryType.f22658a) {
                obj = Operation.AND;
            } else if (queryType2 == QueryType.f22659b) {
                obj = Operation.OR;
            }
            if (obj != null) {
                hashMap.put("query_type", obj);
            }
            obj = str12;
        }
        Map hashMap2 = new HashMap();
        if (!(obj == null || list4 == null || list.size() <= 0)) {
            hashMap2.put(obj, list4);
        }
        if (list5 != null && list2.size() > 0) {
            hashMap2.put("channel_urls", list5);
        }
        if (list6 != null && list3.size() > 0) {
            hashMap2.put("custom_types", list6);
        }
        if (superChannelFilter2 == SuperChannelFilter.ALL) {
            hashMap.put("super_mode", "all");
        } else if (superChannelFilter2 == SuperChannelFilter.SUPER_CHANNEL_ONLY) {
            hashMap.put("super_mode", "super");
        } else if (superChannelFilter2 == SuperChannelFilter.NONSUPER_CHANNEL_ONLY) {
            hashMap.put("super_mode", "nonsuper");
        }
        if (publicChannelFilter2 == PublicChannelFilter.ALL) {
            hashMap.put("public_mode", "all");
        } else if (publicChannelFilter2 == PublicChannelFilter.PUBLIC) {
            hashMap.put("public_mode", "public");
        } else if (publicChannelFilter2 == PublicChannelFilter.PRIVATE) {
            hashMap.put("public_mode", "private");
        }
        m24827a(format, hashMap, hashMap2, aPIClientHandler);
    }

    final void m24857e(String str, String str2, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/users/%s/block", new Object[]{UrlUtil.m24816a(str)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("target_id", str2);
        m24826a(str, jsonObject, aPIClientHandler);
    }

    final void m24845a(String str, String str2, boolean z, APIClientHandler aPIClientHandler) {
        str = String.format("/v3/users/%s/push_preference/%s", new Object[]{UrlUtil.m24816a(str), UrlUtil.m24816a(str2)});
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31126a("enable", Boolean.valueOf(z));
        m24830b(str, jsonObject, aPIClientHandler);
    }

    final void m24847a(boolean z, String str, long j, final APIClientHandler aPIClientHandler) {
        if (z) {
            z = String.format("/v3/open_channels/%s/messages/%s", new Object[]{UrlUtil.m24816a(str), Long.toString(j)});
        } else {
            z = String.format("/v3/group_channels/%s/messages/%s", new Object[]{UrlUtil.m24816a(str), Long.toString(j)});
        }
        str = new JsonObject();
        if (m24856e() != null) {
            if (m24856e().length() != null) {
                m24837a(new CheckRoutingHandler(this) {
                    final /* synthetic */ Map f30015c = null;
                    final /* synthetic */ Map f30016d = null;
                    final /* synthetic */ APIClient f30018f;

                    public final void mo5210a(String str, String str2, SendBirdException sendBirdException) {
                        if (sendBirdException != null) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, sendBirdException);
                            }
                            return;
                        }
                        try {
                            str = APIClient.m24821a(str, z, this.f30015c, this.f30016d);
                            sendBirdException = new StringBuilder("DELETE: ");
                            sendBirdException.append(str);
                            Logger.m24934b(sendBirdException.toString());
                            String a = APIClient.f22522a.m25064a(str);
                            StringBuilder stringBuilder = new StringBuilder("API request: ");
                            stringBuilder.append(a);
                            Logger.m24934b(stringBuilder.toString());
                            RequestBody a2 = RequestBody.m25321a(APIClient.f22523b, a);
                            StringBuilder stringBuilder2 = new StringBuilder("Jand/");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2 = new StringBuilder("Android,");
                            stringBuilder2.append(SendBird.m24977b());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24986d());
                            this.f30018f.m24838a(new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25317a("Session-Key", this.f30018f.f22525d).m25315a(str).m25316a("DELETE", a2).m25318a(), aPIClientHandler);
                        } catch (String str3) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, new SendBirdException(str3.getMessage(), 800220));
                            }
                        }
                    }
                });
                return;
            }
        }
        aPIClientHandler.mo5216a(false, new SendBirdException("Connection must be made.", 800101));
    }

    final synchronized void m24840a(String str) {
        if (str != null) {
            this.f22525d = str;
        }
    }

    final synchronized void m24849b(String str) {
        if (str != null) {
            this.f22526e = str;
        }
    }

    final synchronized String m24856e() {
        return this.f22525d;
    }

    final synchronized String m24858f() {
        return this.f22526e;
    }

    final void m24850b(String str, APIClientHandler aPIClientHandler) {
        m24827a(str, null, null, aPIClientHandler);
    }

    private void m24827a(String str, Map<String, String> map, Map<String, Collection<String>> map2, APIClientHandler aPIClientHandler) {
        if (m24856e() != null) {
            if (m24856e().length() != 0) {
                final APIClientHandler aPIClientHandler2 = aPIClientHandler;
                final String str2 = str;
                final Map<String, String> map3 = map;
                final Map<String, Collection<String>> map4 = map2;
                m24837a(new CheckRoutingHandler(this) {
                    final /* synthetic */ APIClient f29995e;

                    public final void mo5210a(String str, String str2, SendBirdException sendBirdException) {
                        if (sendBirdException != null) {
                            if (aPIClientHandler2 != null) {
                                aPIClientHandler2.mo5216a(null, sendBirdException);
                            }
                            return;
                        }
                        try {
                            str = APIClient.m24821a(str, str2, map3, map4);
                            sendBirdException = new StringBuilder("GET: ");
                            sendBirdException.append(str);
                            Logger.m24934b(sendBirdException.toString());
                            StringBuilder stringBuilder = new StringBuilder("Jand/");
                            stringBuilder.append(SendBird.m24983c());
                            stringBuilder = new StringBuilder("Android,");
                            stringBuilder.append(SendBird.m24977b());
                            stringBuilder.append(",");
                            stringBuilder.append(SendBird.m24983c());
                            stringBuilder.append(",");
                            stringBuilder.append(SendBird.m24986d());
                            this.f29995e.m24838a(new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder.toString()).m25317a("SendBird", stringBuilder.toString()).m25317a("Connection", "keep-alive").m25317a("Session-Key", this.f29995e.f22525d).m25315a(str).m25318a(), aPIClientHandler2);
                        } catch (String str3) {
                            if (aPIClientHandler2 != null) {
                                aPIClientHandler2.mo5216a(null, new SendBirdException(str3.getMessage(), 800220));
                            }
                        }
                    }
                });
                return;
            }
        }
        if (aPIClientHandler != null) {
            aPIClientHandler.mo5216a(null, new SendBirdException("Connection must be made.", 800101));
        }
    }

    private void m24826a(final String str, final JsonElement jsonElement, final APIClientHandler aPIClientHandler) {
        if (m24856e() != null) {
            if (m24856e().length() != 0) {
                m24837a(new CheckRoutingHandler(this) {
                    final /* synthetic */ APIClient f29999d;

                    public final void mo5210a(String str, String str2, SendBirdException sendBirdException) {
                        str2 = new StringBuilder("POST: ");
                        str2.append(str);
                        str2.append(str);
                        Logger.m24934b(str2.toString());
                        if (sendBirdException != null) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, sendBirdException);
                            }
                            return;
                        }
                        try {
                            String a = APIClient.f22522a.m25064a(jsonElement);
                            StringBuilder stringBuilder = new StringBuilder("API request: ");
                            stringBuilder.append(a);
                            Logger.m24934b(stringBuilder.toString());
                            RequestBody a2 = RequestBody.m25321a(APIClient.f22523b, a);
                            StringBuilder stringBuilder2 = new StringBuilder("Jand/");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2 = new StringBuilder("Android,");
                            stringBuilder2.append(SendBird.m24977b());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24986d());
                            Builder a3 = new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25317a("Session-Key", this.f29999d.f22525d);
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str);
                            stringBuilder3.append(str);
                            this.f29999d.m24838a(a3.m25315a(stringBuilder3.toString()).m25316a(HttpRequest.METHOD_POST, a2).m25318a(), aPIClientHandler);
                        } catch (String str3) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, new SendBirdException(str3.getMessage(), 800220));
                            }
                        }
                    }
                });
                return;
            }
        }
        if (aPIClientHandler != null) {
            aPIClientHandler.mo5216a(null, new SendBirdException("Connection must be made.", 800101));
        }
    }

    private void m24830b(final String str, final JsonElement jsonElement, final APIClientHandler aPIClientHandler) {
        if (m24856e() != null) {
            if (m24856e().length() != 0) {
                m24837a(new CheckRoutingHandler(this) {
                    final /* synthetic */ APIClient f30012d;

                    public final void mo5210a(String str, String str2, SendBirdException sendBirdException) {
                        str2 = new StringBuilder("PUT: ");
                        str2.append(str);
                        str2.append(str);
                        Logger.m24934b(str2.toString());
                        if (sendBirdException != null) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, sendBirdException);
                            }
                            return;
                        }
                        try {
                            String a = APIClient.f22522a.m25064a(jsonElement);
                            StringBuilder stringBuilder = new StringBuilder("API request: ");
                            stringBuilder.append(a);
                            Logger.m24934b(stringBuilder.toString());
                            RequestBody a2 = RequestBody.m25321a(APIClient.f22523b, a);
                            StringBuilder stringBuilder2 = new StringBuilder("Jand/");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2 = new StringBuilder("Android,");
                            stringBuilder2.append(SendBird.m24977b());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24986d());
                            Builder a3 = new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25317a("Session-Key", this.f30012d.f22525d);
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str);
                            stringBuilder3.append(str);
                            this.f30012d.m24838a(a3.m25315a(stringBuilder3.toString()).m25316a(HttpRequest.METHOD_PUT, a2).m25318a(), aPIClientHandler);
                        } catch (String str3) {
                            if (aPIClientHandler != null) {
                                aPIClientHandler.mo5216a(null, new SendBirdException(str3.getMessage(), 800220));
                            }
                        }
                    }
                });
                return;
            }
        }
        if (aPIClientHandler != null) {
            aPIClientHandler.mo5216a(null, new SendBirdException("Connection must be made.", 800101));
        }
    }

    final synchronized void m24838a(Request request, final APIClientHandler aPIClientHandler) {
        RealCall.m31337a(this.f22527f, request, false).mo5319a(new Callback(this) {
            final /* synthetic */ APIClient f29987b;

            public final void mo5209a(Call call, IOException iOException) {
                if (aPIClientHandler != null && call.mo5321c() == null) {
                    aPIClientHandler.mo5216a(null, new SendBirdException(iOException.getMessage(), 800220));
                }
            }

            public final void mo5208a(Call call, Response response) throws IOException {
                try {
                    response = APIClient.m24819a(response);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(response, null);
                    }
                } catch (Exception e) {
                    Logger.m24933b(e);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(null, e);
                    }
                } catch (Exception e2) {
                    Logger.m24933b(e2);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(null, new SendBirdException(e2.getMessage(), 800220));
                    }
                }
            }
        });
    }

    private synchronized void m24825a(Request request, final String str, final APIClientHandler aPIClientHandler) {
        request = RealCall.m31337a(this.f22528g, request, false);
        request.mo5319a(new Callback(this) {
            final /* synthetic */ APIClient f29990c;

            public final void mo5209a(Call call, IOException iOException) {
                synchronized (this.f29990c.f22530i) {
                    if (this.f29990c.f22529h.containsKey(str)) {
                        this.f29990c.f22529h.remove(str);
                    }
                }
                if (aPIClientHandler != null) {
                    if (call.mo5321c() != null) {
                        aPIClientHandler.mo5216a(null, new SendBirdException("File Message upload canceled."));
                        return;
                    }
                    aPIClientHandler.mo5216a(null, new SendBirdException(iOException.getMessage(), 800220));
                }
            }

            public final void mo5208a(Call call, Response response) throws IOException {
                synchronized (this.f29990c.f22530i) {
                    if (this.f29990c.f22529h.containsKey(str)) {
                        this.f29990c.f22529h.remove(str);
                    }
                }
                try {
                    response = APIClient.m24819a(response);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(response, null);
                    }
                } catch (Exception e) {
                    Logger.m24933b(e);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(null, e);
                    }
                } catch (Exception e2) {
                    Logger.m24933b(e2);
                    if (aPIClientHandler != null) {
                        aPIClientHandler.mo5216a(null, new SendBirdException(e2.getMessage(), 800220));
                    }
                }
            }
        });
        if (str != null) {
            synchronized (this.f22530i) {
                this.f22529h.put(str, request);
            }
        }
    }

    private static String m24822a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.size() > 0) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(String.format("%s=%s", new Object[]{entry.getKey(), entry.getValue()}));
            }
        }
        return stringBuilder.toString();
    }

    protected final void m24837a(CheckRoutingHandler checkRoutingHandler) {
        CheckRouting.m24808a(this.f22527f, checkRoutingHandler);
    }

    protected static void m24834g() {
        CheckRouting.m24807a();
    }

    final void m24839a(File file, String str, List<ThumbnailSize> list, String str2, String str3, APIClientHandler aPIClientHandler) {
        final String str4 = "/v3/storage/file";
        if (m24856e() != null) {
            if (m24856e().length() != 0) {
                final APIClientHandler aPIClientHandler2 = aPIClientHandler;
                final String str5 = str;
                final File file2 = file;
                final List<ThumbnailSize> list2 = list;
                final String str6 = str2;
                final String str7 = str3;
                m24837a(new CheckRoutingHandler(this) {
                    final /* synthetic */ APIClientProgressHandler f30006g = null;
                    final /* synthetic */ APIClient f30008i;

                    public final void mo5210a(java.lang.String r13, java.lang.String r14, com.sendbird.android.SendBirdException r15) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r12 = this;
                        r14 = new java.lang.StringBuilder;
                        r0 = "FILE: ";
                        r14.<init>(r0);
                        r14.append(r13);
                        r0 = r2;
                        r14.append(r0);
                        r14 = r14.toString();
                        com.sendbird.android.Logger.m24934b(r14);
                        r14 = 0;
                        if (r15 == 0) goto L_0x0023;
                    L_0x0019:
                        r13 = r3;
                        if (r13 == 0) goto L_0x0022;
                    L_0x001d:
                        r13 = r3;
                        r13.mo5216a(r14, r15);
                    L_0x0022:
                        return;
                    L_0x0023:
                        r15 = 800220; // 0xc35dc float:1.121347E-39 double:3.95361E-318;
                        r0 = r4;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        if (r0 == 0) goto L_0x0035;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                    L_0x002a:
                        r0 = r4;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        r0 = r0.length();	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        if (r0 <= 0) goto L_0x0035;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                    L_0x0032:
                        r0 = r4;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        goto L_0x004a;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                    L_0x0035:
                        r0 = r5;	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        r0 = r0.toURI();	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        r0 = r0.toURL();	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        r0 = r0.openConnection();	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        r0 = r0.getContentType();	 Catch:{ IOException -> 0x01e3, StringIndexOutOfBoundsException -> 0x0048 }
                        goto L_0x004a;
                    L_0x0048:
                        r0 = "application/octet-stream";
                    L_0x004a:
                        r1 = com.sendbird.android.shadow.okhttp3.MediaType.m25307a(r0);
                        r2 = "text/plain";
                        r2 = com.sendbird.android.shadow.okhttp3.MediaType.m25307a(r2);
                        r3 = new java.lang.StringBuilder;
                        r4 = "File: ";
                        r3.<init>(r4);
                        r4 = r5;
                        r3.append(r4);
                        r3 = r3.toString();
                        com.sendbird.android.Logger.m24934b(r3);
                        r3 = new java.lang.StringBuilder;
                        r4 = "Mime: ";
                        r3.<init>(r4);
                        r3.append(r0);
                        r0 = r3.toString();
                        com.sendbird.android.Logger.m24934b(r0);
                        r0 = new java.util.ArrayList;
                        r0.<init>();
                        r3 = new java.util.ArrayList;
                        r3.<init>();
                        r4 = 4;
                        r4 = new java.lang.String[r4];
                        r5 = "Content-Disposition";
                        r6 = 0;
                        r4[r6] = r5;
                        r5 = new java.lang.StringBuilder;
                        r7 = "form-data; name=\"file\"; filename=\"";
                        r5.<init>(r7);
                        r7 = r5;
                        r7 = r7.getName();
                        r5.append(r7);
                        r7 = "\"";
                        r5.append(r7);
                        r5 = r5.toString();
                        r7 = 1;
                        r4[r7] = r5;
                        r5 = "Content-Transfer-Encoding";
                        r8 = 2;
                        r4[r8] = r5;
                        r5 = 3;
                        r9 = "binary";
                        r4[r5] = r9;
                        r4 = com.sendbird.android.shadow.okhttp3.Headers.m25266a(r4);
                        r0.add(r4);
                        r4 = r5;
                        r1 = com.sendbird.android.shadow.okhttp3.RequestBody.m25320a(r1, r4);
                        r3.add(r1);
                        r1 = r6;
                        if (r1 == 0) goto L_0x011a;
                    L_0x00c4:
                        r1 = r6;
                        r1 = r1.iterator();
                        r4 = r7;
                    L_0x00cb:
                        r5 = r1.hasNext();
                        if (r5 == 0) goto L_0x011a;
                    L_0x00d1:
                        r5 = r1.next();
                        r5 = (com.sendbird.android.FileMessage.ThumbnailSize) r5;
                        r9 = new java.lang.String[r8];
                        r10 = "Content-Disposition";
                        r9[r6] = r10;
                        r10 = new java.lang.StringBuilder;
                        r11 = "form-data; name=\"thumbnail";
                        r10.<init>(r11);
                        r10.append(r4);
                        r11 = "\"";
                        r10.append(r11);
                        r10 = r10.toString();
                        r9[r7] = r10;
                        r9 = com.sendbird.android.shadow.okhttp3.Headers.m25266a(r9);
                        r0.add(r9);
                        r9 = new java.lang.StringBuilder;
                        r9.<init>();
                        r10 = r5.f22590a;
                        r9.append(r10);
                        r10 = ",";
                        r9.append(r10);
                        r5 = r5.f22591b;
                        r9.append(r5);
                        r5 = r9.toString();
                        r5 = com.sendbird.android.shadow.okhttp3.RequestBody.m25321a(r2, r5);
                        r3.add(r5);
                        r4 = r4 + r7;
                        goto L_0x00cb;
                    L_0x011a:
                        r1 = r7;
                        if (r1 == 0) goto L_0x0136;
                    L_0x011e:
                        r1 = "Content-Disposition";
                        r4 = "form-data; name=\"channel_url\"";
                        r1 = new java.lang.String[]{r1, r4};
                        r1 = com.sendbird.android.shadow.okhttp3.Headers.m25266a(r1);
                        r0.add(r1);
                        r1 = r7;
                        r1 = com.sendbird.android.shadow.okhttp3.RequestBody.m25321a(r2, r1);
                        r3.add(r1);
                    L_0x0136:
                        r1 = new com.sendbird.android.APIClient$FixedLengthMultipartRequestBody;	 Catch:{ Exception -> 0x01cf }
                        r2 = r12.f30006g;	 Catch:{ Exception -> 0x01cf }
                        r1.<init>(r0, r3, r2);	 Catch:{ Exception -> 0x01cf }
                        r0 = new com.sendbird.android.shadow.okhttp3.Request$Builder;	 Catch:{ Exception -> 0x01cf }
                        r0.<init>();	 Catch:{ Exception -> 0x01cf }
                        r2 = "Accept";	 Catch:{ Exception -> 0x01cf }
                        r3 = "application/json";	 Catch:{ Exception -> 0x01cf }
                        r0 = r0.m25317a(r2, r3);	 Catch:{ Exception -> 0x01cf }
                        r2 = "User-Agent";	 Catch:{ Exception -> 0x01cf }
                        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cf }
                        r4 = "Jand/";	 Catch:{ Exception -> 0x01cf }
                        r3.<init>(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = com.sendbird.android.SendBird.m24983c();	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r3 = r3.toString();	 Catch:{ Exception -> 0x01cf }
                        r0 = r0.m25317a(r2, r3);	 Catch:{ Exception -> 0x01cf }
                        r2 = "SendBird";	 Catch:{ Exception -> 0x01cf }
                        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cf }
                        r4 = "Android,";	 Catch:{ Exception -> 0x01cf }
                        r3.<init>(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = com.sendbird.android.SendBird.m24977b();	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = ",";	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = com.sendbird.android.SendBird.m24983c();	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = ",";	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r4 = com.sendbird.android.SendBird.m24986d();	 Catch:{ Exception -> 0x01cf }
                        r3.append(r4);	 Catch:{ Exception -> 0x01cf }
                        r3 = r3.toString();	 Catch:{ Exception -> 0x01cf }
                        r0 = r0.m25317a(r2, r3);	 Catch:{ Exception -> 0x01cf }
                        r2 = "Connection";	 Catch:{ Exception -> 0x01cf }
                        r3 = "keep-alive";	 Catch:{ Exception -> 0x01cf }
                        r0 = r0.m25317a(r2, r3);	 Catch:{ Exception -> 0x01cf }
                        r2 = "Session-Key";	 Catch:{ Exception -> 0x01cf }
                        r3 = r12.f30008i;	 Catch:{ Exception -> 0x01cf }
                        r3 = r3.f22525d;	 Catch:{ Exception -> 0x01cf }
                        r0 = r0.m25317a(r2, r3);	 Catch:{ Exception -> 0x01cf }
                        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cf }
                        r2.<init>();	 Catch:{ Exception -> 0x01cf }
                        r2.append(r13);	 Catch:{ Exception -> 0x01cf }
                        r13 = r2;	 Catch:{ Exception -> 0x01cf }
                        r2.append(r13);	 Catch:{ Exception -> 0x01cf }
                        r13 = r2.toString();	 Catch:{ Exception -> 0x01cf }
                        r13 = r0.m25315a(r13);	 Catch:{ Exception -> 0x01cf }
                        r0 = "POST";	 Catch:{ Exception -> 0x01cf }
                        r13 = r13.m25316a(r0, r1);	 Catch:{ Exception -> 0x01cf }
                        r13 = r13.m25318a();	 Catch:{ Exception -> 0x01cf }
                        r0 = r12.f30008i;	 Catch:{ Exception -> 0x01cf }
                        r1 = r8;	 Catch:{ Exception -> 0x01cf }
                        r2 = r3;	 Catch:{ Exception -> 0x01cf }
                        r0.m24825a(r13, r1, r2);	 Catch:{ Exception -> 0x01cf }
                        return;
                    L_0x01cf:
                        r13 = move-exception;
                        r0 = r3;
                        if (r0 == 0) goto L_0x01e2;
                    L_0x01d4:
                        r0 = r3;
                        r1 = new com.sendbird.android.SendBirdException;
                        r13 = r13.getMessage();
                        r1.<init>(r13, r15);
                        r0.mo5216a(r14, r1);
                    L_0x01e2:
                        return;
                    L_0x01e3:
                        r13 = move-exception;
                        r0 = r3;
                        if (r0 == 0) goto L_0x01f6;
                    L_0x01e8:
                        r0 = r3;
                        r1 = new com.sendbird.android.SendBirdException;
                        r13 = r13.getMessage();
                        r1.<init>(r13, r15);
                        r0.mo5216a(r14, r1);
                    L_0x01f6:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.APIClient.6.a(java.lang.String, java.lang.String, com.sendbird.android.SendBirdException):void");
                    }
                });
                return;
            }
        }
        APIClient aPIClient = this;
        aPIClientHandler.mo5216a(null, new SendBirdException("Connection must be made.", 800101));
    }

    protected static JsonElement m24819a(Response response) throws SendBirdException {
        try {
            String d = response.f23314g.m25339d();
            StringBuilder stringBuilder = new StringBuilder("API response: ");
            stringBuilder.append(d);
            Logger.m24934b(stringBuilder.toString());
            if (d != null) {
                if (d.length() > 0) {
                    try {
                        JsonParser jsonParser = new JsonParser();
                        JsonElement a = JsonParser.m25078a(d);
                        int i = 0;
                        response = (response.f23310c < HttpStatus.HTTP_OK || response.f23310c >= 300) ? null : true;
                        if (response != null || (a instanceof JsonObject) == null || a.m25073h().m31129a("error") == null || (a.m25073h().m31130b("error") instanceof JsonPrimitive) == null || a.m25073h().m31130b("error").mo5248g() == null) {
                            return a;
                        }
                        response = "";
                        if (a.m25073h().m31129a("message") && (a.m25073h().m31130b("message") instanceof JsonPrimitive)) {
                            response = a.m25073h().m31130b("message").mo5244c();
                        }
                        if (a.m25073h().m31129a("code") && (a.m25073h().m31130b("code") instanceof JsonPrimitive)) {
                            i = a.m25073h().m31130b("code").mo5247f();
                        }
                        throw new SendBirdException(response, i);
                    } catch (Response response2) {
                        throw new SendBirdException(response2.getMessage(), 800130);
                    }
                }
            }
            return JsonNull.f30234a;
        } catch (Response response22) {
            throw new SendBirdException(response22.getMessage(), 800130);
        }
    }

    static /* synthetic */ String m24821a(String str, String str2, Map map, Map map2) {
        Map hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(UrlUtil.m24816a((String) entry.getKey()), UrlUtil.m24816a((String) entry.getValue()));
            }
        }
        if (map2 != null && map2.size() > null) {
            for (Entry entry2 : map2.entrySet()) {
                hashMap.put(UrlUtil.m24816a((String) entry2.getKey()), UrlUtil.m24817a((Collection) entry2.getValue()));
            }
        }
        if (hashMap.size() > null) {
            map = m24822a(hashMap);
            map2 = new StringBuilder();
            map2.append(str);
            map2.append(str2);
            map2.append(Operation.EMPTY_PARAM);
            map2.append(map);
            return map2.toString();
        }
        map = new StringBuilder();
        map.append(str);
        map.append(str2);
        return map.toString();
    }
}
