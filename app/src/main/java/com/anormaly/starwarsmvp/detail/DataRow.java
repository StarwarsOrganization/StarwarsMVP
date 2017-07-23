package com.anormaly.starwarsmvp.detail;

/**
 * Created by ichigo on 23/07/17.
 */

public class DataRow
{
    private String title;
    private String field;

    public DataRow(){

    }

    public DataRow(String title, String field)
    {
        this.title = title;
        this.field = field;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }
}
