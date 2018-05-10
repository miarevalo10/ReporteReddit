package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import java.util.List;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;

public class TrakBox extends NodeBox {
    public static String fourcc() {
        return TrackBox.TYPE;
    }

    protected void getModelFields(List<String> list) {
    }

    public TrakBox(Header header) {
        super(header);
    }

    public TrakBox() {
        super(new Header(fourcc()));
    }

    public void setDataRef(String str) {
        MediaInfoBox minf = getMdia().getMinf();
        DataInfoBox dinf = minf.getDinf();
        if (dinf == null) {
            dinf = new DataInfoBox();
            minf.add(dinf);
        }
        DataRefBox dref = dinf.getDref();
        Box urlBox = new UrlBox(str);
        if (dref == null) {
            str = new DataRefBox();
            dinf.add(str);
            str.add(urlBox);
            return;
        }
        str = dref.boxes.listIterator();
        while (str.hasNext()) {
            if ((((FullBox) str.next()).getFlags() & 1) != 0) {
                str.set(urlBox);
            }
        }
    }

    public MediaBox getMdia() {
        return (MediaBox) Box.findFirst(this, MediaBox.class, MediaBox.TYPE);
    }

    public TrackHeaderBox getTrackHeader() {
        return (TrackHeaderBox) Box.findFirst(this, TrackHeaderBox.class, TrackHeaderBox.TYPE);
    }

    public List<Edit> getEdits() {
        EditListBox editListBox = (EditListBox) Box.findFirst(this, EditListBox.class, EditBox.TYPE, EditListBox.TYPE);
        if (editListBox == null) {
            return null;
        }
        return editListBox.getEdits();
    }

    public void setEdits(List<Edit> list) {
        NodeBox nodeBox = (NodeBox) Box.findFirst(this, NodeBox.class, EditBox.TYPE);
        if (nodeBox == null) {
            nodeBox = new NodeBox(new Header(EditBox.TYPE));
            add(nodeBox);
        }
        nodeBox.removeChildren(EditListBox.TYPE);
        nodeBox.add(new EditListBox((List) list));
        getTrackHeader().setDuration(QTTimeUtil.getEditedDuration(this));
    }

    public boolean isVideo() {
        return "vide".equals(getHandlerType());
    }

    public boolean isTimecode() {
        return TimeCodeBox.TYPE.equals(getHandlerType());
    }

    public String getHandlerType() {
        HandlerBox handlerBox = (HandlerBox) Box.findFirst(this, HandlerBox.class, MediaBox.TYPE, HandlerBox.TYPE);
        if (handlerBox == null) {
            return null;
        }
        return handlerBox.getComponentSubType();
    }

    public boolean isAudio() {
        return "soun".equals(getHandlerType());
    }

    public int getTimescale() {
        return ((MediaHeaderBox) Box.findFirst(this, MediaHeaderBox.class, MediaBox.TYPE, MediaHeaderBox.TYPE)).getTimescale();
    }

    public long rescale(long j, long j2) {
        return (j * ((long) getTimescale())) / j2;
    }

    public void setDuration(long j) {
        getTrackHeader().setDuration(j);
    }

    public long getDuration() {
        return getTrackHeader().getDuration();
    }

    public long getMediaDuration() {
        return ((MediaHeaderBox) Box.findFirst(this, MediaHeaderBox.class, MediaBox.TYPE, MediaHeaderBox.TYPE)).getDuration();
    }

