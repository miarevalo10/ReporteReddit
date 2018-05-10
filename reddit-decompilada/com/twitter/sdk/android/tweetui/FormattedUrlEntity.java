package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.UrlEntity;

class FormattedUrlEntity {
    int f24170c;
    int f24171d;
    final String f24172e;
    final String f24173f;

    FormattedUrlEntity(UrlEntity urlEntity) {
        this.f24170c = urlEntity.mo5489a();
        this.f24171d = urlEntity.mo5490b();
        this.f24172e = urlEntity.f30762i;
        this.f24173f = urlEntity.f30761h;
    }
}
