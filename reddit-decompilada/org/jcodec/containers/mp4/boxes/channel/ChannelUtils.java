package org.jcodec.containers.mp4.boxes.channel;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChannelBox;
import org.jcodec.containers.mp4.boxes.ChannelBox.ChannelDescription;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class ChannelUtils {
    private static final Label[] EMPTY = new Label[0];
    private static final List<Label> MATRIX_STEREO = Arrays.asList(new Label[]{Label.LeftTotal, Label.RightTotal});
    private static final List<Label> MONO = Arrays.asList(new Label[]{Label.Mono});
    private static final List<Label> STEREO = Arrays.asList(new Label[]{Label.Left, Label.Right});

    public static Label[] getLabels(AudioSampleEntry audioSampleEntry) {
        ChannelBox channelBox = (ChannelBox) Box.findFirst(audioSampleEntry, ChannelBox.class, "chan");
        if (channelBox != null) {
            return getLabels(channelBox);
        }
        audioSampleEntry = audioSampleEntry.getChannelCount();
        switch (audioSampleEntry) {
            case 1:
                return new Label[]{Label.Mono};
            case 2:
                return new Label[]{Label.Left, Label.Right};
            case 3:
                return new Label[]{Label.Left, Label.Right, Label.Center};
            case 4:
                return new Label[]{Label.Left, Label.Right, Label.LeftSurround, Label.RightSurround};
            case 5:
                return new Label[]{Label.Left, Label.Right, Label.Center, Label.LeftSurround, Label.RightSurround};
            case 6:
                return new Label[]{Label.Left, Label.Right, Label.Center, Label.LFEScreen, Label.LeftSurround, Label.RightSurround};
            default:
                audioSampleEntry = new Label[audioSampleEntry];
                Arrays.fill(audioSampleEntry, Label.Mono);
                return audioSampleEntry;
        }
    }

    public static Label[] getLabels(TrakBox trakBox) {
        return getLabels((AudioSampleEntry) trakBox.getSampleEntries()[0]);
    }

    public static void setLabel(TrakBox trakBox, int i, Label label) {
        Label[] labels = getLabels(trakBox);
        labels[i] = label;
        setLabels(trakBox, labels);
    }

    private static void setLabels(TrakBox trakBox, Label[] labelArr) {
        ChannelBox channelBox = (ChannelBox) Box.findFirst(trakBox, ChannelBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null, "chan");
        if (channelBox == null) {
            channelBox = new ChannelBox();
            ((SampleEntry) Box.findFirst(trakBox, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null)).add(channelBox);
        }
        setLabels(labelArr, channelBox);
    }

    public static void setLabels(Label[] labelArr, ChannelBox channelBox) {
        channelBox.setChannelLayout(ChannelLayout.kCAFChannelLayoutTag_UseChannelDescriptions.getCode());
        ChannelDescription[] channelDescriptionArr = new ChannelDescription[labelArr.length];
        for (int i = 0; i < labelArr.length; i++) {
            channelDescriptionArr[i] = new ChannelDescription(labelArr[i].getVal(), 0, new float[]{0.0f, 0.0f, 0.0f});
        }
        channelBox.setDescriptions(channelDescriptionArr);
    }

    public static Label[] getLabels(ChannelBox channelBox) {
        long channelLayout = (long) channelBox.getChannelLayout();
        if ((channelLayout >> 16) == 147) {
            channelBox = ((int) channelLayout) & 65535;
            Label[] labelArr = new Label[channelBox];
            for (int i = 0; i < channelBox; i++) {
                labelArr[i] = Label.getByVal(65536 | i);
            }
            return labelArr;
        }
        Iterator it = EnumSet.allOf(ChannelLayout.class).iterator();
        while (it.hasNext()) {
            ChannelLayout channelLayout2 = (ChannelLayout) it.next();
            if (((long) channelLayout2.getCode()) == channelLayout) {
                switch (channelLayout2) {
                    case kCAFChannelLayoutTag_UseChannelDescriptions:
                        return extractLabels(channelBox.getDescriptions());
                    case kCAFChannelLayoutTag_UseChannelBitmap:
                        return getLabelsByBitmap((long) channelBox.getChannelBitmap());
                    default:
                        return channelLayout2.getLabels();
                }
            }
        }
        return EMPTY;
    }

    private static Label[] extractLabels(ChannelDescription[] channelDescriptionArr) {
        Label[] labelArr = new Label[channelDescriptionArr.length];
        for (int i = 0; i < channelDescriptionArr.length; i++) {
            labelArr[i] = channelDescriptionArr[i].getLabel();
        }
        return labelArr;
    }

    public static Label[] getLabelsByBitmap(long j) {
        List arrayList = new ArrayList();
        for (Label label : Label.values()) {
            if ((label.bitmapVal & j) != 0) {
                arrayList.add(label);
            }
        }
        return (Label[]) arrayList.toArray(new Label[0]);
    }
}
