package org.jsoup.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

public class Elements extends ArrayList<Element> {
    public Elements(int i) {
        super(i);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public final Element m28625a() {
        return isEmpty() ? null : (Element) get(0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(element.aU_());
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ Object clone() {
        Elements elements = new Elements(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            elements.add(((Element) it.next()).mo6856c());
        }
        return elements;
    }
}
