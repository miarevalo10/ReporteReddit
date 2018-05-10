package com.airbnb.deeplinkdispatch;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okio.Buffer;
import org.jcodec.containers.mps.MPSUtils;

public final class DeepLinkUri {
    static final String CONVERT_TO_URI_ENCODE_SET = "^`{}|\\";
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    static final class Builder {
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments = new ArrayList();
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        Builder() {
            this.encodedPathSegments.add("");
        }

        final Builder scheme(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            this.scheme = str;
            return this;
        }

        final Builder username(String str) {
            if (str == null) {
                throw new IllegalArgumentException("username == null");
            }
            this.encodedUsername = DeepLinkUri.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false);
            return this;
        }

        final Builder encodedUsername(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedUsername == null");
            }
            this.encodedUsername = DeepLinkUri.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false);
            return this;
        }

        final Builder password(String str) {
            if (str == null) {
                throw new IllegalArgumentException("password == null");
            }
            this.encodedPassword = DeepLinkUri.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false);
            return this;
        }

        final Builder encodedPassword(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPassword == null");
            }
            this.encodedPassword = DeepLinkUri.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false);
            return this;
        }

        final Builder host(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String canonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (canonicalizeHost == null) {
                StringBuilder stringBuilder = new StringBuilder("unexpected host: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.host = canonicalizeHost;
            return this;
        }

        final Builder port(int i) {
            if (i > 0) {
                if (i <= 65535) {
                    this.port = i;
                    return this;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("unexpected port: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        final int effectivePort() {
            return this.port != -1 ? this.port : DeepLinkUri.defaultPort(this.scheme);
        }

        final Builder addPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        final Builder addEncodedPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        final Builder setPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            String canonicalize = DeepLinkUri.canonicalize(str, 0, str.length(), DeepLinkUri.PATH_SEGMENT_ENCODE_SET, false, false);
            if (!isDot(canonicalize)) {
                if (!isDotDot(canonicalize)) {
                    this.encodedPathSegments.set(i, canonicalize);
                    return this;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("unexpected path segment: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        final Builder setEncodedPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            String canonicalize = DeepLinkUri.canonicalize(str, 0, str.length(), DeepLinkUri.PATH_SEGMENT_ENCODE_SET, true, false);
            this.encodedPathSegments.set(i, canonicalize);
            if (isDot(canonicalize) == 0) {
                if (isDotDot(canonicalize) == 0) {
                    return this;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("unexpected path segment: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty() != 0) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        final Builder encodedPath(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPath == null");
            } else if (str.startsWith(Operation.DIVISION)) {
                resolvePath(str, 0, str.length());
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder("unexpected encodedPath: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        final Builder query(String str) {
            this.encodedQueryNamesAndValues = str != null ? DeepLinkUri.queryStringToNamesAndValues(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_ENCODE_SET, false, true)) : null;
            return this;
        }

        final Builder encodedQuery(String str) {
            this.encodedQueryNamesAndValues = str != null ? DeepLinkUri.queryStringToNamesAndValues(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_ENCODE_SET, true, true)) : null;
            return this;
        }

        final Builder addQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, false, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? DeepLinkUri.canonicalize(str2, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, false, true) : null);
            return this;
        }

        final Builder addEncodedQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? DeepLinkUri.canonicalize(str2, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, true, true) : null);
            return this;
        }

        final Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        final Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        final Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, false, true));
                return this;
            }
        }

        final Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(DeepLinkUri.canonicalize(str, DeepLinkUri.QUERY_COMPONENT_ENCODE_SET, true, true));
                return this;
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        final Builder fragment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("fragment == null");
            }
            this.encodedFragment = DeepLinkUri.canonicalize(str, "", false, false);
            return this;
        }

        final Builder encodedFragment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedFragment == null");
            }
            this.encodedFragment = DeepLinkUri.canonicalize(str, "", true, false);
            return this;
        }

        final DeepLinkUri build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new DeepLinkUri();
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.scheme);
            stringBuilder.append("://");
            if (!(this.encodedUsername.isEmpty() && this.encodedPassword.isEmpty())) {
                stringBuilder.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.encodedPassword);
                }
                stringBuilder.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.host);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != DeepLinkUri.defaultPort(this.scheme)) {
                stringBuilder.append(':');
                stringBuilder.append(effectivePort);
            }
            DeepLinkUri.pathSegmentsToString(stringBuilder, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                stringBuilder.append('?');
                DeepLinkUri.namesAndValuesToQueryString(stringBuilder, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.encodedFragment);
            }
            return stringBuilder.toString();
        }

        final ParseResult parse(DeepLinkUri deepLinkUri, String str) {
            int access$200;
            String str2 = str;
            int i = 0;
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str2, 0, str.length());
            int skipTrailingAsciiWhitespace = skipTrailingAsciiWhitespace(str2, skipLeadingAsciiWhitespace, str.length());
            int schemeDelimiterOffset = schemeDelimiterOffset(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (schemeDelimiterOffset != -1) {
                if (str2.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    r0.scheme = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else {
                    if (str2.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        r0.scheme = "http";
                        skipLeadingAsciiWhitespace += 5;
                    } else {
                        r0.scheme = str2.substring(skipLeadingAsciiWhitespace, schemeDelimiterOffset);
                        skipLeadingAsciiWhitespace += r0.scheme.length() + 1;
                    }
                }
            } else if (deepLinkUri == null) {
                return ParseResult.MISSING_SCHEME;
            } else {
                r0.scheme = deepLinkUri.scheme;
            }
            int slashCount = slashCount(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (slashCount < 2 && deepLinkUri != null) {
                if (deepLinkUri.scheme.equals(r0.scheme)) {
                    r0.encodedUsername = deepLinkUri.encodedUsername();
                    r0.encodedPassword = deepLinkUri.encodedPassword();
                    r0.host = deepLinkUri.host;
                    r0.port = deepLinkUri.port;
                    r0.encodedPathSegments.clear();
                    r0.encodedPathSegments.addAll(deepLinkUri.encodedPathSegments());
                    if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str2.charAt(skipLeadingAsciiWhitespace) == '#') {
                        encodedQuery(deepLinkUri.encodedQuery());
                    }
                    schemeDelimiterOffset = skipLeadingAsciiWhitespace;
                    access$200 = DeepLinkUri.delimiterOffset(str2, schemeDelimiterOffset, skipTrailingAsciiWhitespace, "?#");
                    resolvePath(str2, schemeDelimiterOffset, access$200);
                    if (access$200 < skipTrailingAsciiWhitespace && str2.charAt(access$200) == '?') {
                        i = DeepLinkUri.delimiterOffset(str2, access$200, skipTrailingAsciiWhitespace, "#");
                        r0.encodedQueryNamesAndValues = DeepLinkUri.queryStringToNamesAndValues(DeepLinkUri.canonicalize(str2, access$200 + 1, i, DeepLinkUri.QUERY_ENCODE_SET, true, true));
                        access$200 = i;
                    }
                    if (access$200 < skipTrailingAsciiWhitespace && str2.charAt(access$200) == '#') {
                        r0.encodedFragment = DeepLinkUri.canonicalize(str2, access$200 + 1, skipTrailingAsciiWhitespace, "", true, false);
                    }
                    return ParseResult.SUCCESS;
                }
            }
            slashCount = skipLeadingAsciiWhitespace + slashCount;
            skipLeadingAsciiWhitespace = 0;
            while (true) {
                schemeDelimiterOffset = DeepLinkUri.delimiterOffset(str2, slashCount, skipTrailingAsciiWhitespace, "@/\\?#");
                char charAt = schemeDelimiterOffset != skipTrailingAsciiWhitespace ? str2.charAt(schemeDelimiterOffset) : '￿';
                if (!(charAt == '￿' || charAt == '#' || charAt == '/' || charAt == '\\')) {
                    switch (charAt) {
                        case '?':
                            break;
                        case '@':
                            if (i == 0) {
                                int access$2002 = DeepLinkUri.delimiterOffset(str2, slashCount, schemeDelimiterOffset, ":");
                                String canonicalize = DeepLinkUri.canonicalize(str2, slashCount, access$2002, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (skipLeadingAsciiWhitespace != 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(r0.encodedUsername);
                                    stringBuilder.append("%40");
                                    stringBuilder.append(canonicalize);
                                    canonicalize = stringBuilder.toString();
                                }
                                r0.encodedUsername = canonicalize;
                                if (access$2002 != schemeDelimiterOffset) {
                                    r0.encodedPassword = DeepLinkUri.canonicalize(str2, access$2002 + 1, schemeDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                    i = 1;
                                }
                                skipLeadingAsciiWhitespace = 1;
                            } else {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(r0.encodedPassword);
                                stringBuilder2.append("%40");
                                stringBuilder2.append(DeepLinkUri.canonicalize(str2, slashCount, schemeDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false));
                                r0.encodedPassword = stringBuilder2.toString();
                            }
                            slashCount = schemeDelimiterOffset + 1;
                            continue;
                        default:
                            continue;
                    }
                }
                access$200 = portColonOffset(str2, slashCount, schemeDelimiterOffset);
                int i2 = access$200 + 1;
                if (i2 < schemeDelimiterOffset) {
                    r0.host = canonicalizeHost(str2, slashCount, access$200);
                    r0.port = parsePort(str2, i2, schemeDelimiterOffset);
                    if (r0.port == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                }
                r0.host = canonicalizeHost(str2, slashCount, access$200);
                r0.port = DeepLinkUri.defaultPort(r0.scheme);
                if (r0.host == null) {
                    return ParseResult.INVALID_HOST;
                }
                access$200 = DeepLinkUri.delimiterOffset(str2, schemeDelimiterOffset, skipTrailingAsciiWhitespace, "?#");
                resolvePath(str2, schemeDelimiterOffset, access$200);
                i = DeepLinkUri.delimiterOffset(str2, access$200, skipTrailingAsciiWhitespace, "#");
                r0.encodedQueryNamesAndValues = DeepLinkUri.queryStringToNamesAndValues(DeepLinkUri.canonicalize(str2, access$200 + 1, i, DeepLinkUri.QUERY_ENCODE_SET, true, true));
                access$200 = i;
                r0.encodedFragment = DeepLinkUri.canonicalize(str2, access$200 + 1, skipTrailingAsciiWhitespace, "", true, false);
                return ParseResult.SUCCESS;
            }
        }

        private void resolvePath(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                boolean z;
                char charAt = str.charAt(i);
                if (charAt != '/') {
                    if (charAt != '\\') {
                        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                        while (true) {
                            i3 = i;
                            if (i3 < i2) {
                                i = DeepLinkUri.delimiterOffset(str, i3, i2, "/\\");
                                z = i >= i2;
                                push(str, i3, i, z, true);
                                if (z) {
                                    i++;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
                while (true) {
                    i3 = i;
                    if (i3 < i2) {
                        i = DeepLinkUri.delimiterOffset(str, i3, i2, "/\\");
                        if (i >= i2) {
                        }
                        push(str, i3, i, z, true);
                        if (z) {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            str = DeepLinkUri.canonicalize(str, i, i2, DeepLinkUri.PATH_SEGMENT_ENCODE_SET, z2, false);
            if (isDot(str) == 0) {
                if (isDotDot(str) != 0) {
                    pop();
                    return;
                }
                if (((String) this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).isEmpty() != 0) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, str);
                } else {
                    this.encodedPathSegments.add(str);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private boolean isDot(String str) {
            if (!str.equals(".")) {
                if (str.equalsIgnoreCase("%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        private boolean isDotDot(String str) {
            if (!(str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e"))) {
                if (str.equalsIgnoreCase("%2e%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        private void pop() {
            if (!((String) this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
            }
        }

        private int skipLeadingAsciiWhitespace(String str, int i, int i2) {
            while (i < i2) {
                switch (str.charAt(i)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        i++;
                    default:
                        return i;
                }
            }
            return i2;
        }

        private int skipTrailingAsciiWhitespace(String str, int i, int i2) {
            i2--;
            while (i2 >= i) {
                switch (str.charAt(i2)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        i2--;
                    default:
                        return i2 + 1;
                }
            }
            return i;
        }

        private static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if (charAt < 'a' || charAt > 'z') {
                if (charAt >= 'A') {
                    if (charAt > 'Z') {
                    }
                }
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '.'))) {
                    break;
                }
            }
            if (charAt == ':') {
                return i;
            }
            return -1;
        }

        private static int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            str = DeepLinkUri.percentDecode(str, i, i2);
            if (str.startsWith("[") == 0 || str.endsWith("]") == 0) {
                return domainToAscii(str);
            }
            str = decodeIpv6(str, 1, str.length() - 1);
            if (str == null) {
                return null;
            }
            str = str.getAddress();
            if (str.length == 16) {
                return inet6AddressToAscii(str);
            }
            throw new AssertionError();
        }

        private static java.net.InetAddress decodeIpv6(java.lang.String r11, int r12, int r13) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 16;
            r1 = new byte[r0];
            r2 = -1;
            r3 = 0;
            r5 = r2;
            r6 = r5;
            r4 = r3;
        L_0x0009:
            r7 = 0;
            if (r12 >= r13) goto L_0x007a;
        L_0x000c:
            if (r4 != r0) goto L_0x000f;
        L_0x000e:
            return r7;
        L_0x000f:
            r8 = r12 + 2;
            if (r8 > r13) goto L_0x0028;
        L_0x0013:
            r9 = "::";
            r10 = 2;
            r9 = r11.regionMatches(r12, r9, r3, r10);
            if (r9 == 0) goto L_0x0028;
        L_0x001c:
            if (r5 == r2) goto L_0x001f;
        L_0x001e:
            return r7;
        L_0x001f:
            r4 = r4 + 2;
            if (r8 != r13) goto L_0x0025;
        L_0x0023:
            r5 = r4;
            goto L_0x007a;
        L_0x0025:
            r5 = r4;
            r6 = r8;
            goto L_0x004c;
        L_0x0028:
            if (r4 == 0) goto L_0x004b;
        L_0x002a:
            r8 = ":";
            r9 = 1;
            r8 = r11.regionMatches(r12, r8, r3, r9);
            if (r8 == 0) goto L_0x0036;
        L_0x0033:
            r12 = r12 + 1;
            goto L_0x004b;
        L_0x0036:
            r8 = ".";
            r12 = r11.regionMatches(r12, r8, r3, r9);
            if (r12 == 0) goto L_0x004a;
        L_0x003e:
            r12 = r4 + -2;
            r11 = decodeIpv4Suffix(r11, r6, r13, r1, r12);
            if (r11 != 0) goto L_0x0047;
        L_0x0046:
            return r7;
        L_0x0047:
            r4 = r4 + 2;
            goto L_0x007a;
        L_0x004a:
            return r7;
        L_0x004b:
            r6 = r12;
        L_0x004c:
            r8 = r3;
            r12 = r6;
        L_0x004e:
            if (r12 >= r13) goto L_0x0060;
        L_0x0050:
            r9 = r11.charAt(r12);
            r9 = com.airbnb.deeplinkdispatch.DeepLinkUri.decodeHexDigit(r9);
            if (r9 == r2) goto L_0x0060;
        L_0x005a:
            r8 = r8 << 4;
            r8 = r8 + r9;
            r12 = r12 + 1;
            goto L_0x004e;
        L_0x0060:
            r9 = r12 - r6;
            if (r9 == 0) goto L_0x0079;
        L_0x0064:
            r10 = 4;
            if (r9 <= r10) goto L_0x0068;
        L_0x0067:
            goto L_0x0079;
        L_0x0068:
            r7 = r4 + 1;
            r9 = r8 >>> 8;
            r9 = r9 & 255;
            r9 = (byte) r9;
            r1[r4] = r9;
            r4 = r7 + 1;
            r8 = r8 & 255;
            r8 = (byte) r8;
            r1[r7] = r8;
            goto L_0x0009;
        L_0x0079:
            return r7;
        L_0x007a:
            if (r4 == r0) goto L_0x008b;
        L_0x007c:
            if (r5 != r2) goto L_0x007f;
        L_0x007e:
            return r7;
        L_0x007f:
            r11 = r4 - r5;
            r12 = 16 - r11;
            java.lang.System.arraycopy(r1, r5, r1, r12, r11);
            r0 = r0 - r4;
            r0 = r0 + r5;
            java.util.Arrays.fill(r1, r5, r0, r3);
        L_0x008b:
            r11 = java.net.InetAddress.getByAddress(r1);	 Catch:{ UnknownHostException -> 0x0090 }
            return r11;
        L_0x0090:
            r11 = new java.lang.AssertionError;
            r11.<init>();
            throw r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.deeplinkdispatch.DeepLinkUri.Builder.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if (i6 == 0 && i != i5) {
                        return false;
                    } else {
                        i6 = ((i6 * 10) + charAt) - 48;
                        if (i6 > 255) {
                            return false;
                        }
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                i = i4 + 1;
                bArr[i4] = (byte) i6;
                i4 = i;
                i = i5;
            }
            if (i4 != i3 + 4) {
                return false;
            }
            return true;
        }

        private static java.lang.String domainToAscii(java.lang.String r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 0;
            r2 = java.net.IDN.toASCII(r2);	 Catch:{ IllegalArgumentException -> 0x001d }
            r1 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x001d }
            r2 = r2.toLowerCase(r1);	 Catch:{ IllegalArgumentException -> 0x001d }
            r1 = r2.isEmpty();	 Catch:{ IllegalArgumentException -> 0x001d }
            if (r1 == 0) goto L_0x0012;	 Catch:{ IllegalArgumentException -> 0x001d }
        L_0x0011:
            return r0;	 Catch:{ IllegalArgumentException -> 0x001d }
        L_0x0012:
            if (r2 != 0) goto L_0x0015;	 Catch:{ IllegalArgumentException -> 0x001d }
        L_0x0014:
            return r0;	 Catch:{ IllegalArgumentException -> 0x001d }
        L_0x0015:
            r1 = containsInvalidHostnameAsciiCodes(r2);	 Catch:{ IllegalArgumentException -> 0x001d }
            if (r1 == 0) goto L_0x001c;
        L_0x001b:
            return r0;
        L_0x001c:
            return r2;
        L_0x001d:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.deeplinkdispatch.DeepLinkUri.Builder.domainToAscii(java.lang.String):java.lang.String");
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt > '\u001f') {
                    if (charAt < '') {
                        if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                            return true;
                        }
                        i++;
                    }
                }
                return true;
            }
            return false;
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = i2;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i3 = i4;
                    i2 = i6;
                }
                i4 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.b(58);
                    i += i2;
                    if (i == 16) {
                        buffer.b(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.b(58);
                    }
                    buffer.l((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return buffer.p();
        }

        private static int parsePort(java.lang.String r7, int r8, int r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = -1;
            r4 = "";	 Catch:{ NumberFormatException -> 0x0019 }
            r5 = 0;	 Catch:{ NumberFormatException -> 0x0019 }
            r6 = 0;	 Catch:{ NumberFormatException -> 0x0019 }
            r1 = r7;	 Catch:{ NumberFormatException -> 0x0019 }
            r2 = r8;	 Catch:{ NumberFormatException -> 0x0019 }
            r3 = r9;	 Catch:{ NumberFormatException -> 0x0019 }
            r7 = com.airbnb.deeplinkdispatch.DeepLinkUri.canonicalize(r1, r2, r3, r4, r5, r6);	 Catch:{ NumberFormatException -> 0x0019 }
            r7 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x0019 }
            if (r7 <= 0) goto L_0x0018;
        L_0x0012:
            r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
            if (r7 > r8) goto L_0x0018;
        L_0x0017:
            return r7;
        L_0x0018:
            return r0;
        L_0x0019:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.deeplinkdispatch.DeepLinkUri.Builder.parsePort(java.lang.String, int, int):int");
        }
    }

    static int decodeHexDigit(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    private DeepLinkUri(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername);
        this.password = percentDecode(builder.encodedPassword);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments);
        String str = null;
        this.queryNamesAndValues = builder.encodedQueryNamesAndValues != null ? percentDecode(builder.encodedQueryNamesAndValues) : null;
        if (builder.encodedFragment != null) {
            str = percentDecode(builder.encodedFragment);
        }
        this.fragment = str;
        this.url = builder.toString();
    }

    final URL url() {
        try {
            return new URL(this.url);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    final java.net.URI uri() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.url;	 Catch:{ URISyntaxException -> 0x0010 }
        r1 = "^`{}|\\";	 Catch:{ URISyntaxException -> 0x0010 }
        r2 = 1;	 Catch:{ URISyntaxException -> 0x0010 }
        r3 = 0;	 Catch:{ URISyntaxException -> 0x0010 }
        r0 = canonicalize(r0, r1, r2, r3);	 Catch:{ URISyntaxException -> 0x0010 }
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0010 }
        r1.<init>(r0);	 Catch:{ URISyntaxException -> 0x0010 }
        return r1;
    L_0x0010:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "not valid as a java.net.URI: ";
        r1.<init>(r2);
        r2 = r4.url;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.deeplinkdispatch.DeepLinkUri.uri():java.net.URI");
    }

    final String scheme() {
        return this.scheme;
    }

    final boolean isHttps() {
        return this.scheme.equals("https");
    }

    final String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        return this.url.substring(length, delimiterOffset(this.url, length, this.url.length(), ":@"));
    }

    final String username() {
        return this.username;
    }

    final String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    final String password() {
        return this.password;
    }

    final String host() {
        return this.host;
    }

    final String encodedHost() {
        return canonicalize(this.host, CONVERT_TO_URI_ENCODE_SET, true, true);
    }

    final int port() {
        return this.port;
    }

    static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") != null ? MPSUtils.SYSTEM : -1;
    }

    final int pathSize() {
        return this.pathSegments.size();
    }

    final String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        return this.url.substring(indexOf, delimiterOffset(this.url, indexOf, this.url.length(), "?#"));
    }

    static void pathSegmentsToString(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    final List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        int delimiterOffset = delimiterOffset(this.url, indexOf, this.url.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            indexOf++;
            int delimiterOffset2 = delimiterOffset(this.url, indexOf, delimiterOffset, Operation.DIVISION);
            arrayList.add(this.url.substring(indexOf, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    final List<String> pathSegments() {
        return this.pathSegments;
    }

    final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        return this.url.substring(indexOf, delimiterOffset(this.url, indexOf + 1, this.url.length(), "#"));
    }

    static void namesAndValuesToQueryString(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> queryStringToNamesAndValues(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1) {
                if (indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                    i = indexOf + 1;
                }
            }
            arrayList.add(str.substring(i, indexOf));
            arrayList.add(null);
            i = indexOf + 1;
        }
        return arrayList;
    }

    final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        namesAndValuesToQueryString(stringBuilder, this.queryNamesAndValues);
        return stringBuilder.toString();
    }

    final int querySize() {
        return this.queryNamesAndValues != null ? this.queryNamesAndValues.size() / 2 : 0;
    }

    final String queryParameter(String str) {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return (String) this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public final List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    final String queryParameterName(int i) {
        return (String) this.queryNamesAndValues.get(i * 2);
    }

    final String queryParameterValue(int i) {
        return (String) this.queryNamesAndValues.get((i * 2) + 1);
    }

    final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    final String fragment() {
        return this.fragment;
    }

    final DeepLinkUri resolve(String str) {
        Builder builder = new Builder();
        return builder.parse(this, str) == ParseResult.SUCCESS ? builder.build() : null;
    }

    final Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public static DeepLinkUri parse(String str) {
        Builder builder = new Builder();
        if (builder.parse(null, str) == ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    static DeepLinkUri get(URL url) {
        return parse(url.toString());
    }

    static DeepLinkUri getChecked(String str) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        ParseResult parse = builder.parse(null, str);
        switch (parse) {
            case SUCCESS:
                return builder.build();
            case INVALID_HOST:
                StringBuilder stringBuilder = new StringBuilder("Invalid host: ");
                stringBuilder.append(str);
                throw new UnknownHostException(stringBuilder.toString());
            default:
                StringBuilder stringBuilder2 = new StringBuilder("Invalid URL: ");
                stringBuilder2.append(parse);
                stringBuilder2.append(" for ");
                stringBuilder2.append(str);
                throw new MalformedURLException(stringBuilder2.toString());
        }
    }

    static DeepLinkUri get(URI uri) {
        return parse(uri.toString());
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof DeepLinkUri) || ((DeepLinkUri) obj).url.equals(this.url) == null) ? null : true;
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String toString() {
        return this.url;
    }

    private static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    static String percentDecode(String str) {
        return percentDecode(str, 0, str.length());
    }

    private List<String> percentDecode(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? percentDecode(str) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String percentDecode(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == '%') {
                Buffer buffer = new Buffer();
                buffer.a(str, i, i3);
                percentDecode(buffer, str, i3, i2);
                return buffer.p();
            }
        }
        return str.substring(i, i2);
    }

    static void percentDecode(Buffer buffer, String str, int i, int i2) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int decodeHexDigit = decodeHexDigit(str.charAt(i + 1));
                    int decodeHexDigit2 = decodeHexDigit(str.charAt(i3));
                    if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                        buffer.b((decodeHexDigit << 4) + decodeHexDigit2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                }
            }
            buffer.a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt < 127 && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || z)) {
                if (!z2 || codePointAt != 43) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.a(str, i, i3);
            canonicalize(buffer, str, i3, i2, str2, z, z2);
            return buffer.p();
        }
        return str.substring(i, i2);
    }

    static void canonicalize(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (z2 && codePointAt == 43) {
                    buffer.a(z ? "%20" : "%2B");
                } else {
                    if (codePointAt >= 32 && codePointAt < 127 && str2.indexOf(codePointAt) == -1) {
                        if (codePointAt != 37 || z) {
                            buffer.a(codePointAt);
                        }
                    }
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.a(codePointAt);
                    while (!buffer2.d()) {
                        int g = buffer2.g() & 255;
                        buffer.b(37);
                        buffer.b(HEX_DIGITS[(g >> 4) & 15]);
                        buffer.b(HEX_DIGITS[g & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2) {
        return canonicalize(str, 0, str.length(), str2, z, z2);
    }
}
