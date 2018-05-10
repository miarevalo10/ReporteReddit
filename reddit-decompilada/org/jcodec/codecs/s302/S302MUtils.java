package org.jcodec.codecs.s302;

import org.jcodec.common.model.ChannelLabel;

public class S302MUtils {
    public static String name(int i) {
        if (i == 4) {
            return "Surround 4.0";
        }
        if (i == 8) {
            return "Stereo 2.0 + Surround 5.1";
        }
        switch (i) {
            case 1:
                return "Mono";
            case 2:
                return "Stereo 2.0";
            default:
                return null;
        }
    }

    public static ChannelLabel[] labels(int i) {
        if (i == 4) {
            return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
        } else if (i != 8) {
            switch (i) {
                case 1:
                    return new ChannelLabel[]{ChannelLabel.MONO};
                case 2:
                    return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
                default:
                    return 0;
            }
        } else {
            return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE};
        }
    }
}
