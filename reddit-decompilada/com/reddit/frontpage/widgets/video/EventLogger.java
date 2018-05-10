package com.reddit.frontpage.widgets.video;

import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.MetadataRenderer.Output;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import timber.log.Timber;

final class EventLogger implements EventListener, AudioRendererEventListener, Output, AdaptiveMediaSourceEventListener, ExtractorMediaSource.EventListener, VideoRendererEventListener {
    private static final NumberFormat f34555a;
    private final MappingTrackSelector f34556b;
    private final Window f34557c;
    private final Period f34558d;
    private final long f34559e;

    private static String m35339b(int i) {
        switch (i) {
            case 0:
                return "NO";
            case 1:
                return "NO_UNSUPPORTED_TYPE";
            case 3:
                return "NO_EXCEEDS_CAPABILITIES";
            case 4:
                return "YES";
            default:
                return Operation.EMPTY_PARAM;
        }
    }

    private static String m35340b(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public final void m35343a(int i, int i2, int i3, float f) {
    }

    public final void m35346a(Surface surface) {
    }

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        f34555a = instance;
        instance.setMinimumFractionDigits(2);
        f34555a.setMaximumFractionDigits(2);
        f34555a.setGroupingUsed(false);
    }

    public final void m35355a(boolean z) {
        Timber.b("loading [%s]", new Object[]{Boolean.valueOf(z)});
    }

    public final void m35356a(boolean z, int i) {
        String str = "state [%s, %s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = m35338b();
        objArr[1] = Boolean.valueOf(z);
        switch (i) {
            case 1:
                z = "I";
                break;
            case 2:
                z = "B";
                break;
            case 3:
                z = "R";
                break;
            case 4:
                z = "E";
                break;
            default:
                z = Operation.EMPTY_PARAM;
                break;
        }
        objArr[2] = z;
        Timber.b(str, objArr);
    }

    public final void m35341a() {
        Timber.b("positionDiscontinuity", new Object[0]);
    }

    public final void m35349a(Timeline timeline) {
        if (timeline != null) {
            int c = timeline.c();
            int b = timeline.b();
            Timber.b("sourceInfo [periodCount=%d, windowCount=%d", new Object[]{Integer.valueOf(c), Integer.valueOf(b)});
            for (int i = 0; i < Math.min(c, 3); i++) {
                timeline.a(i, this.f34558d, false);
                Timber.b("  period [%s]", new Object[]{m35335a(C.a(this.f34558d.d))});
            }
            if (c > 3) {
                Timber.b("  ...", new Object[0]);
            }
            for (c = 0; c < Math.min(b, 3); c++) {
                timeline.a(c, this.f34557c, 0);
                Timber.b("  window [%s, %s, %s]", new Object[]{m35335a(C.a(this.f34557c.i)), Boolean.valueOf(this.f34557c.d), Boolean.valueOf(this.f34557c.e)});
            }
            if (b > 3) {
                Timber.b("  ...", new Object[0]);
            }
            Timber.b("]", new Object[0]);
        }
    }

    public final void m35347a(ExoPlaybackException exoPlaybackException) {
        Timber.c(exoPlaybackException, "playerFailed [%s]", new Object[]{m35338b()});
    }

