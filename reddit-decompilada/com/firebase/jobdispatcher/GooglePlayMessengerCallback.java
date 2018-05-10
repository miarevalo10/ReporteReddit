package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;

class GooglePlayMessengerCallback implements JobCallback {
    private final Messenger f12702a;
    private final String f12703b;

    GooglePlayMessengerCallback(Messenger messenger, String str) {
        this.f12702a = messenger;
        this.f12703b = str;
    }

    public final void mo1243a(int i) {
        try {
            Messenger messenger = this.f12702a;
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = i;
            i = new Bundle();
            i.putString("tag", this.f12703b);
            obtain.setData(i);
            messenger.send(obtain);
        } catch (int i2) {
            throw new RuntimeException(i2);
        }
    }
}
