package com.reddit.datalibrary.frontpage.requests.models.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.parceler.Parcel;

@Parcel
public class ListingModel<T extends Identifiable> implements Listing<T> {
    String adDistance;
    String after;
    String before;
    List<T> entities;
    Set<Long> entityIds;
    List<SubmittedVideoLink> videoLinks;

    ListingModel() {
    }

    public ListingModel(List<T> list, String str, String str2, String str3) {
        this.entities = list;
        this.entityIds = new HashSet(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.entityIds.add(Long.valueOf(((Identifiable) list.get(i)).getUniqueID()));
        }
        this.before = str;
        this.after = str2;
        this.adDistance = str3;
    }

    private ListingModel(List<T> list, String str, String str2, String str3, Set<Long> set) {
        this.entities = new ArrayList(list);
        this.before = str;
        this.after = str2;
        this.adDistance = str3;
        this.entityIds = new HashSet(set);
    }

    public void add(Listing<? extends T> listing) {
        if (listing instanceof ListingModel) {
            for (Identifiable identifiable : ((ListingModel) listing).entities) {
                long uniqueID = identifiable.getUniqueID();
                if (!this.entityIds.contains(Long.valueOf(uniqueID))) {
                    this.entities.add(identifiable);
                    this.entityIds.add(Long.valueOf(uniqueID));
                }
            }
            this.after = listing.getAfter();
            this.adDistance = listing.getAdDistance();
            return;
        }
        throw new IllegalArgumentException();
    }

    public Listing<T> copy() {
        return new ListingModel(this.entities, this.before, this.after, this.adDistance, this.entityIds);
    }

    public void remove(int i) {
        this.entityIds.remove(Long.valueOf(((Identifiable) this.entities.remove(i)).getUniqueID()));
    }

    public T get(int i) {
        return (Identifiable) this.entities.get(i);
    }

    public boolean contains(T t) {
        return this.entityIds.contains(Long.valueOf(t.getUniqueID()));
    }

    public List<T> getEntities() {
        return Collections.unmodifiableList(this.entities);
    }

    public boolean isEmpty() {
        return this.entities.isEmpty();
    }

    public int size() {
        return this.entities.size();
    }

    public String getBefore() {
        return this.before;
    }

    public String getAfter() {
        return this.after;
    }

    public String getAdDistance() {
        return this.adDistance;
    }

    public Iterator<T> iterator() {
        return this.entities.iterator();
    }

    public <U extends T> void insert(int i, U u) {
        this.entities.add(i, u);
        this.entityIds.add(Long.valueOf(u.getUniqueID()));
    }

    public void setVideoLinks(List<SubmittedVideoLink> list) {
        this.videoLinks = list;
    }

    public List<SubmittedVideoLink> getVideoLinks() {
        return this.videoLinks;
    }
}