    public final void m35352a(TrackSelectionArray trackSelectionArray) {
        MappedTrackInfo mappedTrackInfo = this.f34556b.a;
        boolean z = false;
        if (mappedTrackInfo == null) {
            Timber.b("Tracks []", new Object[0]);
            return;
        }
        Timber.b("Tracks [", new Object[0]);
        int i = 0;
        while (true) {
            int i2 = 4;
            if (i >= mappedTrackInfo.a) {
                break;
            }
            EventLogger eventLogger;
            boolean z2;
            TrackGroupArray trackGroupArray = mappedTrackInfo.b[i];
            TrackSelection trackSelection = trackSelectionArray.b[i];
            if (trackGroupArray.b > 0) {
                int i3;
                Timber.b("  Renderer: %d [", new Object[]{Integer.valueOf(i)});
                int i4 = z;
                while (i4 < trackGroupArray.b) {
                    int i5;
                    int i6;
                    int i7;
                    String str;
                    TrackGroup trackGroup = trackGroupArray.c[i4];
                    int i8 = trackGroup.a;
                    int i9 = mappedTrackInfo.b[i].c[i4].a;
                    int[] iArr = new int[i9];
                    for (i5 = i6; i5 < i9; i5++) {
                        if (mappedTrackInfo.a(i, i4, i5) == i2) {
                            i7 = i6 + 1;
                            iArr[i6] = i5;
                            i6 = i7;
                        }
                    }
                    int[] copyOf = Arrays.copyOf(iArr, i6);
                    Object obj = null;
                    i5 = 0;
                    i7 = 16;
                    i9 = 0;
                    int i10 = 0;
                    while (i5 < copyOf.length) {
                        str = mappedTrackInfo.b[i].c[i4].b[copyOf[i5]].f;
                        int i11 = i9 + 1;
                        if (i9 == 0) {
                            obj = str;
                        } else {
                            i10 = (Util.a(obj, str) ^ 1) | i10;
                        }
                        i7 = Math.min(i7, mappedTrackInfo.d[i][i4][i5] & 24);
                        i5++;
                        i9 = i11;
                        eventLogger = this;
                    }
                    if (i10 != 0) {
                        i7 = Math.min(i7, mappedTrackInfo.c[i]);
                    }
                    str = i8 < 2 ? "N/A" : i7 != 0 ? i7 != 8 ? i7 != 16 ? Operation.EMPTY_PARAM : "YES" : "YES_NOT_SEAMLESS" : "NO";
                    Timber.b("    Group: %d, adaptive_supported=%s]", new Object[]{Integer.valueOf(i4), str});
                    for (i3 = 0; i3 < trackGroup.a; i3++) {
                        z = (trackSelection == null || trackSelection.d() != trackGroup || trackSelection.c(i3) == -1) ? false : true;
                        String b = m35340b(z);
                        String b2 = m35339b(mappedTrackInfo.a(i, i4, i3));
                        Timber.b("      %s Track: %d, %s, support=%s", new Object[]{b, Integer.valueOf(i3), Format.a(trackGroup.b[i3]), b2});
                    }
                    Timber.b("    ]", new Object[0]);
                    i4++;
                    eventLogger = this;
                    i6 = 0;
                    i2 = 4;
                }
                if (trackSelection != null) {
                    for (i3 = 0; i3 < trackSelection.e(); i3++) {
                        Metadata metadata = trackSelection.a(i3).d;
                        if (metadata != null) {
                            z2 = false;
                            Timber.b("    Metadata [", new Object[0]);
                            m35336a(metadata, "      ");
                            Timber.b("    ]", new Object[0]);
                            break;
                        }
                    }
                }
                z2 = false;
                Timber.b("  ]", new Object[z2]);
            } else {
                z2 = z;
            }
            i++;
            z = z2;
            eventLogger = this;
        }
        int i12 = z;
        TrackGroupArray trackGroupArray2 = mappedTrackInfo.e;
        if (trackGroupArray2.b > 0) {
            Timber.b("  Renderer:None [", new Object[i12]);
            int i13 = i12;
            while (i13 < trackGroupArray2.b) {
                Timber.b("    Group: %d [", new Object[]{Integer.valueOf(i13)});
                TrackGroup trackGroup2 = trackGroupArray2.c[i13];
                i = i12;
                while (i < trackGroup2.a) {
                    b2 = m35340b((boolean) i12);
                    String b3 = m35339b(i12);
                    Timber.b("      %s Track: %d %s, supported=%s", new Object[]{b2, Integer.valueOf(i), Format.a(trackGroup2.b[i]), b3});
                    i++;
                    i12 = false;
                }
                Timber.b("    ]", new Object[0]);
                i13++;
                z2 = false;
            }
            i = i12;
            Timber.b("  ]", new Object[i]);
        } else {
            i = i12;
        }
        Timber.b("]", new Object[i]);
    }

