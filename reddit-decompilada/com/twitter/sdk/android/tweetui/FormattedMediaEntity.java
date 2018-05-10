package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.MediaEntity;

class FormattedMediaEntity extends FormattedUrlEntity {
    final String f30765a;
    final String f30766b;

    FormattedMediaEntity(MediaEntity mediaEntity) {
        super(mediaEntity);
        this.f30765a = mediaEntity.f34649e;
        this.f30766b = mediaEntity.f34647c;
    }
}
