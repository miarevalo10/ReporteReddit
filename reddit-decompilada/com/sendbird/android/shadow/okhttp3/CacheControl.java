package com.sendbird.android.shadow.okhttp3;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.concurrent.TimeUnit;

public final class CacheControl {
    public static final CacheControl f23073a;
    public static final CacheControl f23074b;
    public final boolean f23075c;
    public final boolean f23076d;
    public final int f23077e;
    public final boolean f23078f;
    public final boolean f23079g;
    public final boolean f23080h;
    public final int f23081i;
    public final int f23082j;
    public final boolean f23083k;
    public final boolean f23084l;
    String f23085m;
    private final int f23086n;
    private final boolean f23087o;

    public static final class Builder {
        boolean f23065a;
        boolean f23066b;
        int f23067c = -1;
        int f23068d = -1;
        int f23069e = -1;
        boolean f23070f;
        boolean f23071g;
        boolean f23072h;

        public final CacheControl m25199a() {
            return new CacheControl(this);
        }
    }

    static {
        Builder builder = new Builder();
        builder.f23065a = true;
        f23073a = builder.m25199a();
        builder = new Builder();
        builder.f23070f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        builder.f23068d = toSeconds > 2147483647L ? RedditJobManager.f10810d : (int) toSeconds;
        f23074b = builder.m25199a();
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f23075c = z;
        this.f23076d = z2;
        this.f23077e = i;
        this.f23086n = i2;
        this.f23078f = z3;
        this.f23079g = z4;
        this.f23080h = z5;
        this.f23081i = i3;
        this.f23082j = i4;
        this.f23083k = z6;
        this.f23087o = z7;
        this.f23084l = z8;
        this.f23085m = str;
    }

    CacheControl(Builder builder) {
        this.f23075c = builder.f23065a;
        this.f23076d = builder.f23066b;
        this.f23077e = builder.f23067c;
        this.f23086n = -1;
        this.f23078f = false;
        this.f23079g = false;
        this.f23080h = false;
        this.f23081i = builder.f23068d;
        this.f23082j = builder.f23069e;
        this.f23083k = builder.f23070f;
        this.f23087o = builder.f23071g;
        this.f23084l = builder.f23072h;
    }

