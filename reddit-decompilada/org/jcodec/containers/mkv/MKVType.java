package org.jcodec.containers.mkv;

import com.facebook.stetho.dumpapp.Framer;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlDate;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlSint;
import org.jcodec.containers.mkv.boxes.EbmlString;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.EbmlVoid;
import org.jcodec.containers.mkv.boxes.MkvBlock;
import org.jcodec.containers.mkv.boxes.MkvSegment;
import org.jcodec.containers.mkv.util.EbmlUtil;
import org.jcodec.containers.mxf.model.BER;

public enum MKVType {
    Void(new byte[]{(byte) -20}, EbmlVoid.class),
    CRC32(new byte[]{(byte) -65}, EbmlBin.class),
    EBML(new byte[]{(byte) 26, (byte) 69, (byte) -33, (byte) -93}, EbmlMaster.class),
    EBMLVersion(new byte[]{(byte) 66, (byte) -122}),
    EBMLReadVersion(new byte[]{(byte) 66, (byte) -9}),
    EBMLMaxIDLength(new byte[]{(byte) 66, (byte) -14}),
    EBMLMaxSizeLength(new byte[]{(byte) 66, (byte) -13}),
    DocType(new byte[]{(byte) 66, (byte) -126}, EbmlString.class),
    DocTypeVersion(new byte[]{(byte) 66, (byte) -121}),
    DocTypeReadVersion(new byte[]{(byte) 66, (byte) -123}),
    Segment(new byte[]{(byte) 24, (byte) 83, BER.ASN_LONG_LEN, (byte) 103}, MkvSegment.class),
    SeekHead(new byte[]{(byte) 17, (byte) 77, (byte) -101, (byte) 116}, EbmlMaster.class),
    Seek(new byte[]{(byte) 77, (byte) -69}, EbmlMaster.class),
    SeekID(new byte[]{(byte) 83, (byte) -85}, EbmlBin.class),
    SeekPosition(new byte[]{(byte) 83, (byte) -84}),
    Info(new byte[]{(byte) 21, (byte) 73, (byte) -87, (byte) 102}, EbmlMaster.class),
    SegmentUID(new byte[]{(byte) 115, (byte) -92}, EbmlBin.class),
    SegmentFilename(new byte[]{(byte) 115, (byte) -124}, EbmlString.class),
    PrevUID(new byte[]{(byte) 60, (byte) -71, (byte) 35}, EbmlBin.class),
    PrevFilename(new byte[]{(byte) 60, (byte) -125, (byte) -85}, EbmlString.class),
    NextUID(new byte[]{(byte) 62, (byte) -71, (byte) 35}, EbmlBin.class),
    NextFilenam(new byte[]{(byte) 62, (byte) -125, (byte) -69}, EbmlString.class),
    SegmentFamily(new byte[]{(byte) 68, (byte) 68}, EbmlBin.class),
    ChapterTranslate(new byte[]{(byte) 105, (byte) 36}, EbmlMaster.class),
    ChapterTranslateEditionUID(new byte[]{(byte) 105, (byte) -4}),
    ChapterTranslateCodec(new byte[]{(byte) 105, (byte) -65}),
    ChapterTranslateID(new byte[]{(byte) 105, (byte) -91}, EbmlBin.class),
    TimecodeScale(new byte[]{(byte) 42, (byte) -41, (byte) -79}),
    Duration(new byte[]{(byte) 68, (byte) -119}, EbmlFloat.class),
    DateUTC(new byte[]{(byte) 68, (byte) 97}, EbmlDate.class),
    Title(new byte[]{(byte) 123, (byte) -87}, EbmlString.class),
    MuxingApp(new byte[]{(byte) 77, BER.ASN_LONG_LEN}, EbmlString.class),
    WritingApp(new byte[]{(byte) 87, (byte) 65}, EbmlString.class),
    Cluster(new byte[]{(byte) 31, (byte) 67, (byte) -74, (byte) 117}, EbmlMaster.class),
    Timecode(new byte[]{(byte) -25}),
    SilentTracks(new byte[]{(byte) 88, (byte) 84}, EbmlMaster.class),
    SilentTrackNumber(new byte[]{(byte) 88, (byte) -41}),
    Position(new byte[]{(byte) -89}),
    PrevSize(new byte[]{(byte) -85}),
    SimpleBlock(new byte[]{(byte) -93}, MkvBlock.class),
    BlockGroup(new byte[]{(byte) -96}, EbmlMaster.class),
    Block(new byte[]{(byte) -95}, MkvBlock.class),
    BlockAdditions(new byte[]{(byte) 117, (byte) -95}, EbmlMaster.class),
    BlockMore(new byte[]{(byte) -90}, EbmlMaster.class),
    BlockAddID(new byte[]{(byte) -18}),
    BlockAdditional(new byte[]{(byte) -91}, EbmlBin.class),
    BlockDuration(new byte[]{(byte) -101}),
    ReferencePriority(new byte[]{(byte) -6}),
    ReferenceBlock(new byte[]{(byte) -5}, EbmlSint.class),
    CodecState(new byte[]{(byte) -92}, EbmlBin.class),
    Slices(new byte[]{(byte) -114}, EbmlMaster.class),
    TimeSlice(new byte[]{(byte) -24}, EbmlMaster.class),
    LaceNumber(new byte[]{(byte) -52}),
    Tracks(new byte[]{(byte) 22, (byte) 84, (byte) -82, (byte) 107}, EbmlMaster.class),
    TrackEntry(new byte[]{(byte) -82}, EbmlMaster.class),
    TrackNumber(new byte[]{(byte) -41}),
    TrackUID(new byte[]{(byte) 115, (byte) -59}),
    TrackType(new byte[]{(byte) -125}),
    FlagEnabled(new byte[]{(byte) -71}),
    FlagDefault(new byte[]{(byte) -120}),
    FlagForced(new byte[]{(byte) 85, (byte) -86}),
    FlagLacing(new byte[]{(byte) -100}),
    MinCache(new byte[]{(byte) 109, (byte) -25}),
    MaxCache(new byte[]{(byte) 109, (byte) -8}),
    DefaultDuration(new byte[]{(byte) 35, (byte) -29, (byte) -125}),
    MaxBlockAdditionID(new byte[]{(byte) 85, (byte) -18}),
    Name(new byte[]{(byte) 83, (byte) 110}, EbmlString.class),
    Language(new byte[]{(byte) 34, (byte) -75, (byte) -100}, EbmlString.class),
    CodecID(new byte[]{(byte) -122}, EbmlString.class),
    CodecPrivate(new byte[]{(byte) 99, (byte) -94}, EbmlBin.class),
    CodecName(new byte[]{(byte) 37, (byte) -122, (byte) -120}, EbmlString.class),
    AttachmentLink(new byte[]{(byte) 116, (byte) 70}),
    CodecDecodeAll(new byte[]{(byte) -86}),
    TrackOverlay(new byte[]{(byte) 111, (byte) -85}),
    TrackTranslate(new byte[]{(byte) 102, (byte) 36}, EbmlMaster.class),
    TrackTranslateEditionUID(new byte[]{(byte) 102, (byte) -4}),
    TrackTranslateCodec(new byte[]{(byte) 102, (byte) -65}),
    TrackTranslateTrackID(new byte[]{(byte) 102, (byte) -91}, EbmlBin.class),
    Video(new byte[]{(byte) -32}, EbmlMaster.class),
    FlagInterlaced(new byte[]{(byte) -102}),
    StereoMode(new byte[]{(byte) 83, (byte) -72}),
    AlphaMode(new byte[]{(byte) 83, (byte) -64}),
    PixelWidth(new byte[]{(byte) -80}),
    PixelHeight(new byte[]{(byte) -70}),
    PixelCropBottom(new byte[]{(byte) 84, (byte) -86}),
    PixelCropTop(new byte[]{(byte) 84, (byte) -69}),
    PixelCropLeft(new byte[]{(byte) 84, (byte) -52}),
    PixelCropRight(new byte[]{(byte) 84, (byte) -35}),
    DisplayWidth(new byte[]{(byte) 84, (byte) -80}),
    DisplayHeight(new byte[]{(byte) 84, (byte) -70}),
    DisplayUnit(new byte[]{(byte) 84, (byte) -78}),
    AspectRatioType(new byte[]{(byte) 84, (byte) -77}),
    ColourSpace(new byte[]{(byte) 46, (byte) -75, (byte) 36}, EbmlBin.class),
    Audio(new byte[]{(byte) -31}, EbmlMaster.class),
    SamplingFrequency(new byte[]{(byte) -75}, EbmlFloat.class),
    OutputSamplingFrequency(new byte[]{Framer.EXIT_FRAME_PREFIX, (byte) -75}, EbmlFloat.class),
    Channels(new byte[]{(byte) -97}),
    BitDepth(new byte[]{(byte) 98, (byte) 100}),
    TrackOperation(new byte[]{(byte) -30}, EbmlMaster.class),
    TrackCombinePlanes(new byte[]{(byte) -29}, EbmlMaster.class),
    TrackPlane(new byte[]{(byte) -28}, EbmlMaster.class),
    TrackPlaneUID(new byte[]{(byte) -27}),
    TrackPlaneType(new byte[]{(byte) -26}),
    TrackJoinBlocks(new byte[]{(byte) -23}, EbmlMaster.class),
    TrackJoinUID(new byte[]{(byte) -19}),
    ContentEncodings(new byte[]{(byte) 109, BER.ASN_LONG_LEN}, EbmlMaster.class),
    ContentEncoding(new byte[]{(byte) 98, (byte) 64}, EbmlMaster.class),
    ContentEncodingOrder(new byte[]{(byte) 80, Framer.STDOUT_FRAME_PREFIX}),
    ContentEncodingScope(new byte[]{(byte) 80, Framer.STDERR_FRAME_PREFIX}),
    ContentEncodingType(new byte[]{(byte) 80, (byte) 51}),
    ContentCompression(new byte[]{(byte) 80, (byte) 52}, EbmlMaster.class),
    ContentCompAlgo(new byte[]{(byte) 66, (byte) 84}),
    ContentCompSettings(new byte[]{(byte) 66, (byte) 85}, EbmlBin.class),
    ContentEncryption(new byte[]{(byte) 80, (byte) 53}, EbmlMaster.class),
    ContentEncAlgo(new byte[]{(byte) 71, (byte) -31}),
    ContentEncKeyID(new byte[]{(byte) 71, (byte) -30}, EbmlBin.class),
    ContentSignature(new byte[]{(byte) 71, (byte) -29}, EbmlBin.class),
    ContentSigKeyID(new byte[]{(byte) 71, (byte) -28}, EbmlBin.class),
    ContentSigAlgo(new byte[]{(byte) 71, (byte) -27}),
    ContentSigHashAlgo(new byte[]{(byte) 71, (byte) -26}),
    Cues(new byte[]{(byte) 28, (byte) 83, (byte) -69, (byte) 107}, EbmlMaster.class),
    CuePoint(new byte[]{(byte) -69}, EbmlMaster.class),
    CueTime(new byte[]{(byte) -77}, EbmlUint.class),
    CueTrackPositions(new byte[]{(byte) -73}, EbmlMaster.class),
    CueTrack(new byte[]{(byte) -9}, EbmlUint.class),
    CueClusterPosition(new byte[]{(byte) -15}, EbmlUint.class),
    CueRelativePosition(new byte[]{(byte) -16}),
    CueDuration(new byte[]{(byte) -78}),
    CueBlockNumber(new byte[]{(byte) 83, Framer.EXIT_FRAME_PREFIX}),
    CueCodecState(new byte[]{(byte) -22}),
    CueReference(new byte[]{(byte) -37}, EbmlMaster.class),
    CueRefTime(new byte[]{(byte) -106}),
    Attachments(new byte[]{(byte) 25, (byte) 65, (byte) -92, (byte) 105}, EbmlMaster.class),
    AttachedFile(new byte[]{(byte) 97, (byte) -89}, EbmlMaster.class),
    FileDescription(new byte[]{(byte) 70, (byte) 126}, EbmlString.class),
    FileName(new byte[]{(byte) 70, (byte) 110}, EbmlString.class),
    FileMimeType(new byte[]{(byte) 70, (byte) 96}, EbmlString.class),
    FileData(new byte[]{(byte) 70, (byte) 92}, EbmlBin.class),
    FileUID(new byte[]{(byte) 70, (byte) -82}),
    Chapters(new byte[]{(byte) 16, (byte) 67, (byte) -89, (byte) 112}, EbmlMaster.class),
    EditionEntry(new byte[]{(byte) 69, (byte) -71}, EbmlMaster.class),
    EditionUID(new byte[]{(byte) 69, (byte) -68}),
    EditionFlagHidden(new byte[]{(byte) 69, (byte) -67}),
    EditionFlagDefault(new byte[]{(byte) 69, (byte) -37}),
    EditionFlagOrdered(new byte[]{(byte) 69, (byte) -35}),
    ChapterAtom(new byte[]{(byte) -74}, EbmlMaster.class),
    ChapterUID(new byte[]{(byte) 115, (byte) -60}),
    ChapterStringUID(new byte[]{(byte) 86, (byte) 84}, EbmlString.class),
    ChapterTimeStart(new byte[]{(byte) -111}),
    ChapterTimeEnd(new byte[]{(byte) -110}),
    ChapterFlagHidden(new byte[]{(byte) -104}),
    ChapterFlagEnabled(new byte[]{(byte) 69, (byte) -104}),
    ChapterSegmentUID(new byte[]{(byte) 110, (byte) 103}, EbmlBin.class),
    ChapterSegmentEditionUID(new byte[]{(byte) 110, (byte) -68}),
    ChapterPhysicalEquiv(new byte[]{(byte) 99, (byte) -61}),
    ChapterTrack(new byte[]{(byte) -113}, EbmlMaster.class),
    ChapterTrackNumber(new byte[]{(byte) -119}),
    ChapterDisplay(new byte[]{BER.ASN_LONG_LEN}, EbmlMaster.class),
    ChapString(new byte[]{(byte) -123}, EbmlString.class),
    ChapLanguage(new byte[]{(byte) 67, (byte) 124}, EbmlString.class),
    ChapCountry(new byte[]{(byte) 67, (byte) 126}, EbmlString.class),
    ChapProcess(new byte[]{(byte) 105, (byte) 68}, EbmlMaster.class),
    ChapProcessCodecID(new byte[]{(byte) 105, (byte) 85}),
    ChapProcessPrivate(new byte[]{(byte) 69, (byte) 13}, EbmlBin.class),
    ChapProcessCommand(new byte[]{(byte) 105, (byte) 17}, EbmlMaster.class),
    ChapProcessTime(new byte[]{(byte) 105, (byte) 34}),
    ChapProcessData(new byte[]{(byte) 105, (byte) 51}, EbmlBin.class),
    Tags(new byte[]{(byte) 18, (byte) 84, (byte) -61, (byte) 103}, EbmlMaster.class),
    Tag(new byte[]{(byte) 115, (byte) 115}, EbmlMaster.class),
    Targets(new byte[]{(byte) 99, (byte) -64}, EbmlMaster.class),
    TargetTypeValue(new byte[]{(byte) 104, (byte) -54}),
    TargetType(new byte[]{(byte) 99, (byte) -54}, EbmlString.class),
    TagTrackUID(new byte[]{(byte) 99, (byte) -59}),
    TagEditionUID(new byte[]{(byte) 99, (byte) -55}),
    TagChapterUID(new byte[]{(byte) 99, (byte) -60}),
    TagAttachmentUID(new byte[]{(byte) 99, (byte) -58}),
    SimpleTag(new byte[]{(byte) 103, (byte) -56}, EbmlMaster.class),
    TagName(new byte[]{(byte) 69, (byte) -93}, EbmlString.class),
    TagLanguage(new byte[]{(byte) 68, (byte) 122}, EbmlString.class),
    TagDefault(new byte[]{(byte) 68, (byte) -124}),
    TagString(new byte[]{(byte) 68, (byte) -121}, EbmlString.class),
    TagBinary(new byte[]{(byte) 68, (byte) -123}, EbmlBin.class);
    
