package org.jsoup.parser;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

abstract class Token {
    TokenType f27085a;

    enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    static final class Character extends Token {
        String f33363b;

        Character() {
            super();
            this.a = TokenType.Character;
        }

        final Token mo6350a() {
            this.f33363b = null;
            return this;
        }

        public final String toString() {
            return this.f33363b;
        }
    }

    static final class Comment extends Token {
        final StringBuilder f33364b;
        boolean f33365c;

        final Token mo6350a() {
            Token.m28571a(this.f33364b);
            this.f33365c = false;
            return this;
        }

        Comment() {
            super();
            this.f33364b = new StringBuilder();
            this.f33365c = false;
            this.a = TokenType.Comment;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("<!--");
            stringBuilder.append(this.f33364b.toString());
            stringBuilder.append("-->");
            return stringBuilder.toString();
        }
    }

    static final class Doctype extends Token {
        final StringBuilder f33366b;
        String f33367c;
        final StringBuilder f33368d;
        final StringBuilder f33369e;
        boolean f33370f;

        Doctype() {
            super();
            this.f33366b = new StringBuilder();
            this.f33367c = null;
            this.f33368d = new StringBuilder();
            this.f33369e = new StringBuilder();
            this.f33370f = false;
            this.a = TokenType.Doctype;
        }

        final Token mo6350a() {
            Token.m28571a(this.f33366b);
            this.f33367c = null;
            Token.m28571a(this.f33368d);
            Token.m28571a(this.f33369e);
            this.f33370f = false;
            return this;
        }
    }

    static final class EOF extends Token {
        final Token mo6350a() {
            return this;
        }

        EOF() {
            super();
            this.a = TokenType.EOF;
        }
    }

    static abstract class Tag extends Token {
        protected String f33371b;
        protected String f33372c;
        String f33373d;
        boolean f33374e = false;
        boolean f33375f = false;
        Attributes f33376g;
        private StringBuilder f33377h = new StringBuilder();
        private String f33378i;
        private boolean f33379j = false;

        Tag() {
            super();
        }

        /* synthetic */ Token mo6350a() {
            return mo6857h();
        }

        Tag mo6857h() {
            this.f33371b = null;
            this.f33372c = null;
            this.f33373d = null;
            Token.m28571a(this.f33377h);
            this.f33378i = null;
            this.f33374e = false;
            this.f33379j = false;
            this.f33375f = false;
            this.f33376g = null;
            return this;
        }

        final void m34068i() {
            if (this.f33376g == null) {
                this.f33376g = new Attributes();
            }
            if (this.f33373d != null) {
                Attribute attribute;
                if (this.f33379j) {
                    attribute = new Attribute(this.f33373d, this.f33377h.length() > 0 ? this.f33377h.toString() : this.f33378i);
                } else if (this.f33374e) {
                    attribute = new Attribute(this.f33373d, "");
                } else {
                    attribute = new BooleanAttribute(this.f33373d);
                }
                this.f33376g.m28471a(attribute);
            }
            this.f33373d = null;
            this.f33374e = false;
            this.f33379j = false;
            Token.m28571a(this.f33377h);
            this.f33378i = null;
        }

        final String m34069j() {
            boolean z;
            if (this.f33371b != null) {
                if (this.f33371b.length() != 0) {
                    z = false;
                    Validate.m28460b(z);
                    return this.f33371b;
                }
            }
            z = true;
            Validate.m28460b(z);
            return this.f33371b;
        }

        final String m34070k() {
            return this.f33372c;
        }

        final Tag m34058a(String str) {
            this.f33371b = str;
            this.f33372c = str.toLowerCase();
            return this;
        }

        final void m34063b(String str) {
            if (this.f33371b != null) {
                str = this.f33371b.concat(str);
            }
            this.f33371b = str;
            this.f33372c = this.f33371b.toLowerCase();
        }

        final void m34060a(char c) {
            m34063b(String.valueOf(c));
        }

        final void m34065c(String str) {
            if (this.f33373d != null) {
                str = this.f33373d.concat(str);
            }
            this.f33373d = str;
        }

        final void m34062b(char c) {
            m34065c(String.valueOf(c));
        }

        final void m34066d(String str) {
            m34057l();
            if (this.f33377h.length() == 0) {
                this.f33378i = str;
            } else {
                this.f33377h.append(str);
            }
        }

        final void m34064c(char c) {
            m34057l();
            this.f33377h.append(c);
        }

        final void m34061a(int[] iArr) {
            m34057l();
            for (int appendCodePoint : iArr) {
                this.f33377h.appendCodePoint(appendCodePoint);
            }
        }

        private void m34057l() {
            this.f33379j = true;
            if (this.f33378i != null) {
                this.f33377h.append(this.f33378i);
                this.f33378i = null;
            }
        }
    }

    static final class EndTag extends Tag {
        EndTag() {
            this.a = TokenType.EndTag;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("</");
            stringBuilder.append(m34069j());
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    static final class StartTag extends Tag {
        final /* synthetic */ Token mo6350a() {
            return mo6857h();
        }

        StartTag() {
            this.g = new Attributes();
            this.a = TokenType.StartTag;
        }

        final Tag mo6857h() {
            super.mo6857h();
            this.g = new Attributes();
            return this;
        }

        final StartTag m36605a(String str, Attributes attributes) {
            this.b = str;
            this.g = attributes;
            this.c = this.b.toLowerCase();
            return this;
        }

        public final String toString() {
            if (this.g == null || this.g.m28467a() <= 0) {
                StringBuilder stringBuilder = new StringBuilder(Operation.LESS_THAN);
                stringBuilder.append(m34069j());
                stringBuilder.append(Operation.GREATER_THAN);
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder(Operation.LESS_THAN);
            stringBuilder.append(m34069j());
            stringBuilder.append(" ");
            stringBuilder.append(this.g.toString());
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    abstract Token mo6350a();

    private Token() {
    }

    static void m28571a(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    final boolean m28573b() {
        return this.f27085a == TokenType.Doctype;
    }

    final boolean m28574c() {
        return this.f27085a == TokenType.StartTag;
    }

    final boolean m28575d() {
        return this.f27085a == TokenType.EndTag;
    }

    final boolean m28576e() {
        return this.f27085a == TokenType.Comment;
    }

    final boolean m28577f() {
        return this.f27085a == TokenType.Character;
    }

    final boolean m28578g() {
        return this.f27085a == TokenType.EOF;
    }
}
