package com.googlecode.mp4parser.authoring;

import com.googlecode.mp4parser.util.Matrix;
import java.util.LinkedList;
import java.util.List;

public class Movie {
    public Matrix f8886a = Matrix.f9068j;
    public List<Track> f8887b = new LinkedList();

    public final void m7629a(Track track) {
        Track track2;
        long j = track.mo3626m().f8896i;
        for (Track track3 : this.f8887b) {
            if (track3.mo3626m().f8896i == j) {
                track2 = track3;
                break;
            }
        }
        track2 = null;
        if (track2 != null) {
            TrackMetaData m = track.mo3626m();
            long j2 = 0;
            for (Track track4 : this.f8887b) {
                if (j2 < track4.mo3626m().f8896i) {
                    j2 = track4.mo3626m().f8896i;
                }
            }
            m.f8896i = j2 + 1;
        }
        this.f8887b.add(track);
    }

    public String toString() {
        Object obj = "Movie{ ";
        for (Track track : this.f8887b) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj));
            stringBuilder.append("track_");
            stringBuilder.append(track.mo3626m().f8896i);
            stringBuilder.append(" (");
            stringBuilder.append(track.mo3627n());
            stringBuilder.append(") ");
            obj = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(obj));
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public final long m7628a() {
        long j = ((Track) this.f8887b.iterator().next()).mo3626m().f8889b;
        for (Track m : this.f8887b) {
            long j2 = m.mo3626m().f8889b;
            while (j != 0) {
                long j3 = j;
                j = j2 % j;
                j2 = j3;
            }
            j = j2;
        }
        return j;
    }
}
