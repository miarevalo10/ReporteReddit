package com.instabug.library.network;

/* compiled from: ServerConnectionException */
public class C0748c extends Exception {
    public C0748c(String str) {
        StringBuilder stringBuilder = new StringBuilder("Server connection error - ");
        stringBuilder.append(str);
        super(stringBuilder.toString());
    }

    public C0748c() {
        super("Server connection error");
    }
}
