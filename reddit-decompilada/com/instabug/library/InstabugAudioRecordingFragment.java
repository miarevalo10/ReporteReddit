package com.instabug.library;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.internal.media.AudioPlayer.C0678b;
import com.instabug.library.internal.media.C0679a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.Timer;
import java.util.TimerTask;

public class InstabugAudioRecordingFragment extends Fragment implements OnClickListener, OnTouchListener {
    private static final String EXTRA_FILE_PATH = "com.instabug.library.audio_attachment_path";
    private boolean isFirstPermissionRequested = false;
    private Callbacks listener;
    private PorterDuffColorFilter mColorFilter;
    private int mCurrentTime;
    private boolean mIsRecordingActive = false;
    private boolean mIsRecordingPermissionGranted;
    private ImageView mRecordButtonBackground;
    private ImageView mRecordButtonIcon;
    private C0679a mRecorder;
    private Timer mRecordingTimer;
    private TimerTask mTimerTask = new C0592a(this);
    private TextView timerTextView;
    private TextView titleTextView;

    class C05891 implements Runnable {
        final /* synthetic */ InstabugAudioRecordingFragment f9384a;

        C05891(InstabugAudioRecordingFragment instabugAudioRecordingFragment) {
            this.f9384a = instabugAudioRecordingFragment;
        }

        public void run() {
            if (this.f9384a.isFirstPermissionRequested) {
                InstabugSDKLogger.m8356d(this.f9384a, "Shouldn't try to explain why get this permission, either first time or never again selected OR permission not in manifest");
                Toast.makeText(this.f9384a.getContext(), this.f9384a.getPermissionDeniedMessage(), 0).show();
                Instabug.setShouldAudioRecordingOptionAppear(false);
                return;
            }
            this.f9384a.isFirstPermissionRequested = true;
        }
    }

    class C05902 implements Runnable {
        final /* synthetic */ InstabugAudioRecordingFragment f9385a;

        C05902(InstabugAudioRecordingFragment instabugAudioRecordingFragment) {
            this.f9385a = instabugAudioRecordingFragment;
        }

        public void run() {
            InstabugSDKLogger.m8356d(this.f9385a, "Audio recording permission already granted before");
            this.f9385a.mIsRecordingPermissionGranted = true;
        }
    }

    public interface Callbacks {
        void onAudioRecorded(String str, String str2);
    }

    class C0592a extends TimerTask {
        final /* synthetic */ InstabugAudioRecordingFragment f9387a;

        class C05911 implements Runnable {
            final /* synthetic */ C0592a f9386a;

            C05911(C0592a c0592a) {
                this.f9386a = c0592a;
            }

            public void run() {
                if (this.f9386a.f9387a.mCurrentTime >= 50) {
                    this.f9386a.f9387a.timerTextView.setTextColor(Instabug.getPrimaryColor());
                } else {
                    this.f9386a.f9387a.timerTextView.setTextColor(-65536);
                }
                if (this.f9386a.f9387a.mCurrentTime == 60) {
                    this.f9386a.f9387a.onTimeIsUp();
                }
                this.f9386a.f9387a.timerTextView.setText(AudioPlayer.getFormattedDurationText((long) (this.f9386a.f9387a.mCurrentTime * 1000)));
                this.f9386a.f9387a.mCurrentTime = this.f9386a.f9387a.mCurrentTime + 1;
            }
        }

        C0592a(InstabugAudioRecordingFragment instabugAudioRecordingFragment) {
            this.f9387a = instabugAudioRecordingFragment;
        }

        public void run() {
            this.f9387a.getActivity().runOnUiThread(new C05911(this));
        }
    }

