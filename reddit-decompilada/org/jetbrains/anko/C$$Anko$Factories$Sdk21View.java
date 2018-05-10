package org.jetbrains.anko;

import android.app.MediaRouteButton;
import android.content.Context;
import android.gesture.GestureOverlayView;
import android.inputmethodservice.ExtractEditText;
import android.media.tv.TvView;
import android.opengl.GLSurfaceView;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.AdapterViewFlipper;
import android.widget.AnalogClock;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.DialerFilter;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.StackView;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.TwoLineListItem;
import android.widget.VideoView;
import android.widget.ViewFlipper;
import android.widget.ZoomButton;
import android.widget.ZoomControls;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000¢\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+0\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002040\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\bR\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:0\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=0\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u001d\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020@0\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\bR\u001d\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020C0\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020F0\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\bR\u001d\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020I0\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u001d\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020L0\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\bR\u001d\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020O0\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\bR\u001d\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020R0\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\bR\u001d\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020U0\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\bR\u001d\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020X0\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\bR\u001d\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020[0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\bR\u001d\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020^0\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\bR\u001d\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020a0\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\bR\u001d\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020d0\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\bR\u001d\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020g0\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\bR\u001d\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020j0\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\bR\u001d\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020m0\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\bR\u001d\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020p0\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\bR\u001d\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020s0\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\bR\u001d\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020v0\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\bR\u001d\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020y0\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\bR\u001d\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020|0\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\bR\u001e\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000200\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\bR \u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\b¨\u0006\u0001"}, d2 = {"org/jetbrains/anko/$$Anko$Factories$Sdk21View", "", "()V", "ADAPTER_VIEW_FLIPPER", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/widget/AdapterViewFlipper;", "getADAPTER_VIEW_FLIPPER", "()Lkotlin/jvm/functions/Function1;", "ANALOG_CLOCK", "Landroid/widget/AnalogClock;", "getANALOG_CLOCK", "AUTO_COMPLETE_TEXT_VIEW", "Landroid/widget/AutoCompleteTextView;", "getAUTO_COMPLETE_TEXT_VIEW", "BUTTON", "Landroid/widget/Button;", "getBUTTON", "CALENDAR_VIEW", "Landroid/widget/CalendarView;", "getCALENDAR_VIEW", "CHECKED_TEXT_VIEW", "Landroid/widget/CheckedTextView;", "getCHECKED_TEXT_VIEW", "CHECK_BOX", "Landroid/widget/CheckBox;", "getCHECK_BOX", "CHRONOMETER", "Landroid/widget/Chronometer;", "getCHRONOMETER", "DATE_PICKER", "Landroid/widget/DatePicker;", "getDATE_PICKER", "DIALER_FILTER", "Landroid/widget/DialerFilter;", "getDIALER_FILTER", "DIGITAL_CLOCK", "Landroid/widget/DigitalClock;", "getDIGITAL_CLOCK", "EDIT_TEXT", "Landroid/widget/EditText;", "getEDIT_TEXT", "EXPANDABLE_LIST_VIEW", "Landroid/widget/ExpandableListView;", "getEXPANDABLE_LIST_VIEW", "EXTRACT_EDIT_TEXT", "Landroid/inputmethodservice/ExtractEditText;", "getEXTRACT_EDIT_TEXT", "GESTURE_OVERLAY_VIEW", "Landroid/gesture/GestureOverlayView;", "getGESTURE_OVERLAY_VIEW", "G_L_SURFACE_VIEW", "Landroid/opengl/GLSurfaceView;", "getG_L_SURFACE_VIEW", "IMAGE_BUTTON", "Landroid/widget/ImageButton;", "getIMAGE_BUTTON", "IMAGE_VIEW", "Landroid/widget/ImageView;", "getIMAGE_VIEW", "LIST_VIEW", "Landroid/widget/ListView;", "getLIST_VIEW", "MEDIA_ROUTE_BUTTON", "Landroid/app/MediaRouteButton;", "getMEDIA_ROUTE_BUTTON", "MULTI_AUTO_COMPLETE_TEXT_VIEW", "Landroid/widget/MultiAutoCompleteTextView;", "getMULTI_AUTO_COMPLETE_TEXT_VIEW", "NUMBER_PICKER", "Landroid/widget/NumberPicker;", "getNUMBER_PICKER", "PROGRESS_BAR", "Landroid/widget/ProgressBar;", "getPROGRESS_BAR", "QUICK_CONTACT_BADGE", "Landroid/widget/QuickContactBadge;", "getQUICK_CONTACT_BADGE", "RADIO_BUTTON", "Landroid/widget/RadioButton;", "getRADIO_BUTTON", "RATING_BAR", "Landroid/widget/RatingBar;", "getRATING_BAR", "SEARCH_VIEW", "Landroid/widget/SearchView;", "getSEARCH_VIEW", "SEEK_BAR", "Landroid/widget/SeekBar;", "getSEEK_BAR", "SLIDING_DRAWER", "Landroid/widget/SlidingDrawer;", "getSLIDING_DRAWER", "SPACE", "Landroid/widget/Space;", "getSPACE", "SPINNER", "Landroid/widget/Spinner;", "getSPINNER", "STACK_VIEW", "Landroid/widget/StackView;", "getSTACK_VIEW", "SURFACE_VIEW", "Landroid/view/SurfaceView;", "getSURFACE_VIEW", "SWITCH", "Landroid/widget/Switch;", "getSWITCH", "TAB_HOST", "Landroid/widget/TabHost;", "getTAB_HOST", "TAB_WIDGET", "Landroid/widget/TabWidget;", "getTAB_WIDGET", "TEXTURE_VIEW", "Landroid/view/TextureView;", "getTEXTURE_VIEW", "TEXT_CLOCK", "Landroid/widget/TextClock;", "getTEXT_CLOCK", "TEXT_VIEW", "Landroid/widget/TextView;", "getTEXT_VIEW", "TIME_PICKER", "Landroid/widget/TimePicker;", "getTIME_PICKER", "TOGGLE_BUTTON", "Landroid/widget/ToggleButton;", "getTOGGLE_BUTTON", "TV_VIEW", "Landroid/media/tv/TvView;", "getTV_VIEW", "TWO_LINE_LIST_ITEM", "Landroid/widget/TwoLineListItem;", "getTWO_LINE_LIST_ITEM", "VIDEO_VIEW", "Landroid/widget/VideoView;", "getVIDEO_VIEW", "VIEW", "Landroid/view/View;", "getVIEW", "VIEW_FLIPPER", "Landroid/widget/ViewFlipper;", "getVIEW_FLIPPER", "VIEW_STUB", "Landroid/view/ViewStub;", "getVIEW_STUB", "WEB_VIEW", "Landroid/webkit/WebView;", "getWEB_VIEW", "ZOOM_BUTTON", "Landroid/widget/ZoomButton;", "getZOOM_BUTTON", "ZOOM_CONTROLS", "Landroid/widget/ZoomControls;", "getZOOM_CONTROLS", "anko-sdk21_release"}, k = 1, mv = {1, 1, 5})
@PublishedApi
/* compiled from: Views.kt */
public final class C$$Anko$Factories$Sdk21View {
    private static final Function1<Context, ListView> f26866A = null;
    private static final Function1<Context, MultiAutoCompleteTextView> f26867B = null;
    private static final Function1<Context, NumberPicker> f26868C = null;
    private static final Function1<Context, ProgressBar> f26869D = null;
    private static final Function1<Context, QuickContactBadge> f26870E = null;
    private static final Function1<Context, RadioButton> f26871F = null;
    private static final Function1<Context, RatingBar> f26872G = null;
    private static final Function1<Context, SearchView> f26873H = null;
    private static final Function1<Context, SeekBar> f26874I = null;
    private static final Function1<Context, SlidingDrawer> f26875J = null;
    private static final Function1<Context, Space> f26876K = null;
    private static final Function1<Context, Spinner> f26877L = null;
    private static final Function1<Context, StackView> f26878M = null;
    private static final Function1<Context, Switch> f26879N = null;
    private static final Function1<Context, TabHost> f26880O = null;
    private static final Function1<Context, TabWidget> f26881P = null;
    private static final Function1<Context, TextClock> f26882Q = null;
    private static final Function1<Context, TextView> f26883R = null;
    private static final Function1<Context, TimePicker> f26884S = null;
    private static final Function1<Context, ToggleButton> f26885T = null;
    private static final Function1<Context, TwoLineListItem> f26886U = null;
    private static final Function1<Context, VideoView> f26887V = null;
    private static final Function1<Context, ViewFlipper> f26888W = null;
    private static final Function1<Context, ZoomButton> f26889X = null;
    private static final Function1<Context, ZoomControls> f26890Y = null;
    public static final C$$Anko$Factories$Sdk21View f26891a = null;
    private static final Function1<Context, MediaRouteButton> f26892b = null;
    private static final Function1<Context, GestureOverlayView> f26893c = null;
    private static final Function1<Context, ExtractEditText> f26894d = null;
    private static final Function1<Context, TvView> f26895e = null;
    private static final Function1<Context, GLSurfaceView> f26896f = null;
    private static final Function1<Context, SurfaceView> f26897g = null;
    private static final Function1<Context, TextureView> f26898h = null;
    private static final Function1<Context, View> f26899i = null;
    private static final Function1<Context, ViewStub> f26900j = null;
    private static final Function1<Context, WebView> f26901k = null;
    private static final Function1<Context, AdapterViewFlipper> f26902l = null;
    private static final Function1<Context, AnalogClock> f26903m = null;
    private static final Function1<Context, AutoCompleteTextView> f26904n = null;
    private static final Function1<Context, Button> f26905o = null;
    private static final Function1<Context, CalendarView> f26906p = null;
    private static final Function1<Context, CheckBox> f26907q = null;
    private static final Function1<Context, CheckedTextView> f26908r = null;
    private static final Function1<Context, Chronometer> f26909s = null;
    private static final Function1<Context, DatePicker> f26910t = null;
    private static final Function1<Context, DialerFilter> f26911u = null;
    private static final Function1<Context, DigitalClock> f26912v = null;
    private static final Function1<Context, EditText> f26913w = null;
    private static final Function1<Context, ExpandableListView> f26914x = null;
    private static final Function1<Context, ImageButton> f26915y = null;
    private static final Function1<Context, ImageView> f26916z = null;

