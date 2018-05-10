package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {
    public URL f12536b;
    private final Headers f12537c;
    private final URL f12538d;
    private final String f12539e;
    private String f12540f;
    private volatile byte[] f12541g;
    private int f12542h;

    public GlideUrl(URL url) {
        this(url, Headers.f3488b);
    }

    public GlideUrl(String str) {
        this(str, Headers.f3488b);
    }

    private GlideUrl(URL url, Headers headers) {
        this.f12538d = (URL) Preconditions.m3217a((Object) url);
        this.f12539e = null;
        this.f12537c = (Headers) Preconditions.m3217a((Object) headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f12538d = null;
        this.f12539e = Preconditions.m3219a(str);
        this.f12537c = (Headers) Preconditions.m3217a((Object) headers);
    }

    public final String m11489a() {
        if (TextUtils.isEmpty(this.f12540f)) {
            String str = this.f12539e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.m3217a(this.f12538d)).toString();
            }
            this.f12540f = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f12540f;
    }

    public final Map<String, String> m11491b() {
        return this.f12537c.mo976a();
    }

    private String m11488c() {
        return this.f12539e != null ? this.f12539e : ((URL) Preconditions.m3217a(this.f12538d)).toString();
    }

    public String toString() {
        return m11488c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!m11488c().equals(glideUrl.m11488c()) || this.f12537c.equals(glideUrl.f12537c) == null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f12542h == 0) {
            this.f12542h = m11488c().hashCode();
            this.f12542h = (31 * this.f12542h) + this.f12537c.hashCode();
        }
        return this.f12542h;
    }

    public final void mo893a(MessageDigest messageDigest) {
        if (this.f12541g == null) {
            this.f12541g = m11488c().getBytes(a);
        }
        messageDigest.update(this.f12541g);
    }
}
