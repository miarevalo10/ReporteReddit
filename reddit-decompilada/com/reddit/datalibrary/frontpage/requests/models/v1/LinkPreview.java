package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.reddit.frontpage.domain.model.Image;
import com.reddit.frontpage.domain.model.Preview;
import com.reddit.frontpage.domain.model.Variant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class LinkPreview extends BaseModel implements Serializable {
    ImageResolution gif;
    List<ImageResolution> gifResolutions;
    ImageResolution mp4;
    List<ImageResolution> mp4Resolutions;
    ImageResolution obfuscated;
    List<ImageResolution> obfuscatedResolutions;
    RedditVideo redditVideoPreview;
    ImageResolution source;
    List<ImageResolution> sourceResolutions;

    LinkPreview() {
    }

    public LinkPreview(ImageResolution imageResolution, List<ImageResolution> list, ImageResolution imageResolution2, List<ImageResolution> list2, ImageResolution imageResolution3, List<ImageResolution> list3, ImageResolution imageResolution4, List<ImageResolution> list4, RedditVideo redditVideo) {
        this.source = imageResolution;
        if (list == null) {
            list = new ArrayList();
        }
        this.sourceResolutions = list;
        this.obfuscated = imageResolution2;
        if (list2 == null) {
            list2 = new ArrayList();
        }
        this.obfuscatedResolutions = list2;
        this.gif = imageResolution3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        this.gifResolutions = list3;
        this.mp4 = imageResolution4;
        if (list4 == null) {
            list4 = new ArrayList();
        }
        this.mp4Resolutions = list4;
        this.redditVideoPreview = redditVideo;
    }

    public LinkPreview(Preview preview) {
        Image image = (Image) preview.getImages().get(0);
        this.source = new ImageResolution(image.getSource());
        this.sourceResolutions = Lists.m7163a(image.getResolutions(), LinkPreview$$Lambda$0.$instance);
        Variant obfuscated = image.getVariants().getObfuscated();
        if (obfuscated != null) {
            this.obfuscated = new ImageResolution(obfuscated.getSource());
            this.obfuscatedResolutions = Lists.m7163a(obfuscated.getResolutions(), LinkPreview$$Lambda$1.$instance);
        }
        obfuscated = image.getVariants().getGif();
        if (obfuscated != null) {
            this.gif = new ImageResolution(obfuscated.getSource());
            this.gifResolutions = Lists.m7163a(obfuscated.getResolutions(), LinkPreview$$Lambda$2.$instance);
        }
        Variant mp4 = image.getVariants().getMp4();
        if (mp4 != null) {
            this.mp4 = new ImageResolution(mp4.getSource());
            this.mp4Resolutions = Lists.m7163a(mp4.getResolutions(), LinkPreview$$Lambda$3.$instance);
        }
        if (preview.getRedditVideoPreview() != null) {
            this.redditVideoPreview = new RedditVideo(preview.getRedditVideoPreview());
        }
    }

    public ImageResolution getSource() {
        return this.source;
    }

    public String getSourceUrl() {
        return this.source != null ? this.source.getUrl() : null;
    }

    public ImageResolution getObfuscated() {
        return this.obfuscated;
    }

    public String getObfuscatedUrl() {
        return this.obfuscated != null ? this.obfuscated.getUrl() : null;
    }

    public ImageResolution getGif() {
        return this.gif;
    }

    public String getGifUrl() {
        return this.gif != null ? this.gif.getUrl() : null;
    }

    public ImageResolution getMp4() {
        return this.mp4;
    }

    public String getMp4Url() {
        return this.mp4 != null ? this.mp4.getUrl() : null;
    }

    public List<ImageResolution> getSourceResolutions() {
        return this.sourceResolutions != null ? this.sourceResolutions : new ArrayList();
    }

    public List<ImageResolution> getObfuscatedResolutions() {
        return this.obfuscatedResolutions != null ? this.obfuscatedResolutions : new ArrayList();
    }

    public List<ImageResolution> getGifResolutions() {
        return this.gifResolutions != null ? this.gifResolutions : new ArrayList();
    }

    public List<ImageResolution> getMp4Resolutions() {
        return this.mp4Resolutions != null ? this.mp4Resolutions : new ArrayList();
    }

    public RedditVideo getRedditVideoPreview() {
        return this.redditVideoPreview;
    }

    public void setRedditVideoPreview(RedditVideo redditVideo) {
        this.redditVideoPreview = redditVideo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                LinkPreview linkPreview = (LinkPreview) obj;
                return Objects.m14557a(this.source, linkPreview.source) && Objects.m14557a(this.sourceResolutions, linkPreview.sourceResolutions) && Objects.m14557a(this.obfuscated, linkPreview.obfuscated) && Objects.m14557a(this.obfuscatedResolutions, linkPreview.obfuscatedResolutions) && Objects.m14557a(this.gif, linkPreview.gif) && Objects.m14557a(this.gifResolutions, linkPreview.gifResolutions) && Objects.m14557a(this.mp4, linkPreview.mp4) && Objects.m14557a(this.mp4Resolutions, linkPreview.mp4Resolutions) && Objects.m14557a(this.redditVideoPreview, linkPreview.redditVideoPreview) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.m14556a(this.source, this.sourceResolutions, this.obfuscated, this.obfuscatedResolutions, this.gif, this.gifResolutions, this.mp4, this.mp4Resolutions, this.redditVideoPreview);
    }
}
