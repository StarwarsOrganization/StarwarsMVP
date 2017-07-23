package com.anormaly.starwarsmvp.data.retrofit;

import android.content.Context;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static APIError parseError(Response<?> response,Context context) {
        Converter<ResponseBody, APIError> converter =
                new RetrofitHelper(context).getRetrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);
        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}