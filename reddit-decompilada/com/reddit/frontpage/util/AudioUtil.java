package com.reddit.frontpage.util;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.instabug.chat.model.Attachment;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public class AudioUtil {
    public final PublishSubject<Integer> f21699a = PublishSubject.create();
    private final AudioManager f21700b = ((AudioManager) FrontpageApplication.f27402a.getSystemService(Attachment.TYPE_AUDIO));
    private final OnAudioFocusChangeListener f21701c = new AudioUtil$$Lambda$0(this);

    AudioUtil() {
    }

    public final boolean m23652a() {
        boolean z = 1 == this.f21700b.requestAudioFocus(this.f21701c, 3, 1);
        String str = "Audio focus request result [%s]";
        Object[] objArr = new Object[1];
        objArr[0] = z ? "success" : "fail";
        Timber.b(str, objArr);
        return z;
    }

    public final boolean m23653b() {
        boolean z = 1 == this.f21700b.abandonAudioFocus(this.f21701c);
        String str = "Audio abandon request result [%s]";
        Object[] objArr = new Object[1];
        objArr[0] = z ? "success" : "fail";
        Timber.b(str, objArr);
        return z;
    }
}
