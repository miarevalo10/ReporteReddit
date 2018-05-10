package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final UriMatcher f16727a;

    protected final /* synthetic */ void mo3262a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f16727a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f16727a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f16727a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f16727a.addURI("com.android.contacts", "contacts/#", 3);
        f16727a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f16727a.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    protected final /* synthetic */ Object mo3261a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f16727a.match(uri);
        if (match != 1) {
            if (match == 3) {
                contentResolver = Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            } else if (match != 5) {
                contentResolver = contentResolver.openInputStream(uri);
            }
            if (contentResolver == null) {
                return contentResolver;
            }
            StringBuilder stringBuilder = new StringBuilder("InputStream is null for ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
        if (lookupContact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        contentResolver = Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
        if (contentResolver == null) {
            return contentResolver;
        }
        StringBuilder stringBuilder2 = new StringBuilder("InputStream is null for ");
        stringBuilder2.append(uri);
        throw new FileNotFoundException(stringBuilder2.toString());
    }
}