    public static final Map<MKVType, Set<MKVType>> children = null;
    public static MKVType[] firstLevelHeaders;
    public final Class<? extends EbmlBase> clazz;
    public final byte[] id;

    static {
        firstLevelHeaders = new MKVType[]{SeekHead, Info, Cluster, Tracks, Cues, Attachments, Chapters, Tags, EBMLVersion, EBMLReadVersion, EBMLMaxIDLength, EBMLMaxSizeLength, DocType, DocTypeVersion, DocTypeReadVersion};
        Map hashMap = new HashMap();
        children = hashMap;
        hashMap.put(EBML, new HashSet(Arrays.asList(new MKVType[]{EBMLVersion, EBMLReadVersion, EBMLMaxIDLength, EBMLMaxSizeLength, DocType, DocTypeVersion, DocTypeReadVersion})));
        children.put(Segment, new HashSet(Arrays.asList(new MKVType[]{SeekHead, Info, Cluster, Tracks, Cues, Attachments, Chapters, Tags})));
        children.put(SeekHead, new HashSet(Arrays.asList(new MKVType[]{Seek})));
        children.put(Seek, new HashSet(Arrays.asList(new MKVType[]{SeekID, SeekPosition})));
        children.put(Info, new HashSet(Arrays.asList(new MKVType[]{SegmentUID, SegmentFilename, PrevUID, PrevFilename, NextUID, NextFilenam, SegmentFamily, ChapterTranslate, TimecodeScale, Duration, DateUTC, Title, MuxingApp, WritingApp})));
        children.put(ChapterTranslate, new HashSet(Arrays.asList(new MKVType[]{ChapterTranslateEditionUID, ChapterTranslateCodec, ChapterTranslateID})));
        children.put(Cluster, new HashSet(Arrays.asList(new MKVType[]{Timecode, SilentTracks, Position, PrevSize, SimpleBlock, BlockGroup})));
        children.put(SilentTracks, new HashSet(Arrays.asList(new MKVType[]{SilentTrackNumber})));
        children.put(BlockGroup, new HashSet(Arrays.asList(new MKVType[]{Block, BlockAdditions, BlockDuration, ReferencePriority, ReferenceBlock, CodecState, Slices})));
        children.put(BlockAdditions, new HashSet(Arrays.asList(new MKVType[]{BlockMore})));
        children.put(BlockMore, new HashSet(Arrays.asList(new MKVType[]{BlockAddID, BlockAdditional})));
        children.put(Slices, new HashSet(Arrays.asList(new MKVType[]{TimeSlice})));
        children.put(TimeSlice, new HashSet(Arrays.asList(new MKVType[]{LaceNumber})));
        children.put(Tracks, new HashSet(Arrays.asList(new MKVType[]{TrackEntry})));
        children.put(TrackEntry, new HashSet(Arrays.asList(new MKVType[]{TrackNumber, TrackUID, TrackType, TrackType, FlagDefault, FlagForced, FlagLacing, MinCache, MaxCache, DefaultDuration, MaxBlockAdditionID, Name, Language, CodecID, CodecPrivate, CodecName, AttachmentLink, CodecDecodeAll, TrackOverlay, TrackTranslate, Video, Audio, TrackOperation, ContentEncodings})));
        children.put(TrackTranslate, new HashSet(Arrays.asList(new MKVType[]{TrackTranslateEditionUID, TrackTranslateCodec, TrackTranslateTrackID})));
        children.put(Video, new HashSet(Arrays.asList(new MKVType[]{FlagInterlaced, StereoMode, AlphaMode, PixelWidth, PixelHeight, PixelCropBottom, PixelCropTop, PixelCropLeft, PixelCropRight, DisplayWidth, DisplayHeight, DisplayUnit, AspectRatioType, ColourSpace})));
        children.put(Audio, new HashSet(Arrays.asList(new MKVType[]{SamplingFrequency, OutputSamplingFrequency, Channels, BitDepth})));
        children.put(TrackOperation, new HashSet(Arrays.asList(new MKVType[]{TrackCombinePlanes, TrackJoinBlocks})));
        children.put(TrackCombinePlanes, new HashSet(Arrays.asList(new MKVType[]{TrackPlane})));
        children.put(TrackPlane, new HashSet(Arrays.asList(new MKVType[]{TrackPlaneUID, TrackPlaneType})));
        children.put(TrackJoinBlocks, new HashSet(Arrays.asList(new MKVType[]{TrackJoinUID})));
        children.put(ContentEncodings, new HashSet(Arrays.asList(new MKVType[]{ContentEncoding})));
        children.put(ContentEncoding, new HashSet(Arrays.asList(new MKVType[]{ContentEncodingOrder, ContentEncodingScope, ContentEncodingType, ContentCompression, ContentEncryption})));
        children.put(ContentCompression, new HashSet(Arrays.asList(new MKVType[]{ContentCompAlgo, ContentCompSettings})));
        children.put(ContentEncryption, new HashSet(Arrays.asList(new MKVType[]{ContentEncAlgo, ContentEncKeyID, ContentSignature, ContentSigKeyID, ContentSigAlgo, ContentSigHashAlgo})));
        children.put(Cues, new HashSet(Arrays.asList(new MKVType[]{CuePoint})));
        children.put(CuePoint, new HashSet(Arrays.asList(new MKVType[]{CueTime, CueTrackPositions})));
        children.put(CueTrackPositions, new HashSet(Arrays.asList(new MKVType[]{CueTrack, CueClusterPosition, CueRelativePosition, CueDuration, CueBlockNumber, CueCodecState, CueReference})));
        children.put(CueReference, new HashSet(Arrays.asList(new MKVType[]{CueRefTime})));
        children.put(Attachments, new HashSet(Arrays.asList(new MKVType[]{AttachedFile})));
        children.put(AttachedFile, new HashSet(Arrays.asList(new MKVType[]{FileDescription, FileName, FileMimeType, FileData, FileUID})));
        children.put(Chapters, new HashSet(Arrays.asList(new MKVType[]{EditionEntry})));
        children.put(EditionEntry, new HashSet(Arrays.asList(new MKVType[]{EditionUID, EditionFlagHidden, EditionFlagDefault, EditionFlagOrdered, ChapterAtom})));
        children.put(ChapterAtom, new HashSet(Arrays.asList(new MKVType[]{ChapterUID, ChapterStringUID, ChapterTimeStart, ChapterTimeEnd, ChapterFlagHidden, ChapterFlagEnabled, ChapterSegmentUID, ChapterSegmentEditionUID, ChapterPhysicalEquiv, ChapterTrack, ChapterDisplay, ChapProcess})));
        children.put(ChapterTrack, new HashSet(Arrays.asList(new MKVType[]{ChapterTrackNumber})));
        children.put(ChapterDisplay, new HashSet(Arrays.asList(new MKVType[]{ChapString, ChapLanguage, ChapCountry})));
        children.put(ChapProcess, new HashSet(Arrays.asList(new MKVType[]{ChapProcessCodecID, ChapProcessPrivate, ChapProcessCommand})));
        children.put(ChapProcessCommand, new HashSet(Arrays.asList(new MKVType[]{ChapProcessTime, ChapProcessData})));
        children.put(Tags, new HashSet(Arrays.asList(new MKVType[]{Tag})));
        children.put(Tag, new HashSet(Arrays.asList(new MKVType[]{Targets, SimpleTag})));
        children.put(Targets, new HashSet(Arrays.asList(new MKVType[]{TargetTypeValue, TargetType, TagTrackUID, TagEditionUID, TagChapterUID, TagAttachmentUID})));
        children.put(SimpleTag, new HashSet(Arrays.asList(new MKVType[]{TagName, TagLanguage, TagDefault, TagString, TagBinary})));
    }