    public boolean isPureRef() {
        DataInfoBox dinf = getMdia().getMinf().getDinf();
        if (dinf == null) {
            return false;
        }
        DataRefBox dref = dinf.getDref();
        if (dref == null) {
            return false;
        }
        for (Box box : dref.boxes) {
            if ((((FullBox) box).getFlags() & 1) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean hasDataRef() {
        DataInfoBox dinf = getMdia().getMinf().getDinf();
        if (dinf == null) {
            return false;
        }
        DataRefBox dref = dinf.getDref();
        if (dref == null) {
            return false;
        }
        boolean z = false;
        for (Box box : dref.boxes) {
            int i = 1;
            if ((((FullBox) box).getFlags() & 1) == 1) {
                i = 0;
            }
            z |= i;
        }
        return z;
    }

    public Rational getPAR() {
        PixelAspectExt pixelAspectExt = (PixelAspectExt) Box.findFirst(this, PixelAspectExt.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null, PixelAspectRationAtom.TYPE);
        return pixelAspectExt == null ? new Rational(1, 1) : pixelAspectExt.getRational();
    }

    public void setPAR(Rational rational) {
        for (SampleEntry sampleEntry : getSampleEntries()) {
            sampleEntry.removeChildren(PixelAspectRationAtom.TYPE);
            sampleEntry.add(new PixelAspectExt(rational));
        }
    }

    public SampleEntry[] getSampleEntries() {
        return (SampleEntry[]) Box.findAll(this, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null);
    }

    public void setClipRect(short s, short s2, short s3, short s4) {
        NodeBox nodeBox = (NodeBox) Box.findFirst(this, NodeBox.class, "clip");
        if (nodeBox == null) {
            nodeBox = new NodeBox(new Header("clip"));
            add(nodeBox);
        }
        nodeBox.replace("crgn", new ClipRegionBox(s, s2, s3, s4));
    }

    public long getSampleCount() {
        return (long) ((SampleSizesBox) Box.findFirst(this, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE)).getCount();
    }

    public void setAperture(Size size, Size size2) {
        removeChildren(TrackApertureModeDimensionAtom.TYPE);
        Box nodeBox = new NodeBox(new Header(TrackApertureModeDimensionAtom.TYPE));
        nodeBox.add(new ClearApertureBox(size2.getWidth(), size2.getHeight()));
        nodeBox.add(new ProductionApertureBox(size2.getWidth(), size2.getHeight()));
        nodeBox.add(new EncodedPixelBox(size.getWidth(), size.getHeight()));
        add(nodeBox);
    }

    public void setDimensions(Size size) {
        getTrackHeader().setWidth((float) size.getWidth());
        getTrackHeader().setHeight((float) size.getHeight());
    }

    public int getFrameCount() {
        SampleSizesBox sampleSizesBox = (SampleSizesBox) Box.findFirst(this, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE);
        return sampleSizesBox.getDefaultSize() != 0 ? sampleSizesBox.getCount() : sampleSizesBox.getSizes().length;
    }

    public String getName() {
        NameBox nameBox = (NameBox) Box.findFirst(this, NameBox.class, UserDataBox.TYPE, "name");
        if (nameBox == null) {
            return null;
        }
        return nameBox.getName();
    }

    public void fixMediaTimescale(int i) {
        MediaHeaderBox mediaHeaderBox = (MediaHeaderBox) Box.findFirst(this, MediaHeaderBox.class, MediaBox.TYPE, MediaHeaderBox.TYPE);
        int timescale = mediaHeaderBox.getTimescale();
        mediaHeaderBox.setTimescale(i);
        long j = (long) i;
        long j2 = (long) timescale;
        mediaHeaderBox.setDuration((mediaHeaderBox.getDuration() * j) / j2);
        List<Edit> edits = getEdits();
        if (edits != null) {
            for (Edit edit : edits) {
                edit.setMediaTime((edit.getMediaTime() * j) / j2);
            }
        }
        for (TimeToSampleEntry timeToSampleEntry : ((TimeToSampleBox) Box.findFirst(this, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, TimeToSampleBox.TYPE)).getEntries()) {
            timeToSampleEntry.setSampleDuration((timeToSampleEntry.getSampleDuration() * i) / timescale);
        }
    }

    public void setName(String str) {
        NodeBox nodeBox = (NodeBox) Box.findFirst(this, NodeBox.class, UserDataBox.TYPE);
        if (nodeBox == null) {
            nodeBox = new NodeBox(new Header(UserDataBox.TYPE));
            add(nodeBox);
        }
        nodeBox.removeChildren("name");
        nodeBox.add(new NameBox(str));
    }

    public Size getCodedSize() {
        SampleEntry sampleEntry = getSampleEntries()[0];
        if (sampleEntry instanceof VideoSampleEntry) {
            VideoSampleEntry videoSampleEntry = (VideoSampleEntry) sampleEntry;
            return new Size(videoSampleEntry.getWidth(), videoSampleEntry.getHeight());
        }
        throw new IllegalArgumentException("Not a video track");
    }
}
