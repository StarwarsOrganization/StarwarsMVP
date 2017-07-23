package com.anormaly.starwarsmvp.data.retrofit;

import java.io.IOException;

/**
 * Created by ichigo on 12/07/17.
 */

public class NoConnectivityException extends IOException
{
    public NoConnectivityException(String message)
    {
        super(message);
    }
}
