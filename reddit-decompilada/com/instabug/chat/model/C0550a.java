package com.instabug.chat.model;

import java.util.ArrayList;

/* compiled from: FlatMessage */
public class C0550a {
    public String f9275a;
    public String f9276b;
    public long f9277c;
    public String f9278d;
    public String f9279e;
    public C0549b f9280f;
    public C0548a f9281g;
    public boolean f9282h;
    public boolean f9283i = false;
    public ArrayList<C1308b> f9284j;

    /* compiled from: FlatMessage */
    public enum C0548a {
        NONE,
        PLAYING
    }

    /* compiled from: FlatMessage */
    public enum C0549b {
        MESSAGE,
        IMAGE,
        AUDIO,
        VIDEO
    }

    public final boolean m7927a() {
        return this.f9284j != null && this.f9284j.size() > 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Body: ");
        stringBuilder.append(this.f9275a);
        stringBuilder.append("URL: ");
        stringBuilder.append(this.f9278d);
        stringBuilder.append("has actions: ");
        stringBuilder.append(m7927a());
        stringBuilder.append("type: ");
        stringBuilder.append(this.f9280f);
        stringBuilder.append("actions: ");
        stringBuilder.append(this.f9284j);
        return stringBuilder.toString();
    }
}
