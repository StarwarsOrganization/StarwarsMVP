package com.anormaly.starwarsmvp.data.dataobjects.planet.source.local;


import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.PeopleORM;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ichigo on 12/07/17.
 */
public class CustomString
{

    @DatabaseField(generatedId = true,unique = true)
    private long id;

    @DatabaseField(foreign = true)
    private PlanetORM planetORM;

    @DatabaseField
    private String text;


    public String text()
    {
        return text;
    }


    public CustomString toType(String text)
    {
        return new CustomString(text);
    }

    public CustomString()
    {
    }

    public CustomString(String text)
    {
        this.text = text;
    }


}