    public static InstabugAudioRecordingFragment newInstance(String str) {
        InstabugAudioRecordingFragment instabugAudioRecordingFragment = new InstabugAudioRecordingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_FILE_PATH, str);
        instabugAudioRecordingFragment.setArguments(bundle);
        return instabugAudioRecordingFragment;
    }

    public static InstabugAudioRecordingFragment newInstance(String str, Callbacks callbacks) {
        str = newInstance(str);
        str.listener = callbacks;
        return str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mIsRecordingPermissionGranted = false;
        this.mRecordingTimer = new Timer();
        this.mRecorder = new C0679a(getArguments().getString(EXTRA_FILE_PATH));
        layoutInflater = layoutInflater.inflate(C0593R.layout.instabug_lyt_record_audio, viewGroup, false);
        layoutInflater.findViewById(C0593R.id.instabug_btn_record_audio).setOnTouchListener(this);
        this.mRecordButtonBackground = (ImageView) layoutInflater.findViewById(C0593R.id.instabug_bk_record_audio);
        this.mRecordButtonIcon = (ImageView) layoutInflater.findViewById(C0593R.id.instabug_img_record_audio);
        this.mColorFilter = new PorterDuffColorFilter(SettingsManager.getInstance().getPrimaryColor(), Mode.SRC_IN);
        this.mRecordButtonBackground.setColorFilter(this.mColorFilter);
        this.mRecordButtonIcon.setColorFilter(this.mColorFilter);
        this.timerTextView = (TextView) layoutInflater.findViewById(C0593R.id.instabug_txt_timer);
        this.timerTextView.setTextColor(Instabug.getPrimaryColor());
        this.timerTextView.setText(String.format("00:%02d", new Object[]{Integer.valueOf(0)}));
        this.titleTextView = (TextView) layoutInflater.findViewById(C0593R.id.instabug_txt_recording_title);
        this.titleTextView.setText(PlaceHolderUtils.getPlaceHolder(Key.VOICE_MESSAGE_PRESS_AND_HOLD_TO_RECORD, getString(C0593R.string.instabug_str_hold_to_record)));
        layoutInflater.findViewById(C0593R.id.instabug_recording_audio_dialog_container).setOnClickListener(this);
        return layoutInflater;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        requestAudioRecordingPermission();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    private void requestAudioRecordingPermission() {
        PermissionsUtils.requestPermission((Fragment) this, "android.permission.RECORD_AUDIO", 1, new C05891(this), new C05902(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr.length <= null || iArr[0] != null) {
            InstabugSDKLogger.m8356d(this, "Audio recording permission denied by user");
            this.mIsRecordingPermissionGranted = false;
            Toast.makeText(getContext(), getPermissionDeniedMessage(), 0).show();
        } else {
            InstabugSDKLogger.m8356d(this, "Audio recording permission granted by user");
            this.mIsRecordingPermissionGranted = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        view = motionEvent.getAction();
        if (view != 3) {
            switch (view) {
                case null:
                    if (this.mIsRecordingActive == null && this.mIsRecordingPermissionGranted != null) {
                        this.mCurrentTime = null;
                        this.mRecordingTimer.scheduleAtFixedRate(this.mTimerTask, 0, 1000);
                        this.mRecorder.m8188a();
                        this.mIsRecordingActive = true;
                        setStateActive();
                        this.titleTextView.setText(PlaceHolderUtils.getPlaceHolder(Key.VOICE_MESSAGE_RELEASE_TO_ATTACH, getString(C0593R.string.instabug_str_release_stop_record)));
                    }
                    if (this.mIsRecordingPermissionGranted == null) {
                        requestAudioRecordingPermission();
                        break;
                    }
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
        if (!(this.mIsRecordingActive == null || this.mIsRecordingPermissionGranted == null || stopRecording() == null || motionEvent.getAction() != 1)) {
            finishRecording();
        }
        return true;
    }

    private void finishRecording() {
        if (this.listener != null) {
            final AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.getDurationAsync(getArguments().getString(EXTRA_FILE_PATH), new C0678b(this) {
                final /* synthetic */ InstabugAudioRecordingFragment f15436b;

                public final void mo2566a(int i) {
                    audioPlayer.release();
                    this.f15436b.listener.onAudioRecorded(this.f15436b.getArguments().getString(InstabugAudioRecordingFragment.EXTRA_FILE_PATH), AudioPlayer.getFormattedDurationText((long) i));
                    this.f15436b.removeCurrentFragment();
                }
            });
        }
    }

    private boolean stopRecording() {
        try {
            this.mTimerTask.cancel();
            this.mRecordingTimer.cancel();
            this.mTimerTask = new C0592a(this);
            this.mRecordingTimer = new Timer();
            this.mIsRecordingActive = false;
            setStateInactive();
            this.timerTextView.setText(String.format("00:%02d", new Object[]{Integer.valueOf(0)}));
            this.titleTextView.setText(PlaceHolderUtils.getPlaceHolder(Key.VOICE_MESSAGE_PRESS_AND_HOLD_TO_RECORD, getString(C0593R.string.instabug_str_hold_to_record)));
            this.mRecorder.m8189b();
            return this.mCurrentTime > 3;
        } catch (Throwable e) {
            if (this.mCurrentTime > 1) {
                Toast.makeText(getActivity(), "Unknown error occurred", 0).show();
            }
            InstabugSDKLogger.m8358e(this, "Error capturing audio stream", e);
            return false;
        }
    }

    private void setStateActive() {
        this.mRecordButtonBackground.setImageResource(C0593R.drawable.instabug_bg_active_record);
        Colorizer.applyTint(-65536, this.mRecordButtonBackground);
        this.mRecordButtonIcon.setColorFilter(null);
        this.timerTextView.setTextColor(-65536);
    }

    private void setStateInactive() {
        this.mRecordButtonBackground.setImageResource(C0593R.drawable.instabug_bg_default_record);
        this.mRecordButtonBackground.setColorFilter(this.mColorFilter);
        this.mRecordButtonIcon.setColorFilter(this.mColorFilter);
        this.timerTextView.setTextColor(Instabug.getPrimaryColor());
    }

    public void onClick(View view) {
        if (getFragmentManager() != null) {
            getFragmentManager().mo219a().mo196a((Fragment) this).mo203c();
            getFragmentManager().mo226c();
        }
    }

    private String getPermissionDeniedMessage() {
        return PlaceHolderUtils.getPlaceHolder(Key.AUDIO_RECORDING_PERMISSION_DENIED, getString(C0593R.string.instabug_audio_recorder_permission_denied));
    }

    private void onTimeIsUp() {
        finishRecording();
    }

    private void removeCurrentFragment() {
        getActivity().getSupportFragmentManager().mo219a().mo196a((Fragment) this).mo203c();
        getFragmentManager().mo224b("Record Audio");
    }
}
