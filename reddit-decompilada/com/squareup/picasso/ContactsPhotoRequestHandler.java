package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;

class ContactsPhotoRequestHandler extends RequestHandler {
    private static final UriMatcher f30664a;
    private final Context f30665b;

    @TargetApi(14)
    private static class ContactPhotoStreamIcs {
        static InputStream m25752a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f30664a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f30664a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f30664a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f30664a.addURI("com.android.contacts", "contacts/#", 3);
        f30664a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    ContactsPhotoRequestHandler(Context context) {
        this.f30665b = context;
    }

    public final boolean mo5445a(Request request) {
        Uri uri = request.uri;
        return ("content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f30664a.match(request.uri) != -1) ? true : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.squareup.picasso.RequestHandler.Result mo5446b(com.squareup.picasso.Request r5) throws java.io.IOException {
        /*
        r4 = this;
        r0 = r4.f30665b;
        r0 = r0.getContentResolver();
        r5 = r5.uri;
        r1 = f30664a;
        r1 = r1.match(r5);
        r2 = 0;
        switch(r1) {
            case 1: goto L_0x002b;
            case 2: goto L_0x0026;
            case 3: goto L_0x0033;
            case 4: goto L_0x0026;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Invalid uri: ";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        r0.<init>(r5);
        throw r0;
    L_0x0026:
        r5 = r0.openInputStream(r5);
        goto L_0x0042;
    L_0x002b:
        r5 = android.provider.ContactsContract.Contacts.lookupContact(r0, r5);
        if (r5 != 0) goto L_0x0033;
    L_0x0031:
        r5 = r2;
        goto L_0x0042;
    L_0x0033:
        r1 = android.os.Build.VERSION.SDK_INT;
        r3 = 14;
        if (r1 >= r3) goto L_0x003e;
    L_0x0039:
        r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r0, r5);
        goto L_0x0042;
    L_0x003e:
        r5 = com.squareup.picasso.ContactsPhotoRequestHandler.ContactPhotoStreamIcs.m25752a(r0, r5);
    L_0x0042:
        if (r5 == 0) goto L_0x004c;
    L_0x0044:
        r0 = new com.squareup.picasso.RequestHandler$Result;
        r1 = com.squareup.picasso.Picasso.LoadedFrom.DISK;
        r0.<init>(r5, r1);
        return r0;
    L_0x004c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.ContactsPhotoRequestHandler.b(com.squareup.picasso.Request):com.squareup.picasso.RequestHandler$Result");
    }
}
