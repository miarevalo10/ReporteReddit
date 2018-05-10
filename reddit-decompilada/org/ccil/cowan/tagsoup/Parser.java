package org.ccil.cowan.tagsoup;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {
    private static char[] f33230M = new char[]{'<', '/', '>'};
    private static String f33231O = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
    private static boolean f33232i = true;
    private static boolean f33233j = false;
    private static boolean f33234k = false;
    private static boolean f33235l = true;
    private static boolean f33236m = true;
    private static boolean f33237n = false;
    private static boolean f33238o = true;
    private static boolean f33239p = false;
    private static boolean f33240q = true;
    private HashMap f33241A = new HashMap();
    private Element f33242B;
    private String f33243C;
    private boolean f33244D;
    private String f33245E;
    private String f33246F;
    private String f33247G;
    private String f33248H;
    private Element f33249I;
    private Element f33250J;
    private Element f33251K;
    private int f33252L;
    private boolean f33253N;
    private char[] f33254P;
    private ContentHandler f33255a = this;
    private LexicalHandler f33256b = this;
    private DTDHandler f33257c = this;
    private ErrorHandler f33258d = this;
    private EntityResolver f33259e = this;
    private Schema f33260f;
    private Scanner f33261g;
    private AutoDetector f33262h;
    private boolean f33263r = f33232i;
    private boolean f33264s = f33233j;
    private boolean f33265t = f33234k;
    private boolean f33266u = f33235l;
    private boolean f33267v = f33236m;
    private boolean f33268w = f33237n;
    private boolean f33269x = f33238o;
    private boolean f33270y = f33239p;
    private boolean f33271z = f33240q;

    class C26351 implements AutoDetector {
        private final Parser f33229a;

        C26351(Parser parser) {
            this.f33229a = parser;
        }

        public final Reader mo6175a(InputStream inputStream) {
            return new InputStreamReader(inputStream);
        }
    }

    public void comment(char[] cArr, int i, int i2) throws SAXException {
    }

    public void endCDATA() throws SAXException {
    }

    public void endDTD() throws SAXException {
    }

    public void endEntity(String str) throws SAXException {
    }

    public void startCDATA() throws SAXException {
    }

    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    public void startEntity(String str) throws SAXException {
    }

    public Parser() {
        this.f33241A.put("http://xml.org/sax/features/namespaces", m33826a(f33232i));
        this.f33241A.put("http://xml.org/sax/features/namespace-prefixes", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/external-general-entities", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/external-parameter-entities", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/is-standalone", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/lexical-handler/parameter-entities", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/resolve-dtd-uris", Boolean.TRUE);
        this.f33241A.put("http://xml.org/sax/features/string-interning", Boolean.TRUE);
        this.f33241A.put("http://xml.org/sax/features/use-attributes2", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/use-locator2", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/use-entity-resolver2", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/validation", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
        this.f33241A.put("http://xml.org/sax/features/xml-1.1", Boolean.FALSE);
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons", m33826a(f33233j));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty", m33826a(f33234k));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/root-bogons", m33826a(f33235l));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/default-attributes", m33826a(f33236m));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/translate-colons", m33826a(f33237n));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/restart-elements", m33826a(f33238o));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace", m33826a(f33239p));
        this.f33241A.put("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements", m33826a(f33240q));
        this.f33242B = null;
        this.f33243C = null;
        this.f33244D = false;
        this.f33245E = null;
        this.f33246F = null;
        this.f33247G = null;
        this.f33248H = null;
        this.f33249I = null;
        this.f33250J = null;
        this.f33251K = null;
        this.f33252L = 0;
        this.f33253N = true;
        this.f33254P = new char[CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE];
    }

    private static Boolean m33826a(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean bool = (Boolean) this.f33241A.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (((Boolean) this.f33241A.get(str)) == null) {
            StringBuffer stringBuffer = new StringBuffer("Unknown feature ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
        if (z) {
            this.f33241A.put(str, Boolean.TRUE);
        } else {
            this.f33241A.put(str, Boolean.FALSE);
        }
        if (str.equals("http://xml.org/sax/features/namespaces")) {
            this.f33263r = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons")) {
            this.f33264s = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty")) {
            this.f33265t = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/root-bogons")) {
            this.f33266u = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/default-attributes")) {
            this.f33267v = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/translate-colons")) {
            this.f33268w = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/restart-elements")) {
            this.f33269x = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace")) {
            this.f33270y = z;
        } else {
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements") != null) {
                this.f33271z = z;
            }
        }
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            return this.f33256b == this ? null : this.f33256b;
        } else {
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
                return this.f33261g;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
                return this.f33260f;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
                return this.f33262h;
            }
            StringBuffer stringBuffer = new StringBuffer("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            if (obj == null) {
                this.f33256b = this;
            } else if ((obj instanceof LexicalHandler) != null) {
                this.f33256b = (LexicalHandler) obj;
            } else {
                throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
            }
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            if ((obj instanceof Scanner) != null) {
                this.f33261g = (Scanner) obj;
                return;
            }
            throw new SAXNotSupportedException("Your scanner is not a Scanner");
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
            if ((obj instanceof Schema) != null) {
                this.f33260f = (Schema) obj;
                return;
            }
            throw new SAXNotSupportedException("Your schema is not a Schema");
        } else if (!str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
            StringBuffer stringBuffer = new StringBuffer("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        } else if ((obj instanceof AutoDetector) != null) {
            this.f33262h = (AutoDetector) obj;
        } else {
            throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
        }
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            entityResolver = this;
        }
        this.f33259e = entityResolver;
    }

    public EntityResolver getEntityResolver() {
        return this.f33259e == this ? null : this.f33259e;
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            dTDHandler = this;
        }
        this.f33257c = dTDHandler;
    }

    public DTDHandler getDTDHandler() {
        return this.f33257c == this ? null : this.f33257c;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            contentHandler = this;
        }
        this.f33255a = contentHandler;
    }

    public ContentHandler getContentHandler() {
        return this.f33255a == this ? null : this.f33255a;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            errorHandler = this;
        }
        this.f33258d = errorHandler;
    }

    public ErrorHandler getErrorHandler() {
        return this.f33258d == this ? null : this.f33258d;
    }

    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    private java.io.Reader m33825a(org.xml.sax.InputSource r7) throws org.xml.sax.SAXException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = r7.getCharacterStream();
        r1 = r7.getByteStream();
        r2 = r7.getEncoding();
        r7.getPublicId();
        r7 = r7.getSystemId();
        if (r0 != 0) goto L_0x0059;
    L_0x0015:
        if (r1 != 0) goto L_0x0045;
    L_0x0017:
        r0 = new java.net.URL;
        r1 = "file";
        r3 = "";
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r5 = "user.dir";
        r5 = java.lang.System.getProperty(r5);
        r4.append(r5);
        r5 = "/.";
        r4.append(r5);
        r4 = r4.toString();
        r0.<init>(r1, r3, r4);
        r1 = new java.net.URL;
        r1.<init>(r0, r7);
        r7 = r1.openConnection();
        r1 = r7.getInputStream();
    L_0x0045:
        if (r2 != 0) goto L_0x004e;
    L_0x0047:
        r7 = r6.f33262h;
        r0 = r7.mo6175a(r1);
        goto L_0x0059;
    L_0x004e:
        r0 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x0054 }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0054 }
        goto L_0x0059;
    L_0x0054:
        r0 = new java.io.InputStreamReader;
        r0.<init>(r1);
    L_0x0059:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.a(org.xml.sax.InputSource):java.io.Reader");
    }

    public final void mo6176a() throws SAXException {
        if (this.f33242B != null) {
            if (this.f33243C != null) {
                this.f33242B.m28342a(this.f33243C, this.f33243C);
                this.f33243C = null;
            }
        }
    }

    public final void mo6177a(char[] cArr, int i) throws SAXException {
        if (this.f33242B != null) {
            this.f33243C = m33831b(cArr, 0, i).toLowerCase();
        }
    }

    public final void mo6179b(char[] cArr, int i) throws SAXException {
        if (this.f33242B != null) {
            if (this.f33243C != null) {
                this.f33242B.m28342a(this.f33243C, m33827a(new String(cArr, 0, i)));
                this.f33243C = null;
            }
        }
    }

    private String m33827a(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = i;
        int i3 = -1;
        while (i < length) {
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i2 = i4;
                i3 = i2;
            } else {
                if (!(i3 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#')) {
                    if (charAt == ';') {
                        i2 = m33824a(cArr, i3, (i4 - i3) - 1);
                        if (i2 > 65535) {
                            i2 -= 65536;
                            cArr[i3 - 1] = (char) ((i2 >> 10) + 55296);
                            cArr[i3] = (char) ((i2 & 1023) + 56320);
                            i3++;
                        } else if (i2 != 0) {
                            cArr[i3 - 1] = (char) i2;
                        } else {
                            i3 = i4;
                        }
                        i2 = i3;
                        i3 = -1;
                    } else {
                        i3 = -1;
                    }
                }
                i2 = i4;
            }
            i++;
        }
        return new String(cArr, 0, i2);
    }

    public final void mo6181c(char[] cArr, int i) throws SAXException {
        this.f33252L = m33824a(cArr, 1, i);
    }

    private int m33824a(char[] r6, int r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        if (r8 > 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6[r7];
        r2 = 35;
        if (r1 != r2) goto L_0x003b;
    L_0x000a:
        r1 = 1;
        if (r8 <= r1) goto L_0x002c;
    L_0x000d:
        r2 = r7 + 1;
        r3 = r6[r2];
        r4 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r3 == r4) goto L_0x001b;
    L_0x0015:
        r2 = r6[r2];
        r3 = 88;
        if (r2 != r3) goto L_0x002c;
    L_0x001b:
        r1 = new java.lang.String;	 Catch:{ NumberFormatException -> 0x002b }
        r7 = r7 + 2;	 Catch:{ NumberFormatException -> 0x002b }
        r8 = r8 + -2;	 Catch:{ NumberFormatException -> 0x002b }
        r1.<init>(r6, r7, r8);	 Catch:{ NumberFormatException -> 0x002b }
        r6 = 16;	 Catch:{ NumberFormatException -> 0x002b }
        r6 = java.lang.Integer.parseInt(r1, r6);	 Catch:{ NumberFormatException -> 0x002b }
        return r6;
    L_0x002b:
        return r0;
    L_0x002c:
        r2 = new java.lang.String;	 Catch:{ NumberFormatException -> 0x003a }
        r7 = r7 + r1;	 Catch:{ NumberFormatException -> 0x003a }
        r8 = r8 - r1;	 Catch:{ NumberFormatException -> 0x003a }
        r2.<init>(r6, r7, r8);	 Catch:{ NumberFormatException -> 0x003a }
        r6 = 10;	 Catch:{ NumberFormatException -> 0x003a }
        r6 = java.lang.Integer.parseInt(r2, r6);	 Catch:{ NumberFormatException -> 0x003a }
        return r6;
    L_0x003a:
        return r0;
    L_0x003b:
        r1 = r5.f33260f;
        r2 = new java.lang.String;
        r2.<init>(r6, r7, r8);
        r6 = r1.f26743a;
        r6 = r6.get(r2);
        r6 = (java.lang.Integer) r6;
        if (r6 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r6 = r6.intValue();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.a(char[], int, int):int");
    }

    public final void mo6178b() throws SAXException {
        if (this.f33253N) {
            m33834c(this.f33251K);
        }
        while (this.f33249I.f26732c != null) {
            m33835d();
        }
        if (!this.f33260f.f26744b.equals("")) {
            this.f33255a.endPrefixMapping(this.f33260f.f26745c);
        }
        this.f33255a.endDocument();
    }

    private void m33839m(char[] r5, int r6) throws org.xml.sax.SAXException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = 0;
        r4.f33242B = r0;
        r1 = 0;
        if (r6 == 0) goto L_0x0016;
    L_0x0006:
        r5 = r4.m33831b(r5, r1, r6);
        r6 = r4.f33260f;
        r5 = r6.m28367a(r5);
        if (r5 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r5 = r5.f26734a;
        goto L_0x001c;
    L_0x0016:
        r5 = r4.f33249I;
        r5 = r5.f26730a;
        r5 = r5.f26734a;
    L_0x001c:
        r6 = r4.f33249I;
    L_0x001e:
        r2 = 1;
        if (r6 == 0) goto L_0x0037;
    L_0x0021:
        r3 = r6.f26730a;
        r3 = r3.f26734a;
        r3 = r3.equals(r5);
        if (r3 != 0) goto L_0x0037;
    L_0x002b:
        r3 = r6.f26730a;
        r3 = r3.f26739f;
        r3 = r3 & 4;
        if (r3 == 0) goto L_0x0034;
    L_0x0033:
        r1 = r2;
    L_0x0034:
        r6 = r6.f26732c;
        goto L_0x001e;
    L_0x0037:
        if (r6 != 0) goto L_0x003a;
    L_0x0039:
        return;
    L_0x003a:
        r5 = r6.f26732c;
        if (r5 == 0) goto L_0x0061;
    L_0x003e:
        r5 = r6.f26732c;
        r5 = r5.f26732c;
        if (r5 != 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0061;
    L_0x0045:
        if (r1 == 0) goto L_0x004b;
    L_0x0047:
        r6.f26733d = r2;
        r5 = r4;
        goto L_0x0057;
    L_0x004b:
        r5 = r4.f33249I;
        if (r5 == r6) goto L_0x0053;
    L_0x004f:
        r4.m33838e();
        goto L_0x004b;
    L_0x0053:
        r5 = r4;
    L_0x0054:
        r5.m33835d();
    L_0x0057:
        r6 = r5.f33249I;
        r6 = r6.f26733d;
        if (r6 != 0) goto L_0x0054;
    L_0x005d:
        r5.m33828a(r0);
        return;
    L_0x0061:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.m(char[], int):void");
    }

    private void m33828a(Element element) throws SAXException {
        while (this.f33250J != null && this.f33249I.m28343a(this.f33250J)) {
            if (element == null || this.f33250J.m28343a(element)) {
                Element element2 = this.f33250J.f26732c;
                m33832b(this.f33250J);
                this.f33250J = element2;
            } else {
                return;
            }
        }
    }

    private void m33835d() throws SAXException {
        if (this.f33249I != null) {
            String str = this.f33249I.f26730a.f26734a;
            String str2 = this.f33249I.f26730a.f26736c;
            String str3 = this.f33249I.f26730a.f26735b;
            String b = m33830b(str);
            if (this.f33263r) {
                String str4 = str3;
                str3 = str2;
                str2 = str4;
            } else {
                str2 = "";
                str3 = str2;
            }
            this.f33255a.endElement(str2, str3, str);
            if (m33829a(b, str2)) {
                this.f33255a.endPrefixMapping(b);
            }
            Attributes attributes = this.f33249I.f26731b;
            for (int length = attributes.getLength() - 1; length >= 0; length--) {
                str3 = attributes.getURI(length);
                b = m33830b(attributes.getQName(length));
                if (m33829a(b, str3)) {
                    this.f33255a.endPrefixMapping(b);
                }
            }
            this.f33249I = this.f33249I.f26732c;
        }
    }

    private void m33838e() throws SAXException {
        Element element = this.f33249I;
        m33835d();
        if (this.f33269x && (element.f26730a.f26739f & 1) != 0) {
            int length = element.f26731b.getLength() - 1;
            while (length >= 0) {
                if (element.f26731b.getType(length).equals("ID") || element.f26731b.getQName(length).equals("name")) {
                    element.f26731b.m28340a(length);
                }
                length--;
            }
            element.f26732c = this.f33250J;
            this.f33250J = element;
        }
    }

    private static String m33830b(String str) {
        int indexOf = str.indexOf(58);
        return indexOf != -1 ? str.substring(0, indexOf) : "";
    }

    private boolean m33829a(String str, String str2) {
        return (str.equals("") == null && str2.equals("") == null && str2.equals(this.f33260f.f26744b) == null) ? true : null;
    }

    public final void mo6183e(char[] r6, int r7) throws org.xml.sax.SAXException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = new java.lang.String;
        r1 = 0;
        r0.<init>(r6, r1, r7);
        r6 = m33836d(r0);
        r7 = 0;
        r0 = r6.length;
        if (r0 <= 0) goto L_0x0052;
    L_0x000e:
        r0 = "DOCTYPE";
        r1 = r6[r1];
        r0 = r0.equalsIgnoreCase(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0018:
        r0 = r5.f33244D;
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        return;
    L_0x001d:
        r0 = 1;
        r5.f33244D = r0;
        r1 = r6.length;
        if (r1 <= r0) goto L_0x0052;
    L_0x0023:
        r0 = r6[r0];
        r1 = 2;
        r2 = 3;
        r3 = r6.length;
        if (r3 <= r2) goto L_0x0037;
    L_0x002a:
        r3 = "SYSTEM";
        r4 = r6[r1];
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0037;
    L_0x0034:
        r6 = r6[r2];
        goto L_0x0054;
    L_0x0037:
        r3 = r6.length;
        if (r3 <= r2) goto L_0x0050;
    L_0x003a:
        r3 = "PUBLIC";
        r1 = r6[r1];
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0050;
    L_0x0044:
        r7 = r6[r2];
        r1 = 4;
        r2 = r6.length;
        if (r2 <= r1) goto L_0x004d;
    L_0x004a:
        r6 = r6[r1];
        goto L_0x0054;
    L_0x004d:
        r6 = "";
        goto L_0x0054;
    L_0x0050:
        r6 = r7;
        goto L_0x0054;
    L_0x0052:
        r6 = r7;
        r0 = r6;
    L_0x0054:
        r7 = m33833c(r7);
        r6 = m33833c(r6);
        if (r0 == 0) goto L_0x0093;
    L_0x005e:
        r7 = m33837e(r7);
        r1 = r5.f33256b;
        r1.startDTD(r0, r7, r6);
        r1 = r5.f33256b;
        r1.endDTD();
        r5.f33247G = r0;
        r5.f33245E = r7;
        r7 = r5.f33261g;
        r7 = r7 instanceof org.xml.sax.Locator;
        if (r7 == 0) goto L_0x0093;
    L_0x0076:
        r7 = r5.f33261g;
        r7 = (org.xml.sax.Locator) r7;
        r7 = r7.getSystemId();
        r5.f33246F = r7;
        r7 = new java.net.URL;	 Catch:{ Exception -> 0x0093 }
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0093 }
        r1 = r5.f33246F;	 Catch:{ Exception -> 0x0093 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0093 }
        r7.<init>(r0, r6);	 Catch:{ Exception -> 0x0093 }
        r6 = r7.toString();	 Catch:{ Exception -> 0x0093 }
        r5.f33246F = r6;	 Catch:{ Exception -> 0x0093 }
        return;
    L_0x0093:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.e(char[], int):void");
    }

    private static String m33833c(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (charAt == str.charAt(length - 1) && (charAt == '\'' || charAt == '\"')) {
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }

    private static String[] m33836d(String str) throws IllegalArgumentException {
        str = str.trim();
        if (str.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        while (i < length) {
            char charAt = str.charAt(i);
            if (i2 == 0 && charAt == '\'' && r6 != 92) {
                i4 = i5 ^ 1;
                if (i3 < 0) {
                    i3 = i;
                }
                i5 = i4;
            } else {
                if (i5 == 0 && charAt == '\"' && r6 != 92) {
                    i2 ^= 1;
                    if (i3 >= 0) {
                    }
                } else if (i5 == 0 && i2 == 0) {
                    if (Character.isWhitespace(charAt)) {
                        if (i3 >= 0) {
                            arrayList.add(str.substring(i3, i));
                        }
                        i3 = -1;
                    } else if (i3 < 0 && charAt != ' ') {
                    }
                }
                i3 = i;
            }
            i++;
            char c = charAt;
        }
        arrayList.add(str.substring(i3, i));
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String m33837e(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (f33231O.indexOf(charAt) != -1) {
                stringBuffer.append(charAt);
                obj = null;
            } else if (obj == null) {
                stringBuffer.append(' ');
                obj = 1;
            }
        }
        return stringBuffer.toString().trim();
    }

    public final void mo6184f(char[] cArr, int i) throws SAXException {
        if (this.f33242B == null) {
            String b = m33831b(cArr, 0, i);
            if (b != null) {
                i = this.f33260f.m28367a(b);
                if (i == 0) {
                    if (this.f33264s == 0) {
                        int i2 = -1;
                        i = this.f33265t != 0 ? 0 : -1;
                        if (!this.f33266u) {
                            i2 = RedditJobManager.f10810d;
                        }
                        this.f33260f.m28369a(b, i, i2, 0);
                        if (this.f33266u == 0) {
                            this.f33260f.m28370a(b, this.f33260f.f26746d.f26734a);
                        }
                        i = this.f33260f.m28367a(b);
                    } else {
                        return;
                    }
                }
                this.f33242B = new Element(i, this.f33267v);
            }
        }
    }

    public final void mo6185g(char[] cArr, int i) throws SAXException {
        if (i != 0) {
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                if (!Character.isWhitespace(cArr[0 + i3])) {
                    i2 = 0;
                }
            }
            if (i2 == 0 || this.f33249I.m28343a(this.f33251K)) {
                m33834c(this.f33251K);
                this.f33255a.characters(cArr, 0, i);
            } else if (this.f33270y) {
                this.f33255a.ignorableWhitespace(cArr, 0, i);
            }
        }
    }

    public final void mo6186h(char[] cArr, int i) throws SAXException {
        if (this.f33242B == null) {
            this.f33248H = m33831b(cArr, 0, i).replace(58, '_');
        }
    }

    public final void mo6187i(char[] cArr, int i) throws SAXException {
        if (this.f33242B == null) {
            if (this.f33248H != null) {
                if (!"xml".equalsIgnoreCase(this.f33248H)) {
                    if (i > 0 && cArr[i - 1] == '?') {
                        i--;
                    }
                    this.f33255a.processingInstruction(this.f33248H, new String(cArr, 0, i));
                    this.f33248H = null;
                }
            }
        }
    }

    public final void mo6188j(char[] cArr, int i) throws SAXException {
        if (this.f33242B != null) {
            m33834c(this.f33242B);
            if (this.f33249I.f26730a.f26737d == 0) {
                m33839m(cArr, i);
            }
        }
    }

    public final void mo6189k(char[] cArr, int i) throws SAXException {
        if (this.f33242B != null) {
            m33834c(this.f33242B);
            m33839m(cArr, i);
        }
    }

    public final void mo6190l(char[] cArr, int i) throws SAXException {
        this.f33256b.comment(cArr, 0, i);
    }

    private void m33834c(Element element) throws SAXException {
        while (true) {
            Element element2 = this.f33249I;
            while (element2 != null && !element2.m28343a(element)) {
                element2 = element2.f26732c;
            }
            if (element2 != null) {
                break;
            }
            ElementType elementType = element.f26730a.f26741h;
            if (elementType == null) {
                break;
            }
            element2 = new Element(elementType, this.f33267v);
            element2.f26732c = element;
            element = element2;
        }
        if (element2 != null) {
            while (this.f33249I != element2 && this.f33249I != null && this.f33249I.f26732c != null && this.f33249I.f26732c.f26732c != null) {
                m33838e();
            }
            while (element != null) {
                element2 = element.f26732c;
                if (!element.f26730a.f26734a.equals("<pcdata>")) {
                    m33832b(element);
                }
                m33828a(element2);
                element = element2;
            }
            this.f33242B = null;
        }
    }

    public final int mo6180c() {
        return this.f33252L;
    }

    private String m33831b(char[] cArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 + 2);
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i2 = cArr[i];
            if (!Character.isLetter(i2)) {
                if (i2 != 95) {
                    if (!(Character.isDigit(i2) || i2 == 45)) {
                        if (i2 != 46) {
                            if (i2 == 58 && r4 == 0) {
                                if (i4 != 0) {
                                    stringBuffer.append('_');
                                }
                                if (this.f33268w) {
                                    i2 = 95;
                                }
                                stringBuffer.append(i2);
                                i4 = 1;
                                i3 = i4;
                            }
                            i++;
                            i2 = i5;
                        }
                    }
                    if (i4 != 0) {
                        stringBuffer.append('_');
                    }
                    stringBuffer.append(i2);
                    i4 = 0;
                    i++;
                    i2 = i5;
                }
            }
            stringBuffer.append(i2);
            i4 = 0;
            i++;
            i2 = i5;
        }
        cArr = stringBuffer.length();
        if (cArr == null || stringBuffer.charAt(cArr - 1) == 58) {
            stringBuffer.append('_');
        }
        return stringBuffer.toString().intern();
    }

    public void parse(InputSource inputSource) throws IOException, SAXException {
        if (this.f33260f == null) {
            this.f33260f = new HTMLSchema();
        }
        if (this.f33261g == null) {
            this.f33261g = new HTMLScanner();
        }
        if (this.f33262h == null) {
            this.f33262h = new C26351(this);
        }
        this.f33249I = new Element(this.f33260f.m28367a("<root>"), this.f33267v);
        this.f33251K = new Element(this.f33260f.m28367a("<pcdata>"), this.f33267v);
        this.f33242B = null;
        this.f33243C = null;
        this.f33248H = null;
        this.f33250J = null;
        this.f33252L = 0;
        this.f33253N = true;
        this.f33246F = null;
        this.f33245E = null;
        this.f33247G = null;
        Reader a = m33825a(inputSource);
        this.f33255a.startDocument();
        this.f33261g.mo6174a(inputSource.getPublicId(), inputSource.getSystemId());
        if ((this.f33261g instanceof Locator) != null) {
            this.f33255a.setDocumentLocator((Locator) this.f33261g);
        }
        if (this.f33260f.f26744b.equals("") == null) {
            this.f33255a.startPrefixMapping(this.f33260f.f26745c, this.f33260f.f26744b);
        }
        this.f33261g.mo6173a(a, (ScanHandler) this);
    }

    public final void mo6182d(char[] cArr, int i) throws SAXException {
        String str = this.f33249I.f26730a.f26734a;
        int i2 = 1;
        if (this.f33271z && (this.f33249I.f26730a.f26739f & 2) != 0) {
            int i3 = i == str.length() ? 1 : 0;
            if (i3 != 0) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (Character.toLowerCase(cArr[0 + i4]) != Character.toLowerCase(str.charAt(i4))) {
                        i3 = 0;
                        break;
                    }
                }
            }
            if (i3 == 0) {
                this.f33255a.characters(f33230M, 0, 2);
                this.f33255a.characters(cArr, 0, i);
                this.f33255a.characters(f33230M, 2, 1);
                this.f33261g.mo6172a();
                if (i2 != 0) {
                    m33839m(cArr, i);
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            m33839m(cArr, i);
        }
    }

    private void m33832b(org.ccil.cowan.tagsoup.Element r11) throws org.xml.sax.SAXException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r0 = r11.f26730a;
        r0 = r0.f26734a;
        r1 = r11.f26730a;
        r1 = r1.f26736c;
        r2 = r11.f26730a;
        r2 = r2.f26735b;
        r3 = m33830b(r0);
        r4 = r11.f26731b;
        r4 = r4.getLength();
        r4 = r4 + -1;
    L_0x0018:
        if (r4 < 0) goto L_0x0038;
    L_0x001a:
        r5 = r11.f26731b;
        r5 = r5.getLocalName(r4);
        r6 = r11.f26731b;
        r6 = r6.getValue(r4);
        if (r6 == 0) goto L_0x0030;
    L_0x0028:
        if (r5 == 0) goto L_0x0030;
    L_0x002a:
        r5 = r5.length();
        if (r5 != 0) goto L_0x0035;
    L_0x0030:
        r5 = r11.f26731b;
        r5.m28340a(r4);
    L_0x0035:
        r4 = r4 + -1;
        goto L_0x0018;
    L_0x0038:
        r4 = r10.f33263r;
        if (r4 != 0) goto L_0x003f;
    L_0x003c:
        r1 = "";
        r2 = r1;
    L_0x003f:
        r4 = r10.f33253N;
        if (r4 == 0) goto L_0x0054;
    L_0x0043:
        r4 = r10.f33247G;
        r4 = r1.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0054;
    L_0x004b:
        r4 = r10.f33259e;	 Catch:{ IOException -> 0x0054 }
        r5 = r10.f33245E;	 Catch:{ IOException -> 0x0054 }
        r6 = r10.f33246F;	 Catch:{ IOException -> 0x0054 }
        r4.resolveEntity(r5, r6);	 Catch:{ IOException -> 0x0054 }
    L_0x0054:
        r4 = r10.m33829a(r3, r2);
        if (r4 == 0) goto L_0x005f;
    L_0x005a:
        r4 = r10.f33255a;
        r4.startPrefixMapping(r3, r2);
    L_0x005f:
        r3 = r11.f26731b;
        r4 = r3.getLength();
        r5 = 0;
        r6 = r5;
    L_0x0067:
        if (r6 >= r4) goto L_0x0083;
    L_0x0069:
        r7 = r3.getURI(r6);
        r8 = r3.getQName(r6);
        r8 = m33830b(r8);
        r9 = r10.m33829a(r8, r7);
        if (r9 == 0) goto L_0x0080;
    L_0x007b:
        r9 = r10.f33255a;
        r9.startPrefixMapping(r8, r7);
    L_0x0080:
        r6 = r6 + 1;
        goto L_0x0067;
    L_0x0083:
        r3 = r10.f33255a;
        r4 = r11.f26731b;
        r3.startElement(r2, r1, r0, r4);
        r0 = r10.f33249I;
        r11.f26732c = r0;
        r10.f33249I = r11;
        r10.f33253N = r5;
        r11 = r10.f33271z;
        if (r11 == 0) goto L_0x00a5;
    L_0x0096:
        r11 = r10.f33249I;
        r11 = r11.f26730a;
        r11 = r11.f26739f;
        r11 = r11 & 2;
        if (r11 == 0) goto L_0x00a5;
    L_0x00a0:
        r11 = r10.f33261g;
        r11.mo6172a();
    L_0x00a5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.b(org.ccil.cowan.tagsoup.Element):void");
    }
}
