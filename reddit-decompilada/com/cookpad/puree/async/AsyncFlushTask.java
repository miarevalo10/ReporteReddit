package com.cookpad.puree.async;

import android.os.AsyncTask;
import com.cookpad.puree.outputs.PureeBufferedOutput;

public class AsyncFlushTask extends AsyncTask<Void, Void, Void> {
    private PureeBufferedOutput f3692a;

    public AsyncFlushTask(PureeBufferedOutput pureeBufferedOutput) {
        this.f3692a = pureeBufferedOutput;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        this.f3692a.m11747b();
        return null;
    }
}
