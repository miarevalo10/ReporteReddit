package pl.droidsonroids.gif;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.Locale;

public enum GifError {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    READ_FAILED(102, "Failed to read from given input"),
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    NO_SCRN_DSCR(104, "No screen descriptor detected"),
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    WRONG_RECORD(107, "Wrong record type detected"),
    DATA_TOO_BIG(108, "Number of pixels bigger than width * height"),
    NOT_ENOUGH_MEM(109, "Failed to allocate required memory"),
    CLOSE_FAILED(110, "Failed to close given input"),
    NOT_READABLE(111, "Given file was not opened for read"),
    IMAGE_DEFECT(112, "Image is defective, decoding aborted"),
    EOF_TOO_SOON(113, "Image EOF detected before image complete"),
    NO_FRAMES(1000, "No frames found, at least one frame required"),
    INVALID_SCR_DIMS(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT, "Invalid screen size, dimensions must be positive"),
    INVALID_IMG_DIMS(1002, "Invalid image size, dimensions must be positive"),
    IMG_NOT_CONFINED(1003, "Image size exceeds screen size"),
    REWIND_FAILED(1004, "Input source rewind failed, animation stopped"),
    INVALID_BYTE_BUFFER(1005, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, "Unknown error");
    
    public final String f41189v;
    int f41190w;

    private GifError(int i, String str) {
        this.f41190w = i;
        this.f41189v = str;
    }

    static GifError m43247a(int i) {
        for (GifError gifError : values()) {
            if (gifError.f41190w == i) {
                return gifError;
            }
        }
        GifError gifError2 = UNKNOWN;
        gifError2.f41190w = i;
        return gifError2;
    }

    final String m43248a() {
        return String.format(Locale.ENGLISH, "GifError %d: %s", new Object[]{Integer.valueOf(this.f41190w), this.f41189v});
    }
}
