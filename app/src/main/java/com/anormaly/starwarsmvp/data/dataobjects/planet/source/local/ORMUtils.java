package com.anormaly.starwarsmvp.data.dataobjects.planet.source.local;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class ORMUtils
{

    public static ArrayList<String> getList(Collection<CustomString> ormString){
        ArrayList<String> result = new ArrayList<>();
        for(CustomString s:ormString){
            result.add(s.text());
        }
        return result;
    }

    public static Collection<CustomString> getStrings(List<String> stringList){
        Collection<CustomString> result = new ArrayList<>();
        for(String s:stringList){
            result.add(new CustomString(s));
        }
        return result;
    }
}
