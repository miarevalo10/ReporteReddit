package com.reddit.datalibrary.frontpage.service.api;

import org.parceler.Parcel;

@Parcel
public class FileUploadResponse {
    public String fileKey;
    public String fileUrl;
    public boolean success;

    public FileUploadResponse(String str, String str2, boolean z) {
        this.fileUrl = str;
        this.fileKey = str2;
        this.success = z;
    }
}