    private MKVType(byte[] bArr) {
        this.id = bArr;
        this.clazz = EbmlUint.class;
    }

    private MKVType(byte[] bArr, Class<? extends EbmlBase> cls) {
        this.id = bArr;
        this.clazz = cls;
    }

    public static <T extends EbmlBase> T createByType(MKVType mKVType) {
        try {
            T create = create(mKVType.clazz, mKVType.id);
            create.type = mKVType;
            return create;
        } catch (SecurityException e) {
            e.printStackTrace();
            return new EbmlBin(mKVType.id);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return new EbmlBin(mKVType.id);
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return new EbmlBin(mKVType.id);
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return new EbmlBin(mKVType.id);
        } catch (InstantiationException e5) {
            e5.printStackTrace();
            return new EbmlBin(mKVType.id);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return new EbmlBin(mKVType.id);
        }
    }

    private static <T extends EbmlBase> T create(Class<T> cls, byte[] bArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (EbmlBase) cls.getConstructor(new Class[]{byte[].class}).newInstance(new Object[]{bArr});
    }

    public static <T extends EbmlBase> T createById(byte[] bArr, long j) {
        for (MKVType mKVType : values()) {
            if (Arrays.equals(mKVType.id, bArr)) {
                return createByType(mKVType);
            }
        }
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder("WARNING: unspecified ebml ID (");
        stringBuilder.append(EbmlUtil.toHexString(bArr));
        stringBuilder.append(") encountered at position 0x");
        stringBuilder.append(Long.toHexString(j).toUpperCase());
        printStream.println(stringBuilder.toString());
        j = new EbmlVoid(bArr);
        j.type = Void;
        return j;
    }

