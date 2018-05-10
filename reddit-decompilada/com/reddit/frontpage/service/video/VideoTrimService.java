package com.reddit.frontpage.service.video;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.FileDataSourceViaHeapImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import com.reddit.frontpage.util.FileUtil;
import com.reddit.frontpage.util.Util;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import timber.log.Timber;

public class VideoTrimService extends IntentService {
    private static final Subject<VideoTrimEvent> f21044a = BehaviorSubject.m38175a();

    private static final class TrimException extends Exception {
        TrimException() {
            super("Trim failed");
        }

        TrimException(String str) {
            super(str);
        }
    }

    public static final class VideoTrimEvent {
        public final boolean f21041a;
        public final String f21042b;
        public final String f21043c;

        VideoTrimEvent(boolean z, String str, String str2) {
            this.f21041a = z;
            this.f21042b = str;
            this.f21043c = str2;
        }
    }

    public static Intent m23252a(Context context, String str, int i, int i2) {
        Intent intent = new Intent(context, VideoTrimService.class);
        intent.putExtra("video_file", str);
        intent.putExtra("video_start_secs", i);
        intent.putExtra("video_end_secs", i2);
        return intent;
    }

    public static Observable<VideoTrimEvent> m23253a() {
        return f21044a;
    }

    public VideoTrimService() {
        super("VideoTrimService");
    }

