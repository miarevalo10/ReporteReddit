package net.hockeyapp.android.tasks;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import net.hockeyapp.android.utils.Util;

public abstract class ConnectionTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected static String m28194a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        httpURLConnection = Util.m28232a(bufferedInputStream);
        bufferedInputStream.close();
        return httpURLConnection;
    }
}