    static {
        C$$Anko$Factories$Sdk21View c$$Anko$Factories$Sdk21View = new C$$Anko$Factories$Sdk21View();
    }

    private C$$Anko$Factories$Sdk21View() {
        f26891a = this;
        f26892b = C$$Anko$Factories$Sdk21View$MEDIA_ROUTE_BUTTON$1.f39003a;
        f26893c = C$$Anko$Factories$Sdk21View$GESTURE_OVERLAY_VIEW$1.f38998a;
        f26894d = C$$Anko$Factories$Sdk21View$EXTRACT_EDIT_TEXT$1.f38997a;
        f26895e = C$$Anko$Factories$Sdk21View$TV_VIEW$1.f39025a;
        f26896f = C$$Anko$Factories$Sdk21View$G_L_SURFACE_VIEW$1.f38999a;
        f26897g = C$$Anko$Factories$Sdk21View$SURFACE_VIEW$1.f39016a;
        f26898h = C$$Anko$Factories$Sdk21View$TEXTURE_VIEW$1.f39020a;
        f26899i = C$$Anko$Factories$Sdk21View$VIEW$1.f39028a;
        f26900j = C$$Anko$Factories$Sdk21View$VIEW_STUB$1.f39030a;
        f26901k = C$$Anko$Factories$Sdk21View$WEB_VIEW$1.f39031a;
        f26902l = C$$Anko$Factories$Sdk21View$ADAPTER_VIEW_FLIPPER$1.f38984a;
        f26903m = C$$Anko$Factories$Sdk21View$ANALOG_CLOCK$1.f38985a;
        f26904n = C$$Anko$Factories$Sdk21View$AUTO_COMPLETE_TEXT_VIEW$1.f38986a;
        f26905o = C$$Anko$Factories$Sdk21View$BUTTON$1.f38987a;
        f26906p = C$$Anko$Factories$Sdk21View$CALENDAR_VIEW$1.f38988a;
        f26907q = C$$Anko$Factories$Sdk21View$CHECK_BOX$1.f38990a;
        f26908r = C$$Anko$Factories$Sdk21View$CHECKED_TEXT_VIEW$1.f38989a;
        f26909s = C$$Anko$Factories$Sdk21View$CHRONOMETER$1.f38991a;
        f26910t = C$$Anko$Factories$Sdk21View$DATE_PICKER$1.f38992a;
        f26911u = C$$Anko$Factories$Sdk21View$DIALER_FILTER$1.f38993a;
        f26912v = C$$Anko$Factories$Sdk21View$DIGITAL_CLOCK$1.f38994a;
        f26913w = C$$Anko$Factories$Sdk21View$EDIT_TEXT$1.f38995a;
        f26914x = C$$Anko$Factories$Sdk21View$EXPANDABLE_LIST_VIEW$1.f38996a;
        f26915y = C$$Anko$Factories$Sdk21View$IMAGE_BUTTON$1.f39000a;
        f26916z = C$$Anko$Factories$Sdk21View$IMAGE_VIEW$1.f39001a;
        f26866A = C$$Anko$Factories$Sdk21View$LIST_VIEW$1.f39002a;
        f26867B = C$$Anko$Factories$Sdk21View$MULTI_AUTO_COMPLETE_TEXT_VIEW$1.f39004a;
        f26868C = C$$Anko$Factories$Sdk21View$NUMBER_PICKER$1.f39005a;
        f26869D = C$$Anko$Factories$Sdk21View$PROGRESS_BAR$1.f39006a;
        f26870E = C$$Anko$Factories$Sdk21View$QUICK_CONTACT_BADGE$1.f39007a;
        f26871F = C$$Anko$Factories$Sdk21View$RADIO_BUTTON$1.f39008a;
        f26872G = C$$Anko$Factories$Sdk21View$RATING_BAR$1.f39009a;
        f26873H = C$$Anko$Factories$Sdk21View$SEARCH_VIEW$1.f39010a;
        f26874I = C$$Anko$Factories$Sdk21View$SEEK_BAR$1.f39011a;
        f26875J = C$$Anko$Factories$Sdk21View$SLIDING_DRAWER$1.f39012a;
        f26876K = C$$Anko$Factories$Sdk21View$SPACE$1.f39013a;
        f26877L = C$$Anko$Factories$Sdk21View$SPINNER$1.f39014a;
        f26878M = C$$Anko$Factories$Sdk21View$STACK_VIEW$1.f39015a;
        f26879N = C$$Anko$Factories$Sdk21View$SWITCH$1.f39017a;
        f26880O = C$$Anko$Factories$Sdk21View$TAB_HOST$1.f39018a;
        f26881P = C$$Anko$Factories$Sdk21View$TAB_WIDGET$1.f39019a;
        f26882Q = C$$Anko$Factories$Sdk21View$TEXT_CLOCK$1.f39021a;
        f26883R = C$$Anko$Factories$Sdk21View$TEXT_VIEW$1.f39022a;
        f26884S = C$$Anko$Factories$Sdk21View$TIME_PICKER$1.f39023a;
        f26885T = C$$Anko$Factories$Sdk21View$TOGGLE_BUTTON$1.f39024a;
        f26886U = C$$Anko$Factories$Sdk21View$TWO_LINE_LIST_ITEM$1.f39026a;
        f26887V = C$$Anko$Factories$Sdk21View$VIDEO_VIEW$1.f39027a;
        f26888W = C$$Anko$Factories$Sdk21View$VIEW_FLIPPER$1.f39029a;
        f26889X = C$$Anko$Factories$Sdk21View$ZOOM_BUTTON$1.f39032a;
        f26890Y = C$$Anko$Factories$Sdk21View$ZOOM_CONTROLS$1.f39033a;
    }

    public static Function1<Context, ImageView> m28392a() {
        return f26916z;
    }

    public static Function1<Context, TextView> m28393b() {
        return f26883R;
    }
}