    protected void onHandleIntent(Intent intent) {
        File a;
        Closeable fileOutputStream;
        Closeable channel;
        Throwable th;
        long nanoTime;
        Subject subject;
        String absolutePath;
        Object videoTrimEvent;
        Closeable closeable;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("video_file");
        int intExtra = intent2.getIntExtra("video_start_secs", 0);
        int intExtra2 = intent2.getIntExtra("video_end_secs", 0);
        if (!TextUtils.isEmpty(stringExtra) && intExtra >= 0) {
            if (intExtra2 >= intExtra) {
                long nanoTime2 = System.nanoTime();
                Timber.b("Trimming started for video [%s], start [%ds], end [%ds]", new Object[]{stringExtra, Integer.valueOf(intExtra), Integer.valueOf(intExtra2)});
                try {
                    Container a2;
                    a = FileUtil.m23689a(1);
                    try {
                        Movie a3 = MovieCreator.a(new FileDataSourceViaHeapImpl(stringExtra));
                        List<Track> list = a3.b;
                        a3.b = new LinkedList();
                        double d = (double) intExtra;
                        double d2 = (double) intExtra2;
                        intExtra = 0;
                        for (Track track : list) {
                            if (track.b() != null && track.b().length > 0) {
                                if (intExtra != 0) {
                                    throw new TrimException("Unsupported number of sync sample tracks.");
                                }
                                double a4 = m23251a(track, d);
                                d2 = Math.max(a4, m23251a(track, d2));
                                d = a4;
                                intExtra = 1;
                            }
                        }
                        for (Track track2 : list) {
                            long j = -1;
                            long j2 = 0;
                            double d3 = -1.0d;
                            int i = 0;
                            double d4 = 0.0d;
                            long j3 = -1;
                            while (i < track2.k().length) {
                                Movie movie = a3;
                                long j4 = track2.k()[i];
                                int i2 = (d4 > d3 ? 1 : (d4 == d3 ? 0 : -1));
                                if (i2 > 0 && d4 <= d) {
                                    j3 = j2;
                                }
                                if (i2 > 0 && d4 <= d2) {
                                    j = j2 + 1;
                                }
                                j2++;
                                i++;
                                d3 = d4;
                                a3 = movie;
                                d4 += ((double) j4) / ((double) track2.m().b);
                                d2 = d2;
                            }
                            double d5 = d2;
                            Track[] trackArr = new Track[]{new CroppedTrack(track2, j3, j)};
                            Movie movie2 = a3;
                            movie2.a(new AppendTrack(trackArr));
                            a3 = movie2;
                            d2 = d5;
                        }
                        a2 = new DefaultMp4Builder().a(a3);
                        fileOutputStream = new FileOutputStream(a);
                        try {
                            channel = fileOutputStream.getChannel();
                        } catch (Throwable e) {
                            th = e;
                            channel = fileOutputStream;
                            fileOutputStream = null;
                            Timber.c(th, "Exception trimming video", new Object[0]);
                            Util.m23989a(fileOutputStream);
                            Util.m23989a(channel);
                            nanoTime = System.nanoTime() - nanoTime2;
                            Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                            subject = f21044a;
                            if (a == null) {
                                absolutePath = a.getAbsolutePath();
                            } else {
                                absolutePath = "";
                            }
                            videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                            subject.onNext(videoTrimEvent);
                            return;
                        } catch (Throwable e2) {
                            th = e2;
                            channel = fileOutputStream;
                            fileOutputStream = null;
                            try {
                                Timber.c(th, "Exception trimming video", new Object[0]);
                                Util.m23989a(fileOutputStream);
                                Util.m23989a(channel);
                                nanoTime = System.nanoTime() - nanoTime2;
                                Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                                subject = f21044a;
                                if (a == null) {
                                    absolutePath = a.getAbsolutePath();
                                } else {
                                    absolutePath = "";
                                }
                                videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                                subject.onNext(videoTrimEvent);
                                return;
                            } catch (Throwable e22) {
                                th = e22;
                                Util.m23989a(fileOutputStream);
                                Util.m23989a(channel);
                                nanoTime = System.nanoTime() - nanoTime2;
                                Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                                f21044a.onNext(new VideoTrimEvent(false, stringExtra, a != null ? "" : a.getAbsolutePath()));
                                throw th;
                            }
                        } catch (Throwable e222) {
                            th = e222;
                            channel = fileOutputStream;
                            fileOutputStream = null;
                            Util.m23989a(fileOutputStream);
                            Util.m23989a(channel);
                            nanoTime = System.nanoTime() - nanoTime2;
                            Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                            if (a != null) {
                            }
                            f21044a.onNext(new VideoTrimEvent(false, stringExtra, a != null ? "" : a.getAbsolutePath()));
                            throw th;
                        }
                    } catch (Throwable e2222) {
                        th = e2222;
                        channel = null;
                        fileOutputStream = null;
                        Timber.c(th, "Exception trimming video", new Object[0]);
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        subject = f21044a;
                        if (a == null) {
                            absolutePath = "";
                        } else {
                            absolutePath = a.getAbsolutePath();
                        }
                        videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                        subject.onNext(videoTrimEvent);
                        return;
                    } catch (Throwable e22222) {
                        th = e22222;
                        channel = null;
                        fileOutputStream = null;
                        Timber.c(th, "Exception trimming video", new Object[0]);
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        subject = f21044a;
                        if (a == null) {
                            absolutePath = "";
                        } else {
                            absolutePath = a.getAbsolutePath();
                        }
                        videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                        subject.onNext(videoTrimEvent);
                        return;
                    } catch (Throwable e222222) {
                        th = e222222;
                        channel = null;
                        fileOutputStream = null;
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        if (a != null) {
                        }
                        f21044a.onNext(new VideoTrimEvent(false, stringExtra, a != null ? "" : a.getAbsolutePath()));
                        throw th;
                    }
                    try {
                        a2.writeContainer(channel);
                        Util.m23989a(channel);
                        Util.m23989a(fileOutputStream);
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime2)) / 1000000.0f)});
                        subject = f21044a;
                        videoTrimEvent = new VideoTrimEvent(true, stringExtra, a != null ? a.getAbsolutePath() : "");
                    } catch (Throwable e2222222) {
                        th = e2222222;
                        closeable = fileOutputStream;
                        fileOutputStream = channel;
                        channel = closeable;
                        Timber.c(th, "Exception trimming video", new Object[0]);
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        subject = f21044a;
                        if (a == null) {
                            absolutePath = a.getAbsolutePath();
                        } else {
                            absolutePath = "";
                        }
                        videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                        subject.onNext(videoTrimEvent);
                        return;
                    } catch (Throwable e22222222) {
                        th = e22222222;
                        closeable = fileOutputStream;
                        fileOutputStream = channel;
                        channel = closeable;
                        Timber.c(th, "Exception trimming video", new Object[0]);
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        subject = f21044a;
                        if (a == null) {
                            absolutePath = a.getAbsolutePath();
                        } else {
                            absolutePath = "";
                        }
                        videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                        subject.onNext(videoTrimEvent);
                        return;
                    } catch (Throwable e222222222) {
                        th = e222222222;
                        closeable = fileOutputStream;
                        fileOutputStream = channel;
                        channel = closeable;
                        Util.m23989a(fileOutputStream);
                        Util.m23989a(channel);
                        nanoTime = System.nanoTime() - nanoTime2;
                        Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                        if (a != null) {
                        }
                        f21044a.onNext(new VideoTrimEvent(false, stringExtra, a != null ? "" : a.getAbsolutePath()));
                        throw th;
                    }
                } catch (Throwable e2222222222) {
                    th = e2222222222;
                    channel = null;
                    fileOutputStream = null;
                    a = null;
                    Timber.c(th, "Exception trimming video", new Object[0]);
                    Util.m23989a(fileOutputStream);
                    Util.m23989a(channel);
                    nanoTime = System.nanoTime() - nanoTime2;
                    Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                    subject = f21044a;
                    if (a == null) {
                        absolutePath = "";
                    } else {
                        absolutePath = a.getAbsolutePath();
                    }
                    videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                    subject.onNext(videoTrimEvent);
                    return;
                } catch (Throwable e22222222222) {
                    th = e22222222222;
                    channel = null;
                    fileOutputStream = null;
                    a = null;
                    Timber.c(th, "Exception trimming video", new Object[0]);
                    Util.m23989a(fileOutputStream);
                    Util.m23989a(channel);
                    nanoTime = System.nanoTime() - nanoTime2;
                    Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                    subject = f21044a;
                    if (a == null) {
                        absolutePath = "";
                    } else {
                        absolutePath = a.getAbsolutePath();
                    }
                    videoTrimEvent = new VideoTrimEvent(false, stringExtra, absolutePath);
                    subject.onNext(videoTrimEvent);
                    return;
                } catch (Throwable e222222222222) {
                    th = e222222222222;
                    channel = null;
                    fileOutputStream = null;
                    a = null;
                    Util.m23989a(fileOutputStream);
                    Util.m23989a(channel);
                    nanoTime = System.nanoTime() - nanoTime2;
                    Timber.b("Trimming time: [%.1fms]", new Object[]{Float.valueOf(((float) nanoTime) / 1000000.0f)});
                    if (a != null) {
                    }
                    f21044a.onNext(new VideoTrimEvent(false, stringExtra, a != null ? "" : a.getAbsolutePath()));
                    throw th;
                }
                subject.onNext(videoTrimEvent);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid clip arguments, file [");
        stringBuilder.append(stringExtra);
        stringBuilder.append("], start [");
        stringBuilder.append(intExtra);
        stringBuilder.append("], end [");
        stringBuilder.append(intExtra2);
        stringBuilder.append("]");
        Timber.e(stringBuilder.toString(), new Object[0]);
    }

    private static double m23251a(Track track, double d) {
        int i = 0;
        double d2 = 0.0d;
        double[] dArr = new double[track.b().length];
        double d3 = 0.0d;
        long j = 0;
        for (long j2 : track.k()) {
            j++;
            if (Arrays.binarySearch(track.b(), j) >= 0) {
                dArr[Arrays.binarySearch(track.b(), j)] = d3;
            }
            d3 += ((double) j2) / ((double) track.m().b);
        }
        int length = dArr.length;
        while (i < length) {
            double d4 = dArr[i];
            if (d4 >= d) {
                return Math.abs(d - d4) < Math.abs(d - d2) ? d4 : d2;
            } else {
                i++;
                d2 = d4;
            }
        }
        return Double.MAX_VALUE;
    }
}