    public final void m35351a(Metadata metadata) {
        Timber.b("onMetadata [", new Object[0]);
        m35336a(metadata, "  ");
        Timber.b("]", new Object[0]);
    }

    public final void m35361c(DecoderCounters decoderCounters) {
        Timber.b("audioEnabled [%s]", new Object[]{m35338b()});
    }

    public final void m35342a(int i) {
        Timber.b("audioSessionId [%d]", new Object[]{Integer.valueOf(i)});
    }

    public final void m35360b(String str, long j, long j2) {
        Timber.b("audioDecoderInitialized [%s, %s]", new Object[]{m35338b(), str});
    }

    public final void m35357b(Format format) {
        Timber.b("audioFormatChanged [%s, %s]", new Object[]{m35338b(), Format.a(format)});
    }

    public final void m35362d(DecoderCounters decoderCounters) {
        Timber.b("audioDisabled [%s]", new Object[]{m35338b()});
    }

    public final void m35345a(int i, long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder("audioTrackUnderrun [");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(j);
        stringBuilder.append(", ");
        stringBuilder.append(j2);
        stringBuilder.append("]");
        m35337a(stringBuilder.toString(), (Exception) 0);
    }

    public final void m35350a(DecoderCounters decoderCounters) {
        Timber.b("videoEnabled [%s]", new Object[]{m35338b()});
    }

    public final void m35354a(String str, long j, long j2) {
        Timber.b("videoDecoderInitialized [%s, %s]", new Object[]{m35338b(), str});
    }

    public final void m35348a(Format format) {
        Timber.b("videoFormatChanged [%s, %s]", new Object[]{m35338b(), Format.a(format)});
    }

    public final void m35358b(DecoderCounters decoderCounters) {
        Timber.b("videoDisabled [%s]", new Object[]{m35338b()});
    }

    public final void m35344a(int i, long j) {
        Timber.b("droppedFrames [%s, %d]", new Object[]{m35338b(), Integer.valueOf(i)});
    }

    public final void m35359b(IOException iOException) {
        m35337a("loadError", (Exception) iOException);
    }

    public final void m35353a(IOException iOException) {
        m35337a("loadError", (Exception) iOException);
    }

    private void m35337a(String str, Exception exception) {
        Timber.c(exception, "internalError [%s, %s]", new Object[]{m35338b(), str});
    }

    private String m35338b() {
        return m35335a(SystemClock.elapsedRealtime() - this.f34559e);
    }

    private static String m35335a(long j) {
        return j == -9223372036854775807L ? Operation.EMPTY_PARAM : f34555a.format((double) (((float) j) / 1000.0f));
    }

    private static void m35336a(Metadata metadata, String str) {
        for (Entry entry : metadata.a) {
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                Timber.b("%s %s: value=%s", new Object[]{str, textInformationFrame.f, textInformationFrame.b});
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                Timber.b("%s %s: url=%s", new Object[]{str, urlLinkFrame.f, urlLinkFrame.b});
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                Timber.b("%s %s: owner=%s", new Object[]{str, privFrame.f, privFrame.a});
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                Timber.b("%s %s: mimeType=%s, filename=%s, description=%s", new Object[]{str, geobFrame.f, geobFrame.a, geobFrame.b, geobFrame.c});
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                Timber.b("%s, %s: mimeType=%s, description=%s", new Object[]{str, apicFrame.f, apicFrame.a, apicFrame.b});
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                Timber.b("%s, %s: language=%s, description=%s", new Object[]{str, commentFrame.f, commentFrame.a, commentFrame.b});
            } else if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) entry;
                Timber.b("%s, %s", new Object[]{str, id3Frame.f});
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                Timber.b("%s, EMSG: scheme=%s, id=%d, value=%s", new Object[]{str, eventMessage.a, Long.valueOf(eventMessage.d), eventMessage.b});
            }
        }
    }
}
