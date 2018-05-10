package com.bea.xml.stream;

import com.bea.xml.stream.util.ElementTypeNames;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

public class EventState {
    private List attributes;
    private String data;
    private String extraData;
    private List namespaces;
    private QName qname;
    private int type;

    public EventState(int i) {
        this.type = i;
        this.attributes = new ArrayList();
        this.namespaces = new ArrayList();
    }

    public void clear() {
        this.qname = null;
        this.attributes = new ArrayList();
        this.namespaces = new ArrayList();
        this.data = null;
        this.extraData = null;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public QName getName() {
        return this.qname;
    }

    public String getLocalName() {
        return this.qname.getLocalPart();
    }

    public String getPrefix() {
        return this.qname.getPrefix();
    }

    public String getNamespaceURI() {
        return this.qname.getNamespaceURI();
    }

    public void setName(QName qName) {
        this.qname = qName;
    }

    public void setAttributes(List list) {
        this.attributes = list;
    }

    public void addAttribute(Object obj) {
        this.attributes.add(obj);
    }

    public void addNamespace(Object obj) {
        this.namespaces.add(obj);
    }

    public List getAttributes() {
        return this.attributes;
    }

    public void setNamespaces(List list) {
        this.namespaces = list;
    }

    public List getNamespaces() {
        return this.namespaces;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer("[");
        stringBuffer2.append(ElementTypeNames.m2472a(this.type));
        stringBuffer2.append("]");
        stringBuffer.append(stringBuffer2.toString());
        if (this.qname != null) {
            stringBuffer2 = new StringBuffer("[name='");
            stringBuffer2.append(this.qname);
            stringBuffer2.append("']");
            stringBuffer.append(stringBuffer2.toString());
        }
        for (Object append : this.namespaces) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(append);
            stringBuffer3.append(" ");
            stringBuffer.append(stringBuffer3.toString());
        }
        for (Object append2 : this.attributes) {
            stringBuffer3 = new StringBuffer();
            stringBuffer3.append(append2);
            stringBuffer3.append(" ");
            stringBuffer.append(stringBuffer3.toString());
        }
        if (this.data != null) {
            stringBuffer2 = new StringBuffer(",data=[");
            stringBuffer2.append(this.data);
            stringBuffer2.append("]");
            stringBuffer.append(stringBuffer2.toString());
        }
        if (this.extraData != null) {
            stringBuffer2 = new StringBuffer(",extradata=[");
            stringBuffer2.append(this.extraData);
            stringBuffer2.append("]");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }
}
