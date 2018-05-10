package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CroppedTrack extends AbstractTrack {
    static final /* synthetic */ boolean f18499e = true;
    Track f18500d;
    private int f18501f;
    private int f18502g;

    public CroppedTrack(Track track, long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder("crop(");
        stringBuilder.append(track.mo2517f());
        stringBuilder.append(")");
        super(stringBuilder.toString());
        this.f18500d = track;
        if (f18499e == null && j > 2147483647L) {
            throw new AssertionError();
        } else if (f18499e != null || j2 <= 2147483647L) {
            this.f18501f = (int) j;
            this.f18502g = (int) j2;
        } else {
            throw new AssertionError();
        }
    }

    public void close() throws IOException {
        this.f18500d.close();
    }

    public final List<Sample> mo3623j() {
        return this.f18500d.mo3623j().subList(this.f18501f, this.f18502g);
    }

    public final SampleDescriptionBox mo3625l() {
        return this.f18500d.mo3625l();
    }

    public final synchronized long[] mo3624k() {
        Object obj;
        obj = new long[(this.f18502g - this.f18501f)];
        System.arraycopy(this.f18500d.mo3624k(), this.f18501f, obj, 0, obj.length);
        return obj;
    }

    public final List<Entry> mo2512a() {
        List a = this.f18500d.mo2512a();
        long j = (long) this.f18501f;
        long j2 = (long) this.f18502g;
        if (a == null || a.isEmpty()) {
            return null;
        }
        long j3 = 0;
        ListIterator listIterator = a.listIterator();
        List arrayList = new ArrayList();
        while (true) {
            Entry entry = (Entry) listIterator.next();
            if (((long) entry.getCount()) + j3 > j) {
                break;
            }
            j3 += (long) entry.getCount();
        }
        if (((long) entry.getCount()) + j3 >= j2) {
            arrayList.add(new Entry((int) (j2 - j), entry.getOffset()));
            return arrayList;
        }
        arrayList.add(new Entry((int) ((((long) entry.getCount()) + j3) - j), entry.getOffset()));
        j3 += (long) entry.getCount();
        while (listIterator.hasNext()) {
            entry = (Entry) listIterator.next();
            if (((long) entry.getCount()) + j3 >= j2) {
                break;
            }
            arrayList.add(entry);
            j3 += (long) entry.getCount();
        }
        arrayList.add(new Entry((int) (j2 - j3), entry.getOffset()));
        return arrayList;
    }

    public final synchronized long[] mo2513b() {
        if (this.f18500d.mo2513b() == null) {
            return null;
        }
        long[] b = this.f18500d.mo2513b();
        int length = b.length;
        int i = 0;
        int i2 = 0;
        while (i2 < b.length) {
            if (b[i2] >= ((long) this.f18501f)) {
                break;
            }
            i2++;
        }
        while (length > 0) {
            if (((long) this.f18502g) >= b[length - 1]) {
                break;
            }
            length--;
        }
        length -= i2;
        Object obj = new long[length];
        System.arraycopy(this.f18500d.mo2513b(), i2, obj, 0, length);
        while (i < obj.length) {
            obj[i] = obj[i] - ((long) this.f18501f);
            i++;
        }
        return obj;
    }

    public final List<SampleDependencyTypeBox.Entry> mo2514c() {
        return (this.f18500d.mo2514c() == null || this.f18500d.mo2514c().isEmpty()) ? null : this.f18500d.mo2514c().subList(this.f18501f, this.f18502g);
    }

    public final TrackMetaData mo3626m() {
        return this.f18500d.mo3626m();
    }

    public final String mo3627n() {
        return this.f18500d.mo3627n();
    }

    public final SubSampleInformationBox mo2515d() {
        return this.f18500d.mo2515d();
    }
}
