package org.jcodec.movtool;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import java.io.File;
import java.util.Arrays;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ClipRegionBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class Paste {
    long[] tv;

    public static void main(String[] strArr) throws Exception {
        SeekableByteChannel writableFileChannel;
        SeekableByteChannel writableFileChannel2;
        SeekableByteChannel seekableByteChannel;
        if (strArr.length < 2) {
            System.out.println("Syntax: paste <to movie> <from movie> [second]");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        try {
            File parentFile = file.getParentFile();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getName().replaceAll("\\.mov$", ""));
            stringBuilder.append(".paste.mov");
            File file2 = new File(parentFile, stringBuilder.toString());
            file2.delete();
            writableFileChannel = NIOUtils.writableFileChannel(file2);
            try {
                writableFileChannel2 = NIOUtils.writableFileChannel(file);
            } catch (Throwable th) {
                strArr = th;
                writableFileChannel2 = null;
                seekableByteChannel = writableFileChannel2;
                if (writableFileChannel2 != null) {
                    writableFileChannel2.close();
                }
                if (seekableByteChannel != null) {
                    seekableByteChannel.close();
                }
                if (writableFileChannel != null) {
                    writableFileChannel.close();
                }
                throw strArr;
            }
            try {
                File file3 = new File(strArr[1]);
                seekableByteChannel = NIOUtils.readableFileChannel(file3);
                try {
                    StringBuilder stringBuilder2 = new StringBuilder("file://");
                    stringBuilder2.append(file.getCanonicalPath());
                    MovieBox createRefMovie = MP4Util.createRefMovie(writableFileChannel2, stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("file://");
                    stringBuilder2.append(file3.getCanonicalPath());
                    MovieBox createRefMovie2 = MP4Util.createRefMovie(seekableByteChannel, stringBuilder2.toString());
                    new Strip().strip(createRefMovie2);
                    if (strArr.length > 2) {
                        new Paste().paste(createRefMovie, createRefMovie2, Double.parseDouble(strArr[2]));
                    } else {
                        new Paste().addToMovie(createRefMovie, createRefMovie2);
                    }
                    MP4Util.writeMovie(writableFileChannel, createRefMovie);
                    if (writableFileChannel2 != null) {
                        writableFileChannel2.close();
                    }
                    if (seekableByteChannel != null) {
                        seekableByteChannel.close();
                    }
                    if (writableFileChannel != null) {
                        writableFileChannel.close();
                    }
                } catch (Throwable th2) {
                    strArr = th2;
                    if (writableFileChannel2 != null) {
                        writableFileChannel2.close();
                    }
                    if (seekableByteChannel != null) {
                        seekableByteChannel.close();
                    }
                    if (writableFileChannel != null) {
                        writableFileChannel.close();
                    }
                    throw strArr;
                }
            } catch (Throwable th3) {
                strArr = th3;
                seekableByteChannel = null;
                if (writableFileChannel2 != null) {
                    writableFileChannel2.close();
                }
                if (seekableByteChannel != null) {
                    seekableByteChannel.close();
                }
                if (writableFileChannel != null) {
                    writableFileChannel.close();
                }
                throw strArr;
            }
        } catch (Throwable th4) {
            strArr = th4;
            writableFileChannel = null;
            writableFileChannel2 = writableFileChannel;
            seekableByteChannel = writableFileChannel2;
            if (writableFileChannel2 != null) {
                writableFileChannel2.close();
            }
            if (seekableByteChannel != null) {
                seekableByteChannel.close();
            }
            if (writableFileChannel != null) {
                writableFileChannel.close();
            }
            throw strArr;
        }
    }

    public void paste(MovieBox movieBox, MovieBox movieBox2, double d) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        if (!(videoTrack == null || videoTrack.getTimescale() == movieBox.getTimescale())) {
            movieBox.fixTimescale(videoTrack.getTimescale());
        }
        long timescale = (long) (((double) movieBox.getTimescale()) * d);
        Util.forceEditList(movieBox);
        Util.forceEditList(movieBox2);
        TrakBox[] tracks = movieBox2.getTracks();
        TrakBox[] tracks2 = movieBox.getTracks();
        int[][] findMatches = findMatches(tracks, tracks2);
        for (int i = 0; i < findMatches[0].length; i++) {
            TrakBox importTrack = movieBox.importTrack(movieBox2, tracks[i]);
            if (findMatches[0][i] != -1) {
                Util.insertTo(movieBox, tracks2[findMatches[0][i]], importTrack, timescale);
            } else {
                movieBox.appendTrack(importTrack);
                Util.shift(movieBox, importTrack, timescale);
            }
        }
        for (int i2 = 0; i2 < findMatches[1].length; i2++) {
            if (findMatches[1][i2] == -1) {
                Util.spread(movieBox, tracks2[i2], timescale, movieBox.rescale(movieBox2.getDuration(), (long) movieBox2.getTimescale()));
            }
        }
        movieBox.updateDuration();
    }

    public void addToMovie(MovieBox movieBox, MovieBox movieBox2) {
        for (TrakBox importTrack : movieBox2.getTracks()) {
            movieBox.appendTrack(movieBox.importTrack(movieBox2, importTrack));
        }
    }

    private long getFrameTv(TrakBox trakBox, int i) {
        if (this.tv == null) {
            this.tv = Util.getTimevalues(trakBox);
        }
        return this.tv[i];
    }

    private int[][] findMatches(TrakBox[] trakBoxArr, TrakBox[] trakBoxArr2) {
        int[] iArr = new int[trakBoxArr.length];
        int[] iArr2 = new int[trakBoxArr2.length];
        Arrays.fill(iArr, -1);
        Arrays.fill(iArr2, -1);
        int i = 0;
        while (i < trakBoxArr.length) {
            if (iArr[i] == -1) {
                int i2 = 0;
                while (i2 < trakBoxArr2.length) {
                    if (iArr2[i2] == -1 && matches(trakBoxArr[i], trakBoxArr2[i2])) {
                        iArr[i] = i2;
                        iArr2[i2] = i;
                        break;
                    }
                    i2++;
                }
            }
            i++;
        }
        return new int[][]{iArr, iArr2};
    }

    private boolean matches(TrakBox trakBox, TrakBox trakBox2) {
        return (trakBox.getHandlerType().equals(trakBox2.getHandlerType()) && matchHeaders(trakBox, trakBox2) && matchSampleSizes(trakBox, trakBox2) && matchMediaHeader(trakBox, trakBox2) && matchClip(trakBox, trakBox2) && matchLoad(trakBox, trakBox2) != null) ? true : null;
    }

    private boolean matchSampleSizes(TrakBox trakBox, TrakBox trakBox2) {
        return ((SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE)).getDefaultSize() == ((SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE)).getDefaultSize() ? true : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean matchMediaHeader(org.jcodec.containers.mp4.boxes.TrakBox r7, org.jcodec.containers.mp4.boxes.TrakBox r8) {
        /*
        r6 = this;
        r0 = org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox.class;
        r1 = "mdia";
        r2 = "minf";
        r3 = "vmhd";
        r1 = new java.lang.String[]{r1, r2, r3};
        r0 = org.jcodec.containers.mp4.boxes.Box.findFirst(r7, r0, r1);
        r0 = (org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox) r0;
        r1 = org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox.class;
        r2 = "mdia";
        r3 = "minf";
        r4 = "vmhd";
        r2 = new java.lang.String[]{r2, r3, r4};
        r1 = org.jcodec.containers.mp4.boxes.Box.findFirst(r8, r1, r2);
        r1 = (org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox) r1;
        r2 = 0;
        if (r0 == 0) goto L_0x002b;
    L_0x0029:
        if (r1 == 0) goto L_0x002f;
    L_0x002b:
        if (r0 != 0) goto L_0x0030;
    L_0x002d:
        if (r1 == 0) goto L_0x0030;
    L_0x002f:
        return r2;
    L_0x0030:
        r3 = 1;
        if (r0 == 0) goto L_0x005f;
    L_0x0033:
        if (r1 == 0) goto L_0x005f;
    L_0x0035:
        r7 = r0.getGraphicsMode();
        r8 = r1.getGraphicsMode();
        if (r7 != r8) goto L_0x005e;
    L_0x003f:
        r7 = r0.getbOpColor();
        r8 = r1.getbOpColor();
        if (r7 != r8) goto L_0x005e;
    L_0x0049:
        r7 = r0.getgOpColor();
        r8 = r1.getgOpColor();
        if (r7 != r8) goto L_0x005e;
    L_0x0053:
        r7 = r0.getrOpColor();
        r8 = r1.getrOpColor();
        if (r7 != r8) goto L_0x005e;
    L_0x005d:
        return r3;
    L_0x005e:
        return r2;
    L_0x005f:
        r0 = org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox.class;
        r1 = "mdia";
        r4 = "minf";
        r5 = "smhd";
        r1 = new java.lang.String[]{r1, r4, r5};
        r7 = org.jcodec.containers.mp4.boxes.Box.findFirst(r7, r0, r1);
        r7 = (org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox) r7;
        r0 = org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox.class;
        r1 = "mdia";
        r4 = "minf";
        r5 = "smhd";
        r1 = new java.lang.String[]{r1, r4, r5};
        r8 = org.jcodec.containers.mp4.boxes.Box.findFirst(r8, r0, r1);
        r8 = (org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox) r8;
        if (r7 != 0) goto L_0x0087;
    L_0x0085:
        if (r8 != 0) goto L_0x008b;
    L_0x0087:
        if (r7 == 0) goto L_0x008c;
    L_0x0089:
        if (r8 != 0) goto L_0x008c;
    L_0x008b:
        return r2;
    L_0x008c:
        if (r7 == 0) goto L_0x009c;
    L_0x008e:
        if (r8 == 0) goto L_0x009c;
    L_0x0090:
        r8 = r7.getBalance();
        r7 = r7.getBalance();
        if (r8 != r7) goto L_0x009b;
    L_0x009a:
        return r3;
    L_0x009b:
        return r2;
    L_0x009c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Paste.matchMediaHeader(org.jcodec.containers.mp4.boxes.TrakBox, org.jcodec.containers.mp4.boxes.TrakBox):boolean");
    }

    private boolean matchHeaders(TrakBox trakBox, TrakBox trakBox2) {
        TrackHeaderBox trackHeader = trakBox.getTrackHeader();
        trakBox2 = trakBox2.getTrackHeader();
        return (!("vide".equals(trakBox.getHandlerType()) && Arrays.equals(trackHeader.getMatrix(), trakBox2.getMatrix()) && trackHeader.getLayer() == trakBox2.getLayer() && trackHeader.getWidth() == trakBox2.getWidth() && trackHeader.getHeight() == trakBox2.getHeight()) && (!("soun".equals(trakBox.getHandlerType()) && trackHeader.getVolume() == trakBox2.getVolume()) && TimeCodeBox.TYPE.equals(trakBox.getHandlerType()) == null)) ? null : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean matchLoad(org.jcodec.containers.mp4.boxes.TrakBox r5, org.jcodec.containers.mp4.boxes.TrakBox r6) {
        /*
        r4 = this;
        r0 = org.jcodec.containers.mp4.boxes.LoadSettingsBox.class;
        r1 = "load";
        r1 = new java.lang.String[]{r1};
        r5 = org.jcodec.containers.mp4.boxes.Box.findFirst(r5, r0, r1);
        r5 = (org.jcodec.containers.mp4.boxes.LoadSettingsBox) r5;
        r0 = org.jcodec.containers.mp4.boxes.LoadSettingsBox.class;
        r1 = "load";
        r1 = new java.lang.String[]{r1};
        r6 = org.jcodec.containers.mp4.boxes.Box.findFirst(r6, r0, r1);
        r6 = (org.jcodec.containers.mp4.boxes.LoadSettingsBox) r6;
        r0 = 1;
        if (r5 != 0) goto L_0x0022;
    L_0x001f:
        if (r6 != 0) goto L_0x0022;
    L_0x0021:
        return r0;
    L_0x0022:
        r1 = 0;
        if (r5 != 0) goto L_0x0027;
    L_0x0025:
        if (r6 != 0) goto L_0x002b;
    L_0x0027:
        if (r5 == 0) goto L_0x002c;
    L_0x0029:
        if (r6 != 0) goto L_0x002c;
    L_0x002b:
        return r1;
    L_0x002c:
        r2 = r5.getPreloadStartTime();
        r3 = r6.getPreloadStartTime();
        if (r2 != r3) goto L_0x0055;
    L_0x0036:
        r2 = r5.getPreloadDuration();
        r3 = r6.getPreloadDuration();
        if (r2 != r3) goto L_0x0055;
    L_0x0040:
        r2 = r5.getPreloadFlags();
        r3 = r6.getPreloadFlags();
        if (r2 != r3) goto L_0x0055;
    L_0x004a:
        r5 = r5.getDefaultHints();
        r6 = r6.getDefaultHints();
        if (r5 != r6) goto L_0x0055;
    L_0x0054:
        return r0;
    L_0x0055:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Paste.matchLoad(org.jcodec.containers.mp4.boxes.TrakBox, org.jcodec.containers.mp4.boxes.TrakBox):boolean");
    }

    private boolean matchClip(TrakBox trakBox, TrakBox trakBox2) {
        ClipRegionBox clipRegionBox = (ClipRegionBox) Box.findFirst(trakBox, ClipRegionBox.class, "clip", "crgn");
        ClipRegionBox clipRegionBox2 = (ClipRegionBox) Box.findFirst(trakBox2, ClipRegionBox.class, "clip", "crgn");
        if ((clipRegionBox == null && clipRegionBox2 != null) || (clipRegionBox != null && clipRegionBox2 == null)) {
            return false;
        }
        if (clipRegionBox == null && clipRegionBox2 == null) {
            return true;
        }
        return clipRegionBox.getRgnSize() == clipRegionBox2.getRgnSize() && clipRegionBox.getX() == clipRegionBox2.getX() && clipRegionBox.getY() == clipRegionBox2.getY() && clipRegionBox.getWidth() == clipRegionBox2.getWidth() && clipRegionBox.getHeight() == clipRegionBox2.getHeight();
    }
}
