package com.instabug.library.network;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

/* compiled from: Multipart */
class C0747b {
    final String f9845a;
    PrintWriter f9846b = new PrintWriter(new OutputStreamWriter(this.f9847c, "UTF-8"), true);
    private OutputStream f9847c;

    public C0747b(HttpURLConnection httpURLConnection) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("===");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("===");
        this.f9845a = stringBuilder.toString();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setChunkedStreamingMode(1048576);
        StringBuilder stringBuilder2 = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder2.append(this.f9845a);
        httpURLConnection.setRequestProperty("Content-Type", stringBuilder2.toString());
        this.f9847c = httpURLConnection.getOutputStream();
    }

    @SuppressFBWarnings({"OBL_UNSATISFIED_OBLIGATION_EXCEPTION_EDGE"})
    public final void m8310a(String str, File file, String str2, String str3) throws IOException {
        this.f9846b.append("--").append(this.f9845a).append("\r\n");
        this.f9846b.append("Content-Disposition: file; name=\"").append(str).append("\"; filename=\"").append(str2).append("\"").append("\r\n");
        this.f9846b.append("Content-Type: ").append(str3).append("\r\n");
        this.f9846b.append("\r\n");
        this.f9846b.flush();
        str = new FileInputStream(file);
        file = new byte[1048576];
        while (true) {
            str2 = str.read(file);
            if (str2 != -1) {
                this.f9847c.write(file, 0, str2);
            } else {
                this.f9847c.flush();
                str.close();
                this.f9846b.append("\r\n");
                this.f9846b.flush();
                return;
            }
        }
    }
}
