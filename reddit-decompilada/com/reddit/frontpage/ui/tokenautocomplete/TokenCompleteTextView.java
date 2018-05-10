package com.reddit.frontpage.ui.tokenautocomplete;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.QwertyKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class TokenCompleteTextView<T> extends AppCompatMultiAutoCompleteTextView implements OnEditorActionListener {
    static final /* synthetic */ boolean f34467b = true;
    boolean f34468a = false;
    private char[] f34469c = new char[]{',', ';'};
    private Tokenizer f34470d;
    private T f34471e;
    private TokenListener<T> f34472f;
    private TokenSpanWatcher f34473g;
    private TokenTextWatcher f34474h;
    private ArrayList<T> f34475i;
    private List<TokenImageSpan> f34476j;
    private TokenDeleteStyle f34477k = TokenDeleteStyle._Parent;
    private TokenClickStyle f34478l = TokenClickStyle.None;
    private CharSequence f34479m = "";
    private boolean f34480n = false;
    private Layout f34481o = null;
    private boolean f34482p = true;
    private boolean f34483q = false;
    private boolean f34484r = false;
    private boolean f34485s = true;
    private boolean f34486t = false;
    private boolean f34487u = false;
    private boolean f34488v = true;
    private int f34489w = -1;

    class C19141 implements InputFilter {
        final /* synthetic */ TokenCompleteTextView f21650a;

        C19141(TokenCompleteTextView tokenCompleteTextView) {
            this.f21650a = tokenCompleteTextView;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.f21650a.f34489w != -1 && this.f21650a.f34475i.size() == this.f21650a.f34489w) {
                return "";
            }
            if (charSequence.length() == 1 && TokenCompleteTextView.m35242a(this.f21650a, charSequence.charAt(0)) != null) {
                this.f21650a.performCompletion();
                return "";
            } else if (i3 >= this.f21650a.f34479m.length()) {
                return null;
            } else {
                if (i3 == 0 && i4 == 0) {
                    return null;
                }
                if (i4 <= this.f21650a.f34479m.length()) {
                    return this.f21650a.f34479m.subSequence(i3, i4);
                }
                return this.f21650a.f34479m.subSequence(i3, this.f21650a.f34479m.length());
            }
        }
    }

    class C19185 implements Runnable {
        final /* synthetic */ TokenCompleteTextView f21658a;

        C19185(TokenCompleteTextView tokenCompleteTextView) {
            this.f21658a = tokenCompleteTextView;
        }

        public void run() {
            Spannable text = this.f21658a.getText();
            if (text != null) {
                int i = 0;
                TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
                int length = tokenImageSpanArr.length;
                while (i < length) {
                    TokenImageSpan tokenImageSpan = tokenImageSpanArr[i];
                    this.f21658a.m35238a(tokenImageSpan);
                    this.f21658a.f34473g.onSpanRemoved(text, tokenImageSpan, text.getSpanStart(tokenImageSpan), text.getSpanEnd(tokenImageSpan));
                    i++;
                }
            }
        }
    }

    class C19196 implements Runnable {
        final /* synthetic */ TokenCompleteTextView f21659a;

        C19196(TokenCompleteTextView tokenCompleteTextView) {
            this.f21659a = tokenCompleteTextView;
        }

        public void run() {
            this.f21659a.mo7031a(this.f21659a.isFocused());
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C19211();
        CharSequence f21662a;
        boolean f21663b;
        boolean f21664c;
        boolean f21665d;
        TokenClickStyle f21666e;
        TokenDeleteStyle f21667f;
        ArrayList<Serializable> f21668g;
        char[] f21669h;

        static class C19211 implements Creator<SavedState> {
            C19211() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f21662a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z = false;
            this.f21663b = parcel.readInt() != 0;
            this.f21664c = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            this.f21665d = z;
            this.f21666e = TokenClickStyle.values()[parcel.readInt()];
            this.f21667f = TokenDeleteStyle.values()[parcel.readInt()];
            this.f21668g = (ArrayList) parcel.readSerializable();
            this.f21669h = parcel.createCharArray();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f21662a, parcel, 0);
            parcel.writeInt(this.f21663b);
            parcel.writeInt(this.f21664c);
            parcel.writeInt(this.f21665d);
            parcel.writeInt(this.f21666e.ordinal());
            parcel.writeInt(this.f21667f.ordinal());
            parcel.writeSerializable(this.f21668g);
            parcel.writeCharArray(this.f21669h);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("TokenCompleteTextView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" tokens=");
            stringBuilder.append(this.f21668g);
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("}");
            return stringBuilder3.toString();
        }
    }

    public enum TokenClickStyle {
        None(false),
        Delete(false),
        Select(true),
        SelectDeselect(true);
        
        boolean f21675e;

        private TokenClickStyle(boolean z) {
            this.f21675e = null;
            this.f21675e = z;
        }
    }

    public enum TokenDeleteStyle {
        _Parent,
        Clear,
        PartialCompletion,
        ToString
    }

    private class TokenInputConnection extends InputConnectionWrapper {
        final /* synthetic */ TokenCompleteTextView f21681a;

        TokenInputConnection(TokenCompleteTextView tokenCompleteTextView, InputConnection inputConnection) {
            this.f21681a = tokenCompleteTextView;
            super(inputConnection, true);
        }

        public boolean deleteSurroundingText(int i, int i2) {
            this.f21681a.m35272a(i);
            if (this.f21681a.getSelectionStart() > this.f21681a.f34479m.length()) {
                return super.deleteSurroundingText(i, i2);
            }
            if (this.f21681a.m35246b(false) == 0) {
                if (super.deleteSurroundingText(0, i2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public interface TokenListener<T> {
        void mo7523a(T t);

        void mo7532b(T t);
    }

    private class TokenSpanWatcher implements SpanWatcher {
        final /* synthetic */ TokenCompleteTextView f21682a;

        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        }

        private TokenSpanWatcher(TokenCompleteTextView tokenCompleteTextView) {
            this.f21682a = tokenCompleteTextView;
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if ((obj instanceof TokenImageSpan) != null && this.f21682a.f34486t == null && this.f21682a.f34483q == null) {
                TokenImageSpan tokenImageSpan = (TokenImageSpan) obj;
                this.f21682a.f34475i.add(tokenImageSpan.f29373a);
                if (this.f21682a.f34472f != null) {
                    this.f21682a.f34472f.mo7523a(tokenImageSpan.f29373a);
                }
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if ((obj instanceof TokenImageSpan) != null && this.f21682a.f34486t == null && this.f21682a.f34483q == null) {
                TokenImageSpan tokenImageSpan = (TokenImageSpan) obj;
                if (this.f21682a.f34475i.contains(tokenImageSpan.f29373a) != null) {
                    this.f21682a.f34475i.remove(tokenImageSpan.f29373a);
                }
                if (this.f21682a.f34472f != null) {
                    this.f21682a.f34472f.mo7532b(tokenImageSpan.f29373a);
                }
            }
        }
    }

    private class TokenTextWatcher implements TextWatcher {
        ArrayList<TokenImageSpan> f21683a;
        final /* synthetic */ TokenCompleteTextView f21684b;

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private TokenTextWatcher(TokenCompleteTextView tokenCompleteTextView) {
            this.f21684b = tokenCompleteTextView;
            this.f21683a = new ArrayList();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i2 > 0 && this.f21684b.getText() != null) {
                charSequence = this.f21684b.getText();
                i2 += i;
                if (charSequence.charAt(i) == 32) {
                    i--;
                }
                TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) charSequence.getSpans(i, i2, TokenImageSpan.class);
                ArrayList arrayList = new ArrayList();
                for (Object obj : tokenImageSpanArr) {
                    if (charSequence.getSpanStart(obj) < i2 && i < charSequence.getSpanEnd(obj)) {
                        arrayList.add(obj);
                    }
                }
                this.f21683a = arrayList;
            }
        }

        public void afterTextChanged(Editable editable) {
            ArrayList arrayList = new ArrayList(this.f21683a);
            this.f21683a.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TokenImageSpan tokenImageSpan = (TokenImageSpan) it.next();
                int spanStart = editable.getSpanStart(tokenImageSpan);
                int spanEnd = editable.getSpanEnd(tokenImageSpan);
                editable.removeSpan(tokenImageSpan);
                spanEnd--;
                if (spanEnd >= 0 && TokenCompleteTextView.m35242a(this.f21684b, editable.charAt(spanEnd))) {
                    editable.delete(spanEnd, spanEnd + 1);
                }
                if (spanStart >= 0 && TokenCompleteTextView.m35242a(this.f21684b, editable.charAt(spanStart))) {
                    editable.delete(spanStart, spanStart + 1);
                }
            }
            this.f21684b.m35263k();
            this.f21684b.m35261j();
        }
    }

    protected class TokenImageSpan extends ViewSpan implements NoCopySpan {
        T f29373a;
        final /* synthetic */ TokenCompleteTextView f29374b;

        public TokenImageSpan(TokenCompleteTextView tokenCompleteTextView, View view, T t, int i) {
            this.f29374b = tokenCompleteTextView;
            super(view, i);
            this.f29373a = t;
        }

        public final void mo5022a() {
            Editable text = this.f29374b.getText();
            if (text != null) {
                switch (this.f29374b.f34478l) {
                    case Select:
                    case SelectDeselect:
                        if (!this.c.isSelected()) {
                            this.f29374b.m35263k();
                            this.c.setSelected(true);
                            return;
                        } else if (this.f29374b.f34478l != TokenClickStyle.SelectDeselect) {
                            TokenCompleteTextView.m35241a();
                            break;
                        } else {
                            this.c.setSelected(false);
                            this.f29374b.invalidate();
                            return;
                        }
                    case Delete:
                        break;
                    default:
                        if (this.f29374b.getSelectionStart() != text.getSpanEnd(this) + 1) {
                            this.f29374b.setSelection(text.getSpanEnd(this) + 1);
                        }
                        return;
                }
                TokenCompleteTextView.m35241a();
                this.f29374b.m35238a(this);
            }
        }
    }

    public static boolean m35241a() {
        return true;
    }

    protected abstract View mo7029a(T t);

    protected abstract T mo7030a(String str);

    private void m35249d() {
        Editable text = getText();
        if (text != null) {
            text.setSpan(this.f34473g, 0, text.length(), 18);
            addTextChangedListener(this.f34474h);
        }
    }

    private void m35252e() {
        if (!this.f34484r) {
            setTokenizer(new CommaTokenizer());
            this.f34475i = new ArrayList();
            Editable text = getText();
            if (f34467b || text != null) {
                this.f34473g = new TokenSpanWatcher();
                this.f34474h = new TokenTextWatcher();
                this.f34476j = new ArrayList();
                m35249d();
                setTextIsSelectable(false);
                setLongClickable(false);
                setInputType((getInputType() | 524288) | 65536);
                setOnEditorActionListener(this);
                setFilters(new InputFilter[]{new C19141(this)});
                setDeletionStyle(TokenDeleteStyle.Clear);
                this.f34484r = true;
                return;
            }
            throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TokenCompleteTextView(android.content.Context r2) {
        /*
        r1 = this;
        r1.<init>(r2);
        r2 = 2;
        r2 = new char[r2];
        r2 = {44, 59};
        r1.f34469c = r2;
        r2 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenDeleteStyle._Parent;
        r1.f34477k = r2;
        r2 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenClickStyle.None;
        r1.f34478l = r2;
        r2 = "";
        r1.f34479m = r2;
        r2 = 0;
        r1.f34480n = r2;
        r0 = 0;
        r1.f34481o = r0;
        r0 = 1;
        r1.f34482p = r0;
        r1.f34483q = r2;
        r1.f34484r = r2;
        r1.f34485s = r0;
        r1.f34486t = r2;
        r1.f34487u = r2;
        r1.f34488v = r0;
        r0 = -1;
        r1.f34489w = r0;
        r1.f34468a = r2;
        r1.m35252e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.<init>(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TokenCompleteTextView(android.content.Context r1, android.util.AttributeSet r2) {
        /*
        r0 = this;
        r0.<init>(r1, r2);
        r1 = 2;
        r1 = new char[r1];
        r1 = {44, 59};
        r0.f34469c = r1;
        r1 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenDeleteStyle._Parent;
        r0.f34477k = r1;
        r1 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenClickStyle.None;
        r0.f34478l = r1;
        r1 = "";
        r0.f34479m = r1;
        r1 = 0;
        r0.f34480n = r1;
        r2 = 0;
        r0.f34481o = r2;
        r2 = 1;
        r0.f34482p = r2;
        r0.f34483q = r1;
        r0.f34484r = r1;
        r0.f34485s = r2;
        r0.f34486t = r1;
        r0.f34487u = r1;
        r0.f34488v = r2;
        r2 = -1;
        r0.f34489w = r2;
        r0.f34468a = r1;
        r0.m35252e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TokenCompleteTextView(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        /*
        r0 = this;
        r0.<init>(r1, r2, r3);
        r1 = 2;
        r1 = new char[r1];
        r1 = {44, 59};
        r0.f34469c = r1;
        r1 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenDeleteStyle._Parent;
        r0.f34477k = r1;
        r1 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenClickStyle.None;
        r0.f34478l = r1;
        r1 = "";
        r0.f34479m = r1;
        r1 = 0;
        r0.f34480n = r1;
        r2 = 0;
        r0.f34481o = r2;
        r2 = 1;
        r0.f34482p = r2;
        r0.f34483q = r1;
        r0.f34484r = r1;
        r0.f34485s = r2;
        r0.f34486t = r1;
        r0.f34487u = r1;
        r0.f34488v = r2;
        r2 = -1;
        r0.f34489w = r2;
        r0.f34468a = r1;
        r0.m35252e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    protected void performFiltering(CharSequence charSequence, int i, int i2, int i3) {
        if (i < this.f34479m.length()) {
            i = this.f34479m.length();
        }
        i3 = getFilter();
        if (i3 != 0) {
            if (this.f34480n) {
                i3.filter("");
                return;
            }
            i3.filter(charSequence.subSequence(i, i2), this);
        }
    }

    public void setTokenizer(Tokenizer tokenizer) {
        super.setTokenizer(tokenizer);
        this.f34470d = tokenizer;
    }

    public void setDeletionStyle(TokenDeleteStyle tokenDeleteStyle) {
        this.f34477k = tokenDeleteStyle;
    }

    public void setTokenClickStyle(TokenClickStyle tokenClickStyle) {
        this.f34478l = tokenClickStyle;
    }

    public void setTokenListener(TokenListener<T> tokenListener) {
        this.f34472f = tokenListener;
    }

    public void setPrefix(CharSequence charSequence) {
        this.f34479m = "";
        Editable text = getText();
        if (text != null) {
            text.insert(0, charSequence);
        }
        this.f34479m = charSequence;
        m35261j();
    }

    public List<T> getObjects() {
        return this.f34475i;
    }

    public void setSplitChar(char[] cArr) {
        char[] cArr2;
        if (cArr[0] == ' ') {
            cArr2 = new char[(cArr.length + 1)];
            cArr2[0] = '§';
            System.arraycopy(cArr, 0, cArr2, 1, cArr.length);
        } else {
            cArr2 = cArr;
        }
        this.f34469c = cArr2;
        setTokenizer(new CharacterTokenizer(cArr));
    }

    public void setSplitChar(char c) {
        setSplitChar(new char[]{c});
    }

    public void setAllowDuplicates(boolean z) {
        this.f34482p = z;
    }

    public void setPerformBestGuess(boolean z) {
        this.f34485s = z;
    }

    public void setAllowCollapse(boolean z) {
        this.f34488v = z;
    }

    public void setTokenLimit(int i) {
        this.f34489w = i;
    }

    public CharSequence getTextForAccessibility() {
        if (getObjects().size() == 0) {
            return getText();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence text = getText();
        int i = -1;
        int i2 = i;
        CharSequence charSequence = spannableStringBuilder;
        int i3 = 0;
        while (i3 < text.length()) {
            if (i3 == Selection.getSelectionStart(text)) {
                i = charSequence.length();
            }
            if (i3 == Selection.getSelectionEnd(text)) {
                i2 = charSequence.length();
            }
            TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(i3, i3, TokenImageSpan.class);
            if (tokenImageSpanArr.length > 0) {
                TokenImageSpan tokenImageSpan = tokenImageSpanArr[0];
                charSequence = charSequence.append(this.f34470d.terminateToken(tokenImageSpan.f29373a.toString()));
                i3 = text.getSpanEnd(tokenImageSpan);
            } else {
                charSequence = charSequence.append(text.subSequence(i3, i3 + 1));
            }
            i3++;
        }
        if (i3 == Selection.getSelectionStart(text)) {
            i = charSequence.length();
        }
        if (i3 == Selection.getSelectionEnd(text)) {
            i2 = charSequence.length();
        }
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(charSequence, i, i2);
        }
        return charSequence;
    }

    public final void m35273b() {
        if (m35254f().length() != 0) {
            Editable text = getText();
            int correctedTokenEnd = getCorrectedTokenEnd();
            text.delete(m35243b(correctedTokenEnd), correctedTokenEnd);
        }
    }

    public String getCompletionText() {
        if (m35254f().length() == 0) {
            return null;
        }
        Editable text = getText();
        int correctedTokenEnd = getCorrectedTokenEnd();
        return text.subSequence(m35243b(correctedTokenEnd), correctedTokenEnd).toString();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            CharSequence textForAccessibility = getTextForAccessibility();
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(textForAccessibility));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(textForAccessibility));
            accessibilityEvent.setItemCount(textForAccessibility.length());
        }
    }

    private int getCorrectedTokenEnd() {
        return this.f34470d.findTokenEnd(getText(), getSelectionEnd());
    }

    private int m35243b(int i) {
        i = this.f34470d.findTokenStart(getText(), i);
        return i < this.f34479m.length() ? this.f34479m.length() : i;
    }

    private String m35254f() {
        if (this.f34480n) {
            return "";
        }
        CharSequence text = getText();
        int correctedTokenEnd = getCorrectedTokenEnd();
        return TextUtils.substring(text, m35243b(correctedTokenEnd), correctedTokenEnd);
    }

    private float m35255g() {
        return (float) ((getWidth() - getPaddingLeft()) - getPaddingRight());
    }

    public void invalidate() {
        if (VERSION.SDK_INT >= 16 && this.f34484r && !this.f34468a) {
            this.f34468a = true;
            setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
            this.f34468a = false;
        }
        super.invalidate();
    }

    public boolean enoughToFilter() {
        if (this.f34470d != null) {
            if (!this.f34480n) {
                if (getSelectionEnd() < 0) {
                    return false;
                }
                int correctedTokenEnd = getCorrectedTokenEnd();
                if (correctedTokenEnd - m35243b(correctedTokenEnd) >= Math.max(getThreshold(), 1)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void performCompletion() {
        if ((getAdapter() == null || getListSelection() == -1) && enoughToFilter()) {
            Object a;
            if (getAdapter() == null || getAdapter().getCount() <= 0 || !this.f34485s) {
                a = mo7030a(m35254f());
            } else {
                a = getAdapter().getItem(0);
            }
            replaceText(convertSelectionToString(a));
            return;
        }
        super.performCompletion();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        InputConnection tokenInputConnection = new TokenInputConnection(this, onCreateInputConnection);
        editorInfo.imeOptions &= -1073741825;
        editorInfo.imeOptions |= 268435456;
        return tokenInputConnection;
    }

    private void m35258h() {
        performCompletion();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        i = super.onKeyUp(i, keyEvent);
        if (this.f34487u != null) {
            this.f34487u = null;
            m35258h();
        }
        return i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (!(i == 23 || i == 61)) {
            switch (i) {
                case 66:
                    break;
                case 67:
                    m35272a(1);
                    if (m35246b(false)) {
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (keyEvent.hasNoModifiers()) {
            this.f34487u = true;
            z = true;
            if (!z) {
                if (super.onKeyDown(i, keyEvent) != 0) {
                    return false;
                }
            }
            return true;
        }
        z = false;
        if (z) {
            if (super.onKeyDown(i, keyEvent) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean m35246b(boolean z) {
        if (this.f34478l != null && this.f34478l.f21675e) {
            Editable text = getText();
            int i = 0;
            if (text == null) {
                return false;
            }
            TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
            int length = tokenImageSpanArr.length;
            while (i < length) {
                TokenImageSpan tokenImageSpan = tokenImageSpanArr[i];
                if (tokenImageSpan.c.isSelected()) {
                    m35238a(tokenImageSpan);
                    z = true;
                    break;
                }
                i++;
            }
        }
        return z;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return null;
        }
        m35258h();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        Editable text = getText();
        boolean onTouchEvent = this.f34478l == TokenClickStyle.None ? super.onTouchEvent(motionEvent) : false;
        if (isFocused() && text != null && this.f34481o != null && actionMasked == 1) {
            actionMasked = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (actionMasked != -1) {
                TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(actionMasked, actionMasked, TokenImageSpan.class);
                if (tokenImageSpanArr.length > 0) {
                    tokenImageSpanArr[0].mo5022a();
                    onTouchEvent = true;
                } else {
                    m35263k();
                }
            }
        }
        return (onTouchEvent || this.f34478l == TokenClickStyle.None) ? onTouchEvent : super.onTouchEvent(motionEvent);
    }

    protected void onSelectionChanged(int i, int i2) {
        int i3 = 0;
        if (this.f34480n != 0) {
            i = 0;
        }
        if (!(this.f34478l == 0 || this.f34478l.f21675e == 0 || getText() == 0)) {
            m35263k();
        }
        if (this.f34479m == 0 || (i >= this.f34479m.length() && i >= this.f34479m.length())) {
            i2 = getText();
            if (i2 != 0) {
                TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) i2.getSpans(i, i, TokenImageSpan.class);
                int length = tokenImageSpanArr.length;
                while (i3 < length) {
                    Object obj = tokenImageSpanArr[i3];
                    int spanEnd = i2.getSpanEnd(obj);
                    if (i > spanEnd || i2.getSpanStart(obj) >= i) {
                        i3++;
                    } else if (spanEnd == i2.length()) {
                        setSelection(spanEnd);
                        return;
                    } else {
                        setSelection(spanEnd + 1);
                        return;
                    }
                }
            }
            super.onSelectionChanged(i, i);
            return;
        }
        setSelection(this.f34479m.length());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f34481o = getLayout();
    }

    public void mo7031a(boolean z) {
        this.f34483q = true;
        int lineVisibleEnd;
        if (z) {
            z = getText();
            if (z) {
                for (Object obj : (CountSpan[]) z.getSpans(0, z.length(), CountSpan.class)) {
                    z.delete(z.getSpanStart(obj), z.getSpanEnd(obj));
                    z.removeSpan(obj);
                }
                for (TokenImageSpan tokenImageSpan : this.f34476j) {
                    Object obj2 = tokenImageSpan.f29373a;
                    CharSequence obj3 = this.f34477k == TokenDeleteStyle.ToString ? obj2 != null ? obj2.toString() : "" : "";
                    m35245b(obj2, obj3);
                }
                this.f34476j.clear();
                if (this.f34480n) {
                    setSelection(this.f34479m.length());
                } else {
                    postDelayed(new Runnable(this) {
                        final /* synthetic */ TokenCompleteTextView f21652b;

                        public void run() {
                            this.f21652b.setSelection(z.length());
                        }
                    }, 10);
                }
                if (((TokenSpanWatcher[]) getText().getSpans(0, getText().length(), TokenSpanWatcher.class)).length == 0) {
                    z.setSpan(this.f34473g, 0, z.length(), 18);
                }
            }
        } else {
            z = getText();
            if (z && this.f34481o != null) {
                lineVisibleEnd = this.f34481o.getLineVisibleEnd(0);
                TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) z.getSpans(0, lineVisibleEnd, TokenImageSpan.class);
                int size = this.f34475i.size() - tokenImageSpanArr.length;
                CountSpan[] countSpanArr = (CountSpan[]) z.getSpans(0, lineVisibleEnd, CountSpan.class);
                if (size > 0 && countSpanArr.length == 0) {
                    lineVisibleEnd++;
                    CountSpan countSpan = new CountSpan(size, getContext(), getCurrentTextColor(), (int) getTextSize(), (int) m35255g());
                    z.insert(lineVisibleEnd, countSpan.f29372a);
                    if (Layout.getDesiredWidth(z, 0, countSpan.f29372a.length() + lineVisibleEnd, this.f34481o.getPaint()) > m35255g()) {
                        z.delete(lineVisibleEnd, countSpan.f29372a.length() + lineVisibleEnd);
                        if (tokenImageSpanArr.length > 0) {
                            lineVisibleEnd = z.getSpanStart(tokenImageSpanArr[tokenImageSpanArr.length - 1]);
                            countSpan.m30425a(size + 1);
                        } else {
                            lineVisibleEnd = this.f34479m.length();
                        }
                        z.insert(lineVisibleEnd, countSpan.f29372a);
                    }
                    z.setSpan(countSpan, lineVisibleEnd, countSpan.f29372a.length() + lineVisibleEnd, 33);
                    this.f34476j = new ArrayList(Arrays.asList((TokenImageSpan[]) z.getSpans(lineVisibleEnd + countSpan.f29372a.length(), z.length(), TokenImageSpan.class)));
                    for (TokenImageSpan a : this.f34476j) {
                        m35238a(a);
                    }
                }
            }
        }
        this.f34483q = false;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            performCompletion();
        }
        m35263k();
        if (this.f34488v != 0) {
            mo7031a(z);
        }
    }

    protected CharSequence convertSelectionToString(Object obj) {
        this.f34471e = obj;
        switch (this.f34477k) {
            case Clear:
                return "";
            case PartialCompletion:
                return m35254f();
            case ToString:
                return obj != null ? obj.toString() : "";
            default:
                return super.convertSelectionToString(obj);
        }
    }

    private SpannableStringBuilder m35237a(CharSequence charSequence) {
        char c = this.f34469c[0];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append(this.f34470d.terminateToken(charSequence).toString());
        return new SpannableStringBuilder(stringBuilder.toString());
    }

    private TokenImageSpan m35248d(T t) {
        if (t == null) {
            return null;
        }
        return new TokenImageSpan(this, mo7029a((Object) t), t, (int) m35255g());
    }

    protected void replaceText(CharSequence charSequence) {
        clearComposingText();
        if (this.f34471e != null) {
            if (!this.f34471e.toString().equals("")) {
                int i;
                charSequence = m35237a(charSequence);
                TokenImageSpan d = m35248d(this.f34471e);
                Editable text = getText();
                int selectionEnd = getSelectionEnd();
                if (this.f34480n) {
                    i = selectionEnd;
                } else {
                    selectionEnd = getCorrectedTokenEnd();
                    i = selectionEnd;
                    selectionEnd = m35243b(selectionEnd);
                }
                String substring = TextUtils.substring(text, selectionEnd, i);
                if (text != null) {
                    if (d == null) {
                        text.replace(selectionEnd, i, "");
                    } else if (this.f34482p || !this.f34475i.contains(d.f29373a)) {
                        QwertyKeyListener.markAsReplaced(text, selectionEnd, i, substring);
                        text.replace(selectionEnd, i, charSequence);
                        text.setSpan(d, selectionEnd, (charSequence.length() + selectionEnd) - 1, 33);
                    } else {
                        text.replace(selectionEnd, i, "");
                    }
                }
            }
        }
    }

    public boolean extractText(ExtractedTextRequest extractedTextRequest, ExtractedText extractedText) {
        try {
            return super.extractText(extractedTextRequest, extractedText);
        } catch (ExtractedTextRequest extractedTextRequest2) {
            Log.d("TokenAutoComplete", "extractText hit IndexOutOfBoundsException. This may be normal.", extractedTextRequest2);
            return null;
        }
    }

    public final void m35270a(final T t, final CharSequence charSequence) {
        post(new Runnable(this) {
            final /* synthetic */ TokenCompleteTextView f21655c;

            public void run() {
                if (t != null) {
                    if (!this.f21655c.f34482p && this.f21655c.f34475i.contains(t)) {
                        return;
                    }
                    if (this.f21655c.f34489w == -1 || this.f21655c.f34475i.size() != this.f21655c.f34489w) {
                        this.f21655c.m35245b(t, charSequence);
                        if (this.f21655c.getText() != null && this.f21655c.isFocused()) {
                            this.f21655c.setSelection(this.f21655c.getText().length());
                        }
                    }
                }
            }
        });
    }

    public final void m35274b(T t) {
        m35270a((Object) t, (CharSequence) "");
    }

    public final void m35276c(final T t) {
        post(new Runnable(this) {
            final /* synthetic */ TokenCompleteTextView f21657b;

            public void run() {
                Editable text = this.f21657b.getText();
                if (text != null) {
                    int i;
                    TokenImageSpan tokenImageSpan;
                    ArrayList arrayList = new ArrayList();
                    for (TokenImageSpan tokenImageSpan2 : this.f21657b.f34476j) {
                        if (tokenImageSpan2.f29373a.equals(t)) {
                            arrayList.add(tokenImageSpan2);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        i = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        tokenImageSpan = (TokenImageSpan) it.next();
                        this.f21657b.f34476j.remove(tokenImageSpan);
                        this.f21657b.f34473g.onSpanRemoved(text, tokenImageSpan, 0, 0);
                    }
                    this.f21657b.m35259i();
                    TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
                    int length = tokenImageSpanArr.length;
                    while (i < length) {
                        tokenImageSpan = tokenImageSpanArr[i];
                        if (tokenImageSpan.f29373a.equals(t)) {
                            this.f21657b.m35238a(tokenImageSpan);
                        }
                        i++;
                    }
                }
            }
        });
    }

    private void m35259i() {
        Editable text = getText();
        int i = 0;
        CountSpan[] countSpanArr = (CountSpan[]) text.getSpans(0, text.length(), CountSpan.class);
        int size = this.f34476j.size();
        int length = countSpanArr.length;
        while (i < length) {
            CountSpan countSpan = countSpanArr[i];
            if (size == 0) {
                text.delete(text.getSpanStart(countSpan), text.getSpanEnd(countSpan));
                text.removeSpan(countSpan);
            } else {
                countSpan.m30425a(this.f34476j.size());
                text.setSpan(countSpan, text.getSpanStart(countSpan), text.getSpanEnd(countSpan), 33);
            }
            i++;
        }
    }

    private void m35238a(TokenImageSpan tokenImageSpan) {
        Editable text = getText();
        if (text != null) {
            if (((TokenSpanWatcher[]) text.getSpans(0, text.length(), TokenSpanWatcher.class)).length == 0) {
                this.f34473g.onSpanRemoved(text, tokenImageSpan, text.getSpanStart(tokenImageSpan), text.getSpanEnd(tokenImageSpan));
            }
            text.delete(text.getSpanStart(tokenImageSpan), text.getSpanEnd(tokenImageSpan) + 1);
            if (this.f34488v != null && isFocused() == null) {
                m35259i();
            }
        }
    }

    private void m35245b(T t, CharSequence charSequence) {
        charSequence = m35237a(charSequence);
        TokenImageSpan d = m35248d((Object) t);
        Spannable text = getText();
        if (text != null) {
            if (this.f34488v && !isFocused()) {
                if (!this.f34476j.isEmpty()) {
                    this.f34476j.add(d);
                    this.f34473g.onSpanAdded(text, d, 0, 0);
                    m35259i();
                    return;
                }
            }
            int length = text.length();
            if (this.f34480n) {
                length = this.f34479m.length();
                text.insert(length, charSequence);
            } else {
                CharSequence f = m35254f();
                if (f != null && f.length() > 0) {
                    length = TextUtils.indexOf(text, f);
                }
                text.insert(length, charSequence);
            }
            text.setSpan(d, length, (charSequence.length() + length) - 1, 33);
            if (isFocused() == null && this.f34488v != null) {
                mo7031a(false);
            }
            if (this.f34475i.contains(t) == null) {
                this.f34473g.onSpanAdded(text, d, 0, 0);
            }
        }
    }

    public final void m35275c() {
        post(new C19185(this));
    }

    private void m35261j() {
        Editable text = getText();
        CharSequence hint = getHint();
        if (text != null) {
            if (hint != null) {
                if (this.f34479m.length() > 0) {
                    int i = 0;
                    HintSpan[] hintSpanArr = (HintSpan[]) text.getSpans(0, text.length(), HintSpan.class);
                    Object obj = null;
                    int length = this.f34479m.length();
                    if (hintSpanArr.length > 0) {
                        obj = hintSpanArr[0];
                        length += text.getSpanEnd(obj) - text.getSpanStart(obj);
                    }
                    if (text.length() == length) {
                        this.f34480n = true;
                        if (obj == null) {
                            Typeface typeface = getTypeface();
                            if (typeface != null) {
                                i = typeface.getStyle();
                            }
                            ColorStateList hintTextColors = getHintTextColors();
                            HintSpan hintSpan = new HintSpan(i, (int) getTextSize(), hintTextColors, hintTextColors);
                            text.insert(this.f34479m.length(), hint);
                            text.setSpan(hintSpan, this.f34479m.length(), this.f34479m.length() + getHint().length(), 33);
                            setSelection(this.f34479m.length());
                        }
                    } else if (obj != null) {
                        int spanStart = text.getSpanStart(obj);
                        int spanEnd = text.getSpanEnd(obj);
                        text.removeSpan(obj);
                        text.replace(spanStart, spanEnd, "");
                        this.f34480n = false;
                    }
                }
            }
        }
    }

    private void m35263k() {
        if (this.f34478l != null) {
            if (this.f34478l.f21675e) {
                Editable text = getText();
                if (text != null) {
                    for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
                        tokenImageSpan.c.setSelected(false);
                    }
                    invalidate();
                }
            }
        }
    }

    protected ArrayList<Serializable> getSerializableObjects() {
        ArrayList<Serializable> arrayList = new ArrayList();
        for (Object next : getObjects()) {
            if (next instanceof Serializable) {
                arrayList.add((Serializable) next);
            } else {
                StringBuilder stringBuilder = new StringBuilder("Unable to save '");
                stringBuilder.append(next);
                stringBuilder.append("'");
                Log.e("TokenAutoComplete", stringBuilder.toString());
            }
        }
        if (arrayList.size() != this.f34475i.size()) {
            Log.e("TokenAutoComplete", "You should make your objects Serializable or override\ngetSerializableObjects and convertSerializableArrayToObjectArray");
        }
        return arrayList;
    }

    public Parcelable onSaveInstanceState() {
        ArrayList serializableObjects = getSerializableObjects();
        Editable text = getText();
        if (text != null) {
            for (Object removeSpan : (TokenSpanWatcher[]) text.getSpans(0, text.length(), TokenSpanWatcher.class)) {
                text.removeSpan(removeSpan);
            }
            removeTextChangedListener(this.f34474h);
        }
        this.f34486t = true;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        this.f34486t = false;
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.f21662a = this.f34479m;
        savedState.f21663b = this.f34488v;
        savedState.f21664c = this.f34482p;
        savedState.f21665d = this.f34485s;
        savedState.f21666e = this.f34478l;
        savedState.f21667f = this.f34477k;
        savedState.f21668g = serializableObjects;
        savedState.f21669h = this.f34469c;
        m35249d();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setText(savedState.f21662a);
            this.f34479m = savedState.f21662a;
            m35261j();
            this.f34488v = savedState.f21663b;
            this.f34482p = savedState.f21664c;
            this.f34485s = savedState.f21665d;
            this.f34478l = savedState.f21666e;
            this.f34477k = savedState.f21667f;
            this.f34469c = savedState.f21669h;
            m35249d();
            parcelable = savedState.f21668g.iterator();
            while (parcelable.hasNext()) {
                m35270a(parcelable.next(), (CharSequence) "");
            }
            if (isFocused() == null && this.f34488v != null) {
                post(new C19196(this));
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final boolean m35272a(int i) {
        if (this.f34475i.size() <= 0) {
            return true;
        }
        getSelectionEnd();
        if (i == 1) {
            getSelectionStart();
        }
        i = getText();
        int i2 = 0;
        TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) i.getSpans(0, i.length(), TokenImageSpan.class);
        int length = tokenImageSpanArr.length;
        while (i2 < length) {
            Object obj = tokenImageSpanArr[i2];
            i.getSpanStart(obj);
            i.getSpanEnd(obj);
            i2++;
        }
        return true;
    }

    static /* synthetic */ boolean m35242a(TokenCompleteTextView tokenCompleteTextView, char c) {
        for (char c2 : tokenCompleteTextView.f34469c) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }
}
