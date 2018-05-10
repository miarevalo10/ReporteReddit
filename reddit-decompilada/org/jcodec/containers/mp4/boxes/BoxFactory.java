package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.coremedia.iso.boxes.ItemProtectionBox;
import com.coremedia.iso.boxes.MetaBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TrackReferenceBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderAtom;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import java.util.HashMap;
import java.util.Map;

public class BoxFactory {
    private static BoxFactory instance = new BoxFactory();
    private Map<String, Class<? extends Box>> mappings = new HashMap();

    public static BoxFactory getDefault() {
        return instance;
    }

    public BoxFactory() {
        this.mappings.put(MovieExtendsBox.fourcc(), MovieExtendsBox.class);
        this.mappings.put(MovieExtendsHeaderBox.fourcc(), MovieExtendsHeaderBox.class);
        this.mappings.put(SegmentIndexBox.fourcc(), SegmentIndexBox.class);
        this.mappings.put(SegmentTypeBox.fourcc(), SegmentTypeBox.class);
        this.mappings.put(TrackExtendsBox.fourcc(), TrackExtendsBox.class);
        this.mappings.put(VideoMediaHeaderBox.fourcc(), VideoMediaHeaderBox.class);
        this.mappings.put(FileTypeBox.fourcc(), FileTypeBox.class);
        this.mappings.put(MovieBox.fourcc(), MovieBox.class);
        this.mappings.put(MovieHeaderBox.fourcc(), MovieHeaderBox.class);
        this.mappings.put(TrakBox.fourcc(), TrakBox.class);
        this.mappings.put(TrackHeaderBox.fourcc(), TrackHeaderBox.class);
        this.mappings.put(EditBox.TYPE, NodeBox.class);
        this.mappings.put(EditListBox.fourcc(), EditListBox.class);
        this.mappings.put(MediaBox.fourcc(), MediaBox.class);
        this.mappings.put(MediaHeaderBox.fourcc(), MediaHeaderBox.class);
        this.mappings.put(MediaInfoBox.fourcc(), MediaInfoBox.class);
        this.mappings.put(HandlerBox.fourcc(), HandlerBox.class);
        this.mappings.put(DataInfoBox.fourcc(), DataInfoBox.class);
        this.mappings.put(SampleTableBox.TYPE, NodeBox.class);
        this.mappings.put(SampleDescriptionBox.fourcc(), SampleDescriptionBox.class);
        this.mappings.put(TimeToSampleBox.fourcc(), TimeToSampleBox.class);
        this.mappings.put(SyncSamplesBox.fourcc(), SyncSamplesBox.class);
        this.mappings.put(PartialSyncSamplesBox.fourcc(), PartialSyncSamplesBox.class);
        this.mappings.put(SampleToChunkBox.fourcc(), SampleToChunkBox.class);
        this.mappings.put(SampleSizesBox.fourcc(), SampleSizesBox.class);
        this.mappings.put(ChunkOffsetsBox.fourcc(), ChunkOffsetsBox.class);
        this.mappings.put(MovieExtendsBox.TYPE, NodeBox.class);
        this.mappings.put(MovieFragmentBox.TYPE, NodeBox.class);
        this.mappings.put(TrackFragmentBox.TYPE, NodeBox.class);
        this.mappings.put(MovieFragmentRandomAccessBox.TYPE, NodeBox.class);
        this.mappings.put(FreeSpaceBox.TYPE, NodeBox.class);
        this.mappings.put(MetaBox.TYPE, LeafBox.class);
        this.mappings.put(DataRefBox.fourcc(), DataRefBox.class);
        this.mappings.put(ItemProtectionBox.TYPE, NodeBox.class);
        this.mappings.put(ProtectionSchemeInformationBox.TYPE, NodeBox.class);
        this.mappings.put(ChunkOffsets64Box.fourcc(), ChunkOffsets64Box.class);
        this.mappings.put(SoundMediaHeaderBox.fourcc(), SoundMediaHeaderBox.class);
        this.mappings.put("clip", NodeBox.class);
        this.mappings.put(ClipRegionBox.fourcc(), ClipRegionBox.class);
        this.mappings.put(LoadSettingsBox.fourcc(), LoadSettingsBox.class);
        this.mappings.put(TrackApertureModeDimensionAtom.TYPE, NodeBox.class);
        this.mappings.put(GenericMediaHeaderAtom.TYPE, NodeBox.class);
        this.mappings.put(TimeCodeBox.TYPE, LeafBox.class);
        this.mappings.put(TrackReferenceBox.TYPE, NodeBox.class);
        this.mappings.put(ClearApertureBox.fourcc(), ClearApertureBox.class);
        this.mappings.put(ProductionApertureBox.fourcc(), ProductionApertureBox.class);
        this.mappings.put(EncodedPixelBox.fourcc(), EncodedPixelBox.class);
        this.mappings.put(GenericMediaInfoBox.fourcc(), GenericMediaInfoBox.class);
        this.mappings.put(TimecodeMediaInfoBox.fourcc(), TimecodeMediaInfoBox.class);
        this.mappings.put(UserDataBox.TYPE, NodeBox.class);
        this.mappings.put(CompositionOffsetsBox.fourcc(), CompositionOffsetsBox.class);
        this.mappings.put(NameBox.fourcc(), NameBox.class);
        this.mappings.put(MovieFragmentHeaderBox.fourcc(), MovieFragmentHeaderBox.class);
        this.mappings.put(TrackFragmentHeaderBox.fourcc(), TrackFragmentHeaderBox.class);
        this.mappings.put(MovieFragmentBox.fourcc(), MovieFragmentBox.class);
        this.mappings.put(TrackFragmentBox.fourcc(), TrackFragmentBox.class);
        this.mappings.put(TrackFragmentBaseMediaDecodeTimeBox.fourcc(), TrackFragmentBaseMediaDecodeTimeBox.class);
        this.mappings.put(TrunBox.fourcc(), TrunBox.class);
    }

    public void override(String str, Class<? extends Box> cls) {
        this.mappings.put(str, cls);
    }

    public void clear() {
        this.mappings.clear();
    }

    public Class<? extends Box> toClass(String str) {
        return (Class) this.mappings.get(str);
    }
}
