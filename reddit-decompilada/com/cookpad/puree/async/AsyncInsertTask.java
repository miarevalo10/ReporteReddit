package com.cookpad.puree.async;

import android.os.AsyncTask;
import com.cookpad.puree.outputs.PureeBufferedOutput;
import org.json.JSONObject;

public class AsyncInsertTask extends AsyncTask<Void, Void, Void> {
    private PureeBufferedOutput f3693a;
    private String f3694b;
    private JSONObject f3695c;

    public AsyncInsertTask(PureeBufferedOutput pureeBufferedOutput, String str, JSONObject jSONObject) {
        this.f3693a = pureeBufferedOutput;
        this.f3694b = str;
        this.f3695c = jSONObject;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        this.f3693a.m11744a(this.f3694b, this.f3695c);
        return null;
    }
}
