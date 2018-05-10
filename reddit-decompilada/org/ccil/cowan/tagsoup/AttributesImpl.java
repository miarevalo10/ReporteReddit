package org.ccil.cowan.tagsoup;

import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    int f26728a;
    String[] f26729b;

    public AttributesImpl() {
        this.f26728a = 0;
        this.f26729b = null;
    }

    public AttributesImpl(Attributes attributes) {
        m28338a(attributes);
    }

    public int getLength() {
        return this.f26728a;
    }

    public String getURI(int i) {
        return (i < 0 || i >= this.f26728a) ? 0 : this.f26729b[i * 5];
    }

    public String getLocalName(int i) {
        return (i < 0 || i >= this.f26728a) ? 0 : this.f26729b[(i * 5) + 1];
    }

    public String getQName(int i) {
        return (i < 0 || i >= this.f26728a) ? 0 : this.f26729b[(i * 5) + 2];
    }

    public String getType(int i) {
        return (i < 0 || i >= this.f26728a) ? 0 : this.f26729b[(i * 5) + 3];
    }

    public String getValue(int i) {
        return (i < 0 || i >= this.f26728a) ? 0 : this.f26729b[(i * 5) + 4];
    }

    public int getIndex(String str, String str2) {
        int i = this.f26728a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.f26729b[i2].equals(str) && this.f26729b[i2 + 1].equals(str2)) {
                return i2 / 5;
            }
            i2 += 5;
        }
        return -1;
    }

    public int getIndex(String str) {
        int i = this.f26728a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.f26729b[i2 + 2].equals(str)) {
                return i2 / 5;
            }
        }
        return -1;
    }

    public String getType(String str, String str2) {
        int i = this.f26728a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.f26729b[i2].equals(str) && this.f26729b[i2 + 1].equals(str2)) {
                return this.f26729b[i2 + 3];
            }
            i2 += 5;
        }
        return null;
    }

    public String getType(String str) {
        int i = this.f26728a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.f26729b[i2 + 2].equals(str)) {
                return this.f26729b[i2 + 3];
            }
        }
        return null;
    }

    public String getValue(String str, String str2) {
        int i = this.f26728a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.f26729b[i2].equals(str) && this.f26729b[i2 + 1].equals(str2)) {
                return this.f26729b[i2 + 4];
            }
            i2 += 5;
        }
        return null;
    }

    public String getValue(String str) {
        int i = this.f26728a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.f26729b[i2 + 2].equals(str)) {
                return this.f26729b[i2 + 4];
            }
        }
        return null;
    }

    public final void m28340a(int i) {
        if (i < 0 || i >= this.f26728a) {
            m28339b(i);
            return;
        }
        if (i < this.f26728a - 1) {
            System.arraycopy(this.f26729b, (i + 1) * 5, this.f26729b, i * 5, ((this.f26728a - i) - 1) * 5);
        }
        i = (this.f26728a - 1) * 5;
        int i2 = i + 1;
        this.f26729b[i] = null;
        int i3 = i2 + 1;
        this.f26729b[i2] = null;
        i2 = i3 + 1;
        this.f26729b[i3] = null;
        i3 = i2 + 1;
        this.f26729b[i2] = null;
        this.f26729b[i3] = null;
        this.f26728a--;
    }

    static void m28339b(int i) throws ArrayIndexOutOfBoundsException {
        StringBuffer stringBuffer = new StringBuffer("Attempt to modify attribute at illegal index: ");
        stringBuffer.append(i);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    private void m28338a(Attributes attributes) {
        int i = 0;
        if (this.f26729b != null) {
            for (int i2 = 0; i2 < this.f26728a * 5; i2++) {
                this.f26729b[i2] = null;
            }
        }
        this.f26728a = 0;
        this.f26728a = attributes.getLength();
        if (this.f26728a > 0) {
            this.f26729b = new String[(this.f26728a * 5)];
            while (i < this.f26728a) {
                int i3 = i * 5;
                this.f26729b[i3] = attributes.getURI(i);
                this.f26729b[i3 + 1] = attributes.getLocalName(i);
                this.f26729b[i3 + 2] = attributes.getQName(i);
                this.f26729b[i3 + 3] = attributes.getType(i);
                this.f26729b[i3 + 4] = attributes.getValue(i);
                i++;
            }
        }
    }
}
