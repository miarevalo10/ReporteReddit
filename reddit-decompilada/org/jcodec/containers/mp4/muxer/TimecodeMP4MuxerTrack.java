package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.movtool.Util;

public class TimecodeMP4MuxerTrack extends FramesMP4MuxerTrack {
    private TapeTimecode firstTimecode;
    private int fpsEstimate;
    private List<Packet> gop = new ArrayList();
    private List<Edit> lower = new ArrayList();
    private TapeTimecode prevTimecode;
    private long sampleDuration;
    private long samplePts;
    private int tcFrames;

    class C22091 implements Comparator<Packet> {
        final /* synthetic */ TimecodeMP4MuxerTrack f26815a;

        C22091(TimecodeMP4MuxerTrack timecodeMP4MuxerTrack) {
            this.f26815a = timecodeMP4MuxerTrack;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            Packet packet = (Packet) obj;
            Packet packet2 = (Packet) obj2;
            if (packet == null && packet2 == null) {
                return 0;
            }
            if (packet != null) {
                if (packet2 == null || packet.getDisplayOrder() > packet2.getDisplayOrder()) {
                    return 1;
                }
                if (packet.getDisplayOrder() == packet2.getDisplayOrder()) {
                    return 0;
                }
            }
            return -1;
        }
    }

    public TimecodeMP4MuxerTrack(SeekableByteChannel seekableByteChannel, int i, int i2) {
        super(seekableByteChannel, i, TrackType.TIMECODE, i2);
    }

    public void addTimecode(Packet packet) throws IOException {
        if (packet.isKeyFrame()) {
            processGop();
        }
        this.gop.add(new Packet(packet, null));
    }

    private void processGop() throws IOException {
        if (this.gop.size() > 0) {
            for (Packet addTimecodeInt : sortByDisplay(this.gop)) {
                addTimecodeInt(addTimecodeInt);
            }
            this.gop.clear();
        }
    }

    private List<Packet> sortByDisplay(List<Packet> list) {
        List<Packet> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C22091(this));
        return arrayList;
    }

    protected Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        processGop();
        outTimecodeSample();
        if (this.sampleEntries.size() == 0) {
            return null;
        }
        if (this.edits != null) {
            this.edits = Util.editsOnEdits(new Rational(1, 1), this.lower, this.edits);
        } else {
            this.edits = this.lower;
        }
        return super.finish(movieHeaderBox);
    }

    private void addTimecodeInt(Packet packet) throws IOException {
        TapeTimecode tapeTimecode = packet.getTapeTimecode();
        boolean isGap = isGap(this.prevTimecode, tapeTimecode);
        this.prevTimecode = tapeTimecode;
        if (isGap) {
            outTimecodeSample();
            this.firstTimecode = tapeTimecode;
            this.fpsEstimate = tapeTimecode.isDropFrame() ? 30 : -1;
            this.samplePts += this.sampleDuration;
            this.sampleDuration = 0;
            this.tcFrames = 0;
        }
        this.sampleDuration += packet.getDuration();
        this.tcFrames++;
    }

    private boolean isGap(TapeTimecode tapeTimecode, TapeTimecode tapeTimecode2) {
        if (tapeTimecode == null && tapeTimecode2 != null) {
            return true;
        }
        if (tapeTimecode == null) {
            return false;
        }
        if (tapeTimecode2 == null) {
            return true;
        }
        if (tapeTimecode.isDropFrame() != tapeTimecode2.isDropFrame()) {
            return true;
        }
        return isTimeGap(tapeTimecode, tapeTimecode2);
    }

    private boolean isTimeGap(TapeTimecode tapeTimecode, TapeTimecode tapeTimecode2) {
        int toSec = toSec(tapeTimecode2);
        int toSec2 = toSec - toSec(tapeTimecode);
        if (toSec2 == 0) {
            tapeTimecode2 = tapeTimecode2.getFrame() - tapeTimecode.getFrame();
            if (this.fpsEstimate != -1) {
                tapeTimecode2 = (tapeTimecode2 + this.fpsEstimate) % this.fpsEstimate;
            }
            if (tapeTimecode2 == 1) {
                return false;
            }
        } else if (toSec2 == 1) {
            if (this.fpsEstimate != -1) {
                boolean z = (tapeTimecode2.isDropFrame() && toSec % 60 == 0 && toSec % 600 != 0) ? true : false;
                if (tapeTimecode2.getFrame() == z && tapeTimecode.getFrame() == this.fpsEstimate - 1) {
                    return false;
                }
            } else if (tapeTimecode2.getFrame() == null) {
                this.fpsEstimate = tapeTimecode.getFrame() + 1;
                return false;
            }
        }
        return true;
    }

    private void outTimecodeSample() throws IOException {
        if (this.sampleDuration > 0) {
            if (r0.firstTimecode != null) {
                if (r0.fpsEstimate == -1) {
                    r0.fpsEstimate = r0.prevTimecode.getFrame() + 1;
                }
                r0.sampleEntries.add(new TimecodeSampleEntry(r0.firstTimecode.isDropFrame(), r0.timescale, (int) (r0.sampleDuration / ((long) r0.tcFrames)), r0.fpsEstimate));
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(toCounter(r0.firstTimecode, r0.fpsEstimate));
                allocate.flip();
                addFrame(new MP4Packet(allocate, r0.samplePts, (long) r0.timescale, r0.sampleDuration, 0, true, null, r0.samplePts, r0.sampleEntries.size() - 1));
                r0.lower.add(new Edit(r0.sampleDuration, r0.samplePts, 1.0f));
                return;
            }
            r0.lower.add(new Edit(r0.sampleDuration, -1, 1.0f));
        }
    }

    private int toCounter(TapeTimecode tapeTimecode, int i) {
        int toSec = (toSec(tapeTimecode) * i) + tapeTimecode.getFrame();
        return tapeTimecode.isDropFrame() != null ? (int) (((long) toSec) - ((18 * ((long) (toSec / 18000))) + (2 * ((((long) (toSec % 18000)) - 2) / 1800)))) : toSec;
    }

    private int toSec(TapeTimecode tapeTimecode) {
        return ((tapeTimecode.getHour() * 3600) + (tapeTimecode.getMinute() * 60)) + tapeTimecode.getSecond();
    }
}
