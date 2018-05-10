package com.google.android.exoplayer2.extractor.mp4;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MetaBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SchemeInformationBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.apple.AppleItemListBox;
import com.coremedia.iso.boxes.apple.AppleWaveBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.HevcConfigurationBox;
import com.mp4parser.iso14496.part30.WebVTTSampleEntry;
import com.mp4parser.iso14496.part30.XMLSubtitleSampleEntry;
import com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import com.mp4parser.iso23009.part1.EventMessageBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Atom {
    public static final int f4324A = Util.m4326g(SegmentIndexBox.TYPE);
    public static final int f4325B = Util.m4326g(MovieBox.TYPE);
    public static final int f4326C = Util.m4326g(MovieHeaderBox.TYPE);
    public static final int f4327D = Util.m4326g(TrackBox.TYPE);
    public static final int f4328E = Util.m4326g(MediaBox.TYPE);
    public static final int f4329F = Util.m4326g(MediaInformationBox.TYPE);
    public static final int f4330G = Util.m4326g(SampleTableBox.TYPE);
    public static final int f4331H = Util.m4326g(AvcConfigurationBox.TYPE);
    public static final int f4332I = Util.m4326g(HevcConfigurationBox.TYPE);
    public static final int f4333J = Util.m4326g(ESDescriptorBox.TYPE);
    public static final int f4334K = Util.m4326g(MovieFragmentBox.TYPE);
    public static final int f4335L = Util.m4326g(TrackFragmentBox.TYPE);
    public static final int f4336M = Util.m4326g(MovieExtendsBox.TYPE);
    public static final int f4337N = Util.m4326g(MovieExtendsHeaderBox.TYPE);
    public static final int f4338O = Util.m4326g(TrackHeaderBox.TYPE);
    public static final int f4339P = Util.m4326g(EditBox.TYPE);
    public static final int f4340Q = Util.m4326g(EditListBox.TYPE);
    public static final int f4341R = Util.m4326g(MediaHeaderBox.TYPE);
    public static final int f4342S = Util.m4326g(HandlerBox.TYPE);
    public static final int f4343T = Util.m4326g(SampleDescriptionBox.TYPE);
    public static final int f4344U = Util.m4326g(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int f4345V = Util.m4326g(ProtectionSchemeInformationBox.TYPE);
    public static final int f4346W = Util.m4326g(SchemeTypeBox.TYPE);
    public static final int f4347X = Util.m4326g(SchemeInformationBox.TYPE);
    public static final int f4348Y = Util.m4326g(TrackEncryptionBox.TYPE);
    public static final int f4349Z = Util.m4326g(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int f4350a = Util.m4326g(FileTypeBox.TYPE);
    public static final int aA = Util.m4326g(UserDataBox.TYPE);
    public static final int aB = Util.m4326g(MetaBox.TYPE);
    public static final int aC = Util.m4326g(AppleItemListBox.TYPE);
    public static final int aD = Util.m4326g("mean");
    public static final int aE = Util.m4326g("name");
    public static final int aF = Util.m4326g("data");
    public static final int aG = Util.m4326g(EventMessageBox.TYPE);
    public static final int aH = Util.m4326g("st3d");
    public static final int aI = Util.m4326g("sv3d");
    public static final int aJ = Util.m4326g("proj");
    public static final int aK = Util.m4326g("vp08");
    public static final int aL = Util.m4326g("vp09");
    public static final int aM = Util.m4326g("vpcC");
    public static final int aN = Util.m4326g("camm");
    public static final int aO = Util.m4326g("alac");
    public static final int aa = Util.m4326g(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int ab = Util.m4326g(OriginalFormatBox.TYPE);
    public static final int ac = Util.m4326g(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int ad = Util.m4326g(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int ae = Util.m4326g(SampleToGroupBox.TYPE);
    public static final int af = Util.m4326g(SampleGroupDescriptionBox.TYPE);
    public static final int ag = Util.m4326g("uuid");
    public static final int ah = Util.m4326g(SampleEncryptionBox.TYPE);
    public static final int ai = Util.m4326g(PixelAspectRationAtom.TYPE);
    public static final int aj = Util.m4326g("TTML");
    public static final int ak = Util.m4326g(VideoMediaHeaderBox.TYPE);
    public static final int al = Util.m4326g(VisualSampleEntry.TYPE1);
    public static final int am = Util.m4326g(TimeToSampleBox.TYPE);
    public static final int an = Util.m4326g(SyncSampleBox.TYPE);
    public static final int ao = Util.m4326g(CompositionTimeToSample.TYPE);
    public static final int ap = Util.m4326g(SampleToChunkBox.TYPE);
    public static final int aq = Util.m4326g(SampleSizeBox.TYPE);
    public static final int ar = Util.m4326g("stz2");
    public static final int as = Util.m4326g(StaticChunkOffsetBox.TYPE);
    public static final int at = Util.m4326g(ChunkOffset64BitBox.TYPE);
    public static final int au = Util.m4326g(TextSampleEntry.TYPE1);
    public static final int av = Util.m4326g(WebVTTSampleEntry.TYPE);
    public static final int aw = Util.m4326g(XMLSubtitleSampleEntry.TYPE);
    public static final int ax = Util.m4326g("c608");
    public static final int ay = Util.m4326g(AudioSampleEntry.TYPE1);
    public static final int az = Util.m4326g(AudioSampleEntry.TYPE2);
    public static final int f4351b = Util.m4326g(VisualSampleEntry.TYPE3);
    public static final int f4352c = Util.m4326g(VisualSampleEntry.TYPE4);
    public static final int f4353d = Util.m4326g(VisualSampleEntry.TYPE6);
    public static final int f4354e = Util.m4326g(VisualSampleEntry.TYPE7);
    public static final int f4355f = Util.m4326g(VisualSampleEntry.TYPE2);
    public static final int f4356g = Util.m4326g("d263");
    public static final int f4357h = Util.m4326g(MediaDataBox.TYPE);
    public static final int f4358i = Util.m4326g(AudioSampleEntry.TYPE3);
    public static final int f4359j = Util.m4326g(".mp3");
    public static final int f4360k = Util.m4326g(AppleWaveBox.TYPE);
    public static final int f4361l = Util.m4326g("lpcm");
    public static final int f4362m = Util.m4326g("sowt");
    public static final int f4363n = Util.m4326g(AudioSampleEntry.TYPE8);
    public static final int f4364o = Util.m4326g(AC3SpecificBox.TYPE);
    public static final int f4365p = Util.m4326g(AudioSampleEntry.TYPE9);
    public static final int f4366q = Util.m4326g(EC3SpecificBox.TYPE);
    public static final int f4367r = Util.m4326g("dtsc");
    public static final int f4368s = Util.m4326g(AudioSampleEntry.TYPE12);
    public static final int f4369t = Util.m4326g(AudioSampleEntry.TYPE11);
    public static final int f4370u = Util.m4326g(AudioSampleEntry.TYPE13);
    public static final int f4371v = Util.m4326g(DTSSpecificBox.TYPE);
    public static final int f4372w = Util.m4326g(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int f4373x = Util.m4326g(TrackFragmentHeaderBox.TYPE);
    public static final int f4374y = Util.m4326g(TrackExtendsBox.TYPE);
    public static final int f4375z = Util.m4326g(TrackRunBox.TYPE);
    public final int aP;

    static final class ContainerAtom extends Atom {
        public final long aQ;
        public final List<LeafAtom> aR = new ArrayList();
        public final List<ContainerAtom> aS = new ArrayList();

        public ContainerAtom(int i, long j) {
            super(i);
            this.aQ = j;
        }

        public final void m12081a(LeafAtom leafAtom) {
            this.aR.add(leafAtom);
        }

        public final void m12080a(ContainerAtom containerAtom) {
            this.aS.add(containerAtom);
        }

        public final LeafAtom m12082d(int i) {
            int size = this.aR.size();
            for (int i2 = 0; i2 < size; i2++) {
                LeafAtom leafAtom = (LeafAtom) this.aR.get(i2);
                if (leafAtom.aP == i) {
                    return leafAtom;
                }
            }
            return 0;
        }

        public final ContainerAtom m12083e(int i) {
            int size = this.aS.size();
            for (int i2 = 0; i2 < size; i2++) {
                ContainerAtom containerAtom = (ContainerAtom) this.aS.get(i2);
                if (containerAtom.aP == i) {
                    return containerAtom;
                }
            }
            return 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Atom.m3789c(this.aP));
            stringBuilder.append(" leaves: ");
            stringBuilder.append(Arrays.toString(this.aR.toArray()));
            stringBuilder.append(" containers: ");
            stringBuilder.append(Arrays.toString(this.aS.toArray()));
            return stringBuilder.toString();
        }
    }

    static final class LeafAtom extends Atom {
        public final ParsableByteArray aQ;

        public LeafAtom(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.aQ = parsableByteArray;
        }
    }

    public static int m3787a(int i) {
        return (i >> 24) & 255;
    }

    public static int m3788b(int i) {
        return i & 16777215;
    }

    public Atom(int i) {
        this.aP = i;
    }

    public String toString() {
        return m3789c(this.aP);
    }

    public static String m3789c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) ((i >> 24) & 255));
        stringBuilder.append((char) ((i >> 16) & 255));
        stringBuilder.append((char) ((i >> 8) & 255));
        stringBuilder.append((char) (i & 255));
        return stringBuilder.toString();
    }
}