    public static boolean isHeaderFirstByte(byte b) {
        for (MKVType mKVType : values()) {
            if (mKVType.id[0] == b) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecifiedHeader(byte[] bArr) {
        for (MKVType mKVType : values()) {
            if (Arrays.equals(mKVType.id, bArr)) {
                return 1;
            }
        }
        return false;
    }

    public static boolean isFirstLevelHeader(byte[] bArr) {
        for (MKVType mKVType : firstLevelHeaders) {
            if (Arrays.equals(mKVType.id, bArr)) {
                return 1;
            }
        }
        return false;
    }

    public static MKVType getParent(MKVType mKVType) {
        for (Entry entry : children.entrySet()) {
            if (((Set) entry.getValue()).contains(mKVType)) {
                return (MKVType) entry.getKey();
            }
        }
        return null;
    }

    public static boolean possibleChild(EbmlMaster ebmlMaster, EbmlBase ebmlBase) {
        if (ebmlMaster == null) {
            if (ebmlBase.type != EBML) {
                if (ebmlBase.type != Segment) {
                    return false;
                }
            }
            return true;
        }
        if (!Arrays.equals(ebmlBase.id, Void.id)) {
            if (!Arrays.equals(ebmlBase.id, CRC32.id)) {
                if (ebmlBase.type != Void) {
                    if (ebmlBase.type != CRC32) {
                        Set set = (Set) children.get(ebmlMaster.type);
                        return (set == null || set.contains(ebmlBase.type) == null) ? false : true;
                    }
                }
                return true;
            }
        }
        return ebmlBase.offset != ebmlMaster.dataOffset + ((long) ebmlMaster.dataLen);
    }

    public static boolean possibleChild(EbmlMaster ebmlMaster, byte[] bArr) {
        if (ebmlMaster == null && (Arrays.equals(EBML.id, bArr) || Arrays.equals(Segment.id, bArr))) {
            return true;
        }
        if (ebmlMaster == null) {
            return false;
        }
        if (!Arrays.equals(Void.id, bArr)) {
            if (!Arrays.equals(CRC32.id, bArr)) {
                for (MKVType mKVType : (Set) children.get(ebmlMaster.type)) {
                    if (Arrays.equals(mKVType.id, bArr)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static EbmlBase findFirst(EbmlBase ebmlBase, MKVType... mKVTypeArr) {
        return findFirstSub(ebmlBase, new LinkedList(Arrays.asList(mKVTypeArr)));
    }

    public static <T> T findFirst(List<? extends EbmlBase> list, MKVType... mKVTypeArr) {
        List linkedList = new LinkedList(Arrays.asList(mKVTypeArr));
        for (EbmlBase findFirstSub : list) {
            mKVTypeArr = findFirstSub(findFirstSub, linkedList);
            if (mKVTypeArr != null) {
                return mKVTypeArr;
            }
        }
        return null;
    }

    private static EbmlBase findFirstSub(EbmlBase ebmlBase, List<MKVType> list) {
        EbmlBase ebmlBase2 = null;
        if (list.size() == 0 || !ebmlBase.type.equals(list.get(0))) {
            return null;
        }
        if (list.size() == 1) {
            return ebmlBase;
        }
        MKVType mKVType = (MKVType) list.remove(0);
        if (ebmlBase instanceof EbmlMaster) {
            ebmlBase = ((EbmlMaster) ebmlBase).children.iterator();
            while (ebmlBase.hasNext() && r1 == null) {
                ebmlBase2 = findFirstSub((EbmlBase) ebmlBase.next(), list);
            }
        }
        list.add(0, mKVType);
        return ebmlBase2;
    }

    public static <T> List<T> findList(List<? extends EbmlBase> list, Class<T> cls, MKVType... mKVTypeArr) {
        cls = new LinkedList();
        List linkedList = new LinkedList(Arrays.asList(mKVTypeArr));
        if (linkedList.size() > null) {
            for (EbmlBase ebmlBase : list) {
                MKVType mKVType = (MKVType) linkedList.remove(0);
                if (mKVType == null || mKVType.equals(ebmlBase.type)) {
                    findSubList(ebmlBase, linkedList, cls);
                }
                linkedList.add(0, mKVType);
            }
        }
        return cls;
    }

    private static <T> void findSubList(EbmlBase ebmlBase, List<MKVType> list, Collection<T> collection) {
        if (list.size() > 0) {
            MKVType mKVType = (MKVType) list.remove(0);
            if (ebmlBase instanceof EbmlMaster) {
                ebmlBase = ((EbmlMaster) ebmlBase).children.iterator();
                while (ebmlBase.hasNext()) {
                    EbmlBase ebmlBase2 = (EbmlBase) ebmlBase.next();
                    if (mKVType == null || mKVType.equals(ebmlBase2.type)) {
                        findSubList(ebmlBase2, list, collection);
                    }
                }
            }
            list.add(0, mKVType);
            return;
        }
        collection.add(ebmlBase);
    }

    public static <T> T[] findAll(List<? extends EbmlBase> list, Class<T> cls, MKVType... mKVTypeArr) {
        Object linkedList = new LinkedList();
        List linkedList2 = new LinkedList(Arrays.asList(mKVTypeArr));
        if (linkedList2.size() > null) {
            for (EbmlBase ebmlBase : list) {
                MKVType mKVType = (MKVType) linkedList2.remove(0);
                if (mKVType == null || mKVType.equals(ebmlBase.type)) {
                    findSub(ebmlBase, linkedList2, linkedList);
                }
                linkedList2.add(0, mKVType);
            }
        }
        return linkedList.toArray((Object[]) Array.newInstance(cls, 0));
    }

    public static <T> T[] findAll(EbmlBase ebmlBase, Class<T> cls, MKVType... mKVTypeArr) {
        Object linkedList = new LinkedList();
        List linkedList2 = new LinkedList(Arrays.asList(mKVTypeArr));
        if (ebmlBase.type.equals(linkedList2.get(0)) == null) {
            return linkedList.toArray((Object[]) Array.newInstance(cls, 0));
        }
        linkedList2.remove(0);
        findSub(ebmlBase, linkedList2, linkedList);
        return linkedList.toArray((Object[]) Array.newInstance(cls, 0));
    }

    private static void findSub(EbmlBase ebmlBase, List<MKVType> list, Collection<EbmlBase> collection) {
        if (list.size() > 0) {
            MKVType mKVType = (MKVType) list.remove(0);
            if (ebmlBase instanceof EbmlMaster) {
                ebmlBase = ((EbmlMaster) ebmlBase).children.iterator();
                while (ebmlBase.hasNext()) {
                    EbmlBase ebmlBase2 = (EbmlBase) ebmlBase.next();
                    if (mKVType == null || mKVType.equals(ebmlBase2.type)) {
                        findSub(ebmlBase2, list, collection);
                    }
                }
            }
            list.add(0, mKVType);
            return;
        }
        collection.add(ebmlBase);
    }
}
