package com.instabug.library.internal.video;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.instabug.library.C0593R;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.eventbus.VideoProcessingServiceEventBus;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.MP4Packet;
import rx.functions.Action1;

@SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
public class VideoProcessingService extends IntentService {
    private Action f9630a;

    public enum Action {
        STOP
    }

    class C13701 implements Action1<Action> {
        final /* synthetic */ VideoProcessingService f15474a;

        C13701(VideoProcessingService videoProcessingService) {
            this.f15474a = videoProcessingService;
        }

        public final /* synthetic */ void m15390a(Object obj) {
            Action action = (Action) obj;
            this.f15474a.f9630a = action;
            VideoProcessingService videoProcessingService = this.f15474a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(action.name());
            stringBuilder.append(" action is received");
            InstabugSDKLogger.m8356d(videoProcessingService, stringBuilder.toString());
        }
    }

    public VideoProcessingService() {
        super("VideoProcessingService");
    }

    public static void m8205a(Context context, String str, String str2) {
        Intent intent = new Intent(context, VideoProcessingService.class);
        intent.putExtra("video.file.path", str);
        intent.putExtra("audio.file.path", str2);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent) {
        Intent intent2 = intent;
        VideoProcessingServiceEventBus.getInstance().subscribe(new C13701(this));
        String stringExtra = intent2.getStringExtra("video.file.path");
        String stringExtra2 = intent2.getStringExtra("audio.file.path");
        try {
            InstabugSDKLogger.m8356d(r1, "making video");
            SettingsManager.getInstance().setVideoProcessorBusy(true);
            List a = m8203a(AttachmentsUtility.getVideoRecordingFramesDirectory(this));
            File file = new File(stringExtra);
            C0691a c0691a = new C0691a(file);
            Iterator it = a.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                if (r1.f9630a == Action.STOP) {
                    m8207b();
                    SettingsManager.getInstance().setVideoProcessorBusy(false);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(VideoProcessingService.class.getSimpleName());
                    stringBuilder.append(" has stopped");
                    InstabugSDKLogger.m8356d(r1, stringBuilder.toString());
                    return;
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(file2.getPath());
                Picture create = Picture.create(decodeFile.getWidth(), decodeFile.getHeight(), ColorSpace.RGB);
                m8206a(decodeFile, create);
                if (c0691a.f9632b == null) {
                    c0691a.f9632b = Picture.create(create.getWidth(), create.getHeight(), c0691a.f9634d.getSupportedColorSpaces()[0]);
                }
                c0691a.f9633c.transform(create, c0691a.f9632b);
                c0691a.f9638h.clear();
                ByteBuffer encodeFrame = c0691a.f9634d.encodeFrame(c0691a.f9632b, c0691a.f9638h);
                c0691a.f9635e.clear();
                c0691a.f9636f.clear();
                H264Utils.wipePS(encodeFrame, c0691a.f9635e, c0691a.f9636f);
                H264Utils.encodeMOVPacket(encodeFrame);
                Iterator it2 = it;
                c0691a.f9637g.addFrame(new MP4Packet(encodeFrame, (long) (c0691a.f9639i * 2), 8, 1, (long) c0691a.f9639i, true, null, (long) (c0691a.f9639i * 2), 0));
                c0691a.f9639i++;
                it = it2;
            }
            try {
                c0691a.f9637g.addSampleEntry(H264Utils.createMOVSampleEntry(c0691a.f9635e, c0691a.f9636f, 4));
                c0691a.f9640j.writeHeader();
            } catch (Throwable e) {
                InstabugSDKLogger.wtf(c0691a, "Something went wrong while generating video", e);
            }
            NIOUtils.closeQuietly(c0691a.f9631a);
            m8207b();
            if (VERSION.SDK_INT >= 18 && stringExtra2 != null) {
                stringExtra = new InstabugVideoUtils().mux(stringExtra2, stringExtra);
                File file3 = new File(stringExtra2);
                file.delete();
                file3.delete();
            }
            InstabugSDKLogger.m8356d(r1, "Video encoding is done!");
            ScreenRecordingEventBus.getInstance().post(new ScreenRecordEvent(1, Uri.fromFile(new File(stringExtra))));
            SettingsManager.getInstance().setVideoProcessorBusy(false);
        } catch (IOException e2) {
            e2.printStackTrace();
            InstabugSDKLogger.m8361w(r1, "Couldn't encode video");
            m8204a();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            InstabugSDKLogger.m8361w(r1, "IllegalAccessException - Couldn't encode video");
            m8204a();
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            InstabugSDKLogger.m8361w(r1, "OutOfMemoryError - Couldn't encode video");
            m8204a();
        }
    }

    private void m8204a() {
        Toast.makeText(this, C0593R.string.instabug_str_video_encoding_error, 0).show();
        ScreenRecordingEventBus.getInstance().post(new ScreenRecordEvent(2, null));
        SettingsManager.getInstance().setVideoProcessorBusy(false);
    }

    private void m8207b() {
        File[] listFiles = AttachmentsUtility.getVideoRecordingFramesDirectory(this).listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        InstabugSDKLogger.m8356d(this, "Video frames are removed");
    }

    private List<File> m8203a(File file) {
        List arrayList = new ArrayList();
        file = file.listFiles();
        if (file != null) {
            for (File file2 : file) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(m8203a(file2));
                    } else if (file2.getName().endsWith(".jpg")) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void m8206a(Bitmap bitmap, Picture picture) {
        picture = picture.getPlaneData(0);
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < bitmap.getHeight()) {
            int i4 = i3;
            i3 = i2;
            i2 = 0;
            while (i2 < bitmap.getWidth()) {
                int i5 = iArr[i3];
                picture[i4] = (i5 >> 16) & 255;
                picture[i4 + 1] = (i5 >> 8) & 255;
                picture[i4 + 2] = i5 & 255;
                i2++;
                i3++;
                i4 += 3;
            }
            i++;
            i2 = i3;
            i3 = i4;
        }
    }
}
