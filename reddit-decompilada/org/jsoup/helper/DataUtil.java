package org.jsoup.helper;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;
import org.jsoup.select.Selector;

public final class DataUtil {
    private static final Pattern f26960a = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
    private static final char[] f26961b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    static void m28439a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[60000];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static ByteBuffer m28437a(InputStream inputStream, int i) throws IOException {
        int i2 = 1;
        Validate.m28457a(i >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i <= 0) {
            i2 = 0;
        }
        int i3 = 60000;
        int i4 = (i2 == 0 || i >= 60000) ? 60000 : i;
        byte[] bArr = new byte[i4];
        if (i2 != 0) {
            i3 = i;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (!Thread.interrupted()) {
            i3 = inputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            if (i2 != 0) {
                if (i3 > i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= i3;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    static ByteBuffer m28436a() {
        return ByteBuffer.allocate(0);
    }

    static String m28435a(String str) {
        if (str == null) {
            return null;
        }
        str = f26960a.matcher(str);
        if (str.find()) {
            return m28441b(str.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    private static java.lang.String m28441b(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x002b;
    L_0x0003:
        r1 = r3.length();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x002b;
    L_0x000a:
        r3 = r3.trim();
        r1 = "[\"']";
        r2 = "";
        r3 = r3.replaceAll(r1, r2);
        r1 = java.nio.charset.Charset.isSupported(r3);	 Catch:{ IllegalCharsetNameException -> 0x002a }
        if (r1 == 0) goto L_0x001d;	 Catch:{ IllegalCharsetNameException -> 0x002a }
    L_0x001c:
        return r3;	 Catch:{ IllegalCharsetNameException -> 0x002a }
    L_0x001d:
        r1 = java.util.Locale.ENGLISH;	 Catch:{ IllegalCharsetNameException -> 0x002a }
        r3 = r3.toUpperCase(r1);	 Catch:{ IllegalCharsetNameException -> 0x002a }
        r1 = java.nio.charset.Charset.isSupported(r3);	 Catch:{ IllegalCharsetNameException -> 0x002a }
        if (r1 == 0) goto L_0x002a;
    L_0x0029:
        return r3;
    L_0x002a:
        return r0;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.b(java.lang.String):java.lang.String");
    }

    static String m28440b() {
        StringBuilder stringBuilder = new StringBuilder(32);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            stringBuilder.append(f26961b[random.nextInt(f26961b.length)]);
        }
        return stringBuilder.toString();
    }

    static Document m28438a(ByteBuffer byteBuffer, String str, String str2, Parser parser) {
        String charBuffer;
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        if ((bArr[0] == (byte) 0 && bArr[1] == (byte) 0 && bArr[2] == (byte) -2 && bArr[3] == (byte) -1) || (bArr[0] == (byte) -1 && bArr[1] == (byte) -2 && bArr[2] == (byte) 0 && bArr[3] == (byte) 0)) {
            str = "UTF-32";
        } else if ((bArr[0] == (byte) -2 && bArr[1] == (byte) -1) || (bArr[0] == (byte) -1 && bArr[1] == (byte) -2)) {
            str = "UTF-16";
        } else if (bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) {
            str = "UTF-8";
            byteBuffer.position(3);
        }
        Document document = null;
        if (str == null) {
            String b;
            charBuffer = Charset.forName("UTF-8").decode(byteBuffer).toString();
            Element a = parser.m28566a(charBuffer, str2);
            Element a2 = Selector.m28637a("meta[http-equiv=content-type], meta[charset]", a).m28625a();
            if (a2 != null) {
                String a3 = a2.mo6342c("http-equiv") ? m28435a(a2.mo6341b("content")) : null;
                b = (a3 == null && a2.mo6342c(HttpRequest.PARAM_CHARSET)) ? a2.mo6341b(HttpRequest.PARAM_CHARSET) : a3;
            } else {
                b = null;
            }
            if (b == null && a.m28513o() > 0 && (a.m28512n() instanceof XmlDeclaration)) {
                XmlDeclaration xmlDeclaration = (XmlDeclaration) a.m28512n();
                if (xmlDeclaration.f33340a.equals("xml")) {
                    b = xmlDeclaration.mo6341b("encoding");
                }
            }
            b = m28441b(b);
            if (b == null || b.equals("UTF-8")) {
                document = a;
            } else {
                str = b.trim().replaceAll("[\"']", "");
                byteBuffer.rewind();
                charBuffer = Charset.forName(str).decode(byteBuffer).toString();
            }
        } else {
            Validate.m28455a(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            charBuffer = Charset.forName(str).decode(byteBuffer).toString();
        }
        if (document != null) {
            return document;
        }
        document = parser.m28566a(charBuffer, str2);
        document.f36228a.m28478a(str);
        return document;
    }
}
