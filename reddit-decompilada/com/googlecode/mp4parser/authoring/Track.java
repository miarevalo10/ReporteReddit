package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

public interface Track extends Closeable {
    List<Entry> mo2512a();

    long[] mo2513b();

    List<SampleDependencyTypeBox.Entry> mo2514c();

    SubSampleInformationBox mo2515d();

    long mo2516e();

    String mo2517f();

    List<Edit> mo2518g();

    Map<GroupEntry, long[]> mo2519h();

    List<Sample> mo3623j();

    long[] mo3624k();

    SampleDescriptionBox mo3625l();

    TrackMetaData mo3626m();

    String mo3627n();
}
