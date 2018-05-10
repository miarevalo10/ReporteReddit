package org.apache.commons.cli;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public abstract class Parser implements CommandLineParser {
    protected CommandLine f33209a;
    private Options f33210b;
    private List f33211c;

    protected abstract String[] mo6792b(Options options, String[] strArr);

    private void m33814a(org.apache.commons.cli.Option r4, java.util.ListIterator r5) throws org.apache.commons.cli.ParseException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0038;
    L_0x0006:
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        r1 = r3.f33210b;
        r1 = r1.m28329a(r0);
        if (r1 == 0) goto L_0x0020;
    L_0x0014:
        r1 = "-";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0020;
    L_0x001c:
        r5.previous();
        goto L_0x0038;
    L_0x0020:
        r0 = org.apache.commons.cli.Util.m28332b(r0);	 Catch:{ RuntimeException -> 0x0035 }
        r1 = r4.f26705g;	 Catch:{ RuntimeException -> 0x0035 }
        r2 = -1;	 Catch:{ RuntimeException -> 0x0035 }
        if (r1 == r2) goto L_0x002d;	 Catch:{ RuntimeException -> 0x0035 }
    L_0x0029:
        r4.m28323a(r0);	 Catch:{ RuntimeException -> 0x0035 }
        goto L_0x0000;	 Catch:{ RuntimeException -> 0x0035 }
    L_0x002d:
        r0 = new java.lang.RuntimeException;	 Catch:{ RuntimeException -> 0x0035 }
        r1 = "NO_ARGS_ALLOWED";	 Catch:{ RuntimeException -> 0x0035 }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0035 }
        throw r0;	 Catch:{ RuntimeException -> 0x0035 }
    L_0x0035:
        r5.previous();
    L_0x0038:
        r5 = r4.f26706h;
        r5 = r5.isEmpty();
        if (r5 == 0) goto L_0x0042;
    L_0x0040:
        r5 = 0;
        goto L_0x0052;
    L_0x0042:
        r5 = r4.f26706h;
        r0 = r4.f26706h;
        r0 = r0.size();
        r0 = new java.lang.String[r0];
        r5 = r5.toArray(r0);
        r5 = (java.lang.String[]) r5;
    L_0x0052:
        if (r5 != 0) goto L_0x005e;
    L_0x0054:
        r5 = r4.f26704f;
        if (r5 != 0) goto L_0x005e;
    L_0x0058:
        r5 = new org.apache.commons.cli.MissingArgumentException;
        r5.<init>(r4);
        throw r5;
    L_0x005e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Parser.a(org.apache.commons.cli.Option, java.util.ListIterator):void");
    }

    public final CommandLine mo6171a(Options options, String[] strArr) throws ParseException {
        for (Option option : options.m28327a()) {
            option.f26706h.clear();
        }
        this.f33210b = options;
        this.f33211c = new ArrayList(options.f26714c);
        this.f33209a = new CommandLine();
        options = null;
        if (strArr == null) {
            strArr = new String[0];
        }
        ListIterator listIterator = Arrays.asList(mo6792b(this.f33210b, strArr)).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (!"--".equals(str)) {
                if (!Operation.MINUS.equals(str)) {
                    if (!str.startsWith(Operation.MINUS)) {
                        this.f33209a.m28314b(str);
                    } else if (!this.f33210b.m28329a(str)) {
                        this.f33209a.m28314b(str);
                    } else if (this.f33210b.m28329a(str)) {
                        Option option2;
                        Options options2 = this.f33210b;
                        str = Util.m28331a(str);
                        if (options2.f26712a.containsKey(str)) {
                            option2 = (Option) options2.f26712a.get(str);
                        } else {
                            option2 = (Option) options2.f26713b.get(str);
                        }
                        option2 = (Option) option2.clone();
                        if (option2.f26703e) {
                            this.f33211c.remove(option2.m28322a());
                        }
                        if (this.f33210b.m28330b(option2) != null) {
                            OptionGroup b = this.f33210b.m28330b(option2);
                            if (b.f26710b) {
                                this.f33211c.remove(b);
                            }
                            if (b.f26709a != null) {
                                if (!b.f26709a.equals(option2.f26699a)) {
                                    throw new AlreadySelectedException(b, option2);
                                }
                            }
                            b.f26709a = option2.f26699a;
                        }
                        if (option2.m28325c()) {
                            m33814a(option2, listIterator);
                        }
                        this.f33209a.f26689b.add(option2);
                        if (options != null) {
                            while (listIterator.hasNext()) {
                                str = (String) listIterator.next();
                                if (!"--".equals(str)) {
                                    this.f33209a.m28314b(str);
                                }
                            }
                        }
                    } else {
                        strArr = new StringBuffer("Unrecognized option: ");
                        strArr.append(str);
                        throw new UnrecognizedOptionException(strArr.toString(), str);
                    }
                }
            }
            options = 1;
            if (options != null) {
                while (listIterator.hasNext()) {
                    str = (String) listIterator.next();
                    if (!"--".equals(str)) {
                        this.f33209a.m28314b(str);
                    }
                }
            }
        }
        if (this.f33211c.isEmpty() != null) {
            return this.f33209a;
        }
        throw new MissingOptionException(this.f33211c);
    }
}
