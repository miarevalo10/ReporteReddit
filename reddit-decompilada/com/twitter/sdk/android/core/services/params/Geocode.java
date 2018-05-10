package com.twitter.sdk.android.core.services.params;

public class Geocode {
    public final double f24119a;
    public final double f24120b;
    public final int f24121c;
    public final Distance f24122d;

    public enum Distance {
        MILES("mi"),
        KILOMETERS("km");
        
        public final String f24118c;

        private Distance(String str) {
            this.f24118c = str;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f24119a);
        stringBuilder.append(",");
        stringBuilder.append(this.f24120b);
        stringBuilder.append(",");
        stringBuilder.append(this.f24121c);
        stringBuilder.append(this.f24122d.f24118c);
        return stringBuilder.toString();
    }
}
