package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzzv
public final class zzajp {
    private static Map<String, List<Map<String, Object>>> f6463a = new HashMap();
    private static List<MediaCodecInfo> f6464b;
    private static final Object f6465c = new Object();

    @TargetApi(16)
    public static List<Map<String, Object>> m5310a(String str) {
        synchronized (f6465c) {
            if (f6463a.containsKey(str)) {
                return (List) f6463a.get(str);
            }
            List arrayList;
            try {
                synchronized (f6465c) {
                    if (f6464b == null) {
                        List asList;
                        if (VERSION.SDK_INT >= 21) {
                            asList = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else if (VERSION.SDK_INT >= 16) {
                            int codecCount = MediaCodecList.getCodecCount();
                            f6464b = new ArrayList(codecCount);
                            for (int i = 0; i < codecCount; i++) {
                                f6464b.add(MediaCodecList.getCodecInfoAt(i));
                            }
                        } else {
                            asList = Collections.emptyList();
                        }
                        f6464b = asList;
                    }
                }
                arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : f6464b) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        Map hashMap = new HashMap();
                        hashMap.put("codecName", mediaCodecInfo.getName());
                        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        hashMap.put("profileLevels", arrayList2);
                        if (VERSION.SDK_INT >= 21) {
                            VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            hashMap.put("bitRatesBps", m5311a(videoCapabilities.getBitrateRange()));
                            hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                            hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                            hashMap.put("frameRates", m5311a(videoCapabilities.getSupportedFrameRates()));
                            hashMap.put("widths", m5311a(videoCapabilities.getSupportedWidths()));
                            hashMap.put("heights", m5311a(videoCapabilities.getSupportedHeights()));
                        }
                        if (VERSION.SDK_INT >= 23) {
                            hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        }
                        arrayList.add(hashMap);
                    }
                }
                f6463a.put(str, arrayList);
                return arrayList;
            } catch (RuntimeException e) {
                Map hashMap2 = new HashMap();
                hashMap2.put("error", e.getClass().getSimpleName());
                arrayList = new ArrayList();
                arrayList.add(hashMap2);
                f6463a.put(str, arrayList);
                return arrayList;
            }
        }
    }

    @TargetApi(21)
    private static Integer[] m5311a(Range<Integer> range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
