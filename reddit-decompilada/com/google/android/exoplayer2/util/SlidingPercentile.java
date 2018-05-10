package com.google.android.exoplayer2.util;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPercentile {
    public static final Comparator<Sample> f5270a = new C04251();
    public static final Comparator<Sample> f5271b = new C04262();
    public final int f5272c = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
    public final ArrayList<Sample> f5273d = new ArrayList();
    public final Sample[] f5274e = new Sample[5];
    public int f5275f = -1;
    public int f5276g;
    public int f5277h;
    public int f5278i;

    static class C04251 implements Comparator<Sample> {
        C04251() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Sample) obj).f5267a - ((Sample) obj2).f5267a;
        }
    }

    static class C04262 implements Comparator<Sample> {
        C04262() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Sample sample = (Sample) obj;
            Sample sample2 = (Sample) obj2;
            if (sample.f5269c < sample2.f5269c) {
                return -1;
            }
            return sample2.f5269c < sample.f5269c ? 1 : null;
        }
    }

    private static class Sample {
        public int f5267a;
        public int f5268b;
        public float f5269c;

        private Sample() {
        }
    }
}