    public final String toString() {
        String str = this.f23085m;
        if (str != null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f23075c) {
            stringBuilder.append("no-cache, ");
        }
        if (this.f23076d) {
            stringBuilder.append("no-store, ");
        }
        if (this.f23077e != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.f23077e);
            stringBuilder.append(", ");
        }
        if (this.f23086n != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.f23086n);
            stringBuilder.append(", ");
        }
        if (this.f23078f) {
            stringBuilder.append("private, ");
        }
        if (this.f23079g) {
            stringBuilder.append("public, ");
        }
        if (this.f23080h) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.f23081i != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.f23081i);
            stringBuilder.append(", ");
        }
        if (this.f23082j != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.f23082j);
            stringBuilder.append(", ");
        }
        if (this.f23083k) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.f23087o) {
            stringBuilder.append("no-transform, ");
        }
        if (this.f23084l) {
            stringBuilder.append("immutable, ");
        }
        if (stringBuilder.length() == 0) {
            str = "";
        } else {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            str = stringBuilder.toString();
        }
        this.f23085m = str;
        return str;
    }

    public static CacheControl m25200a(Headers headers) {
        Headers headers2 = headers;
        int length = headers2.f23197a.length / 2;
        Object obj = 1;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (int i5 = 0; i5 < length; i5++) {
            int i6;
            int a;
            String trim;
            int a2;
            boolean z9;
            int a3;
            String trim2;
            String a4 = headers2.m25268a(i5);
            String b = headers2.m25270b(i5);
            if (a4.equalsIgnoreCase(HttpRequest.HEADER_CACHE_CONTROL)) {
                if (str == null) {
                    str = b;
                    i6 = 0;
                    while (i6 < b.length()) {
                        a = HttpHeaders.m25426a(b, i6, "=,;");
                        trim = b.substring(i6, a).trim();
                        if (!(a == b.length() || b.charAt(a) == ',')) {
                            if (b.charAt(a) == ';') {
                                a2 = HttpHeaders.m25425a(b, a + 1);
                                if (a2 < b.length() || b.charAt(a2) != '\"') {
                                    z9 = true;
                                    a3 = HttpHeaders.m25426a(b, a2, ",;");
                                    trim2 = b.substring(a2, a3).trim();
                                } else {
                                    a2++;
                                    a3 = HttpHeaders.m25426a(b, a2, "\"");
                                    trim2 = b.substring(a2, a3);
                                    z9 = true;
                                    a3++;
                                }
                                if (!"no-cache".equalsIgnoreCase(trim)) {
                                    i6 = a3;
                                    z = z9;
                                } else if ("no-store".equalsIgnoreCase(trim)) {
                                    if (!"max-age".equalsIgnoreCase(trim)) {
                                        i = HttpHeaders.m25432b(trim2, -1);
                                    } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                                        i2 = HttpHeaders.m25432b(trim2, -1);
                                    } else if (!"private".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z3 = z9;
                                    } else if (!"public".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z4 = z9;
                                    } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z5 = z9;
                                    } else if (!"max-stale".equalsIgnoreCase(trim)) {
                                        i3 = HttpHeaders.m25432b(trim2, RedditJobManager.f10810d);
                                    } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                                        i4 = HttpHeaders.m25432b(trim2, -1);
                                    } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z6 = z9;
                                    } else if (!"no-transform".equalsIgnoreCase(trim)) {
                                        i6 = a3;
                                        z7 = z9;
                                    } else if ("immutable".equalsIgnoreCase(trim)) {
                                        z8 = z9;
                                    }
                                    i6 = a3;
                                } else {
                                    i6 = a3;
                                    z2 = z9;
                                }
                            }
                        }
                        z9 = true;
                        a3 = a + 1;
                        trim2 = null;
                        if (!"no-cache".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z = z9;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            if (!"max-age".equalsIgnoreCase(trim)) {
                                i = HttpHeaders.m25432b(trim2, -1);
                            } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                                i2 = HttpHeaders.m25432b(trim2, -1);
                            } else if (!"private".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z3 = z9;
                            } else if (!"public".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z4 = z9;
                            } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z5 = z9;
                            } else if (!"max-stale".equalsIgnoreCase(trim)) {
                                i3 = HttpHeaders.m25432b(trim2, RedditJobManager.f10810d);
                            } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                                i4 = HttpHeaders.m25432b(trim2, -1);
                            } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z6 = z9;
                            } else if (!"no-transform".equalsIgnoreCase(trim)) {
                                i6 = a3;
                                z7 = z9;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z8 = z9;
                            }
                            i6 = a3;
                        } else {
                            i6 = a3;
                            z2 = z9;
                        }
                    }
                }
            } else if (!a4.equalsIgnoreCase("Pragma")) {
            }
            obj = null;
            i6 = 0;
            while (i6 < b.length()) {
                a = HttpHeaders.m25426a(b, i6, "=,;");
                trim = b.substring(i6, a).trim();
                if (b.charAt(a) == ';') {
                    a2 = HttpHeaders.m25425a(b, a + 1);
                    if (a2 < b.length()) {
                    }
                    z9 = true;
                    a3 = HttpHeaders.m25426a(b, a2, ",;");
                    trim2 = b.substring(a2, a3).trim();
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z = z9;
                    } else if ("no-store".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z2 = z9;
                    } else {
                        if (!"max-age".equalsIgnoreCase(trim)) {
                            i = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                            i2 = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"private".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z3 = z9;
                        } else if (!"public".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z4 = z9;
                        } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z5 = z9;
                        } else if (!"max-stale".equalsIgnoreCase(trim)) {
                            i3 = HttpHeaders.m25432b(trim2, RedditJobManager.f10810d);
                        } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                            i4 = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z6 = z9;
                        } else if (!"no-transform".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z7 = z9;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z8 = z9;
                        }
                        i6 = a3;
                    }
                } else {
                    z9 = true;
                    a3 = a + 1;
                    trim2 = null;
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        i6 = a3;
                        z = z9;
                    } else if ("no-store".equalsIgnoreCase(trim)) {
                        if (!"max-age".equalsIgnoreCase(trim)) {
                            i = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                            i2 = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"private".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z3 = z9;
                        } else if (!"public".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z4 = z9;
                        } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z5 = z9;
                        } else if (!"max-stale".equalsIgnoreCase(trim)) {
                            i3 = HttpHeaders.m25432b(trim2, RedditJobManager.f10810d);
                        } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                            i4 = HttpHeaders.m25432b(trim2, -1);
                        } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z6 = z9;
                        } else if (!"no-transform".equalsIgnoreCase(trim)) {
                            i6 = a3;
                            z7 = z9;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z8 = z9;
                        }
                        i6 = a3;
                    } else {
                        i6 = a3;
                        z2 = z9;
                    }
                }
            }
        }
        return new CacheControl(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, obj == null ? null : str);
    }
}
