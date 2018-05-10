package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AppendTrack extends AbstractTrack {
    private static Logger f18494h = Logger.m7708a(AppendTrack.class);
    Track[] f18495d;
    SampleDescriptionBox f18496e;
    List<Sample> f18497f;
    long[] f18498g;

    public AppendTrack(Track... trackArr) throws IOException {
        int i;
        super(m19343a(trackArr));
        this.f18495d = trackArr;
        for (i = 0; i <= 0; i++) {
            Track track = trackArr[0];
            if (this.f18496e == null) {
                this.f18496e = new SampleDescriptionBox();
                this.f18496e.addBox((Box) track.mo3625l().getBoxes(SampleEntry.class).get(0));
            } else {
                this.f18496e = m19339a(this.f18496e, track.mo3625l());
            }
        }
        this.f18497f = new ArrayList();
        for (i = 0; i <= 0; i++) {
            this.f18497f.addAll(trackArr[0].mo3623j());
        }
        i = 0;
        int i2 = i;
        while (i <= 0) {
            i2 = trackArr[0].mo3624k().length + 0;
            i++;
        }
        this.f18498g = new long[i2];
        for (i = 0; i <= 0; i++) {
            Object k = trackArr[0].mo3624k();
            System.arraycopy(k, 0, this.f18498g, 0, k.length);
        }
    }

    private static String m19343a(Track... trackArr) {
        String str = "";
        for (Track track : trackArr) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
            stringBuilder.append(track.mo2517f());
            stringBuilder.append(" + ");
            str = stringBuilder.toString();
        }
        return str.substring(0, str.length() - 3);
    }

    public void close() throws IOException {
        for (Track close : this.f18495d) {
            close.close();
        }
    }

    private static SampleDescriptionBox m19339a(SampleDescriptionBox sampleDescriptionBox, SampleDescriptionBox sampleDescriptionBox2) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        Object obj = null;
        try {
            sampleDescriptionBox.getBox(Channels.newChannel(byteArrayOutputStream));
            sampleDescriptionBox2.getBox(Channels.newChannel(byteArrayOutputStream2));
            if (!Arrays.equals(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream.toByteArray())) {
                SampleEntry sampleEntry = (SampleEntry) sampleDescriptionBox.getBoxes(SampleEntry.class).get(0);
                SampleEntry sampleEntry2 = (SampleEntry) sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0);
                if (sampleEntry.getType().equals(sampleEntry2.getType())) {
                    if ((sampleEntry instanceof VisualSampleEntry) && (sampleEntry2 instanceof VisualSampleEntry)) {
                        obj = m19341a((VisualSampleEntry) sampleEntry, (VisualSampleEntry) sampleEntry2);
                    } else if ((sampleEntry instanceof AudioSampleEntry) && (sampleEntry2 instanceof AudioSampleEntry)) {
                        obj = m19340a((AudioSampleEntry) sampleEntry, (AudioSampleEntry) sampleEntry2);
                    }
                }
                if (obj != null) {
                    sampleDescriptionBox.setBoxes(Collections.singletonList(obj));
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Cannot merge ");
                    stringBuilder.append(sampleDescriptionBox.getBoxes(SampleEntry.class).get(0));
                    stringBuilder.append(" and ");
                    stringBuilder.append(sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                    throw new IOException(stringBuilder.toString());
                }
            }
            return sampleDescriptionBox;
        } catch (SampleDescriptionBox sampleDescriptionBox3) {
            f18494h.mo2533c(sampleDescriptionBox3.getMessage());
            return null;
        }
    }

    private static VisualSampleEntry m19341a(VisualSampleEntry visualSampleEntry, VisualSampleEntry visualSampleEntry2) {
        VisualSampleEntry visualSampleEntry3 = new VisualSampleEntry();
        if (visualSampleEntry.getHorizresolution() == visualSampleEntry2.getHorizresolution()) {
            visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
            visualSampleEntry3.setCompressorname(visualSampleEntry.getCompressorname());
            if (visualSampleEntry.getDepth() == visualSampleEntry2.getDepth()) {
                visualSampleEntry3.setDepth(visualSampleEntry.getDepth());
                if (visualSampleEntry.getFrameCount() == visualSampleEntry2.getFrameCount()) {
                    visualSampleEntry3.setFrameCount(visualSampleEntry.getFrameCount());
                    if (visualSampleEntry.getHeight() == visualSampleEntry2.getHeight()) {
                        visualSampleEntry3.setHeight(visualSampleEntry.getHeight());
                        if (visualSampleEntry.getWidth() == visualSampleEntry2.getWidth()) {
                            visualSampleEntry3.setWidth(visualSampleEntry.getWidth());
                            if (visualSampleEntry.getVertresolution() == visualSampleEntry2.getVertresolution()) {
                                visualSampleEntry3.setVertresolution(visualSampleEntry.getVertresolution());
                                if (visualSampleEntry.getHorizresolution() == visualSampleEntry2.getHorizresolution()) {
                                    visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
                                    if (visualSampleEntry.getBoxes().size() == visualSampleEntry2.getBoxes().size()) {
                                        visualSampleEntry2 = visualSampleEntry2.getBoxes().iterator();
                                        for (Box box : visualSampleEntry.getBoxes()) {
                                            Box box2 = (Box) visualSampleEntry2.next();
                                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            try {
                                                box.getBox(Channels.newChannel(byteArrayOutputStream));
                                                box2.getBox(Channels.newChannel(byteArrayOutputStream2));
                                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                    visualSampleEntry3.addBox(box);
                                                } else if ((box instanceof AbstractDescriptorBox) && (box2 instanceof AbstractDescriptorBox)) {
                                                    AbstractDescriptorBox abstractDescriptorBox = (AbstractDescriptorBox) box;
                                                    abstractDescriptorBox.setDescriptor(m19342a(abstractDescriptorBox.getDescriptor(), ((AbstractDescriptorBox) box2).getDescriptor()));
                                                    visualSampleEntry3.addBox(box);
                                                }
                                            } catch (VisualSampleEntry visualSampleEntry4) {
                                                f18494h.mo2532b(visualSampleEntry4.getMessage());
                                                return null;
                                            }
                                        }
                                    }
                                    return visualSampleEntry3;
                                }
                                f18494h.mo2533c("horizontal resolution differs");
                                return null;
                            }
                            f18494h.mo2533c("vert resolution differs");
                            return null;
                        }
                        f18494h.mo2533c("width differs");
                        return null;
                    }
                    f18494h.mo2533c("height differs");
                    return null;
                }
                f18494h.mo2533c("frame count differs");
                return null;
            }
            f18494h.mo2533c("Depth differs");
            return null;
        }
        f18494h.mo2533c("Horizontal Resolution differs");
        return null;
    }

    private static AudioSampleEntry m19340a(AudioSampleEntry audioSampleEntry, AudioSampleEntry audioSampleEntry2) {
        AudioSampleEntry audioSampleEntry3 = new AudioSampleEntry(audioSampleEntry2.getType());
        if (audioSampleEntry.getBytesPerFrame() == audioSampleEntry2.getBytesPerFrame()) {
            audioSampleEntry3.setBytesPerFrame(audioSampleEntry.getBytesPerFrame());
            if (audioSampleEntry.getBytesPerPacket() != audioSampleEntry2.getBytesPerPacket()) {
                return null;
            }
            audioSampleEntry3.setBytesPerPacket(audioSampleEntry.getBytesPerPacket());
            if (audioSampleEntry.getBytesPerSample() == audioSampleEntry2.getBytesPerSample()) {
                audioSampleEntry3.setBytesPerSample(audioSampleEntry.getBytesPerSample());
                if (audioSampleEntry.getChannelCount() != audioSampleEntry2.getChannelCount()) {
                    return null;
                }
                audioSampleEntry3.setChannelCount(audioSampleEntry.getChannelCount());
                if (audioSampleEntry.getPacketSize() == audioSampleEntry2.getPacketSize()) {
                    audioSampleEntry3.setPacketSize(audioSampleEntry.getPacketSize());
                    if (audioSampleEntry.getCompressionId() != audioSampleEntry2.getCompressionId()) {
                        return null;
                    }
                    audioSampleEntry3.setCompressionId(audioSampleEntry.getCompressionId());
                    if (audioSampleEntry.getSampleRate() != audioSampleEntry2.getSampleRate()) {
                        return null;
                    }
                    audioSampleEntry3.setSampleRate(audioSampleEntry.getSampleRate());
                    if (audioSampleEntry.getSampleSize() != audioSampleEntry2.getSampleSize()) {
                        return null;
                    }
                    audioSampleEntry3.setSampleSize(audioSampleEntry.getSampleSize());
                    if (audioSampleEntry.getSamplesPerPacket() != audioSampleEntry2.getSamplesPerPacket()) {
                        return null;
                    }
                    audioSampleEntry3.setSamplesPerPacket(audioSampleEntry.getSamplesPerPacket());
                    if (audioSampleEntry.getSoundVersion() != audioSampleEntry2.getSoundVersion()) {
                        return null;
                    }
                    audioSampleEntry3.setSoundVersion(audioSampleEntry.getSoundVersion());
                    if (!Arrays.equals(audioSampleEntry.getSoundVersion2Data(), audioSampleEntry2.getSoundVersion2Data())) {
                        return null;
                    }
                    audioSampleEntry3.setSoundVersion2Data(audioSampleEntry.getSoundVersion2Data());
                    if (audioSampleEntry.getBoxes().size() == audioSampleEntry2.getBoxes().size()) {
                        audioSampleEntry2 = audioSampleEntry2.getBoxes().iterator();
                        for (Box box : audioSampleEntry.getBoxes()) {
                            Box box2 = (Box) audioSampleEntry2.next();
                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                box.getBox(Channels.newChannel(byteArrayOutputStream));
                                box2.getBox(Channels.newChannel(byteArrayOutputStream2));
                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                    audioSampleEntry3.addBox(box);
                                } else if (ESDescriptorBox.TYPE.equals(box.getType()) && ESDescriptorBox.TYPE.equals(box2.getType())) {
                                    ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) box;
                                    eSDescriptorBox.setDescriptor(m19342a(eSDescriptorBox.getEsDescriptor(), ((ESDescriptorBox) box2).getEsDescriptor()));
                                    audioSampleEntry3.addBox(box);
                                }
                            } catch (AudioSampleEntry audioSampleEntry4) {
                                f18494h.mo2532b(audioSampleEntry4.getMessage());
                                return null;
                            }
                        }
                    }
                    return audioSampleEntry3;
                }
                f18494h.mo2533c("ChannelCount differ");
                return null;
            }
            f18494h.mo2533c("BytesPerSample differ");
            return null;
        }
        f18494h.mo2533c("BytesPerFrame differ");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor m19342a(com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor r7, com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor r8) {
        /*
        r0 = r7 instanceof com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
        r1 = 0;
        if (r0 == 0) goto L_0x0103;
    L_0x0005:
        r0 = r8 instanceof com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
        if (r0 == 0) goto L_0x0103;
    L_0x0009:
        r7 = (com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor) r7;
        r8 = (com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor) r8;
        r0 = r7.f15197c;
        r2 = r8.f15197c;
        if (r0 == r2) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r0 = r7.f15200f;
        r0 = r8.f15200f;
        r0 = r7.f15203i;
        r2 = r8.f15203i;
        if (r0 == r2) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r0 = r7.f15195a;
        r2 = r8.f15195a;
        if (r0 == r2) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r0 = r7.f15204j;
        r2 = r8.f15204j;
        if (r0 == r2) goto L_0x002d;
    L_0x002c:
        return r1;
    L_0x002d:
        r0 = r7.f15198d;
        r2 = r8.f15198d;
        if (r0 == r2) goto L_0x0034;
    L_0x0033:
        return r1;
    L_0x0034:
        r0 = r7.f15202h;
        r2 = r8.f15202h;
        if (r0 == r2) goto L_0x003b;
    L_0x003a:
        return r1;
    L_0x003b:
        r0 = r7.f15196b;
        r2 = r8.f15196b;
        if (r0 == r2) goto L_0x0042;
    L_0x0041:
        return r1;
    L_0x0042:
        r0 = r7.f15199e;
        r0 = r8.f15199e;
        r0 = r7.f15201g;
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r7.f15201g;
        r2 = r8.f15201g;
        r0.equals(r2);
        goto L_0x0054;
    L_0x0052:
        r0 = r8.f15201g;
    L_0x0054:
        r0 = r7.f15205k;
        if (r0 == 0) goto L_0x0063;
    L_0x0058:
        r0 = r7.f15205k;
        r2 = r8.f15205k;
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x00da;
    L_0x0062:
        goto L_0x0067;
    L_0x0063:
        r0 = r8.f15205k;
        if (r0 == 0) goto L_0x00da;
    L_0x0067:
        r0 = r7.f15205k;
        r2 = r8.f15205k;
        r3 = r0.f15190h;
        if (r3 == 0) goto L_0x007e;
    L_0x006f:
        r3 = r2.f15190h;
        if (r3 == 0) goto L_0x007e;
    L_0x0073:
        r3 = r0.f15190h;
        r4 = r2.f15190h;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x007e;
    L_0x007d:
        return r1;
    L_0x007e:
        r3 = r0.f15188f;
        r5 = r2.f15188f;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x0090;
    L_0x0086:
        r3 = r0.f15188f;
        r5 = r2.f15188f;
        r3 = r3 + r5;
        r5 = 2;
        r3 = r3 / r5;
        r0.f15188f = r3;
    L_0x0090:
        r3 = r0.f15186d;
        r3 = r2.f15186d;
        r3 = r0.f15189g;
        if (r3 == 0) goto L_0x00a3;
    L_0x0098:
        r3 = r0.f15189g;
        r4 = r2.f15189g;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00a8;
    L_0x00a2:
        goto L_0x00a7;
    L_0x00a3:
        r3 = r2.f15189g;
        if (r3 == 0) goto L_0x00a8;
    L_0x00a7:
        return r1;
    L_0x00a8:
        r3 = r0.f15187e;
        r5 = r2.f15187e;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x00ba;
    L_0x00b0:
        r3 = r0.f15187e;
        r5 = r2.f15187e;
        r3 = java.lang.Math.max(r3, r5);
        r0.f15187e = r3;
    L_0x00ba:
        r3 = r0.f15191i;
        r4 = r2.f15191i;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00c5;
    L_0x00c4:
        return r1;
    L_0x00c5:
        r3 = r0.f15183a;
        r4 = r2.f15183a;
        if (r3 == r4) goto L_0x00cc;
    L_0x00cb:
        return r1;
    L_0x00cc:
        r3 = r0.f15184b;
        r4 = r2.f15184b;
        if (r3 == r4) goto L_0x00d3;
    L_0x00d2:
        return r1;
    L_0x00d3:
        r0 = r0.f15185c;
        r2 = r2.f15185c;
        if (r0 == r2) goto L_0x00da;
    L_0x00d9:
        return r1;
    L_0x00da:
        r0 = r7.f15207m;
        if (r0 == 0) goto L_0x00e9;
    L_0x00de:
        r0 = r7.f15207m;
        r2 = r8.f15207m;
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x00ee;
    L_0x00e8:
        goto L_0x00ed;
    L_0x00e9:
        r0 = r8.f15207m;
        if (r0 == 0) goto L_0x00ee;
    L_0x00ed:
        return r1;
    L_0x00ee:
        r0 = r7.f15206l;
        if (r0 == 0) goto L_0x00fd;
    L_0x00f2:
        r0 = r7.f15206l;
        r8 = r8.f15206l;
        r8 = r0.equals(r8);
        if (r8 != 0) goto L_0x0102;
    L_0x00fc:
        goto L_0x0101;
    L_0x00fd:
        r8 = r8.f15206l;
        if (r8 == 0) goto L_0x0102;
    L_0x0101:
        return r1;
    L_0x0102:
        return r7;
    L_0x0103:
        r7 = f18494h;
        r8 = "I can only merge ESDescriptors";
        r7.mo2533c(r8);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.authoring.tracks.AppendTrack.a(com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor, com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor):com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor");
    }

    public final List<Sample> mo3623j() {
        return this.f18497f;
    }

    public final SampleDescriptionBox mo3625l() {
        return this.f18496e;
    }

    public final synchronized long[] mo3624k() {
        return this.f18498g;
    }

    public final List<Entry> mo2512a() {
        if (this.f18495d[0].mo2512a() == null || this.f18495d[0].mo2512a().isEmpty()) {
            return null;
        }
        List<int[]> linkedList = new LinkedList();
        for (Track a : this.f18495d) {
            linkedList.add(CompositionTimeToSample.blowupCompositionTimes(a.mo2512a()));
        }
        List linkedList2 = new LinkedList();
        for (int[] iArr : linkedList) {
            for (int i : (int[]) r6.next()) {
                if (!linkedList2.isEmpty()) {
                    if (((Entry) linkedList2.getLast()).getOffset() == i) {
                        Entry entry = (Entry) linkedList2.getLast();
                        entry.setCount(entry.getCount() + 1);
                    }
                }
                linkedList2.add(new Entry(1, i));
            }
        }
        return linkedList2;
    }

    public final long[] mo2513b() {
        if (this.f18495d[0].mo2513b() == null || this.f18495d[0].mo2513b().length <= 0) {
            return null;
        }
        Track[] trackArr = this.f18495d;
        int length = trackArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            Track track = trackArr[i];
            i2 += track.mo2513b() != null ? track.mo2513b().length : 0;
            i++;
        }
        long[] jArr = new long[i2];
        long j = 0;
        Track[] trackArr2 = this.f18495d;
        int length2 = trackArr2.length;
        int i3 = 0;
        i2 = i3;
        while (i3 < length2) {
            Track track2 = trackArr2[i3];
            if (track2.mo2513b() != null) {
                long[] b = track2.mo2513b();
                int length3 = b.length;
                int i4 = i2;
                i2 = 0;
                while (i2 < length3) {
                    int i5 = i4 + 1;
                    jArr[i4] = b[i2] + j;
                    i2++;
                    i4 = i5;
                }
                i2 = i4;
            }
            j += (long) track2.mo3623j().size();
            i3++;
        }
        return jArr;
    }

    public final List<SampleDependencyTypeBox.Entry> mo2514c() {
        int i = 0;
        if (this.f18495d[0].mo2514c() == null || this.f18495d[0].mo2514c().isEmpty()) {
            return null;
        }
        List<SampleDependencyTypeBox.Entry> linkedList = new LinkedList();
        Track[] trackArr = this.f18495d;
        int length = trackArr.length;
        while (i < length) {
            linkedList.addAll(trackArr[i].mo2514c());
            i++;
        }
        return linkedList;
    }

    public final TrackMetaData mo3626m() {
        return this.f18495d[0].mo3626m();
    }

    public final String mo3627n() {
        return this.f18495d[0].mo3627n();
    }

    public final SubSampleInformationBox mo2515d() {
        return this.f18495d[0].mo2515d();
    }
}
