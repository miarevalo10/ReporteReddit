package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TrackReferenceBox;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.IOException;
import java.util.List;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.demuxer.TimecodeMP4DemuxerTrack;

public class QTTimeUtil {
    public static long getEditedDuration(TrakBox trakBox) {
        List<Edit> edits = trakBox.getEdits();
        if (edits == null) {
            return trakBox.getDuration();
        }
        long j = 0;
        for (Edit duration : edits) {
            j += duration.getDuration();
        }
        return j;
    }

    public static long frameToTimevalue(TrakBox trakBox, int i) {
        trakBox = ((TimeToSampleBox) Box.findFirst(trakBox, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries();
        long j = 0;
        int i2 = 0;
        while (i >= trakBox[i2].getSampleCount()) {
            i -= trakBox[i2].getSampleCount();
            j += (long) (trakBox[i2].getSampleCount() * trakBox[i2].getSampleDuration());
            i2++;
        }
        return j + ((long) (trakBox[i2].getSampleDuration() * i));
    }

    public static int timevalueToFrame(TrakBox trakBox, long j) {
        trakBox = ((TimeToSampleBox) Box.findFirst(trakBox, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries();
        int i = 0;
        int i2 = 0;
        while (j > 0 && i < trakBox.length) {
            long sampleDuration = j / ((long) trakBox[i].getSampleDuration());
            j -= (long) (trakBox[i].getSampleCount() * trakBox[i].getSampleDuration());
            long j2 = (long) i2;
            if (j > 0) {
                sampleDuration = (long) trakBox[i].getSampleCount();
            }
            i2 = (int) (j2 + sampleDuration);
            i++;
        }
        return i2;
    }

    public static long mediaToEdited(TrakBox trakBox, long j, int i) {
        if (trakBox.getEdits() == null) {
            return j;
        }
        long j2 = 0;
        for (Edit edit : trakBox.getEdits()) {
            if (j >= edit.getMediaTime()) {
                long rescale = trakBox.rescale(edit.getDuration(), (long) i);
                if (edit.getMediaTime() != -1 && j >= edit.getMediaTime() && j < edit.getMediaTime() + rescale) {
                    j2 += j - edit.getMediaTime();
                    break;
                }
                j2 += rescale;
            } else {
                return j2;
            }
        }
        return j2;
    }

    public static long editedToMedia(TrakBox trakBox, long j, int i) {
        if (trakBox.getEdits() == null) {
            return j;
        }
        long j2 = 0;
        for (Edit edit : trakBox.getEdits()) {
            long rescale = trakBox.rescale(edit.getDuration(), (long) i) + j2;
            if (rescale > j) {
                return (edit.getMediaTime() + j) - j2;
            }
            j2 = rescale;
        }
        return j2;
    }

    public static int qtPlayerFrameNo(MovieBox movieBox, int i) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        return tv2QTFrameNo(movieBox, mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale()));
    }

    public static int tv2QTFrameNo(MovieBox movieBox, long j) {
        NodeBox videoTrack = movieBox.getVideoTrack();
        TrakBox timecodeTrack = movieBox.getTimecodeTrack();
        if (timecodeTrack == null || Box.findFirst(videoTrack, TrackReferenceBox.TYPE, TimeCodeBox.TYPE) == null) {
            return timevalueToFrame(videoTrack, j);
        }
        return timevalueToTimecodeFrame(timecodeTrack, new RationalLarge(j, (long) videoTrack.getTimescale()), movieBox.getTimescale());
    }

    public static String qtPlayerTime(MovieBox movieBox, int i) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        movieBox = (int) (mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale()) / ((long) videoTrack.getTimescale()));
        i = new StringBuilder();
        i.append(String.format("%02d", new Object[]{Integer.valueOf(movieBox / 3600)}));
        i.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        i.append(String.format("%02d", new Object[]{Integer.valueOf((movieBox % 3600) / 60)}));
        i.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        i.append(String.format("%02d", new Object[]{Integer.valueOf(movieBox % 60)}));
        return i.toString();
    }

    public static String qtPlayerTimecode(MovieBox movieBox, TimecodeMP4DemuxerTrack timecodeMP4DemuxerTrack, int i) throws IOException {
        TrakBox videoTrack = movieBox.getVideoTrack();
        long mediaToEdited = mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale());
        i = timecodeMP4DemuxerTrack.getBox();
        long timescale = (long) i.getTimescale();
        return formatTimecode(timecodeMP4DemuxerTrack.getBox(), timecodeMP4DemuxerTrack.getStartTimecode() + timevalueToTimecodeFrame(timecodeMP4DemuxerTrack.getBox(), new RationalLarge(editedToMedia(i, (mediaToEdited * timescale) / ((long) videoTrack.getTimescale()), movieBox.getTimescale()), timescale), movieBox.getTimescale()));
    }

    public static String qtPlayerTimecode(TimecodeMP4DemuxerTrack timecodeMP4DemuxerTrack, RationalLarge rationalLarge, int i) throws IOException {
        TrakBox box = timecodeMP4DemuxerTrack.getBox();
        long timescale = (long) box.getTimescale();
        return formatTimecode(timecodeMP4DemuxerTrack.getBox(), timecodeMP4DemuxerTrack.getStartTimecode() + timevalueToTimecodeFrame(timecodeMP4DemuxerTrack.getBox(), new RationalLarge(editedToMedia(box, rationalLarge.multiplyS(timescale), i), timescale), i));
    }

    public static int timevalueToTimecodeFrame(TrakBox trakBox, RationalLarge rationalLarge, int i) {
        TimecodeSampleEntry timecodeSampleEntry = (TimecodeSampleEntry) trakBox.getSampleEntries()[0];
        return ((int) (((2 * rationalLarge.multiplyS((long) timecodeSampleEntry.getTimescale())) / ((long) timecodeSampleEntry.getFrameDuration())) + 1)) / 2;
    }

    public static String formatTimecode(TrakBox trakBox, int i) {
        String format = String.format("%02d", new Object[]{Integer.valueOf(i % ((TimecodeSampleEntry) Box.findFirst(trakBox, TimecodeSampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, TimeCodeBox.TYPE)).getNumFrames())});
        i /= trakBox;
        trakBox = new StringBuilder();
        trakBox.append(String.format("%02d", new Object[]{Integer.valueOf(i % 60)}));
        trakBox.append(":");
        trakBox.append(format);
        trakBox = trakBox.toString();
        i /= 60;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%02d", new Object[]{Integer.valueOf(i % 60)}));
        stringBuilder.append(":");
        stringBuilder.append(trakBox);
        trakBox = stringBuilder.toString();
        i /= 60;
        stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%02d", new Object[]{Integer.valueOf(i)}));
        stringBuilder.append(":");
        stringBuilder.append(trakBox);
        return stringBuilder.toString();
    }
}
