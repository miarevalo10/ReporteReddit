package android.support.v4.text;

import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat f1367a = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicCompat f1368b = new TextDirectionHeuristicInternal(null, true);
    public static final TextDirectionHeuristicCompat f1369c = new TextDirectionHeuristicInternal(FirstStrong.f11441a, false);
    public static final TextDirectionHeuristicCompat f1370d = new TextDirectionHeuristicInternal(FirstStrong.f11441a, true);
    public static final TextDirectionHeuristicCompat f1371e = new TextDirectionHeuristicInternal(AnyStrong.f11438a, false);
    public static final TextDirectionHeuristicCompat f1372f = TextDirectionHeuristicLocale.f16504a;

    private interface TextDirectionAlgorithm {
        int mo351a(CharSequence charSequence, int i);
    }

    private static class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong f11438a = new AnyStrong(true);
        public static final AnyStrong f11439b = new AnyStrong(false);
        private final boolean f11440c;

        public final int mo351a(CharSequence charSequence, int i) {
            i += 0;
            int i2 = 0;
            int i3 = i2;
            while (i2 < i) {
                switch (TextDirectionHeuristicsCompat.m996a(Character.getDirectionality(charSequence.charAt(i2)))) {
                    case 0:
                        if (this.f11440c) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.f11440c) {
                            return 1;
                        }
                        break;
                    default:
                        continue;
                }
                i3 = 1;
                i2++;
            }
            if (i3 != 0) {
                return this.f11440c != null ? 1 : 0;
            } else {
                return 2;
            }
        }

        private AnyStrong(boolean z) {
            this.f11440c = z;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong f11441a = new FirstStrong();

        public final int mo351a(CharSequence charSequence, int i) {
            int i2 = 0;
            i += 0;
            int i3 = 2;
            while (i2 < i && i3 == 2) {
                i3 = TextDirectionHeuristicsCompat.m997b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i3;
        }

        private FirstStrong() {
        }
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm f11442a;

        protected abstract boolean mo3133a();

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f11442a = textDirectionAlgorithm;
        }

        public final boolean mo352a(CharSequence charSequence, int i) {
            if (charSequence != null && i >= 0) {
                if (charSequence.length() - i >= 0) {
                    if (this.f11442a == null) {
                        return mo3133a();
                    }
                    switch (this.f11442a.mo351a(charSequence, i)) {
                        case null:
                            return true;
                        case 1:
                            return null;
                        default:
                            return mo3133a();
                    }
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean f16503a;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f16503a = z;
        }

        protected final boolean mo3133a() {
            return this.f16503a;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale f16504a = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        protected final boolean mo3133a() {
            return TextUtilsCompat.m998a(Locale.getDefault()) == 1;
        }
    }

    static int m996a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m997b(int r0) {
        /*
        switch(r0) {
            case 0: goto L_0x000a;
            case 1: goto L_0x0008;
            case 2: goto L_0x0008;
            default: goto L_0x0003;
        };
    L_0x0003:
        switch(r0) {
            case 14: goto L_0x000a;
            case 15: goto L_0x000a;
            case 16: goto L_0x0008;
            case 17: goto L_0x0008;
            default: goto L_0x0006;
        };
    L_0x0006:
        r0 = 2;
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
    L_0x000a:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.TextDirectionHeuristicsCompat.b(int):int");
    }
}
