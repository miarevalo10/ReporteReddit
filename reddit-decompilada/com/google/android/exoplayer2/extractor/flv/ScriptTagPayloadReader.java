package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class ScriptTagPayloadReader extends TagPayloadReader {
    long f12859a = -9223372036854775807L;

    protected final boolean mo1349a(ParsableByteArray parsableByteArray) {
        return true;
    }

    public ScriptTagPayloadReader() {
        super(null);
    }

    private static Double m12034b(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.m4261l()));
    }

    private static String m12035c(ParsableByteArray parsableByteArray) {
        int e = parsableByteArray.m4252e();
        int i = parsableByteArray.f5257b;
        parsableByteArray.m4251d(e);
        return new String(parsableByteArray.f5256a, i, e);
    }

    private static ArrayList<Object> m12036d(ParsableByteArray parsableByteArray) {
        int n = parsableByteArray.m4263n();
        ArrayList<Object> arrayList = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(m12033a(parsableByteArray, parsableByteArray.m4250d()));
        }
        return arrayList;
    }

    private static HashMap<String, Object> m12037e(ParsableByteArray parsableByteArray) {
        int n = parsableByteArray.m4263n();
        HashMap<String, Object> hashMap = new HashMap(n);
        for (int i = 0; i < n; i++) {
            hashMap.put(m12035c(parsableByteArray), m12033a(parsableByteArray, parsableByteArray.m4250d()));
        }
        return hashMap;
    }

    protected final void mo1348a(ParsableByteArray parsableByteArray, long j) throws ParserException {
        if (parsableByteArray.m4250d() != 2) {
            throw new ParserException();
        }
        if ("onMetaData".equals(m12035c(parsableByteArray)) != null && parsableByteArray.m4250d() == 8) {
            parsableByteArray = m12037e(parsableByteArray);
            if (parsableByteArray.containsKey(State.KEY_DURATION) != null) {
                parsableByteArray = ((Double) parsableByteArray.get(State.KEY_DURATION)).doubleValue();
                if (parsableByteArray > 0.0d) {
                    this.f12859a = (long) (parsableByteArray * 1000000.0d);
                }
            }
        }
    }

    private static Object m12033a(ParsableByteArray parsableByteArray, int i) {
        if (i == 8) {
            return m12037e(parsableByteArray);
        }
        switch (i) {
            case 0:
                return m12034b(parsableByteArray);
            case 1:
                i = 1;
                if (parsableByteArray.m4250d() != 1) {
                    i = 0;
                }
                return Boolean.valueOf(i);
            case 2:
                return m12035c(parsableByteArray);
            case 3:
                i = new HashMap();
                while (true) {
                    String c = m12035c(parsableByteArray);
                    int d = parsableByteArray.m4250d();
                    if (d == 9) {
                        return i;
                    }
                    i.put(c, m12033a(parsableByteArray, d));
                }
            default:
                switch (i) {
                    case 10:
                        return m12036d(parsableByteArray);
                    case 11:
                        i = new Date((long) m12034b(parsableByteArray).doubleValue());
                        parsableByteArray.m4251d(2);
                        return i;
                    default:
                        return null;
                }
        }
    }
}
