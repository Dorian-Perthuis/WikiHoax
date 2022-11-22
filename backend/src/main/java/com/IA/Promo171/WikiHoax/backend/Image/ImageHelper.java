package com.IA.Promo171.WikiHoax.backend.Image;

import com.google.gson.Gson;

public class ImageHelper {
    private static Gson gson = new Gson();
   public static String toJsonConverter(Image img){
       return gson.toJson( img );
   }
}
