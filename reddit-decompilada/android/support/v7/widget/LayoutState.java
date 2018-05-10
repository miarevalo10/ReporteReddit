package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.State;

class LayoutState {
    boolean f2289a = true;
    int f2290b;
    int f2291c;
    int f2292d;
    int f2293e;
    int f2294f = 0;
    int f2295g = 0;
    boolean f2296h;
    boolean f2297i;

    LayoutState() {
    }

    final boolean m1971a(State state) {
        return (this.f2291c < 0 || this.f2291c >= state.getItemCount()) ? null : true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutState{mAvailable=");
        stringBuilder.append(this.f2290b);
        stringBuilder.append(", mCurrentPosition=");
        stringBuilder.append(this.f2291c);
        stringBuilder.append(", mItemDirection=");
        stringBuilder.append(this.f2292d);
        stringBuilder.append(", mLayoutDirection=");
        stringBuilder.append(this.f2293e);
        stringBuilder.append(", mStartLine=");
        stringBuilder.append(this.f2294f);
        stringBuilder.append(", mEndLine=");
        stringBuilder.append(this.f2295g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
