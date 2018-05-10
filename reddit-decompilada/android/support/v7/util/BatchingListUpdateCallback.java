package android.support.v7.util;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    final ListUpdateCallback f11676a;
    int f11677b = 0;
    int f11678c = -1;
    int f11679d = -1;
    Object f11680e = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f11676a = listUpdateCallback;
    }

    public final void m10395a() {
        if (this.f11677b != 0) {
            switch (this.f11677b) {
                case 1:
                    this.f11676a.mo505a(this.f11678c, this.f11679d);
                    break;
                case 2:
                    this.f11676a.mo507b(this.f11678c, this.f11679d);
                    break;
                case 3:
                    this.f11676a.mo506a(this.f11678c, this.f11679d, this.f11680e);
                    break;
                default:
                    break;
            }
            this.f11680e = null;
            this.f11677b = 0;
        }
    }

    public final void mo505a(int i, int i2) {
        if (this.f11677b != 1 || i < this.f11678c || i > this.f11678c + this.f11679d) {
            m10395a();
            this.f11678c = i;
            this.f11679d = i2;
            this.f11677b = 1;
            return;
        }
        this.f11679d += i2;
        this.f11678c = Math.min(i, this.f11678c);
    }

    public final void mo507b(int i, int i2) {
        if (this.f11677b != 2 || this.f11678c < i || this.f11678c > i + i2) {
            m10395a();
            this.f11678c = i;
            this.f11679d = i2;
            this.f11677b = 2;
            return;
        }
        this.f11679d += i2;
        this.f11678c = i;
    }

    public final void mo508c(int i, int i2) {
        m10395a();
        this.f11676a.mo508c(i, i2);
    }

    public final void mo506a(int i, int i2, Object obj) {
        if (this.f11677b == 3 && i <= this.f11678c + this.f11679d) {
            int i3 = i + i2;
            if (i3 >= this.f11678c && this.f11680e == obj) {
                i2 = this.f11678c + this.f11679d;
                this.f11678c = Math.min(i, this.f11678c);
                this.f11679d = Math.max(i2, i3) - this.f11678c;
                return;
            }
        }
        m10395a();
        this.f11678c = i;
        this.f11679d = i2;
        this.f11680e = obj;
        this.f11677b = 3;
    }
}
