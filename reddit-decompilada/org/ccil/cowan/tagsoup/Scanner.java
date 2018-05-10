package org.ccil.cowan.tagsoup;

import java.io.IOException;
import java.io.Reader;
import org.xml.sax.SAXException;

public interface Scanner {
    void mo6172a();

    void mo6173a(Reader reader, ScanHandler scanHandler) throws IOException, SAXException;

    void mo6174a(String str, String str2);
}
