package com.anormaly.starwarsmvp.data.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ichigo on 21/07/17.
 */

public class DataObjectList<T extends DataObject>
{
    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private List<T> mDataObjects;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<T> get() {
        return mDataObjects;
    }

    public void set(List<T> dataObjects) {
        this.mDataObjects = dataObjects;
    }
}
